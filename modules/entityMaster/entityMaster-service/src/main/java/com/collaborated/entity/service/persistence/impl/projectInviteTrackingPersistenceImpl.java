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

import com.collaborated.entity.exception.NoSuchprojectInviteTrackingException;
import com.collaborated.entity.model.impl.projectInviteTrackingImpl;
import com.collaborated.entity.model.impl.projectInviteTrackingModelImpl;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.service.persistence.projectInviteTrackingPersistence;

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
 * The persistence implementation for the project invite tracking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see projectInviteTrackingPersistence
 * @see com.collaborated.entity.service.persistence.projectInviteTrackingUtil
 * @generated
 */
@ProviderType
public class projectInviteTrackingPersistenceImpl extends BasePersistenceImpl<projectInviteTracking>
	implements projectInviteTrackingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link projectInviteTrackingUtil} to access the project invite tracking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = projectInviteTrackingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
			projectInviteTrackingModelImpl.FINDER_CACHE_ENABLED,
			projectInviteTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
			projectInviteTrackingModelImpl.FINDER_CACHE_ENABLED,
			projectInviteTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
			projectInviteTrackingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public projectInviteTrackingPersistenceImpl() {
		setModelClass(projectInviteTracking.class);
	}

	/**
	 * Caches the project invite tracking in the entity cache if it is enabled.
	 *
	 * @param projectInviteTracking the project invite tracking
	 */
	@Override
	public void cacheResult(projectInviteTracking projectInviteTracking) {
		entityCache.putResult(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
			projectInviteTrackingImpl.class,
			projectInviteTracking.getPrimaryKey(), projectInviteTracking);

		projectInviteTracking.resetOriginalValues();
	}

	/**
	 * Caches the project invite trackings in the entity cache if it is enabled.
	 *
	 * @param projectInviteTrackings the project invite trackings
	 */
	@Override
	public void cacheResult(List<projectInviteTracking> projectInviteTrackings) {
		for (projectInviteTracking projectInviteTracking : projectInviteTrackings) {
			if (entityCache.getResult(
						projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
						projectInviteTrackingImpl.class,
						projectInviteTracking.getPrimaryKey()) == null) {
				cacheResult(projectInviteTracking);
			}
			else {
				projectInviteTracking.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project invite trackings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(projectInviteTrackingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project invite tracking.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(projectInviteTracking projectInviteTracking) {
		entityCache.removeResult(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
			projectInviteTrackingImpl.class,
			projectInviteTracking.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<projectInviteTracking> projectInviteTrackings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (projectInviteTracking projectInviteTracking : projectInviteTrackings) {
			entityCache.removeResult(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
				projectInviteTrackingImpl.class,
				projectInviteTracking.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project invite tracking with the primary key. Does not add the project invite tracking to the database.
	 *
	 * @param PK_projectInvitationId the primary key for the new project invite tracking
	 * @return the new project invite tracking
	 */
	@Override
	public projectInviteTracking create(long PK_projectInvitationId) {
		projectInviteTracking projectInviteTracking = new projectInviteTrackingImpl();

		projectInviteTracking.setNew(true);
		projectInviteTracking.setPrimaryKey(PK_projectInvitationId);

		return projectInviteTracking;
	}

	/**
	 * Removes the project invite tracking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_projectInvitationId the primary key of the project invite tracking
	 * @return the project invite tracking that was removed
	 * @throws NoSuchprojectInviteTrackingException if a project invite tracking with the primary key could not be found
	 */
	@Override
	public projectInviteTracking remove(long PK_projectInvitationId)
		throws NoSuchprojectInviteTrackingException {
		return remove((Serializable)PK_projectInvitationId);
	}

	/**
	 * Removes the project invite tracking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project invite tracking
	 * @return the project invite tracking that was removed
	 * @throws NoSuchprojectInviteTrackingException if a project invite tracking with the primary key could not be found
	 */
	@Override
	public projectInviteTracking remove(Serializable primaryKey)
		throws NoSuchprojectInviteTrackingException {
		Session session = null;

		try {
			session = openSession();

			projectInviteTracking projectInviteTracking = (projectInviteTracking)session.get(projectInviteTrackingImpl.class,
					primaryKey);

			if (projectInviteTracking == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchprojectInviteTrackingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectInviteTracking);
		}
		catch (NoSuchprojectInviteTrackingException nsee) {
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
	protected projectInviteTracking removeImpl(
		projectInviteTracking projectInviteTracking) {
		projectInviteTracking = toUnwrappedModel(projectInviteTracking);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectInviteTracking)) {
				projectInviteTracking = (projectInviteTracking)session.get(projectInviteTrackingImpl.class,
						projectInviteTracking.getPrimaryKeyObj());
			}

			if (projectInviteTracking != null) {
				session.delete(projectInviteTracking);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectInviteTracking != null) {
			clearCache(projectInviteTracking);
		}

		return projectInviteTracking;
	}

	@Override
	public projectInviteTracking updateImpl(
		projectInviteTracking projectInviteTracking) {
		projectInviteTracking = toUnwrappedModel(projectInviteTracking);

		boolean isNew = projectInviteTracking.isNew();

		projectInviteTrackingModelImpl projectInviteTrackingModelImpl = (projectInviteTrackingModelImpl)projectInviteTracking;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (projectInviteTracking.getCreateDate() == null)) {
			if (serviceContext == null) {
				projectInviteTracking.setCreateDate(now);
			}
			else {
				projectInviteTracking.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!projectInviteTrackingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				projectInviteTracking.setModifiedDate(now);
			}
			else {
				projectInviteTracking.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (projectInviteTracking.isNew()) {
				session.save(projectInviteTracking);

				projectInviteTracking.setNew(false);
			}
			else {
				projectInviteTracking = (projectInviteTracking)session.merge(projectInviteTracking);
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

		entityCache.putResult(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
			projectInviteTrackingImpl.class,
			projectInviteTracking.getPrimaryKey(), projectInviteTracking, false);

		projectInviteTracking.resetOriginalValues();

		return projectInviteTracking;
	}

	protected projectInviteTracking toUnwrappedModel(
		projectInviteTracking projectInviteTracking) {
		if (projectInviteTracking instanceof projectInviteTrackingImpl) {
			return projectInviteTracking;
		}

		projectInviteTrackingImpl projectInviteTrackingImpl = new projectInviteTrackingImpl();

		projectInviteTrackingImpl.setNew(projectInviteTracking.isNew());
		projectInviteTrackingImpl.setPrimaryKey(projectInviteTracking.getPrimaryKey());

		projectInviteTrackingImpl.setPK_projectInvitationId(projectInviteTracking.getPK_projectInvitationId());
		projectInviteTrackingImpl.setGroupId(projectInviteTracking.getGroupId());
		projectInviteTrackingImpl.setCreateDate(projectInviteTracking.getCreateDate());
		projectInviteTrackingImpl.setModifiedDate(projectInviteTracking.getModifiedDate());
		projectInviteTrackingImpl.setProjectId(projectInviteTracking.getProjectId());
		projectInviteTrackingImpl.setInviteFrom(projectInviteTracking.getInviteFrom());
		projectInviteTrackingImpl.setInviteTo(projectInviteTracking.getInviteTo());
		projectInviteTrackingImpl.setInvitationStatus(projectInviteTracking.getInvitationStatus());
		projectInviteTrackingImpl.setIsRead(projectInviteTracking.getIsRead());
		projectInviteTrackingImpl.setIsRemoved(projectInviteTracking.getIsRemoved());
		projectInviteTrackingImpl.setMessageTitle(projectInviteTracking.getMessageTitle());
		projectInviteTrackingImpl.setMessageContent(projectInviteTracking.getMessageContent());
		projectInviteTrackingImpl.setEmailContent(projectInviteTracking.getEmailContent());

		return projectInviteTrackingImpl;
	}

	/**
	 * Returns the project invite tracking with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project invite tracking
	 * @return the project invite tracking
	 * @throws NoSuchprojectInviteTrackingException if a project invite tracking with the primary key could not be found
	 */
	@Override
	public projectInviteTracking findByPrimaryKey(Serializable primaryKey)
		throws NoSuchprojectInviteTrackingException {
		projectInviteTracking projectInviteTracking = fetchByPrimaryKey(primaryKey);

		if (projectInviteTracking == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchprojectInviteTrackingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectInviteTracking;
	}

	/**
	 * Returns the project invite tracking with the primary key or throws a {@link NoSuchprojectInviteTrackingException} if it could not be found.
	 *
	 * @param PK_projectInvitationId the primary key of the project invite tracking
	 * @return the project invite tracking
	 * @throws NoSuchprojectInviteTrackingException if a project invite tracking with the primary key could not be found
	 */
	@Override
	public projectInviteTracking findByPrimaryKey(long PK_projectInvitationId)
		throws NoSuchprojectInviteTrackingException {
		return findByPrimaryKey((Serializable)PK_projectInvitationId);
	}

	/**
	 * Returns the project invite tracking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project invite tracking
	 * @return the project invite tracking, or <code>null</code> if a project invite tracking with the primary key could not be found
	 */
	@Override
	public projectInviteTracking fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
				projectInviteTrackingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		projectInviteTracking projectInviteTracking = (projectInviteTracking)serializable;

		if (projectInviteTracking == null) {
			Session session = null;

			try {
				session = openSession();

				projectInviteTracking = (projectInviteTracking)session.get(projectInviteTrackingImpl.class,
						primaryKey);

				if (projectInviteTracking != null) {
					cacheResult(projectInviteTracking);
				}
				else {
					entityCache.putResult(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
						projectInviteTrackingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
					projectInviteTrackingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectInviteTracking;
	}

	/**
	 * Returns the project invite tracking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_projectInvitationId the primary key of the project invite tracking
	 * @return the project invite tracking, or <code>null</code> if a project invite tracking with the primary key could not be found
	 */
	@Override
	public projectInviteTracking fetchByPrimaryKey(long PK_projectInvitationId) {
		return fetchByPrimaryKey((Serializable)PK_projectInvitationId);
	}

	@Override
	public Map<Serializable, projectInviteTracking> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, projectInviteTracking> map = new HashMap<Serializable, projectInviteTracking>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			projectInviteTracking projectInviteTracking = fetchByPrimaryKey(primaryKey);

			if (projectInviteTracking != null) {
				map.put(primaryKey, projectInviteTracking);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
					projectInviteTrackingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (projectInviteTracking)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTINVITETRACKING_WHERE_PKS_IN);

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

			for (projectInviteTracking projectInviteTracking : (List<projectInviteTracking>)q.list()) {
				map.put(projectInviteTracking.getPrimaryKeyObj(),
					projectInviteTracking);

				cacheResult(projectInviteTracking);

				uncachedPrimaryKeys.remove(projectInviteTracking.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(projectInviteTrackingModelImpl.ENTITY_CACHE_ENABLED,
					projectInviteTrackingImpl.class, primaryKey, nullModel);
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
	 * Returns all the project invite trackings.
	 *
	 * @return the project invite trackings
	 */
	@Override
	public List<projectInviteTracking> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project invite trackings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectInviteTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project invite trackings
	 * @param end the upper bound of the range of project invite trackings (not inclusive)
	 * @return the range of project invite trackings
	 */
	@Override
	public List<projectInviteTracking> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project invite trackings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectInviteTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project invite trackings
	 * @param end the upper bound of the range of project invite trackings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project invite trackings
	 */
	@Override
	public List<projectInviteTracking> findAll(int start, int end,
		OrderByComparator<projectInviteTracking> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project invite trackings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link projectInviteTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project invite trackings
	 * @param end the upper bound of the range of project invite trackings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project invite trackings
	 */
	@Override
	public List<projectInviteTracking> findAll(int start, int end,
		OrderByComparator<projectInviteTracking> orderByComparator,
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

		List<projectInviteTracking> list = null;

		if (retrieveFromCache) {
			list = (List<projectInviteTracking>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTINVITETRACKING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTINVITETRACKING;

				if (pagination) {
					sql = sql.concat(projectInviteTrackingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<projectInviteTracking>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<projectInviteTracking>)QueryUtil.list(q,
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
	 * Removes all the project invite trackings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (projectInviteTracking projectInviteTracking : findAll()) {
			remove(projectInviteTracking);
		}
	}

	/**
	 * Returns the number of project invite trackings.
	 *
	 * @return the number of project invite trackings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTINVITETRACKING);

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
		return projectInviteTrackingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project invite tracking persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(projectInviteTrackingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTINVITETRACKING = "SELECT projectInviteTracking FROM projectInviteTracking projectInviteTracking";
	private static final String _SQL_SELECT_PROJECTINVITETRACKING_WHERE_PKS_IN = "SELECT projectInviteTracking FROM projectInviteTracking projectInviteTracking WHERE PK_projectInvitationId IN (";
	private static final String _SQL_COUNT_PROJECTINVITETRACKING = "SELECT COUNT(projectInviteTracking) FROM projectInviteTracking projectInviteTracking";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectInviteTracking.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No projectInviteTracking exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(projectInviteTrackingPersistenceImpl.class);
}