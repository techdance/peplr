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

import com.collaborated.entity.model.Custom_Workflow_Completed;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the custom_ workflow_ completed service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.Custom_Workflow_CompletedPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_CompletedPersistence
 * @see com.collaborated.entity.service.persistence.impl.Custom_Workflow_CompletedPersistenceImpl
 * @generated
 */
@ProviderType
public class Custom_Workflow_CompletedUtil {
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
	public static void clearCache(
		Custom_Workflow_Completed custom_Workflow_Completed) {
		getPersistence().clearCache(custom_Workflow_Completed);
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
	public static List<Custom_Workflow_Completed> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Custom_Workflow_Completed> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Custom_Workflow_Completed> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Custom_Workflow_Completed> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Custom_Workflow_Completed update(
		Custom_Workflow_Completed custom_Workflow_Completed) {
		return getPersistence().update(custom_Workflow_Completed);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Custom_Workflow_Completed update(
		Custom_Workflow_Completed custom_Workflow_Completed,
		ServiceContext serviceContext) {
		return getPersistence().update(custom_Workflow_Completed, serviceContext);
	}

	/**
	* Caches the custom_ workflow_ completed in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Completed the custom_ workflow_ completed
	*/
	public static void cacheResult(
		Custom_Workflow_Completed custom_Workflow_Completed) {
		getPersistence().cacheResult(custom_Workflow_Completed);
	}

	/**
	* Caches the custom_ workflow_ completeds in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Completeds the custom_ workflow_ completeds
	*/
	public static void cacheResult(
		List<Custom_Workflow_Completed> custom_Workflow_Completeds) {
		getPersistence().cacheResult(custom_Workflow_Completeds);
	}

	/**
	* Creates a new custom_ workflow_ completed with the primary key. Does not add the custom_ workflow_ completed to the database.
	*
	* @param cId the primary key for the new custom_ workflow_ completed
	* @return the new custom_ workflow_ completed
	*/
	public static Custom_Workflow_Completed create(long cId) {
		return getPersistence().create(cId);
	}

	/**
	* Removes the custom_ workflow_ completed with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cId the primary key of the custom_ workflow_ completed
	* @return the custom_ workflow_ completed that was removed
	* @throws NoSuchCustom_Workflow_CompletedException if a custom_ workflow_ completed with the primary key could not be found
	*/
	public static Custom_Workflow_Completed remove(long cId)
		throws com.collaborated.entity.exception.NoSuchCustom_Workflow_CompletedException {
		return getPersistence().remove(cId);
	}

	public static Custom_Workflow_Completed updateImpl(
		Custom_Workflow_Completed custom_Workflow_Completed) {
		return getPersistence().updateImpl(custom_Workflow_Completed);
	}

	/**
	* Returns the custom_ workflow_ completed with the primary key or throws a {@link NoSuchCustom_Workflow_CompletedException} if it could not be found.
	*
	* @param cId the primary key of the custom_ workflow_ completed
	* @return the custom_ workflow_ completed
	* @throws NoSuchCustom_Workflow_CompletedException if a custom_ workflow_ completed with the primary key could not be found
	*/
	public static Custom_Workflow_Completed findByPrimaryKey(long cId)
		throws com.collaborated.entity.exception.NoSuchCustom_Workflow_CompletedException {
		return getPersistence().findByPrimaryKey(cId);
	}

	/**
	* Returns the custom_ workflow_ completed with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cId the primary key of the custom_ workflow_ completed
	* @return the custom_ workflow_ completed, or <code>null</code> if a custom_ workflow_ completed with the primary key could not be found
	*/
	public static Custom_Workflow_Completed fetchByPrimaryKey(long cId) {
		return getPersistence().fetchByPrimaryKey(cId);
	}

	public static java.util.Map<java.io.Serializable, Custom_Workflow_Completed> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the custom_ workflow_ completeds.
	*
	* @return the custom_ workflow_ completeds
	*/
	public static List<Custom_Workflow_Completed> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the custom_ workflow_ completeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ completeds
	* @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	* @return the range of custom_ workflow_ completeds
	*/
	public static List<Custom_Workflow_Completed> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the custom_ workflow_ completeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ completeds
	* @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of custom_ workflow_ completeds
	*/
	public static List<Custom_Workflow_Completed> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Completed> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the custom_ workflow_ completeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ completeds
	* @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of custom_ workflow_ completeds
	*/
	public static List<Custom_Workflow_Completed> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Completed> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the custom_ workflow_ completeds from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of custom_ workflow_ completeds.
	*
	* @return the number of custom_ workflow_ completeds
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Custom_Workflow_CompletedPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Custom_Workflow_CompletedPersistence, Custom_Workflow_CompletedPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Custom_Workflow_CompletedPersistence.class);
}