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

import com.collaborated.entity.model.Custom_WorkflowLog;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the custom_ workflow log service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.Custom_WorkflowLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowLogPersistence
 * @see com.collaborated.entity.service.persistence.impl.Custom_WorkflowLogPersistenceImpl
 * @generated
 */
@ProviderType
public class Custom_WorkflowLogUtil {
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
	public static void clearCache(Custom_WorkflowLog custom_WorkflowLog) {
		getPersistence().clearCache(custom_WorkflowLog);
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
	public static List<Custom_WorkflowLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Custom_WorkflowLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Custom_WorkflowLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Custom_WorkflowLog> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Custom_WorkflowLog update(
		Custom_WorkflowLog custom_WorkflowLog) {
		return getPersistence().update(custom_WorkflowLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Custom_WorkflowLog update(
		Custom_WorkflowLog custom_WorkflowLog, ServiceContext serviceContext) {
		return getPersistence().update(custom_WorkflowLog, serviceContext);
	}

	/**
	* Caches the custom_ workflow log in the entity cache if it is enabled.
	*
	* @param custom_WorkflowLog the custom_ workflow log
	*/
	public static void cacheResult(Custom_WorkflowLog custom_WorkflowLog) {
		getPersistence().cacheResult(custom_WorkflowLog);
	}

	/**
	* Caches the custom_ workflow logs in the entity cache if it is enabled.
	*
	* @param custom_WorkflowLogs the custom_ workflow logs
	*/
	public static void cacheResult(List<Custom_WorkflowLog> custom_WorkflowLogs) {
		getPersistence().cacheResult(custom_WorkflowLogs);
	}

	/**
	* Creates a new custom_ workflow log with the primary key. Does not add the custom_ workflow log to the database.
	*
	* @param logId the primary key for the new custom_ workflow log
	* @return the new custom_ workflow log
	*/
	public static Custom_WorkflowLog create(long logId) {
		return getPersistence().create(logId);
	}

	/**
	* Removes the custom_ workflow log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logId the primary key of the custom_ workflow log
	* @return the custom_ workflow log that was removed
	* @throws NoSuchCustom_WorkflowLogException if a custom_ workflow log with the primary key could not be found
	*/
	public static Custom_WorkflowLog remove(long logId)
		throws com.collaborated.entity.exception.NoSuchCustom_WorkflowLogException {
		return getPersistence().remove(logId);
	}

	public static Custom_WorkflowLog updateImpl(
		Custom_WorkflowLog custom_WorkflowLog) {
		return getPersistence().updateImpl(custom_WorkflowLog);
	}

	/**
	* Returns the custom_ workflow log with the primary key or throws a {@link NoSuchCustom_WorkflowLogException} if it could not be found.
	*
	* @param logId the primary key of the custom_ workflow log
	* @return the custom_ workflow log
	* @throws NoSuchCustom_WorkflowLogException if a custom_ workflow log with the primary key could not be found
	*/
	public static Custom_WorkflowLog findByPrimaryKey(long logId)
		throws com.collaborated.entity.exception.NoSuchCustom_WorkflowLogException {
		return getPersistence().findByPrimaryKey(logId);
	}

	/**
	* Returns the custom_ workflow log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param logId the primary key of the custom_ workflow log
	* @return the custom_ workflow log, or <code>null</code> if a custom_ workflow log with the primary key could not be found
	*/
	public static Custom_WorkflowLog fetchByPrimaryKey(long logId) {
		return getPersistence().fetchByPrimaryKey(logId);
	}

	public static java.util.Map<java.io.Serializable, Custom_WorkflowLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the custom_ workflow logs.
	*
	* @return the custom_ workflow logs
	*/
	public static List<Custom_WorkflowLog> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Custom_WorkflowLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Custom_WorkflowLog> findAll(int start, int end,
		OrderByComparator<Custom_WorkflowLog> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Custom_WorkflowLog> findAll(int start, int end,
		OrderByComparator<Custom_WorkflowLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the custom_ workflow logs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of custom_ workflow logs.
	*
	* @return the number of custom_ workflow logs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Custom_WorkflowLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Custom_WorkflowLogPersistence, Custom_WorkflowLogPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Custom_WorkflowLogPersistence.class);
}