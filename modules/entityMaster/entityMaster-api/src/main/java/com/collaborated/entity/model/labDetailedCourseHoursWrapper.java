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
 * This class is a wrapper for {@link labDetailedCourseHours}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseHours
 * @generated
 */
@ProviderType
public class labDetailedCourseHoursWrapper implements labDetailedCourseHours,
	ModelWrapper<labDetailedCourseHours> {
	public labDetailedCourseHoursWrapper(
		labDetailedCourseHours labDetailedCourseHours) {
		_labDetailedCourseHours = labDetailedCourseHours;
	}

	@Override
	public Class<?> getModelClass() {
		return labDetailedCourseHours.class;
	}

	@Override
	public String getModelClassName() {
		return labDetailedCourseHours.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PK_courseHoursId", getPK_courseHoursId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("PK_projectId", getPK_projectId());
		attributes.put("PK_courseId", getPK_courseId());
		attributes.put("numberOfCredits", getNumberOfCredits());
		attributes.put("numberOfCourseWeeks", getNumberOfCourseWeeks());
		attributes.put("courseHoursPerWeek", getCourseHoursPerWeek());
		attributes.put("lectureHoursPerWeek", getLectureHoursPerWeek());
		attributes.put("labHoursPerWeek", getLabHoursPerWeek());
		attributes.put("independentStudyHoursPerWeek",
			getIndependentStudyHoursPerWeek());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long PK_courseHoursId = (Long)attributes.get("PK_courseHoursId");

		if (PK_courseHoursId != null) {
			setPK_courseHoursId(PK_courseHoursId);
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

		Long numberOfCredits = (Long)attributes.get("numberOfCredits");

		if (numberOfCredits != null) {
			setNumberOfCredits(numberOfCredits);
		}

		Long numberOfCourseWeeks = (Long)attributes.get("numberOfCourseWeeks");

		if (numberOfCourseWeeks != null) {
			setNumberOfCourseWeeks(numberOfCourseWeeks);
		}

		Long courseHoursPerWeek = (Long)attributes.get("courseHoursPerWeek");

		if (courseHoursPerWeek != null) {
			setCourseHoursPerWeek(courseHoursPerWeek);
		}

		Long lectureHoursPerWeek = (Long)attributes.get("lectureHoursPerWeek");

		if (lectureHoursPerWeek != null) {
			setLectureHoursPerWeek(lectureHoursPerWeek);
		}

		Long labHoursPerWeek = (Long)attributes.get("labHoursPerWeek");

		if (labHoursPerWeek != null) {
			setLabHoursPerWeek(labHoursPerWeek);
		}

		Long independentStudyHoursPerWeek = (Long)attributes.get(
				"independentStudyHoursPerWeek");

		if (independentStudyHoursPerWeek != null) {
			setIndependentStudyHoursPerWeek(independentStudyHoursPerWeek);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _labDetailedCourseHours.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labDetailedCourseHours.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labDetailedCourseHours.isNew();
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseHours toEscapedModel() {
		return new labDetailedCourseHoursWrapper(_labDetailedCourseHours.toEscapedModel());
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseHours toUnescapedModel() {
		return new labDetailedCourseHoursWrapper(_labDetailedCourseHours.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labDetailedCourseHours.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.collaborated.entity.model.labDetailedCourseHours> toCacheModel() {
		return _labDetailedCourseHours.toCacheModel();
	}

	@Override
	public int compareTo(
		com.collaborated.entity.model.labDetailedCourseHours labDetailedCourseHours) {
		return _labDetailedCourseHours.compareTo(labDetailedCourseHours);
	}

	@Override
	public int hashCode() {
		return _labDetailedCourseHours.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labDetailedCourseHours.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new labDetailedCourseHoursWrapper((labDetailedCourseHours)_labDetailedCourseHours.clone());
	}

	/**
	* Returns the user uuid of this lab detailed course hours.
	*
	* @return the user uuid of this lab detailed course hours
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labDetailedCourseHours.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _labDetailedCourseHours.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labDetailedCourseHours.toXmlString();
	}

	/**
	* Returns the create date of this lab detailed course hours.
	*
	* @return the create date of this lab detailed course hours
	*/
	@Override
	public Date getCreateDate() {
		return _labDetailedCourseHours.getCreateDate();
	}

	/**
	* Returns the modified date of this lab detailed course hours.
	*
	* @return the modified date of this lab detailed course hours
	*/
	@Override
	public Date getModifiedDate() {
		return _labDetailedCourseHours.getModifiedDate();
	}

	/**
	* Returns the course hours per week of this lab detailed course hours.
	*
	* @return the course hours per week of this lab detailed course hours
	*/
	@Override
	public long getCourseHoursPerWeek() {
		return _labDetailedCourseHours.getCourseHoursPerWeek();
	}

	/**
	* Returns the group ID of this lab detailed course hours.
	*
	* @return the group ID of this lab detailed course hours
	*/
	@Override
	public long getGroupId() {
		return _labDetailedCourseHours.getGroupId();
	}

	/**
	* Returns the independent study hours per week of this lab detailed course hours.
	*
	* @return the independent study hours per week of this lab detailed course hours
	*/
	@Override
	public long getIndependentStudyHoursPerWeek() {
		return _labDetailedCourseHours.getIndependentStudyHoursPerWeek();
	}

	/**
	* Returns the lab hours per week of this lab detailed course hours.
	*
	* @return the lab hours per week of this lab detailed course hours
	*/
	@Override
	public long getLabHoursPerWeek() {
		return _labDetailedCourseHours.getLabHoursPerWeek();
	}

	/**
	* Returns the lecture hours per week of this lab detailed course hours.
	*
	* @return the lecture hours per week of this lab detailed course hours
	*/
	@Override
	public long getLectureHoursPerWeek() {
		return _labDetailedCourseHours.getLectureHoursPerWeek();
	}

	/**
	* Returns the number of course weeks of this lab detailed course hours.
	*
	* @return the number of course weeks of this lab detailed course hours
	*/
	@Override
	public long getNumberOfCourseWeeks() {
		return _labDetailedCourseHours.getNumberOfCourseWeeks();
	}

	/**
	* Returns the number of credits of this lab detailed course hours.
	*
	* @return the number of credits of this lab detailed course hours
	*/
	@Override
	public long getNumberOfCredits() {
		return _labDetailedCourseHours.getNumberOfCredits();
	}

	/**
	* Returns the p k_course hours ID of this lab detailed course hours.
	*
	* @return the p k_course hours ID of this lab detailed course hours
	*/
	@Override
	public long getPK_courseHoursId() {
		return _labDetailedCourseHours.getPK_courseHoursId();
	}

	/**
	* Returns the p k_course ID of this lab detailed course hours.
	*
	* @return the p k_course ID of this lab detailed course hours
	*/
	@Override
	public long getPK_courseId() {
		return _labDetailedCourseHours.getPK_courseId();
	}

	/**
	* Returns the p k_project ID of this lab detailed course hours.
	*
	* @return the p k_project ID of this lab detailed course hours
	*/
	@Override
	public long getPK_projectId() {
		return _labDetailedCourseHours.getPK_projectId();
	}

	/**
	* Returns the primary key of this lab detailed course hours.
	*
	* @return the primary key of this lab detailed course hours
	*/
	@Override
	public long getPrimaryKey() {
		return _labDetailedCourseHours.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lab detailed course hours.
	*
	* @return the user ID of this lab detailed course hours
	*/
	@Override
	public long getUserId() {
		return _labDetailedCourseHours.getUserId();
	}

	@Override
	public void persist() {
		_labDetailedCourseHours.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labDetailedCourseHours.setCachedModel(cachedModel);
	}

	/**
	* Sets the course hours per week of this lab detailed course hours.
	*
	* @param courseHoursPerWeek the course hours per week of this lab detailed course hours
	*/
	@Override
	public void setCourseHoursPerWeek(long courseHoursPerWeek) {
		_labDetailedCourseHours.setCourseHoursPerWeek(courseHoursPerWeek);
	}

	/**
	* Sets the create date of this lab detailed course hours.
	*
	* @param createDate the create date of this lab detailed course hours
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labDetailedCourseHours.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labDetailedCourseHours.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labDetailedCourseHours.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labDetailedCourseHours.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab detailed course hours.
	*
	* @param groupId the group ID of this lab detailed course hours
	*/
	@Override
	public void setGroupId(long groupId) {
		_labDetailedCourseHours.setGroupId(groupId);
	}

	/**
	* Sets the independent study hours per week of this lab detailed course hours.
	*
	* @param independentStudyHoursPerWeek the independent study hours per week of this lab detailed course hours
	*/
	@Override
	public void setIndependentStudyHoursPerWeek(
		long independentStudyHoursPerWeek) {
		_labDetailedCourseHours.setIndependentStudyHoursPerWeek(independentStudyHoursPerWeek);
	}

	/**
	* Sets the lab hours per week of this lab detailed course hours.
	*
	* @param labHoursPerWeek the lab hours per week of this lab detailed course hours
	*/
	@Override
	public void setLabHoursPerWeek(long labHoursPerWeek) {
		_labDetailedCourseHours.setLabHoursPerWeek(labHoursPerWeek);
	}

	/**
	* Sets the lecture hours per week of this lab detailed course hours.
	*
	* @param lectureHoursPerWeek the lecture hours per week of this lab detailed course hours
	*/
	@Override
	public void setLectureHoursPerWeek(long lectureHoursPerWeek) {
		_labDetailedCourseHours.setLectureHoursPerWeek(lectureHoursPerWeek);
	}

	/**
	* Sets the modified date of this lab detailed course hours.
	*
	* @param modifiedDate the modified date of this lab detailed course hours
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labDetailedCourseHours.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_labDetailedCourseHours.setNew(n);
	}

	/**
	* Sets the number of course weeks of this lab detailed course hours.
	*
	* @param numberOfCourseWeeks the number of course weeks of this lab detailed course hours
	*/
	@Override
	public void setNumberOfCourseWeeks(long numberOfCourseWeeks) {
		_labDetailedCourseHours.setNumberOfCourseWeeks(numberOfCourseWeeks);
	}

	/**
	* Sets the number of credits of this lab detailed course hours.
	*
	* @param numberOfCredits the number of credits of this lab detailed course hours
	*/
	@Override
	public void setNumberOfCredits(long numberOfCredits) {
		_labDetailedCourseHours.setNumberOfCredits(numberOfCredits);
	}

	/**
	* Sets the p k_course hours ID of this lab detailed course hours.
	*
	* @param PK_courseHoursId the p k_course hours ID of this lab detailed course hours
	*/
	@Override
	public void setPK_courseHoursId(long PK_courseHoursId) {
		_labDetailedCourseHours.setPK_courseHoursId(PK_courseHoursId);
	}

	/**
	* Sets the p k_course ID of this lab detailed course hours.
	*
	* @param PK_courseId the p k_course ID of this lab detailed course hours
	*/
	@Override
	public void setPK_courseId(long PK_courseId) {
		_labDetailedCourseHours.setPK_courseId(PK_courseId);
	}

	/**
	* Sets the p k_project ID of this lab detailed course hours.
	*
	* @param PK_projectId the p k_project ID of this lab detailed course hours
	*/
	@Override
	public void setPK_projectId(long PK_projectId) {
		_labDetailedCourseHours.setPK_projectId(PK_projectId);
	}

	/**
	* Sets the primary key of this lab detailed course hours.
	*
	* @param primaryKey the primary key of this lab detailed course hours
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labDetailedCourseHours.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labDetailedCourseHours.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this lab detailed course hours.
	*
	* @param userId the user ID of this lab detailed course hours
	*/
	@Override
	public void setUserId(long userId) {
		_labDetailedCourseHours.setUserId(userId);
	}

	/**
	* Sets the user uuid of this lab detailed course hours.
	*
	* @param userUuid the user uuid of this lab detailed course hours
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labDetailedCourseHours.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseHoursWrapper)) {
			return false;
		}

		labDetailedCourseHoursWrapper labDetailedCourseHoursWrapper = (labDetailedCourseHoursWrapper)obj;

		if (Objects.equals(_labDetailedCourseHours,
					labDetailedCourseHoursWrapper._labDetailedCourseHours)) {
			return true;
		}

		return false;
	}

	@Override
	public labDetailedCourseHours getWrappedModel() {
		return _labDetailedCourseHours;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labDetailedCourseHours.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labDetailedCourseHours.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labDetailedCourseHours.resetOriginalValues();
	}

	private final labDetailedCourseHours _labDetailedCourseHours;
}