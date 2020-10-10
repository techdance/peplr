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
 * This class is a wrapper for {@link labDetailedCourseTopics}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseTopics
 * @generated
 */
@ProviderType
public class labDetailedCourseTopicsWrapper implements labDetailedCourseTopics,
	ModelWrapper<labDetailedCourseTopics> {
	public labDetailedCourseTopicsWrapper(
		labDetailedCourseTopics labDetailedCourseTopics) {
		_labDetailedCourseTopics = labDetailedCourseTopics;
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedCourseTopics.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedCourseTopics.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseTopicsId", getPK_courseTopicsId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("courseTopic", getCourseTopic());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseTopicsId = (Long)attributes.get("PK_courseTopicsId");

		if (PK_courseTopicsId != null) {
			setPK_courseTopicsId(PK_courseTopicsId);
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

		String courseTopic = (String)attributes.get("courseTopic");

		if (courseTopic != null) {
			setCourseTopic(courseTopic);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labDetailedCourseTopics.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labDetailedCourseTopics.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labDetailedCourseTopics.isNew();
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseTopics toEscapedModel() {
		return new labDetailedCourseTopicsWrapper(_labDetailedCourseTopics.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseTopics toUnescapedModel() {
		return new labDetailedCourseTopicsWrapper(_labDetailedCourseTopics.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labDetailedCourseTopics.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labDetailedCourseTopics> toCacheModel() {
		return _labDetailedCourseTopics.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labDetailedCourseTopics labDetailedCourseTopics) {
		return _labDetailedCourseTopics.compareTo(labDetailedCourseTopics);
	}

	@Override
	public int hashCode() {
		return _labDetailedCourseTopics.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labDetailedCourseTopics.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labDetailedCourseTopicsWrapper((labDetailedCourseTopics)_labDetailedCourseTopics.clone());
	}

	/**
	* Returns the course topic of this lab detailed course topics.
	*
	* @return the course topic of this lab detailed course topics
	*/
	@Override
	public java.lang.String getCourseTopic() {
		return _labDetailedCourseTopics.getCourseTopic();
	}

	/**
	* Returns the user uuid of this lab detailed course topics.
	*
	* @return the user uuid of this lab detailed course topics
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labDetailedCourseTopics.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labDetailedCourseTopics.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labDetailedCourseTopics.toXmlString();
	}

	/**
	* Returns the create date of this lab detailed course topics.
	*
	* @return the create date of this lab detailed course topics
	*/
	@Override
	public Date getCreateDate() {
		return _labDetailedCourseTopics.getCreateDate();
	}

	/**
	* Returns the modified date of this lab detailed course topics.
	*
	* @return the modified date of this lab detailed course topics
	*/
	@Override
	public Date getModifiedDate() {
		return _labDetailedCourseTopics.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab detailed course topics.
	*
	* @return the group ID of this lab detailed course topics
	*/
	@Override
	public long getGroupId() {
		return _labDetailedCourseTopics.getGroupId();
	}

	/**
	* Returns the p k_course ID of this lab detailed course topics.
	*
	* @return the p k_course ID of this lab detailed course topics
	*/
	@Override
	public long getPK_courseId() {
		return _labDetailedCourseTopics.getPK_courseId();
	}

	/**
	* Returns the p k_course topics ID of this lab detailed course topics.
	*
	* @return the p k_course topics ID of this lab detailed course topics
	*/
	@Override
	public long getPK_courseTopicsId() {
		return _labDetailedCourseTopics.getPK_courseTopicsId();
	}

	/**
	* Returns the p k_project ID of this lab detailed course topics.
	*
	* @return the p k_project ID of this lab detailed course topics
	*/
	@Override
	public long getPK_projectId() {
		return _labDetailedCourseTopics.getPK_projectId();
	}

	/**
	* Returns the primary key of this lab detailed course topics.
	*
	* @return the primary key of this lab detailed course topics
	*/
	@Override
	public long getPrimaryKey() {
		return _labDetailedCourseTopics.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lab detailed course topics.
	*
	* @return the user ID of this lab detailed course topics
	*/
	@Override
	public long getUserId() {
		return _labDetailedCourseTopics.getUserId();
	}

	@Override
	public void persist() {
		_labDetailedCourseTopics.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labDetailedCourseTopics.setCachedModel(cachedModel);
	}

	/**
	* Sets the course topic of this lab detailed course topics.
	*
	* @param courseTopic the course topic of this lab detailed course topics
	*/
	@Override
	public void setCourseTopic(java.lang.String courseTopic) {
		_labDetailedCourseTopics.setCourseTopic(courseTopic);
	}

	/**
	* Sets the create date of this lab detailed course topics.
	*
	* @param createDate the create date of this lab detailed course topics
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labDetailedCourseTopics.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labDetailedCourseTopics.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labDetailedCourseTopics.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labDetailedCourseTopics.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab detailed course topics.
	*
	* @param groupId the group ID of this lab detailed course topics
	*/
	@Override
	public void setGroupId(long groupId) {
		_labDetailedCourseTopics.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this lab detailed course topics.
	*
	* @param modifiedDate the modified date of this lab detailed course topics
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labDetailedCourseTopics.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labDetailedCourseTopics.setNew(n);
	}

	/**
	* Sets the p k_course ID of this lab detailed course topics.
	*
	* @param PK_courseId the p k_course ID of this lab detailed course topics
	*/
	@Override
	public void setPK_courseId(long PK_courseId) {
		_labDetailedCourseTopics.setPK_courseId(PK_courseId);
	}

	/**
	* Sets the p k_course topics ID of this lab detailed course topics.
	*
	* @param PK_courseTopicsId the p k_course topics ID of this lab detailed course topics
	*/
	@Override
	public void setPK_courseTopicsId(long PK_courseTopicsId) {
		_labDetailedCourseTopics.setPK_courseTopicsId(PK_courseTopicsId);
	}

	/**
	* Sets the p k_project ID of this lab detailed course topics.
	*
	* @param PK_projectId the p k_project ID of this lab detailed course topics
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labDetailedCourseTopics.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the primary key of this lab detailed course topics.
	*
	* @param primaryKey the primary key of this lab detailed course topics
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labDetailedCourseTopics.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labDetailedCourseTopics.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this lab detailed course topics.
	*
	* @param userId the user ID of this lab detailed course topics
	*/
	@Override
	public void setUserId(long userId) {
		_labDetailedCourseTopics.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab detailed course topics.
	*
	* @param userUuid the user uuid of this lab detailed course topics
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labDetailedCourseTopics.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseTopicsWrapper)) {
			return false;
		}

		labDetailedCourseTopicsWrapper labDetailedCourseTopicsWrapper = (labDetailedCourseTopicsWrapper)obj;

		if (Objects.equals(_labDetailedCourseTopics,
					labDetailedCourseTopicsWrapper._labDetailedCourseTopics)) {
			return true;
		}

		return false;
	}

	@Override
	public labDetailedCourseTopics getWrappedModel() {
		return _labDetailedCourseTopics;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labDetailedCourseTopics.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labDetailedCourseTopics.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labDetailedCourseTopics.resetOriginalValues();
	}

	private final labDetailedCourseTopics _labDetailedCourseTopics;
}