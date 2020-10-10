package com.collaborated.aheacalendar.portlet;

import com.collaborated.entity.model.Custom_Calendar;
import com.collaborated.entity.model.userInstitutionProfileDetails;
import com.collaborated.entity.service.Custom_CalendarLocalServiceUtil;
import com.collaborated.entity.service.userInstitutionProfileDetailsLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		"javax.portlet.display-name=AheaCalendar Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AheaCalendarPortlet extends MVCPortlet {
	final Log LOG = LogFactoryUtil.getLog(AheaCalendarPortlet.class);
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if (resourceID != null && resourceID.equals("saveCalendarEvent")) {
			saveCalendarEvent(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getEventData")){
			getEventData(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("getSingleEventData")){
			getSingleEventData(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("removeCalendarEvent")){
			removeCalendarEvent(resourceRequest,resourceResponse);
		}
	}
	
	public void saveCalendarEvent(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException{
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String eventTitle = ParamUtil.getString(resourceRequest, "eventTitle");
		String startDate = ParamUtil.getString(resourceRequest, "startDate");
		String endDate = ParamUtil.getString(resourceRequest, "endDate");
		String startTime = ParamUtil.getString(resourceRequest, "startTime");
		String endTime = ParamUtil.getString(resourceRequest, "endTime");
		long eventId = ParamUtil.getLong(resourceRequest, "eventId");
		PrintWriter out = null;
		Custom_Calendar custom_Calendar = null;
		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
		
		try{
			out = resourceResponse.getWriter();
			Date startDateTime = parseFormat.parse(startTime);
			Date endDateTime = parseFormat.parse(endTime);
			if(eventId>0){
				custom_Calendar = Custom_CalendarLocalServiceUtil.getCustom_Calendar(eventId);
				custom_Calendar.setEventTitle(eventTitle);
				custom_Calendar.setStartDate(startDate);
				custom_Calendar.setEndDate(endDate);
				custom_Calendar.setStartTime(displayFormat.format(startDateTime));
				custom_Calendar.setEndTime(displayFormat.format(endDateTime));
				custom_Calendar.setUserId(themeDisplay.getUserId());
				custom_Calendar.setModifiedDate(new Date());
				Custom_CalendarLocalServiceUtil.updateCustom_Calendar(custom_Calendar);
				out.print("update");
			}else{
				custom_Calendar = Custom_CalendarLocalServiceUtil.createCustom_Calendar(CounterLocalServiceUtil.increment());
				custom_Calendar.setEventTitle(eventTitle);
				custom_Calendar.setStartDate(startDate);
				custom_Calendar.setEndDate(endDate);
				custom_Calendar.setStartTime(displayFormat.format(startDateTime));
				custom_Calendar.setEndTime(displayFormat.format(endDateTime));
				custom_Calendar.setUserId(themeDisplay.getUserId());
				custom_Calendar.setCreateDate(new Date());
				Custom_CalendarLocalServiceUtil.addCustom_Calendar(custom_Calendar);
				out.print("add");
			}
		}catch(Exception e){
			LOG.info(e.getMessage());
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
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
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			
			if(Custom_Calendar.size()>0){
				jsonArray = JSONFactoryUtil.createJSONArray();
				for(Custom_Calendar c:Custom_Calendar){
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("title", c.getEventTitle());
					jsonObject.put("start", c.getStartDate()+ "T"+ (c.getStartTime()+":00"));
					jsonObject.put("end", c.getEndDate()+ "T"+ (c.getEndTime()+":00"));
					jsonObject.put("allDay", false);
					jsonObject.put("id", c.getPK_calendarEventId());
					jsonArray.put(jsonObject);
				}
			}
			out.print(jsonArray);
		}catch(Exception e){
			LOG.info(e.getMessage());
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void getSingleEventData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException{
		JSONObject jsonObject = null;
		PrintWriter out = null;
		long id = ParamUtil.getLong(resourceRequest, "eventId");
		Custom_Calendar Custom_Calendar = null;
		SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm a");
		SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm");
		try{
			out = resourceResponse.getWriter();
			Custom_Calendar = Custom_CalendarLocalServiceUtil.getCustom_Calendar(id);			
			Date startDateTime = parseFormat.parse(Custom_Calendar.getStartTime());
			Date endDateTime = parseFormat.parse(Custom_Calendar.getEndTime());
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("eventTitle", Custom_Calendar.getEventTitle());
			jsonObject.put("startDate", Custom_Calendar.getStartDate());
			jsonObject.put("endDate", Custom_Calendar.getEndDate());
			jsonObject.put("startTime", displayFormat.format(startDateTime));
			jsonObject.put("endTime", displayFormat.format(endDateTime));
			jsonObject.put("eventId", Custom_Calendar.getPK_calendarEventId());
			out.print(jsonObject);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void removeCalendarEvent(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException{
		PrintWriter out = null;
		long id = ParamUtil.getLong(resourceRequest, "eventId");
		Custom_Calendar Custom_Calendar = null;
		try{
			out = resourceResponse.getWriter();
			if(id>0){
				Custom_Calendar = Custom_CalendarLocalServiceUtil.deleteCustom_Calendar(id);
			}			
			out.print("removed");
		}catch(Exception e){
			
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
}
