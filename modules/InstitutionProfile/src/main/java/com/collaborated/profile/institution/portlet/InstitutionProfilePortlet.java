package com.collaborated.profile.institution.portlet;

import com.collaborated.entity.model.userInstitutionProfileDetails;
import com.collaborated.entity.model.userInstitutionProfileSubDetails;
import com.collaborated.entity.service.userInstitutionProfileDetailsLocalServiceUtil;
import com.collaborated.entity.service.userInstitutionProfileSubDetailsLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
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

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=InstitutionProfile Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class InstitutionProfilePortlet extends MVCPortlet {
	
	public static long selectedProfileMatching = 0;
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		PortletSession ps = request.getPortletSession();
		Object obj = ps.getAttribute("LIFERAY_SHARED_MATCHING_KEY", PortletSession.APPLICATION_SCOPE);
		selectedProfileMatching = 0;
		if (obj == null) {
			System.out.println("PortletSession attribute NOT found");
		} else {
			selectedProfileMatching = Long.valueOf(obj.toString());
			System.out.println("PortletSession attribute found"+selectedProfileMatching);
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
								+ "<div class=\"content-icon\">  <i class=\"fas fa-shield-alt\"></i><a href=\"#\">"+listData.get(0).getInstitutionName()+"</a></div>"
								+ "<div class=\"content-icon\">  <i class=\"fas fa-map\"></i><a href=\"#\">Google Maps</a></div>"
								+ "<div class=\"content-icon\">  <i class=\"far fa-calendar-check\"></i><a href=\"#\">"+listData.get(0).getAcadeCalendar()+"</a></div>"
								+ "<div class=\"content-icon\">  <i class=\"fas fa-address-card\"></i><a href=\"#\">"+listData.get(0).getDepartmentdescription()+"</a></div>"
								+ "<div id=\"file-nameapnd\" class=\"list-group list-group-flush\">" + subTemplate 
								+ "</div>"
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
}