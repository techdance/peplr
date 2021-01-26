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

import com.collaborated.entity.model.discussionMessageNotification;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the discussion message notification service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.discussionMessageNotificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see discussionMessageNotificationPersistence
 * @see com.collaborated.entity.service.persistence.impl.discussionMessageNotificationPersistenceImpl
 * @generated
 */
@ProviderType
public class discussionMessageNotificationUtil {
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
		discussionMessageNotification discussionMessageNotification) {
		getPersistence().clearCache(discussionMessageNotification);
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
	public static List<discussionMessageNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<discussionMessageNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<discussionMessageNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<discussionMessageNotification> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static discussionMessageNotification update(
		discussionMessageNotification discussionMessageNotification) {
		return getPersistence().update(discussionMessageNotification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static discussionMessageNotification update(
		discussionMessageNotification discussionMessageNotification,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(discussionMessageNotification, serviceContext);
	}

	/**
	* Caches the discussion message notification in the entity cache if it is enabled.
	*
	* @param discussionMessageNotification the discussion message notification
	*/
	public static void cacheResult(
		discussionMessageNotification discussionMessageNotification) {
		getPersistence().cacheResult(discussionMessageNotification);
	}

	/**
	* Caches the discussion message notifications in the entity cache if it is enabled.
	*
	* @param discussionMessageNotifications the discussion message notifications
	*/
	public static void cacheResult(
		List<discussionMessageNotification> discussionMessageNotifications) {
		getPersistence().cacheResult(discussionMessageNotifications);
	}

	/**
	* Creates a new discussion message notification with the primary key. Does not add the discussion message notification to the database.
	*
	* @param PK_discussionNotificationId the primary key for the new discussion message notification
	* @return the new discussion message notification
	*/
	public static discussionMessageNotification create(
		long PK_discussionNotificationId) {
		return getPersistence().create(PK_discussionNotificationId);
	}

	/**
	* Removes the discussion message notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification that was removed
	* @throws NoSuchdiscussionMessageNotificationException if a discussion message notification with the primary key could not be found
	*/
	public static discussionMessageNotification remove(
		long PK_discussionNotificationId)
		throws com.collaborated.entity.exception.NoSuchdiscussionMessageNotificationException {
		return getPersistence().remove(PK_discussionNotificationId);
	}

	public static discussionMessageNotification updateImpl(
		discussionMessageNotification discussionMessageNotification) {
		return getPersistence().updateImpl(discussionMessageNotification);
	}

	/**
	* Returns the discussion message notification with the primary key or throws a {@link NoSuchdiscussionMessageNotificationException} if it could not be found.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification
	* @throws NoSuchdiscussionMessageNotificationException if a discussion message notification with the primary key could not be found
	*/
	public static discussionMessageNotification findByPrimaryKey(
		long PK_discussionNotificationId)
		throws com.collaborated.entity.exception.NoSuchdiscussionMessageNotificationException {
		return getPersistence().findByPrimaryKey(PK_discussionNotificationId);
	}

	/**
	* Returns the discussion message notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification, or <code>null</code> if a discussion message notification with the primary key could not be found
	*/
	public static discussionMessageNotification fetchByPrimaryKey(
		long PK_discussionNotificationId) {
		return getPersistence().fetchByPrimaryKey(PK_discussionNotificationId);
	}

	public static java.util.Map<java.io.Serializable, discussionMessageNotification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the discussion message notifications.
	*
	* @return the discussion message notifications
	*/
	public static List<discussionMessageNotification> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the discussion message notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link discussionMessageNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of discussion message notifications
	* @param end the upper bound of the range of discussion message notifications (not inclusive)
	* @return the range of discussion message notifications
	*/
	public static List<discussionMessageNotification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the discussion message notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link discussionMessageNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of discussion message notifications
	* @param end the upper bound of the range of discussion message notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of discussion message notifications
	*/
	public static List<discussionMessageNotification> findAll(int start,
		int end,
		OrderByComparator<discussionMessageNotification> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the discussion message notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link discussionMessageNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of discussion message notifications
	* @param end the upper bound of the range of discussion message notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of discussion message notifications
	*/
	public static List<discussionMessageNotification> findAll(int start,
		int end,
		OrderByComparator<discussionMessageNotification> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the discussion message notifications from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of discussion message notifications.
	*
	* @return the number of discussion message notifications
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static discussionMessageNotificationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<discussionMessageNotificationPersistence, discussionMessageNotificationPersistence> _serviceTracker =
		ServiceTrackerFactory.open(discussionMessageNotificationPersistence.class);
}