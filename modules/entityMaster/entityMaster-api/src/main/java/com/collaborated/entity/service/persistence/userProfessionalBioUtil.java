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

import com.collaborated.entity.model.userProfessionalBio;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user professional bio service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.userProfessionalBioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userProfessionalBioPersistence
 * @see com.collaborated.entity.service.persistence.impl.userProfessionalBioPersistenceImpl
 * @generated
 */
@ProviderType
public class userProfessionalBioUtil {
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
	public static void clearCache(userProfessionalBio userProfessionalBio) {
		getPersistence().clearCache(userProfessionalBio);
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
	public static List<userProfessionalBio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<userProfessionalBio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<userProfessionalBio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<userProfessionalBio> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static userProfessionalBio update(
		userProfessionalBio userProfessionalBio) {
		return getPersistence().update(userProfessionalBio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static userProfessionalBio update(
		userProfessionalBio userProfessionalBio, ServiceContext serviceContext) {
		return getPersistence().update(userProfessionalBio, serviceContext);
	}

	/**
	* Caches the user professional bio in the entity cache if it is enabled.
	*
	* @param userProfessionalBio the user professional bio
	*/
	public static void cacheResult(userProfessionalBio userProfessionalBio) {
		getPersistence().cacheResult(userProfessionalBio);
	}

	/**
	* Caches the user professional bios in the entity cache if it is enabled.
	*
	* @param userProfessionalBios the user professional bios
	*/
	public static void cacheResult(
		List<userProfessionalBio> userProfessionalBios) {
		getPersistence().cacheResult(userProfessionalBios);
	}

	/**
	* Creates a new user professional bio with the primary key. Does not add the user professional bio to the database.
	*
	* @param PK_userProfessionalBio the primary key for the new user professional bio
	* @return the new user professional bio
	*/
	public static userProfessionalBio create(long PK_userProfessionalBio) {
		return getPersistence().create(PK_userProfessionalBio);
	}

	/**
	* Removes the user professional bio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_userProfessionalBio the primary key of the user professional bio
	* @return the user professional bio that was removed
	* @throws NoSuchuserProfessionalBioException if a user professional bio with the primary key could not be found
	*/
	public static userProfessionalBio remove(long PK_userProfessionalBio)
		throws com.collaborated.entity.exception.NoSuchuserProfessionalBioException {
		return getPersistence().remove(PK_userProfessionalBio);
	}

	public static userProfessionalBio updateImpl(
		userProfessionalBio userProfessionalBio) {
		return getPersistence().updateImpl(userProfessionalBio);
	}

	/**
	* Returns the user professional bio with the primary key or throws a {@link NoSuchuserProfessionalBioException} if it could not be found.
	*
	* @param PK_userProfessionalBio the primary key of the user professional bio
	* @return the user professional bio
	* @throws NoSuchuserProfessionalBioException if a user professional bio with the primary key could not be found
	*/
	public static userProfessionalBio findByPrimaryKey(
		long PK_userProfessionalBio)
		throws com.collaborated.entity.exception.NoSuchuserProfessionalBioException {
		return getPersistence().findByPrimaryKey(PK_userProfessionalBio);
	}

	/**
	* Returns the user professional bio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_userProfessionalBio the primary key of the user professional bio
	* @return the user professional bio, or <code>null</code> if a user professional bio with the primary key could not be found
	*/
	public static userProfessionalBio fetchByPrimaryKey(
		long PK_userProfessionalBio) {
		return getPersistence().fetchByPrimaryKey(PK_userProfessionalBio);
	}

	public static java.util.Map<java.io.Serializable, userProfessionalBio> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user professional bios.
	*
	* @return the user professional bios
	*/
	public static List<userProfessionalBio> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user professional bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user professional bios
	* @param end the upper bound of the range of user professional bios (not inclusive)
	* @return the range of user professional bios
	*/
	public static List<userProfessionalBio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user professional bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user professional bios
	* @param end the upper bound of the range of user professional bios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user professional bios
	*/
	public static List<userProfessionalBio> findAll(int start, int end,
		OrderByComparator<userProfessionalBio> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user professional bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user professional bios
	* @param end the upper bound of the range of user professional bios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user professional bios
	*/
	public static List<userProfessionalBio> findAll(int start, int end,
		OrderByComparator<userProfessionalBio> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user professional bios from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user professional bios.
	*
	* @return the number of user professional bios
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static userProfessionalBioPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<userProfessionalBioPersistence, userProfessionalBioPersistence> _serviceTracker =
		ServiceTrackerFactory.open(userProfessionalBioPersistence.class);
}