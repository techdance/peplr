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

import com.collaborated.entity.model.projectInviteTracking;

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
 * The cache model class for representing projectInviteTracking in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see projectInviteTracking
 * @generated
 */
@ProviderType
public class projectInviteTrackingCacheModel implements CacheModel<projectInviteTracking>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof projectInviteTrackingCacheModel)) {
			return false;
		}

		projectInviteTrackingCacheModel projectInviteTrackingCacheModel = (projectInviteTrackingCacheModel)obj;

		if (PK_projectInvitationId == projectInviteTrackingCacheModel.PK_projectInvitationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_projectInvitationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{PK_projectInvitationId=");
		sb.append(PK_projectInvitationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", inviteFrom=");
		sb.append(inviteFrom);
		sb.append(", inviteTo=");
		sb.append(inviteTo);
		sb.append(", invitationStatus=");
		sb.append(invitationStatus);
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
	public projectInviteTracking toEntityModel() {
		projectInviteTrackingImpl projectInviteTrackingImpl = new projectInviteTrackingImpl();

		projectInviteTrackingImpl.setPK_projectInvitationId(PK_projectInvitationId);
		projectInviteTrackingImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			projectInviteTrackingImpl.setCreateDate(null);
		}
		else {
			projectInviteTrackingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectInviteTrackingImpl.setModifiedDate(null);
		}
		else {
			projectInviteTrackingImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectInviteTrackingImpl.setProjectId(projectId);
		projectInviteTrackingImpl.setInviteFrom(inviteFrom);
		projectInviteTrackingImpl.setInviteTo(inviteTo);

		if (invitationStatus == null) {
			projectInviteTrackingImpl.setInvitationStatus(StringPool.BLANK);
		}
		else {
			projectInviteTrackingImpl.setInvitationStatus(invitationStatus);
		}

		projectInviteTrackingImpl.setIsRead(isRead);
		projectInviteTrackingImpl.setIsRemoved(isRemoved);

		if (messageTitle == null) {
			projectInviteTrackingImpl.setMessageTitle(StringPool.BLANK);
		}
		else {
			projectInviteTrackingImpl.setMessageTitle(messageTitle);
		}

		if (messageContent == null) {
			projectInviteTrackingImpl.setMessageContent(StringPool.BLANK);
		}
		else {
			projectInviteTrackingImpl.setMessageContent(messageContent);
		}

		if (emailContent == null) {
			projectInviteTrackingImpl.setEmailContent(StringPool.BLANK);
		}
		else {
			projectInviteTrackingImpl.setEmailContent(emailContent);
		}

		projectInviteTrackingImpl.resetOriginalValues();

		return projectInviteTrackingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_projectInvitationId = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		projectId = objectInput.readLong();

		inviteFrom = objectInput.readLong();

		inviteTo = objectInput.readLong();
		invitationStatus = objectInput.readUTF();

		isRead = objectInput.readLong();

		isRemoved = objectInput.readLong();
		messageTitle = objectInput.readUTF();
		messageContent = objectInput.readUTF();
		emailContent = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_projectInvitationId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(inviteFrom);

		objectOutput.writeLong(inviteTo);

		if (invitationStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(invitationStatus);
		}

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

	public long PK_projectInvitationId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long projectId;
	public long inviteFrom;
	public long inviteTo;
	public String invitationStatus;
	public long isRead;
	public long isRemoved;
	public String messageTitle;
	public String messageContent;
	public String emailContent;
}