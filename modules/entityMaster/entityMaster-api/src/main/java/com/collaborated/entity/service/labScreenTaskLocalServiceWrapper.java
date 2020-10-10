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
 * Provides a wrapper for {@link labScreenTaskLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see labScreenTaskLocalService
 * @generated
 */
@ProviderType
public class labScreenTaskLocalServiceWrapper
	implements labScreenTaskLocalService,
		ServiceWrapper<labScreenTaskLocalService> {
	public labScreenTaskLocalServiceWrapper(
		labScreenTaskLocalService labScreenTaskLocalService) {
		_labScreenTaskLocalService = labScreenTaskLocalService;
	}

	/**
	* Adds the lab screen task to the database. Also notifies the appropriate model listeners.
	*
	* @param labScreenTask the lab screen task
	* @return the lab screen task that was added
	*/
	@Override
	public com.collaborated.entity.model.labScreenTask addlabScreenTask(
		com.collaborated.entity.model.labScreenTask labScreenTask) {
		return _labScreenTaskLocalService.addlabScreenTask(labScreenTask);
	}

	/**
	* Creates a new lab screen task with the primary key. Does not add the lab screen task to the database.
	*
	* @param PK_taskId the primary key for the new lab screen task
	* @return the new lab screen task
	*/
	@Override
	public com.collaborated.entity.model.labScreenTask createlabScreenTask(
		long PK_taskId) {
		return _labScreenTaskLocalService.createlabScreenTask(PK_taskId);
	}

	/**
	* Deletes the lab screen task from the database. Also notifies the appropriate model listeners.
	*
	* @param labScreenTask the lab screen task
	* @return the lab screen task that was removed
	*/
	@Override
	public com.collaborated.entity.model.labScreenTask deletelabScreenTask(
		com.collaborated.entity.model.labScreenTask labScreenTask) {
		return _labScreenTaskLocalService.deletelabScreenTask(labScreenTask);
	}

	/**
	* Deletes the lab screen task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_taskId the primary key of the lab screen task
	* @return the lab screen task that was removed
	* @throws PortalException if a lab screen task with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labScreenTask deletelabScreenTask(
		long PK_taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenTaskLocalService.deletelabScreenTask(PK_taskId);
	}

	@Override
	public com.collaborated.entity.model.labScreenTask fetchlabScreenTask(
		long PK_taskId) {
		return _labScreenTaskLocalService.fetchlabScreenTask(PK_taskId);
	}

	/**
	* Returns the lab screen task with the primary key.
	*
	* @param PK_taskId the primary key of the lab screen task
	* @return the lab screen task
	* @throws PortalException if a lab screen task with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labScreenTask getlabScreenTask(
		long PK_taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenTaskLocalService.getlabScreenTask(PK_taskId);
	}

	/**
	* Updates the lab screen task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labScreenTask the lab screen task
	* @return the lab screen task that was updated
	*/
	@Override
	public com.collaborated.entity.model.labScreenTask updatelabScreenTask(
		com.collaborated.entity.model.labScreenTask labScreenTask) {
		return _labScreenTaskLocalService.updatelabScreenTask(labScreenTask);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _labScreenTaskLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _labScreenTaskLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _labScreenTaskLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenTaskLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lab screen tasks.
	*
	* @return the number of lab screen tasks
	*/
	@Override
	public int getlabScreenTasksCount() {
		return _labScreenTaskLocalService.getlabScreenTasksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _labScreenTaskLocalService.getOSGiServiceIdentifier();
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
		return _labScreenTaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labScreenTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labScreenTaskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labScreenTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labScreenTaskLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the lab screen tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labScreenTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen tasks
	* @param end the upper bound of the range of lab screen tasks (not inclusive)
	* @return the range of lab screen tasks
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.labScreenTask> getlabScreenTasks(
		int start, int end) {
		return _labScreenTaskLocalService.getlabScreenTasks(start, end);
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
		return _labScreenTaskLocalService.dynamicQueryCount(dynamicQuery);
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
		return _labScreenTaskLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public labScreenTaskLocalService getWrappedService() {
		return _labScreenTaskLocalService;
	}

	@Override
	public void setWrappedService(
		labScreenTaskLocalService labScreenTaskLocalService) {
		_labScreenTaskLocalService = labScreenTaskLocalService;
	}

	private labScreenTaskLocalService _labScreenTaskLocalService;
}