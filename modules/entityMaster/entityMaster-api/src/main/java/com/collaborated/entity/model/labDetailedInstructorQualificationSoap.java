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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labDetailedInstructorQualificationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labDetailedInstructorQualificationServiceSoap
 * @generated
 */
@ProviderType
public class labDetailedInstructorQualificationSoap implements Serializable {
	public static labDetailedInstructorQualificationSoap toSoapModel(
		labDetailedInstructorQualification model) {
		labDetailedInstructorQualificationSoap soapModel = new labDetailedInstructorQualificationSoap();

		soapModel.setPK_courseInstructorQualificationId(model.getPK_courseInstructorQualificationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setPK_courseId(model.getPK_courseId());
		soapModel.setInstructor1Qualification(model.getInstructor1Qualification());
		soapModel.setInstructor2Qualification(model.getInstructor2Qualification());

		return soapModel;
	}

	public static labDetailedInstructorQualificationSoap[] toSoapModels(
		labDetailedInstructorQualification[] models) {
		labDetailedInstructorQualificationSoap[] soapModels = new labDetailedInstructorQualificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labDetailedInstructorQualificationSoap[][] toSoapModels(
		labDetailedInstructorQualification[][] models) {
		labDetailedInstructorQualificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labDetailedInstructorQualificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labDetailedInstructorQualificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labDetailedInstructorQualificationSoap[] toSoapModels(
		List<labDetailedInstructorQualification> models) {
		List<labDetailedInstructorQualificationSoap> soapModels = new ArrayList<labDetailedInstructorQualificationSoap>(models.size());

		for (labDetailedInstructorQualification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labDetailedInstructorQualificationSoap[soapModels.size()]);
	}

	public labDetailedInstructorQualificationSoap() {
	}

	public long getPrimaryKey() {
		return _PK_courseInstructorQualificationId;
	}

	public void setPrimaryKey(long pk) {
		setPK_courseInstructorQualificationId(pk);
	}

	public long getPK_courseInstructorQualificationId() {
		return _PK_courseInstructorQualificationId;
	}

	public void setPK_courseInstructorQualificationId(
		long PK_courseInstructorQualificationId) {
		_PK_courseInstructorQualificationId = PK_courseInstructorQualificationId;
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

	public String getInstructor1Qualification() {
		return _instructor1Qualification;
	}

	public void setInstructor1Qualification(String instructor1Qualification) {
		_instructor1Qualification = instructor1Qualification;
	}

	public String getInstructor2Qualification() {
		return _instructor2Qualification;
	}

	public void setInstructor2Qualification(String instructor2Qualification) {
		_instructor2Qualification = instructor2Qualification;
	}

	private long _PK_courseInstructorQualificationId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectId;
	private long _PK_courseId;
	private String _instructor1Qualification;
	private String _instructor2Qualification;
}