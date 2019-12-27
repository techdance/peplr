package com.collaborated.profile.professionalbio.portlet;

import com.collaborated.entity.model.userProfessionalBio;
import com.collaborated.entity.service.userProfessionalBioLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
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
		"javax.portlet.display-name=ProfessionalBio Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProfessionalBioPortlet extends MVCPortlet {
	
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
		if(resourceID != null && resourceID.equals("getProfessionalBio")){
			getProfessionalBio(resourceRequest,resourceResponse);
		}
	}
	public void getProfessionalBio(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		PrintWriter out = null;
		List<userProfessionalBio> listData = null;
		String template="";
		try{
			out = resourceResponse.getWriter();
			
			long userId = themeDisplay.getUserId();
			if(selectedProfileMatching>0){
				userId = selectedProfileMatching;
			}
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfessionalBio.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
			listData = userProfessionalBioLocalServiceUtil.dynamicQuery(dynamicQuery);
			jsonArray = JSONFactoryUtil.createJSONArray();
			if(listData.size()>0){				
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("professionalBioId",listData.get(0).getPK_userProfessionalBio());
				jsonObject.put("areasofexpertise1",listData.get(0).getAreaofexpertise1());
				jsonObject.put("areasofexpertise2",listData.get(0).getAreaofexpertise2());
				jsonObject.put("areasofexpertise3", listData.get(0).getAreaofexpertise3());
				jsonObject.put("experienceLevel", listData.get(0).getExperienceyears());
				jsonObject.put("cvLink", listData.get(0).getCvlink());
				jsonObject.put("bioDescription",listData.get(0).getBiodescription());					
				jsonArray.put(jsonObject);
				
				template = "<div class=\"box-middle\"> "
								+ "<div class=\"content-icon position-relative\">"
									+ "<div><i class=\"fas fa-binoculars\"></i><strong>Areas of Expertise</strong></div>"
									+ "<p class=\"blue-color ml20\"><a href=\"#\">"+ listData.get(0).getAreaofexpertise1() +"</a><br> <a href=\"#\">"+ listData.get(0).getAreaofexpertise2() +"</a><br><a href=\"#\">"+ listData.get(0).getAreaofexpertise3() +"</a></p>"
								+ "</div>"
								+ "<div class=\"content-icon\">"
									+ "<div><i class=\"fas fa-address-book\"></i><strong>Bio</strong></div>"
									+ "<div class=\"text\"><p>"+listData.get(0).getBiodescription()+"</p></div>"
								+ "</div>"
								+ "<div class=\"content-icon plane\">"
									+ "<p><i class=\"fas fa-plane rotate320deg\"></i><a href=\"#\">"+listData.get(0).getExperienceyears()+" Years of International Experience</a></p>"
								+ "</div>"
								+ "<div>"
									+ "<div class=\"content-icon video\">"
										+ "<div style=\"margin-bottom:8px\"><i class=\"fab fa-youtube\"></i><strong>Introduction Video</strong></div>"
										+ "<div class=\"wrap-video img-resp\">"
											+ "<img src=\"/o/ahea-theme/images/sanaa-video.png\">"
										+ "</div>"
										+ "<p class=\"text-center mt-2\">"
											+ "<a href=\"#\" class=\"\">http://youtube.com/wzercsxz1</a>"
										+ "</p>"
									+ "</div>"
								+ "</div>"
								+ "<a target=\"_blank\" href=\""+listData.get(0).getCvlink()+"\" class=\"btn btn-blue\" style=\"margin-top: 10px;\">VIEW CV</a>"
						   + "</div>";
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