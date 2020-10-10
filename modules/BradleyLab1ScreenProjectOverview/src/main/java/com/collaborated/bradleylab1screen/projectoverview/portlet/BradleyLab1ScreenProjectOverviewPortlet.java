package com.collaborated.bradleylab1screen.projectoverview.portlet;

import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.labScreenTask;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.labScreenTaskLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
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
		"javax.portlet.display-name=BradleyLab1ScreenProjectOverview Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BradleyLab1ScreenProjectOverviewPortlet extends MVCPortlet {
	private long PK_projectId = new Long(1001); 
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		
		PortletSession session = renderRequest.getPortletSession();
		String projectId = (String)session.getAttribute("PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
		PK_projectId = new Long(projectId);
		List<labScreenProjectPartners> partnersList = getPartnerList();
		session.setAttribute("projectList", new Long(projectId), PortletSession.APPLICATION_SCOPE);
		session.setAttribute("partnerList", partnersList, PortletSession.APPLICATION_SCOPE);
		//System.out.println((long)session.getAttribute("projectList", PortletSession.APPLICATION_SCOPE));
		super.doView(renderRequest, renderResponse); // make sure this is the last line in your method
	}
	
	public List<labScreenProjectPartners> getPartnerList(){
		List<labScreenProjectPartners> partnersList = null;
	//	ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,"portletClassLoader");
	//	ClassLoader classLoader = ClassLoaderUtil.getClassLoader(labScreenProjectPartners.class);
	//	ClassLoader classLoader =(ClassLoader) PortletBeanLocatorUtil.locate("entityMaster-api", "portletClassLoader");
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());
		 
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("PK_projectId", PK_projectId);
		 
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("isActive", new Long(0)));
		dynamicQuery.add(criterion);
		 
		partnersList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("partnersList=="+partnersList);
		return partnersList;
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if (resourceID != null && resourceID.equals("moveDetailedScreen")) {
			moveDetailedScreen(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getProjectPercentage")) {
			getProjectPercentage(resourceRequest,resourceResponse);
		}
	}
	
	public void moveDetailedScreen(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;
		List<labScreenTask> listData = null;boolean isNotLink = false;
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenTask.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			listData = labScreenTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(listData.size()>0){		
				for(labScreenTask singleData:listData){
					if(!(singleData.getTaskStatus().equalsIgnoreCase("Completed"))){
						isNotLink = true;
						break;
					}
				}
			}
			
			out.print(isNotLink);
		}catch(Exception e){
			
		}
	}
	
	public void getProjectPercentage(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		PrintWriter out = null;
		List<labScreenTask> listData = null;long percentage = 0;
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenTask.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(Long.valueOf(PK_projectId)));
			listData = labScreenTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(listData.size()>0){
				for(labScreenTask singleData:listData){
					if(singleData.getTaskName().equalsIgnoreCase("Refine Course Identification") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Determine Course Hours") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Identify Course Resources") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Add Instructor Qualifications") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Review Course Topics") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Evaluate Course Objectives") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Identify Learning Environments") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Add Course Objectives to Weeks") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Associate Learning Environment Design with Objectives") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Add Week Activities") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Identify Content for Course Objectives") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 10;
					}
				}
				
			}
			out.print(percentage);
		}catch(Exception e){
			
		}
	}
}