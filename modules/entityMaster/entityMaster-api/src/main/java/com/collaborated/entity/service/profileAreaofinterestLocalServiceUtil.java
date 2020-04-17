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
 * Provides the local service utility for profileAreaofinterest. This utility wraps
 * {@link com.collaborated.entity.service.impl.profileAreaofinterestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see profileAreaofinterestLocalService
 * @see com.collaborated.entity.service.base.profileAreaofinterestLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.profileAreaofinterestLocalServiceImpl
 * @generated
 */
@ProviderType
public class profileAreaofinterestLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.profileAreaofinterestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the profile areaofinterest to the database. Also notifies the appropriate model listeners.
	*
	* @param profileAreaofinterest the profile areaofinterest
	* @return the profile areaofinterest that was added
	*/
	public static com.collaborated.entity.model.profileAreaofinterest addprofileAreaofinterest(
		com.collaborated.entity.model.profileAreaofinterest profileAreaofinterest) {
		return getService().addprofileAreaofinterest(profileAreaofinterest);
	}

	/**
	* Creates a new profile areaofinterest with the primary key. Does not add the profile areaofinterest to the database.
	*
	* @param PK_areaofinterest the primary key for the new profile areaofinterest
	* @return the new profile areaofinterest
	*/
	public static com.collaborated.entity.model.profileAreaofinterest createprofileAreaofinterest(
		long PK_areaofinterest) {
		return getService().createprofileAreaofinterest(PK_areaofinterest);
	}

	/**
	* Deletes the profile areaofinterest from the database. Also notifies the appropriate model listeners.
	*
	* @param profileAreaofinterest the profile areaofinterest
	* @return the profile areaofinterest that was removed
	*/
	public static com.collaborated.entity.model.profileAreaofinterest deleteprofileAreaofinterest(
		com.collaborated.entity.model.profileAreaofinterest profileAreaofinterest) {
		return getService().deleteprofileAreaofinterest(profileAreaofinterest);
	}

	/**
	* Deletes the profile areaofinterest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_areaofinterest the primary key of the profile areaofinterest
	* @return the profile areaofinterest that was removed
	* @throws PortalException if a profile areaofinterest with the primary key could not be found
	*/
	public static com.collaborated.entity.model.profileAreaofinterest deleteprofileAreaofinterest(
		long PK_areaofinterest)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteprofileAreaofinterest(PK_areaofinterest);
	}

	public static com.collaborated.entity.model.profileAreaofinterest fetchprofileAreaofinterest(
		long PK_areaofinterest) {
		return getService().fetchprofileAreaofinterest(PK_areaofinterest);
	}

	/**
	* Returns the profile areaofinterest with the primary key.
	*
	* @param PK_areaofinterest the primary key of the profile areaofinterest
	* @return the profile areaofinterest
	* @throws PortalException if a profile areaofinterest with the primary key could not be found
	*/
	public static com.collaborated.entity.model.profileAreaofinterest getprofileAreaofinterest(
		long PK_areaofinterest)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getprofileAreaofinterest(PK_areaofinterest);
	}

	/**
	* Updates the profile areaofinterest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param profileAreaofinterest the profile areaofinterest
	* @return the profile areaofinterest that was updated
	*/
	public static com.collaborated.entity.model.profileAreaofinterest updateprofileAreaofinterest(
		com.collaborated.entity.model.profileAreaofinterest profileAreaofinterest) {
		return getService().updateprofileAreaofinterest(profileAreaofinterest);
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
	* Returns the number of profile areaofinterests.
	*
	* @return the number of profile areaofinterests
	*/
	public static int getprofileAreaofinterestsCount() {
		return getService().getprofileAreaofinterestsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the profile areaofinterests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile areaofinterests
	* @param end the upper bound of the range of profile areaofinterests (not inclusive)
	* @return the range of profile areaofinterests
	*/
	public static java.util.List<com.collaborated.entity.model.profileAreaofinterest> getprofileAreaofinterests(
		int start, int end) {
		return getService().getprofileAreaofinterests(start, end);
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

	public static profileAreaofinterestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<profileAreaofinterestLocalService, profileAreaofinterestLocalService> _serviceTracker =
		ServiceTrackerFactory.open(profileAreaofinterestLocalService.class);
}