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

import com.collaborated.entity.model.labDetailedInstructorQualification;

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
 * The cache model class for representing labDetailedInstructorQualification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedInstructorQualification
 * @generated
 */
@ProviderType
public class labDetailedInstructorQualificationCacheModel implements CacheModel<labDetailedInstructorQualification>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedInstructorQualificationCacheModel)) {
			return false;
		}

		labDetailedInstructorQualificationCacheModel labDetailedInstructorQualificationCacheModel =
			(labDetailedInstructorQualificationCacheModel)obj;

		if (PK_courseInstructorQualificationId == labDetailedInstructorQualificationCacheModel.PK_courseInstructorQualificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_courseInstructorQualificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{PK_courseInstructorQualificationId=");
		sb.append(PK_courseInstructorQualificationId);
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
		sb.append(", instructor1Qualification=");
		sb.append(instructor1Qualification);
		sb.append(", instructor2Qualification=");
		sb.append(instructor2Qualification);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labDetailedInstructorQualification toEntityModel() {
		labDetailedInstructorQualificationImpl labDetailedInstructorQualificationImpl =
			new labDetailedInstructorQualificationImpl();

		labDetailedInstructorQualificationImpl.setPK_courseInstructorQualificationId(PK_courseInstructorQualificationId);
		labDetailedInstructorQualificationImpl.setGroupId(groupId);
		labDetailedInstructorQualificationImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labDetailedInstructorQualificationImpl.setCreateDate(null);
		}
		else {
			labDetailedInstructorQualificationImpl.setCreateDate(new Date(
					createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labDetailedInstructorQualificationImpl.setModifiedDate(null);
		}
		else {
			labDetailedInstructorQualificationImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		labDetailedInstructorQualificationImpl.setPK_projectId(PK_projectId);
		labDetailedInstructorQualificationImpl.setPK_courseId(PK_courseId);

		if (instructor1Qualification == null) {
			labDetailedInstructorQualificationImpl.setInstructor1Qualification(StringPool.BLANK);
		}
		else {
			labDetailedInstructorQualificationImpl.setInstructor1Qualification(instructor1Qualification);
		}

		if (instructor2Qualification == null) {
			labDetailedInstructorQualificationImpl.setInstructor2Qualification(StringPool.BLANK);
		}
		else {
			labDetailedInstructorQualificationImpl.setInstructor2Qualification(instructor2Qualification);
		}

		labDetailedInstructorQualificationImpl.resetOriginalValues();

		return labDetailedInstructorQualificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_courseInstructorQualificationId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();

		PK_courseId = objectInput.readLong();
		instructor1Qualification = objectInput.readUTF();
		instructor2Qualification = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_courseInstructorQualificationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		objectOutput.writeLong(PK_courseId);

		if (instructor1Qualification == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(instructor1Qualification);
		}

		if (instructor2Qualification == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(instructor2Qualification);
		}
	}

	public long PK_courseInstructorQualificationId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public long PK_courseId;
	public String instructor1Qualification;
	public String instructor2Qualification;
}