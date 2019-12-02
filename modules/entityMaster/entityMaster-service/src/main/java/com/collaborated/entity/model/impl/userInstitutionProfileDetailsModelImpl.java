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

import com.collaborated.entity.model.userInstitutionProfileDetails;
import com.collaborated.entity.model.userInstitutionProfileDetailsModel;
import com.collaborated.entity.model.userInstitutionProfileDetailsSoap;

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
 * The base model implementation for the userInstitutionProfileDetails service. Represents a row in the &quot;collaborated_userInstitutionProfileDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link userInstitutionProfileDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link userInstitutionProfileDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileDetailsImpl
 * @see userInstitutionProfileDetails
 * @see userInstitutionProfileDetailsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class userInstitutionProfileDetailsModelImpl extends BaseModelImpl<userInstitutionProfileDetails>
	implements userInstitutionProfileDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user institution profile details model instance should use the {@link userInstitutionProfileDetails} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_userInstitutionProfileDetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_userInstition", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "institutionName", Types.VARCHAR },
			{ "acadeCalendar", Types.VARCHAR },
			{ "departmentdescription", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_userInstition", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("institutionName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("acadeCalendar", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("departmentdescription", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_userInstitutionProfileDetails (PK_userInstition LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,institutionName VARCHAR(75) null,acadeCalendar VARCHAR(75) null,departmentdescription VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_userInstitutionProfileDetails";
	public static final String ORDER_BY_JPQL = " ORDER BY userInstitutionProfileDetails.PK_userInstition ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_userInstitutionProfileDetails.PK_userInstition ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.userInstitutionProfileDetails"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.userInstitutionProfileDetails"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static userInstitutionProfileDetails toModel(
		userInstitutionProfileDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		userInstitutionProfileDetails model = new userInstitutionProfileDetailsImpl();

		model.setPK_userInstition(soapModel.getPK_userInstition());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setInstitutionName(soapModel.getInstitutionName());
		model.setAcadeCalendar(soapModel.getAcadeCalendar());
		model.setDepartmentdescription(soapModel.getDepartmentdescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<userInstitutionProfileDetails> toModels(
		userInstitutionProfileDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<userInstitutionProfileDetails> models = new ArrayList<userInstitutionProfileDetails>(soapModels.length);

		for (userInstitutionProfileDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.userInstitutionProfileDetails"));

	public userInstitutionProfileDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_userInstition;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_userInstition(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_userInstition;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return userInstitutionProfileDetails.class;
	}

	@Override
	public String getModelClassName() {
		return userInstitutionProfileDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_userInstition", getPK_userInstition());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("institutionName", getInstitutionName());
		attributes.put("acadeCalendar", getAcadeCalendar());
		attributes.put("departmentdescription", getDepartmentdescription());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_userInstition = (Long)attributes.get("PK_userInstition");

		if (PK_userInstition != null) {
			setPK_userInstition(PK_userInstition);
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

		String institutionName = (String)attributes.get("institutionName");

		if (institutionName != null) {
			setInstitutionName(institutionName);
		}

		String acadeCalendar = (String)attributes.get("acadeCalendar");

		if (acadeCalendar != null) {
			setAcadeCalendar(acadeCalendar);
		}

		String departmentdescription = (String)attributes.get(
				"departmentdescription");

		if (departmentdescription != null) {
			setDepartmentdescription(departmentdescription);
		}
	}

	@JSON
	@Override
	public long getPK_userInstition() {
		return _PK_userInstition;
	}

	@Override
	public void setPK_userInstition(long PK_userInstition) {
		_PK_userInstition = PK_userInstition;
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
	public String getInstitutionName() {
		if (_institutionName == null) {
			return StringPool.BLANK;
		}
		else {
			return _institutionName;
		}
	}

	@Override
	public void setInstitutionName(String institutionName) {
		_institutionName = institutionName;
	}

	@JSON
	@Override
	public String getAcadeCalendar() {
		if (_acadeCalendar == null) {
			return StringPool.BLANK;
		}
		else {
			return _acadeCalendar;
		}
	}

	@Override
	public void setAcadeCalendar(String acadeCalendar) {
		_acadeCalendar = acadeCalendar;
	}

	@JSON
	@Override
	public String getDepartmentdescription() {
		if (_departmentdescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _departmentdescription;
		}
	}

	@Override
	public void setDepartmentdescription(String departmentdescription) {
		_departmentdescription = departmentdescription;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			userInstitutionProfileDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public userInstitutionProfileDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (userInstitutionProfileDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		userInstitutionProfileDetailsImpl userInstitutionProfileDetailsImpl = new userInstitutionProfileDetailsImpl();

		userInstitutionProfileDetailsImpl.setPK_userInstition(getPK_userInstition());
		userInstitutionProfileDetailsImpl.setGroupId(getGroupId());
		userInstitutionProfileDetailsImpl.setUserId(getUserId());
		userInstitutionProfileDetailsImpl.setCreateDate(getCreateDate());
		userInstitutionProfileDetailsImpl.setModifiedDate(getModifiedDate());
		userInstitutionProfileDetailsImpl.setInstitutionName(getInstitutionName());
		userInstitutionProfileDetailsImpl.setAcadeCalendar(getAcadeCalendar());
		userInstitutionProfileDetailsImpl.setDepartmentdescription(getDepartmentdescription());

		userInstitutionProfileDetailsImpl.resetOriginalValues();

		return userInstitutionProfileDetailsImpl;
	}

	@Override
	public int compareTo(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		long primaryKey = userInstitutionProfileDetails.getPrimaryKey();

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

		if (!(obj instanceof userInstitutionProfileDetails)) {
			return false;
		}

		userInstitutionProfileDetails userInstitutionProfileDetails = (userInstitutionProfileDetails)obj;

		long primaryKey = userInstitutionProfileDetails.getPrimaryKey();

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
		userInstitutionProfileDetailsModelImpl userInstitutionProfileDetailsModelImpl =
			this;

		userInstitutionProfileDetailsModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<userInstitutionProfileDetails> toCacheModel() {
		userInstitutionProfileDetailsCacheModel userInstitutionProfileDetailsCacheModel =
			new userInstitutionProfileDetailsCacheModel();

		userInstitutionProfileDetailsCacheModel.PK_userInstition = getPK_userInstition();

		userInstitutionProfileDetailsCacheModel.groupId = getGroupId();

		userInstitutionProfileDetailsCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			userInstitutionProfileDetailsCacheModel.createDate = createDate.getTime();
		}
		else {
			userInstitutionProfileDetailsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			userInstitutionProfileDetailsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			userInstitutionProfileDetailsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		userInstitutionProfileDetailsCacheModel.institutionName = getInstitutionName();

		String institutionName = userInstitutionProfileDetailsCacheModel.institutionName;

		if ((institutionName != null) && (institutionName.length() == 0)) {
			userInstitutionProfileDetailsCacheModel.institutionName = null;
		}

		userInstitutionProfileDetailsCacheModel.acadeCalendar = getAcadeCalendar();

		String acadeCalendar = userInstitutionProfileDetailsCacheModel.acadeCalendar;

		if ((acadeCalendar != null) && (acadeCalendar.length() == 0)) {
			userInstitutionProfileDetailsCacheModel.acadeCalendar = null;
		}

		userInstitutionProfileDetailsCacheModel.departmentdescription = getDepartmentdescription();

		String departmentdescription = userInstitutionProfileDetailsCacheModel.departmentdescription;

		if ((departmentdescription != null) &&
				(departmentdescription.length() == 0)) {
			userInstitutionProfileDetailsCacheModel.departmentdescription = null;
		}

		return userInstitutionProfileDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{PK_userInstition=");
		sb.append(getPK_userInstition());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", institutionName=");
		sb.append(getInstitutionName());
		sb.append(", acadeCalendar=");
		sb.append(getAcadeCalendar());
		sb.append(", departmentdescription=");
		sb.append(getDepartmentdescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.collaborated.entity.model.userInstitutionProfileDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_userInstition</column-name><column-value><![CDATA[");
		sb.append(getPK_userInstition());
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
			"<column><column-name>institutionName</column-name><column-value><![CDATA[");
		sb.append(getInstitutionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>acadeCalendar</column-name><column-value><![CDATA[");
		sb.append(getAcadeCalendar());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentdescription</column-name><column-value><![CDATA[");
		sb.append(getDepartmentdescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = userInstitutionProfileDetails.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			userInstitutionProfileDetails.class
		};
	private long _PK_userInstition;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _institutionName;
	private String _acadeCalendar;
	private String _departmentdescription;
	private userInstitutionProfileDetails _escapedModel;
}