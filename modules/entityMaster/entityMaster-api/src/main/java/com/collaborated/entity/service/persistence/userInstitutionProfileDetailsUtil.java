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

import com.collaborated.entity.model.userInstitutionProfileDetails;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user institution profile details service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.userInstitutionProfileDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileDetailsPersistence
 * @see com.collaborated.entity.service.persistence.impl.userInstitutionProfileDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class userInstitutionProfileDetailsUtil {
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
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		getPersistence().clearCache(userInstitutionProfileDetails);
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
	public static List<userInstitutionProfileDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<userInstitutionProfileDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<userInstitutionProfileDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<userInstitutionProfileDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static userInstitutionProfileDetails update(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		return getPersistence().update(userInstitutionProfileDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static userInstitutionProfileDetails update(
		userInstitutionProfileDetails userInstitutionProfileDetails,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(userInstitutionProfileDetails, serviceContext);
	}

	/**
	* Caches the user institution profile details in the entity cache if it is enabled.
	*
	* @param userInstitutionProfileDetails the user institution profile details
	*/
	public static void cacheResult(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		getPersistence().cacheResult(userInstitutionProfileDetails);
	}

	/**
	* Caches the user institution profile detailses in the entity cache if it is enabled.
	*
	* @param userInstitutionProfileDetailses the user institution profile detailses
	*/
	public static void cacheResult(
		List<userInstitutionProfileDetails> userInstitutionProfileDetailses) {
		getPersistence().cacheResult(userInstitutionProfileDetailses);
	}

	/**
	* Creates a new user institution profile details with the primary key. Does not add the user institution profile details to the database.
	*
	* @param PK_userInstition the primary key for the new user institution profile details
	* @return the new user institution profile details
	*/
	public static userInstitutionProfileDetails create(long PK_userInstition) {
		return getPersistence().create(PK_userInstition);
	}

	/**
	* Removes the user institution profile details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_userInstition the primary key of the user institution profile details
	* @return the user institution profile details that was removed
	* @throws NoSuchuserInstitutionProfileDetailsException if a user institution profile details with the primary key could not be found
	*/
	public static userInstitutionProfileDetails remove(long PK_userInstition)
		throws com.collaborated.entity.exception.NoSuchuserInstitutionProfileDetailsException {
		return getPersistence().remove(PK_userInstition);
	}

	public static userInstitutionProfileDetails updateImpl(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		return getPersistence().updateImpl(userInstitutionProfileDetails);
	}

	/**
	* Returns the user institution profile details with the primary key or throws a {@link NoSuchuserInstitutionProfileDetailsException} if it could not be found.
	*
	* @param PK_userInstition the primary key of the user institution profile details
	* @return the user institution profile details
	* @throws NoSuchuserInstitutionProfileDetailsException if a user institution profile details with the primary key could not be found
	*/
	public static userInstitutionProfileDetails findByPrimaryKey(
		long PK_userInstition)
		throws com.collaborated.entity.exception.NoSuchuserInstitutionProfileDetailsException {
		return getPersistence().findByPrimaryKey(PK_userInstition);
	}

	/**
	* Returns the user institution profile details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_userInstition the primary key of the user institution profile details
	* @return the user institution profile details, or <code>null</code> if a user institution profile details with the primary key could not be found
	*/
	public static userInstitutionProfileDetails fetchByPrimaryKey(
		long PK_userInstition) {
		return getPersistence().fetchByPrimaryKey(PK_userInstition);
	}

	public static java.util.Map<java.io.Serializable, userInstitutionProfileDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user institution profile detailses.
	*
	* @return the user institution profile detailses
	*/
	public static List<userInstitutionProfileDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user institution profile detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user institution profile detailses
	* @param end the upper bound of the range of user institution profile detailses (not inclusive)
	* @return the range of user institution profile detailses
	*/
	public static List<userInstitutionProfileDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user institution profile detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user institution profile detailses
	* @param end the upper bound of the range of user institution profile detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user institution profile detailses
	*/
	public static List<userInstitutionProfileDetails> findAll(int start,
		int end,
		OrderByComparator<userInstitutionProfileDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user institution profile detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user institution profile detailses
	* @param end the upper bound of the range of user institution profile detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user institution profile detailses
	*/
	public static List<userInstitutionProfileDetails> findAll(int start,
		int end,
		OrderByComparator<userInstitutionProfileDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user institution profile detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user institution profile detailses.
	*
	* @return the number of user institution profile detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static userInstitutionProfileDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<userInstitutionProfileDetailsPersistence, userInstitutionProfileDetailsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(userInstitutionProfileDetailsPersistence.class);
}