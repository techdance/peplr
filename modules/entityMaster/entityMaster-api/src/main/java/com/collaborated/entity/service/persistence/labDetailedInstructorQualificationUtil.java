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

import com.collaborated.entity.model.labDetailedInstructorQualification;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lab detailed instructor qualification service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.labDetailedInstructorQualificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedInstructorQualificationPersistence
 * @see com.collaborated.entity.service.persistence.impl.labDetailedInstructorQualificationPersistenceImpl
 * @generated
 */
@ProviderType
public class labDetailedInstructorQualificationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		getPersistence().clearCache(labDetailedInstructorQualification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<labDetailedInstructorQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<labDetailedInstructorQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<labDetailedInstructorQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<labDetailedInstructorQualification> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static labDetailedInstructorQualification update(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		return getPersistence().update(labDetailedInstructorQualification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static labDetailedInstructorQualification update(
		labDetailedInstructorQualification labDetailedInstructorQualification,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(labDetailedInstructorQualification, serviceContext);
	}

	/**
	* Returns the lab detailed instructor qualification where PK_courseId = &#63; or throws a {@link NoSuchlabDetailedInstructorQualificationException} if it could not be found.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed instructor qualification
	* @throws NoSuchlabDetailedInstructorQualificationException if a matching lab detailed instructor qualification could not be found
	*/
	public static labDetailedInstructorQualification findBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedInstructorQualificationException {
		return getPersistence()
				   .findBygetCourseInstructorQualificationbyCourseId(PK_courseId);
	}

	/**
	* Returns the lab detailed instructor qualification where PK_courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed instructor qualification, or <code>null</code> if a matching lab detailed instructor qualification could not be found
	*/
	public static labDetailedInstructorQualification fetchBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId) {
		return getPersistence()
				   .fetchBygetCourseInstructorQualificationbyCourseId(PK_courseId);
	}

	/**
	* Returns the lab detailed instructor qualification where PK_courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lab detailed instructor qualification, or <code>null</code> if a matching lab detailed instructor qualification could not be found
	*/
	public static labDetailedInstructorQualification fetchBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBygetCourseInstructorQualificationbyCourseId(PK_courseId,
			retrieveFromCache);
	}

	/**
	* Removes the lab detailed instructor qualification where PK_courseId = &#63; from the database.
	*
	* @param PK_courseId the p k_course ID
	* @return the lab detailed instructor qualification that was removed
	*/
	public static labDetailedInstructorQualification removeBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedInstructorQualificationException {
		return getPersistence()
				   .removeBygetCourseInstructorQualificationbyCourseId(PK_courseId);
	}

	/**
	* Returns the number of lab detailed instructor qualifications where PK_courseId = &#63;.
	*
	* @param PK_courseId the p k_course ID
	* @return the number of matching lab detailed instructor qualifications
	*/
	public static int countBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId) {
		return getPersistence()
				   .countBygetCourseInstructorQualificationbyCourseId(PK_courseId);
	}

	/**
	* Caches the lab detailed instructor qualification in the entity cache if it is enabled.
	*
	* @param labDetailedInstructorQualification the lab detailed instructor qualification
	*/
	public static void cacheResult(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		getPersistence().cacheResult(labDetailedInstructorQualification);
	}

	/**
	* Caches the lab detailed instructor qualifications in the entity cache if it is enabled.
	*
	* @param labDetailedInstructorQualifications the lab detailed instructor qualifications
	*/
	public static void cacheResult(
		List<labDetailedInstructorQualification> labDetailedInstructorQualifications) {
		getPersistence().cacheResult(labDetailedInstructorQualifications);
	}

	/**
	* Creates a new lab detailed instructor qualification with the primary key. Does not add the lab detailed instructor qualification to the database.
	*
	* @param PK_courseInstructorQualificationId the primary key for the new lab detailed instructor qualification
	* @return the new lab detailed instructor qualification
	*/
	public static labDetailedInstructorQualification create(
		long PK_courseInstructorQualificationId) {
		return getPersistence().create(PK_courseInstructorQualificationId);
	}

	/**
	* Removes the lab detailed instructor qualification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	* @return the lab detailed instructor qualification that was removed
	* @throws NoSuchlabDetailedInstructorQualificationException if a lab detailed instructor qualification with the primary key could not be found
	*/
	public static labDetailedInstructorQualification remove(
		long PK_courseInstructorQualificationId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedInstructorQualificationException {
		return getPersistence().remove(PK_courseInstructorQualificationId);
	}

	public static labDetailedInstructorQualification updateImpl(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		return getPersistence().updateImpl(labDetailedInstructorQualification);
	}

	/**
	* Returns the lab detailed instructor qualification with the primary key or throws a {@link NoSuchlabDetailedInstructorQualificationException} if it could not be found.
	*
	* @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	* @return the lab detailed instructor qualification
	* @throws NoSuchlabDetailedInstructorQualificationException if a lab detailed instructor qualification with the primary key could not be found
	*/
	public static labDetailedInstructorQualification findByPrimaryKey(
		long PK_courseInstructorQualificationId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedInstructorQualificationException {
		return getPersistence()
				   .findByPrimaryKey(PK_courseInstructorQualificationId);
	}

	/**
	* Returns the lab detailed instructor qualification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	* @return the lab detailed instructor qualification, or <code>null</code> if a lab detailed instructor qualification with the primary key could not be found
	*/
	public static labDetailedInstructorQualification fetchByPrimaryKey(
		long PK_courseInstructorQualificationId) {
		return getPersistence()
				   .fetchByPrimaryKey(PK_courseInstructorQualificationId);
	}

	public static java.util.Map<java.io.Serializable, labDetailedInstructorQualification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lab detailed instructor qualifications.
	*
	* @return the lab detailed instructor qualifications
	*/
	public static List<labDetailedInstructorQualification> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<labDetailedInstructorQualification> findAll(int start,
		int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<labDetailedInstructorQualification> findAll(int start,
		int end,
		OrderByComparator<labDetailedInstructorQualification> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<labDetailedInstructorQualification> findAll(int start,
		int end,
		OrderByComparator<labDetailedInstructorQualification> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lab detailed instructor qualifications from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lab detailed instructor qualifications.
	*
	* @return the number of lab detailed instructor qualifications
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static labDetailedInstructorQualificationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<labDetailedInstructorQualificationPersistence, labDetailedInstructorQualificationPersistence> _serviceTracker =
		ServiceTrackerFactory.open(labDetailedInstructorQualificationPersistence.class);
}