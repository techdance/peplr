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
 * Provides a wrapper for {@link Custom_CalendarInviteesService}.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarInviteesService
 * @generated
 */
@ProviderType
public class Custom_CalendarInviteesServiceWrapper
	implements Custom_CalendarInviteesService,
		ServiceWrapper<Custom_CalendarInviteesService> {
	public Custom_CalendarInviteesServiceWrapper(
		Custom_CalendarInviteesService custom_CalendarInviteesService) {
		_custom_CalendarInviteesService = custom_CalendarInviteesService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _custom_CalendarInviteesService.getOSGiServiceIdentifier();
	}

	@Override
	public Custom_CalendarInviteesService getWrappedService() {
		return _custom_CalendarInviteesService;
	}

	@Override
	public void setWrappedService(
		Custom_CalendarInviteesService custom_CalendarInviteesService) {
		_custom_CalendarInviteesService = custom_CalendarInviteesService;
	}

	private Custom_CalendarInviteesService _custom_CalendarInviteesService;
}