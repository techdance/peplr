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

import com.collaborated.entity.model.labScreenProjectOverview;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lab screen project overview service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.labScreenProjectOverviewPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectOverviewPersistence
 * @see com.collaborated.entity.service.persistence.impl.labScreenProjectOverviewPersistenceImpl
 * @generated
 */
@ProviderType
public class labScreenProjectOverviewUtil {
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
		labScreenProjectOverview labScreenProjectOverview) {
		getPersistence().clearCache(labScreenProjectOverview);
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
	public static List<labScreenProjectOverview> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<labScreenProjectOverview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<labScreenProjectOverview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<labScreenProjectOverview> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static labScreenProjectOverview update(
		labScreenProjectOverview labScreenProjectOverview) {
		return getPersistence().update(labScreenProjectOverview);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static labScreenProjectOverview update(
		labScreenProjectOverview labScreenProjectOverview,
		ServiceContext serviceContext) {
		return getPersistence().update(labScreenProjectOverview, serviceContext);
	}

	/**
	* Caches the lab screen project overview in the entity cache if it is enabled.
	*
	* @param labScreenProjectOverview the lab screen project overview
	*/
	public static void cacheResult(
		labScreenProjectOverview labScreenProjectOverview) {
		getPersistence().cacheResult(labScreenProjectOverview);
	}

	/**
	* Caches the lab screen project overviews in the entity cache if it is enabled.
	*
	* @param labScreenProjectOverviews the lab screen project overviews
	*/
	public static void cacheResult(
		List<labScreenProjectOverview> labScreenProjectOverviews) {
		getPersistence().cacheResult(labScreenProjectOverviews);
	}

	/**
	* Creates a new lab screen project overview with the primary key. Does not add the lab screen project overview to the database.
	*
	* @param PK_projectId the primary key for the new lab screen project overview
	* @return the new lab screen project overview
	*/
	public static labScreenProjectOverview create(long PK_projectId) {
		return getPersistence().create(PK_projectId);
	}

	/**
	* Removes the lab screen project overview with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectId the primary key of the lab screen project overview
	* @return the lab screen project overview that was removed
	* @throws NoSuchlabScreenProjectOverviewException if a lab screen project overview with the primary key could not be found
	*/
	public static labScreenProjectOverview remove(long PK_projectId)
		throws com.collaborated.entity.exception.NoSuchlabScreenProjectOverviewException {
		return getPersistence().remove(PK_projectId);
	}

	public static labScreenProjectOverview updateImpl(
		labScreenProjectOverview labScreenProjectOverview) {
		return getPersistence().updateImpl(labScreenProjectOverview);
	}

	/**
	* Returns the lab screen project overview with the primary key or throws a {@link NoSuchlabScreenProjectOverviewException} if it could not be found.
	*
	* @param PK_projectId the primary key of the lab screen project overview
	* @return the lab screen project overview
	* @throws NoSuchlabScreenProjectOverviewException if a lab screen project overview with the primary key could not be found
	*/
	public static labScreenProjectOverview findByPrimaryKey(long PK_projectId)
		throws com.collaborated.entity.exception.NoSuchlabScreenProjectOverviewException {
		return getPersistence().findByPrimaryKey(PK_projectId);
	}

	/**
	* Returns the lab screen project overview with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_projectId the primary key of the lab screen project overview
	* @return the lab screen project overview, or <code>null</code> if a lab screen project overview with the primary key could not be found
	*/
	public static labScreenProjectOverview fetchByPrimaryKey(long PK_projectId) {
		return getPersistence().fetchByPrimaryKey(PK_projectId);
	}

	public static java.util.Map<java.io.Serializable, labScreenProjectOverview> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lab screen project overviews.
	*
	* @return the lab screen project overviews
	*/
	public static List<labScreenProjectOverview> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lab screen project overviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project overviews
	* @param end the upper bound of the range of lab screen project overviews (not inclusive)
	* @return the range of lab screen project overviews
	*/
	public static List<labScreenProjectOverview> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lab screen project overviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project overviews
	* @param end the upper bound of the range of lab screen project overviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab screen project overviews
	*/
	public static List<labScreenProjectOverview> findAll(int start, int end,
		OrderByComparator<labScreenProjectOverview> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lab screen project overviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project overviews
	* @param end the upper bound of the range of lab screen project overviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab screen project overviews
	*/
	public static List<labScreenProjectOverview> findAll(int start, int end,
		OrderByComparator<labScreenProjectOverview> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lab screen project overviews from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lab screen project overviews.
	*
	* @return the number of lab screen project overviews
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static labScreenProjectOverviewPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<labScreenProjectOverviewPersistence, labScreenProjectOverviewPersistence> _serviceTracker =
		ServiceTrackerFactory.open(labScreenProjectOverviewPersistence.class);
}