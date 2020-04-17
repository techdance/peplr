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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.userInstitutionProfileDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.userInstitutionProfileDetailsServiceSoap
 * @generated
 */
@ProviderType
public class userInstitutionProfileDetailsSoap implements Serializable {
	public static userInstitutionProfileDetailsSoap toSoapModel(
		userInstitutionProfileDetails model) {
		userInstitutionProfileDetailsSoap soapModel = new userInstitutionProfileDetailsSoap();

		soapModel.setPK_userInstition(model.getPK_userInstition());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setInstitutionName(model.getInstitutionName());
		soapModel.setAcadeCalendar(model.getAcadeCalendar());
		soapModel.setDepartmentdescription(model.getDepartmentdescription());

		return soapModel;
	}

	public static userInstitutionProfileDetailsSoap[] toSoapModels(
		userInstitutionProfileDetails[] models) {
		userInstitutionProfileDetailsSoap[] soapModels = new userInstitutionProfileDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static userInstitutionProfileDetailsSoap[][] toSoapModels(
		userInstitutionProfileDetails[][] models) {
		userInstitutionProfileDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new userInstitutionProfileDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new userInstitutionProfileDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static userInstitutionProfileDetailsSoap[] toSoapModels(
		List<userInstitutionProfileDetails> models) {
		List<userInstitutionProfileDetailsSoap> soapModels = new ArrayList<userInstitutionProfileDetailsSoap>(models.size());

		for (userInstitutionProfileDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new userInstitutionProfileDetailsSoap[soapModels.size()]);
	}

	public userInstitutionProfileDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _PK_userInstition;
	}

	public void setPrimaryKey(long pk) {
		setPK_userInstition(pk);
	}

	public long getPK_userInstition() {
		return _PK_userInstition;
	}

	public void setPK_userInstition(long PK_userInstition) {
		_PK_userInstition = PK_userInstition;
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

	public String getInstitutionName() {
		return _institutionName;
	}

	public void setInstitutionName(String institutionName) {
		_institutionName = institutionName;
	}

	public String getAcadeCalendar() {
		return _acadeCalendar;
	}

	public void setAcadeCalendar(String acadeCalendar) {
		_acadeCalendar = acadeCalendar;
	}

	public String getDepartmentdescription() {
		return _departmentdescription;
	}

	public void setDepartmentdescription(String departmentdescription) {
		_departmentdescription = departmentdescription;
	}

	private long _PK_userInstition;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _institutionName;
	private String _acadeCalendar;
	private String _departmentdescription;
}