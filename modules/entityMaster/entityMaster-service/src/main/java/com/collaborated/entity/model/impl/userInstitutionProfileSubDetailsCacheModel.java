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

import com.collaborated.entity.model.userInstitutionProfileSubDetails;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing userInstitutionProfileSubDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileSubDetails
 * @generated
 */
@ProviderType
public class userInstitutionProfileSubDetailsCacheModel implements CacheModel<userInstitutionProfileSubDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userInstitutionProfileSubDetailsCacheModel)) {
			return false;
		}

		userInstitutionProfileSubDetailsCacheModel userInstitutionProfileSubDetailsCacheModel =
			(userInstitutionProfileSubDetailsCacheModel)obj;

		if (PK_userInstitionSub == userInstitutionProfileSubDetailsCacheModel.PK_userInstitionSub) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_userInstitionSub);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{PK_userInstitionSub=");
		sb.append(PK_userInstitionSub);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", PK_userInstition=");
		sb.append(PK_userInstition);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public userInstitutionProfileSubDetails toEntityModel() {
		userInstitutionProfileSubDetailsImpl userInstitutionProfileSubDetailsImpl =
			new userInstitutionProfileSubDetailsImpl();

		userInstitutionProfileSubDetailsImpl.setPK_userInstitionSub(PK_userInstitionSub);
		userInstitutionProfileSubDetailsImpl.setGroupId(groupId);
		userInstitutionProfileSubDetailsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			userInstitutionProfileSubDetailsImpl.setCreateDate(null);
		}
		else {
			userInstitutionProfileSubDetailsImpl.setCreateDate(new Date(
					createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userInstitutionProfileSubDetailsImpl.setModifiedDate(null);
		}
		else {
			userInstitutionProfileSubDetailsImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		userInstitutionProfileSubDetailsImpl.setFileId(fileId);
		userInstitutionProfileSubDetailsImpl.setPK_userInstition(PK_userInstition);

		userInstitutionProfileSubDetailsImpl.resetOriginalValues();

		return userInstitutionProfileSubDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_userInstitionSub = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		fileId = objectInput.readLong();

		PK_userInstition = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_userInstitionSub);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(fileId);

		objectOutput.writeLong(PK_userInstition);
	}

	public long PK_userInstitionSub;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long fileId;
	public long PK_userInstition;
}