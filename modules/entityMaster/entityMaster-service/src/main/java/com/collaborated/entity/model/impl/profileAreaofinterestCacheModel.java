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

import com.collaborated.entity.model.profileAreaofinterest;

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
 * The cache model class for representing profileAreaofinterest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see profileAreaofinterest
 * @generated
 */
@ProviderType
public class profileAreaofinterestCacheModel implements CacheModel<profileAreaofinterest>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof profileAreaofinterestCacheModel)) {
			return false;
		}

		profileAreaofinterestCacheModel profileAreaofinterestCacheModel = (profileAreaofinterestCacheModel)obj;

		if (PK_areaofinterest == profileAreaofinterestCacheModel.PK_areaofinterest) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_areaofinterest);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{PK_areaofinterest=");
		sb.append(PK_areaofinterest);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", projectType=");
		sb.append(projectType);
		sb.append(", description=");
		sb.append(description);
		sb.append(", language=");
		sb.append(language);
		sb.append(", campus=");
		sb.append(campus);
		sb.append(", programLevel=");
		sb.append(programLevel);
		sb.append(", programLength=");
		sb.append(programLength);
		sb.append(", deliveryMethod=");
		sb.append(deliveryMethod);
		sb.append(", credits=");
		sb.append(credits);
		sb.append(", collaborationType=");
		sb.append(collaborationType);
		sb.append(", discipline1=");
		sb.append(discipline1);
		sb.append(", discipline2=");
		sb.append(discipline2);
		sb.append(", discipline3=");
		sb.append(discipline3);
		sb.append(", location1=");
		sb.append(location1);
		sb.append(", location2=");
		sb.append(location2);
		sb.append(", location3=");
		sb.append(location3);
		sb.append(", location4=");
		sb.append(location4);
		sb.append(", rangerYearStart=");
		sb.append(rangerYearStart);
		sb.append(", rangerYearEnd=");
		sb.append(rangerYearEnd);
		sb.append(", rangerMonthStart=");
		sb.append(rangerMonthStart);
		sb.append(", rangerMonthEnd=");
		sb.append(rangerMonthEnd);
		sb.append(", universityName=");
		sb.append(universityName);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public profileAreaofinterest toEntityModel() {
		profileAreaofinterestImpl profileAreaofinterestImpl = new profileAreaofinterestImpl();

		profileAreaofinterestImpl.setPK_areaofinterest(PK_areaofinterest);
		profileAreaofinterestImpl.setGroupId(groupId);
		profileAreaofinterestImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			profileAreaofinterestImpl.setCreateDate(null);
		}
		else {
			profileAreaofinterestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profileAreaofinterestImpl.setModifiedDate(null);
		}
		else {
			profileAreaofinterestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (projectType == null) {
			profileAreaofinterestImpl.setProjectType(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setProjectType(projectType);
		}

		if (description == null) {
			profileAreaofinterestImpl.setDescription(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setDescription(description);
		}

		if (language == null) {
			profileAreaofinterestImpl.setLanguage(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setLanguage(language);
		}

		if (campus == null) {
			profileAreaofinterestImpl.setCampus(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setCampus(campus);
		}

		if (programLevel == null) {
			profileAreaofinterestImpl.setProgramLevel(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setProgramLevel(programLevel);
		}

		if (programLength == null) {
			profileAreaofinterestImpl.setProgramLength(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setProgramLength(programLength);
		}

		if (deliveryMethod == null) {
			profileAreaofinterestImpl.setDeliveryMethod(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setDeliveryMethod(deliveryMethod);
		}

		if (credits == null) {
			profileAreaofinterestImpl.setCredits(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setCredits(credits);
		}

		if (collaborationType == null) {
			profileAreaofinterestImpl.setCollaborationType(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setCollaborationType(collaborationType);
		}

		if (discipline1 == null) {
			profileAreaofinterestImpl.setDiscipline1(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setDiscipline1(discipline1);
		}

		if (discipline2 == null) {
			profileAreaofinterestImpl.setDiscipline2(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setDiscipline2(discipline2);
		}

		if (discipline3 == null) {
			profileAreaofinterestImpl.setDiscipline3(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setDiscipline3(discipline3);
		}

		if (location1 == null) {
			profileAreaofinterestImpl.setLocation1(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setLocation1(location1);
		}

		if (location2 == null) {
			profileAreaofinterestImpl.setLocation2(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setLocation2(location2);
		}

		if (location3 == null) {
			profileAreaofinterestImpl.setLocation3(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setLocation3(location3);
		}

		if (location4 == null) {
			profileAreaofinterestImpl.setLocation4(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setLocation4(location4);
		}

		profileAreaofinterestImpl.setRangerYearStart(rangerYearStart);
		profileAreaofinterestImpl.setRangerYearEnd(rangerYearEnd);

		if (rangerMonthStart == null) {
			profileAreaofinterestImpl.setRangerMonthStart(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setRangerMonthStart(rangerMonthStart);
		}

		if (rangerMonthEnd == null) {
			profileAreaofinterestImpl.setRangerMonthEnd(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setRangerMonthEnd(rangerMonthEnd);
		}

		if (universityName == null) {
			profileAreaofinterestImpl.setUniversityName(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setUniversityName(universityName);
		}

		if (groupName == null) {
			profileAreaofinterestImpl.setGroupName(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setGroupName(groupName);
		}

		profileAreaofinterestImpl.resetOriginalValues();

		return profileAreaofinterestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_areaofinterest = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		projectType = objectInput.readUTF();
		description = objectInput.readUTF();
		language = objectInput.readUTF();
		campus = objectInput.readUTF();
		programLevel = objectInput.readUTF();
		programLength = objectInput.readUTF();
		deliveryMethod = objectInput.readUTF();
		credits = objectInput.readUTF();
		collaborationType = objectInput.readUTF();
		discipline1 = objectInput.readUTF();
		discipline2 = objectInput.readUTF();
		discipline3 = objectInput.readUTF();
		location1 = objectInput.readUTF();
		location2 = objectInput.readUTF();
		location3 = objectInput.readUTF();
		location4 = objectInput.readUTF();

		rangerYearStart = objectInput.readInt();

		rangerYearEnd = objectInput.readInt();
		rangerMonthStart = objectInput.readUTF();
		rangerMonthEnd = objectInput.readUTF();
		universityName = objectInput.readUTF();
		groupName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_areaofinterest);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (projectType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectType);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (language == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (campus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(campus);
		}

		if (programLevel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(programLevel);
		}

		if (programLength == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(programLength);
		}

		if (deliveryMethod == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deliveryMethod);
		}

		if (credits == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(credits);
		}

		if (collaborationType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collaborationType);
		}

		if (discipline1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(discipline1);
		}

		if (discipline2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(discipline2);
		}

		if (discipline3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(discipline3);
		}

		if (location1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location1);
		}

		if (location2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location2);
		}

		if (location3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location3);
		}

		if (location4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location4);
		}

		objectOutput.writeInt(rangerYearStart);

		objectOutput.writeInt(rangerYearEnd);

		if (rangerMonthStart == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rangerMonthStart);
		}

		if (rangerMonthEnd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rangerMonthEnd);
		}

		if (universityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(universityName);
		}

		if (groupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupName);
		}
	}

	public long PK_areaofinterest;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String projectType;
	public String description;
	public String language;
	public String campus;
	public String programLevel;
	public String programLength;
	public String deliveryMethod;
	public String credits;
	public String collaborationType;
	public String discipline1;
	public String discipline2;
	public String discipline3;
	public String location1;
	public String location2;
	public String location3;
	public String location4;
	public int rangerYearStart;
	public int rangerYearEnd;
	public String rangerMonthStart;
	public String rangerMonthEnd;
	public String universityName;
	public String groupName;
}