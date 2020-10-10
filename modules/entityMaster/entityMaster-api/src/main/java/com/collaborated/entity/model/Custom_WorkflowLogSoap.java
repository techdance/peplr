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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.Custom_WorkflowLogServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.Custom_WorkflowLogServiceSoap
 * @generated
 */
@ProviderType
public class Custom_WorkflowLogSoap implements Serializable {
	public static Custom_WorkflowLogSoap toSoapModel(Custom_WorkflowLog model) {
		Custom_WorkflowLogSoap soapModel = new Custom_WorkflowLogSoap();

		soapModel.setLogId(model.getLogId());
		soapModel.setTrackingId(model.getTrackingId());
		soapModel.setWorkflowId(model.getWorkflowId());
		soapModel.setWorkflowTaskId(model.getWorkflowTaskId());
		soapModel.setTrasitionId(model.getTrasitionId());
		soapModel.setLogDescription(model.getLogDescription());
		soapModel.setComments(model.getComments());
		soapModel.setAssigneeClassPK(model.getAssigneeClassPK());
		soapModel.setClassName(model.getClassName());
		soapModel.setAssignedDate(model.getAssignedDate());
		soapModel.setCompletedDate(model.getCompletedDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static Custom_WorkflowLogSoap[] toSoapModels(
		Custom_WorkflowLog[] models) {
		Custom_WorkflowLogSoap[] soapModels = new Custom_WorkflowLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Custom_WorkflowLogSoap[][] toSoapModels(
		Custom_WorkflowLog[][] models) {
		Custom_WorkflowLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Custom_WorkflowLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Custom_WorkflowLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Custom_WorkflowLogSoap[] toSoapModels(
		List<Custom_WorkflowLog> models) {
		List<Custom_WorkflowLogSoap> soapModels = new ArrayList<Custom_WorkflowLogSoap>(models.size());

		for (Custom_WorkflowLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Custom_WorkflowLogSoap[soapModels.size()]);
	}

	public Custom_WorkflowLogSoap() {
	}

	public long getPrimaryKey() {
		return _logId;
	}

	public void setPrimaryKey(long pk) {
		setLogId(pk);
	}

	public long getLogId() {
		return _logId;
	}

	public void setLogId(long logId) {
		_logId = logId;
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

	public long getAssigneeClassPK() {
		return _assigneeClassPK;
	}

	public void setAssigneeClassPK(long assigneeClassPK) {
		_assigneeClassPK = assigneeClassPK;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public Date getAssignedDate() {
		return _assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		_assignedDate = assignedDate;
	}

	public Date getCompletedDate() {
		return _completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		_completedDate = completedDate;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _logId;
	private long _trackingId;
	private long _workflowId;
	private String _workflowTaskId;
	private long _trasitionId;
	private String _logDescription;
	private String _comments;
	private long _assigneeClassPK;
	private String _className;
	private Date _assignedDate;
	private Date _completedDate;
	private long _createdBy;
	private Date _createdDate;
}