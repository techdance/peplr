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
		soapModel.setDiscipline(model.getDiscipline());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setLocation(model.getLocation());
		soapModel.setCampus(model.getCampus());
		soapModel.setProgramLevel(model.getProgramLevel());
		soapModel.setProgramLength(model.getProgramLength());
		soapModel.setDeliveryMethod(model.getDeliveryMethod());
		soapModel.setCredits(model.getCredits());

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

	public String getDiscipline() {
		return _discipline;
	}

	public void setDiscipline(String discipline) {
		_discipline = discipline;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
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

	private long _PK_areaofinterest;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _projectType;
	private String _description;
	private String _discipline;
	private String _language;
	private String _location;
	private String _campus;
	private String _programLevel;
	private String _programLength;
	private String _deliveryMethod;
	private String _credits;
}