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

import com.collaborated.entity.exception.NoSuchlabDetailedCourseObjectivesException;
import com.collaborated.entity.model.impl.labDetailedCourseObjectivesImpl;
import com.collaborated.entity.model.impl.labDetailedCourseObjectivesModelImpl;
import com.collaborated.entity.model.labDetailedCourseObjectives;
import com.collaborated.entity.service.persistence.labDetailedCourseObjectivesPersistence;

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
 * The persistence implementation for the lab detailed course objectives service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseObjectivesPersistence
 * @see com.collaborated.entity.service.persistence.labDetailedCourseObjectivesUtil
 * @generated
 */
@ProviderType
public class labDetailedCourseObjectivesPersistenceImpl
	extends BasePersistenceImpl<labDetailedCourseObjectives>
	implements labDetailedCourseObjectivesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labDetailedCourseObjectivesUtil} to access the lab detailed course objectives persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labDetailedCourseObjectivesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseObjectivesModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseObjectivesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseObjectivesModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseObjectivesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseObjectivesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public labDetailedCourseObjectivesPersistenceImpl() {
		setModelClass(labDetailedCourseObjectives.class);
	}

	/**
	 * Caches the lab detailed course objectives in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseObjectives the lab detailed course objectives
	 */
	@Override
	public void cacheResult(
		labDetailedCourseObjectives labDetailedCourseObjectives) {
		entityCache.putResult(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseObjectivesImpl.class,
			labDetailedCourseObjectives.getPrimaryKey(),
			labDetailedCourseObjectives);

		labDetailedCourseObjectives.resetOriginalValues();
	}

	/**
	 * Caches the lab detailed course objectiveses in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseObjectiveses the lab detailed course objectiveses
	 */
	@Override
	public void cacheResult(
		List<labDetailedCourseObjectives> labDetailedCourseObjectiveses) {
		for (labDetailedCourseObjectives labDetailedCourseObjectives : labDetailedCourseObjectiveses) {
			if (entityCache.getResult(
						labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseObjectivesImpl.class,
						labDetailedCourseObjectives.getPrimaryKey()) == null) {
				cacheResult(labDetailedCourseObjectives);
			}
			else {
				labDetailedCourseObjectives.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab detailed course objectiveses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labDetailedCourseObjectivesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab detailed course objectives.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		labDetailedCourseObjectives labDetailedCourseObjectives) {
		entityCache.removeResult(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseObjectivesImpl.class,
			labDetailedCourseObjectives.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<labDetailedCourseObjectives> labDetailedCourseObjectiveses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labDetailedCourseObjectives labDetailedCourseObjectives : labDetailedCourseObjectiveses) {
			entityCache.removeResult(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseObjectivesImpl.class,
				labDetailedCourseObjectives.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lab detailed course objectives with the primary key. Does not add the lab detailed course objectives to the database.
	 *
	 * @param PK_courseObjectivesId the primary key for the new lab detailed course objectives
	 * @return the new lab detailed course objectives
	 */
	@Override
	public labDetailedCourseObjectives create(long PK_courseObjectivesId) {
		labDetailedCourseObjectives labDetailedCourseObjectives = new labDetailedCourseObjectivesImpl();

		labDetailedCourseObjectives.setNew(true);
		labDetailedCourseObjectives.setPrimaryKey(PK_courseObjectivesId);

		return labDetailedCourseObjectives;
	}

	/**
	 * Removes the lab detailed course objectives with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_courseObjectivesId the primary key of the lab detailed course objectives
	 * @return the lab detailed course objectives that was removed
	 * @throws NoSuchlabDetailedCourseObjectivesException if a lab detailed course objectives with the primary key could not be found
	 */
	@Override
	public labDetailedCourseObjectives remove(long PK_courseObjectivesId)
		throws NoSuchlabDetailedCourseObjectivesException {
		return remove((Serializable)PK_courseObjectivesId);
	}

	/**
	 * Removes the lab detailed course objectives with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab detailed course objectives
	 * @return the lab detailed course objectives that was removed
	 * @throws NoSuchlabDetailedCourseObjectivesException if a lab detailed course objectives with the primary key could not be found
	 */
	@Override
	public labDetailedCourseObjectives remove(Serializable primaryKey)
		throws NoSuchlabDetailedCourseObjectivesException {
		Session session = null;

		try {
			session = openSession();

			labDetailedCourseObjectives labDetailedCourseObjectives = (labDetailedCourseObjectives)session.get(labDetailedCourseObjectivesImpl.class,
					primaryKey);

			if (labDetailedCourseObjectives == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabDetailedCourseObjectivesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labDetailedCourseObjectives);
		}
		catch (NoSuchlabDetailedCourseObjectivesException nsee) {
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
	protected labDetailedCourseObjectives removeImpl(
		labDetailedCourseObjectives labDetailedCourseObjectives) {
		labDetailedCourseObjectives = toUnwrappedModel(labDetailedCourseObjectives);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labDetailedCourseObjectives)) {
				labDetailedCourseObjectives = (labDetailedCourseObjectives)session.get(labDetailedCourseObjectivesImpl.class,
						labDetailedCourseObjectives.getPrimaryKeyObj());
			}

			if (labDetailedCourseObjectives != null) {
				session.delete(labDetailedCourseObjectives);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labDetailedCourseObjectives != null) {
			clearCache(labDetailedCourseObjectives);
		}

		return labDetailedCourseObjectives;
	}

	@Override
	public labDetailedCourseObjectives updateImpl(
		labDetailedCourseObjectives labDetailedCourseObjectives) {
		labDetailedCourseObjectives = toUnwrappedModel(labDetailedCourseObjectives);

		boolean isNew = labDetailedCourseObjectives.isNew();

		labDetailedCourseObjectivesModelImpl labDetailedCourseObjectivesModelImpl =
			(labDetailedCourseObjectivesModelImpl)labDetailedCourseObjectives;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labDetailedCourseObjectives.getCreateDate() == null)) {
			if (serviceContext == null) {
				labDetailedCourseObjectives.setCreateDate(now);
			}
			else {
				labDetailedCourseObjectives.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labDetailedCourseObjectivesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labDetailedCourseObjectives.setModifiedDate(now);
			}
			else {
				labDetailedCourseObjectives.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labDetailedCourseObjectives.isNew()) {
				session.save(labDetailedCourseObjectives);

				labDetailedCourseObjectives.setNew(false);
			}
			else {
				labDetailedCourseObjectives = (labDetailedCourseObjectives)session.merge(labDetailedCourseObjectives);
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

		entityCache.putResult(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseObjectivesImpl.class,
			labDetailedCourseObjectives.getPrimaryKey(),
			labDetailedCourseObjectives, false);

		labDetailedCourseObjectives.resetOriginalValues();

		return labDetailedCourseObjectives;
	}

	protected labDetailedCourseObjectives toUnwrappedModel(
		labDetailedCourseObjectives labDetailedCourseObjectives) {
		if (labDetailedCourseObjectives instanceof labDetailedCourseObjectivesImpl) {
			return labDetailedCourseObjectives;
		}

		labDetailedCourseObjectivesImpl labDetailedCourseObjectivesImpl = new labDetailedCourseObjectivesImpl();

		labDetailedCourseObjectivesImpl.setNew(labDetailedCourseObjectives.isNew());
		labDetailedCourseObjectivesImpl.setPrimaryKey(labDetailedCourseObjectives.getPrimaryKey());

		labDetailedCourseObjectivesImpl.setPK_courseObjectivesId(labDetailedCourseObjectives.getPK_courseObjectivesId());
		labDetailedCourseObjectivesImpl.setGroupId(labDetailedCourseObjectives.getGroupId());
		labDetailedCourseObjectivesImpl.setUserId(labDetailedCourseObjectives.getUserId());
		labDetailedCourseObjectivesImpl.setCreateDate(labDetailedCourseObjectives.getCreateDate());
		labDetailedCourseObjectivesImpl.setModifiedDate(labDetailedCourseObjectives.getModifiedDate());
		labDetailedCourseObjectivesImpl.setPK_projectId(labDetailedCourseObjectives.getPK_projectId());
		labDetailedCourseObjectivesImpl.setPK_courseId(labDetailedCourseObjectives.getPK_courseId());
		labDetailedCourseObjectivesImpl.setCourseObjective(labDetailedCourseObjectives.getCourseObjective());

		return labDetailedCourseObjectivesImpl;
	}

	/**
	 * Returns the lab detailed course objectives with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course objectives
	 * @return the lab detailed course objectives
	 * @throws NoSuchlabDetailedCourseObjectivesException if a lab detailed course objectives with the primary key could not be found
	 */
	@Override
	public labDetailedCourseObjectives findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlabDetailedCourseObjectivesException {
		labDetailedCourseObjectives labDetailedCourseObjectives = fetchByPrimaryKey(primaryKey);

		if (labDetailedCourseObjectives == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabDetailedCourseObjectivesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labDetailedCourseObjectives;
	}

	/**
	 * Returns the lab detailed course objectives with the primary key or throws a {@link NoSuchlabDetailedCourseObjectivesException} if it could not be found.
	 *
	 * @param PK_courseObjectivesId the primary key of the lab detailed course objectives
	 * @return the lab detailed course objectives
	 * @throws NoSuchlabDetailedCourseObjectivesException if a lab detailed course objectives with the primary key could not be found
	 */
	@Override
	public labDetailedCourseObjectives findByPrimaryKey(
		long PK_courseObjectivesId)
		throws NoSuchlabDetailedCourseObjectivesException {
		return findByPrimaryKey((Serializable)PK_courseObjectivesId);
	}

	/**
	 * Returns the lab detailed course objectives with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course objectives
	 * @return the lab detailed course objectives, or <code>null</code> if a lab detailed course objectives with the primary key could not be found
	 */
	@Override
	public labDetailedCourseObjectives fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseObjectivesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labDetailedCourseObjectives labDetailedCourseObjectives = (labDetailedCourseObjectives)serializable;

		if (labDetailedCourseObjectives == null) {
			Session session = null;

			try {
				session = openSession();

				labDetailedCourseObjectives = (labDetailedCourseObjectives)session.get(labDetailedCourseObjectivesImpl.class,
						primaryKey);

				if (labDetailedCourseObjectives != null) {
					cacheResult(labDetailedCourseObjectives);
				}
				else {
					entityCache.putResult(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseObjectivesImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseObjectivesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labDetailedCourseObjectives;
	}

	/**
	 * Returns the lab detailed course objectives with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_courseObjectivesId the primary key of the lab detailed course objectives
	 * @return the lab detailed course objectives, or <code>null</code> if a lab detailed course objectives with the primary key could not be found
	 */
	@Override
	public labDetailedCourseObjectives fetchByPrimaryKey(
		long PK_courseObjectivesId) {
		return fetchByPrimaryKey((Serializable)PK_courseObjectivesId);
	}

	@Override
	public Map<Serializable, labDetailedCourseObjectives> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labDetailedCourseObjectives> map = new HashMap<Serializable, labDetailedCourseObjectives>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labDetailedCourseObjectives labDetailedCourseObjectives = fetchByPrimaryKey(primaryKey);

			if (labDetailedCourseObjectives != null) {
				map.put(primaryKey, labDetailedCourseObjectives);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseObjectivesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(labDetailedCourseObjectives)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABDETAILEDCOURSEOBJECTIVES_WHERE_PKS_IN);

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

			for (labDetailedCourseObjectives labDetailedCourseObjectives : (List<labDetailedCourseObjectives>)q.list()) {
				map.put(labDetailedCourseObjectives.getPrimaryKeyObj(),
					labDetailedCourseObjectives);

				cacheResult(labDetailedCourseObjectives);

				uncachedPrimaryKeys.remove(labDetailedCourseObjectives.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labDetailedCourseObjectivesModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseObjectivesImpl.class, primaryKey, nullModel);
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
	 * Returns all the lab detailed course objectiveses.
	 *
	 * @return the lab detailed course objectiveses
	 */
	@Override
	public List<labDetailedCourseObjectives> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab detailed course objectiveses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseObjectivesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course objectiveses
	 * @param end the upper bound of the range of lab detailed course objectiveses (not inclusive)
	 * @return the range of lab detailed course objectiveses
	 */
	@Override
	public List<labDetailedCourseObjectives> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab detailed course objectiveses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseObjectivesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course objectiveses
	 * @param end the upper bound of the range of lab detailed course objectiveses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab detailed course objectiveses
	 */
	@Override
	public List<labDetailedCourseObjectives> findAll(int start, int end,
		OrderByComparator<labDetailedCourseObjectives> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab detailed course objectiveses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseObjectivesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course objectiveses
	 * @param end the upper bound of the range of lab detailed course objectiveses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab detailed course objectiveses
	 */
	@Override
	public List<labDetailedCourseObjectives> findAll(int start, int end,
		OrderByComparator<labDetailedCourseObjectives> orderByComparator,
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

		List<labDetailedCourseObjectives> list = null;

		if (retrieveFromCache) {
			list = (List<labDetailedCourseObjectives>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABDETAILEDCOURSEOBJECTIVES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABDETAILEDCOURSEOBJECTIVES;

				if (pagination) {
					sql = sql.concat(labDetailedCourseObjectivesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labDetailedCourseObjectives>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labDetailedCourseObjectives>)QueryUtil.list(q,
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
	 * Removes all the lab detailed course objectiveses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labDetailedCourseObjectives labDetailedCourseObjectives : findAll()) {
			remove(labDetailedCourseObjectives);
		}
	}

	/**
	 * Returns the number of lab detailed course objectiveses.
	 *
	 * @return the number of lab detailed course objectiveses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABDETAILEDCOURSEOBJECTIVES);

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
		return labDetailedCourseObjectivesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab detailed course objectives persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labDetailedCourseObjectivesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABDETAILEDCOURSEOBJECTIVES = "SELECT labDetailedCourseObjectives FROM labDetailedCourseObjectives labDetailedCourseObjectives";
	private static final String _SQL_SELECT_LABDETAILEDCOURSEOBJECTIVES_WHERE_PKS_IN =
		"SELECT labDetailedCourseObjectives FROM labDetailedCourseObjectives labDetailedCourseObjectives WHERE PK_courseObjectivesId IN (";
	private static final String _SQL_COUNT_LABDETAILEDCOURSEOBJECTIVES = "SELECT COUNT(labDetailedCourseObjectives) FROM labDetailedCourseObjectives labDetailedCourseObjectives";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labDetailedCourseObjectives.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labDetailedCourseObjectives exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(labDetailedCourseObjectivesPersistenceImpl.class);
}