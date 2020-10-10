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
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labScreenProjectOverviewServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labScreenProjectOverviewServiceSoap
 * @generated
 */
@ProviderType
public class labScreenProjectOverviewSoap implements Serializable {
	public static labScreenProjectOverviewSoap toSoapModel(
		labScreenProjectOverview model) {
		labScreenProjectOverviewSoap soapModel = new labScreenProjectOverviewSoap();

		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProjectOwnerId(model.getProjectOwnerId());
		soapModel.setProjectName(model.getProjectName());
		soapModel.setProjectType(model.getProjectType());
		soapModel.setProjectDescription(model.getProjectDescription());
		soapModel.setProjectDiscipline1(model.getProjectDiscipline1());
		soapModel.setProjectDiscipline2(model.getProjectDiscipline2());
		soapModel.setProjectDiscipline3(model.getProjectDiscipline3());
		soapModel.setRole(model.getRole());
		soapModel.setProjectStartDate(model.getProjectStartDate());
		soapModel.setProjectEndDate(model.getProjectEndDate());
		soapModel.setProjectDocumentId(model.getProjectDocumentId());
		soapModel.setPercentage(model.getPercentage());
		soapModel.setInterestId(model.getInterestId());
		soapModel.setProjectStatus(model.getProjectStatus());

		return soapModel;
	}

	public static labScreenProjectOverviewSoap[] toSoapModels(
		labScreenProjectOverview[] models) {
		labScreenProjectOverviewSoap[] soapModels = new labScreenProjectOverviewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labScreenProjectOverviewSoap[][] toSoapModels(
		labScreenProjectOverview[][] models) {
		labScreenProjectOverviewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labScreenProjectOverviewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labScreenProjectOverviewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labScreenProjectOverviewSoap[] toSoapModels(
		List<labScreenProjectOverview> models) {
		List<labScreenProjectOverviewSoap> soapModels = new ArrayList<labScreenProjectOverviewSoap>(models.size());

		for (labScreenProjectOverview model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labScreenProjectOverviewSoap[soapModels.size()]);
	}

	public labScreenProjectOverviewSoap() {
	}

	public long getPrimaryKey() {
		return _PK_projectId;
	}

	public void setPrimaryKey(long pk) {
		setPK_projectId(pk);
	}

	public long getPK_projectId() {
		return _PK_projectId;
	}

	public void setPK_projectId(long PK_projectId) {
		_PK_projectId = PK_projectId;
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

	public long getProjectOwnerId() {
		return _projectOwnerId;
	}

	public void setProjectOwnerId(long projectOwnerId) {
		_projectOwnerId = projectOwnerId;
	}

	public String getProjectName() {
		return _projectName;
	}

	public void setProjectName(String projectName) {
		_projectName = projectName;
	}

	public String getProjectType() {
		return _projectType;
	}

	public void setProjectType(String projectType) {
		_projectType = projectType;
	}

	public String getProjectDescription() {
		return _projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		_projectDescription = projectDescription;
	}

	public String getProjectDiscipline1() {
		return _projectDiscipline1;
	}

	public void setProjectDiscipline1(String projectDiscipline1) {
		_projectDiscipline1 = projectDiscipline1;
	}

	public String getProjectDiscipline2() {
		return _projectDiscipline2;
	}

	public void setProjectDiscipline2(String projectDiscipline2) {
		_projectDiscipline2 = projectDiscipline2;
	}

	public String getProjectDiscipline3() {
		return _projectDiscipline3;
	}

	public void setProjectDiscipline3(String projectDiscipline3) {
		_projectDiscipline3 = projectDiscipline3;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public String getProjectStartDate() {
		return _projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		_projectStartDate = projectStartDate;
	}

	public String getProjectEndDate() {
		return _projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		_projectEndDate = projectEndDate;
	}

	public long getProjectDocumentId() {
		return _projectDocumentId;
	}

	public void setProjectDocumentId(long projectDocumentId) {
		_projectDocumentId = projectDocumentId;
	}

	public long getPercentage() {
		return _percentage;
	}

	public void setPercentage(long percentage) {
		_percentage = percentage;
	}

	public long getInterestId() {
		return _interestId;
	}

	public void setInterestId(long interestId) {
		_interestId = interestId;
	}

	public String getProjectStatus() {
		return _projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		_projectStatus = projectStatus;
	}

	private long _PK_projectId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _projectOwnerId;
	private String _projectName;
	private String _projectType;
	private String _projectDescription;
	private String _projectDiscipline1;
	private String _projectDiscipline2;
	private String _projectDiscipline3;
	private String _role;
	private String _projectStartDate;
	private String _projectEndDate;
	private long _projectDocumentId;
	private long _percentage;
	private long _interestId;
	private String _projectStatus;
}