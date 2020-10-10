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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.projectInviteTrackingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.projectInviteTrackingServiceSoap
 * @generated
 */
@ProviderType
public class projectInviteTrackingSoap implements Serializable {
	public static projectInviteTrackingSoap toSoapModel(
		projectInviteTracking model) {
		projectInviteTrackingSoap soapModel = new projectInviteTrackingSoap();

		soapModel.setPK_projectInvitationId(model.getPK_projectInvitationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setInviteFrom(model.getInviteFrom());
		soapModel.setInviteTo(model.getInviteTo());
		soapModel.setInvitationStatus(model.getInvitationStatus());
		soapModel.setIsRead(model.getIsRead());
		soapModel.setIsRemoved(model.getIsRemoved());
		soapModel.setMessageTitle(model.getMessageTitle());
		soapModel.setMessageContent(model.getMessageContent());
		soapModel.setEmailContent(model.getEmailContent());

		return soapModel;
	}

	public static projectInviteTrackingSoap[] toSoapModels(
		projectInviteTracking[] models) {
		projectInviteTrackingSoap[] soapModels = new projectInviteTrackingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static projectInviteTrackingSoap[][] toSoapModels(
		projectInviteTracking[][] models) {
		projectInviteTrackingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new projectInviteTrackingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new projectInviteTrackingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static projectInviteTrackingSoap[] toSoapModels(
		List<projectInviteTracking> models) {
		List<projectInviteTrackingSoap> soapModels = new ArrayList<projectInviteTrackingSoap>(models.size());

		for (projectInviteTracking model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new projectInviteTrackingSoap[soapModels.size()]);
	}

	public projectInviteTrackingSoap() {
	}

	public long getPrimaryKey() {
		return _PK_projectInvitationId;
	}

	public void setPrimaryKey(long pk) {
		setPK_projectInvitationId(pk);
	}

	public long getPK_projectInvitationId() {
		return _PK_projectInvitationId;
	}

	public void setPK_projectInvitationId(long PK_projectInvitationId) {
		_PK_projectInvitationId = PK_projectInvitationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getInviteFrom() {
		return _inviteFrom;
	}

	public void setInviteFrom(long inviteFrom) {
		_inviteFrom = inviteFrom;
	}

	public long getInviteTo() {
		return _inviteTo;
	}

	public void setInviteTo(long inviteTo) {
		_inviteTo = inviteTo;
	}

	public String getInvitationStatus() {
		return _invitationStatus;
	}

	public void setInvitationStatus(String invitationStatus) {
		_invitationStatus = invitationStatus;
	}

	public long getIsRead() {
		return _isRead;
	}

	public void setIsRead(long isRead) {
		_isRead = isRead;
	}

	public long getIsRemoved() {
		return _isRemoved;
	}

	public void setIsRemoved(long isRemoved) {
		_isRemoved = isRemoved;
	}

	public String getMessageTitle() {
		return _messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		_messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return _messageContent;
	}

	public void setMessageContent(String messageContent) {
		_messageContent = messageContent;
	}

	public String getEmailContent() {
		return _emailContent;
	}

	public void setEmailContent(String emailContent) {
		_emailContent = emailContent;
	}

	private long _PK_projectInvitationId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _projectId;
	private long _inviteFrom;
	private long _inviteTo;
	private String _invitationStatus;
	private long _isRead;
	private long _isRemoved;
	private String _messageTitle;
	private String _messageContent;
	private String _emailContent;
}