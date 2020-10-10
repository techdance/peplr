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
 * Provides the local service utility for labDetailedCourseObjectives. This utility wraps
 * {@link com.collaborated.entity.service.impl.labDetailedCourseObjectivesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseObjectivesLocalService
 * @see com.collaborated.entity.service.base.labDetailedCourseObjectivesLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.labDetailedCourseObjectivesLocalServiceImpl
 * @generated
 */
@ProviderType
public class labDetailedCourseObjectivesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.labDetailedCourseObjectivesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the lab detailed course objectives to the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseObjectives the lab detailed course objectives
	* @return the lab detailed course objectives that was added
	*/
	public static com.collaborated.entity.model.labDetailedCourseObjectives addlabDetailedCourseObjectives(
		com.collaborated.entity.model.labDetailedCourseObjectives labDetailedCourseObjectives) {
		return getService()
				   .addlabDetailedCourseObjectives(labDetailedCourseObjectives);
	}

	/**
	* Creates a new lab detailed course objectives with the primary key. Does not add the lab detailed course objectives to the database.
	*
	* @param PK_courseObjectivesId the primary key for the new lab detailed course objectives
	* @return the new lab detailed course objectives
	*/
	public static com.collaborated.entity.model.labDetailedCourseObjectives createlabDetailedCourseObjectives(
		long PK_courseObjectivesId) {
		return getService()
				   .createlabDetailedCourseObjectives(PK_courseObjectivesId);
	}

	/**
	* Deletes the lab detailed course objectives from the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseObjectives the lab detailed course objectives
	* @return the lab detailed course objectives that was removed
	*/
	public static com.collaborated.entity.model.labDetailedCourseObjectives deletelabDetailedCourseObjectives(
		com.collaborated.entity.model.labDetailedCourseObjectives labDetailedCourseObjectives) {
		return getService()
				   .deletelabDetailedCourseObjectives(labDetailedCourseObjectives);
	}

	/**
	* Deletes the lab detailed course objectives with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseObjectivesId the primary key of the lab detailed course objectives
	* @return the lab detailed course objectives that was removed
	* @throws PortalException if a lab detailed course objectives with the primary key could not be found
	*/
	public static com.collaborated.entity.model.labDetailedCourseObjectives deletelabDetailedCourseObjectives(
		long PK_courseObjectivesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deletelabDetailedCourseObjectives(PK_courseObjectivesId);
	}

	public static com.collaborated.entity.model.labDetailedCourseObjectives fetchlabDetailedCourseObjectives(
		long PK_courseObjectivesId) {
		return getService()
				   .fetchlabDetailedCourseObjectives(PK_courseObjectivesId);
	}

	/**
	* Returns the lab detailed course objectives with the primary key.
	*
	* @param PK_courseObjectivesId the primary key of the lab detailed course objectives
	* @return the lab detailed course objectives
	* @throws PortalException if a lab detailed course objectives with the primary key could not be found
	*/
	public static com.collaborated.entity.model.labDetailedCourseObjectives getlabDetailedCourseObjectives(
		long PK_courseObjectivesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getlabDetailedCourseObjectives(PK_courseObjectivesId);
	}

	/**
	* Updates the lab detailed course objectives in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labDetailedCourseObjectives the lab detailed course objectives
	* @return the lab detailed course objectives that was updated
	*/
	public static com.collaborated.entity.model.labDetailedCourseObjectives updatelabDetailedCourseObjectives(
		com.collaborated.entity.model.labDetailedCourseObjectives labDetailedCourseObjectives) {
		return getService()
				   .updatelabDetailedCourseObjectives(labDetailedCourseObjectives);
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
	* Returns the number of lab detailed course objectiveses.
	*
	* @return the number of lab detailed course objectiveses
	*/
	public static int getlabDetailedCourseObjectivesesCount() {
		return getService().getlabDetailedCourseObjectivesesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseObjectivesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseObjectivesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the lab detailed course objectiveses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedCourseObjectivesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course objectiveses
	* @param end the upper bound of the range of lab detailed course objectiveses (not inclusive)
	* @return the range of lab detailed course objectiveses
	*/
	public static java.util.List<com.collaborated.entity.model.labDetailedCourseObjectives> getlabDetailedCourseObjectiveses(
		int start, int end) {
		return getService().getlabDetailedCourseObjectiveses(start, end);
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

	public static labDetailedCourseObjectivesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<labDetailedCourseObjectivesLocalService, labDetailedCourseObjectivesLocalService> _serviceTracker =
		ServiceTrackerFactory.open(labDetailedCourseObjectivesLocalService.class);
}