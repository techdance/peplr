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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.userProfessionalBioServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.userProfessionalBioServiceSoap
 * @generated
 */
@ProviderType
public class userProfessionalBioSoap implements Serializable {
	public static userProfessionalBioSoap toSoapModel(userProfessionalBio model) {
		userProfessionalBioSoap soapModel = new userProfessionalBioSoap();

		soapModel.setPK_userProfessionalBio(model.getPK_userProfessionalBio());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAreaofexpertise1(model.getAreaofexpertise1());
		soapModel.setAreaofexpertise2(model.getAreaofexpertise2());
		soapModel.setAreaofexpertise3(model.getAreaofexpertise3());
		soapModel.setExperienceyears(model.getExperienceyears());
		soapModel.setCvlink(model.getCvlink());
		soapModel.setBiodescription(model.getBiodescription());
		soapModel.setBioDiscipline(model.getBioDiscipline());

		return soapModel;
	}

	public static userProfessionalBioSoap[] toSoapModels(
		userProfessionalBio[] models) {
		userProfessionalBioSoap[] soapModels = new userProfessionalBioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static userProfessionalBioSoap[][] toSoapModels(
		userProfessionalBio[][] models) {
		userProfessionalBioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new userProfessionalBioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new userProfessionalBioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static userProfessionalBioSoap[] toSoapModels(
		List<userProfessionalBio> models) {
		List<userProfessionalBioSoap> soapModels = new ArrayList<userProfessionalBioSoap>(models.size());

		for (userProfessionalBio model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new userProfessionalBioSoap[soapModels.size()]);
	}

	public userProfessionalBioSoap() {
	}

	public long getPrimaryKey() {
		return _PK_userProfessionalBio;
	}

	public void setPrimaryKey(long pk) {
		setPK_userProfessionalBio(pk);
	}

	public long getPK_userProfessionalBio() {
		return _PK_userProfessionalBio;
	}

	public void setPK_userProfessionalBio(long PK_userProfessionalBio) {
		_PK_userProfessionalBio = PK_userProfessionalBio;
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

	public String getAreaofexpertise1() {
		return _areaofexpertise1;
	}

	public void setAreaofexpertise1(String areaofexpertise1) {
		_areaofexpertise1 = areaofexpertise1;
	}

	public String getAreaofexpertise2() {
		return _areaofexpertise2;
	}

	public void setAreaofexpertise2(String areaofexpertise2) {
		_areaofexpertise2 = areaofexpertise2;
	}

	public String getAreaofexpertise3() {
		return _areaofexpertise3;
	}

	public void setAreaofexpertise3(String areaofexpertise3) {
		_areaofexpertise3 = areaofexpertise3;
	}

	public String getExperienceyears() {
		return _experienceyears;
	}

	public void setExperienceyears(String experienceyears) {
		_experienceyears = experienceyears;
	}

	public String getCvlink() {
		return _cvlink;
	}

	public void setCvlink(String cvlink) {
		_cvlink = cvlink;
	}

	public String getBiodescription() {
		return _biodescription;
	}

	public void setBiodescription(String biodescription) {
		_biodescription = biodescription;
	}

	public String getBioDiscipline() {
		return _bioDiscipline;
	}

	public void setBioDiscipline(String bioDiscipline) {
		_bioDiscipline = bioDiscipline;
	}

	private long _PK_userProfessionalBio;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _areaofexpertise1;
	private String _areaofexpertise2;
	private String _areaofexpertise3;
	private String _experienceyears;
	private String _cvlink;
	private String _biodescription;
	private String _bioDiscipline;
}