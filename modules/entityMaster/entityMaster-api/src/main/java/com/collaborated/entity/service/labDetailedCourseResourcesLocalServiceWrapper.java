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
 * Provides a wrapper for {@link labDetailedCourseResourcesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseResourcesLocalService
 * @generated
 */
@ProviderType
public class labDetailedCourseResourcesLocalServiceWrapper
	implements labDetailedCourseResourcesLocalService,
		ServiceWrapper<labDetailedCourseResourcesLocalService> {
	public labDetailedCourseResourcesLocalServiceWrapper(
		labDetailedCourseResourcesLocalService labDetailedCourseResourcesLocalService) {
		_labDetailedCourseResourcesLocalService = labDetailedCourseResourcesLocalService;
	}

	/**
	* Adds the lab detailed course resources to the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseResources the lab detailed course resources
	* @return the lab detailed course resources that was added
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseResources addlabDetailedCourseResources(
		com.collaborated.entity.model.labDetailedCourseResources labDetailedCourseResources) {
		return _labDetailedCourseResourcesLocalService.addlabDetailedCourseResources(labDetailedCourseResources);
	}

	/**
	* Creates a new lab detailed course resources with the primary key. Does not add the lab detailed course resources to the database.
	*
	* @param PK_courseResourceId the primary key for the new lab detailed course resources
	* @return the new lab detailed course resources
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseResources createlabDetailedCourseResources(
		long PK_courseResourceId) {
		return _labDetailedCourseResourcesLocalService.createlabDetailedCourseResources(PK_courseResourceId);
	}

	/**
	* Deletes the lab detailed course resources from the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseResources the lab detailed course resources
	* @return the lab detailed course resources that was removed
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseResources deletelabDetailedCourseResources(
		com.collaborated.entity.model.labDetailedCourseResources labDetailedCourseResources) {
		return _labDetailedCourseResourcesLocalService.deletelabDetailedCourseResources(labDetailedCourseResources);
	}

	/**
	* Deletes the lab detailed course resources with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseResourceId the primary key of the lab detailed course resources
	* @return the lab detailed course resources that was removed
	* @throws PortalException if a lab detailed course resources with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseResources deletelabDetailedCourseResources(
		long PK_courseResourceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseResourcesLocalService.deletelabDetailedCourseResources(PK_courseResourceId);
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseResources fetchlabDetailedCourseResources(
		long PK_courseResourceId) {
		return _labDetailedCourseResourcesLocalService.fetchlabDetailedCourseResources(PK_courseResourceId);
	}

	/**
	* Returns the lab detailed course resources with the primary key.
	*
	* @param PK_courseResourceId the primary key of the lab detailed course resources
	* @return the lab detailed course resources
	* @throws PortalException if a lab detailed course resources with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseResources getlabDetailedCourseResources(
		long PK_courseResourceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseResourcesLocalService.getlabDetailedCourseResources(PK_courseResourceId);
	}

	/**
	* Updates the lab detailed course resources in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseResources the lab detailed course resources
	* @return the lab detailed course resources that was updated
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseResources updatelabDetailedCourseResources(
		com.collaborated.entity.model.labDetailedCourseResources labDetailedCourseResources) {
		return _labDetailedCourseResourcesLocalService.updatelabDetailedCourseResources(labDetailedCourseResources);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _labDetailedCourseResourcesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _labDetailedCourseResourcesLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _labDetailedCourseResourcesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseResourcesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseResourcesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lab detailed course resourceses.
	*
	* @return the number of lab detailed course resourceses
	*/
	@Override
	public int getlabDetailedCourseResourcesesCount() {
		return _labDetailedCourseResourcesLocalService.getlabDetailedCourseResourcesesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _labDetailedCourseResourcesLocalService.getOSGiServiceIdentifier();
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
		return _labDetailedCourseResourcesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedCourseResourcesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedCourseResourcesLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the lab detailed course resourceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course resourceses
	* @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	* @return the range of lab detailed course resourceses
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.labDetailedCourseResources> getlabDetailedCourseResourceses(
		int start, int end) {
		return _labDetailedCourseResourcesLocalService.getlabDetailedCourseResourceses(start,
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
		return _labDetailedCourseResourcesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _labDetailedCourseResourcesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public labDetailedCourseResourcesLocalService getWrappedService() {
		return _labDetailedCourseResourcesLocalService;
	}

	@Override
	public void setWrappedService(
		labDetailedCourseResourcesLocalService labDetailedCourseResourcesLocalService) {
		_labDetailedCourseResourcesLocalService = labDetailedCourseResourcesLocalService;
	}

	private labDetailedCourseResourcesLocalService _labDetailedCourseResourcesLocalService;
}