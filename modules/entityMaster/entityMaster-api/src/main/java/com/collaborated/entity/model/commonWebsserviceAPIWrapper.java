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

package com.collaborated.entity.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link commonWebsserviceAPI}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPI
 * @generated
 */
@ProviderType
public class commonWebsserviceAPIWrapper implements commonWebsserviceAPI,
	ModelWrapper<commonWebsserviceAPI> {
	public commonWebsserviceAPIWrapper(
		commonWebsserviceAPI commonWebsserviceAPI) {
		_commonWebsserviceAPI = commonWebsserviceAPI;
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commonAPIId = (Long)attributes.get("commonAPIId");

		if (commonAPIId != null) {
			setCommonAPIId(commonAPIId);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _commonWebsserviceAPI.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _commonWebsserviceAPI.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _commonWebsserviceAPI.isNew();
	}

	@Override
	public com.collaborated.entity.model.commonWebsserviceAPI toEscapedModel() {
		return new commonWebsserviceAPIWrapper(_commonWebsserviceAPI.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.commonWebsserviceAPI toUnescapedModel() {
		return new commonWebsserviceAPIWrapper(_commonWebsserviceAPI.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _commonWebsserviceAPI.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.commonWebsserviceAPI> toCacheModel() {
		return _commonWebsserviceAPI.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.commonWebsserviceAPI commonWebsserviceAPI) {
		return _commonWebsserviceAPI.compareTo(commonWebsserviceAPI);
	}

	@Override
	public int hashCode() {
		return _commonWebsserviceAPI.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commonWebsserviceAPI.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new commonWebsserviceAPIWrapper((commonWebsserviceAPI)_commonWebsserviceAPI.clone());
	}

	@Override
	public java.lang.String toString() {
		return _commonWebsserviceAPI.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _commonWebsserviceAPI.toXmlString();
	}

	/**
	* Returns the common a p i ID of this common websservice a p i.
	*
	* @return the common a p i ID of this common websservice a p i
	*/
	@Override
	public long getCommonAPIId() {
		return _commonWebsserviceAPI.getCommonAPIId();
	}

	/**
	* Returns the primary key of this common websservice a p i.
	*
	* @return the primary key of this common websservice a p i
	*/
	@Override
	public long getPrimaryKey() {
		return _commonWebsserviceAPI.getPrimaryKey();
	}

	@Override
	public void persist() {
		_commonWebsserviceAPI.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_commonWebsserviceAPI.setCachedModel(cachedModel);
	}

	/**
	* Sets the common a p i ID of this common websservice a p i.
	*
	* @param commonAPIId the common a p i ID of this common websservice a p i
	*/
	@Override
	public void setCommonAPIId(long commonAPIId) {
		_commonWebsserviceAPI.setCommonAPIId(commonAPIId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_commonWebsserviceAPI.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_commonWebsserviceAPI.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_commonWebsserviceAPI.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_commonWebsserviceAPI.setNew(n);
	}

	/**
	* Sets the primary key of this common websservice a p i.
	*
	* @param primaryKey the primary key of this common websservice a p i
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_commonWebsserviceAPI.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_commonWebsserviceAPI.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof commonWebsserviceAPIWrapper)) {
			return false;
		}

		commonWebsserviceAPIWrapper commonWebsserviceAPIWrapper = (commonWebsserviceAPIWrapper)obj;

		if (Objects.equals(_commonWebsserviceAPI,
					commonWebsserviceAPIWrapper._commonWebsserviceAPI)) {
			return true;
		}

		return false;
	}

	@Override
	public commonWebsserviceAPI getWrappedModel() {
		return _commonWebsserviceAPI;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _commonWebsserviceAPI.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _commonWebsserviceAPI.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_commonWebsserviceAPI.resetOriginalValues();
	}

	private final commonWebsserviceAPI _commonWebsserviceAPI;
}