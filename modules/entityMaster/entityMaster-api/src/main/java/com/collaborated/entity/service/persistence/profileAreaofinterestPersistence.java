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

import com.collaborated.entity.exception.NoSuchprofileAreaofinterestException;
import com.collaborated.entity.model.profileAreaofinterest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the profile areaofinterest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.profileAreaofinterestPersistenceImpl
 * @see profileAreaofinterestUtil
 * @generated
 */
@ProviderType
public interface profileAreaofinterestPersistence extends BasePersistence<profileAreaofinterest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link profileAreaofinterestUtil} to access the profile areaofinterest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the profile areaofinterest in the entity cache if it is enabled.
	*
	* @param profileAreaofinterest the profile areaofinterest
	*/
	public void cacheResult(profileAreaofinterest profileAreaofinterest);

	/**
	* Caches the profile areaofinterests in the entity cache if it is enabled.
	*
	* @param profileAreaofinterests the profile areaofinterests
	*/
	public void cacheResult(
		java.util.List<profileAreaofinterest> profileAreaofinterests);

	/**
	* Creates a new profile areaofinterest with the primary key. Does not add the profile areaofinterest to the database.
	*
	* @param PK_areaofinterest the primary key for the new profile areaofinterest
	* @return the new profile areaofinterest
	*/
	public profileAreaofinterest create(long PK_areaofinterest);

	/**
	* Removes the profile areaofinterest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_areaofinterest the primary key of the profile areaofinterest
	* @return the profile areaofinterest that was removed
	* @throws NoSuchprofileAreaofinterestException if a profile areaofinterest with the primary key could not be found
	*/
	public profileAreaofinterest remove(long PK_areaofinterest)
		throws NoSuchprofileAreaofinterestException;

	public profileAreaofinterest updateImpl(
		profileAreaofinterest profileAreaofinterest);

	/**
	* Returns the profile areaofinterest with the primary key or throws a {@link NoSuchprofileAreaofinterestException} if it could not be found.
	*
	* @param PK_areaofinterest the primary key of the profile areaofinterest
	* @return the profile areaofinterest
	* @throws NoSuchprofileAreaofinterestException if a profile areaofinterest with the primary key could not be found
	*/
	public profileAreaofinterest findByPrimaryKey(long PK_areaofinterest)
		throws NoSuchprofileAreaofinterestException;

	/**
	* Returns the profile areaofinterest with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_areaofinterest the primary key of the profile areaofinterest
	* @return the profile areaofinterest, or <code>null</code> if a profile areaofinterest with the primary key could not be found
	*/
	public profileAreaofinterest fetchByPrimaryKey(long PK_areaofinterest);

	@Override
	public java.util.Map<java.io.Serializable, profileAreaofinterest> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the profile areaofinterests.
	*
	* @return the profile areaofinterests
	*/
	public java.util.List<profileAreaofinterest> findAll();

	/**
	* Returns a range of all the profile areaofinterests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile areaofinterests
	* @param end the upper bound of the range of profile areaofinterests (not inclusive)
	* @return the range of profile areaofinterests
	*/
	public java.util.List<profileAreaofinterest> findAll(int start, int end);

	/**
	* Returns an ordered range of all the profile areaofinterests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile areaofinterests
	* @param end the upper bound of the range of profile areaofinterests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of profile areaofinterests
	*/
	public java.util.List<profileAreaofinterest> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<profileAreaofinterest> orderByComparator);

	/**
	* Returns an ordered range of all the profile areaofinterests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of profile areaofinterests
	* @param end the upper bound of the range of profile areaofinterests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of profile areaofinterests
	*/
	public java.util.List<profileAreaofinterest> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<profileAreaofinterest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the profile areaofinterests from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of profile areaofinterests.
	*
	* @return the number of profile areaofinterests
	*/
	public int countAll();
}