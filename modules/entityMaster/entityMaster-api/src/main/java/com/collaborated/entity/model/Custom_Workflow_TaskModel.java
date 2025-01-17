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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Custom_Workflow_Task service. Represents a row in the &quot;collaborated_Custom_Workflow_Task&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.collaborated.entity.model.impl.Custom_Workflow_TaskModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.collaborated.entity.model.impl.Custom_Workflow_TaskImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_Task
 * @see com.collaborated.entity.model.impl.Custom_Workflow_TaskImpl
 * @see com.collaborated.entity.model.impl.Custom_Workflow_TaskModelImpl
 * @generated
 */
@ProviderType
public interface Custom_Workflow_TaskModel extends BaseModel<Custom_Workflow_Task> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a custom_ workflow_ task model instance should use the {@link Custom_Workflow_Task} interface instead.
	 */

	/**
	 * Returns the primary key of this custom_ workflow_ task.
	 *
	 * @return the primary key of this custom_ workflow_ task
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this custom_ workflow_ task.
	 *
	 * @param primaryKey the primary key of this custom_ workflow_ task
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the work flow task ID of this custom_ workflow_ task.
	 *
	 * @return the work flow task ID of this custom_ workflow_ task
	 */
	@AutoEscape
	public String getWorkFlowTaskId();

	/**
	 * Sets the work flow task ID of this custom_ workflow_ task.
	 *
	 * @param workFlowTaskId the work flow task ID of this custom_ workflow_ task
	 */
	public void setWorkFlowTaskId(String workFlowTaskId);

	/**
	 * Returns the work flow ID of this custom_ workflow_ task.
	 *
	 * @return the work flow ID of this custom_ workflow_ task
	 */
	public long getWorkFlowId();

	/**
	 * Sets the work flow ID of this custom_ workflow_ task.
	 *
	 * @param workFlowId the work flow ID of this custom_ workflow_ task
	 */
	public void setWorkFlowId(long workFlowId);

	/**
	 * Returns the task name of this custom_ workflow_ task.
	 *
	 * @return the task name of this custom_ workflow_ task
	 */
	@AutoEscape
	public String getTaskName();

	/**
	 * Sets the task name of this custom_ workflow_ task.
	 *
	 * @param taskName the task name of this custom_ workflow_ task
	 */
	public void setTaskName(String taskName);

	/**
	 * Returns the role ID of this custom_ workflow_ task.
	 *
	 * @return the role ID of this custom_ workflow_ task
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this custom_ workflow_ task.
	 *
	 * @param roleId the role ID of this custom_ workflow_ task
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the role name of this custom_ workflow_ task.
	 *
	 * @return the role name of this custom_ workflow_ task
	 */
	@AutoEscape
	public String getRoleName();

	/**
	 * Sets the role name of this custom_ workflow_ task.
	 *
	 * @param roleName the role name of this custom_ workflow_ task
	 */
	public void setRoleName(String roleName);

	/**
	 * Returns the comments of this custom_ workflow_ task.
	 *
	 * @return the comments of this custom_ workflow_ task
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this custom_ workflow_ task.
	 *
	 * @param comments the comments of this custom_ workflow_ task
	 */
	public void setComments(String comments);

	/**
	 * Returns the created date of this custom_ workflow_ task.
	 *
	 * @return the created date of this custom_ workflow_ task
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this custom_ workflow_ task.
	 *
	 * @param createdDate the created date of this custom_ workflow_ task
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the created by of this custom_ workflow_ task.
	 *
	 * @return the created by of this custom_ workflow_ task
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this custom_ workflow_ task.
	 *
	 * @param createdBy the created by of this custom_ workflow_ task
	 */
	public void setCreatedBy(long createdBy);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Custom_Workflow_Task custom_Workflow_Task);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Custom_Workflow_Task> toCacheModel();

	@Override
	public Custom_Workflow_Task toEscapedModel();

	@Override
	public Custom_Workflow_Task toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}