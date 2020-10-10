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
 * Provides the local service utility for Custom_Workflow_Completed. This utility wraps
 * {@link com.collaborated.entity.service.impl.Custom_Workflow_CompletedLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_CompletedLocalService
 * @see com.collaborated.entity.service.base.Custom_Workflow_CompletedLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.Custom_Workflow_CompletedLocalServiceImpl
 * @generated
 */
@ProviderType
public class Custom_Workflow_CompletedLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.Custom_Workflow_CompletedLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the custom_ workflow_ completed to the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow_Completed the custom_ workflow_ completed
	* @return the custom_ workflow_ completed that was added
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Completed addCustom_Workflow_Completed(
		com.collaborated.entity.model.Custom_Workflow_Completed custom_Workflow_Completed) {
		return getService()
				   .addCustom_Workflow_Completed(custom_Workflow_Completed);
	}

	/**
	* Creates a new custom_ workflow_ completed with the primary key. Does not add the custom_ workflow_ completed to the database.
	*
	* @param cId the primary key for the new custom_ workflow_ completed
	* @return the new custom_ workflow_ completed
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Completed createCustom_Workflow_Completed(
		long cId) {
		return getService().createCustom_Workflow_Completed(cId);
	}

	/**
	* Deletes the custom_ workflow_ completed from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow_Completed the custom_ workflow_ completed
	* @return the custom_ workflow_ completed that was removed
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Completed deleteCustom_Workflow_Completed(
		com.collaborated.entity.model.Custom_Workflow_Completed custom_Workflow_Completed) {
		return getService()
				   .deleteCustom_Workflow_Completed(custom_Workflow_Completed);
	}

	/**
	* Deletes the custom_ workflow_ completed with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cId the primary key of the custom_ workflow_ completed
	* @return the custom_ workflow_ completed that was removed
	* @throws PortalException if a custom_ workflow_ completed with the primary key could not be found
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Completed deleteCustom_Workflow_Completed(
		long cId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCustom_Workflow_Completed(cId);
	}

	public static com.collaborated.entity.model.Custom_Workflow_Completed fetchCustom_Workflow_Completed(
		long cId) {
		return getService().fetchCustom_Workflow_Completed(cId);
	}

	/**
	* Returns the custom_ workflow_ completed with the primary key.
	*
	* @param cId the primary key of the custom_ workflow_ completed
	* @return the custom_ workflow_ completed
	* @throws PortalException if a custom_ workflow_ completed with the primary key could not be found
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Completed getCustom_Workflow_Completed(
		long cId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCustom_Workflow_Completed(cId);
	}

	/**
	* Updates the custom_ workflow_ completed in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow_Completed the custom_ workflow_ completed
	* @return the custom_ workflow_ completed that was updated
	*/
	public static com.collaborated.entity.model.Custom_Workflow_Completed updateCustom_Workflow_Completed(
		com.collaborated.entity.model.Custom_Workflow_Completed custom_Workflow_Completed) {
		return getService()
				   .updateCustom_Workflow_Completed(custom_Workflow_Completed);
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
	* Returns the number of custom_ workflow_ completeds.
	*
	* @return the number of custom_ workflow_ completeds
	*/
	public static int getCustom_Workflow_CompletedsCount() {
		return getService().getCustom_Workflow_CompletedsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the custom_ workflow_ completeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ completeds
	* @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	* @return the range of custom_ workflow_ completeds
	*/
	public static java.util.List<com.collaborated.entity.model.Custom_Workflow_Completed> getCustom_Workflow_Completeds(
		int start, int end) {
		return getService().getCustom_Workflow_Completeds(start, end);
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

	public static Custom_Workflow_CompletedLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Custom_Workflow_CompletedLocalService, Custom_Workflow_CompletedLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Custom_Workflow_CompletedLocalService.class);
}