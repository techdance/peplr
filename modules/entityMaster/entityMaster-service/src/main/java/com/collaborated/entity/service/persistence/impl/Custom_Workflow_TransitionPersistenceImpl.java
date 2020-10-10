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

import com.collaborated.entity.exception.NoSuchCustom_Workflow_TransitionException;
import com.collaborated.entity.model.Custom_Workflow_Transition;
import com.collaborated.entity.model.impl.Custom_Workflow_TransitionImpl;
import com.collaborated.entity.model.impl.Custom_Workflow_TransitionModelImpl;
import com.collaborated.entity.service.persistence.Custom_Workflow_TransitionPersistence;

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
 * The persistence implementation for the custom_ workflow_ transition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_TransitionPersistence
 * @see com.collaborated.entity.service.persistence.Custom_Workflow_TransitionUtil
 * @generated
 */
@ProviderType
public class Custom_Workflow_TransitionPersistenceImpl
	extends BasePersistenceImpl<Custom_Workflow_Transition>
	implements Custom_Workflow_TransitionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Custom_Workflow_TransitionUtil} to access the custom_ workflow_ transition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Custom_Workflow_TransitionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TransitionModelImpl.FINDER_CACHE_ENABLED,
			Custom_Workflow_TransitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TransitionModelImpl.FINDER_CACHE_ENABLED,
			Custom_Workflow_TransitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TransitionModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public Custom_Workflow_TransitionPersistenceImpl() {
		setModelClass(Custom_Workflow_Transition.class);
	}

	/**
	 * Caches the custom_ workflow_ transition in the entity cache if it is enabled.
	 *
	 * @param custom_Workflow_Transition the custom_ workflow_ transition
	 */
	@Override
	public void cacheResult(
		Custom_Workflow_Transition custom_Workflow_Transition) {
		entityCache.putResult(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TransitionImpl.class,
			custom_Workflow_Transition.getPrimaryKey(),
			custom_Workflow_Transition);

		custom_Workflow_Transition.resetOriginalValues();
	}

	/**
	 * Caches the custom_ workflow_ transitions in the entity cache if it is enabled.
	 *
	 * @param custom_Workflow_Transitions the custom_ workflow_ transitions
	 */
	@Override
	public void cacheResult(
		List<Custom_Workflow_Transition> custom_Workflow_Transitions) {
		for (Custom_Workflow_Transition custom_Workflow_Transition : custom_Workflow_Transitions) {
			if (entityCache.getResult(
						Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
						Custom_Workflow_TransitionImpl.class,
						custom_Workflow_Transition.getPrimaryKey()) == null) {
				cacheResult(custom_Workflow_Transition);
			}
			else {
				custom_Workflow_Transition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom_ workflow_ transitions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Custom_Workflow_TransitionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom_ workflow_ transition.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		Custom_Workflow_Transition custom_Workflow_Transition) {
		entityCache.removeResult(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TransitionImpl.class,
			custom_Workflow_Transition.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Custom_Workflow_Transition> custom_Workflow_Transitions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Custom_Workflow_Transition custom_Workflow_Transition : custom_Workflow_Transitions) {
			entityCache.removeResult(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
				Custom_Workflow_TransitionImpl.class,
				custom_Workflow_Transition.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom_ workflow_ transition with the primary key. Does not add the custom_ workflow_ transition to the database.
	 *
	 * @param transitionId the primary key for the new custom_ workflow_ transition
	 * @return the new custom_ workflow_ transition
	 */
	@Override
	public Custom_Workflow_Transition create(long transitionId) {
		Custom_Workflow_Transition custom_Workflow_Transition = new Custom_Workflow_TransitionImpl();

		custom_Workflow_Transition.setNew(true);
		custom_Workflow_Transition.setPrimaryKey(transitionId);

		return custom_Workflow_Transition;
	}

	/**
	 * Removes the custom_ workflow_ transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transitionId the primary key of the custom_ workflow_ transition
	 * @return the custom_ workflow_ transition that was removed
	 * @throws NoSuchCustom_Workflow_TransitionException if a custom_ workflow_ transition with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Transition remove(long transitionId)
		throws NoSuchCustom_Workflow_TransitionException {
		return remove((Serializable)transitionId);
	}

	/**
	 * Removes the custom_ workflow_ transition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom_ workflow_ transition
	 * @return the custom_ workflow_ transition that was removed
	 * @throws NoSuchCustom_Workflow_TransitionException if a custom_ workflow_ transition with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Transition remove(Serializable primaryKey)
		throws NoSuchCustom_Workflow_TransitionException {
		Session session = null;

		try {
			session = openSession();

			Custom_Workflow_Transition custom_Workflow_Transition = (Custom_Workflow_Transition)session.get(Custom_Workflow_TransitionImpl.class,
					primaryKey);

			if (custom_Workflow_Transition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustom_Workflow_TransitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(custom_Workflow_Transition);
		}
		catch (NoSuchCustom_Workflow_TransitionException nsee) {
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
	protected Custom_Workflow_Transition removeImpl(
		Custom_Workflow_Transition custom_Workflow_Transition) {
		custom_Workflow_Transition = toUnwrappedModel(custom_Workflow_Transition);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(custom_Workflow_Transition)) {
				custom_Workflow_Transition = (Custom_Workflow_Transition)session.get(Custom_Workflow_TransitionImpl.class,
						custom_Workflow_Transition.getPrimaryKeyObj());
			}

			if (custom_Workflow_Transition != null) {
				session.delete(custom_Workflow_Transition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (custom_Workflow_Transition != null) {
			clearCache(custom_Workflow_Transition);
		}

		return custom_Workflow_Transition;
	}

	@Override
	public Custom_Workflow_Transition updateImpl(
		Custom_Workflow_Transition custom_Workflow_Transition) {
		custom_Workflow_Transition = toUnwrappedModel(custom_Workflow_Transition);

		boolean isNew = custom_Workflow_Transition.isNew();

		Session session = null;

		try {
			session = openSession();

			if (custom_Workflow_Transition.isNew()) {
				session.save(custom_Workflow_Transition);

				custom_Workflow_Transition.setNew(false);
			}
			else {
				custom_Workflow_Transition = (Custom_Workflow_Transition)session.merge(custom_Workflow_Transition);
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

		entityCache.putResult(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TransitionImpl.class,
			custom_Workflow_Transition.getPrimaryKey(),
			custom_Workflow_Transition, false);

		custom_Workflow_Transition.resetOriginalValues();

		return custom_Workflow_Transition;
	}

	protected Custom_Workflow_Transition toUnwrappedModel(
		Custom_Workflow_Transition custom_Workflow_Transition) {
		if (custom_Workflow_Transition instanceof Custom_Workflow_TransitionImpl) {
			return custom_Workflow_Transition;
		}

		Custom_Workflow_TransitionImpl custom_Workflow_TransitionImpl = new Custom_Workflow_TransitionImpl();

		custom_Workflow_TransitionImpl.setNew(custom_Workflow_Transition.isNew());
		custom_Workflow_TransitionImpl.setPrimaryKey(custom_Workflow_Transition.getPrimaryKey());

		custom_Workflow_TransitionImpl.setTransitionId(custom_Workflow_Transition.getTransitionId());
		custom_Workflow_TransitionImpl.setWorkFlowId(custom_Workflow_Transition.getWorkFlowId());
		custom_Workflow_TransitionImpl.setWorkFlowTaskId(custom_Workflow_Transition.getWorkFlowTaskId());
		custom_Workflow_TransitionImpl.setTransitionName(custom_Workflow_Transition.getTransitionName());
		custom_Workflow_TransitionImpl.setLogDescription(custom_Workflow_Transition.getLogDescription());
		custom_Workflow_TransitionImpl.setNext_WorkFlowTaskId(custom_Workflow_Transition.getNext_WorkFlowTaskId());
		custom_Workflow_TransitionImpl.setIsEnd(custom_Workflow_Transition.getIsEnd());
		custom_Workflow_TransitionImpl.setComments(custom_Workflow_Transition.getComments());
		custom_Workflow_TransitionImpl.setCreatedDate(custom_Workflow_Transition.getCreatedDate());

		return custom_Workflow_TransitionImpl;
	}

	/**
	 * Returns the custom_ workflow_ transition with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow_ transition
	 * @return the custom_ workflow_ transition
	 * @throws NoSuchCustom_Workflow_TransitionException if a custom_ workflow_ transition with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Transition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustom_Workflow_TransitionException {
		Custom_Workflow_Transition custom_Workflow_Transition = fetchByPrimaryKey(primaryKey);

		if (custom_Workflow_Transition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustom_Workflow_TransitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return custom_Workflow_Transition;
	}

	/**
	 * Returns the custom_ workflow_ transition with the primary key or throws a {@link NoSuchCustom_Workflow_TransitionException} if it could not be found.
	 *
	 * @param transitionId the primary key of the custom_ workflow_ transition
	 * @return the custom_ workflow_ transition
	 * @throws NoSuchCustom_Workflow_TransitionException if a custom_ workflow_ transition with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Transition findByPrimaryKey(long transitionId)
		throws NoSuchCustom_Workflow_TransitionException {
		return findByPrimaryKey((Serializable)transitionId);
	}

	/**
	 * Returns the custom_ workflow_ transition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow_ transition
	 * @return the custom_ workflow_ transition, or <code>null</code> if a custom_ workflow_ transition with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Transition fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
				Custom_Workflow_TransitionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Custom_Workflow_Transition custom_Workflow_Transition = (Custom_Workflow_Transition)serializable;

		if (custom_Workflow_Transition == null) {
			Session session = null;

			try {
				session = openSession();

				custom_Workflow_Transition = (Custom_Workflow_Transition)session.get(Custom_Workflow_TransitionImpl.class,
						primaryKey);

				if (custom_Workflow_Transition != null) {
					cacheResult(custom_Workflow_Transition);
				}
				else {
					entityCache.putResult(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
						Custom_Workflow_TransitionImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
					Custom_Workflow_TransitionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return custom_Workflow_Transition;
	}

	/**
	 * Returns the custom_ workflow_ transition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transitionId the primary key of the custom_ workflow_ transition
	 * @return the custom_ workflow_ transition, or <code>null</code> if a custom_ workflow_ transition with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Transition fetchByPrimaryKey(long transitionId) {
		return fetchByPrimaryKey((Serializable)transitionId);
	}

	@Override
	public Map<Serializable, Custom_Workflow_Transition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Custom_Workflow_Transition> map = new HashMap<Serializable, Custom_Workflow_Transition>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Custom_Workflow_Transition custom_Workflow_Transition = fetchByPrimaryKey(primaryKey);

			if (custom_Workflow_Transition != null) {
				map.put(primaryKey, custom_Workflow_Transition);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
					Custom_Workflow_TransitionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Custom_Workflow_Transition)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOM_WORKFLOW_TRANSITION_WHERE_PKS_IN);

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

			for (Custom_Workflow_Transition custom_Workflow_Transition : (List<Custom_Workflow_Transition>)q.list()) {
				map.put(custom_Workflow_Transition.getPrimaryKeyObj(),
					custom_Workflow_Transition);

				cacheResult(custom_Workflow_Transition);

				uncachedPrimaryKeys.remove(custom_Workflow_Transition.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Custom_Workflow_TransitionModelImpl.ENTITY_CACHE_ENABLED,
					Custom_Workflow_TransitionImpl.class, primaryKey, nullModel);
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
	 * Returns all the custom_ workflow_ transitions.
	 *
	 * @return the custom_ workflow_ transitions
	 */
	@Override
	public List<Custom_Workflow_Transition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the custom_ workflow_ transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow_ transitions
	 * @param end the upper bound of the range of custom_ workflow_ transitions (not inclusive)
	 * @return the range of custom_ workflow_ transitions
	 */
	@Override
	public List<Custom_Workflow_Transition> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the custom_ workflow_ transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow_ transitions
	 * @param end the upper bound of the range of custom_ workflow_ transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom_ workflow_ transitions
	 */
	@Override
	public List<Custom_Workflow_Transition> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Transition> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the custom_ workflow_ transitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow_ transitions
	 * @param end the upper bound of the range of custom_ workflow_ transitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of custom_ workflow_ transitions
	 */
	@Override
	public List<Custom_Workflow_Transition> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Transition> orderByComparator,
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

		List<Custom_Workflow_Transition> list = null;

		if (retrieveFromCache) {
			list = (List<Custom_Workflow_Transition>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOM_WORKFLOW_TRANSITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOM_WORKFLOW_TRANSITION;

				if (pagination) {
					sql = sql.concat(Custom_Workflow_TransitionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Custom_Workflow_Transition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Custom_Workflow_Transition>)QueryUtil.list(q,
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
	 * Removes all the custom_ workflow_ transitions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Custom_Workflow_Transition custom_Workflow_Transition : findAll()) {
			remove(custom_Workflow_Transition);
		}
	}

	/**
	 * Returns the number of custom_ workflow_ transitions.
	 *
	 * @return the number of custom_ workflow_ transitions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOM_WORKFLOW_TRANSITION);

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
		return Custom_Workflow_TransitionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom_ workflow_ transition persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Custom_Workflow_TransitionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOM_WORKFLOW_TRANSITION = "SELECT custom_Workflow_Transition FROM Custom_Workflow_Transition custom_Workflow_Transition";
	private static final String _SQL_SELECT_CUSTOM_WORKFLOW_TRANSITION_WHERE_PKS_IN =
		"SELECT custom_Workflow_Transition FROM Custom_Workflow_Transition custom_Workflow_Transition WHERE transitionId IN (";
	private static final String _SQL_COUNT_CUSTOM_WORKFLOW_TRANSITION = "SELECT COUNT(custom_Workflow_Transition) FROM Custom_Workflow_Transition custom_Workflow_Transition";
	private static final String _ORDER_BY_ENTITY_ALIAS = "custom_Workflow_Transition.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Custom_Workflow_Transition exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(Custom_Workflow_TransitionPersistenceImpl.class);
}