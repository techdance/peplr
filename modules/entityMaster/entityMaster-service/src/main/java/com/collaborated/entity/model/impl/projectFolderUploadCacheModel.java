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

import com.collaborated.entity.model.projectFolderUpload;

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
 * The cache model class for representing projectFolderUpload in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see projectFolderUpload
 * @generated
 */
@ProviderType
public class projectFolderUploadCacheModel implements CacheModel<projectFolderUpload>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof projectFolderUploadCacheModel)) {
			return false;
		}

		projectFolderUploadCacheModel projectFolderUploadCacheModel = (projectFolderUploadCacheModel)obj;

		if (PK_projectFolderId == projectFolderUploadCacheModel.PK_projectFolderId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_projectFolderId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{PK_projectFolderId=");
		sb.append(PK_projectFolderId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdOn=");
		sb.append(createdOn);
		sb.append(", deletedOn=");
		sb.append(deletedOn);
		sb.append(", interestId=");
		sb.append(interestId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", deletedBy=");
		sb.append(deletedBy);
		sb.append(", parentFolderId=");
		sb.append(parentFolderId);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", folderName=");
		sb.append(folderName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public projectFolderUpload toEntityModel() {
		projectFolderUploadImpl projectFolderUploadImpl = new projectFolderUploadImpl();

		projectFolderUploadImpl.setPK_projectFolderId(PK_projectFolderId);
		projectFolderUploadImpl.setGroupId(groupId);

		if (createdOn == Long.MIN_VALUE) {
			projectFolderUploadImpl.setCreatedOn(null);
		}
		else {
			projectFolderUploadImpl.setCreatedOn(new Date(createdOn));
		}

		if (deletedOn == Long.MIN_VALUE) {
			projectFolderUploadImpl.setDeletedOn(null);
		}
		else {
			projectFolderUploadImpl.setDeletedOn(new Date(deletedOn));
		}

		projectFolderUploadImpl.setInterestId(interestId);
		projectFolderUploadImpl.setProjectId(projectId);
		projectFolderUploadImpl.setUserId(userId);
		projectFolderUploadImpl.setDeletedBy(deletedBy);
		projectFolderUploadImpl.setParentFolderId(parentFolderId);
		projectFolderUploadImpl.setFolderId(folderId);

		if (folderName == null) {
			projectFolderUploadImpl.setFolderName(StringPool.BLANK);
		}
		else {
			projectFolderUploadImpl.setFolderName(folderName);
		}

		if (description == null) {
			projectFolderUploadImpl.setDescription(StringPool.BLANK);
		}
		else {
			projectFolderUploadImpl.setDescription(description);
		}

		projectFolderUploadImpl.resetOriginalValues();

		return projectFolderUploadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_projectFolderId = objectInput.readLong();

		groupId = objectInput.readLong();
		createdOn = objectInput.readLong();
		deletedOn = objectInput.readLong();

		interestId = objectInput.readLong();

		projectId = objectInput.readLong();

		userId = objectInput.readLong();

		deletedBy = objectInput.readLong();

		parentFolderId = objectInput.readLong();

		folderId = objectInput.readLong();
		folderName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_projectFolderId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createdOn);
		objectOutput.writeLong(deletedOn);

		objectOutput.writeLong(interestId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(deletedBy);

		objectOutput.writeLong(parentFolderId);

		objectOutput.writeLong(folderId);

		if (folderName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(folderName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long PK_projectFolderId;
	public long groupId;
	public long createdOn;
	public long deletedOn;
	public long interestId;
	public long projectId;
	public long userId;
	public long deletedBy;
	public long parentFolderId;
	public long folderId;
	public String folderName;
	public String description;
}