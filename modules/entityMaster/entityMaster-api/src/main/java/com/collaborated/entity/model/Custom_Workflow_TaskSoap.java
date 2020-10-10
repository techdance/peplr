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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.Custom_Workflow_TaskServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.Custom_Workflow_TaskServiceSoap
 * @generated
 */
@ProviderType
public class Custom_Workflow_TaskSoap implements Serializable {
	public static Custom_Workflow_TaskSoap toSoapModel(
		Custom_Workflow_Task model) {
		Custom_Workflow_TaskSoap soapModel = new Custom_Workflow_TaskSoap();

		soapModel.setWorkFlowTaskId(model.getWorkFlowTaskId());
		soapModel.setWorkFlowId(model.getWorkFlowId());
		soapModel.setTaskName(model.getTaskName());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setRoleName(model.getRoleName());
		soapModel.setComments(model.getComments());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedBy(model.getCreatedBy());

		return soapModel;
	}

	public static Custom_Workflow_TaskSoap[] toSoapModels(
		Custom_Workflow_Task[] models) {
		Custom_Workflow_TaskSoap[] soapModels = new Custom_Workflow_TaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Custom_Workflow_TaskSoap[][] toSoapModels(
		Custom_Workflow_Task[][] models) {
		Custom_Workflow_TaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Custom_Workflow_TaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Custom_Workflow_TaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Custom_Workflow_TaskSoap[] toSoapModels(
		List<Custom_Workflow_Task> models) {
		List<Custom_Workflow_TaskSoap> soapModels = new ArrayList<Custom_Workflow_TaskSoap>(models.size());

		for (Custom_Workflow_Task model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Custom_Workflow_TaskSoap[soapModels.size()]);
	}

	public Custom_Workflow_TaskSoap() {
	}

	public String getPrimaryKey() {
		return _workFlowTaskId;
	}

	public void setPrimaryKey(String pk) {
		setWorkFlowTaskId(pk);
	}

	public String getWorkFlowTaskId() {
		return _workFlowTaskId;
	}

	public void setWorkFlowTaskId(String workFlowTaskId) {
		_workFlowTaskId = workFlowTaskId;
	}

	public long getWorkFlowId() {
		return _workFlowId;
	}

	public void setWorkFlowId(long workFlowId) {
		_workFlowId = workFlowId;
	}

	public String getTaskName() {
		return _taskName;
	}

	public void setTaskName(String taskName) {
		_taskName = taskName;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public String getRoleName() {
		return _roleName;
	}

	public void setRoleName(String roleName) {
		_roleName = roleName;
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

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	private String _workFlowTaskId;
	private long _workFlowId;
	private String _taskName;
	private long _roleId;
	private String _roleName;
	private String _comments;
	private Date _createdDate;
	private long _createdBy;
}