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

import com.collaborated.entity.model.profileAreaofinterest;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the profile areaofinterest service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.profileAreaofinterestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileAreaofinterestPersistence
 * @see com.collaborated.entity.service.persistence.impl.profileAreaofinterestPersistenceImpl
 * @generated
 */
@ProviderType
public class profileAreaofinterestUtil {
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
	public static void clearCache(profileAreaofinterest profileAreaofinterest) {
		getPersistence().clearCache(profileAreaofinterest);
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
	public static List<profileAreaofinterest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<profileAreaofinterest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<profileAreaofinterest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<profileAreaofinterest> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static profileAreaofinterest update(
		profileAreaofinterest profileAreaofinterest) {
		return getPersistence().update(profileAreaofinterest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static profileAreaofinterest update(
		profileAreaofinterest profileAreaofinterest,
		ServiceContext serviceContext) {
		return getPersistence().update(profileAreaofinterest, serviceContext);
	}

	/**
	* Caches the profile areaofinterest in the entity cache if it is enabled.
	*
	* @param profileAreaofinterest the profile areaofinterest
	*/
	public static void cacheResult(profileAreaofinterest profileAreaofinterest) {
		getPersistence().cacheResult(profileAreaofinterest);
	}

	/**
	* Caches the profile areaofinterests in the entity cache if it is enabled.
	*
	* @param profileAreaofinterests the profile areaofinterests
	*/
	public static void cacheResult(
		List<profileAreaofinterest> profileAreaofinterests) {
		getPersistence().cacheResult(profileAreaofinterests);
	}

	/**
	* Creates a new profile areaofinterest with the primary key. Does not add the profile areaofinterest to the database.
	*
	* @param PK_areaofinterest the primary key for the new profile areaofinterest
	* @return the new profile areaofinterest
	*/
	public static profileAreaofinterest create(long PK_areaofinterest) {
		return getPersistence().create(PK_areaofinterest);
	}

	/**
	* Removes the profile areaofinterest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_areaofinterest the primary key of the profile areaofinterest
	* @return the profile areaofinterest that was removed
	* @throws NoSuchprofileAreaofinterestException if a profile areaofinterest with the primary key could not be found
	*/
	public static profileAreaofinterest remove(long PK_areaofinterest)
		throws com.collaborated.entity.exception.NoSuchprofileAreaofinterestException {
		return getPersistence().remove(PK_areaofinterest);
	}

	public static profileAreaofinterest updateImpl(
		profileAreaofinterest profileAreaofinterest) {
		return getPersistence().updateImpl(profileAreaofinterest);
	}

	/**
	* Returns the profile areaofinterest with the primary key or throws a {@link NoSuchprofileAreaofinterestException} if it could not be found.
	*
	* @param PK_areaofinterest the primary key of the profile areaofinterest
	* @return the profile areaofinterest
	* @throws NoSuchprofileAreaofinterestException if a profile areaofinterest with the primary key could not be found
	*/
	public static profileAreaofinterest findByPrimaryKey(long PK_areaofinterest)
		throws com.collaborated.entity.exception.NoSuchprofileAreaofinterestException {
		return getPersistence().findByPrimaryKey(PK_areaofinterest);
	}

	/**
	* Returns the profile areaofinterest with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_areaofinterest the primary key of the profile areaofinterest
	* @return the profile areaofinterest, or <code>null</code> if a profile areaofinterest with the primary key could not be found
	*/
	public static profileAreaofinterest fetchByPrimaryKey(
		long PK_areaofinterest) {
		return getPersistence().fetchByPrimaryKey(PK_areaofinterest);
	}

	public static java.util.Map<java.io.Serializable, profileAreaofinterest> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the profile areaofinterests.
	*
	* @return the profile areaofinterests
	*/
	public static List<profileAreaofinterest> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the profile areaofinterests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile areaofinterests
	* @param end the upper bound of the range of profile areaofinterests (not inclusive)
	* @return the range of profile areaofinterests
	*/
	public static List<profileAreaofinterest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the profile areaofinterests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile areaofinterests
	* @param end the upper bound of the range of profile areaofinterests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of profile areaofinterests
	*/
	public static List<profileAreaofinterest> findAll(int start, int end,
		OrderByComparator<profileAreaofinterest> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the profile areaofinterests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile areaofinterests
	* @param end the upper bound of the range of profile areaofinterests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of profile areaofinterests
	*/
	public static List<profileAreaofinterest> findAll(int start, int end,
		OrderByComparator<profileAreaofinterest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the profile areaofinterests from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of profile areaofinterests.
	*
	* @return the number of profile areaofinterests
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static profileAreaofinterestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<profileAreaofinterestPersistence, profileAreaofinterestPersistence> _serviceTracker =
		ServiceTrackerFactory.open(profileAreaofinterestPersistence.class);
}