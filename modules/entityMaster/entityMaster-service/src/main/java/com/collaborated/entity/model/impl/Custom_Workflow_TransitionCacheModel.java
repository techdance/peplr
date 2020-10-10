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

import com.collaborated.entity.model.Custom_Workflow_Transition;

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
 * The cache model class for representing Custom_Workflow_Transition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_Transition
 * @generated
 */
@ProviderType
public class Custom_Workflow_TransitionCacheModel implements CacheModel<Custom_Workflow_Transition>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Custom_Workflow_TransitionCacheModel)) {
			return false;
		}

		Custom_Workflow_TransitionCacheModel custom_Workflow_TransitionCacheModel =
			(Custom_Workflow_TransitionCacheModel)obj;

		if (transitionId == custom_Workflow_TransitionCacheModel.transitionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, transitionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{transitionId=");
		sb.append(transitionId);
		sb.append(", workFlowId=");
		sb.append(workFlowId);
		sb.append(", workFlowTaskId=");
		sb.append(workFlowTaskId);
		sb.append(", transitionName=");
		sb.append(transitionName);
		sb.append(", logDescription=");
		sb.append(logDescription);
		sb.append(", next_WorkFlowTaskId=");
		sb.append(next_WorkFlowTaskId);
		sb.append(", isEnd=");
		sb.append(isEnd);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Custom_Workflow_Transition toEntityModel() {
		Custom_Workflow_TransitionImpl custom_Workflow_TransitionImpl = new Custom_Workflow_TransitionImpl();

		custom_Workflow_TransitionImpl.setTransitionId(transitionId);
		custom_Workflow_TransitionImpl.setWorkFlowId(workFlowId);

		if (workFlowTaskId == null) {
			custom_Workflow_TransitionImpl.setWorkFlowTaskId(StringPool.BLANK);
		}
		else {
			custom_Workflow_TransitionImpl.setWorkFlowTaskId(workFlowTaskId);
		}

		if (transitionName == null) {
			custom_Workflow_TransitionImpl.setTransitionName(StringPool.BLANK);
		}
		else {
			custom_Workflow_TransitionImpl.setTransitionName(transitionName);
		}

		if (logDescription == null) {
			custom_Workflow_TransitionImpl.setLogDescription(StringPool.BLANK);
		}
		else {
			custom_Workflow_TransitionImpl.setLogDescription(logDescription);
		}

		if (next_WorkFlowTaskId == null) {
			custom_Workflow_TransitionImpl.setNext_WorkFlowTaskId(StringPool.BLANK);
		}
		else {
			custom_Workflow_TransitionImpl.setNext_WorkFlowTaskId(next_WorkFlowTaskId);
		}

		custom_Workflow_TransitionImpl.setIsEnd(isEnd);

		if (comments == null) {
			custom_Workflow_TransitionImpl.setComments(StringPool.BLANK);
		}
		else {
			custom_Workflow_TransitionImpl.setComments(comments);
		}

		if (createdDate == Long.MIN_VALUE) {
			custom_Workflow_TransitionImpl.setCreatedDate(null);
		}
		else {
			custom_Workflow_TransitionImpl.setCreatedDate(new Date(createdDate));
		}

		custom_Workflow_TransitionImpl.resetOriginalValues();

		return custom_Workflow_TransitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		transitionId = objectInput.readLong();

		workFlowId = objectInput.readLong();
		workFlowTaskId = objectInput.readUTF();
		transitionName = objectInput.readUTF();
		logDescription = objectInput.readUTF();
		next_WorkFlowTaskId = objectInput.readUTF();

		isEnd = objectInput.readLong();
		comments = objectInput.readUTF();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(transitionId);

		objectOutput.writeLong(workFlowId);

		if (workFlowTaskId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workFlowTaskId);
		}

		if (transitionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(transitionName);
		}

		if (logDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logDescription);
		}

		if (next_WorkFlowTaskId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(next_WorkFlowTaskId);
		}

		objectOutput.writeLong(isEnd);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(createdDate);
	}

	public long transitionId;
	public long workFlowId;
	public String workFlowTaskId;
	public String transitionName;
	public String logDescription;
	public String next_WorkFlowTaskId;
	public long isEnd;
	public String comments;
	public long createdDate;
}