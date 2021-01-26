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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link discussionMessageNotificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see discussionMessageNotificationLocalService
 * @generated
 */
@ProviderType
public class discussionMessageNotificationLocalServiceWrapper
	implements discussionMessageNotificationLocalService,
		ServiceWrapper<discussionMessageNotificationLocalService> {
	public discussionMessageNotificationLocalServiceWrapper(
		discussionMessageNotificationLocalService discussionMessageNotificationLocalService) {
		_discussionMessageNotificationLocalService = discussionMessageNotificationLocalService;
	}

	/**
	* Adds the discussion message notification to the database. Also notifies the appropriate model listeners.
	*
	* @param discussionMessageNotification the discussion message notification
	* @return the discussion message notification that was added
	*/
	@Override
	public com.collaborated.entity.model.discussionMessageNotification adddiscussionMessageNotification(
		com.collaborated.entity.model.discussionMessageNotification discussionMessageNotification) {
		return _discussionMessageNotificationLocalService.adddiscussionMessageNotification(discussionMessageNotification);
	}

	/**
	* Creates a new discussion message notification with the primary key. Does not add the discussion message notification to the database.
	*
	* @param PK_discussionNotificationId the primary key for the new discussion message notification
	* @return the new discussion message notification
	*/
	@Override
	public com.collaborated.entity.model.discussionMessageNotification creatediscussionMessageNotification(
		long PK_discussionNotificationId) {
		return _discussionMessageNotificationLocalService.creatediscussionMessageNotification(PK_discussionNotificationId);
	}

	/**
	* Deletes the discussion message notification from the database. Also notifies the appropriate model listeners.
	*
	* @param discussionMessageNotification the discussion message notification
	* @return the discussion message notification that was removed
	*/
	@Override
	public com.collaborated.entity.model.discussionMessageNotification deletediscussionMessageNotification(
		com.collaborated.entity.model.discussionMessageNotification discussionMessageNotification) {
		return _discussionMessageNotificationLocalService.deletediscussionMessageNotification(discussionMessageNotification);
	}

	/**
	* Deletes the discussion message notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification that was removed
	* @throws PortalException if a discussion message notification with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.discussionMessageNotification deletediscussionMessageNotification(
		long PK_discussionNotificationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _discussionMessageNotificationLocalService.deletediscussionMessageNotification(PK_discussionNotificationId);
	}

	@Override
	public com.collaborated.entity.model.discussionMessageNotification fetchdiscussionMessageNotification(
		long PK_discussionNotificationId) {
		return _discussionMessageNotificationLocalService.fetchdiscussionMessageNotification(PK_discussionNotificationId);
	}

	/**
	* Returns the discussion message notification with the primary key.
	*
	* @param PK_discussionNotificationId the primary key of the discussion message notification
	* @return the discussion message notification
	* @throws PortalException if a discussion message notification with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.discussionMessageNotification getdiscussionMessageNotification(
		long PK_discussionNotificationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _discussionMessageNotificationLocalService.getdiscussionMessageNotification(PK_discussionNotificationId);
	}

	/**
	* Updates the discussion message notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param discussionMessageNotification the discussion message notification
	* @return the discussion message notification that was updated
	*/
	@Override
	public com.collaborated.entity.model.discussionMessageNotification updatediscussionMessageNotification(
		com.collaborated.entity.model.discussionMessageNotification discussionMessageNotification) {
		return _discussionMessageNotificationLocalService.updatediscussionMessageNotification(discussionMessageNotification);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _discussionMessageNotificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _discussionMessageNotificationLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _discussionMessageNotificationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _discussionMessageNotificationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _discussionMessageNotificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of discussion message notifications.
	*
	* @return the number of discussion message notifications
	*/
	@Override
	public int getdiscussionMessageNotificationsCount() {
		return _discussionMessageNotificationLocalService.getdiscussionMessageNotificationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _discussionMessageNotificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _discussionMessageNotificationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _discussionMessageNotificationLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _discussionMessageNotificationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
	@Override
	public java.util.List<com.collaborated.entity.model.discussionMessageNotification> getdiscussionMessageNotifications(
		int start, int end) {
		return _discussionMessageNotificationLocalService.getdiscussionMessageNotifications(start,
			end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _discussionMessageNotificationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _discussionMessageNotificationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public discussionMessageNotificationLocalService getWrappedService() {
		return _discussionMessageNotificationLocalService;
	}

	@Override
	public void setWrappedService(
		discussionMessageNotificationLocalService discussionMessageNotificationLocalService) {
		_discussionMessageNotificationLocalService = discussionMessageNotificationLocalService;
	}

	private discussionMessageNotificationLocalService _discussionMessageNotificationLocalService;
}