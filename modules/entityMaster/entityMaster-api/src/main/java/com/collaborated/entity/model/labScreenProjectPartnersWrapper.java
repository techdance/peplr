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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link labScreenProjectPartners}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectPartners
 * @generated
 */
@ProviderType
public class labScreenProjectPartnersWrapper implements labScreenProjectPartners,
	ModelWrapper<labScreenProjectPartners> {
	public labScreenProjectPartnersWrapper(
		labScreenProjectPartners labScreenProjectPartners) {
		_labScreenProjectPartners = labScreenProjectPartners;
	}

	@Override
	public Class<?> getModelClass() {
		return labScreenProjectPartners.class;
	}

	@Override
	public String getModelClassName() {
		return labScreenProjectPartners.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_projectPartnerId", getPK_projectPartnerId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("projectPartnerId", getProjectPartnerId());
		attributes.put("isActive", getIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_projectPartnerId = (Long)attributes.get("PK_projectPartnerId");

		if (PK_projectPartnerId != null) {
			setPK_projectPartnerId(PK_projectPartnerId);
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

		Long projectPartnerId = (Long)attributes.get("projectPartnerId");

		if (projectPartnerId != null) {
			setProjectPartnerId(projectPartnerId);
		}

		Long isActive = (Long)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labScreenProjectPartners.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labScreenProjectPartners.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labScreenProjectPartners.isNew();
	}

	@Override
	public com.collaborated.entity.model.labScreenProjectPartners toEscapedModel() {
		return new labScreenProjectPartnersWrapper(_labScreenProjectPartners.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labScreenProjectPartners toUnescapedModel() {
		return new labScreenProjectPartnersWrapper(_labScreenProjectPartners.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labScreenProjectPartners.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labScreenProjectPartners> toCacheModel() {
		return _labScreenProjectPartners.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labScreenProjectPartners labScreenProjectPartners) {
		return _labScreenProjectPartners.compareTo(labScreenProjectPartners);
	}

	@Override
	public int hashCode() {
		return _labScreenProjectPartners.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labScreenProjectPartners.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labScreenProjectPartnersWrapper((labScreenProjectPartners)_labScreenProjectPartners.clone());
	}

	/**
	* Returns the user uuid of this lab screen project partners.
	*
	* @return the user uuid of this lab screen project partners
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labScreenProjectPartners.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labScreenProjectPartners.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labScreenProjectPartners.toXmlString();
	}

	/**
	* Returns the create date of this lab screen project partners.
	*
	* @return the create date of this lab screen project partners
	*/
	@Override
	public Date getCreateDate() {
		return _labScreenProjectPartners.getCreateDate();
	}

	/**
	* Returns the modified date of this lab screen project partners.
	*
	* @return the modified date of this lab screen project partners
	*/
	@Override
	public Date getModifiedDate() {
		return _labScreenProjectPartners.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab screen project partners.
	*
	* @return the group ID of this lab screen project partners
	*/
	@Override
	public long getGroupId() {
		return _labScreenProjectPartners.getGroupId();
	}

	/**
	* Returns the is active of this lab screen project partners.
	*
	* @return the is active of this lab screen project partners
	*/
	@Override
	public long getIsActive() {
		return _labScreenProjectPartners.getIsActive();
	}

	/**
	* Returns the p k_project ID of this lab screen project partners.
	*
	* @return the p k_project ID of this lab screen project partners
	*/
	@Override
	public long getPK_projectId() {
		return _labScreenProjectPartners.getPK_projectId();
	}

	/**
	* Returns the p k_project partner ID of this lab screen project partners.
	*
	* @return the p k_project partner ID of this lab screen project partners
	*/
	@Override
	public long getPK_projectPartnerId() {
		return _labScreenProjectPartners.getPK_projectPartnerId();
	}

	/**
	* Returns the primary key of this lab screen project partners.
	*
	* @return the primary key of this lab screen project partners
	*/
	@Override
	public long getPrimaryKey() {
		return _labScreenProjectPartners.getPrimaryKey();
	}

	/**
	* Returns the project partner ID of this lab screen project partners.
	*
	* @return the project partner ID of this lab screen project partners
	*/
	@Override
	public long getProjectPartnerId() {
		return _labScreenProjectPartners.getProjectPartnerId();
	}

	/**
	* Returns the user ID of this lab screen project partners.
	*
	* @return the user ID of this lab screen project partners
	*/
	@Override
	public long getUserId() {
		return _labScreenProjectPartners.getUserId();
	}

	@Override
	public void persist() {
		_labScreenProjectPartners.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labScreenProjectPartners.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this lab screen project partners.
	*
	* @param createDate the create date of this lab screen project partners
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labScreenProjectPartners.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labScreenProjectPartners.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labScreenProjectPartners.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labScreenProjectPartners.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab screen project partners.
	*
	* @param groupId the group ID of this lab screen project partners
	*/
	@Override
	public void setGroupId(long groupId) {
		_labScreenProjectPartners.setGroupId(groupId);
	}

	/**
	* Sets the is active of this lab screen project partners.
	*
	* @param isActive the is active of this lab screen project partners
	*/
	@Override
	public void setIsActive(long isActive) {
		_labScreenProjectPartners.setIsActive(isActive);
	}

	/**
	* Sets the modified date of this lab screen project partners.
	*
	* @param modifiedDate the modified date of this lab screen project partners
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labScreenProjectPartners.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labScreenProjectPartners.setNew(n);
	}

	/**
	* Sets the p k_project ID of this lab screen project partners.
	*
	* @param PK_projectId the p k_project ID of this lab screen project partners
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labScreenProjectPartners.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the p k_project partner ID of this lab screen project partners.
	*
	* @param PK_projectPartnerId the p k_project partner ID of this lab screen project partners
	*/
	@Override
	public void setPK_projectPartnerId(long PK_projectPartnerId) {
		_labScreenProjectPartners.setPK_projectPartnerId(PK_projectPartnerId);
	}

	/**
	* Sets the primary key of this lab screen project partners.
	*
	* @param primaryKey the primary key of this lab screen project partners
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labScreenProjectPartners.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labScreenProjectPartners.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project partner ID of this lab screen project partners.
	*
	* @param projectPartnerId the project partner ID of this lab screen project partners
	*/
	@Override
	public void setProjectPartnerId(long projectPartnerId) {
		_labScreenProjectPartners.setProjectPartnerId(projectPartnerId);
	}

	/**
	* Sets the user ID of this lab screen project partners.
	*
	* @param userId the user ID of this lab screen project partners
	*/
	@Override
	public void setUserId(long userId) {
		_labScreenProjectPartners.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab screen project partners.
	*
	* @param userUuid the user uuid of this lab screen project partners
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labScreenProjectPartners.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labScreenProjectPartnersWrapper)) {
			return false;
		}

		labScreenProjectPartnersWrapper labScreenProjectPartnersWrapper = (labScreenProjectPartnersWrapper)obj;

		if (Objects.equals(_labScreenProjectPartners,
					labScreenProjectPartnersWrapper._labScreenProjectPartners)) {
			return true;
		}

		return false;
	}

	@Override
	public labScreenProjectPartners getWrappedModel() {
		return _labScreenProjectPartners;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labScreenProjectPartners.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labScreenProjectPartners.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labScreenProjectPartners.resetOriginalValues();
	}

	private final labScreenProjectPartners _labScreenProjectPartners;
}