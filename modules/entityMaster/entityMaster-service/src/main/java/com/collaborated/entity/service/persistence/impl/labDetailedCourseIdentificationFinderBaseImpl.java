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

package com.collaborated.entity.service.persistence.impl;

import com.collaborated.entity.model.labDetailedCourseIdentification;
import com.collaborated.entity.service.persistence.labDetailedCourseIdentificationPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class labDetailedCourseIdentificationFinderBaseImpl
	extends BasePersistenceImpl<labDetailedCourseIdentification> {
	/**
	 * Returns the lab detailed course identification persistence.
	 *
	 * @return the lab detailed course identification persistence
	 */
	public labDetailedCourseIdentificationPersistence getlabDetailedCourseIdentificationPersistence() {
		return labDetailedCourseIdentificationPersistence;
	}

	/**
	 * Sets the lab detailed course identification persistence.
	 *
	 * @param labDetailedCourseIdentificationPersistence the lab detailed course identification persistence
	 */
	public void setlabDetailedCourseIdentificationPersistence(
		labDetailedCourseIdentificationPersistence labDetailedCourseIdentificationPersistence) {
		this.labDetailedCourseIdentificationPersistence = labDetailedCourseIdentificationPersistence;
	}

	@BeanReference(type = labDetailedCourseIdentificationPersistence.class)
	protected labDetailedCourseIdentificationPersistence labDetailedCourseIdentificationPersistence;
}