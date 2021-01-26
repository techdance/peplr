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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Custom_Calendar}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Calendar
 * @generated
 */
@ProviderType
public class Custom_CalendarWrapper implements Custom_Calendar,
	ModelWrapper<Custom_Calendar> {
	public Custom_CalendarWrapper(Custom_Calendar custom_Calendar) {
		_custom_Calendar = custom_Calendar;
	}

	@Override
	public Class<?> getModelClass() {
		return Custom_Calendar.class;
	}

	@Override
	public String getModelClassName() {
		return Custom_Calendar.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_calendarEventId", getPK_calendarEventId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("calendarResourceId", getCalendarResourceId());
		attributes.put("timeZoneId", getTimeZoneId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("eventTitle", getEventTitle());
		attributes.put("eventLocation", getEventLocation());
		attributes.put("allDay", getAllDay());
		attributes.put("repeat", getRepeat());
		attributes.put("endRepeat", getEndRepeat());
		attributes.put("endRepeatDate", getEndRepeatDate());
		attributes.put("alert", getAlert());
		attributes.put("url", getUrl());
		attributes.put("notes", getNotes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_calendarEventId = (Long)attributes.get("PK_calendarEventId");

		if (PK_calendarEventId != null) {
			setPK_calendarEventId(PK_calendarEventId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long calendarResourceId = (Long)attributes.get("calendarResourceId");

		if (calendarResourceId != null) {
			setCalendarResourceId(calendarResourceId);
		}

		String timeZoneId = (String)attributes.get("timeZoneId");

		if (timeZoneId != null) {
			setTimeZoneId(timeZoneId);
		}

		String startDate = (String)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String endDate = (String)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String startTime = (String)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		String endTime = (String)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		String eventTitle = (String)attributes.get("eventTitle");

		if (eventTitle != null) {
			setEventTitle(eventTitle);
		}

		String eventLocation = (String)attributes.get("eventLocation");

		if (eventLocation != null) {
			setEventLocation(eventLocation);
		}

		Integer allDay = (Integer)attributes.get("allDay");

		if (allDay != null) {
			setAllDay(allDay);
		}

		String repeat = (String)attributes.get("repeat");

		if (repeat != null) {
			setRepeat(repeat);
		}

		String endRepeat = (String)attributes.get("endRepeat");

		if (endRepeat != null) {
			setEndRepeat(endRepeat);
		}

		String endRepeatDate = (String)attributes.get("endRepeatDate");

		if (endRepeatDate != null) {
			setEndRepeatDate(endRepeatDate);
		}

		String alert = (String)attributes.get("alert");

		if (alert != null) {
			setAlert(alert);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}
	}

	@Override
	public Custom_Calendar toEscapedModel() {
		return new Custom_CalendarWrapper(_custom_Calendar.toEscapedModel());
	}

	@Override
	public Custom_Calendar toUnescapedModel() {
		return new Custom_CalendarWrapper(_custom_Calendar.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _custom_Calendar.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _custom_Calendar.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _custom_Calendar.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _custom_Calendar.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Custom_Calendar> toCacheModel() {
		return _custom_Calendar.toCacheModel();
	}

	@Override
	public int compareTo(Custom_Calendar custom_Calendar) {
		return _custom_Calendar.compareTo(custom_Calendar);
	}

	/**
	* Returns the all day of this custom_ calendar.
	*
	* @return the all day of this custom_ calendar
	*/
	@Override
	public int getAllDay() {
		return _custom_Calendar.getAllDay();
	}

	@Override
	public int hashCode() {
		return _custom_Calendar.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _custom_Calendar.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Custom_CalendarWrapper((Custom_Calendar)_custom_Calendar.clone());
	}

	/**
	* Returns the alert of this custom_ calendar.
	*
	* @return the alert of this custom_ calendar
	*/
	@Override
	public java.lang.String getAlert() {
		return _custom_Calendar.getAlert();
	}

	/**
	* Returns the end date of this custom_ calendar.
	*
	* @return the end date of this custom_ calendar
	*/
	@Override
	public java.lang.String getEndDate() {
		return _custom_Calendar.getEndDate();
	}

	/**
	* Returns the end repeat of this custom_ calendar.
	*
	* @return the end repeat of this custom_ calendar
	*/
	@Override
	public java.lang.String getEndRepeat() {
		return _custom_Calendar.getEndRepeat();
	}

	/**
	* Returns the end repeat date of this custom_ calendar.
	*
	* @return the end repeat date of this custom_ calendar
	*/
	@Override
	public java.lang.String getEndRepeatDate() {
		return _custom_Calendar.getEndRepeatDate();
	}

	/**
	* Returns the end time of this custom_ calendar.
	*
	* @return the end time of this custom_ calendar
	*/
	@Override
	public java.lang.String getEndTime() {
		return _custom_Calendar.getEndTime();
	}

	/**
	* Returns the event location of this custom_ calendar.
	*
	* @return the event location of this custom_ calendar
	*/
	@Override
	public java.lang.String getEventLocation() {
		return _custom_Calendar.getEventLocation();
	}

	/**
	* Returns the event title of this custom_ calendar.
	*
	* @return the event title of this custom_ calendar
	*/
	@Override
	public java.lang.String getEventTitle() {
		return _custom_Calendar.getEventTitle();
	}

	/**
	* Returns the notes of this custom_ calendar.
	*
	* @return the notes of this custom_ calendar
	*/
	@Override
	public java.lang.String getNotes() {
		return _custom_Calendar.getNotes();
	}

	/**
	* Returns the repeat of this custom_ calendar.
	*
	* @return the repeat of this custom_ calendar
	*/
	@Override
	public java.lang.String getRepeat() {
		return _custom_Calendar.getRepeat();
	}

	/**
	* Returns the start date of this custom_ calendar.
	*
	* @return the start date of this custom_ calendar
	*/
	@Override
	public java.lang.String getStartDate() {
		return _custom_Calendar.getStartDate();
	}

	/**
	* Returns the start time of this custom_ calendar.
	*
	* @return the start time of this custom_ calendar
	*/
	@Override
	public java.lang.String getStartTime() {
		return _custom_Calendar.getStartTime();
	}

	/**
	* Returns the time zone ID of this custom_ calendar.
	*
	* @return the time zone ID of this custom_ calendar
	*/
	@Override
	public java.lang.String getTimeZoneId() {
		return _custom_Calendar.getTimeZoneId();
	}

	/**
	* Returns the url of this custom_ calendar.
	*
	* @return the url of this custom_ calendar
	*/
	@Override
	public java.lang.String getUrl() {
		return _custom_Calendar.getUrl();
	}

	/**
	* Returns the user uuid of this custom_ calendar.
	*
	* @return the user uuid of this custom_ calendar
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _custom_Calendar.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _custom_Calendar.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _custom_Calendar.toXmlString();
	}

	/**
	* Returns the create date of this custom_ calendar.
	*
	* @return the create date of this custom_ calendar
	*/
	@Override
	public Date getCreateDate() {
		return _custom_Calendar.getCreateDate();
	}

	/**
	* Returns the modified date of this custom_ calendar.
	*
	* @return the modified date of this custom_ calendar
	*/
	@Override
	public Date getModifiedDate() {
		return _custom_Calendar.getModifiedDate();
	}

	/**
	* Returns the calendar resource ID of this custom_ calendar.
	*
	* @return the calendar resource ID of this custom_ calendar
	*/
	@Override
	public long getCalendarResourceId() {
		return _custom_Calendar.getCalendarResourceId();
	}

	/**
	* Returns the group ID of this custom_ calendar.
	*
	* @return the group ID of this custom_ calendar
	*/
	@Override
	public long getGroupId() {
		return _custom_Calendar.getGroupId();
	}

	/**
	* Returns the p k_calendar event ID of this custom_ calendar.
	*
	* @return the p k_calendar event ID of this custom_ calendar
	*/
	@Override
	public long getPK_calendarEventId() {
		return _custom_Calendar.getPK_calendarEventId();
	}

	/**
	* Returns the primary key of this custom_ calendar.
	*
	* @return the primary key of this custom_ calendar
	*/
	@Override
	public long getPrimaryKey() {
		return _custom_Calendar.getPrimaryKey();
	}

	/**
	* Returns the user ID of this custom_ calendar.
	*
	* @return the user ID of this custom_ calendar
	*/
	@Override
	public long getUserId() {
		return _custom_Calendar.getUserId();
	}

	@Override
	public void persist() {
		_custom_Calendar.persist();
	}

	/**
	* Sets the alert of this custom_ calendar.
	*
	* @param alert the alert of this custom_ calendar
	*/
	@Override
	public void setAlert(java.lang.String alert) {
		_custom_Calendar.setAlert(alert);
	}

	/**
	* Sets the all day of this custom_ calendar.
	*
	* @param allDay the all day of this custom_ calendar
	*/
	@Override
	public void setAllDay(int allDay) {
		_custom_Calendar.setAllDay(allDay);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_custom_Calendar.setCachedModel(cachedModel);
	}

	/**
	* Sets the calendar resource ID of this custom_ calendar.
	*
	* @param calendarResourceId the calendar resource ID of this custom_ calendar
	*/
	@Override
	public void setCalendarResourceId(long calendarResourceId) {
		_custom_Calendar.setCalendarResourceId(calendarResourceId);
	}

	/**
	* Sets the create date of this custom_ calendar.
	*
	* @param createDate the create date of this custom_ calendar
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_custom_Calendar.setCreateDate(createDate);
	}

	/**
	* Sets the end date of this custom_ calendar.
	*
	* @param endDate the end date of this custom_ calendar
	*/
	@Override
	public void setEndDate(java.lang.String endDate) {
		_custom_Calendar.setEndDate(endDate);
	}

	/**
	* Sets the end repeat of this custom_ calendar.
	*
	* @param endRepeat the end repeat of this custom_ calendar
	*/
	@Override
	public void setEndRepeat(java.lang.String endRepeat) {
		_custom_Calendar.setEndRepeat(endRepeat);
	}

	/**
	* Sets the end repeat date of this custom_ calendar.
	*
	* @param endRepeatDate the end repeat date of this custom_ calendar
	*/
	@Override
	public void setEndRepeatDate(java.lang.String endRepeatDate) {
		_custom_Calendar.setEndRepeatDate(endRepeatDate);
	}

	/**
	* Sets the end time of this custom_ calendar.
	*
	* @param endTime the end time of this custom_ calendar
	*/
	@Override
	public void setEndTime(java.lang.String endTime) {
		_custom_Calendar.setEndTime(endTime);
	}

	/**
	* Sets the event location of this custom_ calendar.
	*
	* @param eventLocation the event location of this custom_ calendar
	*/
	@Override
	public void setEventLocation(java.lang.String eventLocation) {
		_custom_Calendar.setEventLocation(eventLocation);
	}

	/**
	* Sets the event title of this custom_ calendar.
	*
	* @param eventTitle the event title of this custom_ calendar
	*/
	@Override
	public void setEventTitle(java.lang.String eventTitle) {
		_custom_Calendar.setEventTitle(eventTitle);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_custom_Calendar.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_custom_Calendar.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_custom_Calendar.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this custom_ calendar.
	*
	* @param groupId the group ID of this custom_ calendar
	*/
	@Override
	public void setGroupId(long groupId) {
		_custom_Calendar.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this custom_ calendar.
	*
	* @param modifiedDate the modified date of this custom_ calendar
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_custom_Calendar.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_custom_Calendar.setNew(n);
	}

	/**
	* Sets the notes of this custom_ calendar.
	*
	* @param notes the notes of this custom_ calendar
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_custom_Calendar.setNotes(notes);
	}

	/**
	* Sets the p k_calendar event ID of this custom_ calendar.
	*
	* @param PK_calendarEventId the p k_calendar event ID of this custom_ calendar
	*/
	@Override
	public void setPK_calendarEventId(long PK_calendarEventId) {
		_custom_Calendar.setPK_calendarEventId(PK_calendarEventId);
	}

	/**
	* Sets the primary key of this custom_ calendar.
	*
	* @param primaryKey the primary key of this custom_ calendar
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_custom_Calendar.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_custom_Calendar.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the repeat of this custom_ calendar.
	*
	* @param repeat the repeat of this custom_ calendar
	*/
	@Override
	public void setRepeat(java.lang.String repeat) {
		_custom_Calendar.setRepeat(repeat);
	}

	/**
	* Sets the start date of this custom_ calendar.
	*
	* @param startDate the start date of this custom_ calendar
	*/
	@Override
	public void setStartDate(java.lang.String startDate) {
		_custom_Calendar.setStartDate(startDate);
	}

	/**
	* Sets the start time of this custom_ calendar.
	*
	* @param startTime the start time of this custom_ calendar
	*/
	@Override
	public void setStartTime(java.lang.String startTime) {
		_custom_Calendar.setStartTime(startTime);
	}

	/**
	* Sets the time zone ID of this custom_ calendar.
	*
	* @param timeZoneId the time zone ID of this custom_ calendar
	*/
	@Override
	public void setTimeZoneId(java.lang.String timeZoneId) {
		_custom_Calendar.setTimeZoneId(timeZoneId);
	}

	/**
	* Sets the url of this custom_ calendar.
	*
	* @param url the url of this custom_ calendar
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_custom_Calendar.setUrl(url);
	}

	/**
	* Sets the user ID of this custom_ calendar.
	*
	* @param userId the user ID of this custom_ calendar
	*/
	@Override
	public void setUserId(long userId) {
		_custom_Calendar.setUserId(userId);
	}

	/**
	* Sets the user uuid of this custom_ calendar.
	*
	* @param userUuid the user uuid of this custom_ calendar
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_custom_Calendar.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_CalendarWrapper)) {
			return false;
		}

		Custom_CalendarWrapper custom_CalendarWrapper = (Custom_CalendarWrapper)obj;

		if (Objects.equals(_custom_Calendar,
					custom_CalendarWrapper._custom_Calendar)) {
			return true;
		}

		return false;
	}

	@Override
	public Custom_Calendar getWrappedModel() {
		return _custom_Calendar;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _custom_Calendar.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _custom_Calendar.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_custom_Calendar.resetOriginalValues();
	}

	private final Custom_Calendar _custom_Calendar;
}