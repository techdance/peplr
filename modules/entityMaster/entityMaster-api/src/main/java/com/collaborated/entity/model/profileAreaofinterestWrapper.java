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
 * This class is a wrapper for {@link profileAreaofinterest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileAreaofinterest
 * @generated
 */
@ProviderType
public class profileAreaofinterestWrapper implements profileAreaofinterest,
	ModelWrapper<profileAreaofinterest> {
	public profileAreaofinterestWrapper(
		profileAreaofinterest profileAreaofinterest) {
		_profileAreaofinterest = profileAreaofinterest;
	}

	@Override
	public Class<?> getModelClass() {
		return profileAreaofinterest.class;
	}

	@Override
	public String getModelClassName() {
		return profileAreaofinterest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_areaofinterest", getPK_areaofinterest());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("projectType", getProjectType());
		attributes.put("description", getDescription());
		attributes.put("discipline", getDiscipline());
		attributes.put("language", getLanguage());
		attributes.put("location", getLocation());
		attributes.put("campus", getCampus());
		attributes.put("programLevel", getProgramLevel());
		attributes.put("programLength", getProgramLength());
		attributes.put("deliveryMethod", getDeliveryMethod());
		attributes.put("credits", getCredits());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_areaofinterest = (Long)attributes.get("PK_areaofinterest");

		if (PK_areaofinterest != null) {
			setPK_areaofinterest(PK_areaofinterest);
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

		String projectType = (String)attributes.get("projectType");

		if (projectType != null) {
			setProjectType(projectType);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String discipline = (String)attributes.get("discipline");

		if (discipline != null) {
			setDiscipline(discipline);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String campus = (String)attributes.get("campus");

		if (campus != null) {
			setCampus(campus);
		}

		String programLevel = (String)attributes.get("programLevel");

		if (programLevel != null) {
			setProgramLevel(programLevel);
		}

		String programLength = (String)attributes.get("programLength");

		if (programLength != null) {
			setProgramLength(programLength);
		}

		String deliveryMethod = (String)attributes.get("deliveryMethod");

		if (deliveryMethod != null) {
			setDeliveryMethod(deliveryMethod);
		}

		String credits = (String)attributes.get("credits");

		if (credits != null) {
			setCredits(credits);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _profileAreaofinterest.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _profileAreaofinterest.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _profileAreaofinterest.isNew();
	}

	@Override
	public com.collaborated.entity.model.profileAreaofinterest toEscapedModel() {
		return new profileAreaofinterestWrapper(_profileAreaofinterest.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.profileAreaofinterest toUnescapedModel() {
		return new profileAreaofinterestWrapper(_profileAreaofinterest.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _profileAreaofinterest.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.profileAreaofinterest> toCacheModel() {
		return _profileAreaofinterest.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.profileAreaofinterest profileAreaofinterest) {
		return _profileAreaofinterest.compareTo(profileAreaofinterest);
	}

	@Override
	public int hashCode() {
		return _profileAreaofinterest.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _profileAreaofinterest.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new profileAreaofinterestWrapper((profileAreaofinterest)_profileAreaofinterest.clone());
	}

	/**
	* Returns the campus of this profile areaofinterest.
	*
	* @return the campus of this profile areaofinterest
	*/
	@Override
	public java.lang.String getCampus() {
		return _profileAreaofinterest.getCampus();
	}

	/**
	* Returns the credits of this profile areaofinterest.
	*
	* @return the credits of this profile areaofinterest
	*/
	@Override
	public java.lang.String getCredits() {
		return _profileAreaofinterest.getCredits();
	}

	/**
	* Returns the delivery method of this profile areaofinterest.
	*
	* @return the delivery method of this profile areaofinterest
	*/
	@Override
	public java.lang.String getDeliveryMethod() {
		return _profileAreaofinterest.getDeliveryMethod();
	}

	/**
	* Returns the description of this profile areaofinterest.
	*
	* @return the description of this profile areaofinterest
	*/
	@Override
	public java.lang.String getDescription() {
		return _profileAreaofinterest.getDescription();
	}

	/**
	* Returns the discipline of this profile areaofinterest.
	*
	* @return the discipline of this profile areaofinterest
	*/
	@Override
	public java.lang.String getDiscipline() {
		return _profileAreaofinterest.getDiscipline();
	}

	/**
	* Returns the language of this profile areaofinterest.
	*
	* @return the language of this profile areaofinterest
	*/
	@Override
	public java.lang.String getLanguage() {
		return _profileAreaofinterest.getLanguage();
	}

	/**
	* Returns the location of this profile areaofinterest.
	*
	* @return the location of this profile areaofinterest
	*/
	@Override
	public java.lang.String getLocation() {
		return _profileAreaofinterest.getLocation();
	}

	/**
	* Returns the program length of this profile areaofinterest.
	*
	* @return the program length of this profile areaofinterest
	*/
	@Override
	public java.lang.String getProgramLength() {
		return _profileAreaofinterest.getProgramLength();
	}

	/**
	* Returns the program level of this profile areaofinterest.
	*
	* @return the program level of this profile areaofinterest
	*/
	@Override
	public java.lang.String getProgramLevel() {
		return _profileAreaofinterest.getProgramLevel();
	}

	/**
	* Returns the project type of this profile areaofinterest.
	*
	* @return the project type of this profile areaofinterest
	*/
	@Override
	public java.lang.String getProjectType() {
		return _profileAreaofinterest.getProjectType();
	}

	/**
	* Returns the user uuid of this profile areaofinterest.
	*
	* @return the user uuid of this profile areaofinterest
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _profileAreaofinterest.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _profileAreaofinterest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _profileAreaofinterest.toXmlString();
	}

	/**
	* Returns the create date of this profile areaofinterest.
	*
	* @return the create date of this profile areaofinterest
	*/
	@Override
	public Date getCreateDate() {
		return _profileAreaofinterest.getCreateDate();
	}

	/**
	* Returns the modified date of this profile areaofinterest.
	*
	* @return the modified date of this profile areaofinterest
	*/
	@Override
	public Date getModifiedDate() {
		return _profileAreaofinterest.getModifiedDate();
	}

	/**
	* Returns the group ID of this profile areaofinterest.
	*
	* @return the group ID of this profile areaofinterest
	*/
	@Override
	public long getGroupId() {
		return _profileAreaofinterest.getGroupId();
	}

	/**
	* Returns the p k_areaofinterest of this profile areaofinterest.
	*
	* @return the p k_areaofinterest of this profile areaofinterest
	*/
	@Override
	public long getPK_areaofinterest() {
		return _profileAreaofinterest.getPK_areaofinterest();
	}

	/**
	* Returns the primary key of this profile areaofinterest.
	*
	* @return the primary key of this profile areaofinterest
	*/
	@Override
	public long getPrimaryKey() {
		return _profileAreaofinterest.getPrimaryKey();
	}

	/**
	* Returns the user ID of this profile areaofinterest.
	*
	* @return the user ID of this profile areaofinterest
	*/
	@Override
	public long getUserId() {
		return _profileAreaofinterest.getUserId();
	}

	@Override
	public void persist() {
		_profileAreaofinterest.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_profileAreaofinterest.setCachedModel(cachedModel);
	}

	/**
	* Sets the campus of this profile areaofinterest.
	*
	* @param campus the campus of this profile areaofinterest
	*/
	@Override
	public void setCampus(java.lang.String campus) {
		_profileAreaofinterest.setCampus(campus);
	}

	/**
	* Sets the create date of this profile areaofinterest.
	*
	* @param createDate the create date of this profile areaofinterest
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_profileAreaofinterest.setCreateDate(createDate);
	}

	/**
	* Sets the credits of this profile areaofinterest.
	*
	* @param credits the credits of this profile areaofinterest
	*/
	@Override
	public void setCredits(java.lang.String credits) {
		_profileAreaofinterest.setCredits(credits);
	}

	/**
	* Sets the delivery method of this profile areaofinterest.
	*
	* @param deliveryMethod the delivery method of this profile areaofinterest
	*/
	@Override
	public void setDeliveryMethod(java.lang.String deliveryMethod) {
		_profileAreaofinterest.setDeliveryMethod(deliveryMethod);
	}

	/**
	* Sets the description of this profile areaofinterest.
	*
	* @param description the description of this profile areaofinterest
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_profileAreaofinterest.setDescription(description);
	}

	/**
	* Sets the discipline of this profile areaofinterest.
	*
	* @param discipline the discipline of this profile areaofinterest
	*/
	@Override
	public void setDiscipline(java.lang.String discipline) {
		_profileAreaofinterest.setDiscipline(discipline);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_profileAreaofinterest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_profileAreaofinterest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_profileAreaofinterest.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this profile areaofinterest.
	*
	* @param groupId the group ID of this profile areaofinterest
	*/
	@Override
	public void setGroupId(long groupId) {
		_profileAreaofinterest.setGroupId(groupId);
	}

	/**
	* Sets the language of this profile areaofinterest.
	*
	* @param language the language of this profile areaofinterest
	*/
	@Override
	public void setLanguage(java.lang.String language) {
		_profileAreaofinterest.setLanguage(language);
	}

	/**
	* Sets the location of this profile areaofinterest.
	*
	* @param location the location of this profile areaofinterest
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_profileAreaofinterest.setLocation(location);
	}

	/**
	* Sets the modified date of this profile areaofinterest.
	*
	* @param modifiedDate the modified date of this profile areaofinterest
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_profileAreaofinterest.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_profileAreaofinterest.setNew(n);
	}

	/**
	* Sets the p k_areaofinterest of this profile areaofinterest.
	*
	* @param PK_areaofinterest the p k_areaofinterest of this profile areaofinterest
	*/
	@Override
	public void setPK_areaofinterest(long PK_areaofinterest) {
		_profileAreaofinterest.setPK_areaofinterest(PK_areaofinterest);
	}

	/**
	* Sets the primary key of this profile areaofinterest.
	*
	* @param primaryKey the primary key of this profile areaofinterest
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_profileAreaofinterest.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_profileAreaofinterest.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the program length of this profile areaofinterest.
	*
	* @param programLength the program length of this profile areaofinterest
	*/
	@Override
	public void setProgramLength(java.lang.String programLength) {
		_profileAreaofinterest.setProgramLength(programLength);
	}

	/**
	* Sets the program level of this profile areaofinterest.
	*
	* @param programLevel the program level of this profile areaofinterest
	*/
	@Override
	public void setProgramLevel(java.lang.String programLevel) {
		_profileAreaofinterest.setProgramLevel(programLevel);
	}

	/**
	* Sets the project type of this profile areaofinterest.
	*
	* @param projectType the project type of this profile areaofinterest
	*/
	@Override
	public void setProjectType(java.lang.String projectType) {
		_profileAreaofinterest.setProjectType(projectType);
	}

	/**
	* Sets the user ID of this profile areaofinterest.
	*
	* @param userId the user ID of this profile areaofinterest
	*/
	@Override
	public void setUserId(long userId) {
		_profileAreaofinterest.setUserId(userId);
	}

	/**
	* Sets the user uuid of this profile areaofinterest.
	*
	* @param userUuid the user uuid of this profile areaofinterest
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_profileAreaofinterest.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof profileAreaofinterestWrapper)) {
			return false;
		}

		profileAreaofinterestWrapper profileAreaofinterestWrapper = (profileAreaofinterestWrapper)obj;

		if (Objects.equals(_profileAreaofinterest,
					profileAreaofinterestWrapper._profileAreaofinterest)) {
			return true;
		}

		return false;
	}

	@Override
	public profileAreaofinterest getWrappedModel() {
		return _profileAreaofinterest;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _profileAreaofinterest.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _profileAreaofinterest.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_profileAreaofinterest.resetOriginalValues();
	}

	private final profileAreaofinterest _profileAreaofinterest;
}