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

import com.collaborated.entity.exception.NoSuchCustom_Workflow_TaskException;
import com.collaborated.entity.model.Custom_Workflow_Task;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the custom_ workflow_ task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.Custom_Workflow_TaskPersistenceImpl
 * @see Custom_Workflow_TaskUtil
 * @generated
 */
@ProviderType
public interface Custom_Workflow_TaskPersistence extends BasePersistence<Custom_Workflow_Task> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Custom_Workflow_TaskUtil} to access the custom_ workflow_ task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the custom_ workflow_ task in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Task the custom_ workflow_ task
	*/
	public void cacheResult(Custom_Workflow_Task custom_Workflow_Task);

	/**
	* Caches the custom_ workflow_ tasks in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Tasks the custom_ workflow_ tasks
	*/
	public void cacheResult(
		java.util.List<Custom_Workflow_Task> custom_Workflow_Tasks);

	/**
	* Creates a new custom_ workflow_ task with the primary key. Does not add the custom_ workflow_ task to the database.
	*
	* @param workFlowTaskId the primary key for the new custom_ workflow_ task
	* @return the new custom_ workflow_ task
	*/
	public Custom_Workflow_Task create(java.lang.String workFlowTaskId);

	/**
	* Removes the custom_ workflow_ task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workFlowTaskId the primary key of the custom_ workflow_ task
	* @return the custom_ workflow_ task that was removed
	* @throws NoSuchCustom_Workflow_TaskException if a custom_ workflow_ task with the primary key could not be found
	*/
	public Custom_Workflow_Task remove(java.lang.String workFlowTaskId)
		throws NoSuchCustom_Workflow_TaskException;

	public Custom_Workflow_Task updateImpl(
		Custom_Workflow_Task custom_Workflow_Task);

	/**
	* Returns the custom_ workflow_ task with the primary key or throws a {@link NoSuchCustom_Workflow_TaskException} if it could not be found.
	*
	* @param workFlowTaskId the primary key of the custom_ workflow_ task
	* @return the custom_ workflow_ task
	* @throws NoSuchCustom_Workflow_TaskException if a custom_ workflow_ task with the primary key could not be found
	*/
	public Custom_Workflow_Task findByPrimaryKey(
		java.lang.String workFlowTaskId)
		throws NoSuchCustom_Workflow_TaskException;

	/**
	* Returns the custom_ workflow_ task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workFlowTaskId the primary key of the custom_ workflow_ task
	* @return the custom_ workflow_ task, or <code>null</code> if a custom_ workflow_ task with the primary key could not be found
	*/
	public Custom_Workflow_Task fetchByPrimaryKey(
		java.lang.String workFlowTaskId);

	@Override
	public java.util.Map<java.io.Serializable, Custom_Workflow_Task> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the custom_ workflow_ tasks.
	*
	* @return the custom_ workflow_ tasks
	*/
	public java.util.List<Custom_Workflow_Task> findAll();

	/**
	* Returns a range of all the custom_ workflow_ tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ tasks
	* @param end the upper bound of the range of custom_ workflow_ tasks (not inclusive)
	* @return the range of custom_ workflow_ tasks
	*/
	public java.util.List<Custom_Workflow_Task> findAll(int start, int end);

	/**
	* Returns an ordered range of all the custom_ workflow_ tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ tasks
	* @param end the upper bound of the range of custom_ workflow_ tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of custom_ workflow_ tasks
	*/
	public java.util.List<Custom_Workflow_Task> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_Workflow_Task> orderByComparator);

	/**
	* Returns an ordered range of all the custom_ workflow_ tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ tasks
	* @param end the upper bound of the range of custom_ workflow_ tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of custom_ workflow_ tasks
	*/
	public java.util.List<Custom_Workflow_Task> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_Workflow_Task> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the custom_ workflow_ tasks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of custom_ workflow_ tasks.
	*
	* @return the number of custom_ workflow_ tasks
	*/
	public int countAll();
}