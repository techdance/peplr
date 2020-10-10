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

import com.collaborated.entity.exception.NoSuchCustom_Workflow_TaskException;
import com.collaborated.entity.model.Custom_Workflow_Task;
import com.collaborated.entity.model.impl.Custom_Workflow_TaskImpl;
import com.collaborated.entity.model.impl.Custom_Workflow_TaskModelImpl;
import com.collaborated.entity.service.persistence.Custom_Workflow_TaskPersistence;

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
 * The persistence implementation for the custom_ workflow_ task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_TaskPersistence
 * @see com.collaborated.entity.service.persistence.Custom_Workflow_TaskUtil
 * @generated
 */
@ProviderType
public class Custom_Workflow_TaskPersistenceImpl extends BasePersistenceImpl<Custom_Workflow_Task>
	implements Custom_Workflow_TaskPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Custom_Workflow_TaskUtil} to access the custom_ workflow_ task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Custom_Workflow_TaskImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TaskModelImpl.FINDER_CACHE_ENABLED,
			Custom_Workflow_TaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TaskModelImpl.FINDER_CACHE_ENABLED,
			Custom_Workflow_TaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Custom_Workflow_TaskPersistenceImpl() {
		setModelClass(Custom_Workflow_Task.class);
	}

	/**
	 * Caches the custom_ workflow_ task in the entity cache if it is enabled.
	 *
	 * @param custom_Workflow_Task the custom_ workflow_ task
	 */
	@Override
	public void cacheResult(Custom_Workflow_Task custom_Workflow_Task) {
		entityCache.putResult(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TaskImpl.class,
			custom_Workflow_Task.getPrimaryKey(), custom_Workflow_Task);

		custom_Workflow_Task.resetOriginalValues();
	}

	/**
	 * Caches the custom_ workflow_ tasks in the entity cache if it is enabled.
	 *
	 * @param custom_Workflow_Tasks the custom_ workflow_ tasks
	 */
	@Override
	public void cacheResult(List<Custom_Workflow_Task> custom_Workflow_Tasks) {
		for (Custom_Workflow_Task custom_Workflow_Task : custom_Workflow_Tasks) {
			if (entityCache.getResult(
						Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
						Custom_Workflow_TaskImpl.class,
						custom_Workflow_Task.getPrimaryKey()) == null) {
				cacheResult(custom_Workflow_Task);
			}
			else {
				custom_Workflow_Task.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom_ workflow_ tasks.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Custom_Workflow_TaskImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom_ workflow_ task.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Custom_Workflow_Task custom_Workflow_Task) {
		entityCache.removeResult(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TaskImpl.class, custom_Workflow_Task.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Custom_Workflow_Task> custom_Workflow_Tasks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Custom_Workflow_Task custom_Workflow_Task : custom_Workflow_Tasks) {
			entityCache.removeResult(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
				Custom_Workflow_TaskImpl.class,
				custom_Workflow_Task.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom_ workflow_ task with the primary key. Does not add the custom_ workflow_ task to the database.
	 *
	 * @param workFlowTaskId the primary key for the new custom_ workflow_ task
	 * @return the new custom_ workflow_ task
	 */
	@Override
	public Custom_Workflow_Task create(String workFlowTaskId) {
		Custom_Workflow_Task custom_Workflow_Task = new Custom_Workflow_TaskImpl();

		custom_Workflow_Task.setNew(true);
		custom_Workflow_Task.setPrimaryKey(workFlowTaskId);

		return custom_Workflow_Task;
	}

	/**
	 * Removes the custom_ workflow_ task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFlowTaskId the primary key of the custom_ workflow_ task
	 * @return the custom_ workflow_ task that was removed
	 * @throws NoSuchCustom_Workflow_TaskException if a custom_ workflow_ task with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Task remove(String workFlowTaskId)
		throws NoSuchCustom_Workflow_TaskException {
		return remove((Serializable)workFlowTaskId);
	}

	/**
	 * Removes the custom_ workflow_ task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom_ workflow_ task
	 * @return the custom_ workflow_ task that was removed
	 * @throws NoSuchCustom_Workflow_TaskException if a custom_ workflow_ task with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Task remove(Serializable primaryKey)
		throws NoSuchCustom_Workflow_TaskException {
		Session session = null;

		try {
			session = openSession();

			Custom_Workflow_Task custom_Workflow_Task = (Custom_Workflow_Task)session.get(Custom_Workflow_TaskImpl.class,
					primaryKey);

			if (custom_Workflow_Task == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustom_Workflow_TaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(custom_Workflow_Task);
		}
		catch (NoSuchCustom_Workflow_TaskException nsee) {
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
	protected Custom_Workflow_Task removeImpl(
		Custom_Workflow_Task custom_Workflow_Task) {
		custom_Workflow_Task = toUnwrappedModel(custom_Workflow_Task);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(custom_Workflow_Task)) {
				custom_Workflow_Task = (Custom_Workflow_Task)session.get(Custom_Workflow_TaskImpl.class,
						custom_Workflow_Task.getPrimaryKeyObj());
			}

			if (custom_Workflow_Task != null) {
				session.delete(custom_Workflow_Task);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (custom_Workflow_Task != null) {
			clearCache(custom_Workflow_Task);
		}

		return custom_Workflow_Task;
	}

	@Override
	public Custom_Workflow_Task updateImpl(
		Custom_Workflow_Task custom_Workflow_Task) {
		custom_Workflow_Task = toUnwrappedModel(custom_Workflow_Task);

		boolean isNew = custom_Workflow_Task.isNew();

		Session session = null;

		try {
			session = openSession();

			if (custom_Workflow_Task.isNew()) {
				session.save(custom_Workflow_Task);

				custom_Workflow_Task.setNew(false);
			}
			else {
				custom_Workflow_Task = (Custom_Workflow_Task)session.merge(custom_Workflow_Task);
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

		entityCache.putResult(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
			Custom_Workflow_TaskImpl.class,
			custom_Workflow_Task.getPrimaryKey(), custom_Workflow_Task, false);

		custom_Workflow_Task.resetOriginalValues();

		return custom_Workflow_Task;
	}

	protected Custom_Workflow_Task toUnwrappedModel(
		Custom_Workflow_Task custom_Workflow_Task) {
		if (custom_Workflow_Task instanceof Custom_Workflow_TaskImpl) {
			return custom_Workflow_Task;
		}

		Custom_Workflow_TaskImpl custom_Workflow_TaskImpl = new Custom_Workflow_TaskImpl();

		custom_Workflow_TaskImpl.setNew(custom_Workflow_Task.isNew());
		custom_Workflow_TaskImpl.setPrimaryKey(custom_Workflow_Task.getPrimaryKey());

		custom_Workflow_TaskImpl.setWorkFlowTaskId(custom_Workflow_Task.getWorkFlowTaskId());
		custom_Workflow_TaskImpl.setWorkFlowId(custom_Workflow_Task.getWorkFlowId());
		custom_Workflow_TaskImpl.setTaskName(custom_Workflow_Task.getTaskName());
		custom_Workflow_TaskImpl.setRoleId(custom_Workflow_Task.getRoleId());
		custom_Workflow_TaskImpl.setRoleName(custom_Workflow_Task.getRoleName());
		custom_Workflow_TaskImpl.setComments(custom_Workflow_Task.getComments());
		custom_Workflow_TaskImpl.setCreatedDate(custom_Workflow_Task.getCreatedDate());
		custom_Workflow_TaskImpl.setCreatedBy(custom_Workflow_Task.getCreatedBy());

		return custom_Workflow_TaskImpl;
	}

	/**
	 * Returns the custom_ workflow_ task with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow_ task
	 * @return the custom_ workflow_ task
	 * @throws NoSuchCustom_Workflow_TaskException if a custom_ workflow_ task with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Task findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustom_Workflow_TaskException {
		Custom_Workflow_Task custom_Workflow_Task = fetchByPrimaryKey(primaryKey);

		if (custom_Workflow_Task == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustom_Workflow_TaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return custom_Workflow_Task;
	}

	/**
	 * Returns the custom_ workflow_ task with the primary key or throws a {@link NoSuchCustom_Workflow_TaskException} if it could not be found.
	 *
	 * @param workFlowTaskId the primary key of the custom_ workflow_ task
	 * @return the custom_ workflow_ task
	 * @throws NoSuchCustom_Workflow_TaskException if a custom_ workflow_ task with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Task findByPrimaryKey(String workFlowTaskId)
		throws NoSuchCustom_Workflow_TaskException {
		return findByPrimaryKey((Serializable)workFlowTaskId);
	}

	/**
	 * Returns the custom_ workflow_ task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow_ task
	 * @return the custom_ workflow_ task, or <code>null</code> if a custom_ workflow_ task with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Task fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
				Custom_Workflow_TaskImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Custom_Workflow_Task custom_Workflow_Task = (Custom_Workflow_Task)serializable;

		if (custom_Workflow_Task == null) {
			Session session = null;

			try {
				session = openSession();

				custom_Workflow_Task = (Custom_Workflow_Task)session.get(Custom_Workflow_TaskImpl.class,
						primaryKey);

				if (custom_Workflow_Task != null) {
					cacheResult(custom_Workflow_Task);
				}
				else {
					entityCache.putResult(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
						Custom_Workflow_TaskImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
					Custom_Workflow_TaskImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return custom_Workflow_Task;
	}

	/**
	 * Returns the custom_ workflow_ task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFlowTaskId the primary key of the custom_ workflow_ task
	 * @return the custom_ workflow_ task, or <code>null</code> if a custom_ workflow_ task with the primary key could not be found
	 */
	@Override
	public Custom_Workflow_Task fetchByPrimaryKey(String workFlowTaskId) {
		return fetchByPrimaryKey((Serializable)workFlowTaskId);
	}

	@Override
	public Map<Serializable, Custom_Workflow_Task> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Custom_Workflow_Task> map = new HashMap<Serializable, Custom_Workflow_Task>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Custom_Workflow_Task custom_Workflow_Task = fetchByPrimaryKey(primaryKey);

			if (custom_Workflow_Task != null) {
				map.put(primaryKey, custom_Workflow_Task);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
					Custom_Workflow_TaskImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Custom_Workflow_Task)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_CUSTOM_WORKFLOW_TASK_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Custom_Workflow_Task custom_Workflow_Task : (List<Custom_Workflow_Task>)q.list()) {
				map.put(custom_Workflow_Task.getPrimaryKeyObj(),
					custom_Workflow_Task);

				cacheResult(custom_Workflow_Task);

				uncachedPrimaryKeys.remove(custom_Workflow_Task.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Custom_Workflow_TaskModelImpl.ENTITY_CACHE_ENABLED,
					Custom_Workflow_TaskImpl.class, primaryKey, nullModel);
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
	 * Returns all the custom_ workflow_ tasks.
	 *
	 * @return the custom_ workflow_ tasks
	 */
	@Override
	public List<Custom_Workflow_Task> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the custom_ workflow_ tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow_ tasks
	 * @param end the upper bound of the range of custom_ workflow_ tasks (not inclusive)
	 * @return the range of custom_ workflow_ tasks
	 */
	@Override
	public List<Custom_Workflow_Task> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the custom_ workflow_ tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow_ tasks
	 * @param end the upper bound of the range of custom_ workflow_ tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom_ workflow_ tasks
	 */
	@Override
	public List<Custom_Workflow_Task> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Task> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the custom_ workflow_ tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_Workflow_TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflow_ tasks
	 * @param end the upper bound of the range of custom_ workflow_ tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of custom_ workflow_ tasks
	 */
	@Override
	public List<Custom_Workflow_Task> findAll(int start, int end,
		OrderByComparator<Custom_Workflow_Task> orderByComparator,
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

		List<Custom_Workflow_Task> list = null;

		if (retrieveFromCache) {
			list = (List<Custom_Workflow_Task>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOM_WORKFLOW_TASK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOM_WORKFLOW_TASK;

				if (pagination) {
					sql = sql.concat(Custom_Workflow_TaskModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Custom_Workflow_Task>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Custom_Workflow_Task>)QueryUtil.list(q,
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
	 * Removes all the custom_ workflow_ tasks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Custom_Workflow_Task custom_Workflow_Task : findAll()) {
			remove(custom_Workflow_Task);
		}
	}

	/**
	 * Returns the number of custom_ workflow_ tasks.
	 *
	 * @return the number of custom_ workflow_ tasks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOM_WORKFLOW_TASK);

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
		return Custom_Workflow_TaskModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom_ workflow_ task persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Custom_Workflow_TaskImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOM_WORKFLOW_TASK = "SELECT custom_Workflow_Task FROM Custom_Workflow_Task custom_Workflow_Task";
	private static final String _SQL_SELECT_CUSTOM_WORKFLOW_TASK_WHERE_PKS_IN = "SELECT custom_Workflow_Task FROM Custom_Workflow_Task custom_Workflow_Task WHERE workFlowTaskId IN (";
	private static final String _SQL_COUNT_CUSTOM_WORKFLOW_TASK = "SELECT COUNT(custom_Workflow_Task) FROM Custom_Workflow_Task custom_Workflow_Task";
	private static final String _ORDER_BY_ENTITY_ALIAS = "custom_Workflow_Task.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Custom_Workflow_Task exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(Custom_Workflow_TaskPersistenceImpl.class);
}