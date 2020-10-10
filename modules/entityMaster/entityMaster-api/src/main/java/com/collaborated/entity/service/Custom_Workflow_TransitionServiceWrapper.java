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
 * Provides a wrapper for {@link Custom_Workflow_TransitionService}.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_TransitionService
 * @generated
 */
@ProviderType
public class Custom_Workflow_TransitionServiceWrapper
	implements Custom_Workflow_TransitionService,
		ServiceWrapper<Custom_Workflow_TransitionService> {
	public Custom_Workflow_TransitionServiceWrapper(
		Custom_Workflow_TransitionService custom_Workflow_TransitionService) {
		_custom_Workflow_TransitionService = custom_Workflow_TransitionService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _custom_Workflow_TransitionService.getOSGiServiceIdentifier();
	}

	@Override
	public Custom_Workflow_TransitionService getWrappedService() {
		return _custom_Workflow_TransitionService;
	}

	@Override
	public void setWrappedService(
		Custom_Workflow_TransitionService custom_Workflow_TransitionService) {
		_custom_Workflow_TransitionService = custom_Workflow_TransitionService;
	}

	private Custom_Workflow_TransitionService _custom_Workflow_TransitionService;
}