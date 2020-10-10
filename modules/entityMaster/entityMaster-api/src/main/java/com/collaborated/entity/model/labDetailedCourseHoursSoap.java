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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labDetailedCourseHoursServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labDetailedCourseHoursServiceSoap
 * @generated
 */
@ProviderType
public class labDetailedCourseHoursSoap implements Serializable {
	public static labDetailedCourseHoursSoap toSoapModel(
		labDetailedCourseHours model) {
		labDetailedCourseHoursSoap soapModel = new labDetailedCourseHoursSoap();

		soapModel.setPK_courseHoursId(model.getPK_courseHoursId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setPK_courseId(model.getPK_courseId());
		soapModel.setNumberOfCredits(model.getNumberOfCredits());
		soapModel.setNumberOfCourseWeeks(model.getNumberOfCourseWeeks());
		soapModel.setCourseHoursPerWeek(model.getCourseHoursPerWeek());
		soapModel.setLectureHoursPerWeek(model.getLectureHoursPerWeek());
		soapModel.setLabHoursPerWeek(model.getLabHoursPerWeek());
		soapModel.setIndependentStudyHoursPerWeek(model.getIndependentStudyHoursPerWeek());

		return soapModel;
	}

	public static labDetailedCourseHoursSoap[] toSoapModels(
		labDetailedCourseHours[] models) {
		labDetailedCourseHoursSoap[] soapModels = new labDetailedCourseHoursSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labDetailedCourseHoursSoap[][] toSoapModels(
		labDetailedCourseHours[][] models) {
		labDetailedCourseHoursSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labDetailedCourseHoursSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labDetailedCourseHoursSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labDetailedCourseHoursSoap[] toSoapModels(
		List<labDetailedCourseHours> models) {
		List<labDetailedCourseHoursSoap> soapModels = new ArrayList<labDetailedCourseHoursSoap>(models.size());

		for (labDetailedCourseHours model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labDetailedCourseHoursSoap[soapModels.size()]);
	}

	public labDetailedCourseHoursSoap() {
	}

	public long getPrimaryKey() {
		return _PK_courseHoursId;
	}

	public void setPrimaryKey(long pk) {
		setPK_courseHoursId(pk);
	}

	public long getPK_courseHoursId() {
		return _PK_courseHoursId;
	}

	public void setPK_courseHoursId(long PK_courseHoursId) {
		_PK_courseHoursId = PK_courseHoursId;
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

	public long getNumberOfCredits() {
		return _numberOfCredits;
	}

	public void setNumberOfCredits(long numberOfCredits) {
		_numberOfCredits = numberOfCredits;
	}

	public long getNumberOfCourseWeeks() {
		return _numberOfCourseWeeks;
	}

	public void setNumberOfCourseWeeks(long numberOfCourseWeeks) {
		_numberOfCourseWeeks = numberOfCourseWeeks;
	}

	public long getCourseHoursPerWeek() {
		return _courseHoursPerWeek;
	}

	public void setCourseHoursPerWeek(long courseHoursPerWeek) {
		_courseHoursPerWeek = courseHoursPerWeek;
	}

	public long getLectureHoursPerWeek() {
		return _lectureHoursPerWeek;
	}

	public void setLectureHoursPerWeek(long lectureHoursPerWeek) {
		_lectureHoursPerWeek = lectureHoursPerWeek;
	}

	public long getLabHoursPerWeek() {
		return _labHoursPerWeek;
	}

	public void setLabHoursPerWeek(long labHoursPerWeek) {
		_labHoursPerWeek = labHoursPerWeek;
	}

	public long getIndependentStudyHoursPerWeek() {
		return _independentStudyHoursPerWeek;
	}

	public void setIndependentStudyHoursPerWeek(
		long independentStudyHoursPerWeek) {
		_independentStudyHoursPerWeek = independentStudyHoursPerWeek;
	}

	private long _PK_courseHoursId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectId;
	private long _PK_courseId;
	private long _numberOfCredits;
	private long _numberOfCourseWeeks;
	private long _courseHoursPerWeek;
	private long _lectureHoursPerWeek;
	private long _labHoursPerWeek;
	private long _independentStudyHoursPerWeek;
}