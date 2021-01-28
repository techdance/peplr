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
 * This class is a wrapper for {@link applicationLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see applicationLog
 * @generated
 */
@ProviderType
public class applicationLogWrapper implements applicationLog,
	ModelWrapper<applicationLog> {
	public applicationLogWrapper(applicationLog applicationLog) {
		_applicationLog = applicationLog;
	}

	@Override
	public Class<?> getModelClass() {
		return applicationLog.class;
	}

	@Override
	public String getModelClassName() {
		return applicationLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_logId", getPK_logId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("pageName", getPageName());
		attributes.put("moduleName", getModuleName());
		attributes.put("buttonName", getButtonName());
		attributes.put("projectId", getProjectId());
		attributes.put("interestId", getInterestId());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_logId = (Long)attributes.get("PK_logId");

		if (PK_logId != null) {
			setPK_logId(PK_logId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String pageName = (String)attributes.get("pageName");

		if (pageName != null) {
			setPageName(pageName);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		String buttonName = (String)attributes.get("buttonName");

		if (buttonName != null) {
			setButtonName(buttonName);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long interestId = (Long)attributes.get("interestId");

		if (interestId != null) {
			setInterestId(interestId);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _applicationLog.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _applicationLog.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _applicationLog.isNew();
	}

	@Override
	public com.collaborated.entity.model.applicationLog toEscapedModel() {
		return new applicationLogWrapper(_applicationLog.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.applicationLog toUnescapedModel() {
		return new applicationLogWrapper(_applicationLog.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _applicationLog.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.applicationLog> toCacheModel() {
		return _applicationLog.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.applicationLog applicationLog) {
		return _applicationLog.compareTo(applicationLog);
	}

	@Override
	public int hashCode() {
		return _applicationLog.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationLog.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new applicationLogWrapper((applicationLog)_applicationLog.clone());
	}

	/**
	* Returns the button name of this application log.
	*
	* @return the button name of this application log
	*/
	@Override
	public java.lang.String getButtonName() {
		return _applicationLog.getButtonName();
	}

	/**
	* Returns the comments of this application log.
	*
	* @return the comments of this application log
	*/
	@Override
	public java.lang.String getComments() {
		return _applicationLog.getComments();
	}

	/**
	* Returns the module name of this application log.
	*
	* @return the module name of this application log
	*/
	@Override
	public java.lang.String getModuleName() {
		return _applicationLog.getModuleName();
	}

	/**
	* Returns the page name of this application log.
	*
	* @return the page name of this application log
	*/
	@Override
	public java.lang.String getPageName() {
		return _applicationLog.getPageName();
	}

	/**
	* Returns the user name of this application log.
	*
	* @return the user name of this application log
	*/
	@Override
	public java.lang.String getUserName() {
		return _applicationLog.getUserName();
	}

	/**
	* Returns the user uuid of this application log.
	*
	* @return the user uuid of this application log
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _applicationLog.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _applicationLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _applicationLog.toXmlString();
	}

	/**
	* Returns the create date of this application log.
	*
	* @return the create date of this application log
	*/
	@Override
	public Date getCreateDate() {
		return _applicationLog.getCreateDate();
	}

	/**
	* Returns the interest ID of this application log.
	*
	* @return the interest ID of this application log
	*/
	@Override
	public long getInterestId() {
		return _applicationLog.getInterestId();
	}

	/**
	* Returns the p k_log ID of this application log.
	*
	* @return the p k_log ID of this application log
	*/
	@Override
	public long getPK_logId() {
		return _applicationLog.getPK_logId();
	}

	/**
	* Returns the primary key of this application log.
	*
	* @return the primary key of this application log
	*/
	@Override
	public long getPrimaryKey() {
		return _applicationLog.getPrimaryKey();
	}

	/**
	* Returns the project ID of this application log.
	*
	* @return the project ID of this application log
	*/
	@Override
	public long getProjectId() {
		return _applicationLog.getProjectId();
	}

	/**
	* Returns the user ID of this application log.
	*
	* @return the user ID of this application log
	*/
	@Override
	public long getUserId() {
		return _applicationLog.getUserId();
	}

	@Override
	public void persist() {
		_applicationLog.persist();
	}

	/**
	* Sets the button name of this application log.
	*
	* @param buttonName the button name of this application log
	*/
	@Override
	public void setButtonName(java.lang.String buttonName) {
		_applicationLog.setButtonName(buttonName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applicationLog.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this application log.
	*
	* @param comments the comments of this application log
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_applicationLog.setComments(comments);
	}

	/**
	* Sets the create date of this application log.
	*
	* @param createDate the create date of this application log
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_applicationLog.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_applicationLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_applicationLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_applicationLog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the interest ID of this application log.
	*
	* @param interestId the interest ID of this application log
	*/
	@Override
	public void setInterestId(long interestId) {
		_applicationLog.setInterestId(interestId);
	}

	/**
	* Sets the module name of this application log.
	*
	* @param moduleName the module name of this application log
	*/
	@Override
	public void setModuleName(java.lang.String moduleName) {
		_applicationLog.setModuleName(moduleName);
	}

	@Override
	public void setNew(boolean n) {
		_applicationLog.setNew(n);
	}

	/**
	* Sets the p k_log ID of this application log.
	*
	* @param PK_logId the p k_log ID of this application log
	*/
	@Override
	public void setPK_logId(long PK_logId) {
		_applicationLog.setPK_logId(PK_logId);
	}

	/**
	* Sets the page name of this application log.
	*
	* @param pageName the page name of this application log
	*/
	@Override
	public void setPageName(java.lang.String pageName) {
		_applicationLog.setPageName(pageName);
	}

	/**
	* Sets the primary key of this application log.
	*
	* @param primaryKey the primary key of this application log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applicationLog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_applicationLog.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this application log.
	*
	* @param projectId the project ID of this application log
	*/
	@Override
	public void setProjectId(long projectId) {
		_applicationLog.setProjectId(projectId);
	}

	/**
	* Sets the user ID of this application log.
	*
	* @param userId the user ID of this application log
	*/
	@Override
	public void setUserId(long userId) {
		_applicationLog.setUserId(userId);
	}

	/**
	* Sets the user name of this application log.
	*
	* @param userName the user name of this application log
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_applicationLog.setUserName(userName);
	}

	/**
	* Sets the user uuid of this application log.
	*
	* @param userUuid the user uuid of this application log
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_applicationLog.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof applicationLogWrapper)) {
			return false;
		}

		applicationLogWrapper applicationLogWrapper = (applicationLogWrapper)obj;

		if (Objects.equals(_applicationLog,
					applicationLogWrapper._applicationLog)) {
			return true;
		}

		return false;
	}

	@Override
	public applicationLog getWrappedModel() {
		return _applicationLog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _applicationLog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _applicationLog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_applicationLog.resetOriginalValues();
	}

	private final applicationLog _applicationLog;
}