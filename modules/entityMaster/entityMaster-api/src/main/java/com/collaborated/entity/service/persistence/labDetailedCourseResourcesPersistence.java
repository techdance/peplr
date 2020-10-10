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

import com.collaborated.entity.exception.NoSuchlabDetailedCourseResourcesException;
import com.collaborated.entity.model.labDetailedCourseResources;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab detailed course resources service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labDetailedCourseResourcesPersistenceImpl
 * @see labDetailedCourseResourcesUtil
 * @generated
 */
@ProviderType
public interface labDetailedCourseResourcesPersistence extends BasePersistence<labDetailedCourseResources> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labDetailedCourseResourcesUtil} to access the lab detailed course resources persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the lab detailed course resources where PK_courseId = &#63; or throws a {@link NoSuchlabDetailedCourseResourcesException} if it could not be found.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed course resources
	* @throws NoSuchlabDetailedCourseResourcesException if a matching lab detailed course resources could not be found
	*/
	public labDetailedCourseResources findBygetCourseResourcesbyCourseId(
		long PK_courseId) throws NoSuchlabDetailedCourseResourcesException;

	/**
	* Returns the lab detailed course resources where PK_courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @return the matching lab detailed course resources, or <code>null</code> if a matching lab detailed course resources could not be found
	*/
	public labDetailedCourseResources fetchBygetCourseResourcesbyCourseId(
		long PK_courseId);

	/**
	* Returns the lab detailed course resources where PK_courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PK_courseId the p k_course ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lab detailed course resources, or <code>null</code> if a matching lab detailed course resources could not be found
	*/
	public labDetailedCourseResources fetchBygetCourseResourcesbyCourseId(
		long PK_courseId, boolean retrieveFromCache);

	/**
	* Removes the lab detailed course resources where PK_courseId = &#63; from the database.
	*
	* @param PK_courseId the p k_course ID
	* @return the lab detailed course resources that was removed
	*/
	public labDetailedCourseResources removeBygetCourseResourcesbyCourseId(
		long PK_courseId) throws NoSuchlabDetailedCourseResourcesException;

	/**
	* Returns the number of lab detailed course resourceses where PK_courseId = &#63;.
	*
	* @param PK_courseId the p k_course ID
	* @return the number of matching lab detailed course resourceses
	*/
	public int countBygetCourseResourcesbyCourseId(long PK_courseId);

	/**
	* Caches the lab detailed course resources in the entity cache if it is enabled.
	*
	* @param labDetailedCourseResources the lab detailed course resources
	*/
	public void cacheResult(
		labDetailedCourseResources labDetailedCourseResources);

	/**
	* Caches the lab detailed course resourceses in the entity cache if it is enabled.
	*
	* @param labDetailedCourseResourceses the lab detailed course resourceses
	*/
	public void cacheResult(
		java.util.List<labDetailedCourseResources> labDetailedCourseResourceses);

	/**
	* Creates a new lab detailed course resources with the primary key. Does not add the lab detailed course resources to the database.
	*
	* @param PK_courseResourceId the primary key for the new lab detailed course resources
	* @return the new lab detailed course resources
	*/
	public labDetailedCourseResources create(long PK_courseResourceId);

	/**
	* Removes the lab detailed course resources with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_courseResourceId the primary key of the lab detailed course resources
	* @return the lab detailed course resources that was removed
	* @throws NoSuchlabDetailedCourseResourcesException if a lab detailed course resources with the primary key could not be found
	*/
	public labDetailedCourseResources remove(long PK_courseResourceId)
		throws NoSuchlabDetailedCourseResourcesException;

	public labDetailedCourseResources updateImpl(
		labDetailedCourseResources labDetailedCourseResources);

	/**
	* Returns the lab detailed course resources with the primary key or throws a {@link NoSuchlabDetailedCourseResourcesException} if it could not be found.
	*
	* @param PK_courseResourceId the primary key of the lab detailed course resources
	* @return the lab detailed course resources
	* @throws NoSuchlabDetailedCourseResourcesException if a lab detailed course resources with the primary key could not be found
	*/
	public labDetailedCourseResources findByPrimaryKey(long PK_courseResourceId)
		throws NoSuchlabDetailedCourseResourcesException;

	/**
	* Returns the lab detailed course resources with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_courseResourceId the primary key of the lab detailed course resources
	* @return the lab detailed course resources, or <code>null</code> if a lab detailed course resources with the primary key could not be found
	*/
	public labDetailedCourseResources fetchByPrimaryKey(
		long PK_courseResourceId);

	@Override
	public java.util.Map<java.io.Serializable, labDetailedCourseResources> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab detailed course resourceses.
	*
	* @return the lab detailed course resourceses
	*/
	public java.util.List<labDetailedCourseResources> findAll();

	/**
	* Returns a range of all the lab detailed course resourceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course resourceses
	* @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	* @return the range of lab detailed course resourceses
	*/
	public java.util.List<labDetailedCourseResources> findAll(int start, int end);

	/**
	* Returns an ordered range of all the lab detailed course resourceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course resourceses
	* @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailed course resourceses
	*/
	public java.util.List<labDetailedCourseResources> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseResources> orderByComparator);

	/**
	* Returns an ordered range of all the lab detailed course resourceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailed course resourceses
	* @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailed course resourceses
	*/
	public java.util.List<labDetailedCourseResources> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<labDetailedCourseResources> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab detailed course resourceses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab detailed course resourceses.
	*
	* @return the number of lab detailed course resourceses
	*/
	public int countAll();
}