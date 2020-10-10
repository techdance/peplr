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

import com.collaborated.entity.exception.NoSuchprojectFolderUploadException;
import com.collaborated.entity.model.impl.projectFolderUploadImpl;
import com.collaborated.entity.model.impl.projectFolderUploadModelImpl;
import com.collaborated.entity.model.projectFolderUpload;
import com.collaborated.entity.service.persistence.projectFolderUploadPersistence;

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
 * The persistence implementation for the project folder upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectFolderUploadPersistence
 * @see com.collaborated.entity.service.persistence.projectFolderUploadUtil
 * @generated
 */
@ProviderType
public class projectFolderUploadPersistenceImpl extends BasePersistenceImpl<projectFolderUpload>
	implements projectFolderUploadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link projectFolderUploadUtil} to access the project folder upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = projectFolderUploadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFolderUploadModelImpl.FINDER_CACHE_ENABLED,
			projectFolderUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFolderUploadModelImpl.FINDER_CACHE_ENABLED,
			projectFolderUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFolderUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public projectFolderUploadPersistenceImpl() {
		setModelClass(projectFolderUpload.class);
	}

	/**
	 * Caches the project folder upload in the entity cache if it is enabled.
	 *
	 * @param projectFolderUpload the project folder upload
	 */
	@Override
	public void cacheResult(projectFolderUpload projectFolderUpload) {
		entityCache.putResult(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFolderUploadImpl.class, projectFolderUpload.getPrimaryKey(),
			projectFolderUpload);

		projectFolderUpload.resetOriginalValues();
	}

	/**
	 * Caches the project folder uploads in the entity cache if it is enabled.
	 *
	 * @param projectFolderUploads the project folder uploads
	 */
	@Override
	public void cacheResult(List<projectFolderUpload> projectFolderUploads) {
		for (projectFolderUpload projectFolderUpload : projectFolderUploads) {
			if (entityCache.getResult(
						projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
						projectFolderUploadImpl.class,
						projectFolderUpload.getPrimaryKey()) == null) {
				cacheResult(projectFolderUpload);
			}
			else {
				projectFolderUpload.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project folder uploads.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(projectFolderUploadImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project folder upload.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(projectFolderUpload projectFolderUpload) {
		entityCache.removeResult(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFolderUploadImpl.class, projectFolderUpload.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<projectFolderUpload> projectFolderUploads) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (projectFolderUpload projectFolderUpload : projectFolderUploads) {
			entityCache.removeResult(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
				projectFolderUploadImpl.class,
				projectFolderUpload.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project folder upload with the primary key. Does not add the project folder upload to the database.
	 *
	 * @param PK_projectFolderId the primary key for the new project folder upload
	 * @return the new project folder upload
	 */
	@Override
	public projectFolderUpload create(long PK_projectFolderId) {
		projectFolderUpload projectFolderUpload = new projectFolderUploadImpl();

		projectFolderUpload.setNew(true);
		projectFolderUpload.setPrimaryKey(PK_projectFolderId);

		return projectFolderUpload;
	}

	/**
	 * Removes the project folder upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_projectFolderId the primary key of the project folder upload
	 * @return the project folder upload that was removed
	 * @throws NoSuchprojectFolderUploadException if a project folder upload with the primary key could not be found
	 */
	@Override
	public projectFolderUpload remove(long PK_projectFolderId)
		throws NoSuchprojectFolderUploadException {
		return remove((Serializable)PK_projectFolderId);
	}

	/**
	 * Removes the project folder upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project folder upload
	 * @return the project folder upload that was removed
	 * @throws NoSuchprojectFolderUploadException if a project folder upload with the primary key could not be found
	 */
	@Override
	public projectFolderUpload remove(Serializable primaryKey)
		throws NoSuchprojectFolderUploadException {
		Session session = null;

		try {
			session = openSession();

			projectFolderUpload projectFolderUpload = (projectFolderUpload)session.get(projectFolderUploadImpl.class,
					primaryKey);

			if (projectFolderUpload == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchprojectFolderUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectFolderUpload);
		}
		catch (NoSuchprojectFolderUploadException nsee) {
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
	protected projectFolderUpload removeImpl(
		projectFolderUpload projectFolderUpload) {
		projectFolderUpload = toUnwrappedModel(projectFolderUpload);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectFolderUpload)) {
				projectFolderUpload = (projectFolderUpload)session.get(projectFolderUploadImpl.class,
						projectFolderUpload.getPrimaryKeyObj());
			}

			if (projectFolderUpload != null) {
				session.delete(projectFolderUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectFolderUpload != null) {
			clearCache(projectFolderUpload);
		}

		return projectFolderUpload;
	}

	@Override
	public projectFolderUpload updateImpl(
		projectFolderUpload projectFolderUpload) {
		projectFolderUpload = toUnwrappedModel(projectFolderUpload);

		boolean isNew = projectFolderUpload.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projectFolderUpload.isNew()) {
				session.save(projectFolderUpload);

				projectFolderUpload.setNew(false);
			}
			else {
				projectFolderUpload = (projectFolderUpload)session.merge(projectFolderUpload);
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

		entityCache.putResult(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
			projectFolderUploadImpl.class, projectFolderUpload.getPrimaryKey(),
			projectFolderUpload, false);

		projectFolderUpload.resetOriginalValues();

		return projectFolderUpload;
	}

	protected projectFolderUpload toUnwrappedModel(
		projectFolderUpload projectFolderUpload) {
		if (projectFolderUpload instanceof projectFolderUploadImpl) {
			return projectFolderUpload;
		}

		projectFolderUploadImpl projectFolderUploadImpl = new projectFolderUploadImpl();

		projectFolderUploadImpl.setNew(projectFolderUpload.isNew());
		projectFolderUploadImpl.setPrimaryKey(projectFolderUpload.getPrimaryKey());

		projectFolderUploadImpl.setPK_projectFolderId(projectFolderUpload.getPK_projectFolderId());
		projectFolderUploadImpl.setGroupId(projectFolderUpload.getGroupId());
		projectFolderUploadImpl.setCreatedOn(projectFolderUpload.getCreatedOn());
		projectFolderUploadImpl.setDeletedOn(projectFolderUpload.getDeletedOn());
		projectFolderUploadImpl.setInterestId(projectFolderUpload.getInterestId());
		projectFolderUploadImpl.setProjectId(projectFolderUpload.getProjectId());
		projectFolderUploadImpl.setUserId(projectFolderUpload.getUserId());
		projectFolderUploadImpl.setDeletedBy(projectFolderUpload.getDeletedBy());
		projectFolderUploadImpl.setParentFolderId(projectFolderUpload.getParentFolderId());
		projectFolderUploadImpl.setFolderId(projectFolderUpload.getFolderId());
		projectFolderUploadImpl.setFolderName(projectFolderUpload.getFolderName());
		projectFolderUploadImpl.setDescription(projectFolderUpload.getDescription());

		return projectFolderUploadImpl;
	}

	/**
	 * Returns the project folder upload with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project folder upload
	 * @return the project folder upload
	 * @throws NoSuchprojectFolderUploadException if a project folder upload with the primary key could not be found
	 */
	@Override
	public projectFolderUpload findByPrimaryKey(Serializable primaryKey)
		throws NoSuchprojectFolderUploadException {
		projectFolderUpload projectFolderUpload = fetchByPrimaryKey(primaryKey);

		if (projectFolderUpload == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchprojectFolderUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectFolderUpload;
	}

	/**
	 * Returns the project folder upload with the primary key or throws a {@link NoSuchprojectFolderUploadException} if it could not be found.
	 *
	 * @param PK_projectFolderId the primary key of the project folder upload
	 * @return the project folder upload
	 * @throws NoSuchprojectFolderUploadException if a project folder upload with the primary key could not be found
	 */
	@Override
	public projectFolderUpload findByPrimaryKey(long PK_projectFolderId)
		throws NoSuchprojectFolderUploadException {
		return findByPrimaryKey((Serializable)PK_projectFolderId);
	}

	/**
	 * Returns the project folder upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project folder upload
	 * @return the project folder upload, or <code>null</code> if a project folder upload with the primary key could not be found
	 */
	@Override
	public projectFolderUpload fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
				projectFolderUploadImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		projectFolderUpload projectFolderUpload = (projectFolderUpload)serializable;

		if (projectFolderUpload == null) {
			Session session = null;

			try {
				session = openSession();

				projectFolderUpload = (projectFolderUpload)session.get(projectFolderUploadImpl.class,
						primaryKey);

				if (projectFolderUpload != null) {
					cacheResult(projectFolderUpload);
				}
				else {
					entityCache.putResult(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
						projectFolderUploadImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
					projectFolderUploadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectFolderUpload;
	}

	/**
	 * Returns the project folder upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_projectFolderId the primary key of the project folder upload
	 * @return the project folder upload, or <code>null</code> if a project folder upload with the primary key could not be found
	 */
	@Override
	public projectFolderUpload fetchByPrimaryKey(long PK_projectFolderId) {
		return fetchByPrimaryKey((Serializable)PK_projectFolderId);
	}

	@Override
	public Map<Serializable, projectFolderUpload> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, projectFolderUpload> map = new HashMap<Serializable, projectFolderUpload>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			projectFolderUpload projectFolderUpload = fetchByPrimaryKey(primaryKey);

			if (projectFolderUpload != null) {
				map.put(primaryKey, projectFolderUpload);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
					projectFolderUploadImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (projectFolderUpload)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTFOLDERUPLOAD_WHERE_PKS_IN);

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

			for (projectFolderUpload projectFolderUpload : (List<projectFolderUpload>)q.list()) {
				map.put(projectFolderUpload.getPrimaryKeyObj(),
					projectFolderUpload);

				cacheResult(projectFolderUpload);

				uncachedPrimaryKeys.remove(projectFolderUpload.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(projectFolderUploadModelImpl.ENTITY_CACHE_ENABLED,
					projectFolderUploadImpl.class, primaryKey, nullModel);
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
	 * Returns all the project folder uploads.
	 *
	 * @return the project folder uploads
	 */
	@Override
	public List<projectFolderUpload> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project folder uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectFolderUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project folder uploads
	 * @param end the upper bound of the range of project folder uploads (not inclusive)
	 * @return the range of project folder uploads
	 */
	@Override
	public List<projectFolderUpload> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project folder uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectFolderUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project folder uploads
	 * @param end the upper bound of the range of project folder uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project folder uploads
	 */
	@Override
	public List<projectFolderUpload> findAll(int start, int end,
		OrderByComparator<projectFolderUpload> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project folder uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectFolderUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project folder uploads
	 * @param end the upper bound of the range of project folder uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project folder uploads
	 */
	@Override
	public List<projectFolderUpload> findAll(int start, int end,
		OrderByComparator<projectFolderUpload> orderByComparator,
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

		List<projectFolderUpload> list = null;

		if (retrieveFromCache) {
			list = (List<projectFolderUpload>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTFOLDERUPLOAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTFOLDERUPLOAD;

				if (pagination) {
					sql = sql.concat(projectFolderUploadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<projectFolderUpload>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<projectFolderUpload>)QueryUtil.list(q,
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
	 * Removes all the project folder uploads from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (projectFolderUpload projectFolderUpload : findAll()) {
			remove(projectFolderUpload);
		}
	}

	/**
	 * Returns the number of project folder uploads.
	 *
	 * @return the number of project folder uploads
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTFOLDERUPLOAD);

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
		return projectFolderUploadModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project folder upload persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(projectFolderUploadImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTFOLDERUPLOAD = "SELECT projectFolderUpload FROM projectFolderUpload projectFolderUpload";
	private static final String _SQL_SELECT_PROJECTFOLDERUPLOAD_WHERE_PKS_IN = "SELECT projectFolderUpload FROM projectFolderUpload projectFolderUpload WHERE PK_projectFolderId IN (";
	private static final String _SQL_COUNT_PROJECTFOLDERUPLOAD = "SELECT COUNT(projectFolderUpload) FROM projectFolderUpload projectFolderUpload";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectFolderUpload.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No projectFolderUpload exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(projectFolderUploadPersistenceImpl.class);
}