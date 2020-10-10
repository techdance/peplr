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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labDetailedCourseTopicsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labDetailedCourseTopicsServiceSoap
 * @generated
 */
@ProviderType
public class labDetailedCourseTopicsSoap implements Serializable {
	public static labDetailedCourseTopicsSoap toSoapModel(
		labDetailedCourseTopics model) {
		labDetailedCourseTopicsSoap soapModel = new labDetailedCourseTopicsSoap();

		soapModel.setPK_courseTopicsId(model.getPK_courseTopicsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setPK_courseId(model.getPK_courseId());
		soapModel.setCourseTopic(model.getCourseTopic());

		return soapModel;
	}

	public static labDetailedCourseTopicsSoap[] toSoapModels(
		labDetailedCourseTopics[] models) {
		labDetailedCourseTopicsSoap[] soapModels = new labDetailedCourseTopicsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labDetailedCourseTopicsSoap[][] toSoapModels(
		labDetailedCourseTopics[][] models) {
		labDetailedCourseTopicsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labDetailedCourseTopicsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labDetailedCourseTopicsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labDetailedCourseTopicsSoap[] toSoapModels(
		List<labDetailedCourseTopics> models) {
		List<labDetailedCourseTopicsSoap> soapModels = new ArrayList<labDetailedCourseTopicsSoap>(models.size());

		for (labDetailedCourseTopics model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labDetailedCourseTopicsSoap[soapModels.size()]);
	}

	public labDetailedCourseTopicsSoap() {
	}

	public long getPrimaryKey() {
		return _PK_courseTopicsId;
	}

	public void setPrimaryKey(long pk) {
		setPK_courseTopicsId(pk);
	}

	public long getPK_courseTopicsId() {
		return _PK_courseTopicsId;
	}

	public void setPK_courseTopicsId(long PK_courseTopicsId) {
		_PK_courseTopicsId = PK_courseTopicsId;
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

	public String getCourseTopic() {
		return _courseTopic;
	}

	public void setCourseTopic(String courseTopic) {
		_courseTopic = courseTopic;
	}

	private long _PK_courseTopicsId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectId;
	private long _PK_courseId;
	private String _courseTopic;
}