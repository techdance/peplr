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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.profileAreaofinterestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.profileAreaofinterestServiceSoap
 * @generated
 */
@ProviderType
public class profileAreaofinterestSoap implements Serializable {
	public static profileAreaofinterestSoap toSoapModel(
		profileAreaofinterest model) {
		profileAreaofinterestSoap soapModel = new profileAreaofinterestSoap();

		soapModel.setPK_areaofinterest(model.getPK_areaofinterest());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProjectType(model.getProjectType());
		soapModel.setDescription(model.getDescription());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setCampus(model.getCampus());
		soapModel.setProgramLevel(model.getProgramLevel());
		soapModel.setProgramLength(model.getProgramLength());
		soapModel.setDeliveryMethod(model.getDeliveryMethod());
		soapModel.setCredits(model.getCredits());
		soapModel.setCollaborationType(model.getCollaborationType());
		soapModel.setDiscipline1(model.getDiscipline1());
		soapModel.setDiscipline2(model.getDiscipline2());
		soapModel.setDiscipline3(model.getDiscipline3());
		soapModel.setLocation1(model.getLocation1());
		soapModel.setLocation2(model.getLocation2());
		soapModel.setLocation3(model.getLocation3());
		soapModel.setLocation4(model.getLocation4());
		soapModel.setRangerYearStart(model.getRangerYearStart());
		soapModel.setRangerYearEnd(model.getRangerYearEnd());
		soapModel.setRangerMonthStart(model.getRangerMonthStart());
		soapModel.setRangerMonthEnd(model.getRangerMonthEnd());

		return soapModel;
	}

	public static profileAreaofinterestSoap[] toSoapModels(
		profileAreaofinterest[] models) {
		profileAreaofinterestSoap[] soapModels = new profileAreaofinterestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static profileAreaofinterestSoap[][] toSoapModels(
		profileAreaofinterest[][] models) {
		profileAreaofinterestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new profileAreaofinterestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new profileAreaofinterestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static profileAreaofinterestSoap[] toSoapModels(
		List<profileAreaofinterest> models) {
		List<profileAreaofinterestSoap> soapModels = new ArrayList<profileAreaofinterestSoap>(models.size());

		for (profileAreaofinterest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new profileAreaofinterestSoap[soapModels.size()]);
	}

	public profileAreaofinterestSoap() {
	}

	public long getPrimaryKey() {
		return _PK_areaofinterest;
	}

	public void setPrimaryKey(long pk) {
		setPK_areaofinterest(pk);
	}

	public long getPK_areaofinterest() {
		return _PK_areaofinterest;
	}

	public void setPK_areaofinterest(long PK_areaofinterest) {
		_PK_areaofinterest = PK_areaofinterest;
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

	public String getProjectType() {
		return _projectType;
	}

	public void setProjectType(String projectType) {
		_projectType = projectType;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getCampus() {
		return _campus;
	}

	public void setCampus(String campus) {
		_campus = campus;
	}

	public String getProgramLevel() {
		return _programLevel;
	}

	public void setProgramLevel(String programLevel) {
		_programLevel = programLevel;
	}

	public String getProgramLength() {
		return _programLength;
	}

	public void setProgramLength(String programLength) {
		_programLength = programLength;
	}

	public String getDeliveryMethod() {
		return _deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		_deliveryMethod = deliveryMethod;
	}

	public String getCredits() {
		return _credits;
	}

	public void setCredits(String credits) {
		_credits = credits;
	}

	public String getCollaborationType() {
		return _collaborationType;
	}

	public void setCollaborationType(String collaborationType) {
		_collaborationType = collaborationType;
	}

	public String getDiscipline1() {
		return _discipline1;
	}

	public void setDiscipline1(String discipline1) {
		_discipline1 = discipline1;
	}

	public String getDiscipline2() {
		return _discipline2;
	}

	public void setDiscipline2(String discipline2) {
		_discipline2 = discipline2;
	}

	public String getDiscipline3() {
		return _discipline3;
	}

	public void setDiscipline3(String discipline3) {
		_discipline3 = discipline3;
	}

	public String getLocation1() {
		return _location1;
	}

	public void setLocation1(String location1) {
		_location1 = location1;
	}

	public String getLocation2() {
		return _location2;
	}

	public void setLocation2(String location2) {
		_location2 = location2;
	}

	public String getLocation3() {
		return _location3;
	}

	public void setLocation3(String location3) {
		_location3 = location3;
	}

	public String getLocation4() {
		return _location4;
	}

	public void setLocation4(String location4) {
		_location4 = location4;
	}

	public int getRangerYearStart() {
		return _rangerYearStart;
	}

	public void setRangerYearStart(int rangerYearStart) {
		_rangerYearStart = rangerYearStart;
	}

	public int getRangerYearEnd() {
		return _rangerYearEnd;
	}

	public void setRangerYearEnd(int rangerYearEnd) {
		_rangerYearEnd = rangerYearEnd;
	}

	public String getRangerMonthStart() {
		return _rangerMonthStart;
	}

	public void setRangerMonthStart(String rangerMonthStart) {
		_rangerMonthStart = rangerMonthStart;
	}

	public String getRangerMonthEnd() {
		return _rangerMonthEnd;
	}

	public void setRangerMonthEnd(String rangerMonthEnd) {
		_rangerMonthEnd = rangerMonthEnd;
	}

	private long _PK_areaofinterest;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _projectType;
	private String _description;
	private String _language;
	private String _campus;
	private String _programLevel;
	private String _programLength;
	private String _deliveryMethod;
	private String _credits;
	private String _collaborationType;
	private String _discipline1;
	private String _discipline2;
	private String _discipline3;
	private String _location1;
	private String _location2;
	private String _location3;
	private String _location4;
	private int _rangerYearStart;
	private int _rangerYearEnd;
	private String _rangerMonthStart;
	private String _rangerMonthEnd;
}