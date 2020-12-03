package com.collaborated.project.invites.portlet;


import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.model.userCredential;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil;
import com.collaborated.entity.service.projectInviteTrackingLocalServiceUtil;
import com.collaborated.entity.service.userCredentialLocalServiceUtil;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
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
		"javax.portlet.display-name=ProjectInvites Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProjectinvitesPortlet extends MVCPortlet {
	
	/*
	 * @isRemoved - 0(Accepted),1(Declined),2(read)
	 * @isRead - 0(read),1(not read)
	 * 
	 */
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		JSONObject data=null;
		JSONObject responseJSONInstitute = null;String instituteName = "";String department = "";
		PortletSession ps = request.getPortletSession();
		responseJSONInstitute = (JSONObject)ps.getAttribute("INSTITUTE_PROFILE",PortletSession.APPLICATION_SCOPE);
		if(responseJSONInstitute!=null){
			instituteName = responseJSONInstitute.getString("institutionName");
			JSONObject institutionContact = responseJSONInstitute.getJSONObject("institutionContact");
			if(institutionContact!=null){
				department = institutionContact.getString("department");
			}
		}
		super.render(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("loadProjectInvites")){
			loadProjectInvites(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("updateProjectInvites")){
			updateProjectInvites(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getViewMoreData")){
			getViewMoreData(resourceRequest,resourceResponse);
		}
	}
	
	public void loadProjectInvites(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String key = ParamUtil.getString(resourceRequest, "key");
		String template="";
		PrintWriter out = null;
		List<projectInviteTracking> trackingList = null;
		User inviteDetail = null;
		profileAreaofinterest profileAreaofinterest = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
		try{
			out = resourceResponse.getWriter();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, PortalClassLoaderUtil.getClassLoader());
			
			if(key.equalsIgnoreCase("sent")){
				dynamicQuery.add(PropertyFactoryUtil.forName("inviteFrom").eq(Long.valueOf(themeDisplay.getUserId())));
				dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
				trackingList = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQuery);
			}else{
				//dynamicQuery.add(PropertyFactoryUtil.forName("inviteTo").eq(Long.valueOf(themeDisplay.getUserId())));
				dynamicQuery.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("inviteTo",themeDisplay.getUserId()),RestrictionsFactoryUtil.ne("invitationStatus", "Declined")));
				dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));
				trackingList = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQuery);
			}
						
			if(trackingList.size()>0){
				for(projectInviteTracking singleTrackingData:trackingList){
					if(singleTrackingData.getInvitationStatus()!=""){
						int i = 1;
						String userNameDegree = "";
						String userPosition = "";
						String userCollege = "";
						String sentReceiveDate = "";
						String projectType = "";
						String preferredLanguage = "";
						String disipline = "";
						String region = "";
						String projectInviteStatus = "";
						String receiveActions = "";
						String imgUrl = "";
						String educationLevel = "";
						/*String instituteDepartment = "";*/
						String userDepartment= "";
						String imageURL = "",imgSRC="";boolean isBase64 = false;
						
						if(key.equalsIgnoreCase("sent")){
							if(singleTrackingData.getInviteTo()!=0){
								inviteDetail = UserLocalServiceUtil.getUser(singleTrackingData.getInviteTo());
							}
						}else{
							if(singleTrackingData.getInviteFrom()!=0){
								inviteDetail = UserLocalServiceUtil.getUser(singleTrackingData.getInviteFrom());
							}
						}
						if(inviteDetail!=null){
							userNameDegree = inviteDetail.getFullName();
							if(inviteDetail.getJobTitle()!=""){userPosition = ", "; }
							userPosition = inviteDetail.getJobTitle()+userPosition;
							userDepartment = (String) inviteDetail.getExpandoBridge().getAttribute("userDepartment");
							/*instituteDepartment = (String) inviteDetail.getExpandoBridge().getAttribute("instituteDepartment");*/
							userCollege = (String) inviteDetail.getExpandoBridge().getAttribute("instituteName");	
					
							sentReceiveDate = formatter.format(singleTrackingData.getCreateDate());
							//long portraitId = inviteDetail.getPortraitId();
							imgUrl = inviteDetail.getPortraitURL(themeDisplay);
							
							imageURL = "";imgSRC="";isBase64 = false;
							DynamicQuery dynamicQueryProfile = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
							dynamicQueryProfile.add(PropertyFactoryUtil.forName("userId").eq(inviteDetail.getUserId()));
							List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQueryProfile);
							if(values.size()>0){
								imageURL = values.get(0).getFileEntryUrl();					
							    JSONObject jsonObject2 = CommonMethods.getProfileImageBlob(inviteDetail.getUserId());	               
							    imageURL = jsonObject2.getString("byteArray");
							    imgSRC = "data:image/png;base64,"+imageURL;
							    isBase64 = true;
							}else{
								imageURL = "/o/ahea-theme/images/user.png";
								imgSRC = imageURL;
								isBase64 = false;
							}
							
							DynamicQuery dynamicQueryCredential = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
							dynamicQueryCredential.add(PropertyFactoryUtil.forName("userId").eq(inviteDetail.getUserId()));
							List<userCredential> creList = userCredentialLocalServiceUtil.dynamicQuery(dynamicQueryCredential);
							if(creList.size()>0){
								 educationLevel = "";
								 if(creList.get(0).getMembership4()!=""){ educationLevel = ", "; }
								 educationLevel = educationLevel + creList.get(0).getMembership4();
							}
						}
						
						if(singleTrackingData.getProjectId()>0){
							profileAreaofinterest = profileAreaofinterestLocalServiceUtil.getprofileAreaofinterest(singleTrackingData.getProjectId());
							if(profileAreaofinterest!=null){
								projectType = profileAreaofinterest.getProjectType(); 
								preferredLanguage = profileAreaofinterest.getLanguage();
								disipline = profileAreaofinterest.getDiscipline1();
								region = profileAreaofinterest.getLocation1();
							}
						}
						
						projectInviteStatus = singleTrackingData.getInvitationStatus();
						
						
						
						if(key.equalsIgnoreCase("receive") && projectInviteStatus.equalsIgnoreCase("Pending")){
							receiveActions = "<td><div class=\"d-flex mb-4\">"
									+ "<a href=\"#\" class=\"btn btn-blue btn-sm mr-2 color-white\" onclick=\"updateProjectInviteStatusDeclined(1,"+singleTrackingData.getPK_projectInvitationId()+")\">DECLINE</a>"
									+ "<a href=\"#\" class=\"btn btn-blue btn-sm color-white\" onclick=\"updateProjectInviteStatus(0,"+singleTrackingData.getPK_projectInvitationId()+")\">ACCEPT</a> </div>"
									+ "<div class=\"text-center\"><a href=\"javascript:void(0);\" data-toggle=\"modal\" data-target=\"#popup-"+singleTrackingData.getProjectId()+"\" onclick=\"getViewMoreData("+singleTrackingData.getProjectId()+")\">View More <i class=\"far fa-arrow-alt-circle-right\"></i></a>"
											+ "<div class=\"modal fade modalToltip modalareainterest \" id=\"popup-"+singleTrackingData.getProjectId()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modalLabel\" aria-hidden=\"true\"></div></div>"
									+ "</td>";
						}else if(key.equalsIgnoreCase("sent")){
							receiveActions = "<td><p>"+projectInviteStatus+"</p>"
									+  "<div class=\"text-left\"><a href=\"javascript:void(0);\" data-toggle=\"modal\" data-target=\"#popup-"+singleTrackingData.getProjectId()+"\" onclick=\"getViewMoreData("+singleTrackingData.getProjectId()+")\">View More <i class=\"far fa-arrow-alt-circle-right\"></i></a>"
									+ "<div class=\"modal fade modalToltip modalareainterest \" id=\"popup-"+singleTrackingData.getProjectId()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modalLabel\" aria-hidden=\"true\"></div></div>"
						+"</td>";
						}else if(key.equalsIgnoreCase("receive") && (!projectInviteStatus.equalsIgnoreCase("Pending"))){
							receiveActions = "<td><p>"+projectInviteStatus+"</p><br><div class=\"d-flex mb-4\"><div class=\"text-center\">"
									+ "<a href=\"javascript:void(0);\" data-toggle=\"modal\" data-target=\"#popup-"+singleTrackingData.getProjectId()+"\" onclick=\"getViewMoreData("+singleTrackingData.getProjectId()+")\">View More <i class=\"far fa-arrow-alt-circle-right\"></i></a>"
											+ "<div class=\"modal fade modalToltip modalareainterest \" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modalLabel\" aria-hidden=\"true\" id=\"popup-"+singleTrackingData.getProjectId()+"\"></div></div></div></td>";
						}
						
						template = template + "<tr id=\"Project_Invites_"+i+"\">"
								+ "<td width='180px' class=\"border-bottom-none\"> <div class=\"person-img\"> <img src="+imgSRC+" width=\"95\"> </div> </td>" 
								+ "<td><p class=\"invites-head\">"+userNameDegree+educationLevel+"</p><p class=\"invites-content\">"+userPosition+userDepartment+"</p>"
								+ "<p class=\"font-style-italic\"><a href=\"#\">"+userCollege+"</a></p> <p class=\"invites-date\">"+sentReceiveDate+"</p> </td>"
								+ "<td><p class=\"mb-2\"><strong>Project</strong><br>"+projectType+"</p><p><strong>Discipline</strong><br>"+disipline+"</p></td>"
								+ "<td><p class=\"mb-2\"><strong>Preferred Language</strong><br>"+preferredLanguage+"</p><p><strong>Region</strong><br>"+region+"</p></td>"
								+ receiveActions
								+ "</tr>"
								;
						i++;
					}
				}
			}			
			out.print("<table class=\"table table-invite\">"+template+"</table>");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void updateProjectInvites(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		long status = ParamUtil.getLong(resourceRequest, "status");
		long inviteId = ParamUtil.getLong(resourceRequest, "inviteId");
		projectInviteTracking projectInviteTracking = null;long inviteTo = 0;String inviteToName = "";
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;
		try{
			out = resourceResponse.getWriter();
			if(inviteId>0){
				projectInviteTracking = projectInviteTrackingLocalServiceUtil.getprojectInviteTracking(inviteId);
				inviteTo = projectInviteTracking.getInviteTo();
				inviteToName = UserLocalServiceUtil.getUser(inviteTo).getFullName();
				if(status==1){
					projectInviteTracking.setInvitationStatus("Declined");
					projectInviteTracking.setIsRemoved(1);	
					projectInviteTracking.setEmailContent(inviteToName+" declined your invitation");
				}else if(status==0){
					projectInviteTracking.setInvitationStatus("Accepted");
					projectInviteTracking.setIsRemoved(0);
					projectInviteTracking.setEmailContent(inviteToName+" accepted your invitation");
					
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());
					dynamicQuery.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("PK_projectId",projectInviteTracking.getProjectId()),RestrictionsFactoryUtil.eq("projectPartnerId", themeDisplay.getUserId())));
					List<labScreenProjectPartners> labScreenProjectPartnersList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQuery);
					if(labScreenProjectPartnersList.size()>0){
						labScreenProjectPartners labScreenProjectPartners = labScreenProjectPartnersLocalServiceUtil.fetchlabScreenProjectPartners(labScreenProjectPartnersList.get(0).getPK_projectPartnerId());
						labScreenProjectPartners.setIsActive(0);
						labScreenProjectPartners.setModifiedDate(new Date());
						labScreenProjectPartnersLocalServiceUtil.updatelabScreenProjectPartners(labScreenProjectPartners);
					}
				}
				projectInviteTrackingLocalServiceUtil.updateprojectInviteTracking(projectInviteTracking);
				out.print("saved");
			}
		}catch(Exception e){
			
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
		String template = "";String programLevel = "", deliveryMethod = "";
		try{
			out = resourceResponse.getWriter();
			singleData = profileAreaofinterestLocalServiceUtil.fetchprofileAreaofinterest(key);
			if(singleData!=null){
				if(singleData.getCampus().equalsIgnoreCase("1")){
					intercampus = "Intracampus";
				}else if(singleData.getCampus().equalsIgnoreCase("2")){
					intercampus = "Intercampus";
				}
				if(singleData.getProgramLevel().equalsIgnoreCase("Post Doctoral")){
					programLevel = "Post-Doctoral";
        		}else{
        			programLevel = singleData.getProgramLevel();
        		}
				
				deliveryMethod = singleData.getDeliveryMethod();
				if(singleData.getDeliveryMethod().equalsIgnoreCase("Blended or Hybrid")){
					deliveryMethod = "Blended";
				}
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("projectType", singleData.getProjectType());
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
				jsonObject.put("startMonth", singleData.getRangerMonthStart());
				jsonObject.put("endMonth", singleData.getRangerMonthEnd());
				jsonObject.put("startYear", singleData.getRangerYearStart());
				jsonObject.put("endYear", singleData.getRangerYearEnd());
				jsonObject.put("PK_areaofinterest", singleData.getPK_areaofinterest());
				/*template = "<div class=\"modal modalToltip \" id=\"popup"+key+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modalLabel\" aria-hidden=\"true\">"*/
				template =  " <div class='modal-dialog'> " +
							" <div class='modal-content'> " +
							" <div class='modal-header'> " +
							" <div class='font15 my-auto text-center d-flex flex-column w-100'><strong>Project</strong><span>"+singleData.getProjectType()+"</span></div> " +
							" <div class='toltip-close3'><a href='javascript:void(0);' data-dismiss='modal'><i class='fa fa-times-circle'></i></a></div> " +
							" </div> " +
							" <div class='modal-body'> " +
							" <div class='interest-modal'> "+
							" <div class='view-more-interest-modal-inner'> "+
							" <div class='view-more-interest-modal-inner-content'> "+
							" <div class='row mb-2'> <div class='col-md-12 d-flex flex-column'> "+
							" <strong>Description</strong> "+
							" <span id='description'>"+ singleData.getDescription() +"</span> "+
							" </div> </div> <div class='row  mb-2'> <div class='col-md-6 d-flex flex-column'> "+
							" <strong>Discipline</strong> "+
							" <span id='discipline'>"+singleData.getDiscipline1()+"</span> "+
							" </div> <div class='col-md-6 d-flex flex-column'> "+
							" <strong>Delivery Method</strong> "+
							" <span id='deliveryMethod'>"+ singleData.getDeliveryMethod() +"</span> "+
							" </div></div><div class='row mb-2'><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Collaboration Type</strong> "+
							" <span id='collaborationType'>"+ singleData.getCollaborationType() +"</span> "+
							" </div><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Region</strong> "+
							" <span id='region'>"+ singleData.getLocation1() +"</span> "+
							" </div><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Program Length</strong> "+
							" <span id='programLength'>"+ singleData.getProgramLength() +"</span> "+
							" </div></div><div class='row mb-2'><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Preferred Language</strong> "+
							" <span id='preferredLanguage'>"+ singleData.getLanguage() +"</span> "+
							" </div><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Credits</strong> "+
							" <span id='credits'>"+ singleData.getCredits() +"</span> "+
							" </div><div class='col-md-4 d-flex flex-column'> "+
							" <strong>Program Level</strong> "+
							" <span id='programLevel'>"+ programLevel +"</span> "+
							" </div></div><div class='row mb-2'><div class='col-md-12 disableField'>	 "+
							" <strong>Project Date Range</strong> "+
							" <div class='top-label-range'><div class='top-init-range'><div><span class='projectInviteStartDay mr-1'>"+ singleData.getRangerMonthStart() + "</span><span id='projectInviteDay'>" + singleData.getRangerYearStart() +"</span></div></div> "+
							" <div class='year-last-range pickerdata'><input type='text' class='rangerDatepickerPID' id='rangerDatepickerPID' value='"+ singleData.getRangerYearEnd() +"' readonly/></div></div> "+
							" <input type='text' class='js-range-slider' id='projectRangePID' name='my_range' value='"+singleData.getRangerMonthEnd()+"' /> "+
							" </div></div></div></div></div> "+
							" </div> " +
							" </div> " +
							" </div>";
			}
			JSONObject jsonObjectFinal = JSONFactoryUtil.createJSONObject();
			jsonObjectFinal.put("rangerData",jsonObject);
			jsonObjectFinal.put("template", template);
			out.print(jsonObjectFinal);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
}