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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labScreenTaskServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labScreenTaskServiceSoap
 * @generated
 */
@ProviderType
public class labScreenTaskSoap implements Serializable {
	public static labScreenTaskSoap toSoapModel(labScreenTask model) {
		labScreenTaskSoap soapModel = new labScreenTaskSoap();

		soapModel.setPK_taskId(model.getPK_taskId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setMilestoneName(model.getMilestoneName());
		soapModel.setTaskName(model.getTaskName());
		soapModel.setProjectAssignedTo(model.getProjectAssignedTo());
		soapModel.setTaskDescription(model.getTaskDescription());
		soapModel.setTaskStatus(model.getTaskStatus());
		soapModel.setDueDate(model.getDueDate());

		return soapModel;
	}

	public static labScreenTaskSoap[] toSoapModels(labScreenTask[] models) {
		labScreenTaskSoap[] soapModels = new labScreenTaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labScreenTaskSoap[][] toSoapModels(labScreenTask[][] models) {
		labScreenTaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labScreenTaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labScreenTaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labScreenTaskSoap[] toSoapModels(List<labScreenTask> models) {
		List<labScreenTaskSoap> soapModels = new ArrayList<labScreenTaskSoap>(models.size());

		for (labScreenTask model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labScreenTaskSoap[soapModels.size()]);
	}

	public labScreenTaskSoap() {
	}

	public long getPrimaryKey() {
		return _PK_taskId;
	}

	public void setPrimaryKey(long pk) {
		setPK_taskId(pk);
	}

	public long getPK_taskId() {
		return _PK_taskId;
	}

	public void setPK_taskId(long PK_taskId) {
		_PK_taskId = PK_taskId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getPK_projectId() {
		return _PK_projectId;
	}

	public void setPK_projectId(long PK_projectId) {
		_PK_projectId = PK_projectId;
	}

	public String getMilestoneName() {
		return _milestoneName;
	}

	public void setMilestoneName(String milestoneName) {
		_milestoneName = milestoneName;
	}

	public String getTaskName() {
		return _taskName;
	}

	public void setTaskName(String taskName) {
		_taskName = taskName;
	}

	public long getProjectAssignedTo() {
		return _projectAssignedTo;
	}

	public void setProjectAssignedTo(long projectAssignedTo) {
		_projectAssignedTo = projectAssignedTo;
	}

	public String getTaskDescription() {
		return _taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		_taskDescription = taskDescription;
	}

	public String getTaskStatus() {
		return _taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		_taskStatus = taskStatus;
	}

	public String getDueDate() {
		return _dueDate;
	}

	public void setDueDate(String dueDate) {
		_dueDate = dueDate;
	}

	private long _PK_taskId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectId;
	private String _milestoneName;
	private String _taskName;
	private long _projectAssignedTo;
	private String _taskDescription;
	private String _taskStatus;
	private String _dueDate;
}