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
 * Provides a wrapper for {@link projectDiscussionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see projectDiscussionLocalService
 * @generated
 */
@ProviderType
public class projectDiscussionLocalServiceWrapper
	implements projectDiscussionLocalService,
		ServiceWrapper<projectDiscussionLocalService> {
	public projectDiscussionLocalServiceWrapper(
		projectDiscussionLocalService projectDiscussionLocalService) {
		_projectDiscussionLocalService = projectDiscussionLocalService;
	}

	/**
	* Adds the project discussion to the database. Also notifies the appropriate model listeners.
	*
	* @param projectDiscussion the project discussion
	* @return the project discussion that was added
	*/
	@Override
	public com.collaborated.entity.model.projectDiscussion addprojectDiscussion(
		com.collaborated.entity.model.projectDiscussion projectDiscussion) {
		return _projectDiscussionLocalService.addprojectDiscussion(projectDiscussion);
	}

	/**
	* Creates a new project discussion with the primary key. Does not add the project discussion to the database.
	*
	* @param PK_projectDiscussionId the primary key for the new project discussion
	* @return the new project discussion
	*/
	@Override
	public com.collaborated.entity.model.projectDiscussion createprojectDiscussion(
		long PK_projectDiscussionId) {
		return _projectDiscussionLocalService.createprojectDiscussion(PK_projectDiscussionId);
	}

	/**
	* Deletes the project discussion from the database. Also notifies the appropriate model listeners.
	*
	* @param projectDiscussion the project discussion
	* @return the project discussion that was removed
	*/
	@Override
	public com.collaborated.entity.model.projectDiscussion deleteprojectDiscussion(
		com.collaborated.entity.model.projectDiscussion projectDiscussion) {
		return _projectDiscussionLocalService.deleteprojectDiscussion(projectDiscussion);
	}

	/**
	* Deletes the project discussion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectDiscussionId the primary key of the project discussion
	* @return the project discussion that was removed
	* @throws PortalException if a project discussion with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.projectDiscussion deleteprojectDiscussion(
		long PK_projectDiscussionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectDiscussionLocalService.deleteprojectDiscussion(PK_projectDiscussionId);
	}

	@Override
	public com.collaborated.entity.model.projectDiscussion fetchprojectDiscussion(
		long PK_projectDiscussionId) {
		return _projectDiscussionLocalService.fetchprojectDiscussion(PK_projectDiscussionId);
	}

	/**
	* Returns the project discussion with the primary key.
	*
	* @param PK_projectDiscussionId the primary key of the project discussion
	* @return the project discussion
	* @throws PortalException if a project discussion with the primary key could not be found
	*/
	@Override
	public com.collaborated.entity.model.projectDiscussion getprojectDiscussion(
		long PK_projectDiscussionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectDiscussionLocalService.getprojectDiscussion(PK_projectDiscussionId);
	}

	/**
	* Updates the project discussion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectDiscussion the project discussion
	* @return the project discussion that was updated
	*/
	@Override
	public com.collaborated.entity.model.projectDiscussion updateprojectDiscussion(
		com.collaborated.entity.model.projectDiscussion projectDiscussion) {
		return _projectDiscussionLocalService.updateprojectDiscussion(projectDiscussion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectDiscussionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectDiscussionLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectDiscussionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectDiscussionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectDiscussionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of project discussions.
	*
	* @return the number of project discussions
	*/
	@Override
	public int getprojectDiscussionsCount() {
		return _projectDiscussionLocalService.getprojectDiscussionsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _projectDiscussionLocalService.getOSGiServiceIdentifier();
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
		return _projectDiscussionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectDiscussionLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectDiscussionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the project discussions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project discussions
	* @param end the upper bound of the range of project discussions (not inclusive)
	* @return the range of project discussions
	*/
	@Override
	public java.util.List<com.collaborated.entity.model.projectDiscussion> getprojectDiscussions(
		int start, int end) {
		return _projectDiscussionLocalService.getprojectDiscussions(start, end);
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
		return _projectDiscussionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectDiscussionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public projectDiscussionLocalService getWrappedService() {
		return _projectDiscussionLocalService;
	}

	@Override
	public void setWrappedService(
		projectDiscussionLocalService projectDiscussionLocalService) {
		_projectDiscussionLocalService = projectDiscussionLocalService;
	}

	private projectDiscussionLocalService _projectDiscussionLocalService;
}