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

import com.collaborated.entity.model.Custom_Workflow_Task;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the custom_ workflow_ task service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.Custom_Workflow_TaskPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_TaskPersistence
 * @see com.collaborated.entity.service.persistence.impl.Custom_Workflow_TaskPersistenceImpl
 * @generated
 */
@ProviderType
public class Custom_Workflow_TaskUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Custom_Workflow_Task custom_Workflow_Task) {
		getPersistence().clearCache(custom_Workflow_Task);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Custom_Workflow_Task> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Custom_Workflow_Task> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Custom_Workflow_Task> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Custom_Workflow_Task> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Custom_Workflow_Task update(
		Custom_Workflow_Task custom_Workflow_Task) {
		return getPersistence().update(custom_Workflow_Task);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Custom_Workflow_Task update(
		Custom_Workflow_Task custom_Workflow_Task, ServiceContext serviceContext) {
		return getPersistence().update(custom_Workflow_Task, serviceContext);
	}

	/**
	* Caches the custom_ workflow_ task in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Task the custom_ workflow_ task
	*/
	public static void cacheResult(Custom_Workflow_Task custom_Workflow_Task) {
		getPersistence().cacheResult(custom_Workflow_Task);
	}

	/**
	* Caches the custom_ workflow_ tasks in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Tasks the custom_ workflow_ tasks
	*/
	public static void cacheResult(
		List<Custom_Workflow_Task> custom_Workflow_Tasks) {
		getPersistence().cacheResult(custom_Workflow_Tasks);
	}

	/**
	* Creates a new custom_ workflow_ task with the primary key. Does not add the custom_ workflow_ task to the database.
	*
	* @param workFlowTaskId the primary key for the new custom_ workflow_ task
	* @return the new custom_ workflow_ task
	*/
	public static Custom_Workflow_Task create(java.lang.String workFlowTaskId) {
		return getPersistence().create(workFlowTaskId);
	}

	/**
	* Removes the custom_ workflow_ task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workFlowTaskId the primary key of the custom_ workflow_ task
	* @return the custom_ workflow_ task that was removed
	* @throws NoSuchCustom_Workflow_TaskException if a custom_ workflow_ task with the primary key could not be found
	*/
	public static Custom_Workflow_Task remove(java.lang.String workFlowTaskId)
		throws com.collaborated.entity.exception.NoSuchCustom_Workflow_TaskException {
		return getPersistence().remove(workFlowTaskId);
	}

	public static Custom_Workflow_Task updateImpl(
		Custom_Workflow_Task custom_Workflow_Task) {
		return getPersistence().updateImpl(custom_Workflow_Task);
	}

	/**
	* Returns the custom_ workflow_ task with the primary key or throws a {@link NoSuchCustom_Workflow_TaskException} if it could not be found.
	*
	* @param workFlowTaskId the primary key of the custom_ workflow_ task
	* @return the custom_ workflow_ task
	* @throws NoSuchCustom_Workflow_TaskException if a custom_ workflow_ task with the primary key could not be found
	*/
	public static Custom_Workflow_Task findByPrimaryKey(
		java.lang.String workFlowTaskId)
		throws com.collaborated.entity.exception.NoSuchCustom_Workflow_TaskException {
		return getPersistence().findByPrimaryKey(workFlowTaskId);
	}

	/**
	* Returns the custom_ workflow_ task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workFlowTaskId the primary key of the custom_ workflow_ task
	* @return the custom_ workflow_ task, or <code>null</code> if a custom_ workflow_ task with the primary key could not be found
	*/
	public static Custom_Workflow_Task fetchByPrimaryKey(
		java.lang.String workFlowTaskId) {
		return getPersistence().fetchByPrimaryKey(workFlowTaskId);
	}

	public static java.util.Map<java.io.Serializable, Custom_Workflow_Task> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the custom_ workflow_ tasks.
	*
	* @return the custom_ workflow_ tasks
	*/
	public static List<Custom_Workflow_Task> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Custom_Workflow_Task> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Custom_Workflow_Task> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Task> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Custom_Workflow_Task> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Task> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the custom_ workflow_ tasks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of custom_ workflow_ tasks.
	*
	* @return the number of custom_ workflow_ tasks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Custom_Workflow_TaskPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Custom_Workflow_TaskPersistence, Custom_Workflow_TaskPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Custom_Workflow_TaskPersistence.class);
}