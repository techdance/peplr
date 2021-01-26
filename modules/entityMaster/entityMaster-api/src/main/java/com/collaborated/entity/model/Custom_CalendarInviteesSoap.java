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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.Custom_CalendarInviteesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.Custom_CalendarInviteesServiceSoap
 * @generated
 */
@ProviderType
public class Custom_CalendarInviteesSoap implements Serializable {
	public static Custom_CalendarInviteesSoap toSoapModel(
		Custom_CalendarInvitees model) {
		Custom_CalendarInviteesSoap soapModel = new Custom_CalendarInviteesSoap();

		soapModel.setPK_calendarEventSubId(model.getPK_calendarEventSubId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_calendarEventId(model.getPK_calendarEventId());
		soapModel.setInviteeEmailAddress(model.getInviteeEmailAddress());
		soapModel.setInvitee(model.getInvitee());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static Custom_CalendarInviteesSoap[] toSoapModels(
		Custom_CalendarInvitees[] models) {
		Custom_CalendarInviteesSoap[] soapModels = new Custom_CalendarInviteesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Custom_CalendarInviteesSoap[][] toSoapModels(
		Custom_CalendarInvitees[][] models) {
		Custom_CalendarInviteesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Custom_CalendarInviteesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Custom_CalendarInviteesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Custom_CalendarInviteesSoap[] toSoapModels(
		List<Custom_CalendarInvitees> models) {
		List<Custom_CalendarInviteesSoap> soapModels = new ArrayList<Custom_CalendarInviteesSoap>(models.size());

		for (Custom_CalendarInvitees model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Custom_CalendarInviteesSoap[soapModels.size()]);
	}

	public Custom_CalendarInviteesSoap() {
	}

	public long getPrimaryKey() {
		return _PK_calendarEventSubId;
	}

	public void setPrimaryKey(long pk) {
		setPK_calendarEventSubId(pk);
	}

	public long getPK_calendarEventSubId() {
		return _PK_calendarEventSubId;
	}

	public void setPK_calendarEventSubId(long PK_calendarEventSubId) {
		_PK_calendarEventSubId = PK_calendarEventSubId;
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

	public long getPK_calendarEventId() {
		return _PK_calendarEventId;
	}

	public void setPK_calendarEventId(long PK_calendarEventId) {
		_PK_calendarEventId = PK_calendarEventId;
	}

	public String getInviteeEmailAddress() {
		return _inviteeEmailAddress;
	}

	public void setInviteeEmailAddress(String inviteeEmailAddress) {
		_inviteeEmailAddress = inviteeEmailAddress;
	}

	public long getInvitee() {
		return _invitee;
	}

	public void setInvitee(long invitee) {
		_invitee = invitee;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _PK_calendarEventSubId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_calendarEventId;
	private String _inviteeEmailAddress;
	private long _invitee;
	private int _status;
}