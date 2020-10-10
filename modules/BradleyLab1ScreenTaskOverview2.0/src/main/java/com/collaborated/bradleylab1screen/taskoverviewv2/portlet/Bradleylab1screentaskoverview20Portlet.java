package com.collaborated.bradleylab1screen.taskoverviewv2.portlet;

import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.labScreenTask;
import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.labScreenTaskLocalServiceUtil;
import com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil;
import com.collaborated.entity.service.projectInviteTrackingLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
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
		"javax.portlet.display-name=BradleyLab1ScreenTaskOverview2.0 Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		/*"com.liferay.portlet.private-session-attributes=false",*/
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Bradleylab1screentaskoverview20Portlet extends MVCPortlet {
	final Log LOG = LogFactoryUtil.getLog(Bradleylab1screentaskoverview20Portlet.class);
	long PK_projectId = 0;long interestId = 0;long projectOwnerId = 0;
	List<labScreenProjectPartners> partnersList = null;
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		PortletSession session = renderRequest.getPortletSession();
		labScreenProjectOverview labScreenProjectOverview = null;
		//session.setAttribute("projectList", new Long(1001), PortletSession.APPLICATION_SCOPE);
		/*String projectId = (String)session.getAttribute("PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
		System.out.println("projectId==="+projectId);
		PK_projectId = new Long(projectId);
		
		
		labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(PK_projectId);
		if(labScreenProjectOverview!=null){
			interestId = labScreenProjectOverview.getInterestId();
			projectOwnerId = labScreenProjectOverview.getProjectOwnerId();
		}
		DynamicQuery dynamicQueryPartnerList = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());	 
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("PK_projectId", interestId);		 
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("isActive", new Long(0)));
		dynamicQueryPartnerList.add(criterion);
		 
		partnersList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQueryPartnerList);
		renderRequest.setAttribute("projectPartnersList", partnersList);*/
		//PK_projectId = 1001;
		
		/*ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenTask.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
		dynamicQuery.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("userId",Long.valueOf(themeDisplay.getUserId())),RestrictionsFactoryUtil.eq("milestoneName", milestoneNameDB)));
		listData = labScreenTaskLocalServiceUtil.dynamicQuery(dynamicQuery);*/
		
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
		}else if(resourceID != null && resourceID.equals("getViewTask")){
			getViewTask(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("statusChangeTask")){
			statusChangeTask(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("projectAssignedTask")){
			projectAssignedTask(resourceRequest,resourceResponse);
		}else if(resourceID !=null && resourceID.equals("removeTask")){
			removeTask(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("dueDateChangeTask")){
			dueDateChangeTask(resourceRequest,resourceResponse);
		}
	}
	
	public void addTask(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		String taskName = ParamUtil.getString(uploadRequest, "taskName");
		long assignedTo = ParamUtil.getLong(uploadRequest, "projectAssignedTo");
		String dueDate = ParamUtil.getString(uploadRequest, "dueDate");
		String milestoneNameDB = ParamUtil.getString(uploadRequest, "milestoneName");
		long taskId = ParamUtil.getLong(uploadRequest, "taskId");
		//Date dueDate = ParamUtil.getDate(resourceRequest, "", "mm-dd-yyyy");
		PrintWriter out = null;//String milestoneNameDB = "";
		labScreenTask labScreenTask = null;
		try{
			out = resourceResponse.getWriter();
			/*if(milestoneName==0){
				milestoneNameDB = "Course Information";
			}else if(milestoneName==33){
				milestoneNameDB = "Course Design";
			}else if(milestoneName==66){
				milestoneNameDB = "Activity Table";
			}else if(milestoneName==100){
				milestoneNameDB = "Course Summary";
			}*/
			
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
			String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
			long PK_projectId = new Long(0);
			long PK_interestId = new Long(0);
			long currentUser = (Long)httpsession.getAttribute("currentUser");		
			if(currentUser==themeDisplay.getUserId()){
				PK_projectId = new Long(sessionProjectID);	
				PK_interestId = new Long(sessionInterestID);
			}
			
			if(taskId!=0){
				labScreenTask = labScreenTaskLocalServiceUtil.getlabScreenTask(taskId);
				labScreenTask.setTaskName(taskName);
				labScreenTask.setDueDate(dueDate);
				labScreenTask.setUserId(themeDisplay.getUserId());
				labScreenTask.setModifiedDate(new Date());
				labScreenTask.setProjectAssignedTo(assignedTo);
				labScreenTask.setPK_projectId(PK_projectId);
				labScreenTask.setMilestoneName(milestoneNameDB);
				labScreenTaskLocalServiceUtil.updatelabScreenTask(labScreenTask);
				out.print("update");
			}else{
				labScreenTask = labScreenTaskLocalServiceUtil.createlabScreenTask(CounterLocalServiceUtil.increment());
				labScreenTask.setTaskName(taskName);
				labScreenTask.setTaskStatus("To do");
				labScreenTask.setDueDate(dueDate);
				labScreenTask.setUserId(themeDisplay.getUserId());
				labScreenTask.setCreateDate(new Date());
				labScreenTask.setProjectAssignedTo(assignedTo);
				labScreenTask.setPK_projectId(PK_projectId);
				labScreenTask.setMilestoneName(milestoneNameDB);
				labScreenTaskLocalServiceUtil.addlabScreenTask(labScreenTask);
				out.print("add");
			}				
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
		String milestoneNameDB = ParamUtil.getString(resourceRequest, "milestoneName");
		List<labScreenTask> listData = null;boolean isNotLink = false;boolean addTask = false;
		String template="";String selectedValueCmpleted = "",selectedValueProgress="",selectedValueToDo = "";
		String userSelected = "";//String milestoneNameDB = "";
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		labScreenProjectOverview labScreenProjectOverview = null;
		List<labScreenProjectOverview> labScreenProjectOverviewPartners = null;
		try{
			out = resourceResponse.getWriter();
			/*if(milestoneName==0){
				milestoneNameDB = "Course Information";
			}else if(milestoneName==33){
				milestoneNameDB = "Course Design";
			}else if(milestoneName==66){
				milestoneNameDB = "Activity Table";
			}else if(milestoneName==100){
				milestoneNameDB = "Course Summary";
			}*/
			
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
			String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
			long PK_projectId = new Long(0);
			long PK_interestId = new Long(0);
			long currentUser = (Long)httpsession.getAttribute("currentUser");		
			if(currentUser==themeDisplay.getUserId()){
				PK_projectId = new Long(sessionProjectID);	
				PK_interestId = new Long(sessionInterestID);
			}
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenTask.class, PortalClassLoaderUtil.getClassLoader());
			//dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			dynamicQuery.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("PK_projectId",Long.valueOf(PK_projectId)),RestrictionsFactoryUtil.eq("milestoneName", milestoneNameDB)));
			listData = labScreenTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println(listData.size());
			System.out.println("milestoneNameDB==="+milestoneNameDB);
			//Adding static tasks
			if(listData.size()>0){		
				for(labScreenTask singleData:listData){	
					addTask = false;
					if(milestoneNameDB.equalsIgnoreCase("Course Information") && ((singleData.getTaskName().equalsIgnoreCase("Refine Course Identification")) || (singleData.getTaskName().equalsIgnoreCase("Determine Course Hours"))
							|| (singleData.getTaskName().equalsIgnoreCase("Identify Course Resources")) || (singleData.getTaskName().equalsIgnoreCase("Add Instructor Qualifications")))){
						addTask =  true;
						break;
					}else if(milestoneNameDB.equalsIgnoreCase("Course Design") && ((singleData.getTaskName().equalsIgnoreCase("Review Course Topics"))
							|| (singleData.getTaskName().equalsIgnoreCase("Evaluate Course Objectives")) || (singleData.getTaskName().equalsIgnoreCase("Identify Learning Environments")))){
						addTask =  true;
						break;
					}else if (milestoneNameDB.equalsIgnoreCase("Activity Table") && ((singleData.getTaskName().equalsIgnoreCase("Add Course Objectives to Weeks")) || (singleData.getTaskName().equalsIgnoreCase("Associate Learning Environment Design with Objectives"))
							|| (singleData.getTaskName().equalsIgnoreCase("Add Week Activities")) || (singleData.getTaskName().equalsIgnoreCase("Identify Content for Course Objectives")))){
						addTask =  true;
						break;
					} 
					
					/*if(milestoneNameDB.equalsIgnoreCase("Course Information") && (!(singleData.getTaskName().equalsIgnoreCase("Refine Course Identification")))){
						addTask =  true;
						break;
					}else if(milestoneNameDB.equalsIgnoreCase("Course Design") && (!(singleData.getTaskName().equalsIgnoreCase("Review Course Topics")))){
						addTask =  true;
						break;
					}else if (milestoneNameDB.equalsIgnoreCase("Activity Table") && (!(singleData.getTaskName().equalsIgnoreCase("Add Course Objectives to Weeks")))){
						addTask =  true;
						break;
					}*/
				}
			}
			if(milestoneNameDB.equalsIgnoreCase("Course Summary")){
				addTask =  true;
			}	
			if(addTask==false){
				String[] taskArray1 = {"Refine Course Identification","Determine Course Hours","Identify Course Resources","Add Instructor Qualifications"};
				String[] taskArray2 = {"Review Course Topics","Evaluate Course Objectives","Identify Learning Environments"};
				String[] taskArray3 = {"Add Course Objectives to Weeks","Associate Learning Environment Design with Objectives","Add Week Activities","Identify Content for Course Objectives"};
				String[] globalArray = null;
				//iterating all elements in the array
				if(milestoneNameDB.equalsIgnoreCase("Course Information")){
					globalArray = taskArray1;
				}else if(milestoneNameDB.equalsIgnoreCase("Course Design")){
					globalArray = taskArray2;
				}else if(milestoneNameDB.equalsIgnoreCase("Activity Table")){
					globalArray = taskArray3;
				}
				if(globalArray.length>0){
					for (int i = 0; i < globalArray.length; i++) {
						long interestId = 0;
						labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(PK_projectId);
						if(labScreenProjectOverview!=null){
							interestId = labScreenProjectOverview.getInterestId();
						}
						labScreenTask labScreenTaskAdd = labScreenTaskLocalServiceUtil.createlabScreenTask(CounterLocalServiceUtil.increment());
						labScreenTaskAdd.setTaskName(globalArray[i]);
						labScreenTaskAdd.setTaskStatus("To do");
						labScreenTaskAdd.setDueDate("");
						labScreenTaskAdd.setUserId(themeDisplay.getUserId());
						labScreenTaskAdd.setCreateDate(new Date());
						labScreenTaskAdd.setProjectAssignedTo(0);
						labScreenTaskAdd.setPK_projectId(PK_projectId);
						labScreenTaskAdd.setMilestoneName(milestoneNameDB);
						labScreenTaskLocalServiceUtil.addlabScreenTask(labScreenTaskAdd);
					}
				}
			}
			
			DynamicQuery dynamicQueryTask = DynamicQueryFactoryUtil.forClass(labScreenTask.class, PortalClassLoaderUtil.getClassLoader());
			//dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			dynamicQueryTask.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("PK_projectId",Long.valueOf(PK_projectId)),RestrictionsFactoryUtil.eq("milestoneName", milestoneNameDB)));
			listData = labScreenTaskLocalServiceUtil.dynamicQuery(dynamicQueryTask);
			System.out.println("listData==="+listData.size());
			if(listData.size()>0){		
				for(labScreenTask singleData:listData){
					selectedValueCmpleted = "";selectedValueProgress = "";selectedValueToDo = "";
					if(singleData.getTaskStatus().equalsIgnoreCase("To do")){
						selectedValueToDo = "selected";
					}
					else if(singleData.getTaskStatus().equalsIgnoreCase("In Progress")){
						selectedValueProgress = "selected";
					}
					else if(singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						selectedValueCmpleted = "selected";
					}
					String optionList = "";
					
					
					DynamicQuery dynamicQueryPartnerList = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());	 
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("PK_projectId", PK_interestId);		 
					criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("isActive", new Long(0)));
					dynamicQueryPartnerList.add(criterion);
					 
					partnersList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQueryPartnerList);
					long inviteFrom = 0;
					if(partnersList.size()>0){ 
						/*DynamicQuery dynamicQueryResources = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, PortalClassLoaderUtil.getClassLoader());
						dynamicQueryResources.add(PropertyFactoryUtil.forName("interestId").eq(partnersList.get(0).getPK_projectId()));
						labScreenProjectOverviewPartners = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(dynamicQueryResources);*/
						inviteFrom = partnersList.get(0).getUserId();
						for(labScreenProjectPartners p:partnersList){
							if(p.getProjectPartnerId()>0){
								String fullName = UserLocalServiceUtil.getUser(p.getProjectPartnerId()).getFullName();
								userSelected = (p.getProjectPartnerId()==singleData.getProjectAssignedTo())?"selected":"";
								optionList = optionList + "<option value='"+p.getProjectPartnerId()+"' "+userSelected+">"+fullName+"</option>";
							}														
						} 
						if(inviteFrom>0){
							String fullName = UserLocalServiceUtil.getUser(inviteFrom).getFullName();
							userSelected = (inviteFrom==singleData.getProjectAssignedTo())?"selected":"";
							optionList = optionList + "<option value='"+inviteFrom+"' "+userSelected+">"+fullName+"</option>";
						}
					}
					
					String taskAction = "<td class='td-valign-top'> "
							+ "<div class='td-label'>Actions</div> "
							+ "<div class='td-text'> "
							+ "<a href='javascript:void(0);' class='btn btn-blue btn-w-100 btn-sm mr-1' onclick='getViewData("+singleData.getPK_taskId()+")'>Edit</a> "
							+ "<a class='btn btn-grey btn-w-100 btn-sm' href='javascript:void(0);' onclick='removeData("+singleData.getPK_taskId()+")'>Remove</a> "
							+ "</div> "
							+ "</td> ";
					if(singleData.getTaskName().equalsIgnoreCase("Refine Course Identification") || singleData.getTaskName().equalsIgnoreCase("Determine Course Hours") 
							|| singleData.getTaskName().equalsIgnoreCase("Identify Course Resources") || singleData.getTaskName().equalsIgnoreCase("Add Instructor Qualifications")
							|| singleData.getTaskName().equalsIgnoreCase("Review Course Topics") || singleData.getTaskName().equalsIgnoreCase("Evaluate Course Objectives") || singleData.getTaskName().equalsIgnoreCase("Identify Learning Environments")
							|| singleData.getTaskName().equalsIgnoreCase("Add Course Objectives to Weeks") || singleData.getTaskName().equalsIgnoreCase("Associate Learning Environment Design with Objectives")
							|| singleData.getTaskName().equalsIgnoreCase("Add Week Activities") || singleData.getTaskName().equalsIgnoreCase("Identify Content for Course Objectives")){
						taskAction = "";
					}
					
					template = template + "<tr>"
							+ "<td class='td-valign-bottom td-icon-arrow td-icon-arrow'><i class='fas fa-chevron-circle-right color-orange fa-2x'></i></td> "
							+ "<td class='td-valign-top'> "
							+ "<div class='td-label'>Task</div> "
							+ "<div class='td-text pt-1'> "+ singleData.getTaskName() +" </div> "
							+ "</td> "
							+ "<td class='td-valign-top'> "
							+ "<div class='td-label'>Status</div> "
							+ "<div class='td-text'> "
							+ "<div class='form-group'> "
							+ "<select class='form-control' id='projectStatus' onchange='statusChange(this.value,"+singleData.getPK_taskId()+")' > "
							+ "<option value=''>Select</option> "
							+ "<option value='To do' "+selectedValueToDo+">To Do</option> "
							+ "<option value='In Progress' "+selectedValueProgress+">In Progress</option> "
							+ "<option value='Completed' "+selectedValueCmpleted+">Completed</option> "
							+ "</select> "
							+ "</div> "
							+ "</div> "
							+ "</td> "
							+ "<td class='td-valign-top'> "
							+ "<div class='td-label'>Assigned</div> "
							+ "<div class='td-text'> "
							+ "<div class='form-group'> "
							+ "<select class='form-control' id='projectAssignedTo' onchange='projectAssignedToChange(this.value,"+singleData.getPK_taskId()+")'> "
							+ "<option value=''>Select</option> "  
							+ optionList
							+ "</select> "
							+ "</div> "
							+ "</div> "
							+ "</td> "
							+ "<td class='td-valign-top' width='180'> "
							+ "<div class='td-label'>Due Date</div> "
							+ "<div class='td-text'> "
							+ "<div class='form-group wrap-input-calendar'><input type='text' onchange='dueDateChange(this.value,"+singleData.getPK_taskId()+")' value='"+singleData.getDueDate()+"' placeholder='YYYY-MM-DD' class='wrap-input form-control input icon-cal dueDate' autocomplete='off' required='true' onkeydown='return false' /></div> "
							+ "</div> "
							+ "</td> "
							/*+ "<td class='td-valign-top'> "
							+ "<div class='td-label'>Assets</div> "
							+ "<div class='td-text d-flex'> "
							+ "<span class='icon-com-clip mr-2'><i class='fal fa-comment-alt-lines'></i> 2</span> "
							+ "<span class='icon-com-clip'><i class='fal fa-paperclip'></i> 1</span> "
							+ "</div> "
							+ "</td> "*/							
							+ taskAction
							+ "</tr>";
					
					
				}
				
				for(labScreenTask singleData:listData){
					if(!(singleData.getTaskStatus().equalsIgnoreCase("Completed"))){
						isNotLink = true;
						break;
					}
				}
			}
			jsonObject.put("template", template);
			jsonObject.put("isNotLink", isNotLink);
			out.print(jsonObject.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	public void getViewTask(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject jsonObject = null;
		labScreenTask labScreenTask = null;
		PrintWriter out = null;
		long PK_taskId = ParamUtil.getLong(resourceRequest, "taskId");
		try{
			out = resourceResponse.getWriter();
			labScreenTask = labScreenTaskLocalServiceUtil.getlabScreenTask(PK_taskId);
			if(labScreenTask!=null){
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("taskId", labScreenTask.getPK_taskId());
				jsonObject.put("taskName", labScreenTask.getTaskName());
				jsonObject.put("projectAssignedTo", labScreenTask.getProjectAssignedTo());
				jsonObject.put("dueDate", labScreenTask.getDueDate());
				out.print(jsonObject);
			}
		}catch(Exception e){
			
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void statusChangeTask(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		long PK_taskId = ParamUtil.getLong(resourceRequest, "taskId");
		String taskStatus = ParamUtil.getString(resourceRequest, "status");
		PrintWriter out = null;
		labScreenTask labScreenTask = null;
		labScreenProjectOverview labScreenProjectOverview = null;
		String projectName = "";long interestId = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = null;
		try{
			out = resourceResponse.getWriter();
			labScreenTask = labScreenTaskLocalServiceUtil.getlabScreenTask(PK_taskId);
			if(labScreenTask!=null){
				if(labScreenTask.getProjectAssignedTo()!=0){
					labScreenTask.setTaskStatus(taskStatus);
					labScreenTaskLocalServiceUtil.updatelabScreenTask(labScreenTask);
				
					if(labScreenTask.getPK_projectId()!=0){
						labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(labScreenTask.getPK_projectId());
						projectName = labScreenProjectOverview.getProjectName();
						interestId = labScreenProjectOverview.getInterestId();
					}
				
					if(taskStatus.equalsIgnoreCase("Completed")){
						projectInviteTracking projectInviteTracking = projectInviteTrackingLocalServiceUtil.createprojectInviteTracking(CounterLocalServiceUtil.increment());
						projectInviteTracking.setProjectId(PK_projectId);
						projectInviteTracking.setInviteFrom(themeDisplay.getUserId());
						projectInviteTracking.setInviteTo(labScreenTask.getProjectAssignedTo());
						projectInviteTracking.setInvitationStatus("");
						projectInviteTracking.setIsRead(0);
						projectInviteTracking.setIsRemoved(4);
						projectInviteTracking.setMessageContent(themeDisplay.getUser().getFullName() + " completed " + labScreenTask.getTaskName() + " in " +projectName + " project");
						projectInviteTracking.setCreateDate(new Date());
						projectInviteTrackingLocalServiceUtil.addprojectInviteTracking(projectInviteTracking);
					}
					out.print("update");
				}else{
					out.print("not update");
				}
			}
			
		}catch(Exception e){
			
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void projectAssignedTask(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		long PK_taskId = ParamUtil.getLong(resourceRequest, "taskId");
		long taskAssigned = ParamUtil.getLong(resourceRequest, "projectAssigned");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;
		labScreenTask labScreenTask = null;
		labScreenProjectOverview labScreenProjectOverview = null;
		String projectName = "";long interestId = 0;String message = "error";
		try{
			out = resourceResponse.getWriter();
			labScreenTask = labScreenTaskLocalServiceUtil.getlabScreenTask(PK_taskId);
			if(labScreenTask!=null){
				if(labScreenTask.getPK_projectId()!=0){
					labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(labScreenTask.getPK_projectId());
					projectName = labScreenProjectOverview.getProjectName();
					interestId = labScreenProjectOverview.getInterestId();
					if(labScreenProjectOverview.getProjectOwnerId()==themeDisplay.getUserId()){
						labScreenTask.setProjectAssignedTo(taskAssigned);
						labScreenTaskLocalServiceUtil.updatelabScreenTask(labScreenTask);
						message = "update";
					}else if(labScreenProjectOverview.getProjectOwnerId()!=themeDisplay.getUserId() && themeDisplay.getUserId()==taskAssigned){
						labScreenTask.setProjectAssignedTo(taskAssigned);
						labScreenTaskLocalServiceUtil.updatelabScreenTask(labScreenTask);
						message = "update";
					}
				}
				
				HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
				httprequest = PortalUtil.getOriginalServletRequest(httprequest);

				HttpSession httpsession = httprequest.getSession();
				String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
				String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
				long PK_projectId = new Long(sessionProjectID);
				long currentUser = (Long)httpsession.getAttribute("currentUser");		
				if(currentUser==themeDisplay.getUserId()){
					PK_projectId = new Long(sessionProjectID);				
				}
				
				if(taskAssigned!=themeDisplay.getUserId() && taskAssigned!=0){					
					projectInviteTracking projectInviteTracking = projectInviteTrackingLocalServiceUtil.createprojectInviteTracking(CounterLocalServiceUtil.increment());
					projectInviteTracking.setProjectId(PK_projectId);
					projectInviteTracking.setInviteFrom(themeDisplay.getUserId());
					projectInviteTracking.setInviteTo(taskAssigned);
					projectInviteTracking.setInvitationStatus("");
					projectInviteTracking.setIsRead(0);
					projectInviteTracking.setIsRemoved(4);
					projectInviteTracking.setMessageContent("You have a new task in "+projectName + " project");
					projectInviteTracking.setCreateDate(new Date());
					projectInviteTrackingLocalServiceUtil.addprojectInviteTracking(projectInviteTracking);
				}
				out.print(message);
			}
		}catch(Exception e){
			
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	private void removeTask(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException {
		long taskId = ParamUtil.getLong(resourceRequest, "taskId");
		PrintWriter out = null;
		try {
			out = resourceResponse.getWriter();
			if(taskId!=0){
				labScreenTaskLocalServiceUtil.deletelabScreenTask(taskId);
				out.print("removed");
			}
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void dueDateChangeTask(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		long PK_taskId = ParamUtil.getLong(resourceRequest, "taskId");
		String taskdueDate = ParamUtil.getString(resourceRequest, "taskdueDate");
		PrintWriter out = null;
		labScreenTask labScreenTask = null;
		try{
			out = resourceResponse.getWriter();
			labScreenTask = labScreenTaskLocalServiceUtil.getlabScreenTask(PK_taskId);
			if(labScreenTask!=null){
				labScreenTask.setDueDate(taskdueDate);
				labScreenTaskLocalServiceUtil.updatelabScreenTask(labScreenTask);
				out.print("update");
			}			
		}catch(Exception e){
			
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
}