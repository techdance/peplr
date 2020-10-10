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

import com.collaborated.entity.model.Custom_Workflow;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the custom_ workflow service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.Custom_WorkflowPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowPersistence
 * @see com.collaborated.entity.service.persistence.impl.Custom_WorkflowPersistenceImpl
 * @generated
 */
@ProviderType
public class Custom_WorkflowUtil {
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
	public static void clearCache(Custom_Workflow custom_Workflow) {
		getPersistence().clearCache(custom_Workflow);
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
	public static List<Custom_Workflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Custom_Workflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Custom_Workflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Custom_Workflow> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Custom_Workflow update(Custom_Workflow custom_Workflow) {
		return getPersistence().update(custom_Workflow);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Custom_Workflow update(Custom_Workflow custom_Workflow,
		ServiceContext serviceContext) {
		return getPersistence().update(custom_Workflow, serviceContext);
	}

	/**
	* Caches the custom_ workflow in the entity cache if it is enabled.
	*
	* @param custom_Workflow the custom_ workflow
	*/
	public static void cacheResult(Custom_Workflow custom_Workflow) {
		getPersistence().cacheResult(custom_Workflow);
	}

	/**
	* Caches the custom_ workflows in the entity cache if it is enabled.
	*
	* @param custom_Workflows the custom_ workflows
	*/
	public static void cacheResult(List<Custom_Workflow> custom_Workflows) {
		getPersistence().cacheResult(custom_Workflows);
	}

	/**
	* Creates a new custom_ workflow with the primary key. Does not add the custom_ workflow to the database.
	*
	* @param workFlowId the primary key for the new custom_ workflow
	* @return the new custom_ workflow
	*/
	public static Custom_Workflow create(long workFlowId) {
		return getPersistence().create(workFlowId);
	}

	/**
	* Removes the custom_ workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workFlowId the primary key of the custom_ workflow
	* @return the custom_ workflow that was removed
	* @throws NoSuchCustom_WorkflowException if a custom_ workflow with the primary key could not be found
	*/
	public static Custom_Workflow remove(long workFlowId)
		throws com.collaborated.entity.exception.NoSuchCustom_WorkflowException {
		return getPersistence().remove(workFlowId);
	}

	public static Custom_Workflow updateImpl(Custom_Workflow custom_Workflow) {
		return getPersistence().updateImpl(custom_Workflow);
	}

	/**
	* Returns the custom_ workflow with the primary key or throws a {@link NoSuchCustom_WorkflowException} if it could not be found.
	*
	* @param workFlowId the primary key of the custom_ workflow
	* @return the custom_ workflow
	* @throws NoSuchCustom_WorkflowException if a custom_ workflow with the primary key could not be found
	*/
	public static Custom_Workflow findByPrimaryKey(long workFlowId)
		throws com.collaborated.entity.exception.NoSuchCustom_WorkflowException {
		return getPersistence().findByPrimaryKey(workFlowId);
	}

	/**
	* Returns the custom_ workflow with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workFlowId the primary key of the custom_ workflow
	* @return the custom_ workflow, or <code>null</code> if a custom_ workflow with the primary key could not be found
	*/
	public static Custom_Workflow fetchByPrimaryKey(long workFlowId) {
		return getPersistence().fetchByPrimaryKey(workFlowId);
	}

	public static java.util.Map<java.io.Serializable, Custom_Workflow> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the custom_ workflows.
	*
	* @return the custom_ workflows
	*/
	public static List<Custom_Workflow> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the custom_ workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflows
	* @param end the upper bound of the range of custom_ workflows (not inclusive)
	* @return the range of custom_ workflows
	*/
	public static List<Custom_Workflow> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the custom_ workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflows
	* @param end the upper bound of the range of custom_ workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of custom_ workflows
	*/
	public static List<Custom_Workflow> findAll(int start, int end,
		OrderByComparator<Custom_Workflow> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the custom_ workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflows
	* @param end the upper bound of the range of custom_ workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of custom_ workflows
	*/
	public static List<Custom_Workflow> findAll(int start, int end,
		OrderByComparator<Custom_Workflow> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the custom_ workflows from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of custom_ workflows.
	*
	* @return the number of custom_ workflows
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Custom_WorkflowPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Custom_WorkflowPersistence, Custom_WorkflowPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Custom_WorkflowPersistence.class);
}