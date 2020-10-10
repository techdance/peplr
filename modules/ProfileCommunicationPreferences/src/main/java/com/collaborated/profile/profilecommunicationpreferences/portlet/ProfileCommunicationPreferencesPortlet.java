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
import com.liferay.portal.kernel.util.PortalUtil;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProfileCommunicationPreferences Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProfileCommunicationPreferencesPortlet extends MVCPortlet {
	
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
			
			long userId = 0;
			long selectedProfileMatching = 0;
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			long currentUser = 0;
			System.out.println(httpsession.getAttribute("currentUser"));
			if(httpsession.getAttribute("currentUser")!=null){
				currentUser = (Long)httpsession.getAttribute("currentUser");
				if(currentUser>0 && currentUser==themeDisplay.getUserId()){
					String sessionuserID = (String)httpsession.getAttribute("MATCHING_KEY");
					selectedProfileMatching = new Long(sessionuserID);	
				}
			}
			if(selectedProfileMatching>0){
				userId = selectedProfileMatching;
			}else{
				userId = themeDisplay.getUserId();
			}
			String primName = "", secondName = "", tertiaryName = "";
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
			List<communicationPreferences> communicationPreferences = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("userId==="+Long.valueOf(userId));
			System.out.println("communicationPreferences==="+communicationPreferences.size());
			if(communicationPreferences.size()>0){
				jsonObject = JSONFactoryUtil.createJSONObject();
				System.out.println(communicationPreferences.get(0).getPrimaryLanguageId()!=0);
				if(communicationPreferences.get(0).getPrimaryLanguageId()!=0){
					primName = getLanguageName(communicationPreferences.get(0).getPrimaryLanguageId());
				}
				System.out.println(communicationPreferences.get(0).getSecondaryLanguageId()!=0);
				if(communicationPreferences.get(0).getSecondaryLanguageId()!=0){
					secondName = getLanguageName(communicationPreferences.get(0).getSecondaryLanguageId());
				}
				System.out.println(communicationPreferences.get(0).getTertiaryLanguageId()!=0);
				if(communicationPreferences.get(0).getTertiaryLanguageId()!=0){
					tertiaryName = getLanguageName(communicationPreferences.get(0).getTertiaryLanguageId());
				}
				System.out.println(primName+"===="+secondName);
				jsonObject.put("primaryLanguage_Communication", primName);
				jsonObject.put("secondaryLanguage_Communication", secondName);
				jsonObject.put("tertiaryLanguage_Communication", tertiaryName);
				jsonObject.put("emailId_Communication", communicationPreferences.get(0).getEmailAddress());
				jsonObject.put("phoneNumber_Communication", communicationPreferences.get(0).getPhoneNumber());
				jsonObject.put("website_Communication", communicationPreferences.get(0).getWebsite());
				jsonObject.put("mobileNumber_Communication", communicationPreferences.get(0).getMobileNumber());
				System.out.println("Before==="+jsonObject);
			}
			System.out.println("After==="+jsonObject);
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