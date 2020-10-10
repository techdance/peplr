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

import com.collaborated.entity.exception.NoSuchlabDetailedLearningEnvironmentsException;
import com.collaborated.entity.model.impl.labDetailedLearningEnvironmentsImpl;
import com.collaborated.entity.model.impl.labDetailedLearningEnvironmentsModelImpl;
import com.collaborated.entity.model.labDetailedLearningEnvironments;
import com.collaborated.entity.service.persistence.labDetailedLearningEnvironmentsPersistence;

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
 * The persistence implementation for the lab detailed learning environments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedLearningEnvironmentsPersistence
 * @see com.collaborated.entity.service.persistence.labDetailedLearningEnvironmentsUtil
 * @generated
 */
@ProviderType
public class labDetailedLearningEnvironmentsPersistenceImpl
	extends BasePersistenceImpl<labDetailedLearningEnvironments>
	implements labDetailedLearningEnvironmentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labDetailedLearningEnvironmentsUtil} to access the lab detailed learning environments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labDetailedLearningEnvironmentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedLearningEnvironmentsModelImpl.FINDER_CACHE_ENABLED,
			labDetailedLearningEnvironmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedLearningEnvironmentsModelImpl.FINDER_CACHE_ENABLED,
			labDetailedLearningEnvironmentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedLearningEnvironmentsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public labDetailedLearningEnvironmentsPersistenceImpl() {
		setModelClass(labDetailedLearningEnvironments.class);
	}

	/**
	 * Caches the lab detailed learning environments in the entity cache if it is enabled.
	 *
	 * @param labDetailedLearningEnvironments the lab detailed learning environments
	 */
	@Override
	public void cacheResult(
		labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		entityCache.putResult(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedLearningEnvironmentsImpl.class,
			labDetailedLearningEnvironments.getPrimaryKey(),
			labDetailedLearningEnvironments);

		labDetailedLearningEnvironments.resetOriginalValues();
	}

	/**
	 * Caches the lab detailed learning environmentses in the entity cache if it is enabled.
	 *
	 * @param labDetailedLearningEnvironmentses the lab detailed learning environmentses
	 */
	@Override
	public void cacheResult(
		List<labDetailedLearningEnvironments> labDetailedLearningEnvironmentses) {
		for (labDetailedLearningEnvironments labDetailedLearningEnvironments : labDetailedLearningEnvironmentses) {
			if (entityCache.getResult(
						labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedLearningEnvironmentsImpl.class,
						labDetailedLearningEnvironments.getPrimaryKey()) == null) {
				cacheResult(labDetailedLearningEnvironments);
			}
			else {
				labDetailedLearningEnvironments.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab detailed learning environmentses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labDetailedLearningEnvironmentsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab detailed learning environments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		entityCache.removeResult(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedLearningEnvironmentsImpl.class,
			labDetailedLearningEnvironments.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<labDetailedLearningEnvironments> labDetailedLearningEnvironmentses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labDetailedLearningEnvironments labDetailedLearningEnvironments : labDetailedLearningEnvironmentses) {
			entityCache.removeResult(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedLearningEnvironmentsImpl.class,
				labDetailedLearningEnvironments.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lab detailed learning environments with the primary key. Does not add the lab detailed learning environments to the database.
	 *
	 * @param PK_learningEnvironmentId the primary key for the new lab detailed learning environments
	 * @return the new lab detailed learning environments
	 */
	@Override
	public labDetailedLearningEnvironments create(long PK_learningEnvironmentId) {
		labDetailedLearningEnvironments labDetailedLearningEnvironments = new labDetailedLearningEnvironmentsImpl();

		labDetailedLearningEnvironments.setNew(true);
		labDetailedLearningEnvironments.setPrimaryKey(PK_learningEnvironmentId);

		return labDetailedLearningEnvironments;
	}

	/**
	 * Removes the lab detailed learning environments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_learningEnvironmentId the primary key of the lab detailed learning environments
	 * @return the lab detailed learning environments that was removed
	 * @throws NoSuchlabDetailedLearningEnvironmentsException if a lab detailed learning environments with the primary key could not be found
	 */
	@Override
	public labDetailedLearningEnvironments remove(long PK_learningEnvironmentId)
		throws NoSuchlabDetailedLearningEnvironmentsException {
		return remove((Serializable)PK_learningEnvironmentId);
	}

	/**
	 * Removes the lab detailed learning environments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab detailed learning environments
	 * @return the lab detailed learning environments that was removed
	 * @throws NoSuchlabDetailedLearningEnvironmentsException if a lab detailed learning environments with the primary key could not be found
	 */
	@Override
	public labDetailedLearningEnvironments remove(Serializable primaryKey)
		throws NoSuchlabDetailedLearningEnvironmentsException {
		Session session = null;

		try {
			session = openSession();

			labDetailedLearningEnvironments labDetailedLearningEnvironments = (labDetailedLearningEnvironments)session.get(labDetailedLearningEnvironmentsImpl.class,
					primaryKey);

			if (labDetailedLearningEnvironments == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabDetailedLearningEnvironmentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labDetailedLearningEnvironments);
		}
		catch (NoSuchlabDetailedLearningEnvironmentsException nsee) {
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
	protected labDetailedLearningEnvironments removeImpl(
		labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		labDetailedLearningEnvironments = toUnwrappedModel(labDetailedLearningEnvironments);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labDetailedLearningEnvironments)) {
				labDetailedLearningEnvironments = (labDetailedLearningEnvironments)session.get(labDetailedLearningEnvironmentsImpl.class,
						labDetailedLearningEnvironments.getPrimaryKeyObj());
			}

			if (labDetailedLearningEnvironments != null) {
				session.delete(labDetailedLearningEnvironments);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labDetailedLearningEnvironments != null) {
			clearCache(labDetailedLearningEnvironments);
		}

		return labDetailedLearningEnvironments;
	}

	@Override
	public labDetailedLearningEnvironments updateImpl(
		labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		labDetailedLearningEnvironments = toUnwrappedModel(labDetailedLearningEnvironments);

		boolean isNew = labDetailedLearningEnvironments.isNew();

		labDetailedLearningEnvironmentsModelImpl labDetailedLearningEnvironmentsModelImpl =
			(labDetailedLearningEnvironmentsModelImpl)labDetailedLearningEnvironments;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labDetailedLearningEnvironments.getCreateDate() == null)) {
			if (serviceContext == null) {
				labDetailedLearningEnvironments.setCreateDate(now);
			}
			else {
				labDetailedLearningEnvironments.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labDetailedLearningEnvironmentsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labDetailedLearningEnvironments.setModifiedDate(now);
			}
			else {
				labDetailedLearningEnvironments.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labDetailedLearningEnvironments.isNew()) {
				session.save(labDetailedLearningEnvironments);

				labDetailedLearningEnvironments.setNew(false);
			}
			else {
				labDetailedLearningEnvironments = (labDetailedLearningEnvironments)session.merge(labDetailedLearningEnvironments);
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

		entityCache.putResult(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedLearningEnvironmentsImpl.class,
			labDetailedLearningEnvironments.getPrimaryKey(),
			labDetailedLearningEnvironments, false);

		labDetailedLearningEnvironments.resetOriginalValues();

		return labDetailedLearningEnvironments;
	}

	protected labDetailedLearningEnvironments toUnwrappedModel(
		labDetailedLearningEnvironments labDetailedLearningEnvironments) {
		if (labDetailedLearningEnvironments instanceof labDetailedLearningEnvironmentsImpl) {
			return labDetailedLearningEnvironments;
		}

		labDetailedLearningEnvironmentsImpl labDetailedLearningEnvironmentsImpl = new labDetailedLearningEnvironmentsImpl();

		labDetailedLearningEnvironmentsImpl.setNew(labDetailedLearningEnvironments.isNew());
		labDetailedLearningEnvironmentsImpl.setPrimaryKey(labDetailedLearningEnvironments.getPrimaryKey());

		labDetailedLearningEnvironmentsImpl.setPK_learningEnvironmentId(labDetailedLearningEnvironments.getPK_learningEnvironmentId());
		labDetailedLearningEnvironmentsImpl.setGroupId(labDetailedLearningEnvironments.getGroupId());
		labDetailedLearningEnvironmentsImpl.setUserId(labDetailedLearningEnvironments.getUserId());
		labDetailedLearningEnvironmentsImpl.setCreateDate(labDetailedLearningEnvironments.getCreateDate());
		labDetailedLearningEnvironmentsImpl.setModifiedDate(labDetailedLearningEnvironments.getModifiedDate());
		labDetailedLearningEnvironmentsImpl.setPK_projectId(labDetailedLearningEnvironments.getPK_projectId());
		labDetailedLearningEnvironmentsImpl.setPK_courseId(labDetailedLearningEnvironments.getPK_courseId());
		labDetailedLearningEnvironmentsImpl.setLearningEnvironment(labDetailedLearningEnvironments.getLearningEnvironment());

		return labDetailedLearningEnvironmentsImpl;
	}

	/**
	 * Returns the lab detailed learning environments with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed learning environments
	 * @return the lab detailed learning environments
	 * @throws NoSuchlabDetailedLearningEnvironmentsException if a lab detailed learning environments with the primary key could not be found
	 */
	@Override
	public labDetailedLearningEnvironments findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchlabDetailedLearningEnvironmentsException {
		labDetailedLearningEnvironments labDetailedLearningEnvironments = fetchByPrimaryKey(primaryKey);

		if (labDetailedLearningEnvironments == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabDetailedLearningEnvironmentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labDetailedLearningEnvironments;
	}

	/**
	 * Returns the lab detailed learning environments with the primary key or throws a {@link NoSuchlabDetailedLearningEnvironmentsException} if it could not be found.
	 *
	 * @param PK_learningEnvironmentId the primary key of the lab detailed learning environments
	 * @return the lab detailed learning environments
	 * @throws NoSuchlabDetailedLearningEnvironmentsException if a lab detailed learning environments with the primary key could not be found
	 */
	@Override
	public labDetailedLearningEnvironments findByPrimaryKey(
		long PK_learningEnvironmentId)
		throws NoSuchlabDetailedLearningEnvironmentsException {
		return findByPrimaryKey((Serializable)PK_learningEnvironmentId);
	}

	/**
	 * Returns the lab detailed learning environments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed learning environments
	 * @return the lab detailed learning environments, or <code>null</code> if a lab detailed learning environments with the primary key could not be found
	 */
	@Override
	public labDetailedLearningEnvironments fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedLearningEnvironmentsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labDetailedLearningEnvironments labDetailedLearningEnvironments = (labDetailedLearningEnvironments)serializable;

		if (labDetailedLearningEnvironments == null) {
			Session session = null;

			try {
				session = openSession();

				labDetailedLearningEnvironments = (labDetailedLearningEnvironments)session.get(labDetailedLearningEnvironmentsImpl.class,
						primaryKey);

				if (labDetailedLearningEnvironments != null) {
					cacheResult(labDetailedLearningEnvironments);
				}
				else {
					entityCache.putResult(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedLearningEnvironmentsImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedLearningEnvironmentsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labDetailedLearningEnvironments;
	}

	/**
	 * Returns the lab detailed learning environments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_learningEnvironmentId the primary key of the lab detailed learning environments
	 * @return the lab detailed learning environments, or <code>null</code> if a lab detailed learning environments with the primary key could not be found
	 */
	@Override
	public labDetailedLearningEnvironments fetchByPrimaryKey(
		long PK_learningEnvironmentId) {
		return fetchByPrimaryKey((Serializable)PK_learningEnvironmentId);
	}

	@Override
	public Map<Serializable, labDetailedLearningEnvironments> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labDetailedLearningEnvironments> map = new HashMap<Serializable, labDetailedLearningEnvironments>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labDetailedLearningEnvironments labDetailedLearningEnvironments = fetchByPrimaryKey(primaryKey);

			if (labDetailedLearningEnvironments != null) {
				map.put(primaryKey, labDetailedLearningEnvironments);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedLearningEnvironmentsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(labDetailedLearningEnvironments)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABDETAILEDLEARNINGENVIRONMENTS_WHERE_PKS_IN);

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

			for (labDetailedLearningEnvironments labDetailedLearningEnvironments : (List<labDetailedLearningEnvironments>)q.list()) {
				map.put(labDetailedLearningEnvironments.getPrimaryKeyObj(),
					labDetailedLearningEnvironments);

				cacheResult(labDetailedLearningEnvironments);

				uncachedPrimaryKeys.remove(labDetailedLearningEnvironments.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labDetailedLearningEnvironmentsModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedLearningEnvironmentsImpl.class, primaryKey,
					nullModel);
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
	 * Returns all the lab detailed learning environmentses.
	 *
	 * @return the lab detailed learning environmentses
	 */
	@Override
	public List<labDetailedLearningEnvironments> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab detailed learning environmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedLearningEnvironmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed learning environmentses
	 * @param end the upper bound of the range of lab detailed learning environmentses (not inclusive)
	 * @return the range of lab detailed learning environmentses
	 */
	@Override
	public List<labDetailedLearningEnvironments> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab detailed learning environmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedLearningEnvironmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed learning environmentses
	 * @param end the upper bound of the range of lab detailed learning environmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab detailed learning environmentses
	 */
	@Override
	public List<labDetailedLearningEnvironments> findAll(int start, int end,
		OrderByComparator<labDetailedLearningEnvironments> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab detailed learning environmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedLearningEnvironmentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed learning environmentses
	 * @param end the upper bound of the range of lab detailed learning environmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab detailed learning environmentses
	 */
	@Override
	public List<labDetailedLearningEnvironments> findAll(int start, int end,
		OrderByComparator<labDetailedLearningEnvironments> orderByComparator,
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

		List<labDetailedLearningEnvironments> list = null;

		if (retrieveFromCache) {
			list = (List<labDetailedLearningEnvironments>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABDETAILEDLEARNINGENVIRONMENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABDETAILEDLEARNINGENVIRONMENTS;

				if (pagination) {
					sql = sql.concat(labDetailedLearningEnvironmentsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labDetailedLearningEnvironments>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labDetailedLearningEnvironments>)QueryUtil.list(q,
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
	 * Removes all the lab detailed learning environmentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labDetailedLearningEnvironments labDetailedLearningEnvironments : findAll()) {
			remove(labDetailedLearningEnvironments);
		}
	}

	/**
	 * Returns the number of lab detailed learning environmentses.
	 *
	 * @return the number of lab detailed learning environmentses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABDETAILEDLEARNINGENVIRONMENTS);

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
		return labDetailedLearningEnvironmentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab detailed learning environments persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labDetailedLearningEnvironmentsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABDETAILEDLEARNINGENVIRONMENTS = "SELECT labDetailedLearningEnvironments FROM labDetailedLearningEnvironments labDetailedLearningEnvironments";
	private static final String _SQL_SELECT_LABDETAILEDLEARNINGENVIRONMENTS_WHERE_PKS_IN =
		"SELECT labDetailedLearningEnvironments FROM labDetailedLearningEnvironments labDetailedLearningEnvironments WHERE PK_learningEnvironmentId IN (";
	private static final String _SQL_COUNT_LABDETAILEDLEARNINGENVIRONMENTS = "SELECT COUNT(labDetailedLearningEnvironments) FROM labDetailedLearningEnvironments labDetailedLearningEnvironments";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labDetailedLearningEnvironments.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labDetailedLearningEnvironments exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(labDetailedLearningEnvironmentsPersistenceImpl.class);
}