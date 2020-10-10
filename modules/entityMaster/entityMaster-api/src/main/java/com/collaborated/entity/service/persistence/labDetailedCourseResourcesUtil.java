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

import com.collaborated.entity.model.labDetailedCourseResources;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lab detailed course resources service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.labDetailedCourseResourcesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseResourcesPersistence
 * @see com.collaborated.entity.service.persistence.impl.labDetailedCourseResourcesPersistenceImpl
 * @generated
 */
@ProviderType
public class labDetailedCourseResourcesUtil {
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
		labDetailedCourseResources labDetailedCourseResources) {
		getPersistence().clearCache(labDetailedCourseResources);
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
	public static List<labDetailedCourseResources> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<labDetailedCourseResources> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<labDetailedCourseResources> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<labDetailedCourseResources> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static labDetailedCourseResources update(
		labDetailedCourseResources labDetailedCourseResources) {
		return getPersistence().update(labDetailedCourseResources);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static labDetailedCourseResources update(
		labDetailedCourseResources labDetailedCourseResources,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(labDetailedCourseResources, serviceContext);
	}

	/**
	* Returns the lab detailed course resources where PK_courseId = &#63; or throws a {@link NoSuchlabDetailedCourseResourcesException} if it could not be found.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed course resources
	* @throws NoSuchlabDetailedCourseResourcesException if a matching lab detailed course resources could not be found
	*/
	public static labDetailedCourseResources findBygetCourseResourcesbyCourseId(
		long PK_courseId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedCourseResourcesException {
		return getPersistence().findBygetCourseResourcesbyCourseId(PK_courseId);
	}

	/**
	* Returns the lab detailed course resources where PK_courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed course resources, or <code>null</code> if a matching lab detailed course resources could not be found
	*/
	public static labDetailedCourseResources fetchBygetCourseResourcesbyCourseId(
		long PK_courseId) {
		return getPersistence().fetchBygetCourseResourcesbyCourseId(PK_courseId);
	}

	/**
	* Returns the lab detailed course resources where PK_courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lab detailed course resources, or <code>null</code> if a matching lab detailed course resources could not be found
	*/
	public static labDetailedCourseResources fetchBygetCourseResourcesbyCourseId(
		long PK_courseId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBygetCourseResourcesbyCourseId(PK_courseId,
			retrieveFromCache);
	}

	/**
	* Removes the lab detailed course resources where PK_courseId = &#63; from the database.
	*
	* @param PK_courseId the p k_course ID
	* @return the lab detailed course resources that was removed
	*/
	public static labDetailedCourseResources removeBygetCourseResourcesbyCourseId(
		long PK_courseId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedCourseResourcesException {
		return getPersistence().removeBygetCourseResourcesbyCourseId(PK_courseId);
	}

	/**
	* Returns the number of lab detailed course resourceses where PK_courseId = &#63;.
	*
	* @param PK_courseId the p k_course ID
	* @return the number of matching lab detailed course resourceses
	*/
	public static int countBygetCourseResourcesbyCourseId(long PK_courseId) {
		return getPersistence().countBygetCourseResourcesbyCourseId(PK_courseId);
	}

	/**
	* Caches the lab detailed course resources in the entity cache if it is enabled.
	*
	* @param labDetailedCourseResources the lab detailed course resources
	*/
	public static void cacheResult(
		labDetailedCourseResources labDetailedCourseResources) {
		getPersistence().cacheResult(labDetailedCourseResources);
	}

	/**
	* Caches the lab detailed course resourceses in the entity cache if it is enabled.
	*
	* @param labDetailedCourseResourceses the lab detailed course resourceses
	*/
	public static void cacheResult(
		List<labDetailedCourseResources> labDetailedCourseResourceses) {
		getPersistence().cacheResult(labDetailedCourseResourceses);
	}

	/**
	* Creates a new lab detailed course resources with the primary key. Does not add the lab detailed course resources to the database.
	*
	* @param PK_courseResourceId the primary key for the new lab detailed course resources
	* @return the new lab detailed course resources
	*/
	public static labDetailedCourseResources create(long PK_courseResourceId) {
		return getPersistence().create(PK_courseResourceId);
	}

	/**
	* Removes the lab detailed course resources with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseResourceId the primary key of the lab detailed course resources
	* @return the lab detailed course resources that was removed
	* @throws NoSuchlabDetailedCourseResourcesException if a lab detailed course resources with the primary key could not be found
	*/
	public static labDetailedCourseResources remove(long PK_courseResourceId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedCourseResourcesException {
		return getPersistence().remove(PK_courseResourceId);
	}

	public static labDetailedCourseResources updateImpl(
		labDetailedCourseResources labDetailedCourseResources) {
		return getPersistence().updateImpl(labDetailedCourseResources);
	}

	/**
	* Returns the lab detailed course resources with the primary key or throws a {@link NoSuchlabDetailedCourseResourcesException} if it could not be found.
	*
	* @param PK_courseResourceId the primary key of the lab detailed course resources
	* @return the lab detailed course resources
	* @throws NoSuchlabDetailedCourseResourcesException if a lab detailed course resources with the primary key could not be found
	*/
	public static labDetailedCourseResources findByPrimaryKey(
		long PK_courseResourceId)
		throws com.collaborated.entity.exception.NoSuchlabDetailedCourseResourcesException {
		return getPersistence().findByPrimaryKey(PK_courseResourceId);
	}

	/**
	* Returns the lab detailed course resources with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_courseResourceId the primary key of the lab detailed course resources
	* @return the lab detailed course resources, or <code>null</code> if a lab detailed course resources with the primary key could not be found
	*/
	public static labDetailedCourseResources fetchByPrimaryKey(
		long PK_courseResourceId) {
		return getPersistence().fetchByPrimaryKey(PK_courseResourceId);
	}

	public static java.util.Map<java.io.Serializable, labDetailedCourseResources> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lab detailed course resourceses.
	*
	* @return the lab detailed course resourceses
	*/
	public static List<labDetailedCourseResources> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lab detailed course resourceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course resourceses
	* @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	* @return the range of lab detailed course resourceses
	*/
	public static List<labDetailedCourseResources> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lab detailed course resourceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course resourceses
	* @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailed course resourceses
	*/
	public static List<labDetailedCourseResources> findAll(int start, int end,
		OrderByComparator<labDetailedCourseResources> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lab detailed course resourceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course resourceses
	* @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailed course resourceses
	*/
	public static List<labDetailedCourseResources> findAll(int start, int end,
		OrderByComparator<labDetailedCourseResources> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lab detailed course resourceses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lab detailed course resourceses.
	*
	* @return the number of lab detailed course resourceses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static labDetailedCourseResourcesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<labDetailedCourseResourcesPersistence, labDetailedCourseResourcesPersistence> _serviceTracker =
		ServiceTrackerFactory.open(labDetailedCourseResourcesPersistence.class);
}