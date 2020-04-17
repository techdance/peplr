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

import com.collaborated.entity.model.languagePreferences;

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
 * The cache model class for representing languagePreferences in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see languagePreferences
 * @generated
 */
@ProviderType
public class languagePreferencesCacheModel implements CacheModel<languagePreferences>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof languagePreferencesCacheModel)) {
			return false;
		}

		languagePreferencesCacheModel languagePreferencesCacheModel = (languagePreferencesCacheModel)obj;

		if (PK_languagePreferences == languagePreferencesCacheModel.PK_languagePreferences) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_languagePreferences);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{PK_languagePreferences=");
		sb.append(PK_languagePreferences);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", languageName=");
		sb.append(languageName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public languagePreferences toEntityModel() {
		languagePreferencesImpl languagePreferencesImpl = new languagePreferencesImpl();

		languagePreferencesImpl.setPK_languagePreferences(PK_languagePreferences);
		languagePreferencesImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			languagePreferencesImpl.setCreateDate(null);
		}
		else {
			languagePreferencesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			languagePreferencesImpl.setModifiedDate(null);
		}
		else {
			languagePreferencesImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (languageName == null) {
			languagePreferencesImpl.setLanguageName(StringPool.BLANK);
		}
		else {
			languagePreferencesImpl.setLanguageName(languageName);
		}

		languagePreferencesImpl.resetOriginalValues();

		return languagePreferencesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_languagePreferences = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		languageName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_languagePreferences);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (languageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageName);
		}
	}

	public long PK_languagePreferences;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String languageName;
}