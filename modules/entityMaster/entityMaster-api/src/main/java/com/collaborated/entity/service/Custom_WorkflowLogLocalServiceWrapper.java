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
 * Provides a wrapper for {@link Custom_WorkflowLogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowLogLocalService
 * @generated
 */
@ProviderType
public class Custom_WorkflowLogLocalServiceWrapper
	implements Custom_WorkflowLogLocalService,
		ServiceWrapper<Custom_WorkflowLogLocalService> {
	public Custom_WorkflowLogLocalServiceWrapper(
		Custom_WorkflowLogLocalService custom_WorkflowLogLocalService) {
		_custom_WorkflowLogLocalService = custom_WorkflowLogLocalService;
	}

	/**
	* Adds the custom_ workflow log to the database. Also notifies the appropriate model listeners.
	*
	* @param custom_WorkflowLog the custom_ workflow log
	* @return the custom_ workflow log that was added
	*/
	@Override
	public com.collaborated.entity.model.Custom_WorkflowLog addCustom_WorkflowLog(
		com.collaborated.entity.model.Custom_WorkflowLog custom_WorkflowLog) {
		return _custom_WorkflowLogLocalService.addCustom_WorkflowLog(custom_WorkflowLog);
	}

	/**
	* Creates a new custom_ workflow log with the primary key. Does not add the custom_ workflow log to the database.
	*
	* @param logId the primary key for the new custom_ workflow log
	* @return the new custom_ workflow log
	*/
	@Override
	public com.collaborated.entity.model.Custom_WorkflowLog createCustom_WorkflowLog(
		long logId) {
		return _custom_WorkflowLogLocalService.createCustom_WorkflowLog(logId);
	}

	/**
	* Deletes the custom_ workflow log from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_WorkflowLog the custom_ workflow log
	* @return the custom_ workflow log that was removed
	*/
	@Override
	public com.collaborated.entity.model.Custom_WorkflowLog deleteCustom_WorkflowLog(
		com.collaborated.entity.model.Custom_WorkflowLog custom_WorkflowLog) {
		return _custom_WorkflowLogLocalService.deleteCustom_WorkflowLog(custom_WorkflowLog);
	}

	/**
	* Deletes the custom_ workflow log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logId the primary key of the custom_ workflow log
	* @return the custom_ workflow log that was removed
	* @throws PortalException if a custom_ workflow log with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.Custom_WorkflowLog deleteCustom_WorkflowLog(
		long logId) throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_WorkflowLogLocalService.deleteCustom_WorkflowLog(logId);
	}

	@Override
	public com.collaborated.entity.model.Custom_WorkflowLog fetchCustom_WorkflowLog(
		long logId) {
		return _custom_WorkflowLogLocalService.fetchCustom_WorkflowLog(logId);
	}

	/**
	* Returns the custom_ workflow log with the primary key.
	*
	* @param logId the primary key of the custom_ workflow log
	* @return the custom_ workflow log
	* @throws PortalException if a custom_ workflow log with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.Custom_WorkflowLog getCustom_WorkflowLog(
		long logId) throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_WorkflowLogLocalService.getCustom_WorkflowLog(logId);
	}

	/**
	* Updates the custom_ workflow log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param custom_WorkflowLog the custom_ workflow log
	* @return the custom_ workflow log that was updated
	*/
	@Override
	public com.collaborated.entity.model.Custom_WorkflowLog updateCustom_WorkflowLog(
		com.collaborated.entity.model.Custom_WorkflowLog custom_WorkflowLog) {
		return _custom_WorkflowLogLocalService.updateCustom_WorkflowLog(custom_WorkflowLog);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _custom_WorkflowLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _custom_WorkflowLogLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _custom_WorkflowLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_WorkflowLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_WorkflowLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of custom_ workflow logs.
	*
	* @return the number of custom_ workflow logs
	*/
	@Override
	public int getCustom_WorkflowLogsCount() {
		return _custom_WorkflowLogLocalService.getCustom_WorkflowLogsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _custom_WorkflowLogLocalService.getOSGiServiceIdentifier();
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
		return _custom_WorkflowLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_WorkflowLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _custom_WorkflowLogLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_WorkflowLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _custom_WorkflowLogLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the custom_ workflow logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_WorkflowLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow logs
	* @param end the upper bound of the range of custom_ workflow logs (not inclusive)
	* @return the range of custom_ workflow logs
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.Custom_WorkflowLog> getCustom_WorkflowLogs(
		int start, int end) {
		return _custom_WorkflowLogLocalService.getCustom_WorkflowLogs(start, end);
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
		return _custom_WorkflowLogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _custom_WorkflowLogLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public Custom_WorkflowLogLocalService getWrappedService() {
		return _custom_WorkflowLogLocalService;
	}

	@Override
	public void setWrappedService(
		Custom_WorkflowLogLocalService custom_WorkflowLogLocalService) {
		_custom_WorkflowLogLocalService = custom_WorkflowLogLocalService;
	}

	private Custom_WorkflowLogLocalService _custom_WorkflowLogLocalService;
}