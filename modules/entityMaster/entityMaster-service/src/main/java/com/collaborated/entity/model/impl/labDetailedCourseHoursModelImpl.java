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

import com.collaborated.entity.model.labDetailedCourseHours;
import com.collaborated.entity.model.labDetailedCourseHoursModel;
import com.collaborated.entity.model.labDetailedCourseHoursSoap;

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
 * The base model implementation for the labDetailedCourseHours service. Represents a row in the &quot;collaborated_labDetailedCourseHours&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link labDetailedCourseHoursModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link labDetailedCourseHoursImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseHoursImpl
 * @see labDetailedCourseHours
 * @see labDetailedCourseHoursModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class labDetailedCourseHoursModelImpl extends BaseModelImpl<labDetailedCourseHours>
	implements labDetailedCourseHoursModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lab detailed course hours model instance should use the {@link labDetailedCourseHours} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_labDetailedCourseHours";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_courseHoursId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "PK_projectId", Types.BIGINT },
			{ "PK_courseId", Types.BIGINT },
			{ "numberOfCredits", Types.BIGINT },
			{ "numberOfCourseWeeks", Types.BIGINT },
			{ "courseHoursPerWeek", Types.BIGINT },
			{ "lectureHoursPerWeek", Types.BIGINT },
			{ "labHoursPerWeek", Types.BIGINT },
			{ "independentStudyHoursPerWeek", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_courseHoursId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("PK_projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("PK_courseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("numberOfCredits", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("numberOfCourseWeeks", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("courseHoursPerWeek", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lectureHoursPerWeek", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("labHoursPerWeek", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("independentStudyHoursPerWeek", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_labDetailedCourseHours (PK_courseHoursId LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,PK_projectId LONG,PK_courseId LONG,numberOfCredits LONG,numberOfCourseWeeks LONG,courseHoursPerWeek LONG,lectureHoursPerWeek LONG,labHoursPerWeek LONG,independentStudyHoursPerWeek LONG)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_labDetailedCourseHours";
	public static final String ORDER_BY_JPQL = " ORDER BY labDetailedCourseHours.PK_courseHoursId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_labDetailedCourseHours.PK_courseHoursId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.labDetailedCourseHours"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.labDetailedCourseHours"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.collaborated.entity.model.labDetailedCourseHours"),
			true);
	public static final long PK_COURSEID_COLUMN_BITMASK = 1L;
	public static final long PK_COURSEHOURSID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static labDetailedCourseHours toModel(
		labDetailedCourseHoursSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		labDetailedCourseHours model = new labDetailedCourseHoursImpl();

		model.setPK_courseHoursId(soapModel.getPK_courseHoursId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPK_projectId(soapModel.getPK_projectId());
		model.setPK_courseId(soapModel.getPK_courseId());
		model.setNumberOfCredits(soapModel.getNumberOfCredits());
		model.setNumberOfCourseWeeks(soapModel.getNumberOfCourseWeeks());
		model.setCourseHoursPerWeek(soapModel.getCourseHoursPerWeek());
		model.setLectureHoursPerWeek(soapModel.getLectureHoursPerWeek());
		model.setLabHoursPerWeek(soapModel.getLabHoursPerWeek());
		model.setIndependentStudyHoursPerWeek(soapModel.getIndependentStudyHoursPerWeek());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<labDetailedCourseHours> toModels(
		labDetailedCourseHoursSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<labDetailedCourseHours> models = new ArrayList<labDetailedCourseHours>(soapModels.length);

		for (labDetailedCourseHoursSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.labDetailedCourseHours"));

	public labDetailedCourseHoursModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_courseHoursId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_courseHoursId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_courseHoursId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedCourseHours.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedCourseHours.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseHoursId", getPK_courseHoursId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("numberOfCredits", getNumberOfCredits());
		attributes.put("numberOfCourseWeeks", getNumberOfCourseWeeks());
		attributes.put("courseHoursPerWeek", getCourseHoursPerWeek());
		attributes.put("lectureHoursPerWeek", getLectureHoursPerWeek());
		attributes.put("labHoursPerWeek", getLabHoursPerWeek());
		attributes.put("independentStudyHoursPerWeek",
			getIndependentStudyHoursPerWeek());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseHoursId = (Long)attributes.get("PK_courseHoursId");

		if (PK_courseHoursId != null) {
			setPK_courseHoursId(PK_courseHoursId);
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

		Long numberOfCredits = (Long)attributes.get("numberOfCredits");

		if (numberOfCredits != null) {
			setNumberOfCredits(numberOfCredits);
		}

		Long numberOfCourseWeeks = (Long)attributes.get("numberOfCourseWeeks");

		if (numberOfCourseWeeks != null) {
			setNumberOfCourseWeeks(numberOfCourseWeeks);
		}

		Long courseHoursPerWeek = (Long)attributes.get("courseHoursPerWeek");

		if (courseHoursPerWeek != null) {
			setCourseHoursPerWeek(courseHoursPerWeek);
		}

		Long lectureHoursPerWeek = (Long)attributes.get("lectureHoursPerWeek");

		if (lectureHoursPerWeek != null) {
			setLectureHoursPerWeek(lectureHoursPerWeek);
		}

		Long labHoursPerWeek = (Long)attributes.get("labHoursPerWeek");

		if (labHoursPerWeek != null) {
			setLabHoursPerWeek(labHoursPerWeek);
		}

		Long independentStudyHoursPerWeek = (Long)attributes.get(
				"independentStudyHoursPerWeek");

		if (independentStudyHoursPerWeek != null) {
			setIndependentStudyHoursPerWeek(independentStudyHoursPerWeek);
		}
	}

	@JSON
	@Override
	public long getPK_courseHoursId() {
		return _PK_courseHoursId;
	}

	@Override
	public void setPK_courseHoursId(long PK_courseHoursId) {
		_PK_courseHoursId = PK_courseHoursId;
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
	public long getNumberOfCredits() {
		return _numberOfCredits;
	}

	@Override
	public void setNumberOfCredits(long numberOfCredits) {
		_numberOfCredits = numberOfCredits;
	}

	@JSON
	@Override
	public long getNumberOfCourseWeeks() {
		return _numberOfCourseWeeks;
	}

	@Override
	public void setNumberOfCourseWeeks(long numberOfCourseWeeks) {
		_numberOfCourseWeeks = numberOfCourseWeeks;
	}

	@JSON
	@Override
	public long getCourseHoursPerWeek() {
		return _courseHoursPerWeek;
	}

	@Override
	public void setCourseHoursPerWeek(long courseHoursPerWeek) {
		_courseHoursPerWeek = courseHoursPerWeek;
	}

	@JSON
	@Override
	public long getLectureHoursPerWeek() {
		return _lectureHoursPerWeek;
	}

	@Override
	public void setLectureHoursPerWeek(long lectureHoursPerWeek) {
		_lectureHoursPerWeek = lectureHoursPerWeek;
	}

	@JSON
	@Override
	public long getLabHoursPerWeek() {
		return _labHoursPerWeek;
	}

	@Override
	public void setLabHoursPerWeek(long labHoursPerWeek) {
		_labHoursPerWeek = labHoursPerWeek;
	}

	@JSON
	@Override
	public long getIndependentStudyHoursPerWeek() {
		return _independentStudyHoursPerWeek;
	}

	@Override
	public void setIndependentStudyHoursPerWeek(
		long independentStudyHoursPerWeek) {
		_independentStudyHoursPerWeek = independentStudyHoursPerWeek;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			labDetailedCourseHours.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public labDetailedCourseHours toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (labDetailedCourseHours)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		labDetailedCourseHoursImpl labDetailedCourseHoursImpl = new labDetailedCourseHoursImpl();

		labDetailedCourseHoursImpl.setPK_courseHoursId(getPK_courseHoursId());
		labDetailedCourseHoursImpl.setGroupId(getGroupId());
		labDetailedCourseHoursImpl.setUserId(getUserId());
		labDetailedCourseHoursImpl.setCreateDate(getCreateDate());
		labDetailedCourseHoursImpl.setModifiedDate(getModifiedDate());
		labDetailedCourseHoursImpl.setPK_projectId(getPK_projectId());
		labDetailedCourseHoursImpl.setPK_courseId(getPK_courseId());
		labDetailedCourseHoursImpl.setNumberOfCredits(getNumberOfCredits());
		labDetailedCourseHoursImpl.setNumberOfCourseWeeks(getNumberOfCourseWeeks());
		labDetailedCourseHoursImpl.setCourseHoursPerWeek(getCourseHoursPerWeek());
		labDetailedCourseHoursImpl.setLectureHoursPerWeek(getLectureHoursPerWeek());
		labDetailedCourseHoursImpl.setLabHoursPerWeek(getLabHoursPerWeek());
		labDetailedCourseHoursImpl.setIndependentStudyHoursPerWeek(getIndependentStudyHoursPerWeek());

		labDetailedCourseHoursImpl.resetOriginalValues();

		return labDetailedCourseHoursImpl;
	}

	@Override
	public int compareTo(labDetailedCourseHours labDetailedCourseHours) {
		long primaryKey = labDetailedCourseHours.getPrimaryKey();

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

		if (!(obj instanceof labDetailedCourseHours)) {
			return false;
		}

		labDetailedCourseHours labDetailedCourseHours = (labDetailedCourseHours)obj;

		long primaryKey = labDetailedCourseHours.getPrimaryKey();

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
		labDetailedCourseHoursModelImpl labDetailedCourseHoursModelImpl = this;

		labDetailedCourseHoursModelImpl._setModifiedDate = false;

		labDetailedCourseHoursModelImpl._originalPK_courseId = labDetailedCourseHoursModelImpl._PK_courseId;

		labDetailedCourseHoursModelImpl._setOriginalPK_courseId = false;

		labDetailedCourseHoursModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<labDetailedCourseHours> toCacheModel() {
		labDetailedCourseHoursCacheModel labDetailedCourseHoursCacheModel = new labDetailedCourseHoursCacheModel();

		labDetailedCourseHoursCacheModel.PK_courseHoursId = getPK_courseHoursId();

		labDetailedCourseHoursCacheModel.groupId = getGroupId();

		labDetailedCourseHoursCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			labDetailedCourseHoursCacheModel.createDate = createDate.getTime();
		}
		else {
			labDetailedCourseHoursCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			labDetailedCourseHoursCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			labDetailedCourseHoursCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		labDetailedCourseHoursCacheModel.PK_projectId = getPK_projectId();

		labDetailedCourseHoursCacheModel.PK_courseId = getPK_courseId();

		labDetailedCourseHoursCacheModel.numberOfCredits = getNumberOfCredits();

		labDetailedCourseHoursCacheModel.numberOfCourseWeeks = getNumberOfCourseWeeks();

		labDetailedCourseHoursCacheModel.courseHoursPerWeek = getCourseHoursPerWeek();

		labDetailedCourseHoursCacheModel.lectureHoursPerWeek = getLectureHoursPerWeek();

		labDetailedCourseHoursCacheModel.labHoursPerWeek = getLabHoursPerWeek();

		labDetailedCourseHoursCacheModel.independentStudyHoursPerWeek = getIndependentStudyHoursPerWeek();

		return labDetailedCourseHoursCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{PK_courseHoursId=");
		sb.append(getPK_courseHoursId());
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
		sb.append(", numberOfCredits=");
		sb.append(getNumberOfCredits());
		sb.append(", numberOfCourseWeeks=");
		sb.append(getNumberOfCourseWeeks());
		sb.append(", courseHoursPerWeek=");
		sb.append(getCourseHoursPerWeek());
		sb.append(", lectureHoursPerWeek=");
		sb.append(getLectureHoursPerWeek());
		sb.append(", labHoursPerWeek=");
		sb.append(getLabHoursPerWeek());
		sb.append(", independentStudyHoursPerWeek=");
		sb.append(getIndependentStudyHoursPerWeek());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.collaborated.entity.model.labDetailedCourseHours");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_courseHoursId</column-name><column-value><![CDATA[");
		sb.append(getPK_courseHoursId());
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
			"<column><column-name>numberOfCredits</column-name><column-value><![CDATA[");
		sb.append(getNumberOfCredits());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfCourseWeeks</column-name><column-value><![CDATA[");
		sb.append(getNumberOfCourseWeeks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseHoursPerWeek</column-name><column-value><![CDATA[");
		sb.append(getCourseHoursPerWeek());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureHoursPerWeek</column-name><column-value><![CDATA[");
		sb.append(getLectureHoursPerWeek());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>labHoursPerWeek</column-name><column-value><![CDATA[");
		sb.append(getLabHoursPerWeek());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>independentStudyHoursPerWeek</column-name><column-value><![CDATA[");
		sb.append(getIndependentStudyHoursPerWeek());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = labDetailedCourseHours.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			labDetailedCourseHours.class
		};
	private long _PK_courseHoursId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _PK_projectId;
	private long _PK_courseId;
	private long _originalPK_courseId;
	private boolean _setOriginalPK_courseId;
	private long _numberOfCredits;
	private long _numberOfCourseWeeks;
	private long _courseHoursPerWeek;
	private long _lectureHoursPerWeek;
	private long _labHoursPerWeek;
	private long _independentStudyHoursPerWeek;
	private long _columnBitmask;
	private labDetailedCourseHours _escapedModel;
}