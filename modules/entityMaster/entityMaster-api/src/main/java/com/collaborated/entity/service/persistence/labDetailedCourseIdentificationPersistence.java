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

import com.collaborated.entity.exception.NoSuchlabDetailedCourseIdentificationException;
import com.collaborated.entity.model.labDetailedCourseIdentification;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab detailed course identification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labDetailedCourseIdentificationPersistenceImpl
 * @see labDetailedCourseIdentificationUtil
 * @generated
 */
@ProviderType
public interface labDetailedCourseIdentificationPersistence
	extends BasePersistence<labDetailedCourseIdentification> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labDetailedCourseIdentificationUtil} to access the lab detailed course identification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the lab detailed course identification where PK_projectId = &#63; or throws a {@link NoSuchlabDetailedCourseIdentificationException} if it could not be found.
	*
	* @param PK_projectId the p k_project ID
	* @return the matching lab detailed course identification
	* @throws NoSuchlabDetailedCourseIdentificationException if a matching lab detailed course identification could not be found
	*/
	public labDetailedCourseIdentification findByfetchCourseIdentificationbyProjectId(
		long PK_projectId)
		throws NoSuchlabDetailedCourseIdentificationException;

	/**
	* Returns the lab detailed course identification where PK_projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PK_projectId the p k_project ID
	* @return the matching lab detailed course identification, or <code>null</code> if a matching lab detailed course identification could not be found
	*/
	public labDetailedCourseIdentification fetchByfetchCourseIdentificationbyProjectId(
		long PK_projectId);

	/**
	* Returns the lab detailed course identification where PK_projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PK_projectId the p k_project ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lab detailed course identification, or <code>null</code> if a matching lab detailed course identification could not be found
	*/
	public labDetailedCourseIdentification fetchByfetchCourseIdentificationbyProjectId(
		long PK_projectId, boolean retrieveFromCache);

	/**
	* Removes the lab detailed course identification where PK_projectId = &#63; from the database.
	*
	* @param PK_projectId the p k_project ID
	* @return the lab detailed course identification that was removed
	*/
	public labDetailedCourseIdentification removeByfetchCourseIdentificationbyProjectId(
		long PK_projectId)
		throws NoSuchlabDetailedCourseIdentificationException;

	/**
	* Returns the number of lab detailed course identifications where PK_projectId = &#63;.
	*
	* @param PK_projectId the p k_project ID
	* @return the number of matching lab detailed course identifications
	*/
	public int countByfetchCourseIdentificationbyProjectId(long PK_projectId);

	/**
	* Caches the lab detailed course identification in the entity cache if it is enabled.
	*
	* @param labDetailedCourseIdentification the lab detailed course identification
	*/
	public void cacheResult(
		labDetailedCourseIdentification labDetailedCourseIdentification);

	/**
	* Caches the lab detailed course identifications in the entity cache if it is enabled.
	*
	* @param labDetailedCourseIdentifications the lab detailed course identifications
	*/
	public void cacheResult(
		java.util.List<labDetailedCourseIdentification> labDetailedCourseIdentifications);

	/**
	* Creates a new lab detailed course identification with the primary key. Does not add the lab detailed course identification to the database.
	*
	* @param PK_courseId the primary key for the new lab detailed course identification
	* @return the new lab detailed course identification
	*/
	public labDetailedCourseIdentification create(long PK_courseId);

	/**
	* Removes the lab detailed course identification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseId the primary key of the lab detailed course identification
	* @return the lab detailed course identification that was removed
	* @throws NoSuchlabDetailedCourseIdentificationException if a lab detailed course identification with the primary key could not be found
	*/
	public labDetailedCourseIdentification remove(long PK_courseId)
		throws NoSuchlabDetailedCourseIdentificationException;

	public labDetailedCourseIdentification updateImpl(
		labDetailedCourseIdentification labDetailedCourseIdentification);

	/**
	* Returns the lab detailed course identification with the primary key or throws a {@link NoSuchlabDetailedCourseIdentificationException} if it could not be found.
	*
	* @param PK_courseId the primary key of the lab detailed course identification
	* @return the lab detailed course identification
	* @throws NoSuchlabDetailedCourseIdentificationException if a lab detailed course identification with the primary key could not be found
	*/
	public labDetailedCourseIdentification findByPrimaryKey(long PK_courseId)
		throws NoSuchlabDetailedCourseIdentificationException;

	/**
	* Returns the lab detailed course identification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_courseId the primary key of the lab detailed course identification
	* @return the lab detailed course identification, or <code>null</code> if a lab detailed course identification with the primary key could not be found
	*/
	public labDetailedCourseIdentification fetchByPrimaryKey(long PK_courseId);

	@Override
	public java.util.Map<java.io.Serializable, labDetailedCourseIdentification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab detailed course identifications.
	*
	* @return the lab detailed course identifications
	*/
	public java.util.List<labDetailedCourseIdentification> findAll();

	/**
	* Returns a range of all the lab detailed course identifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseIdentificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course identifications
	* @param end the upper bound of the range of lab detailed course identifications (not inclusive)
	* @return the range of lab detailed course identifications
	*/
	public java.util.List<labDetailedCourseIdentification> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the lab detailed course identifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseIdentificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course identifications
	* @param end the upper bound of the range of lab detailed course identifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailed course identifications
	*/
	public java.util.List<labDetailedCourseIdentification> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseIdentification> orderByComparator);

	/**
	* Returns an ordered range of all the lab detailed course identifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseIdentificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course identifications
	* @param end the upper bound of the range of lab detailed course identifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailed course identifications
	*/
	public java.util.List<labDetailedCourseIdentification> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseIdentification> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab detailed course identifications from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab detailed course identifications.
	*
	* @return the number of lab detailed course identifications
	*/
	public int countAll();
}