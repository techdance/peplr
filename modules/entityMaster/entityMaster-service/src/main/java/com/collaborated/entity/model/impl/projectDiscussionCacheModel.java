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

import com.collaborated.entity.model.projectDiscussion;

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
 * The cache model class for representing projectDiscussion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see projectDiscussion
 * @generated
 */
@ProviderType
public class projectDiscussionCacheModel implements CacheModel<projectDiscussion>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof projectDiscussionCacheModel)) {
			return false;
		}

		projectDiscussionCacheModel projectDiscussionCacheModel = (projectDiscussionCacheModel)obj;

		if (PK_projectDiscussionId == projectDiscussionCacheModel.PK_projectDiscussionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_projectDiscussionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{PK_projectDiscussionId=");
		sb.append(PK_projectDiscussionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdOn=");
		sb.append(createdOn);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", interestId=");
		sb.append(interestId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", senderId=");
		sb.append(senderId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public projectDiscussion toEntityModel() {
		projectDiscussionImpl projectDiscussionImpl = new projectDiscussionImpl();

		projectDiscussionImpl.setPK_projectDiscussionId(PK_projectDiscussionId);
		projectDiscussionImpl.setGroupId(groupId);

		if (createdOn == Long.MIN_VALUE) {
			projectDiscussionImpl.setCreatedOn(null);
		}
		else {
			projectDiscussionImpl.setCreatedOn(new Date(createdOn));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectDiscussionImpl.setModifiedDate(null);
		}
		else {
			projectDiscussionImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectDiscussionImpl.setInterestId(interestId);
		projectDiscussionImpl.setProjectId(projectId);
		projectDiscussionImpl.setSenderId(senderId);

		if (description == null) {
			projectDiscussionImpl.setDescription(StringPool.BLANK);
		}
		else {
			projectDiscussionImpl.setDescription(description);
		}

		projectDiscussionImpl.setFileEntryId(fileEntryId);

		if (imageUrl == null) {
			projectDiscussionImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			projectDiscussionImpl.setImageUrl(imageUrl);
		}

		projectDiscussionImpl.resetOriginalValues();

		return projectDiscussionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_projectDiscussionId = objectInput.readLong();

		groupId = objectInput.readLong();
		createdOn = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		interestId = objectInput.readLong();

		projectId = objectInput.readLong();

		senderId = objectInput.readLong();
		description = objectInput.readUTF();

		fileEntryId = objectInput.readLong();
		imageUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_projectDiscussionId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createdOn);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(interestId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(senderId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(fileEntryId);

		if (imageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}
	}

	public long PK_projectDiscussionId;
	public long groupId;
	public long createdOn;
	public long modifiedDate;
	public long interestId;
	public long projectId;
	public long senderId;
	public String description;
	public long fileEntryId;
	public String imageUrl;
}