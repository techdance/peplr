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

package com.collaborated.entity.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.labScreenProjectOverviewModel;
import com.collaborated.entity.model.labScreenProjectOverviewSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the labScreenProjectOverview service. Represents a row in the &quot;collaborated_labScreenProjectOverview&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link labScreenProjectOverviewModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link labScreenProjectOverviewImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectOverviewImpl
 * @see labScreenProjectOverview
 * @see labScreenProjectOverviewModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class labScreenProjectOverviewModelImpl extends BaseModelImpl<labScreenProjectOverview>
	implements labScreenProjectOverviewModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lab screen project overview model instance should use the {@link labScreenProjectOverview} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_labScreenProjectOverview";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_projectId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "projectOwnerId", Types.BIGINT },
			{ "projectName", Types.VARCHAR },
			{ "projectType", Types.VARCHAR },
			{ "projectDescription", Types.VARCHAR },
			{ "projectDiscipline1", Types.VARCHAR },
			{ "projectDiscipline2", Types.VARCHAR },
			{ "projectDiscipline3", Types.VARCHAR },
			{ "role", Types.VARCHAR },
			{ "projectStartDate", Types.VARCHAR },
			{ "projectEndDate", Types.VARCHAR },
			{ "projectDocumentId", Types.BIGINT },
			{ "percentage", Types.BIGINT },
			{ "interestId", Types.BIGINT },
			{ "projectStatus", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("projectOwnerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("projectName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectDiscipline1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectDiscipline2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectDiscipline3", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("role", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectStartDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectEndDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectDocumentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("percentage", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("interestId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("projectStatus", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_labScreenProjectOverview (PK_projectId LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,projectOwnerId LONG,projectName VARCHAR(75) null,projectType VARCHAR(75) null,projectDescription VARCHAR(75) null,projectDiscipline1 VARCHAR(75) null,projectDiscipline2 VARCHAR(75) null,projectDiscipline3 VARCHAR(75) null,role VARCHAR(75) null,projectStartDate VARCHAR(75) null,projectEndDate VARCHAR(75) null,projectDocumentId LONG,percentage LONG,interestId LONG,projectStatus VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_labScreenProjectOverview";
	public static final String ORDER_BY_JPQL = " ORDER BY labScreenProjectOverview.PK_projectId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_labScreenProjectOverview.PK_projectId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.labScreenProjectOverview"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.labScreenProjectOverview"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static labScreenProjectOverview toModel(
		labScreenProjectOverviewSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		labScreenProjectOverview model = new labScreenProjectOverviewImpl();

		model.setPK_projectId(soapModel.getPK_projectId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setProjectOwnerId(soapModel.getProjectOwnerId());
		model.setProjectName(soapModel.getProjectName());
		model.setProjectType(soapModel.getProjectType());
		model.setProjectDescription(soapModel.getProjectDescription());
		model.setProjectDiscipline1(soapModel.getProjectDiscipline1());
		model.setProjectDiscipline2(soapModel.getProjectDiscipline2());
		model.setProjectDiscipline3(soapModel.getProjectDiscipline3());
		model.setRole(soapModel.getRole());
		model.setProjectStartDate(soapModel.getProjectStartDate());
		model.setProjectEndDate(soapModel.getProjectEndDate());
		model.setProjectDocumentId(soapModel.getProjectDocumentId());
		model.setPercentage(soapModel.getPercentage());
		model.setInterestId(soapModel.getInterestId());
		model.setProjectStatus(soapModel.getProjectStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<labScreenProjectOverview> toModels(
		labScreenProjectOverviewSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<labScreenProjectOverview> models = new ArrayList<labScreenProjectOverview>(soapModels.length);

		for (labScreenProjectOverviewSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.labScreenProjectOverview"));

	public labScreenProjectOverviewModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_projectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_projectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_projectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public long getPK_projectId() {
		return _PK_projectId;
	}

	@Override
	public void setPK_projectId(long PK_projectId) {
		_PK_projectId = PK_projectId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getProjectOwnerId() {
		return _projectOwnerId;
	}

	@Override
	public void setProjectOwnerId(long projectOwnerId) {
		_projectOwnerId = projectOwnerId;
	}

	@JSON
	@Override
	public String getProjectName() {
		if (_projectName == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectName;
		}
	}

	@Override
	public void setProjectName(String projectName) {
		_projectName = projectName;
	}

	@JSON
	@Override
	public String getProjectType() {
		if (_projectType == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectType;
		}
	}

	@Override
	public void setProjectType(String projectType) {
		_projectType = projectType;
	}

	@JSON
	@Override
	public String getProjectDescription() {
		if (_projectDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectDescription;
		}
	}

	@Override
	public void setProjectDescription(String projectDescription) {
		_projectDescription = projectDescription;
	}

	@JSON
	@Override
	public String getProjectDiscipline1() {
		if (_projectDiscipline1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectDiscipline1;
		}
	}

	@Override
	public void setProjectDiscipline1(String projectDiscipline1) {
		_projectDiscipline1 = projectDiscipline1;
	}

	@JSON
	@Override
	public String getProjectDiscipline2() {
		if (_projectDiscipline2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectDiscipline2;
		}
	}

	@Override
	public void setProjectDiscipline2(String projectDiscipline2) {
		_projectDiscipline2 = projectDiscipline2;
	}

	@JSON
	@Override
	public String getProjectDiscipline3() {
		if (_projectDiscipline3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectDiscipline3;
		}
	}

	@Override
	public void setProjectDiscipline3(String projectDiscipline3) {
		_projectDiscipline3 = projectDiscipline3;
	}

	@JSON
	@Override
	public String getRole() {
		if (_role == null) {
			return StringPool.BLANK;
		}
		else {
			return _role;
		}
	}

	@Override
	public void setRole(String role) {
		_role = role;
	}

	@JSON
	@Override
	public String getProjectStartDate() {
		if (_projectStartDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectStartDate;
		}
	}

	@Override
	public void setProjectStartDate(String projectStartDate) {
		_projectStartDate = projectStartDate;
	}

	@JSON
	@Override
	public String getProjectEndDate() {
		if (_projectEndDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectEndDate;
		}
	}

	@Override
	public void setProjectEndDate(String projectEndDate) {
		_projectEndDate = projectEndDate;
	}

	@JSON
	@Override
	public long getProjectDocumentId() {
		return _projectDocumentId;
	}

	@Override
	public void setProjectDocumentId(long projectDocumentId) {
		_projectDocumentId = projectDocumentId;
	}

	@JSON
	@Override
	public long getPercentage() {
		return _percentage;
	}

	@Override
	public void setPercentage(long percentage) {
		_percentage = percentage;
	}

	@JSON
	@Override
	public long getInterestId() {
		return _interestId;
	}

	@Override
	public void setInterestId(long interestId) {
		_interestId = interestId;
	}

	@JSON
	@Override
	public String getProjectStatus() {
		if (_projectStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _projectStatus;
		}
	}

	@Override
	public void setProjectStatus(String projectStatus) {
		_projectStatus = projectStatus;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			labScreenProjectOverview.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public labScreenProjectOverview toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (labScreenProjectOverview)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		labScreenProjectOverviewImpl labScreenProjectOverviewImpl = new labScreenProjectOverviewImpl();

		labScreenProjectOverviewImpl.setPK_projectId(getPK_projectId());
		labScreenProjectOverviewImpl.setGroupId(getGroupId());
		labScreenProjectOverviewImpl.setUserId(getUserId());
		labScreenProjectOverviewImpl.setCreateDate(getCreateDate());
		labScreenProjectOverviewImpl.setModifiedDate(getModifiedDate());
		labScreenProjectOverviewImpl.setProjectOwnerId(getProjectOwnerId());
		labScreenProjectOverviewImpl.setProjectName(getProjectName());
		labScreenProjectOverviewImpl.setProjectType(getProjectType());
		labScreenProjectOverviewImpl.setProjectDescription(getProjectDescription());
		labScreenProjectOverviewImpl.setProjectDiscipline1(getProjectDiscipline1());
		labScreenProjectOverviewImpl.setProjectDiscipline2(getProjectDiscipline2());
		labScreenProjectOverviewImpl.setProjectDiscipline3(getProjectDiscipline3());
		labScreenProjectOverviewImpl.setRole(getRole());
		labScreenProjectOverviewImpl.setProjectStartDate(getProjectStartDate());
		labScreenProjectOverviewImpl.setProjectEndDate(getProjectEndDate());
		labScreenProjectOverviewImpl.setProjectDocumentId(getProjectDocumentId());
		labScreenProjectOverviewImpl.setPercentage(getPercentage());
		labScreenProjectOverviewImpl.setInterestId(getInterestId());
		labScreenProjectOverviewImpl.setProjectStatus(getProjectStatus());

		labScreenProjectOverviewImpl.resetOriginalValues();

		return labScreenProjectOverviewImpl;
	}

	@Override
	public int compareTo(labScreenProjectOverview labScreenProjectOverview) {
		long primaryKey = labScreenProjectOverview.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labScreenProjectOverview)) {
			return false;
		}

		labScreenProjectOverview labScreenProjectOverview = (labScreenProjectOverview)obj;

		long primaryKey = labScreenProjectOverview.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		labScreenProjectOverviewModelImpl labScreenProjectOverviewModelImpl = this;

		labScreenProjectOverviewModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<labScreenProjectOverview> toCacheModel() {
		labScreenProjectOverviewCacheModel labScreenProjectOverviewCacheModel = new labScreenProjectOverviewCacheModel();

		labScreenProjectOverviewCacheModel.PK_projectId = getPK_projectId();

		labScreenProjectOverviewCacheModel.groupId = getGroupId();

		labScreenProjectOverviewCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			labScreenProjectOverviewCacheModel.createDate = createDate.getTime();
		}
		else {
			labScreenProjectOverviewCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			labScreenProjectOverviewCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			labScreenProjectOverviewCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		labScreenProjectOverviewCacheModel.projectOwnerId = getProjectOwnerId();

		labScreenProjectOverviewCacheModel.projectName = getProjectName();

		String projectName = labScreenProjectOverviewCacheModel.projectName;

		if ((projectName != null) && (projectName.length() == 0)) {
			labScreenProjectOverviewCacheModel.projectName = null;
		}

		labScreenProjectOverviewCacheModel.projectType = getProjectType();

		String projectType = labScreenProjectOverviewCacheModel.projectType;

		if ((projectType != null) && (projectType.length() == 0)) {
			labScreenProjectOverviewCacheModel.projectType = null;
		}

		labScreenProjectOverviewCacheModel.projectDescription = getProjectDescription();

		String projectDescription = labScreenProjectOverviewCacheModel.projectDescription;

		if ((projectDescription != null) && (projectDescription.length() == 0)) {
			labScreenProjectOverviewCacheModel.projectDescription = null;
		}

		labScreenProjectOverviewCacheModel.projectDiscipline1 = getProjectDiscipline1();

		String projectDiscipline1 = labScreenProjectOverviewCacheModel.projectDiscipline1;

		if ((projectDiscipline1 != null) && (projectDiscipline1.length() == 0)) {
			labScreenProjectOverviewCacheModel.projectDiscipline1 = null;
		}

		labScreenProjectOverviewCacheModel.projectDiscipline2 = getProjectDiscipline2();

		String projectDiscipline2 = labScreenProjectOverviewCacheModel.projectDiscipline2;

		if ((projectDiscipline2 != null) && (projectDiscipline2.length() == 0)) {
			labScreenProjectOverviewCacheModel.projectDiscipline2 = null;
		}

		labScreenProjectOverviewCacheModel.projectDiscipline3 = getProjectDiscipline3();

		String projectDiscipline3 = labScreenProjectOverviewCacheModel.projectDiscipline3;

		if ((projectDiscipline3 != null) && (projectDiscipline3.length() == 0)) {
			labScreenProjectOverviewCacheModel.projectDiscipline3 = null;
		}

		labScreenProjectOverviewCacheModel.role = getRole();

		String role = labScreenProjectOverviewCacheModel.role;

		if ((role != null) && (role.length() == 0)) {
			labScreenProjectOverviewCacheModel.role = null;
		}

		labScreenProjectOverviewCacheModel.projectStartDate = getProjectStartDate();

		String projectStartDate = labScreenProjectOverviewCacheModel.projectStartDate;

		if ((projectStartDate != null) && (projectStartDate.length() == 0)) {
			labScreenProjectOverviewCacheModel.projectStartDate = null;
		}

		labScreenProjectOverviewCacheModel.projectEndDate = getProjectEndDate();

		String projectEndDate = labScreenProjectOverviewCacheModel.projectEndDate;

		if ((projectEndDate != null) && (projectEndDate.length() == 0)) {
			labScreenProjectOverviewCacheModel.projectEndDate = null;
		}

		labScreenProjectOverviewCacheModel.projectDocumentId = getProjectDocumentId();

		labScreenProjectOverviewCacheModel.percentage = getPercentage();

		labScreenProjectOverviewCacheModel.interestId = getInterestId();

		labScreenProjectOverviewCacheModel.projectStatus = getProjectStatus();

		String projectStatus = labScreenProjectOverviewCacheModel.projectStatus;

		if ((projectStatus != null) && (projectStatus.length() == 0)) {
			labScreenProjectOverviewCacheModel.projectStatus = null;
		}

		return labScreenProjectOverviewCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{PK_projectId=");
		sb.append(getPK_projectId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", projectOwnerId=");
		sb.append(getProjectOwnerId());
		sb.append(", projectName=");
		sb.append(getProjectName());
		sb.append(", projectType=");
		sb.append(getProjectType());
		sb.append(", projectDescription=");
		sb.append(getProjectDescription());
		sb.append(", projectDiscipline1=");
		sb.append(getProjectDiscipline1());
		sb.append(", projectDiscipline2=");
		sb.append(getProjectDiscipline2());
		sb.append(", projectDiscipline3=");
		sb.append(getProjectDiscipline3());
		sb.append(", role=");
		sb.append(getRole());
		sb.append(", projectStartDate=");
		sb.append(getProjectStartDate());
		sb.append(", projectEndDate=");
		sb.append(getProjectEndDate());
		sb.append(", projectDocumentId=");
		sb.append(getProjectDocumentId());
		sb.append(", percentage=");
		sb.append(getPercentage());
		sb.append(", interestId=");
		sb.append(getInterestId());
		sb.append(", projectStatus=");
		sb.append(getProjectStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.collaborated.entity.model.labScreenProjectOverview");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_projectId</column-name><column-value><![CDATA[");
		sb.append(getPK_projectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectOwnerId</column-name><column-value><![CDATA[");
		sb.append(getProjectOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectName</column-name><column-value><![CDATA[");
		sb.append(getProjectName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectType</column-name><column-value><![CDATA[");
		sb.append(getProjectType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectDescription</column-name><column-value><![CDATA[");
		sb.append(getProjectDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectDiscipline1</column-name><column-value><![CDATA[");
		sb.append(getProjectDiscipline1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectDiscipline2</column-name><column-value><![CDATA[");
		sb.append(getProjectDiscipline2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectDiscipline3</column-name><column-value><![CDATA[");
		sb.append(getProjectDiscipline3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>role</column-name><column-value><![CDATA[");
		sb.append(getRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectStartDate</column-name><column-value><![CDATA[");
		sb.append(getProjectStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectEndDate</column-name><column-value><![CDATA[");
		sb.append(getProjectEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectDocumentId</column-name><column-value><![CDATA[");
		sb.append(getProjectDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>percentage</column-name><column-value><![CDATA[");
		sb.append(getPercentage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interestId</column-name><column-value><![CDATA[");
		sb.append(getInterestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectStatus</column-name><column-value><![CDATA[");
		sb.append(getProjectStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = labScreenProjectOverview.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			labScreenProjectOverview.class
		};
	private long _PK_projectId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
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
	private labScreenProjectOverview _escapedModel;
}