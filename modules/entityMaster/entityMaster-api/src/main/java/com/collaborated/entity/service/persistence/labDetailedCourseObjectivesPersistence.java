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

import com.collaborated.entity.exception.NoSuchlabDetailedCourseObjectivesException;
import com.collaborated.entity.model.labDetailedCourseObjectives;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab detailed course objectives service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labDetailedCourseObjectivesPersistenceImpl
 * @see labDetailedCourseObjectivesUtil
 * @generated
 */
@ProviderType
public interface labDetailedCourseObjectivesPersistence extends BasePersistence<labDetailedCourseObjectives> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labDetailedCourseObjectivesUtil} to access the lab detailed course objectives persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lab detailed course objectives in the entity cache if it is enabled.
	*
	* @param labDetailedCourseObjectives the lab detailed course objectives
	*/
	public void cacheResult(
		labDetailedCourseObjectives labDetailedCourseObjectives);

	/**
	* Caches the lab detailed course objectiveses in the entity cache if it is enabled.
	*
	* @param labDetailedCourseObjectiveses the lab detailed course objectiveses
	*/
	public void cacheResult(
		java.util.List<labDetailedCourseObjectives> labDetailedCourseObjectiveses);

	/**
	* Creates a new lab detailed course objectives with the primary key. Does not add the lab detailed course objectives to the database.
	*
	* @param PK_courseObjectivesId the primary key for the new lab detailed course objectives
	* @return the new lab detailed course objectives
	*/
	public labDetailedCourseObjectives create(long PK_courseObjectivesId);

	/**
	* Removes the lab detailed course objectives with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseObjectivesId the primary key of the lab detailed course objectives
	* @return the lab detailed course objectives that was removed
	* @throws NoSuchlabDetailedCourseObjectivesException if a lab detailed course objectives with the primary key could not be found
	*/
	public labDetailedCourseObjectives remove(long PK_courseObjectivesId)
		throws NoSuchlabDetailedCourseObjectivesException;

	public labDetailedCourseObjectives updateImpl(
		labDetailedCourseObjectives labDetailedCourseObjectives);

	/**
	* Returns the lab detailed course objectives with the primary key or throws a {@link NoSuchlabDetailedCourseObjectivesException} if it could not be found.
	*
	* @param PK_courseObjectivesId the primary key of the lab detailed course objectives
	* @return the lab detailed course objectives
	* @throws NoSuchlabDetailedCourseObjectivesException if a lab detailed course objectives with the primary key could not be found
	*/
	public labDetailedCourseObjectives findByPrimaryKey(
		long PK_courseObjectivesId)
		throws NoSuchlabDetailedCourseObjectivesException;

	/**
	* Returns the lab detailed course objectives with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_courseObjectivesId the primary key of the lab detailed course objectives
	* @return the lab detailed course objectives, or <code>null</code> if a lab detailed course objectives with the primary key could not be found
	*/
	public labDetailedCourseObjectives fetchByPrimaryKey(
		long PK_courseObjectivesId);

	@Override
	public java.util.Map<java.io.Serializable, labDetailedCourseObjectives> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab detailed course objectiveses.
	*
	* @return the lab detailed course objectiveses
	*/
	public java.util.List<labDetailedCourseObjectives> findAll();

	/**
	* Returns a range of all the lab detailed course objectiveses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseObjectivesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course objectiveses
	* @param end the upper bound of the range of lab detailed course objectiveses (not inclusive)
	* @return the range of lab detailed course objectiveses
	*/
	public java.util.List<labDetailedCourseObjectives> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the lab detailed course objectiveses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseObjectivesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course objectiveses
	* @param end the upper bound of the range of lab detailed course objectiveses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailed course objectiveses
	*/
	public java.util.List<labDetailedCourseObjectives> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseObjectives> orderByComparator);

	/**
	* Returns an ordered range of all the lab detailed course objectiveses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseObjectivesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course objectiveses
	* @param end the upper bound of the range of lab detailed course objectiveses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailed course objectiveses
	*/
	public java.util.List<labDetailedCourseObjectives> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseObjectives> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab detailed course objectiveses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab detailed course objectiveses.
	*
	* @return the number of lab detailed course objectiveses
	*/
	public int countAll();
}