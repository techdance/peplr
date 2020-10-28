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

import com.collaborated.entity.model.labScreenTask;
import com.collaborated.entity.model.labScreenTaskModel;
import com.collaborated.entity.model.labScreenTaskSoap;

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
 * The base model implementation for the labScreenTask service. Represents a row in the &quot;collaborated_labScreenTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link labScreenTaskModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link labScreenTaskImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenTaskImpl
 * @see labScreenTask
 * @see labScreenTaskModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class labScreenTaskModelImpl extends BaseModelImpl<labScreenTask>
	implements labScreenTaskModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lab screen task model instance should use the {@link labScreenTask} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_labScreenTask";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_taskId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "PK_projectId", Types.BIGINT },
			{ "milestoneName", Types.VARCHAR },
			{ "taskName", Types.VARCHAR },
			{ "projectAssignedTo", Types.BIGINT },
			{ "taskDescription", Types.VARCHAR },
			{ "taskStatus", Types.VARCHAR },
			{ "dueDate", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_taskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("PK_projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("milestoneName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("taskName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectAssignedTo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("taskDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("taskStatus", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dueDate", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_labScreenTask (PK_taskId LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,PK_projectId LONG,milestoneName VARCHAR(75) null,taskName VARCHAR(75) null,projectAssignedTo LONG,taskDescription VARCHAR(75) null,taskStatus VARCHAR(75) null,dueDate VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_labScreenTask";
	public static final String ORDER_BY_JPQL = " ORDER BY labScreenTask.PK_taskId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_labScreenTask.PK_taskId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.labScreenTask"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.labScreenTask"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static labScreenTask toModel(labScreenTaskSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		labScreenTask model = new labScreenTaskImpl();

		model.setPK_taskId(soapModel.getPK_taskId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPK_projectId(soapModel.getPK_projectId());
		model.setMilestoneName(soapModel.getMilestoneName());
		model.setTaskName(soapModel.getTaskName());
		model.setProjectAssignedTo(soapModel.getProjectAssignedTo());
		model.setTaskDescription(soapModel.getTaskDescription());
		model.setTaskStatus(soapModel.getTaskStatus());
		model.setDueDate(soapModel.getDueDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<labScreenTask> toModels(labScreenTaskSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<labScreenTask> models = new ArrayList<labScreenTask>(soapModels.length);

		for (labScreenTaskSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.labScreenTask"));

	public labScreenTaskModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_taskId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_taskId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_taskId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return labScreenTask.class;
	}

	@Override
	public String getModelClassName() {
		return labScreenTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_taskId", getPK_taskId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("milestoneName", getMilestoneName());
		attributes.put("taskName", getTaskName());
		attributes.put("projectAssignedTo", getProjectAssignedTo());
		attributes.put("taskDescription", getTaskDescription());
		attributes.put("taskStatus", getTaskStatus());
		attributes.put("dueDate", getDueDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_taskId = (Long)attributes.get("PK_taskId");

		if (PK_taskId != null) {
			setPK_taskId(PK_taskId);
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

		Long PK_projectId = (Long)attributes.get("PK_projectId");

		if (PK_projectId != null) {
			setPK_projectId(PK_projectId);
		}

		String milestoneName = (String)attributes.get("milestoneName");

		if (milestoneName != null) {
			setMilestoneName(milestoneName);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}

		Long projectAssignedTo = (Long)attributes.get("projectAssignedTo");

		if (projectAssignedTo != null) {
			setProjectAssignedTo(projectAssignedTo);
		}

		String taskDescription = (String)attributes.get("taskDescription");

		if (taskDescription != null) {
			setTaskDescription(taskDescription);
		}

		String taskStatus = (String)attributes.get("taskStatus");

		if (taskStatus != null) {
			setTaskStatus(taskStatus);
		}

		String dueDate = (String)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}
	}

	@JSON
	@Override
	public long getPK_taskId() {
		return _PK_taskId;
	}

	@Override
	public void setPK_taskId(long PK_taskId) {
		_PK_taskId = PK_taskId;
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
	public long getPK_projectId() {
		return _PK_projectId;
	}

	@Override
	public void setPK_projectId(long PK_projectId) {
		_PK_projectId = PK_projectId;
	}

	@JSON
	@Override
	public String getMilestoneName() {
		if (_milestoneName == null) {
			return StringPool.BLANK;
		}
		else {
			return _milestoneName;
		}
	}

	@Override
	public void setMilestoneName(String milestoneName) {
		_milestoneName = milestoneName;
	}

	@JSON
	@Override
	public String getTaskName() {
		if (_taskName == null) {
			return StringPool.BLANK;
		}
		else {
			return _taskName;
		}
	}

	@Override
	public void setTaskName(String taskName) {
		_taskName = taskName;
	}

	@JSON
	@Override
	public long getProjectAssignedTo() {
		return _projectAssignedTo;
	}

	@Override
	public void setProjectAssignedTo(long projectAssignedTo) {
		_projectAssignedTo = projectAssignedTo;
	}

	@JSON
	@Override
	public String getTaskDescription() {
		if (_taskDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _taskDescription;
		}
	}

	@Override
	public void setTaskDescription(String taskDescription) {
		_taskDescription = taskDescription;
	}

	@JSON
	@Override
	public String getTaskStatus() {
		if (_taskStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _taskStatus;
		}
	}

	@Override
	public void setTaskStatus(String taskStatus) {
		_taskStatus = taskStatus;
	}

	@JSON
	@Override
	public String getDueDate() {
		if (_dueDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _dueDate;
		}
	}

	@Override
	public void setDueDate(String dueDate) {
		_dueDate = dueDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			labScreenTask.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public labScreenTask toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (labScreenTask)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		labScreenTaskImpl labScreenTaskImpl = new labScreenTaskImpl();

		labScreenTaskImpl.setPK_taskId(getPK_taskId());
		labScreenTaskImpl.setGroupId(getGroupId());
		labScreenTaskImpl.setUserId(getUserId());
		labScreenTaskImpl.setCreateDate(getCreateDate());
		labScreenTaskImpl.setModifiedDate(getModifiedDate());
		labScreenTaskImpl.setPK_projectId(getPK_projectId());
		labScreenTaskImpl.setMilestoneName(getMilestoneName());
		labScreenTaskImpl.setTaskName(getTaskName());
		labScreenTaskImpl.setProjectAssignedTo(getProjectAssignedTo());
		labScreenTaskImpl.setTaskDescription(getTaskDescription());
		labScreenTaskImpl.setTaskStatus(getTaskStatus());
		labScreenTaskImpl.setDueDate(getDueDate());

		labScreenTaskImpl.resetOriginalValues();

		return labScreenTaskImpl;
	}

	@Override
	public int compareTo(labScreenTask labScreenTask) {
		long primaryKey = labScreenTask.getPrimaryKey();

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

		if (!(obj instanceof labScreenTask)) {
			return false;
		}

		labScreenTask labScreenTask = (labScreenTask)obj;

		long primaryKey = labScreenTask.getPrimaryKey();

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
		labScreenTaskModelImpl labScreenTaskModelImpl = this;

		labScreenTaskModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<labScreenTask> toCacheModel() {
		labScreenTaskCacheModel labScreenTaskCacheModel = new labScreenTaskCacheModel();

		labScreenTaskCacheModel.PK_taskId = getPK_taskId();

		labScreenTaskCacheModel.groupId = getGroupId();

		labScreenTaskCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			labScreenTaskCacheModel.createDate = createDate.getTime();
		}
		else {
			labScreenTaskCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			labScreenTaskCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			labScreenTaskCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		labScreenTaskCacheModel.PK_projectId = getPK_projectId();

		labScreenTaskCacheModel.milestoneName = getMilestoneName();

		String milestoneName = labScreenTaskCacheModel.milestoneName;

		if ((milestoneName != null) && (milestoneName.length() == 0)) {
			labScreenTaskCacheModel.milestoneName = null;
		}

		labScreenTaskCacheModel.taskName = getTaskName();

		String taskName = labScreenTaskCacheModel.taskName;

		if ((taskName != null) && (taskName.length() == 0)) {
			labScreenTaskCacheModel.taskName = null;
		}

		labScreenTaskCacheModel.projectAssignedTo = getProjectAssignedTo();

		labScreenTaskCacheModel.taskDescription = getTaskDescription();

		String taskDescription = labScreenTaskCacheModel.taskDescription;

		if ((taskDescription != null) && (taskDescription.length() == 0)) {
			labScreenTaskCacheModel.taskDescription = null;
		}

		labScreenTaskCacheModel.taskStatus = getTaskStatus();

		String taskStatus = labScreenTaskCacheModel.taskStatus;

		if ((taskStatus != null) && (taskStatus.length() == 0)) {
			labScreenTaskCacheModel.taskStatus = null;
		}

		labScreenTaskCacheModel.dueDate = getDueDate();

		String dueDate = labScreenTaskCacheModel.dueDate;

		if ((dueDate != null) && (dueDate.length() == 0)) {
			labScreenTaskCacheModel.dueDate = null;
		}

		return labScreenTaskCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{PK_taskId=");
		sb.append(getPK_taskId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", PK_projectId=");
		sb.append(getPK_projectId());
		sb.append(", milestoneName=");
		sb.append(getMilestoneName());
		sb.append(", taskName=");
		sb.append(getTaskName());
		sb.append(", projectAssignedTo=");
		sb.append(getProjectAssignedTo());
		sb.append(", taskDescription=");
		sb.append(getTaskDescription());
		sb.append(", taskStatus=");
		sb.append(getTaskStatus());
		sb.append(", dueDate=");
		sb.append(getDueDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.collaborated.entity.model.labScreenTask");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_taskId</column-name><column-value><![CDATA[");
		sb.append(getPK_taskId());
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
			"<column><column-name>PK_projectId</column-name><column-value><![CDATA[");
		sb.append(getPK_projectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>milestoneName</column-name><column-value><![CDATA[");
		sb.append(getMilestoneName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskName</column-name><column-value><![CDATA[");
		sb.append(getTaskName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectAssignedTo</column-name><column-value><![CDATA[");
		sb.append(getProjectAssignedTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskDescription</column-name><column-value><![CDATA[");
		sb.append(getTaskDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskStatus</column-name><column-value><![CDATA[");
		sb.append(getTaskStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dueDate</column-name><column-value><![CDATA[");
		sb.append(getDueDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = labScreenTask.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			labScreenTask.class
		};
	private long _PK_taskId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _PK_projectId;
	private String _milestoneName;
	private String _taskName;
	private long _projectAssignedTo;
	private String _taskDescription;
	private String _taskStatus;
	private String _dueDate;
	private labScreenTask _escapedModel;
}