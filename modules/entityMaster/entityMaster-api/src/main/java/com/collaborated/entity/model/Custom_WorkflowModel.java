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
 * The base model interface for the Custom_Workflow service. Represents a row in the &quot;collaborated_Custom_Workflow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.collaborated.entity.model.impl.Custom_WorkflowModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.collaborated.entity.model.impl.Custom_WorkflowImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow
 * @see com.collaborated.entity.model.impl.Custom_WorkflowImpl
 * @see com.collaborated.entity.model.impl.Custom_WorkflowModelImpl
 * @generated
 */
@ProviderType
public interface Custom_WorkflowModel extends BaseModel<Custom_Workflow> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a custom_ workflow model instance should use the {@link Custom_Workflow} interface instead.
	 */

	/**
	 * Returns the primary key of this custom_ workflow.
	 *
	 * @return the primary key of this custom_ workflow
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this custom_ workflow.
	 *
	 * @param primaryKey the primary key of this custom_ workflow
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the work flow ID of this custom_ workflow.
	 *
	 * @return the work flow ID of this custom_ workflow
	 */
	public long getWorkFlowId();

	/**
	 * Sets the work flow ID of this custom_ workflow.
	 *
	 * @param workFlowId the work flow ID of this custom_ workflow
	 */
	public void setWorkFlowId(long workFlowId);

	/**
	 * Returns the work flow name of this custom_ workflow.
	 *
	 * @return the work flow name of this custom_ workflow
	 */
	@AutoEscape
	public String getWorkFlowName();

	/**
	 * Sets the work flow name of this custom_ workflow.
	 *
	 * @param workFlowName the work flow name of this custom_ workflow
	 */
	public void setWorkFlowName(String workFlowName);

	/**
	 * Returns the start workflow task ID of this custom_ workflow.
	 *
	 * @return the start workflow task ID of this custom_ workflow
	 */
	@AutoEscape
	public String getStartWorkflowTaskId();

	/**
	 * Sets the start workflow task ID of this custom_ workflow.
	 *
	 * @param startWorkflowTaskId the start workflow task ID of this custom_ workflow
	 */
	public void setStartWorkflowTaskId(String startWorkflowTaskId);

	/**
	 * Returns the comments of this custom_ workflow.
	 *
	 * @return the comments of this custom_ workflow
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this custom_ workflow.
	 *
	 * @param comments the comments of this custom_ workflow
	 */
	public void setComments(String comments);

	/**
	 * Returns the is active of this custom_ workflow.
	 *
	 * @return the is active of this custom_ workflow
	 */
	public long getIsActive();

	/**
	 * Sets the is active of this custom_ workflow.
	 *
	 * @param isActive the is active of this custom_ workflow
	 */
	public void setIsActive(long isActive);

	/**
	 * Returns the created date of this custom_ workflow.
	 *
	 * @return the created date of this custom_ workflow
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this custom_ workflow.
	 *
	 * @param createdDate the created date of this custom_ workflow
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the created by of this custom_ workflow.
	 *
	 * @return the created by of this custom_ workflow
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this custom_ workflow.
	 *
	 * @param createdBy the created by of this custom_ workflow
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
	public int compareTo(Custom_Workflow custom_Workflow);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Custom_Workflow> toCacheModel();

	@Override
	public Custom_Workflow toEscapedModel();

	@Override
	public Custom_Workflow toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}