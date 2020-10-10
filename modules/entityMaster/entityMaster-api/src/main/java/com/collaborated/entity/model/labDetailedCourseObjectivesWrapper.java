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
 * This class is a wrapper for {@link labDetailedCourseObjectives}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseObjectives
 * @generated
 */
@ProviderType
public class labDetailedCourseObjectivesWrapper
	implements labDetailedCourseObjectives,
		ModelWrapper<labDetailedCourseObjectives> {
	public labDetailedCourseObjectivesWrapper(
		labDetailedCourseObjectives labDetailedCourseObjectives) {
		_labDetailedCourseObjectives = labDetailedCourseObjectives;
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedCourseObjectives.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedCourseObjectives.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseObjectivesId", getPK_courseObjectivesId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("courseObjective", getCourseObjective());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseObjectivesId = (Long)attributes.get(
				"PK_courseObjectivesId");

		if (PK_courseObjectivesId != null) {
			setPK_courseObjectivesId(PK_courseObjectivesId);
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

		String courseObjective = (String)attributes.get("courseObjective");

		if (courseObjective != null) {
			setCourseObjective(courseObjective);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labDetailedCourseObjectives.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labDetailedCourseObjectives.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labDetailedCourseObjectives.isNew();
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseObjectives toEscapedModel() {
		return new labDetailedCourseObjectivesWrapper(_labDetailedCourseObjectives.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseObjectives toUnescapedModel() {
		return new labDetailedCourseObjectivesWrapper(_labDetailedCourseObjectives.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labDetailedCourseObjectives.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labDetailedCourseObjectives> toCacheModel() {
		return _labDetailedCourseObjectives.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labDetailedCourseObjectives labDetailedCourseObjectives) {
		return _labDetailedCourseObjectives.compareTo(labDetailedCourseObjectives);
	}

	@Override
	public int hashCode() {
		return _labDetailedCourseObjectives.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labDetailedCourseObjectives.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labDetailedCourseObjectivesWrapper((labDetailedCourseObjectives)_labDetailedCourseObjectives.clone());
	}

	/**
	* Returns the course objective of this lab detailed course objectives.
	*
	* @return the course objective of this lab detailed course objectives
	*/
	@Override
	public java.lang.String getCourseObjective() {
		return _labDetailedCourseObjectives.getCourseObjective();
	}

	/**
	* Returns the user uuid of this lab detailed course objectives.
	*
	* @return the user uuid of this lab detailed course objectives
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labDetailedCourseObjectives.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labDetailedCourseObjectives.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labDetailedCourseObjectives.toXmlString();
	}

	/**
	* Returns the create date of this lab detailed course objectives.
	*
	* @return the create date of this lab detailed course objectives
	*/
	@Override
	public Date getCreateDate() {
		return _labDetailedCourseObjectives.getCreateDate();
	}

	/**
	* Returns the modified date of this lab detailed course objectives.
	*
	* @return the modified date of this lab detailed course objectives
	*/
	@Override
	public Date getModifiedDate() {
		return _labDetailedCourseObjectives.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab detailed course objectives.
	*
	* @return the group ID of this lab detailed course objectives
	*/
	@Override
	public long getGroupId() {
		return _labDetailedCourseObjectives.getGroupId();
	}

	/**
	* Returns the p k_course ID of this lab detailed course objectives.
	*
	* @return the p k_course ID of this lab detailed course objectives
	*/
	@Override
	public long getPK_courseId() {
		return _labDetailedCourseObjectives.getPK_courseId();
	}

	/**
	* Returns the p k_course objectives ID of this lab detailed course objectives.
	*
	* @return the p k_course objectives ID of this lab detailed course objectives
	*/
	@Override
	public long getPK_courseObjectivesId() {
		return _labDetailedCourseObjectives.getPK_courseObjectivesId();
	}

	/**
	* Returns the p k_project ID of this lab detailed course objectives.
	*
	* @return the p k_project ID of this lab detailed course objectives
	*/
	@Override
	public long getPK_projectId() {
		return _labDetailedCourseObjectives.getPK_projectId();
	}

	/**
	* Returns the primary key of this lab detailed course objectives.
	*
	* @return the primary key of this lab detailed course objectives
	*/
	@Override
	public long getPrimaryKey() {
		return _labDetailedCourseObjectives.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lab detailed course objectives.
	*
	* @return the user ID of this lab detailed course objectives
	*/
	@Override
	public long getUserId() {
		return _labDetailedCourseObjectives.getUserId();
	}

	@Override
	public void persist() {
		_labDetailedCourseObjectives.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labDetailedCourseObjectives.setCachedModel(cachedModel);
	}

	/**
	* Sets the course objective of this lab detailed course objectives.
	*
	* @param courseObjective the course objective of this lab detailed course objectives
	*/
	@Override
	public void setCourseObjective(java.lang.String courseObjective) {
		_labDetailedCourseObjectives.setCourseObjective(courseObjective);
	}

	/**
	* Sets the create date of this lab detailed course objectives.
	*
	* @param createDate the create date of this lab detailed course objectives
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labDetailedCourseObjectives.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labDetailedCourseObjectives.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labDetailedCourseObjectives.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labDetailedCourseObjectives.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab detailed course objectives.
	*
	* @param groupId the group ID of this lab detailed course objectives
	*/
	@Override
	public void setGroupId(long groupId) {
		_labDetailedCourseObjectives.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this lab detailed course objectives.
	*
	* @param modifiedDate the modified date of this lab detailed course objectives
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labDetailedCourseObjectives.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labDetailedCourseObjectives.setNew(n);
	}

	/**
	* Sets the p k_course ID of this lab detailed course objectives.
	*
	* @param PK_courseId the p k_course ID of this lab detailed course objectives
	*/
	@Override
	public void setPK_courseId(long PK_courseId) {
		_labDetailedCourseObjectives.setPK_courseId(PK_courseId);
	}

	/**
	* Sets the p k_course objectives ID of this lab detailed course objectives.
	*
	* @param PK_courseObjectivesId the p k_course objectives ID of this lab detailed course objectives
	*/
	@Override
	public void setPK_courseObjectivesId(long PK_courseObjectivesId) {
		_labDetailedCourseObjectives.setPK_courseObjectivesId(PK_courseObjectivesId);
	}

	/**
	* Sets the p k_project ID of this lab detailed course objectives.
	*
	* @param PK_projectId the p k_project ID of this lab detailed course objectives
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labDetailedCourseObjectives.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the primary key of this lab detailed course objectives.
	*
	* @param primaryKey the primary key of this lab detailed course objectives
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labDetailedCourseObjectives.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labDetailedCourseObjectives.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this lab detailed course objectives.
	*
	* @param userId the user ID of this lab detailed course objectives
	*/
	@Override
	public void setUserId(long userId) {
		_labDetailedCourseObjectives.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab detailed course objectives.
	*
	* @param userUuid the user uuid of this lab detailed course objectives
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labDetailedCourseObjectives.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseObjectivesWrapper)) {
			return false;
		}

		labDetailedCourseObjectivesWrapper labDetailedCourseObjectivesWrapper = (labDetailedCourseObjectivesWrapper)obj;

		if (Objects.equals(_labDetailedCourseObjectives,
					labDetailedCourseObjectivesWrapper._labDetailedCourseObjectives)) {
			return true;
		}

		return false;
	}

	@Override
	public labDetailedCourseObjectives getWrappedModel() {
		return _labDetailedCourseObjectives;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labDetailedCourseObjectives.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labDetailedCourseObjectives.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labDetailedCourseObjectives.resetOriginalValues();
	}

	private final labDetailedCourseObjectives _labDetailedCourseObjectives;
}