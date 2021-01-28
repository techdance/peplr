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

import com.collaborated.entity.exception.NoSuchapplicationLogException;
import com.collaborated.entity.model.applicationLog;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the application log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.applicationLogPersistenceImpl
 * @see applicationLogUtil
 * @generated
 */
@ProviderType
public interface applicationLogPersistence extends BasePersistence<applicationLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link applicationLogUtil} to access the application log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the application log in the entity cache if it is enabled.
	*
	* @param applicationLog the application log
	*/
	public void cacheResult(applicationLog applicationLog);

	/**
	* Caches the application logs in the entity cache if it is enabled.
	*
	* @param applicationLogs the application logs
	*/
	public void cacheResult(java.util.List<applicationLog> applicationLogs);

	/**
	* Creates a new application log with the primary key. Does not add the application log to the database.
	*
	* @param PK_logId the primary key for the new application log
	* @return the new application log
	*/
	public applicationLog create(long PK_logId);

	/**
	* Removes the application log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_logId the primary key of the application log
	* @return the application log that was removed
	* @throws NoSuchapplicationLogException if a application log with the primary key could not be found
	*/
	public applicationLog remove(long PK_logId)
		throws NoSuchapplicationLogException;

	public applicationLog updateImpl(applicationLog applicationLog);

	/**
	* Returns the application log with the primary key or throws a {@link NoSuchapplicationLogException} if it could not be found.
	*
	* @param PK_logId the primary key of the application log
	* @return the application log
	* @throws NoSuchapplicationLogException if a application log with the primary key could not be found
	*/
	public applicationLog findByPrimaryKey(long PK_logId)
		throws NoSuchapplicationLogException;

	/**
	* Returns the application log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_logId the primary key of the application log
	* @return the application log, or <code>null</code> if a application log with the primary key could not be found
	*/
	public applicationLog fetchByPrimaryKey(long PK_logId);

	@Override
	public java.util.Map<java.io.Serializable, applicationLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the application logs.
	*
	* @return the application logs
	*/
	public java.util.List<applicationLog> findAll();

	/**
	* Returns a range of all the application logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link applicationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application logs
	* @param end the upper bound of the range of application logs (not inclusive)
	* @return the range of application logs
	*/
	public java.util.List<applicationLog> findAll(int start, int end);

	/**
	* Returns an ordered range of all the application logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link applicationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application logs
	* @param end the upper bound of the range of application logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of application logs
	*/
	public java.util.List<applicationLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<applicationLog> orderByComparator);

	/**
	* Returns an ordered range of all the application logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link applicationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application logs
	* @param end the upper bound of the range of application logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of application logs
	*/
	public java.util.List<applicationLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<applicationLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the application logs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of application logs.
	*
	* @return the number of application logs
	*/
	public int countAll();
}