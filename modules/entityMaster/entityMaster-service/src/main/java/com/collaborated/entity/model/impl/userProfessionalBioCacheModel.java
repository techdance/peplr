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

import com.collaborated.entity.model.userProfessionalBio;

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
 * The cache model class for representing userProfessionalBio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see userProfessionalBio
 * @generated
 */
@ProviderType
public class userProfessionalBioCacheModel implements CacheModel<userProfessionalBio>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userProfessionalBioCacheModel)) {
			return false;
		}

		userProfessionalBioCacheModel userProfessionalBioCacheModel = (userProfessionalBioCacheModel)obj;

		if (PK_userProfessionalBio == userProfessionalBioCacheModel.PK_userProfessionalBio) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_userProfessionalBio);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{PK_userProfessionalBio=");
		sb.append(PK_userProfessionalBio);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", areaofexpertise1=");
		sb.append(areaofexpertise1);
		sb.append(", areaofexpertise2=");
		sb.append(areaofexpertise2);
		sb.append(", areaofexpertise3=");
		sb.append(areaofexpertise3);
		sb.append(", experienceyears=");
		sb.append(experienceyears);
		sb.append(", cvlink=");
		sb.append(cvlink);
		sb.append(", biodescription=");
		sb.append(biodescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public userProfessionalBio toEntityModel() {
		userProfessionalBioImpl userProfessionalBioImpl = new userProfessionalBioImpl();

		userProfessionalBioImpl.setPK_userProfessionalBio(PK_userProfessionalBio);
		userProfessionalBioImpl.setGroupId(groupId);
		userProfessionalBioImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			userProfessionalBioImpl.setCreateDate(null);
		}
		else {
			userProfessionalBioImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userProfessionalBioImpl.setModifiedDate(null);
		}
		else {
			userProfessionalBioImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (areaofexpertise1 == null) {
			userProfessionalBioImpl.setAreaofexpertise1(StringPool.BLANK);
		}
		else {
			userProfessionalBioImpl.setAreaofexpertise1(areaofexpertise1);
		}

		if (areaofexpertise2 == null) {
			userProfessionalBioImpl.setAreaofexpertise2(StringPool.BLANK);
		}
		else {
			userProfessionalBioImpl.setAreaofexpertise2(areaofexpertise2);
		}

		if (areaofexpertise3 == null) {
			userProfessionalBioImpl.setAreaofexpertise3(StringPool.BLANK);
		}
		else {
			userProfessionalBioImpl.setAreaofexpertise3(areaofexpertise3);
		}

		if (experienceyears == null) {
			userProfessionalBioImpl.setExperienceyears(StringPool.BLANK);
		}
		else {
			userProfessionalBioImpl.setExperienceyears(experienceyears);
		}

		if (cvlink == null) {
			userProfessionalBioImpl.setCvlink(StringPool.BLANK);
		}
		else {
			userProfessionalBioImpl.setCvlink(cvlink);
		}

		if (biodescription == null) {
			userProfessionalBioImpl.setBiodescription(StringPool.BLANK);
		}
		else {
			userProfessionalBioImpl.setBiodescription(biodescription);
		}

		userProfessionalBioImpl.resetOriginalValues();

		return userProfessionalBioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_userProfessionalBio = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		areaofexpertise1 = objectInput.readUTF();
		areaofexpertise2 = objectInput.readUTF();
		areaofexpertise3 = objectInput.readUTF();
		experienceyears = objectInput.readUTF();
		cvlink = objectInput.readUTF();
		biodescription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_userProfessionalBio);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (areaofexpertise1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(areaofexpertise1);
		}

		if (areaofexpertise2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(areaofexpertise2);
		}

		if (areaofexpertise3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(areaofexpertise3);
		}

		if (experienceyears == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(experienceyears);
		}

		if (cvlink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cvlink);
		}

		if (biodescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biodescription);
		}
	}

	public long PK_userProfessionalBio;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String areaofexpertise1;
	public String areaofexpertise2;
	public String areaofexpertise3;
	public String experienceyears;
	public String cvlink;
	public String biodescription;
}