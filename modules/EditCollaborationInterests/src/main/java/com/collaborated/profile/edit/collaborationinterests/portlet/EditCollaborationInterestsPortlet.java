package com.collaborated.profile.edit.collaborationinterests.portlet;

import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil;
import com.collaborated.entity.service.profileAreaofinterestServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
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
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EditCollaborationInterests Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EditCollaborationInterestsPortlet extends MVCPortlet {
	final Log LOG = LogFactoryUtil.getLog(EditCollaborationInterestsPortlet.class);
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		System.out.println("resourceID" + resourceID);
		if (resourceID != null && resourceID.equals("saveCollaborationInterest")) {
			saveCollaborationInterest(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getCollaborationInterest")){
			getCollaborationInterest(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getViewMoreData")){
			getViewMoreData(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("goToMatchingScreen")){
			goToMatchingScreen(resourceRequest,resourceResponse);
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
			profileAreaofinterest.setDiscipline1(discipline);
			profileAreaofinterest.setLanguage(preferredLanguage);
			profileAreaofinterest.setLocation1(location);
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
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(listData.size()>0){
				for(profileAreaofinterest pa:listData){
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("projectType", pa.getProjectType());
					jsonObject.put("discipline", pa.getDiscipline1());
					jsonObject.put("region", pa.getLocation1());
					jsonObject.put("deliveryMethod", pa.getDeliveryMethod());
					jsonObject.put("id", pa.getPK_areaofinterest());
					jsonArray.put(jsonObject);
				}
			}
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
		String intercampus = "";
		long key = ParamUtil.getLong(resourceRequest, "key");
		
		try{
			out = resourceResponse.getWriter();
			singleData = profileAreaofinterestLocalServiceUtil.fetchprofileAreaofinterest(key);
			if(singleData!=null){
				if(singleData.getCampus().equalsIgnoreCase("1")){
					intercampus = "Intracampus";
				}else if(singleData.getCampus().equalsIgnoreCase("2")){
					intercampus = "Intercampus";
				}
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("projectType", singleData.getProjectType());
				jsonObject.put("deliveryMethod", singleData.getDeliveryMethod());
				jsonObject.put("discipline", singleData.getDiscipline1());
				jsonObject.put("description", singleData.getDescription());
				jsonObject.put("campus", intercampus);
				jsonObject.put("programLevel", singleData.getProgramLevel());
				jsonObject.put("programLength", singleData.getProgramLength());
				jsonObject.put("credits", singleData.getCredits());
				jsonObject.put("language", singleData.getLanguage());
				jsonObject.put("region", singleData.getLocation1());
				jsonObject.put("PK_areaofinterest", singleData.getPK_areaofinterest());
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
	
}