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

import com.collaborated.entity.exception.NoSuchlabScreenProjectOverviewException;
import com.collaborated.entity.model.labScreenProjectOverview;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab screen project overview service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labScreenProjectOverviewPersistenceImpl
 * @see labScreenProjectOverviewUtil
 * @generated
 */
@ProviderType
public interface labScreenProjectOverviewPersistence extends BasePersistence<labScreenProjectOverview> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labScreenProjectOverviewUtil} to access the lab screen project overview persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lab screen project overview in the entity cache if it is enabled.
	*
	* @param labScreenProjectOverview the lab screen project overview
	*/
	public void cacheResult(labScreenProjectOverview labScreenProjectOverview);

	/**
	* Caches the lab screen project overviews in the entity cache if it is enabled.
	*
	* @param labScreenProjectOverviews the lab screen project overviews
	*/
	public void cacheResult(
		java.util.List<labScreenProjectOverview> labScreenProjectOverviews);

	/**
	* Creates a new lab screen project overview with the primary key. Does not add the lab screen project overview to the database.
	*
	* @param PK_projectId the primary key for the new lab screen project overview
	* @return the new lab screen project overview
	*/
	public labScreenProjectOverview create(long PK_projectId);

	/**
	* Removes the lab screen project overview with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectId the primary key of the lab screen project overview
	* @return the lab screen project overview that was removed
	* @throws NoSuchlabScreenProjectOverviewException if a lab screen project overview with the primary key could not be found
	*/
	public labScreenProjectOverview remove(long PK_projectId)
		throws NoSuchlabScreenProjectOverviewException;

	public labScreenProjectOverview updateImpl(
		labScreenProjectOverview labScreenProjectOverview);

	/**
	* Returns the lab screen project overview with the primary key or throws a {@link NoSuchlabScreenProjectOverviewException} if it could not be found.
	*
	* @param PK_projectId the primary key of the lab screen project overview
	* @return the lab screen project overview
	* @throws NoSuchlabScreenProjectOverviewException if a lab screen project overview with the primary key could not be found
	*/
	public labScreenProjectOverview findByPrimaryKey(long PK_projectId)
		throws NoSuchlabScreenProjectOverviewException;

	/**
	* Returns the lab screen project overview with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_projectId the primary key of the lab screen project overview
	* @return the lab screen project overview, or <code>null</code> if a lab screen project overview with the primary key could not be found
	*/
	public labScreenProjectOverview fetchByPrimaryKey(long PK_projectId);

	@Override
	public java.util.Map<java.io.Serializable, labScreenProjectOverview> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab screen project overviews.
	*
	* @return the lab screen project overviews
	*/
	public java.util.List<labScreenProjectOverview> findAll();

	/**
	* Returns a range of all the lab screen project overviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project overviews
	* @param end the upper bound of the range of lab screen project overviews (not inclusive)
	* @return the range of lab screen project overviews
	*/
	public java.util.List<labScreenProjectOverview> findAll(int start, int end);

	/**
	* Returns an ordered range of all the lab screen project overviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project overviews
	* @param end the upper bound of the range of lab screen project overviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab screen project overviews
	*/
	public java.util.List<labScreenProjectOverview> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labScreenProjectOverview> orderByComparator);

	/**
	* Returns an ordered range of all the lab screen project overviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project overviews
	* @param end the upper bound of the range of lab screen project overviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab screen project overviews
	*/
	public java.util.List<labScreenProjectOverview> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labScreenProjectOverview> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab screen project overviews from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab screen project overviews.
	*
	* @return the number of lab screen project overviews
	*/
	public int countAll();
}