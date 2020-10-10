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

import com.collaborated.entity.model.labDetailedActivityTable;

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
 * The cache model class for representing labDetailedActivityTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedActivityTable
 * @generated
 */
@ProviderType
public class labDetailedActivityTableCacheModel implements CacheModel<labDetailedActivityTable>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedActivityTableCacheModel)) {
			return false;
		}

		labDetailedActivityTableCacheModel labDetailedActivityTableCacheModel = (labDetailedActivityTableCacheModel)obj;

		if (PK_activityTableId == labDetailedActivityTableCacheModel.PK_activityTableId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_activityTableId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{PK_activityTableId=");
		sb.append(PK_activityTableId);
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
		sb.append(", week=");
		sb.append(week);
		sb.append(", courseObjective=");
		sb.append(courseObjective);
		sb.append(", learningEnvironmentDesign=");
		sb.append(learningEnvironmentDesign);
		sb.append(", activity=");
		sb.append(activity);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labDetailedActivityTable toEntityModel() {
		labDetailedActivityTableImpl labDetailedActivityTableImpl = new labDetailedActivityTableImpl();

		labDetailedActivityTableImpl.setPK_activityTableId(PK_activityTableId);
		labDetailedActivityTableImpl.setGroupId(groupId);
		labDetailedActivityTableImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labDetailedActivityTableImpl.setCreateDate(null);
		}
		else {
			labDetailedActivityTableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labDetailedActivityTableImpl.setModifiedDate(null);
		}
		else {
			labDetailedActivityTableImpl.setModifiedDate(new Date(modifiedDate));
		}

		labDetailedActivityTableImpl.setPK_projectId(PK_projectId);
		labDetailedActivityTableImpl.setPK_courseId(PK_courseId);
		labDetailedActivityTableImpl.setWeek(week);

		if (courseObjective == null) {
			labDetailedActivityTableImpl.setCourseObjective(StringPool.BLANK);
		}
		else {
			labDetailedActivityTableImpl.setCourseObjective(courseObjective);
		}

		if (learningEnvironmentDesign == null) {
			labDetailedActivityTableImpl.setLearningEnvironmentDesign(StringPool.BLANK);
		}
		else {
			labDetailedActivityTableImpl.setLearningEnvironmentDesign(learningEnvironmentDesign);
		}

		if (activity == null) {
			labDetailedActivityTableImpl.setActivity(StringPool.BLANK);
		}
		else {
			labDetailedActivityTableImpl.setActivity(activity);
		}

		if (content == null) {
			labDetailedActivityTableImpl.setContent(StringPool.BLANK);
		}
		else {
			labDetailedActivityTableImpl.setContent(content);
		}

		labDetailedActivityTableImpl.resetOriginalValues();

		return labDetailedActivityTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_activityTableId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();

		PK_courseId = objectInput.readLong();

		week = objectInput.readLong();
		courseObjective = objectInput.readUTF();
		learningEnvironmentDesign = objectInput.readUTF();
		activity = objectInput.readUTF();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_activityTableId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		objectOutput.writeLong(PK_courseId);

		objectOutput.writeLong(week);

		if (courseObjective == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseObjective);
		}

		if (learningEnvironmentDesign == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(learningEnvironmentDesign);
		}

		if (activity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activity);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public long PK_activityTableId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public long PK_courseId;
	public long week;
	public String courseObjective;
	public String learningEnvironmentDesign;
	public String activity;
	public String content;
}