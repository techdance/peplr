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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.userCredentialServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.userCredentialServiceSoap
 * @generated
 */
@ProviderType
public class userCredentialSoap implements Serializable {
	public static userCredentialSoap toSoapModel(userCredential model) {
		userCredentialSoap soapModel = new userCredentialSoap();

		soapModel.setPK_userCredential(model.getPK_userCredential());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMembership1(model.getMembership1());
		soapModel.setMembership2(model.getMembership2());
		soapModel.setMembership3(model.getMembership3());
		soapModel.setMembership4(model.getMembership4());
		soapModel.setCertificate1(model.getCertificate1());
		soapModel.setCertificate2(model.getCertificate2());
		soapModel.setCertificate3(model.getCertificate3());

		return soapModel;
	}

	public static userCredentialSoap[] toSoapModels(userCredential[] models) {
		userCredentialSoap[] soapModels = new userCredentialSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static userCredentialSoap[][] toSoapModels(userCredential[][] models) {
		userCredentialSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new userCredentialSoap[models.length][models[0].length];
		}
		else {
			soapModels = new userCredentialSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static userCredentialSoap[] toSoapModels(List<userCredential> models) {
		List<userCredentialSoap> soapModels = new ArrayList<userCredentialSoap>(models.size());

		for (userCredential model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new userCredentialSoap[soapModels.size()]);
	}

	public userCredentialSoap() {
	}

	public long getPrimaryKey() {
		return _PK_userCredential;
	}

	public void setPrimaryKey(long pk) {
		setPK_userCredential(pk);
	}

	public long getPK_userCredential() {
		return _PK_userCredential;
	}

	public void setPK_userCredential(long PK_userCredential) {
		_PK_userCredential = PK_userCredential;
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

	public String getMembership1() {
		return _membership1;
	}

	public void setMembership1(String membership1) {
		_membership1 = membership1;
	}

	public String getMembership2() {
		return _membership2;
	}

	public void setMembership2(String membership2) {
		_membership2 = membership2;
	}

	public String getMembership3() {
		return _membership3;
	}

	public void setMembership3(String membership3) {
		_membership3 = membership3;
	}

	public String getMembership4() {
		return _membership4;
	}

	public void setMembership4(String membership4) {
		_membership4 = membership4;
	}

	public String getCertificate1() {
		return _certificate1;
	}

	public void setCertificate1(String certificate1) {
		_certificate1 = certificate1;
	}

	public String getCertificate2() {
		return _certificate2;
	}

	public void setCertificate2(String certificate2) {
		_certificate2 = certificate2;
	}

	public String getCertificate3() {
		return _certificate3;
	}

	public void setCertificate3(String certificate3) {
		_certificate3 = certificate3;
	}

	private long _PK_userCredential;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _membership1;
	private String _membership2;
	private String _membership3;
	private String _membership4;
	private String _certificate1;
	private String _certificate2;
	private String _certificate3;
}