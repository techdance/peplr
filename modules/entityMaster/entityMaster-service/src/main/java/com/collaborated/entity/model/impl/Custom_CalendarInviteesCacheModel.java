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

import com.collaborated.entity.model.Custom_CalendarInvitees;

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
 * The cache model class for representing Custom_CalendarInvitees in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarInvitees
 * @generated
 */
@ProviderType
public class Custom_CalendarInviteesCacheModel implements CacheModel<Custom_CalendarInvitees>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_CalendarInviteesCacheModel)) {
			return false;
		}

		Custom_CalendarInviteesCacheModel custom_CalendarInviteesCacheModel = (Custom_CalendarInviteesCacheModel)obj;

		if (PK_calendarEventSubId == custom_CalendarInviteesCacheModel.PK_calendarEventSubId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_calendarEventSubId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{PK_calendarEventSubId=");
		sb.append(PK_calendarEventSubId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", PK_calendarEventId=");
		sb.append(PK_calendarEventId);
		sb.append(", inviteeEmailAddress=");
		sb.append(inviteeEmailAddress);
		sb.append(", invitee=");
		sb.append(invitee);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Custom_CalendarInvitees toEntityModel() {
		Custom_CalendarInviteesImpl custom_CalendarInviteesImpl = new Custom_CalendarInviteesImpl();

		custom_CalendarInviteesImpl.setPK_calendarEventSubId(PK_calendarEventSubId);
		custom_CalendarInviteesImpl.setGroupId(groupId);
		custom_CalendarInviteesImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			custom_CalendarInviteesImpl.setCreateDate(null);
		}
		else {
			custom_CalendarInviteesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			custom_CalendarInviteesImpl.setModifiedDate(null);
		}
		else {
			custom_CalendarInviteesImpl.setModifiedDate(new Date(modifiedDate));
		}

		custom_CalendarInviteesImpl.setPK_calendarEventId(PK_calendarEventId);

		if (inviteeEmailAddress == null) {
			custom_CalendarInviteesImpl.setInviteeEmailAddress(StringPool.BLANK);
		}
		else {
			custom_CalendarInviteesImpl.setInviteeEmailAddress(inviteeEmailAddress);
		}

		custom_CalendarInviteesImpl.setInvitee(invitee);
		custom_CalendarInviteesImpl.setStatus(status);

		custom_CalendarInviteesImpl.resetOriginalValues();

		return custom_CalendarInviteesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_calendarEventSubId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_calendarEventId = objectInput.readLong();
		inviteeEmailAddress = objectInput.readUTF();

		invitee = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_calendarEventSubId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_calendarEventId);

		if (inviteeEmailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(inviteeEmailAddress);
		}

		objectOutput.writeLong(invitee);

		objectOutput.writeInt(status);
	}

	public long PK_calendarEventSubId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_calendarEventId;
	public String inviteeEmailAddress;
	public long invitee;
	public int status;
}