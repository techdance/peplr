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

import com.collaborated.entity.model.projectFilesUpload;

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
 * The cache model class for representing projectFilesUpload in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see projectFilesUpload
 * @generated
 */
@ProviderType
public class projectFilesUploadCacheModel implements CacheModel<projectFilesUpload>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof projectFilesUploadCacheModel)) {
			return false;
		}

		projectFilesUploadCacheModel projectFilesUploadCacheModel = (projectFilesUploadCacheModel)obj;

		if (PK_projectFileId == projectFilesUploadCacheModel.PK_projectFileId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_projectFileId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{PK_projectFileId=");
		sb.append(PK_projectFileId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdOn=");
		sb.append(createdOn);
		sb.append(", deletedOn=");
		sb.append(deletedOn);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", deletedBy=");
		sb.append(deletedBy);
		sb.append(", PK_projectFolderId=");
		sb.append(PK_projectFolderId);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public projectFilesUpload toEntityModel() {
		projectFilesUploadImpl projectFilesUploadImpl = new projectFilesUploadImpl();

		projectFilesUploadImpl.setPK_projectFileId(PK_projectFileId);
		projectFilesUploadImpl.setGroupId(groupId);

		if (createdOn == Long.MIN_VALUE) {
			projectFilesUploadImpl.setCreatedOn(null);
		}
		else {
			projectFilesUploadImpl.setCreatedOn(new Date(createdOn));
		}

		if (deletedOn == Long.MIN_VALUE) {
			projectFilesUploadImpl.setDeletedOn(null);
		}
		else {
			projectFilesUploadImpl.setDeletedOn(new Date(deletedOn));
		}

		projectFilesUploadImpl.setUserId(userId);
		projectFilesUploadImpl.setDeletedBy(deletedBy);
		projectFilesUploadImpl.setPK_projectFolderId(PK_projectFolderId);

		if (fileName == null) {
			projectFilesUploadImpl.setFileName(StringPool.BLANK);
		}
		else {
			projectFilesUploadImpl.setFileName(fileName);
		}

		if (fileEntryId == null) {
			projectFilesUploadImpl.setFileEntryId(StringPool.BLANK);
		}
		else {
			projectFilesUploadImpl.setFileEntryId(fileEntryId);
		}

		if (description == null) {
			projectFilesUploadImpl.setDescription(StringPool.BLANK);
		}
		else {
			projectFilesUploadImpl.setDescription(description);
		}

		projectFilesUploadImpl.resetOriginalValues();

		return projectFilesUploadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_projectFileId = objectInput.readLong();

		groupId = objectInput.readLong();
		createdOn = objectInput.readLong();
		deletedOn = objectInput.readLong();

		userId = objectInput.readLong();

		deletedBy = objectInput.readLong();

		PK_projectFolderId = objectInput.readLong();
		fileName = objectInput.readUTF();
		fileEntryId = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_projectFileId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createdOn);
		objectOutput.writeLong(deletedOn);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(deletedBy);

		objectOutput.writeLong(PK_projectFolderId);

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (fileEntryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryId);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long PK_projectFileId;
	public long groupId;
	public long createdOn;
	public long deletedOn;
	public long userId;
	public long deletedBy;
	public long PK_projectFolderId;
	public String fileName;
	public String fileEntryId;
	public String description;
}