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

import com.collaborated.entity.exception.NoSuchcommonWebsserviceAPIException;
import com.collaborated.entity.model.commonWebsserviceAPI;
import com.collaborated.entity.model.impl.commonWebsserviceAPIImpl;
import com.collaborated.entity.model.impl.commonWebsserviceAPIModelImpl;
import com.collaborated.entity.service.persistence.commonWebsserviceAPIPersistence;

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
 * The persistence implementation for the common websservice a p i service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPIPersistence
 * @see com.collaborated.entity.service.persistence.commonWebsserviceAPIUtil
 * @generated
 */
@ProviderType
public class commonWebsserviceAPIPersistenceImpl extends BasePersistenceImpl<commonWebsserviceAPI>
	implements commonWebsserviceAPIPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link commonWebsserviceAPIUtil} to access the common websservice a p i persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = commonWebsserviceAPIImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
			commonWebsserviceAPIModelImpl.FINDER_CACHE_ENABLED,
			commonWebsserviceAPIImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
			commonWebsserviceAPIModelImpl.FINDER_CACHE_ENABLED,
			commonWebsserviceAPIImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
			commonWebsserviceAPIModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public commonWebsserviceAPIPersistenceImpl() {
		setModelClass(commonWebsserviceAPI.class);
	}

	/**
	 * Caches the common websservice a p i in the entity cache if it is enabled.
	 *
	 * @param commonWebsserviceAPI the common websservice a p i
	 */
	@Override
	public void cacheResult(commonWebsserviceAPI commonWebsserviceAPI) {
		entityCache.putResult(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
			commonWebsserviceAPIImpl.class,
			commonWebsserviceAPI.getPrimaryKey(), commonWebsserviceAPI);

		commonWebsserviceAPI.resetOriginalValues();
	}

	/**
	 * Caches the common websservice a p is in the entity cache if it is enabled.
	 *
	 * @param commonWebsserviceAPIs the common websservice a p is
	 */
	@Override
	public void cacheResult(List<commonWebsserviceAPI> commonWebsserviceAPIs) {
		for (commonWebsserviceAPI commonWebsserviceAPI : commonWebsserviceAPIs) {
			if (entityCache.getResult(
						commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
						commonWebsserviceAPIImpl.class,
						commonWebsserviceAPI.getPrimaryKey()) == null) {
				cacheResult(commonWebsserviceAPI);
			}
			else {
				commonWebsserviceAPI.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all common websservice a p is.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(commonWebsserviceAPIImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the common websservice a p i.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(commonWebsserviceAPI commonWebsserviceAPI) {
		entityCache.removeResult(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
			commonWebsserviceAPIImpl.class, commonWebsserviceAPI.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<commonWebsserviceAPI> commonWebsserviceAPIs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (commonWebsserviceAPI commonWebsserviceAPI : commonWebsserviceAPIs) {
			entityCache.removeResult(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
				commonWebsserviceAPIImpl.class,
				commonWebsserviceAPI.getPrimaryKey());
		}
	}

	/**
	 * Creates a new common websservice a p i with the primary key. Does not add the common websservice a p i to the database.
	 *
	 * @param commonAPIId the primary key for the new common websservice a p i
	 * @return the new common websservice a p i
	 */
	@Override
	public commonWebsserviceAPI create(long commonAPIId) {
		commonWebsserviceAPI commonWebsserviceAPI = new commonWebsserviceAPIImpl();

		commonWebsserviceAPI.setNew(true);
		commonWebsserviceAPI.setPrimaryKey(commonAPIId);

		return commonWebsserviceAPI;
	}

	/**
	 * Removes the common websservice a p i with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commonAPIId the primary key of the common websservice a p i
	 * @return the common websservice a p i that was removed
	 * @throws NoSuchcommonWebsserviceAPIException if a common websservice a p i with the primary key could not be found
	 */
	@Override
	public commonWebsserviceAPI remove(long commonAPIId)
		throws NoSuchcommonWebsserviceAPIException {
		return remove((Serializable)commonAPIId);
	}

	/**
	 * Removes the common websservice a p i with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the common websservice a p i
	 * @return the common websservice a p i that was removed
	 * @throws NoSuchcommonWebsserviceAPIException if a common websservice a p i with the primary key could not be found
	 */
	@Override
	public commonWebsserviceAPI remove(Serializable primaryKey)
		throws NoSuchcommonWebsserviceAPIException {
		Session session = null;

		try {
			session = openSession();

			commonWebsserviceAPI commonWebsserviceAPI = (commonWebsserviceAPI)session.get(commonWebsserviceAPIImpl.class,
					primaryKey);

			if (commonWebsserviceAPI == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcommonWebsserviceAPIException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(commonWebsserviceAPI);
		}
		catch (NoSuchcommonWebsserviceAPIException nsee) {
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
	protected commonWebsserviceAPI removeImpl(
		commonWebsserviceAPI commonWebsserviceAPI) {
		commonWebsserviceAPI = toUnwrappedModel(commonWebsserviceAPI);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commonWebsserviceAPI)) {
				commonWebsserviceAPI = (commonWebsserviceAPI)session.get(commonWebsserviceAPIImpl.class,
						commonWebsserviceAPI.getPrimaryKeyObj());
			}

			if (commonWebsserviceAPI != null) {
				session.delete(commonWebsserviceAPI);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commonWebsserviceAPI != null) {
			clearCache(commonWebsserviceAPI);
		}

		return commonWebsserviceAPI;
	}

	@Override
	public commonWebsserviceAPI updateImpl(
		commonWebsserviceAPI commonWebsserviceAPI) {
		commonWebsserviceAPI = toUnwrappedModel(commonWebsserviceAPI);

		boolean isNew = commonWebsserviceAPI.isNew();

		Session session = null;

		try {
			session = openSession();

			if (commonWebsserviceAPI.isNew()) {
				session.save(commonWebsserviceAPI);

				commonWebsserviceAPI.setNew(false);
			}
			else {
				commonWebsserviceAPI = (commonWebsserviceAPI)session.merge(commonWebsserviceAPI);
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

		entityCache.putResult(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
			commonWebsserviceAPIImpl.class,
			commonWebsserviceAPI.getPrimaryKey(), commonWebsserviceAPI, false);

		commonWebsserviceAPI.resetOriginalValues();

		return commonWebsserviceAPI;
	}

	protected commonWebsserviceAPI toUnwrappedModel(
		commonWebsserviceAPI commonWebsserviceAPI) {
		if (commonWebsserviceAPI instanceof commonWebsserviceAPIImpl) {
			return commonWebsserviceAPI;
		}

		commonWebsserviceAPIImpl commonWebsserviceAPIImpl = new commonWebsserviceAPIImpl();

		commonWebsserviceAPIImpl.setNew(commonWebsserviceAPI.isNew());
		commonWebsserviceAPIImpl.setPrimaryKey(commonWebsserviceAPI.getPrimaryKey());

		commonWebsserviceAPIImpl.setCommonAPIId(commonWebsserviceAPI.getCommonAPIId());

		return commonWebsserviceAPIImpl;
	}

	/**
	 * Returns the common websservice a p i with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the common websservice a p i
	 * @return the common websservice a p i
	 * @throws NoSuchcommonWebsserviceAPIException if a common websservice a p i with the primary key could not be found
	 */
	@Override
	public commonWebsserviceAPI findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcommonWebsserviceAPIException {
		commonWebsserviceAPI commonWebsserviceAPI = fetchByPrimaryKey(primaryKey);

		if (commonWebsserviceAPI == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcommonWebsserviceAPIException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return commonWebsserviceAPI;
	}

	/**
	 * Returns the common websservice a p i with the primary key or throws a {@link NoSuchcommonWebsserviceAPIException} if it could not be found.
	 *
	 * @param commonAPIId the primary key of the common websservice a p i
	 * @return the common websservice a p i
	 * @throws NoSuchcommonWebsserviceAPIException if a common websservice a p i with the primary key could not be found
	 */
	@Override
	public commonWebsserviceAPI findByPrimaryKey(long commonAPIId)
		throws NoSuchcommonWebsserviceAPIException {
		return findByPrimaryKey((Serializable)commonAPIId);
	}

	/**
	 * Returns the common websservice a p i with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the common websservice a p i
	 * @return the common websservice a p i, or <code>null</code> if a common websservice a p i with the primary key could not be found
	 */
	@Override
	public commonWebsserviceAPI fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
				commonWebsserviceAPIImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		commonWebsserviceAPI commonWebsserviceAPI = (commonWebsserviceAPI)serializable;

		if (commonWebsserviceAPI == null) {
			Session session = null;

			try {
				session = openSession();

				commonWebsserviceAPI = (commonWebsserviceAPI)session.get(commonWebsserviceAPIImpl.class,
						primaryKey);

				if (commonWebsserviceAPI != null) {
					cacheResult(commonWebsserviceAPI);
				}
				else {
					entityCache.putResult(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
						commonWebsserviceAPIImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
					commonWebsserviceAPIImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commonWebsserviceAPI;
	}

	/**
	 * Returns the common websservice a p i with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commonAPIId the primary key of the common websservice a p i
	 * @return the common websservice a p i, or <code>null</code> if a common websservice a p i with the primary key could not be found
	 */
	@Override
	public commonWebsserviceAPI fetchByPrimaryKey(long commonAPIId) {
		return fetchByPrimaryKey((Serializable)commonAPIId);
	}

	@Override
	public Map<Serializable, commonWebsserviceAPI> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, commonWebsserviceAPI> map = new HashMap<Serializable, commonWebsserviceAPI>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			commonWebsserviceAPI commonWebsserviceAPI = fetchByPrimaryKey(primaryKey);

			if (commonWebsserviceAPI != null) {
				map.put(primaryKey, commonWebsserviceAPI);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
					commonWebsserviceAPIImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (commonWebsserviceAPI)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COMMONWEBSSERVICEAPI_WHERE_PKS_IN);

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

			for (commonWebsserviceAPI commonWebsserviceAPI : (List<commonWebsserviceAPI>)q.list()) {
				map.put(commonWebsserviceAPI.getPrimaryKeyObj(),
					commonWebsserviceAPI);

				cacheResult(commonWebsserviceAPI);

				uncachedPrimaryKeys.remove(commonWebsserviceAPI.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(commonWebsserviceAPIModelImpl.ENTITY_CACHE_ENABLED,
					commonWebsserviceAPIImpl.class, primaryKey, nullModel);
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
	 * Returns all the common websservice a p is.
	 *
	 * @return the common websservice a p is
	 */
	@Override
	public List<commonWebsserviceAPI> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the common websservice a p is.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of common websservice a p is
	 * @param end the upper bound of the range of common websservice a p is (not inclusive)
	 * @return the range of common websservice a p is
	 */
	@Override
	public List<commonWebsserviceAPI> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the common websservice a p is.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of common websservice a p is
	 * @param end the upper bound of the range of common websservice a p is (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of common websservice a p is
	 */
	@Override
	public List<commonWebsserviceAPI> findAll(int start, int end,
		OrderByComparator<commonWebsserviceAPI> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the common websservice a p is.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link commonWebsserviceAPIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of common websservice a p is
	 * @param end the upper bound of the range of common websservice a p is (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of common websservice a p is
	 */
	@Override
	public List<commonWebsserviceAPI> findAll(int start, int end,
		OrderByComparator<commonWebsserviceAPI> orderByComparator,
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

		List<commonWebsserviceAPI> list = null;

		if (retrieveFromCache) {
			list = (List<commonWebsserviceAPI>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMONWEBSSERVICEAPI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMONWEBSSERVICEAPI;

				if (pagination) {
					sql = sql.concat(commonWebsserviceAPIModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<commonWebsserviceAPI>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<commonWebsserviceAPI>)QueryUtil.list(q,
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
	 * Removes all the common websservice a p is from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (commonWebsserviceAPI commonWebsserviceAPI : findAll()) {
			remove(commonWebsserviceAPI);
		}
	}

	/**
	 * Returns the number of common websservice a p is.
	 *
	 * @return the number of common websservice a p is
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMONWEBSSERVICEAPI);

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
		return commonWebsserviceAPIModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the common websservice a p i persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(commonWebsserviceAPIImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_COMMONWEBSSERVICEAPI = "SELECT commonWebsserviceAPI FROM commonWebsserviceAPI commonWebsserviceAPI";
	private static final String _SQL_SELECT_COMMONWEBSSERVICEAPI_WHERE_PKS_IN = "SELECT commonWebsserviceAPI FROM commonWebsserviceAPI commonWebsserviceAPI WHERE commonAPIId IN (";
	private static final String _SQL_COUNT_COMMONWEBSSERVICEAPI = "SELECT COUNT(commonWebsserviceAPI) FROM commonWebsserviceAPI commonWebsserviceAPI";
	private static final String _ORDER_BY_ENTITY_ALIAS = "commonWebsserviceAPI.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No commonWebsserviceAPI exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(commonWebsserviceAPIPersistenceImpl.class);
}