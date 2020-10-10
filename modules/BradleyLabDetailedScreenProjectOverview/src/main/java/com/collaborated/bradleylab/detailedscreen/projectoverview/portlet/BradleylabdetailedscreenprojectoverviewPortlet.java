package com.collaborated.bradleylab.detailedscreen.projectoverview.portlet;

import com.collaborated.entity.exception.NoSuchlabDetailedCourseHoursException;
import com.collaborated.entity.exception.NoSuchlabDetailedCourseIdentificationException;
import com.collaborated.entity.exception.NoSuchlabDetailedCourseResourcesException;
import com.collaborated.entity.exception.NoSuchlabDetailedInstructorQualificationException;
import com.collaborated.entity.model.labDetailedActivityTable;
import com.collaborated.entity.model.labDetailedCourseHours;
import com.collaborated.entity.model.labDetailedCourseIdentification;
import com.collaborated.entity.model.labDetailedCourseObjectives;
import com.collaborated.entity.model.labDetailedCourseResources;
import com.collaborated.entity.model.labDetailedCourseTopics;
import com.collaborated.entity.model.labDetailedInstructorQualification;
import com.collaborated.entity.model.labDetailedLearningEnvironments;
import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.labScreenTask;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.service.labDetailedActivityTableLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseHoursLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseIdentificationLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseObjectivesLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseResourcesLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseTopicsLocalServiceUtil;
import com.collaborated.entity.service.labDetailedInstructorQualificationLocalServiceUtil;
import com.collaborated.entity.service.labDetailedLearningEnvironmentsLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.labScreenTaskLocalServiceUtil;
import com.collaborated.entity.service.projectInviteTrackingLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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

