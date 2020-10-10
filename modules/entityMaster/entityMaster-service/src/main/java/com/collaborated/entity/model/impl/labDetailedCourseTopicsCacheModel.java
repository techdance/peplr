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

import com.collaborated.entity.model.labDetailedCourseTopics;

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
 * The cache model class for representing labDetailedCourseTopics in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseTopics
 * @generated
 */
@ProviderType
public class labDetailedCourseTopicsCacheModel implements CacheModel<labDetailedCourseTopics>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseTopicsCacheModel)) {
			return false;
		}

		labDetailedCourseTopicsCacheModel labDetailedCourseTopicsCacheModel = (labDetailedCourseTopicsCacheModel)obj;

		if (PK_courseTopicsId == labDetailedCourseTopicsCacheModel.PK_courseTopicsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_courseTopicsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{PK_courseTopicsId=");
		sb.append(PK_courseTopicsId);
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
		sb.append(", courseTopic=");
		sb.append(courseTopic);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labDetailedCourseTopics toEntityModel() {
		labDetailedCourseTopicsImpl labDetailedCourseTopicsImpl = new labDetailedCourseTopicsImpl();

		labDetailedCourseTopicsImpl.setPK_courseTopicsId(PK_courseTopicsId);
		labDetailedCourseTopicsImpl.setGroupId(groupId);
		labDetailedCourseTopicsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labDetailedCourseTopicsImpl.setCreateDate(null);
		}
		else {
			labDetailedCourseTopicsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labDetailedCourseTopicsImpl.setModifiedDate(null);
		}
		else {
			labDetailedCourseTopicsImpl.setModifiedDate(new Date(modifiedDate));
		}

		labDetailedCourseTopicsImpl.setPK_projectId(PK_projectId);
		labDetailedCourseTopicsImpl.setPK_courseId(PK_courseId);

		if (courseTopic == null) {
			labDetailedCourseTopicsImpl.setCourseTopic(StringPool.BLANK);
		}
		else {
			labDetailedCourseTopicsImpl.setCourseTopic(courseTopic);
		}

		labDetailedCourseTopicsImpl.resetOriginalValues();

		return labDetailedCourseTopicsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_courseTopicsId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();

		PK_courseId = objectInput.readLong();
		courseTopic = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_courseTopicsId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		objectOutput.writeLong(PK_courseId);

		if (courseTopic == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseTopic);
		}
	}

	public long PK_courseTopicsId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public long PK_courseId;
	public String courseTopic;
}