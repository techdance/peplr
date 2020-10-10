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
 * This class is a wrapper for {@link Custom_WorkflowLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowLog
 * @generated
 */
@ProviderType
public class Custom_WorkflowLogWrapper implements Custom_WorkflowLog,
	ModelWrapper<Custom_WorkflowLog> {
	public Custom_WorkflowLogWrapper(Custom_WorkflowLog custom_WorkflowLog) {
		_custom_WorkflowLog = custom_WorkflowLog;
	}

	@Override
	public Class<?> getModelClass() {
		return Custom_WorkflowLog.class;
	}

	@Override
	public String getModelClassName() {
		return Custom_WorkflowLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("logId", getLogId());
		attributes.put("trackingId", getTrackingId());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("workflowTaskId", getWorkflowTaskId());
		attributes.put("trasitionId", getTrasitionId());
		attributes.put("logDescription", getLogDescription());
		attributes.put("comments", getComments());
		attributes.put("assigneeClassPK", getAssigneeClassPK());
		attributes.put("className", getClassName());
		attributes.put("assignedDate", getAssignedDate());
		attributes.put("completedDate", getCompletedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long logId = (Long)attributes.get("logId");

		if (logId != null) {
			setLogId(logId);
		}

		Long trackingId = (Long)attributes.get("trackingId");

		if (trackingId != null) {
			setTrackingId(trackingId);
		}

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		String workflowTaskId = (String)attributes.get("workflowTaskId");

		if (workflowTaskId != null) {
			setWorkflowTaskId(workflowTaskId);
		}

		Long trasitionId = (Long)attributes.get("trasitionId");

		if (trasitionId != null) {
			setTrasitionId(trasitionId);
		}

		String logDescription = (String)attributes.get("logDescription");

		if (logDescription != null) {
			setLogDescription(logDescription);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Long assigneeClassPK = (Long)attributes.get("assigneeClassPK");

		if (assigneeClassPK != null) {
			setAssigneeClassPK(assigneeClassPK);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Date assignedDate = (Date)attributes.get("assignedDate");

		if (assignedDate != null) {
			setAssignedDate(assignedDate);
		}

		Date completedDate = (Date)attributes.get("completedDate");

		if (completedDate != null) {
			setCompletedDate(completedDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public Custom_WorkflowLog toEscapedModel() {
		return new Custom_WorkflowLogWrapper(_custom_WorkflowLog.toEscapedModel());
	}

	@Override
	public Custom_WorkflowLog toUnescapedModel() {
		return new Custom_WorkflowLogWrapper(_custom_WorkflowLog.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _custom_WorkflowLog.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _custom_WorkflowLog.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _custom_WorkflowLog.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _custom_WorkflowLog.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Custom_WorkflowLog> toCacheModel() {
		return _custom_WorkflowLog.toCacheModel();
	}

	@Override
	public int compareTo(Custom_WorkflowLog custom_WorkflowLog) {
		return _custom_WorkflowLog.compareTo(custom_WorkflowLog);
	}

	@Override
	public int hashCode() {
		return _custom_WorkflowLog.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _custom_WorkflowLog.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Custom_WorkflowLogWrapper((Custom_WorkflowLog)_custom_WorkflowLog.clone());
	}

	/**
	* Returns the class name of this custom_ workflow log.
	*
	* @return the class name of this custom_ workflow log
	*/
	@Override
	public java.lang.String getClassName() {
		return _custom_WorkflowLog.getClassName();
	}

	/**
	* Returns the comments of this custom_ workflow log.
	*
	* @return the comments of this custom_ workflow log
	*/
	@Override
	public java.lang.String getComments() {
		return _custom_WorkflowLog.getComments();
	}

	/**
	* Returns the log description of this custom_ workflow log.
	*
	* @return the log description of this custom_ workflow log
	*/
	@Override
	public java.lang.String getLogDescription() {
		return _custom_WorkflowLog.getLogDescription();
	}

	/**
	* Returns the workflow task ID of this custom_ workflow log.
	*
	* @return the workflow task ID of this custom_ workflow log
	*/
	@Override
	public java.lang.String getWorkflowTaskId() {
		return _custom_WorkflowLog.getWorkflowTaskId();
	}

	@Override
	public java.lang.String toString() {
		return _custom_WorkflowLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _custom_WorkflowLog.toXmlString();
	}

	/**
	* Returns the assigned date of this custom_ workflow log.
	*
	* @return the assigned date of this custom_ workflow log
	*/
	@Override
	public Date getAssignedDate() {
		return _custom_WorkflowLog.getAssignedDate();
	}

	/**
	* Returns the completed date of this custom_ workflow log.
	*
	* @return the completed date of this custom_ workflow log
	*/
	@Override
	public Date getCompletedDate() {
		return _custom_WorkflowLog.getCompletedDate();
	}

	/**
	* Returns the created date of this custom_ workflow log.
	*
	* @return the created date of this custom_ workflow log
	*/
	@Override
	public Date getCreatedDate() {
		return _custom_WorkflowLog.getCreatedDate();
	}

	/**
	* Returns the assignee class p k of this custom_ workflow log.
	*
	* @return the assignee class p k of this custom_ workflow log
	*/
	@Override
	public long getAssigneeClassPK() {
		return _custom_WorkflowLog.getAssigneeClassPK();
	}

	/**
	* Returns the created by of this custom_ workflow log.
	*
	* @return the created by of this custom_ workflow log
	*/
	@Override
	public long getCreatedBy() {
		return _custom_WorkflowLog.getCreatedBy();
	}

	/**
	* Returns the log ID of this custom_ workflow log.
	*
	* @return the log ID of this custom_ workflow log
	*/
	@Override
	public long getLogId() {
		return _custom_WorkflowLog.getLogId();
	}

	/**
	* Returns the primary key of this custom_ workflow log.
	*
	* @return the primary key of this custom_ workflow log
	*/
	@Override
	public long getPrimaryKey() {
		return _custom_WorkflowLog.getPrimaryKey();
	}

	/**
	* Returns the tracking ID of this custom_ workflow log.
	*
	* @return the tracking ID of this custom_ workflow log
	*/
	@Override
	public long getTrackingId() {
		return _custom_WorkflowLog.getTrackingId();
	}

	/**
	* Returns the trasition ID of this custom_ workflow log.
	*
	* @return the trasition ID of this custom_ workflow log
	*/
	@Override
	public long getTrasitionId() {
		return _custom_WorkflowLog.getTrasitionId();
	}

	/**
	* Returns the workflow ID of this custom_ workflow log.
	*
	* @return the workflow ID of this custom_ workflow log
	*/
	@Override
	public long getWorkflowId() {
		return _custom_WorkflowLog.getWorkflowId();
	}

	@Override
	public void persist() {
		_custom_WorkflowLog.persist();
	}

	/**
	* Sets the assigned date of this custom_ workflow log.
	*
	* @param assignedDate the assigned date of this custom_ workflow log
	*/
	@Override
	public void setAssignedDate(Date assignedDate) {
		_custom_WorkflowLog.setAssignedDate(assignedDate);
	}

	/**
	* Sets the assignee class p k of this custom_ workflow log.
	*
	* @param assigneeClassPK the assignee class p k of this custom_ workflow log
	*/
	@Override
	public void setAssigneeClassPK(long assigneeClassPK) {
		_custom_WorkflowLog.setAssigneeClassPK(assigneeClassPK);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_custom_WorkflowLog.setCachedModel(cachedModel);
	}

	/**
	* Sets the class name of this custom_ workflow log.
	*
	* @param className the class name of this custom_ workflow log
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_custom_WorkflowLog.setClassName(className);
	}

	/**
	* Sets the comments of this custom_ workflow log.
	*
	* @param comments the comments of this custom_ workflow log
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_custom_WorkflowLog.setComments(comments);
	}

	/**
	* Sets the completed date of this custom_ workflow log.
	*
	* @param completedDate the completed date of this custom_ workflow log
	*/
	@Override
	public void setCompletedDate(Date completedDate) {
		_custom_WorkflowLog.setCompletedDate(completedDate);
	}

	/**
	* Sets the created by of this custom_ workflow log.
	*
	* @param createdBy the created by of this custom_ workflow log
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_custom_WorkflowLog.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this custom_ workflow log.
	*
	* @param createdDate the created date of this custom_ workflow log
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_custom_WorkflowLog.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_custom_WorkflowLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_custom_WorkflowLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_custom_WorkflowLog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the log description of this custom_ workflow log.
	*
	* @param logDescription the log description of this custom_ workflow log
	*/
	@Override
	public void setLogDescription(java.lang.String logDescription) {
		_custom_WorkflowLog.setLogDescription(logDescription);
	}

	/**
	* Sets the log ID of this custom_ workflow log.
	*
	* @param logId the log ID of this custom_ workflow log
	*/
	@Override
	public void setLogId(long logId) {
		_custom_WorkflowLog.setLogId(logId);
	}

	@Override
	public void setNew(boolean n) {
		_custom_WorkflowLog.setNew(n);
	}

	/**
	* Sets the primary key of this custom_ workflow log.
	*
	* @param primaryKey the primary key of this custom_ workflow log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_custom_WorkflowLog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_custom_WorkflowLog.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tracking ID of this custom_ workflow log.
	*
	* @param trackingId the tracking ID of this custom_ workflow log
	*/
	@Override
	public void setTrackingId(long trackingId) {
		_custom_WorkflowLog.setTrackingId(trackingId);
	}

	/**
	* Sets the trasition ID of this custom_ workflow log.
	*
	* @param trasitionId the trasition ID of this custom_ workflow log
	*/
	@Override
	public void setTrasitionId(long trasitionId) {
		_custom_WorkflowLog.setTrasitionId(trasitionId);
	}

	/**
	* Sets the workflow ID of this custom_ workflow log.
	*
	* @param workflowId the workflow ID of this custom_ workflow log
	*/
	@Override
	public void setWorkflowId(long workflowId) {
		_custom_WorkflowLog.setWorkflowId(workflowId);
	}

	/**
	* Sets the workflow task ID of this custom_ workflow log.
	*
	* @param workflowTaskId the workflow task ID of this custom_ workflow log
	*/
	@Override
	public void setWorkflowTaskId(java.lang.String workflowTaskId) {
		_custom_WorkflowLog.setWorkflowTaskId(workflowTaskId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_WorkflowLogWrapper)) {
			return false;
		}

		Custom_WorkflowLogWrapper custom_WorkflowLogWrapper = (Custom_WorkflowLogWrapper)obj;

		if (Objects.equals(_custom_WorkflowLog,
					custom_WorkflowLogWrapper._custom_WorkflowLog)) {
			return true;
		}

		return false;
	}

	@Override
	public Custom_WorkflowLog getWrappedModel() {
		return _custom_WorkflowLog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _custom_WorkflowLog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _custom_WorkflowLog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_custom_WorkflowLog.resetOriginalValues();
	}

	private final Custom_WorkflowLog _custom_WorkflowLog;
}