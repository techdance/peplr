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
 * This class is a wrapper for {@link Custom_Workflow_Completed}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_Completed
 * @generated
 */
@ProviderType
public class Custom_Workflow_CompletedWrapper
	implements Custom_Workflow_Completed,
		ModelWrapper<Custom_Workflow_Completed> {
	public Custom_Workflow_CompletedWrapper(
		Custom_Workflow_Completed custom_Workflow_Completed) {
		_custom_Workflow_Completed = custom_Workflow_Completed;
	}

	@Override
	public Class<?> getModelClass() {
		return Custom_Workflow_Completed.class;
	}

	@Override
	public String getModelClassName() {
		return Custom_Workflow_Completed.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cId", getCId());
		attributes.put("trackingId", getTrackingId());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("workflowTaskId", getWorkflowTaskId());
		attributes.put("trasitionId", getTrasitionId());
		attributes.put("logDescription", getLogDescription());
		attributes.put("comments", getComments());
		attributes.put("completedDate", getCompletedDate());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cId = (Long)attributes.get("cId");

		if (cId != null) {
			setCId(cId);
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

		Date completedDate = (Date)attributes.get("completedDate");

		if (completedDate != null) {
			setCompletedDate(completedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public Custom_Workflow_Completed toEscapedModel() {
		return new Custom_Workflow_CompletedWrapper(_custom_Workflow_Completed.toEscapedModel());
	}

	@Override
	public Custom_Workflow_Completed toUnescapedModel() {
		return new Custom_Workflow_CompletedWrapper(_custom_Workflow_Completed.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _custom_Workflow_Completed.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _custom_Workflow_Completed.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _custom_Workflow_Completed.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _custom_Workflow_Completed.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Custom_Workflow_Completed> toCacheModel() {
		return _custom_Workflow_Completed.toCacheModel();
	}

	@Override
	public int compareTo(Custom_Workflow_Completed custom_Workflow_Completed) {
		return _custom_Workflow_Completed.compareTo(custom_Workflow_Completed);
	}

	@Override
	public int hashCode() {
		return _custom_Workflow_Completed.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _custom_Workflow_Completed.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Custom_Workflow_CompletedWrapper((Custom_Workflow_Completed)_custom_Workflow_Completed.clone());
	}

	/**
	* Returns the comments of this custom_ workflow_ completed.
	*
	* @return the comments of this custom_ workflow_ completed
	*/
	@Override
	public java.lang.String getComments() {
		return _custom_Workflow_Completed.getComments();
	}

	/**
	* Returns the log description of this custom_ workflow_ completed.
	*
	* @return the log description of this custom_ workflow_ completed
	*/
	@Override
	public java.lang.String getLogDescription() {
		return _custom_Workflow_Completed.getLogDescription();
	}

	/**
	* Returns the user uuid of this custom_ workflow_ completed.
	*
	* @return the user uuid of this custom_ workflow_ completed
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _custom_Workflow_Completed.getUserUuid();
	}

	/**
	* Returns the workflow task ID of this custom_ workflow_ completed.
	*
	* @return the workflow task ID of this custom_ workflow_ completed
	*/
	@Override
	public java.lang.String getWorkflowTaskId() {
		return _custom_Workflow_Completed.getWorkflowTaskId();
	}

	@Override
	public java.lang.String toString() {
		return _custom_Workflow_Completed.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _custom_Workflow_Completed.toXmlString();
	}

	/**
	* Returns the completed date of this custom_ workflow_ completed.
	*
	* @return the completed date of this custom_ workflow_ completed
	*/
	@Override
	public Date getCompletedDate() {
		return _custom_Workflow_Completed.getCompletedDate();
	}

	/**
	* Returns the created date of this custom_ workflow_ completed.
	*
	* @return the created date of this custom_ workflow_ completed
	*/
	@Override
	public Date getCreatedDate() {
		return _custom_Workflow_Completed.getCreatedDate();
	}

	/**
	* Returns the c ID of this custom_ workflow_ completed.
	*
	* @return the c ID of this custom_ workflow_ completed
	*/
	@Override
	public long getCId() {
		return _custom_Workflow_Completed.getCId();
	}

	/**
	* Returns the primary key of this custom_ workflow_ completed.
	*
	* @return the primary key of this custom_ workflow_ completed
	*/
	@Override
	public long getPrimaryKey() {
		return _custom_Workflow_Completed.getPrimaryKey();
	}

	/**
	* Returns the tracking ID of this custom_ workflow_ completed.
	*
	* @return the tracking ID of this custom_ workflow_ completed
	*/
	@Override
	public long getTrackingId() {
		return _custom_Workflow_Completed.getTrackingId();
	}

	/**
	* Returns the trasition ID of this custom_ workflow_ completed.
	*
	* @return the trasition ID of this custom_ workflow_ completed
	*/
	@Override
	public long getTrasitionId() {
		return _custom_Workflow_Completed.getTrasitionId();
	}

	/**
	* Returns the user ID of this custom_ workflow_ completed.
	*
	* @return the user ID of this custom_ workflow_ completed
	*/
	@Override
	public long getUserId() {
		return _custom_Workflow_Completed.getUserId();
	}

	/**
	* Returns the workflow ID of this custom_ workflow_ completed.
	*
	* @return the workflow ID of this custom_ workflow_ completed
	*/
	@Override
	public long getWorkflowId() {
		return _custom_Workflow_Completed.getWorkflowId();
	}

	@Override
	public void persist() {
		_custom_Workflow_Completed.persist();
	}

	/**
	* Sets the c ID of this custom_ workflow_ completed.
	*
	* @param cId the c ID of this custom_ workflow_ completed
	*/
	@Override
	public void setCId(long cId) {
		_custom_Workflow_Completed.setCId(cId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_custom_Workflow_Completed.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this custom_ workflow_ completed.
	*
	* @param comments the comments of this custom_ workflow_ completed
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_custom_Workflow_Completed.setComments(comments);
	}

	/**
	* Sets the completed date of this custom_ workflow_ completed.
	*
	* @param completedDate the completed date of this custom_ workflow_ completed
	*/
	@Override
	public void setCompletedDate(Date completedDate) {
		_custom_Workflow_Completed.setCompletedDate(completedDate);
	}

	/**
	* Sets the created date of this custom_ workflow_ completed.
	*
	* @param createdDate the created date of this custom_ workflow_ completed
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_custom_Workflow_Completed.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_custom_Workflow_Completed.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_custom_Workflow_Completed.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_custom_Workflow_Completed.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the log description of this custom_ workflow_ completed.
	*
	* @param logDescription the log description of this custom_ workflow_ completed
	*/
	@Override
	public void setLogDescription(java.lang.String logDescription) {
		_custom_Workflow_Completed.setLogDescription(logDescription);
	}

	@Override
	public void setNew(boolean n) {
		_custom_Workflow_Completed.setNew(n);
	}

	/**
	* Sets the primary key of this custom_ workflow_ completed.
	*
	* @param primaryKey the primary key of this custom_ workflow_ completed
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_custom_Workflow_Completed.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_custom_Workflow_Completed.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tracking ID of this custom_ workflow_ completed.
	*
	* @param trackingId the tracking ID of this custom_ workflow_ completed
	*/
	@Override
	public void setTrackingId(long trackingId) {
		_custom_Workflow_Completed.setTrackingId(trackingId);
	}

	/**
	* Sets the trasition ID of this custom_ workflow_ completed.
	*
	* @param trasitionId the trasition ID of this custom_ workflow_ completed
	*/
	@Override
	public void setTrasitionId(long trasitionId) {
		_custom_Workflow_Completed.setTrasitionId(trasitionId);
	}

	/**
	* Sets the user ID of this custom_ workflow_ completed.
	*
	* @param userId the user ID of this custom_ workflow_ completed
	*/
	@Override
	public void setUserId(long userId) {
		_custom_Workflow_Completed.setUserId(userId);
	}

	/**
	* Sets the user uuid of this custom_ workflow_ completed.
	*
	* @param userUuid the user uuid of this custom_ workflow_ completed
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_custom_Workflow_Completed.setUserUuid(userUuid);
	}

	/**
	* Sets the workflow ID of this custom_ workflow_ completed.
	*
	* @param workflowId the workflow ID of this custom_ workflow_ completed
	*/
	@Override
	public void setWorkflowId(long workflowId) {
		_custom_Workflow_Completed.setWorkflowId(workflowId);
	}

	/**
	* Sets the workflow task ID of this custom_ workflow_ completed.
	*
	* @param workflowTaskId the workflow task ID of this custom_ workflow_ completed
	*/
	@Override
	public void setWorkflowTaskId(java.lang.String workflowTaskId) {
		_custom_Workflow_Completed.setWorkflowTaskId(workflowTaskId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_Workflow_CompletedWrapper)) {
			return false;
		}

		Custom_Workflow_CompletedWrapper custom_Workflow_CompletedWrapper = (Custom_Workflow_CompletedWrapper)obj;

		if (Objects.equals(_custom_Workflow_Completed,
					custom_Workflow_CompletedWrapper._custom_Workflow_Completed)) {
			return true;
		}

		return false;
	}

	@Override
	public Custom_Workflow_Completed getWrappedModel() {
		return _custom_Workflow_Completed;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _custom_Workflow_Completed.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _custom_Workflow_Completed.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_custom_Workflow_Completed.resetOriginalValues();
	}

	private final Custom_Workflow_Completed _custom_Workflow_Completed;
}