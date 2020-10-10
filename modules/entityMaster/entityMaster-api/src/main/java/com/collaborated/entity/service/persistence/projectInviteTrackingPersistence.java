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

import com.collaborated.entity.exception.NoSuchprojectInviteTrackingException;
import com.collaborated.entity.model.projectInviteTracking;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project invite tracking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.projectInviteTrackingPersistenceImpl
 * @see projectInviteTrackingUtil
 * @generated
 */
@ProviderType
public interface projectInviteTrackingPersistence extends BasePersistence<projectInviteTracking> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link projectInviteTrackingUtil} to access the project invite tracking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project invite tracking in the entity cache if it is enabled.
	*
	* @param projectInviteTracking the project invite tracking
	*/
	public void cacheResult(projectInviteTracking projectInviteTracking);

	/**
	* Caches the project invite trackings in the entity cache if it is enabled.
	*
	* @param projectInviteTrackings the project invite trackings
	*/
	public void cacheResult(
		java.util.List<projectInviteTracking> projectInviteTrackings);

	/**
	* Creates a new project invite tracking with the primary key. Does not add the project invite tracking to the database.
	*
	* @param PK_projectInvitationId the primary key for the new project invite tracking
	* @return the new project invite tracking
	*/
	public projectInviteTracking create(long PK_projectInvitationId);

	/**
	* Removes the project invite tracking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectInvitationId the primary key of the project invite tracking
	* @return the project invite tracking that was removed
	* @throws NoSuchprojectInviteTrackingException if a project invite tracking with the primary key could not be found
	*/
	public projectInviteTracking remove(long PK_projectInvitationId)
		throws NoSuchprojectInviteTrackingException;

	public projectInviteTracking updateImpl(
		projectInviteTracking projectInviteTracking);

	/**
	* Returns the project invite tracking with the primary key or throws a {@link NoSuchprojectInviteTrackingException} if it could not be found.
	*
	* @param PK_projectInvitationId the primary key of the project invite tracking
	* @return the project invite tracking
	* @throws NoSuchprojectInviteTrackingException if a project invite tracking with the primary key could not be found
	*/
	public projectInviteTracking findByPrimaryKey(long PK_projectInvitationId)
		throws NoSuchprojectInviteTrackingException;

	/**
	* Returns the project invite tracking with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_projectInvitationId the primary key of the project invite tracking
	* @return the project invite tracking, or <code>null</code> if a project invite tracking with the primary key could not be found
	*/
	public projectInviteTracking fetchByPrimaryKey(long PK_projectInvitationId);

	@Override
	public java.util.Map<java.io.Serializable, projectInviteTracking> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project invite trackings.
	*
	* @return the project invite trackings
	*/
	public java.util.List<projectInviteTracking> findAll();

	/**
	* Returns a range of all the project invite trackings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectInviteTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project invite trackings
	* @param end the upper bound of the range of project invite trackings (not inclusive)
	* @return the range of project invite trackings
	*/
	public java.util.List<projectInviteTracking> findAll(int start, int end);

	/**
	* Returns an ordered range of all the project invite trackings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectInviteTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project invite trackings
	* @param end the upper bound of the range of project invite trackings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project invite trackings
	*/
	public java.util.List<projectInviteTracking> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projectInviteTracking> orderByComparator);

	/**
	* Returns an ordered range of all the project invite trackings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectInviteTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project invite trackings
	* @param end the upper bound of the range of project invite trackings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project invite trackings
	*/
	public java.util.List<projectInviteTracking> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projectInviteTracking> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project invite trackings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project invite trackings.
	*
	* @return the number of project invite trackings
	*/
	public int countAll();
}