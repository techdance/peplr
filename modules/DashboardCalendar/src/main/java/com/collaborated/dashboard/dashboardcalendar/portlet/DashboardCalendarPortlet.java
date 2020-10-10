package com.collaborated.dashboard.dashboardcalendar.portlet;

import com.collaborated.entity.model.Custom_Calendar;
import com.collaborated.entity.service.Custom_CalendarLocalServiceUtil;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DashboardCalendar Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DashboardCalendarPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if(resourceID != null && resourceID.equals("getEventData")){
			getEventData(resourceRequest,resourceResponse);
		}
	}
	
	public void getEventData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException{
		JSONArray jsonArray = null;
		JSONObject jsonObject = null;
		PrintWriter out = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQueryCustom_Calendar = DynamicQueryFactoryUtil.forClass(Custom_Calendar.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryCustom_Calendar.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			List<Custom_Calendar> Custom_Calendar = Custom_CalendarLocalServiceUtil.dynamicQuery(dynamicQueryCustom_Calendar);
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			if(Custom_Calendar.size()>0){
				jsonArray = JSONFactoryUtil.createJSONArray();
				for(Custom_Calendar c:Custom_Calendar){
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("start", c.getStartDate()+ " 00:00:00");
					jsonArray.put(jsonObject);
				}
			}
			out.print(jsonArray);
		}catch(Exception e){
			//LOG.info(e.getMessage());
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
}