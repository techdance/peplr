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
 * Provides a wrapper for {@link labScreenProjectPartnersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectPartnersLocalService
 * @generated
 */
@ProviderType
public class labScreenProjectPartnersLocalServiceWrapper
	implements labScreenProjectPartnersLocalService,
		ServiceWrapper<labScreenProjectPartnersLocalService> {
	public labScreenProjectPartnersLocalServiceWrapper(
		labScreenProjectPartnersLocalService labScreenProjectPartnersLocalService) {
		_labScreenProjectPartnersLocalService = labScreenProjectPartnersLocalService;
	}

	/**
	* Adds the lab screen project partners to the database. Also notifies the appropriate model listeners.
	*
	* @param labScreenProjectPartners the lab screen project partners
	* @return the lab screen project partners that was added
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectPartners addlabScreenProjectPartners(
		com.collaborated.entity.model.labScreenProjectPartners labScreenProjectPartners) {
		return _labScreenProjectPartnersLocalService.addlabScreenProjectPartners(labScreenProjectPartners);
	}

	/**
	* Creates a new lab screen project partners with the primary key. Does not add the lab screen project partners to the database.
	*
	* @param PK_projectPartnerId the primary key for the new lab screen project partners
	* @return the new lab screen project partners
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectPartners createlabScreenProjectPartners(
		long PK_projectPartnerId) {
		return _labScreenProjectPartnersLocalService.createlabScreenProjectPartners(PK_projectPartnerId);
	}

	/**
	* Deletes the lab screen project partners from the database. Also notifies the appropriate model listeners.
	*
	* @param labScreenProjectPartners the lab screen project partners
	* @return the lab screen project partners that was removed
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectPartners deletelabScreenProjectPartners(
		com.collaborated.entity.model.labScreenProjectPartners labScreenProjectPartners) {
		return _labScreenProjectPartnersLocalService.deletelabScreenProjectPartners(labScreenProjectPartners);
	}

	/**
	* Deletes the lab screen project partners with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectPartnerId the primary key of the lab screen project partners
	* @return the lab screen project partners that was removed
	* @throws PortalException if a lab screen project partners with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectPartners deletelabScreenProjectPartners(
		long PK_projectPartnerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenProjectPartnersLocalService.deletelabScreenProjectPartners(PK_projectPartnerId);
	}

	@Override
	public com.collaborated.entity.model.labScreenProjectPartners fetchlabScreenProjectPartners(
		long PK_projectPartnerId) {
		return _labScreenProjectPartnersLocalService.fetchlabScreenProjectPartners(PK_projectPartnerId);
	}

	/**
	* Returns the lab screen project partners with the primary key.
	*
	* @param PK_projectPartnerId the primary key of the lab screen project partners
	* @return the lab screen project partners
	* @throws PortalException if a lab screen project partners with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectPartners getlabScreenProjectPartners(
		long PK_projectPartnerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenProjectPartnersLocalService.getlabScreenProjectPartners(PK_projectPartnerId);
	}

	/**
	* Updates the lab screen project partners in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labScreenProjectPartners the lab screen project partners
	* @return the lab screen project partners that was updated
	*/
	@Override
	public com.collaborated.entity.model.labScreenProjectPartners updatelabScreenProjectPartners(
		com.collaborated.entity.model.labScreenProjectPartners labScreenProjectPartners) {
		return _labScreenProjectPartnersLocalService.updatelabScreenProjectPartners(labScreenProjectPartners);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _labScreenProjectPartnersLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _labScreenProjectPartnersLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _labScreenProjectPartnersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenProjectPartnersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labScreenProjectPartnersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of lab screen project partnerses.
	*
	* @return the number of lab screen project partnerses
	*/
	@Override
	public int getlabScreenProjectPartnersesCount() {
		return _labScreenProjectPartnersLocalService.getlabScreenProjectPartnersesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _labScreenProjectPartnersLocalService.getOSGiServiceIdentifier();
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
		return _labScreenProjectPartnersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labScreenProjectPartnersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labScreenProjectPartnersLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labScreenProjectPartnersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _labScreenProjectPartnersLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the lab screen project partnerses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.labScreenProjectPartnersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project partnerses
	* @param end the upper bound of the range of lab screen project partnerses (not inclusive)
	* @return the range of lab screen project partnerses
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.labScreenProjectPartners> getlabScreenProjectPartnerses(
		int start, int end) {
		return _labScreenProjectPartnersLocalService.getlabScreenProjectPartnerses(start,
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
		return _labScreenProjectPartnersLocalService.dynamicQueryCount(dynamicQuery);
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
		return _labScreenProjectPartnersLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public labScreenProjectPartnersLocalService getWrappedService() {
		return _labScreenProjectPartnersLocalService;
	}

	@Override
	public void setWrappedService(
		labScreenProjectPartnersLocalService labScreenProjectPartnersLocalService) {
		_labScreenProjectPartnersLocalService = labScreenProjectPartnersLocalService;
	}

	private labScreenProjectPartnersLocalService _labScreenProjectPartnersLocalService;
}