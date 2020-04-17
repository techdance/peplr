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
 * Provides the local service utility for userCredential. This utility wraps
 * {@link com.collaborated.entity.service.impl.userCredentialLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see userCredentialLocalService
 * @see com.collaborated.entity.service.base.userCredentialLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.userCredentialLocalServiceImpl
 * @generated
 */
@ProviderType
public class userCredentialLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.userCredentialLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user credential to the database. Also notifies the appropriate model listeners.
	*
	* @param userCredential the user credential
	* @return the user credential that was added
	*/
	public static com.collaborated.entity.model.userCredential adduserCredential(
		com.collaborated.entity.model.userCredential userCredential) {
		return getService().adduserCredential(userCredential);
	}

	/**
	* Creates a new user credential with the primary key. Does not add the user credential to the database.
	*
	* @param PK_userCredential the primary key for the new user credential
	* @return the new user credential
	*/
	public static com.collaborated.entity.model.userCredential createuserCredential(
		long PK_userCredential) {
		return getService().createuserCredential(PK_userCredential);
	}

	/**
	* Deletes the user credential from the database. Also notifies the appropriate model listeners.
	*
	* @param userCredential the user credential
	* @return the user credential that was removed
	*/
	public static com.collaborated.entity.model.userCredential deleteuserCredential(
		com.collaborated.entity.model.userCredential userCredential) {
		return getService().deleteuserCredential(userCredential);
	}

	/**
	* Deletes the user credential with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_userCredential the primary key of the user credential
	* @return the user credential that was removed
	* @throws PortalException if a user credential with the primary key could not be found
	*/
	public static com.collaborated.entity.model.userCredential deleteuserCredential(
		long PK_userCredential)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteuserCredential(PK_userCredential);
	}

	public static com.collaborated.entity.model.userCredential fetchuserCredential(
		long PK_userCredential) {
		return getService().fetchuserCredential(PK_userCredential);
	}

	/**
	* Returns the user credential with the primary key.
	*
	* @param PK_userCredential the primary key of the user credential
	* @return the user credential
	* @throws PortalException if a user credential with the primary key could not be found
	*/
	public static com.collaborated.entity.model.userCredential getuserCredential(
		long PK_userCredential)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getuserCredential(PK_userCredential);
	}

	/**
	* Updates the user credential in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userCredential the user credential
	* @return the user credential that was updated
	*/
	public static com.collaborated.entity.model.userCredential updateuserCredential(
		com.collaborated.entity.model.userCredential userCredential) {
		return getService().updateuserCredential(userCredential);
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
	* Returns the number of user credentials.
	*
	* @return the number of user credentials
	*/
	public static int getuserCredentialsCount() {
		return getService().getuserCredentialsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the user credentials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user credentials
	* @param end the upper bound of the range of user credentials (not inclusive)
	* @return the range of user credentials
	*/
	public static java.util.List<com.collaborated.entity.model.userCredential> getuserCredentials(
		int start, int end) {
		return getService().getuserCredentials(start, end);
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

	public static userCredentialLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<userCredentialLocalService, userCredentialLocalService> _serviceTracker =
		ServiceTrackerFactory.open(userCredentialLocalService.class);
}