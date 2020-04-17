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
 * This class is a wrapper for {@link userInstitutionProfileSubDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileSubDetails
 * @generated
 */
@ProviderType
public class userInstitutionProfileSubDetailsWrapper
	implements userInstitutionProfileSubDetails,
		ModelWrapper<userInstitutionProfileSubDetails> {
	public userInstitutionProfileSubDetailsWrapper(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		_userInstitutionProfileSubDetails = userInstitutionProfileSubDetails;
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

	@Override
	public boolean isCachedModel() {
		return _userInstitutionProfileSubDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userInstitutionProfileSubDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userInstitutionProfileSubDetails.isNew();
	}

	@Override
	public com.collaborated.entity.model.userInstitutionProfileSubDetails toEscapedModel() {
		return new userInstitutionProfileSubDetailsWrapper(_userInstitutionProfileSubDetails.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.userInstitutionProfileSubDetails toUnescapedModel() {
		return new userInstitutionProfileSubDetailsWrapper(_userInstitutionProfileSubDetails.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userInstitutionProfileSubDetails.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.userInstitutionProfileSubDetails> toCacheModel() {
		return _userInstitutionProfileSubDetails.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		return _userInstitutionProfileSubDetails.compareTo(userInstitutionProfileSubDetails);
	}

	@Override
	public int hashCode() {
		return _userInstitutionProfileSubDetails.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userInstitutionProfileSubDetails.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new userInstitutionProfileSubDetailsWrapper((userInstitutionProfileSubDetails)_userInstitutionProfileSubDetails.clone());
	}

	/**
	* Returns the user uuid of this user institution profile sub details.
	*
	* @return the user uuid of this user institution profile sub details
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userInstitutionProfileSubDetails.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userInstitutionProfileSubDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userInstitutionProfileSubDetails.toXmlString();
	}

	/**
	* Returns the create date of this user institution profile sub details.
	*
	* @return the create date of this user institution profile sub details
	*/
	@Override
	public Date getCreateDate() {
		return _userInstitutionProfileSubDetails.getCreateDate();
	}

	/**
	* Returns the modified date of this user institution profile sub details.
	*
	* @return the modified date of this user institution profile sub details
	*/
	@Override
	public Date getModifiedDate() {
		return _userInstitutionProfileSubDetails.getModifiedDate();
	}

	/**
	* Returns the file ID of this user institution profile sub details.
	*
	* @return the file ID of this user institution profile sub details
	*/
	@Override
	public long getFileId() {
		return _userInstitutionProfileSubDetails.getFileId();
	}

	/**
	* Returns the group ID of this user institution profile sub details.
	*
	* @return the group ID of this user institution profile sub details
	*/
	@Override
	public long getGroupId() {
		return _userInstitutionProfileSubDetails.getGroupId();
	}

	/**
	* Returns the p k_user instition of this user institution profile sub details.
	*
	* @return the p k_user instition of this user institution profile sub details
	*/
	@Override
	public long getPK_userInstition() {
		return _userInstitutionProfileSubDetails.getPK_userInstition();
	}

	/**
	* Returns the p k_user instition sub of this user institution profile sub details.
	*
	* @return the p k_user instition sub of this user institution profile sub details
	*/
	@Override
	public long getPK_userInstitionSub() {
		return _userInstitutionProfileSubDetails.getPK_userInstitionSub();
	}

	/**
	* Returns the primary key of this user institution profile sub details.
	*
	* @return the primary key of this user institution profile sub details
	*/
	@Override
	public long getPrimaryKey() {
		return _userInstitutionProfileSubDetails.getPrimaryKey();
	}

	/**
	* Returns the user ID of this user institution profile sub details.
	*
	* @return the user ID of this user institution profile sub details
	*/
	@Override
	public long getUserId() {
		return _userInstitutionProfileSubDetails.getUserId();
	}

	@Override
	public void persist() {
		_userInstitutionProfileSubDetails.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userInstitutionProfileSubDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this user institution profile sub details.
	*
	* @param createDate the create date of this user institution profile sub details
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userInstitutionProfileSubDetails.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userInstitutionProfileSubDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userInstitutionProfileSubDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userInstitutionProfileSubDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file ID of this user institution profile sub details.
	*
	* @param fileId the file ID of this user institution profile sub details
	*/
	@Override
	public void setFileId(long fileId) {
		_userInstitutionProfileSubDetails.setFileId(fileId);
	}

	/**
	* Sets the group ID of this user institution profile sub details.
	*
	* @param groupId the group ID of this user institution profile sub details
	*/
	@Override
	public void setGroupId(long groupId) {
		_userInstitutionProfileSubDetails.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this user institution profile sub details.
	*
	* @param modifiedDate the modified date of this user institution profile sub details
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userInstitutionProfileSubDetails.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_userInstitutionProfileSubDetails.setNew(n);
	}

	/**
	* Sets the p k_user instition of this user institution profile sub details.
	*
	* @param PK_userInstition the p k_user instition of this user institution profile sub details
	*/
	@Override
	public void setPK_userInstition(long PK_userInstition) {
		_userInstitutionProfileSubDetails.setPK_userInstition(PK_userInstition);
	}

	/**
	* Sets the p k_user instition sub of this user institution profile sub details.
	*
	* @param PK_userInstitionSub the p k_user instition sub of this user institution profile sub details
	*/
	@Override
	public void setPK_userInstitionSub(long PK_userInstitionSub) {
		_userInstitutionProfileSubDetails.setPK_userInstitionSub(PK_userInstitionSub);
	}

	/**
	* Sets the primary key of this user institution profile sub details.
	*
	* @param primaryKey the primary key of this user institution profile sub details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userInstitutionProfileSubDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userInstitutionProfileSubDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this user institution profile sub details.
	*
	* @param userId the user ID of this user institution profile sub details
	*/
	@Override
	public void setUserId(long userId) {
		_userInstitutionProfileSubDetails.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user institution profile sub details.
	*
	* @param userUuid the user uuid of this user institution profile sub details
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userInstitutionProfileSubDetails.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userInstitutionProfileSubDetailsWrapper)) {
			return false;
		}

		userInstitutionProfileSubDetailsWrapper userInstitutionProfileSubDetailsWrapper =
			(userInstitutionProfileSubDetailsWrapper)obj;

		if (Objects.equals(_userInstitutionProfileSubDetails,
					userInstitutionProfileSubDetailsWrapper._userInstitutionProfileSubDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public userInstitutionProfileSubDetails getWrappedModel() {
		return _userInstitutionProfileSubDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userInstitutionProfileSubDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userInstitutionProfileSubDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userInstitutionProfileSubDetails.resetOriginalValues();
	}

	private final userInstitutionProfileSubDetails _userInstitutionProfileSubDetails;
}