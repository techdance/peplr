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

package com.collaborated.entity.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Custom_CalendarLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarLocalService
 * @generated
 */
@ProviderType
public class Custom_CalendarLocalServiceWrapper
	implements Custom_CalendarLocalService,
		ServiceWrapper<Custom_CalendarLocalService> {
	public Custom_CalendarLocalServiceWrapper(
		Custom_CalendarLocalService custom_CalendarLocalService) {
		_custom_CalendarLocalService = custom_CalendarLocalService;
	}

	/**
	* Adds the custom_ calendar to the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Calendar the custom_ calendar
	* @return the custom_ calendar that was added
	*/
	@Override
	public com.collaborated.entity.model.Custom_Calendar addCustom_Calendar(
		com.collaborated.entity.model.Custom_Calendar custom_Calendar) {
		return _custom_CalendarLocalService.addCustom_Calendar(custom_Calendar);
	}

	/**
	* Creates a new custom_ calendar with the primary key. Does not add the custom_ calendar to the database.
	*
	* @param PK_calendarEventId the primary key for the new custom_ calendar
	* @return the new custom_ calendar
	*/
	@Override
	public com.collaborated.entity.model.Custom_Calendar createCustom_Calendar(
		long PK_calendarEventId) {
		return _custom_CalendarLocalService.createCustom_Calendar(PK_calendarEventId);
	}

	/**
	* Deletes the custom_ calendar from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Calendar the custom_ calendar
	* @return the custom_ calendar that was removed
	*/
	@Override
	public com.collaborated.entity.model.Custom_Calendar deleteCustom_Calendar(
		com.collaborated.entity.model.Custom_Calendar custom_Calendar) {
		return _custom_CalendarLocalService.deleteCustom_Calendar(custom_Calendar);
	}

	/**
	* Deletes the custom_ calendar with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_calendarEventId the primary key of the custom_ calendar
	* @return the custom_ calendar that was removed
	* @throws PortalException if a custom_ calendar with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.Custom_Calendar deleteCustom_Calendar(
		long PK_calendarEventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_CalendarLocalService.deleteCustom_Calendar(PK_calendarEventId);
	}

	@Override
	public com.collaborated.entity.model.Custom_Calendar fetchCustom_Calendar(
		long PK_calendarEventId) {
		return _custom_CalendarLocalService.fetchCustom_Calendar(PK_calendarEventId);
	}

	/**
	* Returns the custom_ calendar with the primary key.
	*
	* @param PK_calendarEventId the primary key of the custom_ calendar
	* @return the custom_ calendar
	* @throws PortalException if a custom_ calendar with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.Custom_Calendar getCustom_Calendar(
		long PK_calendarEventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_CalendarLocalService.getCustom_Calendar(PK_calendarEventId);
	}

	/**
	* Updates the custom_ calendar in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param custom_Calendar the custom_ calendar
	* @return the custom_ calendar that was updated
	*/
	@Override
	public com.collaborated.entity.model.Custom_Calendar updateCustom_Calendar(
		com.collaborated.entity.model.Custom_Calendar custom_Calendar) {
		return _custom_CalendarLocalService.updateCustom_Calendar(custom_Calendar);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _custom_CalendarLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _custom_CalendarLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _custom_CalendarLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_CalendarLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_CalendarLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of custom_ calendars.
	*
	* @return the number of custom_ calendars
	*/
	@Override
	public int getCustom_CalendarsCount() {
		return _custom_CalendarLocalService.getCustom_CalendarsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _custom_CalendarLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _custom_CalendarLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_CalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _custom_CalendarLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_CalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _custom_CalendarLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the custom_ calendars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_CalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ calendars
	* @param end the upper bound of the range of custom_ calendars (not inclusive)
	* @return the range of custom_ calendars
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.Custom_Calendar> getCustom_Calendars(
		int start, int end) {
		return _custom_CalendarLocalService.getCustom_Calendars(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _custom_CalendarLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _custom_CalendarLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public Custom_CalendarLocalService getWrappedService() {
		return _custom_CalendarLocalService;
	}

	@Override
	public void setWrappedService(
		Custom_CalendarLocalService custom_CalendarLocalService) {
		_custom_CalendarLocalService = custom_CalendarLocalService;
	}

	private Custom_CalendarLocalService _custom_CalendarLocalService;
}