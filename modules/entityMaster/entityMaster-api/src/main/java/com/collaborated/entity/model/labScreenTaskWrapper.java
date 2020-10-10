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
 * This class is a wrapper for {@link labScreenTask}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenTask
 * @generated
 */
@ProviderType
public class labScreenTaskWrapper implements labScreenTask,
	ModelWrapper<labScreenTask> {
	public labScreenTaskWrapper(labScreenTask labScreenTask) {
		_labScreenTask = labScreenTask;
	}

	@Override
	public Class<?> getModelClass() {
		return labScreenTask.class;
	}

	@Override
	public String getModelClassName() {
		return labScreenTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_taskId", getPK_taskId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("milestoneName", getMilestoneName());
		attributes.put("taskName", getTaskName());
		attributes.put("projectAssignedTo", getProjectAssignedTo());
		attributes.put("taskDescription", getTaskDescription());
		attributes.put("taskStatus", getTaskStatus());
		attributes.put("dueDate", getDueDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_taskId = (Long)attributes.get("PK_taskId");

		if (PK_taskId != null) {
			setPK_taskId(PK_taskId);
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

		String milestoneName = (String)attributes.get("milestoneName");

		if (milestoneName != null) {
			setMilestoneName(milestoneName);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}

		Long projectAssignedTo = (Long)attributes.get("projectAssignedTo");

		if (projectAssignedTo != null) {
			setProjectAssignedTo(projectAssignedTo);
		}

		String taskDescription = (String)attributes.get("taskDescription");

		if (taskDescription != null) {
			setTaskDescription(taskDescription);
		}

		String taskStatus = (String)attributes.get("taskStatus");

		if (taskStatus != null) {
			setTaskStatus(taskStatus);
		}

		String dueDate = (String)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labScreenTask.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labScreenTask.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labScreenTask.isNew();
	}

	@Override
	public com.collaborated.entity.model.labScreenTask toEscapedModel() {
		return new labScreenTaskWrapper(_labScreenTask.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labScreenTask toUnescapedModel() {
		return new labScreenTaskWrapper(_labScreenTask.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labScreenTask.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labScreenTask> toCacheModel() {
		return _labScreenTask.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labScreenTask labScreenTask) {
		return _labScreenTask.compareTo(labScreenTask);
	}

	@Override
	public int hashCode() {
		return _labScreenTask.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labScreenTask.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labScreenTaskWrapper((labScreenTask)_labScreenTask.clone());
	}

	/**
	* Returns the due date of this lab screen task.
	*
	* @return the due date of this lab screen task
	*/
	@Override
	public java.lang.String getDueDate() {
		return _labScreenTask.getDueDate();
	}

	/**
	* Returns the milestone name of this lab screen task.
	*
	* @return the milestone name of this lab screen task
	*/
	@Override
	public java.lang.String getMilestoneName() {
		return _labScreenTask.getMilestoneName();
	}

	/**
	* Returns the task description of this lab screen task.
	*
	* @return the task description of this lab screen task
	*/
	@Override
	public java.lang.String getTaskDescription() {
		return _labScreenTask.getTaskDescription();
	}

	/**
	* Returns the task name of this lab screen task.
	*
	* @return the task name of this lab screen task
	*/
	@Override
	public java.lang.String getTaskName() {
		return _labScreenTask.getTaskName();
	}

	/**
	* Returns the task status of this lab screen task.
	*
	* @return the task status of this lab screen task
	*/
	@Override
	public java.lang.String getTaskStatus() {
		return _labScreenTask.getTaskStatus();
	}

	/**
	* Returns the user uuid of this lab screen task.
	*
	* @return the user uuid of this lab screen task
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labScreenTask.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labScreenTask.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labScreenTask.toXmlString();
	}

	/**
	* Returns the create date of this lab screen task.
	*
	* @return the create date of this lab screen task
	*/
	@Override
	public Date getCreateDate() {
		return _labScreenTask.getCreateDate();
	}

	/**
	* Returns the modified date of this lab screen task.
	*
	* @return the modified date of this lab screen task
	*/
	@Override
	public Date getModifiedDate() {
		return _labScreenTask.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab screen task.
	*
	* @return the group ID of this lab screen task
	*/
	@Override
	public long getGroupId() {
		return _labScreenTask.getGroupId();
	}

	/**
	* Returns the p k_project ID of this lab screen task.
	*
	* @return the p k_project ID of this lab screen task
	*/
	@Override
	public long getPK_projectId() {
		return _labScreenTask.getPK_projectId();
	}

	/**
	* Returns the p k_task ID of this lab screen task.
	*
	* @return the p k_task ID of this lab screen task
	*/
	@Override
	public long getPK_taskId() {
		return _labScreenTask.getPK_taskId();
	}

	/**
	* Returns the primary key of this lab screen task.
	*
	* @return the primary key of this lab screen task
	*/
	@Override
	public long getPrimaryKey() {
		return _labScreenTask.getPrimaryKey();
	}

	/**
	* Returns the project assigned to of this lab screen task.
	*
	* @return the project assigned to of this lab screen task
	*/
	@Override
	public long getProjectAssignedTo() {
		return _labScreenTask.getProjectAssignedTo();
	}

	/**
	* Returns the user ID of this lab screen task.
	*
	* @return the user ID of this lab screen task
	*/
	@Override
	public long getUserId() {
		return _labScreenTask.getUserId();
	}

	@Override
	public void persist() {
		_labScreenTask.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labScreenTask.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this lab screen task.
	*
	* @param createDate the create date of this lab screen task
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labScreenTask.setCreateDate(createDate);
	}

	/**
	* Sets the due date of this lab screen task.
	*
	* @param dueDate the due date of this lab screen task
	*/
	@Override
	public void setDueDate(java.lang.String dueDate) {
		_labScreenTask.setDueDate(dueDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labScreenTask.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labScreenTask.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labScreenTask.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab screen task.
	*
	* @param groupId the group ID of this lab screen task
	*/
	@Override
	public void setGroupId(long groupId) {
		_labScreenTask.setGroupId(groupId);
	}

	/**
	* Sets the milestone name of this lab screen task.
	*
	* @param milestoneName the milestone name of this lab screen task
	*/
	@Override
	public void setMilestoneName(java.lang.String milestoneName) {
		_labScreenTask.setMilestoneName(milestoneName);
	}

	/**
	* Sets the modified date of this lab screen task.
	*
	* @param modifiedDate the modified date of this lab screen task
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labScreenTask.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labScreenTask.setNew(n);
	}

	/**
	* Sets the p k_project ID of this lab screen task.
	*
	* @param PK_projectId the p k_project ID of this lab screen task
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labScreenTask.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the p k_task ID of this lab screen task.
	*
	* @param PK_taskId the p k_task ID of this lab screen task
	*/
	@Override
	public void setPK_taskId(long PK_taskId) {
		_labScreenTask.setPK_taskId(PK_taskId);
	}

	/**
	* Sets the primary key of this lab screen task.
	*
	* @param primaryKey the primary key of this lab screen task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labScreenTask.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labScreenTask.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project assigned to of this lab screen task.
	*
	* @param projectAssignedTo the project assigned to of this lab screen task
	*/
	@Override
	public void setProjectAssignedTo(long projectAssignedTo) {
		_labScreenTask.setProjectAssignedTo(projectAssignedTo);
	}

	/**
	* Sets the task description of this lab screen task.
	*
	* @param taskDescription the task description of this lab screen task
	*/
	@Override
	public void setTaskDescription(java.lang.String taskDescription) {
		_labScreenTask.setTaskDescription(taskDescription);
	}

	/**
	* Sets the task name of this lab screen task.
	*
	* @param taskName the task name of this lab screen task
	*/
	@Override
	public void setTaskName(java.lang.String taskName) {
		_labScreenTask.setTaskName(taskName);
	}

	/**
	* Sets the task status of this lab screen task.
	*
	* @param taskStatus the task status of this lab screen task
	*/
	@Override
	public void setTaskStatus(java.lang.String taskStatus) {
		_labScreenTask.setTaskStatus(taskStatus);
	}

	/**
	* Sets the user ID of this lab screen task.
	*
	* @param userId the user ID of this lab screen task
	*/
	@Override
	public void setUserId(long userId) {
		_labScreenTask.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab screen task.
	*
	* @param userUuid the user uuid of this lab screen task
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labScreenTask.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labScreenTaskWrapper)) {
			return false;
		}

		labScreenTaskWrapper labScreenTaskWrapper = (labScreenTaskWrapper)obj;

		if (Objects.equals(_labScreenTask, labScreenTaskWrapper._labScreenTask)) {
			return true;
		}

		return false;
	}

	@Override
	public labScreenTask getWrappedModel() {
		return _labScreenTask;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labScreenTask.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labScreenTask.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labScreenTask.resetOriginalValues();
	}

	private final labScreenTask _labScreenTask;
}