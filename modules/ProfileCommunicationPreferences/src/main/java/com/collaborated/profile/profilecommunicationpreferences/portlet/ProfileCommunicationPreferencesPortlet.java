package com.collaborated.profile.profilecommunicationpreferences.portlet;

import com.collaborated.entity.model.communicationPreferences;
import com.collaborated.entity.service.communicationPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProfileCommunicationPreferences Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProfileCommunicationPreferencesPortlet extends MVCPortlet {
	
	public static long selectedProfileMatching = 0;
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		PortletSession ps = request.getPortletSession();
		Object obj = ps.getAttribute("LIFERAY_SHARED_MATCHING_KEY", PortletSession.APPLICATION_SCOPE);
		selectedProfileMatching = 0;
		if (obj == null) {
			System.out.println("PortletSession attribute NOT found");
		} else {
			selectedProfileMatching = Long.valueOf(obj.toString());
			System.out.println("PortletSession attribute found"+selectedProfileMatching);
		}
		super.render(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("getProfileCommunicationPreferenceData")){
			getProfileInfo(resourceRequest,resourceResponse);
		}
	}
	
	public void getProfileInfo(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		PrintWriter out = null;
		JSONObject jsonObject = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			
			long userId = themeDisplay.getUserId();
			if(selectedProfileMatching>0){
				userId = selectedProfileMatching;
			}
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
			List<communicationPreferences> communicationPreferences = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(communicationPreferences.size()>0){
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("primaryLanguage_Communication", getLanguageName(communicationPreferences.get(0).getPrimaryLanguageId()));
				jsonObject.put("secondaryLanguage_Communication", getLanguageName(communicationPreferences.get(0).getSecondaryLanguageId()));
				jsonObject.put("emailId_Communication", communicationPreferences.get(0).getEmailAddress());
				jsonObject.put("phoneNumber_Communication", communicationPreferences.get(0).getPhoneNumber().substring(1));
				jsonObject.put("website_Communication", communicationPreferences.get(0).getWebsite());
			}
			out.print(jsonObject);
		}catch(Exception e){
			
		}finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	public String getLanguageName(long languageId) {
		String languageName = "";		
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection conn = null;
		try{
			String query = "SELECT languageName FROM `collaborated_languagePreferences` WHERE `PK_languagePreferences`="+languageId;
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
}