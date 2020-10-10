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

import com.collaborated.entity.exception.NoSuchCustom_WorkflowLogException;
import com.collaborated.entity.model.Custom_WorkflowLog;
import com.collaborated.entity.model.impl.Custom_WorkflowLogImpl;
import com.collaborated.entity.model.impl.Custom_WorkflowLogModelImpl;
import com.collaborated.entity.service.persistence.Custom_WorkflowLogPersistence;

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
 * The persistence implementation for the custom_ workflow log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowLogPersistence
 * @see com.collaborated.entity.service.persistence.Custom_WorkflowLogUtil
 * @generated
 */
@ProviderType
public class Custom_WorkflowLogPersistenceImpl extends BasePersistenceImpl<Custom_WorkflowLog>
	implements Custom_WorkflowLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Custom_WorkflowLogUtil} to access the custom_ workflow log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Custom_WorkflowLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowLogModelImpl.FINDER_CACHE_ENABLED,
			Custom_WorkflowLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowLogModelImpl.FINDER_CACHE_ENABLED,
			Custom_WorkflowLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Custom_WorkflowLogPersistenceImpl() {
		setModelClass(Custom_WorkflowLog.class);
	}

	/**
	 * Caches the custom_ workflow log in the entity cache if it is enabled.
	 *
	 * @param custom_WorkflowLog the custom_ workflow log
	 */
	@Override
	public void cacheResult(Custom_WorkflowLog custom_WorkflowLog) {
		entityCache.putResult(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowLogImpl.class, custom_WorkflowLog.getPrimaryKey(),
			custom_WorkflowLog);

		custom_WorkflowLog.resetOriginalValues();
	}

	/**
	 * Caches the custom_ workflow logs in the entity cache if it is enabled.
	 *
	 * @param custom_WorkflowLogs the custom_ workflow logs
	 */
	@Override
	public void cacheResult(List<Custom_WorkflowLog> custom_WorkflowLogs) {
		for (Custom_WorkflowLog custom_WorkflowLog : custom_WorkflowLogs) {
			if (entityCache.getResult(
						Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
						Custom_WorkflowLogImpl.class,
						custom_WorkflowLog.getPrimaryKey()) == null) {
				cacheResult(custom_WorkflowLog);
			}
			else {
				custom_WorkflowLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom_ workflow logs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Custom_WorkflowLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom_ workflow log.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Custom_WorkflowLog custom_WorkflowLog) {
		entityCache.removeResult(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowLogImpl.class, custom_WorkflowLog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Custom_WorkflowLog> custom_WorkflowLogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Custom_WorkflowLog custom_WorkflowLog : custom_WorkflowLogs) {
			entityCache.removeResult(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
				Custom_WorkflowLogImpl.class, custom_WorkflowLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom_ workflow log with the primary key. Does not add the custom_ workflow log to the database.
	 *
	 * @param logId the primary key for the new custom_ workflow log
	 * @return the new custom_ workflow log
	 */
	@Override
	public Custom_WorkflowLog create(long logId) {
		Custom_WorkflowLog custom_WorkflowLog = new Custom_WorkflowLogImpl();

		custom_WorkflowLog.setNew(true);
		custom_WorkflowLog.setPrimaryKey(logId);

		return custom_WorkflowLog;
	}

	/**
	 * Removes the custom_ workflow log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the custom_ workflow log
	 * @return the custom_ workflow log that was removed
	 * @throws NoSuchCustom_WorkflowLogException if a custom_ workflow log with the primary key could not be found
	 */
	@Override
	public Custom_WorkflowLog remove(long logId)
		throws NoSuchCustom_WorkflowLogException {
		return remove((Serializable)logId);
	}

	/**
	 * Removes the custom_ workflow log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom_ workflow log
	 * @return the custom_ workflow log that was removed
	 * @throws NoSuchCustom_WorkflowLogException if a custom_ workflow log with the primary key could not be found
	 */
	@Override
	public Custom_WorkflowLog remove(Serializable primaryKey)
		throws NoSuchCustom_WorkflowLogException {
		Session session = null;

		try {
			session = openSession();

			Custom_WorkflowLog custom_WorkflowLog = (Custom_WorkflowLog)session.get(Custom_WorkflowLogImpl.class,
					primaryKey);

			if (custom_WorkflowLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustom_WorkflowLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(custom_WorkflowLog);
		}
		catch (NoSuchCustom_WorkflowLogException nsee) {
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
	protected Custom_WorkflowLog removeImpl(
		Custom_WorkflowLog custom_WorkflowLog) {
		custom_WorkflowLog = toUnwrappedModel(custom_WorkflowLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(custom_WorkflowLog)) {
				custom_WorkflowLog = (Custom_WorkflowLog)session.get(Custom_WorkflowLogImpl.class,
						custom_WorkflowLog.getPrimaryKeyObj());
			}

			if (custom_WorkflowLog != null) {
				session.delete(custom_WorkflowLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (custom_WorkflowLog != null) {
			clearCache(custom_WorkflowLog);
		}

		return custom_WorkflowLog;
	}

	@Override
	public Custom_WorkflowLog updateImpl(Custom_WorkflowLog custom_WorkflowLog) {
		custom_WorkflowLog = toUnwrappedModel(custom_WorkflowLog);

		boolean isNew = custom_WorkflowLog.isNew();

		Session session = null;

		try {
			session = openSession();

			if (custom_WorkflowLog.isNew()) {
				session.save(custom_WorkflowLog);

				custom_WorkflowLog.setNew(false);
			}
			else {
				custom_WorkflowLog = (Custom_WorkflowLog)session.merge(custom_WorkflowLog);
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

		entityCache.putResult(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowLogImpl.class, custom_WorkflowLog.getPrimaryKey(),
			custom_WorkflowLog, false);

		custom_WorkflowLog.resetOriginalValues();

		return custom_WorkflowLog;
	}

	protected Custom_WorkflowLog toUnwrappedModel(
		Custom_WorkflowLog custom_WorkflowLog) {
		if (custom_WorkflowLog instanceof Custom_WorkflowLogImpl) {
			return custom_WorkflowLog;
		}

		Custom_WorkflowLogImpl custom_WorkflowLogImpl = new Custom_WorkflowLogImpl();

		custom_WorkflowLogImpl.setNew(custom_WorkflowLog.isNew());
		custom_WorkflowLogImpl.setPrimaryKey(custom_WorkflowLog.getPrimaryKey());

		custom_WorkflowLogImpl.setLogId(custom_WorkflowLog.getLogId());
		custom_WorkflowLogImpl.setTrackingId(custom_WorkflowLog.getTrackingId());
		custom_WorkflowLogImpl.setWorkflowId(custom_WorkflowLog.getWorkflowId());
		custom_WorkflowLogImpl.setWorkflowTaskId(custom_WorkflowLog.getWorkflowTaskId());
		custom_WorkflowLogImpl.setTrasitionId(custom_WorkflowLog.getTrasitionId());
		custom_WorkflowLogImpl.setLogDescription(custom_WorkflowLog.getLogDescription());
		custom_WorkflowLogImpl.setComments(custom_WorkflowLog.getComments());
		custom_WorkflowLogImpl.setAssigneeClassPK(custom_WorkflowLog.getAssigneeClassPK());
		custom_WorkflowLogImpl.setClassName(custom_WorkflowLog.getClassName());
		custom_WorkflowLogImpl.setAssignedDate(custom_WorkflowLog.getAssignedDate());
		custom_WorkflowLogImpl.setCompletedDate(custom_WorkflowLog.getCompletedDate());
		custom_WorkflowLogImpl.setCreatedBy(custom_WorkflowLog.getCreatedBy());
		custom_WorkflowLogImpl.setCreatedDate(custom_WorkflowLog.getCreatedDate());

		return custom_WorkflowLogImpl;
	}

	/**
	 * Returns the custom_ workflow log with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow log
	 * @return the custom_ workflow log
	 * @throws NoSuchCustom_WorkflowLogException if a custom_ workflow log with the primary key could not be found
	 */
	@Override
	public Custom_WorkflowLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustom_WorkflowLogException {
		Custom_WorkflowLog custom_WorkflowLog = fetchByPrimaryKey(primaryKey);

		if (custom_WorkflowLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustom_WorkflowLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return custom_WorkflowLog;
	}

	/**
	 * Returns the custom_ workflow log with the primary key or throws a {@link NoSuchCustom_WorkflowLogException} if it could not be found.
	 *
	 * @param logId the primary key of the custom_ workflow log
	 * @return the custom_ workflow log
	 * @throws NoSuchCustom_WorkflowLogException if a custom_ workflow log with the primary key could not be found
	 */
	@Override
	public Custom_WorkflowLog findByPrimaryKey(long logId)
		throws NoSuchCustom_WorkflowLogException {
		return findByPrimaryKey((Serializable)logId);
	}

	/**
	 * Returns the custom_ workflow log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow log
	 * @return the custom_ workflow log, or <code>null</code> if a custom_ workflow log with the primary key could not be found
	 */
	@Override
	public Custom_WorkflowLog fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
				Custom_WorkflowLogImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Custom_WorkflowLog custom_WorkflowLog = (Custom_WorkflowLog)serializable;

		if (custom_WorkflowLog == null) {
			Session session = null;

			try {
				session = openSession();

				custom_WorkflowLog = (Custom_WorkflowLog)session.get(Custom_WorkflowLogImpl.class,
						primaryKey);

				if (custom_WorkflowLog != null) {
					cacheResult(custom_WorkflowLog);
				}
				else {
					entityCache.putResult(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
						Custom_WorkflowLogImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
					Custom_WorkflowLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return custom_WorkflowLog;
	}

	/**
	 * Returns the custom_ workflow log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param logId the primary key of the custom_ workflow log
	 * @return the custom_ workflow log, or <code>null</code> if a custom_ workflow log with the primary key could not be found
	 */
	@Override
	public Custom_WorkflowLog fetchByPrimaryKey(long logId) {
		return fetchByPrimaryKey((Serializable)logId);
	}

	@Override
	public Map<Serializable, Custom_WorkflowLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Custom_WorkflowLog> map = new HashMap<Serializable, Custom_WorkflowLog>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Custom_WorkflowLog custom_WorkflowLog = fetchByPrimaryKey(primaryKey);

			if (custom_WorkflowLog != null) {
				map.put(primaryKey, custom_WorkflowLog);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
					Custom_WorkflowLogImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Custom_WorkflowLog)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOM_WORKFLOWLOG_WHERE_PKS_IN);

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

			for (Custom_WorkflowLog custom_WorkflowLog : (List<Custom_WorkflowLog>)q.list()) {
				map.put(custom_WorkflowLog.getPrimaryKeyObj(),
					custom_WorkflowLog);

				cacheResult(custom_WorkflowLog);

				uncachedPrimaryKeys.remove(custom_WorkflowLog.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Custom_WorkflowLogModelImpl.ENTITY_CACHE_ENABLED,
					Custom_WorkflowLogImpl.class, primaryKey, nullModel);
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
	 * Returns all the custom_ workflow logs.
	 *
	 * @return the custom_ workflow logs
	 */
	@Override
	public List<Custom_WorkflowLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the custom_ workflow logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow logs
	 * @param end the upper bound of the range of custom_ workflow logs (not inclusive)
	 * @return the range of custom_ workflow logs
	 */
	@Override
	public List<Custom_WorkflowLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the custom_ workflow logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow logs
	 * @param end the upper bound of the range of custom_ workflow logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom_ workflow logs
	 */
	@Override
	public List<Custom_WorkflowLog> findAll(int start, int end,
		OrderByComparator<Custom_WorkflowLog> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the custom_ workflow logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow logs
	 * @param end the upper bound of the range of custom_ workflow logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of custom_ workflow logs
	 */
	@Override
	public List<Custom_WorkflowLog> findAll(int start, int end,
		OrderByComparator<Custom_WorkflowLog> orderByComparator,
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

		List<Custom_WorkflowLog> list = null;

		if (retrieveFromCache) {
			list = (List<Custom_WorkflowLog>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOM_WORKFLOWLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOM_WORKFLOWLOG;

				if (pagination) {
					sql = sql.concat(Custom_WorkflowLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Custom_WorkflowLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Custom_WorkflowLog>)QueryUtil.list(q,
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
	 * Removes all the custom_ workflow logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Custom_WorkflowLog custom_WorkflowLog : findAll()) {
			remove(custom_WorkflowLog);
		}
	}

	/**
	 * Returns the number of custom_ workflow logs.
	 *
	 * @return the number of custom_ workflow logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOM_WORKFLOWLOG);

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
		return Custom_WorkflowLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom_ workflow log persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Custom_WorkflowLogImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOM_WORKFLOWLOG = "SELECT custom_WorkflowLog FROM Custom_WorkflowLog custom_WorkflowLog";
	private static final String _SQL_SELECT_CUSTOM_WORKFLOWLOG_WHERE_PKS_IN = "SELECT custom_WorkflowLog FROM Custom_WorkflowLog custom_WorkflowLog WHERE logId IN (";
	private static final String _SQL_COUNT_CUSTOM_WORKFLOWLOG = "SELECT COUNT(custom_WorkflowLog) FROM Custom_WorkflowLog custom_WorkflowLog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "custom_WorkflowLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Custom_WorkflowLog exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(Custom_WorkflowLogPersistenceImpl.class);
}