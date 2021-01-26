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
 * This class is a wrapper for {@link Custom_CalendarInvitees}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarInvitees
 * @generated
 */
@ProviderType
public class Custom_CalendarInviteesWrapper implements Custom_CalendarInvitees,
	ModelWrapper<Custom_CalendarInvitees> {
	public Custom_CalendarInviteesWrapper(
		Custom_CalendarInvitees custom_CalendarInvitees) {
		_custom_CalendarInvitees = custom_CalendarInvitees;
	}

	@Override
	public Class<?> getModelClass() {
		return Custom_CalendarInvitees.class;
	}

	@Override
	public String getModelClassName() {
		return Custom_CalendarInvitees.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_calendarEventSubId", getPK_calendarEventSubId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_calendarEventId", getPK_calendarEventId());
		attributes.put("inviteeEmailAddress", getInviteeEmailAddress());
		attributes.put("invitee", getInvitee());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_calendarEventSubId = (Long)attributes.get(
				"PK_calendarEventSubId");

		if (PK_calendarEventSubId != null) {
			setPK_calendarEventSubId(PK_calendarEventSubId);
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

		Long PK_calendarEventId = (Long)attributes.get("PK_calendarEventId");

		if (PK_calendarEventId != null) {
			setPK_calendarEventId(PK_calendarEventId);
		}

		String inviteeEmailAddress = (String)attributes.get(
				"inviteeEmailAddress");

		if (inviteeEmailAddress != null) {
			setInviteeEmailAddress(inviteeEmailAddress);
		}

		Long invitee = (Long)attributes.get("invitee");

		if (invitee != null) {
			setInvitee(invitee);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Custom_CalendarInvitees toEscapedModel() {
		return new Custom_CalendarInviteesWrapper(_custom_CalendarInvitees.toEscapedModel());
	}

	@Override
	public Custom_CalendarInvitees toUnescapedModel() {
		return new Custom_CalendarInviteesWrapper(_custom_CalendarInvitees.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _custom_CalendarInvitees.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _custom_CalendarInvitees.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _custom_CalendarInvitees.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _custom_CalendarInvitees.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Custom_CalendarInvitees> toCacheModel() {
		return _custom_CalendarInvitees.toCacheModel();
	}

	@Override
	public int compareTo(Custom_CalendarInvitees custom_CalendarInvitees) {
		return _custom_CalendarInvitees.compareTo(custom_CalendarInvitees);
	}

	/**
	* Returns the status of this custom_ calendar invitees.
	*
	* @return the status of this custom_ calendar invitees
	*/
	@Override
	public int getStatus() {
		return _custom_CalendarInvitees.getStatus();
	}

	@Override
	public int hashCode() {
		return _custom_CalendarInvitees.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _custom_CalendarInvitees.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Custom_CalendarInviteesWrapper((Custom_CalendarInvitees)_custom_CalendarInvitees.clone());
	}

	/**
	* Returns the invitee email address of this custom_ calendar invitees.
	*
	* @return the invitee email address of this custom_ calendar invitees
	*/
	@Override
	public java.lang.String getInviteeEmailAddress() {
		return _custom_CalendarInvitees.getInviteeEmailAddress();
	}

	/**
	* Returns the user uuid of this custom_ calendar invitees.
	*
	* @return the user uuid of this custom_ calendar invitees
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _custom_CalendarInvitees.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _custom_CalendarInvitees.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _custom_CalendarInvitees.toXmlString();
	}

	/**
	* Returns the create date of this custom_ calendar invitees.
	*
	* @return the create date of this custom_ calendar invitees
	*/
	@Override
	public Date getCreateDate() {
		return _custom_CalendarInvitees.getCreateDate();
	}

	/**
	* Returns the modified date of this custom_ calendar invitees.
	*
	* @return the modified date of this custom_ calendar invitees
	*/
	@Override
	public Date getModifiedDate() {
		return _custom_CalendarInvitees.getModifiedDate();
	}

	/**
	* Returns the group ID of this custom_ calendar invitees.
	*
	* @return the group ID of this custom_ calendar invitees
	*/
	@Override
	public long getGroupId() {
		return _custom_CalendarInvitees.getGroupId();
	}

	/**
	* Returns the invitee of this custom_ calendar invitees.
	*
	* @return the invitee of this custom_ calendar invitees
	*/
	@Override
	public long getInvitee() {
		return _custom_CalendarInvitees.getInvitee();
	}

	/**
	* Returns the p k_calendar event ID of this custom_ calendar invitees.
	*
	* @return the p k_calendar event ID of this custom_ calendar invitees
	*/
	@Override
	public long getPK_calendarEventId() {
		return _custom_CalendarInvitees.getPK_calendarEventId();
	}

	/**
	* Returns the p k_calendar event sub ID of this custom_ calendar invitees.
	*
	* @return the p k_calendar event sub ID of this custom_ calendar invitees
	*/
	@Override
	public long getPK_calendarEventSubId() {
		return _custom_CalendarInvitees.getPK_calendarEventSubId();
	}

	/**
	* Returns the primary key of this custom_ calendar invitees.
	*
	* @return the primary key of this custom_ calendar invitees
	*/
	@Override
	public long getPrimaryKey() {
		return _custom_CalendarInvitees.getPrimaryKey();
	}

	/**
	* Returns the user ID of this custom_ calendar invitees.
	*
	* @return the user ID of this custom_ calendar invitees
	*/
	@Override
	public long getUserId() {
		return _custom_CalendarInvitees.getUserId();
	}

	@Override
	public void persist() {
		_custom_CalendarInvitees.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_custom_CalendarInvitees.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this custom_ calendar invitees.
	*
	* @param createDate the create date of this custom_ calendar invitees
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_custom_CalendarInvitees.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_custom_CalendarInvitees.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_custom_CalendarInvitees.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_custom_CalendarInvitees.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this custom_ calendar invitees.
	*
	* @param groupId the group ID of this custom_ calendar invitees
	*/
	@Override
	public void setGroupId(long groupId) {
		_custom_CalendarInvitees.setGroupId(groupId);
	}

	/**
	* Sets the invitee of this custom_ calendar invitees.
	*
	* @param invitee the invitee of this custom_ calendar invitees
	*/
	@Override
	public void setInvitee(long invitee) {
		_custom_CalendarInvitees.setInvitee(invitee);
	}

	/**
	* Sets the invitee email address of this custom_ calendar invitees.
	*
	* @param inviteeEmailAddress the invitee email address of this custom_ calendar invitees
	*/
	@Override
	public void setInviteeEmailAddress(java.lang.String inviteeEmailAddress) {
		_custom_CalendarInvitees.setInviteeEmailAddress(inviteeEmailAddress);
	}

	/**
	* Sets the modified date of this custom_ calendar invitees.
	*
	* @param modifiedDate the modified date of this custom_ calendar invitees
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_custom_CalendarInvitees.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_custom_CalendarInvitees.setNew(n);
	}

	/**
	* Sets the p k_calendar event ID of this custom_ calendar invitees.
	*
	* @param PK_calendarEventId the p k_calendar event ID of this custom_ calendar invitees
	*/
	@Override
	public void setPK_calendarEventId(long PK_calendarEventId) {
		_custom_CalendarInvitees.setPK_calendarEventId(PK_calendarEventId);
	}

	/**
	* Sets the p k_calendar event sub ID of this custom_ calendar invitees.
	*
	* @param PK_calendarEventSubId the p k_calendar event sub ID of this custom_ calendar invitees
	*/
	@Override
	public void setPK_calendarEventSubId(long PK_calendarEventSubId) {
		_custom_CalendarInvitees.setPK_calendarEventSubId(PK_calendarEventSubId);
	}

	/**
	* Sets the primary key of this custom_ calendar invitees.
	*
	* @param primaryKey the primary key of this custom_ calendar invitees
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_custom_CalendarInvitees.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_custom_CalendarInvitees.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this custom_ calendar invitees.
	*
	* @param status the status of this custom_ calendar invitees
	*/
	@Override
	public void setStatus(int status) {
		_custom_CalendarInvitees.setStatus(status);
	}

	/**
	* Sets the user ID of this custom_ calendar invitees.
	*
	* @param userId the user ID of this custom_ calendar invitees
	*/
	@Override
	public void setUserId(long userId) {
		_custom_CalendarInvitees.setUserId(userId);
	}

	/**
	* Sets the user uuid of this custom_ calendar invitees.
	*
	* @param userUuid the user uuid of this custom_ calendar invitees
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_custom_CalendarInvitees.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_CalendarInviteesWrapper)) {
			return false;
		}

		Custom_CalendarInviteesWrapper custom_CalendarInviteesWrapper = (Custom_CalendarInviteesWrapper)obj;

		if (Objects.equals(_custom_CalendarInvitees,
					custom_CalendarInviteesWrapper._custom_CalendarInvitees)) {
			return true;
		}

		return false;
	}

	@Override
	public Custom_CalendarInvitees getWrappedModel() {
		return _custom_CalendarInvitees;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _custom_CalendarInvitees.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _custom_CalendarInvitees.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_custom_CalendarInvitees.resetOriginalValues();
	}

	private final Custom_CalendarInvitees _custom_CalendarInvitees;
}