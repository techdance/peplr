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
 * Provides a wrapper for {@link languagePreferencesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see languagePreferencesLocalService
 * @generated
 */
@ProviderType
public class languagePreferencesLocalServiceWrapper
	implements languagePreferencesLocalService,
		ServiceWrapper<languagePreferencesLocalService> {
	public languagePreferencesLocalServiceWrapper(
		languagePreferencesLocalService languagePreferencesLocalService) {
		_languagePreferencesLocalService = languagePreferencesLocalService;
	}

	/**
	* Adds the language preferences to the database. Also notifies the appropriate model listeners.
	*
	* @param languagePreferences the language preferences
	* @return the language preferences that was added
	*/
	@Override
	public com.collaborated.entity.model.languagePreferences addlanguagePreferences(
		com.collaborated.entity.model.languagePreferences languagePreferences) {
		return _languagePreferencesLocalService.addlanguagePreferences(languagePreferences);
	}

	/**
	* Creates a new language preferences with the primary key. Does not add the language preferences to the database.
	*
	* @param PK_languagePreferences the primary key for the new language preferences
	* @return the new language preferences
	*/
	@Override
	public com.collaborated.entity.model.languagePreferences createlanguagePreferences(
		long PK_languagePreferences) {
		return _languagePreferencesLocalService.createlanguagePreferences(PK_languagePreferences);
	}

	/**
	* Deletes the language preferences from the database. Also notifies the appropriate model listeners.
	*
	* @param languagePreferences the language preferences
	* @return the language preferences that was removed
	*/
	@Override
	public com.collaborated.entity.model.languagePreferences deletelanguagePreferences(
		com.collaborated.entity.model.languagePreferences languagePreferences) {
		return _languagePreferencesLocalService.deletelanguagePreferences(languagePreferences);
	}

	/**
	* Deletes the language preferences with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_languagePreferences the primary key of the language preferences
	* @return the language preferences that was removed
	* @throws PortalException if a language preferences with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.languagePreferences deletelanguagePreferences(
		long PK_languagePreferences)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languagePreferencesLocalService.deletelanguagePreferences(PK_languagePreferences);
	}

	@Override
	public com.collaborated.entity.model.languagePreferences fetchlanguagePreferences(
		long PK_languagePreferences) {
		return _languagePreferencesLocalService.fetchlanguagePreferences(PK_languagePreferences);
	}

	/**
	* Returns the language preferences with the primary key.
	*
	* @param PK_languagePreferences the primary key of the language preferences
	* @return the language preferences
	* @throws PortalException if a language preferences with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.languagePreferences getlanguagePreferences(
		long PK_languagePreferences)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languagePreferencesLocalService.getlanguagePreferences(PK_languagePreferences);
	}

	/**
	* Updates the language preferences in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param languagePreferences the language preferences
	* @return the language preferences that was updated
	*/
	@Override
	public com.collaborated.entity.model.languagePreferences updatelanguagePreferences(
		com.collaborated.entity.model.languagePreferences languagePreferences) {
		return _languagePreferencesLocalService.updatelanguagePreferences(languagePreferences);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _languagePreferencesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _languagePreferencesLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _languagePreferencesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languagePreferencesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languagePreferencesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of language preferenceses.
	*
	* @return the number of language preferenceses
	*/
	@Override
	public int getlanguagePreferencesesCount() {
		return _languagePreferencesLocalService.getlanguagePreferencesesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _languagePreferencesLocalService.getOSGiServiceIdentifier();
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
		return _languagePreferencesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _languagePreferencesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _languagePreferencesLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the language preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of language preferenceses
	* @param end the upper bound of the range of language preferenceses (not inclusive)
	* @return the range of language preferenceses
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.languagePreferences> getlanguagePreferenceses(
		int start, int end) {
		return _languagePreferencesLocalService.getlanguagePreferenceses(start,
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
		return _languagePreferencesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _languagePreferencesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public languagePreferencesLocalService getWrappedService() {
		return _languagePreferencesLocalService;
	}

	@Override
	public void setWrappedService(
		languagePreferencesLocalService languagePreferencesLocalService) {
		_languagePreferencesLocalService = languagePreferencesLocalService;
	}

	private languagePreferencesLocalService _languagePreferencesLocalService;
}