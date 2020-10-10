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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labScreenProjectPartnersServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labScreenProjectPartnersServiceSoap
 * @generated
 */
@ProviderType
public class labScreenProjectPartnersSoap implements Serializable {
	public static labScreenProjectPartnersSoap toSoapModel(
		labScreenProjectPartners model) {
		labScreenProjectPartnersSoap soapModel = new labScreenProjectPartnersSoap();

		soapModel.setPK_projectPartnerId(model.getPK_projectPartnerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setProjectPartnerId(model.getProjectPartnerId());
		soapModel.setIsActive(model.getIsActive());

		return soapModel;
	}

	public static labScreenProjectPartnersSoap[] toSoapModels(
		labScreenProjectPartners[] models) {
		labScreenProjectPartnersSoap[] soapModels = new labScreenProjectPartnersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labScreenProjectPartnersSoap[][] toSoapModels(
		labScreenProjectPartners[][] models) {
		labScreenProjectPartnersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labScreenProjectPartnersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labScreenProjectPartnersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labScreenProjectPartnersSoap[] toSoapModels(
		List<labScreenProjectPartners> models) {
		List<labScreenProjectPartnersSoap> soapModels = new ArrayList<labScreenProjectPartnersSoap>(models.size());

		for (labScreenProjectPartners model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labScreenProjectPartnersSoap[soapModels.size()]);
	}

	public labScreenProjectPartnersSoap() {
	}

	public long getPrimaryKey() {
		return _PK_projectPartnerId;
	}

	public void setPrimaryKey(long pk) {
		setPK_projectPartnerId(pk);
	}

	public long getPK_projectPartnerId() {
		return _PK_projectPartnerId;
	}

	public void setPK_projectPartnerId(long PK_projectPartnerId) {
		_PK_projectPartnerId = PK_projectPartnerId;
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

	public long getProjectPartnerId() {
		return _projectPartnerId;
	}

	public void setProjectPartnerId(long projectPartnerId) {
		_projectPartnerId = projectPartnerId;
	}

	public long getIsActive() {
		return _isActive;
	}

	public void setIsActive(long isActive) {
		_isActive = isActive;
	}

	private long _PK_projectPartnerId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectId;
	private long _projectPartnerId;
	private long _isActive;
}