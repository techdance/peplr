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
 * This class is a wrapper for {@link projectFolderUpload}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectFolderUpload
 * @generated
 */
@ProviderType
public class projectFolderUploadWrapper implements projectFolderUpload,
	ModelWrapper<projectFolderUpload> {
	public projectFolderUploadWrapper(projectFolderUpload projectFolderUpload) {
		_projectFolderUpload = projectFolderUpload;
	}

	@Override
	public Class<?> getModelClass() {
		return projectFolderUpload.class;
	}

	@Override
	public String getModelClassName() {
		return projectFolderUpload.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_projectFolderId", getPK_projectFolderId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("deletedOn", getDeletedOn());
		attributes.put("interestId", getInterestId());
		attributes.put("projectId", getProjectId());
		attributes.put("userId", getUserId());
		attributes.put("deletedBy", getDeletedBy());
		attributes.put("parentFolderId", getParentFolderId());
		attributes.put("folderId", getFolderId());
		attributes.put("folderName", getFolderName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_projectFolderId = (Long)attributes.get("PK_projectFolderId");

		if (PK_projectFolderId != null) {
			setPK_projectFolderId(PK_projectFolderId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createdOn = (Date)attributes.get("createdOn");

		if (createdOn != null) {
			setCreatedOn(createdOn);
		}

		Date deletedOn = (Date)attributes.get("deletedOn");

		if (deletedOn != null) {
			setDeletedOn(deletedOn);
		}

		Long interestId = (Long)attributes.get("interestId");

		if (interestId != null) {
			setInterestId(interestId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long deletedBy = (Long)attributes.get("deletedBy");

		if (deletedBy != null) {
			setDeletedBy(deletedBy);
		}

		Long parentFolderId = (Long)attributes.get("parentFolderId");

		if (parentFolderId != null) {
			setParentFolderId(parentFolderId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		String folderName = (String)attributes.get("folderName");

		if (folderName != null) {
			setFolderName(folderName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _projectFolderUpload.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectFolderUpload.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectFolderUpload.isNew();
	}

	@Override
	public com.collaborated.entity.model.projectFolderUpload toEscapedModel() {
		return new projectFolderUploadWrapper(_projectFolderUpload.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.projectFolderUpload toUnescapedModel() {
		return new projectFolderUploadWrapper(_projectFolderUpload.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectFolderUpload.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.projectFolderUpload> toCacheModel() {
		return _projectFolderUpload.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.projectFolderUpload projectFolderUpload) {
		return _projectFolderUpload.compareTo(projectFolderUpload);
	}

	@Override
	public int hashCode() {
		return _projectFolderUpload.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectFolderUpload.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new projectFolderUploadWrapper((projectFolderUpload)_projectFolderUpload.clone());
	}

	/**
	* Returns the description of this project folder upload.
	*
	* @return the description of this project folder upload
	*/
	@Override
	public java.lang.String getDescription() {
		return _projectFolderUpload.getDescription();
	}

	/**
	* Returns the folder name of this project folder upload.
	*
	* @return the folder name of this project folder upload
	*/
	@Override
	public java.lang.String getFolderName() {
		return _projectFolderUpload.getFolderName();
	}

	/**
	* Returns the user uuid of this project folder upload.
	*
	* @return the user uuid of this project folder upload
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _projectFolderUpload.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _projectFolderUpload.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectFolderUpload.toXmlString();
	}

	/**
	* Returns the created on of this project folder upload.
	*
	* @return the created on of this project folder upload
	*/
	@Override
	public Date getCreatedOn() {
		return _projectFolderUpload.getCreatedOn();
	}

	/**
	* Returns the deleted on of this project folder upload.
	*
	* @return the deleted on of this project folder upload
	*/
	@Override
	public Date getDeletedOn() {
		return _projectFolderUpload.getDeletedOn();
	}

	/**
	* Returns the deleted by of this project folder upload.
	*
	* @return the deleted by of this project folder upload
	*/
	@Override
	public long getDeletedBy() {
		return _projectFolderUpload.getDeletedBy();
	}

	/**
	* Returns the folder ID of this project folder upload.
	*
	* @return the folder ID of this project folder upload
	*/
	@Override
	public long getFolderId() {
		return _projectFolderUpload.getFolderId();
	}

	/**
	* Returns the group ID of this project folder upload.
	*
	* @return the group ID of this project folder upload
	*/
	@Override
	public long getGroupId() {
		return _projectFolderUpload.getGroupId();
	}

	/**
	* Returns the interest ID of this project folder upload.
	*
	* @return the interest ID of this project folder upload
	*/
	@Override
	public long getInterestId() {
		return _projectFolderUpload.getInterestId();
	}

	/**
	* Returns the p k_project folder ID of this project folder upload.
	*
	* @return the p k_project folder ID of this project folder upload
	*/
	@Override
	public long getPK_projectFolderId() {
		return _projectFolderUpload.getPK_projectFolderId();
	}

	/**
	* Returns the parent folder ID of this project folder upload.
	*
	* @return the parent folder ID of this project folder upload
	*/
	@Override
	public long getParentFolderId() {
		return _projectFolderUpload.getParentFolderId();
	}

	/**
	* Returns the primary key of this project folder upload.
	*
	* @return the primary key of this project folder upload
	*/
	@Override
	public long getPrimaryKey() {
		return _projectFolderUpload.getPrimaryKey();
	}

	/**
	* Returns the project ID of this project folder upload.
	*
	* @return the project ID of this project folder upload
	*/
	@Override
	public long getProjectId() {
		return _projectFolderUpload.getProjectId();
	}

	/**
	* Returns the user ID of this project folder upload.
	*
	* @return the user ID of this project folder upload
	*/
	@Override
	public long getUserId() {
		return _projectFolderUpload.getUserId();
	}

	@Override
	public void persist() {
		_projectFolderUpload.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectFolderUpload.setCachedModel(cachedModel);
	}

	/**
	* Sets the created on of this project folder upload.
	*
	* @param createdOn the created on of this project folder upload
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_projectFolderUpload.setCreatedOn(createdOn);
	}

	/**
	* Sets the deleted by of this project folder upload.
	*
	* @param deletedBy the deleted by of this project folder upload
	*/
	@Override
	public void setDeletedBy(long deletedBy) {
		_projectFolderUpload.setDeletedBy(deletedBy);
	}

	/**
	* Sets the deleted on of this project folder upload.
	*
	* @param deletedOn the deleted on of this project folder upload
	*/
	@Override
	public void setDeletedOn(Date deletedOn) {
		_projectFolderUpload.setDeletedOn(deletedOn);
	}

	/**
	* Sets the description of this project folder upload.
	*
	* @param description the description of this project folder upload
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_projectFolderUpload.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectFolderUpload.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectFolderUpload.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectFolderUpload.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the folder ID of this project folder upload.
	*
	* @param folderId the folder ID of this project folder upload
	*/
	@Override
	public void setFolderId(long folderId) {
		_projectFolderUpload.setFolderId(folderId);
	}

	/**
	* Sets the folder name of this project folder upload.
	*
	* @param folderName the folder name of this project folder upload
	*/
	@Override
	public void setFolderName(java.lang.String folderName) {
		_projectFolderUpload.setFolderName(folderName);
	}

	/**
	* Sets the group ID of this project folder upload.
	*
	* @param groupId the group ID of this project folder upload
	*/
	@Override
	public void setGroupId(long groupId) {
		_projectFolderUpload.setGroupId(groupId);
	}

	/**
	* Sets the interest ID of this project folder upload.
	*
	* @param interestId the interest ID of this project folder upload
	*/
	@Override
	public void setInterestId(long interestId) {
		_projectFolderUpload.setInterestId(interestId);
	}

	@Override
	public void setNew(boolean n) {
		_projectFolderUpload.setNew(n);
	}

	/**
	* Sets the p k_project folder ID of this project folder upload.
	*
	* @param PK_projectFolderId the p k_project folder ID of this project folder upload
	*/
	@Override
	public void setPK_projectFolderId(long PK_projectFolderId) {
		_projectFolderUpload.setPK_projectFolderId(PK_projectFolderId);
	}

	/**
	* Sets the parent folder ID of this project folder upload.
	*
	* @param parentFolderId the parent folder ID of this project folder upload
	*/
	@Override
	public void setParentFolderId(long parentFolderId) {
		_projectFolderUpload.setParentFolderId(parentFolderId);
	}

	/**
	* Sets the primary key of this project folder upload.
	*
	* @param primaryKey the primary key of this project folder upload
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectFolderUpload.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectFolderUpload.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this project folder upload.
	*
	* @param projectId the project ID of this project folder upload
	*/
	@Override
	public void setProjectId(long projectId) {
		_projectFolderUpload.setProjectId(projectId);
	}

	/**
	* Sets the user ID of this project folder upload.
	*
	* @param userId the user ID of this project folder upload
	*/
	@Override
	public void setUserId(long userId) {
		_projectFolderUpload.setUserId(userId);
	}

	/**
	* Sets the user uuid of this project folder upload.
	*
	* @param userUuid the user uuid of this project folder upload
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_projectFolderUpload.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof projectFolderUploadWrapper)) {
			return false;
		}

		projectFolderUploadWrapper projectFolderUploadWrapper = (projectFolderUploadWrapper)obj;

		if (Objects.equals(_projectFolderUpload,
					projectFolderUploadWrapper._projectFolderUpload)) {
			return true;
		}

		return false;
	}

	@Override
	public projectFolderUpload getWrappedModel() {
		return _projectFolderUpload;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectFolderUpload.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectFolderUpload.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectFolderUpload.resetOriginalValues();
	}

	private final projectFolderUpload _projectFolderUpload;
}