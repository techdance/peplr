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

import com.collaborated.entity.model.communicationPreferences;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the communication preferences service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.communicationPreferencesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see communicationPreferencesPersistence
 * @see com.collaborated.entity.service.persistence.impl.communicationPreferencesPersistenceImpl
 * @generated
 */
@ProviderType
public class communicationPreferencesUtil {
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
		communicationPreferences communicationPreferences) {
		getPersistence().clearCache(communicationPreferences);
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
	public static List<communicationPreferences> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<communicationPreferences> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<communicationPreferences> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<communicationPreferences> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static communicationPreferences update(
		communicationPreferences communicationPreferences) {
		return getPersistence().update(communicationPreferences);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static communicationPreferences update(
		communicationPreferences communicationPreferences,
		ServiceContext serviceContext) {
		return getPersistence().update(communicationPreferences, serviceContext);
	}

	/**
	* Caches the communication preferences in the entity cache if it is enabled.
	*
	* @param communicationPreferences the communication preferences
	*/
	public static void cacheResult(
		communicationPreferences communicationPreferences) {
		getPersistence().cacheResult(communicationPreferences);
	}

	/**
	* Caches the communication preferenceses in the entity cache if it is enabled.
	*
	* @param communicationPreferenceses the communication preferenceses
	*/
	public static void cacheResult(
		List<communicationPreferences> communicationPreferenceses) {
		getPersistence().cacheResult(communicationPreferenceses);
	}

	/**
	* Creates a new communication preferences with the primary key. Does not add the communication preferences to the database.
	*
	* @param PK_communicationPreferences the primary key for the new communication preferences
	* @return the new communication preferences
	*/
	public static communicationPreferences create(
		long PK_communicationPreferences) {
		return getPersistence().create(PK_communicationPreferences);
	}

	/**
	* Removes the communication preferences with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_communicationPreferences the primary key of the communication preferences
	* @return the communication preferences that was removed
	* @throws NoSuchcommunicationPreferencesException if a communication preferences with the primary key could not be found
	*/
	public static communicationPreferences remove(
		long PK_communicationPreferences)
		throws com.collaborated.entity.exception.NoSuchcommunicationPreferencesException {
		return getPersistence().remove(PK_communicationPreferences);
	}

	public static communicationPreferences updateImpl(
		communicationPreferences communicationPreferences) {
		return getPersistence().updateImpl(communicationPreferences);
	}

	/**
	* Returns the communication preferences with the primary key or throws a {@link NoSuchcommunicationPreferencesException} if it could not be found.
	*
	* @param PK_communicationPreferences the primary key of the communication preferences
	* @return the communication preferences
	* @throws NoSuchcommunicationPreferencesException if a communication preferences with the primary key could not be found
	*/
	public static communicationPreferences findByPrimaryKey(
		long PK_communicationPreferences)
		throws com.collaborated.entity.exception.NoSuchcommunicationPreferencesException {
		return getPersistence().findByPrimaryKey(PK_communicationPreferences);
	}

	/**
	* Returns the communication preferences with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_communicationPreferences the primary key of the communication preferences
	* @return the communication preferences, or <code>null</code> if a communication preferences with the primary key could not be found
	*/
	public static communicationPreferences fetchByPrimaryKey(
		long PK_communicationPreferences) {
		return getPersistence().fetchByPrimaryKey(PK_communicationPreferences);
	}

	public static java.util.Map<java.io.Serializable, communicationPreferences> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the communication preferenceses.
	*
	* @return the communication preferenceses
	*/
	public static List<communicationPreferences> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the communication preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link communicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of communication preferenceses
	* @param end the upper bound of the range of communication preferenceses (not inclusive)
	* @return the range of communication preferenceses
	*/
	public static List<communicationPreferences> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the communication preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link communicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of communication preferenceses
	* @param end the upper bound of the range of communication preferenceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of communication preferenceses
	*/
	public static List<communicationPreferences> findAll(int start, int end,
		OrderByComparator<communicationPreferences> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the communication preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link communicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of communication preferenceses
	* @param end the upper bound of the range of communication preferenceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of communication preferenceses
	*/
	public static List<communicationPreferences> findAll(int start, int end,
		OrderByComparator<communicationPreferences> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the communication preferenceses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of communication preferenceses.
	*
	* @return the number of communication preferenceses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static communicationPreferencesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<communicationPreferencesPersistence, communicationPreferencesPersistence> _serviceTracker =
		ServiceTrackerFactory.open(communicationPreferencesPersistence.class);
}