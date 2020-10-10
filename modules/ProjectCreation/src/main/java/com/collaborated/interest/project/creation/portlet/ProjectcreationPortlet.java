package com.collaborated.interest.project.creation.portlet;

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
import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.service.labDetailedActivityTableLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseHoursLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseIdentificationLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseObjectivesLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseResourcesLocalServiceUtil;
import com.collaborated.entity.service.labDetailedCourseTopicsLocalService;
import com.collaborated.entity.service.labDetailedCourseTopicsLocalServiceUtil;
import com.collaborated.entity.service.labDetailedInstructorQualificationLocalServiceUtil;
import com.collaborated.entity.service.labDetailedLearningEnvironmentsLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil;
import com.collaborated.entity.service.projectInviteTrackingLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
//import com.opencsv.CSVReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.awt.color.ProfileDataException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
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
		"javax.portlet.display-name=ProjectCreation Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProjectcreationPortlet extends MVCPortlet {
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		PortletSession session = renderRequest.getPortletSession();
		//partnersList = (List<labScreenProjectPartners>)session.getAttribute("LIFERAY_SHARED_PROJECT_PARTNERS", PortletSession.APPLICATION_SCOPE);
		super.doView(renderRequest, renderResponse); // make sure this is the last line in your method
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if (resourceID != null && resourceID.equals("getProjectDetailsCreation")) {
			getProjectDetailsCreation(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("projectCreation")) {
			projectCreation(resourceRequest,resourceResponse);
		}
	}
	
	public void getProjectDetailsCreation(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long key = ParamUtil.getLong(resourceRequest, "key");
		PrintWriter out = null;
		JSONObject jsonObject = null;
		profileAreaofinterest profileAreaofinterest = null;
		labScreenProjectOverview labScreenProjectOverview = null;
		String discipline1 = "", discipline2 = "", discipline3 = "";
		try{
			out = resourceResponse.getWriter();
			jsonObject = JSONFactoryUtil.createJSONObject();	
			
			if(key!=0){
				profileAreaofinterest = profileAreaofinterestLocalServiceUtil.fetchprofileAreaofinterest(key);
				if(profileAreaofinterest!=null){
					discipline1 = profileAreaofinterest.getDiscipline1();
					discipline2 = profileAreaofinterest.getDiscipline2();
					discipline3 = profileAreaofinterest.getDiscipline3();
					jsonObject.put("projectType", profileAreaofinterest.getProjectType());
					jsonObject.put("description", profileAreaofinterest.getDescription());												
				}
				DynamicQuery dynamicQueryTask = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryTask.add(RestrictionsFactoryUtil.eq("interestId",key));
				List<labScreenProjectOverview> trackNotificationCountTask = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(dynamicQueryTask);
				if(trackNotificationCountTask.size()>0){
					discipline1 = trackNotificationCountTask.get(0).getProjectDiscipline1();
					discipline2 = trackNotificationCountTask.get(0).getProjectDiscipline2();
					discipline3 = trackNotificationCountTask.get(0).getProjectDiscipline3();
					jsonObject.put("projectName", trackNotificationCountTask.get(0).getProjectName());
					jsonObject.put("role", trackNotificationCountTask.get(0).getRole());
					jsonObject.put("startDate", trackNotificationCountTask.get(0).getProjectStartDate());
					jsonObject.put("endDate", trackNotificationCountTask.get(0).getProjectEndDate());
					jsonObject.put("projectCreationId", trackNotificationCountTask.get(0).getPK_projectId());
					jsonObject.put("isEdit", "Yes");
				}else{
					jsonObject.put("isEdit", "No");
				}
				
				jsonObject.put("discipline1", discipline1);	
				jsonObject.put("discipline2", discipline2);	
				jsonObject.put("discipline3", discipline3);
			}
			out.print(jsonObject);
		}catch(Exception e){}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void projectCreation(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long projectCreationId = ParamUtil.getLong(resourceRequest, "projectCreationId");
		long interestId = ParamUtil.getLong(resourceRequest, "interestId");
		String projectType = ParamUtil.getString(resourceRequest, "projectTypeSave");
		String projectName = ParamUtil.getString(resourceRequest, "projectName");
		String projectDescription = ParamUtil.getString(resourceRequest, "projectDescription");
		String projectDiscipline1 = ParamUtil.getString(resourceRequest, "projectDiscipline1");
		String projectDiscipline2 = ParamUtil.getString(resourceRequest, "projectDiscipline2");
		String projectDiscipline3 = ParamUtil.getString(resourceRequest, "projectDiscipline3");
		String role = ParamUtil.getString(resourceRequest, "role");
		String projectStartDate = ParamUtil.getString(resourceRequest, "projectStartDate");
		String projectEndDate = ParamUtil.getString(resourceRequest, "projectEndDate");
		///CSV file
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File fileupload = uploadRequest.getFile("courseControlDocument");
		String fileName = fileupload.getName();
		int pos = fileName.lastIndexOf('.');
		String fileExtension = fileName.substring(pos + 1);
		if (Validator.isNull(fileExtension) || !(fileExtension.equalsIgnoreCase("csv"))) {
			
		}
		
		String courseTitle = "",courseNumber="",prerequisites="",courseDescription="";
		long numberOfCredits = 0,numberOfCourseWeeks=0,courseHoursPerWeek=0,lectureHoursPerWeek=0,labHoursPerWeek=0,independentStudyHoursPerWeek=0;
		String textBookTitle = "",publisherName = "",author="", isbn="";
		String instructor1Qualification="", instructor2Qualification="";
		String courseTopic1="",courseTopic2="",courseTopic3="",courseTopic4="",courseTopic5="";
		String courseObjective1="",courseObjective2="",courseObjective3="";
		String learningEnvironment1="", learningEnvironment2="",learningEnvironment3="";
		long week1 = 0,week2 = 0,week3 = 0, week4 = 0;
		String activitycourseObjective1 = "", activitycourseObjective2 = "", activitycourseObjective3 = "";
		String activitylearningEnvironmentDesign1 = "", activitylearningEnvironmentDesign2 = "", activitylearningEnvironmentDesign3 = "";
		String activity1 = "", activity2 = "", activity3 = "";
		String content1 = "", content2 = "", content3 = "";
		
		String activitycourseObjective1week2 = "", activitycourseObjective2week2 = "", activitycourseObjective3week2 = "";
		String activitylearningEnvironmentDesign1week2 = "", activitylearningEnvironmentDesign2week2 = "", activitylearningEnvironmentDesign3week2 = "";
		String activity1week2 = "", activity2week2 = "", activity3week2 = "";
		String content1week2 = "", content2week2 = "", content3week2 = "";
		
		String activitycourseObjective1week3 = "", activitycourseObjective2week3 = "", activitycourseObjective3week3 = "";
		String activitylearningEnvironmentDesign1week3 = "", activitylearningEnvironmentDesign2week3 = "", activitylearningEnvironmentDesign3week3 = "";
		String activity1week3 = "", activity2week3 = "", activity3week3 = "";
		String content1week3 = "", content2week3 = "", content3week3 = "";
		
		String activitycourseObjective1week4 = "", activitycourseObjective2week4 = "", activitycourseObjective3week4 = "";
		String activitylearningEnvironmentDesign1week4 = "", activitylearningEnvironmentDesign2week4 = "", activitylearningEnvironmentDesign3week4 = "";
		String activity1week4 = "", activity2week4 = "", activity3week4 = "";
		String content1week4 = "", content2week4 = "", content3week4 = "";
		
		labDetailedCourseIdentification courseIdentification = null;
		labDetailedCourseHours labDetailedCourseHours = null;
		labDetailedCourseResources labDetailedCourseResources = null;
		labDetailedInstructorQualification labDetailedInstructorQualification = null;
		
		labDetailedCourseTopics labDetailedCourseTopics = null;
		labDetailedCourseObjectives labDetailedCourseObjectives = null;
		labDetailedLearningEnvironments labDetailedLearningEnvironments = null;
		labDetailedActivityTable labDetailedActivityTable = null;
		
		long PK_courseId = 0;
				
		if (Validator.isNotNull(fileExtension)  && fileExtension.equalsIgnoreCase("csv")) {			
			FileReader filereader = new FileReader(fileupload);			  
            // create csvParser object with 
            // custom seperator semi-colon 
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();  
            // create csvReader object with 
            // parameter filereader and parser 
            CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build(); 
            // Read all data at once 
            List<String[]> allData = csvReader.readAll();  
            // print Data 
            for (String[] row : allData) {  
                if(row[0].equals("Course Title")){
                	courseTitle = row[1];
                }
                if(row[0].equals("Course Number")){
                	courseNumber = row[1];
                }
                if(row[0].equals("Prerequisites")){
                	prerequisites = row[1];
                }
                if(row[0].equals("Course Description")){
                	courseDescription = row[1];
                }
                if(row[0].equals("Credit Hours")){
                	numberOfCredits = Long.valueOf(row[1]);
                }
                if(row[0].equals("Number of course weeks")){
                	numberOfCourseWeeks = Long.valueOf(row[1]);
                }
                if(row[0].equals("Contact Hours")){
                	courseHoursPerWeek = Long.valueOf(row[1]);
                }
                if(row[0].equals("Lecture Hours")){
                	lectureHoursPerWeek = Long.valueOf(row[1]);
                }
                if(row[0].equals("Lab Hours")){
                	labHoursPerWeek = Long.valueOf(row[1]);
                }
                if(row[0].equals("Independent Study Hours")){
                	independentStudyHoursPerWeek = Long.valueOf(row[1]);
                }
                if(row[0].equals("Textbook Title")){
                	textBookTitle = row[1];
                }
                if(row[0].equals("Publisher's Name")){
                	publisherName = row[1];
                }
                if(row[0].equals("Author")){
                	author = row[1];
                }
                if(row[0].equals("ISBN")){
                	isbn = row[1];
                }
                if(row[0].equals("Instructor 1 Qualifications")){
                	instructor1Qualification = row[1];
                }
                if(row[0].equals("Instructor 2 Qualifications")){
                	instructor2Qualification = row[1];
                }
                if(row[0].equals("Course Topic 1")){
                	courseTopic1 = row[1];
                }
                if(row[0].equals("Course Topic 2")){
                	courseTopic2 = row[1];
                }
                if(row[0].equals("Course Topic 3")){
                	courseTopic3 = row[1];
                }
                if(row[0].equals("Course Topic 4")){
                	courseTopic4 = row[1];
                }
                if(row[0].equals("Course Topic 5")){
                	courseTopic5 = row[1];
                }
                if(row[0].equals("Course Objective 1")){
                	courseObjective1 = row[1];
                }
                if(row[0].equals("Course Objective 2")){
                	courseObjective2 = row[1];
                }
                if(row[0].equals("Course Objective 3")){
                	courseObjective3 = row[1];
                }
                if(row[0].equals("Learning Environment 1")){
                	learningEnvironment1 = row[1];
                }
                if(row[0].equals("Learning Environment 2")){
                	learningEnvironment2 = row[1];
                }
                if(row[0].equals("Learning Environment 3")){
                	learningEnvironment3 = row[1];
                }
                if(row[0].equals("Week 1 - Course Objective 1")){
                	week1 = 1;
                	activitycourseObjective1 = row[1];
                }
                if(row[0].equals("Week 1 - Course Objective 2")){
                	activitycourseObjective2 = row[1];
                }
                if(row[0].equals("Week 1 - Course Objective 3")){
                	activitycourseObjective3 = row[1];
                }
                if(row[0].equals("Week 1 - Learning Environment Design 1")){
                	activitylearningEnvironmentDesign1 = row[1];
                }
                if(row[0].equals("Week 1 - Learning Environment Design 2")){
                	activitylearningEnvironmentDesign2 = row[1];
                }
                if(row[0].equals("Week 1 - Learning Environment Design 3")){
                	activitylearningEnvironmentDesign3 = row[1];
                }
                if(row[0].equals("Week 1 - Activity 1")){
                	activity1 = row[1];
                }
                if(row[0].equals("Week 1 - Activity 2")){
                	activity2 = row[1];
                }
                if(row[0].equals("Week 1 - Activity 3")){
                	activity3 = row[1];
                }
                if(row[0].equals("Week 1 - Content 1")){
                	content1 = row[1];
                }
                if(row[0].equals("Week 1 - Content 2")){
                	content2 = row[1];
                }
                if(row[0].equals("Week 1 - Content 3")){
                	content3 = row[1];
                }
                if(row[0].equals("Week 2 - Course Objective 1")){
                	week2 = 2;
                	activitycourseObjective1week2 = row[1];
                }
                if(row[0].equals("Week 2 - Course Objective 2")){
                	activitycourseObjective2week2 = row[1];
                }
                if(row[0].equals("Week 2 - Course Objective 3")){
                	activitycourseObjective3week2 = row[1];
                }
                if(row[0].equals("Week 2 - Learning Environment Design 1")){
                	activitylearningEnvironmentDesign1week2 = row[1];
                }
                if(row[0].equals("Week 2 - Learning Environment Design 2")){
                	activitylearningEnvironmentDesign2week2 = row[1];
                }
                if(row[0].equals("Week 2 - Learning Environment Design 3")){
                	activitylearningEnvironmentDesign3week2 = row[1];
                }
                if(row[0].equals("Week 2 - Activity 1")){
                	activity1week2 = row[1];
                }
                if(row[0].equals("Week 2 - Activity 2")){
                	activity2week2 = row[1];
                }
                if(row[0].equals("Week 2 - Activity 3")){
                	activity3week2 = row[1];
                }
                if(row[0].equals("Week 2 - Content 1")){
                	content1week2 = row[1];
                }
                if(row[0].equals("Week 2 - Content 2")){
                	content2week2 = row[1];
                }
                if(row[0].equals("Week 2 - Content 3")){
                	content3week2 = row[1];
                }
                if(row[0].equals("Week 3 - Course Objective 1")){
                	week3 = 3;
                	activitycourseObjective1week3 = row[1];
                }
                if(row[0].equals("Week 3 - Course Objective 2")){
                	activitycourseObjective2week3 = row[1];
                }
                if(row[0].equals("Week 3 - Course Objective 3")){
                	activitycourseObjective3week3 = row[1];
                }
                if(row[0].equals("Week 3 - Learning Environment Design 1")){
                	activitylearningEnvironmentDesign1week3 = row[1];
                }
                if(row[0].equals("Week 3 - Learning Environment Design 2")){
                	activitylearningEnvironmentDesign2week3 = row[1];
                }
                if(row[0].equals("Week 3 - Learning Environment Design 3")){
                	activitylearningEnvironmentDesign3week3 = row[1];
                }
                if(row[0].equals("Week 3 - Activity 1")){
                	activity1week3 = row[1];
                }
                if(row[0].equals("Week 3 - Activity 2")){
                	activity2week3 = row[1];
                }
                if(row[0].equals("Week 3 - Activity 3")){
                	activity3week3 = row[1];
                }
                if(row[0].equals("Week 3 - Content 1")){
                	content1week3 = row[1];
                }
                if(row[0].equals("Week 3 - Content 2")){
                	content2week3 = row[1];
                }
                if(row[0].equals("Week 3 - Content 3")){
                	content3week3 = row[1];
                }
                if(row[0].equals("Week 4 - Course Objective 1")){
                	week4 = 4;
                	activitycourseObjective1week4 = row[1];
                }
                if(row[0].equals("Week 4 - Course Objective 2")){
                	activitycourseObjective2week4 = row[1];
                }
                if(row[0].equals("Week 4 - Course Objective 3")){
                	activitycourseObjective3week4 = row[1];
                }
                if(row[0].equals("Week 4 - Learning Environment Design 1")){
                	activitylearningEnvironmentDesign1week4 = row[1];
                }
                if(row[0].equals("Week 4 - Learning Environment Design 2")){
                	activitylearningEnvironmentDesign2week4 = row[1];
                }
                if(row[0].equals("Week 4 - Learning Environment Design 3")){
                	activitylearningEnvironmentDesign3week4 = row[1];
                }
                if(row[0].equals("Week 4 - Activity 1")){
                	activity1week4 = row[1];
                }
                if(row[0].equals("Week 4 - Activity 2")){
                	activity2week4 = row[1];
                }
                if(row[0].equals("Week 4 - Activity 3")){
                	activity3week4 = row[1];
                }
                if(row[0].equals("Week 4 - Content 1")){
                	content1week4 = row[1];
                }
                if(row[0].equals("Week 4 - Content 2")){
                	content2week4 = row[1];
                }
                if(row[0].equals("Week 4 - Content 3")){
                	content3week4 = row[1];
                }
            } 
		}
		
		PrintWriter out = null;
		try{
			out = resourceResponse.getWriter();
			if(projectCreationId!=0){
				labScreenProjectOverview labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverview(projectCreationId);
				labScreenProjectOverview.setProjectType(projectType);
				labScreenProjectOverview.setProjectName(projectName);
				labScreenProjectOverview.setProjectDescription(projectDescription);
				labScreenProjectOverview.setProjectDiscipline1(projectDiscipline1);
				labScreenProjectOverview.setProjectDiscipline2(projectDiscipline2);
				labScreenProjectOverview.setProjectDiscipline3(projectDiscipline3);
				labScreenProjectOverview.setRole(role);
				labScreenProjectOverview.setProjectStartDate(projectStartDate);
				labScreenProjectOverview.setProjectEndDate(projectEndDate);
				//labScreenProjectOverview.setInterestId(interestId);
				labScreenProjectOverviewLocalServiceUtil.updatelabScreenProjectOverview(labScreenProjectOverview);
				
				/*PortletSession ps = resourceRequest.getPortletSession();
				ps.setAttribute("LIFERAY_SHARED_PROJECT_KEY", String.valueOf(labScreenProjectOverview.getPK_projectId()), PortletSession.APPLICATION_SCOPE);
				ps.setAttribute("LIFERAY_SHARED_PROJECT_INTEREST_KEY", String.valueOf(interestId), PortletSession.APPLICATION_SCOPE);*/
				HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
				httprequest = PortalUtil.getOriginalServletRequest(httprequest);

				HttpSession session = httprequest.getSession();
				session.removeAttribute("PROJECT_KEY");
				session.removeAttribute("PROJECT_INTEREST_KEY");
				session.setAttribute("PROJECT_KEY", String.valueOf(labScreenProjectOverview.getPK_projectId()));
				session.setAttribute("PROJECT_INTEREST_KEY", String.valueOf(interestId));
				session.setAttribute("currentUser", themeDisplay.getUserId());
				out.print("update");
			}else{
				labScreenProjectOverview labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.createlabScreenProjectOverview(CounterLocalServiceUtil.increment());
				labScreenProjectOverview.setProjectType(projectType);
				labScreenProjectOverview.setProjectName(projectName);
				labScreenProjectOverview.setProjectDescription(projectDescription);
				labScreenProjectOverview.setProjectDiscipline1(projectDiscipline1);
				labScreenProjectOverview.setProjectDiscipline2(projectDiscipline2);
				labScreenProjectOverview.setProjectDiscipline3(projectDiscipline3);
				labScreenProjectOverview.setRole(role);
				labScreenProjectOverview.setProjectStartDate(projectStartDate);
				labScreenProjectOverview.setProjectEndDate(projectEndDate);
				labScreenProjectOverview.setProjectOwnerId(themeDisplay.getUserId());
				labScreenProjectOverview.setInterestId(interestId);
				labScreenProjectOverviewLocalServiceUtil.addlabScreenProjectOverview(labScreenProjectOverview);
				
				long PK_projectId = labScreenProjectOverview.getPK_projectId();
				
				List<labScreenProjectPartners> partnersList = null;
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());				 
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.eq("PK_projectId", new Long(interestId));				 
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("isActive", new Long(0)));
				dynamicQuery.add(criterion);
				 
				partnersList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQuery);
				
				if(partnersList.size()>0){
					for(labScreenProjectPartners singleData:partnersList){
						projectInviteTracking projectInviteTracking = projectInviteTrackingLocalServiceUtil.createprojectInviteTracking(CounterLocalServiceUtil.increment());
						projectInviteTracking.setProjectId(PK_projectId);
						projectInviteTracking.setInviteFrom(themeDisplay.getUserId());
						projectInviteTracking.setInviteTo(singleData.getProjectPartnerId());
						projectInviteTracking.setInvitationStatus("");
						projectInviteTracking.setIsRead(0);
						projectInviteTracking.setIsRemoved(4);
						projectInviteTracking.setMessageContent(themeDisplay.getUser().getFullName()+ " has started "+projectName + " project");
						projectInviteTracking.setCreateDate(new Date());
						projectInviteTrackingLocalServiceUtil.addprojectInviteTracking(projectInviteTracking);
					}
				}
				
				/*projectInviteTracking projectInviteTracking = projectInviteTrackingLocalServiceUtil.createprojectInviteTracking(CounterLocalServiceUtil.increment());
				projectInviteTracking.setProjectId(PK_projectId);
				projectInviteTracking.setInviteFrom(labScreenTask.getUserId());
				projectInviteTracking.setInviteTo(labScreenTask.getProjectAssignedTo());
				projectInviteTracking.setInvitationStatus("");
				projectInviteTracking.setIsRead(0);
				projectInviteTracking.setIsRemoved(4);
				projectInviteTracking.setMessageContent(" "+projectName + " project");
				projectInviteTracking.setCreateDate(new Date());
				projectInviteTrackingLocalServiceUtil.addprojectInviteTracking(projectInviteTracking);*/
				
				
			if (Validator.isNotNull(fileExtension)  && fileExtension.equalsIgnoreCase("csv")) {
				
				if(courseTitle!=""){
					courseIdentification = labDetailedCourseIdentificationLocalServiceUtil.createlabDetailedCourseIdentification(CounterLocalServiceUtil.increment());
					courseIdentification.setUserId(themeDisplay.getUserId());
					courseIdentification.setCreateDate(new Date());
					courseIdentification.setCourseTitle(courseTitle);
					courseIdentification.setCourseNumber(courseNumber);
					courseIdentification.setPrerequisites(prerequisites);
					courseIdentification.setCourseDescription(courseDescription);
					courseIdentification.setPK_projectId(PK_projectId);
					labDetailedCourseIdentificationLocalServiceUtil.addlabDetailedCourseIdentification(courseIdentification);
					PK_courseId = courseIdentification.getPK_courseId();
				}
				
				if(numberOfCredits!=0 || numberOfCourseWeeks!=0 || courseHoursPerWeek!=0 || lectureHoursPerWeek!=0 || labHoursPerWeek!=0 || independentStudyHoursPerWeek!=0){
					labDetailedCourseHours = labDetailedCourseHoursLocalServiceUtil.createlabDetailedCourseHours(CounterLocalServiceUtil.increment());
					labDetailedCourseHours.setUserId(themeDisplay.getUserId());
					labDetailedCourseHours.setCreateDate(new Date());
					labDetailedCourseHours.setPK_projectId(PK_projectId);
					labDetailedCourseHours.setPK_courseId(PK_courseId);
					labDetailedCourseHours.setNumberOfCredits(numberOfCredits);
					labDetailedCourseHours.setNumberOfCourseWeeks(numberOfCourseWeeks);
					labDetailedCourseHours.setCourseHoursPerWeek(courseHoursPerWeek);
					labDetailedCourseHours.setLectureHoursPerWeek(lectureHoursPerWeek);
					labDetailedCourseHours.setLabHoursPerWeek(labHoursPerWeek);
					labDetailedCourseHours.setIndependentStudyHoursPerWeek(independentStudyHoursPerWeek);
					labDetailedCourseHoursLocalServiceUtil.addlabDetailedCourseHours(labDetailedCourseHours);
				}
				
				if(textBookTitle!="" || publisherName!="" || author!="" || isbn!=""){
					labDetailedCourseResources = labDetailedCourseResourcesLocalServiceUtil.createlabDetailedCourseResources(CounterLocalServiceUtil.increment());
					labDetailedCourseResources.setUserId(themeDisplay.getUserId());
					labDetailedCourseResources.setCreateDate(new Date());
					labDetailedCourseResources.setPK_courseId(PK_courseId);
					labDetailedCourseResources.setPK_projectId(PK_projectId);
					labDetailedCourseResources.setTextbokTitle(textBookTitle);
					labDetailedCourseResources.setPublisherName(publisherName);
					labDetailedCourseResources.setAuthor(author);
					labDetailedCourseResources.setIsbn(isbn);
					labDetailedCourseResourcesLocalServiceUtil.addlabDetailedCourseResources(labDetailedCourseResources);
				}
				
				if(instructor1Qualification!="" || instructor2Qualification!=""){
					labDetailedInstructorQualification = labDetailedInstructorQualificationLocalServiceUtil.createlabDetailedInstructorQualification(CounterLocalServiceUtil.increment());
					labDetailedInstructorQualification.setUserId(themeDisplay.getUserId());
					labDetailedInstructorQualification.setCreateDate(new Date());
					labDetailedInstructorQualification.setPK_projectId(PK_projectId);
					labDetailedInstructorQualification.setPK_courseId(PK_courseId);
					labDetailedInstructorQualification.setInstructor1Qualification(instructor1Qualification);
					labDetailedInstructorQualification.setInstructor2Qualification(instructor2Qualification);
					labDetailedInstructorQualificationLocalServiceUtil.addlabDetailedInstructorQualification(labDetailedInstructorQualification);				
				}
				
				
				if(!(courseTopic1.equalsIgnoreCase("")) && courseTopic1!=null){
					labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.createlabDetailedCourseTopics(CounterLocalServiceUtil.increment());
					labDetailedCourseTopics.setCourseTopic(courseTopic1);
					labDetailedCourseTopics.setPK_courseId(PK_courseId);
					labDetailedCourseTopics.setPK_projectId(PK_projectId);
					labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
					labDetailedCourseTopics.setCreateDate(new Date());
					labDetailedCourseTopicsLocalServiceUtil.addlabDetailedCourseTopics(labDetailedCourseTopics);
				}
				
				if(!(courseTopic2.equalsIgnoreCase("")) && courseTopic2!=null){
					labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.createlabDetailedCourseTopics(CounterLocalServiceUtil.increment());
					labDetailedCourseTopics.setCourseTopic(courseTopic2);
					labDetailedCourseTopics.setPK_courseId(PK_courseId);
					labDetailedCourseTopics.setPK_projectId(PK_projectId);
					labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
					labDetailedCourseTopics.setCreateDate(new Date());
					labDetailedCourseTopicsLocalServiceUtil.addlabDetailedCourseTopics(labDetailedCourseTopics);
				}
				
				if(!(courseTopic3.equalsIgnoreCase("")) && courseTopic3!=null){
					labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.createlabDetailedCourseTopics(CounterLocalServiceUtil.increment());
					labDetailedCourseTopics.setCourseTopic(courseTopic3);
					labDetailedCourseTopics.setPK_courseId(PK_courseId);
					labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
					labDetailedCourseTopics.setCreateDate(new Date());
					labDetailedCourseTopicsLocalServiceUtil.addlabDetailedCourseTopics(labDetailedCourseTopics);
				}
				
				if(!(courseTopic4.equalsIgnoreCase("")) && courseTopic4!=null){
					labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.createlabDetailedCourseTopics(CounterLocalServiceUtil.increment());
					labDetailedCourseTopics.setCourseTopic(courseTopic4);
					labDetailedCourseTopics.setPK_courseId(PK_courseId);
					labDetailedCourseTopics.setPK_projectId(PK_projectId);
					labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
					labDetailedCourseTopics.setCreateDate(new Date());
					labDetailedCourseTopicsLocalServiceUtil.addlabDetailedCourseTopics(labDetailedCourseTopics);
				}
				
				if(!(courseTopic5.equalsIgnoreCase("")) && courseTopic5!=null){
					labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.createlabDetailedCourseTopics(CounterLocalServiceUtil.increment());
					labDetailedCourseTopics.setCourseTopic(courseTopic5);
					labDetailedCourseTopics.setPK_courseId(PK_courseId);
					labDetailedCourseTopics.setPK_projectId(PK_projectId);
					labDetailedCourseTopics.setUserId(themeDisplay.getUserId());
					labDetailedCourseTopics.setCreateDate(new Date());
					labDetailedCourseTopicsLocalServiceUtil.addlabDetailedCourseTopics(labDetailedCourseTopics);
				}
				
				if(!(courseObjective1.equalsIgnoreCase("")) && courseObjective1!=null){
					labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.createlabDetailedCourseObjectives(CounterLocalServiceUtil.increment());
					labDetailedCourseObjectives.setCourseObjective(courseObjective1);
					labDetailedCourseObjectives.setPK_courseId(PK_courseId);
					labDetailedCourseObjectives.setPK_projectId(PK_projectId);
					labDetailedCourseObjectives.setUserId(themeDisplay.getUserId());
					labDetailedCourseObjectives.setCreateDate(new Date());
					labDetailedCourseObjectivesLocalServiceUtil.addlabDetailedCourseObjectives(labDetailedCourseObjectives);
				}
				
				if(!(courseObjective2.equalsIgnoreCase("")) && courseObjective2!=null){
					labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.createlabDetailedCourseObjectives(CounterLocalServiceUtil.increment());
					labDetailedCourseObjectives.setCourseObjective(courseObjective2);
					labDetailedCourseObjectives.setPK_courseId(PK_courseId);
					labDetailedCourseObjectives.setPK_projectId(PK_projectId);
					labDetailedCourseObjectives.setUserId(themeDisplay.getUserId());
					labDetailedCourseObjectives.setCreateDate(new Date());
					labDetailedCourseObjectivesLocalServiceUtil.addlabDetailedCourseObjectives(labDetailedCourseObjectives);
				}
				
				if(!(courseObjective3.equalsIgnoreCase("")) && courseObjective3!=null){
					labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.createlabDetailedCourseObjectives(CounterLocalServiceUtil.increment());
					labDetailedCourseObjectives.setCourseObjective(courseObjective3);
					labDetailedCourseObjectives.setPK_courseId(PK_courseId);
					labDetailedCourseObjectives.setPK_projectId(PK_projectId);
					labDetailedCourseObjectives.setUserId(themeDisplay.getUserId());
					labDetailedCourseObjectives.setCreateDate(new Date());
					labDetailedCourseObjectivesLocalServiceUtil.addlabDetailedCourseObjectives(labDetailedCourseObjectives);
				}
				
				if(!(learningEnvironment1.equalsIgnoreCase("")) && learningEnvironment1!=null){
					labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.createlabDetailedLearningEnvironments(CounterLocalServiceUtil.increment());
					labDetailedLearningEnvironments.setLearningEnvironment(learningEnvironment1);
					labDetailedLearningEnvironments.setPK_courseId(PK_courseId);
					labDetailedLearningEnvironments.setPK_projectId(PK_projectId);
					labDetailedLearningEnvironments.setUserId(themeDisplay.getUserId());
					labDetailedLearningEnvironments.setCreateDate(new Date());
					labDetailedLearningEnvironmentsLocalServiceUtil.addlabDetailedLearningEnvironments(labDetailedLearningEnvironments);
				}
				
				if(!(learningEnvironment2.equalsIgnoreCase("")) && learningEnvironment2!=null){
					labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.createlabDetailedLearningEnvironments(CounterLocalServiceUtil.increment());
					labDetailedLearningEnvironments.setLearningEnvironment(learningEnvironment2);
					labDetailedLearningEnvironments.setPK_courseId(PK_courseId);
					labDetailedLearningEnvironments.setPK_projectId(PK_projectId);
					labDetailedLearningEnvironments.setUserId(themeDisplay.getUserId());
					labDetailedLearningEnvironments.setCreateDate(new Date());
					labDetailedLearningEnvironmentsLocalServiceUtil.addlabDetailedLearningEnvironments(labDetailedLearningEnvironments);
				}
				
				if(!(learningEnvironment3.equalsIgnoreCase("")) && learningEnvironment3!=null){
					labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.createlabDetailedLearningEnvironments(CounterLocalServiceUtil.increment());
					labDetailedLearningEnvironments.setLearningEnvironment(learningEnvironment3);
					labDetailedLearningEnvironments.setPK_courseId(PK_courseId);
					labDetailedLearningEnvironments.setPK_projectId(PK_projectId);
					labDetailedLearningEnvironments.setUserId(themeDisplay.getUserId());
					labDetailedLearningEnvironments.setCreateDate(new Date());
					labDetailedLearningEnvironmentsLocalServiceUtil.addlabDetailedLearningEnvironments(labDetailedLearningEnvironments);
				}
				
				if(week1!=0){
					if(!(activitycourseObjective1.equalsIgnoreCase("")) && activitycourseObjective1!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective1);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					if(!(activitycourseObjective2.equalsIgnoreCase("")) && activitycourseObjective2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					if(!(activitycourseObjective3.equalsIgnoreCase("")) && activitycourseObjective3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign1.equalsIgnoreCase("")) && activitylearningEnvironmentDesign1!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign1);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign2.equalsIgnoreCase("")) && activitylearningEnvironmentDesign2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign3.equalsIgnoreCase("")) && activitylearningEnvironmentDesign3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity1.equalsIgnoreCase("")) && activity1!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setActivity(activity1);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity2.equalsIgnoreCase("")) && activity2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setActivity(activity2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity3.equalsIgnoreCase("")) && activity3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setActivity(activity3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content1.equalsIgnoreCase("")) && content1!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setContent(content1);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content2.equalsIgnoreCase("")) && content2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setContent(content2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content3.equalsIgnoreCase("")) && content3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setContent(content3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
				}
				
				if(week2==2){
					if(!(activitycourseObjective1week2.equals("")) && activitycourseObjective1week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective1week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					if(!(activitycourseObjective2week2.equals("")) && activitycourseObjective2week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective2week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					if(!(activitycourseObjective3week2.equals("")) && activitycourseObjective3week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective3week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign1week2.equals("")) && activitylearningEnvironmentDesign1week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(1);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign1week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign2week2.equals("")) && activitylearningEnvironmentDesign2week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign2week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign3week2.equals("")) && activitylearningEnvironmentDesign3week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign3week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity1week2.equals("")) && activity1week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setActivity(activity1week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity2week2.equals("")) && activity2week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setActivity(activity2week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity3week2.equals("")) && activity3week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setActivity(activity3week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content1week2.equals("")) && content1week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setContent(content1week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content2week2.equals("")) && content2week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setContent(content2week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content3week2.equals("")) && content3week2!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(2);
						labDetailedActivityTable.setContent(content3week2);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
				}
				
				if(week3==3){
					if(!(activitycourseObjective1week3.equals("")) && activitycourseObjective1week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective1week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					if(!(activitycourseObjective2week3.equals("")) && activitycourseObjective2week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective2week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					if(!(activitycourseObjective3week3.equals("")) && activitycourseObjective3week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective3week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign1week3.equals("")) && activitylearningEnvironmentDesign1week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign1week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign2week3.equals("")) && activitylearningEnvironmentDesign2week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign2week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign3week3.equals("")) && activitylearningEnvironmentDesign3week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign3week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity1week3.equals("")) && activity1week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setActivity(activity1week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity2week3.equals("")) && activity2week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setActivity(activity2week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity3week3.equals("")) && activity3week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setActivity(activity3week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content1week3.equals("")) && content1week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setContent(content1week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content2week3.equals("")) && content2week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setContent(content2week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content3week3.equals("")) && content3week3!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(3);
						labDetailedActivityTable.setContent(content3week3);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
				}
				
				if(week4==4){
					if(!(activitycourseObjective1week4.equals("")) && activitycourseObjective1week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective1week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					if(!(activitycourseObjective2week4.equals("")) && activitycourseObjective2week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective2week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					if(!(activitycourseObjective3week4.equals("")) && activitycourseObjective3week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setCourseObjective(activitycourseObjective3week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign1week4.equals("")) && activitylearningEnvironmentDesign1week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign1week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign2week4.equals("")) && activitylearningEnvironmentDesign2week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign2week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activitylearningEnvironmentDesign3week4.equals("")) && activitylearningEnvironmentDesign3week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setLearningEnvironmentDesign(activitylearningEnvironmentDesign3week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity1week4.equals("")) && activity1week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setActivity(activity1week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity2week4.equals("")) && activity2week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setActivity(activity2week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(activity3week4.equals("")) && activity3week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setActivity(activity3week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content1week4.equals("")) && content1week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setContent(content1week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content2week4.equals("")) && content2week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setContent(content2week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
					
					if(!(content3week4.equals("")) && content3week4!=null){
						labDetailedActivityTable = labDetailedActivityTableLocalServiceUtil.createlabDetailedActivityTable(CounterLocalServiceUtil.increment());
						labDetailedActivityTable.setUserId(themeDisplay.getUserId());
						labDetailedActivityTable.setWeek(4);
						labDetailedActivityTable.setContent(content3week4);
						labDetailedActivityTable.setCreateDate(new Date());
						labDetailedActivityTable.setPK_projectId(PK_projectId);
						labDetailedActivityTable.setPK_courseId(PK_courseId);
						labDetailedActivityTableLocalServiceUtil.updatelabDetailedActivityTable(labDetailedActivityTable);
					}
				}
			}
			/*PortletSession ps = resourceRequest.getPortletSession();
			ps.removeAttribute("LIFERAY_SHARED_PROJECT_KEY");
			ps.removeAttribute("LIFERAY_SHARED_PROJECT_INTEREST_KEY");
			ps.removeAttribute("LIFERAY_SHARED_PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
			ps.removeAttribute("LIFERAY_SHARED_PROJECT_INTEREST_KEY", PortletSession.APPLICATION_SCOPE);
			ps.setAttribute("LIFERAY_SHARED_PROJECT_KEY", String.valueOf(labScreenProjectOverview.getPK_projectId()), PortletSession.APPLICATION_SCOPE);
			ps.setAttribute("LIFERAY_SHARED_PROJECT_INTEREST_KEY", String.valueOf(interestId), PortletSession.APPLICATION_SCOPE);*/
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession session = httprequest.getSession();
			session.removeAttribute("PROJECT_KEY");
			session.removeAttribute("PROJECT_INTEREST_KEY");
			session.setAttribute("PROJECT_KEY", String.valueOf(labScreenProjectOverview.getPK_projectId()));
			session.setAttribute("PROJECT_INTEREST_KEY", String.valueOf(interestId));
			session.setAttribute("currentUser", themeDisplay.getUserId());
			
			out.print("add");				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	/*private CsvReader getCSV(UploadPortletRequest portletRequest) {
        
        InputStream inputStream = null;
        CsvReader csv=null;
        try {
            inputStream = new FileInputStream(portletRequest.getFile("fileupload"));
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            LOG.error("Error on Reading File"+e.getMessage());
        }
        BufferedReader csvFile = 
            new BufferedReader(new InputStreamReader(inputStream));
        csv = new CsvReader(csvFile);
        
        return csv;
    }*/
}