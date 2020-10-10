package com.collaborated.profile.credentials.portlet;

import com.collaborated.entity.model.userCredential;
import com.collaborated.entity.service.userCredentialLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
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
		"javax.portlet.display-name=ProfileCredentials Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProfileCredentialsPortlet extends MVCPortlet {
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("getCredentialData")){
			getCredentialData(resourceRequest,resourceResponse);
		}
	}
	public void getCredentialData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = null;
		JSONObject jsonObject = null;
		PrintWriter out = null;
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
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
			List<userCredential> creList = userCredentialLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(creList.size()>0){
				jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("membership1", creList.get(0).getMembership1());
				jsonObject.put("membership2", creList.get(0).getMembership2());
				jsonObject.put("membership3", creList.get(0).getMembership3());
				jsonObject.put("membership4", creList.get(0).getMembership4());
				jsonObject.put("certificate1", creList.get(0).getCertificate1());
				jsonObject.put("certificate2", creList.get(0).getCertificate2());
				jsonObject.put("certificate3", creList.get(0).getCertificate3());
				jsonObject.put("credentialId", creList.get(0).getPK_userCredential());
				
				template = "<div class=\"box-middle\"> "
						+ "<div class=\"content-icon\">"
							+ "<p><span class=\"icon-regular icon-user-graduate\"></span><strong>Highest Education Level</strong></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getMembership4()+"</a></p>"
						+ "</div>"
						+ "<div class=\"content-icon\">"
							+ "<p><span class=\"icon-regular icon-trophy-alt\"></span><strong>Professional Memberships</strong></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getMembership1()+"</a></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getMembership2()+"</a></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getMembership3()+"</a></p>"
						+ "</div>"
						+ "<div class=\"content-icon\">"
							+ "<p><span class=\"icon-regular icon-file-certificate\"></span><strong>Certificates</strong></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getCertificate1()+"</a></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getCertificate2()+"</a></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getCertificate3()+"</a></p>"
						+ "</div>"
				   + "</div>";
				
				
			}
			out.print(template);
		}catch(Exception e){
			e.printStackTrace();			
		}finally{
			if(user!=null){
				user=null;
			}
			if (out != null) {
				out.close();
			}
		}
	}
}