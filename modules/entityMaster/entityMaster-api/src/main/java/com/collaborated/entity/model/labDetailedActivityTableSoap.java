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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labDetailedActivityTableServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labDetailedActivityTableServiceSoap
 * @generated
 */
@ProviderType
public class labDetailedActivityTableSoap implements Serializable {
	public static labDetailedActivityTableSoap toSoapModel(
		labDetailedActivityTable model) {
		labDetailedActivityTableSoap soapModel = new labDetailedActivityTableSoap();

		soapModel.setPK_activityTableId(model.getPK_activityTableId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setPK_courseId(model.getPK_courseId());
		soapModel.setWeek(model.getWeek());
		soapModel.setCourseObjective(model.getCourseObjective());
		soapModel.setLearningEnvironmentDesign(model.getLearningEnvironmentDesign());
		soapModel.setActivity(model.getActivity());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static labDetailedActivityTableSoap[] toSoapModels(
		labDetailedActivityTable[] models) {
		labDetailedActivityTableSoap[] soapModels = new labDetailedActivityTableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labDetailedActivityTableSoap[][] toSoapModels(
		labDetailedActivityTable[][] models) {
		labDetailedActivityTableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labDetailedActivityTableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labDetailedActivityTableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labDetailedActivityTableSoap[] toSoapModels(
		List<labDetailedActivityTable> models) {
		List<labDetailedActivityTableSoap> soapModels = new ArrayList<labDetailedActivityTableSoap>(models.size());

		for (labDetailedActivityTable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labDetailedActivityTableSoap[soapModels.size()]);
	}

	public labDetailedActivityTableSoap() {
	}

	public long getPrimaryKey() {
		return _PK_activityTableId;
	}

	public void setPrimaryKey(long pk) {
		setPK_activityTableId(pk);
	}

	public long getPK_activityTableId() {
		return _PK_activityTableId;
	}

	public void setPK_activityTableId(long PK_activityTableId) {
		_PK_activityTableId = PK_activityTableId;
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

	public long getWeek() {
		return _week;
	}

	public void setWeek(long week) {
		_week = week;
	}

	public String getCourseObjective() {
		return _courseObjective;
	}

	public void setCourseObjective(String courseObjective) {
		_courseObjective = courseObjective;
	}

	public String getLearningEnvironmentDesign() {
		return _learningEnvironmentDesign;
	}

	public void setLearningEnvironmentDesign(String learningEnvironmentDesign) {
		_learningEnvironmentDesign = learningEnvironmentDesign;
	}

	public String getActivity() {
		return _activity;
	}

	public void setActivity(String activity) {
		_activity = activity;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private long _PK_activityTableId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectId;
	private long _PK_courseId;
	private long _week;
	private String _courseObjective;
	private String _learningEnvironmentDesign;
	private String _activity;
	private String _content;
}