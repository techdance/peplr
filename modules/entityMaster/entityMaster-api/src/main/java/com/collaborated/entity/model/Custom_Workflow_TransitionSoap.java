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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.Custom_Workflow_TransitionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.Custom_Workflow_TransitionServiceSoap
 * @generated
 */
@ProviderType
public class Custom_Workflow_TransitionSoap implements Serializable {
	public static Custom_Workflow_TransitionSoap toSoapModel(
		Custom_Workflow_Transition model) {
		Custom_Workflow_TransitionSoap soapModel = new Custom_Workflow_TransitionSoap();

		soapModel.setTransitionId(model.getTransitionId());
		soapModel.setWorkFlowId(model.getWorkFlowId());
		soapModel.setWorkFlowTaskId(model.getWorkFlowTaskId());
		soapModel.setTransitionName(model.getTransitionName());
		soapModel.setLogDescription(model.getLogDescription());
		soapModel.setNext_WorkFlowTaskId(model.getNext_WorkFlowTaskId());
		soapModel.setIsEnd(model.getIsEnd());
		soapModel.setComments(model.getComments());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static Custom_Workflow_TransitionSoap[] toSoapModels(
		Custom_Workflow_Transition[] models) {
		Custom_Workflow_TransitionSoap[] soapModels = new Custom_Workflow_TransitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Custom_Workflow_TransitionSoap[][] toSoapModels(
		Custom_Workflow_Transition[][] models) {
		Custom_Workflow_TransitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Custom_Workflow_TransitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Custom_Workflow_TransitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Custom_Workflow_TransitionSoap[] toSoapModels(
		List<Custom_Workflow_Transition> models) {
		List<Custom_Workflow_TransitionSoap> soapModels = new ArrayList<Custom_Workflow_TransitionSoap>(models.size());

		for (Custom_Workflow_Transition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Custom_Workflow_TransitionSoap[soapModels.size()]);
	}

	public Custom_Workflow_TransitionSoap() {
	}

	public long getPrimaryKey() {
		return _transitionId;
	}

	public void setPrimaryKey(long pk) {
		setTransitionId(pk);
	}

	public long getTransitionId() {
		return _transitionId;
	}

	public void setTransitionId(long transitionId) {
		_transitionId = transitionId;
	}

	public long getWorkFlowId() {
		return _workFlowId;
	}

	public void setWorkFlowId(long workFlowId) {
		_workFlowId = workFlowId;
	}

	public String getWorkFlowTaskId() {
		return _workFlowTaskId;
	}

	public void setWorkFlowTaskId(String workFlowTaskId) {
		_workFlowTaskId = workFlowTaskId;
	}

	public String getTransitionName() {
		return _transitionName;
	}

	public void setTransitionName(String transitionName) {
		_transitionName = transitionName;
	}

	public String getLogDescription() {
		return _logDescription;
	}

	public void setLogDescription(String logDescription) {
		_logDescription = logDescription;
	}

	public String getNext_WorkFlowTaskId() {
		return _next_WorkFlowTaskId;
	}

	public void setNext_WorkFlowTaskId(String next_WorkFlowTaskId) {
		_next_WorkFlowTaskId = next_WorkFlowTaskId;
	}

	public long getIsEnd() {
		return _isEnd;
	}

	public void setIsEnd(long isEnd) {
		_isEnd = isEnd;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _transitionId;
	private long _workFlowId;
	private String _workFlowTaskId;
	private String _transitionName;
	private String _logDescription;
	private String _next_WorkFlowTaskId;
	private long _isEnd;
	private String _comments;
	private Date _createdDate;
}