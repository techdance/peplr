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

import com.collaborated.entity.exception.NoSuchprojectDiscussionException;
import com.collaborated.entity.model.impl.projectDiscussionImpl;
import com.collaborated.entity.model.impl.projectDiscussionModelImpl;
import com.collaborated.entity.model.projectDiscussion;
import com.collaborated.entity.service.persistence.projectDiscussionPersistence;

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
 * The persistence implementation for the project discussion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectDiscussionPersistence
 * @see com.collaborated.entity.service.persistence.projectDiscussionUtil
 * @generated
 */
@ProviderType
public class projectDiscussionPersistenceImpl extends BasePersistenceImpl<projectDiscussion>
	implements projectDiscussionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link projectDiscussionUtil} to access the project discussion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = projectDiscussionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			projectDiscussionModelImpl.FINDER_CACHE_ENABLED,
			projectDiscussionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			projectDiscussionModelImpl.FINDER_CACHE_ENABLED,
			projectDiscussionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			projectDiscussionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public projectDiscussionPersistenceImpl() {
		setModelClass(projectDiscussion.class);
	}

	/**
	 * Caches the project discussion in the entity cache if it is enabled.
	 *
	 * @param projectDiscussion the project discussion
	 */
	@Override
	public void cacheResult(projectDiscussion projectDiscussion) {
		entityCache.putResult(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			projectDiscussionImpl.class, projectDiscussion.getPrimaryKey(),
			projectDiscussion);

		projectDiscussion.resetOriginalValues();
	}

	/**
	 * Caches the project discussions in the entity cache if it is enabled.
	 *
	 * @param projectDiscussions the project discussions
	 */
	@Override
	public void cacheResult(List<projectDiscussion> projectDiscussions) {
		for (projectDiscussion projectDiscussion : projectDiscussions) {
			if (entityCache.getResult(
						projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
						projectDiscussionImpl.class,
						projectDiscussion.getPrimaryKey()) == null) {
				cacheResult(projectDiscussion);
			}
			else {
				projectDiscussion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project discussions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(projectDiscussionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project discussion.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(projectDiscussion projectDiscussion) {
		entityCache.removeResult(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			projectDiscussionImpl.class, projectDiscussion.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<projectDiscussion> projectDiscussions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (projectDiscussion projectDiscussion : projectDiscussions) {
			entityCache.removeResult(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
				projectDiscussionImpl.class, projectDiscussion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project discussion with the primary key. Does not add the project discussion to the database.
	 *
	 * @param PK_projectDiscussionId the primary key for the new project discussion
	 * @return the new project discussion
	 */
	@Override
	public projectDiscussion create(long PK_projectDiscussionId) {
		projectDiscussion projectDiscussion = new projectDiscussionImpl();

		projectDiscussion.setNew(true);
		projectDiscussion.setPrimaryKey(PK_projectDiscussionId);

		return projectDiscussion;
	}

	/**
	 * Removes the project discussion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_projectDiscussionId the primary key of the project discussion
	 * @return the project discussion that was removed
	 * @throws NoSuchprojectDiscussionException if a project discussion with the primary key could not be found
	 */
	@Override
	public projectDiscussion remove(long PK_projectDiscussionId)
		throws NoSuchprojectDiscussionException {
		return remove((Serializable)PK_projectDiscussionId);
	}

	/**
	 * Removes the project discussion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project discussion
	 * @return the project discussion that was removed
	 * @throws NoSuchprojectDiscussionException if a project discussion with the primary key could not be found
	 */
	@Override
	public projectDiscussion remove(Serializable primaryKey)
		throws NoSuchprojectDiscussionException {
		Session session = null;

		try {
			session = openSession();

			projectDiscussion projectDiscussion = (projectDiscussion)session.get(projectDiscussionImpl.class,
					primaryKey);

			if (projectDiscussion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchprojectDiscussionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectDiscussion);
		}
		catch (NoSuchprojectDiscussionException nsee) {
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
	protected projectDiscussion removeImpl(projectDiscussion projectDiscussion) {
		projectDiscussion = toUnwrappedModel(projectDiscussion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectDiscussion)) {
				projectDiscussion = (projectDiscussion)session.get(projectDiscussionImpl.class,
						projectDiscussion.getPrimaryKeyObj());
			}

			if (projectDiscussion != null) {
				session.delete(projectDiscussion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectDiscussion != null) {
			clearCache(projectDiscussion);
		}

		return projectDiscussion;
	}

	@Override
	public projectDiscussion updateImpl(projectDiscussion projectDiscussion) {
		projectDiscussion = toUnwrappedModel(projectDiscussion);

		boolean isNew = projectDiscussion.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projectDiscussion.isNew()) {
				session.save(projectDiscussion);

				projectDiscussion.setNew(false);
			}
			else {
				projectDiscussion = (projectDiscussion)session.merge(projectDiscussion);
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

		entityCache.putResult(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
			projectDiscussionImpl.class, projectDiscussion.getPrimaryKey(),
			projectDiscussion, false);

		projectDiscussion.resetOriginalValues();

		return projectDiscussion;
	}

	protected projectDiscussion toUnwrappedModel(
		projectDiscussion projectDiscussion) {
		if (projectDiscussion instanceof projectDiscussionImpl) {
			return projectDiscussion;
		}

		projectDiscussionImpl projectDiscussionImpl = new projectDiscussionImpl();

		projectDiscussionImpl.setNew(projectDiscussion.isNew());
		projectDiscussionImpl.setPrimaryKey(projectDiscussion.getPrimaryKey());

		projectDiscussionImpl.setPK_projectDiscussionId(projectDiscussion.getPK_projectDiscussionId());
		projectDiscussionImpl.setGroupId(projectDiscussion.getGroupId());
		projectDiscussionImpl.setCreatedOn(projectDiscussion.getCreatedOn());
		projectDiscussionImpl.setModifiedDate(projectDiscussion.getModifiedDate());
		projectDiscussionImpl.setInterestId(projectDiscussion.getInterestId());
		projectDiscussionImpl.setProjectId(projectDiscussion.getProjectId());
		projectDiscussionImpl.setSenderId(projectDiscussion.getSenderId());
		projectDiscussionImpl.setDescription(projectDiscussion.getDescription());
		projectDiscussionImpl.setFileEntryId(projectDiscussion.getFileEntryId());
		projectDiscussionImpl.setImageUrl(projectDiscussion.getImageUrl());

		return projectDiscussionImpl;
	}

	/**
	 * Returns the project discussion with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project discussion
	 * @return the project discussion
	 * @throws NoSuchprojectDiscussionException if a project discussion with the primary key could not be found
	 */
	@Override
	public projectDiscussion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchprojectDiscussionException {
		projectDiscussion projectDiscussion = fetchByPrimaryKey(primaryKey);

		if (projectDiscussion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchprojectDiscussionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectDiscussion;
	}

	/**
	 * Returns the project discussion with the primary key or throws a {@link NoSuchprojectDiscussionException} if it could not be found.
	 *
	 * @param PK_projectDiscussionId the primary key of the project discussion
	 * @return the project discussion
	 * @throws NoSuchprojectDiscussionException if a project discussion with the primary key could not be found
	 */
	@Override
	public projectDiscussion findByPrimaryKey(long PK_projectDiscussionId)
		throws NoSuchprojectDiscussionException {
		return findByPrimaryKey((Serializable)PK_projectDiscussionId);
	}

	/**
	 * Returns the project discussion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project discussion
	 * @return the project discussion, or <code>null</code> if a project discussion with the primary key could not be found
	 */
	@Override
	public projectDiscussion fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
				projectDiscussionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		projectDiscussion projectDiscussion = (projectDiscussion)serializable;

		if (projectDiscussion == null) {
			Session session = null;

			try {
				session = openSession();

				projectDiscussion = (projectDiscussion)session.get(projectDiscussionImpl.class,
						primaryKey);

				if (projectDiscussion != null) {
					cacheResult(projectDiscussion);
				}
				else {
					entityCache.putResult(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
						projectDiscussionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
					projectDiscussionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectDiscussion;
	}

	/**
	 * Returns the project discussion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_projectDiscussionId the primary key of the project discussion
	 * @return the project discussion, or <code>null</code> if a project discussion with the primary key could not be found
	 */
	@Override
	public projectDiscussion fetchByPrimaryKey(long PK_projectDiscussionId) {
		return fetchByPrimaryKey((Serializable)PK_projectDiscussionId);
	}

	@Override
	public Map<Serializable, projectDiscussion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, projectDiscussion> map = new HashMap<Serializable, projectDiscussion>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			projectDiscussion projectDiscussion = fetchByPrimaryKey(primaryKey);

			if (projectDiscussion != null) {
				map.put(primaryKey, projectDiscussion);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
					projectDiscussionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (projectDiscussion)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTDISCUSSION_WHERE_PKS_IN);

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

			for (projectDiscussion projectDiscussion : (List<projectDiscussion>)q.list()) {
				map.put(projectDiscussion.getPrimaryKeyObj(), projectDiscussion);

				cacheResult(projectDiscussion);

				uncachedPrimaryKeys.remove(projectDiscussion.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(projectDiscussionModelImpl.ENTITY_CACHE_ENABLED,
					projectDiscussionImpl.class, primaryKey, nullModel);
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
	 * Returns all the project discussions.
	 *
	 * @return the project discussions
	 */
	@Override
	public List<projectDiscussion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project discussions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project discussions
	 * @param end the upper bound of the range of project discussions (not inclusive)
	 * @return the range of project discussions
	 */
	@Override
	public List<projectDiscussion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project discussions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project discussions
	 * @param end the upper bound of the range of project discussions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project discussions
	 */
	@Override
	public List<projectDiscussion> findAll(int start, int end,
		OrderByComparator<projectDiscussion> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project discussions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectDiscussionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project discussions
	 * @param end the upper bound of the range of project discussions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project discussions
	 */
	@Override
	public List<projectDiscussion> findAll(int start, int end,
		OrderByComparator<projectDiscussion> orderByComparator,
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

		List<projectDiscussion> list = null;

		if (retrieveFromCache) {
			list = (List<projectDiscussion>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTDISCUSSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTDISCUSSION;

				if (pagination) {
					sql = sql.concat(projectDiscussionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<projectDiscussion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<projectDiscussion>)QueryUtil.list(q,
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
	 * Removes all the project discussions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (projectDiscussion projectDiscussion : findAll()) {
			remove(projectDiscussion);
		}
	}

	/**
	 * Returns the number of project discussions.
	 *
	 * @return the number of project discussions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTDISCUSSION);

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
		return projectDiscussionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project discussion persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(projectDiscussionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTDISCUSSION = "SELECT projectDiscussion FROM projectDiscussion projectDiscussion";
	private static final String _SQL_SELECT_PROJECTDISCUSSION_WHERE_PKS_IN = "SELECT projectDiscussion FROM projectDiscussion projectDiscussion WHERE PK_projectDiscussionId IN (";
	private static final String _SQL_COUNT_PROJECTDISCUSSION = "SELECT COUNT(projectDiscussion) FROM projectDiscussion projectDiscussion";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectDiscussion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No projectDiscussion exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(projectDiscussionPersistenceImpl.class);
}