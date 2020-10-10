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

package com.collaborated.entity.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.collaborated.entity.exception.NoSuchprojectDiscussionException;
import com.collaborated.entity.model.projectDiscussion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project discussion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.projectDiscussionPersistenceImpl
 * @see projectDiscussionUtil
 * @generated
 */
@ProviderType
public interface projectDiscussionPersistence extends BasePersistence<projectDiscussion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link projectDiscussionUtil} to access the project discussion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project discussion in the entity cache if it is enabled.
	*
	* @param projectDiscussion the project discussion
	*/
	public void cacheResult(projectDiscussion projectDiscussion);

	/**
	* Caches the project discussions in the entity cache if it is enabled.
	*
	* @param projectDiscussions the project discussions
	*/
	public void cacheResult(
		java.util.List<projectDiscussion> projectDiscussions);

	/**
	* Creates a new project discussion with the primary key. Does not add the project discussion to the database.
	*
	* @param PK_projectDiscussionId the primary key for the new project discussion
	* @return the new project discussion
	*/
	public projectDiscussion create(long PK_projectDiscussionId);

	/**
	* Removes the project discussion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectDiscussionId the primary key of the project discussion
	* @return the project discussion that was removed
	* @throws NoSuchprojectDiscussionException if a project discussion with the primary key could not be found
	*/
	public projectDiscussion remove(long PK_projectDiscussionId)
		throws NoSuchprojectDiscussionException;

	public projectDiscussion updateImpl(projectDiscussion projectDiscussion);

	/**
	* Returns the project discussion with the primary key or throws a {@link NoSuchprojectDiscussionException} if it could not be found.
	*
	* @param PK_projectDiscussionId the primary key of the project discussion
	* @return the project discussion
	* @throws NoSuchprojectDiscussionException if a project discussion with the primary key could not be found
	*/
	public projectDiscussion findByPrimaryKey(long PK_projectDiscussionId)
		throws NoSuchprojectDiscussionException;

	/**
	* Returns the project discussion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_projectDiscussionId the primary key of the project discussion
	* @return the project discussion, or <code>null</code> if a project discussion with the primary key could not be found
	*/
	public projectDiscussion fetchByPrimaryKey(long PK_projectDiscussionId);

	@Override
	public java.util.Map<java.io.Serializable, projectDiscussion> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project discussions.
	*
	* @return the project discussions
	*/
	public java.util.List<projectDiscussion> findAll();

	/**
	* Returns a range of all the project discussions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project discussions
	* @param end the upper bound of the range of project discussions (not inclusive)
	* @return the range of project discussions
	*/
	public java.util.List<projectDiscussion> findAll(int start, int end);

	/**
	* Returns an ordered range of all the project discussions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project discussions
	* @param end the upper bound of the range of project discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project discussions
	*/
	public java.util.List<projectDiscussion> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projectDiscussion> orderByComparator);

	/**
	* Returns an ordered range of all the project discussions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project discussions
	* @param end the upper bound of the range of project discussions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project discussions
	*/
	public java.util.List<projectDiscussion> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projectDiscussion> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project discussions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project discussions.
	*
	* @return the number of project discussions
	*/
	public int countAll();
}