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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.discussionMessageNotificationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.discussionMessageNotificationServiceSoap
 * @generated
 */
@ProviderType
public class discussionMessageNotificationSoap implements Serializable {
	public static discussionMessageNotificationSoap toSoapModel(
		discussionMessageNotification model) {
		discussionMessageNotificationSoap soapModel = new discussionMessageNotificationSoap();

		soapModel.setPK_discussionNotificationId(model.getPK_discussionNotificationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectDiscussionId(model.getPK_projectDiscussionId());
		soapModel.setMessageFrom(model.getMessageFrom());
		soapModel.setMessageTo(model.getMessageTo());
		soapModel.setIsRead(model.getIsRead());
		soapModel.setIsRemoved(model.getIsRemoved());
		soapModel.setMessageTitle(model.getMessageTitle());
		soapModel.setMessageContent(model.getMessageContent());
		soapModel.setEmailContent(model.getEmailContent());

		return soapModel;
	}

	public static discussionMessageNotificationSoap[] toSoapModels(
		discussionMessageNotification[] models) {
		discussionMessageNotificationSoap[] soapModels = new discussionMessageNotificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static discussionMessageNotificationSoap[][] toSoapModels(
		discussionMessageNotification[][] models) {
		discussionMessageNotificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new discussionMessageNotificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new discussionMessageNotificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static discussionMessageNotificationSoap[] toSoapModels(
		List<discussionMessageNotification> models) {
		List<discussionMessageNotificationSoap> soapModels = new ArrayList<discussionMessageNotificationSoap>(models.size());

		for (discussionMessageNotification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new discussionMessageNotificationSoap[soapModels.size()]);
	}

	public discussionMessageNotificationSoap() {
	}

	public long getPrimaryKey() {
		return _PK_discussionNotificationId;
	}

	public void setPrimaryKey(long pk) {
		setPK_discussionNotificationId(pk);
	}

	public long getPK_discussionNotificationId() {
		return _PK_discussionNotificationId;
	}

	public void setPK_discussionNotificationId(long PK_discussionNotificationId) {
		_PK_discussionNotificationId = PK_discussionNotificationId;
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

	public long getPK_projectDiscussionId() {
		return _PK_projectDiscussionId;
	}

	public void setPK_projectDiscussionId(long PK_projectDiscussionId) {
		_PK_projectDiscussionId = PK_projectDiscussionId;
	}

	public long getMessageFrom() {
		return _messageFrom;
	}

	public void setMessageFrom(long messageFrom) {
		_messageFrom = messageFrom;
	}

	public long getMessageTo() {
		return _messageTo;
	}

	public void setMessageTo(long messageTo) {
		_messageTo = messageTo;
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

	private long _PK_discussionNotificationId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectDiscussionId;
	private long _messageFrom;
	private long _messageTo;
	private long _isRead;
	private long _isRemoved;
	private String _messageTitle;
	private String _messageContent;
	private String _emailContent;
}