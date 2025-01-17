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

import com.collaborated.entity.model.userProfessionalBio;
import com.collaborated.entity.model.userProfessionalBioModel;
import com.collaborated.entity.model.userProfessionalBioSoap;

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
 * The base model implementation for the userProfessionalBio service. Represents a row in the &quot;collaborated_userProfessionalBio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link userProfessionalBioModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link userProfessionalBioImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userProfessionalBioImpl
 * @see userProfessionalBio
 * @see userProfessionalBioModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class userProfessionalBioModelImpl extends BaseModelImpl<userProfessionalBio>
	implements userProfessionalBioModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user professional bio model instance should use the {@link userProfessionalBio} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_userProfessionalBio";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PK_userProfessionalBio", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "areaofexpertise1", Types.VARCHAR },
			{ "areaofexpertise2", Types.VARCHAR },
			{ "areaofexpertise3", Types.VARCHAR },
			{ "experienceyears", Types.VARCHAR },
			{ "cvlink", Types.VARCHAR },
			{ "biodescription", Types.VARCHAR },
			{ "bioDiscipline", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("PK_userProfessionalBio", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("areaofexpertise1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("areaofexpertise2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("areaofexpertise3", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("experienceyears", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cvlink", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("biodescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bioDiscipline", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_userProfessionalBio (PK_userProfessionalBio LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,areaofexpertise1 VARCHAR(75) null,areaofexpertise2 VARCHAR(75) null,areaofexpertise3 VARCHAR(75) null,experienceyears VARCHAR(75) null,cvlink VARCHAR(75) null,biodescription VARCHAR(75) null,bioDiscipline VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_userProfessionalBio";
	public static final String ORDER_BY_JPQL = " ORDER BY userProfessionalBio.PK_userProfessionalBio ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_userProfessionalBio.PK_userProfessionalBio ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.userProfessionalBio"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.userProfessionalBio"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static userProfessionalBio toModel(userProfessionalBioSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		userProfessionalBio model = new userProfessionalBioImpl();

		model.setPK_userProfessionalBio(soapModel.getPK_userProfessionalBio());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setAreaofexpertise1(soapModel.getAreaofexpertise1());
		model.setAreaofexpertise2(soapModel.getAreaofexpertise2());
		model.setAreaofexpertise3(soapModel.getAreaofexpertise3());
		model.setExperienceyears(soapModel.getExperienceyears());
		model.setCvlink(soapModel.getCvlink());
		model.setBiodescription(soapModel.getBiodescription());
		model.setBioDiscipline(soapModel.getBioDiscipline());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<userProfessionalBio> toModels(
		userProfessionalBioSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<userProfessionalBio> models = new ArrayList<userProfessionalBio>(soapModels.length);

		for (userProfessionalBioSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.userProfessionalBio"));

	public userProfessionalBioModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _PK_userProfessionalBio;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPK_userProfessionalBio(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PK_userProfessionalBio;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return userProfessionalBio.class;
	}

	@Override
	public String getModelClassName() {
		return userProfessionalBio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_userProfessionalBio", getPK_userProfessionalBio());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("areaofexpertise1", getAreaofexpertise1());
		attributes.put("areaofexpertise2", getAreaofexpertise2());
		attributes.put("areaofexpertise3", getAreaofexpertise3());
		attributes.put("experienceyears", getExperienceyears());
		attributes.put("cvlink", getCvlink());
		attributes.put("biodescription", getBiodescription());
		attributes.put("bioDiscipline", getBioDiscipline());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_userProfessionalBio = (Long)attributes.get(
				"PK_userProfessionalBio");

		if (PK_userProfessionalBio != null) {
			setPK_userProfessionalBio(PK_userProfessionalBio);
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

		String areaofexpertise1 = (String)attributes.get("areaofexpertise1");

		if (areaofexpertise1 != null) {
			setAreaofexpertise1(areaofexpertise1);
		}

		String areaofexpertise2 = (String)attributes.get("areaofexpertise2");

		if (areaofexpertise2 != null) {
			setAreaofexpertise2(areaofexpertise2);
		}

		String areaofexpertise3 = (String)attributes.get("areaofexpertise3");

		if (areaofexpertise3 != null) {
			setAreaofexpertise3(areaofexpertise3);
		}

		String experienceyears = (String)attributes.get("experienceyears");

		if (experienceyears != null) {
			setExperienceyears(experienceyears);
		}

		String cvlink = (String)attributes.get("cvlink");

		if (cvlink != null) {
			setCvlink(cvlink);
		}

		String biodescription = (String)attributes.get("biodescription");

		if (biodescription != null) {
			setBiodescription(biodescription);
		}

		String bioDiscipline = (String)attributes.get("bioDiscipline");

		if (bioDiscipline != null) {
			setBioDiscipline(bioDiscipline);
		}
	}

	@JSON
	@Override
	public long getPK_userProfessionalBio() {
		return _PK_userProfessionalBio;
	}

	@Override
	public void setPK_userProfessionalBio(long PK_userProfessionalBio) {
		_PK_userProfessionalBio = PK_userProfessionalBio;
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
	public String getAreaofexpertise1() {
		if (_areaofexpertise1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _areaofexpertise1;
		}
	}

	@Override
	public void setAreaofexpertise1(String areaofexpertise1) {
		_areaofexpertise1 = areaofexpertise1;
	}

	@JSON
	@Override
	public String getAreaofexpertise2() {
		if (_areaofexpertise2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _areaofexpertise2;
		}
	}

	@Override
	public void setAreaofexpertise2(String areaofexpertise2) {
		_areaofexpertise2 = areaofexpertise2;
	}

	@JSON
	@Override
	public String getAreaofexpertise3() {
		if (_areaofexpertise3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _areaofexpertise3;
		}
	}

	@Override
	public void setAreaofexpertise3(String areaofexpertise3) {
		_areaofexpertise3 = areaofexpertise3;
	}

	@JSON
	@Override
	public String getExperienceyears() {
		if (_experienceyears == null) {
			return StringPool.BLANK;
		}
		else {
			return _experienceyears;
		}
	}

	@Override
	public void setExperienceyears(String experienceyears) {
		_experienceyears = experienceyears;
	}

	@JSON
	@Override
	public String getCvlink() {
		if (_cvlink == null) {
			return StringPool.BLANK;
		}
		else {
			return _cvlink;
		}
	}

	@Override
	public void setCvlink(String cvlink) {
		_cvlink = cvlink;
	}

	@JSON
	@Override
	public String getBiodescription() {
		if (_biodescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _biodescription;
		}
	}

	@Override
	public void setBiodescription(String biodescription) {
		_biodescription = biodescription;
	}

	@JSON
	@Override
	public String getBioDiscipline() {
		if (_bioDiscipline == null) {
			return StringPool.BLANK;
		}
		else {
			return _bioDiscipline;
		}
	}

	@Override
	public void setBioDiscipline(String bioDiscipline) {
		_bioDiscipline = bioDiscipline;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			userProfessionalBio.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public userProfessionalBio toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (userProfessionalBio)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		userProfessionalBioImpl userProfessionalBioImpl = new userProfessionalBioImpl();

		userProfessionalBioImpl.setPK_userProfessionalBio(getPK_userProfessionalBio());
		userProfessionalBioImpl.setGroupId(getGroupId());
		userProfessionalBioImpl.setUserId(getUserId());
		userProfessionalBioImpl.setCreateDate(getCreateDate());
		userProfessionalBioImpl.setModifiedDate(getModifiedDate());
		userProfessionalBioImpl.setAreaofexpertise1(getAreaofexpertise1());
		userProfessionalBioImpl.setAreaofexpertise2(getAreaofexpertise2());
		userProfessionalBioImpl.setAreaofexpertise3(getAreaofexpertise3());
		userProfessionalBioImpl.setExperienceyears(getExperienceyears());
		userProfessionalBioImpl.setCvlink(getCvlink());
		userProfessionalBioImpl.setBiodescription(getBiodescription());
		userProfessionalBioImpl.setBioDiscipline(getBioDiscipline());

		userProfessionalBioImpl.resetOriginalValues();

		return userProfessionalBioImpl;
	}

	@Override
	public int compareTo(userProfessionalBio userProfessionalBio) {
		long primaryKey = userProfessionalBio.getPrimaryKey();

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

		if (!(obj instanceof userProfessionalBio)) {
			return false;
		}

		userProfessionalBio userProfessionalBio = (userProfessionalBio)obj;

		long primaryKey = userProfessionalBio.getPrimaryKey();

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
		userProfessionalBioModelImpl userProfessionalBioModelImpl = this;

		userProfessionalBioModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<userProfessionalBio> toCacheModel() {
		userProfessionalBioCacheModel userProfessionalBioCacheModel = new userProfessionalBioCacheModel();

		userProfessionalBioCacheModel.PK_userProfessionalBio = getPK_userProfessionalBio();

		userProfessionalBioCacheModel.groupId = getGroupId();

		userProfessionalBioCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			userProfessionalBioCacheModel.createDate = createDate.getTime();
		}
		else {
			userProfessionalBioCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			userProfessionalBioCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			userProfessionalBioCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		userProfessionalBioCacheModel.areaofexpertise1 = getAreaofexpertise1();

		String areaofexpertise1 = userProfessionalBioCacheModel.areaofexpertise1;

		if ((areaofexpertise1 != null) && (areaofexpertise1.length() == 0)) {
			userProfessionalBioCacheModel.areaofexpertise1 = null;
		}

		userProfessionalBioCacheModel.areaofexpertise2 = getAreaofexpertise2();

		String areaofexpertise2 = userProfessionalBioCacheModel.areaofexpertise2;

		if ((areaofexpertise2 != null) && (areaofexpertise2.length() == 0)) {
			userProfessionalBioCacheModel.areaofexpertise2 = null;
		}

		userProfessionalBioCacheModel.areaofexpertise3 = getAreaofexpertise3();

		String areaofexpertise3 = userProfessionalBioCacheModel.areaofexpertise3;

		if ((areaofexpertise3 != null) && (areaofexpertise3.length() == 0)) {
			userProfessionalBioCacheModel.areaofexpertise3 = null;
		}

		userProfessionalBioCacheModel.experienceyears = getExperienceyears();

		String experienceyears = userProfessionalBioCacheModel.experienceyears;

		if ((experienceyears != null) && (experienceyears.length() == 0)) {
			userProfessionalBioCacheModel.experienceyears = null;
		}

		userProfessionalBioCacheModel.cvlink = getCvlink();

		String cvlink = userProfessionalBioCacheModel.cvlink;

		if ((cvlink != null) && (cvlink.length() == 0)) {
			userProfessionalBioCacheModel.cvlink = null;
		}

		userProfessionalBioCacheModel.biodescription = getBiodescription();

		String biodescription = userProfessionalBioCacheModel.biodescription;

		if ((biodescription != null) && (biodescription.length() == 0)) {
			userProfessionalBioCacheModel.biodescription = null;
		}

		userProfessionalBioCacheModel.bioDiscipline = getBioDiscipline();

		String bioDiscipline = userProfessionalBioCacheModel.bioDiscipline;

		if ((bioDiscipline != null) && (bioDiscipline.length() == 0)) {
			userProfessionalBioCacheModel.bioDiscipline = null;
		}

		return userProfessionalBioCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{PK_userProfessionalBio=");
		sb.append(getPK_userProfessionalBio());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", areaofexpertise1=");
		sb.append(getAreaofexpertise1());
		sb.append(", areaofexpertise2=");
		sb.append(getAreaofexpertise2());
		sb.append(", areaofexpertise3=");
		sb.append(getAreaofexpertise3());
		sb.append(", experienceyears=");
		sb.append(getExperienceyears());
		sb.append(", cvlink=");
		sb.append(getCvlink());
		sb.append(", biodescription=");
		sb.append(getBiodescription());
		sb.append(", bioDiscipline=");
		sb.append(getBioDiscipline());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.collaborated.entity.model.userProfessionalBio");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PK_userProfessionalBio</column-name><column-value><![CDATA[");
		sb.append(getPK_userProfessionalBio());
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
			"<column><column-name>areaofexpertise1</column-name><column-value><![CDATA[");
		sb.append(getAreaofexpertise1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>areaofexpertise2</column-name><column-value><![CDATA[");
		sb.append(getAreaofexpertise2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>areaofexpertise3</column-name><column-value><![CDATA[");
		sb.append(getAreaofexpertise3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>experienceyears</column-name><column-value><![CDATA[");
		sb.append(getExperienceyears());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cvlink</column-name><column-value><![CDATA[");
		sb.append(getCvlink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biodescription</column-name><column-value><![CDATA[");
		sb.append(getBiodescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bioDiscipline</column-name><column-value><![CDATA[");
		sb.append(getBioDiscipline());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = userProfessionalBio.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			userProfessionalBio.class
		};
	private long _PK_userProfessionalBio;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _areaofexpertise1;
	private String _areaofexpertise2;
	private String _areaofexpertise3;
	private String _experienceyears;
	private String _cvlink;
	private String _biodescription;
	private String _bioDiscipline;
	private userProfessionalBio _escapedModel;
}