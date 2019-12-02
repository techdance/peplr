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
 * The extended model interface for the userProfessionalBio service. Represents a row in the &quot;collaborated_userProfessionalBio&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see userProfessionalBioModel
 * @see com.collaborated.entity.model.impl.userProfessionalBioImpl
 * @see com.collaborated.entity.model.impl.userProfessionalBioModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.userProfessionalBioImpl")
@ProviderType
public interface userProfessionalBio extends userProfessionalBioModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.userProfessionalBioImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<userProfessionalBio, Long> P_K_USER_PROFESSIONAL_BIO_ACCESSOR =
		new Accessor<userProfessionalBio, Long>() {
			@Override
			public Long get(userProfessionalBio userProfessionalBio) {
				return userProfessionalBio.getPK_userProfessionalBio();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<userProfessionalBio> getTypeClass() {
				return userProfessionalBio.class;
			}
		};
}