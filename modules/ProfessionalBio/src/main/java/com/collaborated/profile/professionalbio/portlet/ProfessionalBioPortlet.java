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
import com.liferay.portal.kernel.util.PortalUtil;
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
			
			long userId = 0;
			long selectedProfileMatching = 0;
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			long currentUser = 0;
			System.out.println(httpsession.getAttribute("currentUser"));
			if(httpsession.getAttribute("currentUser")!=null){
				currentUser = (Long)httpsession.getAttribute("currentUser");
				if(currentUser>0 && currentUser==themeDisplay.getUserId()){
					String sessionuserID = (String)httpsession.getAttribute("MATCHING_KEY");
					selectedProfileMatching = new Long(sessionuserID);	
				}
			}
			if(selectedProfileMatching>0){
				userId = selectedProfileMatching;
			}else{
				userId = themeDisplay.getUserId();
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
				jsonObject.put("bioDiscipline",listData.get(0).getBioDiscipline());
				jsonArray.put(jsonObject);
				
				String expYears = "";
				if(listData.get(0).getExperienceyears().equalsIgnoreCase("1")){
					expYears = "1 – 2";
				}else if(listData.get(0).getExperienceyears().equalsIgnoreCase("2")){
					expYears = "3 – 7";
				}else if(listData.get(0).getExperienceyears().equalsIgnoreCase("3")){
					expYears = "7+";
				}
				
				template = " <div class='box-middle'> "+
						" <div class='row row-custom mb-4'> "+
						" <div class='col-md-12'> "+
						" <div class='mb-3'><span class='icon-regular icon-camcorder'></span> <strong>Introduction Video</strong></div> "+
						" </div> "+
						" <div class='col-md-6'> "+
						" <div class='wrap-video img-resp mb-2'> "+
						" <img src='/o/ahea-theme/images/video-bradley.png'> "+
//						" <a href='http://youtube.com/jkfvljfg786' target='_blank'>http://youtube.com/jkfvljfg786</a> "+
						" </div> "+
						" </div> "+
						" </div> "+
						" <div class='content-icon position-relative'> "+
						" <div><span class='icon-regular icon-shield-check'></span><strong>Discipline</strong></div> "+
						" <p class='blue-color ml20'> "+
						" <a href='#'>"+listData.get(0).getBioDiscipline()+"</a> "+
						" </p> "+
						" </div> "+
						" <div class='content-icon position-relative'> "+
						" <div><span class='icon-regular icon-user-ninja'></span><strong>Areas of Expertise</strong></div> "+
						" <p class='blue-color ml20'> "+
						" <a href='#'>"+ listData.get(0).getAreaofexpertise1() +"</a><br> "+
						" <a href='#'>"+ listData.get(0).getAreaofexpertise2() +"</a><br> "+
						" <a href='#'>"+ listData.get(0).getAreaofexpertise3() +"</a> "+
						" </p> "+
						" </div> "+
						" <div class='content-icon plane'> "+
						" <p><span class='icon-regular icon-globe-stand'></span> "+expYears+" Years of International Experience</p> "+
						" </div> "+
						" <div class='content-icon'> "+
						" <div><span class='icon-regular icon-book-user'></span><strong>Bio</strong></div> "+
						" <div class='text'> "+
						" <p>"+listData.get(0).getBiodescription()+"</p> "+
						" </div> "+
						" </div> "+
						" <div class='ac mt-4 pt-2'> "+
						" <a href='"+listData.get(0).getCvlink()+"' class='btn btn-blue view-cv disabled'>View CV</a> "+
						" </div> "+
						" </div> ";
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