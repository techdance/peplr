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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.projectDiscussionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.projectDiscussionServiceSoap
 * @generated
 */
@ProviderType
public class projectDiscussionSoap implements Serializable {
	public static projectDiscussionSoap toSoapModel(projectDiscussion model) {
		projectDiscussionSoap soapModel = new projectDiscussionSoap();

		soapModel.setPK_projectDiscussionId(model.getPK_projectDiscussionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setInterestId(model.getInterestId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setSenderId(model.getSenderId());
		soapModel.setDescription(model.getDescription());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setImageUrl(model.getImageUrl());

		return soapModel;
	}

	public static projectDiscussionSoap[] toSoapModels(
		projectDiscussion[] models) {
		projectDiscussionSoap[] soapModels = new projectDiscussionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static projectDiscussionSoap[][] toSoapModels(
		projectDiscussion[][] models) {
		projectDiscussionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new projectDiscussionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new projectDiscussionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static projectDiscussionSoap[] toSoapModels(
		List<projectDiscussion> models) {
		List<projectDiscussionSoap> soapModels = new ArrayList<projectDiscussionSoap>(models.size());

		for (projectDiscussion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new projectDiscussionSoap[soapModels.size()]);
	}

	public projectDiscussionSoap() {
	}

	public long getPrimaryKey() {
		return _PK_projectDiscussionId;
	}

	public void setPrimaryKey(long pk) {
		setPK_projectDiscussionId(pk);
	}

	public long getPK_projectDiscussionId() {
		return _PK_projectDiscussionId;
	}

	public void setPK_projectDiscussionId(long PK_projectDiscussionId) {
		_PK_projectDiscussionId = PK_projectDiscussionId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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

	public long getSenderId() {
		return _senderId;
	}

	public void setSenderId(long senderId) {
		_senderId = senderId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	private long _PK_projectDiscussionId;
	private long _groupId;
	private Date _createdOn;
	private Date _modifiedDate;
	private long _interestId;
	private long _projectId;
	private long _senderId;
	private String _description;
	private long _fileEntryId;
	private String _imageUrl;
}