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

import com.collaborated.entity.model.userInstitutionProfileSubDetails;
import com.collaborated.entity.model.userInstitutionProfileSubDetailsModel;
import com.collaborated.entity.model.userInstitutionProfileSubDetailsSoap;

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
 * The base model implementation for the userInstitutionProfileSubDetails service. Represents a row in the &quot;collaborated_userInstitutionProfileSubDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link userInstitutionProfileSubDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link userInstitutionProfileSubDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileSubDetailsImpl
 * @see userInstitutionProfileSubDetails
 * @see userInstitutionProfileSubDetailsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class userInstitutionProfileSubDetailsModelImpl extends BaseModelImpl<userInstitutionProfileSubDetails>
	implements userInstitutionProfileSubDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user institution profile sub details model instance should use the {@link userInstitutionProfileSubDetails} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_userInstitutionProfileSubDetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_userInstitionSub", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "fileId", Types.BIGINT },
			{ "PK_userInstition", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_userInstitionSub", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("PK_userInstition", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_userInstitutionProfileSubDetails (PK_userInstitionSub LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,fileId LONG,PK_userInstition LONG)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_userInstitutionProfileSubDetails";
	public static final String ORDER_BY_JPQL = " ORDER BY userInstitutionProfileSubDetails.PK_userInstitionSub ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_userInstitutionProfileSubDetails.PK_userInstitionSub ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.userInstitutionProfileSubDetails"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.userInstitutionProfileSubDetails"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static userInstitutionProfileSubDetails toModel(
		userInstitutionProfileSubDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		userInstitutionProfileSubDetails model = new userInstitutionProfileSubDetailsImpl();

		model.setPK_userInstitionSub(soapModel.getPK_userInstitionSub());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFileId(soapModel.getFileId());
		model.setPK_userInstition(soapModel.getPK_userInstition());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<userInstitutionProfileSubDetails> toModels(
		userInstitutionProfileSubDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<userInstitutionProfileSubDetails> models = new ArrayList<userInstitutionProfileSubDetails>(soapModels.length);

		for (userInstitutionProfileSubDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.userInstitutionProfileSubDetails"));

	public userInstitutionProfileSubDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_userInstitionSub;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_userInstitionSub(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_userInstitionSub;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return userInstitutionProfileSubDetails.class;
	}

	@Override
	public String getModelClassName() {
		return userInstitutionProfileSubDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_userInstitionSub", getPK_userInstitionSub());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fileId", getFileId());
		attributes.put("PK_userInstition", getPK_userInstition());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_userInstitionSub = (Long)attributes.get("PK_userInstitionSub");

		if (PK_userInstitionSub != null) {
			setPK_userInstitionSub(PK_userInstitionSub);
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

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		Long PK_userInstition = (Long)attributes.get("PK_userInstition");

		if (PK_userInstition != null) {
			setPK_userInstition(PK_userInstition);
		}
	}

	@JSON
	@Override
	public long getPK_userInstitionSub() {
		return _PK_userInstitionSub;
	}

	@Override
	public void setPK_userInstitionSub(long PK_userInstitionSub) {
		_PK_userInstitionSub = PK_userInstitionSub;
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
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		_fileId = fileId;
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			userInstitutionProfileSubDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public userInstitutionProfileSubDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (userInstitutionProfileSubDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		userInstitutionProfileSubDetailsImpl userInstitutionProfileSubDetailsImpl =
			new userInstitutionProfileSubDetailsImpl();

		userInstitutionProfileSubDetailsImpl.setPK_userInstitionSub(getPK_userInstitionSub());
		userInstitutionProfileSubDetailsImpl.setGroupId(getGroupId());
		userInstitutionProfileSubDetailsImpl.setUserId(getUserId());
		userInstitutionProfileSubDetailsImpl.setCreateDate(getCreateDate());
		userInstitutionProfileSubDetailsImpl.setModifiedDate(getModifiedDate());
		userInstitutionProfileSubDetailsImpl.setFileId(getFileId());
		userInstitutionProfileSubDetailsImpl.setPK_userInstition(getPK_userInstition());

		userInstitutionProfileSubDetailsImpl.resetOriginalValues();

		return userInstitutionProfileSubDetailsImpl;
	}

	@Override
	public int compareTo(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		long primaryKey = userInstitutionProfileSubDetails.getPrimaryKey();

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

		if (!(obj instanceof userInstitutionProfileSubDetails)) {
			return false;
		}

		userInstitutionProfileSubDetails userInstitutionProfileSubDetails = (userInstitutionProfileSubDetails)obj;

		long primaryKey = userInstitutionProfileSubDetails.getPrimaryKey();

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
		userInstitutionProfileSubDetailsModelImpl userInstitutionProfileSubDetailsModelImpl =
			this;

		userInstitutionProfileSubDetailsModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<userInstitutionProfileSubDetails> toCacheModel() {
		userInstitutionProfileSubDetailsCacheModel userInstitutionProfileSubDetailsCacheModel =
			new userInstitutionProfileSubDetailsCacheModel();

		userInstitutionProfileSubDetailsCacheModel.PK_userInstitionSub = getPK_userInstitionSub();

		userInstitutionProfileSubDetailsCacheModel.groupId = getGroupId();

		userInstitutionProfileSubDetailsCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			userInstitutionProfileSubDetailsCacheModel.createDate = createDate.getTime();
		}
		else {
			userInstitutionProfileSubDetailsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			userInstitutionProfileSubDetailsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			userInstitutionProfileSubDetailsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		userInstitutionProfileSubDetailsCacheModel.fileId = getFileId();

		userInstitutionProfileSubDetailsCacheModel.PK_userInstition = getPK_userInstition();

		return userInstitutionProfileSubDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{PK_userInstitionSub=");
		sb.append(getPK_userInstitionSub());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", fileId=");
		sb.append(getFileId());
		sb.append(", PK_userInstition=");
		sb.append(getPK_userInstition());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append(
			"com.collaborated.entity.model.userInstitutionProfileSubDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_userInstitionSub</column-name><column-value><![CDATA[");
		sb.append(getPK_userInstitionSub());
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
			"<column><column-name>fileId</column-name><column-value><![CDATA[");
		sb.append(getFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PK_userInstition</column-name><column-value><![CDATA[");
		sb.append(getPK_userInstition());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = userInstitutionProfileSubDetails.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			userInstitutionProfileSubDetails.class
		};
	private long _PK_userInstitionSub;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _fileId;
	private long _PK_userInstition;
	private userInstitutionProfileSubDetails _escapedModel;
}