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
 * This class is a wrapper for {@link labDetailedCourseIdentification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseIdentification
 * @generated
 */
@ProviderType
public class labDetailedCourseIdentificationWrapper
	implements labDetailedCourseIdentification,
		ModelWrapper<labDetailedCourseIdentification> {
	public labDetailedCourseIdentificationWrapper(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		_labDetailedCourseIdentification = labDetailedCourseIdentification;
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedCourseIdentification.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedCourseIdentification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("courseTitle", getCourseTitle());
		attributes.put("courseNumber", getCourseNumber());
		attributes.put("prerequisites", getPrerequisites());
		attributes.put("courseDescription", getCourseDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseId = (Long)attributes.get("PK_courseId");

		if (PK_courseId != null) {
			setPK_courseId(PK_courseId);
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

		String courseTitle = (String)attributes.get("courseTitle");

		if (courseTitle != null) {
			setCourseTitle(courseTitle);
		}

		String courseNumber = (String)attributes.get("courseNumber");

		if (courseNumber != null) {
			setCourseNumber(courseNumber);
		}

		String prerequisites = (String)attributes.get("prerequisites");

		if (prerequisites != null) {
			setPrerequisites(prerequisites);
		}

		String courseDescription = (String)attributes.get("courseDescription");

		if (courseDescription != null) {
			setCourseDescription(courseDescription);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labDetailedCourseIdentification.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labDetailedCourseIdentification.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labDetailedCourseIdentification.isNew();
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseIdentification toEscapedModel() {
		return new labDetailedCourseIdentificationWrapper(_labDetailedCourseIdentification.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseIdentification toUnescapedModel() {
		return new labDetailedCourseIdentificationWrapper(_labDetailedCourseIdentification.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labDetailedCourseIdentification.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labDetailedCourseIdentification> toCacheModel() {
		return _labDetailedCourseIdentification.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labDetailedCourseIdentification labDetailedCourseIdentification) {
		return _labDetailedCourseIdentification.compareTo(labDetailedCourseIdentification);
	}

	@Override
	public int hashCode() {
		return _labDetailedCourseIdentification.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labDetailedCourseIdentification.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labDetailedCourseIdentificationWrapper((labDetailedCourseIdentification)_labDetailedCourseIdentification.clone());
	}

	/**
	* Returns the course description of this lab detailed course identification.
	*
	* @return the course description of this lab detailed course identification
	*/
	@Override
	public java.lang.String getCourseDescription() {
		return _labDetailedCourseIdentification.getCourseDescription();
	}

	/**
	* Returns the course number of this lab detailed course identification.
	*
	* @return the course number of this lab detailed course identification
	*/
	@Override
	public java.lang.String getCourseNumber() {
		return _labDetailedCourseIdentification.getCourseNumber();
	}

	/**
	* Returns the course title of this lab detailed course identification.
	*
	* @return the course title of this lab detailed course identification
	*/
	@Override
	public java.lang.String getCourseTitle() {
		return _labDetailedCourseIdentification.getCourseTitle();
	}

	/**
	* Returns the prerequisites of this lab detailed course identification.
	*
	* @return the prerequisites of this lab detailed course identification
	*/
	@Override
	public java.lang.String getPrerequisites() {
		return _labDetailedCourseIdentification.getPrerequisites();
	}

	/**
	* Returns the user uuid of this lab detailed course identification.
	*
	* @return the user uuid of this lab detailed course identification
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labDetailedCourseIdentification.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labDetailedCourseIdentification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labDetailedCourseIdentification.toXmlString();
	}

	/**
	* Returns the create date of this lab detailed course identification.
	*
	* @return the create date of this lab detailed course identification
	*/
	@Override
	public Date getCreateDate() {
		return _labDetailedCourseIdentification.getCreateDate();
	}

	/**
	* Returns the modified date of this lab detailed course identification.
	*
	* @return the modified date of this lab detailed course identification
	*/
	@Override
	public Date getModifiedDate() {
		return _labDetailedCourseIdentification.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab detailed course identification.
	*
	* @return the group ID of this lab detailed course identification
	*/
	@Override
	public long getGroupId() {
		return _labDetailedCourseIdentification.getGroupId();
	}

	/**
	* Returns the p k_course ID of this lab detailed course identification.
	*
	* @return the p k_course ID of this lab detailed course identification
	*/
	@Override
	public long getPK_courseId() {
		return _labDetailedCourseIdentification.getPK_courseId();
	}

	/**
	* Returns the p k_project ID of this lab detailed course identification.
	*
	* @return the p k_project ID of this lab detailed course identification
	*/
	@Override
	public long getPK_projectId() {
		return _labDetailedCourseIdentification.getPK_projectId();
	}

	/**
	* Returns the primary key of this lab detailed course identification.
	*
	* @return the primary key of this lab detailed course identification
	*/
	@Override
	public long getPrimaryKey() {
		return _labDetailedCourseIdentification.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lab detailed course identification.
	*
	* @return the user ID of this lab detailed course identification
	*/
	@Override
	public long getUserId() {
		return _labDetailedCourseIdentification.getUserId();
	}

	@Override
	public void persist() {
		_labDetailedCourseIdentification.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labDetailedCourseIdentification.setCachedModel(cachedModel);
	}

	/**
	* Sets the course description of this lab detailed course identification.
	*
	* @param courseDescription the course description of this lab detailed course identification
	*/
	@Override
	public void setCourseDescription(java.lang.String courseDescription) {
		_labDetailedCourseIdentification.setCourseDescription(courseDescription);
	}

	/**
	* Sets the course number of this lab detailed course identification.
	*
	* @param courseNumber the course number of this lab detailed course identification
	*/
	@Override
	public void setCourseNumber(java.lang.String courseNumber) {
		_labDetailedCourseIdentification.setCourseNumber(courseNumber);
	}

	/**
	* Sets the course title of this lab detailed course identification.
	*
	* @param courseTitle the course title of this lab detailed course identification
	*/
	@Override
	public void setCourseTitle(java.lang.String courseTitle) {
		_labDetailedCourseIdentification.setCourseTitle(courseTitle);
	}

	/**
	* Sets the create date of this lab detailed course identification.
	*
	* @param createDate the create date of this lab detailed course identification
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labDetailedCourseIdentification.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labDetailedCourseIdentification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labDetailedCourseIdentification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labDetailedCourseIdentification.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab detailed course identification.
	*
	* @param groupId the group ID of this lab detailed course identification
	*/
	@Override
	public void setGroupId(long groupId) {
		_labDetailedCourseIdentification.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this lab detailed course identification.
	*
	* @param modifiedDate the modified date of this lab detailed course identification
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labDetailedCourseIdentification.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labDetailedCourseIdentification.setNew(n);
	}

	/**
	* Sets the p k_course ID of this lab detailed course identification.
	*
	* @param PK_courseId the p k_course ID of this lab detailed course identification
	*/
	@Override
	public void setPK_courseId(long PK_courseId) {
		_labDetailedCourseIdentification.setPK_courseId(PK_courseId);
	}

	/**
	* Sets the p k_project ID of this lab detailed course identification.
	*
	* @param PK_projectId the p k_project ID of this lab detailed course identification
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labDetailedCourseIdentification.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the prerequisites of this lab detailed course identification.
	*
	* @param prerequisites the prerequisites of this lab detailed course identification
	*/
	@Override
	public void setPrerequisites(java.lang.String prerequisites) {
		_labDetailedCourseIdentification.setPrerequisites(prerequisites);
	}

	/**
	* Sets the primary key of this lab detailed course identification.
	*
	* @param primaryKey the primary key of this lab detailed course identification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labDetailedCourseIdentification.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labDetailedCourseIdentification.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this lab detailed course identification.
	*
	* @param userId the user ID of this lab detailed course identification
	*/
	@Override
	public void setUserId(long userId) {
		_labDetailedCourseIdentification.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab detailed course identification.
	*
	* @param userUuid the user uuid of this lab detailed course identification
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labDetailedCourseIdentification.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseIdentificationWrapper)) {
			return false;
		}

		labDetailedCourseIdentificationWrapper labDetailedCourseIdentificationWrapper =
			(labDetailedCourseIdentificationWrapper)obj;

		if (Objects.equals(_labDetailedCourseIdentification,
					labDetailedCourseIdentificationWrapper._labDetailedCourseIdentification)) {
			return true;
		}

		return false;
	}

	@Override
	public labDetailedCourseIdentification getWrappedModel() {
		return _labDetailedCourseIdentification;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labDetailedCourseIdentification.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labDetailedCourseIdentification.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labDetailedCourseIdentification.resetOriginalValues();
	}

	private final labDetailedCourseIdentification _labDetailedCourseIdentification;
}