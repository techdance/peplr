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

import com.collaborated.entity.model.Custom_Calendar;

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
 * The cache model class for representing Custom_Calendar in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Calendar
 * @generated
 */
@ProviderType
public class Custom_CalendarCacheModel implements CacheModel<Custom_Calendar>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_CalendarCacheModel)) {
			return false;
		}

		Custom_CalendarCacheModel custom_CalendarCacheModel = (Custom_CalendarCacheModel)obj;

		if (PK_calendarEventId == custom_CalendarCacheModel.PK_calendarEventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_calendarEventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{PK_calendarEventId=");
		sb.append(PK_calendarEventId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", calendarResourceId=");
		sb.append(calendarResourceId);
		sb.append(", timeZoneId=");
		sb.append(timeZoneId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", eventTitle=");
		sb.append(eventTitle);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Custom_Calendar toEntityModel() {
		Custom_CalendarImpl custom_CalendarImpl = new Custom_CalendarImpl();

		custom_CalendarImpl.setPK_calendarEventId(PK_calendarEventId);
		custom_CalendarImpl.setGroupId(groupId);
		custom_CalendarImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			custom_CalendarImpl.setCreateDate(null);
		}
		else {
			custom_CalendarImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			custom_CalendarImpl.setModifiedDate(null);
		}
		else {
			custom_CalendarImpl.setModifiedDate(new Date(modifiedDate));
		}

		custom_CalendarImpl.setCalendarResourceId(calendarResourceId);

		if (timeZoneId == null) {
			custom_CalendarImpl.setTimeZoneId(StringPool.BLANK);
		}
		else {
			custom_CalendarImpl.setTimeZoneId(timeZoneId);
		}

		if (startDate == null) {
			custom_CalendarImpl.setStartDate(StringPool.BLANK);
		}
		else {
			custom_CalendarImpl.setStartDate(startDate);
		}

		if (endDate == null) {
			custom_CalendarImpl.setEndDate(StringPool.BLANK);
		}
		else {
			custom_CalendarImpl.setEndDate(endDate);
		}

		if (startTime == null) {
			custom_CalendarImpl.setStartTime(StringPool.BLANK);
		}
		else {
			custom_CalendarImpl.setStartTime(startTime);
		}

		if (endTime == null) {
			custom_CalendarImpl.setEndTime(StringPool.BLANK);
		}
		else {
			custom_CalendarImpl.setEndTime(endTime);
		}

		if (eventTitle == null) {
			custom_CalendarImpl.setEventTitle(StringPool.BLANK);
		}
		else {
			custom_CalendarImpl.setEventTitle(eventTitle);
		}

		custom_CalendarImpl.resetOriginalValues();

		return custom_CalendarImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_calendarEventId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		calendarResourceId = objectInput.readLong();
		timeZoneId = objectInput.readUTF();
		startDate = objectInput.readUTF();
		endDate = objectInput.readUTF();
		startTime = objectInput.readUTF();
		endTime = objectInput.readUTF();
		eventTitle = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_calendarEventId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(calendarResourceId);

		if (timeZoneId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timeZoneId);
		}

		if (startDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startDate);
		}

		if (endDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endDate);
		}

		if (startTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startTime);
		}

		if (endTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endTime);
		}

		if (eventTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventTitle);
		}
	}

	public long PK_calendarEventId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long calendarResourceId;
	public String timeZoneId;
	public String startDate;
	public String endDate;
	public String startTime;
	public String endTime;
	public String eventTitle;
}