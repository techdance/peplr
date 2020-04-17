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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the commonWebsserviceAPI service. Represents a row in the &quot;collaborated_commonWebsserviceAPI&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPIModel
 * @see com.collaborated.entity.model.impl.commonWebsserviceAPIImpl
 * @see com.collaborated.entity.model.impl.commonWebsserviceAPIModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.commonWebsserviceAPIImpl")
@ProviderType
public interface commonWebsserviceAPI extends commonWebsserviceAPIModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.commonWebsserviceAPIImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<commonWebsserviceAPI, Long> COMMON_A_P_I_ID_ACCESSOR =
		new Accessor<commonWebsserviceAPI, Long>() {
			@Override
			public Long get(commonWebsserviceAPI commonWebsserviceAPI) {
				return commonWebsserviceAPI.getCommonAPIId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<commonWebsserviceAPI> getTypeClass() {
				return commonWebsserviceAPI.class;
			}
		};
}