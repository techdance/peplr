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

import com.collaborated.entity.model.labDetailedInstructorQualification;
import com.collaborated.entity.model.labDetailedInstructorQualificationModel;
import com.collaborated.entity.model.labDetailedInstructorQualificationSoap;

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
 * The base model implementation for the labDetailedInstructorQualification service. Represents a row in the &quot;collaborated_labDetailedInstructorQualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link labDetailedInstructorQualificationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link labDetailedInstructorQualificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedInstructorQualificationImpl
 * @see labDetailedInstructorQualification
 * @see labDetailedInstructorQualificationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class labDetailedInstructorQualificationModelImpl extends BaseModelImpl<labDetailedInstructorQualification>
	implements labDetailedInstructorQualificationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lab detailed instructor qualification model instance should use the {@link labDetailedInstructorQualification} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_labDetailedInstructorQualification";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_courseInstructorQualificationId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "PK_projectId", Types.BIGINT },
			{ "PK_courseId", Types.BIGINT },
			{ "instructor1Qualification", Types.VARCHAR },
			{ "instructor2Qualification", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_courseInstructorQualificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("PK_projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("PK_courseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("instructor1Qualification", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("instructor2Qualification", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_labDetailedInstructorQualification (PK_courseInstructorQualificationId LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,PK_projectId LONG,PK_courseId LONG,instructor1Qualification VARCHAR(75) null,instructor2Qualification VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_labDetailedInstructorQualification";
	public static final String ORDER_BY_JPQL = " ORDER BY labDetailedInstructorQualification.PK_courseInstructorQualificationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_labDetailedInstructorQualification.PK_courseInstructorQualificationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.labDetailedInstructorQualification"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.labDetailedInstructorQualification"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.collaborated.entity.model.labDetailedInstructorQualification"),
			true);
	public static final long PK_COURSEID_COLUMN_BITMASK = 1L;
	public static final long PK_COURSEINSTRUCTORQUALIFICATIONID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static labDetailedInstructorQualification toModel(
		labDetailedInstructorQualificationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		labDetailedInstructorQualification model = new labDetailedInstructorQualificationImpl();

		model.setPK_courseInstructorQualificationId(soapModel.getPK_courseInstructorQualificationId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPK_projectId(soapModel.getPK_projectId());
		model.setPK_courseId(soapModel.getPK_courseId());
		model.setInstructor1Qualification(soapModel.getInstructor1Qualification());
		model.setInstructor2Qualification(soapModel.getInstructor2Qualification());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<labDetailedInstructorQualification> toModels(
		labDetailedInstructorQualificationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<labDetailedInstructorQualification> models = new ArrayList<labDetailedInstructorQualification>(soapModels.length);

		for (labDetailedInstructorQualificationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.labDetailedInstructorQualification"));

	public labDetailedInstructorQualificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_courseInstructorQualificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_courseInstructorQualificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_courseInstructorQualificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedInstructorQualification.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedInstructorQualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseInstructorQualificationId",
			getPK_courseInstructorQualificationId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("instructor1Qualification", getInstructor1Qualification());
		attributes.put("instructor2Qualification", getInstructor2Qualification());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseInstructorQualificationId = (Long)attributes.get(
				"PK_courseInstructorQualificationId");

		if (PK_courseInstructorQualificationId != null) {
			setPK_courseInstructorQualificationId(PK_courseInstructorQualificationId);
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

		String instructor1Qualification = (String)attributes.get(
				"instructor1Qualification");

		if (instructor1Qualification != null) {
			setInstructor1Qualification(instructor1Qualification);
		}

		String instructor2Qualification = (String)attributes.get(
				"instructor2Qualification");

		if (instructor2Qualification != null) {
			setInstructor2Qualification(instructor2Qualification);
		}
	}

	@JSON
	@Override
	public long getPK_courseInstructorQualificationId() {
		return _PK_courseInstructorQualificationId;
	}

	@Override
	public void setPK_courseInstructorQualificationId(
		long PK_courseInstructorQualificationId) {
		_PK_courseInstructorQualificationId = PK_courseInstructorQualificationId;
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
		_columnBitmask |= PK_COURSEID_COLUMN_BITMASK;

		if (!_setOriginalPK_courseId) {
			_setOriginalPK_courseId = true;

			_originalPK_courseId = _PK_courseId;
		}

		_PK_courseId = PK_courseId;
	}

	public long getOriginalPK_courseId() {
		return _originalPK_courseId;
	}

	@JSON
	@Override
	public String getInstructor1Qualification() {
		if (_instructor1Qualification == null) {
			return StringPool.BLANK;
		}
		else {
			return _instructor1Qualification;
		}
	}

	@Override
	public void setInstructor1Qualification(String instructor1Qualification) {
		_instructor1Qualification = instructor1Qualification;
	}

	@JSON
	@Override
	public String getInstructor2Qualification() {
		if (_instructor2Qualification == null) {
			return StringPool.BLANK;
		}
		else {
			return _instructor2Qualification;
		}
	}

	@Override
	public void setInstructor2Qualification(String instructor2Qualification) {
		_instructor2Qualification = instructor2Qualification;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			labDetailedInstructorQualification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public labDetailedInstructorQualification toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (labDetailedInstructorQualification)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		labDetailedInstructorQualificationImpl labDetailedInstructorQualificationImpl =
			new labDetailedInstructorQualificationImpl();

		labDetailedInstructorQualificationImpl.setPK_courseInstructorQualificationId(getPK_courseInstructorQualificationId());
		labDetailedInstructorQualificationImpl.setGroupId(getGroupId());
		labDetailedInstructorQualificationImpl.setUserId(getUserId());
		labDetailedInstructorQualificationImpl.setCreateDate(getCreateDate());
		labDetailedInstructorQualificationImpl.setModifiedDate(getModifiedDate());
		labDetailedInstructorQualificationImpl.setPK_projectId(getPK_projectId());
		labDetailedInstructorQualificationImpl.setPK_courseId(getPK_courseId());
		labDetailedInstructorQualificationImpl.setInstructor1Qualification(getInstructor1Qualification());
		labDetailedInstructorQualificationImpl.setInstructor2Qualification(getInstructor2Qualification());

		labDetailedInstructorQualificationImpl.resetOriginalValues();

		return labDetailedInstructorQualificationImpl;
	}

	@Override
	public int compareTo(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		long primaryKey = labDetailedInstructorQualification.getPrimaryKey();

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

		if (!(obj instanceof labDetailedInstructorQualification)) {
			return false;
		}

		labDetailedInstructorQualification labDetailedInstructorQualification = (labDetailedInstructorQualification)obj;

		long primaryKey = labDetailedInstructorQualification.getPrimaryKey();

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
		labDetailedInstructorQualificationModelImpl labDetailedInstructorQualificationModelImpl =
			this;

		labDetailedInstructorQualificationModelImpl._setModifiedDate = false;

		labDetailedInstructorQualificationModelImpl._originalPK_courseId = labDetailedInstructorQualificationModelImpl._PK_courseId;

		labDetailedInstructorQualificationModelImpl._setOriginalPK_courseId = false;

		labDetailedInstructorQualificationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<labDetailedInstructorQualification> toCacheModel() {
		labDetailedInstructorQualificationCacheModel labDetailedInstructorQualificationCacheModel =
			new labDetailedInstructorQualificationCacheModel();

		labDetailedInstructorQualificationCacheModel.PK_courseInstructorQualificationId = getPK_courseInstructorQualificationId();

		labDetailedInstructorQualificationCacheModel.groupId = getGroupId();

		labDetailedInstructorQualificationCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			labDetailedInstructorQualificationCacheModel.createDate = createDate.getTime();
		}
		else {
			labDetailedInstructorQualificationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			labDetailedInstructorQualificationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			labDetailedInstructorQualificationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		labDetailedInstructorQualificationCacheModel.PK_projectId = getPK_projectId();

		labDetailedInstructorQualificationCacheModel.PK_courseId = getPK_courseId();

		labDetailedInstructorQualificationCacheModel.instructor1Qualification = getInstructor1Qualification();

		String instructor1Qualification = labDetailedInstructorQualificationCacheModel.instructor1Qualification;

		if ((instructor1Qualification != null) &&
				(instructor1Qualification.length() == 0)) {
			labDetailedInstructorQualificationCacheModel.instructor1Qualification = null;
		}

		labDetailedInstructorQualificationCacheModel.instructor2Qualification = getInstructor2Qualification();

		String instructor2Qualification = labDetailedInstructorQualificationCacheModel.instructor2Qualification;

		if ((instructor2Qualification != null) &&
				(instructor2Qualification.length() == 0)) {
			labDetailedInstructorQualificationCacheModel.instructor2Qualification = null;
		}

		return labDetailedInstructorQualificationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{PK_courseInstructorQualificationId=");
		sb.append(getPK_courseInstructorQualificationId());
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
		sb.append(", instructor1Qualification=");
		sb.append(getInstructor1Qualification());
		sb.append(", instructor2Qualification=");
		sb.append(getInstructor2Qualification());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.collaborated.entity.model.labDetailedInstructorQualification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_courseInstructorQualificationId</column-name><column-value><![CDATA[");
		sb.append(getPK_courseInstructorQualificationId());
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
			"<column><column-name>instructor1Qualification</column-name><column-value><![CDATA[");
		sb.append(getInstructor1Qualification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>instructor2Qualification</column-name><column-value><![CDATA[");
		sb.append(getInstructor2Qualification());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = labDetailedInstructorQualification.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			labDetailedInstructorQualification.class
		};
	private long _PK_courseInstructorQualificationId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _PK_projectId;
	private long _PK_courseId;
	private long _originalPK_courseId;
	private boolean _setOriginalPK_courseId;
	private String _instructor1Qualification;
	private String _instructor2Qualification;
	private long _columnBitmask;
	private labDetailedInstructorQualification _escapedModel;
}