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

import com.collaborated.entity.model.Custom_Workflow_Task;

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
 * The cache model class for representing Custom_Workflow_Task in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_Task
 * @generated
 */
@ProviderType
public class Custom_Workflow_TaskCacheModel implements CacheModel<Custom_Workflow_Task>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_Workflow_TaskCacheModel)) {
			return false;
		}

		Custom_Workflow_TaskCacheModel custom_Workflow_TaskCacheModel = (Custom_Workflow_TaskCacheModel)obj;

		if (workFlowTaskId.equals(custom_Workflow_TaskCacheModel.workFlowTaskId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workFlowTaskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{workFlowTaskId=");
		sb.append(workFlowTaskId);
		sb.append(", workFlowId=");
		sb.append(workFlowId);
		sb.append(", taskName=");
		sb.append(taskName);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", roleName=");
		sb.append(roleName);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Custom_Workflow_Task toEntityModel() {
		Custom_Workflow_TaskImpl custom_Workflow_TaskImpl = new Custom_Workflow_TaskImpl();

		if (workFlowTaskId == null) {
			custom_Workflow_TaskImpl.setWorkFlowTaskId(StringPool.BLANK);
		}
		else {
			custom_Workflow_TaskImpl.setWorkFlowTaskId(workFlowTaskId);
		}

		custom_Workflow_TaskImpl.setWorkFlowId(workFlowId);

		if (taskName == null) {
			custom_Workflow_TaskImpl.setTaskName(StringPool.BLANK);
		}
		else {
			custom_Workflow_TaskImpl.setTaskName(taskName);
		}

		custom_Workflow_TaskImpl.setRoleId(roleId);

		if (roleName == null) {
			custom_Workflow_TaskImpl.setRoleName(StringPool.BLANK);
		}
		else {
			custom_Workflow_TaskImpl.setRoleName(roleName);
		}

		if (comments == null) {
			custom_Workflow_TaskImpl.setComments(StringPool.BLANK);
		}
		else {
			custom_Workflow_TaskImpl.setComments(comments);
		}

		if (createdDate == Long.MIN_VALUE) {
			custom_Workflow_TaskImpl.setCreatedDate(null);
		}
		else {
			custom_Workflow_TaskImpl.setCreatedDate(new Date(createdDate));
		}

		custom_Workflow_TaskImpl.setCreatedBy(createdBy);

		custom_Workflow_TaskImpl.resetOriginalValues();

		return custom_Workflow_TaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workFlowTaskId = objectInput.readUTF();

		workFlowId = objectInput.readLong();
		taskName = objectInput.readUTF();

		roleId = objectInput.readLong();
		roleName = objectInput.readUTF();
		comments = objectInput.readUTF();
		createdDate = objectInput.readLong();

		createdBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (workFlowTaskId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workFlowTaskId);
		}

		objectOutput.writeLong(workFlowId);

		if (taskName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taskName);
		}

		objectOutput.writeLong(roleId);

		if (roleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(roleName);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(createdBy);
	}

	public String workFlowTaskId;
	public long workFlowId;
	public String taskName;
	public long roleId;
	public String roleName;
	public String comments;
	public long createdDate;
	public long createdBy;
}