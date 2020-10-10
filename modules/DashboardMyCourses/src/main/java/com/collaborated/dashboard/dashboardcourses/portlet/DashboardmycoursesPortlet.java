package com.collaborated.dashboard.dashboardcourses.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DashboardMyCourses Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DashboardmycoursesPortlet extends MVCPortlet {
	
	JSONArray responseJSONInstitute = null;
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = null;
		PortletSession ps = request.getPortletSession();
		try {
			user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			String apiURL = "http://137.117.70.79/local/getcourses/client/client.php?username="+user.getEmailAddress();
	        String institutionProfileResonse = getMethodAPI(apiURL); 
	        System.out.println("responseJSONInstitute==="+institutionProfileResonse);
		    try {
		    	responseJSONInstitute = JSONFactoryUtil.createJSONArray(institutionProfileResonse);
		    	ps.removeAttribute("MY_COURSES", PortletSession.APPLICATION_SCOPE);
		    	ps.setAttribute("MY_COURSES", responseJSONInstitute, PortletSession.APPLICATION_SCOPE);
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
		    }
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
			
		super.render(request, response);
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