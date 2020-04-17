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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link languagePreferences}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see languagePreferences
 * @generated
 */
@ProviderType
public class languagePreferencesWrapper implements languagePreferences,
	ModelWrapper<languagePreferences> {
	public languagePreferencesWrapper(languagePreferences languagePreferences) {
		_languagePreferences = languagePreferences;
	}

	@Override
	public Class<?> getModelClass() {
		return languagePreferences.class;
	}

	@Override
	public String getModelClassName() {
		return languagePreferences.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_languagePreferences", getPK_languagePreferences());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("languageName", getLanguageName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_languagePreferences = (Long)attributes.get(
				"PK_languagePreferences");

		if (PK_languagePreferences != null) {
			setPK_languagePreferences(PK_languagePreferences);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String languageName = (String)attributes.get("languageName");

		if (languageName != null) {
			setLanguageName(languageName);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _languagePreferences.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _languagePreferences.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _languagePreferences.isNew();
	}

	@Override
	public com.collaborated.entity.model.languagePreferences toEscapedModel() {
		return new languagePreferencesWrapper(_languagePreferences.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.languagePreferences toUnescapedModel() {
		return new languagePreferencesWrapper(_languagePreferences.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _languagePreferences.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.languagePreferences> toCacheModel() {
		return _languagePreferences.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.languagePreferences languagePreferences) {
		return _languagePreferences.compareTo(languagePreferences);
	}

	@Override
	public int hashCode() {
		return _languagePreferences.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _languagePreferences.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new languagePreferencesWrapper((languagePreferences)_languagePreferences.clone());
	}

	/**
	* Returns the language name of this language preferences.
	*
	* @return the language name of this language preferences
	*/
	@Override
	public java.lang.String getLanguageName() {
		return _languagePreferences.getLanguageName();
	}

	/**
	* Returns the user uuid of this language preferences.
	*
	* @return the user uuid of this language preferences
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _languagePreferences.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _languagePreferences.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _languagePreferences.toXmlString();
	}

	/**
	* Returns the create date of this language preferences.
	*
	* @return the create date of this language preferences
	*/
	@Override
	public Date getCreateDate() {
		return _languagePreferences.getCreateDate();
	}

	/**
	* Returns the modified date of this language preferences.
	*
	* @return the modified date of this language preferences
	*/
	@Override
	public Date getModifiedDate() {
		return _languagePreferences.getModifiedDate();
	}

	/**
	* Returns the p k_language preferences of this language preferences.
	*
	* @return the p k_language preferences of this language preferences
	*/
	@Override
	public long getPK_languagePreferences() {
		return _languagePreferences.getPK_languagePreferences();
	}

	/**
	* Returns the primary key of this language preferences.
	*
	* @return the primary key of this language preferences
	*/
	@Override
	public long getPrimaryKey() {
		return _languagePreferences.getPrimaryKey();
	}

	/**
	* Returns the user ID of this language preferences.
	*
	* @return the user ID of this language preferences
	*/
	@Override
	public long getUserId() {
		return _languagePreferences.getUserId();
	}

	@Override
	public void persist() {
		_languagePreferences.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_languagePreferences.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this language preferences.
	*
	* @param createDate the create date of this language preferences
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_languagePreferences.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_languagePreferences.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_languagePreferences.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_languagePreferences.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the language name of this language preferences.
	*
	* @param languageName the language name of this language preferences
	*/
	@Override
	public void setLanguageName(java.lang.String languageName) {
		_languagePreferences.setLanguageName(languageName);
	}

	/**
	* Sets the modified date of this language preferences.
	*
	* @param modifiedDate the modified date of this language preferences
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_languagePreferences.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_languagePreferences.setNew(n);
	}

	/**
	* Sets the p k_language preferences of this language preferences.
	*
	* @param PK_languagePreferences the p k_language preferences of this language preferences
	*/
	@Override
	public void setPK_languagePreferences(long PK_languagePreferences) {
		_languagePreferences.setPK_languagePreferences(PK_languagePreferences);
	}

	/**
	* Sets the primary key of this language preferences.
	*
	* @param primaryKey the primary key of this language preferences
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_languagePreferences.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_languagePreferences.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this language preferences.
	*
	* @param userId the user ID of this language preferences
	*/
	@Override
	public void setUserId(long userId) {
		_languagePreferences.setUserId(userId);
	}

	/**
	* Sets the user uuid of this language preferences.
	*
	* @param userUuid the user uuid of this language preferences
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_languagePreferences.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof languagePreferencesWrapper)) {
			return false;
		}

		languagePreferencesWrapper languagePreferencesWrapper = (languagePreferencesWrapper)obj;

		if (Objects.equals(_languagePreferences,
					languagePreferencesWrapper._languagePreferences)) {
			return true;
		}

		return false;
	}

	@Override
	public languagePreferences getWrappedModel() {
		return _languagePreferences;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _languagePreferences.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _languagePreferences.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_languagePreferences.resetOriginalValues();
	}

	private final languagePreferences _languagePreferences;
}