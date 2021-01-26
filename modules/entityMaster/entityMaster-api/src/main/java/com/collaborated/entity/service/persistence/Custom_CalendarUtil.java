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

import com.collaborated.entity.model.Custom_Calendar;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the custom_ calendar service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.Custom_CalendarPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarPersistence
 * @see com.collaborated.entity.service.persistence.impl.Custom_CalendarPersistenceImpl
 * @generated
 */
@ProviderType
public class Custom_CalendarUtil {
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
	public static void clearCache(Custom_Calendar custom_Calendar) {
		getPersistence().clearCache(custom_Calendar);
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
	public static List<Custom_Calendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Custom_Calendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Custom_Calendar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Custom_Calendar> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Custom_Calendar update(Custom_Calendar custom_Calendar) {
		return getPersistence().update(custom_Calendar);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Custom_Calendar update(Custom_Calendar custom_Calendar,
		ServiceContext serviceContext) {
		return getPersistence().update(custom_Calendar, serviceContext);
	}

	/**
	* Caches the custom_ calendar in the entity cache if it is enabled.
	*
	* @param custom_Calendar the custom_ calendar
	*/
	public static void cacheResult(Custom_Calendar custom_Calendar) {
		getPersistence().cacheResult(custom_Calendar);
	}

	/**
	* Caches the custom_ calendars in the entity cache if it is enabled.
	*
	* @param custom_Calendars the custom_ calendars
	*/
	public static void cacheResult(List<Custom_Calendar> custom_Calendars) {
		getPersistence().cacheResult(custom_Calendars);
	}

	/**
	* Creates a new custom_ calendar with the primary key. Does not add the custom_ calendar to the database.
	*
	* @param PK_calendarEventId the primary key for the new custom_ calendar
	* @return the new custom_ calendar
	*/
	public static Custom_Calendar create(long PK_calendarEventId) {
		return getPersistence().create(PK_calendarEventId);
	}

	/**
	* Removes the custom_ calendar with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_calendarEventId the primary key of the custom_ calendar
	* @return the custom_ calendar that was removed
	* @throws NoSuchCustom_CalendarException if a custom_ calendar with the primary key could not be found
	*/
	public static Custom_Calendar remove(long PK_calendarEventId)
		throws com.collaborated.entity.exception.NoSuchCustom_CalendarException {
		return getPersistence().remove(PK_calendarEventId);
	}

	public static Custom_Calendar updateImpl(Custom_Calendar custom_Calendar) {
		return getPersistence().updateImpl(custom_Calendar);
	}

	/**
	* Returns the custom_ calendar with the primary key or throws a {@link NoSuchCustom_CalendarException} if it could not be found.
	*
	* @param PK_calendarEventId the primary key of the custom_ calendar
	* @return the custom_ calendar
	* @throws NoSuchCustom_CalendarException if a custom_ calendar with the primary key could not be found
	*/
	public static Custom_Calendar findByPrimaryKey(long PK_calendarEventId)
		throws com.collaborated.entity.exception.NoSuchCustom_CalendarException {
		return getPersistence().findByPrimaryKey(PK_calendarEventId);
	}

	/**
	* Returns the custom_ calendar with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_calendarEventId the primary key of the custom_ calendar
	* @return the custom_ calendar, or <code>null</code> if a custom_ calendar with the primary key could not be found
	*/
	public static Custom_Calendar fetchByPrimaryKey(long PK_calendarEventId) {
		return getPersistence().fetchByPrimaryKey(PK_calendarEventId);
	}

	public static java.util.Map<java.io.Serializable, Custom_Calendar> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the custom_ calendars.
	*
	* @return the custom_ calendars
	*/
	public static List<Custom_Calendar> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the custom_ calendars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_CalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ calendars
	* @param end the upper bound of the range of custom_ calendars (not inclusive)
	* @return the range of custom_ calendars
	*/
	public static List<Custom_Calendar> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the custom_ calendars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_CalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ calendars
	* @param end the upper bound of the range of custom_ calendars (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of custom_ calendars
	*/
	public static List<Custom_Calendar> findAll(int start, int end,
		OrderByComparator<Custom_Calendar> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the custom_ calendars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_CalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ calendars
	* @param end the upper bound of the range of custom_ calendars (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of custom_ calendars
	*/
	public static List<Custom_Calendar> findAll(int start, int end,
		OrderByComparator<Custom_Calendar> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the custom_ calendars from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of custom_ calendars.
	*
	* @return the number of custom_ calendars
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static Custom_CalendarPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Custom_CalendarPersistence, Custom_CalendarPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Custom_CalendarPersistence.class);
}