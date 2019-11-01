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
 * The extended model interface for the profileAreaofinterest service. Represents a row in the &quot;collaborated_profileAreaofinterest&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see profileAreaofinterestModel
 * @see com.collaborated.entity.model.impl.profileAreaofinterestImpl
 * @see com.collaborated.entity.model.impl.profileAreaofinterestModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.profileAreaofinterestImpl")
@ProviderType
public interface profileAreaofinterest extends profileAreaofinterestModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.profileAreaofinterestImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<profileAreaofinterest, Long> P_K_AREAOFINTEREST_ACCESSOR =
		new Accessor<profileAreaofinterest, Long>() {
			@Override
			public Long get(profileAreaofinterest profileAreaofinterest) {
				return profileAreaofinterest.getPK_areaofinterest();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<profileAreaofinterest> getTypeClass() {
				return profileAreaofinterest.class;
			}
		};
}