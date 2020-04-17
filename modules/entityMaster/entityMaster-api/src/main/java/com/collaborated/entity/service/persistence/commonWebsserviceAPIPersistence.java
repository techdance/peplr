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

import com.collaborated.entity.exception.NoSuchcommonWebsserviceAPIException;
import com.collaborated.entity.model.commonWebsserviceAPI;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the common websservice a p i service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.commonWebsserviceAPIPersistenceImpl
 * @see commonWebsserviceAPIUtil
 * @generated
 */
@ProviderType
public interface commonWebsserviceAPIPersistence extends BasePersistence<commonWebsserviceAPI> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link commonWebsserviceAPIUtil} to access the common websservice a p i persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the common websservice a p i in the entity cache if it is enabled.
	*
	* @param commonWebsserviceAPI the common websservice a p i
	*/
	public void cacheResult(commonWebsserviceAPI commonWebsserviceAPI);

	/**
	* Caches the common websservice a p is in the entity cache if it is enabled.
	*
	* @param commonWebsserviceAPIs the common websservice a p is
	*/
	public void cacheResult(
		java.util.List<commonWebsserviceAPI> commonWebsserviceAPIs);

	/**
	* Creates a new common websservice a p i with the primary key. Does not add the common websservice a p i to the database.
	*
	* @param commonAPIId the primary key for the new common websservice a p i
	* @return the new common websservice a p i
	*/
	public commonWebsserviceAPI create(long commonAPIId);

	/**
	* Removes the common websservice a p i with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i that was removed
	* @throws NoSuchcommonWebsserviceAPIException if a common websservice a p i with the primary key could not be found
	*/
	public commonWebsserviceAPI remove(long commonAPIId)
		throws NoSuchcommonWebsserviceAPIException;

	public commonWebsserviceAPI updateImpl(
		commonWebsserviceAPI commonWebsserviceAPI);

	/**
	* Returns the common websservice a p i with the primary key or throws a {@link NoSuchcommonWebsserviceAPIException} if it could not be found.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i
	* @throws NoSuchcommonWebsserviceAPIException if a common websservice a p i with the primary key could not be found
	*/
	public commonWebsserviceAPI findByPrimaryKey(long commonAPIId)
		throws NoSuchcommonWebsserviceAPIException;

	/**
	* Returns the common websservice a p i with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i, or <code>null</code> if a common websservice a p i with the primary key could not be found
	*/
	public commonWebsserviceAPI fetchByPrimaryKey(long commonAPIId);

	@Override
	public java.util.Map<java.io.Serializable, commonWebsserviceAPI> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the common websservice a p is.
	*
	* @return the common websservice a p is
	*/
	public java.util.List<commonWebsserviceAPI> findAll();

	/**
	* Returns a range of all the common websservice a p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common websservice a p is
	* @param end the upper bound of the range of common websservice a p is (not inclusive)
	* @return the range of common websservice a p is
	*/
	public java.util.List<commonWebsserviceAPI> findAll(int start, int end);

	/**
	* Returns an ordered range of all the common websservice a p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common websservice a p is
	* @param end the upper bound of the range of common websservice a p is (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of common websservice a p is
	*/
	public java.util.List<commonWebsserviceAPI> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<commonWebsserviceAPI> orderByComparator);

	/**
	* Returns an ordered range of all the common websservice a p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common websservice a p is
	* @param end the upper bound of the range of common websservice a p is (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of common websservice a p is
	*/
	public java.util.List<commonWebsserviceAPI> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<commonWebsserviceAPI> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the common websservice a p is from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of common websservice a p is.
	*
	* @return the number of common websservice a p is
	*/
	public int countAll();
}