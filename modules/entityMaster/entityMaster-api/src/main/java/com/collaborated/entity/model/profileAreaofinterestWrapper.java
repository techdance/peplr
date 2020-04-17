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
		attributes.put("language", getLanguage());
		attributes.put("campus", getCampus());
		attributes.put("programLevel", getProgramLevel());
		attributes.put("programLength", getProgramLength());
		attributes.put("deliveryMethod", getDeliveryMethod());
		attributes.put("credits", getCredits());
		attributes.put("collaborationType", getCollaborationType());
		attributes.put("discipline1", getDiscipline1());
		attributes.put("discipline2", getDiscipline2());
		attributes.put("discipline3", getDiscipline3());
		attributes.put("location1", getLocation1());
		attributes.put("location2", getLocation2());
		attributes.put("location3", getLocation3());
		attributes.put("location4", getLocation4());
		attributes.put("rangerYearStart", getRangerYearStart());
		attributes.put("rangerYearEnd", getRangerYearEnd());
		attributes.put("rangerMonthStart", getRangerMonthStart());
		attributes.put("rangerMonthEnd", getRangerMonthEnd());

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

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
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

		String collaborationType = (String)attributes.get("collaborationType");

		if (collaborationType != null) {
			setCollaborationType(collaborationType);
		}

		String discipline1 = (String)attributes.get("discipline1");

		if (discipline1 != null) {
			setDiscipline1(discipline1);
		}

		String discipline2 = (String)attributes.get("discipline2");

		if (discipline2 != null) {
			setDiscipline2(discipline2);
		}

		String discipline3 = (String)attributes.get("discipline3");

		if (discipline3 != null) {
			setDiscipline3(discipline3);
		}

		String location1 = (String)attributes.get("location1");

		if (location1 != null) {
			setLocation1(location1);
		}

		String location2 = (String)attributes.get("location2");

		if (location2 != null) {
			setLocation2(location2);
		}

		String location3 = (String)attributes.get("location3");

		if (location3 != null) {
			setLocation3(location3);
		}

		String location4 = (String)attributes.get("location4");

		if (location4 != null) {
			setLocation4(location4);
		}

		Integer rangerYearStart = (Integer)attributes.get("rangerYearStart");

		if (rangerYearStart != null) {
			setRangerYearStart(rangerYearStart);
		}

		Integer rangerYearEnd = (Integer)attributes.get("rangerYearEnd");

		if (rangerYearEnd != null) {
			setRangerYearEnd(rangerYearEnd);
		}

		String rangerMonthStart = (String)attributes.get("rangerMonthStart");

		if (rangerMonthStart != null) {
			setRangerMonthStart(rangerMonthStart);
		}

		String rangerMonthEnd = (String)attributes.get("rangerMonthEnd");

		if (rangerMonthEnd != null) {
			setRangerMonthEnd(rangerMonthEnd);
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

	/**
	* Returns the ranger year end of this profile areaofinterest.
	*
	* @return the ranger year end of this profile areaofinterest
	*/
	@Override
	public int getRangerYearEnd() {
		return _profileAreaofinterest.getRangerYearEnd();
	}

	/**
	* Returns the ranger year start of this profile areaofinterest.
	*
	* @return the ranger year start of this profile areaofinterest
	*/
	@Override
	public int getRangerYearStart() {
		return _profileAreaofinterest.getRangerYearStart();
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
	* Returns the collaboration type of this profile areaofinterest.
	*
	* @return the collaboration type of this profile areaofinterest
	*/
	@Override
	public java.lang.String getCollaborationType() {
		return _profileAreaofinterest.getCollaborationType();
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
	* Returns the discipline1 of this profile areaofinterest.
	*
	* @return the discipline1 of this profile areaofinterest
	*/
	@Override
	public java.lang.String getDiscipline1() {
		return _profileAreaofinterest.getDiscipline1();
	}

	/**
	* Returns the discipline2 of this profile areaofinterest.
	*
	* @return the discipline2 of this profile areaofinterest
	*/
	@Override
	public java.lang.String getDiscipline2() {
		return _profileAreaofinterest.getDiscipline2();
	}

	/**
	* Returns the discipline3 of this profile areaofinterest.
	*
	* @return the discipline3 of this profile areaofinterest
	*/
	@Override
	public java.lang.String getDiscipline3() {
		return _profileAreaofinterest.getDiscipline3();
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
	* Returns the location1 of this profile areaofinterest.
	*
	* @return the location1 of this profile areaofinterest
	*/
	@Override
	public java.lang.String getLocation1() {
		return _profileAreaofinterest.getLocation1();
	}

	/**
	* Returns the location2 of this profile areaofinterest.
	*
	* @return the location2 of this profile areaofinterest
	*/
	@Override
	public java.lang.String getLocation2() {
		return _profileAreaofinterest.getLocation2();
	}

	/**
	* Returns the location3 of this profile areaofinterest.
	*
	* @return the location3 of this profile areaofinterest
	*/
	@Override
	public java.lang.String getLocation3() {
		return _profileAreaofinterest.getLocation3();
	}

	/**
	* Returns the location4 of this profile areaofinterest.
	*
	* @return the location4 of this profile areaofinterest
	*/
	@Override
	public java.lang.String getLocation4() {
		return _profileAreaofinterest.getLocation4();
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
	* Returns the ranger month end of this profile areaofinterest.
	*
	* @return the ranger month end of this profile areaofinterest
	*/
	@Override
	public java.lang.String getRangerMonthEnd() {
		return _profileAreaofinterest.getRangerMonthEnd();
	}

	/**
	* Returns the ranger month start of this profile areaofinterest.
	*
	* @return the ranger month start of this profile areaofinterest
	*/
	@Override
	public java.lang.String getRangerMonthStart() {
		return _profileAreaofinterest.getRangerMonthStart();
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
	* Sets the collaboration type of this profile areaofinterest.
	*
	* @param collaborationType the collaboration type of this profile areaofinterest
	*/
	@Override
	public void setCollaborationType(java.lang.String collaborationType) {
		_profileAreaofinterest.setCollaborationType(collaborationType);
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
	* Sets the discipline1 of this profile areaofinterest.
	*
	* @param discipline1 the discipline1 of this profile areaofinterest
	*/
	@Override
	public void setDiscipline1(java.lang.String discipline1) {
		_profileAreaofinterest.setDiscipline1(discipline1);
	}

	/**
	* Sets the discipline2 of this profile areaofinterest.
	*
	* @param discipline2 the discipline2 of this profile areaofinterest
	*/
	@Override
	public void setDiscipline2(java.lang.String discipline2) {
		_profileAreaofinterest.setDiscipline2(discipline2);
	}

	/**
	* Sets the discipline3 of this profile areaofinterest.
	*
	* @param discipline3 the discipline3 of this profile areaofinterest
	*/
	@Override
	public void setDiscipline3(java.lang.String discipline3) {
		_profileAreaofinterest.setDiscipline3(discipline3);
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
	* Sets the location1 of this profile areaofinterest.
	*
	* @param location1 the location1 of this profile areaofinterest
	*/
	@Override
	public void setLocation1(java.lang.String location1) {
		_profileAreaofinterest.setLocation1(location1);
	}

	/**
	* Sets the location2 of this profile areaofinterest.
	*
	* @param location2 the location2 of this profile areaofinterest
	*/
	@Override
	public void setLocation2(java.lang.String location2) {
		_profileAreaofinterest.setLocation2(location2);
	}

	/**
	* Sets the location3 of this profile areaofinterest.
	*
	* @param location3 the location3 of this profile areaofinterest
	*/
	@Override
	public void setLocation3(java.lang.String location3) {
		_profileAreaofinterest.setLocation3(location3);
	}

	/**
	* Sets the location4 of this profile areaofinterest.
	*
	* @param location4 the location4 of this profile areaofinterest
	*/
	@Override
	public void setLocation4(java.lang.String location4) {
		_profileAreaofinterest.setLocation4(location4);
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
	* Sets the ranger month end of this profile areaofinterest.
	*
	* @param rangerMonthEnd the ranger month end of this profile areaofinterest
	*/
	@Override
	public void setRangerMonthEnd(java.lang.String rangerMonthEnd) {
		_profileAreaofinterest.setRangerMonthEnd(rangerMonthEnd);
	}

	/**
	* Sets the ranger month start of this profile areaofinterest.
	*
	* @param rangerMonthStart the ranger month start of this profile areaofinterest
	*/
	@Override
	public void setRangerMonthStart(java.lang.String rangerMonthStart) {
		_profileAreaofinterest.setRangerMonthStart(rangerMonthStart);
	}

	/**
	* Sets the ranger year end of this profile areaofinterest.
	*
	* @param rangerYearEnd the ranger year end of this profile areaofinterest
	*/
	@Override
	public void setRangerYearEnd(int rangerYearEnd) {
		_profileAreaofinterest.setRangerYearEnd(rangerYearEnd);
	}

	/**
	* Sets the ranger year start of this profile areaofinterest.
	*
	* @param rangerYearStart the ranger year start of this profile areaofinterest
	*/
	@Override
	public void setRangerYearStart(int rangerYearStart) {
		_profileAreaofinterest.setRangerYearStart(rangerYearStart);
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