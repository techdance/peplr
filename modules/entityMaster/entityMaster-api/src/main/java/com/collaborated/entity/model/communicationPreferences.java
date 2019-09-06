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
 * The extended model interface for the communicationPreferences service. Represents a row in the &quot;collaborated_communicationPreferences&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see communicationPreferencesModel
 * @see com.collaborated.entity.model.impl.communicationPreferencesImpl
 * @see com.collaborated.entity.model.impl.communicationPreferencesModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.communicationPreferencesImpl")
@ProviderType
public interface communicationPreferences extends communicationPreferencesModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.communicationPreferencesImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<communicationPreferences, Long> P_K_COMMUNICATION_PREFERENCES_ACCESSOR =
		new Accessor<communicationPreferences, Long>() {
			@Override
			public Long get(communicationPreferences communicationPreferences) {
				return communicationPreferences.getPK_communicationPreferences();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<communicationPreferences> getTypeClass() {
				return communicationPreferences.class;
			}
		};
}