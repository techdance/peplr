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

import com.collaborated.entity.model.Custom_WorkflowLog;

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
 * The cache model class for representing Custom_WorkflowLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowLog
 * @generated
 */
@ProviderType
public class Custom_WorkflowLogCacheModel implements CacheModel<Custom_WorkflowLog>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_WorkflowLogCacheModel)) {
			return false;
		}

		Custom_WorkflowLogCacheModel custom_WorkflowLogCacheModel = (Custom_WorkflowLogCacheModel)obj;

		if (logId == custom_WorkflowLogCacheModel.logId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, logId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{logId=");
		sb.append(logId);
		sb.append(", trackingId=");
		sb.append(trackingId);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", workflowTaskId=");
		sb.append(workflowTaskId);
		sb.append(", trasitionId=");
		sb.append(trasitionId);
		sb.append(", logDescription=");
		sb.append(logDescription);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", assigneeClassPK=");
		sb.append(assigneeClassPK);
		sb.append(", className=");
		sb.append(className);
		sb.append(", assignedDate=");
		sb.append(assignedDate);
		sb.append(", completedDate=");
		sb.append(completedDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Custom_WorkflowLog toEntityModel() {
		Custom_WorkflowLogImpl custom_WorkflowLogImpl = new Custom_WorkflowLogImpl();

		custom_WorkflowLogImpl.setLogId(logId);
		custom_WorkflowLogImpl.setTrackingId(trackingId);
		custom_WorkflowLogImpl.setWorkflowId(workflowId);

		if (workflowTaskId == null) {
			custom_WorkflowLogImpl.setWorkflowTaskId(StringPool.BLANK);
		}
		else {
			custom_WorkflowLogImpl.setWorkflowTaskId(workflowTaskId);
		}

		custom_WorkflowLogImpl.setTrasitionId(trasitionId);

		if (logDescription == null) {
			custom_WorkflowLogImpl.setLogDescription(StringPool.BLANK);
		}
		else {
			custom_WorkflowLogImpl.setLogDescription(logDescription);
		}

		if (comments == null) {
			custom_WorkflowLogImpl.setComments(StringPool.BLANK);
		}
		else {
			custom_WorkflowLogImpl.setComments(comments);
		}

		custom_WorkflowLogImpl.setAssigneeClassPK(assigneeClassPK);

		if (className == null) {
			custom_WorkflowLogImpl.setClassName(StringPool.BLANK);
		}
		else {
			custom_WorkflowLogImpl.setClassName(className);
		}

		if (assignedDate == Long.MIN_VALUE) {
			custom_WorkflowLogImpl.setAssignedDate(null);
		}
		else {
			custom_WorkflowLogImpl.setAssignedDate(new Date(assignedDate));
		}

		if (completedDate == Long.MIN_VALUE) {
			custom_WorkflowLogImpl.setCompletedDate(null);
		}
		else {
			custom_WorkflowLogImpl.setCompletedDate(new Date(completedDate));
		}

		custom_WorkflowLogImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			custom_WorkflowLogImpl.setCreatedDate(null);
		}
		else {
			custom_WorkflowLogImpl.setCreatedDate(new Date(createdDate));
		}

		custom_WorkflowLogImpl.resetOriginalValues();

		return custom_WorkflowLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		logId = objectInput.readLong();

		trackingId = objectInput.readLong();

		workflowId = objectInput.readLong();
		workflowTaskId = objectInput.readUTF();

		trasitionId = objectInput.readLong();
		logDescription = objectInput.readUTF();
		comments = objectInput.readUTF();

		assigneeClassPK = objectInput.readLong();
		className = objectInput.readUTF();
		assignedDate = objectInput.readLong();
		completedDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(logId);

		objectOutput.writeLong(trackingId);

		objectOutput.writeLong(workflowId);

		if (workflowTaskId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowTaskId);
		}

		objectOutput.writeLong(trasitionId);

		if (logDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logDescription);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(assigneeClassPK);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(assignedDate);
		objectOutput.writeLong(completedDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdDate);
	}

	public long logId;
	public long trackingId;
	public long workflowId;
	public String workflowTaskId;
	public long trasitionId;
	public String logDescription;
	public String comments;
	public long assigneeClassPK;
	public String className;
	public long assignedDate;
	public long completedDate;
	public long createdBy;
	public long createdDate;
}