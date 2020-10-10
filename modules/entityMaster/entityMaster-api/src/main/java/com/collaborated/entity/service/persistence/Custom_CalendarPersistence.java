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

import com.collaborated.entity.exception.NoSuchCustom_CalendarException;
import com.collaborated.entity.model.Custom_Calendar;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the custom_ calendar service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.Custom_CalendarPersistenceImpl
 * @see Custom_CalendarUtil
 * @generated
 */
@ProviderType
public interface Custom_CalendarPersistence extends BasePersistence<Custom_Calendar> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Custom_CalendarUtil} to access the custom_ calendar persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the custom_ calendar in the entity cache if it is enabled.
	*
	* @param custom_Calendar the custom_ calendar
	*/
	public void cacheResult(Custom_Calendar custom_Calendar);

	/**
	* Caches the custom_ calendars in the entity cache if it is enabled.
	*
	* @param custom_Calendars the custom_ calendars
	*/
	public void cacheResult(java.util.List<Custom_Calendar> custom_Calendars);

	/**
	* Creates a new custom_ calendar with the primary key. Does not add the custom_ calendar to the database.
	*
	* @param PK_calendarEventId the primary key for the new custom_ calendar
	* @return the new custom_ calendar
	*/
	public Custom_Calendar create(long PK_calendarEventId);

	/**
	* Removes the custom_ calendar with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_calendarEventId the primary key of the custom_ calendar
	* @return the custom_ calendar that was removed
	* @throws NoSuchCustom_CalendarException if a custom_ calendar with the primary key could not be found
	*/
	public Custom_Calendar remove(long PK_calendarEventId)
		throws NoSuchCustom_CalendarException;

	public Custom_Calendar updateImpl(Custom_Calendar custom_Calendar);

	/**
	* Returns the custom_ calendar with the primary key or throws a {@link NoSuchCustom_CalendarException} if it could not be found.
	*
	* @param PK_calendarEventId the primary key of the custom_ calendar
	* @return the custom_ calendar
	* @throws NoSuchCustom_CalendarException if a custom_ calendar with the primary key could not be found
	*/
	public Custom_Calendar findByPrimaryKey(long PK_calendarEventId)
		throws NoSuchCustom_CalendarException;

	/**
	* Returns the custom_ calendar with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_calendarEventId the primary key of the custom_ calendar
	* @return the custom_ calendar, or <code>null</code> if a custom_ calendar with the primary key could not be found
	*/
	public Custom_Calendar fetchByPrimaryKey(long PK_calendarEventId);

	@Override
	public java.util.Map<java.io.Serializable, Custom_Calendar> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the custom_ calendars.
	*
	* @return the custom_ calendars
	*/
	public java.util.List<Custom_Calendar> findAll();

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
	public java.util.List<Custom_Calendar> findAll(int start, int end);

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
	public java.util.List<Custom_Calendar> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_Calendar> orderByComparator);

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
	public java.util.List<Custom_Calendar> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_Calendar> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the custom_ calendars from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of custom_ calendars.
	*
	* @return the number of custom_ calendars
	*/
	public int countAll();
}