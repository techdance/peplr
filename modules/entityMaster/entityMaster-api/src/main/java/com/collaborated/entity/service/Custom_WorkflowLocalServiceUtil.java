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
 * Provides the local service utility for Custom_Workflow. This utility wraps
 * {@link com.collaborated.entity.service.impl.Custom_WorkflowLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowLocalService
 * @see com.collaborated.entity.service.base.Custom_WorkflowLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.Custom_WorkflowLocalServiceImpl
 * @generated
 */
@ProviderType
public class Custom_WorkflowLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.Custom_WorkflowLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the custom_ workflow to the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow the custom_ workflow
	* @return the custom_ workflow that was added
	*/
	public static com.collaborated.entity.model.Custom_Workflow addCustom_Workflow(
		com.collaborated.entity.model.Custom_Workflow custom_Workflow) {
		return getService().addCustom_Workflow(custom_Workflow);
	}

	/**
	* Creates a new custom_ workflow with the primary key. Does not add the custom_ workflow to the database.
	*
	* @param workFlowId the primary key for the new custom_ workflow
	* @return the new custom_ workflow
	*/
	public static com.collaborated.entity.model.Custom_Workflow createCustom_Workflow(
		long workFlowId) {
		return getService().createCustom_Workflow(workFlowId);
	}

	/**
	* Deletes the custom_ workflow from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow the custom_ workflow
	* @return the custom_ workflow that was removed
	*/
	public static com.collaborated.entity.model.Custom_Workflow deleteCustom_Workflow(
		com.collaborated.entity.model.Custom_Workflow custom_Workflow) {
		return getService().deleteCustom_Workflow(custom_Workflow);
	}

	/**
	* Deletes the custom_ workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workFlowId the primary key of the custom_ workflow
	* @return the custom_ workflow that was removed
	* @throws PortalException if a custom_ workflow with the primary key could not be found
	*/
	public static com.collaborated.entity.model.Custom_Workflow deleteCustom_Workflow(
		long workFlowId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCustom_Workflow(workFlowId);
	}

	public static com.collaborated.entity.model.Custom_Workflow fetchCustom_Workflow(
		long workFlowId) {
		return getService().fetchCustom_Workflow(workFlowId);
	}

	/**
	* Returns the custom_ workflow with the primary key.
	*
	* @param workFlowId the primary key of the custom_ workflow
	* @return the custom_ workflow
	* @throws PortalException if a custom_ workflow with the primary key could not be found
	*/
	public static com.collaborated.entity.model.Custom_Workflow getCustom_Workflow(
		long workFlowId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCustom_Workflow(workFlowId);
	}

	/**
	* Updates the custom_ workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow the custom_ workflow
	* @return the custom_ workflow that was updated
	*/
	public static com.collaborated.entity.model.Custom_Workflow updateCustom_Workflow(
		com.collaborated.entity.model.Custom_Workflow custom_Workflow) {
		return getService().updateCustom_Workflow(custom_Workflow);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
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
	* Returns the number of custom_ workflows.
	*
	* @return the number of custom_ workflows
	*/
	public static int getCustom_WorkflowsCount() {
		return getService().getCustom_WorkflowsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the custom_ workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflows
	* @param end the upper bound of the range of custom_ workflows (not inclusive)
	* @return the range of custom_ workflows
	*/
	public static java.util.List<com.collaborated.entity.model.Custom_Workflow> getCustom_Workflows(
		int start, int end) {
		return getService().getCustom_Workflows(start, end);
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

	public static Custom_WorkflowLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Custom_WorkflowLocalService, Custom_WorkflowLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Custom_WorkflowLocalService.class);
}