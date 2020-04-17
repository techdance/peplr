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

import com.collaborated.entity.exception.NoSuchlanguagePreferencesException;
import com.collaborated.entity.model.languagePreferences;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the language preferences service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.languagePreferencesPersistenceImpl
 * @see languagePreferencesUtil
 * @generated
 */
@ProviderType
public interface languagePreferencesPersistence extends BasePersistence<languagePreferences> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link languagePreferencesUtil} to access the language preferences persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the language preferences in the entity cache if it is enabled.
	*
	* @param languagePreferences the language preferences
	*/
	public void cacheResult(languagePreferences languagePreferences);

	/**
	* Caches the language preferenceses in the entity cache if it is enabled.
	*
	* @param languagePreferenceses the language preferenceses
	*/
	public void cacheResult(
		java.util.List<languagePreferences> languagePreferenceses);

	/**
	* Creates a new language preferences with the primary key. Does not add the language preferences to the database.
	*
	* @param PK_languagePreferences the primary key for the new language preferences
	* @return the new language preferences
	*/
	public languagePreferences create(long PK_languagePreferences);

	/**
	* Removes the language preferences with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_languagePreferences the primary key of the language preferences
	* @return the language preferences that was removed
	* @throws NoSuchlanguagePreferencesException if a language preferences with the primary key could not be found
	*/
	public languagePreferences remove(long PK_languagePreferences)
		throws NoSuchlanguagePreferencesException;

	public languagePreferences updateImpl(
		languagePreferences languagePreferences);

	/**
	* Returns the language preferences with the primary key or throws a {@link NoSuchlanguagePreferencesException} if it could not be found.
	*
	* @param PK_languagePreferences the primary key of the language preferences
	* @return the language preferences
	* @throws NoSuchlanguagePreferencesException if a language preferences with the primary key could not be found
	*/
	public languagePreferences findByPrimaryKey(long PK_languagePreferences)
		throws NoSuchlanguagePreferencesException;

	/**
	* Returns the language preferences with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_languagePreferences the primary key of the language preferences
	* @return the language preferences, or <code>null</code> if a language preferences with the primary key could not be found
	*/
	public languagePreferences fetchByPrimaryKey(long PK_languagePreferences);

	@Override
	public java.util.Map<java.io.Serializable, languagePreferences> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the language preferenceses.
	*
	* @return the language preferenceses
	*/
	public java.util.List<languagePreferences> findAll();

	/**
	* Returns a range of all the language preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of language preferenceses
	* @param end the upper bound of the range of language preferenceses (not inclusive)
	* @return the range of language preferenceses
	*/
	public java.util.List<languagePreferences> findAll(int start, int end);

	/**
	* Returns an ordered range of all the language preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of language preferenceses
	* @param end the upper bound of the range of language preferenceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of language preferenceses
	*/
	public java.util.List<languagePreferences> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<languagePreferences> orderByComparator);

	/**
	* Returns an ordered range of all the language preferenceses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of language preferenceses
	* @param end the upper bound of the range of language preferenceses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of language preferenceses
	*/
	public java.util.List<languagePreferences> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<languagePreferences> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the language preferenceses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of language preferenceses.
	*
	* @return the number of language preferenceses
	*/
	public int countAll();
}