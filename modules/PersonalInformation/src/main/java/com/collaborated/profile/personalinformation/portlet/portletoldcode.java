package com.collaborated.profile.personalinformation.portlet;

import com.collaborated.entity.model.communicationPreferences;
import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.model.userCredential;
import com.collaborated.entity.model.userInstitutionProfileDetails;
import com.collaborated.entity.model.userProfessionalBio;
import com.collaborated.entity.service.communicationPreferencesLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil;
import com.collaborated.entity.service.projectInviteTrackingLocalServiceUtil;
import com.collaborated.entity.service.userCredentialLocalServiceUtil;
import com.collaborated.entity.service.userProfessionalBioLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PersonalInformation Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class portletoldcode extends MVCPortlet {
	
	/*public static long selectedProfileMatching = 0;*/
	public static String firstName = "";
	public static String lastName = "";
	public static String position = "";
	public static String institution = "AHEA University";
	public static String department = "Test";
	public static String primaryLanguage = "";
	public static String email = "";
	public static String discipline = "";
	public static String bio = "";
	public static String highestEducation = "";
	public String userToken = "";
	
	/*@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		ThemeDisplay themeDisplayProfile = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<communicationPreferences> communicationPreferences = null;
		List<userProfessionalBio> userProfessionalBio = null;
		List<userCredential> userCredential = null;
		JSONObject userJSON=null;
		JSONObject responseJSON = null;
		
		PortletSession ps = request.getPortletSession();
		Object obj = ps.getAttribute("MATCHING_KEY", PortletSession.APPLICATION_SCOPE);
		
		String currentURL = themeDisplayProfile.getURLCurrent();
		int i = currentURL.indexOf("?");
		System.out.println("currentURL==="+currentURL);
		System.out.println("i==="+i);
	    if (i > -1) {
	       String searchURL = currentURL.substring(currentURL.indexOf("?") + 1);
	       System.out.println("Search URL: " + searchURL);
	       String params[] = searchURL.split("&");
	       for (String param : params) {
	           String temp[] = param.split("=");
	           userToken = temp[1];
	           String apiURL = "http://23.99.141.44:3000/getUserDetails?user="+userToken;
	           String userJSONString = getMethodAPI(apiURL); 
			   try {
				   responseJSON = JSONFactoryUtil.createJSONObject(userJSONString);
				   userJSON = responseJSON.getJSONObject("user");
				   ps.setAttribute("USER_PROFILE", userJSON, PortletSession.APPLICATION_SCOPE);
				   ps.setAttribute("USER_TOKEN", userToken, PortletSession.APPLICATION_SCOPE);
			   } catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			   }
		       }
	    }
		
		System.out.println("userJSON==="+userJSON);
		if(userJSON!=null){
			firstName = userJSON.getString("firstName");
			lastName = userJSON.getString("lastName");
			if(userJSON.getString("position").trim()!=null && userJSON.getString("position").trim()!=""){
				position = userJSON.getString("position");
			}
			
		}
		
		DynamicQuery dynamicQueryPreferences = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQueryPreferences.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplayProfile.getUserId())));
		communicationPreferences = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQueryPreferences);
		if(communicationPreferences.size()>0){
			primaryLanguage = communicationPreferences.get(0).getPrimaryLanguageName();
			email = communicationPreferences.get(0).getEmailAddress();
			
		}
		
		DynamicQuery dynamicQueryBio = DynamicQueryFactoryUtil.forClass(userProfessionalBio.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQueryBio.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplayProfile.getUserId())));
		userProfessionalBio = userProfessionalBioLocalServiceUtil.dynamicQuery(dynamicQueryBio);
		if(userProfessionalBio.size()>0){
			discipline = userProfessionalBio.get(0).getBioDiscipline();
			bio = userProfessionalBio.get(0).getBiodescription();
			
		}
		
		DynamicQuery dynamicQueryCredential = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQueryCredential.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplayProfile.getUserId())));
		userCredential = userCredentialLocalServiceUtil.dynamicQuery(dynamicQueryCredential);
		if(userCredential.size()>0){
			highestEducation = userCredential.get(0).getMembership4();
			
		}
		if (obj == null) {
			System.out.println("PortletSession attribute NOT found");
		} else {
			selectedProfileMatching = Long.valueOf(obj.toString());
			System.out.println("PortletSession attribute found"+selectedProfileMatching);
		}
		super.render(request, response);
	}*/
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("getProfileData")){
			getProfileInfo(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getViewMoreDataInvite")){
			getViewMoreDataInvite(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("sendInvite")) {
			sendInvite(resourceRequest,resourceResponse);
		}
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
	
	public void getProfileInfo(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		User user = null;
		String prefixValue = "";
		PrintWriter out = null;
		JSONObject jsonObject = null;
		String profileStatus = "";
		String isEdit = "Yes";
		boolean isAlreadySent = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long interestId = ParamUtil.getLong(resourceRequest, "interestId");
		try{
			out = resourceResponse.getWriter();
			long userId = 0;
			long selectedProfileMatching = 0;
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionuserID = (String)httpsession.getAttribute("MATCHING_KEY");
			long currentUser = (Long)httpsession.getAttribute("currentUser");	
			if(currentUser==themeDisplay.getUserId()){
				selectedProfileMatching = new Long(sessionuserID);	
			}
			/*PortletSession ps = resourceRequest.getPortletSession();
			selectedProfileMatching = (long)ps.getAttribute("MATCHING_KEY", PortletSession.APPLICATION_SCOPE);
			System.out.println("selectedProfileMatching==="+selectedProfileMatching);*/
			System.out.println("selectedProfileMatching==="+selectedProfileMatching);
			if(selectedProfileMatching>0){
				userId = selectedProfileMatching;
				isEdit = "No";
			}else{
				userId = themeDisplay.getUserId();
			}
			System.out.println("user id==="+userId);			
			user = UserLocalServiceUtil.getUser(userId);
			profileStatus = (String) user.getExpandoBridge().getAttribute("status");
			String[] onlineStatus = (String[]) user.getExpandoBridge().getAttribute("onlineStatus");
			
			if(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId()!=0){
				ListType listType = ListTypeServiceUtil.getListType(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId());
				prefixValue = listType.getName();
			}
			
			if(interestId!=0){
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(interestId));
				List<projectInviteTracking> projectInviteTrackingList = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(projectInviteTrackingList.size()>0){
					 isAlreadySent = true;
				}
			}
			
			JSONObject userJSON=null;
			JSONObject responseJSON = null;
			PortletSession ps = resourceRequest.getPortletSession();
			String currentURL = themeDisplay.getURLCurrent();
			int i = currentURL.indexOf("?");
			System.out.println("currentURL==="+currentURL);
			System.out.println("i==="+i);
		    if (i > -1) {
		       String searchURL = currentURL.substring(currentURL.indexOf("?") + 1);
		       System.out.println("Search URL: " + searchURL);
		       String params[] = searchURL.split("&");
		       for (String param : params) {
		           String temp[] = param.split("=");
		           userToken = temp[1];
		           String apiURL = "http://23.99.141.44:3000/getUserDetails?user="+userToken;
		           String userJSONString = getMethodAPI(apiURL); 
				   try {
					   responseJSON = JSONFactoryUtil.createJSONObject(userJSONString);
					   userJSON = responseJSON.getJSONObject("user");
					   ps.setAttribute("USER_PROFILE", userJSON, PortletSession.APPLICATION_SCOPE);
					   ps.setAttribute("USER_TOKEN", userToken, PortletSession.APPLICATION_SCOPE);
				   } catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				   }
			       }
		    }
			
			System.out.println("userJSON==="+userJSON);
			if(userJSON!=null){
				firstName = userJSON.getString("firstName");
				lastName = userJSON.getString("lastName");
				if(userJSON.getString("position").trim()!=null && userJSON.getString("position").trim()!=""){
					position = userJSON.getString("position");
				}
				
			}
			
			if(selectedProfileMatching>0){
				firstName = user.getFullName();
				position = user.getJobTitle();
			}else{
				UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				firstName = user.getFullName();
				lastName = user.getLastName();
				position = user.getJobTitle();
			}
			
			List<communicationPreferences> communicationPreferences = null;
			List<userProfessionalBio> userProfessionalBio = null;
			List<userCredential> userCredential = null;
			DynamicQuery dynamicQueryPreferences = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryPreferences.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(user.getUserId())));
			communicationPreferences = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQueryPreferences);
			if(communicationPreferences.size()>0){
				primaryLanguage = communicationPreferences.get(0).getPrimaryLanguageName();
				email = communicationPreferences.get(0).getEmailAddress();
				
			}
			
			DynamicQuery dynamicQueryBio = DynamicQueryFactoryUtil.forClass(userProfessionalBio.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryBio.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(user.getUserId())));
			userProfessionalBio = userProfessionalBioLocalServiceUtil.dynamicQuery(dynamicQueryBio);
			if(userProfessionalBio.size()>0){
				discipline = userProfessionalBio.get(0).getBioDiscipline();
				bio = userProfessionalBio.get(0).getBiodescription();
				
			}
			
			DynamicQuery dynamicQueryCredential = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryCredential.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(user.getUserId())));
			userCredential = userCredentialLocalServiceUtil.dynamicQuery(dynamicQueryCredential);
			if(userCredential.size()>0){
				highestEducation = userCredential.get(0).getMembership4();
				
			}

			long percentage = 0;
			if(user.getPortraitId()!=0){
				percentage = percentage + 10;
			}if(firstName!="" && lastName!=""){
				percentage = percentage + 20;
			}if(primaryLanguage!=""){
				percentage = percentage + 10;
			}if(email!=""){
				percentage = percentage + 10;
			}if(discipline!=""){
				percentage = percentage + 10;
			}if(bio!=""){
				percentage = percentage + 10;
			}if(highestEducation!=""){
				percentage = percentage + 10;
			}if(institution!=""){
				percentage = percentage + 10;
			}if(department!=""){
				percentage = percentage + 10;
			}
			System.out.println("percentage=="+percentage);
			System.out.println("user.getPortraitURL(themeDisplay)=="+user.getPortraitURL(themeDisplay));
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("prefixValue", prefixValue);
			jsonObject.put("fullName", firstName);
			jsonObject.put("jobTitle", position);
			jsonObject.put("profileImage", user.getPortraitURL(themeDisplay));
			jsonObject.put("profileStatus", profileStatus);
			jsonObject.put("onlineStatus", onlineStatus);
			jsonObject.put("isEdit", isEdit);
			jsonObject.put("isAlreadySent", isAlreadySent);
			jsonObject.put("profilePercentage", percentage);
			out.print(jsonObject);
		}catch(Exception e){
			
		}finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void getViewMoreDataInvite(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject jsonObject = null;
		PrintWriter out = null;
		profileAreaofinterest singleData = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String intercampus = "";
		long key = ParamUtil.getLong(resourceRequest, "key");
		String template = "";
		User user = null;
		String prefixValue = "";
		String profileStatus = "";
		try{
			out = resourceResponse.getWriter();
			jsonObject = JSONFactoryUtil.createJSONObject();
			long userId = themeDisplay.getUserId();
			long selectedProfileMatching = 0;
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionuserID = (String)httpsession.getAttribute("MATCHING_KEY");
			long currentUser = (Long)httpsession.getAttribute("currentUser");	
			if(currentUser==themeDisplay.getUserId()){
				selectedProfileMatching = new Long(sessionuserID);	
			}
			
			if(selectedProfileMatching>0){
				userId = selectedProfileMatching;
			}
						
			user = UserLocalServiceUtil.getUser(userId);
			profileStatus = (String) user.getExpandoBridge().getAttribute("status");
			String[] onlineStatus = (String[]) user.getExpandoBridge().getAttribute("onlineStatus");
			
			if(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId()!=0){
				ListType listType = ListTypeServiceUtil.getListType(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId());
				prefixValue = listType.getName();
			}
			
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(user.getCompanyId(),User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
			 ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(user.getCompanyId(),User.class.getName(), table.getName(), "instituteName" );
			 String instituteName =  ExpandoValueLocalServiceUtil.getData(user.getCompanyId(),User.class.getName(), table.getName(), column.getName(), user.getUserId(), StringPool.BLANK);
			
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("prefixValue", prefixValue);
			jsonObject.put("fullName", user.getFullName());
			jsonObject.put("jobTitle", user.getJobTitle());
			jsonObject.put("profileImage", user.getPortraitURL(themeDisplay));
			jsonObject.put("instituteName",instituteName);
			
			singleData = profileAreaofinterestLocalServiceUtil.fetchprofileAreaofinterest(key);
			if(singleData!=null){
				if(singleData.getCampus().equalsIgnoreCase("1")){
					intercampus = "Intracampus";
				}else if(singleData.getCampus().equalsIgnoreCase("2")){
					intercampus = "Intercampus";
				}
				
				jsonObject.put("projectType", singleData.getProjectType());
				jsonObject.put("deliveryMethod", singleData.getDeliveryMethod());
				jsonObject.put("discipline1", singleData.getDiscipline1());
				jsonObject.put("discipline2", singleData.getDiscipline2());
				jsonObject.put("discipline3", singleData.getDiscipline3());
				jsonObject.put("description", singleData.getDescription());
				jsonObject.put("collaborationType", singleData.getCollaborationType());
				jsonObject.put("campus", intercampus);
				jsonObject.put("programLevel", singleData.getProgramLevel());
				jsonObject.put("programLength", singleData.getProgramLength());
				jsonObject.put("credits", singleData.getCredits());
				jsonObject.put("language", singleData.getLanguage());
				jsonObject.put("region1", singleData.getLocation1());
				jsonObject.put("region2", singleData.getLocation2());
				jsonObject.put("region3", singleData.getLocation3());
				jsonObject.put("region4", singleData.getLocation4());
				jsonObject.put("startMonth", singleData.getRangerMonthStart());
				jsonObject.put("endMonth", singleData.getRangerMonthEnd());
				jsonObject.put("startYear", singleData.getRangerYearStart());
				jsonObject.put("endYear", singleData.getRangerYearEnd());
				jsonObject.put("PK_areaofinterest", singleData.getPK_areaofinterest());
				/*template = "<div class=\"modal modalToltip \" id=\"popup"+key+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modalLabel\" aria-hidden=\"true\">"*/
				template =  " <div class='modal-dialog'> " +
							" <div class='modal-content'> " +
							" <div class='modal-header'> " +
							" <div class='font15 m-auto d-flex flex-column'><strong>Project</strong><span>"+singleData.getProjectType()+"</span></div> " +
							" <div class='toltip-close3'><a href='javascript:void(0);' data-dismiss='modal'><i class='fa fa-times-circle'></i></a></div> " +
							" </div> " +
							" <div class='modal-body'> " +
							" <div class='interest-modal'> "+
							" <div class='view-more-interest-modal-inner'> "+
							" <div class='view-more-interest-modal-inner-content'> "+
							" <div class='row mb-2'> <div class='col-md-12 d-flex flex-column'> "+
							" <strong>Descripcion</strong> "+
							" <span id='description'>"+ singleData.getDescription() +"</span> "+
							" </div> </div> <div class='row  mb-2'> <div class='col-md-6 d-flex flex-column'> "+
							" <strong>Discipline</strong> "+
							" <span id='discipline'>"+singleData.getDiscipline1()+"</span> "+
							" </div> <div class='col-md-6 d-flex flex-column'> "+
							" <strong>Delivery Method</strong> "+
							" <span id='deliveryMethod'>"+ singleData.getDeliveryMethod() +"</span> "+
							" </div></div><div class='row mb-2'><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Collaboration Type</strong> "+
							" <span id='collaborationType'>"+ singleData.getProjectType() +"</span> "+
							" </div><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Region</strong> "+
							" <span id='region'>"+ singleData.getLocation1() +"</span> "+
							" </div><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Program Length</strong> "+
							" <span id='programLength'>"+ singleData.getProgramLength() +"</span> "+
							" </div></div><div class='row mb-2'><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Preferred Language</strong> "+
							" <span id='preferredLanguage'>"+ singleData.getLanguage() +"</span> "+
							" </div><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Credits</strong> "+
							" <span id='credits'>"+ singleData.getCredits() +"</span> "+
							" </div><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Program Level</strong> "+
							" <span id='programLevel'>"+ singleData.getProgramLevel() +"</span> "+
							" </div></div><div class='row mb-2'><div class='col-md-12'>	 "+
							" <strong>Project Date Range</strong> "+
							" </div></div></div></div></div> "+
							" </div> " +
							" </div> " +
							" </div>";
			}
			out.print(jsonObject);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void sendInvite(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long interestId = ParamUtil.getLong(resourceRequest, "interestId");
		profileAreaofinterest profileAreaofinterest = null;
		long inviteFrom = themeDisplay.getUserId();
		long inviteTo = 0;String inviteToName = "";String projectName = "";
		projectInviteTracking projectInviteTracking = null;
		PrintWriter out = null;
		boolean isAlreadySent = false;
		JSONObject jsonObject = null;
		try{
			out = resourceResponse.getWriter();
			
			long selectedProfileMatching = 0;
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionuserID = (String)httpsession.getAttribute("MATCHING_KEY");
			long currentUser = (Long)httpsession.getAttribute("currentUser");	
			if(currentUser==themeDisplay.getUserId()){
				selectedProfileMatching = new Long(sessionuserID);	
			}
			
			jsonObject = JSONFactoryUtil.createJSONObject();
			if(interestId!=0){
				profileAreaofinterest = profileAreaofinterestLocalServiceUtil.getprofileAreaofinterest(interestId);
				if(profileAreaofinterest!=null){
					inviteTo = profileAreaofinterest.getUserId();
					inviteToName = UserLocalServiceUtil.getUser(themeDisplay.getUserId()).getFullName();
				}
			}
			if(inviteTo!=0){
				projectInviteTracking = projectInviteTrackingLocalServiceUtil.createprojectInviteTracking(CounterLocalServiceUtil.increment());
				projectInviteTracking.setProjectId(interestId);
				projectInviteTracking.setInviteFrom(inviteFrom);
				projectInviteTracking.setInviteTo(selectedProfileMatching);
				projectInviteTracking.setInvitationStatus("Pending");
				projectInviteTracking.setIsRead(1);
				projectInviteTracking.setIsRemoved(3);
				projectInviteTracking.setMessageContent(inviteToName+" has sent you an invitation");
				projectInviteTracking.setCreateDate(new Date());
				projectInviteTrackingLocalServiceUtil.addprojectInviteTracking(projectInviteTracking);
				
				labScreenProjectPartners labScreenProjectPartners = labScreenProjectPartnersLocalServiceUtil.createlabScreenProjectPartners(CounterLocalServiceUtil.increment());
				labScreenProjectPartners.setPK_projectId(interestId);
				labScreenProjectPartners.setProjectPartnerId(selectedProfileMatching);
				labScreenProjectPartners.setIsActive(1);
				labScreenProjectPartners.setUserId(themeDisplay.getUserId());
				labScreenProjectPartners.setCreateDate(new Date());
				labScreenProjectPartnersLocalServiceUtil.addlabScreenProjectPartners(labScreenProjectPartners);
				
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(interestId));
				List<projectInviteTracking> projectInviteTrackingList = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(projectInviteTrackingList.size()>0){
					 isAlreadySent = true;
				}
				jsonObject.put("isAlreadySent", isAlreadySent);
				jsonObject.put("message", "sent");
				out.print(jsonObject);
			}
		}catch(Exception e){}
		finally{
			
		}
	}
}