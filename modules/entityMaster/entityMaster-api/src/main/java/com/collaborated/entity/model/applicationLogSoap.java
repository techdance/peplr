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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.applicationLogServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.applicationLogServiceSoap
 * @generated
 */
@ProviderType
public class applicationLogSoap implements Serializable {
	public static applicationLogSoap toSoapModel(applicationLog model) {
		applicationLogSoap soapModel = new applicationLogSoap();

		soapModel.setPK_logId(model.getPK_logId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setPageName(model.getPageName());
		soapModel.setModuleName(model.getModuleName());
		soapModel.setButtonName(model.getButtonName());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setInterestId(model.getInterestId());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static applicationLogSoap[] toSoapModels(applicationLog[] models) {
		applicationLogSoap[] soapModels = new applicationLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static applicationLogSoap[][] toSoapModels(applicationLog[][] models) {
		applicationLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new applicationLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new applicationLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static applicationLogSoap[] toSoapModels(List<applicationLog> models) {
		List<applicationLogSoap> soapModels = new ArrayList<applicationLogSoap>(models.size());

		for (applicationLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new applicationLogSoap[soapModels.size()]);
	}

	public applicationLogSoap() {
	}

	public long getPrimaryKey() {
		return _PK_logId;
	}

	public void setPrimaryKey(long pk) {
		setPK_logId(pk);
	}

	public long getPK_logId() {
		return _PK_logId;
	}

	public void setPK_logId(long PK_logId) {
		_PK_logId = PK_logId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getPageName() {
		return _pageName;
	}

	public void setPageName(String pageName) {
		_pageName = pageName;
	}

	public String getModuleName() {
		return _moduleName;
	}

	public void setModuleName(String moduleName) {
		_moduleName = moduleName;
	}

	public String getButtonName() {
		return _buttonName;
	}

	public void setButtonName(String buttonName) {
		_buttonName = buttonName;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getInterestId() {
		return _interestId;
	}

	public void setInterestId(long interestId) {
		_interestId = interestId;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private long _PK_logId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private String _pageName;
	private String _moduleName;
	private String _buttonName;
	private long _projectId;
	private long _interestId;
	private String _comments;
}