package com.collaborated.profile.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TopMenu Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TopMenuPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		System.out.println("resourceID" + resourceID);
		if(resourceID != null && resourceID.equals("loadMyProfileDetails")) {
			loadMyProfileDetails(resourceRequest,resourceResponse);
		}
	}
	
	public void loadMyProfileDetails(ResourceRequest request, ResourceResponse response){
		try{
			PortletSession ps = request.getPortletSession();
			Object obj = ps.getAttribute("LIFERAY_SHARED_MATCHING_KEY", PortletSession.APPLICATION_SCOPE);
			System.out.println(obj);
			if (obj != null) {
				ps.removeAttribute("LIFERAY_SHARED_MATCHING_KEY",PortletSession.APPLICATION_SCOPE);
			}
			System.out.println(obj);
		}catch(Exception e){}
		finally{
			
		}
	}
}