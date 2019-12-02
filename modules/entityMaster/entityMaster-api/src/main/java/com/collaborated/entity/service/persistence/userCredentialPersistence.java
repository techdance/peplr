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

import com.collaborated.entity.exception.NoSuchuserCredentialException;
import com.collaborated.entity.model.userCredential;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user credential service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.userCredentialPersistenceImpl
 * @see userCredentialUtil
 * @generated
 */
@ProviderType
public interface userCredentialPersistence extends BasePersistence<userCredential> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link userCredentialUtil} to access the user credential persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user credential in the entity cache if it is enabled.
	*
	* @param userCredential the user credential
	*/
	public void cacheResult(userCredential userCredential);

	/**
	* Caches the user credentials in the entity cache if it is enabled.
	*
	* @param userCredentials the user credentials
	*/
	public void cacheResult(java.util.List<userCredential> userCredentials);

	/**
	* Creates a new user credential with the primary key. Does not add the user credential to the database.
	*
	* @param PK_userCredential the primary key for the new user credential
	* @return the new user credential
	*/
	public userCredential create(long PK_userCredential);

	/**
	* Removes the user credential with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_userCredential the primary key of the user credential
	* @return the user credential that was removed
	* @throws NoSuchuserCredentialException if a user credential with the primary key could not be found
	*/
	public userCredential remove(long PK_userCredential)
		throws NoSuchuserCredentialException;

	public userCredential updateImpl(userCredential userCredential);

	/**
	* Returns the user credential with the primary key or throws a {@link NoSuchuserCredentialException} if it could not be found.
	*
	* @param PK_userCredential the primary key of the user credential
	* @return the user credential
	* @throws NoSuchuserCredentialException if a user credential with the primary key could not be found
	*/
	public userCredential findByPrimaryKey(long PK_userCredential)
		throws NoSuchuserCredentialException;

	/**
	* Returns the user credential with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_userCredential the primary key of the user credential
	* @return the user credential, or <code>null</code> if a user credential with the primary key could not be found
	*/
	public userCredential fetchByPrimaryKey(long PK_userCredential);

	@Override
	public java.util.Map<java.io.Serializable, userCredential> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user credentials.
	*
	* @return the user credentials
	*/
	public java.util.List<userCredential> findAll();

	/**
	* Returns a range of all the user credentials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user credentials
	* @param end the upper bound of the range of user credentials (not inclusive)
	* @return the range of user credentials
	*/
	public java.util.List<userCredential> findAll(int start, int end);

	/**
	* Returns an ordered range of all the user credentials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user credentials
	* @param end the upper bound of the range of user credentials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user credentials
	*/
	public java.util.List<userCredential> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<userCredential> orderByComparator);

	/**
	* Returns an ordered range of all the user credentials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user credentials
	* @param end the upper bound of the range of user credentials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user credentials
	*/
	public java.util.List<userCredential> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<userCredential> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user credentials from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user credentials.
	*
	* @return the number of user credentials
	*/
	public int countAll();
}