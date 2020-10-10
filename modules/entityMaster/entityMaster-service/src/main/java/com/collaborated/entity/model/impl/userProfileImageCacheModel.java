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

import com.collaborated.entity.model.userProfileImage;

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
 * The cache model class for representing userProfileImage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see userProfileImage
 * @generated
 */
@ProviderType
public class userProfileImageCacheModel implements CacheModel<userProfileImage>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userProfileImageCacheModel)) {
			return false;
		}

		userProfileImageCacheModel userProfileImageCacheModel = (userProfileImageCacheModel)obj;

		if (PK_profileImageId == userProfileImageCacheModel.PK_profileImageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_profileImageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{PK_profileImageId=");
		sb.append(PK_profileImageId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdOn=");
		sb.append(createdOn);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", fileEntryUrl=");
		sb.append(fileEntryUrl);

		return sb.toString();
	}

	@Override
	public userProfileImage toEntityModel() {
		userProfileImageImpl userProfileImageImpl = new userProfileImageImpl();

		userProfileImageImpl.setPK_profileImageId(PK_profileImageId);
		userProfileImageImpl.setGroupId(groupId);

		if (createdOn == Long.MIN_VALUE) {
			userProfileImageImpl.setCreatedOn(null);
		}
		else {
			userProfileImageImpl.setCreatedOn(new Date(createdOn));
		}

		userProfileImageImpl.setUserId(userId);

		if (fileEntryId == null) {
			userProfileImageImpl.setFileEntryId(StringPool.BLANK);
		}
		else {
			userProfileImageImpl.setFileEntryId(fileEntryId);
		}

		if (fileEntryUrl == null) {
			userProfileImageImpl.setFileEntryUrl(StringPool.BLANK);
		}
		else {
			userProfileImageImpl.setFileEntryUrl(fileEntryUrl);
		}

		userProfileImageImpl.resetOriginalValues();

		return userProfileImageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_profileImageId = objectInput.readLong();

		groupId = objectInput.readLong();
		createdOn = objectInput.readLong();

		userId = objectInput.readLong();
		fileEntryId = objectInput.readUTF();
		fileEntryUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_profileImageId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createdOn);

		objectOutput.writeLong(userId);

		if (fileEntryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryId);
		}

		if (fileEntryUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryUrl);
		}
	}

	public long PK_profileImageId;
	public long groupId;
	public long createdOn;
	public long userId;
	public String fileEntryId;
	public String fileEntryUrl;
}