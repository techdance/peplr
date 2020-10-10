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
 * Provides the local service utility for labDetailedLearningEnvironments. This utility wraps
 * {@link com.collaborated.entity.service.impl.labDetailedLearningEnvironmentsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedLearningEnvironmentsLocalService
 * @see com.collaborated.entity.service.base.labDetailedLearningEnvironmentsLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.labDetailedLearningEnvironmentsLocalServiceImpl
 * @generated
 */
@ProviderType
public class labDetailedLearningEnvironmentsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.labDetailedLearningEnvironmentsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lab detailed learning environments to the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedLearningEnvironments the lab detailed learning environments
	* @return the lab detailed learning environments that was added
	*/
	public static com.collaborated.entity.model.labDetailedLearningEnvironments addlabDetailedLearningEnvironments(
		com.collaborated.entity.model.labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		return getService()
				   .addlabDetailedLearningEnvironments(labDetailedLearningEnvironments);
	}

	/**
	* Creates a new lab detailed learning environments with the primary key. Does not add the lab detailed learning environments to the database.
	*
	* @param PK_learningEnvironmentId the primary key for the new lab detailed learning environments
	* @return the new lab detailed learning environments
	*/
	public static com.collaborated.entity.model.labDetailedLearningEnvironments createlabDetailedLearningEnvironments(
		long PK_learningEnvironmentId) {
		return getService()
				   .createlabDetailedLearningEnvironments(PK_learningEnvironmentId);
	}

	/**
	* Deletes the lab detailed learning environments from the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedLearningEnvironments the lab detailed learning environments
	* @return the lab detailed learning environments that was removed
	*/
	public static com.collaborated.entity.model.labDetailedLearningEnvironments deletelabDetailedLearningEnvironments(
		com.collaborated.entity.model.labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		return getService()
				   .deletelabDetailedLearningEnvironments(labDetailedLearningEnvironments);
	}

	/**
	* Deletes the lab detailed learning environments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_learningEnvironmentId the primary key of the lab detailed learning environments
	* @return the lab detailed learning environments that was removed
	* @throws PortalException if a lab detailed learning environments with the primary key could not be found
	*/
	public static com.collaborated.entity.model.labDetailedLearningEnvironments deletelabDetailedLearningEnvironments(
		long PK_learningEnvironmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deletelabDetailedLearningEnvironments(PK_learningEnvironmentId);
	}

	public static com.collaborated.entity.model.labDetailedLearningEnvironments fetchlabDetailedLearningEnvironments(
		long PK_learningEnvironmentId) {
		return getService()
				   .fetchlabDetailedLearningEnvironments(PK_learningEnvironmentId);
	}

	/**
	* Returns the lab detailed learning environments with the primary key.
	*
	* @param PK_learningEnvironmentId the primary key of the lab detailed learning environments
	* @return the lab detailed learning environments
	* @throws PortalException if a lab detailed learning environments with the primary key could not be found
	*/
	public static com.collaborated.entity.model.labDetailedLearningEnvironments getlabDetailedLearningEnvironments(
		long PK_learningEnvironmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getlabDetailedLearningEnvironments(PK_learningEnvironmentId);
	}

	/**
	* Updates the lab detailed learning environments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labDetailedLearningEnvironments the lab detailed learning environments
	* @return the lab detailed learning environments that was updated
	*/
	public static com.collaborated.entity.model.labDetailedLearningEnvironments updatelabDetailedLearningEnvironments(
		com.collaborated.entity.model.labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		return getService()
				   .updatelabDetailedLearningEnvironments(labDetailedLearningEnvironments);
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
	* Returns the number of lab detailed learning environmentses.
	*
	* @return the number of lab detailed learning environmentses
	*/
	public static int getlabDetailedLearningEnvironmentsesCount() {
		return getService().getlabDetailedLearningEnvironmentsesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedLearningEnvironmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedLearningEnvironmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the lab detailed learning environmentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedLearningEnvironmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed learning environmentses
	* @param end the upper bound of the range of lab detailed learning environmentses (not inclusive)
	* @return the range of lab detailed learning environmentses
	*/
	public static java.util.List<com.collaborated.entity.model.labDetailedLearningEnvironments> getlabDetailedLearningEnvironmentses(
		int start, int end) {
		return getService().getlabDetailedLearningEnvironmentses(start, end);
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

	public static labDetailedLearningEnvironmentsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<labDetailedLearningEnvironmentsLocalService, labDetailedLearningEnvironmentsLocalService> _serviceTracker =
		ServiceTrackerFactory.open(labDetailedLearningEnvironmentsLocalService.class);
}