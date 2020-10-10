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

import com.collaborated.entity.model.labScreenProjectOverview;

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
 * The cache model class for representing labScreenProjectOverview in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectOverview
 * @generated
 */
@ProviderType
public class labScreenProjectOverviewCacheModel implements CacheModel<labScreenProjectOverview>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labScreenProjectOverviewCacheModel)) {
			return false;
		}

		labScreenProjectOverviewCacheModel labScreenProjectOverviewCacheModel = (labScreenProjectOverviewCacheModel)obj;

		if (PK_projectId == labScreenProjectOverviewCacheModel.PK_projectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_projectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{PK_projectId=");
		sb.append(PK_projectId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", projectOwnerId=");
		sb.append(projectOwnerId);
		sb.append(", projectName=");
		sb.append(projectName);
		sb.append(", projectType=");
		sb.append(projectType);
		sb.append(", projectDescription=");
		sb.append(projectDescription);
		sb.append(", projectDiscipline1=");
		sb.append(projectDiscipline1);
		sb.append(", projectDiscipline2=");
		sb.append(projectDiscipline2);
		sb.append(", projectDiscipline3=");
		sb.append(projectDiscipline3);
		sb.append(", role=");
		sb.append(role);
		sb.append(", projectStartDate=");
		sb.append(projectStartDate);
		sb.append(", projectEndDate=");
		sb.append(projectEndDate);
		sb.append(", projectDocumentId=");
		sb.append(projectDocumentId);
		sb.append(", percentage=");
		sb.append(percentage);
		sb.append(", interestId=");
		sb.append(interestId);
		sb.append(", projectStatus=");
		sb.append(projectStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labScreenProjectOverview toEntityModel() {
		labScreenProjectOverviewImpl labScreenProjectOverviewImpl = new labScreenProjectOverviewImpl();

		labScreenProjectOverviewImpl.setPK_projectId(PK_projectId);
		labScreenProjectOverviewImpl.setGroupId(groupId);
		labScreenProjectOverviewImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labScreenProjectOverviewImpl.setCreateDate(null);
		}
		else {
			labScreenProjectOverviewImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labScreenProjectOverviewImpl.setModifiedDate(null);
		}
		else {
			labScreenProjectOverviewImpl.setModifiedDate(new Date(modifiedDate));
		}

		labScreenProjectOverviewImpl.setProjectOwnerId(projectOwnerId);

		if (projectName == null) {
			labScreenProjectOverviewImpl.setProjectName(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setProjectName(projectName);
		}

		if (projectType == null) {
			labScreenProjectOverviewImpl.setProjectType(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setProjectType(projectType);
		}

		if (projectDescription == null) {
			labScreenProjectOverviewImpl.setProjectDescription(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setProjectDescription(projectDescription);
		}

		if (projectDiscipline1 == null) {
			labScreenProjectOverviewImpl.setProjectDiscipline1(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setProjectDiscipline1(projectDiscipline1);
		}

		if (projectDiscipline2 == null) {
			labScreenProjectOverviewImpl.setProjectDiscipline2(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setProjectDiscipline2(projectDiscipline2);
		}

		if (projectDiscipline3 == null) {
			labScreenProjectOverviewImpl.setProjectDiscipline3(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setProjectDiscipline3(projectDiscipline3);
		}

		if (role == null) {
			labScreenProjectOverviewImpl.setRole(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setRole(role);
		}

		if (projectStartDate == null) {
			labScreenProjectOverviewImpl.setProjectStartDate(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setProjectStartDate(projectStartDate);
		}

		if (projectEndDate == null) {
			labScreenProjectOverviewImpl.setProjectEndDate(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setProjectEndDate(projectEndDate);
		}

		labScreenProjectOverviewImpl.setProjectDocumentId(projectDocumentId);
		labScreenProjectOverviewImpl.setPercentage(percentage);
		labScreenProjectOverviewImpl.setInterestId(interestId);

		if (projectStatus == null) {
			labScreenProjectOverviewImpl.setProjectStatus(StringPool.BLANK);
		}
		else {
			labScreenProjectOverviewImpl.setProjectStatus(projectStatus);
		}

		labScreenProjectOverviewImpl.resetOriginalValues();

		return labScreenProjectOverviewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_projectId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		projectOwnerId = objectInput.readLong();
		projectName = objectInput.readUTF();
		projectType = objectInput.readUTF();
		projectDescription = objectInput.readUTF();
		projectDiscipline1 = objectInput.readUTF();
		projectDiscipline2 = objectInput.readUTF();
		projectDiscipline3 = objectInput.readUTF();
		role = objectInput.readUTF();
		projectStartDate = objectInput.readUTF();
		projectEndDate = objectInput.readUTF();

		projectDocumentId = objectInput.readLong();

		percentage = objectInput.readLong();

		interestId = objectInput.readLong();
		projectStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_projectId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(projectOwnerId);

		if (projectName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectName);
		}

		if (projectType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectType);
		}

		if (projectDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectDescription);
		}

		if (projectDiscipline1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectDiscipline1);
		}

		if (projectDiscipline2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectDiscipline2);
		}

		if (projectDiscipline3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectDiscipline3);
		}

		if (role == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(role);
		}

		if (projectStartDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectStartDate);
		}

		if (projectEndDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectEndDate);
		}

		objectOutput.writeLong(projectDocumentId);

		objectOutput.writeLong(percentage);

		objectOutput.writeLong(interestId);

		if (projectStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectStatus);
		}
	}

	public long PK_projectId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long projectOwnerId;
	public String projectName;
	public String projectType;
	public String projectDescription;
	public String projectDiscipline1;
	public String projectDiscipline2;
	public String projectDiscipline3;
	public String role;
	public String projectStartDate;
	public String projectEndDate;
	public long projectDocumentId;
	public long percentage;
	public long interestId;
	public String projectStatus;
}