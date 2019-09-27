package com.collaborated.profile.personalinformation.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PersonalInformation Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PersonalInformationPortlet extends MVCPortlet {
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("getProfileData")){
			getProfileInfo(resourceRequest,resourceResponse);
		}
	}
	
	public void getProfileInfo(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		User user = null;
		String prefixValue = "";
		PrintWriter out = null;
		JSONObject jsonObject = null;
		String profileStatus = "";
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			profileStatus = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("status");
			String[] onlineStatus = (String[]) themeDisplay.getUser().getExpandoBridge().getAttribute("onlineStatus");
			user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			if(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId()!=0){
				ListType listType = ListTypeServiceUtil.getListType(ContactLocalServiceUtil.getContact(user.getContactId()).getPrefixId());
				prefixValue = listType.getName();
			}
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("prefixValue", prefixValue);
			jsonObject.put("fullName", user.getFullName());
			jsonObject.put("jobTitle", user.getJobTitle());
			jsonObject.put("profileImage", themeDisplay.getUser().getPortraitURL(themeDisplay));
			jsonObject.put("profileStatus", profileStatus);
			jsonObject.put("onlineStatus",onlineStatus);
			out.print(jsonObject);
		}catch(Exception e){
			
		}finally {
			if (out != null) {
				out.close();
			}
		}
	}
}