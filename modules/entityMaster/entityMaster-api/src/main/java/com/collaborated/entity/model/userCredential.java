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
 * The extended model interface for the userCredential service. Represents a row in the &quot;collaborated_userCredential&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see userCredentialModel
 * @see com.collaborated.entity.model.impl.userCredentialImpl
 * @see com.collaborated.entity.model.impl.userCredentialModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.userCredentialImpl")
@ProviderType
public interface userCredential extends userCredentialModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.userCredentialImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<userCredential, Long> P_K_USER_CREDENTIAL_ACCESSOR =
		new Accessor<userCredential, Long>() {
			@Override
			public Long get(userCredential userCredential) {
				return userCredential.getPK_userCredential();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<userCredential> getTypeClass() {
				return userCredential.class;
			}
		};
}