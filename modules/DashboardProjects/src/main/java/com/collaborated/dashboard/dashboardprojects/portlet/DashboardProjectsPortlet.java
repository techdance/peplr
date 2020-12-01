package com.collaborated.dashboard.dashboardprojects.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.labScreenTask;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.labScreenTaskLocalServiceUtil;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DashboardProjects Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		/*"com.liferay.portlet.private-session-attributes=false",*/
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DashboardProjectsPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("loadMyProjectDetails")) {
			loadMyProjectDetails(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("goToLabScreen")) {
			goToLabScreen(resourceRequest,resourceResponse);
		}
	}
	
	public void loadMyProjectDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;
		String template = "";
		List<labScreenProjectPartners> partnerList = null;
		Map<String, Integer> projectsPercentage = new HashMap<String, Integer>();
		try{
			out = resourceResponse.getWriter();
			long showProjectCount = 0;
			//Get projects created by current user
			/*DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("projectOwnerId",themeDisplay.getUserId()));
			List<labScreenProjectOverview> projectList = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("projectList=="+projectList.size());*/
			
			//List<labScreenProjectOverview> projectListAll = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverviews(-1, -1);
			DynamicQuery projectListQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, "labScreenProjectOverview",PortalClassLoaderUtil.getClassLoader());
			/*projectListQuery.addOrder(OrderFactoryUtil.desc("labScreenProjectOverview.createDate"));*/
			List<labScreenProjectOverview> projectListAll = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(projectListQuery);
			System.out.println("projectListAll==="+projectListAll.size());
			if(projectListAll.size()>0){
				int i = 0;
				for(labScreenProjectOverview singleData:projectListAll){
					
					boolean showProjects = false;
					
					//Get projects created by current user
					DynamicQuery dynamicQueryPartners = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());
					dynamicQueryPartners.add(RestrictionsFactoryUtil.eq("PK_projectId",singleData.getInterestId()));
					partnerList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQueryPartners); 
					
					System.out.println("partnerList==="+partnerList);
					
					/*String[] startDateArr = singleData.getProjectStartDate().split("-", 0);  
					if(singleData.getProjectEndDate()!=""){
						String[] endDateArr = singleData.getProjectEndDate().split("-", 0);  
						if (Integer.parseInt(endDateArr[1]) >= 1 && Integer.parseInt(endDateArr[1]) <= 12) {
							endDate = months[Integer.parseInt(endDateArr[1])-1]+" "+endDateArr[2]+","+endDateArr[0];
						}
					}
					
					if (Integer.parseInt(startDateArr[1]) >= 1 && Integer.parseInt(startDateArr[1]) <= 12) {
						startDate = months[Integer.parseInt(startDateArr[1])-1]+" "+startDateArr[2]+","+startDateArr[0];
					}*/	
					
					if(partnerList.size()>0){
						for(labScreenProjectPartners singleDataPartner:partnerList){
							if(singleDataPartner.getProjectPartnerId()==themeDisplay.getUserId()){								
								showProjects = true;								
							}
						}
					}
					
					if(singleData.getProjectOwnerId()==themeDisplay.getUserId()){
						showProjects = true;						
					}
					
					if(showProjects==true){
						showProjectCount = showProjectCount + 1;
						projectsPercentage.put(String.valueOf(singleData.getPK_projectId()), getProjectPercentage(singleData.getPK_projectId()));
					}
					i++;
				}
				int n = 3;
				if(showProjectCount < 3){
					n = Integer.parseInt(String.valueOf(showProjectCount));
				}
				List<Entry<String, Integer>> greatest = findGreatest(projectsPercentage, n);
				if(Validator.isNotNull(greatest) && greatest.size() > 1){
				Collections.sort(greatest, new Comparator<Entry<String, Integer>>()   
				{  
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)   
				{  
				 
				return o2.getValue().compareTo(o1.getValue());  
				
				}  
				}); 
				}
				
		        for (Entry<String, Integer> entry : greatest)
		        {
		        	String startDate = "", endDate = "ongoing";String organizerName = "";String organizerProfileImage = "";String projectTypeIcons = "";String projectColor = "";String percentageColor = "";
		        	long percentageValue = 0;
		        	labScreenProjectOverview singleData = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverview(Long.parseLong(entry.getKey()));
		        	startDate = singleData.getProjectStartDate();

					if(singleData.getProjectEndDate()!=""){
						endDate = singleData.getProjectEndDate();
					}
					if(singleData.getProjectType().equalsIgnoreCase("Academic Journal") || singleData.getProjectType().equalsIgnoreCase("Best Practices") || singleData.getProjectType().equalsIgnoreCase("Course Development")){
						projectTypeIcons = "fa-hands-helping";
						projectColor = "row-color-blue";
						percentageColor = "#084265";
					}else if(singleData.getProjectType().equalsIgnoreCase("Curriculum Development") || singleData.getProjectType().equalsIgnoreCase("General Publication") || singleData.getProjectType().equalsIgnoreCase("Mentorship")){
						projectTypeIcons = "fa-user-friends";
						projectColor = "row-color-green";
						percentageColor = "#339900";
					}else if(singleData.getProjectType().equalsIgnoreCase("Peer Review") || singleData.getProjectType().equalsIgnoreCase("Research") || singleData.getProjectType().equalsIgnoreCase("Study Abroad") || singleData.getProjectType().equalsIgnoreCase("Other")){
						projectTypeIcons = "fa-microscope";
						projectColor = "row-color-orange";
						percentageColor = "#ff993e";
					}
					String imageURL = "",imgSRC="";boolean isBase64 = false;
					if(Validator.isNotNull(partnerList) && partnerList.size()>0){
						User user = UserLocalServiceUtil.getUser(singleData.getProjectOwnerId());
						organizerName = user.getFullName();
						imageURL = "";imgSRC="";isBase64 = false;
						DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
						dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(user.getUserId()));
						List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQuery);
						if(values.size()>0){
							imageURL = values.get(0).getFileEntryUrl();					
						    JSONObject jsonObject2 = CommonMethods.getProfileImageBlob(user.getUserId());	               
						    imageURL = jsonObject2.getString("byteArray");
						    imgSRC = "data:image/png;base64,"+imageURL;
						    isBase64 = true;
						}else{
							imageURL = "/o/ahea-theme/images/user.png";
							imgSRC = imageURL;
							isBase64 = false;
						}
						//organizerProfileImage = user.getPortraitURL(themeDisplay);
					}
					
					percentageValue = getProjectPercentage(singleData.getPK_projectId());
					if(singleData.getProjectType().equalsIgnoreCase("Course Development") ){
						if(greatest.indexOf(entry)==0){
							projectTypeIcons = "fa-hands-helping";
							projectColor = "row-color-blue";
							percentageColor = "#084265";
						}
						if(greatest.indexOf(entry)==1){
							projectTypeIcons = "fa-user-friends";
							projectColor = "row-color-green";
							percentageColor = "#339900";
						}
						if(greatest.indexOf(entry)==2){
							projectTypeIcons = "fa-microscope";
							projectColor = "row-color-orange";
							percentageColor = "#ff993e";
						}
					}
					
					template = template + "<a href='' onclick='goToLabScreen("+singleData.getPK_projectId()+")'>" + singleData.getProjectName() + singleData.getProjectDescription()+startDate+endDate+organizerName+organizerProfileImage+"</a>";
					template = template + "<tr class=" + projectColor + "><td><a href='' onclick='goToLabScreen("
							+ singleData.getPK_projectId() + ")'>" + singleData.getProjectName()
							+ "</a></td><td class='align-center'>" + startDate + " to " + endDate
							+ "</td><td class='align-center'><i class='fad icon-size-40 " + projectTypeIcons
							+ "'></i></td><td class='align-center'><span class='wrap-image'><img src=" + imgSRC
							+ " width='36' alt=''><span class='user-active'></span></span><div class='org-name'>"
							+ organizerName
							+ "</div></td><td class='align-center'><i class='fad fa-paste icon-size-40'></i></td><td class='align-center'><i class='fad fa-ball-pile icon-size-40'></i></td><td class='align-center'><div class='circular-chart' data-percent='"
							+ percentageValue + "' data-size='60' data-bar-color='" + percentageColor + "'>"
							+ percentageValue + "%</div></td></tr>";
		        }
				
			}
			System.out.println("is organizer==="+showProjectCount);
			out.print(template);
			
		}catch(Exception e){/*e.printStackTrace();*/}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void goToLabScreen(ResourceRequest request, ResourceResponse response){
		String projectId = ParamUtil.getString(request, "projectId");
		labScreenProjectOverview labScreenProjectOverview = null;
		long interestId = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			PortletSession ps = request.getPortletSession();
			labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverview(Long.valueOf(projectId));
			if(labScreenProjectOverview!=null){
				interestId = labScreenProjectOverview.getInterestId();
			}
			/*setSession(PortalUtil.getHttpServletRequest(request),"LIFERAY_SHARED_PROJECT_KEY",projectId);
			setSession(PortalUtil.getHttpServletRequest(request),"LIFERAY_SHARED_PROJECT_INTEREST_KEY",String.valueOf(interestId));*/
			
			System.out.println(getSessionAttr(PortalUtil.getHttpServletRequest(request),"LIFERAY_SHARED_PROJECT_KEY"));
			
			/*ps.removeAttribute("LIFERAY_SHARED_PROJECT_KEY");
			ps.removeAttribute("LIFERAY_SHARED_PROJECT_INTEREST_KEY");
			ps.removeAttribute("LIFERAY_SHARED_PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
			ps.removeAttribute("LIFERAY_SHARED_PROJECT_INTEREST_KEY", PortletSession.APPLICATION_SCOPE);
			ps.setAttribute("LIFERAY_SHARED_PROJECT_KEY", projectId, PortletSession.APPLICATION_SCOPE);
			ps.setAttribute("LIFERAY_SHARED_PROJECT_INTEREST_KEY", String.valueOf(interestId), PortletSession.APPLICATION_SCOPE);*/
			/*ps.removeAttribute("PROJECT_KEY");
			ps.removeAttribute("PROJECT_INTEREST_KEY");
			ps.removeAttribute("PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
			ps.removeAttribute("PROJECT_INTEREST_KEY", PortletSession.APPLICATION_SCOPE);
			ps.setAttribute("PROJECT_KEY", projectId, PortletSession.APPLICATION_SCOPE);
			ps.setAttribute("PROJECT_INTEREST_KEY", String.valueOf(interestId), PortletSession.APPLICATION_SCOPE);*/
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(request);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession session = httprequest.getSession();
			session.removeAttribute("PROJECT_KEY");
			session.removeAttribute("PROJECT_INTEREST_KEY");
			session.setAttribute("PROJECT_KEY", projectId);
			session.setAttribute("PROJECT_INTEREST_KEY", String.valueOf(interestId));
			session.setAttribute("currentUser", themeDisplay.getUserId());
			
		}catch(Exception e){}
		finally{
			
		}
	}
	
	public int getProjectPercentage(long PK_projectId) {
		List<labScreenTask> listData = null;int percentage = 0;
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
	
	public void setSession(HttpServletRequest request,String key,String value){
		/*if(!(key.equalsIgnoreCase("")) && key!=null){
		request.getSession().removeAttribute(key);
		request.getSession().setAttribute(key,value);
		}*/
		System.out.println("key==="+key);
		System.out.println("value==="+value);
		request.getSession().removeAttribute(key);
		request.getSession().setAttribute(key,value);
		
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
	
	private static <K, V extends Comparable<? super V>> List<Entry<K, V>> findGreatest(Map<K, V> map, int n){
    
		Comparator<? super Entry<K, V>> comparator = new Comparator<Entry<K, V>>()
		{
	        @Override
	        public int compare(Entry<K, V> e0, Entry<K, V> e1)
	        {
	            V v0 = e0.getValue();
	            V v1 = e1.getValue();
	            return v0.compareTo(v1);
	        }
		};
		
		PriorityQueue<Entry<K, V>> highest = new PriorityQueue<Entry<K,V>>(n, comparator);
		    for (Entry<K, V> entry : map.entrySet())
		    {
		        highest.offer(entry);
		        while (highest.size() > n)
		        {
		            highest.poll();
		        }
		    }

		List<Entry<K, V>> result = new LinkedList<Map.Entry<K,V>>();
		
	    while (highest.size() > 0)
	    {
	        result.add(highest.poll());
	    }
	    return result;
	}
}