package com.collaborated.my.projects.portlet;


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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
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
		"javax.portlet.display-name=MyProjects Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyprojectsPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("getMyProjectsAndTasks")) {
			getMyProjectsAndTasks(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getCourseSummaryData")) {
			getCourseSummaryData(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("moveToLabScreen")) {
			moveToLabScreen(resourceRequest,resourceResponse);
		}
	}
	
	public void getMyProjectsAndTasks(ResourceRequest resourceRequest,ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;
		String templatePast = "";String templateProgress = "";String templateTasks = "";
		SimpleDateFormat displayFormat = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject jsonObject = null;
		try{			
			out = resourceResponse.getWriter();
			jsonObject = JSONFactoryUtil.createJSONObject();			
			long showProjectCount = 0;
			/*DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("projectOwnerId",themeDisplay.getUserId()));
			List<labScreenProjectOverview> projectList = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(dynamicQuery);*/
			
			DynamicQuery dynamicQueryTasks = DynamicQueryFactoryUtil.forClass(labScreenTask.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryTasks.add(RestrictionsFactoryUtil.eq("projectAssignedTo",themeDisplay.getUserId()));
			List<labScreenTask> labScreenTaskList = labScreenTaskLocalServiceUtil.dynamicQuery(dynamicQueryTasks);
			
			//List<labScreenProjectOverview> projectListAll = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverviews(-1, -1);
			DynamicQuery projectListQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, "labScreenProjectOverview",PortalClassLoaderUtil.getClassLoader());
			projectListQuery.addOrder(OrderFactoryUtil.desc("labScreenProjectOverview.createDate"));
			List<labScreenProjectOverview> projectListAll = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(projectListQuery);
			System.out.println("projectListAll==="+projectListAll.size());
			if(projectListAll.size()>0){
				for(labScreenProjectOverview singleData:projectListAll){
					boolean showProjects = false;
					DynamicQuery dynamicQueryPartners = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());
					dynamicQueryPartners.add(RestrictionsFactoryUtil.eq("PK_projectId",singleData.getInterestId()));
					List<labScreenProjectPartners> partnerList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQueryPartners); 
					
					if(partnerList.size()>0){
						for(labScreenProjectPartners singleDataPartner:partnerList){
							if(singleDataPartner.getProjectPartnerId()==themeDisplay.getUserId()){								
								showProjects = true;
								System.out.println("is partner==="+showProjects);
							}
						}
					}
					
					if(singleData.getProjectOwnerId()==themeDisplay.getUserId()){
						showProjects = true;
						System.out.println("is organizer==="+showProjects);
					}
					
					if(showProjects==true){
						showProjectCount = showProjectCount + 1;
						String projectColor = "", dataBarcolor = "";long percentageValue = 0;
						if(singleData.getProjectType().equalsIgnoreCase("Academic Journal") || singleData.getProjectType().equalsIgnoreCase("Best Practices") || singleData.getProjectType().equalsIgnoreCase("Course Development")){				
							projectColor = "box-project-progress-blue";
							dataBarcolor = "#084265";
						}else if(singleData.getProjectType().equalsIgnoreCase("Curriculum Development") || singleData.getProjectType().equalsIgnoreCase("General Publication") || singleData.getProjectType().equalsIgnoreCase("Mentorship")){					
							projectColor = "box-project-progress-green";
							dataBarcolor = "#339937";
						}else if(singleData.getProjectType().equalsIgnoreCase("Peer Review") || singleData.getProjectType().equalsIgnoreCase("Research") || singleData.getProjectType().equalsIgnoreCase("Study Abroad") || singleData.getProjectType().equalsIgnoreCase("Other")){					
							projectColor = "box-project-progress-orange";
							dataBarcolor = "#ff993e";
						}
						
						percentageValue = getProjectPercentage(singleData.getPK_projectId());
						if(singleData.getProjectType().equalsIgnoreCase("Course Development") ){
							if(showProjectCount==0){
								projectColor = "box-project-progress-blue";
								dataBarcolor = "#084265";
							}
							if(showProjectCount==1){
								projectColor = "box-project-progress-green";
								dataBarcolor = "#339937";
							}
							if(showProjectCount==2){
								projectColor = "box-project-progress-orange";
								dataBarcolor = "#ff993e";
							}
						}
						if(percentageValue<100){
							templateProgress = templateProgress + "<div class=\"col-md-6 mb-3\">"
									+ "<div class=\"box-project-progress h-100 "+projectColor+"\">"
									+ "<div class=\"box-project-progress-header\"></div>"
									+ "<div class=\"box-project-progress-body\"><a href=\"#\" onclick=\"goToLabScreen("+singleData.getPK_projectId()+")\">"
									+ "<h4>"+singleData.getProjectName()+"</h4></a>"
									/*+ "<div class=\"modal fade modalToltip modalareainterest \" id=\"popup-"+singleData.getPK_projectId()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modalLabel\" aria-hidden=\"true\"></div>"*/
									+ "<div class=\"d-flex\"><div class=\"box-donnut pr-4\">"
									+ "<div class=\"chart-donnut easyPieChart\" data-percent=\""+percentageValue+"\" data-size=\"150\" data-bar-color=\""+dataBarcolor+"\" >"+percentageValue+"%"+"</div></div>"
									+ "<div class=\"box-text\">"+singleData.getProjectDescription()+"</div>"
									+ "</div></div></div></div>"
									;
						}else{
							templatePast = templatePast + "<div class=\"col-md-6 mb-3\">"
									+ "<div class=\"box-project-progress h-100 "+projectColor+"\">"
									+ "<div class=\"box-project-progress-header\"></div>"
									+ "<div class=\"box-project-progress-body\"><a href=\"javascript:void(0);\" data-toggle=\"modal\" data-target=\"#popup-"+singleData.getPK_projectId()+"\" onclick=\"getCourseSummaryData("+singleData.getPK_projectId()+")\">"
									+ "<h4>"+singleData.getProjectName()+"</h4></a>"
									+ "<div class=\"modal fade modalToltip modalareainterest \" id=\"popup-"+singleData.getPK_projectId()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modalLabel\" aria-hidden=\"true\"></div>"
									+ "<div class=\"d-flex\"><div class=\"box-donnut pr-4\">"
									+ "<div class=\"chart-donnut easyPieChart\" data-percent=\""+percentageValue+"\" data-size=\"150\" data-bar-color=\"#339937\">"+percentageValue+"%"+"</div></div>"
									+ "<div class=\"box-text\">"+singleData.getProjectDescription()+"</div>"
									+ "</div></div></div></div>"
									;
						}	
					}
				}
			}
			
			/*for(labScreenProjectOverview singleData:projectList){
				
				String projectColor = "";long percentageValue = 0;
				if(singleData.getProjectType().equalsIgnoreCase("Academic Journal") || singleData.getProjectType().equalsIgnoreCase("Best Practices") || singleData.getProjectType().equalsIgnoreCase("Course Development")){				
					projectColor = "box-project-progress-blue";
				}else if(singleData.getProjectType().equalsIgnoreCase("Curriculum Development") || singleData.getProjectType().equalsIgnoreCase("General Publication") || singleData.getProjectType().equalsIgnoreCase("Mentorship")){					
					projectColor = "box-project-progress-green";
				}else if(singleData.getProjectType().equalsIgnoreCase("Peer Review") || singleData.getProjectType().equalsIgnoreCase("Research") || singleData.getProjectType().equalsIgnoreCase("Study Abroad") || singleData.getProjectType().equalsIgnoreCase("Other")){					
					projectColor = "box-project-progress-orange";
				}
				percentageValue = getProjectPercentage(singleData.getPK_projectId());
				if(percentageValue<100){
					templateProgress = templateProgress + "<div class=\"col-md-6\">"
							+ "<div class=\"box-project-progress "+projectColor+"\">"
							+ "<div class=\"box-project-progress-header\"></div>"
							+ "<div class=\"box-project-progress-body\"><a href=\"javascript:void(0);\" data-toggle=\"modal\" data-target=\"#popup-"+singleData.getPK_projectId()+"\" onclick=\"getCourseSummaryData("+singleData.getPK_projectId()+")\">"
							+ "<h4>"+singleData.getProjectName()+"</h4></a>"
							+ "<div class=\"modal fade modalToltip modalareainterest \" id=\"popup-"+singleData.getPK_projectId()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modalLabel\" aria-hidden=\"true\"></div>"
							+ "<div class=\"d-flex\"><div class=\"box-donnut pr-4\">"
							+ "<div class=\"chart-donnut easyPieChart\" data-percent=\""+percentageValue+"\" data-size=\"150\" data-bar-color=\"#339937\">"+percentageValue+"%"+"</div>"
							+ "<div class=\"box-text\">"+singleData.getProjectDescription()+"</div>"
							+ "</div></div></div></div></div>"
							;
				}else{
					templatePast = templatePast + "<div class=\"col-md-6\">"
							+ "<div class=\"box-project-progress "+projectColor+"\">"
							+ "<div class=\"box-project-progress-header\"></div>"
							+ "<div class=\"box-project-progress-body\"><a href=\"javascript:void(0);\" data-toggle=\"modal\" data-target=\"#popup-"+singleData.getPK_projectId()+"\" onclick=\"getCourseSummaryData("+singleData.getPK_projectId()+")\">"
							+ "<h4>"+singleData.getProjectName()+"</h4></a>"
							+ "<div class=\"modal fade modalToltip modalareainterest \" id=\"popup-"+singleData.getPK_projectId()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modalLabel\" aria-hidden=\"true\"></div>"
							+ "<div class=\"d-flex\"><div class=\"box-donnut pr-4\">"
							+ "<div class=\"chart-donnut easyPieChart\" data-percent=\""+percentageValue+"\" data-size=\"150\" data-bar-color=\"#339937\">"+percentageValue+"%"+"</div></div>"
							+ "<div class=\"box-text\">"+singleData.getProjectDescription()+"</div>"
							+ "</div></div></div></div>"
							;
				}				
			}*/
			
			if(labScreenTaskList.size()>0){
				for(labScreenTask singleData:labScreenTaskList){
					String projectName = "", taskTitle = "",dueDate = "",milestoneName = "";
					long projectId = 0;
					labScreenProjectOverview labScreenProjectOverview = null;
					labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverview(singleData.getPK_projectId());
					if(labScreenProjectOverview!=null){
						projectName = labScreenProjectOverview.getProjectName();
						projectId = labScreenProjectOverview.getPK_projectId();
					}
					dueDate = singleData.getDueDate();					
					taskTitle = singleData.getTaskName();
					milestoneName = singleData.getMilestoneName();
					//String redirectURL = themeDisplay.getURLPortal()+"/lab-detailed-screen?milestoneName="+milestoneName;
					templateTasks = templateTasks + "<tr><td class=\"td-valign-bottom td-icon-arrow td-icon-arrow\"><i class=\"fas fa-chevron-circle-right color-orange fa-2x\"></i></td>"
							+ "<td class=\"td-valign-top\"><a href=\"#\" onclick=\"goToLabScreenMileStone("+projectId+",'"+milestoneName+"')\">"+projectName+"</a></td>"
							+ "<td class=\"td-valign-top\">"+taskTitle+"</td>"
							+ "<td class=\"td-valign-top\">"+dueDate+"</td></tr>"
							; 
				}
			}
			
			jsonObject.put("templatePast", templatePast);
			jsonObject.put("templateProgress", templateProgress);
			jsonObject.put("templateTasks", templateTasks);
			out.print(jsonObject);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void getCourseSummaryData(ResourceRequest resourceRequest,ResourceResponse resourceResponse){
		List<labDetailedCourseIdentification> courseIdentification = null;
		long key = ParamUtil.getLong(resourceRequest, "key");
		long PK_courseId = 0;PrintWriter out = null;
		labDetailedCourseIdentification labDetailedCourseIdentification = null;
		List<labDetailedCourseHours> labDetailedCourseHours = null;
		List<labDetailedCourseResources> labDetailedCourseResources = null;
		List<labDetailedInstructorQualification> labDetailedInstructorQualification = null;
		List<labDetailedCourseTopics> labDetailedCourseTopics = null;
		List<labDetailedCourseObjectives> labDetailedCourseObjectives = null;
		List<labDetailedLearningEnvironments> labDetailedLearningEnvironments = null;
		List<labDetailedActivityTable> labDetailedActivityTable = null;
		long courseIdentificationId=0, courseHoursId=0, courseResourcesId=0, courseInstId=0;
		String courseTitle="",courseNumber="",prerequisites="",courseDescription="";
		long numberOfCredits=0,numberOfCourseWeeks=0,courseHoursPerWeek=0,lectureHoursPerWeek=0,labHoursPerWeek=0,studyHoursPerWeek=0,contactHours=0;
		String textbookTitle = "",publisherName = "", author = "", ISBN = "";
		String instructor1Qualifications = "",instructor2Qualifications = "";
		String template = "";String topicsTemplate = "", objectivesTemplate = "", environmentTempalte = "", activityTable = "";
		try{
			
			out = resourceResponse.getWriter();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labDetailedCourseIdentification.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("PK_projectId").eq(key));
			courseIdentification = labDetailedCourseIdentificationLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			System.out.println("PK_projectId===courseIdentification=="+courseIdentification);
			if(courseIdentification.size()>0){
				PK_courseId = courseIdentification.get(0).getPK_courseId();
			}
			
			labDetailedCourseIdentification = labDetailedCourseIdentificationLocalServiceUtil.getlabDetailedCourseIdentification(PK_courseId);
			if(labDetailedCourseIdentification!=null){
				courseTitle = labDetailedCourseIdentification.getCourseTitle();
				courseNumber = labDetailedCourseIdentification.getCourseNumber();
				prerequisites = labDetailedCourseIdentification.getPrerequisites();
				courseDescription = labDetailedCourseIdentification.getCourseDescription();
				courseIdentificationId = labDetailedCourseIdentification.getPK_courseId();
			}
			DynamicQuery dynamicQueryHours = DynamicQueryFactoryUtil.forClass(labDetailedCourseHours.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryHours.add(PropertyFactoryUtil.forName("PK_projectId").eq(key));
			labDetailedCourseHours = labDetailedCourseHoursLocalServiceUtil.dynamicQuery(dynamicQueryHours); 
			if(labDetailedCourseHours.size()>0){
				numberOfCredits = labDetailedCourseHours.get(0).getNumberOfCredits();
				numberOfCourseWeeks = labDetailedCourseHours.get(0).getNumberOfCourseWeeks();
				courseHoursPerWeek = labDetailedCourseHours.get(0).getCourseHoursPerWeek();
				lectureHoursPerWeek = labDetailedCourseHours.get(0).getLectureHoursPerWeek();
				labHoursPerWeek = labDetailedCourseHours.get(0).getLabHoursPerWeek();
				studyHoursPerWeek = labDetailedCourseHours.get(0).getIndependentStudyHoursPerWeek();
				contactHours = courseHoursPerWeek * numberOfCourseWeeks;
				courseHoursId = labDetailedCourseHours.get(0).getPK_courseHoursId();
			}
			DynamicQuery dynamicQueryResources = DynamicQueryFactoryUtil.forClass(labDetailedCourseResources.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryResources.add(PropertyFactoryUtil.forName("PK_projectId").eq(key));
			labDetailedCourseResources = labDetailedCourseResourcesLocalServiceUtil.dynamicQuery(dynamicQueryResources);
			if(labDetailedCourseResources.size()>0){
				textbookTitle = labDetailedCourseResources.get(0).getTextbokTitle();
				publisherName = labDetailedCourseResources.get(0).getPublisherName();
				author = labDetailedCourseResources.get(0).getAuthor();
				ISBN = labDetailedCourseResources.get(0).getIsbn();
				courseResourcesId = labDetailedCourseResources.get(0).getPK_courseResourceId();
			}

			DynamicQuery dynamicQueryQualification = DynamicQueryFactoryUtil.forClass(labDetailedInstructorQualification.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryQualification.add(PropertyFactoryUtil.forName("PK_projectId").eq(key));
			labDetailedInstructorQualification = labDetailedInstructorQualificationLocalServiceUtil.dynamicQuery(dynamicQueryQualification);
			if(labDetailedInstructorQualification.size()>0){
				instructor1Qualifications = labDetailedInstructorQualification.get(0).getInstructor1Qualification();
				instructor2Qualifications = labDetailedInstructorQualification.get(0).getInstructor2Qualification();
				courseInstId = labDetailedInstructorQualification.get(0).getPK_courseInstructorQualificationId();
			}
			
			DynamicQuery dynamicQueryCourseTopics = DynamicQueryFactoryUtil.forClass(labDetailedCourseTopics.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryCourseTopics.add(PropertyFactoryUtil.forName("PK_projectId").eq(key));
			labDetailedCourseTopics = labDetailedCourseTopicsLocalServiceUtil.dynamicQuery(dynamicQueryCourseTopics);
			if(labDetailedCourseTopics.size()>0){
				for(labDetailedCourseTopics singleData:labDetailedCourseTopics){
					topicsTemplate = topicsTemplate + singleData.getCourseTopic()+"<br>";
				}
				topicsTemplate = "<div class='col-md-8'><p class='m-0 detailtext'>"+topicsTemplate+"</p></div>";
			}
			
			DynamicQuery dynamicQueryCourseObjectives = DynamicQueryFactoryUtil.forClass(labDetailedCourseObjectives.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryCourseObjectives.add(PropertyFactoryUtil.forName("PK_projectId").eq(key));
			labDetailedCourseObjectives = labDetailedCourseObjectivesLocalServiceUtil.dynamicQuery(dynamicQueryCourseObjectives);
			if(labDetailedCourseObjectives.size()>0){
				for(labDetailedCourseObjectives singleData:labDetailedCourseObjectives){
					objectivesTemplate = objectivesTemplate + singleData.getCourseObjective()+"<br>";
				}
				objectivesTemplate = "<div class='col-md-8'><p class='m-0 detailtext'>"+objectivesTemplate+"</p></div>";
			}
			
			DynamicQuery dynamicQueryEnvironment = DynamicQueryFactoryUtil.forClass(labDetailedLearningEnvironments.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryEnvironment.add(PropertyFactoryUtil.forName("PK_projectId").eq(key));
			labDetailedLearningEnvironments = labDetailedLearningEnvironmentsLocalServiceUtil.dynamicQuery(dynamicQueryEnvironment);
			if(labDetailedLearningEnvironments.size()>0){
				for(labDetailedLearningEnvironments singleData:labDetailedLearningEnvironments){
					environmentTempalte = environmentTempalte + singleData.getLearningEnvironment()+"<br>";
				}
				environmentTempalte = "<div class='col-md-8'><p class='m-0 detailtext'>"+environmentTempalte+"</p></div>";
			}
			
			//Modal design
			template = " <div class='modal-dialog myprojectsdetails'> " +
				    " <div class='modal-content'> " +
				    " <div class='modal-header'> " +
				    " <div class='font15 m-auto d-flex flex-column'><strong>Course Information</strong></div> " +
				    " <div class='toltip-close3'><a href='javascript:void(0);' data-dismiss='modal'><i class='fa fa-times-circle'></i></a></div> " +
				    " </div> " +
				    " <div class='modal-body'> " +
				    " <div class='interest-modal'> "+
				    " <div class='view-more-interest-modal-inner'> "+
				    " <div class='view-more-interest-modal-inner-content'> "+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Course Title:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+courseTitle+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Course Number:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+courseNumber+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Prerequisites:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+prerequisites+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Credit Hours:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+courseHoursPerWeek+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Contact Hours:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+contactHours+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Lecture Hours:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+lectureHoursPerWeek+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Laboratory Hours:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+labHoursPerWeek+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Textbook Title:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+textbookTitle+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Publisher's Name:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+publisherName+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Author:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+author+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>ISBN:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+ISBN+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Instructor 1 Qualifications:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+instructor1Qualifications+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Instructor 2 Qualifications:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+instructor2Qualifications+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Course Description:</strong></div><div class='col-md-8'>"+
				    " <p class='m-0 detailtext'>"+courseDescription+"</p></div></div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Course Topics:</strong></div>"+ topicsTemplate +
				    " </div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Course Objectives:</strong></div>"+ objectivesTemplate +
				    " </div>"+
				    " <div class='row mb-2'><div class='col-sm-4 '>"+
				    " <strong class='headingtext'>Learning Environments:</strong></div>"+ environmentTempalte +
				    " </div>"+
				    " </div> " +
				    " </div> " +
				    " </div>"+
				    " </div>"+
				    " </div>"+
				    " </div>";
			out.print(template);
		}catch(Exception e){
			template = " <div class='modal-dialog myprojectsdetails'> " +
				    " <div class='modal-content'> " +
				    " <div class='modal-header'> " +
				    " <div class='font15 m-auto d-flex flex-column'><strong>Course Information</strong></div> " +
				    " <div class='toltip-close3'><a href='javascript:void(0);' data-dismiss='modal'><i class='fa fa-times-circle'></i></a></div> " +
				    " </div> " +
				    " <div class='modal-body'> " +
				    " <div class='interest-modal'> "+
				    " <p class='my-5 text-center text-dark'>No Records Found</p>"+
				    " </div> " +
				    " </div>"+
				    " </div>"+
				    " </div>";
			out.print(template);
		}
	}
	
	public long getProjectPercentage(long PK_projectId) {
		List<labScreenTask> listData = null;long percentage = 0;
		try{
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
		}catch(Exception e){
			
		}
		return percentage;
	}
	
	public void moveToLabScreen(ResourceRequest request, ResourceResponse response){
		String key = ParamUtil.getString(request, "key");
		labScreenProjectOverview labScreenProjectOverview = null;
		long interestId = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverview(Long.valueOf(key));
			if(labScreenProjectOverview!=null){
				interestId = labScreenProjectOverview.getInterestId();
			}
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(request);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession session = httprequest.getSession();
			session.removeAttribute("PROJECT_KEY");
			session.removeAttribute("PROJECT_INTEREST_KEY");
			session.setAttribute("PROJECT_KEY", key);
			session.setAttribute("PROJECT_INTEREST_KEY", String.valueOf(interestId));
			session.setAttribute("currentUser", themeDisplay.getUserId());
		}catch(Exception e){}
		finally{
			
		}
	}
}