import javax.portlet.ActionRequest;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
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
		"javax.portlet.display-name=BradleyLabDetailedScreenProjectOverview Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		/*"com.liferay.portlet.private-session-attributes=false",*/
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BradleylabdetailedscreenprojectoverviewPortlet extends MVCPortlet {
	private long PK_projectId = new Long(0); 
	private long PK_courseId = new Long(0);
	private String sessionProjectID = "";
	private String sessionInterestID = "";
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		
		PortletSession session = renderRequest.getPortletSession();
		List<labDetailedCourseIdentification> courseIdentification = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//String projectId = (String)session.getAttribute("PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
		//String projectId = (String)getSessionAttr(PortalUtil.getHttpServletRequest(renderRequest),"LIFERAY_SHARED_PROJECT_KEY");
		//PK_projectId = new Long(projectId);
		List<labScreenProjectPartners> partnersList = getPartnerList(renderRequest);
		session.setAttribute("projectList", new Long(PK_projectId), PortletSession.APPLICATION_SCOPE);
		session.setAttribute("partnerList", partnersList, PortletSession.APPLICATION_SCOPE);
		
		HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(renderRequest);
		httprequest = PortalUtil.getOriginalServletRequest(httprequest);

		HttpSession httpsession = httprequest.getSession();
		sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
		sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
		PK_projectId = new Long(sessionProjectID);
		long currentUser = (Long)httpsession.getAttribute("currentUser");		
		if(currentUser==themeDisplay.getUserId()){
			PK_projectId = new Long(sessionProjectID);
		}
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labDetailedCourseIdentification.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
		courseIdentification = labDetailedCourseIdentificationLocalServiceUtil.dynamicQuery(dynamicQuery);
		PK_courseId = 0;
		
		if(courseIdentification.size()>0){
			PK_courseId = courseIdentification.get(0).getPK_courseId();
		}
		System.out.println("PK_courseId===detailed=="+PK_courseId);
		
		
		
		
		super.doView(renderRequest, renderResponse); // make sure this is the last line in your method
	}
	
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if (resourceID != null && resourceID.equals("courseIdentificationAddEdit")) {
			courseIdentificationAddEdit(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("courseHoursAddEdit")) {
			courseHoursAddEdit(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("courseResourcesAddEdit")) {
			courseResourcesAddEdit(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("courseInstructorQualificationAddEdit")) {
			courseInstructorQualificationAddEdit(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("courseSummaryAddEdit")) {
			courseSummaryAddEdit(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("viewCourseIdentification")){
			viewCourseIdentification(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("viewCourseHours")) {
			viewCourseHours(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("viewCourseResources")) {
			viewCourseResources(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("viewCourseInstructorQualification")) {
			viewCourseInstructorQualification(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("loadCourseInformation")) {
			try {
				loadCourseInformation(resourceRequest,resourceResponse);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (resourceID != null && resourceID.equals("donutPercentage")) {
			donutPercentage(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getProjectPercentage")) {
			getProjectPercentage(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getProjectPercentageLoad")) {
			getProjectPercentageLoad(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("saveActivityTable")){
			saveActivityTable(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("loadWeekWiseData")){
			loadWeekWiseData(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("loadWeekWiseDataMain")){
			loadWeekWiseDataMain(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("loadCourseTopics")){
			loadCourseTopics(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("loadCourseObjectives")){
			loadCourseObjectives(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("loadCourseLearningEnvironment")){
			loadCourseLearningEnvironment(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("courseTopicSave")){
			courseTopicSave(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("courseObjectiveSave")){
			courseObjectiveSave(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("courseLearningEnvironmentSave")){
			courseLearningEnvironmentSave(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("removeContent")){
			removeContent(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("courseTopicUpdate")){
			courseTopicUpdate(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("courseObjectiveUpdate")){
			courseObjectiveUpdate(resourceRequest,resourceResponse);
		}
		else if(resourceID != null && resourceID.equals("courseLearningEnvironmentUpdate")){
			courseLearningEnvironmentUpdate(resourceRequest,resourceResponse);
		}
	}
	
	public String getSessionAttr(HttpServletRequest request, String key){
		String value = "";
		try{
			System.out.println("key==="+key);
			value = (String)request.getSession().getAttribute(key);
			System.out.println("====> inside getUserID===>"+request.getSession().getAttribute(key));
		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}
	
	public List<labScreenProjectPartners> getPartnerList(RenderRequest renderRequest){
		List<labScreenProjectPartners> partnersList = null;
		labScreenProjectOverview labScreenProjectOverview = null;
		long interestId = 0;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(renderRequest);
		httprequest = PortalUtil.getOriginalServletRequest(httprequest);

		HttpSession httpsession = httprequest.getSession();
		String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
		String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
		long PK_projectId = new Long(sessionProjectID);
		long currentUser = (Long)httpsession.getAttribute("currentUser");		
		if(currentUser==themeDisplay.getUserId()){
			PK_projectId = new Long(sessionProjectID);				
		}
		
		labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(PK_projectId);
		if(labScreenProjectOverview!=null){
			interestId = labScreenProjectOverview.getInterestId();
		}
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());
		 
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("PK_projectId", new Long(interestId));
		 
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("isActive", new Long(0)));
		dynamicQuery.add(criterion);
		 
		partnersList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQuery);
		return partnersList;
	}
	
	public void loadCourseInformation(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortalException {
		labDetailedCourseIdentification labDetailedCourseIdentification = null;
		List<labDetailedCourseHours> labDetailedCourseHours = null;
		List<labDetailedCourseResources> labDetailedCourseResources = null;
		List<labDetailedInstructorQualification> labDetailedInstructorQualification = null;
		
		List<labDetailedCourseTopics> labDetailedCourseTopics = null;
		List<labDetailedCourseObjectives> labDetailedCourseObjectives = null;
		List<labDetailedLearningEnvironments> labDetailedLearningEnvironments = null;
		
		JSONArray topicArray = JSONFactoryUtil.createJSONArray();
		JSONArray objectiveArray = JSONFactoryUtil.createJSONArray();
		JSONArray envArray = JSONFactoryUtil.createJSONArray();
		
		JSONArray jsonArray = null;
		JSONObject jsonObject = null;
		PrintWriter out = null;
		long courseIdentificationId=0, courseHoursId=0, courseResourcesId=0, courseInstId=0;
		String courseTitle="",courseNumber="",prerequisites="",courseDescription="";
		long numberOfCredits=0,numberOfCourseWeeks=0,courseHoursPerWeek=0,lectureHoursPerWeek=0,labHoursPerWeek=0,studyHoursPerWeek=0,contactHours=0;
		String textbookTitle = "",publisherName = "", author = "", ISBN = "";
		String instructor1Qualifications = "",instructor2Qualifications = "";
		boolean completeMilestone = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try{
			out = resourceResponse.getWriter();
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonArray = JSONFactoryUtil.createJSONArray();
			
			//PK_projectId = Long.valueOf(getSessionAttr(PortalUtil.getHttpServletRequest(resourceRequest),"LIFERAY_SHARED_PROJECT_KEY"));
			
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
			
			DynamicQuery dynamicQueryIdentification = DynamicQueryFactoryUtil.forClass(labDetailedCourseIdentification.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryIdentification.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			List<labDetailedCourseIdentification> courseIdentification = labDetailedCourseIdentificationLocalServiceUtil.dynamicQuery(dynamicQueryIdentification);
			long PK_courseId = 0;
			if(courseIdentification.size()>0){
				PK_courseId = courseIdentification.get(0).getPK_courseId();
			}
			System.out.println("PK_courseId===detailed=="+PK_courseId);
			if(PK_courseId>0){
				labDetailedCourseIdentification = labDetailedCourseIdentificationLocalServiceUtil.getlabDetailedCourseIdentification(PK_courseId);
				if(labDetailedCourseIdentification!=null){
					courseTitle = labDetailedCourseIdentification.getCourseTitle();
					courseNumber = labDetailedCourseIdentification.getCourseNumber();
					prerequisites = labDetailedCourseIdentification.getPrerequisites();
					courseDescription = labDetailedCourseIdentification.getCourseDescription();
					courseIdentificationId = labDetailedCourseIdentification.getPK_courseId();
				}
			}
			System.out.println("loadCourseInformation");
			DynamicQuery dynamicQueryHours = DynamicQueryFactoryUtil.forClass(labDetailedCourseHours.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryHours.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			labDetailedCourseHours = labDetailedCourseHoursLocalServiceUtil.dynamicQuery(dynamicQueryHours); 
			if(labDetailedCourseHours.size()>0){
				numberOfCredits = labDetailedCourseHours.get(0).getNumberOfCredits();
				numberOfCourseWeeks = labDetailedCourseHours.get(0).getNumberOfCourseWeeks();
				courseHoursPerWeek = labDetailedCourseHours.get(0).getCourseHoursPerWeek();
				lectureHoursPerWeek = labDetailedCourseHours.get(0).getLectureHoursPerWeek();
				labHoursPerWeek = labDetailedCourseHours.get(0).getLabHoursPerWeek();
				studyHoursPerWeek = labDetailedCourseHours.get(0).getIndependentStudyHoursPerWeek();
				//contactHours = courseHoursPerWeek * numberOfCourseWeeks;
				contactHours = labDetailedCourseHours.get(0).getCourseHoursPerWeek();
				courseHoursId = labDetailedCourseHours.get(0).getPK_courseHoursId();
				
				jsonObject.put("numberOfCredits", labDetailedCourseHours.get(0).getNumberOfCredits());
				jsonObject.put("numberOfCourseWeeks", labDetailedCourseHours.get(0).getNumberOfCourseWeeks());
				jsonObject.put("courseHoursPerWeek", labDetailedCourseHours.get(0).getCourseHoursPerWeek());
				jsonObject.put("lectureHoursPerWeek", labDetailedCourseHours.get(0).getLectureHoursPerWeek());
				jsonObject.put("labHoursPerWeek", labDetailedCourseHours.get(0).getLabHoursPerWeek());
				jsonObject.put("studyHoursPerWeek", labDetailedCourseHours.get(0).getIndependentStudyHoursPerWeek());
				jsonObject.put("contactHours", contactHours);
			}else{
				jsonObject.put("numberOfCredits", "");
				jsonObject.put("numberOfCourseWeeks", "");
				jsonObject.put("courseHoursPerWeek", "");
				jsonObject.put("lectureHoursPerWeek", "");
				jsonObject.put("labHoursPerWeek", "");
				jsonObject.put("studyHoursPerWeek", "");
				jsonObject.put("contactHours", contactHours);
			}
			System.out.println("loadCourseInformation");
			DynamicQuery dynamicQueryResources = DynamicQueryFactoryUtil.forClass(labDetailedCourseResources.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryResources.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			labDetailedCourseResources = labDetailedCourseResourcesLocalServiceUtil.dynamicQuery(dynamicQueryResources);
			if(labDetailedCourseResources.size()>0){
				textbookTitle = labDetailedCourseResources.get(0).getTextbokTitle();
				publisherName = labDetailedCourseResources.get(0).getPublisherName();
				author = labDetailedCourseResources.get(0).getAuthor();
				ISBN = labDetailedCourseResources.get(0).getIsbn();
				courseResourcesId = labDetailedCourseResources.get(0).getPK_courseResourceId();
			}
			System.out.println("loadCourseInformation");
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labDetailedInstructorQualification.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			labDetailedInstructorQualification = labDetailedInstructorQualificationLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(labDetailedInstructorQualification.size()>0){
				instructor1Qualifications = labDetailedInstructorQualification.get(0).getInstructor1Qualification();
				instructor2Qualifications = labDetailedInstructorQualification.get(0).getInstructor2Qualification();
				courseInstId = labDetailedInstructorQualification.get(0).getPK_courseInstructorQualificationId();
			}
			
			DynamicQuery dynamicQueryTopics = DynamicQueryFactoryUtil.forClass(labDetailedCourseTopics.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryTopics.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.dynamicQuery(dynamicQueryTopics);
			if(labDetailedCourseTopics.size()>0){				
				JSONObject topicObject = null;
				for(labDetailedCourseTopics singleData:labDetailedCourseTopics){
					topicObject = JSONFactoryUtil.createJSONObject();
					topicObject.put("couseTopic", singleData.getCourseTopic());
					topicArray.put(topicObject);
				}
			}
			
			DynamicQuery dynamicQueryObjectives = DynamicQueryFactoryUtil.forClass(labDetailedCourseObjectives.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryObjectives.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.dynamicQuery(dynamicQueryObjectives);
			if(labDetailedCourseObjectives.size()>0){
				JSONObject topicObject = null;
				for(labDetailedCourseObjectives singleData:labDetailedCourseObjectives){
					topicObject = JSONFactoryUtil.createJSONObject();
					topicObject.put("couseObjectives", singleData.getCourseObjective());
					objectiveArray.put(topicObject);
				}
			}
			
			DynamicQuery dynamicQueryEnv = DynamicQueryFactoryUtil.forClass(labDetailedLearningEnvironments.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryEnv.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.dynamicQuery(dynamicQueryEnv);
			if(labDetailedLearningEnvironments.size()>0){
				JSONObject topicObject = null;
				for(labDetailedLearningEnvironments singleData:labDetailedLearningEnvironments){
					topicObject = JSONFactoryUtil.createJSONObject();
					topicObject.put("learningEnvironment", singleData.getLearningEnvironment());
					envArray.put(topicObject);
				}
			}
			
			if(labDetailedCourseIdentification!=null && labDetailedCourseHours.size()>0){
				labScreenProjectOverview labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(PK_projectId);
				labScreenProjectOverview.setPercentage(33);
				labScreenProjectOverviewLocalServiceUtil.updatelabScreenProjectOverview(labScreenProjectOverview);
			}
			
			if(labDetailedCourseIdentification!=null && labDetailedCourseHours.size()>0 
					&& labDetailedCourseResources.size()>0 && labDetailedInstructorQualification.size()>0){
				completeMilestone = true;
				System.out.println("loadCourseInformation===100");
				labScreenProjectOverview labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(PK_projectId);
				labScreenProjectOverview.setPercentage(100);
				labScreenProjectOverviewLocalServiceUtil.updatelabScreenProjectOverview(labScreenProjectOverview);
			}
			
			jsonObject.put("couseTitle", courseTitle);
			jsonObject.put("courseNumber", courseNumber);
			jsonObject.put("prerequisites", prerequisites);
			jsonObject.put("couseDescription", courseDescription);
			
			jsonObject.put("textbookTitle", textbookTitle);
			jsonObject.put("publisherName", publisherName);
			jsonObject.put("author", author);
			jsonObject.put("ISBN", ISBN);
			jsonObject.put("instructor1Qualifications", instructor1Qualifications);
			jsonObject.put("instructor2Qualifications", instructor2Qualifications);
			jsonObject.put("courseId", courseIdentificationId);
			jsonObject.put("courseHoursId", courseHoursId);
			jsonObject.put("courseResourceId", courseResourcesId);
			jsonObject.put("courseInstId", courseInstId);
			jsonObject.put("enable", completeMilestone);
			jsonObject.put("courseTopic", topicArray);
			jsonObject.put("courseObjective", objectiveArray);
			jsonObject.put("learningEnvironment", envArray);
			out.print(jsonObject.toString());
		}catch(NoSuchlabDetailedCourseIdentificationException e){
			courseTitle="";courseNumber="";prerequisites="";courseDescription="";
		}catch(NoSuchlabDetailedCourseHoursException e){
			numberOfCredits=0;numberOfCourseWeeks=0;courseHoursPerWeek=0;lectureHoursPerWeek=0;labHoursPerWeek=0;studyHoursPerWeek=0;
		}catch(NoSuchlabDetailedCourseResourcesException e){
			textbookTitle = "";publisherName = ""; author = ""; ISBN = "";
		}catch(NoSuchlabDetailedInstructorQualificationException e){
			instructor1Qualifications = "";instructor2Qualifications = "";
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void courseIdentificationAddEdit(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		String courseTitle = ParamUtil.getString(uploadRequest, "courseTitle");
		String courseNumber = ParamUtil.getString(uploadRequest, "courseNumber");
		String prerequisites = ParamUtil.getString(uploadRequest, "prerequisites");
		String courseDescription = ParamUtil.getString(uploadRequest, "courseDescription");
		long courseIdentificationsId = ParamUtil.getLong(uploadRequest, "courseIdentificationsId");
		//Date dueDate = ParamUtil.getDate(resourceRequest, "", "mm-dd-yyyy");
		PrintWriter out = null;
		labDetailedCourseIdentification courseIdentification = null;
		try{
			out = resourceResponse.getWriter();
			
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
			
			if(courseIdentificationsId!=0){
				courseIdentification = labDetailedCourseIdentificationLocalServiceUtil.getlabDetailedCourseIdentification(courseIdentificationsId);
				courseIdentification.setUserId(themeDisplay.getUserId());
				courseIdentification.setModifiedDate(new Date());
				courseIdentification.setCourseTitle(courseTitle);
				courseIdentification.setCourseNumber(courseNumber);
				courseIdentification.setPrerequisites(prerequisites);
				courseIdentification.setCourseDescription(courseDescription);
				courseIdentification.setPK_projectId(PK_projectId);
				labDetailedCourseIdentificationLocalServiceUtil.updatelabDetailedCourseIdentification(courseIdentification);
				out.print("update");
			}else{
				courseIdentification = labDetailedCourseIdentificationLocalServiceUtil.createlabDetailedCourseIdentification(CounterLocalServiceUtil.increment());
				courseIdentification.setUserId(themeDisplay.getUserId());
				courseIdentification.setCreateDate(new Date());
				courseIdentification.setCourseTitle(courseTitle);
				courseIdentification.setCourseNumber(courseNumber);
				courseIdentification.setPrerequisites(prerequisites);
				courseIdentification.setCourseDescription(courseDescription);
				courseIdentification.setPK_projectId(PK_projectId);
				labDetailedCourseIdentificationLocalServiceUtil.addlabDetailedCourseIdentification(courseIdentification);
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
	
	public void courseHoursAddEdit(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		long numberOfCredits = ParamUtil.getLong(uploadRequest, "numberOfCredits");
		long numberOfCourseWeeks = ParamUtil.getLong(uploadRequest, "numberOfCourseWeeks");
		long courseHoursPerWeek = ParamUtil.getLong(uploadRequest, "courseHoursPerWeek");
		long lectureHoursPerWeek = ParamUtil.getLong(uploadRequest, "lectureHoursPerWeek");
		long labHoursPerWeek = ParamUtil.getLong(uploadRequest, "labHoursPerWeek");
		long studyHoursPerWeek = ParamUtil.getLong(uploadRequest, "studyHoursPerWeek");
		long courseHoursId = ParamUtil.getLong(uploadRequest, "courseHoursId");
		//Date dueDate = ParamUtil.getDate(resourceRequest, "", "mm-dd-yyyy");
		PrintWriter out = null;
		labDetailedCourseHours labDetailedCourseHours = null;
		try{
			out = resourceResponse.getWriter();
			
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
			
			if(courseHoursId!=0){
				labDetailedCourseHours = labDetailedCourseHoursLocalServiceUtil.getlabDetailedCourseHours(courseHoursId);
				labDetailedCourseHours.setUserId(themeDisplay.getUserId());
				labDetailedCourseHours.setModifiedDate(new Date());
				labDetailedCourseHours.setPK_projectId(PK_projectId);
				labDetailedCourseHours.setPK_courseId(PK_courseId);
				labDetailedCourseHours.setNumberOfCredits(numberOfCredits);
				labDetailedCourseHours.setNumberOfCourseWeeks(numberOfCourseWeeks);
				labDetailedCourseHours.setCourseHoursPerWeek(courseHoursPerWeek);
				labDetailedCourseHours.setLectureHoursPerWeek(lectureHoursPerWeek);
				labDetailedCourseHours.setLabHoursPerWeek(labHoursPerWeek);
				labDetailedCourseHours.setIndependentStudyHoursPerWeek(studyHoursPerWeek);
				labDetailedCourseHoursLocalServiceUtil.updatelabDetailedCourseHours(labDetailedCourseHours);
				out.print("update");
			}else{
				labDetailedCourseHours = labDetailedCourseHoursLocalServiceUtil.createlabDetailedCourseHours(CounterLocalServiceUtil.increment());
				labDetailedCourseHours.setUserId(themeDisplay.getUserId());
				labDetailedCourseHours.setCreateDate(new Date());
				labDetailedCourseHours.setPK_courseId(PK_courseId);
				labDetailedCourseHours.setPK_projectId(PK_projectId);
				labDetailedCourseHours.setNumberOfCredits(numberOfCredits);
				labDetailedCourseHours.setNumberOfCourseWeeks(numberOfCourseWeeks);
				labDetailedCourseHours.setCourseHoursPerWeek(courseHoursPerWeek);
				labDetailedCourseHours.setLectureHoursPerWeek(lectureHoursPerWeek);
				labDetailedCourseHours.setLabHoursPerWeek(labHoursPerWeek);
				labDetailedCourseHours.setIndependentStudyHoursPerWeek(studyHoursPerWeek);
				labDetailedCourseHoursLocalServiceUtil.addlabDetailedCourseHours(labDetailedCourseHours);
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
	
	public void courseResourcesAddEdit(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		String textbookTitle = ParamUtil.getString(uploadRequest, "textbookTitle");
		String publisherName = ParamUtil.getString(uploadRequest, "publisherName");
		String author = ParamUtil.getString(uploadRequest, "author");
		String ISBN = ParamUtil.getString(uploadRequest, "ISBN");
		long courseResourcesId = ParamUtil.getLong(uploadRequest, "courseResourcesId");
		//Date dueDate = ParamUtil.getDate(resourceRequest, "", "mm-dd-yyyy");
		PrintWriter out = null;
		labDetailedCourseResources labDetailedCourseResources = null;
		try{
			out = resourceResponse.getWriter();
			
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
			
			if(courseResourcesId!=0){
				labDetailedCourseResources = labDetailedCourseResourcesLocalServiceUtil.getlabDetailedCourseResources(courseResourcesId);
				labDetailedCourseResources.setUserId(themeDisplay.getUserId());
				labDetailedCourseResources.setModifiedDate(new Date());
				labDetailedCourseResources.setPK_courseId(PK_courseId);
				labDetailedCourseResources.setPK_projectId(PK_projectId);
				labDetailedCourseResources.setTextbokTitle(textbookTitle);
				labDetailedCourseResources.setPublisherName(publisherName);
				labDetailedCourseResources.setAuthor(author);
				labDetailedCourseResources.setIsbn(ISBN);
				labDetailedCourseResourcesLocalServiceUtil.updatelabDetailedCourseResources(labDetailedCourseResources);
				out.print("update");
			}else{
				labDetailedCourseResources = labDetailedCourseResourcesLocalServiceUtil.createlabDetailedCourseResources(CounterLocalServiceUtil.increment());
				labDetailedCourseResources.setUserId(themeDisplay.getUserId());
				labDetailedCourseResources.setCreateDate(new Date());
				labDetailedCourseResources.setPK_courseId(PK_courseId);
				labDetailedCourseResources.setPK_projectId(PK_projectId);
				labDetailedCourseResources.setTextbokTitle(textbookTitle);
				labDetailedCourseResources.setPublisherName(publisherName);
				labDetailedCourseResources.setAuthor(author);
				labDetailedCourseResources.setIsbn(ISBN);
				labDetailedCourseResourcesLocalServiceUtil.addlabDetailedCourseResources(labDetailedCourseResources);
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
	
	public void courseInstructorQualificationAddEdit(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		String instructor1Qualifications = ParamUtil.getString(uploadRequest, "instructor1Qualifications");
		String instructor2Qualifications = ParamUtil.getString(uploadRequest, "instructor2Qualifications");
		long instructorQualificationsFormId = ParamUtil.getLong(uploadRequest, "instructorQualificationsFormId");
		//Date dueDate = ParamUtil.getDate(resourceRequest, "", "mm-dd-yyyy");
		PrintWriter out = null;
		labDetailedInstructorQualification labDetailedInstructorQualification = null;
		try{
			out = resourceResponse.getWriter();
			
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
			
			if(instructorQualificationsFormId!=0){
				labDetailedInstructorQualification = labDetailedInstructorQualificationLocalServiceUtil.getlabDetailedInstructorQualification(instructorQualificationsFormId);
				labDetailedInstructorQualification.setUserId(themeDisplay.getUserId());
				labDetailedInstructorQualification.setModifiedDate(new Date());
				labDetailedInstructorQualification.setPK_courseId(PK_courseId);
				labDetailedInstructorQualification.setPK_projectId(PK_projectId);
				labDetailedInstructorQualification.setInstructor1Qualification(instructor1Qualifications);
				labDetailedInstructorQualification.setInstructor2Qualification(instructor2Qualifications);
				labDetailedInstructorQualificationLocalServiceUtil.updatelabDetailedInstructorQualification(labDetailedInstructorQualification);
				out.print("update");
			}else{
				labDetailedInstructorQualification = labDetailedInstructorQualificationLocalServiceUtil.createlabDetailedInstructorQualification(CounterLocalServiceUtil.increment());
				labDetailedInstructorQualification.setUserId(themeDisplay.getUserId());
				labDetailedInstructorQualification.setCreateDate(new Date());
				labDetailedInstructorQualification.setPK_courseId(PK_courseId);
				labDetailedInstructorQualification.setPK_projectId(PK_projectId);
				labDetailedInstructorQualification.setInstructor1Qualification(instructor1Qualifications);
				labDetailedInstructorQualification.setInstructor2Qualification(instructor2Qualifications);
				labDetailedInstructorQualificationLocalServiceUtil.addlabDetailedInstructorQualification(labDetailedInstructorQualification);
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
	
	public void courseSummaryAddEdit(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		long summary_courseIdentificationsId = ParamUtil.getLong(uploadRequest, "summary_courseIdentificationsId");
		long summary_courseHoursId = ParamUtil.getLong(uploadRequest, "summary_courseHoursId");
		long summary_courseResourcesId = ParamUtil.getLong(uploadRequest, "summary_courseResourcesId");
		long summary_instructorQualificationsFormId = ParamUtil.getLong(uploadRequest, "summary_instructorQualificationsFormId");
		String summary_courseTitle = ParamUtil.getString(uploadRequest, "summary_courseTitle");
		String summary_courseNumber = ParamUtil.getString(uploadRequest, "summary_courseNumber");
		String summary_prerequisites = ParamUtil.getString(uploadRequest, "summary_prerequisites");
		String summary_courseDescription = ParamUtil.getString(uploadRequest, "summary_courseDescription");
		long summary_creditHours = ParamUtil.getLong(uploadRequest, "summary_creditHours");
		long summary_contactHours = ParamUtil.getLong(uploadRequest, "summary_contactHours");
		long summary_lectureHours = ParamUtil.getLong(uploadRequest, "summary_lectureHours");
		long summary_laboratoryHours = ParamUtil.getLong(uploadRequest, "summary_laboratoryHours");
		String summary_textbookTitle = ParamUtil.getString(uploadRequest, "summary_textbookTitle");
		String summary_publisherName = ParamUtil.getString(uploadRequest, "summary_publisherName");
		String summary_authors = ParamUtil.getString(uploadRequest, "summary_authors");
		String summary_ISBN = ParamUtil.getString(uploadRequest, "summary_ISBN");
		String summary_instructor1Qualifications = ParamUtil.getString(uploadRequest, "summary_instructor1Qualifications");
		String summary_instructor2Qualifications = ParamUtil.getString(uploadRequest, "summary_instructor2Qualifications");
		
		PrintWriter out = null;
		labDetailedCourseIdentification courseIdentification = null;
		labDetailedCourseHours labDetailedCourseHours = null;
		labDetailedCourseResources labDetailedCourseResources = null;
		labDetailedInstructorQualification labDetailedInstructorQualification = null;
		try{
			out = resourceResponse.getWriter();			
			
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
			
			if(summary_courseIdentificationsId!=0){
				courseIdentification = labDetailedCourseIdentificationLocalServiceUtil.getlabDetailedCourseIdentification(summary_courseIdentificationsId);
				courseIdentification.setUserId(themeDisplay.getUserId());
				courseIdentification.setModifiedDate(new Date());
				courseIdentification.setCourseTitle(summary_courseTitle);
				courseIdentification.setCourseNumber(summary_courseNumber);
				courseIdentification.setPrerequisites(summary_prerequisites);
				courseIdentification.setCourseDescription(summary_courseDescription);
				courseIdentification.setPK_courseId(PK_courseId);
				courseIdentification.setPK_projectId(PK_projectId);
				labDetailedCourseIdentificationLocalServiceUtil.updatelabDetailedCourseIdentification(courseIdentification);
			}else{
				courseIdentification = labDetailedCourseIdentificationLocalServiceUtil.createlabDetailedCourseIdentification(CounterLocalServiceUtil.increment());
				courseIdentification.setUserId(themeDisplay.getUserId());
				courseIdentification.setCreateDate(new Date());
				courseIdentification.setCourseTitle(summary_courseTitle);
				courseIdentification.setCourseNumber(summary_courseNumber);
				courseIdentification.setPrerequisites(summary_prerequisites);
				courseIdentification.setCourseDescription(summary_courseDescription);
				courseIdentification.setPK_courseId(PK_courseId);
				courseIdentification.setPK_projectId(PK_projectId);
				labDetailedCourseIdentificationLocalServiceUtil.addlabDetailedCourseIdentification(courseIdentification);
			}			
			if(summary_courseHoursId!=0){
				labDetailedCourseHours = labDetailedCourseHoursLocalServiceUtil.getlabDetailedCourseHours(summary_courseHoursId);
				labDetailedCourseHours.setUserId(themeDisplay.getUserId());
				labDetailedCourseHours.setModifiedDate(new Date());
				labDetailedCourseHours.setPK_courseId(PK_courseId);
				labDetailedCourseHours.setPK_projectId(PK_projectId);
				labDetailedCourseHours.setNumberOfCredits(summary_creditHours);
				labDetailedCourseHours.setLectureHoursPerWeek(summary_lectureHours);
				labDetailedCourseHours.setLabHoursPerWeek(summary_laboratoryHours);
				labDetailedCourseHoursLocalServiceUtil.updatelabDetailedCourseHours(labDetailedCourseHours);
			}else{
				labDetailedCourseHours = labDetailedCourseHoursLocalServiceUtil.createlabDetailedCourseHours(CounterLocalServiceUtil.increment());
				labDetailedCourseHours.setUserId(themeDisplay.getUserId());
				labDetailedCourseHours.setCreateDate(new Date());
				labDetailedCourseHours.setPK_courseId(PK_courseId);
				labDetailedCourseHours.setPK_projectId(PK_projectId);
				labDetailedCourseHours.setNumberOfCredits(summary_creditHours);
				labDetailedCourseHours.setLectureHoursPerWeek(summary_lectureHours);
				labDetailedCourseHours.setLabHoursPerWeek(summary_laboratoryHours);
				labDetailedCourseHoursLocalServiceUtil.addlabDetailedCourseHours(labDetailedCourseHours);
			}				
			
			if(summary_courseResourcesId!=0){
				labDetailedCourseResources = labDetailedCourseResourcesLocalServiceUtil.getlabDetailedCourseResources(summary_courseResourcesId);
				labDetailedCourseResources.setUserId(themeDisplay.getUserId());
				labDetailedCourseResources.setModifiedDate(new Date());
				labDetailedCourseResources.setPK_courseId(PK_courseId);
				labDetailedCourseResources.setPK_projectId(PK_projectId);
				labDetailedCourseResources.setTextbokTitle(summary_textbookTitle);
				labDetailedCourseResources.setPublisherName(summary_publisherName);
				labDetailedCourseResources.setAuthor(summary_authors);
				labDetailedCourseResources.setIsbn(summary_ISBN);
				labDetailedCourseResourcesLocalServiceUtil.updatelabDetailedCourseResources(labDetailedCourseResources);
			}else{
				labDetailedCourseResources = labDetailedCourseResourcesLocalServiceUtil.createlabDetailedCourseResources(CounterLocalServiceUtil.increment());
				labDetailedCourseResources.setUserId(themeDisplay.getUserId());
				labDetailedCourseResources.setCreateDate(new Date());
				labDetailedCourseResources.setPK_courseId(PK_courseId);
				labDetailedCourseResources.setPK_projectId(PK_projectId);
				labDetailedCourseResources.setTextbokTitle(summary_textbookTitle);
				labDetailedCourseResources.setPublisherName(summary_publisherName);
				labDetailedCourseResources.setAuthor(summary_authors);
				labDetailedCourseResources.setIsbn(summary_ISBN);
				labDetailedCourseResourcesLocalServiceUtil.addlabDetailedCourseResources(labDetailedCourseResources);
			}			
			
			if(summary_instructorQualificationsFormId!=0){
				labDetailedInstructorQualification = labDetailedInstructorQualificationLocalServiceUtil.getlabDetailedInstructorQualification(summary_instructorQualificationsFormId);
				labDetailedInstructorQualification.setUserId(themeDisplay.getUserId());
				labDetailedInstructorQualification.setModifiedDate(new Date());
				labDetailedInstructorQualification.setPK_courseId(PK_courseId);
				labDetailedInstructorQualification.setPK_projectId(PK_projectId);
				labDetailedInstructorQualification.setInstructor1Qualification(summary_instructor1Qualifications);
				labDetailedInstructorQualification.setInstructor2Qualification(summary_instructor2Qualifications);
				labDetailedInstructorQualificationLocalServiceUtil.updatelabDetailedInstructorQualification(labDetailedInstructorQualification);
			}else{
				labDetailedInstructorQualification = labDetailedInstructorQualificationLocalServiceUtil.createlabDetailedInstructorQualification(CounterLocalServiceUtil.increment());
				labDetailedInstructorQualification.setUserId(themeDisplay.getUserId());
				labDetailedInstructorQualification.setCreateDate(new Date());
				labDetailedInstructorQualification.setPK_courseId(PK_courseId);
				labDetailedInstructorQualification.setPK_projectId(PK_projectId);
				labDetailedInstructorQualification.setInstructor1Qualification(summary_instructor1Qualifications);
				labDetailedInstructorQualification.setInstructor2Qualification(summary_instructor2Qualifications);
				labDetailedInstructorQualificationLocalServiceUtil.addlabDetailedInstructorQualification(labDetailedInstructorQualification);				
			}	
			out.print("save");
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	
	public void viewCourseIdentification(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		PrintWriter out = null;
		labDetailedCourseIdentification courseIdentification = null;long courseIdentificationsId = 0;
		String template = "";String courseTitle="",courseNumber="",prerequisites="",courseDescription="";
		try{
			out = resourceResponse.getWriter();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
			String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
			long PK_projectId = new Long(sessionProjectID);
			long PK_courseId = 0;
			long currentUser = (Long)httpsession.getAttribute("currentUser");		
			if(currentUser==themeDisplay.getUserId()){
				PK_projectId = new Long(sessionProjectID);	
				if(PK_projectId>0){
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labDetailedCourseIdentification.class, PortalClassLoaderUtil.getClassLoader());
					dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
					List<labDetailedCourseIdentification> courseIdentificationRef = labDetailedCourseIdentificationLocalServiceUtil.dynamicQuery(dynamicQuery);
					PK_courseId = 0;
					
					if(courseIdentificationRef.size()>0){
						PK_courseId = courseIdentificationRef.get(0).getPK_courseId();
					}
				}
			}
			
			if(PK_courseId>0){
				courseIdentification = labDetailedCourseIdentificationLocalServiceUtil.getlabDetailedCourseIdentification(PK_courseId);
				if(courseIdentification!=null){
					//Popup load with data
					courseIdentificationsId = courseIdentification.getPK_courseId();
					courseTitle = courseIdentification.getCourseTitle();
					courseNumber = courseIdentification.getCourseNumber();
					prerequisites = courseIdentification.getPrerequisites();
					courseDescription = courseIdentification.getCourseDescription();
				}
			}
			//Popup load with empty input
			template = template + "<div class='modal-content'> <div class='modal-header position-relative text-center'>"
					+ "<div class='text-left font15 m-auto'><strong>Course Identification</strong> </div> </div> "
					+ "<form name='courseIdentificationsForm' id='courseIdentificationsForm'> "
					+ "<input type='hidden' name='courseIdentificationsId' value='"+courseIdentificationsId+"' class='wrap-input input' required='true' /> "
					+ "<div class='modal-body'> <div class='interest-modal'> "
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='courseTitle'>Course Title</label><div class='col-md-8'><input type='text' name='courseTitle'  value='"+courseTitle+"' class='wrap-input input form-control' required='true' /></div> </div>"
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='courseNumber'>Course Number</label><div class='col-md-8'><input type='text' name='courseNumber'  value='"+courseNumber+"' class='wrap-input input form-control' required='true' /></div> </div>"
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='prerequisites'>Prerequisites</label><div class='col-md-8'><input type='text' name='prerequisites'  value='"+prerequisites+"' class='wrap-input input form-control' required='true' /></div> </div>"
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='courseDescription'>Course Description</label><div class='col-md-8'><textarea name='courseDescription'  value='"+courseDescription+"' class='wrap-input input form-control' required='true'>"+courseDescription+"</textarea></div> </div>"
					+ "<div class='text-right'> "
					+ "<button value='Cancel' class='btn btn-grey mr-2' data-dismiss='modal' type='reset' onclick='clearModal()'>Cancel</button> "
					+ "<button value='Save' type='submit' class='btn btn-blue' onclick='courseIdentificationAddEdit()'>Save</button> "
					+ "</div> </div> </div> </form> </div> ";
			out.print(template);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void viewCourseHours(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		PrintWriter out = null;
		List<labDetailedCourseHours> labDetailedCourseHours = null;
		String template = "";long numberOfCredits=0,numberOfCourseWeeks=0,courseHoursPerWeek=0,lectureHoursPerWeek=0,labHoursPerWeek=0,studyHoursPerWeek=0,totalHours=0,courseHoursId=0;
		long contactHouts = 0, indeStudyHours=0;
		
		try{
			out = resourceResponse.getWriter();
			System.out.println("PK_projectId===courseIdentification=="+PK_courseId);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
			
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labDetailedCourseHours.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			labDetailedCourseHours = labDetailedCourseHoursLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(labDetailedCourseHours.size()>0){
				//Popup load with data
				courseHoursId = labDetailedCourseHours.get(0).getPK_courseHoursId();
				numberOfCredits = labDetailedCourseHours.get(0).getNumberOfCredits();
				numberOfCourseWeeks = labDetailedCourseHours.get(0).getNumberOfCourseWeeks();
				courseHoursPerWeek = labDetailedCourseHours.get(0).getCourseHoursPerWeek();
				lectureHoursPerWeek = labDetailedCourseHours.get(0).getLectureHoursPerWeek();
				labHoursPerWeek = labDetailedCourseHours.get(0).getLabHoursPerWeek();
				studyHoursPerWeek = labDetailedCourseHours.get(0).getIndependentStudyHoursPerWeek();
				
				contactHouts = courseHoursPerWeek * numberOfCourseWeeks;
				indeStudyHours = studyHoursPerWeek * numberOfCourseWeeks;
				
				totalHours = contactHouts + indeStudyHours;  
			}
			
			//Popup load with empty input
			PortletURL formSubmitURL = resourceResponse.createActionURL();
			formSubmitURL.setParameter(ActionRequest.ACTION_NAME, "courseHoursAddEdit");
			template = template+ "<div class='modal-content'> <div class='modal-header position-relative text-center'>"
					+ "<div class='text-left font15 m-auto'><strong>Course Hours</strong> </div> </div> "
					+ "<form name='courseHoursForm' method='post' id='courseHoursForm'> "
					+ "<input type='hidden' name='courseHoursId' value='"+courseHoursId+"' class='wrap-input input' required='true' /> "
					+ "<div class='modal-body'> <div class='interest-modal'> "
					+ "<div class='row mb-2'> "
					+ "<div class='col-md-6'> "
					+ "<div class='form-group'><label class='control-label' for='numberOfCredits'>Number of Credits</label><input type='number' name='numberOfCredits' id='numberOfCredits' min='0' value='"+numberOfCredits+"' maxlength='2' oninput='javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);' class='wrap-input input form-control' required='true' /> </div>"
					+ "<div class='form-group'><label class='control-label' for='numberOfCourseWeeks'>Number of Course Weeks</label><input type='number' name='numberOfCourseWeeks' id='numberOfCourseWeeks' min='0' max='60' maxlength='2' oninput='javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);' value='"+numberOfCourseWeeks+"' class='wrap-input input form-control' required='true' /> </div>"
					+ "<div class='form-group'><label class='control-label' for='courseHoursPerWeek'>Contact Hours per Week</label><input type='number' name='courseHoursPerWeek' id='courseHoursPerWeek' min='0' max='60' maxlength='2' oninput='javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);' value='"+courseHoursPerWeek+"' class='wrap-input input form-control' required='true' /> </div>"
					+ "<div class='form-group'><label class='control-label' for='lectureHoursPerWeek'>Lecture Hours per Week</label><input type='number' name='lectureHoursPerWeek' id='lectureHoursPerWeek' min='0' max='60' maxlength='2' oninput='javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);' value='"+lectureHoursPerWeek+"' class='wrap-input input form-control' required='true' /> </div>"
					+ "</div> "
					+ "<div class='col-md-6'> "
					+ "<div class='form-group'><label class='control-label' for='labHoursPerWeek'>Lab Hours per Week</label><input type='number' name='labHoursPerWeek' id='labHoursPerWeek' min='0' max='60' maxlength='2' oninput='javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);' value='"+labHoursPerWeek+"' class='wrap-input input form-control' required='true' /> </div>"
					+ "<div class='form-group'><label class='control-label' for='studyHoursPerWeek'>Independent Study Hours per Week</label><input type='number' id='studyHoursPerWeek' name='studyHoursPerWeek'  min='0' max='60' maxlength='2' oninput='javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);'  value='"+studyHoursPerWeek+"' class='wrap-input input form-control' required='true' /> </div>"
					+ "<div class='d-flex justify-content-between align-items-center mb-2'> "
					+ "<span>Contact Hours:</span> "
					+ "<span class='contactHoursCal'>"+contactHouts+" Hours</span> "
					+ "</div> "
					+ "<div class='d-flex justify-content-between align-items-center mb-2'> "
					+ "<span>Independent Study Hours:</span> "
					+ "<span class='independentHoursCal'>"+indeStudyHours+" Hours</span> </div> "
					+ "<div class='d-flex align-items-center justify-content-between mb-2'>Total Hours: <span class='totalHoursCal ml-2'>"+totalHours+"</span></div> "
					+ "</div> </div> "
					+ "<div class='row mb-4'> "
					+ "<div class='col-md-12'>	<strong>Tip: </strong>The average 14 week course should have 1 hour of class time and 2 hours of independent study per week for every credit hour.</div> </div> "
					+ "<div class='row'> <div class='col-md-12 text-right'> "
					+ "<button value='Cancel' class='btn btn-grey mr-2' data-dismiss='modal' type='reset' onclick='clearModal(courseHoursForm)'>Cancel</button> "
					+ "<button value='Save' type='submit' class='btn btn-blue' onclick='courseHoursAddEdit()'>Save</button> "
					+ "</div> </div> </div> </div> </form> </div>";
			out.print(template);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void viewCourseResources(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		PrintWriter out = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<labDetailedCourseResources> labDetailedCourseResources = null;long courseResourcesId = 0;
		String template = "";String textbookTitle = "",publisherName = "", author = "", ISBN = "";
		try{
			out = resourceResponse.getWriter();
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
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labDetailedCourseResources.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			labDetailedCourseResources = labDetailedCourseResourcesLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(labDetailedCourseResources.size()>0){
				//Popup load with data
				courseResourcesId = labDetailedCourseResources.get(0).getPK_courseResourceId();
				textbookTitle = labDetailedCourseResources.get(0).getTextbokTitle();
				publisherName = labDetailedCourseResources.get(0).getPublisherName();
				author = labDetailedCourseResources.get(0).getAuthor();
				ISBN = labDetailedCourseResources.get(0).getIsbn();
			}
			
			//Popup load with empty input
			template = template + "<div class='modal-content'> <div class='modal-header position-relative text-center'>"
					+ "<div class='text-left font15 m-auto'><strong>Course Resources</strong> </div> </div> "
					+ "<form name='courseResourcesForm' onSubmit='event.preventDefault();' id='courseResourcesForm'> "
					+ "<input type='hidden' name='courseResourcesId' value='"+courseResourcesId+"' class='wrap-input input' required='true' /> "
					+ "<div class='modal-body'> <div class='interest-modal'> "
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='textbookTitle'>Textbook Title</label><div class='col-md-8'><input type='text' name='textbookTitle'  value='"+textbookTitle+"' class='wrap-input input form-control' required='true' /></div> </div>"
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='publisherName'>Publisher's Name</label><div class='col-md-8'><input type='text' name='publisherName'  value='"+publisherName+"' class='wrap-input input form-control' required='true' /></div> </div>"
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='author'>Author</label><div class='col-md-8'><input type='text' name='author'  value='"+author+"' class='wrap-input input form-control' required='true' /></div> </div>"
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='ISBN'>ISBN</label><div class='col-md-8'><input type='text' name='ISBN'  value='"+ISBN+"' class='wrap-input input form-control' required='true' /></div> </div>"
					+ "<div class='text-right'> "
					+ "<button value='Cancel' class='btn btn-grey mr-2' data-dismiss='modal' type='reset' onclick='clearModal()'>Cancel</button> "
					+ "<button value='Save' type='submit' class='btn btn-blue' onclick='courseResourcesAddEdit()'>Save</button> "
					+ "</div> </div> </div> </form> </div> ";
			out.print(template);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void viewCourseInstructorQualification(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		PrintWriter out = null;
		List<labDetailedInstructorQualification> labDetailedInstructorQualification = null;long instructorQualificationsFormId = 0;
		String template = "";String instructor1Qualifications = "",instructor2Qualifications = "";
		try{
			out = resourceResponse.getWriter();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labDetailedInstructorQualification.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(PK_projectId));
			labDetailedInstructorQualification = labDetailedInstructorQualificationLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(labDetailedInstructorQualification.size()>0){
				//Popup load with data
				instructorQualificationsFormId = labDetailedInstructorQualification.get(0).getPK_courseInstructorQualificationId();
				instructor1Qualifications = labDetailedInstructorQualification.get(0).getInstructor1Qualification();
				instructor2Qualifications = labDetailedInstructorQualification.get(0).getInstructor2Qualification();	
			}				

			//Popup load with empty input
			template = template + "<div class='modal-content'> <div class='modal-header position-relative text-center'>"
					+ "<div class='text-left font15 m-auto'><strong>Instructor Qualifications</strong> </div> </div> "
					+ "<form name='instructorQualificationsForm' onSubmit='event.preventDefault();' id='instructorQualificationsForm'> "
					+ "<input type='hidden' name='instructorQualificationsFormId' value='"+instructorQualificationsFormId+"' class='wrap-input input' required='true' /> "
					+ "<div class='modal-body'> <div class='interest-modal'> "
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='instructor1Qualifications'>Instructor 1 Qualifications</label><div class='col-md-8'><textarea name='instructor1Qualifications' class='wrap-input input form-control' required='true'>"+instructor1Qualifications+"</textarea></div> </div>"
					+ "<div class='form-group row'><label class='col-md-4 control-label' for='instructor2Qualifications'>Instructor 2 Qualifications</label><div class='col-md-8'><textarea name='instructor2Qualifications' class='wrap-input input form-control' required='true'>"+instructor2Qualifications+"</textarea></div> </div>"
					+ "<div class='text-right'> "
					+ "<button value='Cancel' class='btn btn-grey mr-2' data-dismiss='modal' type='reset' onclick='clearModal()'>Cancel</button> "
					+ "<button value='Save' type='submit' class='btn btn-blue' onclick='courseInstructorQualificationAddEdit()'>Save</button> "
					+ "</div> </div> </div> </form> </div> ";
			out.print(template);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	public void donutPercentage(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		long donutPercentage = ParamUtil.getLong(resourceRequest, "donutPercentage");
		labScreenProjectOverview labScreenProjectOverview = null;
		try{
			/*labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(PK_projectId);
			labScreenProjectOverview.setPercentage(donutPercentage);
			labScreenProjectOverviewLocalServiceUtil.updatelabScreenProjectOverview(labScreenProjectOverview);*/
		}catch(Exception e){
			
		}
	}
	
	public void getProjectPercentage(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		PrintWriter out = null;
		List<labScreenTask> listData = null;long percentage = 0;JSONObject jsonObject = null;
		boolean completeMilestoneTab1 = false; boolean completeMilestoneTab2 = false; boolean completeMilestoneTab3 = false; 
		long taskCompletionNotificationTab1 = 0;long taskCompletionNotificationTab2 = 0;long taskCompletionNotificationTab3 = 0;
		try{
			out = resourceResponse.getWriter();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenTask.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(Long.valueOf(PK_projectId)));
			listData = labScreenTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(listData.size()>0){
				for(labScreenTask singleData:listData){
					if(singleData.getTaskName().equalsIgnoreCase("Refine Course Identification") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab1 = taskCompletionNotificationTab1 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Determine Course Hours") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab1 = taskCompletionNotificationTab1 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Identify Course Resources") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab1 = taskCompletionNotificationTab1 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Add Instructor Qualifications") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab1 = taskCompletionNotificationTab1 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Review Course Topics") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab2 = taskCompletionNotificationTab2 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Evaluate Course Objectives") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab2 = taskCompletionNotificationTab2 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Identify Learning Environments") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab2 = taskCompletionNotificationTab2 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Add Course Objectives to Weeks") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab3 = taskCompletionNotificationTab3 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Associate Learning Environment Design with Objectives") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab3 = taskCompletionNotificationTab3 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Add Week Activities") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab3 = taskCompletionNotificationTab3 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Identify Content for Course Objectives") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 10;
						taskCompletionNotificationTab3 = taskCompletionNotificationTab3 + 1;
					}
				}
				if(taskCompletionNotificationTab1==4){
					completeMilestoneTab1 = true;
				}
				if(taskCompletionNotificationTab2==3){
					completeMilestoneTab2 = true;
				}
				if(taskCompletionNotificationTab3==4){
					completeMilestoneTab3 = true;
				}
			}
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("percentage", percentage);
			jsonObject.put("milestone1", completeMilestoneTab1);
			jsonObject.put("milestone2", completeMilestoneTab2);
			jsonObject.put("milestone3", completeMilestoneTab3);
			out.print(jsonObject);
		}catch(Exception e){
			
		}
	}
	
	public void getProjectPercentageLoad(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		PrintWriter out = null;
		List<labScreenTask> listData = null;long percentage = 0;JSONObject jsonObject = null;
		boolean completeMilestoneTab1 = false; boolean completeMilestoneTab2 = false; boolean completeMilestoneTab3 = false; 
		long taskCompletionNotificationTab1 = 0;long taskCompletionNotificationTab2 = 0;long taskCompletionNotificationTab3 = 0;
		try{
			out = resourceResponse.getWriter();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenTask.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(Long.valueOf(PK_projectId)));
			listData = labScreenTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(listData.size()>0){
				for(labScreenTask singleData:listData){
					if(singleData.getTaskName().equalsIgnoreCase("Refine Course Identification") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab1 = taskCompletionNotificationTab1 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Determine Course Hours") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab1 = taskCompletionNotificationTab1 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Identify Course Resources") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab1 = taskCompletionNotificationTab1 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Add Instructor Qualifications") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab1 = taskCompletionNotificationTab1 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Review Course Topics") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab2 = taskCompletionNotificationTab2 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Evaluate Course Objectives") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab2 = taskCompletionNotificationTab2 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Identify Learning Environments") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab2 = taskCompletionNotificationTab2 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Add Course Objectives to Weeks") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab3 = taskCompletionNotificationTab3 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Associate Learning Environment Design with Objectives") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab3 = taskCompletionNotificationTab3 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Add Week Activities") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 9;
						taskCompletionNotificationTab3 = taskCompletionNotificationTab3 + 1;
					}
					if(singleData.getTaskName().equalsIgnoreCase("Identify Content for Course Objectives") && singleData.getTaskStatus().equalsIgnoreCase("Completed")){
						percentage = percentage + 10;
						taskCompletionNotificationTab3 = taskCompletionNotificationTab3 + 1;
					}
				}
				if(taskCompletionNotificationTab1==4){
					completeMilestoneTab1 = true;
				}
				if(taskCompletionNotificationTab2==3){
					completeMilestoneTab2 = true;
				}
				if(taskCompletionNotificationTab3==4){
					completeMilestoneTab3 = true;
				}
			}
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("percentage", percentage);
			jsonObject.put("milestone1", completeMilestoneTab1);
			jsonObject.put("milestone2", completeMilestoneTab2);
			jsonObject.put("milestone3", completeMilestoneTab3);
			out.print(jsonObject);
		}catch(Exception e){
			
		}
	}
	
	public void saveActivityTable(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		long selectedKey = ParamUtil.getLong(resourceRequest, "selectedKey");
		long weekParam = ParamUtil.getLong(resourceRequest, "selectedWeek");
		String paramDetails = ParamUtil.getString(resourceRequest, "selectedParam");
		String value = ParamUtil.getString(resourceRequest, paramDetails);
		labDetailedActivityTable labDetailedActivityTable = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;
		try{
			out = resourceResponse.getWriter();
			System.out.println("paramDetails==="+paramDetails);
			System.out.println("value==="+value);			
			
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
			
			if(selectedKey!=0){
				if(paramDetails.equalsIgnoreCase("courseObjective")){
					labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.getlabDetailedActivityTable(selectedKey);
					labDetailedActivityTable.setUserId(themeDisplay.getUserId());
					labDetailedActivityTable.setWeek(weekParam);
					labDetailedActivityTable.setCourseObjective(value);
					labDetailedActivityTable.setCreateDate(new Date());
					labDetailedActivityTable.setPK_courseId(PK_courseId);
					labDetailedActivityTable.setPK_projectId(PK_projectId);
					labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					out.print(labDetailedActivityTable.getPK_activityTableId());
				}
				if(paramDetails.equalsIgnoreCase("learningEnvironment")){
					labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.getlabDetailedActivityTable(selectedKey);
					labDetailedActivityTable.setUserId(themeDisplay.getUserId());
					labDetailedActivityTable.setWeek(weekParam);
					labDetailedActivityTable.setLearningEnvironmentDesign(value);
					labDetailedActivityTable.setCreateDate(new Date());
					labDetailedActivityTable.setPK_projectId(PK_projectId);
					labDetailedActivityTable.setPK_courseId(PK_courseId);
					labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					out.print(labDetailedActivityTable.getPK_activityTableId());
				}
				if(paramDetails.equalsIgnoreCase("activity")){
					labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.getlabDetailedActivityTable(selectedKey);
					labDetailedActivityTable.setUserId(themeDisplay.getUserId());
					labDetailedActivityTable.setWeek(weekParam);
					labDetailedActivityTable.setActivity(value);
					labDetailedActivityTable.setCreateDate(new Date());
					labDetailedActivityTable.setPK_projectId(PK_projectId);
					labDetailedActivityTable.setPK_courseId(PK_courseId);
					labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					out.print(labDetailedActivityTable.getPK_activityTableId());
				}
				if(paramDetails.equalsIgnoreCase("content")){
					labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.getlabDetailedActivityTable(selectedKey);
					labDetailedActivityTable.setUserId(themeDisplay.getUserId());
					labDetailedActivityTable.setWeek(weekParam);
					labDetailedActivityTable.setContent(value);
					labDetailedActivityTable.setCreateDate(new Date());
					labDetailedActivityTable.setPK_projectId(PK_projectId);
					labDetailedActivityTable.setPK_courseId(PK_courseId);
					labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					out.print(labDetailedActivityTable.getPK_activityTableId());
				}
			}else{
				if(paramDetails.equalsIgnoreCase("courseObjective")){
					labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
					labDetailedActivityTable.setUserId(themeDisplay.getUserId());
					labDetailedActivityTable.setWeek(weekParam);
					labDetailedActivityTable.setCourseObjective(value);
					labDetailedActivityTable.setCreateDate(new Date());
					labDetailedActivityTable.setPK_projectId(PK_projectId);
					labDetailedActivityTable.setPK_courseId(PK_courseId);
					labDetailedActivityTableLocalServiceUtil.addlabDetailedActivityTable(labDetailedActivityTable);
					out.print(labDetailedActivityTable.getPK_activityTableId());
				}
				if(paramDetails.equalsIgnoreCase("learningEnvironment")){
					labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
					labDetailedActivityTable.setUserId(themeDisplay.getUserId());
					labDetailedActivityTable.setWeek(weekParam);
					labDetailedActivityTable.setLearningEnvironmentDesign(value);
					labDetailedActivityTable.setCreateDate(new Date());
					labDetailedActivityTable.setPK_projectId(PK_projectId);
					labDetailedActivityTable.setPK_courseId(PK_courseId);
					labDetailedActivityTableLocalServiceUtil.addlabDetailedActivityTable(labDetailedActivityTable);
					out.print(labDetailedActivityTable.getPK_activityTableId());
				}
				if(paramDetails.equalsIgnoreCase("activity")){
					labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
					labDetailedActivityTable.setUserId(themeDisplay.getUserId());
					labDetailedActivityTable.setWeek(weekParam);
					labDetailedActivityTable.setActivity(value);
					labDetailedActivityTable.setCreateDate(new Date());
					labDetailedActivityTable.setPK_projectId(PK_projectId);
					labDetailedActivityTable.setPK_courseId(PK_courseId);
					labDetailedActivityTableLocalServiceUtil.addlabDetailedActivityTable(labDetailedActivityTable);
					out.print(labDetailedActivityTable.getPK_activityTableId());
				}
				if(paramDetails.equalsIgnoreCase("content")){
					labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
					labDetailedActivityTable.setUserId(themeDisplay.getUserId());
					labDetailedActivityTable.setWeek(weekParam);
					labDetailedActivityTable.setContent(value);
					labDetailedActivityTable.setCreateDate(new Date());
					labDetailedActivityTable.setPK_projectId(PK_projectId);
					labDetailedActivityTable.setPK_courseId(PK_courseId);
					labDetailedActivityTableLocalServiceUtil.addlabDetailedActivityTable(labDetailedActivityTable);
					out.print(labDetailedActivityTable.getPK_activityTableId());
				}
			}
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void loadWeekWiseData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		PrintWriter out = null;
		List<labDetailedActivityTable> labDetailedActivityTable = null;
		try{
			out = resourceResponse.getWriter();
			jsonArray = JSONFactoryUtil.createJSONArray();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
			
			DynamicQuery dynamicQueryWeekWise = DynamicQueryFactoryUtil.forClass(labDetailedActivityTable.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryWeekWise.add(RestrictionsFactoryUtil.eq("PK_projectId",PK_projectId));
			labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.dynamicQuery(dynamicQueryWeekWise);
			if(labDetailedActivityTable.size()>0){
				for(labDetailedActivityTable singleData:labDetailedActivityTable){
					if(singleData.getCourseObjective()!="" && singleData.getCourseObjective()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("courseObjective", singleData.getCourseObjective());
						jsonObject.put("week", singleData.getWeek());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArray.put(jsonObject);
					}
					if(singleData.getLearningEnvironmentDesign()!="" && singleData.getLearningEnvironmentDesign()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("learningEnvironment", singleData.getLearningEnvironmentDesign());
						jsonObject.put("week", singleData.getWeek());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArray.put(jsonObject);
					}
					if(singleData.getActivity()!="" && singleData.getActivity()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("activity", singleData.getActivity());
						jsonObject.put("week", singleData.getWeek());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArray.put(jsonObject);
					}
					if(singleData.getContent()!="" && singleData.getContent()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("content", singleData.getContent());
						jsonObject.put("week", singleData.getWeek());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArray.put(jsonObject);
					}
				}
			}
			out.print(jsonArray);
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void loadWeekWiseDataMain(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		JSONObject jsonObject = null;
		JSONArray jsonArrayWeek1Objective = null;JSONArray jsonArrayWeek1Env = null;JSONArray jsonArrayWeek1Activity = null;JSONArray jsonArrayWeek1Content = null;
		JSONObject courseObjective = null;JSONObject learningEnv = null;JSONObject activity = null;JSONObject content = null;
		PrintWriter out = null;
		List<labDetailedActivityTable> labDetailedActivityTable = null;
		try{
			out = resourceResponse.getWriter();
			jsonArrayWeek1Objective = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Env = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Activity = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Content = JSONFactoryUtil.createJSONArray();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
			
			DynamicQuery dynamicQueryWeekWise1 = DynamicQueryFactoryUtil.forClass(labDetailedActivityTable.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryWeekWise1.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("PK_projectId",PK_projectId),RestrictionsFactoryUtil.eq("week", new Long(1))));
			labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.dynamicQuery(dynamicQueryWeekWise1);
			courseObjective = JSONFactoryUtil.createJSONObject();
			if(labDetailedActivityTable.size()>0){				
				for(labDetailedActivityTable singleData:labDetailedActivityTable){					
					if(!(singleData.getCourseObjective().equalsIgnoreCase("")) && singleData.getCourseObjective()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("courseObjective", singleData.getCourseObjective());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Objective.put(jsonObject);
					}
					if(!(singleData.getLearningEnvironmentDesign().equalsIgnoreCase("")) && singleData.getLearningEnvironmentDesign()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("learningEnvironment", singleData.getLearningEnvironmentDesign());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Env.put(jsonObject);
					}
					if(!(singleData.getActivity().equalsIgnoreCase("")) && singleData.getActivity()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("activity", singleData.getActivity());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Activity.put(jsonObject);
					}
					if(!(singleData.getContent().equalsIgnoreCase("")) && singleData.getContent()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("content", singleData.getContent());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Content.put(jsonObject);
					}
				}
			}
			courseObjective.put("courseObjective",jsonArrayWeek1Objective);
			courseObjective.put("learningEnv",jsonArrayWeek1Env);
			courseObjective.put("activity",jsonArrayWeek1Activity);
			courseObjective.put("content",jsonArrayWeek1Content);
			
			jsonArrayWeek1Objective = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Env = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Activity = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Content = JSONFactoryUtil.createJSONArray();
			learningEnv = JSONFactoryUtil.createJSONObject();
			DynamicQuery dynamicQueryWeekWise2 = DynamicQueryFactoryUtil.forClass(labDetailedActivityTable.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryWeekWise2.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("PK_projectId",PK_projectId),RestrictionsFactoryUtil.eq("week", new Long(2))));
			labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.dynamicQuery(dynamicQueryWeekWise2);
			if(labDetailedActivityTable.size()>0){				
				for(labDetailedActivityTable singleData:labDetailedActivityTable){					
					if(!(singleData.getCourseObjective().equalsIgnoreCase("")) && singleData.getCourseObjective()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("courseObjective", singleData.getCourseObjective());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Objective.put(jsonObject);
					}
					if(!(singleData.getLearningEnvironmentDesign().equalsIgnoreCase("")) && singleData.getLearningEnvironmentDesign()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("learningEnvironment", singleData.getLearningEnvironmentDesign());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Env.put(jsonObject);
					}
					if(!(singleData.getActivity().equalsIgnoreCase("")) && singleData.getActivity()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("activity", singleData.getActivity());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Activity.put(jsonObject);
					}
					if(!(singleData.getContent().equalsIgnoreCase("")) && singleData.getContent()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("content", singleData.getContent());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Content.put(jsonObject);
					}
				}
			}
			learningEnv.put("courseObjective",jsonArrayWeek1Objective);
			learningEnv.put("learningEnv",jsonArrayWeek1Env);
			learningEnv.put("activity",jsonArrayWeek1Activity);
			learningEnv.put("content",jsonArrayWeek1Content);
			
			jsonArrayWeek1Objective = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Env = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Activity = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Content = JSONFactoryUtil.createJSONArray();
			activity = JSONFactoryUtil.createJSONObject();
			DynamicQuery dynamicQueryWeekWise3 = DynamicQueryFactoryUtil.forClass(labDetailedActivityTable.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryWeekWise3.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("PK_projectId",PK_projectId),RestrictionsFactoryUtil.eq("week", new Long(3))));
			labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.dynamicQuery(dynamicQueryWeekWise3);
			if(labDetailedActivityTable.size()>0){				
				for(labDetailedActivityTable singleData:labDetailedActivityTable){					
					if(!(singleData.getCourseObjective().equalsIgnoreCase("")) && singleData.getCourseObjective()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("courseObjective", singleData.getCourseObjective());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Objective.put(jsonObject);
					}
					if(!(singleData.getLearningEnvironmentDesign().equalsIgnoreCase("")) && singleData.getLearningEnvironmentDesign()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("learningEnvironment", singleData.getLearningEnvironmentDesign());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Env.put(jsonObject);
					}
					if(!(singleData.getActivity().equalsIgnoreCase("")) && singleData.getActivity()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("activity", singleData.getActivity());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Activity.put(jsonObject);
					}
					if(!(singleData.getContent().equalsIgnoreCase("")) && singleData.getContent()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("content", singleData.getContent());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Content.put(jsonObject);
					}
				}
			}
			activity.put("courseObjective",jsonArrayWeek1Objective);
			activity.put("learningEnv",jsonArrayWeek1Env);
			activity.put("activity",jsonArrayWeek1Activity);
			activity.put("content",jsonArrayWeek1Content);
			
			jsonArrayWeek1Objective = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Env = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Activity = JSONFactoryUtil.createJSONArray();
			jsonArrayWeek1Content = JSONFactoryUtil.createJSONArray();
			content = JSONFactoryUtil.createJSONObject();
			DynamicQuery dynamicQueryWeekWise4 = DynamicQueryFactoryUtil.forClass(labDetailedActivityTable.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryWeekWise4.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("PK_projectId",PK_projectId),RestrictionsFactoryUtil.eq("week", new Long(4))));
			labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.dynamicQuery(dynamicQueryWeekWise4);
			if(labDetailedActivityTable.size()>0){				
				for(labDetailedActivityTable singleData:labDetailedActivityTable){					
					if(!(singleData.getCourseObjective().equalsIgnoreCase("")) && singleData.getCourseObjective()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("courseObjective", singleData.getCourseObjective());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Objective.put(jsonObject);
					}
					if(!(singleData.getLearningEnvironmentDesign().equalsIgnoreCase("")) && singleData.getLearningEnvironmentDesign()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("learningEnvironment", singleData.getLearningEnvironmentDesign());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Env.put(jsonObject);
					}
					if(!(singleData.getActivity().equalsIgnoreCase("")) && singleData.getActivity()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("activity", singleData.getActivity());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Activity.put(jsonObject);
					}
					if(!(singleData.getContent().equalsIgnoreCase("")) && singleData.getContent()!=null){
						jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("content", singleData.getContent());
						jsonObject.put("id", singleData.getPK_activityTableId());
						jsonArrayWeek1Content.put(jsonObject);
					}
				}
			}
			content.put("courseObjective",jsonArrayWeek1Objective);
			content.put("learningEnv",jsonArrayWeek1Env);
			content.put("activity",jsonArrayWeek1Activity);
			content.put("content",jsonArrayWeek1Content);
			
			
			JSONObject jsonObjectWeekwise = JSONFactoryUtil.createJSONObject();
			jsonObjectWeekwise.put("week1",courseObjective);
			jsonObjectWeekwise.put("week2",learningEnv);
			jsonObjectWeekwise.put("week3",activity);
			jsonObjectWeekwise.put("week4",content);
			out.print(jsonObjectWeekwise);
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void loadCourseTopics(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		PrintWriter out = null;
		List<labDetailedCourseTopics> labDetailedCourseTopics = null;
		try{
			out = resourceResponse.getWriter();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
			
			DynamicQuery dynamicQueryWeekWise = DynamicQueryFactoryUtil.forClass(labDetailedCourseTopics.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryWeekWise.add(RestrictionsFactoryUtil.eq("PK_projectId",PK_projectId));
			labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.dynamicQuery(dynamicQueryWeekWise);
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(labDetailedCourseTopics.size()>0){
				for(labDetailedCourseTopics singleData:labDetailedCourseTopics){
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("courseTopic",singleData.getCourseTopic());
					jsonObject.put("id", singleData.getPK_courseTopicsId());
					jsonArray.put(jsonObject);
				}
			}
			out.print(jsonArray);
		}
		catch(Exception e){
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void loadCourseObjectives(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		JSONObject jsonObject = null;
		PrintWriter out = null;
		JSONArray jsonArray = null;
		List<labDetailedCourseObjectives> labDetailedCourseObjectives = null;
		try{
			out = resourceResponse.getWriter();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
			
			DynamicQuery dynamicQueryWeekWise = DynamicQueryFactoryUtil.forClass(labDetailedCourseObjectives.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryWeekWise.add(RestrictionsFactoryUtil.eq("PK_projectId",PK_projectId));
			labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.dynamicQuery(dynamicQueryWeekWise);
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(labDetailedCourseObjectives.size()>0){
				for(labDetailedCourseObjectives singleData:labDetailedCourseObjectives){
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("courseObjectives",singleData.getCourseObjective());
					jsonObject.put("id", singleData.getPK_courseObjectivesId());
					jsonArray.put(jsonObject);
				}
			}
			out.print(jsonArray);
		}
		catch(Exception e){
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void loadCourseLearningEnvironment(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		JSONObject jsonObject = null;
		PrintWriter out = null;
		JSONArray jsonArray = null;
		List<labDetailedLearningEnvironments> labDetailedLearningEnvironments = null;
		try{
			out = resourceResponse.getWriter();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
			
			DynamicQuery dynamicQueryWeekWise = DynamicQueryFactoryUtil.forClass(labDetailedLearningEnvironments.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryWeekWise.add(RestrictionsFactoryUtil.eq("PK_projectId",PK_projectId));
			labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.dynamicQuery(dynamicQueryWeekWise);
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(labDetailedLearningEnvironments.size()>0){
				for(labDetailedLearningEnvironments singleData:labDetailedLearningEnvironments){
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("learningEnvironment",singleData.getLearningEnvironment());
					jsonObject.put("id", singleData.getPK_learningEnvironmentId());
					jsonArray.put(jsonObject);
				}
			}
			out.print(jsonArray);
		}
		catch(Exception e){
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void courseTopicSave(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		PrintWriter out = null;
		String courseTopic1 = ParamUtil.getString(resourceRequest, "courseTopics");
		long courseTopicId = ParamUtil.getLong(resourceRequest, "courseTopicId");
		labDetailedCourseTopics labDetailedCourseTopics = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			
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
			
			if(courseTopicId>0){
				labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.getlabDetailedCourseTopics(courseTopicId);
				labDetailedCourseTopics.setCourseTopic(courseTopic1);
				labDetailedCourseTopics.setPK_projectId(PK_projectId);
				labDetailedCourseTopics.setPK_courseId(PK_courseId);
				labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
				labDetailedCourseTopics.setCreateDate(new Date());
				labDetailedCourseTopicsLocalServiceUtil.updatelabDetailedCourseTopics(labDetailedCourseTopics);
				out.print("update");
			}else{
				labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.createlabDetailedCourseTopics(CounterLocalServiceUtil.increment());
				labDetailedCourseTopics.setCourseTopic(courseTopic1);
				labDetailedCourseTopics.setPK_projectId(PK_projectId);
				labDetailedCourseTopics.setPK_courseId(PK_courseId);
				labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
				labDetailedCourseTopics.setCreateDate(new Date());
				labDetailedCourseTopicsLocalServiceUtil.addlabDetailedCourseTopics(labDetailedCourseTopics);
				out.print("add");
			}
			
		}catch(Exception e){}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void courseObjectiveSave(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		PrintWriter out = null;
		String courseObjectiveAdd = ParamUtil.getString(resourceRequest, "courseObjectiveAdd");
		long courseObjectiveId = ParamUtil.getLong(resourceRequest, "courseObjectiveId");
		labDetailedCourseObjectives labDetailedCourseObjectives = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			
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
			
			if(courseObjectiveId>0){
				labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.getlabDetailedCourseObjectives(courseObjectiveId);
				labDetailedCourseObjectives.setCourseObjective(courseObjectiveAdd);
				labDetailedCourseObjectives.setPK_projectId(PK_projectId);
				labDetailedCourseObjectives.setPK_courseId(PK_courseId);
				labDetailedCourseObjectives.setUserId(themeDisplay.getUserId());
				labDetailedCourseObjectives.setCreateDate(new Date());
				labDetailedCourseObjectivesLocalServiceUtil.updatelabDetailedCourseObjectives(labDetailedCourseObjectives);
				out.print("update");
			}else{
				labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.createlabDetailedCourseObjectives(CounterLocalServiceUtil.increment());
				labDetailedCourseObjectives.setCourseObjective(courseObjectiveAdd);
				labDetailedCourseObjectives.setPK_projectId(PK_projectId);
				labDetailedCourseObjectives.setPK_courseId(PK_courseId);
				labDetailedCourseObjectives.setUserId(themeDisplay.getUserId());
				labDetailedCourseObjectives.setCreateDate(new Date());
				labDetailedCourseObjectivesLocalServiceUtil.updatelabDetailedCourseObjectives(labDetailedCourseObjectives);
				out.print("add");
			}
			
		}catch(Exception e){}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void courseLearningEnvironmentSave(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		PrintWriter out = null;
		String learningEnvironmentAdd = ParamUtil.getString(resourceRequest, "learningEnvironmentAdd");
		long learningEnvironmentId = ParamUtil.getLong(resourceRequest, "learningEnvironmentId");
		labDetailedLearningEnvironments labDetailedLearningEnvironments = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();			
			
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
			
			if(learningEnvironmentId>0){
				labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.getlabDetailedLearningEnvironments(learningEnvironmentId);
				labDetailedLearningEnvironments.setLearningEnvironment(learningEnvironmentAdd);
				labDetailedLearningEnvironments.setPK_projectId(PK_projectId);
				labDetailedLearningEnvironments.setPK_courseId(PK_courseId);
				labDetailedLearningEnvironments.setUserId(themeDisplay.getUserId());
				labDetailedLearningEnvironments.setCreateDate(new Date());
				labDetailedLearningEnvironmentsLocalServiceUtil.updatelabDetailedLearningEnvironments(labDetailedLearningEnvironments);
				out.print("update");
			}else{
				labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.createlabDetailedLearningEnvironments(CounterLocalServiceUtil.increment());
				labDetailedLearningEnvironments.setLearningEnvironment(learningEnvironmentAdd);
				labDetailedLearningEnvironments.setPK_courseId(PK_courseId);
				labDetailedLearningEnvironments.setPK_projectId(PK_projectId);
				labDetailedLearningEnvironments.setUserId(themeDisplay.getUserId());
				labDetailedLearningEnvironments.setCreateDate(new Date());
				labDetailedLearningEnvironmentsLocalServiceUtil.updatelabDetailedLearningEnvironments(labDetailedLearningEnvironments);
				out.print("add");
			}
			
		}catch(Exception e){}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void removeContent(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		PrintWriter out = null;
		long activityKey = ParamUtil.getLong(resourceRequest, "activityKey");
		//String contentRemovePopupType = ParamUtil.getString(resourceRequest, "activityType");
		List<labDetailedActivityTable> labDetailedActivityTable = null;
		List<labDetailedCourseTopics> labDetailedCourseTopics = null;
		List<labDetailedCourseObjectives> labDetailedCourseObjectives = null;
		List<labDetailedLearningEnvironments> labDetailedLearningEnvironments = null;
		String message = "";
		try{
			out = resourceResponse.getWriter();
			if(activityKey!=0){
//				labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.getlabDetailedActivityTable(activityKey);
//				if(labDetailedActivityTable!=null){
//					labDetailedActivityTableLocalServiceUtil.deletelabDetailedActivityTable(activityKey);
//					out.print("delete");
//				}
				
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				
				DynamicQuery dynamicQueryWeekWiseActivity = DynamicQueryFactoryUtil.forClass(labDetailedActivityTable.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryWeekWiseActivity.add(RestrictionsFactoryUtil.eq("PK_activityTableId",activityKey));
				labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.dynamicQuery(dynamicQueryWeekWiseActivity);
				if(labDetailedActivityTable.size()>0){
					labDetailedActivityTable labDetailedActivityTableSingle = labDetailedActivityTableLocalServiceUtil.getlabDetailedActivityTable(activityKey);
					if(labDetailedActivityTableSingle!=null){
						labDetailedActivityTableLocalServiceUtil.deletelabDetailedActivityTable(activityKey);
						jsonObject.put("message", "delete");
						jsonObject.put("type", "activity");
					}
				}
				
				DynamicQuery dynamicQueryWeekWise = DynamicQueryFactoryUtil.forClass(labDetailedLearningEnvironments.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryWeekWise.add(RestrictionsFactoryUtil.eq("PK_learningEnvironmentId",activityKey));
				labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.dynamicQuery(dynamicQueryWeekWise);
				if(labDetailedLearningEnvironments.size()>0){
					labDetailedLearningEnvironments labDetailedLearningEnvironmentsSingle = labDetailedLearningEnvironmentsLocalServiceUtil.getlabDetailedLearningEnvironments(activityKey);
					if(labDetailedLearningEnvironmentsSingle!=null){
						labDetailedLearningEnvironmentsLocalServiceUtil.deletelabDetailedLearningEnvironments(activityKey);
						jsonObject.put("message", "delete");
						jsonObject.put("type", "env");
					}
				}
				
				DynamicQuery dynamicQueryWeekWiseTopic = DynamicQueryFactoryUtil.forClass(labDetailedCourseTopics.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryWeekWiseTopic.add(RestrictionsFactoryUtil.eq("PK_courseTopicsId",activityKey));
				labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.dynamicQuery(dynamicQueryWeekWiseTopic);
				if(labDetailedCourseTopics.size()>0){
					labDetailedCourseTopics labDetailedCourseTopicsSingle = labDetailedCourseTopicsLocalServiceUtil.getlabDetailedCourseTopics(activityKey);
					if(labDetailedCourseTopicsSingle!=null){
						labDetailedCourseTopicsLocalServiceUtil.deletelabDetailedCourseTopics(activityKey);
						jsonObject.put("message", "delete");
						jsonObject.put("type", "topic");
					}
				}
				
				
				DynamicQuery dynamicQueryWeekWiseObjective = DynamicQueryFactoryUtil.forClass(labDetailedCourseObjectives.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryWeekWiseObjective.add(RestrictionsFactoryUtil.eq("PK_courseObjectivesId",activityKey));
				labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.dynamicQuery(dynamicQueryWeekWiseObjective);
				if(labDetailedCourseObjectives.size()>0){
					labDetailedCourseObjectives labDetailedCourseObjectivesSingle = labDetailedCourseObjectivesLocalServiceUtil.getlabDetailedCourseObjectives(activityKey);
					if(labDetailedCourseObjectivesSingle!=null){
						labDetailedCourseObjectivesLocalServiceUtil.deletelabDetailedCourseObjectives(activityKey);
						jsonObject.put("message", "delete");
						jsonObject.put("type", "objective");
					}
				}
				out.print(jsonObject);
				/*if(contentRemovePopupType.equalsIgnoreCase("week")){*/
					
				/*}*/
				/*if(contentRemovePopupType.equalsIgnoreCase("topic")){
					labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.getlabDetailedCourseTopics(activityKey);
					if(labDetailedCourseTopics!=null){
						labDetailedCourseTopicsLocalServiceUtil.deletelabDetailedCourseTopics(activityKey);
						out.print("delete");
					}
				}
				if(contentRemovePopupType.equalsIgnoreCase("objective")){
					labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.getlabDetailedCourseObjectives(activityKey);
					if(labDetailedCourseObjectives!=null){
						labDetailedCourseObjectivesLocalServiceUtil.deletelabDetailedCourseObjectives(activityKey);
						out.print("delete");
					}
				}
				if(contentRemovePopupType.equalsIgnoreCase("learning")){
					labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.getlabDetailedLearningEnvironments(activityKey);
					if(labDetailedLearningEnvironments!=null){
						labDetailedLearningEnvironmentsLocalServiceUtil.deletelabDetailedLearningEnvironments(activityKey);
						out.print("delete");
					}
				}*/
				System.out.println("message==="+message);
			}
		}catch(Exception e){ e.printStackTrace(); }
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void courseTopicUpdate(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		PrintWriter out = null;
		long courseTopics1Id = ParamUtil.getLong(resourceRequest, "courseTopics1Id");
		String courseTopics1 = ParamUtil.getString(resourceRequest, "courseTopics1");
		long courseTopics2Id = ParamUtil.getLong(resourceRequest, "courseTopics2Id");
		String courseTopics2 = ParamUtil.getString(resourceRequest, "courseTopics2");
		long courseTopics3Id = ParamUtil.getLong(resourceRequest, "courseTopics3Id");
		String courseTopics3 = ParamUtil.getString(resourceRequest, "courseTopics3");
		long courseTopics4Id = ParamUtil.getLong(resourceRequest, "courseTopics4Id");
		String courseTopics4 = ParamUtil.getString(resourceRequest, "courseTopics4");
		long courseTopics0Id = ParamUtil.getLong(resourceRequest, "courseTopics0Id");
		String courseTopics0 = ParamUtil.getString(resourceRequest, "courseTopics0");
		System.out.println("courseTopics1=="+courseTopics1);
		System.out.println("courseTopics1Id=="+courseTopics1Id);
		labDetailedCourseTopics labDetailedCourseTopics = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			
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
			
			if(courseTopics1Id>0){
				labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.getlabDetailedCourseTopics(courseTopics1Id);
				labDetailedCourseTopics.setCourseTopic(courseTopics1);
				labDetailedCourseTopics.setPK_courseId(PK_courseId);
				labDetailedCourseTopics.setPK_projectId(PK_projectId);
				labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
				labDetailedCourseTopics.setCreateDate(new Date());
				labDetailedCourseTopicsLocalServiceUtil.updatelabDetailedCourseTopics(labDetailedCourseTopics);
				out.print("update");
			}
			if(courseTopics2Id>0){
				labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.getlabDetailedCourseTopics(courseTopics2Id);
				labDetailedCourseTopics.setCourseTopic(courseTopics2);
				labDetailedCourseTopics.setPK_projectId(PK_projectId);
				labDetailedCourseTopics.setPK_courseId(PK_courseId);
				labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
				labDetailedCourseTopics.setCreateDate(new Date());
				labDetailedCourseTopicsLocalServiceUtil.updatelabDetailedCourseTopics(labDetailedCourseTopics);
				out.print("update");
			}
			if(courseTopics3Id>0){
				labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.getlabDetailedCourseTopics(courseTopics3Id);
				labDetailedCourseTopics.setCourseTopic(courseTopics3);
				labDetailedCourseTopics.setPK_projectId(PK_projectId);
				labDetailedCourseTopics.setPK_courseId(PK_courseId);
				labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
				labDetailedCourseTopics.setCreateDate(new Date());
				labDetailedCourseTopicsLocalServiceUtil.updatelabDetailedCourseTopics(labDetailedCourseTopics);
				out.print("update");
			}
			if(courseTopics4Id>0){
				labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.getlabDetailedCourseTopics(courseTopics4Id);
				labDetailedCourseTopics.setCourseTopic(courseTopics4);
				labDetailedCourseTopics.setPK_projectId(PK_projectId);
				labDetailedCourseTopics.setPK_courseId(PK_courseId);
				labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
				labDetailedCourseTopics.setCreateDate(new Date());
				labDetailedCourseTopicsLocalServiceUtil.updatelabDetailedCourseTopics(labDetailedCourseTopics);
				out.print("update");
			}
			if(courseTopics0Id>0){
				labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.getlabDetailedCourseTopics(courseTopics0Id);
				labDetailedCourseTopics.setCourseTopic(courseTopics0);
				labDetailedCourseTopics.setPK_projectId(PK_projectId);
				labDetailedCourseTopics.setPK_courseId(PK_courseId);
				labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
				labDetailedCourseTopics.setCreateDate(new Date());
				labDetailedCourseTopicsLocalServiceUtil.updatelabDetailedCourseTopics(labDetailedCourseTopics);
				out.print("update");
			}
		}catch(Exception e){}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	
	public void courseObjectiveUpdate(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		PrintWriter out = null;
		long courseObjectives1Id = ParamUtil.getLong(resourceRequest, "courseObjectives1Id");
		String courseObjectives1 = ParamUtil.getString(resourceRequest, "courseObjectives1");
		long courseObjectives2Id = ParamUtil.getLong(resourceRequest, "courseObjectives2Id");
		String courseObjectives2 = ParamUtil.getString(resourceRequest, "courseObjectives2");
		long courseObjectives0Id = ParamUtil.getLong(resourceRequest, "courseObjectives0Id");
		String courseObjectives0 = ParamUtil.getString(resourceRequest, "courseObjectives0");
		labDetailedCourseObjectives labDetailedCourseObjectives = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			
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
			
			if(courseObjectives1Id>0){
				labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.getlabDetailedCourseObjectives(courseObjectives1Id);
				labDetailedCourseObjectives.setCourseObjective(courseObjectives1);
				labDetailedCourseObjectives.setPK_courseId(PK_courseId);
				labDetailedCourseObjectives.setPK_projectId(PK_projectId);
				labDetailedCourseObjectives.setUserId(themeDisplay.getUserId());
				labDetailedCourseObjectives.setCreateDate(new Date());
				labDetailedCourseObjectivesLocalServiceUtil.updatelabDetailedCourseObjectives(labDetailedCourseObjectives);
				out.print("update");
			}
			if(courseObjectives2Id>0){
				labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.getlabDetailedCourseObjectives(courseObjectives2Id);
				labDetailedCourseObjectives.setCourseObjective(courseObjectives2);
				labDetailedCourseObjectives.setPK_courseId(PK_courseId);
				labDetailedCourseObjectives.setPK_projectId(PK_projectId);
				labDetailedCourseObjectives.setUserId(themeDisplay.getUserId());
				labDetailedCourseObjectives.setCreateDate(new Date());
				labDetailedCourseObjectivesLocalServiceUtil.updatelabDetailedCourseObjectives(labDetailedCourseObjectives);
				out.print("update");
			}
			if(courseObjectives0Id>0){
				labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.getlabDetailedCourseObjectives(courseObjectives0Id);
				labDetailedCourseObjectives.setCourseObjective(courseObjectives0);
				labDetailedCourseObjectives.setPK_courseId(PK_courseId);
				labDetailedCourseObjectives.setPK_projectId(PK_projectId);
				labDetailedCourseObjectives.setUserId(themeDisplay.getUserId());
				labDetailedCourseObjectives.setCreateDate(new Date());
				labDetailedCourseObjectivesLocalServiceUtil.updatelabDetailedCourseObjectives(labDetailedCourseObjectives);
				out.print("update");
			}
		}catch(Exception e){}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void courseLearningEnvironmentUpdate(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		PrintWriter out = null;
		long learningEnvironment1Id = ParamUtil.getLong(resourceRequest, "learningEnvironment1Id");
		String learningEnvironment1 = ParamUtil.getString(resourceRequest, "learningEnvironment1");
		long learningEnvironment2Id = ParamUtil.getLong(resourceRequest, "learningEnvironment2Id");
		String learningEnvironment2 = ParamUtil.getString(resourceRequest, "learningEnvironment2");
		long learningEnvironment0Id = ParamUtil.getLong(resourceRequest, "learningEnvironment0Id");
		String learningEnvironment0 = ParamUtil.getString(resourceRequest, "learningEnvironment0");
		labDetailedLearningEnvironments labDetailedLearningEnvironments = null;String message = "";
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			
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
			
			if(learningEnvironment1Id>0){
				labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.getlabDetailedLearningEnvironments(learningEnvironment1Id);
				labDetailedLearningEnvironments.setLearningEnvironment(learningEnvironment1);
				labDetailedLearningEnvironments.setPK_courseId(PK_courseId);
				labDetailedLearningEnvironments.setPK_projectId(PK_projectId);
				labDetailedLearningEnvironments.setUserId(themeDisplay.getUserId());
				labDetailedLearningEnvironments.setCreateDate(new Date());
				labDetailedLearningEnvironmentsLocalServiceUtil.updatelabDetailedLearningEnvironments(labDetailedLearningEnvironments);
				message = "update";				
			}
			if(learningEnvironment2Id>0){
				labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.getlabDetailedLearningEnvironments(learningEnvironment2Id);
				labDetailedLearningEnvironments.setLearningEnvironment(learningEnvironment2);
				labDetailedLearningEnvironments.setPK_courseId(PK_courseId);
				labDetailedLearningEnvironments.setPK_projectId(PK_projectId);
				labDetailedLearningEnvironments.setUserId(themeDisplay.getUserId());
				labDetailedLearningEnvironments.setCreateDate(new Date());
				labDetailedLearningEnvironmentsLocalServiceUtil.updatelabDetailedLearningEnvironments(labDetailedLearningEnvironments);
				message = "update";
			}
			if(learningEnvironment0Id>0){
				labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.getlabDetailedLearningEnvironments(learningEnvironment0Id);
				labDetailedLearningEnvironments.setLearningEnvironment(learningEnvironment0);
				labDetailedLearningEnvironments.setPK_courseId(PK_courseId);
				labDetailedLearningEnvironments.setPK_projectId(PK_projectId);
				labDetailedLearningEnvironments.setUserId(themeDisplay.getUserId());
				labDetailedLearningEnvironments.setCreateDate(new Date());
				labDetailedLearningEnvironmentsLocalServiceUtil.updatelabDetailedLearningEnvironments(labDetailedLearningEnvironments);
				message = "update";
			}
			out.print(message);
		}catch(Exception e){}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
}