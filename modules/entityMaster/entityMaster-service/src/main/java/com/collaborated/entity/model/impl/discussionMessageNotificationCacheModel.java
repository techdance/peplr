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

import com.collaborated.entity.model.discussionMessageNotification;

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
 * The cache model class for representing discussionMessageNotification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see discussionMessageNotification
 * @generated
 */
@ProviderType
public class discussionMessageNotificationCacheModel implements CacheModel<discussionMessageNotification>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof discussionMessageNotificationCacheModel)) {
			return false;
		}

		discussionMessageNotificationCacheModel discussionMessageNotificationCacheModel =
			(discussionMessageNotificationCacheModel)obj;

		if (PK_discussionNotificationId == discussionMessageNotificationCacheModel.PK_discussionNotificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_discussionNotificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{PK_discussionNotificationId=");
		sb.append(PK_discussionNotificationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", PK_projectDiscussionId=");
		sb.append(PK_projectDiscussionId);
		sb.append(", messageFrom=");
		sb.append(messageFrom);
		sb.append(", messageTo=");
		sb.append(messageTo);
		sb.append(", isRead=");
		sb.append(isRead);
		sb.append(", isRemoved=");
		sb.append(isRemoved);
		sb.append(", messageTitle=");
		sb.append(messageTitle);
		sb.append(", messageContent=");
		sb.append(messageContent);
		sb.append(", emailContent=");
		sb.append(emailContent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public discussionMessageNotification toEntityModel() {
		discussionMessageNotificationImpl discussionMessageNotificationImpl = new discussionMessageNotificationImpl();

		discussionMessageNotificationImpl.setPK_discussionNotificationId(PK_discussionNotificationId);
		discussionMessageNotificationImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			discussionMessageNotificationImpl.setCreateDate(null);
		}
		else {
			discussionMessageNotificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			discussionMessageNotificationImpl.setModifiedDate(null);
		}
		else {
			discussionMessageNotificationImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		discussionMessageNotificationImpl.setPK_projectDiscussionId(PK_projectDiscussionId);
		discussionMessageNotificationImpl.setMessageFrom(messageFrom);
		discussionMessageNotificationImpl.setMessageTo(messageTo);
		discussionMessageNotificationImpl.setIsRead(isRead);
		discussionMessageNotificationImpl.setIsRemoved(isRemoved);

		if (messageTitle == null) {
			discussionMessageNotificationImpl.setMessageTitle(StringPool.BLANK);
		}
		else {
			discussionMessageNotificationImpl.setMessageTitle(messageTitle);
		}

		if (messageContent == null) {
			discussionMessageNotificationImpl.setMessageContent(StringPool.BLANK);
		}
		else {
			discussionMessageNotificationImpl.setMessageContent(messageContent);
		}

		if (emailContent == null) {
			discussionMessageNotificationImpl.setEmailContent(StringPool.BLANK);
		}
		else {
			discussionMessageNotificationImpl.setEmailContent(emailContent);
		}

		discussionMessageNotificationImpl.resetOriginalValues();

		return discussionMessageNotificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_discussionNotificationId = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectDiscussionId = objectInput.readLong();

		messageFrom = objectInput.readLong();

		messageTo = objectInput.readLong();

		isRead = objectInput.readLong();

		isRemoved = objectInput.readLong();
		messageTitle = objectInput.readUTF();
		messageContent = objectInput.readUTF();
		emailContent = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_discussionNotificationId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectDiscussionId);

		objectOutput.writeLong(messageFrom);

		objectOutput.writeLong(messageTo);

		objectOutput.writeLong(isRead);

		objectOutput.writeLong(isRemoved);

		if (messageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageTitle);
		}

		if (messageContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageContent);
		}

		if (emailContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailContent);
		}
	}

	public long PK_discussionNotificationId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectDiscussionId;
	public long messageFrom;
	public long messageTo;
	public long isRead;
	public long isRemoved;
	public String messageTitle;
	public String messageContent;
	public String emailContent;
}