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

import com.collaborated.entity.model.applicationLog;

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
 * The cache model class for representing applicationLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see applicationLog
 * @generated
 */
@ProviderType
public class applicationLogCacheModel implements CacheModel<applicationLog>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof applicationLogCacheModel)) {
			return false;
		}

		applicationLogCacheModel applicationLogCacheModel = (applicationLogCacheModel)obj;

		if (PK_logId == applicationLogCacheModel.PK_logId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_logId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{PK_logId=");
		sb.append(PK_logId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", pageName=");
		sb.append(pageName);
		sb.append(", moduleName=");
		sb.append(moduleName);
		sb.append(", buttonName=");
		sb.append(buttonName);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", interestId=");
		sb.append(interestId);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public applicationLog toEntityModel() {
		applicationLogImpl applicationLogImpl = new applicationLogImpl();

		applicationLogImpl.setPK_logId(PK_logId);
		applicationLogImpl.setUserId(userId);

		if (userName == null) {
			applicationLogImpl.setUserName(StringPool.BLANK);
		}
		else {
			applicationLogImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationLogImpl.setCreateDate(null);
		}
		else {
			applicationLogImpl.setCreateDate(new Date(createDate));
		}

		if (pageName == null) {
			applicationLogImpl.setPageName(StringPool.BLANK);
		}
		else {
			applicationLogImpl.setPageName(pageName);
		}

		if (moduleName == null) {
			applicationLogImpl.setModuleName(StringPool.BLANK);
		}
		else {
			applicationLogImpl.setModuleName(moduleName);
		}

		if (buttonName == null) {
			applicationLogImpl.setButtonName(StringPool.BLANK);
		}
		else {
			applicationLogImpl.setButtonName(buttonName);
		}

		applicationLogImpl.setProjectId(projectId);
		applicationLogImpl.setInterestId(interestId);

		if (comments == null) {
			applicationLogImpl.setComments(StringPool.BLANK);
		}
		else {
			applicationLogImpl.setComments(comments);
		}

		applicationLogImpl.resetOriginalValues();

		return applicationLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_logId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		pageName = objectInput.readUTF();
		moduleName = objectInput.readUTF();
		buttonName = objectInput.readUTF();

		projectId = objectInput.readLong();

		interestId = objectInput.readLong();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_logId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		if (pageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pageName);
		}

		if (moduleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleName);
		}

		if (buttonName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(buttonName);
		}

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(interestId);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public long PK_logId;
	public long userId;
	public String userName;
	public long createDate;
	public String pageName;
	public String moduleName;
	public String buttonName;
	public long projectId;
	public long interestId;
	public String comments;
}