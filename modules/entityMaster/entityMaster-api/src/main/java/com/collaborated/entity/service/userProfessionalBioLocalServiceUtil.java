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

package com.collaborated.entity.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for userProfessionalBio. This utility wraps
 * {@link com.collaborated.entity.service.impl.userProfessionalBioLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see userProfessionalBioLocalService
 * @see com.collaborated.entity.service.base.userProfessionalBioLocalServiceBaseImpl
 * @see com.collaborated.entity.service.impl.userProfessionalBioLocalServiceImpl
 * @generated
 */
@ProviderType
public class userProfessionalBioLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.collaborated.entity.service.impl.userProfessionalBioLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user professional bio to the database. Also notifies the appropriate model listeners.
	*
	* @param userProfessionalBio the user professional bio
	* @return the user professional bio that was added
	*/
	public static com.collaborated.entity.model.userProfessionalBio adduserProfessionalBio(
		com.collaborated.entity.model.userProfessionalBio userProfessionalBio) {
		return getService().adduserProfessionalBio(userProfessionalBio);
	}

	/**
	* Creates a new user professional bio with the primary key. Does not add the user professional bio to the database.
	*
	* @param PK_userProfessionalBio the primary key for the new user professional bio
	* @return the new user professional bio
	*/
	public static com.collaborated.entity.model.userProfessionalBio createuserProfessionalBio(
		long PK_userProfessionalBio) {
		return getService().createuserProfessionalBio(PK_userProfessionalBio);
	}

	/**
	* Deletes the user professional bio from the database. Also notifies the appropriate model listeners.
	*
	* @param userProfessionalBio the user professional bio
	* @return the user professional bio that was removed
	*/
	public static com.collaborated.entity.model.userProfessionalBio deleteuserProfessionalBio(
		com.collaborated.entity.model.userProfessionalBio userProfessionalBio) {
		return getService().deleteuserProfessionalBio(userProfessionalBio);
	}

	/**
	* Deletes the user professional bio with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_userProfessionalBio the primary key of the user professional bio
	* @return the user professional bio that was removed
	* @throws PortalException if a user professional bio with the primary key could not be found
	*/
	public static com.collaborated.entity.model.userProfessionalBio deleteuserProfessionalBio(
		long PK_userProfessionalBio)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteuserProfessionalBio(PK_userProfessionalBio);
	}

	public static com.collaborated.entity.model.userProfessionalBio fetchuserProfessionalBio(
		long PK_userProfessionalBio) {
		return getService().fetchuserProfessionalBio(PK_userProfessionalBio);
	}

	/**
	* Returns the user professional bio with the primary key.
	*
	* @param PK_userProfessionalBio the primary key of the user professional bio
	* @return the user professional bio
	* @throws PortalException if a user professional bio with the primary key could not be found
	*/
	public static com.collaborated.entity.model.userProfessionalBio getuserProfessionalBio(
		long PK_userProfessionalBio)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getuserProfessionalBio(PK_userProfessionalBio);
	}

	/**
	* Updates the user professional bio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userProfessionalBio the user professional bio
	* @return the user professional bio that was updated
	*/
	public static com.collaborated.entity.model.userProfessionalBio updateuserProfessionalBio(
		com.collaborated.entity.model.userProfessionalBio userProfessionalBio) {
		return getService().updateuserProfessionalBio(userProfessionalBio);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of user professional bios.
	*
	* @return the number of user professional bios
	*/
	public static int getuserProfessionalBiosCount() {
		return getService().getuserProfessionalBiosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the user professional bios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user professional bios
	* @param end the upper bound of the range of user professional bios (not inclusive)
	* @return the range of user professional bios
	*/
	public static java.util.List<com.collaborated.entity.model.userProfessionalBio> getuserProfessionalBios(
		int start, int end) {
		return getService().getuserProfessionalBios(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static userProfessionalBioLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<userProfessionalBioLocalService, userProfessionalBioLocalService> _serviceTracker =
		ServiceTrackerFactory.open(userProfessionalBioLocalService.class);
}