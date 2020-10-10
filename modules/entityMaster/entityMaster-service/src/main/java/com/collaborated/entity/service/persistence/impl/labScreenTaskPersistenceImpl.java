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

import com.collaborated.entity.exception.NoSuchlabScreenTaskException;
import com.collaborated.entity.model.impl.labScreenTaskImpl;
import com.collaborated.entity.model.impl.labScreenTaskModelImpl;
import com.collaborated.entity.model.labScreenTask;
import com.collaborated.entity.service.persistence.labScreenTaskPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the lab screen task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenTaskPersistence
 * @see com.collaborated.entity.service.persistence.labScreenTaskUtil
 * @generated
 */
@ProviderType
public class labScreenTaskPersistenceImpl extends BasePersistenceImpl<labScreenTask>
	implements labScreenTaskPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labScreenTaskUtil} to access the lab screen task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labScreenTaskImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
			labScreenTaskModelImpl.FINDER_CACHE_ENABLED,
			labScreenTaskImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
			labScreenTaskModelImpl.FINDER_CACHE_ENABLED,
			labScreenTaskImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
			labScreenTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public labScreenTaskPersistenceImpl() {
		setModelClass(labScreenTask.class);
	}

	/**
	 * Caches the lab screen task in the entity cache if it is enabled.
	 *
	 * @param labScreenTask the lab screen task
	 */
	@Override
	public void cacheResult(labScreenTask labScreenTask) {
		entityCache.putResult(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
			labScreenTaskImpl.class, labScreenTask.getPrimaryKey(),
			labScreenTask);

		labScreenTask.resetOriginalValues();
	}

	/**
	 * Caches the lab screen tasks in the entity cache if it is enabled.
	 *
	 * @param labScreenTasks the lab screen tasks
	 */
	@Override
	public void cacheResult(List<labScreenTask> labScreenTasks) {
		for (labScreenTask labScreenTask : labScreenTasks) {
			if (entityCache.getResult(
						labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
						labScreenTaskImpl.class, labScreenTask.getPrimaryKey()) == null) {
				cacheResult(labScreenTask);
			}
			else {
				labScreenTask.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab screen tasks.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labScreenTaskImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab screen task.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(labScreenTask labScreenTask) {
		entityCache.removeResult(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
			labScreenTaskImpl.class, labScreenTask.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<labScreenTask> labScreenTasks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labScreenTask labScreenTask : labScreenTasks) {
			entityCache.removeResult(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
				labScreenTaskImpl.class, labScreenTask.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lab screen task with the primary key. Does not add the lab screen task to the database.
	 *
	 * @param PK_taskId the primary key for the new lab screen task
	 * @return the new lab screen task
	 */
	@Override
	public labScreenTask create(long PK_taskId) {
		labScreenTask labScreenTask = new labScreenTaskImpl();

		labScreenTask.setNew(true);
		labScreenTask.setPrimaryKey(PK_taskId);

		return labScreenTask;
	}

	/**
	 * Removes the lab screen task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_taskId the primary key of the lab screen task
	 * @return the lab screen task that was removed
	 * @throws NoSuchlabScreenTaskException if a lab screen task with the primary key could not be found
	 */
	@Override
	public labScreenTask remove(long PK_taskId)
		throws NoSuchlabScreenTaskException {
		return remove((Serializable)PK_taskId);
	}

	/**
	 * Removes the lab screen task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab screen task
	 * @return the lab screen task that was removed
	 * @throws NoSuchlabScreenTaskException if a lab screen task with the primary key could not be found
	 */
	@Override
	public labScreenTask remove(Serializable primaryKey)
		throws NoSuchlabScreenTaskException {
		Session session = null;

		try {
			session = openSession();

			labScreenTask labScreenTask = (labScreenTask)session.get(labScreenTaskImpl.class,
					primaryKey);

			if (labScreenTask == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabScreenTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labScreenTask);
		}
		catch (NoSuchlabScreenTaskException nsee) {
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
	protected labScreenTask removeImpl(labScreenTask labScreenTask) {
		labScreenTask = toUnwrappedModel(labScreenTask);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labScreenTask)) {
				labScreenTask = (labScreenTask)session.get(labScreenTaskImpl.class,
						labScreenTask.getPrimaryKeyObj());
			}

			if (labScreenTask != null) {
				session.delete(labScreenTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labScreenTask != null) {
			clearCache(labScreenTask);
		}

		return labScreenTask;
	}

	@Override
	public labScreenTask updateImpl(labScreenTask labScreenTask) {
		labScreenTask = toUnwrappedModel(labScreenTask);

		boolean isNew = labScreenTask.isNew();

		labScreenTaskModelImpl labScreenTaskModelImpl = (labScreenTaskModelImpl)labScreenTask;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labScreenTask.getCreateDate() == null)) {
			if (serviceContext == null) {
				labScreenTask.setCreateDate(now);
			}
			else {
				labScreenTask.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!labScreenTaskModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labScreenTask.setModifiedDate(now);
			}
			else {
				labScreenTask.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labScreenTask.isNew()) {
				session.save(labScreenTask);

				labScreenTask.setNew(false);
			}
			else {
				labScreenTask = (labScreenTask)session.merge(labScreenTask);
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

		entityCache.putResult(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
			labScreenTaskImpl.class, labScreenTask.getPrimaryKey(),
			labScreenTask, false);

		labScreenTask.resetOriginalValues();

		return labScreenTask;
	}

	protected labScreenTask toUnwrappedModel(labScreenTask labScreenTask) {
		if (labScreenTask instanceof labScreenTaskImpl) {
			return labScreenTask;
		}

		labScreenTaskImpl labScreenTaskImpl = new labScreenTaskImpl();

		labScreenTaskImpl.setNew(labScreenTask.isNew());
		labScreenTaskImpl.setPrimaryKey(labScreenTask.getPrimaryKey());

		labScreenTaskImpl.setPK_taskId(labScreenTask.getPK_taskId());
		labScreenTaskImpl.setGroupId(labScreenTask.getGroupId());
		labScreenTaskImpl.setUserId(labScreenTask.getUserId());
		labScreenTaskImpl.setCreateDate(labScreenTask.getCreateDate());
		labScreenTaskImpl.setModifiedDate(labScreenTask.getModifiedDate());
		labScreenTaskImpl.setPK_projectId(labScreenTask.getPK_projectId());
		labScreenTaskImpl.setMilestoneName(labScreenTask.getMilestoneName());
		labScreenTaskImpl.setTaskName(labScreenTask.getTaskName());
		labScreenTaskImpl.setProjectAssignedTo(labScreenTask.getProjectAssignedTo());
		labScreenTaskImpl.setTaskDescription(labScreenTask.getTaskDescription());
		labScreenTaskImpl.setTaskStatus(labScreenTask.getTaskStatus());
		labScreenTaskImpl.setDueDate(labScreenTask.getDueDate());

		return labScreenTaskImpl;
	}

	/**
	 * Returns the lab screen task with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab screen task
	 * @return the lab screen task
	 * @throws NoSuchlabScreenTaskException if a lab screen task with the primary key could not be found
	 */
	@Override
	public labScreenTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlabScreenTaskException {
		labScreenTask labScreenTask = fetchByPrimaryKey(primaryKey);

		if (labScreenTask == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabScreenTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labScreenTask;
	}

	/**
	 * Returns the lab screen task with the primary key or throws a {@link NoSuchlabScreenTaskException} if it could not be found.
	 *
	 * @param PK_taskId the primary key of the lab screen task
	 * @return the lab screen task
	 * @throws NoSuchlabScreenTaskException if a lab screen task with the primary key could not be found
	 */
	@Override
	public labScreenTask findByPrimaryKey(long PK_taskId)
		throws NoSuchlabScreenTaskException {
		return findByPrimaryKey((Serializable)PK_taskId);
	}

	/**
	 * Returns the lab screen task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab screen task
	 * @return the lab screen task, or <code>null</code> if a lab screen task with the primary key could not be found
	 */
	@Override
	public labScreenTask fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
				labScreenTaskImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labScreenTask labScreenTask = (labScreenTask)serializable;

		if (labScreenTask == null) {
			Session session = null;

			try {
				session = openSession();

				labScreenTask = (labScreenTask)session.get(labScreenTaskImpl.class,
						primaryKey);

				if (labScreenTask != null) {
					cacheResult(labScreenTask);
				}
				else {
					entityCache.putResult(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
						labScreenTaskImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
					labScreenTaskImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labScreenTask;
	}

	/**
	 * Returns the lab screen task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_taskId the primary key of the lab screen task
	 * @return the lab screen task, or <code>null</code> if a lab screen task with the primary key could not be found
	 */
	@Override
	public labScreenTask fetchByPrimaryKey(long PK_taskId) {
		return fetchByPrimaryKey((Serializable)PK_taskId);
	}

	@Override
	public Map<Serializable, labScreenTask> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labScreenTask> map = new HashMap<Serializable, labScreenTask>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labScreenTask labScreenTask = fetchByPrimaryKey(primaryKey);

			if (labScreenTask != null) {
				map.put(primaryKey, labScreenTask);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
					labScreenTaskImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (labScreenTask)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABSCREENTASK_WHERE_PKS_IN);

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

			for (labScreenTask labScreenTask : (List<labScreenTask>)q.list()) {
				map.put(labScreenTask.getPrimaryKeyObj(), labScreenTask);

				cacheResult(labScreenTask);

				uncachedPrimaryKeys.remove(labScreenTask.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labScreenTaskModelImpl.ENTITY_CACHE_ENABLED,
					labScreenTaskImpl.class, primaryKey, nullModel);
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
	 * Returns all the lab screen tasks.
	 *
	 * @return the lab screen tasks
	 */
	@Override
	public List<labScreenTask> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab screen tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab screen tasks
	 * @param end the upper bound of the range of lab screen tasks (not inclusive)
	 * @return the range of lab screen tasks
	 */
	@Override
	public List<labScreenTask> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab screen tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab screen tasks
	 * @param end the upper bound of the range of lab screen tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab screen tasks
	 */
	@Override
	public List<labScreenTask> findAll(int start, int end,
		OrderByComparator<labScreenTask> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab screen tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab screen tasks
	 * @param end the upper bound of the range of lab screen tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab screen tasks
	 */
	@Override
	public List<labScreenTask> findAll(int start, int end,
		OrderByComparator<labScreenTask> orderByComparator,
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

		List<labScreenTask> list = null;

		if (retrieveFromCache) {
			list = (List<labScreenTask>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABSCREENTASK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABSCREENTASK;

				if (pagination) {
					sql = sql.concat(labScreenTaskModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labScreenTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labScreenTask>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the lab screen tasks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labScreenTask labScreenTask : findAll()) {
			remove(labScreenTask);
		}
	}

	/**
	 * Returns the number of lab screen tasks.
	 *
	 * @return the number of lab screen tasks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABSCREENTASK);

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
		return labScreenTaskModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab screen task persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labScreenTaskImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABSCREENTASK = "SELECT labScreenTask FROM labScreenTask labScreenTask";
	private static final String _SQL_SELECT_LABSCREENTASK_WHERE_PKS_IN = "SELECT labScreenTask FROM labScreenTask labScreenTask WHERE PK_taskId IN (";
	private static final String _SQL_COUNT_LABSCREENTASK = "SELECT COUNT(labScreenTask) FROM labScreenTask labScreenTask";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labScreenTask.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labScreenTask exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(labScreenTaskPersistenceImpl.class);
}