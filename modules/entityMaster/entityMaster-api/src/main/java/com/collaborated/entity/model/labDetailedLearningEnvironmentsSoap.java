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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labDetailedLearningEnvironmentsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labDetailedLearningEnvironmentsServiceSoap
 * @generated
 */
@ProviderType
public class labDetailedLearningEnvironmentsSoap implements Serializable {
	public static labDetailedLearningEnvironmentsSoap toSoapModel(
		labDetailedLearningEnvironments model) {
		labDetailedLearningEnvironmentsSoap soapModel = new labDetailedLearningEnvironmentsSoap();

		soapModel.setPK_learningEnvironmentId(model.getPK_learningEnvironmentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setPK_courseId(model.getPK_courseId());
		soapModel.setLearningEnvironment(model.getLearningEnvironment());

		return soapModel;
	}

	public static labDetailedLearningEnvironmentsSoap[] toSoapModels(
		labDetailedLearningEnvironments[] models) {
		labDetailedLearningEnvironmentsSoap[] soapModels = new labDetailedLearningEnvironmentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labDetailedLearningEnvironmentsSoap[][] toSoapModels(
		labDetailedLearningEnvironments[][] models) {
		labDetailedLearningEnvironmentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labDetailedLearningEnvironmentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labDetailedLearningEnvironmentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labDetailedLearningEnvironmentsSoap[] toSoapModels(
		List<labDetailedLearningEnvironments> models) {
		List<labDetailedLearningEnvironmentsSoap> soapModels = new ArrayList<labDetailedLearningEnvironmentsSoap>(models.size());

		for (labDetailedLearningEnvironments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labDetailedLearningEnvironmentsSoap[soapModels.size()]);
	}

	public labDetailedLearningEnvironmentsSoap() {
	}

	public long getPrimaryKey() {
		return _PK_learningEnvironmentId;
	}

	public void setPrimaryKey(long pk) {
		setPK_learningEnvironmentId(pk);
	}

	public long getPK_learningEnvironmentId() {
		return _PK_learningEnvironmentId;
	}

	public void setPK_learningEnvironmentId(long PK_learningEnvironmentId) {
		_PK_learningEnvironmentId = PK_learningEnvironmentId;
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

	public long getPK_projectId() {
		return _PK_projectId;
	}

	public void setPK_projectId(long PK_projectId) {
		_PK_projectId = PK_projectId;
	}

	public long getPK_courseId() {
		return _PK_courseId;
	}

	public void setPK_courseId(long PK_courseId) {
		_PK_courseId = PK_courseId;
	}

	public String getLearningEnvironment() {
		return _learningEnvironment;
	}

	public void setLearningEnvironment(String learningEnvironment) {
		_learningEnvironment = learningEnvironment;
	}

	private long _PK_learningEnvironmentId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectId;
	private long _PK_courseId;
	private String _learningEnvironment;
}