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

import com.collaborated.entity.exception.NoSuchCustom_Workflow_CompletedException;
import com.collaborated.entity.model.Custom_Workflow_Completed;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the custom_ workflow_ completed service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.Custom_Workflow_CompletedPersistenceImpl
 * @see Custom_Workflow_CompletedUtil
 * @generated
 */
@ProviderType
public interface Custom_Workflow_CompletedPersistence extends BasePersistence<Custom_Workflow_Completed> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Custom_Workflow_CompletedUtil} to access the custom_ workflow_ completed persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the custom_ workflow_ completed in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Completed the custom_ workflow_ completed
	*/
	public void cacheResult(Custom_Workflow_Completed custom_Workflow_Completed);

	/**
	* Caches the custom_ workflow_ completeds in the entity cache if it is enabled.
	*
	* @param custom_Workflow_Completeds the custom_ workflow_ completeds
	*/
	public void cacheResult(
		java.util.List<Custom_Workflow_Completed> custom_Workflow_Completeds);

	/**
	* Creates a new custom_ workflow_ completed with the primary key. Does not add the custom_ workflow_ completed to the database.
	*
	* @param cId the primary key for the new custom_ workflow_ completed
	* @return the new custom_ workflow_ completed
	*/
	public Custom_Workflow_Completed create(long cId);

	/**
	* Removes the custom_ workflow_ completed with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cId the primary key of the custom_ workflow_ completed
	* @return the custom_ workflow_ completed that was removed
	* @throws NoSuchCustom_Workflow_CompletedException if a custom_ workflow_ completed with the primary key could not be found
	*/
	public Custom_Workflow_Completed remove(long cId)
		throws NoSuchCustom_Workflow_CompletedException;

	public Custom_Workflow_Completed updateImpl(
		Custom_Workflow_Completed custom_Workflow_Completed);

	/**
	* Returns the custom_ workflow_ completed with the primary key or throws a {@link NoSuchCustom_Workflow_CompletedException} if it could not be found.
	*
	* @param cId the primary key of the custom_ workflow_ completed
	* @return the custom_ workflow_ completed
	* @throws NoSuchCustom_Workflow_CompletedException if a custom_ workflow_ completed with the primary key could not be found
	*/
	public Custom_Workflow_Completed findByPrimaryKey(long cId)
		throws NoSuchCustom_Workflow_CompletedException;

	/**
	* Returns the custom_ workflow_ completed with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cId the primary key of the custom_ workflow_ completed
	* @return the custom_ workflow_ completed, or <code>null</code> if a custom_ workflow_ completed with the primary key could not be found
	*/
	public Custom_Workflow_Completed fetchByPrimaryKey(long cId);

	@Override
	public java.util.Map<java.io.Serializable, Custom_Workflow_Completed> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the custom_ workflow_ completeds.
	*
	* @return the custom_ workflow_ completeds
	*/
	public java.util.List<Custom_Workflow_Completed> findAll();

	/**
	* Returns a range of all the custom_ workflow_ completeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ completeds
	* @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	* @return the range of custom_ workflow_ completeds
	*/
	public java.util.List<Custom_Workflow_Completed> findAll(int start, int end);

	/**
	* Returns an ordered range of all the custom_ workflow_ completeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ completeds
	* @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of custom_ workflow_ completeds
	*/
	public java.util.List<Custom_Workflow_Completed> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_Workflow_Completed> orderByComparator);

	/**
	* Returns an ordered range of all the custom_ workflow_ completeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of custom_ workflow_ completeds
	* @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of custom_ workflow_ completeds
	*/
	public java.util.List<Custom_Workflow_Completed> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom_Workflow_Completed> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the custom_ workflow_ completeds from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of custom_ workflow_ completeds.
	*
	* @return the number of custom_ workflow_ completeds
	*/
	public int countAll();
}