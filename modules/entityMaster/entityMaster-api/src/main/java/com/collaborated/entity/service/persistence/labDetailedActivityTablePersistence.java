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

import com.collaborated.entity.exception.NoSuchlabDetailedActivityTableException;
import com.collaborated.entity.model.labDetailedActivityTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab detailed activity table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labDetailedActivityTablePersistenceImpl
 * @see labDetailedActivityTableUtil
 * @generated
 */
@ProviderType
public interface labDetailedActivityTablePersistence extends BasePersistence<labDetailedActivityTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labDetailedActivityTableUtil} to access the lab detailed activity table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lab detailed activity table in the entity cache if it is enabled.
	*
	* @param labDetailedActivityTable the lab detailed activity table
	*/
	public void cacheResult(labDetailedActivityTable labDetailedActivityTable);

	/**
	* Caches the lab detailed activity tables in the entity cache if it is enabled.
	*
	* @param labDetailedActivityTables the lab detailed activity tables
	*/
	public void cacheResult(
		java.util.List<labDetailedActivityTable> labDetailedActivityTables);

	/**
	* Creates a new lab detailed activity table with the primary key. Does not add the lab detailed activity table to the database.
	*
	* @param PK_activityTableId the primary key for the new lab detailed activity table
	* @return the new lab detailed activity table
	*/
	public labDetailedActivityTable create(long PK_activityTableId);

	/**
	* Removes the lab detailed activity table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_activityTableId the primary key of the lab detailed activity table
	* @return the lab detailed activity table that was removed
	* @throws NoSuchlabDetailedActivityTableException if a lab detailed activity table with the primary key could not be found
	*/
	public labDetailedActivityTable remove(long PK_activityTableId)
		throws NoSuchlabDetailedActivityTableException;

	public labDetailedActivityTable updateImpl(
		labDetailedActivityTable labDetailedActivityTable);

	/**
	* Returns the lab detailed activity table with the primary key or throws a {@link NoSuchlabDetailedActivityTableException} if it could not be found.
	*
	* @param PK_activityTableId the primary key of the lab detailed activity table
	* @return the lab detailed activity table
	* @throws NoSuchlabDetailedActivityTableException if a lab detailed activity table with the primary key could not be found
	*/
	public labDetailedActivityTable findByPrimaryKey(long PK_activityTableId)
		throws NoSuchlabDetailedActivityTableException;

	/**
	* Returns the lab detailed activity table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_activityTableId the primary key of the lab detailed activity table
	* @return the lab detailed activity table, or <code>null</code> if a lab detailed activity table with the primary key could not be found
	*/
	public labDetailedActivityTable fetchByPrimaryKey(long PK_activityTableId);

	@Override
	public java.util.Map<java.io.Serializable, labDetailedActivityTable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab detailed activity tables.
	*
	* @return the lab detailed activity tables
	*/
	public java.util.List<labDetailedActivityTable> findAll();

	/**
	* Returns a range of all the lab detailed activity tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedActivityTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed activity tables
	* @param end the upper bound of the range of lab detailed activity tables (not inclusive)
	* @return the range of lab detailed activity tables
	*/
	public java.util.List<labDetailedActivityTable> findAll(int start, int end);

	/**
	* Returns an ordered range of all the lab detailed activity tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedActivityTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed activity tables
	* @param end the upper bound of the range of lab detailed activity tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailed activity tables
	*/
	public java.util.List<labDetailedActivityTable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedActivityTable> orderByComparator);

	/**
	* Returns an ordered range of all the lab detailed activity tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedActivityTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed activity tables
	* @param end the upper bound of the range of lab detailed activity tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailed activity tables
	*/
	public java.util.List<labDetailedActivityTable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedActivityTable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab detailed activity tables from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab detailed activity tables.
	*
	* @return the number of lab detailed activity tables
	*/
	public int countAll();
}