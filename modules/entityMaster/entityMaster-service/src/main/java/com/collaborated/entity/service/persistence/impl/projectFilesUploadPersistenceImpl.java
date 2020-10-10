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

package com.collaborated.entity.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.collaborated.entity.exception.NoSuchprojectFilesUploadException;
import com.collaborated.entity.model.impl.projectFilesUploadImpl;
import com.collaborated.entity.model.impl.projectFilesUploadModelImpl;
import com.collaborated.entity.model.projectFilesUpload;
import com.collaborated.entity.service.persistence.projectFilesUploadPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the project files upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectFilesUploadPersistence
 * @see com.collaborated.entity.service.persistence.projectFilesUploadUtil
 * @generated
 */
@ProviderType
public class projectFilesUploadPersistenceImpl extends BasePersistenceImpl<projectFilesUpload>
	implements projectFilesUploadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link projectFilesUploadUtil} to access the project files upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = projectFilesUploadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFilesUploadModelImpl.FINDER_CACHE_ENABLED,
			projectFilesUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFilesUploadModelImpl.FINDER_CACHE_ENABLED,
			projectFilesUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFilesUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public projectFilesUploadPersistenceImpl() {
		setModelClass(projectFilesUpload.class);
	}

	/**
	 * Caches the project files upload in the entity cache if it is enabled.
	 *
	 * @param projectFilesUpload the project files upload
	 */
	@Override
	public void cacheResult(projectFilesUpload projectFilesUpload) {
		entityCache.putResult(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFilesUploadImpl.class, projectFilesUpload.getPrimaryKey(),
			projectFilesUpload);

		projectFilesUpload.resetOriginalValues();
	}

	/**
	 * Caches the project files uploads in the entity cache if it is enabled.
	 *
	 * @param projectFilesUploads the project files uploads
	 */
	@Override
	public void cacheResult(List<projectFilesUpload> projectFilesUploads) {
		for (projectFilesUpload projectFilesUpload : projectFilesUploads) {
			if (entityCache.getResult(
						projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
						projectFilesUploadImpl.class,
						projectFilesUpload.getPrimaryKey()) == null) {
				cacheResult(projectFilesUpload);
			}
			else {
				projectFilesUpload.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project files uploads.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(projectFilesUploadImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project files upload.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(projectFilesUpload projectFilesUpload) {
		entityCache.removeResult(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFilesUploadImpl.class, projectFilesUpload.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<projectFilesUpload> projectFilesUploads) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (projectFilesUpload projectFilesUpload : projectFilesUploads) {
			entityCache.removeResult(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
				projectFilesUploadImpl.class, projectFilesUpload.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project files upload with the primary key. Does not add the project files upload to the database.
	 *
	 * @param PK_projectFileId the primary key for the new project files upload
	 * @return the new project files upload
	 */
	@Override
	public projectFilesUpload create(long PK_projectFileId) {
		projectFilesUpload projectFilesUpload = new projectFilesUploadImpl();

		projectFilesUpload.setNew(true);
		projectFilesUpload.setPrimaryKey(PK_projectFileId);

		return projectFilesUpload;
	}

	/**
	 * Removes the project files upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_projectFileId the primary key of the project files upload
	 * @return the project files upload that was removed
	 * @throws NoSuchprojectFilesUploadException if a project files upload with the primary key could not be found
	 */
	@Override
	public projectFilesUpload remove(long PK_projectFileId)
		throws NoSuchprojectFilesUploadException {
		return remove((Serializable)PK_projectFileId);
	}

	/**
	 * Removes the project files upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project files upload
	 * @return the project files upload that was removed
	 * @throws NoSuchprojectFilesUploadException if a project files upload with the primary key could not be found
	 */
	@Override
	public projectFilesUpload remove(Serializable primaryKey)
		throws NoSuchprojectFilesUploadException {
		Session session = null;

		try {
			session = openSession();

			projectFilesUpload projectFilesUpload = (projectFilesUpload)session.get(projectFilesUploadImpl.class,
					primaryKey);

			if (projectFilesUpload == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchprojectFilesUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectFilesUpload);
		}
		catch (NoSuchprojectFilesUploadException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected projectFilesUpload removeImpl(
		projectFilesUpload projectFilesUpload) {
		projectFilesUpload = toUnwrappedModel(projectFilesUpload);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectFilesUpload)) {
				projectFilesUpload = (projectFilesUpload)session.get(projectFilesUploadImpl.class,
						projectFilesUpload.getPrimaryKeyObj());
			}

			if (projectFilesUpload != null) {
				session.delete(projectFilesUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectFilesUpload != null) {
			clearCache(projectFilesUpload);
		}

		return projectFilesUpload;
	}

	@Override
	public projectFilesUpload updateImpl(projectFilesUpload projectFilesUpload) {
		projectFilesUpload = toUnwrappedModel(projectFilesUpload);

		boolean isNew = projectFilesUpload.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projectFilesUpload.isNew()) {
				session.save(projectFilesUpload);

				projectFilesUpload.setNew(false);
			}
			else {
				projectFilesUpload = (projectFilesUpload)session.merge(projectFilesUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFilesUploadImpl.class, projectFilesUpload.getPrimaryKey(),
			projectFilesUpload, false);

		projectFilesUpload.resetOriginalValues();

		return projectFilesUpload;
	}

	protected projectFilesUpload toUnwrappedModel(
		projectFilesUpload projectFilesUpload) {
		if (projectFilesUpload instanceof projectFilesUploadImpl) {
			return projectFilesUpload;
		}

		projectFilesUploadImpl projectFilesUploadImpl = new projectFilesUploadImpl();

		projectFilesUploadImpl.setNew(projectFilesUpload.isNew());
		projectFilesUploadImpl.setPrimaryKey(projectFilesUpload.getPrimaryKey());

		projectFilesUploadImpl.setPK_projectFileId(projectFilesUpload.getPK_projectFileId());
		projectFilesUploadImpl.setGroupId(projectFilesUpload.getGroupId());
		projectFilesUploadImpl.setCreatedOn(projectFilesUpload.getCreatedOn());
		projectFilesUploadImpl.setDeletedOn(projectFilesUpload.getDeletedOn());
		projectFilesUploadImpl.setUserId(projectFilesUpload.getUserId());
		projectFilesUploadImpl.setDeletedBy(projectFilesUpload.getDeletedBy());
		projectFilesUploadImpl.setPK_projectFolderId(projectFilesUpload.getPK_projectFolderId());
		projectFilesUploadImpl.setFileName(projectFilesUpload.getFileName());
		projectFilesUploadImpl.setFileEntryId(projectFilesUpload.getFileEntryId());
		projectFilesUploadImpl.setDescription(projectFilesUpload.getDescription());

		return projectFilesUploadImpl;
	}

	/**
	 * Returns the project files upload with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project files upload
	 * @return the project files upload
	 * @throws NoSuchprojectFilesUploadException if a project files upload with the primary key could not be found
	 */
	@Override
	public projectFilesUpload findByPrimaryKey(Serializable primaryKey)
		throws NoSuchprojectFilesUploadException {
		projectFilesUpload projectFilesUpload = fetchByPrimaryKey(primaryKey);

		if (projectFilesUpload == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchprojectFilesUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectFilesUpload;
	}

	/**
	 * Returns the project files upload with the primary key or throws a {@link NoSuchprojectFilesUploadException} if it could not be found.
	 *
	 * @param PK_projectFileId the primary key of the project files upload
	 * @return the project files upload
	 * @throws NoSuchprojectFilesUploadException if a project files upload with the primary key could not be found
	 */
	@Override
	public projectFilesUpload findByPrimaryKey(long PK_projectFileId)
		throws NoSuchprojectFilesUploadException {
		return findByPrimaryKey((Serializable)PK_projectFileId);
	}

	/**
	 * Returns the project files upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project files upload
	 * @return the project files upload, or <code>null</code> if a project files upload with the primary key could not be found
	 */
	@Override
	public projectFilesUpload fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
				projectFilesUploadImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		projectFilesUpload projectFilesUpload = (projectFilesUpload)serializable;

		if (projectFilesUpload == null) {
			Session session = null;

			try {
				session = openSession();

				projectFilesUpload = (projectFilesUpload)session.get(projectFilesUploadImpl.class,
						primaryKey);

				if (projectFilesUpload != null) {
					cacheResult(projectFilesUpload);
				}
				else {
					entityCache.putResult(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
						projectFilesUploadImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
					projectFilesUploadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectFilesUpload;
	}

	/**
	 * Returns the project files upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_projectFileId the primary key of the project files upload
	 * @return the project files upload, or <code>null</code> if a project files upload with the primary key could not be found
	 */
	@Override
	public projectFilesUpload fetchByPrimaryKey(long PK_projectFileId) {
		return fetchByPrimaryKey((Serializable)PK_projectFileId);
	}

	@Override
	public Map<Serializable, projectFilesUpload> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, projectFilesUpload> map = new HashMap<Serializable, projectFilesUpload>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			projectFilesUpload projectFilesUpload = fetchByPrimaryKey(primaryKey);

			if (projectFilesUpload != null) {
				map.put(primaryKey, projectFilesUpload);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
					projectFilesUploadImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (projectFilesUpload)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTFILESUPLOAD_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (projectFilesUpload projectFilesUpload : (List<projectFilesUpload>)q.list()) {
				map.put(projectFilesUpload.getPrimaryKeyObj(),
					projectFilesUpload);

				cacheResult(projectFilesUpload);

				uncachedPrimaryKeys.remove(projectFilesUpload.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(projectFilesUploadModelImpl.ENTITY_CACHE_ENABLED,
					projectFilesUploadImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the project files uploads.
	 *
	 * @return the project files uploads
	 */
	@Override
	public List<projectFilesUpload> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<projectFilesUpload> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<projectFilesUpload> findAll(int start, int end,
		OrderByComparator<projectFilesUpload> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<projectFilesUpload> findAll(int start, int end,
		OrderByComparator<projectFilesUpload> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<projectFilesUpload> list = null;

		if (retrieveFromCache) {
			list = (List<projectFilesUpload>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTFILESUPLOAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTFILESUPLOAD;

				if (pagination) {
					sql = sql.concat(projectFilesUploadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<projectFilesUpload>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<projectFilesUpload>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the project files uploads from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (projectFilesUpload projectFilesUpload : findAll()) {
			remove(projectFilesUpload);
		}
	}

	/**
	 * Returns the number of project files uploads.
	 *
	 * @return the number of project files uploads
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTFILESUPLOAD);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return projectFilesUploadModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project files upload persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(projectFilesUploadImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTFILESUPLOAD = "SELECT projectFilesUpload FROM projectFilesUpload projectFilesUpload";
	private static final String _SQL_SELECT_PROJECTFILESUPLOAD_WHERE_PKS_IN = "SELECT projectFilesUpload FROM projectFilesUpload projectFilesUpload WHERE PK_projectFileId IN (";
	private static final String _SQL_COUNT_PROJECTFILESUPLOAD = "SELECT COUNT(projectFilesUpload) FROM projectFilesUpload projectFilesUpload";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectFilesUpload.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No projectFilesUpload exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(projectFilesUploadPersistenceImpl.class);
}