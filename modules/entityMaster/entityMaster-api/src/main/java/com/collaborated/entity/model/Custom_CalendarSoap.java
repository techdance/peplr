/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.collaborated.entity.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.Custom_CalendarServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.Custom_CalendarServiceSoap
 * @generated
 */
@ProviderType
public class Custom_CalendarSoap implements Serializable {
	public static Custom_CalendarSoap toSoapModel(Custom_Calendar model) {
		Custom_CalendarSoap soapModel = new Custom_CalendarSoap();

		soapModel.setPK_calendarEventId(model.getPK_calendarEventId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCalendarResourceId(model.getCalendarResourceId());
		soapModel.setTimeZoneId(model.getTimeZoneId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setEventTitle(model.getEventTitle());
		soapModel.setEventLocation(model.getEventLocation());
		soapModel.setAllDay(model.getAllDay());
		soapModel.setRepeat(model.getRepeat());
		soapModel.setEndRepeat(model.getEndRepeat());
		soapModel.setEndRepeatDate(model.getEndRepeatDate());
		soapModel.setAlert(model.getAlert());
		soapModel.setUrl(model.getUrl());
		soapModel.setNotes(model.getNotes());

		return soapModel;
	}

	public static Custom_CalendarSoap[] toSoapModels(Custom_Calendar[] models) {
		Custom_CalendarSoap[] soapModels = new Custom_CalendarSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Custom_CalendarSoap[][] toSoapModels(
		Custom_Calendar[][] models) {
		Custom_CalendarSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Custom_CalendarSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Custom_CalendarSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Custom_CalendarSoap[] toSoapModels(
		List<Custom_Calendar> models) {
		List<Custom_CalendarSoap> soapModels = new ArrayList<Custom_CalendarSoap>(models.size());

		for (Custom_Calendar model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Custom_CalendarSoap[soapModels.size()]);
	}

	public Custom_CalendarSoap() {
	}

	public long getPrimaryKey() {
		return _PK_calendarEventId;
	}

	public void setPrimaryKey(long pk) {
		setPK_calendarEventId(pk);
	}

	public long getPK_calendarEventId() {
		return _PK_calendarEventId;
	}

	public void setPK_calendarEventId(long PK_calendarEventId) {
		_PK_calendarEventId = PK_calendarEventId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCalendarResourceId() {
		return _calendarResourceId;
	}

	public void setCalendarResourceId(long calendarResourceId) {
		_calendarResourceId = calendarResourceId;
	}

	public String getTimeZoneId() {
		return _timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		_timeZoneId = timeZoneId;
	}

	public String getStartDate() {
		return _startDate;
	}

	public void setStartDate(String startDate) {
		_startDate = startDate;
	}

	public String getEndDate() {
		return _endDate;
	}

	public void setEndDate(String endDate) {
		_endDate = endDate;
	}

	public String getStartTime() {
		return _startTime;
	}

	public void setStartTime(String startTime) {
		_startTime = startTime;
	}

	public String getEndTime() {
		return _endTime;
	}

	public void setEndTime(String endTime) {
		_endTime = endTime;
	}

	public String getEventTitle() {
		return _eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		_eventTitle = eventTitle;
	}

	public String getEventLocation() {
		return _eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		_eventLocation = eventLocation;
	}

	public int getAllDay() {
		return _allDay;
	}

	public void setAllDay(int allDay) {
		_allDay = allDay;
	}

	public String getRepeat() {
		return _repeat;
	}

	public void setRepeat(String repeat) {
		_repeat = repeat;
	}

	public String getEndRepeat() {
		return _endRepeat;
	}

	public void setEndRepeat(String endRepeat) {
		_endRepeat = endRepeat;
	}

	public String getEndRepeatDate() {
		return _endRepeatDate;
	}

	public void setEndRepeatDate(String endRepeatDate) {
		_endRepeatDate = endRepeatDate;
	}

	public String getAlert() {
		return _alert;
	}

	public void setAlert(String alert) {
		_alert = alert;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	private long _PK_calendarEventId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _calendarResourceId;
	private String _timeZoneId;
	private String _startDate;
	private String _endDate;
	private String _startTime;
	private String _endTime;
	private String _eventTitle;
	private String _eventLocation;
	private int _allDay;
	private String _repeat;
	private String _endRepeat;
	private String _endRepeatDate;
	private String _alert;
	private String _url;
	private String _notes;
}