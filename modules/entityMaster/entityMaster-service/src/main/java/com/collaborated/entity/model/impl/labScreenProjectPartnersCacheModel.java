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

import com.collaborated.entity.model.labScreenProjectPartners;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing labScreenProjectPartners in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectPartners
 * @generated
 */
@ProviderType
public class labScreenProjectPartnersCacheModel implements CacheModel<labScreenProjectPartners>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof labScreenProjectPartnersCacheModel)) {
			return false;
		}

		labScreenProjectPartnersCacheModel labScreenProjectPartnersCacheModel = (labScreenProjectPartnersCacheModel)obj;

		if (PK_projectPartnerId == labScreenProjectPartnersCacheModel.PK_projectPartnerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PK_projectPartnerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{PK_projectPartnerId=");
		sb.append(PK_projectPartnerId);
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
		sb.append(", projectPartnerId=");
		sb.append(projectPartnerId);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public labScreenProjectPartners toEntityModel() {
		labScreenProjectPartnersImpl labScreenProjectPartnersImpl = new labScreenProjectPartnersImpl();

		labScreenProjectPartnersImpl.setPK_projectPartnerId(PK_projectPartnerId);
		labScreenProjectPartnersImpl.setGroupId(groupId);
		labScreenProjectPartnersImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			labScreenProjectPartnersImpl.setCreateDate(null);
		}
		else {
			labScreenProjectPartnersImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labScreenProjectPartnersImpl.setModifiedDate(null);
		}
		else {
			labScreenProjectPartnersImpl.setModifiedDate(new Date(modifiedDate));
		}

		labScreenProjectPartnersImpl.setPK_projectId(PK_projectId);
		labScreenProjectPartnersImpl.setProjectPartnerId(projectPartnerId);
		labScreenProjectPartnersImpl.setIsActive(isActive);

		labScreenProjectPartnersImpl.resetOriginalValues();

		return labScreenProjectPartnersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PK_projectPartnerId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		PK_projectId = objectInput.readLong();

		projectPartnerId = objectInput.readLong();

		isActive = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(PK_projectPartnerId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(PK_projectId);

		objectOutput.writeLong(projectPartnerId);

		objectOutput.writeLong(isActive);
	}

	public long PK_projectPartnerId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long PK_projectId;
	public long projectPartnerId;
	public long isActive;
}