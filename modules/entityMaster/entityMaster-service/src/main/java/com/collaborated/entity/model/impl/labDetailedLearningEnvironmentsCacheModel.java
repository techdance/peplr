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

import com.collaborated.entity.model.labDetailedLearningEnvironments;

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
 * The cache model class for representing labDetailedLearningEnvironments in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedLearningEnvironments
 * @generated
 */
@ProviderType
public class labDetailedLearningEnvironmentsCacheModel implements CacheModel<labDetailedLearningEnvironments>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedLearningEnvironmentsCacheModel)) {
			return false;
		}

		labDetailedLearningEnvironmentsCacheModel labDetailedLearningEnvironmentsCacheModel =
			(labDetailedLearningEnvironmentsCacheModel)obj;

		if (PK_learningEnvironmentId == labDetailedLearningEnvironmentsCacheModel.PK_learningEnvironmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_learningEnvironmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{PK_learningEnvironmentId=");
		sb.append(PK_learningEnvironmentId);
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
		sb.append(", PK_courseId=");
		sb.append(PK_courseId);
		sb.append(", learningEnvironment=");
		sb.append(learningEnvironment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labDetailedLearningEnvironments toEntityModel() {
		labDetailedLearningEnvironmentsImpl labDetailedLearningEnvironmentsImpl = new labDetailedLearningEnvironmentsImpl();

		labDetailedLearningEnvironmentsImpl.setPK_learningEnvironmentId(PK_learningEnvironmentId);
		labDetailedLearningEnvironmentsImpl.setGroupId(groupId);
		labDetailedLearningEnvironmentsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labDetailedLearningEnvironmentsImpl.setCreateDate(null);
		}
		else {
			labDetailedLearningEnvironmentsImpl.setCreateDate(new Date(
					createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labDetailedLearningEnvironmentsImpl.setModifiedDate(null);
		}
		else {
			labDetailedLearningEnvironmentsImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		labDetailedLearningEnvironmentsImpl.setPK_projectId(PK_projectId);
		labDetailedLearningEnvironmentsImpl.setPK_courseId(PK_courseId);

		if (learningEnvironment == null) {
			labDetailedLearningEnvironmentsImpl.setLearningEnvironment(StringPool.BLANK);
		}
		else {
			labDetailedLearningEnvironmentsImpl.setLearningEnvironment(learningEnvironment);
		}

		labDetailedLearningEnvironmentsImpl.resetOriginalValues();

		return labDetailedLearningEnvironmentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_learningEnvironmentId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();

		PK_courseId = objectInput.readLong();
		learningEnvironment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_learningEnvironmentId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		objectOutput.writeLong(PK_courseId);

		if (learningEnvironment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(learningEnvironment);
		}
	}

	public long PK_learningEnvironmentId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public long PK_courseId;
	public String learningEnvironment;
}