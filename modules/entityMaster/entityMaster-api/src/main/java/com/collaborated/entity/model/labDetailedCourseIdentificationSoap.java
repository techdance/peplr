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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labDetailedCourseIdentificationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labDetailedCourseIdentificationServiceSoap
 * @generated
 */
@ProviderType
public class labDetailedCourseIdentificationSoap implements Serializable {
	public static labDetailedCourseIdentificationSoap toSoapModel(
		labDetailedCourseIdentification model) {
		labDetailedCourseIdentificationSoap soapModel = new labDetailedCourseIdentificationSoap();

		soapModel.setPK_courseId(model.getPK_courseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setCourseTitle(model.getCourseTitle());
		soapModel.setCourseNumber(model.getCourseNumber());
		soapModel.setPrerequisites(model.getPrerequisites());
		soapModel.setCourseDescription(model.getCourseDescription());

		return soapModel;
	}

	public static labDetailedCourseIdentificationSoap[] toSoapModels(
		labDetailedCourseIdentification[] models) {
		labDetailedCourseIdentificationSoap[] soapModels = new labDetailedCourseIdentificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labDetailedCourseIdentificationSoap[][] toSoapModels(
		labDetailedCourseIdentification[][] models) {
		labDetailedCourseIdentificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labDetailedCourseIdentificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labDetailedCourseIdentificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labDetailedCourseIdentificationSoap[] toSoapModels(
		List<labDetailedCourseIdentification> models) {
		List<labDetailedCourseIdentificationSoap> soapModels = new ArrayList<labDetailedCourseIdentificationSoap>(models.size());

		for (labDetailedCourseIdentification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labDetailedCourseIdentificationSoap[soapModels.size()]);
	}

	public labDetailedCourseIdentificationSoap() {
	}

	public long getPrimaryKey() {
		return _PK_courseId;
	}

	public void setPrimaryKey(long pk) {
		setPK_courseId(pk);
	}

	public long getPK_courseId() {
		return _PK_courseId;
	}

	public void setPK_courseId(long PK_courseId) {
		_PK_courseId = PK_courseId;
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

	public String getCourseTitle() {
		return _courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		_courseTitle = courseTitle;
	}

	public String getCourseNumber() {
		return _courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		_courseNumber = courseNumber;
	}

	public String getPrerequisites() {
		return _prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		_prerequisites = prerequisites;
	}

	public String getCourseDescription() {
		return _courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		_courseDescription = courseDescription;
	}

	private long _PK_courseId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectId;
	private String _courseTitle;
	private String _courseNumber;
	private String _prerequisites;
	private String _courseDescription;
}