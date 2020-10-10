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

import com.collaborated.entity.exception.NoSuchCustom_WorkflowLogException;
import com.collaborated.entity.model.Custom_WorkflowLog;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the custom_ workflow log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.Custom_WorkflowLogPersistenceImpl
 * @see Custom_WorkflowLogUtil
 * @generated
 */
@ProviderType
public interface Custom_WorkflowLogPersistence extends BasePersistence<Custom_WorkflowLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Custom_WorkflowLogUtil} to access the custom_ workflow log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the custom_ workflow log in the entity cache if it is enabled.
	*
	* @param custom_WorkflowLog the custom_ workflow log
	*/
	public void cacheResult(Custom_WorkflowLog custom_WorkflowLog);

	/**
	* Caches the custom_ workflow logs in the entity cache if it is enabled.
	*
	* @param custom_WorkflowLogs the custom_ workflow logs
	*/
	public void cacheResult(
		java.util.List<Custom_WorkflowLog> custom_WorkflowLogs);

	/**
	* Creates a new custom_ workflow log with the primary key. Does not add the custom_ workflow log to the database.
	*
	* @param logId the primary key for the new custom_ workflow log
	* @return the new custom_ workflow log
	*/
	public Custom_WorkflowLog create(long logId);

	/**
	* Removes the custom_ workflow log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logId the primary key of the custom_ workflow log
	* @return the custom_ workflow log that was removed
	* @throws NoSuchCustom_WorkflowLogException if a custom_ workflow log with the primary key could not be found
	*/
	public Custom_WorkflowLog remove(long logId)
		throws NoSuchCustom_WorkflowLogException;

	public Custom_WorkflowLog updateImpl(Custom_WorkflowLog custom_WorkflowLog);

	/**
	* Returns the custom_ workflow log with the primary key or throws a {@link NoSuchCustom_WorkflowLogException} if it could not be found.
	*
	* @param logId the primary key of the custom_ workflow log
	* @return the custom_ workflow log
	* @throws NoSuchCustom_WorkflowLogException if a custom_ workflow log with the primary key could not be found
	*/
	public Custom_WorkflowLog findByPrimaryKey(long logId)
		throws NoSuchCustom_WorkflowLogException;

	/**
	* Returns the custom_ workflow log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param logId the primary key of the custom_ workflow log
	* @return the custom_ workflow log, or <code>null</code> if a custom_ workflow log with the primary key could not be found
	*/
	public Custom_WorkflowLog fetchByPrimaryKey(long logId);

	@Override
	public java.util.Map<java.io.Serializable, Custom_WorkflowLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the custom_ workflow logs.
	*
	* @return the custom_ workflow logs
	*/
	public java.util.List<Custom_WorkflowLog> findAll();

	/**
	* Returns a range of all the custom_ workflow logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow logs
	* @param end the upper bound of the range of custom_ workflow logs (not inclusive)
	* @return the range of custom_ workflow logs
	*/
	public java.util.List<Custom_WorkflowLog> findAll(int start, int end);

	/**
	* Returns an ordered range of all the custom_ workflow logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow logs
	* @param end the upper bound of the range of custom_ workflow logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of custom_ workflow logs
	*/
	public java.util.List<Custom_WorkflowLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_WorkflowLog> orderByComparator);

	/**
	* Returns an ordered range of all the custom_ workflow logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow logs
	* @param end the upper bound of the range of custom_ workflow logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of custom_ workflow logs
	*/
	public java.util.List<Custom_WorkflowLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_WorkflowLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the custom_ workflow logs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of custom_ workflow logs.
	*
	* @return the number of custom_ workflow logs
	*/
	public int countAll();
}