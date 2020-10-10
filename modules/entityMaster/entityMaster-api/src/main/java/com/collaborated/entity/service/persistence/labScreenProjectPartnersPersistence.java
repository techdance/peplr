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

import com.collaborated.entity.exception.NoSuchlabScreenProjectPartnersException;
import com.collaborated.entity.model.labScreenProjectPartners;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the lab screen project partners service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.labScreenProjectPartnersPersistenceImpl
 * @see labScreenProjectPartnersUtil
 * @generated
 */
@ProviderType
public interface labScreenProjectPartnersPersistence extends BasePersistence<labScreenProjectPartners> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link labScreenProjectPartnersUtil} to access the lab screen project partners persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lab screen project partners in the entity cache if it is enabled.
	*
	* @param labScreenProjectPartners the lab screen project partners
	*/
	public void cacheResult(labScreenProjectPartners labScreenProjectPartners);

	/**
	* Caches the lab screen project partnerses in the entity cache if it is enabled.
	*
	* @param labScreenProjectPartnerses the lab screen project partnerses
	*/
	public void cacheResult(
		java.util.List<labScreenProjectPartners> labScreenProjectPartnerses);

	/**
	* Creates a new lab screen project partners with the primary key. Does not add the lab screen project partners to the database.
	*
	* @param PK_projectPartnerId the primary key for the new lab screen project partners
	* @return the new lab screen project partners
	*/
	public labScreenProjectPartners create(long PK_projectPartnerId);

	/**
	* Removes the lab screen project partners with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectPartnerId the primary key of the lab screen project partners
	* @return the lab screen project partners that was removed
	* @throws NoSuchlabScreenProjectPartnersException if a lab screen project partners with the primary key could not be found
	*/
	public labScreenProjectPartners remove(long PK_projectPartnerId)
		throws NoSuchlabScreenProjectPartnersException;

	public labScreenProjectPartners updateImpl(
		labScreenProjectPartners labScreenProjectPartners);

	/**
	* Returns the lab screen project partners with the primary key or throws a {@link NoSuchlabScreenProjectPartnersException} if it could not be found.
	*
	* @param PK_projectPartnerId the primary key of the lab screen project partners
	* @return the lab screen project partners
	* @throws NoSuchlabScreenProjectPartnersException if a lab screen project partners with the primary key could not be found
	*/
	public labScreenProjectPartners findByPrimaryKey(long PK_projectPartnerId)
		throws NoSuchlabScreenProjectPartnersException;

	/**
	* Returns the lab screen project partners with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_projectPartnerId the primary key of the lab screen project partners
	* @return the lab screen project partners, or <code>null</code> if a lab screen project partners with the primary key could not be found
	*/
	public labScreenProjectPartners fetchByPrimaryKey(long PK_projectPartnerId);

	@Override
	public java.util.Map<java.io.Serializable, labScreenProjectPartners> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab screen project partnerses.
	*
	* @return the lab screen project partnerses
	*/
	public java.util.List<labScreenProjectPartners> findAll();

	/**
	* Returns a range of all the lab screen project partnerses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectPartnersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project partnerses
	* @param end the upper bound of the range of lab screen project partnerses (not inclusive)
	* @return the range of lab screen project partnerses
	*/
	public java.util.List<labScreenProjectPartners> findAll(int start, int end);

	/**
	* Returns an ordered range of all the lab screen project partnerses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectPartnersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project partnerses
	* @param end the upper bound of the range of lab screen project partnerses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab screen project partnerses
	*/
	public java.util.List<labScreenProjectPartners> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labScreenProjectPartners> orderByComparator);

	/**
	* Returns an ordered range of all the lab screen project partnerses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectPartnersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab screen project partnerses
	* @param end the upper bound of the range of lab screen project partnerses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab screen project partnerses
	*/
	public java.util.List<labScreenProjectPartners> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<labScreenProjectPartners> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab screen project partnerses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab screen project partnerses.
	*
	* @return the number of lab screen project partnerses
	*/
	public int countAll();
}