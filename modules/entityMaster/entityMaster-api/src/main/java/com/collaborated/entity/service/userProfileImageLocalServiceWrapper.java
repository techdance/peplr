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
 * Provides a wrapper for {@link userProfileImageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see userProfileImageLocalService
 * @generated
 */
@ProviderType
public class userProfileImageLocalServiceWrapper
	implements userProfileImageLocalService,
		ServiceWrapper<userProfileImageLocalService> {
	public userProfileImageLocalServiceWrapper(
		userProfileImageLocalService userProfileImageLocalService) {
		_userProfileImageLocalService = userProfileImageLocalService;
	}

	/**
	* Adds the user profile image to the database. Also notifies the appropriate model listeners.
	*
	* @param userProfileImage the user profile image
	* @return the user profile image that was added
	*/
	@Override
	public com.collaborated.entity.model.userProfileImage adduserProfileImage(
		com.collaborated.entity.model.userProfileImage userProfileImage) {
		return _userProfileImageLocalService.adduserProfileImage(userProfileImage);
	}

	/**
	* Creates a new user profile image with the primary key. Does not add the user profile image to the database.
	*
	* @param PK_profileImageId the primary key for the new user profile image
	* @return the new user profile image
	*/
	@Override
	public com.collaborated.entity.model.userProfileImage createuserProfileImage(
		long PK_profileImageId) {
		return _userProfileImageLocalService.createuserProfileImage(PK_profileImageId);
	}

	/**
	* Deletes the user profile image from the database. Also notifies the appropriate model listeners.
	*
	* @param userProfileImage the user profile image
	* @return the user profile image that was removed
	*/
	@Override
	public com.collaborated.entity.model.userProfileImage deleteuserProfileImage(
		com.collaborated.entity.model.userProfileImage userProfileImage) {
		return _userProfileImageLocalService.deleteuserProfileImage(userProfileImage);
	}

	/**
	* Deletes the user profile image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image that was removed
	* @throws PortalException if a user profile image with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.userProfileImage deleteuserProfileImage(
		long PK_profileImageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userProfileImageLocalService.deleteuserProfileImage(PK_profileImageId);
	}

	@Override
	public com.collaborated.entity.model.userProfileImage fetchuserProfileImage(
		long PK_profileImageId) {
		return _userProfileImageLocalService.fetchuserProfileImage(PK_profileImageId);
	}

	/**
	* Returns the user profile image with the primary key.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image
	* @throws PortalException if a user profile image with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.userProfileImage getuserProfileImage(
		long PK_profileImageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userProfileImageLocalService.getuserProfileImage(PK_profileImageId);
	}

	/**
	* Updates the user profile image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userProfileImage the user profile image
	* @return the user profile image that was updated
	*/
	@Override
	public com.collaborated.entity.model.userProfileImage updateuserProfileImage(
		com.collaborated.entity.model.userProfileImage userProfileImage) {
		return _userProfileImageLocalService.updateuserProfileImage(userProfileImage);
	}

	@Override
	public com.collaborated.entity.model.userProfileImageBlobDataBlobModel getBlobDataBlobModel(
		java.io.Serializable primaryKey) {
		return _userProfileImageLocalService.getBlobDataBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userProfileImageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userProfileImageLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userProfileImageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userProfileImageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userProfileImageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of user profile images.
	*
	* @return the number of user profile images
	*/
	@Override
	public int getuserProfileImagesCount() {
		return _userProfileImageLocalService.getuserProfileImagesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userProfileImageLocalService.getOSGiServiceIdentifier();
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
		return _userProfileImageLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _userProfileImageLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _userProfileImageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
	@Override
	public java.util.List<com.collaborated.entity.model.userProfileImage> getuserProfileImages(
		int start, int end) {
		return _userProfileImageLocalService.getuserProfileImages(start, end);
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
		return _userProfileImageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userProfileImageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public userProfileImageLocalService getWrappedService() {
		return _userProfileImageLocalService;
	}

	@Override
	public void setWrappedService(
		userProfileImageLocalService userProfileImageLocalService) {
		_userProfileImageLocalService = userProfileImageLocalService;
	}

	private userProfileImageLocalService _userProfileImageLocalService;
}