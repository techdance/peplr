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

import com.collaborated.entity.exception.NoSuchuserProfessionalBioException;
import com.collaborated.entity.model.userProfessionalBio;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user professional bio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.userProfessionalBioPersistenceImpl
 * @see userProfessionalBioUtil
 * @generated
 */
@ProviderType
public interface userProfessionalBioPersistence extends BasePersistence<userProfessionalBio> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link userProfessionalBioUtil} to access the user professional bio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user professional bio in the entity cache if it is enabled.
	*
	* @param userProfessionalBio the user professional bio
	*/
	public void cacheResult(userProfessionalBio userProfessionalBio);

	/**
	* Caches the user professional bios in the entity cache if it is enabled.
	*
	* @param userProfessionalBios the user professional bios
	*/
	public void cacheResult(
		java.util.List<userProfessionalBio> userProfessionalBios);

	/**
	* Creates a new user professional bio with the primary key. Does not add the user professional bio to the database.
	*
	* @param PK_userProfessionalBio the primary key for the new user professional bio
	* @return the new user professional bio
	*/
	public userProfessionalBio create(long PK_userProfessionalBio);

	/**
	* Removes the user professional bio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_userProfessionalBio the primary key of the user professional bio
	* @return the user professional bio that was removed
	* @throws NoSuchuserProfessionalBioException if a user professional bio with the primary key could not be found
	*/
	public userProfessionalBio remove(long PK_userProfessionalBio)
		throws NoSuchuserProfessionalBioException;

	public userProfessionalBio updateImpl(
		userProfessionalBio userProfessionalBio);

	/**
	* Returns the user professional bio with the primary key or throws a {@link NoSuchuserProfessionalBioException} if it could not be found.
	*
	* @param PK_userProfessionalBio the primary key of the user professional bio
	* @return the user professional bio
	* @throws NoSuchuserProfessionalBioException if a user professional bio with the primary key could not be found
	*/
	public userProfessionalBio findByPrimaryKey(long PK_userProfessionalBio)
		throws NoSuchuserProfessionalBioException;

	/**
	* Returns the user professional bio with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_userProfessionalBio the primary key of the user professional bio
	* @return the user professional bio, or <code>null</code> if a user professional bio with the primary key could not be found
	*/
	public userProfessionalBio fetchByPrimaryKey(long PK_userProfessionalBio);

	@Override
	public java.util.Map<java.io.Serializable, userProfessionalBio> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user professional bios.
	*
	* @return the user professional bios
	*/
	public java.util.List<userProfessionalBio> findAll();

	/**
	* Returns a range of all the user professional bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user professional bios
	* @param end the upper bound of the range of user professional bios (not inclusive)
	* @return the range of user professional bios
	*/
	public java.util.List<userProfessionalBio> findAll(int start, int end);

	/**
	* Returns an ordered range of all the user professional bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user professional bios
	* @param end the upper bound of the range of user professional bios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user professional bios
	*/
	public java.util.List<userProfessionalBio> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<userProfessionalBio> orderByComparator);

	/**
	* Returns an ordered range of all the user professional bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user professional bios
	* @param end the upper bound of the range of user professional bios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user professional bios
	*/
	public java.util.List<userProfessionalBio> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<userProfessionalBio> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user professional bios from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user professional bios.
	*
	* @return the number of user professional bios
	*/
	public int countAll();
}