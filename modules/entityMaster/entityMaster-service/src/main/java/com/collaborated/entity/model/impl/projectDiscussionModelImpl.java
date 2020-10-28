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

import com.collaborated.entity.model.projectDiscussion;
import com.collaborated.entity.model.projectDiscussionModel;
import com.collaborated.entity.model.projectDiscussionSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * The base model implementation for the projectDiscussion service. Represents a row in the &quot;collaborated_projectDiscussion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link projectDiscussionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link projectDiscussionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectDiscussionImpl
 * @see projectDiscussion
 * @see projectDiscussionModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class projectDiscussionModelImpl extends BaseModelImpl<projectDiscussion>
	implements projectDiscussionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project discussion model instance should use the {@link projectDiscussion} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_projectDiscussion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_projectDiscussionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createdOn", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "interestId", Types.BIGINT },
			{ "projectId", Types.BIGINT },
			{ "senderId", Types.BIGINT },
			{ "description", Types.VARCHAR },
			{ "fileEntryId", Types.BIGINT },
			{ "imageUrl", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_projectDiscussionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdOn", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("interestId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("senderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("imageUrl", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_projectDiscussion (PK_projectDiscussionId LONG not null primary key,groupId LONG,createdOn DATE null,modifiedDate DATE null,interestId LONG,projectId LONG,senderId LONG,description VARCHAR(75) null,fileEntryId LONG,imageUrl VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_projectDiscussion";
	public static final String ORDER_BY_JPQL = " ORDER BY projectDiscussion.PK_projectDiscussionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_projectDiscussion.PK_projectDiscussionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.projectDiscussion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.projectDiscussion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static projectDiscussion toModel(projectDiscussionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		projectDiscussion model = new projectDiscussionImpl();

		model.setPK_projectDiscussionId(soapModel.getPK_projectDiscussionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCreatedOn(soapModel.getCreatedOn());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setInterestId(soapModel.getInterestId());
		model.setProjectId(soapModel.getProjectId());
		model.setSenderId(soapModel.getSenderId());
		model.setDescription(soapModel.getDescription());
		model.setFileEntryId(soapModel.getFileEntryId());
		model.setImageUrl(soapModel.getImageUrl());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<projectDiscussion> toModels(
		projectDiscussionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<projectDiscussion> models = new ArrayList<projectDiscussion>(soapModels.length);

		for (projectDiscussionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.projectDiscussion"));

	public projectDiscussionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_projectDiscussionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_projectDiscussionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_projectDiscussionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return projectDiscussion.class;
	}

	@Override
	public String getModelClassName() {
		return projectDiscussion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_projectDiscussionId", getPK_projectDiscussionId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("interestId", getInterestId());
		attributes.put("projectId", getProjectId());
		attributes.put("senderId", getSenderId());
		attributes.put("description", getDescription());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("imageUrl", getImageUrl());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_projectDiscussionId = (Long)attributes.get(
				"PK_projectDiscussionId");

		if (PK_projectDiscussionId != null) {
			setPK_projectDiscussionId(PK_projectDiscussionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createdOn = (Date)attributes.get("createdOn");

		if (createdOn != null) {
			setCreatedOn(createdOn);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long interestId = (Long)attributes.get("interestId");

		if (interestId != null) {
			setInterestId(interestId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long senderId = (Long)attributes.get("senderId");

		if (senderId != null) {
			setSenderId(senderId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}
	}

	@JSON
	@Override
	public long getPK_projectDiscussionId() {
		return _PK_projectDiscussionId;
	}

	@Override
	public void setPK_projectDiscussionId(long PK_projectDiscussionId) {
		_PK_projectDiscussionId = PK_projectDiscussionId;
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
	public Date getCreatedOn() {
		return _createdOn;
	}

	@Override
	public void setCreatedOn(Date createdOn) {
		_createdOn = createdOn;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	@JSON
	@Override
	public long getSenderId() {
		return _senderId;
	}

	@Override
	public void setSenderId(long senderId) {
		_senderId = senderId;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	@JSON
	@Override
	public String getImageUrl() {
		if (_imageUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageUrl;
		}
	}

	@Override
	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			projectDiscussion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public projectDiscussion toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (projectDiscussion)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		projectDiscussionImpl projectDiscussionImpl = new projectDiscussionImpl();

		projectDiscussionImpl.setPK_projectDiscussionId(getPK_projectDiscussionId());
		projectDiscussionImpl.setGroupId(getGroupId());
		projectDiscussionImpl.setCreatedOn(getCreatedOn());
		projectDiscussionImpl.setModifiedDate(getModifiedDate());
		projectDiscussionImpl.setInterestId(getInterestId());
		projectDiscussionImpl.setProjectId(getProjectId());
		projectDiscussionImpl.setSenderId(getSenderId());
		projectDiscussionImpl.setDescription(getDescription());
		projectDiscussionImpl.setFileEntryId(getFileEntryId());
		projectDiscussionImpl.setImageUrl(getImageUrl());

		projectDiscussionImpl.resetOriginalValues();

		return projectDiscussionImpl;
	}

	@Override
	public int compareTo(projectDiscussion projectDiscussion) {
		long primaryKey = projectDiscussion.getPrimaryKey();

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

		if (!(obj instanceof projectDiscussion)) {
			return false;
		}

		projectDiscussion projectDiscussion = (projectDiscussion)obj;

		long primaryKey = projectDiscussion.getPrimaryKey();

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
	}

	@Override
	public CacheModel<projectDiscussion> toCacheModel() {
		projectDiscussionCacheModel projectDiscussionCacheModel = new projectDiscussionCacheModel();

		projectDiscussionCacheModel.PK_projectDiscussionId = getPK_projectDiscussionId();

		projectDiscussionCacheModel.groupId = getGroupId();

		Date createdOn = getCreatedOn();

		if (createdOn != null) {
			projectDiscussionCacheModel.createdOn = createdOn.getTime();
		}
		else {
			projectDiscussionCacheModel.createdOn = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			projectDiscussionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			projectDiscussionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		projectDiscussionCacheModel.interestId = getInterestId();

		projectDiscussionCacheModel.projectId = getProjectId();

		projectDiscussionCacheModel.senderId = getSenderId();

		projectDiscussionCacheModel.description = getDescription();

		String description = projectDiscussionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			projectDiscussionCacheModel.description = null;
		}

		projectDiscussionCacheModel.fileEntryId = getFileEntryId();

		projectDiscussionCacheModel.imageUrl = getImageUrl();

		String imageUrl = projectDiscussionCacheModel.imageUrl;

		if ((imageUrl != null) && (imageUrl.length() == 0)) {
			projectDiscussionCacheModel.imageUrl = null;
		}

		return projectDiscussionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{PK_projectDiscussionId=");
		sb.append(getPK_projectDiscussionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createdOn=");
		sb.append(getCreatedOn());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", interestId=");
		sb.append(getInterestId());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", senderId=");
		sb.append(getSenderId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", imageUrl=");
		sb.append(getImageUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.collaborated.entity.model.projectDiscussion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_projectDiscussionId</column-name><column-value><![CDATA[");
		sb.append(getPK_projectDiscussionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdOn</column-name><column-value><![CDATA[");
		sb.append(getCreatedOn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interestId</column-name><column-value><![CDATA[");
		sb.append(getInterestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderId</column-name><column-value><![CDATA[");
		sb.append(getSenderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = projectDiscussion.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			projectDiscussion.class
		};
	private long _PK_projectDiscussionId;
	private long _groupId;
	private Date _createdOn;
	private Date _modifiedDate;
	private long _interestId;
	private long _projectId;
	private long _senderId;
	private String _description;
	private long _fileEntryId;
	private String _imageUrl;
	private projectDiscussion _escapedModel;
}