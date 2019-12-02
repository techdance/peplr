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

import com.collaborated.entity.model.userCredential;
import com.collaborated.entity.model.userCredentialModel;
import com.collaborated.entity.model.userCredentialSoap;

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
 * The base model implementation for the userCredential service. Represents a row in the &quot;collaborated_userCredential&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link userCredentialModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link userCredentialImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userCredentialImpl
 * @see userCredential
 * @see userCredentialModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class userCredentialModelImpl extends BaseModelImpl<userCredential>
	implements userCredentialModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user credential model instance should use the {@link userCredential} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_userCredential";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_userCredential", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "membership1", Types.VARCHAR },
			{ "membership2", Types.VARCHAR },
			{ "membership3", Types.VARCHAR },
			{ "membership4", Types.VARCHAR },
			{ "certificate1", Types.VARCHAR },
			{ "certificate2", Types.VARCHAR },
			{ "certificate3", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_userCredential", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("membership1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("membership2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("membership3", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("membership4", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("certificate1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("certificate2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("certificate3", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_userCredential (PK_userCredential LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,membership1 VARCHAR(75) null,membership2 VARCHAR(75) null,membership3 VARCHAR(75) null,membership4 VARCHAR(75) null,certificate1 VARCHAR(75) null,certificate2 VARCHAR(75) null,certificate3 VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_userCredential";
	public static final String ORDER_BY_JPQL = " ORDER BY userCredential.PK_userCredential ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_userCredential.PK_userCredential ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.userCredential"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.userCredential"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static userCredential toModel(userCredentialSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		userCredential model = new userCredentialImpl();

		model.setPK_userCredential(soapModel.getPK_userCredential());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setMembership1(soapModel.getMembership1());
		model.setMembership2(soapModel.getMembership2());
		model.setMembership3(soapModel.getMembership3());
		model.setMembership4(soapModel.getMembership4());
		model.setCertificate1(soapModel.getCertificate1());
		model.setCertificate2(soapModel.getCertificate2());
		model.setCertificate3(soapModel.getCertificate3());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<userCredential> toModels(userCredentialSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<userCredential> models = new ArrayList<userCredential>(soapModels.length);

		for (userCredentialSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.userCredential"));

	public userCredentialModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_userCredential;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_userCredential(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_userCredential;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return userCredential.class;
	}

	@Override
	public String getModelClassName() {
		return userCredential.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_userCredential", getPK_userCredential());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("membership1", getMembership1());
		attributes.put("membership2", getMembership2());
		attributes.put("membership3", getMembership3());
		attributes.put("membership4", getMembership4());
		attributes.put("certificate1", getCertificate1());
		attributes.put("certificate2", getCertificate2());
		attributes.put("certificate3", getCertificate3());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_userCredential = (Long)attributes.get("PK_userCredential");

		if (PK_userCredential != null) {
			setPK_userCredential(PK_userCredential);
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

		String membership1 = (String)attributes.get("membership1");

		if (membership1 != null) {
			setMembership1(membership1);
		}

		String membership2 = (String)attributes.get("membership2");

		if (membership2 != null) {
			setMembership2(membership2);
		}

		String membership3 = (String)attributes.get("membership3");

		if (membership3 != null) {
			setMembership3(membership3);
		}

		String membership4 = (String)attributes.get("membership4");

		if (membership4 != null) {
			setMembership4(membership4);
		}

		String certificate1 = (String)attributes.get("certificate1");

		if (certificate1 != null) {
			setCertificate1(certificate1);
		}

		String certificate2 = (String)attributes.get("certificate2");

		if (certificate2 != null) {
			setCertificate2(certificate2);
		}

		String certificate3 = (String)attributes.get("certificate3");

		if (certificate3 != null) {
			setCertificate3(certificate3);
		}
	}

	@JSON
	@Override
	public long getPK_userCredential() {
		return _PK_userCredential;
	}

	@Override
	public void setPK_userCredential(long PK_userCredential) {
		_PK_userCredential = PK_userCredential;
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
	public String getMembership1() {
		if (_membership1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _membership1;
		}
	}

	@Override
	public void setMembership1(String membership1) {
		_membership1 = membership1;
	}

	@JSON
	@Override
	public String getMembership2() {
		if (_membership2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _membership2;
		}
	}

	@Override
	public void setMembership2(String membership2) {
		_membership2 = membership2;
	}

	@JSON
	@Override
	public String getMembership3() {
		if (_membership3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _membership3;
		}
	}

	@Override
	public void setMembership3(String membership3) {
		_membership3 = membership3;
	}

	@JSON
	@Override
	public String getMembership4() {
		if (_membership4 == null) {
			return StringPool.BLANK;
		}
		else {
			return _membership4;
		}
	}

	@Override
	public void setMembership4(String membership4) {
		_membership4 = membership4;
	}

	@JSON
	@Override
	public String getCertificate1() {
		if (_certificate1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _certificate1;
		}
	}

	@Override
	public void setCertificate1(String certificate1) {
		_certificate1 = certificate1;
	}

	@JSON
	@Override
	public String getCertificate2() {
		if (_certificate2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _certificate2;
		}
	}

	@Override
	public void setCertificate2(String certificate2) {
		_certificate2 = certificate2;
	}

	@JSON
	@Override
	public String getCertificate3() {
		if (_certificate3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _certificate3;
		}
	}

	@Override
	public void setCertificate3(String certificate3) {
		_certificate3 = certificate3;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			userCredential.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public userCredential toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (userCredential)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		userCredentialImpl userCredentialImpl = new userCredentialImpl();

		userCredentialImpl.setPK_userCredential(getPK_userCredential());
		userCredentialImpl.setGroupId(getGroupId());
		userCredentialImpl.setUserId(getUserId());
		userCredentialImpl.setCreateDate(getCreateDate());
		userCredentialImpl.setModifiedDate(getModifiedDate());
		userCredentialImpl.setMembership1(getMembership1());
		userCredentialImpl.setMembership2(getMembership2());
		userCredentialImpl.setMembership3(getMembership3());
		userCredentialImpl.setMembership4(getMembership4());
		userCredentialImpl.setCertificate1(getCertificate1());
		userCredentialImpl.setCertificate2(getCertificate2());
		userCredentialImpl.setCertificate3(getCertificate3());

		userCredentialImpl.resetOriginalValues();

		return userCredentialImpl;
	}

	@Override
	public int compareTo(userCredential userCredential) {
		long primaryKey = userCredential.getPrimaryKey();

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

		if (!(obj instanceof userCredential)) {
			return false;
		}

		userCredential userCredential = (userCredential)obj;

		long primaryKey = userCredential.getPrimaryKey();

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
		userCredentialModelImpl userCredentialModelImpl = this;

		userCredentialModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<userCredential> toCacheModel() {
		userCredentialCacheModel userCredentialCacheModel = new userCredentialCacheModel();

		userCredentialCacheModel.PK_userCredential = getPK_userCredential();

		userCredentialCacheModel.groupId = getGroupId();

		userCredentialCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			userCredentialCacheModel.createDate = createDate.getTime();
		}
		else {
			userCredentialCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			userCredentialCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			userCredentialCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		userCredentialCacheModel.membership1 = getMembership1();

		String membership1 = userCredentialCacheModel.membership1;

		if ((membership1 != null) && (membership1.length() == 0)) {
			userCredentialCacheModel.membership1 = null;
		}

		userCredentialCacheModel.membership2 = getMembership2();

		String membership2 = userCredentialCacheModel.membership2;

		if ((membership2 != null) && (membership2.length() == 0)) {
			userCredentialCacheModel.membership2 = null;
		}

		userCredentialCacheModel.membership3 = getMembership3();

		String membership3 = userCredentialCacheModel.membership3;

		if ((membership3 != null) && (membership3.length() == 0)) {
			userCredentialCacheModel.membership3 = null;
		}

		userCredentialCacheModel.membership4 = getMembership4();

		String membership4 = userCredentialCacheModel.membership4;

		if ((membership4 != null) && (membership4.length() == 0)) {
			userCredentialCacheModel.membership4 = null;
		}

		userCredentialCacheModel.certificate1 = getCertificate1();

		String certificate1 = userCredentialCacheModel.certificate1;

		if ((certificate1 != null) && (certificate1.length() == 0)) {
			userCredentialCacheModel.certificate1 = null;
		}

		userCredentialCacheModel.certificate2 = getCertificate2();

		String certificate2 = userCredentialCacheModel.certificate2;

		if ((certificate2 != null) && (certificate2.length() == 0)) {
			userCredentialCacheModel.certificate2 = null;
		}

		userCredentialCacheModel.certificate3 = getCertificate3();

		String certificate3 = userCredentialCacheModel.certificate3;

		if ((certificate3 != null) && (certificate3.length() == 0)) {
			userCredentialCacheModel.certificate3 = null;
		}

		return userCredentialCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{PK_userCredential=");
		sb.append(getPK_userCredential());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", membership1=");
		sb.append(getMembership1());
		sb.append(", membership2=");
		sb.append(getMembership2());
		sb.append(", membership3=");
		sb.append(getMembership3());
		sb.append(", membership4=");
		sb.append(getMembership4());
		sb.append(", certificate1=");
		sb.append(getCertificate1());
		sb.append(", certificate2=");
		sb.append(getCertificate2());
		sb.append(", certificate3=");
		sb.append(getCertificate3());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.collaborated.entity.model.userCredential");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_userCredential</column-name><column-value><![CDATA[");
		sb.append(getPK_userCredential());
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
			"<column><column-name>membership1</column-name><column-value><![CDATA[");
		sb.append(getMembership1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>membership2</column-name><column-value><![CDATA[");
		sb.append(getMembership2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>membership3</column-name><column-value><![CDATA[");
		sb.append(getMembership3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>membership4</column-name><column-value><![CDATA[");
		sb.append(getMembership4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificate1</column-name><column-value><![CDATA[");
		sb.append(getCertificate1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificate2</column-name><column-value><![CDATA[");
		sb.append(getCertificate2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificate3</column-name><column-value><![CDATA[");
		sb.append(getCertificate3());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = userCredential.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			userCredential.class
		};
	private long _PK_userCredential;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _membership1;
	private String _membership2;
	private String _membership3;
	private String _membership4;
	private String _certificate1;
	private String _certificate2;
	private String _certificate3;
	private userCredential _escapedModel;
}