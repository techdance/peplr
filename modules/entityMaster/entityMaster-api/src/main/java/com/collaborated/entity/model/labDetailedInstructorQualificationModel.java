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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the labDetailedInstructorQualification service. Represents a row in the &quot;collaborated_labDetailedInstructorQualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.collaborated.entity.model.impl.labDetailedInstructorQualificationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.collaborated.entity.model.impl.labDetailedInstructorQualificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedInstructorQualification
 * @see com.collaborated.entity.model.impl.labDetailedInstructorQualificationImpl
 * @see com.collaborated.entity.model.impl.labDetailedInstructorQualificationModelImpl
 * @generated
 */
@ProviderType
public interface labDetailedInstructorQualificationModel extends BaseModel<labDetailedInstructorQualification> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a lab detailed instructor qualification model instance should use the {@link labDetailedInstructorQualification} interface instead.
	 */

	/**
	 * Returns the primary key of this lab detailed instructor qualification.
	 *
	 * @return the primary key of this lab detailed instructor qualification
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this lab detailed instructor qualification.
	 *
	 * @param primaryKey the primary key of this lab detailed instructor qualification
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the p k_course instructor qualification ID of this lab detailed instructor qualification.
	 *
	 * @return the p k_course instructor qualification ID of this lab detailed instructor qualification
	 */
	public long getPK_courseInstructorQualificationId();

	/**
	 * Sets the p k_course instructor qualification ID of this lab detailed instructor qualification.
	 *
	 * @param PK_courseInstructorQualificationId the p k_course instructor qualification ID of this lab detailed instructor qualification
	 */
	public void setPK_courseInstructorQualificationId(
		long PK_courseInstructorQualificationId);

	/**
	 * Returns the group ID of this lab detailed instructor qualification.
	 *
	 * @return the group ID of this lab detailed instructor qualification
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this lab detailed instructor qualification.
	 *
	 * @param groupId the group ID of this lab detailed instructor qualification
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this lab detailed instructor qualification.
	 *
	 * @return the user ID of this lab detailed instructor qualification
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this lab detailed instructor qualification.
	 *
	 * @param userId the user ID of this lab detailed instructor qualification
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this lab detailed instructor qualification.
	 *
	 * @return the user uuid of this lab detailed instructor qualification
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this lab detailed instructor qualification.
	 *
	 * @param userUuid the user uuid of this lab detailed instructor qualification
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this lab detailed instructor qualification.
	 *
	 * @return the create date of this lab detailed instructor qualification
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this lab detailed instructor qualification.
	 *
	 * @param createDate the create date of this lab detailed instructor qualification
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this lab detailed instructor qualification.
	 *
	 * @return the modified date of this lab detailed instructor qualification
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this lab detailed instructor qualification.
	 *
	 * @param modifiedDate the modified date of this lab detailed instructor qualification
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the p k_project ID of this lab detailed instructor qualification.
	 *
	 * @return the p k_project ID of this lab detailed instructor qualification
	 */
	public long getPK_projectId();

	/**
	 * Sets the p k_project ID of this lab detailed instructor qualification.
	 *
	 * @param PK_projectId the p k_project ID of this lab detailed instructor qualification
	 */
	public void setPK_projectId(long PK_projectId);

	/**
	 * Returns the p k_course ID of this lab detailed instructor qualification.
	 *
	 * @return the p k_course ID of this lab detailed instructor qualification
	 */
	public long getPK_courseId();

	/**
	 * Sets the p k_course ID of this lab detailed instructor qualification.
	 *
	 * @param PK_courseId the p k_course ID of this lab detailed instructor qualification
	 */
	public void setPK_courseId(long PK_courseId);

	/**
	 * Returns the instructor1 qualification of this lab detailed instructor qualification.
	 *
	 * @return the instructor1 qualification of this lab detailed instructor qualification
	 */
	@AutoEscape
	public String getInstructor1Qualification();

	/**
	 * Sets the instructor1 qualification of this lab detailed instructor qualification.
	 *
	 * @param instructor1Qualification the instructor1 qualification of this lab detailed instructor qualification
	 */
	public void setInstructor1Qualification(String instructor1Qualification);

	/**
	 * Returns the instructor2 qualification of this lab detailed instructor qualification.
	 *
	 * @return the instructor2 qualification of this lab detailed instructor qualification
	 */
	@AutoEscape
	public String getInstructor2Qualification();

	/**
	 * Sets the instructor2 qualification of this lab detailed instructor qualification.
	 *
	 * @param instructor2Qualification the instructor2 qualification of this lab detailed instructor qualification
	 */
	public void setInstructor2Qualification(String instructor2Qualification);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.collaborated.entity.model.labDetailedInstructorQualification labDetailedInstructorQualification);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.collaborated.entity.model.labDetailedInstructorQualification> toCacheModel();

	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification toEscapedModel();

	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}