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

import com.collaborated.entity.model.Custom_Workflow_Completed;

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
 * The cache model class for representing Custom_Workflow_Completed in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_Completed
 * @generated
 */
@ProviderType
public class Custom_Workflow_CompletedCacheModel implements CacheModel<Custom_Workflow_Completed>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_Workflow_CompletedCacheModel)) {
			return false;
		}

		Custom_Workflow_CompletedCacheModel custom_Workflow_CompletedCacheModel = (Custom_Workflow_CompletedCacheModel)obj;

		if (cId == custom_Workflow_CompletedCacheModel.cId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{cId=");
		sb.append(cId);
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
		sb.append(", completedDate=");
		sb.append(completedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Custom_Workflow_Completed toEntityModel() {
		Custom_Workflow_CompletedImpl custom_Workflow_CompletedImpl = new Custom_Workflow_CompletedImpl();

		custom_Workflow_CompletedImpl.setCId(cId);
		custom_Workflow_CompletedImpl.setTrackingId(trackingId);
		custom_Workflow_CompletedImpl.setWorkflowId(workflowId);

		if (workflowTaskId == null) {
			custom_Workflow_CompletedImpl.setWorkflowTaskId(StringPool.BLANK);
		}
		else {
			custom_Workflow_CompletedImpl.setWorkflowTaskId(workflowTaskId);
		}

		custom_Workflow_CompletedImpl.setTrasitionId(trasitionId);

		if (logDescription == null) {
			custom_Workflow_CompletedImpl.setLogDescription(StringPool.BLANK);
		}
		else {
			custom_Workflow_CompletedImpl.setLogDescription(logDescription);
		}

		if (comments == null) {
			custom_Workflow_CompletedImpl.setComments(StringPool.BLANK);
		}
		else {
			custom_Workflow_CompletedImpl.setComments(comments);
		}

		if (completedDate == Long.MIN_VALUE) {
			custom_Workflow_CompletedImpl.setCompletedDate(null);
		}
		else {
			custom_Workflow_CompletedImpl.setCompletedDate(new Date(
					completedDate));
		}

		custom_Workflow_CompletedImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			custom_Workflow_CompletedImpl.setCreatedDate(null);
		}
		else {
			custom_Workflow_CompletedImpl.setCreatedDate(new Date(createdDate));
		}

		custom_Workflow_CompletedImpl.resetOriginalValues();

		return custom_Workflow_CompletedImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cId = objectInput.readLong();

		trackingId = objectInput.readLong();

		workflowId = objectInput.readLong();
		workflowTaskId = objectInput.readUTF();

		trasitionId = objectInput.readLong();
		logDescription = objectInput.readUTF();
		comments = objectInput.readUTF();
		completedDate = objectInput.readLong();

		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cId);

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

		objectOutput.writeLong(completedDate);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
	}

	public long cId;
	public long trackingId;
	public long workflowId;
	public String workflowTaskId;
	public long trasitionId;
	public String logDescription;
	public String comments;
	public long completedDate;
	public long userId;
	public long createdDate;
}