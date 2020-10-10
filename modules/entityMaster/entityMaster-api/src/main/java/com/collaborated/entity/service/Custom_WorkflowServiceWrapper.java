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
 * Provides a wrapper for {@link Custom_WorkflowService}.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowService
 * @generated
 */
@ProviderType
public class Custom_WorkflowServiceWrapper implements Custom_WorkflowService,
	ServiceWrapper<Custom_WorkflowService> {
	public Custom_WorkflowServiceWrapper(
		Custom_WorkflowService custom_WorkflowService) {
		_custom_WorkflowService = custom_WorkflowService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _custom_WorkflowService.getOSGiServiceIdentifier();
	}

	@Override
	public Custom_WorkflowService getWrappedService() {
		return _custom_WorkflowService;
	}

	@Override
	public void setWrappedService(Custom_WorkflowService custom_WorkflowService) {
		_custom_WorkflowService = custom_WorkflowService;
	}

	private Custom_WorkflowService _custom_WorkflowService;
}