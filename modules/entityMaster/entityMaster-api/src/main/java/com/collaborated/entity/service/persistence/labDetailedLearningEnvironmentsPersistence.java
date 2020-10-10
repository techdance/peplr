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

import com.collaborated.entity.exception.NoSuchlabDetailedLearningEnvironmentsException;
import com.collaborated.entity.model.labDetailedLearningEnvironments;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab detailed learning environments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labDetailedLearningEnvironmentsPersistenceImpl
 * @see labDetailedLearningEnvironmentsUtil
 * @generated
 */
@ProviderType
public interface labDetailedLearningEnvironmentsPersistence
	extends BasePersistence<labDetailedLearningEnvironments> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labDetailedLearningEnvironmentsUtil} to access the lab detailed learning environments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lab detailed learning environments in the entity cache if it is enabled.
	*
	* @param labDetailedLearningEnvironments the lab detailed learning environments
	*/
	public void cacheResult(
		labDetailedLearningEnvironments labDetailedLearningEnvironments);

	/**
	* Caches the lab detailed learning environmentses in the entity cache if it is enabled.
	*
	* @param labDetailedLearningEnvironmentses the lab detailed learning environmentses
	*/
	public void cacheResult(
		java.util.List<labDetailedLearningEnvironments> labDetailedLearningEnvironmentses);

	/**
	* Creates a new lab detailed learning environments with the primary key. Does not add the lab detailed learning environments to the database.
	*
	* @param PK_learningEnvironmentId the primary key for the new lab detailed learning environments
	* @return the new lab detailed learning environments
	*/
	public labDetailedLearningEnvironments create(long PK_learningEnvironmentId);

	/**
	* Removes the lab detailed learning environments with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_learningEnvironmentId the primary key of the lab detailed learning environments
	* @return the lab detailed learning environments that was removed
	* @throws NoSuchlabDetailedLearningEnvironmentsException if a lab detailed learning environments with the primary key could not be found
	*/
	public labDetailedLearningEnvironments remove(long PK_learningEnvironmentId)
		throws NoSuchlabDetailedLearningEnvironmentsException;

	public labDetailedLearningEnvironments updateImpl(
		labDetailedLearningEnvironments labDetailedLearningEnvironments);

	/**
	* Returns the lab detailed learning environments with the primary key or throws a {@link NoSuchlabDetailedLearningEnvironmentsException} if it could not be found.
	*
	* @param PK_learningEnvironmentId the primary key of the lab detailed learning environments
	* @return the lab detailed learning environments
	* @throws NoSuchlabDetailedLearningEnvironmentsException if a lab detailed learning environments with the primary key could not be found
	*/
	public labDetailedLearningEnvironments findByPrimaryKey(
		long PK_learningEnvironmentId)
		throws NoSuchlabDetailedLearningEnvironmentsException;

	/**
	* Returns the lab detailed learning environments with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_learningEnvironmentId the primary key of the lab detailed learning environments
	* @return the lab detailed learning environments, or <code>null</code> if a lab detailed learning environments with the primary key could not be found
	*/
	public labDetailedLearningEnvironments fetchByPrimaryKey(
		long PK_learningEnvironmentId);

	@Override
	public java.util.Map<java.io.Serializable, labDetailedLearningEnvironments> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab detailed learning environmentses.
	*
	* @return the lab detailed learning environmentses
	*/
	public java.util.List<labDetailedLearningEnvironments> findAll();

	/**
	* Returns a range of all the lab detailed learning environmentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedLearningEnvironmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed learning environmentses
	* @param end the upper bound of the range of lab detailed learning environmentses (not inclusive)
	* @return the range of lab detailed learning environmentses
	*/
	public java.util.List<labDetailedLearningEnvironments> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the lab detailed learning environmentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedLearningEnvironmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed learning environmentses
	* @param end the upper bound of the range of lab detailed learning environmentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailed learning environmentses
	*/
	public java.util.List<labDetailedLearningEnvironments> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedLearningEnvironments> orderByComparator);

	/**
	* Returns an ordered range of all the lab detailed learning environmentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedLearningEnvironmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed learning environmentses
	* @param end the upper bound of the range of lab detailed learning environmentses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailed learning environmentses
	*/
	public java.util.List<labDetailedLearningEnvironments> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedLearningEnvironments> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab detailed learning environmentses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab detailed learning environmentses.
	*
	* @return the number of lab detailed learning environmentses
	*/
	public int countAll();
}