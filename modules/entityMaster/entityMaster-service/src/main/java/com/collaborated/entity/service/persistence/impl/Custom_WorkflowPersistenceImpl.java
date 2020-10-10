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

import com.collaborated.entity.exception.NoSuchCustom_WorkflowException;
import com.collaborated.entity.model.Custom_Workflow;
import com.collaborated.entity.model.impl.Custom_WorkflowImpl;
import com.collaborated.entity.model.impl.Custom_WorkflowModelImpl;
import com.collaborated.entity.service.persistence.Custom_WorkflowPersistence;

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
 * The persistence implementation for the custom_ workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowPersistence
 * @see com.collaborated.entity.service.persistence.Custom_WorkflowUtil
 * @generated
 */
@ProviderType
public class Custom_WorkflowPersistenceImpl extends BasePersistenceImpl<Custom_Workflow>
	implements Custom_WorkflowPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Custom_WorkflowUtil} to access the custom_ workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Custom_WorkflowImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowModelImpl.FINDER_CACHE_ENABLED,
			Custom_WorkflowImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowModelImpl.FINDER_CACHE_ENABLED,
			Custom_WorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Custom_WorkflowPersistenceImpl() {
		setModelClass(Custom_Workflow.class);
	}

	/**
	 * Caches the custom_ workflow in the entity cache if it is enabled.
	 *
	 * @param custom_Workflow the custom_ workflow
	 */
	@Override
	public void cacheResult(Custom_Workflow custom_Workflow) {
		entityCache.putResult(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowImpl.class, custom_Workflow.getPrimaryKey(),
			custom_Workflow);

		custom_Workflow.resetOriginalValues();
	}

	/**
	 * Caches the custom_ workflows in the entity cache if it is enabled.
	 *
	 * @param custom_Workflows the custom_ workflows
	 */
	@Override
	public void cacheResult(List<Custom_Workflow> custom_Workflows) {
		for (Custom_Workflow custom_Workflow : custom_Workflows) {
			if (entityCache.getResult(
						Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
						Custom_WorkflowImpl.class,
						custom_Workflow.getPrimaryKey()) == null) {
				cacheResult(custom_Workflow);
			}
			else {
				custom_Workflow.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom_ workflows.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Custom_WorkflowImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom_ workflow.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Custom_Workflow custom_Workflow) {
		entityCache.removeResult(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowImpl.class, custom_Workflow.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Custom_Workflow> custom_Workflows) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Custom_Workflow custom_Workflow : custom_Workflows) {
			entityCache.removeResult(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
				Custom_WorkflowImpl.class, custom_Workflow.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom_ workflow with the primary key. Does not add the custom_ workflow to the database.
	 *
	 * @param workFlowId the primary key for the new custom_ workflow
	 * @return the new custom_ workflow
	 */
	@Override
	public Custom_Workflow create(long workFlowId) {
		Custom_Workflow custom_Workflow = new Custom_WorkflowImpl();

		custom_Workflow.setNew(true);
		custom_Workflow.setPrimaryKey(workFlowId);

		return custom_Workflow;
	}

	/**
	 * Removes the custom_ workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFlowId the primary key of the custom_ workflow
	 * @return the custom_ workflow that was removed
	 * @throws NoSuchCustom_WorkflowException if a custom_ workflow with the primary key could not be found
	 */
	@Override
	public Custom_Workflow remove(long workFlowId)
		throws NoSuchCustom_WorkflowException {
		return remove((Serializable)workFlowId);
	}

	/**
	 * Removes the custom_ workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom_ workflow
	 * @return the custom_ workflow that was removed
	 * @throws NoSuchCustom_WorkflowException if a custom_ workflow with the primary key could not be found
	 */
	@Override
	public Custom_Workflow remove(Serializable primaryKey)
		throws NoSuchCustom_WorkflowException {
		Session session = null;

		try {
			session = openSession();

			Custom_Workflow custom_Workflow = (Custom_Workflow)session.get(Custom_WorkflowImpl.class,
					primaryKey);

			if (custom_Workflow == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustom_WorkflowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(custom_Workflow);
		}
		catch (NoSuchCustom_WorkflowException nsee) {
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
	protected Custom_Workflow removeImpl(Custom_Workflow custom_Workflow) {
		custom_Workflow = toUnwrappedModel(custom_Workflow);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(custom_Workflow)) {
				custom_Workflow = (Custom_Workflow)session.get(Custom_WorkflowImpl.class,
						custom_Workflow.getPrimaryKeyObj());
			}

			if (custom_Workflow != null) {
				session.delete(custom_Workflow);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (custom_Workflow != null) {
			clearCache(custom_Workflow);
		}

		return custom_Workflow;
	}

	@Override
	public Custom_Workflow updateImpl(Custom_Workflow custom_Workflow) {
		custom_Workflow = toUnwrappedModel(custom_Workflow);

		boolean isNew = custom_Workflow.isNew();

		Session session = null;

		try {
			session = openSession();

			if (custom_Workflow.isNew()) {
				session.save(custom_Workflow);

				custom_Workflow.setNew(false);
			}
			else {
				custom_Workflow = (Custom_Workflow)session.merge(custom_Workflow);
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

		entityCache.putResult(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			Custom_WorkflowImpl.class, custom_Workflow.getPrimaryKey(),
			custom_Workflow, false);

		custom_Workflow.resetOriginalValues();

		return custom_Workflow;
	}

	protected Custom_Workflow toUnwrappedModel(Custom_Workflow custom_Workflow) {
		if (custom_Workflow instanceof Custom_WorkflowImpl) {
			return custom_Workflow;
		}

		Custom_WorkflowImpl custom_WorkflowImpl = new Custom_WorkflowImpl();

		custom_WorkflowImpl.setNew(custom_Workflow.isNew());
		custom_WorkflowImpl.setPrimaryKey(custom_Workflow.getPrimaryKey());

		custom_WorkflowImpl.setWorkFlowId(custom_Workflow.getWorkFlowId());
		custom_WorkflowImpl.setWorkFlowName(custom_Workflow.getWorkFlowName());
		custom_WorkflowImpl.setStartWorkflowTaskId(custom_Workflow.getStartWorkflowTaskId());
		custom_WorkflowImpl.setComments(custom_Workflow.getComments());
		custom_WorkflowImpl.setIsActive(custom_Workflow.getIsActive());
		custom_WorkflowImpl.setCreatedDate(custom_Workflow.getCreatedDate());
		custom_WorkflowImpl.setCreatedBy(custom_Workflow.getCreatedBy());

		return custom_WorkflowImpl;
	}

	/**
	 * Returns the custom_ workflow with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow
	 * @return the custom_ workflow
	 * @throws NoSuchCustom_WorkflowException if a custom_ workflow with the primary key could not be found
	 */
	@Override
	public Custom_Workflow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustom_WorkflowException {
		Custom_Workflow custom_Workflow = fetchByPrimaryKey(primaryKey);

		if (custom_Workflow == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustom_WorkflowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return custom_Workflow;
	}

	/**
	 * Returns the custom_ workflow with the primary key or throws a {@link NoSuchCustom_WorkflowException} if it could not be found.
	 *
	 * @param workFlowId the primary key of the custom_ workflow
	 * @return the custom_ workflow
	 * @throws NoSuchCustom_WorkflowException if a custom_ workflow with the primary key could not be found
	 */
	@Override
	public Custom_Workflow findByPrimaryKey(long workFlowId)
		throws NoSuchCustom_WorkflowException {
		return findByPrimaryKey((Serializable)workFlowId);
	}

	/**
	 * Returns the custom_ workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ workflow
	 * @return the custom_ workflow, or <code>null</code> if a custom_ workflow with the primary key could not be found
	 */
	@Override
	public Custom_Workflow fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
				Custom_WorkflowImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Custom_Workflow custom_Workflow = (Custom_Workflow)serializable;

		if (custom_Workflow == null) {
			Session session = null;

			try {
				session = openSession();

				custom_Workflow = (Custom_Workflow)session.get(Custom_WorkflowImpl.class,
						primaryKey);

				if (custom_Workflow != null) {
					cacheResult(custom_Workflow);
				}
				else {
					entityCache.putResult(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
						Custom_WorkflowImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
					Custom_WorkflowImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return custom_Workflow;
	}

	/**
	 * Returns the custom_ workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFlowId the primary key of the custom_ workflow
	 * @return the custom_ workflow, or <code>null</code> if a custom_ workflow with the primary key could not be found
	 */
	@Override
	public Custom_Workflow fetchByPrimaryKey(long workFlowId) {
		return fetchByPrimaryKey((Serializable)workFlowId);
	}

	@Override
	public Map<Serializable, Custom_Workflow> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Custom_Workflow> map = new HashMap<Serializable, Custom_Workflow>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Custom_Workflow custom_Workflow = fetchByPrimaryKey(primaryKey);

			if (custom_Workflow != null) {
				map.put(primaryKey, custom_Workflow);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
					Custom_WorkflowImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Custom_Workflow)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOM_WORKFLOW_WHERE_PKS_IN);

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

			for (Custom_Workflow custom_Workflow : (List<Custom_Workflow>)q.list()) {
				map.put(custom_Workflow.getPrimaryKeyObj(), custom_Workflow);

				cacheResult(custom_Workflow);

				uncachedPrimaryKeys.remove(custom_Workflow.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Custom_WorkflowModelImpl.ENTITY_CACHE_ENABLED,
					Custom_WorkflowImpl.class, primaryKey, nullModel);
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
	 * Returns all the custom_ workflows.
	 *
	 * @return the custom_ workflows
	 */
	@Override
	public List<Custom_Workflow> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the custom_ workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflows
	 * @param end the upper bound of the range of custom_ workflows (not inclusive)
	 * @return the range of custom_ workflows
	 */
	@Override
	public List<Custom_Workflow> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the custom_ workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflows
	 * @param end the upper bound of the range of custom_ workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom_ workflows
	 */
	@Override
	public List<Custom_Workflow> findAll(int start, int end,
		OrderByComparator<Custom_Workflow> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the custom_ workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ workflows
	 * @param end the upper bound of the range of custom_ workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of custom_ workflows
	 */
	@Override
	public List<Custom_Workflow> findAll(int start, int end,
		OrderByComparator<Custom_Workflow> orderByComparator,
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

		List<Custom_Workflow> list = null;

		if (retrieveFromCache) {
			list = (List<Custom_Workflow>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOM_WORKFLOW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOM_WORKFLOW;

				if (pagination) {
					sql = sql.concat(Custom_WorkflowModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Custom_Workflow>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Custom_Workflow>)QueryUtil.list(q,
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
	 * Removes all the custom_ workflows from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Custom_Workflow custom_Workflow : findAll()) {
			remove(custom_Workflow);
		}
	}

	/**
	 * Returns the number of custom_ workflows.
	 *
	 * @return the number of custom_ workflows
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOM_WORKFLOW);

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
		return Custom_WorkflowModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom_ workflow persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Custom_WorkflowImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOM_WORKFLOW = "SELECT custom_Workflow FROM Custom_Workflow custom_Workflow";
	private static final String _SQL_SELECT_CUSTOM_WORKFLOW_WHERE_PKS_IN = "SELECT custom_Workflow FROM Custom_Workflow custom_Workflow WHERE workFlowId IN (";
	private static final String _SQL_COUNT_CUSTOM_WORKFLOW = "SELECT COUNT(custom_Workflow) FROM Custom_Workflow custom_Workflow";
	private static final String _ORDER_BY_ENTITY_ALIAS = "custom_Workflow.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Custom_Workflow exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(Custom_WorkflowPersistenceImpl.class);
}