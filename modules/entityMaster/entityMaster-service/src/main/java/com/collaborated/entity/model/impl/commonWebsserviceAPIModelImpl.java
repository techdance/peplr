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

import com.collaborated.entity.model.commonWebsserviceAPI;
import com.collaborated.entity.model.commonWebsserviceAPIModel;
import com.collaborated.entity.model.commonWebsserviceAPISoap;

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

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the commonWebsserviceAPI service. Represents a row in the &quot;collaborated_commonWebsserviceAPI&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link commonWebsserviceAPIModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link commonWebsserviceAPIImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPIImpl
 * @see commonWebsserviceAPI
 * @see commonWebsserviceAPIModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class commonWebsserviceAPIModelImpl extends BaseModelImpl<commonWebsserviceAPI>
	implements commonWebsserviceAPIModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a common websservice a p i model instance should use the {@link commonWebsserviceAPI} interface instead.
	 */
	public static final String TABLE_NAME = "collaborated_commonWebsserviceAPI";
	public static final Object[][] TABLE_COLUMNS = {
			{ "commonAPIId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commonAPIId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table collaborated_commonWebsserviceAPI (commonAPIId LONG not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table collaborated_commonWebsserviceAPI";
	public static final String ORDER_BY_JPQL = " ORDER BY commonWebsserviceAPI.commonAPIId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY collaborated_commonWebsserviceAPI.commonAPIId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.collaborated.entity.model.commonWebsserviceAPI"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.collaborated.entity.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.collaborated.entity.model.commonWebsserviceAPI"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static commonWebsserviceAPI toModel(
		commonWebsserviceAPISoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		commonWebsserviceAPI model = new commonWebsserviceAPIImpl();

		model.setCommonAPIId(soapModel.getCommonAPIId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<commonWebsserviceAPI> toModels(
		commonWebsserviceAPISoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<commonWebsserviceAPI> models = new ArrayList<commonWebsserviceAPI>(soapModels.length);

		for (commonWebsserviceAPISoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.collaborated.entity.service.util.ServiceProps.get(
				"lock.expiration.time.com.collaborated.entity.model.commonWebsserviceAPI"));

	public commonWebsserviceAPIModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commonAPIId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommonAPIId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commonAPIId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return commonWebsserviceAPI.class;
	}

	@Override
	public String getModelClassName() {
		return commonWebsserviceAPI.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commonAPIId", getCommonAPIId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commonAPIId = (Long)attributes.get("commonAPIId");

		if (commonAPIId != null) {
			setCommonAPIId(commonAPIId);
		}
	}

	@JSON
	@Override
	public long getCommonAPIId() {
		return _commonAPIId;
	}

	@Override
	public void setCommonAPIId(long commonAPIId) {
		_commonAPIId = commonAPIId;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			commonWebsserviceAPI.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public commonWebsserviceAPI toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (commonWebsserviceAPI)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		commonWebsserviceAPIImpl commonWebsserviceAPIImpl = new commonWebsserviceAPIImpl();

		commonWebsserviceAPIImpl.setCommonAPIId(getCommonAPIId());

		commonWebsserviceAPIImpl.resetOriginalValues();

		return commonWebsserviceAPIImpl;
	}

	@Override
	public int compareTo(commonWebsserviceAPI commonWebsserviceAPI) {
		long primaryKey = commonWebsserviceAPI.getPrimaryKey();

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

		if (!(obj instanceof commonWebsserviceAPI)) {
			return false;
		}

		commonWebsserviceAPI commonWebsserviceAPI = (commonWebsserviceAPI)obj;

		long primaryKey = commonWebsserviceAPI.getPrimaryKey();

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
	public CacheModel<commonWebsserviceAPI> toCacheModel() {
		commonWebsserviceAPICacheModel commonWebsserviceAPICacheModel = new commonWebsserviceAPICacheModel();

		commonWebsserviceAPICacheModel.commonAPIId = getCommonAPIId();

		return commonWebsserviceAPICacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{commonAPIId=");
		sb.append(getCommonAPIId());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("com.collaborated.entity.model.commonWebsserviceAPI");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commonAPIId</column-name><column-value><![CDATA[");
		sb.append(getCommonAPIId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = commonWebsserviceAPI.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			commonWebsserviceAPI.class
		};
	private long _commonAPIId;
	private commonWebsserviceAPI _escapedModel;
}