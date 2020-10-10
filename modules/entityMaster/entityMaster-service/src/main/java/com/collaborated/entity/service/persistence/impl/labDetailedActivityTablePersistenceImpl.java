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

import com.collaborated.entity.exception.NoSuchlabDetailedActivityTableException;
import com.collaborated.entity.model.impl.labDetailedActivityTableImpl;
import com.collaborated.entity.model.impl.labDetailedActivityTableModelImpl;
import com.collaborated.entity.model.labDetailedActivityTable;
import com.collaborated.entity.service.persistence.labDetailedActivityTablePersistence;

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
 * The persistence implementation for the lab detailed activity table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedActivityTablePersistence
 * @see com.collaborated.entity.service.persistence.labDetailedActivityTableUtil
 * @generated
 */
@ProviderType
public class labDetailedActivityTablePersistenceImpl extends BasePersistenceImpl<labDetailedActivityTable>
	implements labDetailedActivityTablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labDetailedActivityTableUtil} to access the lab detailed activity table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labDetailedActivityTableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedActivityTableModelImpl.FINDER_CACHE_ENABLED,
			labDetailedActivityTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedActivityTableModelImpl.FINDER_CACHE_ENABLED,
			labDetailedActivityTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedActivityTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public labDetailedActivityTablePersistenceImpl() {
		setModelClass(labDetailedActivityTable.class);
	}

	/**
	 * Caches the lab detailed activity table in the entity cache if it is enabled.
	 *
	 * @param labDetailedActivityTable the lab detailed activity table
	 */
	@Override
	public void cacheResult(labDetailedActivityTable labDetailedActivityTable) {
		entityCache.putResult(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedActivityTableImpl.class,
			labDetailedActivityTable.getPrimaryKey(), labDetailedActivityTable);

		labDetailedActivityTable.resetOriginalValues();
	}

	/**
	 * Caches the lab detailed activity tables in the entity cache if it is enabled.
	 *
	 * @param labDetailedActivityTables the lab detailed activity tables
	 */
	@Override
	public void cacheResult(
		List<labDetailedActivityTable> labDetailedActivityTables) {
		for (labDetailedActivityTable labDetailedActivityTable : labDetailedActivityTables) {
			if (entityCache.getResult(
						labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedActivityTableImpl.class,
						labDetailedActivityTable.getPrimaryKey()) == null) {
				cacheResult(labDetailedActivityTable);
			}
			else {
				labDetailedActivityTable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab detailed activity tables.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labDetailedActivityTableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab detailed activity table.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(labDetailedActivityTable labDetailedActivityTable) {
		entityCache.removeResult(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedActivityTableImpl.class,
			labDetailedActivityTable.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<labDetailedActivityTable> labDetailedActivityTables) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labDetailedActivityTable labDetailedActivityTable : labDetailedActivityTables) {
			entityCache.removeResult(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedActivityTableImpl.class,
				labDetailedActivityTable.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lab detailed activity table with the primary key. Does not add the lab detailed activity table to the database.
	 *
	 * @param PK_activityTableId the primary key for the new lab detailed activity table
	 * @return the new lab detailed activity table
	 */
	@Override
	public labDetailedActivityTable create(long PK_activityTableId) {
		labDetailedActivityTable labDetailedActivityTable = new labDetailedActivityTableImpl();

		labDetailedActivityTable.setNew(true);
		labDetailedActivityTable.setPrimaryKey(PK_activityTableId);

		return labDetailedActivityTable;
	}

	/**
	 * Removes the lab detailed activity table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_activityTableId the primary key of the lab detailed activity table
	 * @return the lab detailed activity table that was removed
	 * @throws NoSuchlabDetailedActivityTableException if a lab detailed activity table with the primary key could not be found
	 */
	@Override
	public labDetailedActivityTable remove(long PK_activityTableId)
		throws NoSuchlabDetailedActivityTableException {
		return remove((Serializable)PK_activityTableId);
	}

	/**
	 * Removes the lab detailed activity table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab detailed activity table
	 * @return the lab detailed activity table that was removed
	 * @throws NoSuchlabDetailedActivityTableException if a lab detailed activity table with the primary key could not be found
	 */
	@Override
	public labDetailedActivityTable remove(Serializable primaryKey)
		throws NoSuchlabDetailedActivityTableException {
		Session session = null;

		try {
			session = openSession();

			labDetailedActivityTable labDetailedActivityTable = (labDetailedActivityTable)session.get(labDetailedActivityTableImpl.class,
					primaryKey);

			if (labDetailedActivityTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabDetailedActivityTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labDetailedActivityTable);
		}
		catch (NoSuchlabDetailedActivityTableException nsee) {
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
	protected labDetailedActivityTable removeImpl(
		labDetailedActivityTable labDetailedActivityTable) {
		labDetailedActivityTable = toUnwrappedModel(labDetailedActivityTable);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labDetailedActivityTable)) {
				labDetailedActivityTable = (labDetailedActivityTable)session.get(labDetailedActivityTableImpl.class,
						labDetailedActivityTable.getPrimaryKeyObj());
			}

			if (labDetailedActivityTable != null) {
				session.delete(labDetailedActivityTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labDetailedActivityTable != null) {
			clearCache(labDetailedActivityTable);
		}

		return labDetailedActivityTable;
	}

	@Override
	public labDetailedActivityTable updateImpl(
		labDetailedActivityTable labDetailedActivityTable) {
		labDetailedActivityTable = toUnwrappedModel(labDetailedActivityTable);

		boolean isNew = labDetailedActivityTable.isNew();

		labDetailedActivityTableModelImpl labDetailedActivityTableModelImpl = (labDetailedActivityTableModelImpl)labDetailedActivityTable;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labDetailedActivityTable.getCreateDate() == null)) {
			if (serviceContext == null) {
				labDetailedActivityTable.setCreateDate(now);
			}
			else {
				labDetailedActivityTable.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labDetailedActivityTableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labDetailedActivityTable.setModifiedDate(now);
			}
			else {
				labDetailedActivityTable.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labDetailedActivityTable.isNew()) {
				session.save(labDetailedActivityTable);

				labDetailedActivityTable.setNew(false);
			}
			else {
				labDetailedActivityTable = (labDetailedActivityTable)session.merge(labDetailedActivityTable);
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

		entityCache.putResult(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedActivityTableImpl.class,
			labDetailedActivityTable.getPrimaryKey(), labDetailedActivityTable,
			false);

		labDetailedActivityTable.resetOriginalValues();

		return labDetailedActivityTable;
	}

	protected labDetailedActivityTable toUnwrappedModel(
		labDetailedActivityTable labDetailedActivityTable) {
		if (labDetailedActivityTable instanceof labDetailedActivityTableImpl) {
			return labDetailedActivityTable;
		}

		labDetailedActivityTableImpl labDetailedActivityTableImpl = new labDetailedActivityTableImpl();

		labDetailedActivityTableImpl.setNew(labDetailedActivityTable.isNew());
		labDetailedActivityTableImpl.setPrimaryKey(labDetailedActivityTable.getPrimaryKey());

		labDetailedActivityTableImpl.setPK_activityTableId(labDetailedActivityTable.getPK_activityTableId());
		labDetailedActivityTableImpl.setGroupId(labDetailedActivityTable.getGroupId());
		labDetailedActivityTableImpl.setUserId(labDetailedActivityTable.getUserId());
		labDetailedActivityTableImpl.setCreateDate(labDetailedActivityTable.getCreateDate());
		labDetailedActivityTableImpl.setModifiedDate(labDetailedActivityTable.getModifiedDate());
		labDetailedActivityTableImpl.setPK_projectId(labDetailedActivityTable.getPK_projectId());
		labDetailedActivityTableImpl.setPK_courseId(labDetailedActivityTable.getPK_courseId());
		labDetailedActivityTableImpl.setWeek(labDetailedActivityTable.getWeek());
		labDetailedActivityTableImpl.setCourseObjective(labDetailedActivityTable.getCourseObjective());
		labDetailedActivityTableImpl.setLearningEnvironmentDesign(labDetailedActivityTable.getLearningEnvironmentDesign());
		labDetailedActivityTableImpl.setActivity(labDetailedActivityTable.getActivity());
		labDetailedActivityTableImpl.setContent(labDetailedActivityTable.getContent());

		return labDetailedActivityTableImpl;
	}

	/**
	 * Returns the lab detailed activity table with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed activity table
	 * @return the lab detailed activity table
	 * @throws NoSuchlabDetailedActivityTableException if a lab detailed activity table with the primary key could not be found
	 */
	@Override
	public labDetailedActivityTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlabDetailedActivityTableException {
		labDetailedActivityTable labDetailedActivityTable = fetchByPrimaryKey(primaryKey);

		if (labDetailedActivityTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabDetailedActivityTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labDetailedActivityTable;
	}

	/**
	 * Returns the lab detailed activity table with the primary key or throws a {@link NoSuchlabDetailedActivityTableException} if it could not be found.
	 *
	 * @param PK_activityTableId the primary key of the lab detailed activity table
	 * @return the lab detailed activity table
	 * @throws NoSuchlabDetailedActivityTableException if a lab detailed activity table with the primary key could not be found
	 */
	@Override
	public labDetailedActivityTable findByPrimaryKey(long PK_activityTableId)
		throws NoSuchlabDetailedActivityTableException {
		return findByPrimaryKey((Serializable)PK_activityTableId);
	}

	/**
	 * Returns the lab detailed activity table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed activity table
	 * @return the lab detailed activity table, or <code>null</code> if a lab detailed activity table with the primary key could not be found
	 */
	@Override
	public labDetailedActivityTable fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedActivityTableImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labDetailedActivityTable labDetailedActivityTable = (labDetailedActivityTable)serializable;

		if (labDetailedActivityTable == null) {
			Session session = null;

			try {
				session = openSession();

				labDetailedActivityTable = (labDetailedActivityTable)session.get(labDetailedActivityTableImpl.class,
						primaryKey);

				if (labDetailedActivityTable != null) {
					cacheResult(labDetailedActivityTable);
				}
				else {
					entityCache.putResult(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedActivityTableImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedActivityTableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labDetailedActivityTable;
	}

	/**
	 * Returns the lab detailed activity table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_activityTableId the primary key of the lab detailed activity table
	 * @return the lab detailed activity table, or <code>null</code> if a lab detailed activity table with the primary key could not be found
	 */
	@Override
	public labDetailedActivityTable fetchByPrimaryKey(long PK_activityTableId) {
		return fetchByPrimaryKey((Serializable)PK_activityTableId);
	}

	@Override
	public Map<Serializable, labDetailedActivityTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labDetailedActivityTable> map = new HashMap<Serializable, labDetailedActivityTable>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labDetailedActivityTable labDetailedActivityTable = fetchByPrimaryKey(primaryKey);

			if (labDetailedActivityTable != null) {
				map.put(primaryKey, labDetailedActivityTable);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedActivityTableImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (labDetailedActivityTable)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABDETAILEDACTIVITYTABLE_WHERE_PKS_IN);

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

			for (labDetailedActivityTable labDetailedActivityTable : (List<labDetailedActivityTable>)q.list()) {
				map.put(labDetailedActivityTable.getPrimaryKeyObj(),
					labDetailedActivityTable);

				cacheResult(labDetailedActivityTable);

				uncachedPrimaryKeys.remove(labDetailedActivityTable.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labDetailedActivityTableModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedActivityTableImpl.class, primaryKey, nullModel);
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
	 * Returns all the lab detailed activity tables.
	 *
	 * @return the lab detailed activity tables
	 */
	@Override
	public List<labDetailedActivityTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab detailed activity tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedActivityTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed activity tables
	 * @param end the upper bound of the range of lab detailed activity tables (not inclusive)
	 * @return the range of lab detailed activity tables
	 */
	@Override
	public List<labDetailedActivityTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab detailed activity tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedActivityTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed activity tables
	 * @param end the upper bound of the range of lab detailed activity tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab detailed activity tables
	 */
	@Override
	public List<labDetailedActivityTable> findAll(int start, int end,
		OrderByComparator<labDetailedActivityTable> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab detailed activity tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedActivityTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed activity tables
	 * @param end the upper bound of the range of lab detailed activity tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab detailed activity tables
	 */
	@Override
	public List<labDetailedActivityTable> findAll(int start, int end,
		OrderByComparator<labDetailedActivityTable> orderByComparator,
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

		List<labDetailedActivityTable> list = null;

		if (retrieveFromCache) {
			list = (List<labDetailedActivityTable>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABDETAILEDACTIVITYTABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABDETAILEDACTIVITYTABLE;

				if (pagination) {
					sql = sql.concat(labDetailedActivityTableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labDetailedActivityTable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labDetailedActivityTable>)QueryUtil.list(q,
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
	 * Removes all the lab detailed activity tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labDetailedActivityTable labDetailedActivityTable : findAll()) {
			remove(labDetailedActivityTable);
		}
	}

	/**
	 * Returns the number of lab detailed activity tables.
	 *
	 * @return the number of lab detailed activity tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABDETAILEDACTIVITYTABLE);

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
		return labDetailedActivityTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab detailed activity table persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labDetailedActivityTableImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABDETAILEDACTIVITYTABLE = "SELECT labDetailedActivityTable FROM labDetailedActivityTable labDetailedActivityTable";
	private static final String _SQL_SELECT_LABDETAILEDACTIVITYTABLE_WHERE_PKS_IN =
		"SELECT labDetailedActivityTable FROM labDetailedActivityTable labDetailedActivityTable WHERE PK_activityTableId IN (";
	private static final String _SQL_COUNT_LABDETAILEDACTIVITYTABLE = "SELECT COUNT(labDetailedActivityTable) FROM labDetailedActivityTable labDetailedActivityTable";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labDetailedActivityTable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labDetailedActivityTable exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(labDetailedActivityTablePersistenceImpl.class);
}