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
 * The extended model interface for the labDetailedInstructorQualification service. Represents a row in the &quot;collaborated_labDetailedInstructorQualification&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedInstructorQualificationModel
 * @see com.collaborated.entity.model.impl.labDetailedInstructorQualificationImpl
 * @see com.collaborated.entity.model.impl.labDetailedInstructorQualificationModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.labDetailedInstructorQualificationImpl")
@ProviderType
public interface labDetailedInstructorQualification
	extends labDetailedInstructorQualificationModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.labDetailedInstructorQualificationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<labDetailedInstructorQualification, Long> P_K_COURSE_INSTRUCTOR_QUALIFICATION_ID_ACCESSOR =
		new Accessor<labDetailedInstructorQualification, Long>() {
			@Override
			public Long get(
				labDetailedInstructorQualification labDetailedInstructorQualification) {
				return labDetailedInstructorQualification.getPK_courseInstructorQualificationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<labDetailedInstructorQualification> getTypeClass() {
				return labDetailedInstructorQualification.class;
			}
		};
}