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
 * This class is a wrapper for {@link labDetailedCourseResources}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseResources
 * @generated
 */
@ProviderType
public class labDetailedCourseResourcesWrapper
	implements labDetailedCourseResources,
		ModelWrapper<labDetailedCourseResources> {
	public labDetailedCourseResourcesWrapper(
		labDetailedCourseResources labDetailedCourseResources) {
		_labDetailedCourseResources = labDetailedCourseResources;
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedCourseResources.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedCourseResources.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseResourceId", getPK_courseResourceId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("textbokTitle", getTextbokTitle());
		attributes.put("publisherName", getPublisherName());
		attributes.put("author", getAuthor());
		attributes.put("isbn", getIsbn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseResourceId = (Long)attributes.get("PK_courseResourceId");

		if (PK_courseResourceId != null) {
			setPK_courseResourceId(PK_courseResourceId);
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

		Long PK_courseId = (Long)attributes.get("PK_courseId");

		if (PK_courseId != null) {
			setPK_courseId(PK_courseId);
		}

		String textbokTitle = (String)attributes.get("textbokTitle");

		if (textbokTitle != null) {
			setTextbokTitle(textbokTitle);
		}

		String publisherName = (String)attributes.get("publisherName");

		if (publisherName != null) {
			setPublisherName(publisherName);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String isbn = (String)attributes.get("isbn");

		if (isbn != null) {
			setIsbn(isbn);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labDetailedCourseResources.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labDetailedCourseResources.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labDetailedCourseResources.isNew();
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseResources toEscapedModel() {
		return new labDetailedCourseResourcesWrapper(_labDetailedCourseResources.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseResources toUnescapedModel() {
		return new labDetailedCourseResourcesWrapper(_labDetailedCourseResources.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labDetailedCourseResources.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labDetailedCourseResources> toCacheModel() {
		return _labDetailedCourseResources.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labDetailedCourseResources labDetailedCourseResources) {
		return _labDetailedCourseResources.compareTo(labDetailedCourseResources);
	}

	@Override
	public int hashCode() {
		return _labDetailedCourseResources.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labDetailedCourseResources.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labDetailedCourseResourcesWrapper((labDetailedCourseResources)_labDetailedCourseResources.clone());
	}

	/**
	* Returns the author of this lab detailed course resources.
	*
	* @return the author of this lab detailed course resources
	*/
	@Override
	public java.lang.String getAuthor() {
		return _labDetailedCourseResources.getAuthor();
	}

	/**
	* Returns the isbn of this lab detailed course resources.
	*
	* @return the isbn of this lab detailed course resources
	*/
	@Override
	public java.lang.String getIsbn() {
		return _labDetailedCourseResources.getIsbn();
	}

	/**
	* Returns the publisher name of this lab detailed course resources.
	*
	* @return the publisher name of this lab detailed course resources
	*/
	@Override
	public java.lang.String getPublisherName() {
		return _labDetailedCourseResources.getPublisherName();
	}

	/**
	* Returns the textbok title of this lab detailed course resources.
	*
	* @return the textbok title of this lab detailed course resources
	*/
	@Override
	public java.lang.String getTextbokTitle() {
		return _labDetailedCourseResources.getTextbokTitle();
	}

	/**
	* Returns the user uuid of this lab detailed course resources.
	*
	* @return the user uuid of this lab detailed course resources
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labDetailedCourseResources.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labDetailedCourseResources.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labDetailedCourseResources.toXmlString();
	}

	/**
	* Returns the create date of this lab detailed course resources.
	*
	* @return the create date of this lab detailed course resources
	*/
	@Override
	public Date getCreateDate() {
		return _labDetailedCourseResources.getCreateDate();
	}

	/**
	* Returns the modified date of this lab detailed course resources.
	*
	* @return the modified date of this lab detailed course resources
	*/
	@Override
	public Date getModifiedDate() {
		return _labDetailedCourseResources.getModifiedDate();
	}

	/**
	* Returns the group ID of this lab detailed course resources.
	*
	* @return the group ID of this lab detailed course resources
	*/
	@Override
	public long getGroupId() {
		return _labDetailedCourseResources.getGroupId();
	}

	/**
	* Returns the p k_course ID of this lab detailed course resources.
	*
	* @return the p k_course ID of this lab detailed course resources
	*/
	@Override
	public long getPK_courseId() {
		return _labDetailedCourseResources.getPK_courseId();
	}

	/**
	* Returns the p k_course resource ID of this lab detailed course resources.
	*
	* @return the p k_course resource ID of this lab detailed course resources
	*/
	@Override
	public long getPK_courseResourceId() {
		return _labDetailedCourseResources.getPK_courseResourceId();
	}

	/**
	* Returns the p k_project ID of this lab detailed course resources.
	*
	* @return the p k_project ID of this lab detailed course resources
	*/
	@Override
	public long getPK_projectId() {
		return _labDetailedCourseResources.getPK_projectId();
	}

	/**
	* Returns the primary key of this lab detailed course resources.
	*
	* @return the primary key of this lab detailed course resources
	*/
	@Override
	public long getPrimaryKey() {
		return _labDetailedCourseResources.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lab detailed course resources.
	*
	* @return the user ID of this lab detailed course resources
	*/
	@Override
	public long getUserId() {
		return _labDetailedCourseResources.getUserId();
	}

	@Override
	public void persist() {
		_labDetailedCourseResources.persist();
	}

	/**
	* Sets the author of this lab detailed course resources.
	*
	* @param author the author of this lab detailed course resources
	*/
	@Override
	public void setAuthor(java.lang.String author) {
		_labDetailedCourseResources.setAuthor(author);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labDetailedCourseResources.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this lab detailed course resources.
	*
	* @param createDate the create date of this lab detailed course resources
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labDetailedCourseResources.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labDetailedCourseResources.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labDetailedCourseResources.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labDetailedCourseResources.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab detailed course resources.
	*
	* @param groupId the group ID of this lab detailed course resources
	*/
	@Override
	public void setGroupId(long groupId) {
		_labDetailedCourseResources.setGroupId(groupId);
	}

	/**
	* Sets the isbn of this lab detailed course resources.
	*
	* @param isbn the isbn of this lab detailed course resources
	*/
	@Override
	public void setIsbn(java.lang.String isbn) {
		_labDetailedCourseResources.setIsbn(isbn);
	}

	/**
	* Sets the modified date of this lab detailed course resources.
	*
	* @param modifiedDate the modified date of this lab detailed course resources
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labDetailedCourseResources.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labDetailedCourseResources.setNew(n);
	}

	/**
	* Sets the p k_course ID of this lab detailed course resources.
	*
	* @param PK_courseId the p k_course ID of this lab detailed course resources
	*/
	@Override
	public void setPK_courseId(long PK_courseId) {
		_labDetailedCourseResources.setPK_courseId(PK_courseId);
	}

	/**
	* Sets the p k_course resource ID of this lab detailed course resources.
	*
	* @param PK_courseResourceId the p k_course resource ID of this lab detailed course resources
	*/
	@Override
	public void setPK_courseResourceId(long PK_courseResourceId) {
		_labDetailedCourseResources.setPK_courseResourceId(PK_courseResourceId);
	}

	/**
	* Sets the p k_project ID of this lab detailed course resources.
	*
	* @param PK_projectId the p k_project ID of this lab detailed course resources
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labDetailedCourseResources.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the primary key of this lab detailed course resources.
	*
	* @param primaryKey the primary key of this lab detailed course resources
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labDetailedCourseResources.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labDetailedCourseResources.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the publisher name of this lab detailed course resources.
	*
	* @param publisherName the publisher name of this lab detailed course resources
	*/
	@Override
	public void setPublisherName(java.lang.String publisherName) {
		_labDetailedCourseResources.setPublisherName(publisherName);
	}

	/**
	* Sets the textbok title of this lab detailed course resources.
	*
	* @param textbokTitle the textbok title of this lab detailed course resources
	*/
	@Override
	public void setTextbokTitle(java.lang.String textbokTitle) {
		_labDetailedCourseResources.setTextbokTitle(textbokTitle);
	}

	/**
	* Sets the user ID of this lab detailed course resources.
	*
	* @param userId the user ID of this lab detailed course resources
	*/
	@Override
	public void setUserId(long userId) {
		_labDetailedCourseResources.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab detailed course resources.
	*
	* @param userUuid the user uuid of this lab detailed course resources
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labDetailedCourseResources.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseResourcesWrapper)) {
			return false;
		}

		labDetailedCourseResourcesWrapper labDetailedCourseResourcesWrapper = (labDetailedCourseResourcesWrapper)obj;

		if (Objects.equals(_labDetailedCourseResources,
					labDetailedCourseResourcesWrapper._labDetailedCourseResources)) {
			return true;
		}

		return false;
	}

	@Override
	public labDetailedCourseResources getWrappedModel() {
		return _labDetailedCourseResources;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labDetailedCourseResources.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labDetailedCourseResources.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labDetailedCourseResources.resetOriginalValues();
	}

	private final labDetailedCourseResources _labDetailedCourseResources;
}