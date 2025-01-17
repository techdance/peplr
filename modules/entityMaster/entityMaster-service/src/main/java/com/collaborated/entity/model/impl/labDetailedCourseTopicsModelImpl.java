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

import com.collaborated.entity.model.labDetailedCourseTopics;
import com.collaborated.entity.model.labDetailedCourseTopicsModel;
import com.collaborated.entity.model.labDetailedCourseTopicsSoap;

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
 * The base model implementation for the labDetailedCourseTopics service. Represents a row in the &quot;collaborated_labDetailedCourseTopics&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link labDetailedCourseTopicsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link labDetailedCourseTopicsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseTopicsImpl
 * @see labDetailedCourseTopics
 * @see labDetailedCourseTopicsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class labDetailedCourseTopicsModelImpl extends BaseModelImpl<labDetailedCourseTopics>
	implements labDetailedCourseTopicsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lab detailed course topics model instance should use the {@link labDetailedCourseTopics} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_labDetailedCourseTopics";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_courseTopicsId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "PK_projectId", Types.BIGINT },
			{ "PK_courseId", Types.BIGINT },
			{ "courseTopic", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_courseTopicsId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("PK_projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("PK_courseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("courseTopic", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_labDetailedCourseTopics (PK_courseTopicsId LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,PK_projectId LONG,PK_courseId LONG,courseTopic VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_labDetailedCourseTopics";
	public static final String ORDER_BY_JPQL = " ORDER BY labDetailedCourseTopics.PK_courseTopicsId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_labDetailedCourseTopics.PK_courseTopicsId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.labDetailedCourseTopics"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.labDetailedCourseTopics"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static labDetailedCourseTopics toModel(
		labDetailedCourseTopicsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		labDetailedCourseTopics model = new labDetailedCourseTopicsImpl();

		model.setPK_courseTopicsId(soapModel.getPK_courseTopicsId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPK_projectId(soapModel.getPK_projectId());
		model.setPK_courseId(soapModel.getPK_courseId());
		model.setCourseTopic(soapModel.getCourseTopic());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<labDetailedCourseTopics> toModels(
		labDetailedCourseTopicsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<labDetailedCourseTopics> models = new ArrayList<labDetailedCourseTopics>(soapModels.length);

		for (labDetailedCourseTopicsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.labDetailedCourseTopics"));

	public labDetailedCourseTopicsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_courseTopicsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_courseTopicsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_courseTopicsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedCourseTopics.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedCourseTopics.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseTopicsId", getPK_courseTopicsId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("courseTopic", getCourseTopic());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseTopicsId = (Long)attributes.get("PK_courseTopicsId");

		if (PK_courseTopicsId != null) {
			setPK_courseTopicsId(PK_courseTopicsId);
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

		Long PK_courseId = (Long)attributes.get("PK_courseId");

		if (PK_courseId != null) {
			setPK_courseId(PK_courseId);
		}

		String courseTopic = (String)attributes.get("courseTopic");

		if (courseTopic != null) {
			setCourseTopic(courseTopic);
		}
	}

	@JSON
	@Override
	public long getPK_courseTopicsId() {
		return _PK_courseTopicsId;
	}

	@Override
	public void setPK_courseTopicsId(long PK_courseTopicsId) {
		_PK_courseTopicsId = PK_courseTopicsId;
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
	public long getPK_courseId() {
		return _PK_courseId;
	}

	@Override
	public void setPK_courseId(long PK_courseId) {
		_PK_courseId = PK_courseId;
	}

	@JSON
	@Override
	public String getCourseTopic() {
		if (_courseTopic == null) {
			return StringPool.BLANK;
		}
		else {
			return _courseTopic;
		}
	}

	@Override
	public void setCourseTopic(String courseTopic) {
		_courseTopic = courseTopic;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			labDetailedCourseTopics.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public labDetailedCourseTopics toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (labDetailedCourseTopics)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		labDetailedCourseTopicsImpl labDetailedCourseTopicsImpl = new labDetailedCourseTopicsImpl();

		labDetailedCourseTopicsImpl.setPK_courseTopicsId(getPK_courseTopicsId());
		labDetailedCourseTopicsImpl.setGroupId(getGroupId());
		labDetailedCourseTopicsImpl.setUserId(getUserId());
		labDetailedCourseTopicsImpl.setCreateDate(getCreateDate());
		labDetailedCourseTopicsImpl.setModifiedDate(getModifiedDate());
		labDetailedCourseTopicsImpl.setPK_projectId(getPK_projectId());
		labDetailedCourseTopicsImpl.setPK_courseId(getPK_courseId());
		labDetailedCourseTopicsImpl.setCourseTopic(getCourseTopic());

		labDetailedCourseTopicsImpl.resetOriginalValues();

		return labDetailedCourseTopicsImpl;
	}

	@Override
	public int compareTo(labDetailedCourseTopics labDetailedCourseTopics) {
		long primaryKey = labDetailedCourseTopics.getPrimaryKey();

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

		if (!(obj instanceof labDetailedCourseTopics)) {
			return false;
		}

		labDetailedCourseTopics labDetailedCourseTopics = (labDetailedCourseTopics)obj;

		long primaryKey = labDetailedCourseTopics.getPrimaryKey();

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
		labDetailedCourseTopicsModelImpl labDetailedCourseTopicsModelImpl = this;

		labDetailedCourseTopicsModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<labDetailedCourseTopics> toCacheModel() {
		labDetailedCourseTopicsCacheModel labDetailedCourseTopicsCacheModel = new labDetailedCourseTopicsCacheModel();

		labDetailedCourseTopicsCacheModel.PK_courseTopicsId = getPK_courseTopicsId();

		labDetailedCourseTopicsCacheModel.groupId = getGroupId();

		labDetailedCourseTopicsCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			labDetailedCourseTopicsCacheModel.createDate = createDate.getTime();
		}
		else {
			labDetailedCourseTopicsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			labDetailedCourseTopicsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			labDetailedCourseTopicsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		labDetailedCourseTopicsCacheModel.PK_projectId = getPK_projectId();

		labDetailedCourseTopicsCacheModel.PK_courseId = getPK_courseId();

		labDetailedCourseTopicsCacheModel.courseTopic = getCourseTopic();

		String courseTopic = labDetailedCourseTopicsCacheModel.courseTopic;

		if ((courseTopic != null) && (courseTopic.length() == 0)) {
			labDetailedCourseTopicsCacheModel.courseTopic = null;
		}

		return labDetailedCourseTopicsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{PK_courseTopicsId=");
		sb.append(getPK_courseTopicsId());
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
		sb.append(", PK_courseId=");
		sb.append(getPK_courseId());
		sb.append(", courseTopic=");
		sb.append(getCourseTopic());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.collaborated.entity.model.labDetailedCourseTopics");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_courseTopicsId</column-name><column-value><![CDATA[");
		sb.append(getPK_courseTopicsId());
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
			"<column><column-name>PK_courseId</column-name><column-value><![CDATA[");
		sb.append(getPK_courseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseTopic</column-name><column-value><![CDATA[");
		sb.append(getCourseTopic());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = labDetailedCourseTopics.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			labDetailedCourseTopics.class
		};
	private long _PK_courseTopicsId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _PK_projectId;
	private long _PK_courseId;
	private String _courseTopic;
	private labDetailedCourseTopics _escapedModel;
}