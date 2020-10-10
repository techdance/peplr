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

import com.collaborated.entity.model.labDetailedCourseResources;

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
 * The cache model class for representing labDetailedCourseResources in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseResources
 * @generated
 */
@ProviderType
public class labDetailedCourseResourcesCacheModel implements CacheModel<labDetailedCourseResources>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labDetailedCourseResourcesCacheModel)) {
			return false;
		}

		labDetailedCourseResourcesCacheModel labDetailedCourseResourcesCacheModel =
			(labDetailedCourseResourcesCacheModel)obj;

		if (PK_courseResourceId == labDetailedCourseResourcesCacheModel.PK_courseResourceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_courseResourceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{PK_courseResourceId=");
		sb.append(PK_courseResourceId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", PK_projectId=");
		sb.append(PK_projectId);
		sb.append(", PK_courseId=");
		sb.append(PK_courseId);
		sb.append(", textbokTitle=");
		sb.append(textbokTitle);
		sb.append(", publisherName=");
		sb.append(publisherName);
		sb.append(", author=");
		sb.append(author);
		sb.append(", isbn=");
		sb.append(isbn);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labDetailedCourseResources toEntityModel() {
		labDetailedCourseResourcesImpl labDetailedCourseResourcesImpl = new labDetailedCourseResourcesImpl();

		labDetailedCourseResourcesImpl.setPK_courseResourceId(PK_courseResourceId);
		labDetailedCourseResourcesImpl.setGroupId(groupId);
		labDetailedCourseResourcesImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labDetailedCourseResourcesImpl.setCreateDate(null);
		}
		else {
			labDetailedCourseResourcesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labDetailedCourseResourcesImpl.setModifiedDate(null);
		}
		else {
			labDetailedCourseResourcesImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		labDetailedCourseResourcesImpl.setPK_projectId(PK_projectId);
		labDetailedCourseResourcesImpl.setPK_courseId(PK_courseId);

		if (textbokTitle == null) {
			labDetailedCourseResourcesImpl.setTextbokTitle(StringPool.BLANK);
		}
		else {
			labDetailedCourseResourcesImpl.setTextbokTitle(textbokTitle);
		}

		if (publisherName == null) {
			labDetailedCourseResourcesImpl.setPublisherName(StringPool.BLANK);
		}
		else {
			labDetailedCourseResourcesImpl.setPublisherName(publisherName);
		}

		if (author == null) {
			labDetailedCourseResourcesImpl.setAuthor(StringPool.BLANK);
		}
		else {
			labDetailedCourseResourcesImpl.setAuthor(author);
		}

		if (isbn == null) {
			labDetailedCourseResourcesImpl.setIsbn(StringPool.BLANK);
		}
		else {
			labDetailedCourseResourcesImpl.setIsbn(isbn);
		}

		labDetailedCourseResourcesImpl.resetOriginalValues();

		return labDetailedCourseResourcesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_courseResourceId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();

		PK_courseId = objectInput.readLong();
		textbokTitle = objectInput.readUTF();
		publisherName = objectInput.readUTF();
		author = objectInput.readUTF();
		isbn = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_courseResourceId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		objectOutput.writeLong(PK_courseId);

		if (textbokTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(textbokTitle);
		}

		if (publisherName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publisherName);
		}

		if (author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(author);
		}

		if (isbn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isbn);
		}
	}

	public long PK_courseResourceId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public long PK_courseId;
	public String textbokTitle;
	public String publisherName;
	public String author;
	public String isbn;
}