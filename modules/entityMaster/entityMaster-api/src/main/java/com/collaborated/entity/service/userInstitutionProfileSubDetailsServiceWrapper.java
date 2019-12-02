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
 * Provides a wrapper for {@link userInstitutionProfileSubDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileSubDetailsService
 * @generated
 */
@ProviderType
public class userInstitutionProfileSubDetailsServiceWrapper
	implements userInstitutionProfileSubDetailsService,
		ServiceWrapper<userInstitutionProfileSubDetailsService> {
	public userInstitutionProfileSubDetailsServiceWrapper(
		userInstitutionProfileSubDetailsService userInstitutionProfileSubDetailsService) {
		_userInstitutionProfileSubDetailsService = userInstitutionProfileSubDetailsService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userInstitutionProfileSubDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public userInstitutionProfileSubDetailsService getWrappedService() {
		return _userInstitutionProfileSubDetailsService;
	}

	@Override
	public void setWrappedService(
		userInstitutionProfileSubDetailsService userInstitutionProfileSubDetailsService) {
		_userInstitutionProfileSubDetailsService = userInstitutionProfileSubDetailsService;
	}

	private userInstitutionProfileSubDetailsService _userInstitutionProfileSubDetailsService;
}