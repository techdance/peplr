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
 * This class is a wrapper for {@link Custom_Workflow}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow
 * @generated
 */
@ProviderType
public class Custom_WorkflowWrapper implements Custom_Workflow,
	ModelWrapper<Custom_Workflow> {
	public Custom_WorkflowWrapper(Custom_Workflow custom_Workflow) {
		_custom_Workflow = custom_Workflow;
	}

	@Override
	public Class<?> getModelClass() {
		return Custom_Workflow.class;
	}

	@Override
	public String getModelClassName() {
		return Custom_Workflow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workFlowId", getWorkFlowId());
		attributes.put("workFlowName", getWorkFlowName());
		attributes.put("startWorkflowTaskId", getStartWorkflowTaskId());
		attributes.put("comments", getComments());
		attributes.put("isActive", getIsActive());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workFlowId = (Long)attributes.get("workFlowId");

		if (workFlowId != null) {
			setWorkFlowId(workFlowId);
		}

		String workFlowName = (String)attributes.get("workFlowName");

		if (workFlowName != null) {
			setWorkFlowName(workFlowName);
		}

		String startWorkflowTaskId = (String)attributes.get(
				"startWorkflowTaskId");

		if (startWorkflowTaskId != null) {
			setStartWorkflowTaskId(startWorkflowTaskId);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Long isActive = (Long)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
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
	public Custom_Workflow toEscapedModel() {
		return new Custom_WorkflowWrapper(_custom_Workflow.toEscapedModel());
	}

	@Override
	public Custom_Workflow toUnescapedModel() {
		return new Custom_WorkflowWrapper(_custom_Workflow.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _custom_Workflow.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _custom_Workflow.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _custom_Workflow.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _custom_Workflow.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Custom_Workflow> toCacheModel() {
		return _custom_Workflow.toCacheModel();
	}

	@Override
	public int compareTo(Custom_Workflow custom_Workflow) {
		return _custom_Workflow.compareTo(custom_Workflow);
	}

	@Override
	public int hashCode() {
		return _custom_Workflow.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _custom_Workflow.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Custom_WorkflowWrapper((Custom_Workflow)_custom_Workflow.clone());
	}

	/**
	* Returns the comments of this custom_ workflow.
	*
	* @return the comments of this custom_ workflow
	*/
	@Override
	public java.lang.String getComments() {
		return _custom_Workflow.getComments();
	}

	/**
	* Returns the start workflow task ID of this custom_ workflow.
	*
	* @return the start workflow task ID of this custom_ workflow
	*/
	@Override
	public java.lang.String getStartWorkflowTaskId() {
		return _custom_Workflow.getStartWorkflowTaskId();
	}

	/**
	* Returns the work flow name of this custom_ workflow.
	*
	* @return the work flow name of this custom_ workflow
	*/
	@Override
	public java.lang.String getWorkFlowName() {
		return _custom_Workflow.getWorkFlowName();
	}

	@Override
	public java.lang.String toString() {
		return _custom_Workflow.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _custom_Workflow.toXmlString();
	}

	/**
	* Returns the created date of this custom_ workflow.
	*
	* @return the created date of this custom_ workflow
	*/
	@Override
	public Date getCreatedDate() {
		return _custom_Workflow.getCreatedDate();
	}

	/**
	* Returns the created by of this custom_ workflow.
	*
	* @return the created by of this custom_ workflow
	*/
	@Override
	public long getCreatedBy() {
		return _custom_Workflow.getCreatedBy();
	}

	/**
	* Returns the is active of this custom_ workflow.
	*
	* @return the is active of this custom_ workflow
	*/
	@Override
	public long getIsActive() {
		return _custom_Workflow.getIsActive();
	}

	/**
	* Returns the primary key of this custom_ workflow.
	*
	* @return the primary key of this custom_ workflow
	*/
	@Override
	public long getPrimaryKey() {
		return _custom_Workflow.getPrimaryKey();
	}

	/**
	* Returns the work flow ID of this custom_ workflow.
	*
	* @return the work flow ID of this custom_ workflow
	*/
	@Override
	public long getWorkFlowId() {
		return _custom_Workflow.getWorkFlowId();
	}

	@Override
	public void persist() {
		_custom_Workflow.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_custom_Workflow.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this custom_ workflow.
	*
	* @param comments the comments of this custom_ workflow
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_custom_Workflow.setComments(comments);
	}

	/**
	* Sets the created by of this custom_ workflow.
	*
	* @param createdBy the created by of this custom_ workflow
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_custom_Workflow.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this custom_ workflow.
	*
	* @param createdDate the created date of this custom_ workflow
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_custom_Workflow.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_custom_Workflow.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_custom_Workflow.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_custom_Workflow.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the is active of this custom_ workflow.
	*
	* @param isActive the is active of this custom_ workflow
	*/
	@Override
	public void setIsActive(long isActive) {
		_custom_Workflow.setIsActive(isActive);
	}

	@Override
	public void setNew(boolean n) {
		_custom_Workflow.setNew(n);
	}

	/**
	* Sets the primary key of this custom_ workflow.
	*
	* @param primaryKey the primary key of this custom_ workflow
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_custom_Workflow.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_custom_Workflow.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start workflow task ID of this custom_ workflow.
	*
	* @param startWorkflowTaskId the start workflow task ID of this custom_ workflow
	*/
	@Override
	public void setStartWorkflowTaskId(java.lang.String startWorkflowTaskId) {
		_custom_Workflow.setStartWorkflowTaskId(startWorkflowTaskId);
	}

	/**
	* Sets the work flow ID of this custom_ workflow.
	*
	* @param workFlowId the work flow ID of this custom_ workflow
	*/
	@Override
	public void setWorkFlowId(long workFlowId) {
		_custom_Workflow.setWorkFlowId(workFlowId);
	}

	/**
	* Sets the work flow name of this custom_ workflow.
	*
	* @param workFlowName the work flow name of this custom_ workflow
	*/
	@Override
	public void setWorkFlowName(java.lang.String workFlowName) {
		_custom_Workflow.setWorkFlowName(workFlowName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_WorkflowWrapper)) {
			return false;
		}

		Custom_WorkflowWrapper custom_WorkflowWrapper = (Custom_WorkflowWrapper)obj;

		if (Objects.equals(_custom_Workflow,
					custom_WorkflowWrapper._custom_Workflow)) {
			return true;
		}

		return false;
	}

	@Override
	public Custom_Workflow getWrappedModel() {
		return _custom_Workflow;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _custom_Workflow.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _custom_Workflow.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_custom_Workflow.resetOriginalValues();
	}

	private final Custom_Workflow _custom_Workflow;
}