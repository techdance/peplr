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

package com.collaborated.entity.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.commonWebsserviceAPIServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.commonWebsserviceAPIServiceSoap
 * @generated
 */
@ProviderType
public class commonWebsserviceAPISoap implements Serializable {
	public static commonWebsserviceAPISoap toSoapModel(
		commonWebsserviceAPI model) {
		commonWebsserviceAPISoap soapModel = new commonWebsserviceAPISoap();

		soapModel.setCommonAPIId(model.getCommonAPIId());

		return soapModel;
	}

	public static commonWebsserviceAPISoap[] toSoapModels(
		commonWebsserviceAPI[] models) {
		commonWebsserviceAPISoap[] soapModels = new commonWebsserviceAPISoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static commonWebsserviceAPISoap[][] toSoapModels(
		commonWebsserviceAPI[][] models) {
		commonWebsserviceAPISoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new commonWebsserviceAPISoap[models.length][models[0].length];
		}
		else {
			soapModels = new commonWebsserviceAPISoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static commonWebsserviceAPISoap[] toSoapModels(
		List<commonWebsserviceAPI> models) {
		List<commonWebsserviceAPISoap> soapModels = new ArrayList<commonWebsserviceAPISoap>(models.size());

		for (commonWebsserviceAPI model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new commonWebsserviceAPISoap[soapModels.size()]);
	}

	public commonWebsserviceAPISoap() {
	}

	public long getPrimaryKey() {
		return _commonAPIId;
	}

	public void setPrimaryKey(long pk) {
		setCommonAPIId(pk);
	}

	public long getCommonAPIId() {
		return _commonAPIId;
	}

	public void setCommonAPIId(long commonAPIId) {
		_commonAPIId = commonAPIId;
	}

	private long _commonAPIId;
}