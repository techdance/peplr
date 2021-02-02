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

import com.collaborated.entity.model.Custom_CalendarInvitees;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Custom_CalendarInvitees. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarInviteesLocalServiceUtil
 * @see com.collaborated.entity.service.base.Custom_CalendarInviteesLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.Custom_CalendarInviteesLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface Custom_CalendarInviteesLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Custom_CalendarInviteesLocalServiceUtil} to access the custom_ calendar invitees local service. Add custom service methods to {@link com.collaborated.entity.service.impl.Custom_CalendarInviteesLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the custom_ calendar invitees to the database. Also notifies the appropriate model listeners.
	*
	* @param custom_CalendarInvitees the custom_ calendar invitees
	* @return the custom_ calendar invitees that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Custom_CalendarInvitees addCustom_CalendarInvitees(
		Custom_CalendarInvitees custom_CalendarInvitees);

	/**
	* Creates a new custom_ calendar invitees with the primary key. Does not add the custom_ calendar invitees to the database.
	*
	* @param PK_calendarEventSubId the primary key for the new custom_ calendar invitees
	* @return the new custom_ calendar invitees
	*/
	public Custom_CalendarInvitees createCustom_CalendarInvitees(
		long PK_calendarEventSubId);

	/**
	* Deletes the custom_ calendar invitees from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_CalendarInvitees the custom_ calendar invitees
	* @return the custom_ calendar invitees that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Custom_CalendarInvitees deleteCustom_CalendarInvitees(
		Custom_CalendarInvitees custom_CalendarInvitees);

	/**
	* Deletes the custom_ calendar invitees with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_calendarEventSubId the primary key of the custom_ calendar invitees
	* @return the custom_ calendar invitees that was removed
	* @throws PortalException if a custom_ calendar invitees with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Custom_CalendarInvitees deleteCustom_CalendarInvitees(
		long PK_calendarEventSubId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Custom_CalendarInvitees fetchCustom_CalendarInvitees(
		long PK_calendarEventSubId);

	/**
	* Returns the custom_ calendar invitees with the primary key.
	*
	* @param PK_calendarEventSubId the primary key of the custom_ calendar invitees
	* @return the custom_ calendar invitees
	* @throws PortalException if a custom_ calendar invitees with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Custom_CalendarInvitees getCustom_CalendarInvitees(
		long PK_calendarEventSubId) throws PortalException;

	/**
	* Updates the custom_ calendar invitees in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param custom_CalendarInvitees the custom_ calendar invitees
	* @return the custom_ calendar invitees that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Custom_CalendarInvitees updateCustom_CalendarInvitees(
		Custom_CalendarInvitees custom_CalendarInvitees);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of custom_ calendar inviteeses.
	*
	* @return the number of custom_ calendar inviteeses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCustom_CalendarInviteesesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Custom_CalendarInvitees> getCustom_CalendarInviteeses(
		int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}