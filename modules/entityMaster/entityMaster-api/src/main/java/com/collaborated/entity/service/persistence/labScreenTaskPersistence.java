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

import com.collaborated.entity.exception.NoSuchlabScreenTaskException;
import com.collaborated.entity.model.labScreenTask;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab screen task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labScreenTaskPersistenceImpl
 * @see labScreenTaskUtil
 * @generated
 */
@ProviderType
public interface labScreenTaskPersistence extends BasePersistence<labScreenTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labScreenTaskUtil} to access the lab screen task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lab screen task in the entity cache if it is enabled.
	*
	* @param labScreenTask the lab screen task
	*/
	public void cacheResult(labScreenTask labScreenTask);

	/**
	* Caches the lab screen tasks in the entity cache if it is enabled.
	*
	* @param labScreenTasks the lab screen tasks
	*/
	public void cacheResult(java.util.List<labScreenTask> labScreenTasks);

	/**
	* Creates a new lab screen task with the primary key. Does not add the lab screen task to the database.
	*
	* @param PK_taskId the primary key for the new lab screen task
	* @return the new lab screen task
	*/
	public labScreenTask create(long PK_taskId);

	/**
	* Removes the lab screen task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_taskId the primary key of the lab screen task
	* @return the lab screen task that was removed
	* @throws NoSuchlabScreenTaskException if a lab screen task with the primary key could not be found
	*/
	public labScreenTask remove(long PK_taskId)
		throws NoSuchlabScreenTaskException;

	public labScreenTask updateImpl(labScreenTask labScreenTask);

	/**
	* Returns the lab screen task with the primary key or throws a {@link NoSuchlabScreenTaskException} if it could not be found.
	*
	* @param PK_taskId the primary key of the lab screen task
	* @return the lab screen task
	* @throws NoSuchlabScreenTaskException if a lab screen task with the primary key could not be found
	*/
	public labScreenTask findByPrimaryKey(long PK_taskId)
		throws NoSuchlabScreenTaskException;

	/**
	* Returns the lab screen task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_taskId the primary key of the lab screen task
	* @return the lab screen task, or <code>null</code> if a lab screen task with the primary key could not be found
	*/
	public labScreenTask fetchByPrimaryKey(long PK_taskId);

	@Override
	public java.util.Map<java.io.Serializable, labScreenTask> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab screen tasks.
	*
	* @return the lab screen tasks
	*/
	public java.util.List<labScreenTask> findAll();

	/**
	* Returns a range of all the lab screen tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen tasks
	* @param end the upper bound of the range of lab screen tasks (not inclusive)
	* @return the range of lab screen tasks
	*/
	public java.util.List<labScreenTask> findAll(int start, int end);

	/**
	* Returns an ordered range of all the lab screen tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen tasks
	* @param end the upper bound of the range of lab screen tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab screen tasks
	*/
	public java.util.List<labScreenTask> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labScreenTask> orderByComparator);

	/**
	* Returns an ordered range of all the lab screen tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen tasks
	* @param end the upper bound of the range of lab screen tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab screen tasks
	*/
	public java.util.List<labScreenTask> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labScreenTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab screen tasks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab screen tasks.
	*
	* @return the number of lab screen tasks
	*/
	public int countAll();
}