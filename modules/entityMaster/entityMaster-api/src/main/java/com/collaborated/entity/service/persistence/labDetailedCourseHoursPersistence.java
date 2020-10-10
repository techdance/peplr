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

package com.collaborated.entity.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.collaborated.entity.exception.NoSuchlabDetailedCourseHoursException;
import com.collaborated.entity.model.labDetailedCourseHours;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab detailed course hours service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labDetailedCourseHoursPersistenceImpl
 * @see labDetailedCourseHoursUtil
 * @generated
 */
@ProviderType
public interface labDetailedCourseHoursPersistence extends BasePersistence<labDetailedCourseHours> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labDetailedCourseHoursUtil} to access the lab detailed course hours persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the lab detailed course hours where PK_courseId = &#63; or throws a {@link NoSuchlabDetailedCourseHoursException} if it could not be found.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed course hours
	* @throws NoSuchlabDetailedCourseHoursException if a matching lab detailed course hours could not be found
	*/
	public labDetailedCourseHours findBygetCourseHoursbyCourseId(
		long PK_courseId) throws NoSuchlabDetailedCourseHoursException;

	/**
	* Returns the lab detailed course hours where PK_courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed course hours, or <code>null</code> if a matching lab detailed course hours could not be found
	*/
	public labDetailedCourseHours fetchBygetCourseHoursbyCourseId(
		long PK_courseId);

	/**
	* Returns the lab detailed course hours where PK_courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lab detailed course hours, or <code>null</code> if a matching lab detailed course hours could not be found
	*/
	public labDetailedCourseHours fetchBygetCourseHoursbyCourseId(
		long PK_courseId, boolean retrieveFromCache);

	/**
	* Removes the lab detailed course hours where PK_courseId = &#63; from the database.
	*
	* @param PK_courseId the p k_course ID
	* @return the lab detailed course hours that was removed
	*/
	public labDetailedCourseHours removeBygetCourseHoursbyCourseId(
		long PK_courseId) throws NoSuchlabDetailedCourseHoursException;

	/**
	* Returns the number of lab detailed course hourses where PK_courseId = &#63;.
	*
	* @param PK_courseId the p k_course ID
	* @return the number of matching lab detailed course hourses
	*/
	public int countBygetCourseHoursbyCourseId(long PK_courseId);

	/**
	* Caches the lab detailed course hours in the entity cache if it is enabled.
	*
	* @param labDetailedCourseHours the lab detailed course hours
	*/
	public void cacheResult(labDetailedCourseHours labDetailedCourseHours);

	/**
	* Caches the lab detailed course hourses in the entity cache if it is enabled.
	*
	* @param labDetailedCourseHourses the lab detailed course hourses
	*/
	public void cacheResult(
		java.util.List<labDetailedCourseHours> labDetailedCourseHourses);

	/**
	* Creates a new lab detailed course hours with the primary key. Does not add the lab detailed course hours to the database.
	*
	* @param PK_courseHoursId the primary key for the new lab detailed course hours
	* @return the new lab detailed course hours
	*/
	public labDetailedCourseHours create(long PK_courseHoursId);

	/**
	* Removes the lab detailed course hours with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseHoursId the primary key of the lab detailed course hours
	* @return the lab detailed course hours that was removed
	* @throws NoSuchlabDetailedCourseHoursException if a lab detailed course hours with the primary key could not be found
	*/
	public labDetailedCourseHours remove(long PK_courseHoursId)
		throws NoSuchlabDetailedCourseHoursException;

	public labDetailedCourseHours updateImpl(
		labDetailedCourseHours labDetailedCourseHours);

	/**
	* Returns the lab detailed course hours with the primary key or throws a {@link NoSuchlabDetailedCourseHoursException} if it could not be found.
	*
	* @param PK_courseHoursId the primary key of the lab detailed course hours
	* @return the lab detailed course hours
	* @throws NoSuchlabDetailedCourseHoursException if a lab detailed course hours with the primary key could not be found
	*/
	public labDetailedCourseHours findByPrimaryKey(long PK_courseHoursId)
		throws NoSuchlabDetailedCourseHoursException;

	/**
	* Returns the lab detailed course hours with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_courseHoursId the primary key of the lab detailed course hours
	* @return the lab detailed course hours, or <code>null</code> if a lab detailed course hours with the primary key could not be found
	*/
	public labDetailedCourseHours fetchByPrimaryKey(long PK_courseHoursId);

	@Override
	public java.util.Map<java.io.Serializable, labDetailedCourseHours> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab detailed course hourses.
	*
	* @return the lab detailed course hourses
	*/
	public java.util.List<labDetailedCourseHours> findAll();

	/**
	* Returns a range of all the lab detailed course hourses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course hourses
	* @param end the upper bound of the range of lab detailed course hourses (not inclusive)
	* @return the range of lab detailed course hourses
	*/
	public java.util.List<labDetailedCourseHours> findAll(int start, int end);

	/**
	* Returns an ordered range of all the lab detailed course hourses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course hourses
	* @param end the upper bound of the range of lab detailed course hourses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailed course hourses
	*/
	public java.util.List<labDetailedCourseHours> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseHours> orderByComparator);

	/**
	* Returns an ordered range of all the lab detailed course hourses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course hourses
	* @param end the upper bound of the range of lab detailed course hourses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailed course hourses
	*/
	public java.util.List<labDetailedCourseHours> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseHours> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab detailed course hourses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab detailed course hourses.
	*
	* @return the number of lab detailed course hourses
	*/
	public int countAll();
}