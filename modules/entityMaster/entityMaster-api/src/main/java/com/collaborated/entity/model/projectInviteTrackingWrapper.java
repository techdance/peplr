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
 * This class is a wrapper for {@link projectInviteTracking}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectInviteTracking
 * @generated
 */
@ProviderType
public class projectInviteTrackingWrapper implements projectInviteTracking,
	ModelWrapper<projectInviteTracking> {
	public projectInviteTrackingWrapper(
		projectInviteTracking projectInviteTracking) {
		_projectInviteTracking = projectInviteTracking;
	}

	@Override
	public Class<?> getModelClass() {
		return projectInviteTracking.class;
	}

	@Override
	public String getModelClassName() {
		return projectInviteTracking.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_projectInvitationId", getPK_projectInvitationId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("projectId", getProjectId());
		attributes.put("inviteFrom", getInviteFrom());
		attributes.put("inviteTo", getInviteTo());
		attributes.put("invitationStatus", getInvitationStatus());
		attributes.put("isRead", getIsRead());
		attributes.put("isRemoved", getIsRemoved());
		attributes.put("messageTitle", getMessageTitle());
		attributes.put("messageContent", getMessageContent());
		attributes.put("emailContent", getEmailContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_projectInvitationId = (Long)attributes.get(
				"PK_projectInvitationId");

		if (PK_projectInvitationId != null) {
			setPK_projectInvitationId(PK_projectInvitationId);
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

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long inviteFrom = (Long)attributes.get("inviteFrom");

		if (inviteFrom != null) {
			setInviteFrom(inviteFrom);
		}

		Long inviteTo = (Long)attributes.get("inviteTo");

		if (inviteTo != null) {
			setInviteTo(inviteTo);
		}

		String invitationStatus = (String)attributes.get("invitationStatus");

		if (invitationStatus != null) {
			setInvitationStatus(invitationStatus);
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
		return _projectInviteTracking.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectInviteTracking.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectInviteTracking.isNew();
	}

	@Override
	public com.collaborated.entity.model.projectInviteTracking toEscapedModel() {
		return new projectInviteTrackingWrapper(_projectInviteTracking.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.projectInviteTracking toUnescapedModel() {
		return new projectInviteTrackingWrapper(_projectInviteTracking.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectInviteTracking.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.projectInviteTracking> toCacheModel() {
		return _projectInviteTracking.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.projectInviteTracking projectInviteTracking) {
		return _projectInviteTracking.compareTo(projectInviteTracking);
	}

	@Override
	public int hashCode() {
		return _projectInviteTracking.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectInviteTracking.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new projectInviteTrackingWrapper((projectInviteTracking)_projectInviteTracking.clone());
	}

	/**
	* Returns the email content of this project invite tracking.
	*
	* @return the email content of this project invite tracking
	*/
	@Override
	public java.lang.String getEmailContent() {
		return _projectInviteTracking.getEmailContent();
	}

	/**
	* Returns the invitation status of this project invite tracking.
	*
	* @return the invitation status of this project invite tracking
	*/
	@Override
	public java.lang.String getInvitationStatus() {
		return _projectInviteTracking.getInvitationStatus();
	}

	/**
	* Returns the message content of this project invite tracking.
	*
	* @return the message content of this project invite tracking
	*/
	@Override
	public java.lang.String getMessageContent() {
		return _projectInviteTracking.getMessageContent();
	}

	/**
	* Returns the message title of this project invite tracking.
	*
	* @return the message title of this project invite tracking
	*/
	@Override
	public java.lang.String getMessageTitle() {
		return _projectInviteTracking.getMessageTitle();
	}

	@Override
	public java.lang.String toString() {
		return _projectInviteTracking.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectInviteTracking.toXmlString();
	}

	/**
	* Returns the create date of this project invite tracking.
	*
	* @return the create date of this project invite tracking
	*/
	@Override
	public Date getCreateDate() {
		return _projectInviteTracking.getCreateDate();
	}

	/**
	* Returns the modified date of this project invite tracking.
	*
	* @return the modified date of this project invite tracking
	*/
	@Override
	public Date getModifiedDate() {
		return _projectInviteTracking.getModifiedDate();
	}

	/**
	* Returns the group ID of this project invite tracking.
	*
	* @return the group ID of this project invite tracking
	*/
	@Override
	public long getGroupId() {
		return _projectInviteTracking.getGroupId();
	}

	/**
	* Returns the invite from of this project invite tracking.
	*
	* @return the invite from of this project invite tracking
	*/
	@Override
	public long getInviteFrom() {
		return _projectInviteTracking.getInviteFrom();
	}

	/**
	* Returns the invite to of this project invite tracking.
	*
	* @return the invite to of this project invite tracking
	*/
	@Override
	public long getInviteTo() {
		return _projectInviteTracking.getInviteTo();
	}

	/**
	* Returns the is read of this project invite tracking.
	*
	* @return the is read of this project invite tracking
	*/
	@Override
	public long getIsRead() {
		return _projectInviteTracking.getIsRead();
	}

	/**
	* Returns the is removed of this project invite tracking.
	*
	* @return the is removed of this project invite tracking
	*/
	@Override
	public long getIsRemoved() {
		return _projectInviteTracking.getIsRemoved();
	}

	/**
	* Returns the p k_project invitation ID of this project invite tracking.
	*
	* @return the p k_project invitation ID of this project invite tracking
	*/
	@Override
	public long getPK_projectInvitationId() {
		return _projectInviteTracking.getPK_projectInvitationId();
	}

	/**
	* Returns the primary key of this project invite tracking.
	*
	* @return the primary key of this project invite tracking
	*/
	@Override
	public long getPrimaryKey() {
		return _projectInviteTracking.getPrimaryKey();
	}

	/**
	* Returns the project ID of this project invite tracking.
	*
	* @return the project ID of this project invite tracking
	*/
	@Override
	public long getProjectId() {
		return _projectInviteTracking.getProjectId();
	}

	@Override
	public void persist() {
		_projectInviteTracking.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectInviteTracking.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this project invite tracking.
	*
	* @param createDate the create date of this project invite tracking
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_projectInviteTracking.setCreateDate(createDate);
	}

	/**
	* Sets the email content of this project invite tracking.
	*
	* @param emailContent the email content of this project invite tracking
	*/
	@Override
	public void setEmailContent(java.lang.String emailContent) {
		_projectInviteTracking.setEmailContent(emailContent);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectInviteTracking.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectInviteTracking.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectInviteTracking.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this project invite tracking.
	*
	* @param groupId the group ID of this project invite tracking
	*/
	@Override
	public void setGroupId(long groupId) {
		_projectInviteTracking.setGroupId(groupId);
	}

	/**
	* Sets the invitation status of this project invite tracking.
	*
	* @param invitationStatus the invitation status of this project invite tracking
	*/
	@Override
	public void setInvitationStatus(java.lang.String invitationStatus) {
		_projectInviteTracking.setInvitationStatus(invitationStatus);
	}

	/**
	* Sets the invite from of this project invite tracking.
	*
	* @param inviteFrom the invite from of this project invite tracking
	*/
	@Override
	public void setInviteFrom(long inviteFrom) {
		_projectInviteTracking.setInviteFrom(inviteFrom);
	}

	/**
	* Sets the invite to of this project invite tracking.
	*
	* @param inviteTo the invite to of this project invite tracking
	*/
	@Override
	public void setInviteTo(long inviteTo) {
		_projectInviteTracking.setInviteTo(inviteTo);
	}

	/**
	* Sets the is read of this project invite tracking.
	*
	* @param isRead the is read of this project invite tracking
	*/
	@Override
	public void setIsRead(long isRead) {
		_projectInviteTracking.setIsRead(isRead);
	}

	/**
	* Sets the is removed of this project invite tracking.
	*
	* @param isRemoved the is removed of this project invite tracking
	*/
	@Override
	public void setIsRemoved(long isRemoved) {
		_projectInviteTracking.setIsRemoved(isRemoved);
	}

	/**
	* Sets the message content of this project invite tracking.
	*
	* @param messageContent the message content of this project invite tracking
	*/
	@Override
	public void setMessageContent(java.lang.String messageContent) {
		_projectInviteTracking.setMessageContent(messageContent);
	}

	/**
	* Sets the message title of this project invite tracking.
	*
	* @param messageTitle the message title of this project invite tracking
	*/
	@Override
	public void setMessageTitle(java.lang.String messageTitle) {
		_projectInviteTracking.setMessageTitle(messageTitle);
	}

	/**
	* Sets the modified date of this project invite tracking.
	*
	* @param modifiedDate the modified date of this project invite tracking
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_projectInviteTracking.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_projectInviteTracking.setNew(n);
	}

	/**
	* Sets the p k_project invitation ID of this project invite tracking.
	*
	* @param PK_projectInvitationId the p k_project invitation ID of this project invite tracking
	*/
	@Override
	public void setPK_projectInvitationId(long PK_projectInvitationId) {
		_projectInviteTracking.setPK_projectInvitationId(PK_projectInvitationId);
	}

	/**
	* Sets the primary key of this project invite tracking.
	*
	* @param primaryKey the primary key of this project invite tracking
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectInviteTracking.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectInviteTracking.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this project invite tracking.
	*
	* @param projectId the project ID of this project invite tracking
	*/
	@Override
	public void setProjectId(long projectId) {
		_projectInviteTracking.setProjectId(projectId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof projectInviteTrackingWrapper)) {
			return false;
		}

		projectInviteTrackingWrapper projectInviteTrackingWrapper = (projectInviteTrackingWrapper)obj;

		if (Objects.equals(_projectInviteTracking,
					projectInviteTrackingWrapper._projectInviteTracking)) {
			return true;
		}

		return false;
	}

	@Override
	public projectInviteTracking getWrappedModel() {
		return _projectInviteTracking;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectInviteTracking.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectInviteTracking.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectInviteTracking.resetOriginalValues();
	}

	private final projectInviteTracking _projectInviteTracking;
}