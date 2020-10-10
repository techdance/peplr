package com.collaborated.profile.collaborationinterests.portlet;

import com.collaborated.entity.model.labDetailedCourseHours;
import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.service.labDetailedCourseHoursLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil;
import com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil;
import com.collaborated.entity.service.projectInviteTrackingLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CollaborationInterests Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CollaborationInterestsPortlet extends MVCPortlet {
	
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		System.out.println("resourceID" + resourceID);
		if(resourceID != null && resourceID.equals("getCollaborationInterest")){
			getCollaborationInterest(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getViewMoreData")){
			getViewMoreData(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("goToMatchingScreen")){
			goToMatchingScreen(resourceRequest,resourceResponse);
		}
	}
	
	public void getCollaborationInterest(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		PrintWriter out = null;
		List<profileAreaofinterest> listData = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			
			long userId = 0;
			long selectedProfileMatching = 0;String isEdit = "Yes";
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
					isEdit = "No";
				}
			}
			if(selectedProfileMatching>0){
				userId = selectedProfileMatching;
			}else{
				userId = themeDisplay.getUserId();
			}
			
			System.out.println("userId==="+userId+"selectedProfileMatching==="+selectedProfileMatching);
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(profileAreaofinterest.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(userId));
			listData = profileAreaofinterestLocalServiceUtil.dynamicQuery(dynamicQuery);
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(listData.size()>0){
				for(profileAreaofinterest pa:listData){
					boolean startProject = false;
					boolean projectStarted = false;
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("projectType", pa.getProjectType());
					jsonObject.put("discipline", pa.getDiscipline1());
					jsonObject.put("region", pa.getLocation1());
					jsonObject.put("deliveryMethod", pa.getDeliveryMethod());
					jsonObject.put("language", pa.getLanguage());
					jsonObject.put("id", pa.getPK_areaofinterest());
					System.out.println("pa.getPK_areaofinterest()==="+pa.getPK_areaofinterest());
					DynamicQuery dynamicQueryTracking = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, PortalClassLoaderUtil.getClassLoader());
					dynamicQueryTracking.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("projectId",pa.getPK_areaofinterest()), RestrictionsFactoryUtil.eq("invitationStatus", "Accepted")));
					//dynamicQueryTracking.add(PropertyFactoryUtil.forName("projectId").eq(pa.getPK_areaofinterest()));
					List<projectInviteTracking> projectInviteTrackingList = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQueryTracking);
					System.out.println("projectInviteTrackingList.size()==="+projectInviteTrackingList.size());
					
					DynamicQuery dynamicQueryProjectCreated = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, PortalClassLoaderUtil.getClassLoader());
					dynamicQueryProjectCreated.add(PropertyFactoryUtil.forName("interestId").eq(pa.getPK_areaofinterest()));
					List<labScreenProjectOverview> labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(dynamicQueryProjectCreated); 
					
					if(projectInviteTrackingList.size()>0){
						 startProject = true; 
					}
					
					if(labScreenProjectOverview.size()>0){
						projectStarted = true;
					}
					
					jsonObject.put("startProject", startProject);
					jsonObject.put("projectStarted", projectStarted);
					jsonObject.put("isEdit", isEdit);
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
		String intercampus = "",deliveryMethod="";
		long key = ParamUtil.getLong(resourceRequest, "key");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			SimpleDateFormat displayFormat = new SimpleDateFormat("yyyy-MM-dd");
			singleData = profileAreaofinterestLocalServiceUtil.fetchprofileAreaofinterest(key);
			
			long selectedProfileMatching = 0;String isEdit = "Yes";
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
					isEdit = "No";
				}
			}
			
			if(singleData!=null){
				if(singleData.getCampus().equalsIgnoreCase("1")){
					intercampus = "Intracampus";
				}else if(singleData.getCampus().equalsIgnoreCase("2")){
					intercampus = "Intercampus";
				}
				deliveryMethod = singleData.getDeliveryMethod();
				if(singleData.getDeliveryMethod().equalsIgnoreCase("Blended or Hybrid")){
					deliveryMethod = "Blended";
				}
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("projectType", singleData.getProjectType());
				jsonObject.put("collaborationType", singleData.getCollaborationType());
				jsonObject.put("deliveryMethod", deliveryMethod);
				jsonObject.put("discipline1", singleData.getDiscipline1());
				jsonObject.put("discipline2", singleData.getDiscipline2());
				jsonObject.put("discipline3", singleData.getDiscipline3());
				jsonObject.put("description", singleData.getDescription());
				jsonObject.put("campus", intercampus);
				jsonObject.put("programLevel", singleData.getProgramLevel());
				jsonObject.put("programLength", singleData.getProgramLength());
				jsonObject.put("credits", singleData.getCredits());
				jsonObject.put("language", singleData.getLanguage());
				jsonObject.put("region1", singleData.getLocation1());
				jsonObject.put("region2", singleData.getLocation2());
				jsonObject.put("region3", singleData.getLocation3());
				jsonObject.put("region4", singleData.getLocation4());
				jsonObject.put("created", displayFormat.format(singleData.getCreateDate()));
				jsonObject.put("startMonth", singleData.getRangerMonthStart());
				jsonObject.put("endMonth", singleData.getRangerMonthEnd());
				jsonObject.put("startYear", singleData.getRangerYearStart());
				jsonObject.put("endYear", singleData.getRangerYearEnd());
				jsonObject.put("PK_areaofinterest", singleData.getPK_areaofinterest());
				if(selectedProfileMatching>0){
					jsonObject.put("matchButton",false);
				}else{
					jsonObject.put("matchButton",true);
				}
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
	     	System.out.println("selectedProject===="+portletSession.getAttribute("selectedProject", PortletSession.APPLICATION_SCOPE));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
}