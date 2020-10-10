package com.collaborated.projectpartner.portlet;

import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil;
import com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;

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
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;

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

import org.osgi.service.component.annotations.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProjectPartner Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProjectPartnerPortlet extends MVCPortlet {
	
	JSONObject institutionProfile = null;
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		PortletSession session = renderRequest.getPortletSession();
		String apiURL = "http://23.99.141.44:3000/api/institution-profile";
        String institutionProfileResonse = getMethodAPI(apiURL); 
	    try {
	    	JSONObject responseJSONInstitute = JSONFactoryUtil.createJSONObject(institutionProfileResonse);
	    	institutionProfile = responseJSONInstitute.getJSONObject("data");
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
		super.doView(renderRequest, renderResponse); // make sure this is the last line in your method
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("getMyProjectsPartners")) {
			getMyProjectsPartners(resourceRequest,resourceResponse);
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
	
	public void getMyProjectsPartners(ResourceRequest resourceRequest,ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;
		long showProjectCount = 0;String template = "";
		String imageURL = "",imgSRC="";boolean isBase64 = false;
		try{
			out = resourceResponse.getWriter();
			DynamicQuery projectListQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, "labScreenProjectOverview",PortalClassLoaderUtil.getClassLoader());
			projectListQuery.addOrder(OrderFactoryUtil.desc("labScreenProjectOverview.createDate"));
			List<labScreenProjectOverview> projectListAll = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(projectListQuery);

			if(projectListAll.size()>0){
				for(labScreenProjectOverview singleData:projectListAll){					
					boolean showProjects = false;					
					//Get projects created by current user
					DynamicQuery dynamicQueryPartners = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());
					dynamicQueryPartners.add(RestrictionsFactoryUtil.eq("PK_projectId",singleData.getInterestId()));
					List<labScreenProjectPartners> partnerList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQueryPartners); 
					
					if(partnerList.size()>0){
						for(labScreenProjectPartners singleDataPartner:partnerList){
							if(singleDataPartner.getProjectPartnerId()==themeDisplay.getUserId()){								
								showProjects = true;								
							}
						}
					}
					
					/*if(singleData.getProjectOwnerId()==themeDisplay.getUserId()){
						showProjects = true;						
					}*/
					
					String organizerName = "";String organizerProfileImage = "",jobTitle="";
					
					
					
					if(showProjects==true){																											
						if(partnerList.size()>0){
							showProjectCount = showProjectCount + 1;
							User user = UserLocalServiceUtil.getUser(singleData.getProjectOwnerId());
							organizerName = user.getFullName();
							imageURL = "";imgSRC="";isBase64 = false;
							DynamicQuery dynamicQueryProfile = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
							dynamicQueryProfile.add(PropertyFactoryUtil.forName("userId").eq(user.getUserId()));
							List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQueryProfile);
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
							jobTitle = user.getJobTitle();
							
							String instituteName = (String) user.getExpandoBridge().getAttribute("instituteName");
							String instituteDepartment = (String) user.getExpandoBridge().getAttribute("instituteDepartment");
							String instituteCity = (String) user.getExpandoBridge().getAttribute("instituteCity");
							String instituteState = (String) user.getExpandoBridge().getAttribute("instituteState");
							String instituteCountry = (String) user.getExpandoBridge().getAttribute("instituteCountry");
							
							SimpleDateFormat dateTimeFormat = new SimpleDateFormat("hh:mm a");
					        dateTimeFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
					        String estDateTimeString = dateTimeFormat.format(new Date()); //(EST)
							
							/*template = template + organizerName + jobTitle + department + instituteName + cityState;*/
							template = template + " <div class='item d-flex'>"
									+" <div class='item-img'>"
									+" <div class='position-relative'>"
										+" <img src='"+imgSRC+"' alt='' width='58'><span class='user-active'></span>"
									+" </div>"
								+" </div>"
								+" <div class='item-text'>"
									+" <div class='partner partner-name position-relative'>"+organizerName+" <br>"
										+" <i class='far fa-clock'></i> "+estDateTimeString+" Local Time"
									+" </div>"
									+" <span class='partner partner-title'>"+jobTitle+"</span>"
									+" <span class='partner partner-title'>"+instituteDepartment+"</span>"
									+" <span class='partner partner-university'>"+instituteName+"</span>"
									+" <span class='partner partner-address font-bold'>"+instituteCity+", "+instituteState+" "+instituteCountry+"</span>"
									+" </span>"
								+" </div>"
							+" </div>";
							break;
						}												
					}
				} 
			}
			out.print(template);
		}catch(Exception e){}
		finally{
			if(out!=null){
				out.close();
			}
		}
	}
}