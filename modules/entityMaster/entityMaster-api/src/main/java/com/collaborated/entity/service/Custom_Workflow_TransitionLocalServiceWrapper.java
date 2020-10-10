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
 * Provides a wrapper for {@link Custom_Workflow_TransitionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_TransitionLocalService
 * @generated
 */
@ProviderType
public class Custom_Workflow_TransitionLocalServiceWrapper
	implements Custom_Workflow_TransitionLocalService,
		ServiceWrapper<Custom_Workflow_TransitionLocalService> {
	public Custom_Workflow_TransitionLocalServiceWrapper(
		Custom_Workflow_TransitionLocalService custom_Workflow_TransitionLocalService) {
		_custom_Workflow_TransitionLocalService = custom_Workflow_TransitionLocalService;
	}

	/**
	* Adds the custom_ workflow_ transition to the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow_Transition the custom_ workflow_ transition
	* @return the custom_ workflow_ transition that was added
	*/
	@Override
	public com.collaborated.entity.model.Custom_Workflow_Transition addCustom_Workflow_Transition(
		com.collaborated.entity.model.Custom_Workflow_Transition custom_Workflow_Transition) {
		return _custom_Workflow_TransitionLocalService.addCustom_Workflow_Transition(custom_Workflow_Transition);
	}

	/**
	* Creates a new custom_ workflow_ transition with the primary key. Does not add the custom_ workflow_ transition to the database.
	*
	* @param transitionId the primary key for the new custom_ workflow_ transition
	* @return the new custom_ workflow_ transition
	*/
	@Override
	public com.collaborated.entity.model.Custom_Workflow_Transition createCustom_Workflow_Transition(
		long transitionId) {
		return _custom_Workflow_TransitionLocalService.createCustom_Workflow_Transition(transitionId);
	}

	/**
	* Deletes the custom_ workflow_ transition from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow_Transition the custom_ workflow_ transition
	* @return the custom_ workflow_ transition that was removed
	*/
	@Override
	public com.collaborated.entity.model.Custom_Workflow_Transition deleteCustom_Workflow_Transition(
		com.collaborated.entity.model.Custom_Workflow_Transition custom_Workflow_Transition) {
		return _custom_Workflow_TransitionLocalService.deleteCustom_Workflow_Transition(custom_Workflow_Transition);
	}

	/**
	* Deletes the custom_ workflow_ transition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transitionId the primary key of the custom_ workflow_ transition
	* @return the custom_ workflow_ transition that was removed
	* @throws PortalException if a custom_ workflow_ transition with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.Custom_Workflow_Transition deleteCustom_Workflow_Transition(
		long transitionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_Workflow_TransitionLocalService.deleteCustom_Workflow_Transition(transitionId);
	}

	@Override
	public com.collaborated.entity.model.Custom_Workflow_Transition fetchCustom_Workflow_Transition(
		long transitionId) {
		return _custom_Workflow_TransitionLocalService.fetchCustom_Workflow_Transition(transitionId);
	}

	/**
	* Returns the custom_ workflow_ transition with the primary key.
	*
	* @param transitionId the primary key of the custom_ workflow_ transition
	* @return the custom_ workflow_ transition
	* @throws PortalException if a custom_ workflow_ transition with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.Custom_Workflow_Transition getCustom_Workflow_Transition(
		long transitionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_Workflow_TransitionLocalService.getCustom_Workflow_Transition(transitionId);
	}

	/**
	* Updates the custom_ workflow_ transition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param custom_Workflow_Transition the custom_ workflow_ transition
	* @return the custom_ workflow_ transition that was updated
	*/
	@Override
	public com.collaborated.entity.model.Custom_Workflow_Transition updateCustom_Workflow_Transition(
		com.collaborated.entity.model.Custom_Workflow_Transition custom_Workflow_Transition) {
		return _custom_Workflow_TransitionLocalService.updateCustom_Workflow_Transition(custom_Workflow_Transition);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _custom_Workflow_TransitionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _custom_Workflow_TransitionLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _custom_Workflow_TransitionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_Workflow_TransitionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _custom_Workflow_TransitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of custom_ workflow_ transitions.
	*
	* @return the number of custom_ workflow_ transitions
	*/
	@Override
	public int getCustom_Workflow_TransitionsCount() {
		return _custom_Workflow_TransitionLocalService.getCustom_Workflow_TransitionsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _custom_Workflow_TransitionLocalService.getOSGiServiceIdentifier();
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
		return _custom_Workflow_TransitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_Workflow_TransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _custom_Workflow_TransitionLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_Workflow_TransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _custom_Workflow_TransitionLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the custom_ workflow_ transitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.Custom_Workflow_TransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ transitions
	* @param end the upper bound of the range of custom_ workflow_ transitions (not inclusive)
	* @return the range of custom_ workflow_ transitions
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.Custom_Workflow_Transition> getCustom_Workflow_Transitions(
		int start, int end) {
		return _custom_Workflow_TransitionLocalService.getCustom_Workflow_Transitions(start,
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
		return _custom_Workflow_TransitionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _custom_Workflow_TransitionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public Custom_Workflow_TransitionLocalService getWrappedService() {
		return _custom_Workflow_TransitionLocalService;
	}

	@Override
	public void setWrappedService(
		Custom_Workflow_TransitionLocalService custom_Workflow_TransitionLocalService) {
		_custom_Workflow_TransitionLocalService = custom_Workflow_TransitionLocalService;
	}

	private Custom_Workflow_TransitionLocalService _custom_Workflow_TransitionLocalService;
}