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
 * Provides the local service utility for commonWebsserviceAPI. This utility wraps
 * {@link com.collaborated.entity.service.impl.commonWebsserviceAPILocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPILocalService
 * @see com.collaborated.entity.service.base.commonWebsserviceAPILocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.commonWebsserviceAPILocalServiceImpl
 * @generated
 */
@ProviderType
public class commonWebsserviceAPILocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.commonWebsserviceAPILocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean logEntry(
		com.liferay.portal.kernel.json.JSONObject jsonObject) {
		return getService().logEntry(jsonObject);
	}

	/**
	* Adds the common websservice a p i to the database. Also notifies the appropriate model listeners.
	*
	* @param commonWebsserviceAPI the common websservice a p i
	* @return the common websservice a p i that was added
	*/
	public static com.collaborated.entity.model.commonWebsserviceAPI addcommonWebsserviceAPI(
		com.collaborated.entity.model.commonWebsserviceAPI commonWebsserviceAPI) {
		return getService().addcommonWebsserviceAPI(commonWebsserviceAPI);
	}

	/**
	* Creates a new common websservice a p i with the primary key. Does not add the common websservice a p i to the database.
	*
	* @param commonAPIId the primary key for the new common websservice a p i
	* @return the new common websservice a p i
	*/
	public static com.collaborated.entity.model.commonWebsserviceAPI createcommonWebsserviceAPI(
		long commonAPIId) {
		return getService().createcommonWebsserviceAPI(commonAPIId);
	}

	/**
	* Deletes the common websservice a p i from the database. Also notifies the appropriate model listeners.
	*
	* @param commonWebsserviceAPI the common websservice a p i
	* @return the common websservice a p i that was removed
	*/
	public static com.collaborated.entity.model.commonWebsserviceAPI deletecommonWebsserviceAPI(
		com.collaborated.entity.model.commonWebsserviceAPI commonWebsserviceAPI) {
		return getService().deletecommonWebsserviceAPI(commonWebsserviceAPI);
	}

	/**
	* Deletes the common websservice a p i with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i that was removed
	* @throws PortalException if a common websservice a p i with the primary key could not be found
	*/
	public static com.collaborated.entity.model.commonWebsserviceAPI deletecommonWebsserviceAPI(
		long commonAPIId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletecommonWebsserviceAPI(commonAPIId);
	}

	public static com.collaborated.entity.model.commonWebsserviceAPI fetchcommonWebsserviceAPI(
		long commonAPIId) {
		return getService().fetchcommonWebsserviceAPI(commonAPIId);
	}

	/**
	* Returns the common websservice a p i with the primary key.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i
	* @throws PortalException if a common websservice a p i with the primary key could not be found
	*/
	public static com.collaborated.entity.model.commonWebsserviceAPI getcommonWebsserviceAPI(
		long commonAPIId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getcommonWebsserviceAPI(commonAPIId);
	}

	/**
	* Updates the common websservice a p i in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commonWebsserviceAPI the common websservice a p i
	* @return the common websservice a p i that was updated
	*/
	public static com.collaborated.entity.model.commonWebsserviceAPI updatecommonWebsserviceAPI(
		com.collaborated.entity.model.commonWebsserviceAPI commonWebsserviceAPI) {
		return getService().updatecommonWebsserviceAPI(commonWebsserviceAPI);
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
	* Returns the number of common websservice a p is.
	*
	* @return the number of common websservice a p is
	*/
	public static int getcommonWebsserviceAPIsCount() {
		return getService().getcommonWebsserviceAPIsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the common websservice a p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common websservice a p is
	* @param end the upper bound of the range of common websservice a p is (not inclusive)
	* @return the range of common websservice a p is
	*/
	public static java.util.List<com.collaborated.entity.model.commonWebsserviceAPI> getcommonWebsserviceAPIs(
		int start, int end) {
		return getService().getcommonWebsserviceAPIs(start, end);
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

	public static commonWebsserviceAPILocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<commonWebsserviceAPILocalService, commonWebsserviceAPILocalService> _serviceTracker =
		ServiceTrackerFactory.open(commonWebsserviceAPILocalService.class);
}