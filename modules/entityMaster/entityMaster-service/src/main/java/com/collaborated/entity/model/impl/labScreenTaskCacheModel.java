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

import com.collaborated.entity.model.labScreenTask;

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
 * The cache model class for representing labScreenTask in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labScreenTask
 * @generated
 */
@ProviderType
public class labScreenTaskCacheModel implements CacheModel<labScreenTask>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labScreenTaskCacheModel)) {
			return false;
		}

		labScreenTaskCacheModel labScreenTaskCacheModel = (labScreenTaskCacheModel)obj;

		if (PK_taskId == labScreenTaskCacheModel.PK_taskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_taskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{PK_taskId=");
		sb.append(PK_taskId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", PK_projectId=");
		sb.append(PK_projectId);
		sb.append(", milestoneName=");
		sb.append(milestoneName);
		sb.append(", taskName=");
		sb.append(taskName);
		sb.append(", projectAssignedTo=");
		sb.append(projectAssignedTo);
		sb.append(", taskDescription=");
		sb.append(taskDescription);
		sb.append(", taskStatus=");
		sb.append(taskStatus);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labScreenTask toEntityModel() {
		labScreenTaskImpl labScreenTaskImpl = new labScreenTaskImpl();

		labScreenTaskImpl.setPK_taskId(PK_taskId);
		labScreenTaskImpl.setGroupId(groupId);
		labScreenTaskImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labScreenTaskImpl.setCreateDate(null);
		}
		else {
			labScreenTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labScreenTaskImpl.setModifiedDate(null);
		}
		else {
			labScreenTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		labScreenTaskImpl.setPK_projectId(PK_projectId);

		if (milestoneName == null) {
			labScreenTaskImpl.setMilestoneName(StringPool.BLANK);
		}
		else {
			labScreenTaskImpl.setMilestoneName(milestoneName);
		}

		if (taskName == null) {
			labScreenTaskImpl.setTaskName(StringPool.BLANK);
		}
		else {
			labScreenTaskImpl.setTaskName(taskName);
		}

		labScreenTaskImpl.setProjectAssignedTo(projectAssignedTo);

		if (taskDescription == null) {
			labScreenTaskImpl.setTaskDescription(StringPool.BLANK);
		}
		else {
			labScreenTaskImpl.setTaskDescription(taskDescription);
		}

		if (taskStatus == null) {
			labScreenTaskImpl.setTaskStatus(StringPool.BLANK);
		}
		else {
			labScreenTaskImpl.setTaskStatus(taskStatus);
		}

		if (dueDate == null) {
			labScreenTaskImpl.setDueDate(StringPool.BLANK);
		}
		else {
			labScreenTaskImpl.setDueDate(dueDate);
		}

		labScreenTaskImpl.resetOriginalValues();

		return labScreenTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_taskId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();
		milestoneName = objectInput.readUTF();
		taskName = objectInput.readUTF();

		projectAssignedTo = objectInput.readLong();
		taskDescription = objectInput.readUTF();
		taskStatus = objectInput.readUTF();
		dueDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_taskId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		if (milestoneName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(milestoneName);
		}

		if (taskName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taskName);
		}

		objectOutput.writeLong(projectAssignedTo);

		if (taskDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taskDescription);
		}

		if (taskStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taskStatus);
		}

		if (dueDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dueDate);
		}
	}

	public long PK_taskId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public String milestoneName;
	public String taskName;
	public long projectAssignedTo;
	public String taskDescription;
	public String taskStatus;
	public String dueDate;
}