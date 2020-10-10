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

import com.collaborated.entity.model.labDetailedCourseObjectives;

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
 * The cache model class for representing labDetailedCourseObjectives in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseObjectives
 * @generated
 */
@ProviderType
public class labDetailedCourseObjectivesCacheModel implements CacheModel<labDetailedCourseObjectives>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseObjectivesCacheModel)) {
			return false;
		}

		labDetailedCourseObjectivesCacheModel labDetailedCourseObjectivesCacheModel =
			(labDetailedCourseObjectivesCacheModel)obj;

		if (PK_courseObjectivesId == labDetailedCourseObjectivesCacheModel.PK_courseObjectivesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_courseObjectivesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{PK_courseObjectivesId=");
		sb.append(PK_courseObjectivesId);
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
		sb.append(", courseObjective=");
		sb.append(courseObjective);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labDetailedCourseObjectives toEntityModel() {
		labDetailedCourseObjectivesImpl labDetailedCourseObjectivesImpl = new labDetailedCourseObjectivesImpl();

		labDetailedCourseObjectivesImpl.setPK_courseObjectivesId(PK_courseObjectivesId);
		labDetailedCourseObjectivesImpl.setGroupId(groupId);
		labDetailedCourseObjectivesImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labDetailedCourseObjectivesImpl.setCreateDate(null);
		}
		else {
			labDetailedCourseObjectivesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labDetailedCourseObjectivesImpl.setModifiedDate(null);
		}
		else {
			labDetailedCourseObjectivesImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		labDetailedCourseObjectivesImpl.setPK_projectId(PK_projectId);
		labDetailedCourseObjectivesImpl.setPK_courseId(PK_courseId);

		if (courseObjective == null) {
			labDetailedCourseObjectivesImpl.setCourseObjective(StringPool.BLANK);
		}
		else {
			labDetailedCourseObjectivesImpl.setCourseObjective(courseObjective);
		}

		labDetailedCourseObjectivesImpl.resetOriginalValues();

		return labDetailedCourseObjectivesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_courseObjectivesId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();

		PK_courseId = objectInput.readLong();
		courseObjective = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_courseObjectivesId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		objectOutput.writeLong(PK_courseId);

		if (courseObjective == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseObjective);
		}
	}

	public long PK_courseObjectivesId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public long PK_courseId;
	public String courseObjective;
}