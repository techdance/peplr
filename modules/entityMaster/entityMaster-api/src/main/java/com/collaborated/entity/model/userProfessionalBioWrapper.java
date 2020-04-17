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
 * This class is a wrapper for {@link userProfessionalBio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userProfessionalBio
 * @generated
 */
@ProviderType
public class userProfessionalBioWrapper implements userProfessionalBio,
	ModelWrapper<userProfessionalBio> {
	public userProfessionalBioWrapper(userProfessionalBio userProfessionalBio) {
		_userProfessionalBio = userProfessionalBio;
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
	}

	@Override
	public boolean isCachedModel() {
		return _userProfessionalBio.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userProfessionalBio.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userProfessionalBio.isNew();
	}

	@Override
	public com.collaborated.entity.model.userProfessionalBio toEscapedModel() {
		return new userProfessionalBioWrapper(_userProfessionalBio.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.userProfessionalBio toUnescapedModel() {
		return new userProfessionalBioWrapper(_userProfessionalBio.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userProfessionalBio.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.userProfessionalBio> toCacheModel() {
		return _userProfessionalBio.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.userProfessionalBio userProfessionalBio) {
		return _userProfessionalBio.compareTo(userProfessionalBio);
	}

	@Override
	public int hashCode() {
		return _userProfessionalBio.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userProfessionalBio.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new userProfessionalBioWrapper((userProfessionalBio)_userProfessionalBio.clone());
	}

	/**
	* Returns the areaofexpertise1 of this user professional bio.
	*
	* @return the areaofexpertise1 of this user professional bio
	*/
	@Override
	public java.lang.String getAreaofexpertise1() {
		return _userProfessionalBio.getAreaofexpertise1();
	}

	/**
	* Returns the areaofexpertise2 of this user professional bio.
	*
	* @return the areaofexpertise2 of this user professional bio
	*/
	@Override
	public java.lang.String getAreaofexpertise2() {
		return _userProfessionalBio.getAreaofexpertise2();
	}

	/**
	* Returns the areaofexpertise3 of this user professional bio.
	*
	* @return the areaofexpertise3 of this user professional bio
	*/
	@Override
	public java.lang.String getAreaofexpertise3() {
		return _userProfessionalBio.getAreaofexpertise3();
	}

	/**
	* Returns the biodescription of this user professional bio.
	*
	* @return the biodescription of this user professional bio
	*/
	@Override
	public java.lang.String getBiodescription() {
		return _userProfessionalBio.getBiodescription();
	}

	/**
	* Returns the cvlink of this user professional bio.
	*
	* @return the cvlink of this user professional bio
	*/
	@Override
	public java.lang.String getCvlink() {
		return _userProfessionalBio.getCvlink();
	}

	/**
	* Returns the experienceyears of this user professional bio.
	*
	* @return the experienceyears of this user professional bio
	*/
	@Override
	public java.lang.String getExperienceyears() {
		return _userProfessionalBio.getExperienceyears();
	}

	/**
	* Returns the user uuid of this user professional bio.
	*
	* @return the user uuid of this user professional bio
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userProfessionalBio.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userProfessionalBio.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userProfessionalBio.toXmlString();
	}

	/**
	* Returns the create date of this user professional bio.
	*
	* @return the create date of this user professional bio
	*/
	@Override
	public Date getCreateDate() {
		return _userProfessionalBio.getCreateDate();
	}

	/**
	* Returns the modified date of this user professional bio.
	*
	* @return the modified date of this user professional bio
	*/
	@Override
	public Date getModifiedDate() {
		return _userProfessionalBio.getModifiedDate();
	}

	/**
	* Returns the group ID of this user professional bio.
	*
	* @return the group ID of this user professional bio
	*/
	@Override
	public long getGroupId() {
		return _userProfessionalBio.getGroupId();
	}

	/**
	* Returns the p k_user professional bio of this user professional bio.
	*
	* @return the p k_user professional bio of this user professional bio
	*/
	@Override
	public long getPK_userProfessionalBio() {
		return _userProfessionalBio.getPK_userProfessionalBio();
	}

	/**
	* Returns the primary key of this user professional bio.
	*
	* @return the primary key of this user professional bio
	*/
	@Override
	public long getPrimaryKey() {
		return _userProfessionalBio.getPrimaryKey();
	}

	/**
	* Returns the user ID of this user professional bio.
	*
	* @return the user ID of this user professional bio
	*/
	@Override
	public long getUserId() {
		return _userProfessionalBio.getUserId();
	}

	@Override
	public void persist() {
		_userProfessionalBio.persist();
	}

	/**
	* Sets the areaofexpertise1 of this user professional bio.
	*
	* @param areaofexpertise1 the areaofexpertise1 of this user professional bio
	*/
	@Override
	public void setAreaofexpertise1(java.lang.String areaofexpertise1) {
		_userProfessionalBio.setAreaofexpertise1(areaofexpertise1);
	}

	/**
	* Sets the areaofexpertise2 of this user professional bio.
	*
	* @param areaofexpertise2 the areaofexpertise2 of this user professional bio
	*/
	@Override
	public void setAreaofexpertise2(java.lang.String areaofexpertise2) {
		_userProfessionalBio.setAreaofexpertise2(areaofexpertise2);
	}

	/**
	* Sets the areaofexpertise3 of this user professional bio.
	*
	* @param areaofexpertise3 the areaofexpertise3 of this user professional bio
	*/
	@Override
	public void setAreaofexpertise3(java.lang.String areaofexpertise3) {
		_userProfessionalBio.setAreaofexpertise3(areaofexpertise3);
	}

	/**
	* Sets the biodescription of this user professional bio.
	*
	* @param biodescription the biodescription of this user professional bio
	*/
	@Override
	public void setBiodescription(java.lang.String biodescription) {
		_userProfessionalBio.setBiodescription(biodescription);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userProfessionalBio.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this user professional bio.
	*
	* @param createDate the create date of this user professional bio
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userProfessionalBio.setCreateDate(createDate);
	}

	/**
	* Sets the cvlink of this user professional bio.
	*
	* @param cvlink the cvlink of this user professional bio
	*/
	@Override
	public void setCvlink(java.lang.String cvlink) {
		_userProfessionalBio.setCvlink(cvlink);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userProfessionalBio.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userProfessionalBio.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userProfessionalBio.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the experienceyears of this user professional bio.
	*
	* @param experienceyears the experienceyears of this user professional bio
	*/
	@Override
	public void setExperienceyears(java.lang.String experienceyears) {
		_userProfessionalBio.setExperienceyears(experienceyears);
	}

	/**
	* Sets the group ID of this user professional bio.
	*
	* @param groupId the group ID of this user professional bio
	*/
	@Override
	public void setGroupId(long groupId) {
		_userProfessionalBio.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this user professional bio.
	*
	* @param modifiedDate the modified date of this user professional bio
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userProfessionalBio.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_userProfessionalBio.setNew(n);
	}

	/**
	* Sets the p k_user professional bio of this user professional bio.
	*
	* @param PK_userProfessionalBio the p k_user professional bio of this user professional bio
	*/
	@Override
	public void setPK_userProfessionalBio(long PK_userProfessionalBio) {
		_userProfessionalBio.setPK_userProfessionalBio(PK_userProfessionalBio);
	}

	/**
	* Sets the primary key of this user professional bio.
	*
	* @param primaryKey the primary key of this user professional bio
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userProfessionalBio.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userProfessionalBio.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this user professional bio.
	*
	* @param userId the user ID of this user professional bio
	*/
	@Override
	public void setUserId(long userId) {
		_userProfessionalBio.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user professional bio.
	*
	* @param userUuid the user uuid of this user professional bio
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userProfessionalBio.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userProfessionalBioWrapper)) {
			return false;
		}

		userProfessionalBioWrapper userProfessionalBioWrapper = (userProfessionalBioWrapper)obj;

		if (Objects.equals(_userProfessionalBio,
					userProfessionalBioWrapper._userProfessionalBio)) {
			return true;
		}

		return false;
	}

	@Override
	public userProfessionalBio getWrappedModel() {
		return _userProfessionalBio;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userProfessionalBio.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userProfessionalBio.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userProfessionalBio.resetOriginalValues();
	}

	private final userProfessionalBio _userProfessionalBio;
}