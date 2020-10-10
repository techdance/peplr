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

import com.collaborated.entity.exception.NoSuchprojectFilesUploadException;
import com.collaborated.entity.model.projectFilesUpload;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project files upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.persistence.impl.projectFilesUploadPersistenceImpl
 * @see projectFilesUploadUtil
 * @generated
 */
@ProviderType
public interface projectFilesUploadPersistence extends BasePersistence<projectFilesUpload> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link projectFilesUploadUtil} to access the project files upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project files upload in the entity cache if it is enabled.
	*
	* @param projectFilesUpload the project files upload
	*/
	public void cacheResult(projectFilesUpload projectFilesUpload);

	/**
	* Caches the project files uploads in the entity cache if it is enabled.
	*
	* @param projectFilesUploads the project files uploads
	*/
	public void cacheResult(
		java.util.List<projectFilesUpload> projectFilesUploads);

	/**
	* Creates a new project files upload with the primary key. Does not add the project files upload to the database.
	*
	* @param PK_projectFileId the primary key for the new project files upload
	* @return the new project files upload
	*/
	public projectFilesUpload create(long PK_projectFileId);

	/**
	* Removes the project files upload with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PK_projectFileId the primary key of the project files upload
	* @return the project files upload that was removed
	* @throws NoSuchprojectFilesUploadException if a project files upload with the primary key could not be found
	*/
	public projectFilesUpload remove(long PK_projectFileId)
		throws NoSuchprojectFilesUploadException;

	public projectFilesUpload updateImpl(projectFilesUpload projectFilesUpload);

	/**
	* Returns the project files upload with the primary key or throws a {@link NoSuchprojectFilesUploadException} if it could not be found.
	*
	* @param PK_projectFileId the primary key of the project files upload
	* @return the project files upload
	* @throws NoSuchprojectFilesUploadException if a project files upload with the primary key could not be found
	*/
	public projectFilesUpload findByPrimaryKey(long PK_projectFileId)
		throws NoSuchprojectFilesUploadException;

	/**
	* Returns the project files upload with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PK_projectFileId the primary key of the project files upload
	* @return the project files upload, or <code>null</code> if a project files upload with the primary key could not be found
	*/
	public projectFilesUpload fetchByPrimaryKey(long PK_projectFileId);

	@Override
	public java.util.Map<java.io.Serializable, projectFilesUpload> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project files uploads.
	*
	* @return the project files uploads
	*/
	public java.util.List<projectFilesUpload> findAll();

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
	public java.util.List<projectFilesUpload> findAll(int start, int end);

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
	public java.util.List<projectFilesUpload> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projectFilesUpload> orderByComparator);

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
	public java.util.List<projectFilesUpload> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<projectFilesUpload> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project files uploads from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project files uploads.
	*
	* @return the number of project files uploads
	*/
	public int countAll();
}