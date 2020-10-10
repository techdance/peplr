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
 * This class is a wrapper for {@link labDetailedActivityTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedActivityTable
 * @generated
 */
@ProviderType
public class labDetailedActivityTableWrapper implements labDetailedActivityTable,
	ModelWrapper<labDetailedActivityTable> {
	public labDetailedActivityTableWrapper(
		labDetailedActivityTable labDetailedActivityTable) {
		_labDetailedActivityTable = labDetailedActivityTable;
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedActivityTable.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedActivityTable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_activityTableId", getPK_activityTableId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("week", getWeek());
		attributes.put("courseObjective", getCourseObjective());
		attributes.put("learningEnvironmentDesign",
			getLearningEnvironmentDesign());
		attributes.put("activity", getActivity());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_activityTableId = (Long)attributes.get("PK_activityTableId");

		if (PK_activityTableId != null) {
			setPK_activityTableId(PK_activityTableId);
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

		Long week = (Long)attributes.get("week");

		if (week != null) {
			setWeek(week);
		}

		String courseObjective = (String)attributes.get("courseObjective");

		if (courseObjective != null) {
			setCourseObjective(courseObjective);
		}

		String learningEnvironmentDesign = (String)attributes.get(
				"learningEnvironmentDesign");

		if (learningEnvironmentDesign != null) {
			setLearningEnvironmentDesign(learningEnvironmentDesign);
		}

		String activity = (String)attributes.get("activity");

		if (activity != null) {
			setActivity(activity);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labDetailedActivityTable.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labDetailedActivityTable.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labDetailedActivityTable.isNew();
	}

	@Override
	public com.collaborated.entity.model.labDetailedActivityTable toEscapedModel() {
		return new labDetailedActivityTableWrapper(_labDetailedActivityTable.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labDetailedActivityTable toUnescapedModel() {
		return new labDetailedActivityTableWrapper(_labDetailedActivityTable.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labDetailedActivityTable.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labDetailedActivityTable> toCacheModel() {
		return _labDetailedActivityTable.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labDetailedActivityTable labDetailedActivityTable) {
		return _labDetailedActivityTable.compareTo(labDetailedActivityTable);
	}

	@Override
	public int hashCode() {
		return _labDetailedActivityTable.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labDetailedActivityTable.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labDetailedActivityTableWrapper((labDetailedActivityTable)_labDetailedActivityTable.clone());
	}

	/**
	* Returns the activity of this lab detailed activity table.
	*
	* @return the activity of this lab detailed activity table
	*/
	@Override
	public java.lang.String getActivity() {
		return _labDetailedActivityTable.getActivity();
	}

	/**
	* Returns the content of this lab detailed activity table.
	*
	* @return the content of this lab detailed activity table
	*/
	@Override
	public java.lang.String getContent() {
		return _labDetailedActivityTable.getContent();
	}

	/**
	* Returns the course objective of this lab detailed activity table.
	*
	* @return the course objective of this lab detailed activity table
	*/
	@Override
	public java.lang.String getCourseObjective() {
		return _labDetailedActivityTable.getCourseObjective();
	}

	/**
	* Returns the learning environment design of this lab detailed activity table.
	*
	* @return the learning environment design of this lab detailed activity table
	*/
	@Override
	public java.lang.String getLearningEnvironmentDesign() {
		return _labDetailedActivityTable.getLearningEnvironmentDesign();
	}

	/**
	* Returns the user uuid of this lab detailed activity table.
	*
	* @return the user uuid of this lab detailed activity table
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labDetailedActivityTable.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labDetailedActivityTable.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labDetailedActivityTable.toXmlString();
	}

	/**
	* Returns the create date of this lab detailed activity table.
	*
	* @return the create date of this lab detailed activity table
	*/
	@Override
	public Date getCreateDate() {
		return _labDetailedActivityTable.getCreateDate();
	}

	/**
	* Returns the modified date of this lab detailed activity table.
	*
	* @return the modified date of this lab detailed activity table
	*/
	@Override
	public Date getModifiedDate() {
		return _labDetailedActivityTable.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab detailed activity table.
	*
	* @return the group ID of this lab detailed activity table
	*/
	@Override
	public long getGroupId() {
		return _labDetailedActivityTable.getGroupId();
	}

	/**
	* Returns the p k_activity table ID of this lab detailed activity table.
	*
	* @return the p k_activity table ID of this lab detailed activity table
	*/
	@Override
	public long getPK_activityTableId() {
		return _labDetailedActivityTable.getPK_activityTableId();
	}

	/**
	* Returns the p k_course ID of this lab detailed activity table.
	*
	* @return the p k_course ID of this lab detailed activity table
	*/
	@Override
	public long getPK_courseId() {
		return _labDetailedActivityTable.getPK_courseId();
	}

	/**
	* Returns the p k_project ID of this lab detailed activity table.
	*
	* @return the p k_project ID of this lab detailed activity table
	*/
	@Override
	public long getPK_projectId() {
		return _labDetailedActivityTable.getPK_projectId();
	}

	/**
	* Returns the primary key of this lab detailed activity table.
	*
	* @return the primary key of this lab detailed activity table
	*/
	@Override
	public long getPrimaryKey() {
		return _labDetailedActivityTable.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lab detailed activity table.
	*
	* @return the user ID of this lab detailed activity table
	*/
	@Override
	public long getUserId() {
		return _labDetailedActivityTable.getUserId();
	}

	/**
	* Returns the week of this lab detailed activity table.
	*
	* @return the week of this lab detailed activity table
	*/
	@Override
	public long getWeek() {
		return _labDetailedActivityTable.getWeek();
	}

	@Override
	public void persist() {
		_labDetailedActivityTable.persist();
	}

	/**
	* Sets the activity of this lab detailed activity table.
	*
	* @param activity the activity of this lab detailed activity table
	*/
	@Override
	public void setActivity(java.lang.String activity) {
		_labDetailedActivityTable.setActivity(activity);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labDetailedActivityTable.setCachedModel(cachedModel);
	}

	/**
	* Sets the content of this lab detailed activity table.
	*
	* @param content the content of this lab detailed activity table
	*/
	@Override
	public void setContent(java.lang.String content) {
		_labDetailedActivityTable.setContent(content);
	}

	/**
	* Sets the course objective of this lab detailed activity table.
	*
	* @param courseObjective the course objective of this lab detailed activity table
	*/
	@Override
	public void setCourseObjective(java.lang.String courseObjective) {
		_labDetailedActivityTable.setCourseObjective(courseObjective);
	}

	/**
	* Sets the create date of this lab detailed activity table.
	*
	* @param createDate the create date of this lab detailed activity table
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labDetailedActivityTable.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labDetailedActivityTable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labDetailedActivityTable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labDetailedActivityTable.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab detailed activity table.
	*
	* @param groupId the group ID of this lab detailed activity table
	*/
	@Override
	public void setGroupId(long groupId) {
		_labDetailedActivityTable.setGroupId(groupId);
	}

	/**
	* Sets the learning environment design of this lab detailed activity table.
	*
	* @param learningEnvironmentDesign the learning environment design of this lab detailed activity table
	*/
	@Override
	public void setLearningEnvironmentDesign(
		java.lang.String learningEnvironmentDesign) {
		_labDetailedActivityTable.setLearningEnvironmentDesign(learningEnvironmentDesign);
	}

	/**
	* Sets the modified date of this lab detailed activity table.
	*
	* @param modifiedDate the modified date of this lab detailed activity table
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labDetailedActivityTable.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labDetailedActivityTable.setNew(n);
	}

	/**
	* Sets the p k_activity table ID of this lab detailed activity table.
	*
	* @param PK_activityTableId the p k_activity table ID of this lab detailed activity table
	*/
	@Override
	public void setPK_activityTableId(long PK_activityTableId) {
		_labDetailedActivityTable.setPK_activityTableId(PK_activityTableId);
	}

	/**
	* Sets the p k_course ID of this lab detailed activity table.
	*
	* @param PK_courseId the p k_course ID of this lab detailed activity table
	*/
	@Override
	public void setPK_courseId(long PK_courseId) {
		_labDetailedActivityTable.setPK_courseId(PK_courseId);
	}

	/**
	* Sets the p k_project ID of this lab detailed activity table.
	*
	* @param PK_projectId the p k_project ID of this lab detailed activity table
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labDetailedActivityTable.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the primary key of this lab detailed activity table.
	*
	* @param primaryKey the primary key of this lab detailed activity table
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labDetailedActivityTable.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labDetailedActivityTable.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this lab detailed activity table.
	*
	* @param userId the user ID of this lab detailed activity table
	*/
	@Override
	public void setUserId(long userId) {
		_labDetailedActivityTable.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab detailed activity table.
	*
	* @param userUuid the user uuid of this lab detailed activity table
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labDetailedActivityTable.setUserUuid(userUuid);
	}

	/**
	* Sets the week of this lab detailed activity table.
	*
	* @param week the week of this lab detailed activity table
	*/
	@Override
	public void setWeek(long week) {
		_labDetailedActivityTable.setWeek(week);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedActivityTableWrapper)) {
			return false;
		}

		labDetailedActivityTableWrapper labDetailedActivityTableWrapper = (labDetailedActivityTableWrapper)obj;

		if (Objects.equals(_labDetailedActivityTable,
					labDetailedActivityTableWrapper._labDetailedActivityTable)) {
			return true;
		}

		return false;
	}

	@Override
	public labDetailedActivityTable getWrappedModel() {
		return _labDetailedActivityTable;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labDetailedActivityTable.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labDetailedActivityTable.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labDetailedActivityTable.resetOriginalValues();
	}

	private final labDetailedActivityTable _labDetailedActivityTable;
}