package com.collaborated.editprofile.personalinformation.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=ProfilePersonalInformation Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ProfilePersonalInformationPortlet extends MVCPortlet {

	final Log LOG = LogFactoryUtil.getLog(ProfilePersonalInformationPortlet.class);
	
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
		}
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
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setJobTitle(jobTitle);
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
								
				InputStream inputStream = uploadRequest.getFileAsStream("file");
				if (Validator.isNotNull(inputStream)) {
					byte[] bytes = FileUtil.getBytes(inputStream);
                    LOG.info("Image bytes [" + bytes + "]");
                    UserLocalServiceUtil.updatePortrait(user.getUserId(), bytes);
				}
				
				/*if (file != null) {			
					InputStream inputStream = new FileInputStream(file);
					byte[] bytes = FileUtil.getBytes(inputStream);
					UserServiceUtil.updatePortrait(themeDisplay.getUser().getUserId(), bytes);
				}*/	
				
				out.print("update");
				
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
	
	public void getProfileInfo(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = null;
		JSONObject jsonObject = null;
		PrintWriter out = null;
		try{
			out = resourceResponse.getWriter();
			user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			if(user!=null){
				jsonObject = JSONFactoryUtil.createJSONObject();
				if(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId()!=0){
					ListType listType = ListTypeServiceUtil.getListType(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId());
					jsonObject.put("prefixValue", listType.getName().toLowerCase());
				}else{
					jsonObject.put("prefixValue", "");
				}
				String profileStatus = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("status");
				String[] onlineStatus = (String[]) themeDisplay.getUser().getExpandoBridge().getAttribute("onlineStatus");
				long portraitId = user.getPortraitId();
				
				jsonObject.put("firstName", user.getFirstName());
				jsonObject.put("lastName", user.getLastName());
				jsonObject.put("profileImage", themeDisplay.getPathImage()+"/user_portrait?img_id="+portraitId);
				jsonObject.put("jobTitle", user.getJobTitle());
				jsonObject.put("profileStatus", profileStatus);
				jsonObject.put("onlineStatus", onlineStatus);
				out.print(jsonObject);
				System.out.println(jsonObject);
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
}