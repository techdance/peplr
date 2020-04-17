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
 * This class is a wrapper for {@link userCredential}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userCredential
 * @generated
 */
@ProviderType
public class userCredentialWrapper implements userCredential,
	ModelWrapper<userCredential> {
	public userCredentialWrapper(userCredential userCredential) {
		_userCredential = userCredential;
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

	@Override
	public boolean isCachedModel() {
		return _userCredential.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userCredential.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userCredential.isNew();
	}

	@Override
	public com.collaborated.entity.model.userCredential toEscapedModel() {
		return new userCredentialWrapper(_userCredential.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.userCredential toUnescapedModel() {
		return new userCredentialWrapper(_userCredential.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userCredential.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.userCredential> toCacheModel() {
		return _userCredential.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.userCredential userCredential) {
		return _userCredential.compareTo(userCredential);
	}

	@Override
	public int hashCode() {
		return _userCredential.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userCredential.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new userCredentialWrapper((userCredential)_userCredential.clone());
	}

	/**
	* Returns the certificate1 of this user credential.
	*
	* @return the certificate1 of this user credential
	*/
	@Override
	public java.lang.String getCertificate1() {
		return _userCredential.getCertificate1();
	}

	/**
	* Returns the certificate2 of this user credential.
	*
	* @return the certificate2 of this user credential
	*/
	@Override
	public java.lang.String getCertificate2() {
		return _userCredential.getCertificate2();
	}

	/**
	* Returns the certificate3 of this user credential.
	*
	* @return the certificate3 of this user credential
	*/
	@Override
	public java.lang.String getCertificate3() {
		return _userCredential.getCertificate3();
	}

	/**
	* Returns the membership1 of this user credential.
	*
	* @return the membership1 of this user credential
	*/
	@Override
	public java.lang.String getMembership1() {
		return _userCredential.getMembership1();
	}

	/**
	* Returns the membership2 of this user credential.
	*
	* @return the membership2 of this user credential
	*/
	@Override
	public java.lang.String getMembership2() {
		return _userCredential.getMembership2();
	}

	/**
	* Returns the membership3 of this user credential.
	*
	* @return the membership3 of this user credential
	*/
	@Override
	public java.lang.String getMembership3() {
		return _userCredential.getMembership3();
	}

	/**
	* Returns the membership4 of this user credential.
	*
	* @return the membership4 of this user credential
	*/
	@Override
	public java.lang.String getMembership4() {
		return _userCredential.getMembership4();
	}

	/**
	* Returns the user uuid of this user credential.
	*
	* @return the user uuid of this user credential
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userCredential.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userCredential.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userCredential.toXmlString();
	}

	/**
	* Returns the create date of this user credential.
	*
	* @return the create date of this user credential
	*/
	@Override
	public Date getCreateDate() {
		return _userCredential.getCreateDate();
	}

	/**
	* Returns the modified date of this user credential.
	*
	* @return the modified date of this user credential
	*/
	@Override
	public Date getModifiedDate() {
		return _userCredential.getModifiedDate();
	}

	/**
	* Returns the group ID of this user credential.
	*
	* @return the group ID of this user credential
	*/
	@Override
	public long getGroupId() {
		return _userCredential.getGroupId();
	}

	/**
	* Returns the p k_user credential of this user credential.
	*
	* @return the p k_user credential of this user credential
	*/
	@Override
	public long getPK_userCredential() {
		return _userCredential.getPK_userCredential();
	}

	/**
	* Returns the primary key of this user credential.
	*
	* @return the primary key of this user credential
	*/
	@Override
	public long getPrimaryKey() {
		return _userCredential.getPrimaryKey();
	}

	/**
	* Returns the user ID of this user credential.
	*
	* @return the user ID of this user credential
	*/
	@Override
	public long getUserId() {
		return _userCredential.getUserId();
	}

	@Override
	public void persist() {
		_userCredential.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userCredential.setCachedModel(cachedModel);
	}

	/**
	* Sets the certificate1 of this user credential.
	*
	* @param certificate1 the certificate1 of this user credential
	*/
	@Override
	public void setCertificate1(java.lang.String certificate1) {
		_userCredential.setCertificate1(certificate1);
	}

	/**
	* Sets the certificate2 of this user credential.
	*
	* @param certificate2 the certificate2 of this user credential
	*/
	@Override
	public void setCertificate2(java.lang.String certificate2) {
		_userCredential.setCertificate2(certificate2);
	}

	/**
	* Sets the certificate3 of this user credential.
	*
	* @param certificate3 the certificate3 of this user credential
	*/
	@Override
	public void setCertificate3(java.lang.String certificate3) {
		_userCredential.setCertificate3(certificate3);
	}

	/**
	* Sets the create date of this user credential.
	*
	* @param createDate the create date of this user credential
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userCredential.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userCredential.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userCredential.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userCredential.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this user credential.
	*
	* @param groupId the group ID of this user credential
	*/
	@Override
	public void setGroupId(long groupId) {
		_userCredential.setGroupId(groupId);
	}

	/**
	* Sets the membership1 of this user credential.
	*
	* @param membership1 the membership1 of this user credential
	*/
	@Override
	public void setMembership1(java.lang.String membership1) {
		_userCredential.setMembership1(membership1);
	}

	/**
	* Sets the membership2 of this user credential.
	*
	* @param membership2 the membership2 of this user credential
	*/
	@Override
	public void setMembership2(java.lang.String membership2) {
		_userCredential.setMembership2(membership2);
	}

	/**
	* Sets the membership3 of this user credential.
	*
	* @param membership3 the membership3 of this user credential
	*/
	@Override
	public void setMembership3(java.lang.String membership3) {
		_userCredential.setMembership3(membership3);
	}

	/**
	* Sets the membership4 of this user credential.
	*
	* @param membership4 the membership4 of this user credential
	*/
	@Override
	public void setMembership4(java.lang.String membership4) {
		_userCredential.setMembership4(membership4);
	}

	/**
	* Sets the modified date of this user credential.
	*
	* @param modifiedDate the modified date of this user credential
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userCredential.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_userCredential.setNew(n);
	}

	/**
	* Sets the p k_user credential of this user credential.
	*
	* @param PK_userCredential the p k_user credential of this user credential
	*/
	@Override
	public void setPK_userCredential(long PK_userCredential) {
		_userCredential.setPK_userCredential(PK_userCredential);
	}

	/**
	* Sets the primary key of this user credential.
	*
	* @param primaryKey the primary key of this user credential
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userCredential.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userCredential.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this user credential.
	*
	* @param userId the user ID of this user credential
	*/
	@Override
	public void setUserId(long userId) {
		_userCredential.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user credential.
	*
	* @param userUuid the user uuid of this user credential
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userCredential.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userCredentialWrapper)) {
			return false;
		}

		userCredentialWrapper userCredentialWrapper = (userCredentialWrapper)obj;

		if (Objects.equals(_userCredential,
					userCredentialWrapper._userCredential)) {
			return true;
		}

		return false;
	}

	@Override
	public userCredential getWrappedModel() {
		return _userCredential;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userCredential.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userCredential.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userCredential.resetOriginalValues();
	}

	private final userCredential _userCredential;
}