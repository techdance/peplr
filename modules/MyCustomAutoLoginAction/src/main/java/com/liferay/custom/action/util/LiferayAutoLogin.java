package com.liferay.custom.action.util;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.AutoLoginException;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;

@Component(immediate = true)
public class LiferayAutoLogin implements AutoLogin{

	@Override
	public String[] handleException(HttpServletRequest request, HttpServletResponse response, Exception e)
			throws AutoLoginException {
		// TODO Auto-generated method stub
		//System.out.println("==>> AutoLogin > handleException: "+e.getMessage());
		return null;
	}

	@Override
	public String[] login(HttpServletRequest request, HttpServletResponse response) throws AutoLoginException {
		// TODO Auto-generated method stub
		//System.out.println("==================================================================");
		//System.out.println("==>> AutoLogin > login method started.");
		
		boolean allowLogin=false;
		List<String> paramNames = Collections.list(request.getParameterNames());
		String accessToken=null;
		int expirationTime = 0;
		
		String instituteName="", insDepartment="", insCity = "", insState="", insCountry="",insregion="", insTimezone="";
		
		if(paramNames.contains("access_token")){
			accessToken = request.getParameter("access_token")+"";
			System.out.println("accessToken====="+accessToken);
			allowLogin=true;
		}
		System.out.println("allowLogin====="+allowLogin);
		long prefixId = 0;		String jobTitle = "";
		boolean isNewLifeRayUser = false;
		if(allowLogin)
		{
			User user=null;
			long companyId=0;
			JSONObject userJSON=null;
			JSONObject responseJSON = null;
			
			JSONObject institutionProfileJSON=null;
			JSONObject responseJSONInstitute = null;
			try {				
				String apiURL = PropsUtil.get("USER_PROFILE_API_URL")+accessToken;
				//String apiURL = "http://23.99.141.44:3000/getUserDetails?user=NDI4MDE3OTMzNmFwcmluY2VAdG93ZXJlZHRlY2guY29t";
				String userJSONString = getMethodAPI(apiURL); 
				
				responseJSON = JSONFactoryUtil.createJSONObject(userJSONString);
				userJSON = responseJSON.getJSONObject("user");
				
				String institutionProfileResonse = getMethodAPI(PropsUtil.get("INSTITUTION_PROFILE_API_URL")); 
				responseJSONInstitute = JSONFactoryUtil.createJSONObject(institutionProfileResonse);
				institutionProfileJSON = responseJSONInstitute.getJSONObject("data");
				if(institutionProfileJSON!=null){
					instituteName = institutionProfileJSON.getString("institutionName");					
					JSONObject institutionContact = institutionProfileJSON.getJSONObject("institutionContact");
					if(institutionContact!=null){
						insDepartment = institutionContact.getString("department");
					}
					JSONObject instituteProfileContact = institutionProfileJSON.getJSONObject("institutionLocation");
					if(instituteProfileContact!=null){
						insCity = instituteProfileContact.getString("city");
						insState = instituteProfileContact.getString("state");		
						insCountry = instituteProfileContact.getString("country");
						insTimezone = instituteProfileContact.getString("timezone");
						
						/*added newfields for university details*/
						insregion = instituteProfileContact.getString("region");
					}
				}
		        
		        request.getSession().setAttribute("userFirstName", userJSON.getString("firstName"));
		        request.getSession().setAttribute("userLastName", userJSON.getString("lastName"));
		        request.getSession().setAttribute("userEmail", userJSON.getString("institutionEmail"));	
		        request.getSession().setAttribute("userJSON", userJSON);	

		        HttpSession session=request.getSession(); 
		        session.setAttribute("userJSON", userJSON);
		        
		        companyId = PortalUtil.getCompany(request).getCompanyId();
			
		        System.out.println("==>> Company Id: "+companyId);
		        user = UserLocalServiceUtil.getUserByEmailAddress(companyId, userJSON.getString("institutionEmail"));
		        System.out.println("==>> Selected the user record: userId = "+user);		
			} catch (PortalException e) {
				//e.printStackTrace();
				System.out.println("==>> Failed to select the user record: "+e.getMessage());
				
				String prefixValue = userJSON.getString("prefix").trim();
				
				if(userJSON.getString("position").trim()!=null && userJSON.getString("position").trim()!=""){
					jobTitle = userJSON.getString("position").trim();
				}
				
				//String prefixValue = "Mr";
				System.out.println("prefixValue==="+prefixValue);
					try {
						List<ListType> listType=ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.prefix");
						for(ListType l:listType){
							if(l.getName().toLowerCase().equals(prefixValue)){
								prefixId = l.getListTypeId();
							}
						}				
						System.out.println("prefixValue==="+prefixId);
						if(prefixId==0){
							ListType l = ListTypeLocalServiceUtil.addListType(prefixValue, "com.liferay.portal.kernel.model.Contact.prefix");
							prefixId = l.getListTypeId();
						}
						System.out.println("prefixValue==="+prefixId);
						long[] rolesArray = null;
						String roles = userJSON.getString("roles").trim();
						System.out.println("roles==="+roles);
						if(roles.equalsIgnoreCase("ROLE_SUPER_ADMIN")){
							try {
								Role r = RoleLocalServiceUtil.getRole(companyId, "Administrator");
								rolesArray = new long[]{r.getRoleId()};
								System.out.println("Role==="+rolesArray);
							} catch (PortalException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else{
							try {
								Role r = RoleLocalServiceUtil.getRole(companyId, "User");
								rolesArray = new long[]{r.getRoleId()};
								System.out.println("Role==="+rolesArray);
							} catch (PortalException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						System.out.println("roles array==="+rolesArray);
						user = UserLocalServiceUtil.addUser(
						        0, companyId, 
						        true, null, null,
						        false, userJSON.getString("institutionEmail").split("@")[0], 
						        userJSON.getString("institutionEmail"), 
						        0, null, 
						        Locale.US, 
						        userJSON.getString("firstName"), "", userJSON.getString("lastName"),
						        prefixId, 0, true, 
						        1, 1, 1970, 
						        jobTitle, null, 
						        null, rolesArray, null,
						        false, null);
						System.out.println("try===");
						System.out.println("user object=="+user);
						
						user.setPasswordReset(false);
						user.setExpandoBridgeAttributes(new ServiceContext());						
						UserLocalServiceUtil.updateUser(user);
						
						ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(user.getCompanyId(), User.class.getName());
				        ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteName");
				        /*Storing universityURL in custom fields*/
				        ExpandoColumn columnUniversityURL = getOrAddExpandoColumn(table.getTableId(), "universityURL");
						
						//instituteName = userJSON.getString("institutionName");
						String address1 = userJSON.getString("address1");
						String address2 = userJSON.getString("address2");
						String city = userJSON.getString("city");
						String state = userJSON.getString("state");
						String zip = userJSON.getString("zip");
						long typeId = 0;
						
						//Institution Profile
				        
				        ExpandoColumn columnDepartment = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteDepartment");
				        ExpandoColumn columnCity = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteCity");
				        ExpandoColumn columnState = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteState");
				        ExpandoColumn columnCountry = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteCountry");
				        ExpandoColumn columnTimezone = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteTimezone");
				        
						
						ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), column.getName(),user.getUserId(), instituteName);
						ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnDepartment.getName(),user.getUserId(), insDepartment);
						ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnCity.getName(),user.getUserId(), insCity);
						ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnState.getName(),user.getUserId(), insState);
						ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnCountry.getName(),user.getUserId(), insCountry);
						ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnTimezone.getName(),user.getUserId(), insTimezone);
						
						/*Storing universityURL in custom fields*/
						ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), 
								columnUniversityURL.getName(),user.getUserId(), PropsUtil.get("INSTITUTION_PROFILE_API_URL"));
						
						DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ListType.class, PortalClassLoaderUtil.getClassLoader());
						dynamicQuery.add(PropertyFactoryUtil.forName("type").eq("com.liferay.portal.kernel.model.Contact.address")); 
						List<ListType> getTypeId = ListTypeLocalServiceUtil.dynamicQuery(dynamicQuery);
						if(getTypeId.size()>0){
							typeId = getTypeId.get(0).getListTypeId();
						}
						
						
						
						AddressLocalServiceUtil.addAddress(user.getUserId(), Contact.class.getName(), user.getContactId(), address1, address2, "", city, zip, 
								0, 0, typeId, false, true, new ServiceContext());					

						System.out.println("==>> Created the user record: userId = "+user.getUserId()+" Email: "+user.getEmailAddress());
						
						UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), true);
						isNewLifeRayUser = true;						
						
					} catch (PortalException e1) {
						//e1.printStackTrace();
						System.out.println("==>> Failed to create user record: "+e1.getMessage());
					}
        	}
			
			if(user!=null)
			{
				try{
					
					if(userJSON.getString("position").trim()!=null && userJSON.getString("position").trim()!=""){
						jobTitle = userJSON.getString("position").trim();
					}
					
					user.setFirstName(userJSON.getString("firstName"));
					user.setLastName(userJSON.getString("lastName"));
					user.setJobTitle(jobTitle);
					UserLocalServiceUtil.updateUser(user);
					
					//instituteName = userJSON.getString("institutionName");
					ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(user.getCompanyId(), User.class.getName());
			        ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteName");
			        ExpandoValue exvalue = null;
			        exvalue = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), column.getColumnId(), user.getUserId());
			        if(exvalue!=null){
			        	exvalue.setData(instituteName);
			        	ExpandoValueLocalServiceUtil.updateExpandoValue(exvalue);
			        }else{
			        	ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), column.getName(),user.getUserId(), instituteName);
			        }
			       
			       
			        ExpandoColumn columnDepartment = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteDepartment");
			        ExpandoValue expDeptValue = null;
			        expDeptValue = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), columnDepartment.getColumnId(), user.getUserId());
			        if(expDeptValue!=null){
			        	expDeptValue.setData(insDepartment);
			        	ExpandoValueLocalServiceUtil.updateExpandoValue(expDeptValue);
			        }else{
			        	ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnDepartment.getName(),user.getUserId(), insDepartment);
			        }
			        
			        ExpandoColumn columnCity = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteCity");
			        ExpandoValue expCityValue = null;
			        expCityValue = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), columnCity.getColumnId(), user.getUserId());
			        if(expCityValue!=null){
			        	expCityValue.setData(insCity);
			        	ExpandoValueLocalServiceUtil.updateExpandoValue(expCityValue);
			        }else{
			        	ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnCity.getName(),user.getUserId(), insCity);
			        }
			        
			        ExpandoColumn columnState = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteState");
			        ExpandoValue expStateValue = null;
			        expStateValue = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), columnState.getColumnId(), user.getUserId());
			        if(expStateValue!=null){
			        	expStateValue.setData(insState);
			        	ExpandoValueLocalServiceUtil.updateExpandoValue(expStateValue);
			        }else{
			        	ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnState.getName(),user.getUserId(), insState);
			        }
			        
			        ExpandoColumn columnCountry = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteCountry");
			        ExpandoValue expCountryValue = null;
			        expCountryValue = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), columnCountry.getColumnId(), user.getUserId());
			        if(expCountryValue!=null){
			        	expCountryValue.setData(insCountry);
			        	ExpandoValueLocalServiceUtil.updateExpandoValue(expCountryValue);
			        }else{
			        	ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnCountry.getName(),user.getUserId(), insCountry);
			        }
			        
			        
			        ExpandoColumn columnTimezone = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "instituteTimezone");
			        ExpandoValue expTimezoneValue = null;
			        expCountryValue = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), columnTimezone.getColumnId(), user.getUserId());
			        if(expTimezoneValue!=null){
			        	expTimezoneValue.setData(insTimezone);
			        	ExpandoValueLocalServiceUtil.updateExpandoValue(expTimezoneValue);
			        }else{
			        	ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnTimezone.getName(),user.getUserId(), insTimezone);
			        }
			        
			        /*Storing universityURL in custom fields*/
			        ExpandoColumn columnuniversityURL = getOrAddExpandoColumn(table.getTableId(), "universityURL");
			        ExpandoValue expUniversityURLVal = null;
			        expUniversityURLVal = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), columnuniversityURL.getColumnId(), user.getUserId());
			        if(expUniversityURLVal!=null){
			        	expUniversityURLVal.setData(PropsUtil.get("INSTITUTION_PROFILE_API_URL"));
			        	ExpandoValueLocalServiceUtil.updateExpandoValue(expUniversityURLVal);
			        }else{
			        	ExpandoValueLocalServiceUtil.addValue(user.getCompanyId(), User.class.getName(), table.getName(), columnuniversityURL.getName(),user.getUserId(), PropsUtil.get("INSTITUTION_PROFILE_API_URL"));
			        }
			        
					List<ListType> listType=ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.prefix");
					for(ListType l:listType){
						if(l.getName().toLowerCase().equals(userJSON.getString("prefix").trim())){
							prefixId = l.getListTypeId();
						}
					}				
					if(prefixId!=0){
						Contact contact = ContactLocalServiceUtil.getContact(user.getContactId());
						contact.setPrefixId(prefixId);
						ContactLocalServiceUtil.updateContact(contact);
					}
					
				}catch(Exception e){
					
				}
				
				System.out.println("==>> Redirecting to Login page with success Loign!");
				request.setAttribute(AUTO_LOGIN_REDIRECT_AND_CONTINUE, "/web/guest/home1?sso=true&user="+accessToken);
				
				
				String[] credentials = new String[3];
		        credentials[0] = String.valueOf(user.getUserId());
		        credentials[1] = String.valueOf(user.getUserId());
		        credentials[2] = Boolean.FALSE.toString();
		        return credentials;	
			}
			
		}
		
		return null;
	}
	
	public String getMethodAPI(String apiURL) {
		String returnData ="";
		ResponseEntity<String> returnObject= null;		
		try {
			RestTemplate restTemplate = new RestTemplate();
			returnObject=restTemplate.getForEntity(apiURL,String.class);
			if(returnObject!=null){
				returnData = returnObject.getBody();
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return returnData;
	}
	
	
	public ExpandoColumn getOrAddExpandoColumn(long tableId, String columnName) {
	    ExpandoColumn exandoColumn = ExpandoColumnLocalServiceUtil.getColumn(tableId, columnName);
	        if (exandoColumn == null) {
	            try {
					exandoColumn = ExpandoColumnLocalServiceUtil.addColumn(tableId, columnName,
					        ExpandoColumnConstants.STRING, StringPool.BLANK);
				} catch (PortalException e) {
					e.printStackTrace();
				}
	        }
	 
	    return exandoColumn;
	}
}
