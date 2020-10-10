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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link userProfileImage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userProfileImage
 * @generated
 */
@ProviderType
public class userProfileImageWrapper implements userProfileImage,
	ModelWrapper<userProfileImage> {
	public userProfileImageWrapper(userProfileImage userProfileImage) {
		_userProfileImage = userProfileImage;
	}

	@Override
	public Class<?> getModelClass() {
		return userProfileImage.class;
	}

	@Override
	public String getModelClassName() {
		return userProfileImage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_profileImageId", getPK_profileImageId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("userId", getUserId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("fileEntryUrl", getFileEntryUrl());
		attributes.put("blobData", getBlobData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_profileImageId = (Long)attributes.get("PK_profileImageId");

		if (PK_profileImageId != null) {
			setPK_profileImageId(PK_profileImageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createdOn = (Date)attributes.get("createdOn");

		if (createdOn != null) {
			setCreatedOn(createdOn);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String fileEntryId = (String)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String fileEntryUrl = (String)attributes.get("fileEntryUrl");

		if (fileEntryUrl != null) {
			setFileEntryUrl(fileEntryUrl);
		}

		Blob blobData = (Blob)attributes.get("blobData");

		if (blobData != null) {
			setBlobData(blobData);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _userProfileImage.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userProfileImage.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userProfileImage.isNew();
	}

	@Override
	public com.collaborated.entity.model.userProfileImage toEscapedModel() {
		return new userProfileImageWrapper(_userProfileImage.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.userProfileImage toUnescapedModel() {
		return new userProfileImageWrapper(_userProfileImage.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userProfileImage.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.userProfileImage> toCacheModel() {
		return _userProfileImage.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.userProfileImage userProfileImage) {
		return _userProfileImage.compareTo(userProfileImage);
	}

	@Override
	public int hashCode() {
		return _userProfileImage.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userProfileImage.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new userProfileImageWrapper((userProfileImage)_userProfileImage.clone());
	}

	/**
	* Returns the file entry ID of this user profile image.
	*
	* @return the file entry ID of this user profile image
	*/
	@Override
	public java.lang.String getFileEntryId() {
		return _userProfileImage.getFileEntryId();
	}

	/**
	* Returns the file entry url of this user profile image.
	*
	* @return the file entry url of this user profile image
	*/
	@Override
	public java.lang.String getFileEntryUrl() {
		return _userProfileImage.getFileEntryUrl();
	}

	/**
	* Returns the user uuid of this user profile image.
	*
	* @return the user uuid of this user profile image
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userProfileImage.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userProfileImage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userProfileImage.toXmlString();
	}

	/**
	* Returns the blob data of this user profile image.
	*
	* @return the blob data of this user profile image
	*/
	@Override
	public Blob getBlobData() {
		return _userProfileImage.getBlobData();
	}

	/**
	* Returns the created on of this user profile image.
	*
	* @return the created on of this user profile image
	*/
	@Override
	public Date getCreatedOn() {
		return _userProfileImage.getCreatedOn();
	}

	/**
	* Returns the group ID of this user profile image.
	*
	* @return the group ID of this user profile image
	*/
	@Override
	public long getGroupId() {
		return _userProfileImage.getGroupId();
	}

	/**
	* Returns the p k_profile image ID of this user profile image.
	*
	* @return the p k_profile image ID of this user profile image
	*/
	@Override
	public long getPK_profileImageId() {
		return _userProfileImage.getPK_profileImageId();
	}

	/**
	* Returns the primary key of this user profile image.
	*
	* @return the primary key of this user profile image
	*/
	@Override
	public long getPrimaryKey() {
		return _userProfileImage.getPrimaryKey();
	}

	/**
	* Returns the user ID of this user profile image.
	*
	* @return the user ID of this user profile image
	*/
	@Override
	public long getUserId() {
		return _userProfileImage.getUserId();
	}

	@Override
	public void persist() {
		_userProfileImage.persist();
	}

	/**
	* Sets the blob data of this user profile image.
	*
	* @param blobData the blob data of this user profile image
	*/
	@Override
	public void setBlobData(Blob blobData) {
		_userProfileImage.setBlobData(blobData);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userProfileImage.setCachedModel(cachedModel);
	}

	/**
	* Sets the created on of this user profile image.
	*
	* @param createdOn the created on of this user profile image
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_userProfileImage.setCreatedOn(createdOn);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userProfileImage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userProfileImage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userProfileImage.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this user profile image.
	*
	* @param fileEntryId the file entry ID of this user profile image
	*/
	@Override
	public void setFileEntryId(java.lang.String fileEntryId) {
		_userProfileImage.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the file entry url of this user profile image.
	*
	* @param fileEntryUrl the file entry url of this user profile image
	*/
	@Override
	public void setFileEntryUrl(java.lang.String fileEntryUrl) {
		_userProfileImage.setFileEntryUrl(fileEntryUrl);
	}

	/**
	* Sets the group ID of this user profile image.
	*
	* @param groupId the group ID of this user profile image
	*/
	@Override
	public void setGroupId(long groupId) {
		_userProfileImage.setGroupId(groupId);
	}

	@Override
	public void setNew(boolean n) {
		_userProfileImage.setNew(n);
	}

	/**
	* Sets the p k_profile image ID of this user profile image.
	*
	* @param PK_profileImageId the p k_profile image ID of this user profile image
	*/
	@Override
	public void setPK_profileImageId(long PK_profileImageId) {
		_userProfileImage.setPK_profileImageId(PK_profileImageId);
	}

	/**
	* Sets the primary key of this user profile image.
	*
	* @param primaryKey the primary key of this user profile image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userProfileImage.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userProfileImage.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this user profile image.
	*
	* @param userId the user ID of this user profile image
	*/
	@Override
	public void setUserId(long userId) {
		_userProfileImage.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user profile image.
	*
	* @param userUuid the user uuid of this user profile image
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userProfileImage.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userProfileImageWrapper)) {
			return false;
		}

		userProfileImageWrapper userProfileImageWrapper = (userProfileImageWrapper)obj;

		if (Objects.equals(_userProfileImage,
					userProfileImageWrapper._userProfileImage)) {
			return true;
		}

		return false;
	}

	@Override
	public userProfileImage getWrappedModel() {
		return _userProfileImage;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userProfileImage.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userProfileImage.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userProfileImage.resetOriginalValues();
	}

	private final userProfileImage _userProfileImage;
}