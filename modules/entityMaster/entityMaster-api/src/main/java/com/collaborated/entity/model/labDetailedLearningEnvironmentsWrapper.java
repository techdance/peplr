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
 * This class is a wrapper for {@link labDetailedLearningEnvironments}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedLearningEnvironments
 * @generated
 */
@ProviderType
public class labDetailedLearningEnvironmentsWrapper
	implements labDetailedLearningEnvironments,
		ModelWrapper<labDetailedLearningEnvironments> {
	public labDetailedLearningEnvironmentsWrapper(
		labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		_labDetailedLearningEnvironments = labDetailedLearningEnvironments;
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedLearningEnvironments.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedLearningEnvironments.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_learningEnvironmentId", getPK_learningEnvironmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("learningEnvironment", getLearningEnvironment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_learningEnvironmentId = (Long)attributes.get(
				"PK_learningEnvironmentId");

		if (PK_learningEnvironmentId != null) {
			setPK_learningEnvironmentId(PK_learningEnvironmentId);
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

		String learningEnvironment = (String)attributes.get(
				"learningEnvironment");

		if (learningEnvironment != null) {
			setLearningEnvironment(learningEnvironment);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labDetailedLearningEnvironments.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labDetailedLearningEnvironments.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labDetailedLearningEnvironments.isNew();
	}

	@Override
	public com.collaborated.entity.model.labDetailedLearningEnvironments toEscapedModel() {
		return new labDetailedLearningEnvironmentsWrapper(_labDetailedLearningEnvironments.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labDetailedLearningEnvironments toUnescapedModel() {
		return new labDetailedLearningEnvironmentsWrapper(_labDetailedLearningEnvironments.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labDetailedLearningEnvironments.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labDetailedLearningEnvironments> toCacheModel() {
		return _labDetailedLearningEnvironments.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		return _labDetailedLearningEnvironments.compareTo(labDetailedLearningEnvironments);
	}

	@Override
	public int hashCode() {
		return _labDetailedLearningEnvironments.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labDetailedLearningEnvironments.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labDetailedLearningEnvironmentsWrapper((labDetailedLearningEnvironments)_labDetailedLearningEnvironments.clone());
	}

	/**
	* Returns the learning environment of this lab detailed learning environments.
	*
	* @return the learning environment of this lab detailed learning environments
	*/
	@Override
	public java.lang.String getLearningEnvironment() {
		return _labDetailedLearningEnvironments.getLearningEnvironment();
	}

	/**
	* Returns the user uuid of this lab detailed learning environments.
	*
	* @return the user uuid of this lab detailed learning environments
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labDetailedLearningEnvironments.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labDetailedLearningEnvironments.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labDetailedLearningEnvironments.toXmlString();
	}

	/**
	* Returns the create date of this lab detailed learning environments.
	*
	* @return the create date of this lab detailed learning environments
	*/
	@Override
	public Date getCreateDate() {
		return _labDetailedLearningEnvironments.getCreateDate();
	}

	/**
	* Returns the modified date of this lab detailed learning environments.
	*
	* @return the modified date of this lab detailed learning environments
	*/
	@Override
	public Date getModifiedDate() {
		return _labDetailedLearningEnvironments.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab detailed learning environments.
	*
	* @return the group ID of this lab detailed learning environments
	*/
	@Override
	public long getGroupId() {
		return _labDetailedLearningEnvironments.getGroupId();
	}

	/**
	* Returns the p k_course ID of this lab detailed learning environments.
	*
	* @return the p k_course ID of this lab detailed learning environments
	*/
	@Override
	public long getPK_courseId() {
		return _labDetailedLearningEnvironments.getPK_courseId();
	}

	/**
	* Returns the p k_learning environment ID of this lab detailed learning environments.
	*
	* @return the p k_learning environment ID of this lab detailed learning environments
	*/
	@Override
	public long getPK_learningEnvironmentId() {
		return _labDetailedLearningEnvironments.getPK_learningEnvironmentId();
	}

	/**
	* Returns the p k_project ID of this lab detailed learning environments.
	*
	* @return the p k_project ID of this lab detailed learning environments
	*/
	@Override
	public long getPK_projectId() {
		return _labDetailedLearningEnvironments.getPK_projectId();
	}

	/**
	* Returns the primary key of this lab detailed learning environments.
	*
	* @return the primary key of this lab detailed learning environments
	*/
	@Override
	public long getPrimaryKey() {
		return _labDetailedLearningEnvironments.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lab detailed learning environments.
	*
	* @return the user ID of this lab detailed learning environments
	*/
	@Override
	public long getUserId() {
		return _labDetailedLearningEnvironments.getUserId();
	}

	@Override
	public void persist() {
		_labDetailedLearningEnvironments.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labDetailedLearningEnvironments.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this lab detailed learning environments.
	*
	* @param createDate the create date of this lab detailed learning environments
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labDetailedLearningEnvironments.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labDetailedLearningEnvironments.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labDetailedLearningEnvironments.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labDetailedLearningEnvironments.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab detailed learning environments.
	*
	* @param groupId the group ID of this lab detailed learning environments
	*/
	@Override
	public void setGroupId(long groupId) {
		_labDetailedLearningEnvironments.setGroupId(groupId);
	}

	/**
	* Sets the learning environment of this lab detailed learning environments.
	*
	* @param learningEnvironment the learning environment of this lab detailed learning environments
	*/
	@Override
	public void setLearningEnvironment(java.lang.String learningEnvironment) {
		_labDetailedLearningEnvironments.setLearningEnvironment(learningEnvironment);
	}

	/**
	* Sets the modified date of this lab detailed learning environments.
	*
	* @param modifiedDate the modified date of this lab detailed learning environments
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labDetailedLearningEnvironments.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labDetailedLearningEnvironments.setNew(n);
	}

	/**
	* Sets the p k_course ID of this lab detailed learning environments.
	*
	* @param PK_courseId the p k_course ID of this lab detailed learning environments
	*/
	@Override
	public void setPK_courseId(long PK_courseId) {
		_labDetailedLearningEnvironments.setPK_courseId(PK_courseId);
	}

	/**
	* Sets the p k_learning environment ID of this lab detailed learning environments.
	*
	* @param PK_learningEnvironmentId the p k_learning environment ID of this lab detailed learning environments
	*/
	@Override
	public void setPK_learningEnvironmentId(long PK_learningEnvironmentId) {
		_labDetailedLearningEnvironments.setPK_learningEnvironmentId(PK_learningEnvironmentId);
	}

	/**
	* Sets the p k_project ID of this lab detailed learning environments.
	*
	* @param PK_projectId the p k_project ID of this lab detailed learning environments
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labDetailedLearningEnvironments.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the primary key of this lab detailed learning environments.
	*
	* @param primaryKey the primary key of this lab detailed learning environments
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labDetailedLearningEnvironments.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labDetailedLearningEnvironments.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this lab detailed learning environments.
	*
	* @param userId the user ID of this lab detailed learning environments
	*/
	@Override
	public void setUserId(long userId) {
		_labDetailedLearningEnvironments.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab detailed learning environments.
	*
	* @param userUuid the user uuid of this lab detailed learning environments
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labDetailedLearningEnvironments.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedLearningEnvironmentsWrapper)) {
			return false;
		}

		labDetailedLearningEnvironmentsWrapper labDetailedLearningEnvironmentsWrapper =
			(labDetailedLearningEnvironmentsWrapper)obj;

		if (Objects.equals(_labDetailedLearningEnvironments,
					labDetailedLearningEnvironmentsWrapper._labDetailedLearningEnvironments)) {
			return true;
		}

		return false;
	}

	@Override
	public labDetailedLearningEnvironments getWrappedModel() {
		return _labDetailedLearningEnvironments;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labDetailedLearningEnvironments.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labDetailedLearningEnvironments.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labDetailedLearningEnvironments.resetOriginalValues();
	}

	private final labDetailedLearningEnvironments _labDetailedLearningEnvironments;
}