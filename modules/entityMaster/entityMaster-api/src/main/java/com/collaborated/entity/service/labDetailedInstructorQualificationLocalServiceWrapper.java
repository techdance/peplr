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
 * Provides a wrapper for {@link labDetailedInstructorQualificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedInstructorQualificationLocalService
 * @generated
 */
@ProviderType
public class labDetailedInstructorQualificationLocalServiceWrapper
	implements labDetailedInstructorQualificationLocalService,
		ServiceWrapper<labDetailedInstructorQualificationLocalService> {
	public labDetailedInstructorQualificationLocalServiceWrapper(
		labDetailedInstructorQualificationLocalService labDetailedInstructorQualificationLocalService) {
		_labDetailedInstructorQualificationLocalService = labDetailedInstructorQualificationLocalService;
	}

	/**
	* Adds the lab detailed instructor qualification to the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedInstructorQualification the lab detailed instructor qualification
	* @return the lab detailed instructor qualification that was added
	*/
	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification addlabDetailedInstructorQualification(
		com.collaborated.entity.model.labDetailedInstructorQualification labDetailedInstructorQualification) {
		return _labDetailedInstructorQualificationLocalService.addlabDetailedInstructorQualification(labDetailedInstructorQualification);
	}

	/**
	* Creates a new lab detailed instructor qualification with the primary key. Does not add the lab detailed instructor qualification to the database.
	*
	* @param PK_courseInstructorQualificationId the primary key for the new lab detailed instructor qualification
	* @return the new lab detailed instructor qualification
	*/
	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification createlabDetailedInstructorQualification(
		long PK_courseInstructorQualificationId) {
		return _labDetailedInstructorQualificationLocalService.createlabDetailedInstructorQualification(PK_courseInstructorQualificationId);
	}

	/**
	* Deletes the lab detailed instructor qualification from the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedInstructorQualification the lab detailed instructor qualification
	* @return the lab detailed instructor qualification that was removed
	*/
	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification deletelabDetailedInstructorQualification(
		com.collaborated.entity.model.labDetailedInstructorQualification labDetailedInstructorQualification) {
		return _labDetailedInstructorQualificationLocalService.deletelabDetailedInstructorQualification(labDetailedInstructorQualification);
	}

	/**
	* Deletes the lab detailed instructor qualification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	* @return the lab detailed instructor qualification that was removed
	* @throws PortalException if a lab detailed instructor qualification with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification deletelabDetailedInstructorQualification(
		long PK_courseInstructorQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedInstructorQualificationLocalService.deletelabDetailedInstructorQualification(PK_courseInstructorQualificationId);
	}

	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification fetchlabDetailedInstructorQualification(
		long PK_courseInstructorQualificationId) {
		return _labDetailedInstructorQualificationLocalService.fetchlabDetailedInstructorQualification(PK_courseInstructorQualificationId);
	}

	/**
	* Returns the lab detailed instructor qualification with the primary key.
	*
	* @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	* @return the lab detailed instructor qualification
	* @throws PortalException if a lab detailed instructor qualification with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification getlabDetailedInstructorQualification(
		long PK_courseInstructorQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedInstructorQualificationLocalService.getlabDetailedInstructorQualification(PK_courseInstructorQualificationId);
	}

	/**
	* Updates the lab detailed instructor qualification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labDetailedInstructorQualification the lab detailed instructor qualification
	* @return the lab detailed instructor qualification that was updated
	*/
	@Override
	public com.collaborated.entity.model.labDetailedInstructorQualification updatelabDetailedInstructorQualification(
		com.collaborated.entity.model.labDetailedInstructorQualification labDetailedInstructorQualification) {
		return _labDetailedInstructorQualificationLocalService.updatelabDetailedInstructorQualification(labDetailedInstructorQualification);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _labDetailedInstructorQualificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _labDetailedInstructorQualificationLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _labDetailedInstructorQualificationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedInstructorQualificationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedInstructorQualificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lab detailed instructor qualifications.
	*
	* @return the number of lab detailed instructor qualifications
	*/
	@Override
	public int getlabDetailedInstructorQualificationsCount() {
		return _labDetailedInstructorQualificationLocalService.getlabDetailedInstructorQualificationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _labDetailedInstructorQualificationLocalService.getOSGiServiceIdentifier();
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
		return _labDetailedInstructorQualificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedInstructorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedInstructorQualificationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedInstructorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedInstructorQualificationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the lab detailed instructor qualifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedInstructorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed instructor qualifications
	* @param end the upper bound of the range of lab detailed instructor qualifications (not inclusive)
	* @return the range of lab detailed instructor qualifications
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.labDetailedInstructorQualification> getlabDetailedInstructorQualifications(
		int start, int end) {
		return _labDetailedInstructorQualificationLocalService.getlabDetailedInstructorQualifications(start,
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
		return _labDetailedInstructorQualificationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _labDetailedInstructorQualificationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public labDetailedInstructorQualificationLocalService getWrappedService() {
		return _labDetailedInstructorQualificationLocalService;
	}

	@Override
	public void setWrappedService(
		labDetailedInstructorQualificationLocalService labDetailedInstructorQualificationLocalService) {
		_labDetailedInstructorQualificationLocalService = labDetailedInstructorQualificationLocalService;
	}

	private labDetailedInstructorQualificationLocalService _labDetailedInstructorQualificationLocalService;
}