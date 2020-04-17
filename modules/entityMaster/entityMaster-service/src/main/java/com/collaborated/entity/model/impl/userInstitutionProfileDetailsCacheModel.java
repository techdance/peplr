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

package com.collaborated.entity.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.collaborated.entity.model.userInstitutionProfileDetails;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing userInstitutionProfileDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileDetails
 * @generated
 */
@ProviderType
public class userInstitutionProfileDetailsCacheModel implements CacheModel<userInstitutionProfileDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userInstitutionProfileDetailsCacheModel)) {
			return false;
		}

		userInstitutionProfileDetailsCacheModel userInstitutionProfileDetailsCacheModel =
			(userInstitutionProfileDetailsCacheModel)obj;

		if (PK_userInstition == userInstitutionProfileDetailsCacheModel.PK_userInstition) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_userInstition);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{PK_userInstition=");
		sb.append(PK_userInstition);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", institutionName=");
		sb.append(institutionName);
		sb.append(", acadeCalendar=");
		sb.append(acadeCalendar);
		sb.append(", departmentdescription=");
		sb.append(departmentdescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public userInstitutionProfileDetails toEntityModel() {
		userInstitutionProfileDetailsImpl userInstitutionProfileDetailsImpl = new userInstitutionProfileDetailsImpl();

		userInstitutionProfileDetailsImpl.setPK_userInstition(PK_userInstition);
		userInstitutionProfileDetailsImpl.setGroupId(groupId);
		userInstitutionProfileDetailsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			userInstitutionProfileDetailsImpl.setCreateDate(null);
		}
		else {
			userInstitutionProfileDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userInstitutionProfileDetailsImpl.setModifiedDate(null);
		}
		else {
			userInstitutionProfileDetailsImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		if (institutionName == null) {
			userInstitutionProfileDetailsImpl.setInstitutionName(StringPool.BLANK);
		}
		else {
			userInstitutionProfileDetailsImpl.setInstitutionName(institutionName);
		}

		if (acadeCalendar == null) {
			userInstitutionProfileDetailsImpl.setAcadeCalendar(StringPool.BLANK);
		}
		else {
			userInstitutionProfileDetailsImpl.setAcadeCalendar(acadeCalendar);
		}

		if (departmentdescription == null) {
			userInstitutionProfileDetailsImpl.setDepartmentdescription(StringPool.BLANK);
		}
		else {
			userInstitutionProfileDetailsImpl.setDepartmentdescription(departmentdescription);
		}

		userInstitutionProfileDetailsImpl.resetOriginalValues();

		return userInstitutionProfileDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_userInstition = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		institutionName = objectInput.readUTF();
		acadeCalendar = objectInput.readUTF();
		departmentdescription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_userInstition);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (institutionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(institutionName);
		}

		if (acadeCalendar == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(acadeCalendar);
		}

		if (departmentdescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departmentdescription);
		}
	}

	public long PK_userInstition;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String institutionName;
	public String acadeCalendar;
	public String departmentdescription;
}