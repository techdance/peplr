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

import com.collaborated.entity.model.commonWebsserviceAPI;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing commonWebsserviceAPI in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPI
 * @generated
 */
@ProviderType
public class commonWebsserviceAPICacheModel implements CacheModel<commonWebsserviceAPI>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof commonWebsserviceAPICacheModel)) {
			return false;
		}

		commonWebsserviceAPICacheModel commonWebsserviceAPICacheModel = (commonWebsserviceAPICacheModel)obj;

		if (commonAPIId == commonWebsserviceAPICacheModel.commonAPIId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, commonAPIId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{commonAPIId=");
		sb.append(commonAPIId);

		return sb.toString();
	}

	@Override
	public commonWebsserviceAPI toEntityModel() {
		commonWebsserviceAPIImpl commonWebsserviceAPIImpl = new commonWebsserviceAPIImpl();

		commonWebsserviceAPIImpl.setCommonAPIId(commonAPIId);

		commonWebsserviceAPIImpl.resetOriginalValues();

		return commonWebsserviceAPIImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		commonAPIId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(commonAPIId);
	}

	public long commonAPIId;
}