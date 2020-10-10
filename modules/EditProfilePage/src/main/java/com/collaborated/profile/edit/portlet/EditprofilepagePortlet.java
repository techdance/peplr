package com.collaborated.profile.edit.portlet;

import com.collaborated.entity.model.communicationPreferences;
import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.model.userCredential;
import com.collaborated.entity.model.userInstitutionProfileDetails;
import com.collaborated.entity.model.userInstitutionProfileSubDetails;
import com.collaborated.entity.model.userProfessionalBio;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.communicationPreferencesLocalServiceUtil;
import com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil;
import com.collaborated.entity.service.userCredentialLocalServiceUtil;
import com.collaborated.entity.service.userInstitutionProfileDetailsLocalServiceUtil;
import com.collaborated.entity.service.userInstitutionProfileSubDetailsLocalServiceUtil;
import com.collaborated.entity.service.userProfessionalBioLocalServiceUtil;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.exception.DuplicateFileException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EditProfilePage Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EditprofilepagePortlet extends MVCPortlet {

	
	final Log LOG = LogFactoryUtil.getLog(EditprofilepagePortlet.class);
	JSONObject data=null;
	JSONObject responseJSONInstitute = null;
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		JSONArray listArray = getLanguageList();
		renderRequest.setAttribute("languageList", listArray);
		PortletSession ps = renderRequest.getPortletSession();
		//userJSON = (JSONObject)ps.getAttribute("USER_PROFILE", PortletSession.APPLICATION_SCOPE);
		//ps.getAttribute("MATCHING_KEY", PortletSession.APPLICATION_SCOPE);
		
		String apiURL = PropsUtil.get("INSTITUTION_PROFILE_API_URL");
        String institutionProfileResonse = getMethodAPI(apiURL); 
	    try {
	    	responseJSONInstitute = JSONFactoryUtil.createJSONObject(institutionProfileResonse);
		    data = responseJSONInstitute.getJSONObject("data");
		    ps.setAttribute("INSTITUTE_PROFILE", data, PortletSession.APPLICATION_SCOPE);
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
		
		super.doView(renderRequest, renderResponse); // make sure this is the last line in your method
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if (resourceID != null && resourceID.equals("updateProfile")) {
			updateProfile(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getProfileData")){
			getProfileInfo(resourceRequest,resourceResponse);
		}else if(resourceID !=null && resourceID.equals("removeProfileImage")){
			removeProfileImage(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("saveCredentialsForm")) {
			saveCredentialsForm(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getCredentialData")){
			getCredentialData(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("savecommunicationForm")) {
			saveCommunicationPreferences(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getCollaborationInterest")){
			getCollaborationInterest(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getViewMoreData")){
			getViewMoreData(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("goToMatchingScreen")){
			goToMatchingScreen(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("saveProfileForm")){
			saveProfileForm(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getCommunicationData")){
			getCommunicationPreferencesData(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("saveCollaborationInterest")) {
			saveCollaborationInterest(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("getProfessionalBio")) {
			getProfessionalBio(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getInstituteProfile")){
			getInstituteProfile(resourceRequest,resourceResponse);
		}else if(resourceID !=null && resourceID.equals("removeCollaborationInterest")){
			removeCollaborationInterest(resourceRequest,resourceResponse);
		}else if(resourceID !=null && resourceID.equals("updateAreaofinterest")){
			updateAreaofinterest(resourceRequest,resourceResponse);
		}else if(resourceID !=null && resourceID.equals("Test")){
			saveProfileFormTest(resourceRequest,resourceResponse);
		}
	}
	
	public void saveProfileFormTest(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
		System.out.println("Save profile button hit");
		saveProfileForm(resourceRequest,resourceResponse);
	}
	
	public void updateAreaofinterest(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		
		//Add interest
		long updateInterestId = ParamUtil.getLong(resourceRequest, "updateInterestId");
		String projectType = ParamUtil.getString(resourceRequest, "projectTypeEdit");
		String projectDescription = ParamUtil.getString(resourceRequest, "projectDescriptionEdit");
		/*String[] disciplineInput = ParamUtil.getParameterValues(resourceRequest, "disciplineEdit");
		StringBuilder disciplines = new StringBuilder();
		for(String loc : disciplineInput){
			disciplines.append(loc);
			disciplines.append(",");
		}
		String discipline = disciplines.toString();
		String[] locationInput = ParamUtil.getParameterValues(resourceRequest, "locationEdit");
		StringBuilder locations = new StringBuilder();
		for(String loc : locationInput){
			locations.append(loc);
			locations.append(",");
		}
		String location = locations.toString();*/
		//String intracampus = ParamUtil.getString(resourceRequest, "intracampus");		
		String preferredLanguage = ParamUtil.getString(resourceRequest, "preferredLanguageEdit");
		String programLevel = ParamUtil.getString(resourceRequest, "programLevelEdit");
		String programLength = ParamUtil.getString(resourceRequest, "programLengthEdit");
		String deliveryMethod = ParamUtil.getString(resourceRequest, "deliveryMethodEdit");
		String credits = ParamUtil.getString(resourceRequest, "creditsEdit");
	//	String addInterestButton = ParamUtil.getString(resourceRequest, "addInterestButton");
		String collaborationType = ParamUtil.getString(resourceRequest, "collaborationTypeEdit");
		String discipline1 = ParamUtil.getString(resourceRequest, "disciplineEdit1");
		String discipline2 = ParamUtil.getString(resourceRequest, "disciplineEdit2");
		String discipline3 = ParamUtil.getString(resourceRequest, "disciplineEdit3");
		String location1 = ParamUtil.getString(resourceRequest, "locationEdit1");
		String location2 = ParamUtil.getString(resourceRequest, "locationEdit2");
		String location3 = ParamUtil.getString(resourceRequest, "locationEdit3");
		String location4 = ParamUtil.getString(resourceRequest, "locationEdit4");
		String endMonthRangeEdit = ParamUtil.getString(resourceRequest, "endMonthRangeEdit");
		int endYearRangeEdit = ParamUtil.getInteger(resourceRequest, "endYearRangeEdit");
		String startMonthRange = ParamUtil.getString(resourceRequest, "startMonthRange");
		int startYearRange = ParamUtil.getInteger(resourceRequest, "startYearRange");
		PrintWriter out = null;		
		try{
			profileAreaofinterest profileAreaofinterest = profileAreaofinterestLocalServiceUtil.getprofileAreaofinterest(updateInterestId);
			profileAreaofinterest.setUserId(themeDisplay.getUserId());
			profileAreaofinterest.setCreateDate(new Date());
			profileAreaofinterest.setGroupId(themeDisplay.getScopeGroupId());
			profileAreaofinterest.setProjectType(projectType);
			profileAreaofinterest.setDescription(projectDescription);
			profileAreaofinterest.setDiscipline1(discipline1);	
			profileAreaofinterest.setLocation1(location1);
			profileAreaofinterest.setDiscipline2(discipline2);	
			profileAreaofinterest.setLocation2(location2);
			profileAreaofinterest.setDiscipline3(discipline3);	
			profileAreaofinterest.setLocation3(location3);	
			profileAreaofinterest.setLocation4(location4);
			profileAreaofinterest.setRangerMonthEnd(endMonthRangeEdit);
			profileAreaofinterest.setRangerMonthStart(startMonthRange);
			profileAreaofinterest.setRangerYearEnd(endYearRangeEdit);
			profileAreaofinterest.setRangerYearStart(startYearRange);
			//profileAreaofinterest.setDiscipline(discipline.substring(0,discipline.length()-1));
			profileAreaofinterest.setLanguage(preferredLanguage);
			//profileAreaofinterest.setLocation(location.substring(0,location.length()-1));
			//profileAreaofinterest.setCampus(intracampus);
			profileAreaofinterest.setCollaborationType(collaborationType);
			
			if(projectType.equalsIgnoreCase("Course Development") || projectType.equalsIgnoreCase("Curriculum Development")){
				profileAreaofinterest.setProgramLevel(programLevel);
				profileAreaofinterest.setProgramLength(programLength);
				profileAreaofinterest.setDeliveryMethod(deliveryMethod);
				profileAreaofinterest.setCredits(credits);
			}
			profileAreaofinterestLocalServiceUtil.updateprofileAreaofinterest(profileAreaofinterest);
			
			out = resourceResponse.getWriter();
			out.print("update");
		}catch(Exception e){
			
		}
	}
	
	private boolean isFolderExistProfile(long parentFolderId, long repositoryId,String userIdForFolder) {
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(repositoryId, parentFolderId,userIdForFolder);
			folderExist = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return folderExist;
	}
	
	public void saveProfileForm(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		
		//Personal Information
		/*String firstName = uploadRequest.getParameter("firstName");
		String lastName = uploadRequest.getParameter("lastName");
		String prefixValue = uploadRequest.getParameter("prefixValue").toLowerCase();
		String jobTitle = uploadRequest.getParameter("jobTitle");*/
		File file = uploadRequest.getFile("file");
		
		//Credentials Form
		long credentialId = ParamUtil.getLong(resourceRequest, "credentialId");
		String membership1 = ParamUtil.getString(resourceRequest, "membership1");
		String membership2 = ParamUtil.getString(resourceRequest, "membership2");
		String membership3 = ParamUtil.getString(resourceRequest, "membership3");
		String membership4 = ParamUtil.getString(resourceRequest, "membership4");
		String certificate1 = ParamUtil.getString(resourceRequest, "certificate1");
		String certificate2 = ParamUtil.getString(resourceRequest, "certificate2");
		String certificate3 = ParamUtil.getString(resourceRequest, "certificate3");
		
		//Communication Preferences form
		String emailAddress = ParamUtil.getString(resourceRequest, "communicationEmail");
		String phoneNumberChar = ParamUtil.getString(resourceRequest, "communicationPhoneNumber");
		String communicationMobileNumber = ParamUtil.getString(resourceRequest, "communicationMobileNumber");
		//String phoneNumber = phoneNumberChar.replaceAll("[^a-zA-Z0-9]", "");
		String website = ParamUtil.getString(resourceRequest, "communicationWebsite");	
		long primaryLanguageID = ParamUtil.getLong(resourceRequest, "primaryLanguage");
		long secondaryLanguageID = ParamUtil.getLong(resourceRequest, "secondaryLanguage");
		long tertiaryLanguageID = ParamUtil.getLong(resourceRequest, "tertiaryLanguage");
		String primaryLanguageName = getLanguageName(primaryLanguageID);
		String secondaryLanguageName = getLanguageName(secondaryLanguageID);
		String tertiaryLanguageName = getLanguageName(tertiaryLanguageID);		
		long communicationId = ParamUtil.getLong(resourceRequest, "communicationId");
		
		//Add interest
		long addInterestId = ParamUtil.getLong(resourceRequest, "addInterestId");
		String projectType = ParamUtil.getString(resourceRequest, "projectType");
		String projectDescription = ParamUtil.getString(resourceRequest, "projectDescription");
		String discipline1 = ParamUtil.getString(resourceRequest, "discipline1");
		String discipline2 = ParamUtil.getString(resourceRequest, "discipline2");
		String discipline3 = ParamUtil.getString(resourceRequest, "discipline3");
		String endMonthRangeAdd = ParamUtil.getString(resourceRequest, "endMonthRangeAdd");
		int endYearRangeAdd = ParamUtil.getInteger(resourceRequest, "endYearRangeAdd");
		String startMonthRange = ParamUtil.getString(resourceRequest, "startMonthRange");
		int startYearRange = ParamUtil.getInteger(resourceRequest, "startYearRange");
		
		//String discipline4 = ParamUtil.getString(resourceRequest, "discipline4");
//		String[] disciplineInput = ParamUtil.getParameterValues(resourceRequest, "discipline");
//		StringBuilder disciplines = new StringBuilder();
//		for(String dis : disciplineInput){
//			disciplines.append(dis);
//			disciplines.append(",");
//		}
//		String discipline = disciplines.toString();
		String preferredLanguage = ParamUtil.getString(resourceRequest, "preferredLanguage");
		String location1 = ParamUtil.getString(resourceRequest, "location1");
		String location2 = ParamUtil.getString(resourceRequest, "location2");
		String location3 = ParamUtil.getString(resourceRequest, "location3");
		String location4 = ParamUtil.getString(resourceRequest, "location4");
//		String[] locationInput = ParamUtil.getParameterValues(resourceRequest, "location");
//		StringBuilder locations = new StringBuilder();
//		for(String loc : locationInput){
//			locations.append(loc);
//			locations.append(",");
//		}
//		String location = locations.toString();
		
		
		
		String intracampus = ParamUtil.getString(resourceRequest, "intracampus");		
		String programLevel = ParamUtil.getString(resourceRequest, "programLevel");
		String programLength = ParamUtil.getString(resourceRequest, "programLength");
		String deliveryMethod = ParamUtil.getString(resourceRequest, "deliveryMethod");
		String credits = ParamUtil.getString(resourceRequest, "credits");
		String addInterestButton = ParamUtil.getString(resourceRequest, "addInterestButton");
		String collaborationType = ParamUtil.getString(resourceRequest, "collaborationType");
		
		//Area of Expertise (Professional Bio)
		String areasofexpertise1 = ParamUtil.getString(resourceRequest, "areasofexpertise1");
		String areasofexpertise2 = ParamUtil.getString(resourceRequest, "areasofexpertise2");
		String areasofexpertise3 = ParamUtil.getString(resourceRequest, "areasofexpertise3");
		String experienceLevel = ParamUtil.getString(resourceRequest, "experienceLevel");
		String cvLink = ParamUtil.getString(resourceRequest, "cvLink");
		String bioDescription = ParamUtil.getString(resourceRequest, "bioDescription");
		String bioDiscipline = ParamUtil.getString(resourceRequest, "bioDiscipline");
		long professionalBioId = ParamUtil.getLong(resourceRequest, "professionalBioId");
		
		
		System.out.println(areasofexpertise2+bioDescription+"bioDescription");
		
		//Institution Profile
		String institutionName = ParamUtil.getString(resourceRequest, "institutionName");
		String academCalendar = ParamUtil.getString(resourceRequest, "academCalendar");
		String departamentDescription = ParamUtil.getString(resourceRequest, "departamentDescription");
		long institutionProfileId = ParamUtil.getLong(resourceRequest, "institutionProfileId");
		File documentFile = uploadRequest.getFile("uploadedDocument");
		
		long prefixId = 0;
		PrintWriter out = null;
		User user = null;
			try {
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), resourceRequest);
				user = themeDisplay.getUser();
				out = resourceResponse.getWriter();
				if(user!=null){
					//user.setFirstName(firstName);
					//user.setLastName(lastName);
					//user.setJobTitle(jobTitle);
					user.setExpandoBridgeAttributes(serviceContext);
					UserLocalServiceUtil.updateUser(user);			
					
					/*List<ListType> listType=ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.prefix");
					for(ListType l:listType){
						if(l.getName().toLowerCase().equals(prefixValue)){
							prefixId = l.getListTypeId();
						}
					}				
					if(prefixId!=0){
						Contact contact = ContactLocalServiceUtil.getContact(user.getContactId());
						contact.setPrefixId(prefixId);
						ContactLocalServiceUtil.updateContact(contact);
					}				
					else{
						ListType l = ListTypeLocalServiceUtil.addListType(prefixValue, "com.liferay.portal.kernel.model.Contact.prefix");
						Contact contact = ContactLocalServiceUtil.getContact(user.getContactId());
						contact.setPrefixId(l.getListTypeId());
						ContactLocalServiceUtil.updateContact(contact);
					}*/
					
					/*InputStream inputStream = uploadRequest.getFileAsStream("file");
					if (Validator.isNotNull(inputStream)) {
						byte[] bytes = FileUtil.getBytes(inputStream);
	                    LOG.info("Image bytes [" + bytes + "]");
	                    UserLocalServiceUtil.updatePortrait(user.getUserId(), bytes);
					}*/
					
					
					boolean profileAdded = false;
					if (file != null && file.length() > 0) {
						profileAdded = CommonMethods.addProfileImage(user.getUserId(),file);
					}
					
					out.print("update");
					
				}
				
				userCredential userCredential = null;
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
				List<userCredential> userList = userCredentialLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(userList.size()==0){
					if(!(membership1.equalsIgnoreCase("")) || !(membership2.equalsIgnoreCase("")) || !(membership3.equalsIgnoreCase(""))
							|| !(membership4.equalsIgnoreCase("")) || !(certificate2.equalsIgnoreCase("")) || !(certificate1.equalsIgnoreCase(""))
							|| !(certificate3.equalsIgnoreCase(""))){
						userCredential = userCredentialLocalServiceUtil.createuserCredential(CounterLocalServiceUtil.increment());
						userCredential.setUserId(themeDisplay.getUserId());
						userCredential.setCreateDate(new Date());
						userCredential.setGroupId(themeDisplay.getScopeGroupId());	
						userCredential.setMembership1(membership1);
						userCredential.setMembership2(membership2);
						userCredential.setMembership3(membership3);
						userCredential.setMembership4(membership4);
						userCredential.setCertificate1(certificate1);
						userCredential.setCertificate2(certificate2);
						userCredential.setCertificate3(certificate3);
						userCredentialLocalServiceUtil.adduserCredential(userCredential);
						out.print("add");
					}
					
				}else{
					userCredential = userCredentialLocalServiceUtil.getuserCredential(userList.get(0).getPK_userCredential());
					userCredential.setModifiedDate(new Date());
					userCredential.setUserId(themeDisplay.getUserId());
					userCredential.setGroupId(themeDisplay.getScopeGroupId());
					userCredential.setMembership1(membership1);
					userCredential.setMembership2(membership2);
					userCredential.setMembership3(membership3);
					userCredential.setMembership4(membership4);
					userCredential.setCertificate1(certificate1);
					userCredential.setCertificate2(certificate2);
					userCredential.setCertificate3(certificate3);
					userCredentialLocalServiceUtil.updateuserCredential(userCredential);
					out.print("update");
				}
				
				communicationPreferences communicationPreferences = null;
				DynamicQuery dynamicQueryCommunicationPrefe = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryCommunicationPrefe.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
				List<communicationPreferences> communicationList = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQueryCommunicationPrefe);
				if(communicationList.size()==0){
					if(!(primaryLanguageName.equalsIgnoreCase("")) || !(secondaryLanguageName.equalsIgnoreCase("")) || !(tertiaryLanguageName.equalsIgnoreCase(""))
							|| !(emailAddress.equalsIgnoreCase("")) || (phoneNumberChar!="") || !(website.equalsIgnoreCase(""))
							){
						communicationPreferences = communicationPreferencesLocalServiceUtil.createcommunicationPreferences(CounterLocalServiceUtil.increment());
						communicationPreferences.setUserId(themeDisplay.getUserId());
						communicationPreferences.setCreateDate(new Date());
						communicationPreferences.setGroupId(themeDisplay.getScopeGroupId());
						communicationPreferences.setPrimaryLanguageId(primaryLanguageID);
						communicationPreferences.setSecondaryLanguageId(secondaryLanguageID);
						communicationPreferences.setTertiaryLanguageId(tertiaryLanguageID);
						communicationPreferences.setPrimaryLanguageName(primaryLanguageName);
						communicationPreferences.setSecondaryLanguageName(secondaryLanguageName);
						communicationPreferences.setTertiaryLanguageName(tertiaryLanguageName);
						communicationPreferences.setEmailAddress(emailAddress);
						communicationPreferences.setPhoneNumber(phoneNumberChar);
						communicationPreferences.setMobileNumber(communicationMobileNumber);
						communicationPreferences.setWebsite(website);
						communicationPreferencesLocalServiceUtil.addcommunicationPreferences(communicationPreferences);
						out.print("add");
					}
					
				}else{
					System.out.println("primaryLanguageID========"+primaryLanguageID);
					communicationPreferences = communicationPreferencesLocalServiceUtil.getcommunicationPreferences(communicationList.get(0).getPK_communicationPreferences());
					communicationPreferences.setModifiedDate(new Date());
					communicationPreferences.setUserId(themeDisplay.getUserId());
					communicationPreferences.setGroupId(themeDisplay.getScopeGroupId());
					communicationPreferences.setPrimaryLanguageId(primaryLanguageID);
					communicationPreferences.setSecondaryLanguageId(secondaryLanguageID);
					communicationPreferences.setTertiaryLanguageId(tertiaryLanguageID);
					communicationPreferences.setPrimaryLanguageName(primaryLanguageName);
					communicationPreferences.setSecondaryLanguageName(secondaryLanguageName);
					communicationPreferences.setTertiaryLanguageName(tertiaryLanguageName);
					communicationPreferences.setEmailAddress(emailAddress);
					communicationPreferences.setPhoneNumber(phoneNumberChar);
					communicationPreferences.setWebsite(website);
					communicationPreferences.setMobileNumber(communicationMobileNumber);
					communicationPreferencesLocalServiceUtil.updatecommunicationPreferences(communicationPreferences);
					out.print("update");
				}
				
							
				userProfessionalBio userProfessionalBio = null;
				DynamicQuery dynamicQueryProfessionalBio = DynamicQueryFactoryUtil.forClass(userProfessionalBio.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryProfessionalBio.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
				List<userProfessionalBio> bioList = userProfessionalBioLocalServiceUtil.dynamicQuery(dynamicQueryProfessionalBio);
				if(bioList.size()==0){
					if(!(areasofexpertise1.equalsIgnoreCase("")) || !(areasofexpertise2.equalsIgnoreCase("")) || !(areasofexpertise3.equalsIgnoreCase(""))){
						userProfessionalBio = userProfessionalBioLocalServiceUtil.createuserProfessionalBio(CounterLocalServiceUtil.increment());
						userProfessionalBio.setUserId(themeDisplay.getUserId());
						userProfessionalBio.setCreateDate(new Date());
						userProfessionalBio.setGroupId(themeDisplay.getScopeGroupId());
						userProfessionalBio.setAreaofexpertise1(areasofexpertise1);
						userProfessionalBio.setAreaofexpertise2(areasofexpertise2);
						userProfessionalBio.setAreaofexpertise3(areasofexpertise3);
						userProfessionalBio.setExperienceyears(experienceLevel);
						userProfessionalBio.setCvlink(cvLink);
						userProfessionalBio.setBiodescription(bioDescription);
						userProfessionalBio.setBioDiscipline(bioDiscipline);
						userProfessionalBioLocalServiceUtil.adduserProfessionalBio(userProfessionalBio);
						out.print("add");
					}
				
				}else{
					userProfessionalBio = userProfessionalBioLocalServiceUtil.getuserProfessionalBio(bioList.get(0).getPK_userProfessionalBio());
					userProfessionalBio.setModifiedDate(new Date());
					userProfessionalBio.setUserId(themeDisplay.getUserId());
					userProfessionalBio.setGroupId(themeDisplay.getScopeGroupId());	
					userProfessionalBio.setAreaofexpertise1(areasofexpertise1);
					userProfessionalBio.setAreaofexpertise2(areasofexpertise2);
					userProfessionalBio.setAreaofexpertise3(areasofexpertise3);
					userProfessionalBio.setExperienceyears(experienceLevel);
					userProfessionalBio.setCvlink(cvLink);
					userProfessionalBio.setBiodescription(bioDescription);
					userProfessionalBio.setBioDiscipline(bioDiscipline);
					userProfessionalBioLocalServiceUtil.updateuserProfessionalBio(userProfessionalBio);
					out.print("update");
				}
				
				profileAreaofinterest  profileAreaofinterest = null;
				if(addInterestButton.equalsIgnoreCase("AddInterest")){
					String instituteName = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteName");
					addInterestId = CounterLocalServiceUtil.increment();
					profileAreaofinterest = profileAreaofinterestLocalServiceUtil.createprofileAreaofinterest(addInterestId);
					profileAreaofinterest.setUserId(themeDisplay.getUserId());
					profileAreaofinterest.setCreateDate(new Date());
					profileAreaofinterest.setGroupId(themeDisplay.getScopeGroupId());
					profileAreaofinterest.setProjectType(projectType);
					profileAreaofinterest.setDescription(projectDescription);
					profileAreaofinterest.setLanguage(preferredLanguage);	
//					profileAreaofinterest.setDiscipline1(discipline.substring(0,discipline.length()-1));			
//					profileAreaofinterest.setLocation1(location.substring(0,location.length()-1));
					//profileAreaofinterest.setCampus(intracampus);
					profileAreaofinterest.setDiscipline1(discipline1);	
					profileAreaofinterest.setLocation1(location1);
					profileAreaofinterest.setDiscipline2(discipline2);	
					profileAreaofinterest.setLocation2(location2);
					profileAreaofinterest.setDiscipline3(discipline3);	
					profileAreaofinterest.setLocation3(location3);	
					profileAreaofinterest.setLocation4(location4);
					profileAreaofinterest.setCollaborationType(collaborationType);
					profileAreaofinterest.setRangerYearEnd(endYearRangeAdd);
					profileAreaofinterest.setRangerMonthEnd(endMonthRangeAdd);
					profileAreaofinterest.setRangerMonthStart(startMonthRange);
					profileAreaofinterest.setRangerYearStart(startYearRange);
					profileAreaofinterest.setUniversityName(instituteName);
					
					if(projectType.equalsIgnoreCase("Course Development") || projectType.equalsIgnoreCase("Curriculum Development")){
						profileAreaofinterest.setProgramLevel(programLevel);
						profileAreaofinterest.setProgramLength(programLength);
						profileAreaofinterest.setDeliveryMethod(deliveryMethod);
						profileAreaofinterest.setCredits(credits);
					}
					profileAreaofinterestLocalServiceUtil.addprofileAreaofinterest(profileAreaofinterest);
					out.print("add");
				}
				
				long fileEntryId = 0;
				if(documentFile!=null && documentFile.length()>0){
					//fileEntryId = saveInstitutionProfileUpload(resourceRequest,resourceResponse);
				}	
				
				userInstitutionProfileDetails userInstitutionProfileDetails = null;
				DynamicQuery dynamicQueryInstitutionProfile = DynamicQueryFactoryUtil.forClass(userInstitutionProfileDetails.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryInstitutionProfile.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
				List<userInstitutionProfileDetails> institutionList = userInstitutionProfileDetailsLocalServiceUtil.dynamicQuery(dynamicQueryInstitutionProfile);
				if(institutionList.size()==0){
					if(!(institutionName.equalsIgnoreCase("")) || !(academCalendar.equalsIgnoreCase("")) || !(departamentDescription.equalsIgnoreCase(""))){
						userInstitutionProfileDetails = userInstitutionProfileDetailsLocalServiceUtil.createuserInstitutionProfileDetails(CounterLocalServiceUtil.increment());
						userInstitutionProfileDetails.setUserId(themeDisplay.getUserId());
						userInstitutionProfileDetails.setCreateDate(new Date());
						userInstitutionProfileDetails.setGroupId(themeDisplay.getScopeGroupId());
						userInstitutionProfileDetails.setInstitutionName(institutionName);
						userInstitutionProfileDetails.setAcadeCalendar(academCalendar);
						userInstitutionProfileDetails.setDepartmentdescription(departamentDescription);
						userInstitutionProfileDetailsLocalServiceUtil.adduserInstitutionProfileDetails(userInstitutionProfileDetails);
						
						if(fileEntryId>0){
							userInstitutionProfileSubDetails userInstitutionProfileSubDetails = userInstitutionProfileSubDetailsLocalServiceUtil.createuserInstitutionProfileSubDetails(CounterLocalServiceUtil.increment());
							userInstitutionProfileSubDetails.setUserId(themeDisplay.getUserId());
							userInstitutionProfileSubDetails.setCreateDate(new Date());
							userInstitutionProfileSubDetails.setGroupId(themeDisplay.getScopeGroupId());
							userInstitutionProfileSubDetails.setFileId(fileEntryId);
							userInstitutionProfileSubDetails.setPK_userInstition(userInstitutionProfileDetails.getPK_userInstition());
						}
						out.print("add");
					}					
					
				}else{
					userInstitutionProfileDetails = userInstitutionProfileDetailsLocalServiceUtil.getuserInstitutionProfileDetails(institutionList.get(0).getPK_userInstition());
					userInstitutionProfileDetails.setModifiedDate(new Date());
					userInstitutionProfileDetails.setUserId(themeDisplay.getUserId());
					userInstitutionProfileDetails.setGroupId(themeDisplay.getScopeGroupId());	
					userInstitutionProfileDetails.setInstitutionName(institutionName);
					userInstitutionProfileDetails.setAcadeCalendar(academCalendar);
					userInstitutionProfileDetails.setDepartmentdescription(departamentDescription);
					userInstitutionProfileDetailsLocalServiceUtil.updateuserInstitutionProfileDetails(userInstitutionProfileDetails);
					
					if(fileEntryId>0){
						userInstitutionProfileSubDetails userInstitutionProfileSubDetails = userInstitutionProfileSubDetailsLocalServiceUtil.createuserInstitutionProfileSubDetails(CounterLocalServiceUtil.increment());
						userInstitutionProfileSubDetails.setUserId(themeDisplay.getUserId());
						userInstitutionProfileSubDetails.setCreateDate(new Date());
						userInstitutionProfileSubDetails.setGroupId(themeDisplay.getScopeGroupId());
						userInstitutionProfileSubDetails.setFileId(fileEntryId);
						userInstitutionProfileSubDetails.setPK_userInstition(userInstitutionProfileDetails.getPK_userInstition());
						userInstitutionProfileSubDetailsLocalServiceUtil.adduserInstitutionProfileSubDetails(userInstitutionProfileSubDetails);
					}
					out.print("update");
				}
				
				
				
				/*if (file != null) {			
					InputStream inputStream = new FileInputStream(file);
					byte[] bytes = FileUtil.getBytes(inputStream);
					UserServiceUtil.updatePortrait(themeDisplay.getUser().getUserId(), bytes);
				}*/	
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if (out != null) {
					out.close();
				}
			}
	}
	
	private long saveInstitutionProfileUpload(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		boolean folderExist = false;
		String fileName = "";
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		System.out.println("userId---------->" + userId);
		String userIdForFolder = String.valueOf(userId);
		String folderDesc = "This folder is create for Upload documents";
		String subFolder = "Institution Profile";
		DLFileEntry fileEntry = null;
		FileEntry dlFileEntry = null;
		DLFolder dlfolder = null;
		Folder folder1 = null;
		Folder folder = null;
		long dlId = 0;
		long repositoryId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long groupId = themeDisplay.getScopeGroupId();
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File file = uploadRequest.getFile("uploadedDocument");
		
		ServiceContext serviceContext = null;
		try {
			serviceContext = new ServiceContext();
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			folderExist = isFolderExist(parentFolderId, repositoryId, userIdForFolder);
			if (folderExist == false) {
				folder1 = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, userIdForFolder, folderDesc,
						serviceContext);
			} else {
				folder1 = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, userIdForFolder);
			}
			if (folder1 != null) {
				folderExist = isFolderExist(folder1.getFolderId(), repositoryId, subFolder);
				if (folderExist == false) {
					folder = DLAppServiceUtil.addFolder(repositoryId, folder1.getFolderId(), subFolder, folderDesc,
							serviceContext);
				} else {
					folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folder1.getFolderId(),
							subFolder);
				}
			}
			System.out.println("folder1-------------------->" + folder1);
			System.out.println("folder-------------------->" + folder);
			
			InputStream is = null;
			System.out.println(file);
			System.out.println(file.length());
			String nameFile = "";
			if (file != null && file.length() > 0) {
				is = new FileInputStream(file);

				String fname = uploadRequest.getFileName("uploadedDocument");
				String name = fname.replaceAll("\\s+", "");
				System.out.println("name------------->" + name);
				fileName = name;
				String[] res = name.split("\\.");
				if (res[1].equals("jpeg")) {
					fileName = res[0] + res[1].replace(res[1], ".jpg");
				}
				nameFile = new Date().getTime() + "_" + fileName;
			}
			System.out.println("nameFile----------->" + nameFile);
			String DocumentTitle = fileName;
			System.out.println("DocumentTitle----------->" + DocumentTitle);
			try {
				if (folder1 != null) {
					System.out.println("if===folder1----------->");					
					if (file != null && file.length() > 0) {
						dlFileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folder1.getFolderId(),
								nameFile, MimeTypesUtil.getContentType(file), DocumentTitle, "File upload programatically for institution profile",
								"", is, file.length(), serviceContext);
					}

					dlId = dlFileEntry.getFileEntryId();
					System.out.println("dlId===" + dlId);
					Date date1 = new Date();
					if (dlId > 0) {
						DLFileEntry obj = DLFileEntryLocalServiceUtil.fetchDLFileEntry(dlId);
						obj.setCreateDate(date1);
						obj.setTitle(userId + "_" + DocumentTitle);
						obj.setDescription("File upload programatically for institution profile");
						DLFileEntryLocalServiceUtil.updateDLFileEntry(obj);
					}
					//isReturn = "true";
				}

			} catch (DuplicateFileException e1) {
				//isReturn = "Document Title Already Exist";
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				if (is != null) {
					is.close();
				}
			}
			//out.print(dlId);
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return dlId;
	}
	
	private boolean isFolderExist(long parentFolderId,long repositoryId,String userIdForFolder) {
		boolean folderExist = false;
		try {
				DLAppServiceUtil.getFolder(repositoryId,parentFolderId,userIdForFolder);
				folderExist = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return folderExist;
	}
	
	public void updateProfile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		String firstName = uploadRequest.getParameter("firstName");
		String lastName = uploadRequest.getParameter("lastName");
		String prefixValue = uploadRequest.getParameter("prefixValue").toLowerCase();
		String jobTitle = uploadRequest.getParameter("jobTitle");
		File file = uploadRequest.getFile("file");
		long prefixId = 0;
		PrintWriter out = null;
			try {
				out = resourceResponse.getWriter();
				ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), resourceRequest);
				
				User user = themeDisplay.getUser();
				//user.setFirstName(firstName);
				//user.setLastName(lastName);
				//user.setJobTitle(jobTitle);
				user.setExpandoBridgeAttributes(serviceContext);
				UserLocalServiceUtil.updateUser(user);
				
				List<ListType> listType=ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.prefix");
				for(ListType l:listType){
					if(l.getName().toLowerCase().equals(prefixValue)){
						prefixId = l.getListTypeId();
					}
				}				
				if(prefixId!=0){
					Contact contact = ContactLocalServiceUtil.getContact(user.getContactId());
					contact.setPrefixId(prefixId);
					ContactLocalServiceUtil.updateContact(contact);
				}
								
				/*InputStream inputStream = uploadRequest.getFileAsStream("file");
				if (Validator.isNotNull(inputStream)) {
					byte[] bytes = FileUtil.getBytes(inputStream);
                    LOG.info("Image bytes [" + bytes + "]");
                    UserLocalServiceUtil.updatePortrait(user.getUserId(), bytes);
				}*/
				
				/*if (file != null) {			
					InputStream inputStream = new FileInputStream(file);
					byte[] bytes = FileUtil.getBytes(inputStream);
					UserServiceUtil.updatePortrait(themeDisplay.getUser().getUserId(), bytes);
				}*/	
				
				boolean profileAdded = false;
				if (file != null && file.length() > 0) {
					profileAdded = CommonMethods.addProfileImage(user.getUserId(),file);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}finally{
				if (out != null) {
					out.close();
				}
			}
	}
	
	public void getProfileInfo(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = null;
		JSONObject jsonObject = null;
		PrintWriter out = null;OutputStream o = null;Blob blob = null;
		String firstName = "",lastName="",jobTitle="",prefixValue="",imageURL="";
		boolean isBase64=false;
		try{
			out = resourceResponse.getWriter();
			user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			if(user!=null){
				jsonObject = JSONFactoryUtil.createJSONObject();
				if(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId()!=0){
					ListType listType = ListTypeServiceUtil.getListType(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId());
					prefixValue = listType.getName().toLowerCase();
					//jsonObject.put("prefixValue", listType.getName().toLowerCase());
				}else{
					//jsonObject.put("prefixValue", "");
				}
				String profileStatus = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("status");
				String[] onlineStatus = (String[]) themeDisplay.getUser().getExpandoBridge().getAttribute("onlineStatus");
				String instituteName = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteName");
				
				String instituteDepartment = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteDepartment");
				String instituteCity = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteCity");
				String instituteState = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteState");
				String instituteCountry = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteCountry");
				
				JSONObject userJSON = null;
				if(userJSON!=null){
					firstName = userJSON.getString("firstName");
					lastName = userJSON.getString("lastName"); 
					prefixValue = userJSON.getString("prefix").toLowerCase();
					if(userJSON.getString("position").trim()!=null && userJSON.getString("position").trim()!=""){
						jobTitle = userJSON.getString("position");
					}
				}else{
					firstName = user.getFirstName();
					lastName = user.getLastName();
					jobTitle = user.getJobTitle();
				}
				
				/*FileEntry dlFileEntry = null;String imageURL = "";
				dlFileEntry = DLAppServiceUtil.getFileEntry(user.getPortraitId());
				if(dlFileEntry!=null){
					imageURL = "/documents/" + dlFileEntry.getGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle();
				}*/
				
				
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(user.getUserId()));
				List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(values.size()>0){
					imageURL = values.get(0).getFileEntryUrl();					
	                JSONObject jsonObject2 = CommonMethods.getProfileImageBlob(user.getUserId());	               
	                imageURL = jsonObject2.getString("byteArray");
	                isBase64 = true;
				}else{
					//imageURL = user.getPortraitURL(themeDisplay) ;
					imageURL = "/o/ahea-theme/images/user.png";
					isBase64 = false;
				}
				
				jsonObject.put("prefixValue", prefixValue);
				jsonObject.put("firstName", firstName);
				jsonObject.put("lastName", lastName);
				jsonObject.put("isBase64",isBase64);
				jsonObject.put("profileImage",imageURL);
				jsonObject.put("jobTitle", jobTitle);
				jsonObject.put("profileStatus", profileStatus);
				jsonObject.put("onlineStatus", onlineStatus);
				jsonObject.put("instituteName", instituteName);
				jsonObject.put("instituteDepartment", instituteDepartment);
				jsonObject.put("instituteCity", instituteCity);
				jsonObject.put("instituteState", instituteState);
				jsonObject.put("instituteCountry", instituteCountry);
				out.print(jsonObject);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			if(user!=null){
				user=null;
			}
			if (out != null) {
				out.close();
			}
			/*if(o!=null){
				o.flush();
	            o.close();
			}*/
			
		}
	}
	
	public void removeProfileImage(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = null;
		JSONObject jsonObject = null;
		PrintWriter out = null;
		try{
			out = resourceResponse.getWriter();
			if(themeDisplay.getUser().getPortraitId()!=0){
				UserLocalServiceUtil.deletePortrait(themeDisplay.getUserId());
			}		
			out.print("removed");
		}catch(Exception e){
			
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	//Credentials section
	private void saveCredentialsForm(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {
		
		PrintWriter out = null;
		String membership1 = ParamUtil.getString(resourceRequest, "membership1");
		String membership2 = ParamUtil.getString(resourceRequest, "membership2");
		String membership3 = ParamUtil.getString(resourceRequest, "membership3");
		String membership4 = ParamUtil.getString(resourceRequest, "membership4");
		String certificate1 = ParamUtil.getString(resourceRequest, "certificate1");
		String certificate2 = ParamUtil.getString(resourceRequest, "certificate2");
		String certificate3 = ParamUtil.getString(resourceRequest, "certificate3");
		
		long credentialId = ParamUtil.getLong(resourceRequest, "credentialId");
		
		userCredential userCredential = null;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			out = resourceResponse.getWriter();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			List<userCredential> userList = userCredentialLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(userList.size()==0){
				userCredential = userCredentialLocalServiceUtil.createuserCredential(CounterLocalServiceUtil.increment());
				userCredential.setUserId(themeDisplay.getUserId());
				userCredential.setCreateDate(new Date());
				userCredential.setGroupId(themeDisplay.getScopeGroupId());	
				userCredential.setMembership1(membership1);
				userCredential.setMembership2(membership2);
				userCredential.setMembership3(membership3);
				userCredential.setMembership4(membership4);
				userCredential.setCertificate1(certificate1);
				userCredential.setCertificate2(certificate2);
				userCredential.setCertificate3(certificate3);
				userCredentialLocalServiceUtil.adduserCredential(userCredential);
				out.print("add");
			}else{
				userCredential = userCredentialLocalServiceUtil.getuserCredential(credentialId);
				userCredential.setModifiedDate(new Date());
				userCredential.setGroupId(themeDisplay.getScopeGroupId());
				userCredential.setMembership1(membership1);
				userCredential.setMembership2(membership2);
				userCredential.setMembership3(membership3);
				userCredential.setMembership4(membership4);
				userCredential.setCertificate1(certificate1);
				userCredential.setCertificate2(certificate2);
				userCredential.setCertificate3(certificate3);
				userCredentialLocalServiceUtil.updateuserCredential(userCredential);
				out.print("update");
			}
			
		}catch (Exception e) {
			LOG.info(e.getMessage());
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void getCredentialData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = null;
		JSONObject jsonObject = null;
		PrintWriter out = null;
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			List<userCredential> creList = userCredentialLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(creList.size()>0){
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("membership1", creList.get(0).getMembership1());
				jsonObject.put("membership2", creList.get(0).getMembership2());
				jsonObject.put("membership3", creList.get(0).getMembership3());
				jsonObject.put("membership4", creList.get(0).getMembership4());
				jsonObject.put("certificate1", creList.get(0).getCertificate1());
				jsonObject.put("certificate2", creList.get(0).getCertificate2());
				jsonObject.put("certificate3", creList.get(0).getCertificate3());
				jsonObject.put("credentialId", creList.get(0).getPK_userCredential());
				out.print(jsonObject);
			}
		}catch(Exception e){
			e.printStackTrace();			
		}finally{
			if(user!=null){
				user=null;
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	//Communication Preferences
	
	public JSONArray getLanguageList(){
		JSONObject jsonSingleObject = null;
		JSONArray listArray = null;
	
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection conn = null;
		try{
			String query = "SELECT * FROM `collaborated_languagePreferences`";
			conn = DataAccess.getConnection();
			st = conn.prepareStatement(query);
			rs = st.executeQuery(query);
			listArray = JSONFactoryUtil.createJSONArray();
			if (rs != null) {
				while (rs.next()) {
					jsonSingleObject = JSONFactoryUtil.createJSONObject();
					jsonSingleObject.put("languageId",rs.getLong("PK_languagePreferences"));
					jsonSingleObject.put("languageName",rs.getString("languageName")) ;
					listArray.put(jsonSingleObject);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
		    		rs.close();
		    	}
				if(st!=null){
					st.close();
		    	}
				if(conn!=null){
					conn.close();
		    	}
			}catch(Exception e){
			}
		}
		return listArray;
	}
	
	public String getLanguageName(long languageId) {
		String languageName = "";		
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection conn = null;
		try{
			String query = "SELECT languageName FROM `collaborated_languagepreferences` WHERE `PK_languagePreferences`="+languageId;
			conn = DataAccess.getConnection();
			st = conn.prepareStatement(query);
			rs = st.executeQuery(query);
			if (rs != null) {
				while (rs.next()) {
					languageName = rs.getString("languageName");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
		    		rs.close();
		    	}
				if(st!=null){
					st.close();
		    	}
				if(conn!=null){
					conn.close();
		    	}
			}catch(Exception e){
			}
		}
		
		return languageName;
	}
	
	private void saveCommunicationPreferences(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {
		
		PrintWriter out = null;
		String emailAddress = ParamUtil.getString(resourceRequest, "communicationEmail");
		String phoneNumberChar = ParamUtil.getString(resourceRequest, "communicationPhoneNumber");
		String phoneNumber = phoneNumberChar.replaceAll("[^a-zA-Z0-9]", "");
		String website = ParamUtil.getString(resourceRequest, "communicationWebsite");
		
		
		long primaryLanguageID = ParamUtil.getLong(resourceRequest, "primaryLanguage");
		long secondaryLanguageID = ParamUtil.getLong(resourceRequest, "secondaryLanguage");
		long tertiaryLanguageID = ParamUtil.getLong(resourceRequest, "tertiaryLanguage");
		String primaryLanguageName = getLanguageName(primaryLanguageID);
		String secondaryLanguageName = getLanguageName(secondaryLanguageID);
		String tertiaryLanguageName = getLanguageName(tertiaryLanguageID);
		
		long communicationId = ParamUtil.getLong(resourceRequest, "communicationId");
		
		communicationPreferences communicationPreferences = null;
		
		System.out.println(emailAddress+phoneNumber+website+primaryLanguageID+secondaryLanguageID+tertiaryLanguageID);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			out = resourceResponse.getWriter();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			List<communicationPreferences> userList = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(userList.size()==0){
				communicationPreferences = communicationPreferencesLocalServiceUtil.createcommunicationPreferences(CounterLocalServiceUtil.increment());
				communicationPreferences.setUserId(themeDisplay.getUserId());
				communicationPreferences.setCreateDate(new Date());
				communicationPreferences.setGroupId(themeDisplay.getScopeGroupId());
				communicationPreferences.setPrimaryLanguageId(primaryLanguageID);
				communicationPreferences.setSecondaryLanguageId(secondaryLanguageID);
				communicationPreferences.setTertiaryLanguageId(tertiaryLanguageID);
				communicationPreferences.setPrimaryLanguageName(primaryLanguageName);
				communicationPreferences.setSecondaryLanguageName(secondaryLanguageName);
				communicationPreferences.setTertiaryLanguageName(tertiaryLanguageName);
				communicationPreferences.setEmailAddress(emailAddress);
				communicationPreferences.setPhoneNumber(phoneNumber);
				communicationPreferences.setWebsite(website);
				communicationPreferencesLocalServiceUtil.addcommunicationPreferences(communicationPreferences);
				out.print("add");
			}else{
				communicationPreferences = communicationPreferencesLocalServiceUtil.getcommunicationPreferences(communicationId);
				communicationPreferences.setModifiedDate(new Date());
				communicationPreferences.setGroupId(themeDisplay.getScopeGroupId());
				communicationPreferences.setPrimaryLanguageId(primaryLanguageID);
				communicationPreferences.setSecondaryLanguageId(secondaryLanguageID);
				communicationPreferences.setTertiaryLanguageId(tertiaryLanguageID);
				communicationPreferences.setPrimaryLanguageName(primaryLanguageName);
				communicationPreferences.setSecondaryLanguageName(secondaryLanguageName);
				communicationPreferences.setTertiaryLanguageName(tertiaryLanguageName);
				communicationPreferences.setEmailAddress(emailAddress);
				communicationPreferences.setPhoneNumber(phoneNumber);
				communicationPreferences.setWebsite(website);
				communicationPreferencesLocalServiceUtil.updatecommunicationPreferences(communicationPreferences);
				out.print("update");
			}
			
		}catch (Exception e) {
			LOG.info(e.getMessage());
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	public void getCollaborationInterest(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		PrintWriter out = null;
		List<profileAreaofinterest> listData = null;
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(profileAreaofinterest.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			listData = profileAreaofinterestLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println(listData);
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(listData.size()>0){
				for(profileAreaofinterest pa:listData){					
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("projectType", pa.getProjectType());
					jsonObject.put("collaborationType", pa.getCollaborationType());
					jsonObject.put("discipline1", pa.getDiscipline1());
					jsonObject.put("discipline2", pa.getDiscipline2());
					jsonObject.put("discipline3", pa.getDiscipline3());
					jsonObject.put("region1", pa.getLocation1());
					jsonObject.put("region2", pa.getLocation2());
					jsonObject.put("region3", pa.getLocation3());
					jsonObject.put("region4", pa.getLocation4());
					jsonObject.put("deliveryMethod", pa.getDeliveryMethod());					
					jsonObject.put("language", pa.getLanguage());
					jsonObject.put("id", pa.getPK_areaofinterest());
					
					jsonArray.put(jsonObject);
				}
			}
			System.out.println("jsonArray=======");
			System.out.println(jsonArray);
			out.print(jsonArray);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	public void getViewMoreData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject jsonObject = null;
		PrintWriter out = null;
		profileAreaofinterest singleData = null;
		String intercampus = "",deliveryMethod = "",deliveryMethodEdit="";
		long key = ParamUtil.getLong(resourceRequest, "key");
		
		try{
			out = resourceResponse.getWriter();
			singleData = profileAreaofinterestLocalServiceUtil.fetchprofileAreaofinterest(key);
			SimpleDateFormat displayFormat = new SimpleDateFormat("yyyy-MM-dd");
			if(singleData!=null){
				if(singleData.getCampus().equalsIgnoreCase("1")){
					intercampus = "Intracampus";
				}else if(singleData.getCampus().equalsIgnoreCase("2")){
					intercampus = "Intercampus";
				}
				
				if(singleData.getDeliveryMethod().equalsIgnoreCase("Blended or Hybrid")){
					deliveryMethod = "Blended";
				}else{
					deliveryMethod = singleData.getDeliveryMethod();
				}
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("projectType", singleData.getProjectType());
				jsonObject.put("deliveryMethod", deliveryMethod);
				jsonObject.put("deliveryMethodEdit", singleData.getDeliveryMethod());
				jsonObject.put("discipline1", singleData.getDiscipline1());
				jsonObject.put("discipline2", singleData.getDiscipline2());
				jsonObject.put("discipline3", singleData.getDiscipline3());
				jsonObject.put("description", singleData.getDescription());
				//jsonObject.put("campus", intercampus);
				jsonObject.put("programLevel", singleData.getProgramLevel());
				jsonObject.put("programLength", singleData.getProgramLength());
				jsonObject.put("credits", singleData.getCredits());
				jsonObject.put("language", singleData.getLanguage());
				jsonObject.put("region1", singleData.getLocation1());
				jsonObject.put("region2", singleData.getLocation2());
				jsonObject.put("region3", singleData.getLocation3());
				jsonObject.put("region4", singleData.getLocation4());
				jsonObject.put("collaborationType", singleData.getCollaborationType());
				jsonObject.put("startMonth", singleData.getRangerMonthStart());
				jsonObject.put("endMonth", singleData.getRangerMonthEnd());
				jsonObject.put("startYear", singleData.getRangerYearStart());
				jsonObject.put("endYear", singleData.getRangerYearEnd());
				jsonObject.put("PK_areaofinterest", singleData.getPK_areaofinterest());
				jsonObject.put("created", displayFormat.format(singleData.getCreateDate()));
			}
			System.out.println("================"+jsonObject);
			out.print(jsonObject);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void goToMatchingScreen(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		long key = ParamUtil.getLong(resourceRequest, "key");
		try{
			PortletSession portletSession = resourceRequest.getPortletSession();
	     	portletSession.removeAttribute("selectedProject");
	     	portletSession.setAttribute("selectedProject",String.valueOf(key), PortletSession.APPLICATION_SCOPE);
	     	System.out.println(portletSession.getAttribute("selectedProject", PortletSession.APPLICATION_SCOPE));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	public void getProfessionalBio(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		PrintWriter out = null;
		List<userProfessionalBio> listData = null;
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfessionalBio.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			listData = userProfessionalBioLocalServiceUtil.dynamicQuery(dynamicQuery);
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(listData.size()>0){				
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("professionalBioId",listData.get(0).getPK_userProfessionalBio());
				jsonObject.put("areasofexpertise1",listData.get(0).getAreaofexpertise1());
				jsonObject.put("areasofexpertise2",listData.get(0).getAreaofexpertise2());
				jsonObject.put("areasofexpertise3", listData.get(0).getAreaofexpertise3());
				jsonObject.put("experienceLevel", listData.get(0).getExperienceyears());
				jsonObject.put("cvLink", listData.get(0).getCvlink());
				jsonObject.put("bioDescription",listData.get(0).getBiodescription());	
				jsonObject.put("bioDiscipline", listData.get(0).getBioDiscipline());
				jsonArray.put(jsonObject);
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
	
	private void saveCollaborationInterest(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {
		
		PrintWriter out = null;
		long collaborationInterestId = ParamUtil.getLong(resourceRequest, "collaborationInterestId");
		String projectType = ParamUtil.getString(resourceRequest, "projectType");
		String projectDescription = ParamUtil.getString(resourceRequest, "projectDescription");
		String discipline = ParamUtil.getString(resourceRequest, "discipline");
		String preferredLanguage = ParamUtil.getString(resourceRequest, "preferredLanguage");
		String location = ParamUtil.getString(resourceRequest, "location");
		String intracampus = ParamUtil.getString(resourceRequest, "intracampus");
		
		String programLevel = ParamUtil.getString(resourceRequest, "programLevel");
		String programLength = ParamUtil.getString(resourceRequest, "programLength");
		String deliveryMethod = ParamUtil.getString(resourceRequest, "deliveryMethod");
		String credits = ParamUtil.getString(resourceRequest, "credits");
		
		
		
		profileAreaofinterest  profileAreaofinterest = null;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			out = resourceResponse.getWriter();
			collaborationInterestId = CounterLocalServiceUtil.increment();
			profileAreaofinterest = profileAreaofinterestLocalServiceUtil.createprofileAreaofinterest(collaborationInterestId);
			profileAreaofinterest.setUserId(themeDisplay.getUserId());
			profileAreaofinterest.setCreateDate(new Date());
			profileAreaofinterest.setGroupId(themeDisplay.getScopeGroupId());
			profileAreaofinterest.setProjectType(projectType);
			profileAreaofinterest.setDescription(projectDescription);
			//profileAreaofinterest.setDiscipline(discipline);
			profileAreaofinterest.setLanguage(preferredLanguage);
			//profileAreaofinterest.setLocation(location);
			profileAreaofinterest.setCampus(intracampus);
			
			if(projectType.equalsIgnoreCase("Course Development") || projectType.equalsIgnoreCase("Curriculum Development")){
				profileAreaofinterest.setProgramLevel(programLevel);
				profileAreaofinterest.setProgramLength(programLength);
				profileAreaofinterest.setDeliveryMethod(deliveryMethod);
				profileAreaofinterest.setCredits(credits);
			}
			
			profileAreaofinterestLocalServiceUtil.addprofileAreaofinterest(profileAreaofinterest);
			out.print("add");
		}catch (Exception e) {
			LOG.info(e.getMessage());
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	private void removeCollaborationInterest(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {
		profileAreaofinterest  profileAreaofinterest = null;
		PrintWriter out = null;
		try {
			out = resourceResponse.getWriter();
			long profileInterestId = ParamUtil.getLong(resourceRequest, "profileInterestId");
			if(profileInterestId!=0){
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(profileInterestId));
				List<projectInviteTracking> listData = userProfessionalBioLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(listData.size()==0){
					profileAreaofinterestLocalServiceUtil.deleteprofileAreaofinterest(profileInterestId);
					out.print("removed");
				}else{
					out.print("error");
				}				
			}
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void getCommunicationPreferencesData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		PrintWriter out = null;
		List<communicationPreferences> listData = null;
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			listData = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQuery);
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(listData.size()>0){
				jsonObject = JSONFactoryUtil.createJSONObject();
				String mobileNum = listData.get(0).getMobileNumber(), phoneNum = listData.get(0).getPhoneNumber();
				if(!(listData.get(0).getMobileNumber().equalsIgnoreCase("")) && listData.get(0).getMobileNumber().contains("-")){
					mobileNum = listData.get(0).getMobileNumber().replace("-", "");
				}
				if(!(listData.get(0).getPhoneNumber().equalsIgnoreCase("")) && listData.get(0).getPhoneNumber().contains("-")){
					phoneNum = listData.get(0).getPhoneNumber().replace("-", "");
				}
				jsonObject.put("primLangId",listData.get(0).getPrimaryLanguageId());
				jsonObject.put("secoLangId",listData.get(0).getSecondaryLanguageId());
				jsonObject.put("terLangId",listData.get(0).getTertiaryLanguageId());
				jsonObject.put("mobileNum", mobileNum);
				jsonObject.put("phoneNum", phoneNum);
				jsonObject.put("primLangName", listData.get(0).getPrimaryLanguageName());
				jsonObject.put("secLangName", listData.get(0).getSecondaryLanguageName());
				jsonObject.put("terLangName",listData.get(0).getTertiaryLanguageName());
				jsonObject.put("email",listData.get(0).getEmailAddress());
				jsonObject.put("website", listData.get(0).getWebsite());
				jsonObject.put("communicationId", listData.get(0).getPK_communicationPreferences());
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
	
	public void getInstituteProfile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		PrintWriter out = null;
		List<userInstitutionProfileDetails> listData = null;
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userInstitutionProfileDetails.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			listData = userInstitutionProfileDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(listData.size()>0){				
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("institutionProfileId",listData.get(0).getPK_userInstition());
				jsonObject.put("institutionName",listData.get(0).getInstitutionName());
				jsonObject.put("academCalendar",listData.get(0).getAcadeCalendar());
				jsonObject.put("departamentDescription", listData.get(0).getDepartmentdescription());	
				DynamicQuery dynamicQuerySub = DynamicQueryFactoryUtil.forClass(userInstitutionProfileSubDetails.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
				List<userInstitutionProfileSubDetails> listSubData = userInstitutionProfileSubDetailsLocalServiceUtil.dynamicQuery(dynamicQuerySub);
				if(listSubData.size()>0){	
					for(userInstitutionProfileSubDetails sub:listSubData){
						if(sub.getFileId()!=0){
							FileEntry dlFileEntry = DLAppLocalServiceUtil.getFileEntry(sub.getFileId());
							String imgURL = themeDisplay.getPortalURL()+"/documents/" + dlFileEntry.getGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle();
							JSONObject jsonObjectSub = JSONFactoryUtil.createJSONObject();
							jsonObjectSub.put("url", imgURL);
							jsonObjectSub.put("fileName", dlFileEntry.getTitle());
							jsonArray.put(jsonObjectSub);
						}
					}
				}
				jsonObject.put("subDetails", jsonArray);
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
	
	public String viewParticularFile(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException{
		long fileEntryId = ParamUtil.getLong(resourceRequest, "fileEntryId");
		String imgURL = "";ThemeDisplay themeDisplay =null;
		try{
			themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			if(fileEntryId!=0){
				FileEntry dlFileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
				imgURL = themeDisplay.getPortalURL()+"/documents/" + dlFileEntry.getGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle();
			}
		}catch(Exception e){}
		return imgURL;
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