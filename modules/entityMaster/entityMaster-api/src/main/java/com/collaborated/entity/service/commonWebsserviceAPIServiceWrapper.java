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

package com.collaborated.entity.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link commonWebsserviceAPIService}.
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPIService
 * @generated
 */
@ProviderType
public class commonWebsserviceAPIServiceWrapper
	implements commonWebsserviceAPIService,
		ServiceWrapper<commonWebsserviceAPIService> {
	public commonWebsserviceAPIServiceWrapper(
		commonWebsserviceAPIService commonWebsserviceAPIService) {
		_commonWebsserviceAPIService = commonWebsserviceAPIService;
	}

	@Override
	public boolean logEntry(
		com.liferay.portal.kernel.json.JSONObject jsonObject) {
		return _commonWebsserviceAPIService.logEntry(jsonObject);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _commonWebsserviceAPIService.getOSGiServiceIdentifier();
	}

	@Override
	public commonWebsserviceAPIService getWrappedService() {
		return _commonWebsserviceAPIService;
	}

	@Override
	public void setWrappedService(
		commonWebsserviceAPIService commonWebsserviceAPIService) {
		_commonWebsserviceAPIService = commonWebsserviceAPIService;
	}

	private commonWebsserviceAPIService _commonWebsserviceAPIService;
}