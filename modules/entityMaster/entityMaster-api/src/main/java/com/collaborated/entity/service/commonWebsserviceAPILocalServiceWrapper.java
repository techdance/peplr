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
 * Provides a wrapper for {@link commonWebsserviceAPILocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPILocalService
 * @generated
 */
@ProviderType
public class commonWebsserviceAPILocalServiceWrapper
	implements commonWebsserviceAPILocalService,
		ServiceWrapper<commonWebsserviceAPILocalService> {
	public commonWebsserviceAPILocalServiceWrapper(
		commonWebsserviceAPILocalService commonWebsserviceAPILocalService) {
		_commonWebsserviceAPILocalService = commonWebsserviceAPILocalService;
	}

	/**
	* Adds the common websservice a p i to the database. Also notifies the appropriate model listeners.
	*
	* @param commonWebsserviceAPI the common websservice a p i
	* @return the common websservice a p i that was added
	*/
	@Override
	public com.collaborated.entity.model.commonWebsserviceAPI addcommonWebsserviceAPI(
		com.collaborated.entity.model.commonWebsserviceAPI commonWebsserviceAPI) {
		return _commonWebsserviceAPILocalService.addcommonWebsserviceAPI(commonWebsserviceAPI);
	}

	/**
	* Creates a new common websservice a p i with the primary key. Does not add the common websservice a p i to the database.
	*
	* @param commonAPIId the primary key for the new common websservice a p i
	* @return the new common websservice a p i
	*/
	@Override
	public com.collaborated.entity.model.commonWebsserviceAPI createcommonWebsserviceAPI(
		long commonAPIId) {
		return _commonWebsserviceAPILocalService.createcommonWebsserviceAPI(commonAPIId);
	}

	/**
	* Deletes the common websservice a p i from the database. Also notifies the appropriate model listeners.
	*
	* @param commonWebsserviceAPI the common websservice a p i
	* @return the common websservice a p i that was removed
	*/
	@Override
	public com.collaborated.entity.model.commonWebsserviceAPI deletecommonWebsserviceAPI(
		com.collaborated.entity.model.commonWebsserviceAPI commonWebsserviceAPI) {
		return _commonWebsserviceAPILocalService.deletecommonWebsserviceAPI(commonWebsserviceAPI);
	}

	/**
	* Deletes the common websservice a p i with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i that was removed
	* @throws PortalException if a common websservice a p i with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.commonWebsserviceAPI deletecommonWebsserviceAPI(
		long commonAPIId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commonWebsserviceAPILocalService.deletecommonWebsserviceAPI(commonAPIId);
	}

	@Override
	public com.collaborated.entity.model.commonWebsserviceAPI fetchcommonWebsserviceAPI(
		long commonAPIId) {
		return _commonWebsserviceAPILocalService.fetchcommonWebsserviceAPI(commonAPIId);
	}

	/**
	* Returns the common websservice a p i with the primary key.
	*
	* @param commonAPIId the primary key of the common websservice a p i
	* @return the common websservice a p i
	* @throws PortalException if a common websservice a p i with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.commonWebsserviceAPI getcommonWebsserviceAPI(
		long commonAPIId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commonWebsserviceAPILocalService.getcommonWebsserviceAPI(commonAPIId);
	}

	/**
	* Updates the common websservice a p i in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commonWebsserviceAPI the common websservice a p i
	* @return the common websservice a p i that was updated
	*/
	@Override
	public com.collaborated.entity.model.commonWebsserviceAPI updatecommonWebsserviceAPI(
		com.collaborated.entity.model.commonWebsserviceAPI commonWebsserviceAPI) {
		return _commonWebsserviceAPILocalService.updatecommonWebsserviceAPI(commonWebsserviceAPI);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _commonWebsserviceAPILocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commonWebsserviceAPILocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _commonWebsserviceAPILocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commonWebsserviceAPILocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commonWebsserviceAPILocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of common websservice a p is.
	*
	* @return the number of common websservice a p is
	*/
	@Override
	public int getcommonWebsserviceAPIsCount() {
		return _commonWebsserviceAPILocalService.getcommonWebsserviceAPIsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _commonWebsserviceAPILocalService.getOSGiServiceIdentifier();
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
		return _commonWebsserviceAPILocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonWebsserviceAPILocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonWebsserviceAPILocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the common websservice a p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common websservice a p is
	* @param end the upper bound of the range of common websservice a p is (not inclusive)
	* @return the range of common websservice a p is
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.commonWebsserviceAPI> getcommonWebsserviceAPIs(
		int start, int end) {
		return _commonWebsserviceAPILocalService.getcommonWebsserviceAPIs(start,
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
		return _commonWebsserviceAPILocalService.dynamicQueryCount(dynamicQuery);
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
		return _commonWebsserviceAPILocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public commonWebsserviceAPILocalService getWrappedService() {
		return _commonWebsserviceAPILocalService;
	}

	@Override
	public void setWrappedService(
		commonWebsserviceAPILocalService commonWebsserviceAPILocalService) {
		_commonWebsserviceAPILocalService = commonWebsserviceAPILocalService;
	}

	private commonWebsserviceAPILocalService _commonWebsserviceAPILocalService;
}