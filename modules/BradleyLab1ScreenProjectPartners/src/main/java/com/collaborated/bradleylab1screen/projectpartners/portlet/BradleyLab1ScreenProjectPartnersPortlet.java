package com.collaborated.bradleylab1screen.projectpartners.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
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
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BradleyLab1ScreenProjectPartners Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		/*"com.liferay.portlet.private-session-attributes=false",*/
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BradleyLab1ScreenProjectPartnersPortlet extends MVCPortlet {
	long PK_projectId = 0;long PK_interestId = 0;
	List<labScreenProjectPartners> partnersList = null;

	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		PortletSession session = renderRequest.getPortletSession();
		//partnersList = (List<labScreenProjectPartners>) session.getAttribute("partnerList", PortletSession.APPLICATION_SCOPE);
		
		JSONObject userJSON = (JSONObject)session.getAttribute("USER_PROFILE",PortletSession.APPLICATION_SCOPE);
		
		
		/*String apiURL = "http://23.99.141.44:3000/api/institution-profile";
        String institutionProfileResonse = getMethodAPI(apiURL); 
	    try {
	    	JSONObject responseJSONInstitute = JSONFactoryUtil.createJSONObject(institutionProfileResonse);
	    	institutionProfile = responseJSONInstitute.getJSONObject("data");
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }*/
		
		super.doView(renderRequest, renderResponse); // make sure this is the last line in your method
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if (resourceID != null && resourceID.equals("loadProjectPartners")) {
			loadProjectPartners(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("loadProfileDetails")) {
			loadProfileDetails(resourceRequest,resourceResponse);
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
	
	public void loadProjectPartners(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		PrintWriter out = null;
		String template="";long inviteFrom = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<labScreenProjectOverview> labScreenProjectOverview = null;
		try{
			 out = resourceResponse.getWriter();
			
			 /*if(institutionProfile!=null){
					instituteName = institutionProfile.getString("institutionName");
					JSONObject instituteProfileContact = institutionProfile.getJSONObject("institutionLocation");			
					if(instituteProfileContact!=null){						
						cityState = instituteProfileContact.getString("city")+", "+instituteProfileContact.getString("state");								
					}
			}*/
			
			 
			partnersList = getPartnerList(resourceRequest);
			
			SimpleDateFormat dateTimeFormat = new SimpleDateFormat("hh:mm a");
	        
	        
			if(partnersList.size()>0){		
				/*DynamicQuery dynamicQueryResources = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryResources.add(PropertyFactoryUtil.forName("interestId").eq(partnersList.get(0).getPK_projectId()));
				labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(dynamicQueryResources);*/
				inviteFrom = partnersList.get(0).getUserId();
				for(labScreenProjectPartners singleData:partnersList){
					String imageUrl = "";
					/*if(singleData.getProjectPartnerId()!=themeDisplay.getUserId()){*/
						User user = UserLocalServiceUtil.getUser(singleData.getProjectPartnerId());
						//imageUrl = user.getPortraitURL(themeDisplay);
						String url = themeDisplay.getURLPortal()+"/edit-profile?param=interest";
						//String instituteName = (String) user.getExpandoBridge().getAttribute("status");
						String imageURL = "",imgSRC="";boolean isBase64 = false;
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
						
						String instituteName = (String) user.getExpandoBridge().getAttribute("instituteName");
						String instituteDepartment = (String) user.getExpandoBridge().getAttribute("instituteDepartment");
						String instituteCity = (String) user.getExpandoBridge().getAttribute("instituteCity");
						String instituteState = (String) user.getExpandoBridge().getAttribute("instituteState");
						String instituteCountry = (String) user.getExpandoBridge().getAttribute("instituteCountry");
						String insTimezone = (String)user.getExpandoBridge().getAttribute("instituteTimezone");
						
						String estDateTimeString = "";
						if(insTimezone!=""){
							dateTimeFormat.setTimeZone(TimeZone.getTimeZone(insTimezone));
					        estDateTimeString = dateTimeFormat.format(new Date()); //(EST)
						}
						
						template = template + "<div class='col-md-4'>"
								+ "<div class='item item-flex'>"
								+ "<div class='item-img'>"
								+ "<img src='"+imgSRC+"' alt='' width='58'>"
								/*+ "<span class='user-active'></span>"*/
								+ "</div>"
								+ "<div class='item-text'>"
								+ "<div class='partner partner-name position-relative'><a href='#' onClick='goToProfile("+ user.getUserId() +")'>"
								+ " "+ user.getFullName() + "- "+estDateTimeString+"</a>"
								+ "<div class='toltip-phone'>"
								+ "<a href='#'><img src='/o/ahea-theme/images/contact-partner-1.png'></a>"
								+ "<a href='#'><img src='/o/ahea-theme/images/contact-partner-3.png'></a>"
								+ "<a href='#'><img src='/o/ahea-theme/images/contact-partner-2.png'></a>"
								+ "</div>"
								+ "</div>"
								+ "<span class='partner partner-title'>"+user.getJobTitle()+"</span>"
								+ "<span class='partner partner-title'>"+instituteDepartment+"</span>"
								+ "<span class='partner partner-university'>"+instituteName+"</span>"
								+ "<span class='partner partner-address'>"+instituteCity + ", "+instituteState+" "+instituteCountry+"</span>"
								+ "</div>"
								+ "</div>"
								+ "</div>";
					/*}*/
				}
				if(inviteFrom>0){
					String imageUrl = "";
					User user = UserLocalServiceUtil.getUser(inviteFrom);
					
					String imageURL = "",imgSRC="";boolean isBase64 = false;
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
					
					String instituteName = (String) user.getExpandoBridge().getAttribute("instituteName");
					String instituteDepartment = (String) user.getExpandoBridge().getAttribute("instituteDepartment");
					String instituteCity = (String) user.getExpandoBridge().getAttribute("instituteCity");
					String instituteState = (String) user.getExpandoBridge().getAttribute("instituteState");
					String instituteCountry = (String) user.getExpandoBridge().getAttribute("instituteCountry");
					String insTimezone = (String)user.getExpandoBridge().getAttribute("instituteTimezone");
					
					String estDateTimeString = "";
					if(insTimezone!=""){
						dateTimeFormat.setTimeZone(TimeZone.getTimeZone(insTimezone));
						estDateTimeString = dateTimeFormat.format(new Date()); //(EST)
					}
					
					//imageUrl = user.getPortraitURL(themeDisplay);
					String url = themeDisplay.getURLPortal()+"/edit-profile?param=interest";
					template = template + "<div class='col-md-4'>"
							+ "<div class='item item-flex'>"
							+ "<div class='item-img'>"
							+ "<img src='"+imgSRC+"' alt='' width='58'>"
							/*+ "<span class='user-active'></span>"*/
							+ "</div>"
							+ "<div class='item-text'>"
							+ "<div class='partner partner-name position-relative'><a href='#' onClick='goToProfile("+ user.getUserId() +")'>"
							+ " "+ user.getFullName() + "- "+estDateTimeString+" Local Time</a>"
							+ "<div class='toltip-phone'>"
							+ "<a href='#'><img src='/o/ahea-theme/images/contact-partner-1.png'></a>"
							+ "<a href='#'><img src='/o/ahea-theme/images/contact-partner-3.png'></a>"
							+ "<a href='#'><img src='/o/ahea-theme/images/contact-partner-2.png'></a>"
							+ "</div>"
							+ "</div>"
							+ "<span class='partner partner-title'>"+user.getJobTitle()+"</span>"
							+ "<span class='partner partner-title'>"+instituteDepartment+"</span>"
							+ "<span class='partner partner-university'>"+instituteName+"</span>"
							+ "<span class='partner partner-address'>"+instituteCity + ", "+instituteState+" "+instituteCountry+"</span>"
							+ "</div>"
							+ "</div>"
							+ "</div>";
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
	
	public void loadProfileDetails(ResourceRequest request, ResourceResponse response){
		String key = ParamUtil.getString(request, "key");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			/*PortletSession ps = request.getPortletSession();
			ps.setAttribute("MATCHING_KEY", key, PortletSession.APPLICATION_SCOPE);*/
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(request);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession session = httprequest.getSession();
			session.removeAttribute("MATCHING_KEY");			
			session.setAttribute("MATCHING_KEY", key);
			session.setAttribute("currentUser", themeDisplay.getUserId());
			
		}catch(Exception e){}
		finally{
			
		}
	}
	
	public String getMethodAPI(String apiURL) {
		String returnData ="";
		ResponseEntity<String> returnObject= null;		
		try {
			RestTemplate restTemplate = new RestTemplate();
			returnObject=restTemplate.getForEntity(apiURL,String.class);
			if(returnObject!=null){
				returnData = returnObject.getBody();
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return returnData;
	}
}