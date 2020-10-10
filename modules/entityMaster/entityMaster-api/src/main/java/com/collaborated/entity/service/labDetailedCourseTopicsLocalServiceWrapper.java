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
 * Provides a wrapper for {@link labDetailedCourseTopicsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseTopicsLocalService
 * @generated
 */
@ProviderType
public class labDetailedCourseTopicsLocalServiceWrapper
	implements labDetailedCourseTopicsLocalService,
		ServiceWrapper<labDetailedCourseTopicsLocalService> {
	public labDetailedCourseTopicsLocalServiceWrapper(
		labDetailedCourseTopicsLocalService labDetailedCourseTopicsLocalService) {
		_labDetailedCourseTopicsLocalService = labDetailedCourseTopicsLocalService;
	}

	/**
	* Adds the lab detailed course topics to the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseTopics the lab detailed course topics
	* @return the lab detailed course topics that was added
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseTopics addlabDetailedCourseTopics(
		com.collaborated.entity.model.labDetailedCourseTopics labDetailedCourseTopics) {
		return _labDetailedCourseTopicsLocalService.addlabDetailedCourseTopics(labDetailedCourseTopics);
	}

	/**
	* Creates a new lab detailed course topics with the primary key. Does not add the lab detailed course topics to the database.
	*
	* @param PK_courseTopicsId the primary key for the new lab detailed course topics
	* @return the new lab detailed course topics
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseTopics createlabDetailedCourseTopics(
		long PK_courseTopicsId) {
		return _labDetailedCourseTopicsLocalService.createlabDetailedCourseTopics(PK_courseTopicsId);
	}

	/**
	* Deletes the lab detailed course topics from the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseTopics the lab detailed course topics
	* @return the lab detailed course topics that was removed
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseTopics deletelabDetailedCourseTopics(
		com.collaborated.entity.model.labDetailedCourseTopics labDetailedCourseTopics) {
		return _labDetailedCourseTopicsLocalService.deletelabDetailedCourseTopics(labDetailedCourseTopics);
	}

	/**
	* Deletes the lab detailed course topics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseTopicsId the primary key of the lab detailed course topics
	* @return the lab detailed course topics that was removed
	* @throws PortalException if a lab detailed course topics with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseTopics deletelabDetailedCourseTopics(
		long PK_courseTopicsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseTopicsLocalService.deletelabDetailedCourseTopics(PK_courseTopicsId);
	}

	@Override
	public com.collaborated.entity.model.labDetailedCourseTopics fetchlabDetailedCourseTopics(
		long PK_courseTopicsId) {
		return _labDetailedCourseTopicsLocalService.fetchlabDetailedCourseTopics(PK_courseTopicsId);
	}

	/**
	* Returns the lab detailed course topics with the primary key.
	*
	* @param PK_courseTopicsId the primary key of the lab detailed course topics
	* @return the lab detailed course topics
	* @throws PortalException if a lab detailed course topics with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseTopics getlabDetailedCourseTopics(
		long PK_courseTopicsId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseTopicsLocalService.getlabDetailedCourseTopics(PK_courseTopicsId);
	}

	/**
	* Updates the lab detailed course topics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseTopics the lab detailed course topics
	* @return the lab detailed course topics that was updated
	*/
	@Override
	public com.collaborated.entity.model.labDetailedCourseTopics updatelabDetailedCourseTopics(
		com.collaborated.entity.model.labDetailedCourseTopics labDetailedCourseTopics) {
		return _labDetailedCourseTopicsLocalService.updatelabDetailedCourseTopics(labDetailedCourseTopics);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _labDetailedCourseTopicsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _labDetailedCourseTopicsLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _labDetailedCourseTopicsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseTopicsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedCourseTopicsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lab detailed course topicses.
	*
	* @return the number of lab detailed course topicses
	*/
	@Override
	public int getlabDetailedCourseTopicsesCount() {
		return _labDetailedCourseTopicsLocalService.getlabDetailedCourseTopicsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _labDetailedCourseTopicsLocalService.getOSGiServiceIdentifier();
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
		return _labDetailedCourseTopicsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseTopicsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedCourseTopicsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseTopicsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedCourseTopicsLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the lab detailed course topicses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseTopicsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course topicses
	* @param end the upper bound of the range of lab detailed course topicses (not inclusive)
	* @return the range of lab detailed course topicses
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.labDetailedCourseTopics> getlabDetailedCourseTopicses(
		int start, int end) {
		return _labDetailedCourseTopicsLocalService.getlabDetailedCourseTopicses(start,
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
		return _labDetailedCourseTopicsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _labDetailedCourseTopicsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public labDetailedCourseTopicsLocalService getWrappedService() {
		return _labDetailedCourseTopicsLocalService;
	}

	@Override
	public void setWrappedService(
		labDetailedCourseTopicsLocalService labDetailedCourseTopicsLocalService) {
		_labDetailedCourseTopicsLocalService = labDetailedCourseTopicsLocalService;
	}

	private labDetailedCourseTopicsLocalService _labDetailedCourseTopicsLocalService;
}