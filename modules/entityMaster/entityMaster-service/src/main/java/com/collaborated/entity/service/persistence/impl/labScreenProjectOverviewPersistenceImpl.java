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

import com.collaborated.entity.exception.NoSuchlabScreenProjectOverviewException;
import com.collaborated.entity.model.impl.labScreenProjectOverviewImpl;
import com.collaborated.entity.model.impl.labScreenProjectOverviewModelImpl;
import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.service.persistence.labScreenProjectOverviewPersistence;

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
 * The persistence implementation for the lab screen project overview service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectOverviewPersistence
 * @see com.collaborated.entity.service.persistence.labScreenProjectOverviewUtil
 * @generated
 */
@ProviderType
public class labScreenProjectOverviewPersistenceImpl extends BasePersistenceImpl<labScreenProjectOverview>
	implements labScreenProjectOverviewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labScreenProjectOverviewUtil} to access the lab screen project overview persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labScreenProjectOverviewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectOverviewModelImpl.FINDER_CACHE_ENABLED,
			labScreenProjectOverviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectOverviewModelImpl.FINDER_CACHE_ENABLED,
			labScreenProjectOverviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectOverviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public labScreenProjectOverviewPersistenceImpl() {
		setModelClass(labScreenProjectOverview.class);
	}

	/**
	 * Caches the lab screen project overview in the entity cache if it is enabled.
	 *
	 * @param labScreenProjectOverview the lab screen project overview
	 */
	@Override
	public void cacheResult(labScreenProjectOverview labScreenProjectOverview) {
		entityCache.putResult(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectOverviewImpl.class,
			labScreenProjectOverview.getPrimaryKey(), labScreenProjectOverview);

		labScreenProjectOverview.resetOriginalValues();
	}

	/**
	 * Caches the lab screen project overviews in the entity cache if it is enabled.
	 *
	 * @param labScreenProjectOverviews the lab screen project overviews
	 */
	@Override
	public void cacheResult(
		List<labScreenProjectOverview> labScreenProjectOverviews) {
		for (labScreenProjectOverview labScreenProjectOverview : labScreenProjectOverviews) {
			if (entityCache.getResult(
						labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
						labScreenProjectOverviewImpl.class,
						labScreenProjectOverview.getPrimaryKey()) == null) {
				cacheResult(labScreenProjectOverview);
			}
			else {
				labScreenProjectOverview.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab screen project overviews.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labScreenProjectOverviewImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab screen project overview.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(labScreenProjectOverview labScreenProjectOverview) {
		entityCache.removeResult(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectOverviewImpl.class,
			labScreenProjectOverview.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<labScreenProjectOverview> labScreenProjectOverviews) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labScreenProjectOverview labScreenProjectOverview : labScreenProjectOverviews) {
			entityCache.removeResult(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
				labScreenProjectOverviewImpl.class,
				labScreenProjectOverview.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lab screen project overview with the primary key. Does not add the lab screen project overview to the database.
	 *
	 * @param PK_projectId the primary key for the new lab screen project overview
	 * @return the new lab screen project overview
	 */
	@Override
	public labScreenProjectOverview create(long PK_projectId) {
		labScreenProjectOverview labScreenProjectOverview = new labScreenProjectOverviewImpl();

		labScreenProjectOverview.setNew(true);
		labScreenProjectOverview.setPrimaryKey(PK_projectId);

		return labScreenProjectOverview;
	}

	/**
	 * Removes the lab screen project overview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_projectId the primary key of the lab screen project overview
	 * @return the lab screen project overview that was removed
	 * @throws NoSuchlabScreenProjectOverviewException if a lab screen project overview with the primary key could not be found
	 */
	@Override
	public labScreenProjectOverview remove(long PK_projectId)
		throws NoSuchlabScreenProjectOverviewException {
		return remove((Serializable)PK_projectId);
	}

	/**
	 * Removes the lab screen project overview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab screen project overview
	 * @return the lab screen project overview that was removed
	 * @throws NoSuchlabScreenProjectOverviewException if a lab screen project overview with the primary key could not be found
	 */
	@Override
	public labScreenProjectOverview remove(Serializable primaryKey)
		throws NoSuchlabScreenProjectOverviewException {
		Session session = null;

		try {
			session = openSession();

			labScreenProjectOverview labScreenProjectOverview = (labScreenProjectOverview)session.get(labScreenProjectOverviewImpl.class,
					primaryKey);

			if (labScreenProjectOverview == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabScreenProjectOverviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labScreenProjectOverview);
		}
		catch (NoSuchlabScreenProjectOverviewException nsee) {
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
	protected labScreenProjectOverview removeImpl(
		labScreenProjectOverview labScreenProjectOverview) {
		labScreenProjectOverview = toUnwrappedModel(labScreenProjectOverview);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labScreenProjectOverview)) {
				labScreenProjectOverview = (labScreenProjectOverview)session.get(labScreenProjectOverviewImpl.class,
						labScreenProjectOverview.getPrimaryKeyObj());
			}

			if (labScreenProjectOverview != null) {
				session.delete(labScreenProjectOverview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labScreenProjectOverview != null) {
			clearCache(labScreenProjectOverview);
		}

		return labScreenProjectOverview;
	}

	@Override
	public labScreenProjectOverview updateImpl(
		labScreenProjectOverview labScreenProjectOverview) {
		labScreenProjectOverview = toUnwrappedModel(labScreenProjectOverview);

		boolean isNew = labScreenProjectOverview.isNew();

		labScreenProjectOverviewModelImpl labScreenProjectOverviewModelImpl = (labScreenProjectOverviewModelImpl)labScreenProjectOverview;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labScreenProjectOverview.getCreateDate() == null)) {
			if (serviceContext == null) {
				labScreenProjectOverview.setCreateDate(now);
			}
			else {
				labScreenProjectOverview.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labScreenProjectOverviewModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labScreenProjectOverview.setModifiedDate(now);
			}
			else {
				labScreenProjectOverview.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labScreenProjectOverview.isNew()) {
				session.save(labScreenProjectOverview);

				labScreenProjectOverview.setNew(false);
			}
			else {
				labScreenProjectOverview = (labScreenProjectOverview)session.merge(labScreenProjectOverview);
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

		entityCache.putResult(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectOverviewImpl.class,
			labScreenProjectOverview.getPrimaryKey(), labScreenProjectOverview,
			false);

		labScreenProjectOverview.resetOriginalValues();

		return labScreenProjectOverview;
	}

	protected labScreenProjectOverview toUnwrappedModel(
		labScreenProjectOverview labScreenProjectOverview) {
		if (labScreenProjectOverview instanceof labScreenProjectOverviewImpl) {
			return labScreenProjectOverview;
		}

		labScreenProjectOverviewImpl labScreenProjectOverviewImpl = new labScreenProjectOverviewImpl();

		labScreenProjectOverviewImpl.setNew(labScreenProjectOverview.isNew());
		labScreenProjectOverviewImpl.setPrimaryKey(labScreenProjectOverview.getPrimaryKey());

		labScreenProjectOverviewImpl.setPK_projectId(labScreenProjectOverview.getPK_projectId());
		labScreenProjectOverviewImpl.setGroupId(labScreenProjectOverview.getGroupId());
		labScreenProjectOverviewImpl.setUserId(labScreenProjectOverview.getUserId());
		labScreenProjectOverviewImpl.setCreateDate(labScreenProjectOverview.getCreateDate());
		labScreenProjectOverviewImpl.setModifiedDate(labScreenProjectOverview.getModifiedDate());
		labScreenProjectOverviewImpl.setProjectOwnerId(labScreenProjectOverview.getProjectOwnerId());
		labScreenProjectOverviewImpl.setProjectName(labScreenProjectOverview.getProjectName());
		labScreenProjectOverviewImpl.setProjectType(labScreenProjectOverview.getProjectType());
		labScreenProjectOverviewImpl.setProjectDescription(labScreenProjectOverview.getProjectDescription());
		labScreenProjectOverviewImpl.setProjectDiscipline1(labScreenProjectOverview.getProjectDiscipline1());
		labScreenProjectOverviewImpl.setProjectDiscipline2(labScreenProjectOverview.getProjectDiscipline2());
		labScreenProjectOverviewImpl.setProjectDiscipline3(labScreenProjectOverview.getProjectDiscipline3());
		labScreenProjectOverviewImpl.setRole(labScreenProjectOverview.getRole());
		labScreenProjectOverviewImpl.setProjectStartDate(labScreenProjectOverview.getProjectStartDate());
		labScreenProjectOverviewImpl.setProjectEndDate(labScreenProjectOverview.getProjectEndDate());
		labScreenProjectOverviewImpl.setProjectDocumentId(labScreenProjectOverview.getProjectDocumentId());
		labScreenProjectOverviewImpl.setPercentage(labScreenProjectOverview.getPercentage());
		labScreenProjectOverviewImpl.setInterestId(labScreenProjectOverview.getInterestId());
		labScreenProjectOverviewImpl.setProjectStatus(labScreenProjectOverview.getProjectStatus());

		return labScreenProjectOverviewImpl;
	}

	/**
	 * Returns the lab screen project overview with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab screen project overview
	 * @return the lab screen project overview
	 * @throws NoSuchlabScreenProjectOverviewException if a lab screen project overview with the primary key could not be found
	 */
	@Override
	public labScreenProjectOverview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlabScreenProjectOverviewException {
		labScreenProjectOverview labScreenProjectOverview = fetchByPrimaryKey(primaryKey);

		if (labScreenProjectOverview == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabScreenProjectOverviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labScreenProjectOverview;
	}

	/**
	 * Returns the lab screen project overview with the primary key or throws a {@link NoSuchlabScreenProjectOverviewException} if it could not be found.
	 *
	 * @param PK_projectId the primary key of the lab screen project overview
	 * @return the lab screen project overview
	 * @throws NoSuchlabScreenProjectOverviewException if a lab screen project overview with the primary key could not be found
	 */
	@Override
	public labScreenProjectOverview findByPrimaryKey(long PK_projectId)
		throws NoSuchlabScreenProjectOverviewException {
		return findByPrimaryKey((Serializable)PK_projectId);
	}

	/**
	 * Returns the lab screen project overview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab screen project overview
	 * @return the lab screen project overview, or <code>null</code> if a lab screen project overview with the primary key could not be found
	 */
	@Override
	public labScreenProjectOverview fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
				labScreenProjectOverviewImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labScreenProjectOverview labScreenProjectOverview = (labScreenProjectOverview)serializable;

		if (labScreenProjectOverview == null) {
			Session session = null;

			try {
				session = openSession();

				labScreenProjectOverview = (labScreenProjectOverview)session.get(labScreenProjectOverviewImpl.class,
						primaryKey);

				if (labScreenProjectOverview != null) {
					cacheResult(labScreenProjectOverview);
				}
				else {
					entityCache.putResult(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
						labScreenProjectOverviewImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
					labScreenProjectOverviewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labScreenProjectOverview;
	}

	/**
	 * Returns the lab screen project overview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_projectId the primary key of the lab screen project overview
	 * @return the lab screen project overview, or <code>null</code> if a lab screen project overview with the primary key could not be found
	 */
	@Override
	public labScreenProjectOverview fetchByPrimaryKey(long PK_projectId) {
		return fetchByPrimaryKey((Serializable)PK_projectId);
	}

	@Override
	public Map<Serializable, labScreenProjectOverview> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labScreenProjectOverview> map = new HashMap<Serializable, labScreenProjectOverview>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labScreenProjectOverview labScreenProjectOverview = fetchByPrimaryKey(primaryKey);

			if (labScreenProjectOverview != null) {
				map.put(primaryKey, labScreenProjectOverview);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
					labScreenProjectOverviewImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (labScreenProjectOverview)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABSCREENPROJECTOVERVIEW_WHERE_PKS_IN);

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

			for (labScreenProjectOverview labScreenProjectOverview : (List<labScreenProjectOverview>)q.list()) {
				map.put(labScreenProjectOverview.getPrimaryKeyObj(),
					labScreenProjectOverview);

				cacheResult(labScreenProjectOverview);

				uncachedPrimaryKeys.remove(labScreenProjectOverview.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labScreenProjectOverviewModelImpl.ENTITY_CACHE_ENABLED,
					labScreenProjectOverviewImpl.class, primaryKey, nullModel);
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
	 * Returns all the lab screen project overviews.
	 *
	 * @return the lab screen project overviews
	 */
	@Override
	public List<labScreenProjectOverview> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab screen project overviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab screen project overviews
	 * @param end the upper bound of the range of lab screen project overviews (not inclusive)
	 * @return the range of lab screen project overviews
	 */
	@Override
	public List<labScreenProjectOverview> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab screen project overviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab screen project overviews
	 * @param end the upper bound of the range of lab screen project overviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab screen project overviews
	 */
	@Override
	public List<labScreenProjectOverview> findAll(int start, int end,
		OrderByComparator<labScreenProjectOverview> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab screen project overviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectOverviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab screen project overviews
	 * @param end the upper bound of the range of lab screen project overviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab screen project overviews
	 */
	@Override
	public List<labScreenProjectOverview> findAll(int start, int end,
		OrderByComparator<labScreenProjectOverview> orderByComparator,
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

		List<labScreenProjectOverview> list = null;

		if (retrieveFromCache) {
			list = (List<labScreenProjectOverview>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABSCREENPROJECTOVERVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABSCREENPROJECTOVERVIEW;

				if (pagination) {
					sql = sql.concat(labScreenProjectOverviewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labScreenProjectOverview>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labScreenProjectOverview>)QueryUtil.list(q,
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
	 * Removes all the lab screen project overviews from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labScreenProjectOverview labScreenProjectOverview : findAll()) {
			remove(labScreenProjectOverview);
		}
	}

	/**
	 * Returns the number of lab screen project overviews.
	 *
	 * @return the number of lab screen project overviews
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABSCREENPROJECTOVERVIEW);

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
		return labScreenProjectOverviewModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab screen project overview persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labScreenProjectOverviewImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABSCREENPROJECTOVERVIEW = "SELECT labScreenProjectOverview FROM labScreenProjectOverview labScreenProjectOverview";
	private static final String _SQL_SELECT_LABSCREENPROJECTOVERVIEW_WHERE_PKS_IN =
		"SELECT labScreenProjectOverview FROM labScreenProjectOverview labScreenProjectOverview WHERE PK_projectId IN (";
	private static final String _SQL_COUNT_LABSCREENPROJECTOVERVIEW = "SELECT COUNT(labScreenProjectOverview) FROM labScreenProjectOverview labScreenProjectOverview";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labScreenProjectOverview.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labScreenProjectOverview exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(labScreenProjectOverviewPersistenceImpl.class);
}