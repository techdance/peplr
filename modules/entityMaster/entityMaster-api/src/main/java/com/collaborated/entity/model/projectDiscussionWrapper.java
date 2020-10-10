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
 * This class is a wrapper for {@link projectDiscussion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectDiscussion
 * @generated
 */
@ProviderType
public class projectDiscussionWrapper implements projectDiscussion,
	ModelWrapper<projectDiscussion> {
	public projectDiscussionWrapper(projectDiscussion projectDiscussion) {
		_projectDiscussion = projectDiscussion;
	}

	@Override
	public Class<?> getModelClass() {
		return projectDiscussion.class;
	}

	@Override
	public String getModelClassName() {
		return projectDiscussion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_projectDiscussionId", getPK_projectDiscussionId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("interestId", getInterestId());
		attributes.put("projectId", getProjectId());
		attributes.put("senderId", getSenderId());
		attributes.put("description", getDescription());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("imageUrl", getImageUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_projectDiscussionId = (Long)attributes.get(
				"PK_projectDiscussionId");

		if (PK_projectDiscussionId != null) {
			setPK_projectDiscussionId(PK_projectDiscussionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createdOn = (Date)attributes.get("createdOn");

		if (createdOn != null) {
			setCreatedOn(createdOn);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long interestId = (Long)attributes.get("interestId");

		if (interestId != null) {
			setInterestId(interestId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long senderId = (Long)attributes.get("senderId");

		if (senderId != null) {
			setSenderId(senderId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _projectDiscussion.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectDiscussion.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectDiscussion.isNew();
	}

	@Override
	public com.collaborated.entity.model.projectDiscussion toEscapedModel() {
		return new projectDiscussionWrapper(_projectDiscussion.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.projectDiscussion toUnescapedModel() {
		return new projectDiscussionWrapper(_projectDiscussion.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectDiscussion.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.projectDiscussion> toCacheModel() {
		return _projectDiscussion.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.projectDiscussion projectDiscussion) {
		return _projectDiscussion.compareTo(projectDiscussion);
	}

	@Override
	public int hashCode() {
		return _projectDiscussion.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectDiscussion.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new projectDiscussionWrapper((projectDiscussion)_projectDiscussion.clone());
	}

	/**
	* Returns the description of this project discussion.
	*
	* @return the description of this project discussion
	*/
	@Override
	public java.lang.String getDescription() {
		return _projectDiscussion.getDescription();
	}

	/**
	* Returns the image url of this project discussion.
	*
	* @return the image url of this project discussion
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _projectDiscussion.getImageUrl();
	}

	@Override
	public java.lang.String toString() {
		return _projectDiscussion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectDiscussion.toXmlString();
	}

	/**
	* Returns the created on of this project discussion.
	*
	* @return the created on of this project discussion
	*/
	@Override
	public Date getCreatedOn() {
		return _projectDiscussion.getCreatedOn();
	}

	/**
	* Returns the modified date of this project discussion.
	*
	* @return the modified date of this project discussion
	*/
	@Override
	public Date getModifiedDate() {
		return _projectDiscussion.getModifiedDate();
	}

	/**
	* Returns the file entry ID of this project discussion.
	*
	* @return the file entry ID of this project discussion
	*/
	@Override
	public long getFileEntryId() {
		return _projectDiscussion.getFileEntryId();
	}

	/**
	* Returns the group ID of this project discussion.
	*
	* @return the group ID of this project discussion
	*/
	@Override
	public long getGroupId() {
		return _projectDiscussion.getGroupId();
	}

	/**
	* Returns the interest ID of this project discussion.
	*
	* @return the interest ID of this project discussion
	*/
	@Override
	public long getInterestId() {
		return _projectDiscussion.getInterestId();
	}

	/**
	* Returns the p k_project discussion ID of this project discussion.
	*
	* @return the p k_project discussion ID of this project discussion
	*/
	@Override
	public long getPK_projectDiscussionId() {
		return _projectDiscussion.getPK_projectDiscussionId();
	}

	/**
	* Returns the primary key of this project discussion.
	*
	* @return the primary key of this project discussion
	*/
	@Override
	public long getPrimaryKey() {
		return _projectDiscussion.getPrimaryKey();
	}

	/**
	* Returns the project ID of this project discussion.
	*
	* @return the project ID of this project discussion
	*/
	@Override
	public long getProjectId() {
		return _projectDiscussion.getProjectId();
	}

	/**
	* Returns the sender ID of this project discussion.
	*
	* @return the sender ID of this project discussion
	*/
	@Override
	public long getSenderId() {
		return _projectDiscussion.getSenderId();
	}

	@Override
	public void persist() {
		_projectDiscussion.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectDiscussion.setCachedModel(cachedModel);
	}

	/**
	* Sets the created on of this project discussion.
	*
	* @param createdOn the created on of this project discussion
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_projectDiscussion.setCreatedOn(createdOn);
	}

	/**
	* Sets the description of this project discussion.
	*
	* @param description the description of this project discussion
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_projectDiscussion.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectDiscussion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectDiscussion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectDiscussion.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this project discussion.
	*
	* @param fileEntryId the file entry ID of this project discussion
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_projectDiscussion.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the group ID of this project discussion.
	*
	* @param groupId the group ID of this project discussion
	*/
	@Override
	public void setGroupId(long groupId) {
		_projectDiscussion.setGroupId(groupId);
	}

	/**
	* Sets the image url of this project discussion.
	*
	* @param imageUrl the image url of this project discussion
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_projectDiscussion.setImageUrl(imageUrl);
	}

	/**
	* Sets the interest ID of this project discussion.
	*
	* @param interestId the interest ID of this project discussion
	*/
	@Override
	public void setInterestId(long interestId) {
		_projectDiscussion.setInterestId(interestId);
	}

	/**
	* Sets the modified date of this project discussion.
	*
	* @param modifiedDate the modified date of this project discussion
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_projectDiscussion.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_projectDiscussion.setNew(n);
	}

	/**
	* Sets the p k_project discussion ID of this project discussion.
	*
	* @param PK_projectDiscussionId the p k_project discussion ID of this project discussion
	*/
	@Override
	public void setPK_projectDiscussionId(long PK_projectDiscussionId) {
		_projectDiscussion.setPK_projectDiscussionId(PK_projectDiscussionId);
	}

	/**
	* Sets the primary key of this project discussion.
	*
	* @param primaryKey the primary key of this project discussion
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectDiscussion.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectDiscussion.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this project discussion.
	*
	* @param projectId the project ID of this project discussion
	*/
	@Override
	public void setProjectId(long projectId) {
		_projectDiscussion.setProjectId(projectId);
	}

	/**
	* Sets the sender ID of this project discussion.
	*
	* @param senderId the sender ID of this project discussion
	*/
	@Override
	public void setSenderId(long senderId) {
		_projectDiscussion.setSenderId(senderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof projectDiscussionWrapper)) {
			return false;
		}

		projectDiscussionWrapper projectDiscussionWrapper = (projectDiscussionWrapper)obj;

		if (Objects.equals(_projectDiscussion,
					projectDiscussionWrapper._projectDiscussion)) {
			return true;
		}

		return false;
	}

	@Override
	public projectDiscussion getWrappedModel() {
		return _projectDiscussion;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectDiscussion.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectDiscussion.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectDiscussion.resetOriginalValues();
	}

	private final projectDiscussion _projectDiscussion;
}