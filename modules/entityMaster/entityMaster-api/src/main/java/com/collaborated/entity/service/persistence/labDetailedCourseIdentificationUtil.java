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

import com.collaborated.entity.model.labDetailedCourseIdentification;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lab detailed course identification service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.labDetailedCourseIdentificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseIdentificationPersistence
 * @see com.collaborated.entity.service.persistence.impl.labDetailedCourseIdentificationPersistenceImpl
 * @generated
 */
@ProviderType
public class labDetailedCourseIdentificationUtil {
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
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		getPersistence().clearCache(labDetailedCourseIdentification);
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
	public static List<labDetailedCourseIdentification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<labDetailedCourseIdentification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<labDetailedCourseIdentification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<labDetailedCourseIdentification> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static labDetailedCourseIdentification update(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		return getPersistence().update(labDetailedCourseIdentification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static labDetailedCourseIdentification update(
		labDetailedCourseIdentification labDetailedCourseIdentification,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(labDetailedCourseIdentification, serviceContext);
	}

	/**
	* Returns the lab detailed course identification where PK_projectId = &#63; or throws a {@link NoSuchlabDetailedCourseIdentificationException} if it could not be found.
	*
	* @param PK_projectId the p k_project ID
	* @return the matching lab detailed course identification
	* @throws NoSuchlabDetailedCourseIdentificationException if a matching lab detailed course identification could not be found
	*/
	public static labDetailedCourseIdentification findByfetchCourseIdentificationbyProjectId(
		long PK_projectId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedCourseIdentificationException {
		return getPersistence()
				   .findByfetchCourseIdentificationbyProjectId(PK_projectId);
	}

	/**
	* Returns the lab detailed course identification where PK_projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PK_projectId the p k_project ID
	* @return the matching lab detailed course identification, or <code>null</code> if a matching lab detailed course identification could not be found
	*/
	public static labDetailedCourseIdentification fetchByfetchCourseIdentificationbyProjectId(
		long PK_projectId) {
		return getPersistence()
				   .fetchByfetchCourseIdentificationbyProjectId(PK_projectId);
	}

	/**
	* Returns the lab detailed course identification where PK_projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PK_projectId the p k_project ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lab detailed course identification, or <code>null</code> if a matching lab detailed course identification could not be found
	*/
	public static labDetailedCourseIdentification fetchByfetchCourseIdentificationbyProjectId(
		long PK_projectId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByfetchCourseIdentificationbyProjectId(PK_projectId,
			retrieveFromCache);
	}

	/**
	* Removes the lab detailed course identification where PK_projectId = &#63; from the database.
	*
	* @param PK_projectId the p k_project ID
	* @return the lab detailed course identification that was removed
	*/
	public static labDetailedCourseIdentification removeByfetchCourseIdentificationbyProjectId(
		long PK_projectId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedCourseIdentificationException {
		return getPersistence()
				   .removeByfetchCourseIdentificationbyProjectId(PK_projectId);
	}

	/**
	* Returns the number of lab detailed course identifications where PK_projectId = &#63;.
	*
	* @param PK_projectId the p k_project ID
	* @return the number of matching lab detailed course identifications
	*/
	public static int countByfetchCourseIdentificationbyProjectId(
		long PK_projectId) {
		return getPersistence()
				   .countByfetchCourseIdentificationbyProjectId(PK_projectId);
	}

	/**
	* Caches the lab detailed course identification in the entity cache if it is enabled.
	*
	* @param labDetailedCourseIdentification the lab detailed course identification
	*/
	public static void cacheResult(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		getPersistence().cacheResult(labDetailedCourseIdentification);
	}

	/**
	* Caches the lab detailed course identifications in the entity cache if it is enabled.
	*
	* @param labDetailedCourseIdentifications the lab detailed course identifications
	*/
	public static void cacheResult(
		List<labDetailedCourseIdentification> labDetailedCourseIdentifications) {
		getPersistence().cacheResult(labDetailedCourseIdentifications);
	}

	/**
	* Creates a new lab detailed course identification with the primary key. Does not add the lab detailed course identification to the database.
	*
	* @param PK_courseId the primary key for the new lab detailed course identification
	* @return the new lab detailed course identification
	*/
	public static labDetailedCourseIdentification create(long PK_courseId) {
		return getPersistence().create(PK_courseId);
	}

	/**
	* Removes the lab detailed course identification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseId the primary key of the lab detailed course identification
	* @return the lab detailed course identification that was removed
	* @throws NoSuchlabDetailedCourseIdentificationException if a lab detailed course identification with the primary key could not be found
	*/
	public static labDetailedCourseIdentification remove(long PK_courseId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedCourseIdentificationException {
		return getPersistence().remove(PK_courseId);
	}

	public static labDetailedCourseIdentification updateImpl(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		return getPersistence().updateImpl(labDetailedCourseIdentification);
	}

	/**
	* Returns the lab detailed course identification with the primary key or throws a {@link NoSuchlabDetailedCourseIdentificationException} if it could not be found.
	*
	* @param PK_courseId the primary key of the lab detailed course identification
	* @return the lab detailed course identification
	* @throws NoSuchlabDetailedCourseIdentificationException if a lab detailed course identification with the primary key could not be found
	*/
	public static labDetailedCourseIdentification findByPrimaryKey(
		long PK_courseId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedCourseIdentificationException {
		return getPersistence().findByPrimaryKey(PK_courseId);
	}

	/**
	* Returns the lab detailed course identification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_courseId the primary key of the lab detailed course identification
	* @return the lab detailed course identification, or <code>null</code> if a lab detailed course identification with the primary key could not be found
	*/
	public static labDetailedCourseIdentification fetchByPrimaryKey(
		long PK_courseId) {
		return getPersistence().fetchByPrimaryKey(PK_courseId);
	}

	public static java.util.Map<java.io.Serializable, labDetailedCourseIdentification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lab detailed course identifications.
	*
	* @return the lab detailed course identifications
	*/
	public static List<labDetailedCourseIdentification> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<labDetailedCourseIdentification> findAll(int start,
		int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<labDetailedCourseIdentification> findAll(int start,
		int end,
		OrderByComparator<labDetailedCourseIdentification> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<labDetailedCourseIdentification> findAll(int start,
		int end,
		OrderByComparator<labDetailedCourseIdentification> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lab detailed course identifications from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lab detailed course identifications.
	*
	* @return the number of lab detailed course identifications
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static labDetailedCourseIdentificationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<labDetailedCourseIdentificationPersistence, labDetailedCourseIdentificationPersistence> _serviceTracker =
		ServiceTrackerFactory.open(labDetailedCourseIdentificationPersistence.class);
}