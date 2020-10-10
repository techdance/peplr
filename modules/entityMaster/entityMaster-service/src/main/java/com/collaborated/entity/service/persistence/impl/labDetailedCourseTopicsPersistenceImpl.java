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

import com.collaborated.entity.exception.NoSuchlabDetailedCourseTopicsException;
import com.collaborated.entity.model.impl.labDetailedCourseTopicsImpl;
import com.collaborated.entity.model.impl.labDetailedCourseTopicsModelImpl;
import com.collaborated.entity.model.labDetailedCourseTopics;
import com.collaborated.entity.service.persistence.labDetailedCourseTopicsPersistence;

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
 * The persistence implementation for the lab detailed course topics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseTopicsPersistence
 * @see com.collaborated.entity.service.persistence.labDetailedCourseTopicsUtil
 * @generated
 */
@ProviderType
public class labDetailedCourseTopicsPersistenceImpl extends BasePersistenceImpl<labDetailedCourseTopics>
	implements labDetailedCourseTopicsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labDetailedCourseTopicsUtil} to access the lab detailed course topics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labDetailedCourseTopicsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseTopicsModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseTopicsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseTopicsModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseTopicsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseTopicsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public labDetailedCourseTopicsPersistenceImpl() {
		setModelClass(labDetailedCourseTopics.class);
	}

	/**
	 * Caches the lab detailed course topics in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseTopics the lab detailed course topics
	 */
	@Override
	public void cacheResult(labDetailedCourseTopics labDetailedCourseTopics) {
		entityCache.putResult(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseTopicsImpl.class,
			labDetailedCourseTopics.getPrimaryKey(), labDetailedCourseTopics);

		labDetailedCourseTopics.resetOriginalValues();
	}

	/**
	 * Caches the lab detailed course topicses in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseTopicses the lab detailed course topicses
	 */
	@Override
	public void cacheResult(
		List<labDetailedCourseTopics> labDetailedCourseTopicses) {
		for (labDetailedCourseTopics labDetailedCourseTopics : labDetailedCourseTopicses) {
			if (entityCache.getResult(
						labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseTopicsImpl.class,
						labDetailedCourseTopics.getPrimaryKey()) == null) {
				cacheResult(labDetailedCourseTopics);
			}
			else {
				labDetailedCourseTopics.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab detailed course topicses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labDetailedCourseTopicsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab detailed course topics.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(labDetailedCourseTopics labDetailedCourseTopics) {
		entityCache.removeResult(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseTopicsImpl.class,
			labDetailedCourseTopics.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<labDetailedCourseTopics> labDetailedCourseTopicses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labDetailedCourseTopics labDetailedCourseTopics : labDetailedCourseTopicses) {
			entityCache.removeResult(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseTopicsImpl.class,
				labDetailedCourseTopics.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lab detailed course topics with the primary key. Does not add the lab detailed course topics to the database.
	 *
	 * @param PK_courseTopicsId the primary key for the new lab detailed course topics
	 * @return the new lab detailed course topics
	 */
	@Override
	public labDetailedCourseTopics create(long PK_courseTopicsId) {
		labDetailedCourseTopics labDetailedCourseTopics = new labDetailedCourseTopicsImpl();

		labDetailedCourseTopics.setNew(true);
		labDetailedCourseTopics.setPrimaryKey(PK_courseTopicsId);

		return labDetailedCourseTopics;
	}

	/**
	 * Removes the lab detailed course topics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_courseTopicsId the primary key of the lab detailed course topics
	 * @return the lab detailed course topics that was removed
	 * @throws NoSuchlabDetailedCourseTopicsException if a lab detailed course topics with the primary key could not be found
	 */
	@Override
	public labDetailedCourseTopics remove(long PK_courseTopicsId)
		throws NoSuchlabDetailedCourseTopicsException {
		return remove((Serializable)PK_courseTopicsId);
	}

	/**
	 * Removes the lab detailed course topics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab detailed course topics
	 * @return the lab detailed course topics that was removed
	 * @throws NoSuchlabDetailedCourseTopicsException if a lab detailed course topics with the primary key could not be found
	 */
	@Override
	public labDetailedCourseTopics remove(Serializable primaryKey)
		throws NoSuchlabDetailedCourseTopicsException {
		Session session = null;

		try {
			session = openSession();

			labDetailedCourseTopics labDetailedCourseTopics = (labDetailedCourseTopics)session.get(labDetailedCourseTopicsImpl.class,
					primaryKey);

			if (labDetailedCourseTopics == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabDetailedCourseTopicsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labDetailedCourseTopics);
		}
		catch (NoSuchlabDetailedCourseTopicsException nsee) {
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
	protected labDetailedCourseTopics removeImpl(
		labDetailedCourseTopics labDetailedCourseTopics) {
		labDetailedCourseTopics = toUnwrappedModel(labDetailedCourseTopics);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labDetailedCourseTopics)) {
				labDetailedCourseTopics = (labDetailedCourseTopics)session.get(labDetailedCourseTopicsImpl.class,
						labDetailedCourseTopics.getPrimaryKeyObj());
			}

			if (labDetailedCourseTopics != null) {
				session.delete(labDetailedCourseTopics);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labDetailedCourseTopics != null) {
			clearCache(labDetailedCourseTopics);
		}

		return labDetailedCourseTopics;
	}

	@Override
	public labDetailedCourseTopics updateImpl(
		labDetailedCourseTopics labDetailedCourseTopics) {
		labDetailedCourseTopics = toUnwrappedModel(labDetailedCourseTopics);

		boolean isNew = labDetailedCourseTopics.isNew();

		labDetailedCourseTopicsModelImpl labDetailedCourseTopicsModelImpl = (labDetailedCourseTopicsModelImpl)labDetailedCourseTopics;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labDetailedCourseTopics.getCreateDate() == null)) {
			if (serviceContext == null) {
				labDetailedCourseTopics.setCreateDate(now);
			}
			else {
				labDetailedCourseTopics.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labDetailedCourseTopicsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labDetailedCourseTopics.setModifiedDate(now);
			}
			else {
				labDetailedCourseTopics.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labDetailedCourseTopics.isNew()) {
				session.save(labDetailedCourseTopics);

				labDetailedCourseTopics.setNew(false);
			}
			else {
				labDetailedCourseTopics = (labDetailedCourseTopics)session.merge(labDetailedCourseTopics);
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

		entityCache.putResult(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseTopicsImpl.class,
			labDetailedCourseTopics.getPrimaryKey(), labDetailedCourseTopics,
			false);

		labDetailedCourseTopics.resetOriginalValues();

		return labDetailedCourseTopics;
	}

	protected labDetailedCourseTopics toUnwrappedModel(
		labDetailedCourseTopics labDetailedCourseTopics) {
		if (labDetailedCourseTopics instanceof labDetailedCourseTopicsImpl) {
			return labDetailedCourseTopics;
		}

		labDetailedCourseTopicsImpl labDetailedCourseTopicsImpl = new labDetailedCourseTopicsImpl();

		labDetailedCourseTopicsImpl.setNew(labDetailedCourseTopics.isNew());
		labDetailedCourseTopicsImpl.setPrimaryKey(labDetailedCourseTopics.getPrimaryKey());

		labDetailedCourseTopicsImpl.setPK_courseTopicsId(labDetailedCourseTopics.getPK_courseTopicsId());
		labDetailedCourseTopicsImpl.setGroupId(labDetailedCourseTopics.getGroupId());
		labDetailedCourseTopicsImpl.setUserId(labDetailedCourseTopics.getUserId());
		labDetailedCourseTopicsImpl.setCreateDate(labDetailedCourseTopics.getCreateDate());
		labDetailedCourseTopicsImpl.setModifiedDate(labDetailedCourseTopics.getModifiedDate());
		labDetailedCourseTopicsImpl.setPK_projectId(labDetailedCourseTopics.getPK_projectId());
		labDetailedCourseTopicsImpl.setPK_courseId(labDetailedCourseTopics.getPK_courseId());
		labDetailedCourseTopicsImpl.setCourseTopic(labDetailedCourseTopics.getCourseTopic());

		return labDetailedCourseTopicsImpl;
	}

	/**
	 * Returns the lab detailed course topics with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course topics
	 * @return the lab detailed course topics
	 * @throws NoSuchlabDetailedCourseTopicsException if a lab detailed course topics with the primary key could not be found
	 */
	@Override
	public labDetailedCourseTopics findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlabDetailedCourseTopicsException {
		labDetailedCourseTopics labDetailedCourseTopics = fetchByPrimaryKey(primaryKey);

		if (labDetailedCourseTopics == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabDetailedCourseTopicsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labDetailedCourseTopics;
	}

	/**
	 * Returns the lab detailed course topics with the primary key or throws a {@link NoSuchlabDetailedCourseTopicsException} if it could not be found.
	 *
	 * @param PK_courseTopicsId the primary key of the lab detailed course topics
	 * @return the lab detailed course topics
	 * @throws NoSuchlabDetailedCourseTopicsException if a lab detailed course topics with the primary key could not be found
	 */
	@Override
	public labDetailedCourseTopics findByPrimaryKey(long PK_courseTopicsId)
		throws NoSuchlabDetailedCourseTopicsException {
		return findByPrimaryKey((Serializable)PK_courseTopicsId);
	}

	/**
	 * Returns the lab detailed course topics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course topics
	 * @return the lab detailed course topics, or <code>null</code> if a lab detailed course topics with the primary key could not be found
	 */
	@Override
	public labDetailedCourseTopics fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseTopicsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labDetailedCourseTopics labDetailedCourseTopics = (labDetailedCourseTopics)serializable;

		if (labDetailedCourseTopics == null) {
			Session session = null;

			try {
				session = openSession();

				labDetailedCourseTopics = (labDetailedCourseTopics)session.get(labDetailedCourseTopicsImpl.class,
						primaryKey);

				if (labDetailedCourseTopics != null) {
					cacheResult(labDetailedCourseTopics);
				}
				else {
					entityCache.putResult(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseTopicsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseTopicsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labDetailedCourseTopics;
	}

	/**
	 * Returns the lab detailed course topics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_courseTopicsId the primary key of the lab detailed course topics
	 * @return the lab detailed course topics, or <code>null</code> if a lab detailed course topics with the primary key could not be found
	 */
	@Override
	public labDetailedCourseTopics fetchByPrimaryKey(long PK_courseTopicsId) {
		return fetchByPrimaryKey((Serializable)PK_courseTopicsId);
	}

	@Override
	public Map<Serializable, labDetailedCourseTopics> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labDetailedCourseTopics> map = new HashMap<Serializable, labDetailedCourseTopics>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labDetailedCourseTopics labDetailedCourseTopics = fetchByPrimaryKey(primaryKey);

			if (labDetailedCourseTopics != null) {
				map.put(primaryKey, labDetailedCourseTopics);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseTopicsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (labDetailedCourseTopics)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABDETAILEDCOURSETOPICS_WHERE_PKS_IN);

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

			for (labDetailedCourseTopics labDetailedCourseTopics : (List<labDetailedCourseTopics>)q.list()) {
				map.put(labDetailedCourseTopics.getPrimaryKeyObj(),
					labDetailedCourseTopics);

				cacheResult(labDetailedCourseTopics);

				uncachedPrimaryKeys.remove(labDetailedCourseTopics.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labDetailedCourseTopicsModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseTopicsImpl.class, primaryKey, nullModel);
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
	 * Returns all the lab detailed course topicses.
	 *
	 * @return the lab detailed course topicses
	 */
	@Override
	public List<labDetailedCourseTopics> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab detailed course topicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseTopicsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course topicses
	 * @param end the upper bound of the range of lab detailed course topicses (not inclusive)
	 * @return the range of lab detailed course topicses
	 */
	@Override
	public List<labDetailedCourseTopics> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab detailed course topicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseTopicsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course topicses
	 * @param end the upper bound of the range of lab detailed course topicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab detailed course topicses
	 */
	@Override
	public List<labDetailedCourseTopics> findAll(int start, int end,
		OrderByComparator<labDetailedCourseTopics> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab detailed course topicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseTopicsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course topicses
	 * @param end the upper bound of the range of lab detailed course topicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab detailed course topicses
	 */
	@Override
	public List<labDetailedCourseTopics> findAll(int start, int end,
		OrderByComparator<labDetailedCourseTopics> orderByComparator,
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

		List<labDetailedCourseTopics> list = null;

		if (retrieveFromCache) {
			list = (List<labDetailedCourseTopics>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABDETAILEDCOURSETOPICS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABDETAILEDCOURSETOPICS;

				if (pagination) {
					sql = sql.concat(labDetailedCourseTopicsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labDetailedCourseTopics>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labDetailedCourseTopics>)QueryUtil.list(q,
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
	 * Removes all the lab detailed course topicses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labDetailedCourseTopics labDetailedCourseTopics : findAll()) {
			remove(labDetailedCourseTopics);
		}
	}

	/**
	 * Returns the number of lab detailed course topicses.
	 *
	 * @return the number of lab detailed course topicses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABDETAILEDCOURSETOPICS);

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
		return labDetailedCourseTopicsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab detailed course topics persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labDetailedCourseTopicsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABDETAILEDCOURSETOPICS = "SELECT labDetailedCourseTopics FROM labDetailedCourseTopics labDetailedCourseTopics";
	private static final String _SQL_SELECT_LABDETAILEDCOURSETOPICS_WHERE_PKS_IN =
		"SELECT labDetailedCourseTopics FROM labDetailedCourseTopics labDetailedCourseTopics WHERE PK_courseTopicsId IN (";
	private static final String _SQL_COUNT_LABDETAILEDCOURSETOPICS = "SELECT COUNT(labDetailedCourseTopics) FROM labDetailedCourseTopics labDetailedCourseTopics";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labDetailedCourseTopics.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labDetailedCourseTopics exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(labDetailedCourseTopicsPersistenceImpl.class);
}