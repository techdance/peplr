package com.collaborated.profile.institution.portlet;

import com.collaborated.entity.model.userInstitutionProfileDetails;
import com.collaborated.entity.model.userInstitutionProfileSubDetails;
import com.collaborated.entity.service.userInstitutionProfileDetailsLocalServiceUtil;
import com.collaborated.entity.service.userInstitutionProfileSubDetailsLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=InstitutionProfile Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class InstitutionProfilePortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		JSONObject data=null;
		JSONObject responseJSONInstitute = null;
		PortletSession ps = request.getPortletSession();
		HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(request);
		httprequest = PortalUtil.getOriginalServletRequest(httprequest);
		HttpSession httpsession = httprequest.getSession();
		/*Object obj = ps.getAttribute("MATCHING_KEY", PortletSession.APPLICATION_SCOPE);
		selectedProfileMatching = 0;
		if (obj == null) {
			System.out.println("PortletSession attribute NOT found");
		} else {
			selectedProfileMatching = Long.valueOf(obj.toString());
			System.out.println("PortletSession attribute found"+selectedProfileMatching);
		}*/
		
		String apiURL = PropsUtil.get("INSTITUTION_PROFILE_API_URL");
		
		/*Displaying match profile's university details*/		
		String sessionuserID = (String)httpsession.getAttribute("MATCHING_KEY");
		if(Validator.isNotNull(sessionuserID) && !sessionuserID.isEmpty()){
			long matchProfileUserId = new Long(sessionuserID);
			try {
				User matchProfileUser = UserLocalServiceUtil.getUser(matchProfileUserId);
				apiURL = (String) matchProfileUser.getExpandoBridge().getAttribute("universityURL");
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
        String institutionProfileResonse = getMethodAPI(apiURL); 
	    try {
	    	responseJSONInstitute = JSONFactoryUtil.createJSONObject(institutionProfileResonse);
		    data = responseJSONInstitute.getJSONObject("data");
		    ps.setAttribute("INSTITUTE_PROFILE", data, PortletSession.APPLICATION_SCOPE);
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
		
		super.render(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("getInstituteProfile")){
			getInstituteProfile(resourceRequest,resourceResponse);
		}
	}
	public void getInstituteProfile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		PrintWriter out = null;
		List<userInstitutionProfileDetails> listData = null;
		String template="";
		StringBuilder subTemplate = new StringBuilder();
		try{
			out = resourceResponse.getWriter();
			
			long userId = themeDisplay.getUserId();
			long selectedProfileMatching = 0;
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionuserID = (String)httpsession.getAttribute("MATCHING_KEY");
			long currentUser = (Long)httpsession.getAttribute("currentUser");	
			if(currentUser==themeDisplay.getUserId()){
				selectedProfileMatching = new Long(sessionuserID);	
			}
			if(selectedProfileMatching>0){
				userId = selectedProfileMatching;
			}
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userInstitutionProfileDetails.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
			listData = userInstitutionProfileDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(listData.size()>0){				
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("institutionProfileId",listData.get(0).getPK_userInstition());
				jsonObject.put("institutionName",listData.get(0).getInstitutionName());
				jsonObject.put("academCalendar",listData.get(0).getAcadeCalendar());
				jsonObject.put("departamentDescription", listData.get(0).getDepartmentdescription());	
				DynamicQuery dynamicQuerySub = DynamicQueryFactoryUtil.forClass(userInstitutionProfileSubDetails.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
				List<userInstitutionProfileSubDetails> listSubData = userInstitutionProfileSubDetailsLocalServiceUtil.dynamicQuery(dynamicQuerySub);
				if(listSubData.size()>0){	
					for(userInstitutionProfileSubDetails sub:listSubData){
						if(sub.getFileId()!=0){
							FileEntry dlFileEntry = DLAppLocalServiceUtil.getFileEntry(sub.getFileId());
							String imgURL = themeDisplay.getPortalURL()+"/documents/" + dlFileEntry.getGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle();
							JSONObject jsonObjectSub = JSONFactoryUtil.createJSONObject();
							jsonObjectSub.put("url", imgURL);
							jsonObjectSub.put("fileName", dlFileEntry.getTitle());
							jsonArray.put(jsonObjectSub);
							subTemplate.append("<h4 class=\"mt-3 headingresource\">Research Papers</h4><a target=\"_blank\" class=\"list-group-item list-group-item-action list-style-custom content-icon pt-0 d-flex justify-content-start align-items-start resourcepaper\" href=\""+imgURL+"\"><i class=\"far fa-file-pdf mr-2 mt-2\"></i>" + dlFileEntry.getTitle() + "</a>");
						}
					}
				}
				jsonObject.put("subDetails", jsonArray);
				
				template = "<div class=\"box-middle\"> "
								+ "<div class=\"content-icon\">  <span class=\"icon-regular icon-user-shield\"></span>><a href=\"#\">"+listData.get(0).getInstitutionName()+"</a></div>"
								+ "<div class=\"content-icon\">  <i class=\"fas fa-map\"></i><a href=\"#\">Google Maps</a></div>"
								+ "<div class=\"content-icon\"> <span class=\"icon-regular icon-calendar-check\"></span> 4-year Institution </div>"
								+ "<div class=\"content-icon\"> <span class=\"icon-regular icon-globe\"></span><a href=\"#\">Iowa City, IA USA</a> </div>"
								+ "<div class=\"content-icon\"> <span class=\"icon-regular icon-globe-americas\"></span> North America </div>"
								+ "<div class=\"content-icon\">  <span class=\"icon-regular icon-calendar-week\"></span><a href=\"#\">"+listData.get(0).getAcadeCalendar()+"</a></div>"
								+ "<div class=\"content-icon\">  <span class=\"icon-regular icon-business-time\"></span><a href=\"#\">"+listData.get(0).getDepartmentdescription()+"</a></div>"
								//+ "<div id=\"file-nameapnd\" class=\"list-group list-group-flush\">" + subTemplate </div>"
							+"	</div>";
				
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