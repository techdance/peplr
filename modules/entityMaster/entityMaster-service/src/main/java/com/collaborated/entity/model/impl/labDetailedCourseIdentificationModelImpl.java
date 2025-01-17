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

import com.collaborated.entity.model.labDetailedCourseIdentification;
import com.collaborated.entity.model.labDetailedCourseIdentificationModel;
import com.collaborated.entity.model.labDetailedCourseIdentificationSoap;

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
 * The base model implementation for the labDetailedCourseIdentification service. Represents a row in the &quot;collaborated_labDetailedCourseIdentification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link labDetailedCourseIdentificationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link labDetailedCourseIdentificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseIdentificationImpl
 * @see labDetailedCourseIdentification
 * @see labDetailedCourseIdentificationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class labDetailedCourseIdentificationModelImpl extends BaseModelImpl<labDetailedCourseIdentification>
	implements labDetailedCourseIdentificationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lab detailed course identification model instance should use the {@link labDetailedCourseIdentification} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_labDetailedCourseIdentification";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_courseId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "PK_projectId", Types.BIGINT },
			{ "courseTitle", Types.VARCHAR },
			{ "courseNumber", Types.VARCHAR },
			{ "prerequisites", Types.VARCHAR },
			{ "courseDescription", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_courseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("PK_projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("courseTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("courseNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("prerequisites", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("courseDescription", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_labDetailedCourseIdentification (PK_courseId LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,PK_projectId LONG,courseTitle VARCHAR(75) null,courseNumber VARCHAR(75) null,prerequisites VARCHAR(75) null,courseDescription VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_labDetailedCourseIdentification";
	public static final String ORDER_BY_JPQL = " ORDER BY labDetailedCourseIdentification.PK_courseId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_labDetailedCourseIdentification.PK_courseId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.labDetailedCourseIdentification"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.labDetailedCourseIdentification"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.collaborated.entity.model.labDetailedCourseIdentification"),
			true);
	public static final long PK_PROJECTID_COLUMN_BITMASK = 1L;
	public static final long PK_COURSEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static labDetailedCourseIdentification toModel(
		labDetailedCourseIdentificationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		labDetailedCourseIdentification model = new labDetailedCourseIdentificationImpl();

		model.setPK_courseId(soapModel.getPK_courseId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPK_projectId(soapModel.getPK_projectId());
		model.setCourseTitle(soapModel.getCourseTitle());
		model.setCourseNumber(soapModel.getCourseNumber());
		model.setPrerequisites(soapModel.getPrerequisites());
		model.setCourseDescription(soapModel.getCourseDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<labDetailedCourseIdentification> toModels(
		labDetailedCourseIdentificationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<labDetailedCourseIdentification> models = new ArrayList<labDetailedCourseIdentification>(soapModels.length);

		for (labDetailedCourseIdentificationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.labDetailedCourseIdentification"));

	public labDetailedCourseIdentificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_courseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_courseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_courseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedCourseIdentification.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedCourseIdentification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("courseTitle", getCourseTitle());
		attributes.put("courseNumber", getCourseNumber());
		attributes.put("prerequisites", getPrerequisites());
		attributes.put("courseDescription", getCourseDescription());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseId = (Long)attributes.get("PK_courseId");

		if (PK_courseId != null) {
			setPK_courseId(PK_courseId);
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

		String courseTitle = (String)attributes.get("courseTitle");

		if (courseTitle != null) {
			setCourseTitle(courseTitle);
		}

		String courseNumber = (String)attributes.get("courseNumber");

		if (courseNumber != null) {
			setCourseNumber(courseNumber);
		}

		String prerequisites = (String)attributes.get("prerequisites");

		if (prerequisites != null) {
			setPrerequisites(prerequisites);
		}

		String courseDescription = (String)attributes.get("courseDescription");

		if (courseDescription != null) {
			setCourseDescription(courseDescription);
		}
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
		_columnBitmask |= PK_PROJECTID_COLUMN_BITMASK;

		if (!_setOriginalPK_projectId) {
			_setOriginalPK_projectId = true;

			_originalPK_projectId = _PK_projectId;
		}

		_PK_projectId = PK_projectId;
	}

	public long getOriginalPK_projectId() {
		return _originalPK_projectId;
	}

	@JSON
	@Override
	public String getCourseTitle() {
		if (_courseTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _courseTitle;
		}
	}

	@Override
	public void setCourseTitle(String courseTitle) {
		_courseTitle = courseTitle;
	}

	@JSON
	@Override
	public String getCourseNumber() {
		if (_courseNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _courseNumber;
		}
	}

	@Override
	public void setCourseNumber(String courseNumber) {
		_courseNumber = courseNumber;
	}

	@JSON
	@Override
	public String getPrerequisites() {
		if (_prerequisites == null) {
			return StringPool.BLANK;
		}
		else {
			return _prerequisites;
		}
	}

	@Override
	public void setPrerequisites(String prerequisites) {
		_prerequisites = prerequisites;
	}

	@JSON
	@Override
	public String getCourseDescription() {
		if (_courseDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _courseDescription;
		}
	}

	@Override
	public void setCourseDescription(String courseDescription) {
		_courseDescription = courseDescription;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			labDetailedCourseIdentification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public labDetailedCourseIdentification toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (labDetailedCourseIdentification)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		labDetailedCourseIdentificationImpl labDetailedCourseIdentificationImpl = new labDetailedCourseIdentificationImpl();

		labDetailedCourseIdentificationImpl.setPK_courseId(getPK_courseId());
		labDetailedCourseIdentificationImpl.setGroupId(getGroupId());
		labDetailedCourseIdentificationImpl.setUserId(getUserId());
		labDetailedCourseIdentificationImpl.setCreateDate(getCreateDate());
		labDetailedCourseIdentificationImpl.setModifiedDate(getModifiedDate());
		labDetailedCourseIdentificationImpl.setPK_projectId(getPK_projectId());
		labDetailedCourseIdentificationImpl.setCourseTitle(getCourseTitle());
		labDetailedCourseIdentificationImpl.setCourseNumber(getCourseNumber());
		labDetailedCourseIdentificationImpl.setPrerequisites(getPrerequisites());
		labDetailedCourseIdentificationImpl.setCourseDescription(getCourseDescription());

		labDetailedCourseIdentificationImpl.resetOriginalValues();

		return labDetailedCourseIdentificationImpl;
	}

	@Override
	public int compareTo(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		long primaryKey = labDetailedCourseIdentification.getPrimaryKey();

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

		if (!(obj instanceof labDetailedCourseIdentification)) {
			return false;
		}

		labDetailedCourseIdentification labDetailedCourseIdentification = (labDetailedCourseIdentification)obj;

		long primaryKey = labDetailedCourseIdentification.getPrimaryKey();

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
		labDetailedCourseIdentificationModelImpl labDetailedCourseIdentificationModelImpl =
			this;

		labDetailedCourseIdentificationModelImpl._setModifiedDate = false;

		labDetailedCourseIdentificationModelImpl._originalPK_projectId = labDetailedCourseIdentificationModelImpl._PK_projectId;

		labDetailedCourseIdentificationModelImpl._setOriginalPK_projectId = false;

		labDetailedCourseIdentificationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<labDetailedCourseIdentification> toCacheModel() {
		labDetailedCourseIdentificationCacheModel labDetailedCourseIdentificationCacheModel =
			new labDetailedCourseIdentificationCacheModel();

		labDetailedCourseIdentificationCacheModel.PK_courseId = getPK_courseId();

		labDetailedCourseIdentificationCacheModel.groupId = getGroupId();

		labDetailedCourseIdentificationCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			labDetailedCourseIdentificationCacheModel.createDate = createDate.getTime();
		}
		else {
			labDetailedCourseIdentificationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			labDetailedCourseIdentificationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			labDetailedCourseIdentificationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		labDetailedCourseIdentificationCacheModel.PK_projectId = getPK_projectId();

		labDetailedCourseIdentificationCacheModel.courseTitle = getCourseTitle();

		String courseTitle = labDetailedCourseIdentificationCacheModel.courseTitle;

		if ((courseTitle != null) && (courseTitle.length() == 0)) {
			labDetailedCourseIdentificationCacheModel.courseTitle = null;
		}

		labDetailedCourseIdentificationCacheModel.courseNumber = getCourseNumber();

		String courseNumber = labDetailedCourseIdentificationCacheModel.courseNumber;

		if ((courseNumber != null) && (courseNumber.length() == 0)) {
			labDetailedCourseIdentificationCacheModel.courseNumber = null;
		}

		labDetailedCourseIdentificationCacheModel.prerequisites = getPrerequisites();

		String prerequisites = labDetailedCourseIdentificationCacheModel.prerequisites;

		if ((prerequisites != null) && (prerequisites.length() == 0)) {
			labDetailedCourseIdentificationCacheModel.prerequisites = null;
		}

		labDetailedCourseIdentificationCacheModel.courseDescription = getCourseDescription();

		String courseDescription = labDetailedCourseIdentificationCacheModel.courseDescription;

		if ((courseDescription != null) && (courseDescription.length() == 0)) {
			labDetailedCourseIdentificationCacheModel.courseDescription = null;
		}

		return labDetailedCourseIdentificationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{PK_courseId=");
		sb.append(getPK_courseId());
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
		sb.append(", courseTitle=");
		sb.append(getCourseTitle());
		sb.append(", courseNumber=");
		sb.append(getCourseNumber());
		sb.append(", prerequisites=");
		sb.append(getPrerequisites());
		sb.append(", courseDescription=");
		sb.append(getCourseDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.collaborated.entity.model.labDetailedCourseIdentification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_courseId</column-name><column-value><![CDATA[");
		sb.append(getPK_courseId());
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
			"<column><column-name>courseTitle</column-name><column-value><![CDATA[");
		sb.append(getCourseTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseNumber</column-name><column-value><![CDATA[");
		sb.append(getCourseNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prerequisites</column-name><column-value><![CDATA[");
		sb.append(getPrerequisites());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseDescription</column-name><column-value><![CDATA[");
		sb.append(getCourseDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = labDetailedCourseIdentification.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			labDetailedCourseIdentification.class
		};
	private long _PK_courseId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _PK_projectId;
	private long _originalPK_projectId;
	private boolean _setOriginalPK_projectId;
	private String _courseTitle;
	private String _courseNumber;
	private String _prerequisites;
	private String _courseDescription;
	private long _columnBitmask;
	private labDetailedCourseIdentification _escapedModel;
}