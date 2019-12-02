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

import com.collaborated.entity.exception.NoSuchuserInstitutionProfileSubDetailsException;
import com.collaborated.entity.model.userInstitutionProfileSubDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user institution profile sub details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.userInstitutionProfileSubDetailsPersistenceImpl
 * @see userInstitutionProfileSubDetailsUtil
 * @generated
 */
@ProviderType
public interface userInstitutionProfileSubDetailsPersistence
	extends BasePersistence<userInstitutionProfileSubDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link userInstitutionProfileSubDetailsUtil} to access the user institution profile sub details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user institution profile sub details in the entity cache if it is enabled.
	*
	* @param userInstitutionProfileSubDetails the user institution profile sub details
	*/
	public void cacheResult(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails);

	/**
	* Caches the user institution profile sub detailses in the entity cache if it is enabled.
	*
	* @param userInstitutionProfileSubDetailses the user institution profile sub detailses
	*/
	public void cacheResult(
		java.util.List<userInstitutionProfileSubDetails> userInstitutionProfileSubDetailses);

	/**
	* Creates a new user institution profile sub details with the primary key. Does not add the user institution profile sub details to the database.
	*
	* @param PK_userInstitionSub the primary key for the new user institution profile sub details
	* @return the new user institution profile sub details
	*/
	public userInstitutionProfileSubDetails create(long PK_userInstitionSub);

	/**
	* Removes the user institution profile sub details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_userInstitionSub the primary key of the user institution profile sub details
	* @return the user institution profile sub details that was removed
	* @throws NoSuchuserInstitutionProfileSubDetailsException if a user institution profile sub details with the primary key could not be found
	*/
	public userInstitutionProfileSubDetails remove(long PK_userInstitionSub)
		throws NoSuchuserInstitutionProfileSubDetailsException;

	public userInstitutionProfileSubDetails updateImpl(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails);

	/**
	* Returns the user institution profile sub details with the primary key or throws a {@link NoSuchuserInstitutionProfileSubDetailsException} if it could not be found.
	*
	* @param PK_userInstitionSub the primary key of the user institution profile sub details
	* @return the user institution profile sub details
	* @throws NoSuchuserInstitutionProfileSubDetailsException if a user institution profile sub details with the primary key could not be found
	*/
	public userInstitutionProfileSubDetails findByPrimaryKey(
		long PK_userInstitionSub)
		throws NoSuchuserInstitutionProfileSubDetailsException;

	/**
	* Returns the user institution profile sub details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_userInstitionSub the primary key of the user institution profile sub details
	* @return the user institution profile sub details, or <code>null</code> if a user institution profile sub details with the primary key could not be found
	*/
	public userInstitutionProfileSubDetails fetchByPrimaryKey(
		long PK_userInstitionSub);

	@Override
	public java.util.Map<java.io.Serializable, userInstitutionProfileSubDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user institution profile sub detailses.
	*
	* @return the user institution profile sub detailses
	*/
	public java.util.List<userInstitutionProfileSubDetails> findAll();

	/**
	* Returns a range of all the user institution profile sub detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileSubDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user institution profile sub detailses
	* @param end the upper bound of the range of user institution profile sub detailses (not inclusive)
	* @return the range of user institution profile sub detailses
	*/
	public java.util.List<userInstitutionProfileSubDetails> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the user institution profile sub detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileSubDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user institution profile sub detailses
	* @param end the upper bound of the range of user institution profile sub detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user institution profile sub detailses
	*/
	public java.util.List<userInstitutionProfileSubDetails> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<userInstitutionProfileSubDetails> orderByComparator);

	/**
	* Returns an ordered range of all the user institution profile sub detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileSubDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user institution profile sub detailses
	* @param end the upper bound of the range of user institution profile sub detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user institution profile sub detailses
	*/
	public java.util.List<userInstitutionProfileSubDetails> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<userInstitutionProfileSubDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user institution profile sub detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user institution profile sub detailses.
	*
	* @return the number of user institution profile sub detailses
	*/
	public int countAll();
}