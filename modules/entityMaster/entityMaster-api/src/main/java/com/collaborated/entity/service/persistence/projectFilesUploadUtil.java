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

import com.collaborated.entity.model.projectFilesUpload;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project files upload service. This utility wraps {@link com.collaborated.entity.service.persistence.impl.projectFilesUploadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectFilesUploadPersistence
 * @see com.collaborated.entity.service.persistence.impl.projectFilesUploadPersistenceImpl
 * @generated
 */
@ProviderType
public class projectFilesUploadUtil {
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
	public static void clearCache(projectFilesUpload projectFilesUpload) {
		getPersistence().clearCache(projectFilesUpload);
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
	public static List<projectFilesUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<projectFilesUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<projectFilesUpload> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<projectFilesUpload> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static projectFilesUpload update(
		projectFilesUpload projectFilesUpload) {
		return getPersistence().update(projectFilesUpload);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static projectFilesUpload update(
		projectFilesUpload projectFilesUpload, ServiceContext serviceContext) {
		return getPersistence().update(projectFilesUpload, serviceContext);
	}

	/**
	* Caches the project files upload in the entity cache if it is enabled.
	*
	* @param projectFilesUpload the project files upload
	*/
	public static void cacheResult(projectFilesUpload projectFilesUpload) {
		getPersistence().cacheResult(projectFilesUpload);
	}

	/**
	* Caches the project files uploads in the entity cache if it is enabled.
	*
	* @param projectFilesUploads the project files uploads
	*/
	public static void cacheResult(List<projectFilesUpload> projectFilesUploads) {
		getPersistence().cacheResult(projectFilesUploads);
	}

	/**
	* Creates a new project files upload with the primary key. Does not add the project files upload to the database.
	*
	* @param PK_projectFileId the primary key for the new project files upload
	* @return the new project files upload
	*/
	public static projectFilesUpload create(long PK_projectFileId) {
		return getPersistence().create(PK_projectFileId);
	}

	/**
	* Removes the project files upload with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectFileId the primary key of the project files upload
	* @return the project files upload that was removed
	* @throws NoSuchprojectFilesUploadException if a project files upload with the primary key could not be found
	*/
	public static projectFilesUpload remove(long PK_projectFileId)
		throws com.collaborated.entity.exception.NoSuchprojectFilesUploadException {
		return getPersistence().remove(PK_projectFileId);
	}

	public static projectFilesUpload updateImpl(
		projectFilesUpload projectFilesUpload) {
		return getPersistence().updateImpl(projectFilesUpload);
	}

	/**
	* Returns the project files upload with the primary key or throws a {@link NoSuchprojectFilesUploadException} if it could not be found.
	*
	* @param PK_projectFileId the primary key of the project files upload
	* @return the project files upload
	* @throws NoSuchprojectFilesUploadException if a project files upload with the primary key could not be found
	*/
	public static projectFilesUpload findByPrimaryKey(long PK_projectFileId)
		throws com.collaborated.entity.exception.NoSuchprojectFilesUploadException {
		return getPersistence().findByPrimaryKey(PK_projectFileId);
	}

	/**
	* Returns the project files upload with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_projectFileId the primary key of the project files upload
	* @return the project files upload, or <code>null</code> if a project files upload with the primary key could not be found
	*/
	public static projectFilesUpload fetchByPrimaryKey(long PK_projectFileId) {
		return getPersistence().fetchByPrimaryKey(PK_projectFileId);
	}

	public static java.util.Map<java.io.Serializable, projectFilesUpload> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project files uploads.
	*
	* @return the project files uploads
	*/
	public static List<projectFilesUpload> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project files uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectFilesUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project files uploads
	* @param end the upper bound of the range of project files uploads (not inclusive)
	* @return the range of project files uploads
	*/
	public static List<projectFilesUpload> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project files uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectFilesUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project files uploads
	* @param end the upper bound of the range of project files uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project files uploads
	*/
	public static List<projectFilesUpload> findAll(int start, int end,
		OrderByComparator<projectFilesUpload> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project files uploads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectFilesUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project files uploads
	* @param end the upper bound of the range of project files uploads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project files uploads
	*/
	public static List<projectFilesUpload> findAll(int start, int end,
		OrderByComparator<projectFilesUpload> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project files uploads from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project files uploads.
	*
	* @return the number of project files uploads
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static projectFilesUploadPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<projectFilesUploadPersistence, projectFilesUploadPersistence> _serviceTracker =
		ServiceTrackerFactory.open(projectFilesUploadPersistence.class);
}