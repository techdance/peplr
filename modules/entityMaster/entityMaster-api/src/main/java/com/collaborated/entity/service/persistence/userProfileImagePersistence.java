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

import com.collaborated.entity.exception.NoSuchuserProfileImageException;
import com.collaborated.entity.model.userProfileImage;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user profile image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.userProfileImagePersistenceImpl
 * @see userProfileImageUtil
 * @generated
 */
@ProviderType
public interface userProfileImagePersistence extends BasePersistence<userProfileImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link userProfileImageUtil} to access the user profile image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user profile image in the entity cache if it is enabled.
	*
	* @param userProfileImage the user profile image
	*/
	public void cacheResult(userProfileImage userProfileImage);

	/**
	* Caches the user profile images in the entity cache if it is enabled.
	*
	* @param userProfileImages the user profile images
	*/
	public void cacheResult(java.util.List<userProfileImage> userProfileImages);

	/**
	* Creates a new user profile image with the primary key. Does not add the user profile image to the database.
	*
	* @param PK_profileImageId the primary key for the new user profile image
	* @return the new user profile image
	*/
	public userProfileImage create(long PK_profileImageId);

	/**
	* Removes the user profile image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image that was removed
	* @throws NoSuchuserProfileImageException if a user profile image with the primary key could not be found
	*/
	public userProfileImage remove(long PK_profileImageId)
		throws NoSuchuserProfileImageException;

	public userProfileImage updateImpl(userProfileImage userProfileImage);

	/**
	* Returns the user profile image with the primary key or throws a {@link NoSuchuserProfileImageException} if it could not be found.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image
	* @throws NoSuchuserProfileImageException if a user profile image with the primary key could not be found
	*/
	public userProfileImage findByPrimaryKey(long PK_profileImageId)
		throws NoSuchuserProfileImageException;

	/**
	* Returns the user profile image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_profileImageId the primary key of the user profile image
	* @return the user profile image, or <code>null</code> if a user profile image with the primary key could not be found
	*/
	public userProfileImage fetchByPrimaryKey(long PK_profileImageId);

	@Override
	public java.util.Map<java.io.Serializable, userProfileImage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user profile images.
	*
	* @return the user profile images
	*/
	public java.util.List<userProfileImage> findAll();

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
	public java.util.List<userProfileImage> findAll(int start, int end);

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
	public java.util.List<userProfileImage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<userProfileImage> orderByComparator);

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
	public java.util.List<userProfileImage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<userProfileImage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user profile images from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user profile images.
	*
	* @return the number of user profile images
	*/
	public int countAll();
}