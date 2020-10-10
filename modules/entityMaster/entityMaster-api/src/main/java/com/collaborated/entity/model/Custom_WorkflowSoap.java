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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.Custom_WorkflowServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.Custom_WorkflowServiceSoap
 * @generated
 */
@ProviderType
public class Custom_WorkflowSoap implements Serializable {
	public static Custom_WorkflowSoap toSoapModel(Custom_Workflow model) {
		Custom_WorkflowSoap soapModel = new Custom_WorkflowSoap();

		soapModel.setWorkFlowId(model.getWorkFlowId());
		soapModel.setWorkFlowName(model.getWorkFlowName());
		soapModel.setStartWorkflowTaskId(model.getStartWorkflowTaskId());
		soapModel.setComments(model.getComments());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedBy(model.getCreatedBy());

		return soapModel;
	}

	public static Custom_WorkflowSoap[] toSoapModels(Custom_Workflow[] models) {
		Custom_WorkflowSoap[] soapModels = new Custom_WorkflowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Custom_WorkflowSoap[][] toSoapModels(
		Custom_Workflow[][] models) {
		Custom_WorkflowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Custom_WorkflowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Custom_WorkflowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Custom_WorkflowSoap[] toSoapModels(
		List<Custom_Workflow> models) {
		List<Custom_WorkflowSoap> soapModels = new ArrayList<Custom_WorkflowSoap>(models.size());

		for (Custom_Workflow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Custom_WorkflowSoap[soapModels.size()]);
	}

	public Custom_WorkflowSoap() {
	}

	public long getPrimaryKey() {
		return _workFlowId;
	}

	public void setPrimaryKey(long pk) {
		setWorkFlowId(pk);
	}

	public long getWorkFlowId() {
		return _workFlowId;
	}

	public void setWorkFlowId(long workFlowId) {
		_workFlowId = workFlowId;
	}

	public String getWorkFlowName() {
		return _workFlowName;
	}

	public void setWorkFlowName(String workFlowName) {
		_workFlowName = workFlowName;
	}

	public String getStartWorkflowTaskId() {
		return _startWorkflowTaskId;
	}

	public void setStartWorkflowTaskId(String startWorkflowTaskId) {
		_startWorkflowTaskId = startWorkflowTaskId;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public long getIsActive() {
		return _isActive;
	}

	public void setIsActive(long isActive) {
		_isActive = isActive;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	private long _workFlowId;
	private String _workFlowName;
	private String _startWorkflowTaskId;
	private String _comments;
	private long _isActive;
	private Date _createdDate;
	private long _createdBy;
}