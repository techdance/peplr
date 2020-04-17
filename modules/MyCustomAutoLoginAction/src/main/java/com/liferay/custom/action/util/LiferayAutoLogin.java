package com.liferay.custom.action.util;

import java.io.IOException;
import java.time.Instant;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.AutoLoginException;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(immediate = true)
public class LiferayAutoLogin implements AutoLogin{

	@Override
	public String[] handleException(HttpServletRequest request, HttpServletResponse response, Exception e)
			throws AutoLoginException {
		// TODO Auto-generated method stub
		System.out.println("==>> AutoLogin > handleException: "+e.getMessage());
		return null;
	}

	@Override
	public String[] login(HttpServletRequest request, HttpServletResponse response) throws AutoLoginException {
		// TODO Auto-generated method stub
		System.out.println("==================================================================");
		System.out.println("==>> AutoLogin > login method started.");
		
		boolean allowLogin=false;
		List<String> paramNames = Collections.list(request.getParameterNames());
		String accessToken=null;
		int expirationTime = 0;
		
		if(paramNames.contains("access_token")){
			accessToken = request.getParameter("access_token")+"";
			System.out.println("accessToken====="+accessToken);
			allowLogin=true;
		}
				
		boolean isNewLifeRayUser = false;
		if(allowLogin)
		{
			User user=null;
			long companyId=0;
			JSONObject userJSON=null;
			JSONObject responseJSON = null;
			try {				
				String apiURL = "http://23.99.141.44:3000/getUserDetails?user="+accessToken;
				String userJSONString = getMethodAPI(apiURL); 
				responseJSON = JSONFactoryUtil.createJSONObject(userJSONString);
				userJSON = responseJSON.getJSONObject("user");
				int responseCode = 0;
		        		
		        System.out.println("***************************************************userJSON--->"+userJSON);
		        System.out.println("------------------------------ Graph API Call ------------------------------");
		        System.out.println("API Endpoint:   "+"https://graph.microsoft.com/v1.0/me");
		        System.out.println("Autorization:   "+"Bearer "+accessToken);
		        System.out.println("Request Method: GET");
		        System.out.println("Response Code:  "+responseCode);
		        System.out.println("Response JSON:  "+ userJSONString);
		        System.out.println("Response JSON:  "+ userJSON.getString("institutionEmail"));
		        System.out.println("----------------------------------------------------------------------------");
		        
		        request.setAttribute("userName", userJSON.getString("firstName")+userJSON.getString("lastName"));
		        request.setAttribute("userEmail", userJSON.getString("institutionEmail"));		        
		
		        companyId = PortalUtil.getCompany(request).getCompanyId();
			
		        System.out.println("==>> Company Id: "+companyId);
		        user = UserLocalServiceUtil.getUserByEmailAddress(companyId, userJSON.getString("institutionEmail"));
		        System.out.println("==>> Selected the user record: userId = "+user);		
			} catch (PortalException e) {
				//e.printStackTrace();
				System.out.println("==>> Failed to select the user record: "+e.getMessage());
				long prefixId = 0;
				String prefixValue = userJSON.getString("prefix").trim();
				//String prefixValue = "Mr";
				System.out.println("prefixValue==="+prefixValue);
					try {
						List<ListType> listType=ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.prefix");
						for(ListType l:listType){
							if(l.getName().toLowerCase().equals(prefixValue)){
								prefixId = l.getListTypeId();
							}
						}				
						if(prefixId==0){
							ListType l = ListTypeLocalServiceUtil.addListType(prefixValue, "com.liferay.portal.kernel.model.Contact.prefix");
							prefixId = l.getListTypeId();
						}
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
						        "", null, 
						        null, null, null,
						        false, null);
						System.out.println("try===");
						System.out.println("user object=="+user);
						
						user.setPasswordReset(false);
						user.setExpandoBridgeAttributes(new ServiceContext());
						UserLocalServiceUtil.updateUser(user);
						
						System.out.println("==>> Created the user record: userId = "+user.getUserId()+" Email: "+user.getEmailAddress());
						
						System.out.println("==>> Created the user record: userId = "+user.getUserId()+" Email: "+user.getEmailAddress());
						
						UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), true);
						isNewLifeRayUser = true;
						System.out.println("==>> Disabled password reset screen for the user "+user.getEmailAddress());
						
					} catch (PortalException e1) {
						//e1.printStackTrace();
						System.out.println("==>> Failed to create user record: "+e1.getMessage());
					}
        	}
			
			if(user!=null)
			{
				
				System.out.println("==>> Redirecting to Login page with success Loign!");
				//request.setAttribute(AUTO_LOGIN_REDIRECT_AND_CONTINUE, "/group/hgscap/dashboard?sso=true");
				request.setAttribute(AUTO_LOGIN_REDIRECT_AND_CONTINUE, "/web/guest/profile?sso=true");
				
				
				String[] credentials = new String[3];
		        credentials[0] = String.valueOf(user.getUserId());
		        credentials[1] = String.valueOf(user.getUserId());
		        credentials[2] = Boolean.FALSE.toString();
		        return credentials;	
			}
			
		}
		
		System.out.println("==================================================================");
		
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
}