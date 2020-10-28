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
 * The base model interface for the Custom_Workflow_Transition service. Represents a row in the &quot;collaborated_Custom_Workflow_Transition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.collaborated.entity.model.impl.Custom_Workflow_TransitionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.collaborated.entity.model.impl.Custom_Workflow_TransitionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_Transition
 * @see com.collaborated.entity.model.impl.Custom_Workflow_TransitionImpl
 * @see com.collaborated.entity.model.impl.Custom_Workflow_TransitionModelImpl
 * @generated
 */
@ProviderType
public interface Custom_Workflow_TransitionModel extends BaseModel<Custom_Workflow_Transition> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a custom_ workflow_ transition model instance should use the {@link Custom_Workflow_Transition} interface instead.
	 */

	/**
	 * Returns the primary key of this custom_ workflow_ transition.
	 *
	 * @return the primary key of this custom_ workflow_ transition
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this custom_ workflow_ transition.
	 *
	 * @param primaryKey the primary key of this custom_ workflow_ transition
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the transition ID of this custom_ workflow_ transition.
	 *
	 * @return the transition ID of this custom_ workflow_ transition
	 */
	public long getTransitionId();

	/**
	 * Sets the transition ID of this custom_ workflow_ transition.
	 *
	 * @param transitionId the transition ID of this custom_ workflow_ transition
	 */
	public void setTransitionId(long transitionId);

	/**
	 * Returns the work flow ID of this custom_ workflow_ transition.
	 *
	 * @return the work flow ID of this custom_ workflow_ transition
	 */
	public long getWorkFlowId();

	/**
	 * Sets the work flow ID of this custom_ workflow_ transition.
	 *
	 * @param workFlowId the work flow ID of this custom_ workflow_ transition
	 */
	public void setWorkFlowId(long workFlowId);

	/**
	 * Returns the work flow task ID of this custom_ workflow_ transition.
	 *
	 * @return the work flow task ID of this custom_ workflow_ transition
	 */
	@AutoEscape
	public String getWorkFlowTaskId();

	/**
	 * Sets the work flow task ID of this custom_ workflow_ transition.
	 *
	 * @param workFlowTaskId the work flow task ID of this custom_ workflow_ transition
	 */
	public void setWorkFlowTaskId(String workFlowTaskId);

	/**
	 * Returns the transition name of this custom_ workflow_ transition.
	 *
	 * @return the transition name of this custom_ workflow_ transition
	 */
	@AutoEscape
	public String getTransitionName();

	/**
	 * Sets the transition name of this custom_ workflow_ transition.
	 *
	 * @param transitionName the transition name of this custom_ workflow_ transition
	 */
	public void setTransitionName(String transitionName);

	/**
	 * Returns the log description of this custom_ workflow_ transition.
	 *
	 * @return the log description of this custom_ workflow_ transition
	 */
	@AutoEscape
	public String getLogDescription();

	/**
	 * Sets the log description of this custom_ workflow_ transition.
	 *
	 * @param logDescription the log description of this custom_ workflow_ transition
	 */
	public void setLogDescription(String logDescription);

	/**
	 * Returns the next_ work flow task ID of this custom_ workflow_ transition.
	 *
	 * @return the next_ work flow task ID of this custom_ workflow_ transition
	 */
	@AutoEscape
	public String getNext_WorkFlowTaskId();

	/**
	 * Sets the next_ work flow task ID of this custom_ workflow_ transition.
	 *
	 * @param next_WorkFlowTaskId the next_ work flow task ID of this custom_ workflow_ transition
	 */
	public void setNext_WorkFlowTaskId(String next_WorkFlowTaskId);

	/**
	 * Returns the is end of this custom_ workflow_ transition.
	 *
	 * @return the is end of this custom_ workflow_ transition
	 */
	public long getIsEnd();

	/**
	 * Sets the is end of this custom_ workflow_ transition.
	 *
	 * @param isEnd the is end of this custom_ workflow_ transition
	 */
	public void setIsEnd(long isEnd);

	/**
	 * Returns the comments of this custom_ workflow_ transition.
	 *
	 * @return the comments of this custom_ workflow_ transition
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this custom_ workflow_ transition.
	 *
	 * @param comments the comments of this custom_ workflow_ transition
	 */
	public void setComments(String comments);

	/**
	 * Returns the created date of this custom_ workflow_ transition.
	 *
	 * @return the created date of this custom_ workflow_ transition
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this custom_ workflow_ transition.
	 *
	 * @param createdDate the created date of this custom_ workflow_ transition
	 */
	public void setCreatedDate(Date createdDate);

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
	public int compareTo(Custom_Workflow_Transition custom_Workflow_Transition);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Custom_Workflow_Transition> toCacheModel();

	@Override
	public Custom_Workflow_Transition toEscapedModel();

	@Override
	public Custom_Workflow_Transition toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}