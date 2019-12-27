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
		"javax.portlet.display-name=ProfileCredentials Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProfileCredentialsPortlet extends MVCPortlet {
	
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
			
			long userId = themeDisplay.getUserId();
			if(selectedProfileMatching>0){
				userId = selectedProfileMatching;
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
							+ "<p><i class=\"fas fa-trophy\"></i><strong>Professional Memberships</strong></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getMembership1()+"</a></p>"
						+ "</div>"
						+ "<div class=\"content-icon\">"
							+ "<p><i class=\"fas fa-certificate\" aria-hidden=\"true\"></i><strong>Certificates</strong></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getCertificate1()+"</a></p>"
						+ "</div>"
						+ "<div class=\"content-icon\">"
							+ "<p><i class=\"fas fa-graduation-cap\"></i><strong>Highest Education Level</strong></p>"
							+ "<p class=\"blue-color ml20\"><a href=\"#\">"+creList.get(0).getMembership4()+"</a></p>"
						+ "</div>"
				   + "</div>";
				
				out.print(template);
			}
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