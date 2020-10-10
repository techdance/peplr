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
 * This class is a wrapper for {@link labDetailedInstructorQualification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedInstructorQualification
 * @generated
 */
@ProviderType
public class labDetailedInstructorQualificationWrapper
	implements labDetailedInstructorQualification,
		ModelWrapper<labDetailedInstructorQualification> {
	public labDetailedInstructorQualificationWrapper(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		_labDetailedInstructorQualification = labDetailedInstructorQualification;
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedInstructorQualification.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedInstructorQualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseInstructorQualificationId",
			getPK_courseInstructorQualificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("instructor1Qualification", getInstructor1Qualification());
		attributes.put("instructor2Qualification", getInstructor2Qualification());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseInstructorQualificationId = (Long)attributes.get(
				"PK_courseInstructorQualificationId");

		if (PK_courseInstructorQualificationId != null) {
			setPK_courseInstructorQualificationId(PK_courseInstructorQualificationId);
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

		Long PK_projectId = (Long)attributes.get("PK_projectId");

		if (PK_projectId != null) {
			setPK_projectId(PK_projectId);
		}

		Long PK_courseId = (Long)attributes.get("PK_courseId");

		if (PK_courseId != null) {
			setPK_courseId(PK_courseId);
		}

		String instructor1Qualification = (String)attributes.get(
				"instructor1Qualification");

		if (instructor1Qualification != null) {
			setInstructor1Qualification(instructor1Qualification);
		}

		String instructor2Qualification = (String)attributes.get(
				"instructor2Qualification");

		if (instructor2Qualification != null) {
			setInstructor2Qualification(instructor2Qualification);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labDetailedInstructorQualification.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labDetailedInstructorQualification.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labDetailedInstructorQualification.isNew();
	}

	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification toEscapedModel() {
		return new labDetailedInstructorQualificationWrapper(_labDetailedInstructorQualification.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification toUnescapedModel() {
		return new labDetailedInstructorQualificationWrapper(_labDetailedInstructorQualification.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labDetailedInstructorQualification.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labDetailedInstructorQualification> toCacheModel() {
		return _labDetailedInstructorQualification.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labDetailedInstructorQualification labDetailedInstructorQualification) {
		return _labDetailedInstructorQualification.compareTo(labDetailedInstructorQualification);
	}

	@Override
	public int hashCode() {
		return _labDetailedInstructorQualification.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labDetailedInstructorQualification.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labDetailedInstructorQualificationWrapper((labDetailedInstructorQualification)_labDetailedInstructorQualification.clone());
	}

	/**
	* Returns the instructor1 qualification of this lab detailed instructor qualification.
	*
	* @return the instructor1 qualification of this lab detailed instructor qualification
	*/
	@Override
	public java.lang.String getInstructor1Qualification() {
		return _labDetailedInstructorQualification.getInstructor1Qualification();
	}

	/**
	* Returns the instructor2 qualification of this lab detailed instructor qualification.
	*
	* @return the instructor2 qualification of this lab detailed instructor qualification
	*/
	@Override
	public java.lang.String getInstructor2Qualification() {
		return _labDetailedInstructorQualification.getInstructor2Qualification();
	}

	/**
	* Returns the user uuid of this lab detailed instructor qualification.
	*
	* @return the user uuid of this lab detailed instructor qualification
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labDetailedInstructorQualification.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labDetailedInstructorQualification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labDetailedInstructorQualification.toXmlString();
	}

	/**
	* Returns the create date of this lab detailed instructor qualification.
	*
	* @return the create date of this lab detailed instructor qualification
	*/
	@Override
	public Date getCreateDate() {
		return _labDetailedInstructorQualification.getCreateDate();
	}

	/**
	* Returns the modified date of this lab detailed instructor qualification.
	*
	* @return the modified date of this lab detailed instructor qualification
	*/
	@Override
	public Date getModifiedDate() {
		return _labDetailedInstructorQualification.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab detailed instructor qualification.
	*
	* @return the group ID of this lab detailed instructor qualification
	*/
	@Override
	public long getGroupId() {
		return _labDetailedInstructorQualification.getGroupId();
	}

	/**
	* Returns the p k_course ID of this lab detailed instructor qualification.
	*
	* @return the p k_course ID of this lab detailed instructor qualification
	*/
	@Override
	public long getPK_courseId() {
		return _labDetailedInstructorQualification.getPK_courseId();
	}

	/**
	* Returns the p k_course instructor qualification ID of this lab detailed instructor qualification.
	*
	* @return the p k_course instructor qualification ID of this lab detailed instructor qualification
	*/
	@Override
	public long getPK_courseInstructorQualificationId() {
		return _labDetailedInstructorQualification.getPK_courseInstructorQualificationId();
	}

	/**
	* Returns the p k_project ID of this lab detailed instructor qualification.
	*
	* @return the p k_project ID of this lab detailed instructor qualification
	*/
	@Override
	public long getPK_projectId() {
		return _labDetailedInstructorQualification.getPK_projectId();
	}

	/**
	* Returns the primary key of this lab detailed instructor qualification.
	*
	* @return the primary key of this lab detailed instructor qualification
	*/
	@Override
	public long getPrimaryKey() {
		return _labDetailedInstructorQualification.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lab detailed instructor qualification.
	*
	* @return the user ID of this lab detailed instructor qualification
	*/
	@Override
	public long getUserId() {
		return _labDetailedInstructorQualification.getUserId();
	}

	@Override
	public void persist() {
		_labDetailedInstructorQualification.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labDetailedInstructorQualification.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this lab detailed instructor qualification.
	*
	* @param createDate the create date of this lab detailed instructor qualification
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labDetailedInstructorQualification.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labDetailedInstructorQualification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labDetailedInstructorQualification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labDetailedInstructorQualification.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab detailed instructor qualification.
	*
	* @param groupId the group ID of this lab detailed instructor qualification
	*/
	@Override
	public void setGroupId(long groupId) {
		_labDetailedInstructorQualification.setGroupId(groupId);
	}

	/**
	* Sets the instructor1 qualification of this lab detailed instructor qualification.
	*
	* @param instructor1Qualification the instructor1 qualification of this lab detailed instructor qualification
	*/
	@Override
	public void setInstructor1Qualification(
		java.lang.String instructor1Qualification) {
		_labDetailedInstructorQualification.setInstructor1Qualification(instructor1Qualification);
	}

	/**
	* Sets the instructor2 qualification of this lab detailed instructor qualification.
	*
	* @param instructor2Qualification the instructor2 qualification of this lab detailed instructor qualification
	*/
	@Override
	public void setInstructor2Qualification(
		java.lang.String instructor2Qualification) {
		_labDetailedInstructorQualification.setInstructor2Qualification(instructor2Qualification);
	}

	/**
	* Sets the modified date of this lab detailed instructor qualification.
	*
	* @param modifiedDate the modified date of this lab detailed instructor qualification
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labDetailedInstructorQualification.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labDetailedInstructorQualification.setNew(n);
	}

	/**
	* Sets the p k_course ID of this lab detailed instructor qualification.
	*
	* @param PK_courseId the p k_course ID of this lab detailed instructor qualification
	*/
	@Override
	public void setPK_courseId(long PK_courseId) {
		_labDetailedInstructorQualification.setPK_courseId(PK_courseId);
	}

	/**
	* Sets the p k_course instructor qualification ID of this lab detailed instructor qualification.
	*
	* @param PK_courseInstructorQualificationId the p k_course instructor qualification ID of this lab detailed instructor qualification
	*/
	@Override
	public void setPK_courseInstructorQualificationId(
		long PK_courseInstructorQualificationId) {
		_labDetailedInstructorQualification.setPK_courseInstructorQualificationId(PK_courseInstructorQualificationId);
	}

	/**
	* Sets the p k_project ID of this lab detailed instructor qualification.
	*
	* @param PK_projectId the p k_project ID of this lab detailed instructor qualification
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labDetailedInstructorQualification.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the primary key of this lab detailed instructor qualification.
	*
	* @param primaryKey the primary key of this lab detailed instructor qualification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labDetailedInstructorQualification.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labDetailedInstructorQualification.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this lab detailed instructor qualification.
	*
	* @param userId the user ID of this lab detailed instructor qualification
	*/
	@Override
	public void setUserId(long userId) {
		_labDetailedInstructorQualification.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab detailed instructor qualification.
	*
	* @param userUuid the user uuid of this lab detailed instructor qualification
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labDetailedInstructorQualification.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedInstructorQualificationWrapper)) {
			return false;
		}

		labDetailedInstructorQualificationWrapper labDetailedInstructorQualificationWrapper =
			(labDetailedInstructorQualificationWrapper)obj;

		if (Objects.equals(_labDetailedInstructorQualification,
					labDetailedInstructorQualificationWrapper._labDetailedInstructorQualification)) {
			return true;
		}

		return false;
	}

	@Override
	public labDetailedInstructorQualification getWrappedModel() {
		return _labDetailedInstructorQualification;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labDetailedInstructorQualification.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labDetailedInstructorQualification.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labDetailedInstructorQualification.resetOriginalValues();
	}

	private final labDetailedInstructorQualification _labDetailedInstructorQualification;
}