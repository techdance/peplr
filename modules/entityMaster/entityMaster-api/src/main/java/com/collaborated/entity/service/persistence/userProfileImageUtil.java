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

package com.collaborated.entity.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.collaborated.entity.model.userProfileImage;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user profile image service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.userProfileImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userProfileImagePersistence
 * @see com.collaborated.entity.service.persistence.impl.userProfileImagePersistenceImpl
 * @generated
 */
@ProviderType
public class userProfileImageUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(userProfileImage userProfileImage) {
		getPersistence().clearCache(userProfileImage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<userProfileImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<userProfileImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<userProfileImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<userProfileImage> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static userProfileImage update(userProfileImage userProfileImage) {
		return getPersistence().update(userProfileImage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static userProfileImage update(userProfileImage userProfileImage,
		ServiceContext serviceContext) {
		return getPersistence().update(userProfileImage, serviceContext);
	}

	/**
	* Caches the user profile image in the entity cache if it is enabled.
	*
	* @param userProfileImage the user profile image
	*/
	public static void cacheResult(userProfileImage userProfileImage) {
		getPersistence().cacheResult(userProfileImage);
	}

	/**
	* Caches the user profile images in the entity cache if it is enabled.
	*
	* @param userProfileImages the user profile images
	*/
	public static void cacheResult(List<userProfileImage> userProfileImages) {
		getPersistence().cacheResult(userProfileImages);
	}

	/**
	* Creates a new user profile image with the primary key. Does not add the user profile image to the database.
	*
	* @param PK_profileImageId the primary key for the new user profile image
	* @return the new user profile image
	*/
	public static userProfileImage create(long PK_profileImageId) {
		return getPersistence().create(PK_profileImageId);
	}

	/**
	* Removes the user profile image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image that was removed
	* @throws NoSuchuserProfileImageException if a user profile image with the primary key could not be found
	*/
	public static userProfileImage remove(long PK_profileImageId)
		throws com.collaborated.entity.exception.NoSuchuserProfileImageException {
		return getPersistence().remove(PK_profileImageId);
	}

	public static userProfileImage updateImpl(userProfileImage userProfileImage) {
		return getPersistence().updateImpl(userProfileImage);
	}

	/**
	* Returns the user profile image with the primary key or throws a {@link NoSuchuserProfileImageException} if it could not be found.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image
	* @throws NoSuchuserProfileImageException if a user profile image with the primary key could not be found
	*/
	public static userProfileImage findByPrimaryKey(long PK_profileImageId)
		throws com.collaborated.entity.exception.NoSuchuserProfileImageException {
		return getPersistence().findByPrimaryKey(PK_profileImageId);
	}

	/**
	* Returns the user profile image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image, or <code>null</code> if a user profile image with the primary key could not be found
	*/
	public static userProfileImage fetchByPrimaryKey(long PK_profileImageId) {
		return getPersistence().fetchByPrimaryKey(PK_profileImageId);
	}

	public static java.util.Map<java.io.Serializable, userProfileImage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user profile images.
	*
	* @return the user profile images
	*/
	public static List<userProfileImage> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user profile images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfileImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user profile images
	* @param end the upper bound of the range of user profile images (not inclusive)
	* @return the range of user profile images
	*/
	public static List<userProfileImage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user profile images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfileImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user profile images
	* @param end the upper bound of the range of user profile images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user profile images
	*/
	public static List<userProfileImage> findAll(int start, int end,
		OrderByComparator<userProfileImage> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user profile images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfileImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user profile images
	* @param end the upper bound of the range of user profile images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user profile images
	*/
	public static List<userProfileImage> findAll(int start, int end,
		OrderByComparator<userProfileImage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user profile images from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user profile images.
	*
	* @return the number of user profile images
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static userProfileImagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<userProfileImagePersistence, userProfileImagePersistence> _serviceTracker =
		ServiceTrackerFactory.open(userProfileImagePersistence.class);
}