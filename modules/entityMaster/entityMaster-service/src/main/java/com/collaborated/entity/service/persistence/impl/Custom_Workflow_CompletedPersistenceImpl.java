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

import com.collaborated.entity.exception.NoSuchCustom_Workflow_CompletedException;
import com.collaborated.entity.model.Custom_Workflow_Completed;
import com.collaborated.entity.model.impl.Custom_Workflow_CompletedImpl;
import com.collaborated.entity.model.impl.Custom_Workflow_CompletedModelImpl;
import com.collaborated.entity.service.persistence.Custom_Workflow_CompletedPersistence;

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
 * The persistence implementation for the custom_ workflow_ completed service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_CompletedPersistence
 * @see com.collaborated.entity.service.persistence.Custom_Workflow_CompletedUtil
 * @generated
 */
@ProviderType
public class Custom_Workflow_CompletedPersistenceImpl
	extends BasePersistenceImpl<Custom_Workflow_Completed>
	implements Custom_Workflow_CompletedPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Custom_Workflow_CompletedUtil} to access the custom_ workflow_ completed persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Custom_Workflow_CompletedImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_CompletedModelImpl.FINDER_CACHE_ENABLED,
			Custom_Workflow_CompletedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_CompletedModelImpl.FINDER_CACHE_ENABLED,
			Custom_Workflow_CompletedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_CompletedModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public Custom_Workflow_CompletedPersistenceImpl() {
		setModelClass(Custom_Workflow_Completed.class);
	}

	/**
	 * Caches the custom_ workflow_ completed in the entity cache if it is enabled.
	 *
	 * @param custom_Workflow_Completed the custom_ workflow_ completed
	 */
	@Override
	public void cacheResult(Custom_Workflow_Completed custom_Workflow_Completed) {
		entityCache.putResult(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_CompletedImpl.class,
			custom_Workflow_Completed.getPrimaryKey(), custom_Workflow_Completed);

		custom_Workflow_Completed.resetOriginalValues();
	}

	/**
	 * Caches the custom_ workflow_ completeds in the entity cache if it is enabled.
	 *
	 * @param custom_Workflow_Completeds the custom_ workflow_ completeds
	 */
	@Override
	public void cacheResult(
		List<Custom_Workflow_Completed> custom_Workflow_Completeds) {
		for (Custom_Workflow_Completed custom_Workflow_Completed : custom_Workflow_Completeds) {
			if (entityCache.getResult(
						Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
						Custom_Workflow_CompletedImpl.class,
						custom_Workflow_Completed.getPrimaryKey()) == null) {
				cacheResult(custom_Workflow_Completed);
			}
			else {
				custom_Workflow_Completed.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom_ workflow_ completeds.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Custom_Workflow_CompletedImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom_ workflow_ completed.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Custom_Workflow_Completed custom_Workflow_Completed) {
		entityCache.removeResult(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_CompletedImpl.class,
			custom_Workflow_Completed.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Custom_Workflow_Completed> custom_Workflow_Completeds) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Custom_Workflow_Completed custom_Workflow_Completed : custom_Workflow_Completeds) {
			entityCache.removeResult(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
				Custom_Workflow_CompletedImpl.class,
				custom_Workflow_Completed.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom_ workflow_ completed with the primary key. Does not add the custom_ workflow_ completed to the database.
	 *
	 * @param cId the primary key for the new custom_ workflow_ completed
	 * @return the new custom_ workflow_ completed
	 */
	@Override
	public Custom_Workflow_Completed create(long cId) {
		Custom_Workflow_Completed custom_Workflow_Completed = new Custom_Workflow_CompletedImpl();

		custom_Workflow_Completed.setNew(true);
		custom_Workflow_Completed.setPrimaryKey(cId);

		return custom_Workflow_Completed;
	}

	/**
	 * Removes the custom_ workflow_ completed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cId the primary key of the custom_ workflow_ completed
	 * @return the custom_ workflow_ completed that was removed
	 * @throws NoSuchCustom_Workflow_CompletedException if a custom_ workflow_ completed with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Completed remove(long cId)
		throws NoSuchCustom_Workflow_CompletedException {
		return remove((Serializable)cId);
	}

	/**
	 * Removes the custom_ workflow_ completed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom_ workflow_ completed
	 * @return the custom_ workflow_ completed that was removed
	 * @throws NoSuchCustom_Workflow_CompletedException if a custom_ workflow_ completed with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Completed remove(Serializable primaryKey)
		throws NoSuchCustom_Workflow_CompletedException {
		Session session = null;

		try {
			session = openSession();

			Custom_Workflow_Completed custom_Workflow_Completed = (Custom_Workflow_Completed)session.get(Custom_Workflow_CompletedImpl.class,
					primaryKey);

			if (custom_Workflow_Completed == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustom_Workflow_CompletedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(custom_Workflow_Completed);
		}
		catch (NoSuchCustom_Workflow_CompletedException nsee) {
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
	protected Custom_Workflow_Completed removeImpl(
		Custom_Workflow_Completed custom_Workflow_Completed) {
		custom_Workflow_Completed = toUnwrappedModel(custom_Workflow_Completed);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(custom_Workflow_Completed)) {
				custom_Workflow_Completed = (Custom_Workflow_Completed)session.get(Custom_Workflow_CompletedImpl.class,
						custom_Workflow_Completed.getPrimaryKeyObj());
			}

			if (custom_Workflow_Completed != null) {
				session.delete(custom_Workflow_Completed);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (custom_Workflow_Completed != null) {
			clearCache(custom_Workflow_Completed);
		}

		return custom_Workflow_Completed;
	}

	@Override
	public Custom_Workflow_Completed updateImpl(
		Custom_Workflow_Completed custom_Workflow_Completed) {
		custom_Workflow_Completed = toUnwrappedModel(custom_Workflow_Completed);

		boolean isNew = custom_Workflow_Completed.isNew();

		Session session = null;

		try {
			session = openSession();

			if (custom_Workflow_Completed.isNew()) {
				session.save(custom_Workflow_Completed);

				custom_Workflow_Completed.setNew(false);
			}
			else {
				custom_Workflow_Completed = (Custom_Workflow_Completed)session.merge(custom_Workflow_Completed);
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

		entityCache.putResult(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_CompletedImpl.class,
			custom_Workflow_Completed.getPrimaryKey(),
			custom_Workflow_Completed, false);

		custom_Workflow_Completed.resetOriginalValues();

		return custom_Workflow_Completed;
	}

	protected Custom_Workflow_Completed toUnwrappedModel(
		Custom_Workflow_Completed custom_Workflow_Completed) {
		if (custom_Workflow_Completed instanceof Custom_Workflow_CompletedImpl) {
			return custom_Workflow_Completed;
		}

		Custom_Workflow_CompletedImpl custom_Workflow_CompletedImpl = new Custom_Workflow_CompletedImpl();

		custom_Workflow_CompletedImpl.setNew(custom_Workflow_Completed.isNew());
		custom_Workflow_CompletedImpl.setPrimaryKey(custom_Workflow_Completed.getPrimaryKey());

		custom_Workflow_CompletedImpl.setCId(custom_Workflow_Completed.getCId());
		custom_Workflow_CompletedImpl.setTrackingId(custom_Workflow_Completed.getTrackingId());
		custom_Workflow_CompletedImpl.setWorkflowId(custom_Workflow_Completed.getWorkflowId());
		custom_Workflow_CompletedImpl.setWorkflowTaskId(custom_Workflow_Completed.getWorkflowTaskId());
		custom_Workflow_CompletedImpl.setTrasitionId(custom_Workflow_Completed.getTrasitionId());
		custom_Workflow_CompletedImpl.setLogDescription(custom_Workflow_Completed.getLogDescription());
		custom_Workflow_CompletedImpl.setComments(custom_Workflow_Completed.getComments());
		custom_Workflow_CompletedImpl.setCompletedDate(custom_Workflow_Completed.getCompletedDate());
		custom_Workflow_CompletedImpl.setUserId(custom_Workflow_Completed.getUserId());
		custom_Workflow_CompletedImpl.setCreatedDate(custom_Workflow_Completed.getCreatedDate());

		return custom_Workflow_CompletedImpl;
	}

	/**
	 * Returns the custom_ workflow_ completed with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow_ completed
	 * @return the custom_ workflow_ completed
	 * @throws NoSuchCustom_Workflow_CompletedException if a custom_ workflow_ completed with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Completed findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustom_Workflow_CompletedException {
		Custom_Workflow_Completed custom_Workflow_Completed = fetchByPrimaryKey(primaryKey);

		if (custom_Workflow_Completed == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustom_Workflow_CompletedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return custom_Workflow_Completed;
	}

	/**
	 * Returns the custom_ workflow_ completed with the primary key or throws a {@link NoSuchCustom_Workflow_CompletedException} if it could not be found.
	 *
	 * @param cId the primary key of the custom_ workflow_ completed
	 * @return the custom_ workflow_ completed
	 * @throws NoSuchCustom_Workflow_CompletedException if a custom_ workflow_ completed with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Completed findByPrimaryKey(long cId)
		throws NoSuchCustom_Workflow_CompletedException {
		return findByPrimaryKey((Serializable)cId);
	}

	/**
	 * Returns the custom_ workflow_ completed with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow_ completed
	 * @return the custom_ workflow_ completed, or <code>null</code> if a custom_ workflow_ completed with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Completed fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
				Custom_Workflow_CompletedImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Custom_Workflow_Completed custom_Workflow_Completed = (Custom_Workflow_Completed)serializable;

		if (custom_Workflow_Completed == null) {
			Session session = null;

			try {
				session = openSession();

				custom_Workflow_Completed = (Custom_Workflow_Completed)session.get(Custom_Workflow_CompletedImpl.class,
						primaryKey);

				if (custom_Workflow_Completed != null) {
					cacheResult(custom_Workflow_Completed);
				}
				else {
					entityCache.putResult(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
						Custom_Workflow_CompletedImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
					Custom_Workflow_CompletedImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return custom_Workflow_Completed;
	}

	/**
	 * Returns the custom_ workflow_ completed with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cId the primary key of the custom_ workflow_ completed
	 * @return the custom_ workflow_ completed, or <code>null</code> if a custom_ workflow_ completed with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Completed fetchByPrimaryKey(long cId) {
		return fetchByPrimaryKey((Serializable)cId);
	}

	@Override
	public Map<Serializable, Custom_Workflow_Completed> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Custom_Workflow_Completed> map = new HashMap<Serializable, Custom_Workflow_Completed>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Custom_Workflow_Completed custom_Workflow_Completed = fetchByPrimaryKey(primaryKey);

			if (custom_Workflow_Completed != null) {
				map.put(primaryKey, custom_Workflow_Completed);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
					Custom_Workflow_CompletedImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Custom_Workflow_Completed)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOM_WORKFLOW_COMPLETED_WHERE_PKS_IN);

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

			for (Custom_Workflow_Completed custom_Workflow_Completed : (List<Custom_Workflow_Completed>)q.list()) {
				map.put(custom_Workflow_Completed.getPrimaryKeyObj(),
					custom_Workflow_Completed);

				cacheResult(custom_Workflow_Completed);

				uncachedPrimaryKeys.remove(custom_Workflow_Completed.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Custom_Workflow_CompletedModelImpl.ENTITY_CACHE_ENABLED,
					Custom_Workflow_CompletedImpl.class, primaryKey, nullModel);
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
	 * Returns all the custom_ workflow_ completeds.
	 *
	 * @return the custom_ workflow_ completeds
	 */
	@Override
	public List<Custom_Workflow_Completed> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the custom_ workflow_ completeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow_ completeds
	 * @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	 * @return the range of custom_ workflow_ completeds
	 */
	@Override
	public List<Custom_Workflow_Completed> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the custom_ workflow_ completeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow_ completeds
	 * @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom_ workflow_ completeds
	 */
	@Override
	public List<Custom_Workflow_Completed> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Completed> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the custom_ workflow_ completeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_CompletedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow_ completeds
	 * @param end the upper bound of the range of custom_ workflow_ completeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of custom_ workflow_ completeds
	 */
	@Override
	public List<Custom_Workflow_Completed> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Completed> orderByComparator,
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

		List<Custom_Workflow_Completed> list = null;

		if (retrieveFromCache) {
			list = (List<Custom_Workflow_Completed>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOM_WORKFLOW_COMPLETED);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOM_WORKFLOW_COMPLETED;

				if (pagination) {
					sql = sql.concat(Custom_Workflow_CompletedModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Custom_Workflow_Completed>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Custom_Workflow_Completed>)QueryUtil.list(q,
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
	 * Removes all the custom_ workflow_ completeds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Custom_Workflow_Completed custom_Workflow_Completed : findAll()) {
			remove(custom_Workflow_Completed);
		}
	}

	/**
	 * Returns the number of custom_ workflow_ completeds.
	 *
	 * @return the number of custom_ workflow_ completeds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOM_WORKFLOW_COMPLETED);

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
		return Custom_Workflow_CompletedModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom_ workflow_ completed persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Custom_Workflow_CompletedImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOM_WORKFLOW_COMPLETED = "SELECT custom_Workflow_Completed FROM Custom_Workflow_Completed custom_Workflow_Completed";
	private static final String _SQL_SELECT_CUSTOM_WORKFLOW_COMPLETED_WHERE_PKS_IN =
		"SELECT custom_Workflow_Completed FROM Custom_Workflow_Completed custom_Workflow_Completed WHERE cId IN (";
	private static final String _SQL_COUNT_CUSTOM_WORKFLOW_COMPLETED = "SELECT COUNT(custom_Workflow_Completed) FROM Custom_Workflow_Completed custom_Workflow_Completed";
	private static final String _ORDER_BY_ENTITY_ALIAS = "custom_Workflow_Completed.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Custom_Workflow_Completed exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(Custom_Workflow_CompletedPersistenceImpl.class);
}