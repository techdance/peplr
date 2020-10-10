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

import com.collaborated.entity.model.labDetailedCourseHours;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing labDetailedCourseHours in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseHours
 * @generated
 */
@ProviderType
public class labDetailedCourseHoursCacheModel implements CacheModel<labDetailedCourseHours>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseHoursCacheModel)) {
			return false;
		}

		labDetailedCourseHoursCacheModel labDetailedCourseHoursCacheModel = (labDetailedCourseHoursCacheModel)obj;

		if (PK_courseHoursId == labDetailedCourseHoursCacheModel.PK_courseHoursId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_courseHoursId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{PK_courseHoursId=");
		sb.append(PK_courseHoursId);
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
		sb.append(", numberOfCredits=");
		sb.append(numberOfCredits);
		sb.append(", numberOfCourseWeeks=");
		sb.append(numberOfCourseWeeks);
		sb.append(", courseHoursPerWeek=");
		sb.append(courseHoursPerWeek);
		sb.append(", lectureHoursPerWeek=");
		sb.append(lectureHoursPerWeek);
		sb.append(", labHoursPerWeek=");
		sb.append(labHoursPerWeek);
		sb.append(", independentStudyHoursPerWeek=");
		sb.append(independentStudyHoursPerWeek);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labDetailedCourseHours toEntityModel() {
		labDetailedCourseHoursImpl labDetailedCourseHoursImpl = new labDetailedCourseHoursImpl();

		labDetailedCourseHoursImpl.setPK_courseHoursId(PK_courseHoursId);
		labDetailedCourseHoursImpl.setGroupId(groupId);
		labDetailedCourseHoursImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labDetailedCourseHoursImpl.setCreateDate(null);
		}
		else {
			labDetailedCourseHoursImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labDetailedCourseHoursImpl.setModifiedDate(null);
		}
		else {
			labDetailedCourseHoursImpl.setModifiedDate(new Date(modifiedDate));
		}

		labDetailedCourseHoursImpl.setPK_projectId(PK_projectId);
		labDetailedCourseHoursImpl.setPK_courseId(PK_courseId);
		labDetailedCourseHoursImpl.setNumberOfCredits(numberOfCredits);
		labDetailedCourseHoursImpl.setNumberOfCourseWeeks(numberOfCourseWeeks);
		labDetailedCourseHoursImpl.setCourseHoursPerWeek(courseHoursPerWeek);
		labDetailedCourseHoursImpl.setLectureHoursPerWeek(lectureHoursPerWeek);
		labDetailedCourseHoursImpl.setLabHoursPerWeek(labHoursPerWeek);
		labDetailedCourseHoursImpl.setIndependentStudyHoursPerWeek(independentStudyHoursPerWeek);

		labDetailedCourseHoursImpl.resetOriginalValues();

		return labDetailedCourseHoursImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_courseHoursId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();

		PK_courseId = objectInput.readLong();

		numberOfCredits = objectInput.readLong();

		numberOfCourseWeeks = objectInput.readLong();

		courseHoursPerWeek = objectInput.readLong();

		lectureHoursPerWeek = objectInput.readLong();

		labHoursPerWeek = objectInput.readLong();

		independentStudyHoursPerWeek = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_courseHoursId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		objectOutput.writeLong(PK_courseId);

		objectOutput.writeLong(numberOfCredits);

		objectOutput.writeLong(numberOfCourseWeeks);

		objectOutput.writeLong(courseHoursPerWeek);

		objectOutput.writeLong(lectureHoursPerWeek);

		objectOutput.writeLong(labHoursPerWeek);

		objectOutput.writeLong(independentStudyHoursPerWeek);
	}

	public long PK_courseHoursId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public long PK_courseId;
	public long numberOfCredits;
	public long numberOfCourseWeeks;
	public long courseHoursPerWeek;
	public long lectureHoursPerWeek;
	public long labHoursPerWeek;
	public long independentStudyHoursPerWeek;
}