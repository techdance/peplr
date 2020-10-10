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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.projectFilesUploadServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.projectFilesUploadServiceSoap
 * @generated
 */
@ProviderType
public class projectFilesUploadSoap implements Serializable {
	public static projectFilesUploadSoap toSoapModel(projectFilesUpload model) {
		projectFilesUploadSoap soapModel = new projectFilesUploadSoap();

		soapModel.setPK_projectFileId(model.getPK_projectFileId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setDeletedOn(model.getDeletedOn());
		soapModel.setUserId(model.getUserId());
		soapModel.setDeletedBy(model.getDeletedBy());
		soapModel.setPK_projectFolderId(model.getPK_projectFolderId());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static projectFilesUploadSoap[] toSoapModels(
		projectFilesUpload[] models) {
		projectFilesUploadSoap[] soapModels = new projectFilesUploadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static projectFilesUploadSoap[][] toSoapModels(
		projectFilesUpload[][] models) {
		projectFilesUploadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new projectFilesUploadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new projectFilesUploadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static projectFilesUploadSoap[] toSoapModels(
		List<projectFilesUpload> models) {
		List<projectFilesUploadSoap> soapModels = new ArrayList<projectFilesUploadSoap>(models.size());

		for (projectFilesUpload model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new projectFilesUploadSoap[soapModels.size()]);
	}

	public projectFilesUploadSoap() {
	}

	public long getPrimaryKey() {
		return _PK_projectFileId;
	}

	public void setPrimaryKey(long pk) {
		setPK_projectFileId(pk);
	}

	public long getPK_projectFileId() {
		return _PK_projectFileId;
	}

	public void setPK_projectFileId(long PK_projectFileId) {
		_PK_projectFileId = PK_projectFileId;
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

	public long getPK_projectFolderId() {
		return _PK_projectFolderId;
	}

	public void setPK_projectFolderId(long PK_projectFolderId) {
		_PK_projectFolderId = PK_projectFolderId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(String fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _PK_projectFileId;
	private long _groupId;
	private Date _createdOn;
	private Date _deletedOn;
	private long _userId;
	private long _deletedBy;
	private long _PK_projectFolderId;
	private String _fileName;
	private String _fileEntryId;
	private String _description;
}