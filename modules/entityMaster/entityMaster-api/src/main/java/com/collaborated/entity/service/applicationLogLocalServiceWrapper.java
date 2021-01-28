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
 * Provides a wrapper for {@link applicationLogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see applicationLogLocalService
 * @generated
 */
@ProviderType
public class applicationLogLocalServiceWrapper
	implements applicationLogLocalService,
		ServiceWrapper<applicationLogLocalService> {
	public applicationLogLocalServiceWrapper(
		applicationLogLocalService applicationLogLocalService) {
		_applicationLogLocalService = applicationLogLocalService;
	}

	/**
	* Adds the application log to the database. Also notifies the appropriate model listeners.
	*
	* @param applicationLog the application log
	* @return the application log that was added
	*/
	@Override
	public com.collaborated.entity.model.applicationLog addapplicationLog(
		com.collaborated.entity.model.applicationLog applicationLog) {
		return _applicationLogLocalService.addapplicationLog(applicationLog);
	}

	/**
	* Creates a new application log with the primary key. Does not add the application log to the database.
	*
	* @param PK_logId the primary key for the new application log
	* @return the new application log
	*/
	@Override
	public com.collaborated.entity.model.applicationLog createapplicationLog(
		long PK_logId) {
		return _applicationLogLocalService.createapplicationLog(PK_logId);
	}

	/**
	* Deletes the application log from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationLog the application log
	* @return the application log that was removed
	*/
	@Override
	public com.collaborated.entity.model.applicationLog deleteapplicationLog(
		com.collaborated.entity.model.applicationLog applicationLog) {
		return _applicationLogLocalService.deleteapplicationLog(applicationLog);
	}

	/**
	* Deletes the application log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_logId the primary key of the application log
	* @return the application log that was removed
	* @throws PortalException if a application log with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.applicationLog deleteapplicationLog(
		long PK_logId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationLogLocalService.deleteapplicationLog(PK_logId);
	}

	@Override
	public com.collaborated.entity.model.applicationLog fetchapplicationLog(
		long PK_logId) {
		return _applicationLogLocalService.fetchapplicationLog(PK_logId);
	}

	/**
	* Returns the application log with the primary key.
	*
	* @param PK_logId the primary key of the application log
	* @return the application log
	* @throws PortalException if a application log with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.applicationLog getapplicationLog(
		long PK_logId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationLogLocalService.getapplicationLog(PK_logId);
	}

	/**
	* Updates the application log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param applicationLog the application log
	* @return the application log that was updated
	*/
	@Override
	public com.collaborated.entity.model.applicationLog updateapplicationLog(
		com.collaborated.entity.model.applicationLog applicationLog) {
		return _applicationLogLocalService.updateapplicationLog(applicationLog);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _applicationLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _applicationLogLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _applicationLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of application logs.
	*
	* @return the number of application logs
	*/
	@Override
	public int getapplicationLogsCount() {
		return _applicationLogLocalService.getapplicationLogsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicationLogLocalService.getOSGiServiceIdentifier();
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
		return _applicationLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.applicationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _applicationLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.applicationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _applicationLogLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the application logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.applicationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application logs
	* @param end the upper bound of the range of application logs (not inclusive)
	* @return the range of application logs
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.applicationLog> getapplicationLogs(
		int start, int end) {
		return _applicationLogLocalService.getapplicationLogs(start, end);
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
		return _applicationLogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _applicationLogLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public applicationLogLocalService getWrappedService() {
		return _applicationLogLocalService;
	}

	@Override
	public void setWrappedService(
		applicationLogLocalService applicationLogLocalService) {
		_applicationLogLocalService = applicationLogLocalService;
	}

	private applicationLogLocalService _applicationLogLocalService;
}