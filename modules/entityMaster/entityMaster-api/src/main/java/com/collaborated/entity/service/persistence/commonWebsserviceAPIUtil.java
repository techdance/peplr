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

import com.collaborated.entity.model.commonWebsserviceAPI;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the common websservice a p i service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.commonWebsserviceAPIPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPIPersistence
 * @see com.collaborated.entity.service.persistence.impl.commonWebsserviceAPIPersistenceImpl
 * @generated
 */
@ProviderType
public class commonWebsserviceAPIUtil {
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
	public static void clearCache(commonWebsserviceAPI commonWebsserviceAPI) {
		getPersistence().clearCache(commonWebsserviceAPI);
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
	public static List<commonWebsserviceAPI> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<commonWebsserviceAPI> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<commonWebsserviceAPI> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<commonWebsserviceAPI> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static commonWebsserviceAPI update(
		commonWebsserviceAPI commonWebsserviceAPI) {
		return getPersistence().update(commonWebsserviceAPI);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static commonWebsserviceAPI update(
		commonWebsserviceAPI commonWebsserviceAPI, ServiceContext serviceContext) {
		return getPersistence().update(commonWebsserviceAPI, serviceContext);
	}

	/**
	* Caches the common websservice a p i in the entity cache if it is enabled.
	*
	* @param commonWebsserviceAPI the common websservice a p i
	*/
	public static void cacheResult(commonWebsserviceAPI commonWebsserviceAPI) {
		getPersistence().cacheResult(commonWebsserviceAPI);
	}

	/**
	* Caches the common websservice a p is in the entity cache if it is enabled.
	*
	* @param commonWebsserviceAPIs the common websservice a p is
	*/
	public static void cacheResult(
		List<commonWebsserviceAPI> commonWebsserviceAPIs) {
		getPersistence().cacheResult(commonWebsserviceAPIs);
	}

	/**
	* Creates a new common websservice a p i with the primary key. Does not add the common websservice a p i to the database.
	*
	* @param commonAPIId the primary key for the new common websservice a p i
	* @return the new common websservice a p i
	*/
	public static commonWebsserviceAPI create(long commonAPIId) {
		return getPersistence().create(commonAPIId);
	}

	/**
	* Removes the common websservice a p i with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i that was removed
	* @throws NoSuchcommonWebsserviceAPIException if a common websservice a p i with the primary key could not be found
	*/
	public static commonWebsserviceAPI remove(long commonAPIId)
		throws com.collaborated.entity.exception.NoSuchcommonWebsserviceAPIException {
		return getPersistence().remove(commonAPIId);
	}

	public static commonWebsserviceAPI updateImpl(
		commonWebsserviceAPI commonWebsserviceAPI) {
		return getPersistence().updateImpl(commonWebsserviceAPI);
	}

	/**
	* Returns the common websservice a p i with the primary key or throws a {@link NoSuchcommonWebsserviceAPIException} if it could not be found.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i
	* @throws NoSuchcommonWebsserviceAPIException if a common websservice a p i with the primary key could not be found
	*/
	public static commonWebsserviceAPI findByPrimaryKey(long commonAPIId)
		throws com.collaborated.entity.exception.NoSuchcommonWebsserviceAPIException {
		return getPersistence().findByPrimaryKey(commonAPIId);
	}

	/**
	* Returns the common websservice a p i with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i, or <code>null</code> if a common websservice a p i with the primary key could not be found
	*/
	public static commonWebsserviceAPI fetchByPrimaryKey(long commonAPIId) {
		return getPersistence().fetchByPrimaryKey(commonAPIId);
	}

	public static java.util.Map<java.io.Serializable, commonWebsserviceAPI> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the common websservice a p is.
	*
	* @return the common websservice a p is
	*/
	public static List<commonWebsserviceAPI> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the common websservice a p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common websservice a p is
	* @param end the upper bound of the range of common websservice a p is (not inclusive)
	* @return the range of common websservice a p is
	*/
	public static List<commonWebsserviceAPI> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the common websservice a p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common websservice a p is
	* @param end the upper bound of the range of common websservice a p is (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of common websservice a p is
	*/
	public static List<commonWebsserviceAPI> findAll(int start, int end,
		OrderByComparator<commonWebsserviceAPI> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the common websservice a p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common websservice a p is
	* @param end the upper bound of the range of common websservice a p is (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of common websservice a p is
	*/
	public static List<commonWebsserviceAPI> findAll(int start, int end,
		OrderByComparator<commonWebsserviceAPI> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the common websservice a p is from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of common websservice a p is.
	*
	* @return the number of common websservice a p is
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static commonWebsserviceAPIPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<commonWebsserviceAPIPersistence, commonWebsserviceAPIPersistence> _serviceTracker =
		ServiceTrackerFactory.open(commonWebsserviceAPIPersistence.class);
}