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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Custom_Workflow_Task. This utility wraps
 * {@link com.collaborated.entity.service.impl.Custom_Workflow_TaskLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_TaskLocalService
 * @see com.collaborated.entity.service.base.Custom_Workflow_TaskLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.Custom_Workflow_TaskLocalServiceImpl
 * @generated
 */
@ProviderType
public class Custom_Workflow_TaskLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.Custom_Workflow_TaskLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the custom_ workflow_ task to the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow_Task the custom_ workflow_ task
	* @return the custom_ workflow_ task that was added
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Task addCustom_Workflow_Task(
		com.collaborated.entity.model.Custom_Workflow_Task custom_Workflow_Task) {
		return getService().addCustom_Workflow_Task(custom_Workflow_Task);
	}

	/**
	* Creates a new custom_ workflow_ task with the primary key. Does not add the custom_ workflow_ task to the database.
	*
	* @param workFlowTaskId the primary key for the new custom_ workflow_ task
	* @return the new custom_ workflow_ task
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Task createCustom_Workflow_Task(
		java.lang.String workFlowTaskId) {
		return getService().createCustom_Workflow_Task(workFlowTaskId);
	}

	/**
	* Deletes the custom_ workflow_ task from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow_Task the custom_ workflow_ task
	* @return the custom_ workflow_ task that was removed
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Task deleteCustom_Workflow_Task(
		com.collaborated.entity.model.Custom_Workflow_Task custom_Workflow_Task) {
		return getService().deleteCustom_Workflow_Task(custom_Workflow_Task);
	}

	/**
	* Deletes the custom_ workflow_ task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workFlowTaskId the primary key of the custom_ workflow_ task
	* @return the custom_ workflow_ task that was removed
	* @throws PortalException if a custom_ workflow_ task with the primary key could not be found
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Task deleteCustom_Workflow_Task(
		java.lang.String workFlowTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCustom_Workflow_Task(workFlowTaskId);
	}

	public static com.collaborated.entity.model.Custom_Workflow_Task fetchCustom_Workflow_Task(
		java.lang.String workFlowTaskId) {
		return getService().fetchCustom_Workflow_Task(workFlowTaskId);
	}

	/**
	* Returns the custom_ workflow_ task with the primary key.
	*
	* @param workFlowTaskId the primary key of the custom_ workflow_ task
	* @return the custom_ workflow_ task
	* @throws PortalException if a custom_ workflow_ task with the primary key could not be found
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Task getCustom_Workflow_Task(
		java.lang.String workFlowTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCustom_Workflow_Task(workFlowTaskId);
	}

	/**
	* Updates the custom_ workflow_ task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow_Task the custom_ workflow_ task
	* @return the custom_ workflow_ task that was updated
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Task updateCustom_Workflow_Task(
		com.collaborated.entity.model.Custom_Workflow_Task custom_Workflow_Task) {
		return getService().updateCustom_Workflow_Task(custom_Workflow_Task);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of custom_ workflow_ tasks.
	*
	* @return the number of custom_ workflow_ tasks
	*/
	public static int getCustom_Workflow_TasksCount() {
		return getService().getCustom_Workflow_TasksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_Workflow_TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_Workflow_TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the custom_ workflow_ tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_Workflow_TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ tasks
	* @param end the upper bound of the range of custom_ workflow_ tasks (not inclusive)
	* @return the range of custom_ workflow_ tasks
	*/
	public static java.util.List<com.collaborated.entity.model.Custom_Workflow_Task> getCustom_Workflow_Tasks(
		int start, int end) {
		return getService().getCustom_Workflow_Tasks(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Custom_Workflow_TaskLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Custom_Workflow_TaskLocalService, Custom_Workflow_TaskLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Custom_Workflow_TaskLocalService.class);
}