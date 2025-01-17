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
 * The base model interface for the userInstitutionProfileDetails service. Represents a row in the &quot;collaborated_userInstitutionProfileDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.collaborated.entity.model.impl.userInstitutionProfileDetailsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.collaborated.entity.model.impl.userInstitutionProfileDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileDetails
 * @see com.collaborated.entity.model.impl.userInstitutionProfileDetailsImpl
 * @see com.collaborated.entity.model.impl.userInstitutionProfileDetailsModelImpl
 * @generated
 */
@ProviderType
public interface userInstitutionProfileDetailsModel extends BaseModel<userInstitutionProfileDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user institution profile details model instance should use the {@link userInstitutionProfileDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this user institution profile details.
	 *
	 * @return the primary key of this user institution profile details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user institution profile details.
	 *
	 * @param primaryKey the primary key of this user institution profile details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the p k_user instition of this user institution profile details.
	 *
	 * @return the p k_user instition of this user institution profile details
	 */
	public long getPK_userInstition();

	/**
	 * Sets the p k_user instition of this user institution profile details.
	 *
	 * @param PK_userInstition the p k_user instition of this user institution profile details
	 */
	public void setPK_userInstition(long PK_userInstition);

	/**
	 * Returns the group ID of this user institution profile details.
	 *
	 * @return the group ID of this user institution profile details
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this user institution profile details.
	 *
	 * @param groupId the group ID of this user institution profile details
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this user institution profile details.
	 *
	 * @return the user ID of this user institution profile details
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this user institution profile details.
	 *
	 * @param userId the user ID of this user institution profile details
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this user institution profile details.
	 *
	 * @return the user uuid of this user institution profile details
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this user institution profile details.
	 *
	 * @param userUuid the user uuid of this user institution profile details
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this user institution profile details.
	 *
	 * @return the create date of this user institution profile details
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this user institution profile details.
	 *
	 * @param createDate the create date of this user institution profile details
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this user institution profile details.
	 *
	 * @return the modified date of this user institution profile details
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this user institution profile details.
	 *
	 * @param modifiedDate the modified date of this user institution profile details
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the institution name of this user institution profile details.
	 *
	 * @return the institution name of this user institution profile details
	 */
	@AutoEscape
	public String getInstitutionName();

	/**
	 * Sets the institution name of this user institution profile details.
	 *
	 * @param institutionName the institution name of this user institution profile details
	 */
	public void setInstitutionName(String institutionName);

	/**
	 * Returns the acade calendar of this user institution profile details.
	 *
	 * @return the acade calendar of this user institution profile details
	 */
	@AutoEscape
	public String getAcadeCalendar();

	/**
	 * Sets the acade calendar of this user institution profile details.
	 *
	 * @param acadeCalendar the acade calendar of this user institution profile details
	 */
	public void setAcadeCalendar(String acadeCalendar);

	/**
	 * Returns the departmentdescription of this user institution profile details.
	 *
	 * @return the departmentdescription of this user institution profile details
	 */
	@AutoEscape
	public String getDepartmentdescription();

	/**
	 * Sets the departmentdescription of this user institution profile details.
	 *
	 * @param departmentdescription the departmentdescription of this user institution profile details
	 */
	public void setDepartmentdescription(String departmentdescription);

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
		com.collaborated.entity.model.userInstitutionProfileDetails userInstitutionProfileDetails);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.collaborated.entity.model.userInstitutionProfileDetails> toCacheModel();

	@Override
	public com.collaborated.entity.model.userInstitutionProfileDetails toEscapedModel();

	@Override
	public com.collaborated.entity.model.userInstitutionProfileDetails toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}