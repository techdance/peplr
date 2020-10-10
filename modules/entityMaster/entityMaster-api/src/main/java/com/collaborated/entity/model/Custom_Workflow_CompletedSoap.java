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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.Custom_Workflow_CompletedServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.Custom_Workflow_CompletedServiceSoap
 * @generated
 */
@ProviderType
public class Custom_Workflow_CompletedSoap implements Serializable {
	public static Custom_Workflow_CompletedSoap toSoapModel(
		Custom_Workflow_Completed model) {
		Custom_Workflow_CompletedSoap soapModel = new Custom_Workflow_CompletedSoap();

		soapModel.setCId(model.getCId());
		soapModel.setTrackingId(model.getTrackingId());
		soapModel.setWorkflowId(model.getWorkflowId());
		soapModel.setWorkflowTaskId(model.getWorkflowTaskId());
		soapModel.setTrasitionId(model.getTrasitionId());
		soapModel.setLogDescription(model.getLogDescription());
		soapModel.setComments(model.getComments());
		soapModel.setCompletedDate(model.getCompletedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static Custom_Workflow_CompletedSoap[] toSoapModels(
		Custom_Workflow_Completed[] models) {
		Custom_Workflow_CompletedSoap[] soapModels = new Custom_Workflow_CompletedSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Custom_Workflow_CompletedSoap[][] toSoapModels(
		Custom_Workflow_Completed[][] models) {
		Custom_Workflow_CompletedSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Custom_Workflow_CompletedSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Custom_Workflow_CompletedSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Custom_Workflow_CompletedSoap[] toSoapModels(
		List<Custom_Workflow_Completed> models) {
		List<Custom_Workflow_CompletedSoap> soapModels = new ArrayList<Custom_Workflow_CompletedSoap>(models.size());

		for (Custom_Workflow_Completed model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Custom_Workflow_CompletedSoap[soapModels.size()]);
	}

	public Custom_Workflow_CompletedSoap() {
	}

	public long getPrimaryKey() {
		return _cId;
	}

	public void setPrimaryKey(long pk) {
		setCId(pk);
	}

	public long getCId() {
		return _cId;
	}

	public void setCId(long cId) {
		_cId = cId;
	}

	public long getTrackingId() {
		return _trackingId;
	}

	public void setTrackingId(long trackingId) {
		_trackingId = trackingId;
	}

	public long getWorkflowId() {
		return _workflowId;
	}

	public void setWorkflowId(long workflowId) {
		_workflowId = workflowId;
	}

	public String getWorkflowTaskId() {
		return _workflowTaskId;
	}

	public void setWorkflowTaskId(String workflowTaskId) {
		_workflowTaskId = workflowTaskId;
	}

	public long getTrasitionId() {
		return _trasitionId;
	}

	public void setTrasitionId(long trasitionId) {
		_trasitionId = trasitionId;
	}

	public String getLogDescription() {
		return _logDescription;
	}

	public void setLogDescription(String logDescription) {
		_logDescription = logDescription;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public Date getCompletedDate() {
		return _completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		_completedDate = completedDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _cId;
	private long _trackingId;
	private long _workflowId;
	private String _workflowTaskId;
	private long _trasitionId;
	private String _logDescription;
	private String _comments;
	private Date _completedDate;
	private long _userId;
	private Date _createdDate;
}