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

import com.collaborated.entity.model.communicationPreferences;

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
 * The cache model class for representing communicationPreferences in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see communicationPreferences
 * @generated
 */
@ProviderType
public class communicationPreferencesCacheModel implements CacheModel<communicationPreferences>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof communicationPreferencesCacheModel)) {
			return false;
		}

		communicationPreferencesCacheModel communicationPreferencesCacheModel = (communicationPreferencesCacheModel)obj;

		if (PK_communicationPreferences == communicationPreferencesCacheModel.PK_communicationPreferences) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_communicationPreferences);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{PK_communicationPreferences=");
		sb.append(PK_communicationPreferences);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", primaryLanguageId=");
		sb.append(primaryLanguageId);
		sb.append(", primaryLanguageName=");
		sb.append(primaryLanguageName);
		sb.append(", secondaryLanguageId=");
		sb.append(secondaryLanguageId);
		sb.append(", secondaryLanguageName=");
		sb.append(secondaryLanguageName);
		sb.append(", tertiaryLanguageId=");
		sb.append(tertiaryLanguageId);
		sb.append(", tertiaryLanguageName=");
		sb.append(tertiaryLanguageName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", website=");
		sb.append(website);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public communicationPreferences toEntityModel() {
		communicationPreferencesImpl communicationPreferencesImpl = new communicationPreferencesImpl();

		communicationPreferencesImpl.setPK_communicationPreferences(PK_communicationPreferences);
		communicationPreferencesImpl.setGroupId(groupId);
		communicationPreferencesImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			communicationPreferencesImpl.setCreateDate(null);
		}
		else {
			communicationPreferencesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			communicationPreferencesImpl.setModifiedDate(null);
		}
		else {
			communicationPreferencesImpl.setModifiedDate(new Date(modifiedDate));
		}

		communicationPreferencesImpl.setPrimaryLanguageId(primaryLanguageId);

		if (primaryLanguageName == null) {
			communicationPreferencesImpl.setPrimaryLanguageName(StringPool.BLANK);
		}
		else {
			communicationPreferencesImpl.setPrimaryLanguageName(primaryLanguageName);
		}

		communicationPreferencesImpl.setSecondaryLanguageId(secondaryLanguageId);

		if (secondaryLanguageName == null) {
			communicationPreferencesImpl.setSecondaryLanguageName(StringPool.BLANK);
		}
		else {
			communicationPreferencesImpl.setSecondaryLanguageName(secondaryLanguageName);
		}

		communicationPreferencesImpl.setTertiaryLanguageId(tertiaryLanguageId);

		if (tertiaryLanguageName == null) {
			communicationPreferencesImpl.setTertiaryLanguageName(StringPool.BLANK);
		}
		else {
			communicationPreferencesImpl.setTertiaryLanguageName(tertiaryLanguageName);
		}

		if (emailAddress == null) {
			communicationPreferencesImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			communicationPreferencesImpl.setEmailAddress(emailAddress);
		}

		if (phoneNumber == null) {
			communicationPreferencesImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			communicationPreferencesImpl.setPhoneNumber(phoneNumber);
		}

		if (website == null) {
			communicationPreferencesImpl.setWebsite(StringPool.BLANK);
		}
		else {
			communicationPreferencesImpl.setWebsite(website);
		}

		communicationPreferencesImpl.resetOriginalValues();

		return communicationPreferencesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_communicationPreferences = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		primaryLanguageId = objectInput.readLong();
		primaryLanguageName = objectInput.readUTF();

		secondaryLanguageId = objectInput.readLong();
		secondaryLanguageName = objectInput.readUTF();

		tertiaryLanguageId = objectInput.readLong();
		tertiaryLanguageName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		website = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_communicationPreferences);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(primaryLanguageId);

		if (primaryLanguageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(primaryLanguageName);
		}

		objectOutput.writeLong(secondaryLanguageId);

		if (secondaryLanguageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secondaryLanguageName);
		}

		objectOutput.writeLong(tertiaryLanguageId);

		if (tertiaryLanguageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tertiaryLanguageName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (website == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(website);
		}
	}

	public long PK_communicationPreferences;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long primaryLanguageId;
	public String primaryLanguageName;
	public long secondaryLanguageId;
	public String secondaryLanguageName;
	public long tertiaryLanguageId;
	public String tertiaryLanguageName;
	public String emailAddress;
	public String phoneNumber;
	public String website;
}