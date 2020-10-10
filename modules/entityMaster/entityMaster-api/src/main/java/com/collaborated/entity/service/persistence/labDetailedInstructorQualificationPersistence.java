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

import com.collaborated.entity.exception.NoSuchlabDetailedInstructorQualificationException;
import com.collaborated.entity.model.labDetailedInstructorQualification;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab detailed instructor qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labDetailedInstructorQualificationPersistenceImpl
 * @see labDetailedInstructorQualificationUtil
 * @generated
 */
@ProviderType
public interface labDetailedInstructorQualificationPersistence
	extends BasePersistence<labDetailedInstructorQualification> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labDetailedInstructorQualificationUtil} to access the lab detailed instructor qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the lab detailed instructor qualification where PK_courseId = &#63; or throws a {@link NoSuchlabDetailedInstructorQualificationException} if it could not be found.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed instructor qualification
	* @throws NoSuchlabDetailedInstructorQualificationException if a matching lab detailed instructor qualification could not be found
	*/
	public labDetailedInstructorQualification findBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId)
		throws NoSuchlabDetailedInstructorQualificationException;

	/**
	* Returns the lab detailed instructor qualification where PK_courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed instructor qualification, or <code>null</code> if a matching lab detailed instructor qualification could not be found
	*/
	public labDetailedInstructorQualification fetchBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId);

	/**
	* Returns the lab detailed instructor qualification where PK_courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lab detailed instructor qualification, or <code>null</code> if a matching lab detailed instructor qualification could not be found
	*/
	public labDetailedInstructorQualification fetchBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId, boolean retrieveFromCache);

	/**
	* Removes the lab detailed instructor qualification where PK_courseId = &#63; from the database.
	*
	* @param PK_courseId the p k_course ID
	* @return the lab detailed instructor qualification that was removed
	*/
	public labDetailedInstructorQualification removeBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId)
		throws NoSuchlabDetailedInstructorQualificationException;

	/**
	* Returns the number of lab detailed instructor qualifications where PK_courseId = &#63;.
	*
	* @param PK_courseId the p k_course ID
	* @return the number of matching lab detailed instructor qualifications
	*/
	public int countBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId);

	/**
	* Caches the lab detailed instructor qualification in the entity cache if it is enabled.
	*
	* @param labDetailedInstructorQualification the lab detailed instructor qualification
	*/
	public void cacheResult(
		labDetailedInstructorQualification labDetailedInstructorQualification);

	/**
	* Caches the lab detailed instructor qualifications in the entity cache if it is enabled.
	*
	* @param labDetailedInstructorQualifications the lab detailed instructor qualifications
	*/
	public void cacheResult(
		java.util.List<labDetailedInstructorQualification> labDetailedInstructorQualifications);

	/**
	* Creates a new lab detailed instructor qualification with the primary key. Does not add the lab detailed instructor qualification to the database.
	*
	* @param PK_courseInstructorQualificationId the primary key for the new lab detailed instructor qualification
	* @return the new lab detailed instructor qualification
	*/
	public labDetailedInstructorQualification create(
		long PK_courseInstructorQualificationId);

	/**
	* Removes the lab detailed instructor qualification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	* @return the lab detailed instructor qualification that was removed
	* @throws NoSuchlabDetailedInstructorQualificationException if a lab detailed instructor qualification with the primary key could not be found
	*/
	public labDetailedInstructorQualification remove(
		long PK_courseInstructorQualificationId)
		throws NoSuchlabDetailedInstructorQualificationException;

	public labDetailedInstructorQualification updateImpl(
		labDetailedInstructorQualification labDetailedInstructorQualification);

	/**
	* Returns the lab detailed instructor qualification with the primary key or throws a {@link NoSuchlabDetailedInstructorQualificationException} if it could not be found.
	*
	* @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	* @return the lab detailed instructor qualification
	* @throws NoSuchlabDetailedInstructorQualificationException if a lab detailed instructor qualification with the primary key could not be found
	*/
	public labDetailedInstructorQualification findByPrimaryKey(
		long PK_courseInstructorQualificationId)
		throws NoSuchlabDetailedInstructorQualificationException;

	/**
	* Returns the lab detailed instructor qualification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	* @return the lab detailed instructor qualification, or <code>null</code> if a lab detailed instructor qualification with the primary key could not be found
	*/
	public labDetailedInstructorQualification fetchByPrimaryKey(
		long PK_courseInstructorQualificationId);

	@Override
	public java.util.Map<java.io.Serializable, labDetailedInstructorQualification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab detailed instructor qualifications.
	*
	* @return the lab detailed instructor qualifications
	*/
	public java.util.List<labDetailedInstructorQualification> findAll();

	/**
	* Returns a range of all the lab detailed instructor qualifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedInstructorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed instructor qualifications
	* @param end the upper bound of the range of lab detailed instructor qualifications (not inclusive)
	* @return the range of lab detailed instructor qualifications
	*/
	public java.util.List<labDetailedInstructorQualification> findAll(
		int start, int end);

	/**
	* Returns an ordered range of all the lab detailed instructor qualifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedInstructorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed instructor qualifications
	* @param end the upper bound of the range of lab detailed instructor qualifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailed instructor qualifications
	*/
	public java.util.List<labDetailedInstructorQualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedInstructorQualification> orderByComparator);

	/**
	* Returns an ordered range of all the lab detailed instructor qualifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedInstructorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed instructor qualifications
	* @param end the upper bound of the range of lab detailed instructor qualifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailed instructor qualifications
	*/
	public java.util.List<labDetailedInstructorQualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedInstructorQualification> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab detailed instructor qualifications from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab detailed instructor qualifications.
	*
	* @return the number of lab detailed instructor qualifications
	*/
	public int countAll();
}