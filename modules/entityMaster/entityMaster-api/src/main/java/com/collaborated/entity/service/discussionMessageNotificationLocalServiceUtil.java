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

package com.collaborated.entity.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for discussionMessageNotification. This utility wraps
 * {@link com.collaborated.entity.service.impl.discussionMessageNotificationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see discussionMessageNotificationLocalService
 * @see com.collaborated.entity.service.base.discussionMessageNotificationLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.discussionMessageNotificationLocalServiceImpl
 * @generated
 */
@ProviderType
public class discussionMessageNotificationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.discussionMessageNotificationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the discussion message notification to the database. Also notifies the appropriate model listeners.
	*
	* @param discussionMessageNotification the discussion message notification
	* @return the discussion message notification that was added
	*/
	public static com.collaborated.entity.model.discussionMessageNotification adddiscussionMessageNotification(
		com.collaborated.entity.model.discussionMessageNotification discussionMessageNotification) {
		return getService()
				   .adddiscussionMessageNotification(discussionMessageNotification);
	}

	/**
	* Creates a new discussion message notification with the primary key. Does not add the discussion message notification to the database.
	*
	* @param PK_discussionNotificationId the primary key for the new discussion message notification
	* @return the new discussion message notification
	*/
	public static com.collaborated.entity.model.discussionMessageNotification creatediscussionMessageNotification(
		long PK_discussionNotificationId) {
		return getService()
				   .creatediscussionMessageNotification(PK_discussionNotificationId);
	}

	/**
	* Deletes the discussion message notification from the database. Also notifies the appropriate model listeners.
	*
	* @param discussionMessageNotification the discussion message notification
	* @return the discussion message notification that was removed
	*/
	public static com.collaborated.entity.model.discussionMessageNotification deletediscussionMessageNotification(
		com.collaborated.entity.model.discussionMessageNotification discussionMessageNotification) {
		return getService()
				   .deletediscussionMessageNotification(discussionMessageNotification);
	}

	/**
	* Deletes the discussion message notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification that was removed
	* @throws PortalException if a discussion message notification with the primary key could not be found
	*/
	public static com.collaborated.entity.model.discussionMessageNotification deletediscussionMessageNotification(
		long PK_discussionNotificationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deletediscussionMessageNotification(PK_discussionNotificationId);
	}

	public static com.collaborated.entity.model.discussionMessageNotification fetchdiscussionMessageNotification(
		long PK_discussionNotificationId) {
		return getService()
				   .fetchdiscussionMessageNotification(PK_discussionNotificationId);
	}

	/**
	* Returns the discussion message notification with the primary key.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification
	* @throws PortalException if a discussion message notification with the primary key could not be found
	*/
	public static com.collaborated.entity.model.discussionMessageNotification getdiscussionMessageNotification(
		long PK_discussionNotificationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getdiscussionMessageNotification(PK_discussionNotificationId);
	}

	/**
	* Updates the discussion message notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param discussionMessageNotification the discussion message notification
	* @return the discussion message notification that was updated
	*/
	public static com.collaborated.entity.model.discussionMessageNotification updatediscussionMessageNotification(
		com.collaborated.entity.model.discussionMessageNotification discussionMessageNotification) {
		return getService()
				   .updatediscussionMessageNotification(discussionMessageNotification);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of discussion message notifications.
	*
	* @return the number of discussion message notifications
	*/
	public static int getdiscussionMessageNotificationsCount() {
		return getService().getdiscussionMessageNotificationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.discussionMessageNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.discussionMessageNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the discussion message notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.discussionMessageNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of discussion message notifications
	* @param end the upper bound of the range of discussion message notifications (not inclusive)
	* @return the range of discussion message notifications
	*/
	public static java.util.List<com.collaborated.entity.model.discussionMessageNotification> getdiscussionMessageNotifications(
		int start, int end) {
		return getService().getdiscussionMessageNotifications(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static discussionMessageNotificationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<discussionMessageNotificationLocalService, discussionMessageNotificationLocalService> _serviceTracker =
		ServiceTrackerFactory.open(discussionMessageNotificationLocalService.class);
}