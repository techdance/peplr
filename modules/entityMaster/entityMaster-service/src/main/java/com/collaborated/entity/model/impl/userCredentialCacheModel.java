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

import com.collaborated.entity.model.userCredential;

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
 * The cache model class for representing userCredential in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see userCredential
 * @generated
 */
@ProviderType
public class userCredentialCacheModel implements CacheModel<userCredential>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof userCredentialCacheModel)) {
			return false;
		}

		userCredentialCacheModel userCredentialCacheModel = (userCredentialCacheModel)obj;

		if (PK_userCredential == userCredentialCacheModel.PK_userCredential) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_userCredential);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{PK_userCredential=");
		sb.append(PK_userCredential);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", membership1=");
		sb.append(membership1);
		sb.append(", membership2=");
		sb.append(membership2);
		sb.append(", membership3=");
		sb.append(membership3);
		sb.append(", membership4=");
		sb.append(membership4);
		sb.append(", certificate1=");
		sb.append(certificate1);
		sb.append(", certificate2=");
		sb.append(certificate2);
		sb.append(", certificate3=");
		sb.append(certificate3);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public userCredential toEntityModel() {
		userCredentialImpl userCredentialImpl = new userCredentialImpl();

		userCredentialImpl.setPK_userCredential(PK_userCredential);
		userCredentialImpl.setGroupId(groupId);
		userCredentialImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			userCredentialImpl.setCreateDate(null);
		}
		else {
			userCredentialImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userCredentialImpl.setModifiedDate(null);
		}
		else {
			userCredentialImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (membership1 == null) {
			userCredentialImpl.setMembership1(StringPool.BLANK);
		}
		else {
			userCredentialImpl.setMembership1(membership1);
		}

		if (membership2 == null) {
			userCredentialImpl.setMembership2(StringPool.BLANK);
		}
		else {
			userCredentialImpl.setMembership2(membership2);
		}

		if (membership3 == null) {
			userCredentialImpl.setMembership3(StringPool.BLANK);
		}
		else {
			userCredentialImpl.setMembership3(membership3);
		}

		if (membership4 == null) {
			userCredentialImpl.setMembership4(StringPool.BLANK);
		}
		else {
			userCredentialImpl.setMembership4(membership4);
		}

		if (certificate1 == null) {
			userCredentialImpl.setCertificate1(StringPool.BLANK);
		}
		else {
			userCredentialImpl.setCertificate1(certificate1);
		}

		if (certificate2 == null) {
			userCredentialImpl.setCertificate2(StringPool.BLANK);
		}
		else {
			userCredentialImpl.setCertificate2(certificate2);
		}

		if (certificate3 == null) {
			userCredentialImpl.setCertificate3(StringPool.BLANK);
		}
		else {
			userCredentialImpl.setCertificate3(certificate3);
		}

		userCredentialImpl.resetOriginalValues();

		return userCredentialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_userCredential = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		membership1 = objectInput.readUTF();
		membership2 = objectInput.readUTF();
		membership3 = objectInput.readUTF();
		membership4 = objectInput.readUTF();
		certificate1 = objectInput.readUTF();
		certificate2 = objectInput.readUTF();
		certificate3 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_userCredential);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (membership1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(membership1);
		}

		if (membership2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(membership2);
		}

		if (membership3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(membership3);
		}

		if (membership4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(membership4);
		}

		if (certificate1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificate1);
		}

		if (certificate2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificate2);
		}

		if (certificate3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificate3);
		}
	}

	public long PK_userCredential;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String membership1;
	public String membership2;
	public String membership3;
	public String membership4;
	public String certificate1;
	public String certificate2;
	public String certificate3;
}