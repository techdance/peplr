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
 * This class is a wrapper for {@link discussionMessageNotification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see discussionMessageNotification
 * @generated
 */
@ProviderType
public class discussionMessageNotificationWrapper
	implements discussionMessageNotification,
		ModelWrapper<discussionMessageNotification> {
	public discussionMessageNotificationWrapper(
		discussionMessageNotification discussionMessageNotification) {
		_discussionMessageNotification = discussionMessageNotification;
	}

	@Override
	public Class<?> getModelClass() {
		return discussionMessageNotification.class;
	}

	@Override
	public String getModelClassName() {
		return discussionMessageNotification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_discussionNotificationId",
			getPK_discussionNotificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectDiscussionId", getPK_projectDiscussionId());
		attributes.put("messageFrom", getMessageFrom());
		attributes.put("messageTo", getMessageTo());
		attributes.put("isRead", getIsRead());
		attributes.put("isRemoved", getIsRemoved());
		attributes.put("messageTitle", getMessageTitle());
		attributes.put("messageContent", getMessageContent());
		attributes.put("emailContent", getEmailContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_discussionNotificationId = (Long)attributes.get(
				"PK_discussionNotificationId");

		if (PK_discussionNotificationId != null) {
			setPK_discussionNotificationId(PK_discussionNotificationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long PK_projectDiscussionId = (Long)attributes.get(
				"PK_projectDiscussionId");

		if (PK_projectDiscussionId != null) {
			setPK_projectDiscussionId(PK_projectDiscussionId);
		}

		Long messageFrom = (Long)attributes.get("messageFrom");

		if (messageFrom != null) {
			setMessageFrom(messageFrom);
		}

		Long messageTo = (Long)attributes.get("messageTo");

		if (messageTo != null) {
			setMessageTo(messageTo);
		}

		Long isRead = (Long)attributes.get("isRead");

		if (isRead != null) {
			setIsRead(isRead);
		}

		Long isRemoved = (Long)attributes.get("isRemoved");

		if (isRemoved != null) {
			setIsRemoved(isRemoved);
		}

		String messageTitle = (String)attributes.get("messageTitle");

		if (messageTitle != null) {
			setMessageTitle(messageTitle);
		}

		String messageContent = (String)attributes.get("messageContent");

		if (messageContent != null) {
			setMessageContent(messageContent);
		}

		String emailContent = (String)attributes.get("emailContent");

		if (emailContent != null) {
			setEmailContent(emailContent);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _discussionMessageNotification.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _discussionMessageNotification.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _discussionMessageNotification.isNew();
	}

	@Override
	public com.collaborated.entity.model.discussionMessageNotification toEscapedModel() {
		return new discussionMessageNotificationWrapper(_discussionMessageNotification.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.discussionMessageNotification toUnescapedModel() {
		return new discussionMessageNotificationWrapper(_discussionMessageNotification.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _discussionMessageNotification.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.discussionMessageNotification> toCacheModel() {
		return _discussionMessageNotification.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.discussionMessageNotification discussionMessageNotification) {
		return _discussionMessageNotification.compareTo(discussionMessageNotification);
	}

	@Override
	public int hashCode() {
		return _discussionMessageNotification.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _discussionMessageNotification.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new discussionMessageNotificationWrapper((discussionMessageNotification)_discussionMessageNotification.clone());
	}

	/**
	* Returns the email content of this discussion message notification.
	*
	* @return the email content of this discussion message notification
	*/
	@Override
	public java.lang.String getEmailContent() {
		return _discussionMessageNotification.getEmailContent();
	}

	/**
	* Returns the message content of this discussion message notification.
	*
	* @return the message content of this discussion message notification
	*/
	@Override
	public java.lang.String getMessageContent() {
		return _discussionMessageNotification.getMessageContent();
	}

	/**
	* Returns the message title of this discussion message notification.
	*
	* @return the message title of this discussion message notification
	*/
	@Override
	public java.lang.String getMessageTitle() {
		return _discussionMessageNotification.getMessageTitle();
	}

	@Override
	public java.lang.String toString() {
		return _discussionMessageNotification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _discussionMessageNotification.toXmlString();
	}

	/**
	* Returns the create date of this discussion message notification.
	*
	* @return the create date of this discussion message notification
	*/
	@Override
	public Date getCreateDate() {
		return _discussionMessageNotification.getCreateDate();
	}

	/**
	* Returns the modified date of this discussion message notification.
	*
	* @return the modified date of this discussion message notification
	*/
	@Override
	public Date getModifiedDate() {
		return _discussionMessageNotification.getModifiedDate();
	}

	/**
	* Returns the group ID of this discussion message notification.
	*
	* @return the group ID of this discussion message notification
	*/
	@Override
	public long getGroupId() {
		return _discussionMessageNotification.getGroupId();
	}

	/**
	* Returns the is read of this discussion message notification.
	*
	* @return the is read of this discussion message notification
	*/
	@Override
	public long getIsRead() {
		return _discussionMessageNotification.getIsRead();
	}

	/**
	* Returns the is removed of this discussion message notification.
	*
	* @return the is removed of this discussion message notification
	*/
	@Override
	public long getIsRemoved() {
		return _discussionMessageNotification.getIsRemoved();
	}

	/**
	* Returns the message from of this discussion message notification.
	*
	* @return the message from of this discussion message notification
	*/
	@Override
	public long getMessageFrom() {
		return _discussionMessageNotification.getMessageFrom();
	}

	/**
	* Returns the message to of this discussion message notification.
	*
	* @return the message to of this discussion message notification
	*/
	@Override
	public long getMessageTo() {
		return _discussionMessageNotification.getMessageTo();
	}

	/**
	* Returns the p k_discussion notification ID of this discussion message notification.
	*
	* @return the p k_discussion notification ID of this discussion message notification
	*/
	@Override
	public long getPK_discussionNotificationId() {
		return _discussionMessageNotification.getPK_discussionNotificationId();
	}

	/**
	* Returns the p k_project discussion ID of this discussion message notification.
	*
	* @return the p k_project discussion ID of this discussion message notification
	*/
	@Override
	public long getPK_projectDiscussionId() {
		return _discussionMessageNotification.getPK_projectDiscussionId();
	}

	/**
	* Returns the primary key of this discussion message notification.
	*
	* @return the primary key of this discussion message notification
	*/
	@Override
	public long getPrimaryKey() {
		return _discussionMessageNotification.getPrimaryKey();
	}

	@Override
	public void persist() {
		_discussionMessageNotification.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_discussionMessageNotification.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this discussion message notification.
	*
	* @param createDate the create date of this discussion message notification
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_discussionMessageNotification.setCreateDate(createDate);
	}

	/**
	* Sets the email content of this discussion message notification.
	*
	* @param emailContent the email content of this discussion message notification
	*/
	@Override
	public void setEmailContent(java.lang.String emailContent) {
		_discussionMessageNotification.setEmailContent(emailContent);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_discussionMessageNotification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_discussionMessageNotification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_discussionMessageNotification.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this discussion message notification.
	*
	* @param groupId the group ID of this discussion message notification
	*/
	@Override
	public void setGroupId(long groupId) {
		_discussionMessageNotification.setGroupId(groupId);
	}

	/**
	* Sets the is read of this discussion message notification.
	*
	* @param isRead the is read of this discussion message notification
	*/
	@Override
	public void setIsRead(long isRead) {
		_discussionMessageNotification.setIsRead(isRead);
	}

	/**
	* Sets the is removed of this discussion message notification.
	*
	* @param isRemoved the is removed of this discussion message notification
	*/
	@Override
	public void setIsRemoved(long isRemoved) {
		_discussionMessageNotification.setIsRemoved(isRemoved);
	}

	/**
	* Sets the message content of this discussion message notification.
	*
	* @param messageContent the message content of this discussion message notification
	*/
	@Override
	public void setMessageContent(java.lang.String messageContent) {
		_discussionMessageNotification.setMessageContent(messageContent);
	}

	/**
	* Sets the message from of this discussion message notification.
	*
	* @param messageFrom the message from of this discussion message notification
	*/
	@Override
	public void setMessageFrom(long messageFrom) {
		_discussionMessageNotification.setMessageFrom(messageFrom);
	}

	/**
	* Sets the message title of this discussion message notification.
	*
	* @param messageTitle the message title of this discussion message notification
	*/
	@Override
	public void setMessageTitle(java.lang.String messageTitle) {
		_discussionMessageNotification.setMessageTitle(messageTitle);
	}

	/**
	* Sets the message to of this discussion message notification.
	*
	* @param messageTo the message to of this discussion message notification
	*/
	@Override
	public void setMessageTo(long messageTo) {
		_discussionMessageNotification.setMessageTo(messageTo);
	}

	/**
	* Sets the modified date of this discussion message notification.
	*
	* @param modifiedDate the modified date of this discussion message notification
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_discussionMessageNotification.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_discussionMessageNotification.setNew(n);
	}

	/**
	* Sets the p k_discussion notification ID of this discussion message notification.
	*
	* @param PK_discussionNotificationId the p k_discussion notification ID of this discussion message notification
	*/
	@Override
	public void setPK_discussionNotificationId(long PK_discussionNotificationId) {
		_discussionMessageNotification.setPK_discussionNotificationId(PK_discussionNotificationId);
	}

	/**
	* Sets the p k_project discussion ID of this discussion message notification.
	*
	* @param PK_projectDiscussionId the p k_project discussion ID of this discussion message notification
	*/
	@Override
	public void setPK_projectDiscussionId(long PK_projectDiscussionId) {
		_discussionMessageNotification.setPK_projectDiscussionId(PK_projectDiscussionId);
	}

	/**
	* Sets the primary key of this discussion message notification.
	*
	* @param primaryKey the primary key of this discussion message notification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_discussionMessageNotification.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_discussionMessageNotification.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof discussionMessageNotificationWrapper)) {
			return false;
		}

		discussionMessageNotificationWrapper discussionMessageNotificationWrapper =
			(discussionMessageNotificationWrapper)obj;

		if (Objects.equals(_discussionMessageNotification,
					discussionMessageNotificationWrapper._discussionMessageNotification)) {
			return true;
		}

		return false;
	}

	@Override
	public discussionMessageNotification getWrappedModel() {
		return _discussionMessageNotification;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _discussionMessageNotification.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _discussionMessageNotification.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_discussionMessageNotification.resetOriginalValues();
	}

	private final discussionMessageNotification _discussionMessageNotification;
}