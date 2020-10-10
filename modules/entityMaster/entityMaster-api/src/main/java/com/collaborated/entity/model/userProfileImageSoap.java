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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.userProfileImageServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.userProfileImageServiceSoap
 * @generated
 */
@ProviderType
public class userProfileImageSoap implements Serializable {
	public static userProfileImageSoap toSoapModel(userProfileImage model) {
		userProfileImageSoap soapModel = new userProfileImageSoap();

		soapModel.setPK_profileImageId(model.getPK_profileImageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setUserId(model.getUserId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setFileEntryUrl(model.getFileEntryUrl());
		soapModel.setBlobData(model.getBlobData());

		return soapModel;
	}

	public static userProfileImageSoap[] toSoapModels(userProfileImage[] models) {
		userProfileImageSoap[] soapModels = new userProfileImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static userProfileImageSoap[][] toSoapModels(
		userProfileImage[][] models) {
		userProfileImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new userProfileImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new userProfileImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static userProfileImageSoap[] toSoapModels(
		List<userProfileImage> models) {
		List<userProfileImageSoap> soapModels = new ArrayList<userProfileImageSoap>(models.size());

		for (userProfileImage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new userProfileImageSoap[soapModels.size()]);
	}

	public userProfileImageSoap() {
	}

	public long getPrimaryKey() {
		return _PK_profileImageId;
	}

	public void setPrimaryKey(long pk) {
		setPK_profileImageId(pk);
	}

	public long getPK_profileImageId() {
		return _PK_profileImageId;
	}

	public void setPK_profileImageId(long PK_profileImageId) {
		_PK_profileImageId = PK_profileImageId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(String fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getFileEntryUrl() {
		return _fileEntryUrl;
	}

	public void setFileEntryUrl(String fileEntryUrl) {
		_fileEntryUrl = fileEntryUrl;
	}

	public Blob getBlobData() {
		return _blobData;
	}

	public void setBlobData(Blob blobData) {
		_blobData = blobData;
	}

	private long _PK_profileImageId;
	private long _groupId;
	private Date _createdOn;
	private long _userId;
	private String _fileEntryId;
	private String _fileEntryUrl;
	private Blob _blobData;
}