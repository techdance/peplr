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

import com.collaborated.entity.exception.NoSuchlabDetailedCourseTopicsException;
import com.collaborated.entity.model.labDetailedCourseTopics;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab detailed course topics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labDetailedCourseTopicsPersistenceImpl
 * @see labDetailedCourseTopicsUtil
 * @generated
 */
@ProviderType
public interface labDetailedCourseTopicsPersistence extends BasePersistence<labDetailedCourseTopics> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labDetailedCourseTopicsUtil} to access the lab detailed course topics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lab detailed course topics in the entity cache if it is enabled.
	*
	* @param labDetailedCourseTopics the lab detailed course topics
	*/
	public void cacheResult(labDetailedCourseTopics labDetailedCourseTopics);

	/**
	* Caches the lab detailed course topicses in the entity cache if it is enabled.
	*
	* @param labDetailedCourseTopicses the lab detailed course topicses
	*/
	public void cacheResult(
		java.util.List<labDetailedCourseTopics> labDetailedCourseTopicses);

	/**
	* Creates a new lab detailed course topics with the primary key. Does not add the lab detailed course topics to the database.
	*
	* @param PK_courseTopicsId the primary key for the new lab detailed course topics
	* @return the new lab detailed course topics
	*/
	public labDetailedCourseTopics create(long PK_courseTopicsId);

	/**
	* Removes the lab detailed course topics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseTopicsId the primary key of the lab detailed course topics
	* @return the lab detailed course topics that was removed
	* @throws NoSuchlabDetailedCourseTopicsException if a lab detailed course topics with the primary key could not be found
	*/
	public labDetailedCourseTopics remove(long PK_courseTopicsId)
		throws NoSuchlabDetailedCourseTopicsException;

	public labDetailedCourseTopics updateImpl(
		labDetailedCourseTopics labDetailedCourseTopics);

	/**
	* Returns the lab detailed course topics with the primary key or throws a {@link NoSuchlabDetailedCourseTopicsException} if it could not be found.
	*
	* @param PK_courseTopicsId the primary key of the lab detailed course topics
	* @return the lab detailed course topics
	* @throws NoSuchlabDetailedCourseTopicsException if a lab detailed course topics with the primary key could not be found
	*/
	public labDetailedCourseTopics findByPrimaryKey(long PK_courseTopicsId)
		throws NoSuchlabDetailedCourseTopicsException;

	/**
	* Returns the lab detailed course topics with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_courseTopicsId the primary key of the lab detailed course topics
	* @return the lab detailed course topics, or <code>null</code> if a lab detailed course topics with the primary key could not be found
	*/
	public labDetailedCourseTopics fetchByPrimaryKey(long PK_courseTopicsId);

	@Override
	public java.util.Map<java.io.Serializable, labDetailedCourseTopics> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab detailed course topicses.
	*
	* @return the lab detailed course topicses
	*/
	public java.util.List<labDetailedCourseTopics> findAll();

	/**
	* Returns a range of all the lab detailed course topicses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseTopicsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course topicses
	* @param end the upper bound of the range of lab detailed course topicses (not inclusive)
	* @return the range of lab detailed course topicses
	*/
	public java.util.List<labDetailedCourseTopics> findAll(int start, int end);

	/**
	* Returns an ordered range of all the lab detailed course topicses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseTopicsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course topicses
	* @param end the upper bound of the range of lab detailed course topicses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailed course topicses
	*/
	public java.util.List<labDetailedCourseTopics> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseTopics> orderByComparator);

	/**
	* Returns an ordered range of all the lab detailed course topicses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseTopicsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course topicses
	* @param end the upper bound of the range of lab detailed course topicses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailed course topicses
	*/
	public java.util.List<labDetailedCourseTopics> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseTopics> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab detailed course topicses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab detailed course topicses.
	*
	* @return the number of lab detailed course topicses
	*/
	public int countAll();
}