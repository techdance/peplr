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
 * This class is a wrapper for {@link userInstitutionProfileDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileDetails
 * @generated
 */
@ProviderType
public class userInstitutionProfileDetailsWrapper
	implements userInstitutionProfileDetails,
		ModelWrapper<userInstitutionProfileDetails> {
	public userInstitutionProfileDetailsWrapper(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		_userInstitutionProfileDetails = userInstitutionProfileDetails;
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

	@Override
	public boolean isCachedModel() {
		return _userInstitutionProfileDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userInstitutionProfileDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userInstitutionProfileDetails.isNew();
	}

	@Override
	public com.collaborated.entity.model.userInstitutionProfileDetails toEscapedModel() {
		return new userInstitutionProfileDetailsWrapper(_userInstitutionProfileDetails.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.userInstitutionProfileDetails toUnescapedModel() {
		return new userInstitutionProfileDetailsWrapper(_userInstitutionProfileDetails.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userInstitutionProfileDetails.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.userInstitutionProfileDetails> toCacheModel() {
		return _userInstitutionProfileDetails.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.userInstitutionProfileDetails userInstitutionProfileDetails) {
		return _userInstitutionProfileDetails.compareTo(userInstitutionProfileDetails);
	}

	@Override
	public int hashCode() {
		return _userInstitutionProfileDetails.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userInstitutionProfileDetails.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new userInstitutionProfileDetailsWrapper((userInstitutionProfileDetails)_userInstitutionProfileDetails.clone());
	}

	/**
	* Returns the acade calendar of this user institution profile details.
	*
	* @return the acade calendar of this user institution profile details
	*/
	@Override
	public java.lang.String getAcadeCalendar() {
		return _userInstitutionProfileDetails.getAcadeCalendar();
	}

	/**
	* Returns the departmentdescription of this user institution profile details.
	*
	* @return the departmentdescription of this user institution profile details
	*/
	@Override
	public java.lang.String getDepartmentdescription() {
		return _userInstitutionProfileDetails.getDepartmentdescription();
	}

	/**
	* Returns the institution name of this user institution profile details.
	*
	* @return the institution name of this user institution profile details
	*/
	@Override
	public java.lang.String getInstitutionName() {
		return _userInstitutionProfileDetails.getInstitutionName();
	}

	/**
	* Returns the user uuid of this user institution profile details.
	*
	* @return the user uuid of this user institution profile details
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userInstitutionProfileDetails.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userInstitutionProfileDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userInstitutionProfileDetails.toXmlString();
	}

	/**
	* Returns the create date of this user institution profile details.
	*
	* @return the create date of this user institution profile details
	*/
	@Override
	public Date getCreateDate() {
		return _userInstitutionProfileDetails.getCreateDate();
	}

	/**
	* Returns the modified date of this user institution profile details.
	*
	* @return the modified date of this user institution profile details
	*/
	@Override
	public Date getModifiedDate() {
		return _userInstitutionProfileDetails.getModifiedDate();
	}

	/**
	* Returns the group ID of this user institution profile details.
	*
	* @return the group ID of this user institution profile details
	*/
	@Override
	public long getGroupId() {
		return _userInstitutionProfileDetails.getGroupId();
	}

	/**
	* Returns the p k_user instition of this user institution profile details.
	*
	* @return the p k_user instition of this user institution profile details
	*/
	@Override
	public long getPK_userInstition() {
		return _userInstitutionProfileDetails.getPK_userInstition();
	}

	/**
	* Returns the primary key of this user institution profile details.
	*
	* @return the primary key of this user institution profile details
	*/
	@Override
	public long getPrimaryKey() {
		return _userInstitutionProfileDetails.getPrimaryKey();
	}

	/**
	* Returns the user ID of this user institution profile details.
	*
	* @return the user ID of this user institution profile details
	*/
	@Override
	public long getUserId() {
		return _userInstitutionProfileDetails.getUserId();
	}

	@Override
	public void persist() {
		_userInstitutionProfileDetails.persist();
	}

	/**
	* Sets the acade calendar of this user institution profile details.
	*
	* @param acadeCalendar the acade calendar of this user institution profile details
	*/
	@Override
	public void setAcadeCalendar(java.lang.String acadeCalendar) {
		_userInstitutionProfileDetails.setAcadeCalendar(acadeCalendar);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userInstitutionProfileDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this user institution profile details.
	*
	* @param createDate the create date of this user institution profile details
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userInstitutionProfileDetails.setCreateDate(createDate);
	}

	/**
	* Sets the departmentdescription of this user institution profile details.
	*
	* @param departmentdescription the departmentdescription of this user institution profile details
	*/
	@Override
	public void setDepartmentdescription(java.lang.String departmentdescription) {
		_userInstitutionProfileDetails.setDepartmentdescription(departmentdescription);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userInstitutionProfileDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userInstitutionProfileDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userInstitutionProfileDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this user institution profile details.
	*
	* @param groupId the group ID of this user institution profile details
	*/
	@Override
	public void setGroupId(long groupId) {
		_userInstitutionProfileDetails.setGroupId(groupId);
	}

	/**
	* Sets the institution name of this user institution profile details.
	*
	* @param institutionName the institution name of this user institution profile details
	*/
	@Override
	public void setInstitutionName(java.lang.String institutionName) {
		_userInstitutionProfileDetails.setInstitutionName(institutionName);
	}

	/**
	* Sets the modified date of this user institution profile details.
	*
	* @param modifiedDate the modified date of this user institution profile details
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userInstitutionProfileDetails.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_userInstitutionProfileDetails.setNew(n);
	}

	/**
	* Sets the p k_user instition of this user institution profile details.
	*
	* @param PK_userInstition the p k_user instition of this user institution profile details
	*/
	@Override
	public void setPK_userInstition(long PK_userInstition) {
		_userInstitutionProfileDetails.setPK_userInstition(PK_userInstition);
	}

	/**
	* Sets the primary key of this user institution profile details.
	*
	* @param primaryKey the primary key of this user institution profile details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userInstitutionProfileDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userInstitutionProfileDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this user institution profile details.
	*
	* @param userId the user ID of this user institution profile details
	*/
	@Override
	public void setUserId(long userId) {
		_userInstitutionProfileDetails.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user institution profile details.
	*
	* @param userUuid the user uuid of this user institution profile details
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userInstitutionProfileDetails.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userInstitutionProfileDetailsWrapper)) {
			return false;
		}

		userInstitutionProfileDetailsWrapper userInstitutionProfileDetailsWrapper =
			(userInstitutionProfileDetailsWrapper)obj;

		if (Objects.equals(_userInstitutionProfileDetails,
					userInstitutionProfileDetailsWrapper._userInstitutionProfileDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public userInstitutionProfileDetails getWrappedModel() {
		return _userInstitutionProfileDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userInstitutionProfileDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userInstitutionProfileDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userInstitutionProfileDetails.resetOriginalValues();
	}

	private final userInstitutionProfileDetails _userInstitutionProfileDetails;
}