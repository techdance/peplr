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
 * The extended model interface for the labScreenProjectPartners service. Represents a row in the &quot;collaborated_labScreenProjectPartners&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectPartnersModel
 * @see com.collaborated.entity.model.impl.labScreenProjectPartnersImpl
 * @see com.collaborated.entity.model.impl.labScreenProjectPartnersModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.labScreenProjectPartnersImpl")
@ProviderType
public interface labScreenProjectPartners extends labScreenProjectPartnersModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.labScreenProjectPartnersImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<labScreenProjectPartners, Long> P_K_PROJECT_PARTNER_ID_ACCESSOR =
		new Accessor<labScreenProjectPartners, Long>() {
			@Override
			public Long get(labScreenProjectPartners labScreenProjectPartners) {
				return labScreenProjectPartners.getPK_projectPartnerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<labScreenProjectPartners> getTypeClass() {
				return labScreenProjectPartners.class;
			}
		};
}