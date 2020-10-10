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
 * This class is a wrapper for {@link labScreenProjectOverview}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectOverview
 * @generated
 */
@ProviderType
public class labScreenProjectOverviewWrapper implements labScreenProjectOverview,
	ModelWrapper<labScreenProjectOverview> {
	public labScreenProjectOverviewWrapper(
		labScreenProjectOverview labScreenProjectOverview) {
		_labScreenProjectOverview = labScreenProjectOverview;
	}

	@Override
	public Class<?> getModelClass() {
		return labScreenProjectOverview.class;
	}

	@Override
	public String getModelClassName() {
		return labScreenProjectOverview.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("projectOwnerId", getProjectOwnerId());
		attributes.put("projectName", getProjectName());
		attributes.put("projectType", getProjectType());
		attributes.put("projectDescription", getProjectDescription());
		attributes.put("projectDiscipline1", getProjectDiscipline1());
		attributes.put("projectDiscipline2", getProjectDiscipline2());
		attributes.put("projectDiscipline3", getProjectDiscipline3());
		attributes.put("role", getRole());
		attributes.put("projectStartDate", getProjectStartDate());
		attributes.put("projectEndDate", getProjectEndDate());
		attributes.put("projectDocumentId", getProjectDocumentId());
		attributes.put("percentage", getPercentage());
		attributes.put("interestId", getInterestId());
		attributes.put("projectStatus", getProjectStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_projectId = (Long)attributes.get("PK_projectId");

		if (PK_projectId != null) {
			setPK_projectId(PK_projectId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long projectOwnerId = (Long)attributes.get("projectOwnerId");

		if (projectOwnerId != null) {
			setProjectOwnerId(projectOwnerId);
		}

		String projectName = (String)attributes.get("projectName");

		if (projectName != null) {
			setProjectName(projectName);
		}

		String projectType = (String)attributes.get("projectType");

		if (projectType != null) {
			setProjectType(projectType);
		}

		String projectDescription = (String)attributes.get("projectDescription");

		if (projectDescription != null) {
			setProjectDescription(projectDescription);
		}

		String projectDiscipline1 = (String)attributes.get("projectDiscipline1");

		if (projectDiscipline1 != null) {
			setProjectDiscipline1(projectDiscipline1);
		}

		String projectDiscipline2 = (String)attributes.get("projectDiscipline2");

		if (projectDiscipline2 != null) {
			setProjectDiscipline2(projectDiscipline2);
		}

		String projectDiscipline3 = (String)attributes.get("projectDiscipline3");

		if (projectDiscipline3 != null) {
			setProjectDiscipline3(projectDiscipline3);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		String projectStartDate = (String)attributes.get("projectStartDate");

		if (projectStartDate != null) {
			setProjectStartDate(projectStartDate);
		}

		String projectEndDate = (String)attributes.get("projectEndDate");

		if (projectEndDate != null) {
			setProjectEndDate(projectEndDate);
		}

		Long projectDocumentId = (Long)attributes.get("projectDocumentId");

		if (projectDocumentId != null) {
			setProjectDocumentId(projectDocumentId);
		}

		Long percentage = (Long)attributes.get("percentage");

		if (percentage != null) {
			setPercentage(percentage);
		}

		Long interestId = (Long)attributes.get("interestId");

		if (interestId != null) {
			setInterestId(interestId);
		}

		String projectStatus = (String)attributes.get("projectStatus");

		if (projectStatus != null) {
			setProjectStatus(projectStatus);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labScreenProjectOverview.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labScreenProjectOverview.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labScreenProjectOverview.isNew();
	}

	@Override
	public com.collaborated.entity.model.labScreenProjectOverview toEscapedModel() {
		return new labScreenProjectOverviewWrapper(_labScreenProjectOverview.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labScreenProjectOverview toUnescapedModel() {
		return new labScreenProjectOverviewWrapper(_labScreenProjectOverview.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labScreenProjectOverview.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labScreenProjectOverview> toCacheModel() {
		return _labScreenProjectOverview.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labScreenProjectOverview labScreenProjectOverview) {
		return _labScreenProjectOverview.compareTo(labScreenProjectOverview);
	}

	@Override
	public int hashCode() {
		return _labScreenProjectOverview.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labScreenProjectOverview.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labScreenProjectOverviewWrapper((labScreenProjectOverview)_labScreenProjectOverview.clone());
	}

	/**
	* Returns the project description of this lab screen project overview.
	*
	* @return the project description of this lab screen project overview
	*/
	@Override
	public java.lang.String getProjectDescription() {
		return _labScreenProjectOverview.getProjectDescription();
	}

	/**
	* Returns the project discipline1 of this lab screen project overview.
	*
	* @return the project discipline1 of this lab screen project overview
	*/
	@Override
	public java.lang.String getProjectDiscipline1() {
		return _labScreenProjectOverview.getProjectDiscipline1();
	}

	/**
	* Returns the project discipline2 of this lab screen project overview.
	*
	* @return the project discipline2 of this lab screen project overview
	*/
	@Override
	public java.lang.String getProjectDiscipline2() {
		return _labScreenProjectOverview.getProjectDiscipline2();
	}

	/**
	* Returns the project discipline3 of this lab screen project overview.
	*
	* @return the project discipline3 of this lab screen project overview
	*/
	@Override
	public java.lang.String getProjectDiscipline3() {
		return _labScreenProjectOverview.getProjectDiscipline3();
	}

	/**
	* Returns the project end date of this lab screen project overview.
	*
	* @return the project end date of this lab screen project overview
	*/
	@Override
	public java.lang.String getProjectEndDate() {
		return _labScreenProjectOverview.getProjectEndDate();
	}

	/**
	* Returns the project name of this lab screen project overview.
	*
	* @return the project name of this lab screen project overview
	*/
	@Override
	public java.lang.String getProjectName() {
		return _labScreenProjectOverview.getProjectName();
	}

	/**
	* Returns the project start date of this lab screen project overview.
	*
	* @return the project start date of this lab screen project overview
	*/
	@Override
	public java.lang.String getProjectStartDate() {
		return _labScreenProjectOverview.getProjectStartDate();
	}

	/**
	* Returns the project status of this lab screen project overview.
	*
	* @return the project status of this lab screen project overview
	*/
	@Override
	public java.lang.String getProjectStatus() {
		return _labScreenProjectOverview.getProjectStatus();
	}

	/**
	* Returns the project type of this lab screen project overview.
	*
	* @return the project type of this lab screen project overview
	*/
	@Override
	public java.lang.String getProjectType() {
		return _labScreenProjectOverview.getProjectType();
	}

	/**
	* Returns the role of this lab screen project overview.
	*
	* @return the role of this lab screen project overview
	*/
	@Override
	public java.lang.String getRole() {
		return _labScreenProjectOverview.getRole();
	}

	/**
	* Returns the user uuid of this lab screen project overview.
	*
	* @return the user uuid of this lab screen project overview
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labScreenProjectOverview.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labScreenProjectOverview.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labScreenProjectOverview.toXmlString();
	}

	/**
	* Returns the create date of this lab screen project overview.
	*
	* @return the create date of this lab screen project overview
	*/
	@Override
	public Date getCreateDate() {
		return _labScreenProjectOverview.getCreateDate();
	}

	/**
	* Returns the modified date of this lab screen project overview.
	*
	* @return the modified date of this lab screen project overview
	*/
	@Override
	public Date getModifiedDate() {
		return _labScreenProjectOverview.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab screen project overview.
	*
	* @return the group ID of this lab screen project overview
	*/
	@Override
	public long getGroupId() {
		return _labScreenProjectOverview.getGroupId();
	}

	/**
	* Returns the interest ID of this lab screen project overview.
	*
	* @return the interest ID of this lab screen project overview
	*/
	@Override
	public long getInterestId() {
		return _labScreenProjectOverview.getInterestId();
	}

	/**
	* Returns the p k_project ID of this lab screen project overview.
	*
	* @return the p k_project ID of this lab screen project overview
	*/
	@Override
	public long getPK_projectId() {
		return _labScreenProjectOverview.getPK_projectId();
	}

	/**
	* Returns the percentage of this lab screen project overview.
	*
	* @return the percentage of this lab screen project overview
	*/
	@Override
	public long getPercentage() {
		return _labScreenProjectOverview.getPercentage();
	}

	/**
	* Returns the primary key of this lab screen project overview.
	*
	* @return the primary key of this lab screen project overview
	*/
	@Override
	public long getPrimaryKey() {
		return _labScreenProjectOverview.getPrimaryKey();
	}

	/**
	* Returns the project document ID of this lab screen project overview.
	*
	* @return the project document ID of this lab screen project overview
	*/
	@Override
	public long getProjectDocumentId() {
		return _labScreenProjectOverview.getProjectDocumentId();
	}

	/**
	* Returns the project owner ID of this lab screen project overview.
	*
	* @return the project owner ID of this lab screen project overview
	*/
	@Override
	public long getProjectOwnerId() {
		return _labScreenProjectOverview.getProjectOwnerId();
	}

	/**
	* Returns the user ID of this lab screen project overview.
	*
	* @return the user ID of this lab screen project overview
	*/
	@Override
	public long getUserId() {
		return _labScreenProjectOverview.getUserId();
	}

	@Override
	public void persist() {
		_labScreenProjectOverview.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labScreenProjectOverview.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this lab screen project overview.
	*
	* @param createDate the create date of this lab screen project overview
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labScreenProjectOverview.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labScreenProjectOverview.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labScreenProjectOverview.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labScreenProjectOverview.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab screen project overview.
	*
	* @param groupId the group ID of this lab screen project overview
	*/
	@Override
	public void setGroupId(long groupId) {
		_labScreenProjectOverview.setGroupId(groupId);
	}

	/**
	* Sets the interest ID of this lab screen project overview.
	*
	* @param interestId the interest ID of this lab screen project overview
	*/
	@Override
	public void setInterestId(long interestId) {
		_labScreenProjectOverview.setInterestId(interestId);
	}

	/**
	* Sets the modified date of this lab screen project overview.
	*
	* @param modifiedDate the modified date of this lab screen project overview
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labScreenProjectOverview.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labScreenProjectOverview.setNew(n);
	}

	/**
	* Sets the p k_project ID of this lab screen project overview.
	*
	* @param PK_projectId the p k_project ID of this lab screen project overview
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labScreenProjectOverview.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the percentage of this lab screen project overview.
	*
	* @param percentage the percentage of this lab screen project overview
	*/
	@Override
	public void setPercentage(long percentage) {
		_labScreenProjectOverview.setPercentage(percentage);
	}

	/**
	* Sets the primary key of this lab screen project overview.
	*
	* @param primaryKey the primary key of this lab screen project overview
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labScreenProjectOverview.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labScreenProjectOverview.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project description of this lab screen project overview.
	*
	* @param projectDescription the project description of this lab screen project overview
	*/
	@Override
	public void setProjectDescription(java.lang.String projectDescription) {
		_labScreenProjectOverview.setProjectDescription(projectDescription);
	}

	/**
	* Sets the project discipline1 of this lab screen project overview.
	*
	* @param projectDiscipline1 the project discipline1 of this lab screen project overview
	*/
	@Override
	public void setProjectDiscipline1(java.lang.String projectDiscipline1) {
		_labScreenProjectOverview.setProjectDiscipline1(projectDiscipline1);
	}

	/**
	* Sets the project discipline2 of this lab screen project overview.
	*
	* @param projectDiscipline2 the project discipline2 of this lab screen project overview
	*/
	@Override
	public void setProjectDiscipline2(java.lang.String projectDiscipline2) {
		_labScreenProjectOverview.setProjectDiscipline2(projectDiscipline2);
	}

	/**
	* Sets the project discipline3 of this lab screen project overview.
	*
	* @param projectDiscipline3 the project discipline3 of this lab screen project overview
	*/
	@Override
	public void setProjectDiscipline3(java.lang.String projectDiscipline3) {
		_labScreenProjectOverview.setProjectDiscipline3(projectDiscipline3);
	}

	/**
	* Sets the project document ID of this lab screen project overview.
	*
	* @param projectDocumentId the project document ID of this lab screen project overview
	*/
	@Override
	public void setProjectDocumentId(long projectDocumentId) {
		_labScreenProjectOverview.setProjectDocumentId(projectDocumentId);
	}

	/**
	* Sets the project end date of this lab screen project overview.
	*
	* @param projectEndDate the project end date of this lab screen project overview
	*/
	@Override
	public void setProjectEndDate(java.lang.String projectEndDate) {
		_labScreenProjectOverview.setProjectEndDate(projectEndDate);
	}

	/**
	* Sets the project name of this lab screen project overview.
	*
	* @param projectName the project name of this lab screen project overview
	*/
	@Override
	public void setProjectName(java.lang.String projectName) {
		_labScreenProjectOverview.setProjectName(projectName);
	}

	/**
	* Sets the project owner ID of this lab screen project overview.
	*
	* @param projectOwnerId the project owner ID of this lab screen project overview
	*/
	@Override
	public void setProjectOwnerId(long projectOwnerId) {
		_labScreenProjectOverview.setProjectOwnerId(projectOwnerId);
	}

	/**
	* Sets the project start date of this lab screen project overview.
	*
	* @param projectStartDate the project start date of this lab screen project overview
	*/
	@Override
	public void setProjectStartDate(java.lang.String projectStartDate) {
		_labScreenProjectOverview.setProjectStartDate(projectStartDate);
	}

	/**
	* Sets the project status of this lab screen project overview.
	*
	* @param projectStatus the project status of this lab screen project overview
	*/
	@Override
	public void setProjectStatus(java.lang.String projectStatus) {
		_labScreenProjectOverview.setProjectStatus(projectStatus);
	}

	/**
	* Sets the project type of this lab screen project overview.
	*
	* @param projectType the project type of this lab screen project overview
	*/
	@Override
	public void setProjectType(java.lang.String projectType) {
		_labScreenProjectOverview.setProjectType(projectType);
	}

	/**
	* Sets the role of this lab screen project overview.
	*
	* @param role the role of this lab screen project overview
	*/
	@Override
	public void setRole(java.lang.String role) {
		_labScreenProjectOverview.setRole(role);
	}

	/**
	* Sets the user ID of this lab screen project overview.
	*
	* @param userId the user ID of this lab screen project overview
	*/
	@Override
	public void setUserId(long userId) {
		_labScreenProjectOverview.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab screen project overview.
	*
	* @param userUuid the user uuid of this lab screen project overview
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labScreenProjectOverview.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labScreenProjectOverviewWrapper)) {
			return false;
		}

		labScreenProjectOverviewWrapper labScreenProjectOverviewWrapper = (labScreenProjectOverviewWrapper)obj;

		if (Objects.equals(_labScreenProjectOverview,
					labScreenProjectOverviewWrapper._labScreenProjectOverview)) {
			return true;
		}

		return false;
	}

	@Override
	public labScreenProjectOverview getWrappedModel() {
		return _labScreenProjectOverview;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labScreenProjectOverview.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labScreenProjectOverview.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labScreenProjectOverview.resetOriginalValues();
	}

	private final labScreenProjectOverview _labScreenProjectOverview;
}