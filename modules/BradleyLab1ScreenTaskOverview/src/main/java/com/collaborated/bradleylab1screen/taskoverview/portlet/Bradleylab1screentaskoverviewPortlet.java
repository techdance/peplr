package com.collaborated.bradleylab1screen.taskoverview.portlet;

import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.labScreenTask;
import com.collaborated.entity.model.userInstitutionProfileDetails;
import com.collaborated.entity.service.labScreenTaskLocalServiceUtil;
import com.collaborated.entity.service.userInstitutionProfileDetailsLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
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

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BradleyLab1ScreenTaskOverview Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Bradleylab1screentaskoverviewPortlet extends MVCPortlet {
	final Log LOG = LogFactoryUtil.getLog(Bradleylab1screentaskoverviewPortlet.class);
	long PK_projectId = 0;
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		PortletSession session = renderRequest.getPortletSession();
		List<labScreenProjectPartners> partnersList = (List<labScreenProjectPartners>) session.getAttribute("partnerList", PortletSession.APPLICATION_SCOPE);
		renderRequest.setAttribute("projectPartnersList", partnersList);
		PK_projectId = (long)session.getAttribute("projectList", PortletSession.APPLICATION_SCOPE);
		super.doView(renderRequest, renderResponse); // make sure this is the last line in your method
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if (resourceID != null && resourceID.equals("addTask")) {
			addTask(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("viewTask")) {
			viewTask(resourceRequest,resourceResponse);
		}
	}
	
	public void addTask(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		String taskName = ParamUtil.getString(uploadRequest, "taskName");
		long assignedTo = ParamUtil.getLong(uploadRequest, "projectAssignedTo");
		String dueDate = ParamUtil.getString(uploadRequest, "dueDate");
		//Date dueDate = ParamUtil.getDate(resourceRequest, "", "mm-dd-yyyy");
		PrintWriter out = null;
		labScreenTask labScreenTask = null;
		try{
			labScreenTask = labScreenTaskLocalServiceUtil.createlabScreenTask(CounterLocalServiceUtil.increment());
			labScreenTask.setTaskName(taskName);
			labScreenTask.setTaskStatus("In Progress");
			labScreenTask.setDueDate(dueDate);
			labScreenTask.setUserId(themeDisplay.getUserId());
			labScreenTask.setCreateDate(new Date());
			labScreenTask.setProjectAssignedTo(assignedTo);
			labScreenTask.setPK_projectId(PK_projectId);
			labScreenTaskLocalServiceUtil.addlabScreenTask(labScreenTask);
			out = resourceResponse.getWriter();
			out.print("add");
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void viewTask(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;
		List<labScreenTask> listData = null;
		String template="";
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenTask.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			listData = labScreenTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(listData.size()>0){		
				for(labScreenTask singleData:listData){
					template = template + "<tr>"
							+ "<td align='center'> <i class='fas fa-sync fa-2x color-blue'></i> </td>"
							+ "<td>"+ singleData.getTaskName() +"</td>"
							+ "<td><strong class='color-black'>"+ singleData.getTaskStatus() +"</strong></td>"
							+ "<td>"+ UserLocalServiceUtil.getUser(singleData.getUserId()).getFullName() +"</td>"
							+ "<td>"+ singleData.getDueDate() +"</td>"
							+ "<td> <img class='ml-4' src='/o/ahea-theme/images/icon-sms.png'> 2 </td>"
							+ "</tr>";
				}
			}
			out.print(template);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
}