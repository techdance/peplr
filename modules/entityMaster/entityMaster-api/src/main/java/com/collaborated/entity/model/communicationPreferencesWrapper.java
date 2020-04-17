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
 * This class is a wrapper for {@link communicationPreferences}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see communicationPreferences
 * @generated
 */
@ProviderType
public class communicationPreferencesWrapper implements communicationPreferences,
	ModelWrapper<communicationPreferences> {
	public communicationPreferencesWrapper(
		communicationPreferences communicationPreferences) {
		_communicationPreferences = communicationPreferences;
	}

	@Override
	public Class<?> getModelClass() {
		return communicationPreferences.class;
	}

	@Override
	public String getModelClassName() {
		return communicationPreferences.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_communicationPreferences",
			getPK_communicationPreferences());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("primaryLanguageId", getPrimaryLanguageId());
		attributes.put("primaryLanguageName", getPrimaryLanguageName());
		attributes.put("secondaryLanguageId", getSecondaryLanguageId());
		attributes.put("secondaryLanguageName", getSecondaryLanguageName());
		attributes.put("tertiaryLanguageId", getTertiaryLanguageId());
		attributes.put("tertiaryLanguageName", getTertiaryLanguageName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("website", getWebsite());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_communicationPreferences = (Long)attributes.get(
				"PK_communicationPreferences");

		if (PK_communicationPreferences != null) {
			setPK_communicationPreferences(PK_communicationPreferences);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long primaryLanguageId = (Long)attributes.get("primaryLanguageId");

		if (primaryLanguageId != null) {
			setPrimaryLanguageId(primaryLanguageId);
		}

		String primaryLanguageName = (String)attributes.get(
				"primaryLanguageName");

		if (primaryLanguageName != null) {
			setPrimaryLanguageName(primaryLanguageName);
		}

		Long secondaryLanguageId = (Long)attributes.get("secondaryLanguageId");

		if (secondaryLanguageId != null) {
			setSecondaryLanguageId(secondaryLanguageId);
		}

		String secondaryLanguageName = (String)attributes.get(
				"secondaryLanguageName");

		if (secondaryLanguageName != null) {
			setSecondaryLanguageName(secondaryLanguageName);
		}

		Long tertiaryLanguageId = (Long)attributes.get("tertiaryLanguageId");

		if (tertiaryLanguageId != null) {
			setTertiaryLanguageId(tertiaryLanguageId);
		}

		String tertiaryLanguageName = (String)attributes.get(
				"tertiaryLanguageName");

		if (tertiaryLanguageName != null) {
			setTertiaryLanguageName(tertiaryLanguageName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _communicationPreferences.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _communicationPreferences.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _communicationPreferences.isNew();
	}

	@Override
	public com.collaborated.entity.model.communicationPreferences toEscapedModel() {
		return new communicationPreferencesWrapper(_communicationPreferences.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.communicationPreferences toUnescapedModel() {
		return new communicationPreferencesWrapper(_communicationPreferences.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _communicationPreferences.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.communicationPreferences> toCacheModel() {
		return _communicationPreferences.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.communicationPreferences communicationPreferences) {
		return _communicationPreferences.compareTo(communicationPreferences);
	}

	@Override
	public int hashCode() {
		return _communicationPreferences.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _communicationPreferences.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new communicationPreferencesWrapper((communicationPreferences)_communicationPreferences.clone());
	}

	/**
	* Returns the email address of this communication preferences.
	*
	* @return the email address of this communication preferences
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _communicationPreferences.getEmailAddress();
	}

	/**
	* Returns the phone number of this communication preferences.
	*
	* @return the phone number of this communication preferences
	*/
	@Override
	public java.lang.String getPhoneNumber() {
		return _communicationPreferences.getPhoneNumber();
	}

	/**
	* Returns the primary language name of this communication preferences.
	*
	* @return the primary language name of this communication preferences
	*/
	@Override
	public java.lang.String getPrimaryLanguageName() {
		return _communicationPreferences.getPrimaryLanguageName();
	}

	/**
	* Returns the secondary language name of this communication preferences.
	*
	* @return the secondary language name of this communication preferences
	*/
	@Override
	public java.lang.String getSecondaryLanguageName() {
		return _communicationPreferences.getSecondaryLanguageName();
	}

	/**
	* Returns the tertiary language name of this communication preferences.
	*
	* @return the tertiary language name of this communication preferences
	*/
	@Override
	public java.lang.String getTertiaryLanguageName() {
		return _communicationPreferences.getTertiaryLanguageName();
	}

	/**
	* Returns the user uuid of this communication preferences.
	*
	* @return the user uuid of this communication preferences
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _communicationPreferences.getUserUuid();
	}

	/**
	* Returns the website of this communication preferences.
	*
	* @return the website of this communication preferences
	*/
	@Override
	public java.lang.String getWebsite() {
		return _communicationPreferences.getWebsite();
	}

	@Override
	public java.lang.String toString() {
		return _communicationPreferences.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _communicationPreferences.toXmlString();
	}

	/**
	* Returns the create date of this communication preferences.
	*
	* @return the create date of this communication preferences
	*/
	@Override
	public Date getCreateDate() {
		return _communicationPreferences.getCreateDate();
	}

	/**
	* Returns the modified date of this communication preferences.
	*
	* @return the modified date of this communication preferences
	*/
	@Override
	public Date getModifiedDate() {
		return _communicationPreferences.getModifiedDate();
	}

	/**
	* Returns the group ID of this communication preferences.
	*
	* @return the group ID of this communication preferences
	*/
	@Override
	public long getGroupId() {
		return _communicationPreferences.getGroupId();
	}

	/**
	* Returns the p k_communication preferences of this communication preferences.
	*
	* @return the p k_communication preferences of this communication preferences
	*/
	@Override
	public long getPK_communicationPreferences() {
		return _communicationPreferences.getPK_communicationPreferences();
	}

	/**
	* Returns the primary key of this communication preferences.
	*
	* @return the primary key of this communication preferences
	*/
	@Override
	public long getPrimaryKey() {
		return _communicationPreferences.getPrimaryKey();
	}

	/**
	* Returns the primary language ID of this communication preferences.
	*
	* @return the primary language ID of this communication preferences
	*/
	@Override
	public long getPrimaryLanguageId() {
		return _communicationPreferences.getPrimaryLanguageId();
	}

	/**
	* Returns the secondary language ID of this communication preferences.
	*
	* @return the secondary language ID of this communication preferences
	*/
	@Override
	public long getSecondaryLanguageId() {
		return _communicationPreferences.getSecondaryLanguageId();
	}

	/**
	* Returns the tertiary language ID of this communication preferences.
	*
	* @return the tertiary language ID of this communication preferences
	*/
	@Override
	public long getTertiaryLanguageId() {
		return _communicationPreferences.getTertiaryLanguageId();
	}

	/**
	* Returns the user ID of this communication preferences.
	*
	* @return the user ID of this communication preferences
	*/
	@Override
	public long getUserId() {
		return _communicationPreferences.getUserId();
	}

	@Override
	public void persist() {
		_communicationPreferences.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_communicationPreferences.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this communication preferences.
	*
	* @param createDate the create date of this communication preferences
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_communicationPreferences.setCreateDate(createDate);
	}

	/**
	* Sets the email address of this communication preferences.
	*
	* @param emailAddress the email address of this communication preferences
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_communicationPreferences.setEmailAddress(emailAddress);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_communicationPreferences.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_communicationPreferences.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_communicationPreferences.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this communication preferences.
	*
	* @param groupId the group ID of this communication preferences
	*/
	@Override
	public void setGroupId(long groupId) {
		_communicationPreferences.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this communication preferences.
	*
	* @param modifiedDate the modified date of this communication preferences
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_communicationPreferences.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_communicationPreferences.setNew(n);
	}

	/**
	* Sets the p k_communication preferences of this communication preferences.
	*
	* @param PK_communicationPreferences the p k_communication preferences of this communication preferences
	*/
	@Override
	public void setPK_communicationPreferences(long PK_communicationPreferences) {
		_communicationPreferences.setPK_communicationPreferences(PK_communicationPreferences);
	}

	/**
	* Sets the phone number of this communication preferences.
	*
	* @param phoneNumber the phone number of this communication preferences
	*/
	@Override
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_communicationPreferences.setPhoneNumber(phoneNumber);
	}

	/**
	* Sets the primary key of this communication preferences.
	*
	* @param primaryKey the primary key of this communication preferences
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_communicationPreferences.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_communicationPreferences.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the primary language ID of this communication preferences.
	*
	* @param primaryLanguageId the primary language ID of this communication preferences
	*/
	@Override
	public void setPrimaryLanguageId(long primaryLanguageId) {
		_communicationPreferences.setPrimaryLanguageId(primaryLanguageId);
	}

	/**
	* Sets the primary language name of this communication preferences.
	*
	* @param primaryLanguageName the primary language name of this communication preferences
	*/
	@Override
	public void setPrimaryLanguageName(java.lang.String primaryLanguageName) {
		_communicationPreferences.setPrimaryLanguageName(primaryLanguageName);
	}

	/**
	* Sets the secondary language ID of this communication preferences.
	*
	* @param secondaryLanguageId the secondary language ID of this communication preferences
	*/
	@Override
	public void setSecondaryLanguageId(long secondaryLanguageId) {
		_communicationPreferences.setSecondaryLanguageId(secondaryLanguageId);
	}

	/**
	* Sets the secondary language name of this communication preferences.
	*
	* @param secondaryLanguageName the secondary language name of this communication preferences
	*/
	@Override
	public void setSecondaryLanguageName(java.lang.String secondaryLanguageName) {
		_communicationPreferences.setSecondaryLanguageName(secondaryLanguageName);
	}

	/**
	* Sets the tertiary language ID of this communication preferences.
	*
	* @param tertiaryLanguageId the tertiary language ID of this communication preferences
	*/
	@Override
	public void setTertiaryLanguageId(long tertiaryLanguageId) {
		_communicationPreferences.setTertiaryLanguageId(tertiaryLanguageId);
	}

	/**
	* Sets the tertiary language name of this communication preferences.
	*
	* @param tertiaryLanguageName the tertiary language name of this communication preferences
	*/
	@Override
	public void setTertiaryLanguageName(java.lang.String tertiaryLanguageName) {
		_communicationPreferences.setTertiaryLanguageName(tertiaryLanguageName);
	}

	/**
	* Sets the user ID of this communication preferences.
	*
	* @param userId the user ID of this communication preferences
	*/
	@Override
	public void setUserId(long userId) {
		_communicationPreferences.setUserId(userId);
	}

	/**
	* Sets the user uuid of this communication preferences.
	*
	* @param userUuid the user uuid of this communication preferences
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_communicationPreferences.setUserUuid(userUuid);
	}

	/**
	* Sets the website of this communication preferences.
	*
	* @param website the website of this communication preferences
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_communicationPreferences.setWebsite(website);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof communicationPreferencesWrapper)) {
			return false;
		}

		communicationPreferencesWrapper communicationPreferencesWrapper = (communicationPreferencesWrapper)obj;

		if (Objects.equals(_communicationPreferences,
					communicationPreferencesWrapper._communicationPreferences)) {
			return true;
		}

		return false;
	}

	@Override
	public communicationPreferences getWrappedModel() {
		return _communicationPreferences;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _communicationPreferences.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _communicationPreferences.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_communicationPreferences.resetOriginalValues();
	}

	private final communicationPreferences _communicationPreferences;
}