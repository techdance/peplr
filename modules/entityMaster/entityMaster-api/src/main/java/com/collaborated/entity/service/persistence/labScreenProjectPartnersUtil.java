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

import com.collaborated.entity.model.labScreenProjectPartners;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lab screen project partners service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.labScreenProjectPartnersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectPartnersPersistence
 * @see com.collaborated.entity.service.persistence.impl.labScreenProjectPartnersPersistenceImpl
 * @generated
 */
@ProviderType
public class labScreenProjectPartnersUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		labScreenProjectPartners labScreenProjectPartners) {
		getPersistence().clearCache(labScreenProjectPartners);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<labScreenProjectPartners> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<labScreenProjectPartners> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<labScreenProjectPartners> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<labScreenProjectPartners> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static labScreenProjectPartners update(
		labScreenProjectPartners labScreenProjectPartners) {
		return getPersistence().update(labScreenProjectPartners);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static labScreenProjectPartners update(
		labScreenProjectPartners labScreenProjectPartners,
		ServiceContext serviceContext) {
		return getPersistence().update(labScreenProjectPartners, serviceContext);
	}

	/**
	* Caches the lab screen project partners in the entity cache if it is enabled.
	*
	* @param labScreenProjectPartners the lab screen project partners
	*/
	public static void cacheResult(
		labScreenProjectPartners labScreenProjectPartners) {
		getPersistence().cacheResult(labScreenProjectPartners);
	}

	/**
	* Caches the lab screen project partnerses in the entity cache if it is enabled.
	*
	* @param labScreenProjectPartnerses the lab screen project partnerses
	*/
	public static void cacheResult(
		List<labScreenProjectPartners> labScreenProjectPartnerses) {
		getPersistence().cacheResult(labScreenProjectPartnerses);
	}

	/**
	* Creates a new lab screen project partners with the primary key. Does not add the lab screen project partners to the database.
	*
	* @param PK_projectPartnerId the primary key for the new lab screen project partners
	* @return the new lab screen project partners
	*/
	public static labScreenProjectPartners create(long PK_projectPartnerId) {
		return getPersistence().create(PK_projectPartnerId);
	}

	/**
	* Removes the lab screen project partners with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectPartnerId the primary key of the lab screen project partners
	* @return the lab screen project partners that was removed
	* @throws NoSuchlabScreenProjectPartnersException if a lab screen project partners with the primary key could not be found
	*/
	public static labScreenProjectPartners remove(long PK_projectPartnerId)
		throws com.collaborated.entity.exception.NoSuchlabScreenProjectPartnersException {
		return getPersistence().remove(PK_projectPartnerId);
	}

	public static labScreenProjectPartners updateImpl(
		labScreenProjectPartners labScreenProjectPartners) {
		return getPersistence().updateImpl(labScreenProjectPartners);
	}

	/**
	* Returns the lab screen project partners with the primary key or throws a {@link NoSuchlabScreenProjectPartnersException} if it could not be found.
	*
	* @param PK_projectPartnerId the primary key of the lab screen project partners
	* @return the lab screen project partners
	* @throws NoSuchlabScreenProjectPartnersException if a lab screen project partners with the primary key could not be found
	*/
	public static labScreenProjectPartners findByPrimaryKey(
		long PK_projectPartnerId)
		throws com.collaborated.entity.exception.NoSuchlabScreenProjectPartnersException {
		return getPersistence().findByPrimaryKey(PK_projectPartnerId);
	}

	/**
	* Returns the lab screen project partners with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_projectPartnerId the primary key of the lab screen project partners
	* @return the lab screen project partners, or <code>null</code> if a lab screen project partners with the primary key could not be found
	*/
	public static labScreenProjectPartners fetchByPrimaryKey(
		long PK_projectPartnerId) {
		return getPersistence().fetchByPrimaryKey(PK_projectPartnerId);
	}

	public static java.util.Map<java.io.Serializable, labScreenProjectPartners> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lab screen project partnerses.
	*
	* @return the lab screen project partnerses
	*/
	public static List<labScreenProjectPartners> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<labScreenProjectPartners> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<labScreenProjectPartners> findAll(int start, int end,
		OrderByComparator<labScreenProjectPartners> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<labScreenProjectPartners> findAll(int start, int end,
		OrderByComparator<labScreenProjectPartners> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lab screen project partnerses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lab screen project partnerses.
	*
	* @return the number of lab screen project partnerses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static labScreenProjectPartnersPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<labScreenProjectPartnersPersistence, labScreenProjectPartnersPersistence> _serviceTracker =
		ServiceTrackerFactory.open(labScreenProjectPartnersPersistence.class);
}