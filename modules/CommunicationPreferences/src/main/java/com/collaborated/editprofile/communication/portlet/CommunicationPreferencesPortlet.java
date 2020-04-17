package com.collaborated.editprofile.communication.portlet;

import com.collaborated.entity.model.communicationPreferences;
import com.collaborated.entity.service.communicationPreferencesLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CommunicationPreferences Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CommunicationPreferencesPortlet extends MVCPortlet {
	final Log LOG = LogFactoryUtil.getLog(CommunicationPreferencesPortlet.class);
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		JSONArray listArray = getLanguageList();
		renderRequest.setAttribute("languageList", listArray);
		//System.out.println(listArray);
		super.doView(renderRequest, renderResponse); // make sure this is the last line in your method
	}
	
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

	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		System.out.println("resourceID" + resourceID);
		if (resourceID != null && resourceID.equals("savecommunicationForm")) {
			saveCommunicationPreferences(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("callApi")) {
			//getUserData(resourceRequest,resourceResponse);
		}
	}
	
/*	private void getLanguageName(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {
		long primaryLanguageID = ParamUtil.getLong(resourceRequest, "primaryLanguage");
		long secondaryLanguageID = ParamUtil.getLong(resourceRequest, "secondaryLanguage");
		long tertiaryLanguageID = ParamUtil.getLong(resourceRequest, "tertiaryLanguage");
		
		PortletSession portletSession = resourceRequest.getPortletSession();
		portletSession.setAttribute("primaryLanguageID", primaryLanguageID, PortletSession.APPLICATION_SCOPE);
		portletSession.setAttribute("secondaryLanguageID", secondaryLanguageID, PortletSession.APPLICATION_SCOPE);
		portletSession.setAttribute("tertiaryLanguageID", tertiaryLanguageID, PortletSession.APPLICATION_SCOPE);
		
		JSONArray jsonArray = getLanguageList();
		for (int i = 0; i < jsonArray.length(); i++) {
		    JSONObject obj= jsonArray.getJSONObject(i);
		    if(primaryLanguageID!=0 && obj.getLong("languageId")==primaryLanguageID)
		    {
		    	obj.remove(String.valueOf(primaryLanguageID));
		        // add this item in some collection i.e PublishedList, and later use this collection
		    }
		    if(secondaryLanguageID!=0 && obj.getLong("languageId")==secondaryLanguageID)
		    {
		    	obj.remove(String.valueOf(secondaryLanguageID));
		        // add this item in some collection i.e PublishedList, and later use this collection
		    }
		    if(tertiaryLanguageID!=0 && obj.getLong("languageId")==tertiaryLanguageID)
		    {
		    	obj.remove(String.valueOf(tertiaryLanguageID));
		        // add this item in some collection i.e PublishedList, and later use this collection
		    }
		    System.out.println(jsonArray);
		}
	}*/
	
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
		String phoneNumber = ParamUtil.getString(resourceRequest, "communicationPhoneNumber");
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
}