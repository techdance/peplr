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

import com.collaborated.entity.exception.NoSuchapplicationLogException;
import com.collaborated.entity.model.applicationLog;
import com.collaborated.entity.model.impl.applicationLogImpl;
import com.collaborated.entity.model.impl.applicationLogModelImpl;
import com.collaborated.entity.service.persistence.applicationLogPersistence;

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
 * The persistence implementation for the application log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see applicationLogPersistence
 * @see com.collaborated.entity.service.persistence.applicationLogUtil
 * @generated
 */
@ProviderType
public class applicationLogPersistenceImpl extends BasePersistenceImpl<applicationLog>
	implements applicationLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link applicationLogUtil} to access the application log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = applicationLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
			applicationLogModelImpl.FINDER_CACHE_ENABLED,
			applicationLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
			applicationLogModelImpl.FINDER_CACHE_ENABLED,
			applicationLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
			applicationLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public applicationLogPersistenceImpl() {
		setModelClass(applicationLog.class);
	}

	/**
	 * Caches the application log in the entity cache if it is enabled.
	 *
	 * @param applicationLog the application log
	 */
	@Override
	public void cacheResult(applicationLog applicationLog) {
		entityCache.putResult(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
			applicationLogImpl.class, applicationLog.getPrimaryKey(),
			applicationLog);

		applicationLog.resetOriginalValues();
	}

	/**
	 * Caches the application logs in the entity cache if it is enabled.
	 *
	 * @param applicationLogs the application logs
	 */
	@Override
	public void cacheResult(List<applicationLog> applicationLogs) {
		for (applicationLog applicationLog : applicationLogs) {
			if (entityCache.getResult(
						applicationLogModelImpl.ENTITY_CACHE_ENABLED,
						applicationLogImpl.class, applicationLog.getPrimaryKey()) == null) {
				cacheResult(applicationLog);
			}
			else {
				applicationLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all application logs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(applicationLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the application log.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(applicationLog applicationLog) {
		entityCache.removeResult(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
			applicationLogImpl.class, applicationLog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<applicationLog> applicationLogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (applicationLog applicationLog : applicationLogs) {
			entityCache.removeResult(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
				applicationLogImpl.class, applicationLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new application log with the primary key. Does not add the application log to the database.
	 *
	 * @param PK_logId the primary key for the new application log
	 * @return the new application log
	 */
	@Override
	public applicationLog create(long PK_logId) {
		applicationLog applicationLog = new applicationLogImpl();

		applicationLog.setNew(true);
		applicationLog.setPrimaryKey(PK_logId);

		return applicationLog;
	}

	/**
	 * Removes the application log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_logId the primary key of the application log
	 * @return the application log that was removed
	 * @throws NoSuchapplicationLogException if a application log with the primary key could not be found
	 */
	@Override
	public applicationLog remove(long PK_logId)
		throws NoSuchapplicationLogException {
		return remove((Serializable)PK_logId);
	}

	/**
	 * Removes the application log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the application log
	 * @return the application log that was removed
	 * @throws NoSuchapplicationLogException if a application log with the primary key could not be found
	 */
	@Override
	public applicationLog remove(Serializable primaryKey)
		throws NoSuchapplicationLogException {
		Session session = null;

		try {
			session = openSession();

			applicationLog applicationLog = (applicationLog)session.get(applicationLogImpl.class,
					primaryKey);

			if (applicationLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchapplicationLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applicationLog);
		}
		catch (NoSuchapplicationLogException nsee) {
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
	protected applicationLog removeImpl(applicationLog applicationLog) {
		applicationLog = toUnwrappedModel(applicationLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicationLog)) {
				applicationLog = (applicationLog)session.get(applicationLogImpl.class,
						applicationLog.getPrimaryKeyObj());
			}

			if (applicationLog != null) {
				session.delete(applicationLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applicationLog != null) {
			clearCache(applicationLog);
		}

		return applicationLog;
	}

	@Override
	public applicationLog updateImpl(applicationLog applicationLog) {
		applicationLog = toUnwrappedModel(applicationLog);

		boolean isNew = applicationLog.isNew();

		Session session = null;

		try {
			session = openSession();

			if (applicationLog.isNew()) {
				session.save(applicationLog);

				applicationLog.setNew(false);
			}
			else {
				applicationLog = (applicationLog)session.merge(applicationLog);
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

		entityCache.putResult(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
			applicationLogImpl.class, applicationLog.getPrimaryKey(),
			applicationLog, false);

		applicationLog.resetOriginalValues();

		return applicationLog;
	}

	protected applicationLog toUnwrappedModel(applicationLog applicationLog) {
		if (applicationLog instanceof applicationLogImpl) {
			return applicationLog;
		}

		applicationLogImpl applicationLogImpl = new applicationLogImpl();

		applicationLogImpl.setNew(applicationLog.isNew());
		applicationLogImpl.setPrimaryKey(applicationLog.getPrimaryKey());

		applicationLogImpl.setPK_logId(applicationLog.getPK_logId());
		applicationLogImpl.setUserId(applicationLog.getUserId());
		applicationLogImpl.setUserName(applicationLog.getUserName());
		applicationLogImpl.setCreateDate(applicationLog.getCreateDate());
		applicationLogImpl.setPageName(applicationLog.getPageName());
		applicationLogImpl.setModuleName(applicationLog.getModuleName());
		applicationLogImpl.setButtonName(applicationLog.getButtonName());
		applicationLogImpl.setProjectId(applicationLog.getProjectId());
		applicationLogImpl.setInterestId(applicationLog.getInterestId());
		applicationLogImpl.setComments(applicationLog.getComments());

		return applicationLogImpl;
	}

	/**
	 * Returns the application log with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the application log
	 * @return the application log
	 * @throws NoSuchapplicationLogException if a application log with the primary key could not be found
	 */
	@Override
	public applicationLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchapplicationLogException {
		applicationLog applicationLog = fetchByPrimaryKey(primaryKey);

		if (applicationLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchapplicationLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applicationLog;
	}

	/**
	 * Returns the application log with the primary key or throws a {@link NoSuchapplicationLogException} if it could not be found.
	 *
	 * @param PK_logId the primary key of the application log
	 * @return the application log
	 * @throws NoSuchapplicationLogException if a application log with the primary key could not be found
	 */
	@Override
	public applicationLog findByPrimaryKey(long PK_logId)
		throws NoSuchapplicationLogException {
		return findByPrimaryKey((Serializable)PK_logId);
	}

	/**
	 * Returns the application log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the application log
	 * @return the application log, or <code>null</code> if a application log with the primary key could not be found
	 */
	@Override
	public applicationLog fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
				applicationLogImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		applicationLog applicationLog = (applicationLog)serializable;

		if (applicationLog == null) {
			Session session = null;

			try {
				session = openSession();

				applicationLog = (applicationLog)session.get(applicationLogImpl.class,
						primaryKey);

				if (applicationLog != null) {
					cacheResult(applicationLog);
				}
				else {
					entityCache.putResult(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
						applicationLogImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
					applicationLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applicationLog;
	}

	/**
	 * Returns the application log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_logId the primary key of the application log
	 * @return the application log, or <code>null</code> if a application log with the primary key could not be found
	 */
	@Override
	public applicationLog fetchByPrimaryKey(long PK_logId) {
		return fetchByPrimaryKey((Serializable)PK_logId);
	}

	@Override
	public Map<Serializable, applicationLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, applicationLog> map = new HashMap<Serializable, applicationLog>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			applicationLog applicationLog = fetchByPrimaryKey(primaryKey);

			if (applicationLog != null) {
				map.put(primaryKey, applicationLog);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
					applicationLogImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (applicationLog)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPLICATIONLOG_WHERE_PKS_IN);

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

			for (applicationLog applicationLog : (List<applicationLog>)q.list()) {
				map.put(applicationLog.getPrimaryKeyObj(), applicationLog);

				cacheResult(applicationLog);

				uncachedPrimaryKeys.remove(applicationLog.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(applicationLogModelImpl.ENTITY_CACHE_ENABLED,
					applicationLogImpl.class, primaryKey, nullModel);
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
	 * Returns all the application logs.
	 *
	 * @return the application logs
	 */
	@Override
	public List<applicationLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link applicationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application logs
	 * @param end the upper bound of the range of application logs (not inclusive)
	 * @return the range of application logs
	 */
	@Override
	public List<applicationLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the application logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link applicationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application logs
	 * @param end the upper bound of the range of application logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of application logs
	 */
	@Override
	public List<applicationLog> findAll(int start, int end,
		OrderByComparator<applicationLog> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link applicationLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application logs
	 * @param end the upper bound of the range of application logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of application logs
	 */
	@Override
	public List<applicationLog> findAll(int start, int end,
		OrderByComparator<applicationLog> orderByComparator,
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

		List<applicationLog> list = null;

		if (retrieveFromCache) {
			list = (List<applicationLog>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPLICATIONLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICATIONLOG;

				if (pagination) {
					sql = sql.concat(applicationLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<applicationLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<applicationLog>)QueryUtil.list(q,
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
	 * Removes all the application logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (applicationLog applicationLog : findAll()) {
			remove(applicationLog);
		}
	}

	/**
	 * Returns the number of application logs.
	 *
	 * @return the number of application logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPLICATIONLOG);

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
		return applicationLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the application log persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(applicationLogImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_APPLICATIONLOG = "SELECT applicationLog FROM applicationLog applicationLog";
	private static final String _SQL_SELECT_APPLICATIONLOG_WHERE_PKS_IN = "SELECT applicationLog FROM applicationLog applicationLog WHERE PK_logId IN (";
	private static final String _SQL_COUNT_APPLICATIONLOG = "SELECT COUNT(applicationLog) FROM applicationLog applicationLog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applicationLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No applicationLog exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(applicationLogPersistenceImpl.class);
}