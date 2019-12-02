package com.collaborated.profile.edit.credentials.portlet;


import com.collaborated.entity.model.userCredential;
import com.collaborated.entity.service.userCredentialLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

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
		"javax.portlet.display-name=EditCredentials Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EditCredentialsPortlet extends MVCPortlet {
	final Log LOG = LogFactoryUtil.getLog(EditCredentialsPortlet.class);
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		System.out.println("resourceID" + resourceID);
		if (resourceID != null && resourceID.equals("saveCredentialsForm")) {
			saveCredentialsForm(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getCredentialData")){
			getCredentialData(resourceRequest,resourceResponse);
		}
	}
	
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
}