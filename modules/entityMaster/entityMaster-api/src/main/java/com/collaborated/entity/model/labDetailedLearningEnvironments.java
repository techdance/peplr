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
 * The extended model interface for the labDetailedLearningEnvironments service. Represents a row in the &quot;collaborated_labDetailedLearningEnvironments&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedLearningEnvironmentsModel
 * @see com.collaborated.entity.model.impl.labDetailedLearningEnvironmentsImpl
 * @see com.collaborated.entity.model.impl.labDetailedLearningEnvironmentsModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.labDetailedLearningEnvironmentsImpl")
@ProviderType
public interface labDetailedLearningEnvironments
	extends labDetailedLearningEnvironmentsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.labDetailedLearningEnvironmentsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<labDetailedLearningEnvironments, Long> P_K_LEARNING_ENVIRONMENT_ID_ACCESSOR =
		new Accessor<labDetailedLearningEnvironments, Long>() {
			@Override
			public Long get(
				labDetailedLearningEnvironments labDetailedLearningEnvironments) {
				return labDetailedLearningEnvironments.getPK_learningEnvironmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<labDetailedLearningEnvironments> getTypeClass() {
				return labDetailedLearningEnvironments.class;
			}
		};
}