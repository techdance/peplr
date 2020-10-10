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
 * This class is a wrapper for {@link Custom_Workflow_Task}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_Task
 * @generated
 */
@ProviderType
public class Custom_Workflow_TaskWrapper implements Custom_Workflow_Task,
	ModelWrapper<Custom_Workflow_Task> {
	public Custom_Workflow_TaskWrapper(
		Custom_Workflow_Task custom_Workflow_Task) {
		_custom_Workflow_Task = custom_Workflow_Task;
	}

	@Override
	public Class<?> getModelClass() {
		return Custom_Workflow_Task.class;
	}

	@Override
	public String getModelClassName() {
		return Custom_Workflow_Task.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workFlowTaskId", getWorkFlowTaskId());
		attributes.put("workFlowId", getWorkFlowId());
		attributes.put("taskName", getTaskName());
		attributes.put("roleId", getRoleId());
		attributes.put("roleName", getRoleName());
		attributes.put("comments", getComments());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String workFlowTaskId = (String)attributes.get("workFlowTaskId");

		if (workFlowTaskId != null) {
			setWorkFlowTaskId(workFlowTaskId);
		}

		Long workFlowId = (Long)attributes.get("workFlowId");

		if (workFlowId != null) {
			setWorkFlowId(workFlowId);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String roleName = (String)attributes.get("roleName");

		if (roleName != null) {
			setRoleName(roleName);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	@Override
	public Custom_Workflow_Task toEscapedModel() {
		return new Custom_Workflow_TaskWrapper(_custom_Workflow_Task.toEscapedModel());
	}

	@Override
	public Custom_Workflow_Task toUnescapedModel() {
		return new Custom_Workflow_TaskWrapper(_custom_Workflow_Task.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _custom_Workflow_Task.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _custom_Workflow_Task.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _custom_Workflow_Task.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _custom_Workflow_Task.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Custom_Workflow_Task> toCacheModel() {
		return _custom_Workflow_Task.toCacheModel();
	}

	@Override
	public int compareTo(Custom_Workflow_Task custom_Workflow_Task) {
		return _custom_Workflow_Task.compareTo(custom_Workflow_Task);
	}

	@Override
	public int hashCode() {
		return _custom_Workflow_Task.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _custom_Workflow_Task.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Custom_Workflow_TaskWrapper((Custom_Workflow_Task)_custom_Workflow_Task.clone());
	}

	/**
	* Returns the comments of this custom_ workflow_ task.
	*
	* @return the comments of this custom_ workflow_ task
	*/
	@Override
	public java.lang.String getComments() {
		return _custom_Workflow_Task.getComments();
	}

	/**
	* Returns the primary key of this custom_ workflow_ task.
	*
	* @return the primary key of this custom_ workflow_ task
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _custom_Workflow_Task.getPrimaryKey();
	}

	/**
	* Returns the role name of this custom_ workflow_ task.
	*
	* @return the role name of this custom_ workflow_ task
	*/
	@Override
	public java.lang.String getRoleName() {
		return _custom_Workflow_Task.getRoleName();
	}

	/**
	* Returns the task name of this custom_ workflow_ task.
	*
	* @return the task name of this custom_ workflow_ task
	*/
	@Override
	public java.lang.String getTaskName() {
		return _custom_Workflow_Task.getTaskName();
	}

	/**
	* Returns the work flow task ID of this custom_ workflow_ task.
	*
	* @return the work flow task ID of this custom_ workflow_ task
	*/
	@Override
	public java.lang.String getWorkFlowTaskId() {
		return _custom_Workflow_Task.getWorkFlowTaskId();
	}

	@Override
	public java.lang.String toString() {
		return _custom_Workflow_Task.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _custom_Workflow_Task.toXmlString();
	}

	/**
	* Returns the created date of this custom_ workflow_ task.
	*
	* @return the created date of this custom_ workflow_ task
	*/
	@Override
	public Date getCreatedDate() {
		return _custom_Workflow_Task.getCreatedDate();
	}

	/**
	* Returns the created by of this custom_ workflow_ task.
	*
	* @return the created by of this custom_ workflow_ task
	*/
	@Override
	public long getCreatedBy() {
		return _custom_Workflow_Task.getCreatedBy();
	}

	/**
	* Returns the role ID of this custom_ workflow_ task.
	*
	* @return the role ID of this custom_ workflow_ task
	*/
	@Override
	public long getRoleId() {
		return _custom_Workflow_Task.getRoleId();
	}

	/**
	* Returns the work flow ID of this custom_ workflow_ task.
	*
	* @return the work flow ID of this custom_ workflow_ task
	*/
	@Override
	public long getWorkFlowId() {
		return _custom_Workflow_Task.getWorkFlowId();
	}

	@Override
	public void persist() {
		_custom_Workflow_Task.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_custom_Workflow_Task.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this custom_ workflow_ task.
	*
	* @param comments the comments of this custom_ workflow_ task
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_custom_Workflow_Task.setComments(comments);
	}

	/**
	* Sets the created by of this custom_ workflow_ task.
	*
	* @param createdBy the created by of this custom_ workflow_ task
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_custom_Workflow_Task.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this custom_ workflow_ task.
	*
	* @param createdDate the created date of this custom_ workflow_ task
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_custom_Workflow_Task.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_custom_Workflow_Task.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_custom_Workflow_Task.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_custom_Workflow_Task.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_custom_Workflow_Task.setNew(n);
	}

	/**
	* Sets the primary key of this custom_ workflow_ task.
	*
	* @param primaryKey the primary key of this custom_ workflow_ task
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_custom_Workflow_Task.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_custom_Workflow_Task.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the role ID of this custom_ workflow_ task.
	*
	* @param roleId the role ID of this custom_ workflow_ task
	*/
	@Override
	public void setRoleId(long roleId) {
		_custom_Workflow_Task.setRoleId(roleId);
	}

	/**
	* Sets the role name of this custom_ workflow_ task.
	*
	* @param roleName the role name of this custom_ workflow_ task
	*/
	@Override
	public void setRoleName(java.lang.String roleName) {
		_custom_Workflow_Task.setRoleName(roleName);
	}

	/**
	* Sets the task name of this custom_ workflow_ task.
	*
	* @param taskName the task name of this custom_ workflow_ task
	*/
	@Override
	public void setTaskName(java.lang.String taskName) {
		_custom_Workflow_Task.setTaskName(taskName);
	}

	/**
	* Sets the work flow ID of this custom_ workflow_ task.
	*
	* @param workFlowId the work flow ID of this custom_ workflow_ task
	*/
	@Override
	public void setWorkFlowId(long workFlowId) {
		_custom_Workflow_Task.setWorkFlowId(workFlowId);
	}

	/**
	* Sets the work flow task ID of this custom_ workflow_ task.
	*
	* @param workFlowTaskId the work flow task ID of this custom_ workflow_ task
	*/
	@Override
	public void setWorkFlowTaskId(java.lang.String workFlowTaskId) {
		_custom_Workflow_Task.setWorkFlowTaskId(workFlowTaskId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_Workflow_TaskWrapper)) {
			return false;
		}

		Custom_Workflow_TaskWrapper custom_Workflow_TaskWrapper = (Custom_Workflow_TaskWrapper)obj;

		if (Objects.equals(_custom_Workflow_Task,
					custom_Workflow_TaskWrapper._custom_Workflow_Task)) {
			return true;
		}

		return false;
	}

	@Override
	public Custom_Workflow_Task getWrappedModel() {
		return _custom_Workflow_Task;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _custom_Workflow_Task.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _custom_Workflow_Task.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_custom_Workflow_Task.resetOriginalValues();
	}

	private final Custom_Workflow_Task _custom_Workflow_Task;
}