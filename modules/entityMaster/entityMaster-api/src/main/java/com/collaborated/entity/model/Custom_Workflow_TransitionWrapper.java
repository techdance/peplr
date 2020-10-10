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
 * This class is a wrapper for {@link Custom_Workflow_Transition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_Transition
 * @generated
 */
@ProviderType
public class Custom_Workflow_TransitionWrapper
	implements Custom_Workflow_Transition,
		ModelWrapper<Custom_Workflow_Transition> {
	public Custom_Workflow_TransitionWrapper(
		Custom_Workflow_Transition custom_Workflow_Transition) {
		_custom_Workflow_Transition = custom_Workflow_Transition;
	}

	@Override
	public Class<?> getModelClass() {
		return Custom_Workflow_Transition.class;
	}

	@Override
	public String getModelClassName() {
		return Custom_Workflow_Transition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transitionId", getTransitionId());
		attributes.put("workFlowId", getWorkFlowId());
		attributes.put("workFlowTaskId", getWorkFlowTaskId());
		attributes.put("transitionName", getTransitionName());
		attributes.put("logDescription", getLogDescription());
		attributes.put("next_WorkFlowTaskId", getNext_WorkFlowTaskId());
		attributes.put("isEnd", getIsEnd());
		attributes.put("comments", getComments());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long transitionId = (Long)attributes.get("transitionId");

		if (transitionId != null) {
			setTransitionId(transitionId);
		}

		Long workFlowId = (Long)attributes.get("workFlowId");

		if (workFlowId != null) {
			setWorkFlowId(workFlowId);
		}

		String workFlowTaskId = (String)attributes.get("workFlowTaskId");

		if (workFlowTaskId != null) {
			setWorkFlowTaskId(workFlowTaskId);
		}

		String transitionName = (String)attributes.get("transitionName");

		if (transitionName != null) {
			setTransitionName(transitionName);
		}

		String logDescription = (String)attributes.get("logDescription");

		if (logDescription != null) {
			setLogDescription(logDescription);
		}

		String next_WorkFlowTaskId = (String)attributes.get(
				"next_WorkFlowTaskId");

		if (next_WorkFlowTaskId != null) {
			setNext_WorkFlowTaskId(next_WorkFlowTaskId);
		}

		Long isEnd = (Long)attributes.get("isEnd");

		if (isEnd != null) {
			setIsEnd(isEnd);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public Custom_Workflow_Transition toEscapedModel() {
		return new Custom_Workflow_TransitionWrapper(_custom_Workflow_Transition.toEscapedModel());
	}

	@Override
	public Custom_Workflow_Transition toUnescapedModel() {
		return new Custom_Workflow_TransitionWrapper(_custom_Workflow_Transition.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _custom_Workflow_Transition.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _custom_Workflow_Transition.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _custom_Workflow_Transition.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _custom_Workflow_Transition.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Custom_Workflow_Transition> toCacheModel() {
		return _custom_Workflow_Transition.toCacheModel();
	}

	@Override
	public int compareTo(Custom_Workflow_Transition custom_Workflow_Transition) {
		return _custom_Workflow_Transition.compareTo(custom_Workflow_Transition);
	}

	@Override
	public int hashCode() {
		return _custom_Workflow_Transition.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _custom_Workflow_Transition.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Custom_Workflow_TransitionWrapper((Custom_Workflow_Transition)_custom_Workflow_Transition.clone());
	}

	/**
	* Returns the comments of this custom_ workflow_ transition.
	*
	* @return the comments of this custom_ workflow_ transition
	*/
	@Override
	public java.lang.String getComments() {
		return _custom_Workflow_Transition.getComments();
	}

	/**
	* Returns the log description of this custom_ workflow_ transition.
	*
	* @return the log description of this custom_ workflow_ transition
	*/
	@Override
	public java.lang.String getLogDescription() {
		return _custom_Workflow_Transition.getLogDescription();
	}

	/**
	* Returns the next_ work flow task ID of this custom_ workflow_ transition.
	*
	* @return the next_ work flow task ID of this custom_ workflow_ transition
	*/
	@Override
	public java.lang.String getNext_WorkFlowTaskId() {
		return _custom_Workflow_Transition.getNext_WorkFlowTaskId();
	}

	/**
	* Returns the transition name of this custom_ workflow_ transition.
	*
	* @return the transition name of this custom_ workflow_ transition
	*/
	@Override
	public java.lang.String getTransitionName() {
		return _custom_Workflow_Transition.getTransitionName();
	}

	/**
	* Returns the work flow task ID of this custom_ workflow_ transition.
	*
	* @return the work flow task ID of this custom_ workflow_ transition
	*/
	@Override
	public java.lang.String getWorkFlowTaskId() {
		return _custom_Workflow_Transition.getWorkFlowTaskId();
	}

	@Override
	public java.lang.String toString() {
		return _custom_Workflow_Transition.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _custom_Workflow_Transition.toXmlString();
	}

	/**
	* Returns the created date of this custom_ workflow_ transition.
	*
	* @return the created date of this custom_ workflow_ transition
	*/
	@Override
	public Date getCreatedDate() {
		return _custom_Workflow_Transition.getCreatedDate();
	}

	/**
	* Returns the is end of this custom_ workflow_ transition.
	*
	* @return the is end of this custom_ workflow_ transition
	*/
	@Override
	public long getIsEnd() {
		return _custom_Workflow_Transition.getIsEnd();
	}

	/**
	* Returns the primary key of this custom_ workflow_ transition.
	*
	* @return the primary key of this custom_ workflow_ transition
	*/
	@Override
	public long getPrimaryKey() {
		return _custom_Workflow_Transition.getPrimaryKey();
	}

	/**
	* Returns the transition ID of this custom_ workflow_ transition.
	*
	* @return the transition ID of this custom_ workflow_ transition
	*/
	@Override
	public long getTransitionId() {
		return _custom_Workflow_Transition.getTransitionId();
	}

	/**
	* Returns the work flow ID of this custom_ workflow_ transition.
	*
	* @return the work flow ID of this custom_ workflow_ transition
	*/
	@Override
	public long getWorkFlowId() {
		return _custom_Workflow_Transition.getWorkFlowId();
	}

	@Override
	public void persist() {
		_custom_Workflow_Transition.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_custom_Workflow_Transition.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this custom_ workflow_ transition.
	*
	* @param comments the comments of this custom_ workflow_ transition
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_custom_Workflow_Transition.setComments(comments);
	}

	/**
	* Sets the created date of this custom_ workflow_ transition.
	*
	* @param createdDate the created date of this custom_ workflow_ transition
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_custom_Workflow_Transition.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_custom_Workflow_Transition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_custom_Workflow_Transition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_custom_Workflow_Transition.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the is end of this custom_ workflow_ transition.
	*
	* @param isEnd the is end of this custom_ workflow_ transition
	*/
	@Override
	public void setIsEnd(long isEnd) {
		_custom_Workflow_Transition.setIsEnd(isEnd);
	}

	/**
	* Sets the log description of this custom_ workflow_ transition.
	*
	* @param logDescription the log description of this custom_ workflow_ transition
	*/
	@Override
	public void setLogDescription(java.lang.String logDescription) {
		_custom_Workflow_Transition.setLogDescription(logDescription);
	}

	@Override
	public void setNew(boolean n) {
		_custom_Workflow_Transition.setNew(n);
	}

	/**
	* Sets the next_ work flow task ID of this custom_ workflow_ transition.
	*
	* @param next_WorkFlowTaskId the next_ work flow task ID of this custom_ workflow_ transition
	*/
	@Override
	public void setNext_WorkFlowTaskId(java.lang.String next_WorkFlowTaskId) {
		_custom_Workflow_Transition.setNext_WorkFlowTaskId(next_WorkFlowTaskId);
	}

	/**
	* Sets the primary key of this custom_ workflow_ transition.
	*
	* @param primaryKey the primary key of this custom_ workflow_ transition
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_custom_Workflow_Transition.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_custom_Workflow_Transition.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the transition ID of this custom_ workflow_ transition.
	*
	* @param transitionId the transition ID of this custom_ workflow_ transition
	*/
	@Override
	public void setTransitionId(long transitionId) {
		_custom_Workflow_Transition.setTransitionId(transitionId);
	}

	/**
	* Sets the transition name of this custom_ workflow_ transition.
	*
	* @param transitionName the transition name of this custom_ workflow_ transition
	*/
	@Override
	public void setTransitionName(java.lang.String transitionName) {
		_custom_Workflow_Transition.setTransitionName(transitionName);
	}

	/**
	* Sets the work flow ID of this custom_ workflow_ transition.
	*
	* @param workFlowId the work flow ID of this custom_ workflow_ transition
	*/
	@Override
	public void setWorkFlowId(long workFlowId) {
		_custom_Workflow_Transition.setWorkFlowId(workFlowId);
	}

	/**
	* Sets the work flow task ID of this custom_ workflow_ transition.
	*
	* @param workFlowTaskId the work flow task ID of this custom_ workflow_ transition
	*/
	@Override
	public void setWorkFlowTaskId(java.lang.String workFlowTaskId) {
		_custom_Workflow_Transition.setWorkFlowTaskId(workFlowTaskId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_Workflow_TransitionWrapper)) {
			return false;
		}

		Custom_Workflow_TransitionWrapper custom_Workflow_TransitionWrapper = (Custom_Workflow_TransitionWrapper)obj;

		if (Objects.equals(_custom_Workflow_Transition,
					custom_Workflow_TransitionWrapper._custom_Workflow_Transition)) {
			return true;
		}

		return false;
	}

	@Override
	public Custom_Workflow_Transition getWrappedModel() {
		return _custom_Workflow_Transition;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _custom_Workflow_Transition.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _custom_Workflow_Transition.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_custom_Workflow_Transition.resetOriginalValues();
	}

	private final Custom_Workflow_Transition _custom_Workflow_Transition;
}