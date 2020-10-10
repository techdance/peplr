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
 * This class is a wrapper for {@link projectFilesUpload}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectFilesUpload
 * @generated
 */
@ProviderType
public class projectFilesUploadWrapper implements projectFilesUpload,
	ModelWrapper<projectFilesUpload> {
	public projectFilesUploadWrapper(projectFilesUpload projectFilesUpload) {
		_projectFilesUpload = projectFilesUpload;
	}

	@Override
	public Class<?> getModelClass() {
		return projectFilesUpload.class;
	}

	@Override
	public String getModelClassName() {
		return projectFilesUpload.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_projectFileId", getPK_projectFileId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("deletedOn", getDeletedOn());
		attributes.put("userId", getUserId());
		attributes.put("deletedBy", getDeletedBy());
		attributes.put("PK_projectFolderId", getPK_projectFolderId());
		attributes.put("fileName", getFileName());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_projectFileId = (Long)attributes.get("PK_projectFileId");

		if (PK_projectFileId != null) {
			setPK_projectFileId(PK_projectFileId);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long deletedBy = (Long)attributes.get("deletedBy");

		if (deletedBy != null) {
			setDeletedBy(deletedBy);
		}

		Long PK_projectFolderId = (Long)attributes.get("PK_projectFolderId");

		if (PK_projectFolderId != null) {
			setPK_projectFolderId(PK_projectFolderId);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileEntryId = (String)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _projectFilesUpload.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectFilesUpload.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectFilesUpload.isNew();
	}

	@Override
	public com.collaborated.entity.model.projectFilesUpload toEscapedModel() {
		return new projectFilesUploadWrapper(_projectFilesUpload.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.projectFilesUpload toUnescapedModel() {
		return new projectFilesUploadWrapper(_projectFilesUpload.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectFilesUpload.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.projectFilesUpload> toCacheModel() {
		return _projectFilesUpload.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.projectFilesUpload projectFilesUpload) {
		return _projectFilesUpload.compareTo(projectFilesUpload);
	}

	@Override
	public int hashCode() {
		return _projectFilesUpload.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectFilesUpload.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new projectFilesUploadWrapper((projectFilesUpload)_projectFilesUpload.clone());
	}

	/**
	* Returns the description of this project files upload.
	*
	* @return the description of this project files upload
	*/
	@Override
	public java.lang.String getDescription() {
		return _projectFilesUpload.getDescription();
	}

	/**
	* Returns the file entry ID of this project files upload.
	*
	* @return the file entry ID of this project files upload
	*/
	@Override
	public java.lang.String getFileEntryId() {
		return _projectFilesUpload.getFileEntryId();
	}

	/**
	* Returns the file name of this project files upload.
	*
	* @return the file name of this project files upload
	*/
	@Override
	public java.lang.String getFileName() {
		return _projectFilesUpload.getFileName();
	}

	/**
	* Returns the user uuid of this project files upload.
	*
	* @return the user uuid of this project files upload
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _projectFilesUpload.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _projectFilesUpload.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectFilesUpload.toXmlString();
	}

	/**
	* Returns the created on of this project files upload.
	*
	* @return the created on of this project files upload
	*/
	@Override
	public Date getCreatedOn() {
		return _projectFilesUpload.getCreatedOn();
	}

	/**
	* Returns the deleted on of this project files upload.
	*
	* @return the deleted on of this project files upload
	*/
	@Override
	public Date getDeletedOn() {
		return _projectFilesUpload.getDeletedOn();
	}

	/**
	* Returns the deleted by of this project files upload.
	*
	* @return the deleted by of this project files upload
	*/
	@Override
	public long getDeletedBy() {
		return _projectFilesUpload.getDeletedBy();
	}

	/**
	* Returns the group ID of this project files upload.
	*
	* @return the group ID of this project files upload
	*/
	@Override
	public long getGroupId() {
		return _projectFilesUpload.getGroupId();
	}

	/**
	* Returns the p k_project file ID of this project files upload.
	*
	* @return the p k_project file ID of this project files upload
	*/
	@Override
	public long getPK_projectFileId() {
		return _projectFilesUpload.getPK_projectFileId();
	}

	/**
	* Returns the p k_project folder ID of this project files upload.
	*
	* @return the p k_project folder ID of this project files upload
	*/
	@Override
	public long getPK_projectFolderId() {
		return _projectFilesUpload.getPK_projectFolderId();
	}

	/**
	* Returns the primary key of this project files upload.
	*
	* @return the primary key of this project files upload
	*/
	@Override
	public long getPrimaryKey() {
		return _projectFilesUpload.getPrimaryKey();
	}

	/**
	* Returns the user ID of this project files upload.
	*
	* @return the user ID of this project files upload
	*/
	@Override
	public long getUserId() {
		return _projectFilesUpload.getUserId();
	}

	@Override
	public void persist() {
		_projectFilesUpload.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectFilesUpload.setCachedModel(cachedModel);
	}

	/**
	* Sets the created on of this project files upload.
	*
	* @param createdOn the created on of this project files upload
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_projectFilesUpload.setCreatedOn(createdOn);
	}

	/**
	* Sets the deleted by of this project files upload.
	*
	* @param deletedBy the deleted by of this project files upload
	*/
	@Override
	public void setDeletedBy(long deletedBy) {
		_projectFilesUpload.setDeletedBy(deletedBy);
	}

	/**
	* Sets the deleted on of this project files upload.
	*
	* @param deletedOn the deleted on of this project files upload
	*/
	@Override
	public void setDeletedOn(Date deletedOn) {
		_projectFilesUpload.setDeletedOn(deletedOn);
	}

	/**
	* Sets the description of this project files upload.
	*
	* @param description the description of this project files upload
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_projectFilesUpload.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectFilesUpload.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectFilesUpload.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectFilesUpload.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this project files upload.
	*
	* @param fileEntryId the file entry ID of this project files upload
	*/
	@Override
	public void setFileEntryId(java.lang.String fileEntryId) {
		_projectFilesUpload.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the file name of this project files upload.
	*
	* @param fileName the file name of this project files upload
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_projectFilesUpload.setFileName(fileName);
	}

	/**
	* Sets the group ID of this project files upload.
	*
	* @param groupId the group ID of this project files upload
	*/
	@Override
	public void setGroupId(long groupId) {
		_projectFilesUpload.setGroupId(groupId);
	}

	@Override
	public void setNew(boolean n) {
		_projectFilesUpload.setNew(n);
	}

	/**
	* Sets the p k_project file ID of this project files upload.
	*
	* @param PK_projectFileId the p k_project file ID of this project files upload
	*/
	@Override
	public void setPK_projectFileId(long PK_projectFileId) {
		_projectFilesUpload.setPK_projectFileId(PK_projectFileId);
	}

	/**
	* Sets the p k_project folder ID of this project files upload.
	*
	* @param PK_projectFolderId the p k_project folder ID of this project files upload
	*/
	@Override
	public void setPK_projectFolderId(long PK_projectFolderId) {
		_projectFilesUpload.setPK_projectFolderId(PK_projectFolderId);
	}

	/**
	* Sets the primary key of this project files upload.
	*
	* @param primaryKey the primary key of this project files upload
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectFilesUpload.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectFilesUpload.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this project files upload.
	*
	* @param userId the user ID of this project files upload
	*/
	@Override
	public void setUserId(long userId) {
		_projectFilesUpload.setUserId(userId);
	}

	/**
	* Sets the user uuid of this project files upload.
	*
	* @param userUuid the user uuid of this project files upload
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_projectFilesUpload.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof projectFilesUploadWrapper)) {
			return false;
		}

		projectFilesUploadWrapper projectFilesUploadWrapper = (projectFilesUploadWrapper)obj;

		if (Objects.equals(_projectFilesUpload,
					projectFilesUploadWrapper._projectFilesUpload)) {
			return true;
		}

		return false;
	}

	@Override
	public projectFilesUpload getWrappedModel() {
		return _projectFilesUpload;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectFilesUpload.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectFilesUpload.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectFilesUpload.resetOriginalValues();
	}

	private final projectFilesUpload _projectFilesUpload;
}