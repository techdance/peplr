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
 * Provides a wrapper for {@link labScreenProjectOverviewLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectOverviewLocalService
 * @generated
 */
@ProviderType
public class labScreenProjectOverviewLocalServiceWrapper
	implements labScreenProjectOverviewLocalService,
		ServiceWrapper<labScreenProjectOverviewLocalService> {
	public labScreenProjectOverviewLocalServiceWrapper(
		labScreenProjectOverviewLocalService labScreenProjectOverviewLocalService) {
		_labScreenProjectOverviewLocalService = labScreenProjectOverviewLocalService;
	}

	/**
	* Adds the lab screen project overview to the database. Also notifies the appropriate model listeners.
	*
	* @param labScreenProjectOverview the lab screen project overview
	* @return the lab screen project overview that was added
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectOverview addlabScreenProjectOverview(
		com.collaborated.entity.model.labScreenProjectOverview labScreenProjectOverview) {
		return _labScreenProjectOverviewLocalService.addlabScreenProjectOverview(labScreenProjectOverview);
	}

	/**
	* Creates a new lab screen project overview with the primary key. Does not add the lab screen project overview to the database.
	*
	* @param PK_projectId the primary key for the new lab screen project overview
	* @return the new lab screen project overview
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectOverview createlabScreenProjectOverview(
		long PK_projectId) {
		return _labScreenProjectOverviewLocalService.createlabScreenProjectOverview(PK_projectId);
	}

	/**
	* Deletes the lab screen project overview from the database. Also notifies the appropriate model listeners.
	*
	* @param labScreenProjectOverview the lab screen project overview
	* @return the lab screen project overview that was removed
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectOverview deletelabScreenProjectOverview(
		com.collaborated.entity.model.labScreenProjectOverview labScreenProjectOverview) {
		return _labScreenProjectOverviewLocalService.deletelabScreenProjectOverview(labScreenProjectOverview);
	}

	/**
	* Deletes the lab screen project overview with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectId the primary key of the lab screen project overview
	* @return the lab screen project overview that was removed
	* @throws PortalException if a lab screen project overview with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectOverview deletelabScreenProjectOverview(
		long PK_projectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenProjectOverviewLocalService.deletelabScreenProjectOverview(PK_projectId);
	}

	@Override
	public com.collaborated.entity.model.labScreenProjectOverview fetchlabScreenProjectOverview(
		long PK_projectId) {
		return _labScreenProjectOverviewLocalService.fetchlabScreenProjectOverview(PK_projectId);
	}

	/**
	* Returns the lab screen project overview with the primary key.
	*
	* @param PK_projectId the primary key of the lab screen project overview
	* @return the lab screen project overview
	* @throws PortalException if a lab screen project overview with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectOverview getlabScreenProjectOverview(
		long PK_projectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenProjectOverviewLocalService.getlabScreenProjectOverview(PK_projectId);
	}

	/**
	* Updates the lab screen project overview in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labScreenProjectOverview the lab screen project overview
	* @return the lab screen project overview that was updated
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectOverview updatelabScreenProjectOverview(
		com.collaborated.entity.model.labScreenProjectOverview labScreenProjectOverview) {
		return _labScreenProjectOverviewLocalService.updatelabScreenProjectOverview(labScreenProjectOverview);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _labScreenProjectOverviewLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _labScreenProjectOverviewLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _labScreenProjectOverviewLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenProjectOverviewLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenProjectOverviewLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lab screen project overviews.
	*
	* @return the number of lab screen project overviews
	*/
	@Override
	public int getlabScreenProjectOverviewsCount() {
		return _labScreenProjectOverviewLocalService.getlabScreenProjectOverviewsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _labScreenProjectOverviewLocalService.getOSGiServiceIdentifier();
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
		return _labScreenProjectOverviewLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labScreenProjectOverviewLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labScreenProjectOverviewLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the lab screen project overviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project overviews
	* @param end the upper bound of the range of lab screen project overviews (not inclusive)
	* @return the range of lab screen project overviews
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.labScreenProjectOverview> getlabScreenProjectOverviews(
		int start, int end) {
		return _labScreenProjectOverviewLocalService.getlabScreenProjectOverviews(start,
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
		return _labScreenProjectOverviewLocalService.dynamicQueryCount(dynamicQuery);
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
		return _labScreenProjectOverviewLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public labScreenProjectOverviewLocalService getWrappedService() {
		return _labScreenProjectOverviewLocalService;
	}

	@Override
	public void setWrappedService(
		labScreenProjectOverviewLocalService labScreenProjectOverviewLocalService) {
		_labScreenProjectOverviewLocalService = labScreenProjectOverviewLocalService;
	}

	private labScreenProjectOverviewLocalService _labScreenProjectOverviewLocalService;
}