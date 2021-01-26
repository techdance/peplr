package com.collaborated.profile.portlet;

import com.collaborated.entity.model.discussionMessageNotification;
import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.model.userCredential;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.discussionMessageNotificationLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.projectInviteTrackingLocalServiceUtil;
import com.collaborated.entity.service.userCredentialLocalServiceUtil;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
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
		"javax.portlet.display-name=TopMenu Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TopMenuPortlet extends MVCPortlet{
	
	/*public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		PortletSession session = renderRequest.getPortletSession();
		String projectId = (String)session.getAttribute("PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
		PK_projectId = new Long(projectId);
		partnersList = (List<labScreenProjectPartners>)session.getAttribute("PROJECT_PARTNERS", PortletSession.APPLICATION_SCOPE);
	}*/
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("loadMyProfileDetails")) {
			loadMyProfileDetails(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getMyNotificationCount")) {
			getMyNotificationCount(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("closeAction")) {
			closeAction(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("closeActionMessageDiscussion")) {
			closeActionMessageDiscussion(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("projectApproved")) {
			projectApproved(resourceRequest,resourceResponse);
		}
	}
	
	public void loadMyProfileDetails(ResourceRequest request, ResourceResponse response){
		try{
			PortletSession ps = request.getPortletSession();
			/*Object obj = ps.getAttribute("MATCHING_KEY", PortletSession.APPLICATION_SCOPE);
			System.out.println(obj);
			if (obj != null) {
				ps.removeAttribute("MATCHING_KEY",PortletSession.APPLICATION_SCOPE);
			}
			System.out.println(obj);*/
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(request);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			System.out.println(httpsession.getAttribute("currentUser"));
			if(httpsession.getAttribute("currentUser")!=null){
				httpsession.removeAttribute("currentUser");
				httpsession.removeAttribute("MATCHING_KEY");
			}
			
			
			
		}catch(Exception e){}
		finally{
			
		}
	}
	
	public void getMyNotificationCount(ResourceRequest resourceRequest,ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;
		String template1 = "";
		String template2 = "";
		JSONObject jsonObject = null;
		try{			
			out = resourceResponse.getWriter();
			jsonObject = JSONFactoryUtil.createJSONObject();
			DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		
			// under messages design
			DynamicQuery dynamicQueryRead = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, "projectInviteTracking",PortalClassLoaderUtil.getClassLoader());
			dynamicQueryRead.addOrder(OrderFactoryUtil.desc("projectInviteTracking.createDate"));
			/*dynamicQuery.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("inviteTo",themeDisplay.getUserId()),
					(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("isRemoved",new Long(3)),RestrictionsFactoryUtil.eq("isRead", new Long(1))))));*/
			dynamicQueryRead.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("inviteTo",themeDisplay.getUserId()),RestrictionsFactoryUtil.eq("isRead", new Long(1))));
			List<projectInviteTracking> trackNotificationCount = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQueryRead);
			
			// under notifications design
			DynamicQuery dynamicQueryRemoved = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, "projectInviteTracking",PortalClassLoaderUtil.getClassLoader());
			dynamicQueryRemoved.addOrder(OrderFactoryUtil.desc("projectInviteTracking.createDate"));
			dynamicQueryRemoved.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("inviteFrom",themeDisplay.getUserId()),
					(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("isRemoved",new Long(0)),RestrictionsFactoryUtil.eq("isRemoved",new Long(1))))));
			List<projectInviteTracking> trackNotificationCountRemoved = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQueryRemoved);
			
			DynamicQuery dynamicQueryTask = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, "projectInviteTracking",PortalClassLoaderUtil.getClassLoader());
			dynamicQueryTask.addOrder(OrderFactoryUtil.desc("projectInviteTracking.createDate"));
			dynamicQueryTask.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("inviteTo",themeDisplay.getUserId()),RestrictionsFactoryUtil.eq("isRemoved", new Long(4))));
			List<projectInviteTracking> trackNotificationCountTask = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQueryTask);
			
			DynamicQuery dynamicQueryReadDiscussion = DynamicQueryFactoryUtil.forClass(discussionMessageNotification.class, "discussionMessageNotification",PortalClassLoaderUtil.getClassLoader());
			dynamicQueryReadDiscussion.addOrder(OrderFactoryUtil.desc("discussionMessageNotification.createDate"));
			dynamicQueryReadDiscussion.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("messageTo",themeDisplay.getUserId()),RestrictionsFactoryUtil.eq("isRead", new Long(1))));
			List<discussionMessageNotification> trackNotificationCountDiscussion = discussionMessageNotificationLocalServiceUtil.dynamicQuery(dynamicQueryReadDiscussion);
			
			
			//int totalCount = trackNotificationCount.size() + trackNotificationCountRemoved.size();
			
			// under messages design
			if(trackNotificationCount.size()>0){
				for(projectInviteTracking singleProjectInviteTracking:trackNotificationCount){
					int showChar = 140;
					String message = "";String imgUrl = "";String name = "";String type = "message";
					String dateString = dateFormat.format(singleProjectInviteTracking.getCreateDate()).toString();
					long portraitId = UserLocalServiceUtil.getUser(singleProjectInviteTracking.getInviteFrom()).getPortraitId();
					name =  UserLocalServiceUtil.getUser(singleProjectInviteTracking.getInviteFrom()).getFullName();
					imgUrl = themeDisplay.getPathImage()+"/user_portrait?img_id="+portraitId;
					message = singleProjectInviteTracking.getMessageContent();
					if(message.length() > showChar) {
						message = message.substring(0, showChar) + "...";
					}
				  
					template1 = template1 + " <div id='toltip-item-1' class='toltip-item d-flex position-relative p-0 toltip-overlay border-radius-5'> "+
							" <a href='#' class='close-times' data-id='1' onclick='closeActionMessage("+singleProjectInviteTracking.getPK_projectInvitationId()+")'><i class='fas fa-times-circle'></i></a> "+
							" <div class='status-email'></div> "+
							" <div class='toltip-text p-2 pl-4 w-100'> "+
							" <div class='toltip-header'> "+
							" <div class='toltip-header-left p0'> "+
							" <p>"+name+"</p> "+
							" </div> "+
							" <div class='toltip-header-right text-right p0'> "+
							" <p>"+dateString+" </p> "+
							" </div> "+
							" </div> "+
							" <div class='toltip-subhead p0'> "+
							" <p>"+singleProjectInviteTracking.getMessageTitle()+"</p> "+
							" </div> "+
							" <div class='toltip-content p0'> "+
							" <p>"+message+"</p> "+
							" </div> "+
							" </div> "+
							" </div> ";
				}
			}
			
			if(trackNotificationCountDiscussion.size()>0){
				for(discussionMessageNotification singleProjectInviteTracking:trackNotificationCountDiscussion){
					int showChar = 140;
					String message = "";String imgUrl = "";String name = "";String type = "message";
					String dateString = dateFormat.format(singleProjectInviteTracking.getCreateDate()).toString();
					long portraitId = UserLocalServiceUtil.getUser(singleProjectInviteTracking.getMessageFrom()).getPortraitId();
					name =  UserLocalServiceUtil.getUser(singleProjectInviteTracking.getMessageFrom()).getFullName();
					imgUrl = themeDisplay.getPathImage()+"/user_portrait?img_id="+portraitId;
					message = singleProjectInviteTracking.getMessageContent();
					if(message.length() > showChar) {
						message = message.substring(0, showChar) + "...";
					}
				  
					template1 = template1 + " <div id='toltip-item-1' class='toltip-item d-flex position-relative p-0 toltip-overlay border-radius-5'> "+
							" <a href='#' class='close-times' data-id='1' onclick='closeActionMessageDiscussion("+singleProjectInviteTracking.getPK_discussionNotificationId()+")'><i class='fas fa-times-circle'></i></a> "+
							" <div class='status-email'></div> "+
							" <div class='toltip-text p-2 pl-4 w-100'> "+
							" <div class='toltip-header'> "+
							" <div class='toltip-header-left p0'> "+
							" <p>"+name+"</p> "+
							" </div> "+
							" <div class='toltip-header-right text-right p0'> "+
							" <p>"+dateString+" </p> "+
							" </div> "+
							" </div> "+
							" <div class='toltip-subhead p0'> "+
							" <p>"+singleProjectInviteTracking.getMessageTitle()+"</p> "+
							" </div> "+
							" <div class='toltip-content p0'> "+
							" <p>"+message+"</p> "+
							" </div> "+
							" </div> "+
							" </div> ";
				}
			}
			
			// under notifications design
			if(trackNotificationCountRemoved.size()>0){
				for(projectInviteTracking singleProjectInviteTracking:trackNotificationCountRemoved){
					String message = "";String imgUrl = "";String type = "notification";
					//long portraitId = UserLocalServiceUtil.getUser(singleProjectInviteTracking.getInviteTo()).getPortraitId();
					//imgUrl = themeDisplay.getPathImage()+"/user_portrait?img_id="+portraitId;					
					String imageURL = "",imgSRC="";boolean isBase64 = false;
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
					dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(singleProjectInviteTracking.getInviteTo()));
					List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQuery);
					if(values.size()>0){
						imageURL = values.get(0).getFileEntryUrl();					
					    JSONObject jsonObject2 = CommonMethods.getProfileImageBlob(singleProjectInviteTracking.getInviteTo());	               
					    imageURL = jsonObject2.getString("byteArray");
					    imgSRC = "data:image/png;base64,"+imageURL;
					    isBase64 = true;
					}else{
						imageURL = "/o/ahea-theme/images/user.png";
						imgSRC = imageURL;
						isBase64 = false;
					}
					
					message = singleProjectInviteTracking.getEmailContent();
					template2 = template2 + "<div id='toltip-item-1' class='toltip-item toltip-overlay d-flex position-relative'>"
							+ "<a href='javascript:void(0)' class='close-times' data-id='1' onclick='closeActionNotification("+singleProjectInviteTracking.getPK_projectInvitationId()+")'><i class='fa fa-times-circle'></i></a>"
							+ "<div class='toltip-image'>"
							+ "<img src='"+imgSRC+"' width='48'>"
							+ "</div>"
							+ "<div class='toltip-text'>"
							+ "<p>"+message+"</p>"
							+ "</div>"
							+ "</div>";
					//System.out.println("trackNotificationCountRemoved === if === "+template2);
				}
			}
			
			if(trackNotificationCountTask.size()>0){
				for(projectInviteTracking singleProjectInviteTracking:trackNotificationCountTask){
					String message = "";String imgUrl = "";String type = "notification";
					//long portraitId = UserLocalServiceUtil.getUser(singleProjectInviteTracking.getInviteTo()).getPortraitId();
					//imgUrl = themeDisplay.getPathImage()+"/user_portrait?img_id="+portraitId;
					String imageURL = "",imgSRC="";boolean isBase64 = false;
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
					dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(themeDisplay.getUser().getUserId()));
					List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQuery);
					if(values.size()>0){
						imageURL = values.get(0).getFileEntryUrl();					
					    JSONObject jsonObject2 = CommonMethods.getProfileImageBlob(themeDisplay.getUser().getUserId());	               
					    imageURL = jsonObject2.getString("byteArray");
					    imgSRC = "data:image/png;base64,"+imageURL;
					    isBase64 = true;
					}else{
						imageURL = "/o/ahea-theme/images/user.png";
						imgSRC = imageURL;
						isBase64 = false;
					}
					message = singleProjectInviteTracking.getMessageContent();
					/*if(singleProjectInviteTracking.getIsRemoved()==3){*/
						template2 = template2 + "<div id='toltip-item-1' class='toltip-item toltip-overlay d-flex position-relative'>"
								+ "<a href='javascript:void(0)' class='close-times' data-id='1' onclick='closeActionNotification("+singleProjectInviteTracking.getPK_projectInvitationId()+")'><i class='fa fa-times-circle'></i></a>"
								+ "<div class='toltip-image'>"
								+ "<img src='"+imgSRC+"' width='48'>"
								+ "</div>"
								+ "<div class='toltip-text'>"
								+ "<p>"+message+"</p>"
								+ "</div>"
								+ "</div>";
						//System.out.println("trackNotificationCountTask === if === "+template2);
					/*}*/
				}
			}
			
			jsonObject.put("template1", template1);
			jsonObject.put("template2", template2);
			jsonObject.put("messageCount", trackNotificationCount.size()+trackNotificationCountDiscussion.size());
			jsonObject.put("notificationCount", trackNotificationCountRemoved.size()+trackNotificationCountTask.size());
			//jsonObject.put("notificationCount", trackNotificationCountRemoved.size()+trackNotificationCountTask.size());
			out.print(jsonObject);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void closeAction(ResourceRequest resourceRequest,ResourceResponse resourceResponse){
		long actionId = ParamUtil.getLong(resourceRequest, "actionId");
		String type = ParamUtil.getString(resourceRequest, "type");
		PrintWriter out = null;long inviteFrom = 0;String inviteFromName = "";String projectName = "";
		projectInviteTracking projectInviteTracking = null;
		try{
			out = resourceResponse.getWriter();
			projectInviteTracking = projectInviteTrackingLocalServiceUtil.getprojectInviteTracking(actionId);
			if(projectInviteTracking!=null){
				if(type.equalsIgnoreCase("notification")){
					projectInviteTracking.setIsRemoved(2);					
				}else if(type.equalsIgnoreCase("message")){					
					projectInviteTracking.setIsRead(0);					
				}
				projectInviteTrackingLocalServiceUtil.updateprojectInviteTracking(projectInviteTracking);
				out.print("updated");
			}
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}public void closeActionMessageDiscussion(ResourceRequest resourceRequest,ResourceResponse resourceResponse){
		long actionId = ParamUtil.getLong(resourceRequest, "actionId");
		String type = ParamUtil.getString(resourceRequest, "type");
		PrintWriter out = null;long inviteFrom = 0;String inviteFromName = "";String projectName = "";
		discussionMessageNotification discussionMessageNotification = null;
		try{
			out = resourceResponse.getWriter();
			discussionMessageNotification = discussionMessageNotificationLocalServiceUtil.getdiscussionMessageNotification(actionId);
			if(discussionMessageNotification!=null){
				if(type.equalsIgnoreCase("notification")){
					discussionMessageNotification.setIsRemoved(2);					
				}else if(type.equalsIgnoreCase("message")){					
					discussionMessageNotification.setIsRead(0);					
				}
				discussionMessageNotificationLocalServiceUtil.updatediscussionMessageNotification(discussionMessageNotification);
				out.print("updated");
			}
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void projectApproved(ResourceRequest resourceRequest,ResourceResponse resourceResponse){
		PrintWriter out = null;
		labScreenProjectOverview labScreenProjectOverview = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			/*PortletSession session = resourceRequest.getPortletSession();
			String projectId = (String)session.getAttribute("PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
			PK_projectId = new Long(projectId);
			partnersList = (List<labScreenProjectPartners>)session.getAttribute("PROJECT_PARTNERS", PortletSession.APPLICATION_SCOPE);*/
			
			
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
			List<labScreenProjectPartners> partnersList = getPartnerList(resourceRequest);
			
			if(PK_projectId!=0){
				labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverview(PK_projectId);
				labScreenProjectOverview.setUserId(themeDisplay.getUserId());//To know who submitted the project
				labScreenProjectOverview.setModifiedDate(new Date());//To know which date submitted the project
				labScreenProjectOverview.setProjectStatus("Approved");
				labScreenProjectOverviewLocalServiceUtil.updatelabScreenProjectOverview(labScreenProjectOverview);
				
				/*if(themeDisplay.getUserId()==labScreenProjectOverview.getProjectOwnerId()){
					projectInviteTracking projectInviteTracking = projectInviteTrackingLocalServiceUtil.createprojectInviteTracking(CounterLocalServiceUtil.increment());
					projectInviteTracking.setProjectId(PK_projectId);
					projectInviteTracking.setInviteFrom(themeDisplay.getUserId());
					projectInviteTracking.setInviteTo(themeDisplay.getUserId());
					projectInviteTracking.setInvitationStatus("");
					projectInviteTracking.setIsRead(0);
					projectInviteTracking.setIsRemoved(4);
					projectInviteTracking.setMessageContent(labScreenProjectOverview.getProjectName() + " is approved");
					projectInviteTracking.setCreateDate(new Date());						
					projectInviteTrackingLocalServiceUtil.addprojectInviteTracking(projectInviteTracking);
				}*/
				
				if(partnersList.size()>0){
					for(labScreenProjectPartners singleData:partnersList){
						System.out.println("owner id ==="+labScreenProjectOverview.getProjectOwnerId()+"partner id ==="+singleData.getProjectPartnerId());
						if(labScreenProjectOverview.getProjectOwnerId()!=singleData.getProjectPartnerId()){
							projectInviteTracking projectInviteTracking = projectInviteTrackingLocalServiceUtil.createprojectInviteTracking(CounterLocalServiceUtil.increment());
							projectInviteTracking.setProjectId(PK_projectId);
							projectInviteTracking.setInviteFrom(themeDisplay.getUserId());
							projectInviteTracking.setInviteTo(singleData.getProjectPartnerId());
							projectInviteTracking.setInvitationStatus("");
							projectInviteTracking.setIsRead(0);
							projectInviteTracking.setIsRemoved(4);
							projectInviteTracking.setMessageContent(labScreenProjectOverview.getProjectName() + " is approved");
							projectInviteTracking.setCreateDate(new Date());						
							projectInviteTrackingLocalServiceUtil.addprojectInviteTracking(projectInviteTracking);
						}
					}
				}
			}			
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public List<labScreenProjectPartners> getPartnerList(ResourceRequest resourceRequest){
		List<labScreenProjectPartners> partnersList = null;
		labScreenProjectOverview labScreenProjectOverview = null;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
		
		labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(PK_projectId);
		if(labScreenProjectOverview!=null){
			PK_interestId = labScreenProjectOverview.getInterestId();
		}
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());
		 
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("PK_projectId", new Long(PK_interestId));
		 
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("isActive", new Long(0)));
		dynamicQuery.add(criterion);
		 
		partnersList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		resourceRequest.setAttribute("projectPartnersList", partnersList);
		
		return partnersList;
	}
}