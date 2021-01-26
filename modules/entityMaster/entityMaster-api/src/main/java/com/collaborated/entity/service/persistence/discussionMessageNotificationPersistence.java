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

import com.collaborated.entity.exception.NoSuchdiscussionMessageNotificationException;
import com.collaborated.entity.model.discussionMessageNotification;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the discussion message notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.discussionMessageNotificationPersistenceImpl
 * @see discussionMessageNotificationUtil
 * @generated
 */
@ProviderType
public interface discussionMessageNotificationPersistence
	extends BasePersistence<discussionMessageNotification> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link discussionMessageNotificationUtil} to access the discussion message notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the discussion message notification in the entity cache if it is enabled.
	*
	* @param discussionMessageNotification the discussion message notification
	*/
	public void cacheResult(
		discussionMessageNotification discussionMessageNotification);

	/**
	* Caches the discussion message notifications in the entity cache if it is enabled.
	*
	* @param discussionMessageNotifications the discussion message notifications
	*/
	public void cacheResult(
		java.util.List<discussionMessageNotification> discussionMessageNotifications);

	/**
	* Creates a new discussion message notification with the primary key. Does not add the discussion message notification to the database.
	*
	* @param PK_discussionNotificationId the primary key for the new discussion message notification
	* @return the new discussion message notification
	*/
	public discussionMessageNotification create(
		long PK_discussionNotificationId);

	/**
	* Removes the discussion message notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification that was removed
	* @throws NoSuchdiscussionMessageNotificationException if a discussion message notification with the primary key could not be found
	*/
	public discussionMessageNotification remove(
		long PK_discussionNotificationId)
		throws NoSuchdiscussionMessageNotificationException;

	public discussionMessageNotification updateImpl(
		discussionMessageNotification discussionMessageNotification);

	/**
	* Returns the discussion message notification with the primary key or throws a {@link NoSuchdiscussionMessageNotificationException} if it could not be found.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification
	* @throws NoSuchdiscussionMessageNotificationException if a discussion message notification with the primary key could not be found
	*/
	public discussionMessageNotification findByPrimaryKey(
		long PK_discussionNotificationId)
		throws NoSuchdiscussionMessageNotificationException;

	/**
	* Returns the discussion message notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification, or <code>null</code> if a discussion message notification with the primary key could not be found
	*/
	public discussionMessageNotification fetchByPrimaryKey(
		long PK_discussionNotificationId);

	@Override
	public java.util.Map<java.io.Serializable, discussionMessageNotification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the discussion message notifications.
	*
	* @return the discussion message notifications
	*/
	public java.util.List<discussionMessageNotification> findAll();

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
	public java.util.List<discussionMessageNotification> findAll(int start,
		int end);

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
	public java.util.List<discussionMessageNotification> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<discussionMessageNotification> orderByComparator);

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
	public java.util.List<discussionMessageNotification> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<discussionMessageNotification> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the discussion message notifications from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of discussion message notifications.
	*
	* @return the number of discussion message notifications
	*/
	public int countAll();
}