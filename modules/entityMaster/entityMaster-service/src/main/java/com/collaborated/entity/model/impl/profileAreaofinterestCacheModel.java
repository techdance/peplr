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
		StringBundler sb = new StringBundler(31);

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
		sb.append(", discipline=");
		sb.append(discipline);
		sb.append(", language=");
		sb.append(language);
		sb.append(", location=");
		sb.append(location);
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

		if (discipline == null) {
			profileAreaofinterestImpl.setDiscipline(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setDiscipline(discipline);
		}

		if (language == null) {
			profileAreaofinterestImpl.setLanguage(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setLanguage(language);
		}

		if (location == null) {
			profileAreaofinterestImpl.setLocation(StringPool.BLANK);
		}
		else {
			profileAreaofinterestImpl.setLocation(location);
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
		discipline = objectInput.readUTF();
		language = objectInput.readUTF();
		location = objectInput.readUTF();
		campus = objectInput.readUTF();
		programLevel = objectInput.readUTF();
		programLength = objectInput.readUTF();
		deliveryMethod = objectInput.readUTF();
		credits = objectInput.readUTF();
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

		if (discipline == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(discipline);
		}

		if (language == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
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
	}

	public long PK_areaofinterest;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String projectType;
	public String description;
	public String discipline;
	public String language;
	public String location;
	public String campus;
	public String programLevel;
	public String programLength;
	public String deliveryMethod;
	public String credits;
}