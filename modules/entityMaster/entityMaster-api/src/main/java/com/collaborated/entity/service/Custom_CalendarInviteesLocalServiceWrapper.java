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
 * Provides a wrapper for {@link Custom_CalendarInviteesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarInviteesLocalService
 * @generated
 */
@ProviderType
public class Custom_CalendarInviteesLocalServiceWrapper
	implements Custom_CalendarInviteesLocalService,
		ServiceWrapper<Custom_CalendarInviteesLocalService> {
	public Custom_CalendarInviteesLocalServiceWrapper(
		Custom_CalendarInviteesLocalService custom_CalendarInviteesLocalService) {
		_custom_CalendarInviteesLocalService = custom_CalendarInviteesLocalService;
	}

	/**
	* Adds the custom_ calendar invitees to the database. Also notifies the appropriate model listeners.
	*
	* @param custom_CalendarInvitees the custom_ calendar invitees
	* @return the custom_ calendar invitees that was added
	*/
	@Override
	public com.collaborated.entity.model.Custom_CalendarInvitees addCustom_CalendarInvitees(
		com.collaborated.entity.model.Custom_CalendarInvitees custom_CalendarInvitees) {
		return _custom_CalendarInviteesLocalService.addCustom_CalendarInvitees(custom_CalendarInvitees);
	}

	/**
	* Creates a new custom_ calendar invitees with the primary key. Does not add the custom_ calendar invitees to the database.
	*
	* @param PK_calendarEventSubId the primary key for the new custom_ calendar invitees
	* @return the new custom_ calendar invitees
	*/
	@Override
	public com.collaborated.entity.model.Custom_CalendarInvitees createCustom_CalendarInvitees(
		long PK_calendarEventSubId) {
		return _custom_CalendarInviteesLocalService.createCustom_CalendarInvitees(PK_calendarEventSubId);
	}

	/**
	* Deletes the custom_ calendar invitees from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_CalendarInvitees the custom_ calendar invitees
	* @return the custom_ calendar invitees that was removed
	*/
	@Override
	public com.collaborated.entity.model.Custom_CalendarInvitees deleteCustom_CalendarInvitees(
		com.collaborated.entity.model.Custom_CalendarInvitees custom_CalendarInvitees) {
		return _custom_CalendarInviteesLocalService.deleteCustom_CalendarInvitees(custom_CalendarInvitees);
	}

	/**
	* Deletes the custom_ calendar invitees with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_calendarEventSubId the primary key of the custom_ calendar invitees
	* @return the custom_ calendar invitees that was removed
	* @throws PortalException if a custom_ calendar invitees with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.Custom_CalendarInvitees deleteCustom_CalendarInvitees(
		long PK_calendarEventSubId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_CalendarInviteesLocalService.deleteCustom_CalendarInvitees(PK_calendarEventSubId);
	}

	@Override
	public com.collaborated.entity.model.Custom_CalendarInvitees fetchCustom_CalendarInvitees(
		long PK_calendarEventSubId) {
		return _custom_CalendarInviteesLocalService.fetchCustom_CalendarInvitees(PK_calendarEventSubId);
	}

	/**
	* Returns the custom_ calendar invitees with the primary key.
	*
	* @param PK_calendarEventSubId the primary key of the custom_ calendar invitees
	* @return the custom_ calendar invitees
	* @throws PortalException if a custom_ calendar invitees with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.Custom_CalendarInvitees getCustom_CalendarInvitees(
		long PK_calendarEventSubId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_CalendarInviteesLocalService.getCustom_CalendarInvitees(PK_calendarEventSubId);
	}

	/**
	* Updates the custom_ calendar invitees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param custom_CalendarInvitees the custom_ calendar invitees
	* @return the custom_ calendar invitees that was updated
	*/
	@Override
	public com.collaborated.entity.model.Custom_CalendarInvitees updateCustom_CalendarInvitees(
		com.collaborated.entity.model.Custom_CalendarInvitees custom_CalendarInvitees) {
		return _custom_CalendarInviteesLocalService.updateCustom_CalendarInvitees(custom_CalendarInvitees);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _custom_CalendarInviteesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _custom_CalendarInviteesLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _custom_CalendarInviteesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_CalendarInviteesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_CalendarInviteesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of custom_ calendar inviteeses.
	*
	* @return the number of custom_ calendar inviteeses
	*/
	@Override
	public int getCustom_CalendarInviteesesCount() {
		return _custom_CalendarInviteesLocalService.getCustom_CalendarInviteesesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _custom_CalendarInviteesLocalService.getOSGiServiceIdentifier();
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
		return _custom_CalendarInviteesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_CalendarInviteesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _custom_CalendarInviteesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_CalendarInviteesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _custom_CalendarInviteesLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the custom_ calendar inviteeses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_CalendarInviteesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ calendar inviteeses
	* @param end the upper bound of the range of custom_ calendar inviteeses (not inclusive)
	* @return the range of custom_ calendar inviteeses
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.Custom_CalendarInvitees> getCustom_CalendarInviteeses(
		int start, int end) {
		return _custom_CalendarInviteesLocalService.getCustom_CalendarInviteeses(start,
			end);
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
		return _custom_CalendarInviteesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _custom_CalendarInviteesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public Custom_CalendarInviteesLocalService getWrappedService() {
		return _custom_CalendarInviteesLocalService;
	}

	@Override
	public void setWrappedService(
		Custom_CalendarInviteesLocalService custom_CalendarInviteesLocalService) {
		_custom_CalendarInviteesLocalService = custom_CalendarInviteesLocalService;
	}

	private Custom_CalendarInviteesLocalService _custom_CalendarInviteesLocalService;
}