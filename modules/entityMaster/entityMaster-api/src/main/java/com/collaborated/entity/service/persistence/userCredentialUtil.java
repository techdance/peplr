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

import com.collaborated.entity.model.userCredential;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user credential service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.userCredentialPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userCredentialPersistence
 * @see com.collaborated.entity.service.persistence.impl.userCredentialPersistenceImpl
 * @generated
 */
@ProviderType
public class userCredentialUtil {
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
	public static void clearCache(userCredential userCredential) {
		getPersistence().clearCache(userCredential);
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
	public static List<userCredential> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<userCredential> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<userCredential> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<userCredential> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static userCredential update(userCredential userCredential) {
		return getPersistence().update(userCredential);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static userCredential update(userCredential userCredential,
		ServiceContext serviceContext) {
		return getPersistence().update(userCredential, serviceContext);
	}

	/**
	* Caches the user credential in the entity cache if it is enabled.
	*
	* @param userCredential the user credential
	*/
	public static void cacheResult(userCredential userCredential) {
		getPersistence().cacheResult(userCredential);
	}

	/**
	* Caches the user credentials in the entity cache if it is enabled.
	*
	* @param userCredentials the user credentials
	*/
	public static void cacheResult(List<userCredential> userCredentials) {
		getPersistence().cacheResult(userCredentials);
	}

	/**
	* Creates a new user credential with the primary key. Does not add the user credential to the database.
	*
	* @param PK_userCredential the primary key for the new user credential
	* @return the new user credential
	*/
	public static userCredential create(long PK_userCredential) {
		return getPersistence().create(PK_userCredential);
	}

	/**
	* Removes the user credential with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_userCredential the primary key of the user credential
	* @return the user credential that was removed
	* @throws NoSuchuserCredentialException if a user credential with the primary key could not be found
	*/
	public static userCredential remove(long PK_userCredential)
		throws com.collaborated.entity.exception.NoSuchuserCredentialException {
		return getPersistence().remove(PK_userCredential);
	}

	public static userCredential updateImpl(userCredential userCredential) {
		return getPersistence().updateImpl(userCredential);
	}

	/**
	* Returns the user credential with the primary key or throws a {@link NoSuchuserCredentialException} if it could not be found.
	*
	* @param PK_userCredential the primary key of the user credential
	* @return the user credential
	* @throws NoSuchuserCredentialException if a user credential with the primary key could not be found
	*/
	public static userCredential findByPrimaryKey(long PK_userCredential)
		throws com.collaborated.entity.exception.NoSuchuserCredentialException {
		return getPersistence().findByPrimaryKey(PK_userCredential);
	}

	/**
	* Returns the user credential with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_userCredential the primary key of the user credential
	* @return the user credential, or <code>null</code> if a user credential with the primary key could not be found
	*/
	public static userCredential fetchByPrimaryKey(long PK_userCredential) {
		return getPersistence().fetchByPrimaryKey(PK_userCredential);
	}

	public static java.util.Map<java.io.Serializable, userCredential> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user credentials.
	*
	* @return the user credentials
	*/
	public static List<userCredential> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user credentials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user credentials
	* @param end the upper bound of the range of user credentials (not inclusive)
	* @return the range of user credentials
	*/
	public static List<userCredential> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user credentials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user credentials
	* @param end the upper bound of the range of user credentials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user credentials
	*/
	public static List<userCredential> findAll(int start, int end,
		OrderByComparator<userCredential> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user credentials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user credentials
	* @param end the upper bound of the range of user credentials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user credentials
	*/
	public static List<userCredential> findAll(int start, int end,
		OrderByComparator<userCredential> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user credentials from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user credentials.
	*
	* @return the number of user credentials
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static userCredentialPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<userCredentialPersistence, userCredentialPersistence> _serviceTracker =
		ServiceTrackerFactory.open(userCredentialPersistence.class);
}