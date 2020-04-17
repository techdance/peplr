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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.languagePreferencesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.languagePreferencesServiceSoap
 * @generated
 */
@ProviderType
public class languagePreferencesSoap implements Serializable {
	public static languagePreferencesSoap toSoapModel(languagePreferences model) {
		languagePreferencesSoap soapModel = new languagePreferencesSoap();

		soapModel.setPK_languagePreferences(model.getPK_languagePreferences());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLanguageName(model.getLanguageName());

		return soapModel;
	}

	public static languagePreferencesSoap[] toSoapModels(
		languagePreferences[] models) {
		languagePreferencesSoap[] soapModels = new languagePreferencesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static languagePreferencesSoap[][] toSoapModels(
		languagePreferences[][] models) {
		languagePreferencesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new languagePreferencesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new languagePreferencesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static languagePreferencesSoap[] toSoapModels(
		List<languagePreferences> models) {
		List<languagePreferencesSoap> soapModels = new ArrayList<languagePreferencesSoap>(models.size());

		for (languagePreferences model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new languagePreferencesSoap[soapModels.size()]);
	}

	public languagePreferencesSoap() {
	}

	public long getPrimaryKey() {
		return _PK_languagePreferences;
	}

	public void setPrimaryKey(long pk) {
		setPK_languagePreferences(pk);
	}

	public long getPK_languagePreferences() {
		return _PK_languagePreferences;
	}

	public void setPK_languagePreferences(long PK_languagePreferences) {
		_PK_languagePreferences = PK_languagePreferences;
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

	public String getLanguageName() {
		return _languageName;
	}

	public void setLanguageName(String languageName) {
		_languageName = languageName;
	}

	private long _PK_languagePreferences;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _languageName;
}