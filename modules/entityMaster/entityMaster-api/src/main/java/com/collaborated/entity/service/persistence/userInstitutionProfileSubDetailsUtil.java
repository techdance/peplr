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

import com.collaborated.entity.model.userInstitutionProfileSubDetails;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user institution profile sub details service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.userInstitutionProfileSubDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileSubDetailsPersistence
 * @see com.collaborated.entity.service.persistence.impl.userInstitutionProfileSubDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class userInstitutionProfileSubDetailsUtil {
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
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		getPersistence().clearCache(userInstitutionProfileSubDetails);
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
	public static List<userInstitutionProfileSubDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<userInstitutionProfileSubDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<userInstitutionProfileSubDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<userInstitutionProfileSubDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static userInstitutionProfileSubDetails update(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		return getPersistence().update(userInstitutionProfileSubDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static userInstitutionProfileSubDetails update(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(userInstitutionProfileSubDetails, serviceContext);
	}

	/**
	* Caches the user institution profile sub details in the entity cache if it is enabled.
	*
	* @param userInstitutionProfileSubDetails the user institution profile sub details
	*/
	public static void cacheResult(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		getPersistence().cacheResult(userInstitutionProfileSubDetails);
	}

	/**
	* Caches the user institution profile sub detailses in the entity cache if it is enabled.
	*
	* @param userInstitutionProfileSubDetailses the user institution profile sub detailses
	*/
	public static void cacheResult(
		List<userInstitutionProfileSubDetails> userInstitutionProfileSubDetailses) {
		getPersistence().cacheResult(userInstitutionProfileSubDetailses);
	}

	/**
	* Creates a new user institution profile sub details with the primary key. Does not add the user institution profile sub details to the database.
	*
	* @param PK_userInstitionSub the primary key for the new user institution profile sub details
	* @return the new user institution profile sub details
	*/
	public static userInstitutionProfileSubDetails create(
		long PK_userInstitionSub) {
		return getPersistence().create(PK_userInstitionSub);
	}

	/**
	* Removes the user institution profile sub details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_userInstitionSub the primary key of the user institution profile sub details
	* @return the user institution profile sub details that was removed
	* @throws NoSuchuserInstitutionProfileSubDetailsException if a user institution profile sub details with the primary key could not be found
	*/
	public static userInstitutionProfileSubDetails remove(
		long PK_userInstitionSub)
		throws com.collaborated.entity.exception.NoSuchuserInstitutionProfileSubDetailsException {
		return getPersistence().remove(PK_userInstitionSub);
	}

	public static userInstitutionProfileSubDetails updateImpl(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		return getPersistence().updateImpl(userInstitutionProfileSubDetails);
	}

	/**
	* Returns the user institution profile sub details with the primary key or throws a {@link NoSuchuserInstitutionProfileSubDetailsException} if it could not be found.
	*
	* @param PK_userInstitionSub the primary key of the user institution profile sub details
	* @return the user institution profile sub details
	* @throws NoSuchuserInstitutionProfileSubDetailsException if a user institution profile sub details with the primary key could not be found
	*/
	public static userInstitutionProfileSubDetails findByPrimaryKey(
		long PK_userInstitionSub)
		throws com.collaborated.entity.exception.NoSuchuserInstitutionProfileSubDetailsException {
		return getPersistence().findByPrimaryKey(PK_userInstitionSub);
	}

	/**
	* Returns the user institution profile sub details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_userInstitionSub the primary key of the user institution profile sub details
	* @return the user institution profile sub details, or <code>null</code> if a user institution profile sub details with the primary key could not be found
	*/
	public static userInstitutionProfileSubDetails fetchByPrimaryKey(
		long PK_userInstitionSub) {
		return getPersistence().fetchByPrimaryKey(PK_userInstitionSub);
	}

	public static java.util.Map<java.io.Serializable, userInstitutionProfileSubDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user institution profile sub detailses.
	*
	* @return the user institution profile sub detailses
	*/
	public static List<userInstitutionProfileSubDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user institution profile sub detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileSubDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user institution profile sub detailses
	* @param end the upper bound of the range of user institution profile sub detailses (not inclusive)
	* @return the range of user institution profile sub detailses
	*/
	public static List<userInstitutionProfileSubDetails> findAll(int start,
		int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user institution profile sub detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileSubDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user institution profile sub detailses
	* @param end the upper bound of the range of user institution profile sub detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user institution profile sub detailses
	*/
	public static List<userInstitutionProfileSubDetails> findAll(int start,
		int end,
		OrderByComparator<userInstitutionProfileSubDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user institution profile sub detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileSubDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user institution profile sub detailses
	* @param end the upper bound of the range of user institution profile sub detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user institution profile sub detailses
	*/
	public static List<userInstitutionProfileSubDetails> findAll(int start,
		int end,
		OrderByComparator<userInstitutionProfileSubDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user institution profile sub detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user institution profile sub detailses.
	*
	* @return the number of user institution profile sub detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static userInstitutionProfileSubDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<userInstitutionProfileSubDetailsPersistence, userInstitutionProfileSubDetailsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(userInstitutionProfileSubDetailsPersistence.class);
}