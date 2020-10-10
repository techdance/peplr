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
 * Provides the local service utility for userProfileImage. This utility wraps
 * {@link com.collaborated.entity.service.impl.userProfileImageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see userProfileImageLocalService
 * @see com.collaborated.entity.service.base.userProfileImageLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.userProfileImageLocalServiceImpl
 * @generated
 */
@ProviderType
public class userProfileImageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.userProfileImageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user profile image to the database. Also notifies the appropriate model listeners.
	*
	* @param userProfileImage the user profile image
	* @return the user profile image that was added
	*/
	public static com.collaborated.entity.model.userProfileImage adduserProfileImage(
		com.collaborated.entity.model.userProfileImage userProfileImage) {
		return getService().adduserProfileImage(userProfileImage);
	}

	/**
	* Creates a new user profile image with the primary key. Does not add the user profile image to the database.
	*
	* @param PK_profileImageId the primary key for the new user profile image
	* @return the new user profile image
	*/
	public static com.collaborated.entity.model.userProfileImage createuserProfileImage(
		long PK_profileImageId) {
		return getService().createuserProfileImage(PK_profileImageId);
	}

	/**
	* Deletes the user profile image from the database. Also notifies the appropriate model listeners.
	*
	* @param userProfileImage the user profile image
	* @return the user profile image that was removed
	*/
	public static com.collaborated.entity.model.userProfileImage deleteuserProfileImage(
		com.collaborated.entity.model.userProfileImage userProfileImage) {
		return getService().deleteuserProfileImage(userProfileImage);
	}

	/**
	* Deletes the user profile image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image that was removed
	* @throws PortalException if a user profile image with the primary key could not be found
	*/
	public static com.collaborated.entity.model.userProfileImage deleteuserProfileImage(
		long PK_profileImageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteuserProfileImage(PK_profileImageId);
	}

	public static com.collaborated.entity.model.userProfileImage fetchuserProfileImage(
		long PK_profileImageId) {
		return getService().fetchuserProfileImage(PK_profileImageId);
	}

	/**
	* Returns the user profile image with the primary key.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image
	* @throws PortalException if a user profile image with the primary key could not be found
	*/
	public static com.collaborated.entity.model.userProfileImage getuserProfileImage(
		long PK_profileImageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getuserProfileImage(PK_profileImageId);
	}

	/**
	* Updates the user profile image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userProfileImage the user profile image
	* @return the user profile image that was updated
	*/
	public static com.collaborated.entity.model.userProfileImage updateuserProfileImage(
		com.collaborated.entity.model.userProfileImage userProfileImage) {
		return getService().updateuserProfileImage(userProfileImage);
	}

	public static com.collaborated.entity.model.userProfileImageBlobDataBlobModel getBlobDataBlobModel(
		java.io.Serializable primaryKey) {
		return getService().getBlobDataBlobModel(primaryKey);
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
	* Returns the number of user profile images.
	*
	* @return the number of user profile images
	*/
	public static int getuserProfileImagesCount() {
		return getService().getuserProfileImagesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.userProfileImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.userProfileImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the user profile images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.userProfileImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user profile images
	* @param end the upper bound of the range of user profile images (not inclusive)
	* @return the range of user profile images
	*/
	public static java.util.List<com.collaborated.entity.model.userProfileImage> getuserProfileImages(
		int start, int end) {
		return getService().getuserProfileImages(start, end);
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

	public static userProfileImageLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<userProfileImageLocalService, userProfileImageLocalService> _serviceTracker =
		ServiceTrackerFactory.open(userProfileImageLocalService.class);
}