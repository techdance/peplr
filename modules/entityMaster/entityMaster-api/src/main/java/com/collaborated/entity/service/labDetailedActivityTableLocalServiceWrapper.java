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
 * Provides a wrapper for {@link labDetailedActivityTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedActivityTableLocalService
 * @generated
 */
@ProviderType
public class labDetailedActivityTableLocalServiceWrapper
	implements labDetailedActivityTableLocalService,
		ServiceWrapper<labDetailedActivityTableLocalService> {
	public labDetailedActivityTableLocalServiceWrapper(
		labDetailedActivityTableLocalService labDetailedActivityTableLocalService) {
		_labDetailedActivityTableLocalService = labDetailedActivityTableLocalService;
	}

	/**
	* Adds the lab detailed activity table to the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedActivityTable the lab detailed activity table
	* @return the lab detailed activity table that was added
	*/
	@Override
	public com.collaborated.entity.model.labDetailedActivityTable addlabDetailedActivityTable(
		com.collaborated.entity.model.labDetailedActivityTable labDetailedActivityTable) {
		return _labDetailedActivityTableLocalService.addlabDetailedActivityTable(labDetailedActivityTable);
	}

	/**
	* Creates a new lab detailed activity table with the primary key. Does not add the lab detailed activity table to the database.
	*
	* @param PK_activityTableId the primary key for the new lab detailed activity table
	* @return the new lab detailed activity table
	*/
	@Override
	public com.collaborated.entity.model.labDetailedActivityTable createlabDetailedActivityTable(
		long PK_activityTableId) {
		return _labDetailedActivityTableLocalService.createlabDetailedActivityTable(PK_activityTableId);
	}

	/**
	* Deletes the lab detailed activity table from the database. Also notifies the appropriate model listeners.
	*
	* @param labDetailedActivityTable the lab detailed activity table
	* @return the lab detailed activity table that was removed
	*/
	@Override
	public com.collaborated.entity.model.labDetailedActivityTable deletelabDetailedActivityTable(
		com.collaborated.entity.model.labDetailedActivityTable labDetailedActivityTable) {
		return _labDetailedActivityTableLocalService.deletelabDetailedActivityTable(labDetailedActivityTable);
	}

	/**
	* Deletes the lab detailed activity table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_activityTableId the primary key of the lab detailed activity table
	* @return the lab detailed activity table that was removed
	* @throws PortalException if a lab detailed activity table with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedActivityTable deletelabDetailedActivityTable(
		long PK_activityTableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedActivityTableLocalService.deletelabDetailedActivityTable(PK_activityTableId);
	}

	@Override
	public com.collaborated.entity.model.labDetailedActivityTable fetchlabDetailedActivityTable(
		long PK_activityTableId) {
		return _labDetailedActivityTableLocalService.fetchlabDetailedActivityTable(PK_activityTableId);
	}

	/**
	* Returns the lab detailed activity table with the primary key.
	*
	* @param PK_activityTableId the primary key of the lab detailed activity table
	* @return the lab detailed activity table
	* @throws PortalException if a lab detailed activity table with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labDetailedActivityTable getlabDetailedActivityTable(
		long PK_activityTableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedActivityTableLocalService.getlabDetailedActivityTable(PK_activityTableId);
	}

	/**
	* Updates the lab detailed activity table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labDetailedActivityTable the lab detailed activity table
	* @return the lab detailed activity table that was updated
	*/
	@Override
	public com.collaborated.entity.model.labDetailedActivityTable updatelabDetailedActivityTable(
		com.collaborated.entity.model.labDetailedActivityTable labDetailedActivityTable) {
		return _labDetailedActivityTableLocalService.updatelabDetailedActivityTable(labDetailedActivityTable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _labDetailedActivityTableLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _labDetailedActivityTableLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _labDetailedActivityTableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedActivityTableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailedActivityTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lab detailed activity tables.
	*
	* @return the number of lab detailed activity tables
	*/
	@Override
	public int getlabDetailedActivityTablesCount() {
		return _labDetailedActivityTableLocalService.getlabDetailedActivityTablesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _labDetailedActivityTableLocalService.getOSGiServiceIdentifier();
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
		return _labDetailedActivityTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedActivityTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedActivityTableLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedActivityTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labDetailedActivityTableLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the lab detailed activity tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labDetailedActivityTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed activity tables
	* @param end the upper bound of the range of lab detailed activity tables (not inclusive)
	* @return the range of lab detailed activity tables
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.labDetailedActivityTable> getlabDetailedActivityTables(
		int start, int end) {
		return _labDetailedActivityTableLocalService.getlabDetailedActivityTables(start,
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
		return _labDetailedActivityTableLocalService.dynamicQueryCount(dynamicQuery);
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
		return _labDetailedActivityTableLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public labDetailedActivityTableLocalService getWrappedService() {
		return _labDetailedActivityTableLocalService;
	}

	@Override
	public void setWrappedService(
		labDetailedActivityTableLocalService labDetailedActivityTableLocalService) {
		_labDetailedActivityTableLocalService = labDetailedActivityTableLocalService;
	}

	private labDetailedActivityTableLocalService _labDetailedActivityTableLocalService;
}