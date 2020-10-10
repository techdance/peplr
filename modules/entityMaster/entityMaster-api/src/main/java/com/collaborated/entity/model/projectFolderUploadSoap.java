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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.projectFolderUploadServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.projectFolderUploadServiceSoap
 * @generated
 */
@ProviderType
public class projectFolderUploadSoap implements Serializable {
	public static projectFolderUploadSoap toSoapModel(projectFolderUpload model) {
		projectFolderUploadSoap soapModel = new projectFolderUploadSoap();

		soapModel.setPK_projectFolderId(model.getPK_projectFolderId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setDeletedOn(model.getDeletedOn());
		soapModel.setInterestId(model.getInterestId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setUserId(model.getUserId());
		soapModel.setDeletedBy(model.getDeletedBy());
		soapModel.setParentFolderId(model.getParentFolderId());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setFolderName(model.getFolderName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static projectFolderUploadSoap[] toSoapModels(
		projectFolderUpload[] models) {
		projectFolderUploadSoap[] soapModels = new projectFolderUploadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static projectFolderUploadSoap[][] toSoapModels(
		projectFolderUpload[][] models) {
		projectFolderUploadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new projectFolderUploadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new projectFolderUploadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static projectFolderUploadSoap[] toSoapModels(
		List<projectFolderUpload> models) {
		List<projectFolderUploadSoap> soapModels = new ArrayList<projectFolderUploadSoap>(models.size());

		for (projectFolderUpload model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new projectFolderUploadSoap[soapModels.size()]);
	}

	public projectFolderUploadSoap() {
	}

	public long getPrimaryKey() {
		return _PK_projectFolderId;
	}

	public void setPrimaryKey(long pk) {
		setPK_projectFolderId(pk);
	}

	public long getPK_projectFolderId() {
		return _PK_projectFolderId;
	}

	public void setPK_projectFolderId(long PK_projectFolderId) {
		_PK_projectFolderId = PK_projectFolderId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreatedOn() {
		return _createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		_createdOn = createdOn;
	}

	public Date getDeletedOn() {
		return _deletedOn;
	}

	public void setDeletedOn(Date deletedOn) {
		_deletedOn = deletedOn;
	}

	public long getInterestId() {
		return _interestId;
	}

	public void setInterestId(long interestId) {
		_interestId = interestId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getDeletedBy() {
		return _deletedBy;
	}

	public void setDeletedBy(long deletedBy) {
		_deletedBy = deletedBy;
	}

	public long getParentFolderId() {
		return _parentFolderId;
	}

	public void setParentFolderId(long parentFolderId) {
		_parentFolderId = parentFolderId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getFolderName() {
		return _folderName;
	}

	public void setFolderName(String folderName) {
		_folderName = folderName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _PK_projectFolderId;
	private long _groupId;
	private Date _createdOn;
	private Date _deletedOn;
	private long _interestId;
	private long _projectId;
	private long _userId;
	private long _deletedBy;
	private long _parentFolderId;
	private long _folderId;
	private String _folderName;
	private String _description;
}