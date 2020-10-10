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

import com.collaborated.entity.model.Custom_Workflow;

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
 * The cache model class for representing Custom_Workflow in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow
 * @generated
 */
@ProviderType
public class Custom_WorkflowCacheModel implements CacheModel<Custom_Workflow>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_WorkflowCacheModel)) {
			return false;
		}

		Custom_WorkflowCacheModel custom_WorkflowCacheModel = (Custom_WorkflowCacheModel)obj;

		if (workFlowId == custom_WorkflowCacheModel.workFlowId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workFlowId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{workFlowId=");
		sb.append(workFlowId);
		sb.append(", workFlowName=");
		sb.append(workFlowName);
		sb.append(", startWorkflowTaskId=");
		sb.append(startWorkflowTaskId);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Custom_Workflow toEntityModel() {
		Custom_WorkflowImpl custom_WorkflowImpl = new Custom_WorkflowImpl();

		custom_WorkflowImpl.setWorkFlowId(workFlowId);

		if (workFlowName == null) {
			custom_WorkflowImpl.setWorkFlowName(StringPool.BLANK);
		}
		else {
			custom_WorkflowImpl.setWorkFlowName(workFlowName);
		}

		if (startWorkflowTaskId == null) {
			custom_WorkflowImpl.setStartWorkflowTaskId(StringPool.BLANK);
		}
		else {
			custom_WorkflowImpl.setStartWorkflowTaskId(startWorkflowTaskId);
		}

		if (comments == null) {
			custom_WorkflowImpl.setComments(StringPool.BLANK);
		}
		else {
			custom_WorkflowImpl.setComments(comments);
		}

		custom_WorkflowImpl.setIsActive(isActive);

		if (createdDate == Long.MIN_VALUE) {
			custom_WorkflowImpl.setCreatedDate(null);
		}
		else {
			custom_WorkflowImpl.setCreatedDate(new Date(createdDate));
		}

		custom_WorkflowImpl.setCreatedBy(createdBy);

		custom_WorkflowImpl.resetOriginalValues();

		return custom_WorkflowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workFlowId = objectInput.readLong();
		workFlowName = objectInput.readUTF();
		startWorkflowTaskId = objectInput.readUTF();
		comments = objectInput.readUTF();

		isActive = objectInput.readLong();
		createdDate = objectInput.readLong();

		createdBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workFlowId);

		if (workFlowName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workFlowName);
		}

		if (startWorkflowTaskId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startWorkflowTaskId);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(isActive);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(createdBy);
	}

	public long workFlowId;
	public String workFlowName;
	public String startWorkflowTaskId;
	public String comments;
	public long isActive;
	public long createdDate;
	public long createdBy;
}