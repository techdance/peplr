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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.userInstitutionProfileSubDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.userInstitutionProfileSubDetailsServiceSoap
 * @generated
 */
@ProviderType
public class userInstitutionProfileSubDetailsSoap implements Serializable {
	public static userInstitutionProfileSubDetailsSoap toSoapModel(
		userInstitutionProfileSubDetails model) {
		userInstitutionProfileSubDetailsSoap soapModel = new userInstitutionProfileSubDetailsSoap();

		soapModel.setPK_userInstitionSub(model.getPK_userInstitionSub());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFileId(model.getFileId());
		soapModel.setPK_userInstition(model.getPK_userInstition());

		return soapModel;
	}

	public static userInstitutionProfileSubDetailsSoap[] toSoapModels(
		userInstitutionProfileSubDetails[] models) {
		userInstitutionProfileSubDetailsSoap[] soapModels = new userInstitutionProfileSubDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static userInstitutionProfileSubDetailsSoap[][] toSoapModels(
		userInstitutionProfileSubDetails[][] models) {
		userInstitutionProfileSubDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new userInstitutionProfileSubDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new userInstitutionProfileSubDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static userInstitutionProfileSubDetailsSoap[] toSoapModels(
		List<userInstitutionProfileSubDetails> models) {
		List<userInstitutionProfileSubDetailsSoap> soapModels = new ArrayList<userInstitutionProfileSubDetailsSoap>(models.size());

		for (userInstitutionProfileSubDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new userInstitutionProfileSubDetailsSoap[soapModels.size()]);
	}

	public userInstitutionProfileSubDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _PK_userInstitionSub;
	}

	public void setPrimaryKey(long pk) {
		setPK_userInstitionSub(pk);
	}

	public long getPK_userInstitionSub() {
		return _PK_userInstitionSub;
	}

	public void setPK_userInstitionSub(long PK_userInstitionSub) {
		_PK_userInstitionSub = PK_userInstitionSub;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public long getPK_userInstition() {
		return _PK_userInstition;
	}

	public void setPK_userInstition(long PK_userInstition) {
		_PK_userInstition = PK_userInstition;
	}

	private long _PK_userInstitionSub;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _fileId;
	private long _PK_userInstition;
}