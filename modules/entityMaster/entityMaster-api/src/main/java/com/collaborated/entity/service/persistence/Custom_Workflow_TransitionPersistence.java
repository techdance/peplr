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

import com.collaborated.entity.exception.NoSuchCustom_Workflow_TransitionException;
import com.collaborated.entity.model.Custom_Workflow_Transition;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the custom_ workflow_ transition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.Custom_Workflow_TransitionPersistenceImpl
 * @see Custom_Workflow_TransitionUtil
 * @generated
 */
@ProviderType
public interface Custom_Workflow_TransitionPersistence extends BasePersistence<Custom_Workflow_Transition> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Custom_Workflow_TransitionUtil} to access the custom_ workflow_ transition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the custom_ workflow_ transition in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Transition the custom_ workflow_ transition
	*/
	public void cacheResult(
		Custom_Workflow_Transition custom_Workflow_Transition);

	/**
	* Caches the custom_ workflow_ transitions in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Transitions the custom_ workflow_ transitions
	*/
	public void cacheResult(
		java.util.List<Custom_Workflow_Transition> custom_Workflow_Transitions);

	/**
	* Creates a new custom_ workflow_ transition with the primary key. Does not add the custom_ workflow_ transition to the database.
	*
	* @param transitionId the primary key for the new custom_ workflow_ transition
	* @return the new custom_ workflow_ transition
	*/
	public Custom_Workflow_Transition create(long transitionId);

	/**
	* Removes the custom_ workflow_ transition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transitionId the primary key of the custom_ workflow_ transition
	* @return the custom_ workflow_ transition that was removed
	* @throws NoSuchCustom_Workflow_TransitionException if a custom_ workflow_ transition with the primary key could not be found
	*/
	public Custom_Workflow_Transition remove(long transitionId)
		throws NoSuchCustom_Workflow_TransitionException;

	public Custom_Workflow_Transition updateImpl(
		Custom_Workflow_Transition custom_Workflow_Transition);

	/**
	* Returns the custom_ workflow_ transition with the primary key or throws a {@link NoSuchCustom_Workflow_TransitionException} if it could not be found.
	*
	* @param transitionId the primary key of the custom_ workflow_ transition
	* @return the custom_ workflow_ transition
	* @throws NoSuchCustom_Workflow_TransitionException if a custom_ workflow_ transition with the primary key could not be found
	*/
	public Custom_Workflow_Transition findByPrimaryKey(long transitionId)
		throws NoSuchCustom_Workflow_TransitionException;

	/**
	* Returns the custom_ workflow_ transition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transitionId the primary key of the custom_ workflow_ transition
	* @return the custom_ workflow_ transition, or <code>null</code> if a custom_ workflow_ transition with the primary key could not be found
	*/
	public Custom_Workflow_Transition fetchByPrimaryKey(long transitionId);

	@Override
	public java.util.Map<java.io.Serializable, Custom_Workflow_Transition> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the custom_ workflow_ transitions.
	*
	* @return the custom_ workflow_ transitions
	*/
	public java.util.List<Custom_Workflow_Transition> findAll();

	/**
	* Returns a range of all the custom_ workflow_ transitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ transitions
	* @param end the upper bound of the range of custom_ workflow_ transitions (not inclusive)
	* @return the range of custom_ workflow_ transitions
	*/
	public java.util.List<Custom_Workflow_Transition> findAll(int start, int end);

	/**
	* Returns an ordered range of all the custom_ workflow_ transitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ transitions
	* @param end the upper bound of the range of custom_ workflow_ transitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of custom_ workflow_ transitions
	*/
	public java.util.List<Custom_Workflow_Transition> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_Workflow_Transition> orderByComparator);

	/**
	* Returns an ordered range of all the custom_ workflow_ transitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ transitions
	* @param end the upper bound of the range of custom_ workflow_ transitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of custom_ workflow_ transitions
	*/
	public java.util.List<Custom_Workflow_Transition> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_Workflow_Transition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the custom_ workflow_ transitions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of custom_ workflow_ transitions.
	*
	* @return the number of custom_ workflow_ transitions
	*/
	public int countAll();
}