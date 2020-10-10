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

import com.collaborated.entity.model.projectDiscussion;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project discussion service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.projectDiscussionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectDiscussionPersistence
 * @see com.collaborated.entity.service.persistence.impl.projectDiscussionPersistenceImpl
 * @generated
 */
@ProviderType
public class projectDiscussionUtil {
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
	public static void clearCache(projectDiscussion projectDiscussion) {
		getPersistence().clearCache(projectDiscussion);
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
	public static List<projectDiscussion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<projectDiscussion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<projectDiscussion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<projectDiscussion> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static projectDiscussion update(projectDiscussion projectDiscussion) {
		return getPersistence().update(projectDiscussion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static projectDiscussion update(
		projectDiscussion projectDiscussion, ServiceContext serviceContext) {
		return getPersistence().update(projectDiscussion, serviceContext);
	}

	/**
	* Caches the project discussion in the entity cache if it is enabled.
	*
	* @param projectDiscussion the project discussion
	*/
	public static void cacheResult(projectDiscussion projectDiscussion) {
		getPersistence().cacheResult(projectDiscussion);
	}

	/**
	* Caches the project discussions in the entity cache if it is enabled.
	*
	* @param projectDiscussions the project discussions
	*/
	public static void cacheResult(List<projectDiscussion> projectDiscussions) {
		getPersistence().cacheResult(projectDiscussions);
	}

	/**
	* Creates a new project discussion with the primary key. Does not add the project discussion to the database.
	*
	* @param PK_projectDiscussionId the primary key for the new project discussion
	* @return the new project discussion
	*/
	public static projectDiscussion create(long PK_projectDiscussionId) {
		return getPersistence().create(PK_projectDiscussionId);
	}

	/**
	* Removes the project discussion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectDiscussionId the primary key of the project discussion
	* @return the project discussion that was removed
	* @throws NoSuchprojectDiscussionException if a project discussion with the primary key could not be found
	*/
	public static projectDiscussion remove(long PK_projectDiscussionId)
		throws com.collaborated.entity.exception.NoSuchprojectDiscussionException {
		return getPersistence().remove(PK_projectDiscussionId);
	}

	public static projectDiscussion updateImpl(
		projectDiscussion projectDiscussion) {
		return getPersistence().updateImpl(projectDiscussion);
	}

	/**
	* Returns the project discussion with the primary key or throws a {@link NoSuchprojectDiscussionException} if it could not be found.
	*
	* @param PK_projectDiscussionId the primary key of the project discussion
	* @return the project discussion
	* @throws NoSuchprojectDiscussionException if a project discussion with the primary key could not be found
	*/
	public static projectDiscussion findByPrimaryKey(
		long PK_projectDiscussionId)
		throws com.collaborated.entity.exception.NoSuchprojectDiscussionException {
		return getPersistence().findByPrimaryKey(PK_projectDiscussionId);
	}

	/**
	* Returns the project discussion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_projectDiscussionId the primary key of the project discussion
	* @return the project discussion, or <code>null</code> if a project discussion with the primary key could not be found
	*/
	public static projectDiscussion fetchByPrimaryKey(
		long PK_projectDiscussionId) {
		return getPersistence().fetchByPrimaryKey(PK_projectDiscussionId);
	}

	public static java.util.Map<java.io.Serializable, projectDiscussion> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project discussions.
	*
	* @return the project discussions
	*/
	public static List<projectDiscussion> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project discussions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project discussions
	* @param end the upper bound of the range of project discussions (not inclusive)
	* @return the range of project discussions
	*/
	public static List<projectDiscussion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project discussions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project discussions
	* @param end the upper bound of the range of project discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project discussions
	*/
	public static List<projectDiscussion> findAll(int start, int end,
		OrderByComparator<projectDiscussion> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project discussions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project discussions
	* @param end the upper bound of the range of project discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project discussions
	*/
	public static List<projectDiscussion> findAll(int start, int end,
		OrderByComparator<projectDiscussion> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project discussions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project discussions.
	*
	* @return the number of project discussions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static projectDiscussionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<projectDiscussionPersistence, projectDiscussionPersistence> _serviceTracker =
		ServiceTrackerFactory.open(projectDiscussionPersistence.class);
}