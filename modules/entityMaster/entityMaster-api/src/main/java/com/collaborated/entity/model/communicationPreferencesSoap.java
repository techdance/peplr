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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.communicationPreferencesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.communicationPreferencesServiceSoap
 * @generated
 */
@ProviderType
public class communicationPreferencesSoap implements Serializable {
	public static communicationPreferencesSoap toSoapModel(
		communicationPreferences model) {
		communicationPreferencesSoap soapModel = new communicationPreferencesSoap();

		soapModel.setPK_communicationPreferences(model.getPK_communicationPreferences());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPrimaryLanguageId(model.getPrimaryLanguageId());
		soapModel.setPrimaryLanguageName(model.getPrimaryLanguageName());
		soapModel.setSecondaryLanguageId(model.getSecondaryLanguageId());
		soapModel.setSecondaryLanguageName(model.getSecondaryLanguageName());
		soapModel.setTertiaryLanguageId(model.getTertiaryLanguageId());
		soapModel.setTertiaryLanguageName(model.getTertiaryLanguageName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setWebsite(model.getWebsite());

		return soapModel;
	}

	public static communicationPreferencesSoap[] toSoapModels(
		communicationPreferences[] models) {
		communicationPreferencesSoap[] soapModels = new communicationPreferencesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static communicationPreferencesSoap[][] toSoapModels(
		communicationPreferences[][] models) {
		communicationPreferencesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new communicationPreferencesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new communicationPreferencesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static communicationPreferencesSoap[] toSoapModels(
		List<communicationPreferences> models) {
		List<communicationPreferencesSoap> soapModels = new ArrayList<communicationPreferencesSoap>(models.size());

		for (communicationPreferences model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new communicationPreferencesSoap[soapModels.size()]);
	}

	public communicationPreferencesSoap() {
	}

	public long getPrimaryKey() {
		return _PK_communicationPreferences;
	}

	public void setPrimaryKey(long pk) {
		setPK_communicationPreferences(pk);
	}

	public long getPK_communicationPreferences() {
		return _PK_communicationPreferences;
	}

	public void setPK_communicationPreferences(long PK_communicationPreferences) {
		_PK_communicationPreferences = PK_communicationPreferences;
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

	public long getPrimaryLanguageId() {
		return _primaryLanguageId;
	}

	public void setPrimaryLanguageId(long primaryLanguageId) {
		_primaryLanguageId = primaryLanguageId;
	}

	public String getPrimaryLanguageName() {
		return _primaryLanguageName;
	}

	public void setPrimaryLanguageName(String primaryLanguageName) {
		_primaryLanguageName = primaryLanguageName;
	}

	public long getSecondaryLanguageId() {
		return _secondaryLanguageId;
	}

	public void setSecondaryLanguageId(long secondaryLanguageId) {
		_secondaryLanguageId = secondaryLanguageId;
	}

	public String getSecondaryLanguageName() {
		return _secondaryLanguageName;
	}

	public void setSecondaryLanguageName(String secondaryLanguageName) {
		_secondaryLanguageName = secondaryLanguageName;
	}

	public long getTertiaryLanguageId() {
		return _tertiaryLanguageId;
	}

	public void setTertiaryLanguageId(long tertiaryLanguageId) {
		_tertiaryLanguageId = tertiaryLanguageId;
	}

	public String getTertiaryLanguageName() {
		return _tertiaryLanguageName;
	}

	public void setTertiaryLanguageName(String tertiaryLanguageName) {
		_tertiaryLanguageName = tertiaryLanguageName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public long getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	private long _PK_communicationPreferences;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _primaryLanguageId;
	private String _primaryLanguageName;
	private long _secondaryLanguageId;
	private String _secondaryLanguageName;
	private long _tertiaryLanguageId;
	private String _tertiaryLanguageName;
	private String _emailAddress;
	private long _phoneNumber;
	private String _website;
}