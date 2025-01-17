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
 * The base model interface for the labDetailedActivityTable service. Represents a row in the &quot;collaborated_labDetailedActivityTable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.collaborated.entity.model.impl.labDetailedActivityTableModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.collaborated.entity.model.impl.labDetailedActivityTableImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedActivityTable
 * @see com.collaborated.entity.model.impl.labDetailedActivityTableImpl
 * @see com.collaborated.entity.model.impl.labDetailedActivityTableModelImpl
 * @generated
 */
@ProviderType
public interface labDetailedActivityTableModel extends BaseModel<labDetailedActivityTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a lab detailed activity table model instance should use the {@link labDetailedActivityTable} interface instead.
	 */

	/**
	 * Returns the primary key of this lab detailed activity table.
	 *
	 * @return the primary key of this lab detailed activity table
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this lab detailed activity table.
	 *
	 * @param primaryKey the primary key of this lab detailed activity table
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the p k_activity table ID of this lab detailed activity table.
	 *
	 * @return the p k_activity table ID of this lab detailed activity table
	 */
	public long getPK_activityTableId();

	/**
	 * Sets the p k_activity table ID of this lab detailed activity table.
	 *
	 * @param PK_activityTableId the p k_activity table ID of this lab detailed activity table
	 */
	public void setPK_activityTableId(long PK_activityTableId);

	/**
	 * Returns the group ID of this lab detailed activity table.
	 *
	 * @return the group ID of this lab detailed activity table
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this lab detailed activity table.
	 *
	 * @param groupId the group ID of this lab detailed activity table
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this lab detailed activity table.
	 *
	 * @return the user ID of this lab detailed activity table
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this lab detailed activity table.
	 *
	 * @param userId the user ID of this lab detailed activity table
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this lab detailed activity table.
	 *
	 * @return the user uuid of this lab detailed activity table
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this lab detailed activity table.
	 *
	 * @param userUuid the user uuid of this lab detailed activity table
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this lab detailed activity table.
	 *
	 * @return the create date of this lab detailed activity table
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this lab detailed activity table.
	 *
	 * @param createDate the create date of this lab detailed activity table
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this lab detailed activity table.
	 *
	 * @return the modified date of this lab detailed activity table
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this lab detailed activity table.
	 *
	 * @param modifiedDate the modified date of this lab detailed activity table
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the p k_project ID of this lab detailed activity table.
	 *
	 * @return the p k_project ID of this lab detailed activity table
	 */
	public long getPK_projectId();

	/**
	 * Sets the p k_project ID of this lab detailed activity table.
	 *
	 * @param PK_projectId the p k_project ID of this lab detailed activity table
	 */
	public void setPK_projectId(long PK_projectId);

	/**
	 * Returns the p k_course ID of this lab detailed activity table.
	 *
	 * @return the p k_course ID of this lab detailed activity table
	 */
	public long getPK_courseId();

	/**
	 * Sets the p k_course ID of this lab detailed activity table.
	 *
	 * @param PK_courseId the p k_course ID of this lab detailed activity table
	 */
	public void setPK_courseId(long PK_courseId);

	/**
	 * Returns the week of this lab detailed activity table.
	 *
	 * @return the week of this lab detailed activity table
	 */
	public long getWeek();

	/**
	 * Sets the week of this lab detailed activity table.
	 *
	 * @param week the week of this lab detailed activity table
	 */
	public void setWeek(long week);

	/**
	 * Returns the course objective of this lab detailed activity table.
	 *
	 * @return the course objective of this lab detailed activity table
	 */
	@AutoEscape
	public String getCourseObjective();

	/**
	 * Sets the course objective of this lab detailed activity table.
	 *
	 * @param courseObjective the course objective of this lab detailed activity table
	 */
	public void setCourseObjective(String courseObjective);

	/**
	 * Returns the learning environment design of this lab detailed activity table.
	 *
	 * @return the learning environment design of this lab detailed activity table
	 */
	@AutoEscape
	public String getLearningEnvironmentDesign();

	/**
	 * Sets the learning environment design of this lab detailed activity table.
	 *
	 * @param learningEnvironmentDesign the learning environment design of this lab detailed activity table
	 */
	public void setLearningEnvironmentDesign(String learningEnvironmentDesign);

	/**
	 * Returns the activity of this lab detailed activity table.
	 *
	 * @return the activity of this lab detailed activity table
	 */
	@AutoEscape
	public String getActivity();

	/**
	 * Sets the activity of this lab detailed activity table.
	 *
	 * @param activity the activity of this lab detailed activity table
	 */
	public void setActivity(String activity);

	/**
	 * Returns the content of this lab detailed activity table.
	 *
	 * @return the content of this lab detailed activity table
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this lab detailed activity table.
	 *
	 * @param content the content of this lab detailed activity table
	 */
	public void setContent(String content);

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
		com.collaborated.entity.model.labDetailedActivityTable labDetailedActivityTable);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.collaborated.entity.model.labDetailedActivityTable> toCacheModel();

	@Override
	public com.collaborated.entity.model.labDetailedActivityTable toEscapedModel();

	@Override
	public com.collaborated.entity.model.labDetailedActivityTable toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}