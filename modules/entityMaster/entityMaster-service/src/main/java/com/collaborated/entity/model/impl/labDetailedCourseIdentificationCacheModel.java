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

import com.collaborated.entity.model.labDetailedCourseIdentification;

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
 * The cache model class for representing labDetailedCourseIdentification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseIdentification
 * @generated
 */
@ProviderType
public class labDetailedCourseIdentificationCacheModel implements CacheModel<labDetailedCourseIdentification>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseIdentificationCacheModel)) {
			return false;
		}

		labDetailedCourseIdentificationCacheModel labDetailedCourseIdentificationCacheModel =
			(labDetailedCourseIdentificationCacheModel)obj;

		if (PK_courseId == labDetailedCourseIdentificationCacheModel.PK_courseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_courseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{PK_courseId=");
		sb.append(PK_courseId);
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
		sb.append(", courseTitle=");
		sb.append(courseTitle);
		sb.append(", courseNumber=");
		sb.append(courseNumber);
		sb.append(", prerequisites=");
		sb.append(prerequisites);
		sb.append(", courseDescription=");
		sb.append(courseDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labDetailedCourseIdentification toEntityModel() {
		labDetailedCourseIdentificationImpl labDetailedCourseIdentificationImpl = new labDetailedCourseIdentificationImpl();

		labDetailedCourseIdentificationImpl.setPK_courseId(PK_courseId);
		labDetailedCourseIdentificationImpl.setGroupId(groupId);
		labDetailedCourseIdentificationImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labDetailedCourseIdentificationImpl.setCreateDate(null);
		}
		else {
			labDetailedCourseIdentificationImpl.setCreateDate(new Date(
					createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labDetailedCourseIdentificationImpl.setModifiedDate(null);
		}
		else {
			labDetailedCourseIdentificationImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		labDetailedCourseIdentificationImpl.setPK_projectId(PK_projectId);

		if (courseTitle == null) {
			labDetailedCourseIdentificationImpl.setCourseTitle(StringPool.BLANK);
		}
		else {
			labDetailedCourseIdentificationImpl.setCourseTitle(courseTitle);
		}

		if (courseNumber == null) {
			labDetailedCourseIdentificationImpl.setCourseNumber(StringPool.BLANK);
		}
		else {
			labDetailedCourseIdentificationImpl.setCourseNumber(courseNumber);
		}

		if (prerequisites == null) {
			labDetailedCourseIdentificationImpl.setPrerequisites(StringPool.BLANK);
		}
		else {
			labDetailedCourseIdentificationImpl.setPrerequisites(prerequisites);
		}

		if (courseDescription == null) {
			labDetailedCourseIdentificationImpl.setCourseDescription(StringPool.BLANK);
		}
		else {
			labDetailedCourseIdentificationImpl.setCourseDescription(courseDescription);
		}

		labDetailedCourseIdentificationImpl.resetOriginalValues();

		return labDetailedCourseIdentificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_courseId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();
		courseTitle = objectInput.readUTF();
		courseNumber = objectInput.readUTF();
		prerequisites = objectInput.readUTF();
		courseDescription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_courseId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		if (courseTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseTitle);
		}

		if (courseNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseNumber);
		}

		if (prerequisites == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prerequisites);
		}

		if (courseDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseDescription);
		}
	}

	public long PK_courseId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public String courseTitle;
	public String courseNumber;
	public String prerequisites;
	public String courseDescription;
}