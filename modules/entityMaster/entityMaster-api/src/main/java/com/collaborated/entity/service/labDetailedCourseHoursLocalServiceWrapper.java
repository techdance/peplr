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
 * Provides a wrapper for {@link labDetailedCourseHoursLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseHoursLocalService
 * @generated
 */
@ProviderType
public class labDetailedCourseHoursLocalServiceWrapper
	implements labDetailedCourseHoursLocalService,
		ServiceWrapper<labDetailedCourseHoursLocalService> {
	public labDetailedCourseHoursLocalServiceWrapper(
		labDetailedCourseHoursLocalService labDetailedCourseHoursLocalService) {
		_labDetailedCourseHoursLocalService = labDetailedCourseHoursLocalService;
	}

	/**
	* Adds the lab detailed course hours to the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseHours the lab detailed course hours
	* @return the lab detailed course hours that was added
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseHours addlabDetailedCourseHours(
		com.collaborated.entity.model.labDetailedCourseHours labDetailedCourseHours) {
		return _labDetailedCourseHoursLocalService.addlabDetailedCourseHours(labDetailedCourseHours);
	}

	/**
	* Creates a new lab detailed course hours with the primary key. Does not add the lab detailed course hours to the database.
	*
	* @param PK_courseHoursId the primary key for the new lab detailed course hours
	* @return the new lab detailed course hours
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseHours createlabDetailedCourseHours(
		long PK_courseHoursId) {
		return _labDetailedCourseHoursLocalService.createlabDetailedCourseHours(PK_courseHoursId);
	}

	/**
	* Deletes the lab detailed course hours from the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseHours the lab detailed course hours
	* @return the lab detailed course hours that was removed
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseHours deletelabDetailedCourseHours(
		com.collaborated.entity.model.labDetailedCourseHours labDetailedCourseHours) {
		return _labDetailedCourseHoursLocalService.deletelabDetailedCourseHours(labDetailedCourseHours);
	}

	/**
	* Deletes the lab detailed course hours with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseHoursId the primary key of the lab detailed course hours
	* @return the lab detailed course hours that was removed
	* @throws PortalException if a lab detailed course hours with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseHours deletelabDetailedCourseHours(
		long PK_courseHoursId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseHoursLocalService.deletelabDetailedCourseHours(PK_courseHoursId);
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseHours fetchlabDetailedCourseHours(
		long PK_courseHoursId) {
		return _labDetailedCourseHoursLocalService.fetchlabDetailedCourseHours(PK_courseHoursId);
	}

	/**
	* Returns the lab detailed course hours with the primary key.
	*
	* @param PK_courseHoursId the primary key of the lab detailed course hours
	* @return the lab detailed course hours
	* @throws PortalException if a lab detailed course hours with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseHours getlabDetailedCourseHours(
		long PK_courseHoursId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseHoursLocalService.getlabDetailedCourseHours(PK_courseHoursId);
	}

	/**
	* Updates the lab detailed course hours in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseHours the lab detailed course hours
	* @return the lab detailed course hours that was updated
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseHours updatelabDetailedCourseHours(
		com.collaborated.entity.model.labDetailedCourseHours labDetailedCourseHours) {
		return _labDetailedCourseHoursLocalService.updatelabDetailedCourseHours(labDetailedCourseHours);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _labDetailedCourseHoursLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _labDetailedCourseHoursLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _labDetailedCourseHoursLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseHoursLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseHoursLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lab detailed course hourses.
	*
	* @return the number of lab detailed course hourses
	*/
	@Override
	public int getlabDetailedCourseHoursesCount() {
		return _labDetailedCourseHoursLocalService.getlabDetailedCourseHoursesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _labDetailedCourseHoursLocalService.getOSGiServiceIdentifier();
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
		return _labDetailedCourseHoursLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedCourseHoursLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedCourseHoursLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the lab detailed course hourses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course hourses
	* @param end the upper bound of the range of lab detailed course hourses (not inclusive)
	* @return the range of lab detailed course hourses
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.labDetailedCourseHours> getlabDetailedCourseHourses(
		int start, int end) {
		return _labDetailedCourseHoursLocalService.getlabDetailedCourseHourses(start,
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
		return _labDetailedCourseHoursLocalService.dynamicQueryCount(dynamicQuery);
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
		return _labDetailedCourseHoursLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public labDetailedCourseHoursLocalService getWrappedService() {
		return _labDetailedCourseHoursLocalService;
	}

	@Override
	public void setWrappedService(
		labDetailedCourseHoursLocalService labDetailedCourseHoursLocalService) {
		_labDetailedCourseHoursLocalService = labDetailedCourseHoursLocalService;
	}

	private labDetailedCourseHoursLocalService _labDetailedCourseHoursLocalService;
}