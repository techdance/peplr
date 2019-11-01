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

import com.collaborated.entity.exception.NoSuchprofileAreaofinterestException;
import com.collaborated.entity.model.impl.profileAreaofinterestImpl;
import com.collaborated.entity.model.impl.profileAreaofinterestModelImpl;
import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.service.persistence.profileAreaofinterestPersistence;

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
 * The persistence implementation for the profile areaofinterest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profileAreaofinterestPersistence
 * @see com.collaborated.entity.service.persistence.profileAreaofinterestUtil
 * @generated
 */
@ProviderType
public class profileAreaofinterestPersistenceImpl extends BasePersistenceImpl<profileAreaofinterest>
	implements profileAreaofinterestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link profileAreaofinterestUtil} to access the profile areaofinterest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = profileAreaofinterestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
			profileAreaofinterestModelImpl.FINDER_CACHE_ENABLED,
			profileAreaofinterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
			profileAreaofinterestModelImpl.FINDER_CACHE_ENABLED,
			profileAreaofinterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
			profileAreaofinterestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public profileAreaofinterestPersistenceImpl() {
		setModelClass(profileAreaofinterest.class);
	}

	/**
	 * Caches the profile areaofinterest in the entity cache if it is enabled.
	 *
	 * @param profileAreaofinterest the profile areaofinterest
	 */
	@Override
	public void cacheResult(profileAreaofinterest profileAreaofinterest) {
		entityCache.putResult(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
			profileAreaofinterestImpl.class,
			profileAreaofinterest.getPrimaryKey(), profileAreaofinterest);

		profileAreaofinterest.resetOriginalValues();
	}

	/**
	 * Caches the profile areaofinterests in the entity cache if it is enabled.
	 *
	 * @param profileAreaofinterests the profile areaofinterests
	 */
	@Override
	public void cacheResult(List<profileAreaofinterest> profileAreaofinterests) {
		for (profileAreaofinterest profileAreaofinterest : profileAreaofinterests) {
			if (entityCache.getResult(
						profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
						profileAreaofinterestImpl.class,
						profileAreaofinterest.getPrimaryKey()) == null) {
				cacheResult(profileAreaofinterest);
			}
			else {
				profileAreaofinterest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all profile areaofinterests.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(profileAreaofinterestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the profile areaofinterest.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(profileAreaofinterest profileAreaofinterest) {
		entityCache.removeResult(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
			profileAreaofinterestImpl.class,
			profileAreaofinterest.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<profileAreaofinterest> profileAreaofinterests) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (profileAreaofinterest profileAreaofinterest : profileAreaofinterests) {
			entityCache.removeResult(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
				profileAreaofinterestImpl.class,
				profileAreaofinterest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new profile areaofinterest with the primary key. Does not add the profile areaofinterest to the database.
	 *
	 * @param PK_areaofinterest the primary key for the new profile areaofinterest
	 * @return the new profile areaofinterest
	 */
	@Override
	public profileAreaofinterest create(long PK_areaofinterest) {
		profileAreaofinterest profileAreaofinterest = new profileAreaofinterestImpl();

		profileAreaofinterest.setNew(true);
		profileAreaofinterest.setPrimaryKey(PK_areaofinterest);

		return profileAreaofinterest;
	}

	/**
	 * Removes the profile areaofinterest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_areaofinterest the primary key of the profile areaofinterest
	 * @return the profile areaofinterest that was removed
	 * @throws NoSuchprofileAreaofinterestException if a profile areaofinterest with the primary key could not be found
	 */
	@Override
	public profileAreaofinterest remove(long PK_areaofinterest)
		throws NoSuchprofileAreaofinterestException {
		return remove((Serializable)PK_areaofinterest);
	}

	/**
	 * Removes the profile areaofinterest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the profile areaofinterest
	 * @return the profile areaofinterest that was removed
	 * @throws NoSuchprofileAreaofinterestException if a profile areaofinterest with the primary key could not be found
	 */
	@Override
	public profileAreaofinterest remove(Serializable primaryKey)
		throws NoSuchprofileAreaofinterestException {
		Session session = null;

		try {
			session = openSession();

			profileAreaofinterest profileAreaofinterest = (profileAreaofinterest)session.get(profileAreaofinterestImpl.class,
					primaryKey);

			if (profileAreaofinterest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchprofileAreaofinterestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(profileAreaofinterest);
		}
		catch (NoSuchprofileAreaofinterestException nsee) {
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
	protected profileAreaofinterest removeImpl(
		profileAreaofinterest profileAreaofinterest) {
		profileAreaofinterest = toUnwrappedModel(profileAreaofinterest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(profileAreaofinterest)) {
				profileAreaofinterest = (profileAreaofinterest)session.get(profileAreaofinterestImpl.class,
						profileAreaofinterest.getPrimaryKeyObj());
			}

			if (profileAreaofinterest != null) {
				session.delete(profileAreaofinterest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (profileAreaofinterest != null) {
			clearCache(profileAreaofinterest);
		}

		return profileAreaofinterest;
	}

	@Override
	public profileAreaofinterest updateImpl(
		profileAreaofinterest profileAreaofinterest) {
		profileAreaofinterest = toUnwrappedModel(profileAreaofinterest);

		boolean isNew = profileAreaofinterest.isNew();

		profileAreaofinterestModelImpl profileAreaofinterestModelImpl = (profileAreaofinterestModelImpl)profileAreaofinterest;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (profileAreaofinterest.getCreateDate() == null)) {
			if (serviceContext == null) {
				profileAreaofinterest.setCreateDate(now);
			}
			else {
				profileAreaofinterest.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!profileAreaofinterestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				profileAreaofinterest.setModifiedDate(now);
			}
			else {
				profileAreaofinterest.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (profileAreaofinterest.isNew()) {
				session.save(profileAreaofinterest);

				profileAreaofinterest.setNew(false);
			}
			else {
				profileAreaofinterest = (profileAreaofinterest)session.merge(profileAreaofinterest);
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

		entityCache.putResult(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
			profileAreaofinterestImpl.class,
			profileAreaofinterest.getPrimaryKey(), profileAreaofinterest, false);

		profileAreaofinterest.resetOriginalValues();

		return profileAreaofinterest;
	}

	protected profileAreaofinterest toUnwrappedModel(
		profileAreaofinterest profileAreaofinterest) {
		if (profileAreaofinterest instanceof profileAreaofinterestImpl) {
			return profileAreaofinterest;
		}

		profileAreaofinterestImpl profileAreaofinterestImpl = new profileAreaofinterestImpl();

		profileAreaofinterestImpl.setNew(profileAreaofinterest.isNew());
		profileAreaofinterestImpl.setPrimaryKey(profileAreaofinterest.getPrimaryKey());

		profileAreaofinterestImpl.setPK_areaofinterest(profileAreaofinterest.getPK_areaofinterest());
		profileAreaofinterestImpl.setGroupId(profileAreaofinterest.getGroupId());
		profileAreaofinterestImpl.setUserId(profileAreaofinterest.getUserId());
		profileAreaofinterestImpl.setCreateDate(profileAreaofinterest.getCreateDate());
		profileAreaofinterestImpl.setModifiedDate(profileAreaofinterest.getModifiedDate());
		profileAreaofinterestImpl.setProjectType(profileAreaofinterest.getProjectType());
		profileAreaofinterestImpl.setDescription(profileAreaofinterest.getDescription());
		profileAreaofinterestImpl.setDiscipline(profileAreaofinterest.getDiscipline());
		profileAreaofinterestImpl.setLanguage(profileAreaofinterest.getLanguage());
		profileAreaofinterestImpl.setLocation(profileAreaofinterest.getLocation());
		profileAreaofinterestImpl.setCampus(profileAreaofinterest.getCampus());
		profileAreaofinterestImpl.setProgramLevel(profileAreaofinterest.getProgramLevel());
		profileAreaofinterestImpl.setProgramLength(profileAreaofinterest.getProgramLength());
		profileAreaofinterestImpl.setDeliveryMethod(profileAreaofinterest.getDeliveryMethod());
		profileAreaofinterestImpl.setCredits(profileAreaofinterest.getCredits());

		return profileAreaofinterestImpl;
	}

	/**
	 * Returns the profile areaofinterest with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile areaofinterest
	 * @return the profile areaofinterest
	 * @throws NoSuchprofileAreaofinterestException if a profile areaofinterest with the primary key could not be found
	 */
	@Override
	public profileAreaofinterest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchprofileAreaofinterestException {
		profileAreaofinterest profileAreaofinterest = fetchByPrimaryKey(primaryKey);

		if (profileAreaofinterest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchprofileAreaofinterestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return profileAreaofinterest;
	}

	/**
	 * Returns the profile areaofinterest with the primary key or throws a {@link NoSuchprofileAreaofinterestException} if it could not be found.
	 *
	 * @param PK_areaofinterest the primary key of the profile areaofinterest
	 * @return the profile areaofinterest
	 * @throws NoSuchprofileAreaofinterestException if a profile areaofinterest with the primary key could not be found
	 */
	@Override
	public profileAreaofinterest findByPrimaryKey(long PK_areaofinterest)
		throws NoSuchprofileAreaofinterestException {
		return findByPrimaryKey((Serializable)PK_areaofinterest);
	}

	/**
	 * Returns the profile areaofinterest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile areaofinterest
	 * @return the profile areaofinterest, or <code>null</code> if a profile areaofinterest with the primary key could not be found
	 */
	@Override
	public profileAreaofinterest fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
				profileAreaofinterestImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		profileAreaofinterest profileAreaofinterest = (profileAreaofinterest)serializable;

		if (profileAreaofinterest == null) {
			Session session = null;

			try {
				session = openSession();

				profileAreaofinterest = (profileAreaofinterest)session.get(profileAreaofinterestImpl.class,
						primaryKey);

				if (profileAreaofinterest != null) {
					cacheResult(profileAreaofinterest);
				}
				else {
					entityCache.putResult(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
						profileAreaofinterestImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
					profileAreaofinterestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return profileAreaofinterest;
	}

	/**
	 * Returns the profile areaofinterest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_areaofinterest the primary key of the profile areaofinterest
	 * @return the profile areaofinterest, or <code>null</code> if a profile areaofinterest with the primary key could not be found
	 */
	@Override
	public profileAreaofinterest fetchByPrimaryKey(long PK_areaofinterest) {
		return fetchByPrimaryKey((Serializable)PK_areaofinterest);
	}

	@Override
	public Map<Serializable, profileAreaofinterest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, profileAreaofinterest> map = new HashMap<Serializable, profileAreaofinterest>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			profileAreaofinterest profileAreaofinterest = fetchByPrimaryKey(primaryKey);

			if (profileAreaofinterest != null) {
				map.put(primaryKey, profileAreaofinterest);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
					profileAreaofinterestImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (profileAreaofinterest)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROFILEAREAOFINTEREST_WHERE_PKS_IN);

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

			for (profileAreaofinterest profileAreaofinterest : (List<profileAreaofinterest>)q.list()) {
				map.put(profileAreaofinterest.getPrimaryKeyObj(),
					profileAreaofinterest);

				cacheResult(profileAreaofinterest);

				uncachedPrimaryKeys.remove(profileAreaofinterest.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(profileAreaofinterestModelImpl.ENTITY_CACHE_ENABLED,
					profileAreaofinterestImpl.class, primaryKey, nullModel);
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
	 * Returns all the profile areaofinterests.
	 *
	 * @return the profile areaofinterests
	 */
	@Override
	public List<profileAreaofinterest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile areaofinterests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile areaofinterests
	 * @param end the upper bound of the range of profile areaofinterests (not inclusive)
	 * @return the range of profile areaofinterests
	 */
	@Override
	public List<profileAreaofinterest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile areaofinterests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile areaofinterests
	 * @param end the upper bound of the range of profile areaofinterests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile areaofinterests
	 */
	@Override
	public List<profileAreaofinterest> findAll(int start, int end,
		OrderByComparator<profileAreaofinterest> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the profile areaofinterests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile areaofinterests
	 * @param end the upper bound of the range of profile areaofinterests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of profile areaofinterests
	 */
	@Override
	public List<profileAreaofinterest> findAll(int start, int end,
		OrderByComparator<profileAreaofinterest> orderByComparator,
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

		List<profileAreaofinterest> list = null;

		if (retrieveFromCache) {
			list = (List<profileAreaofinterest>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROFILEAREAOFINTEREST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROFILEAREAOFINTEREST;

				if (pagination) {
					sql = sql.concat(profileAreaofinterestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<profileAreaofinterest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<profileAreaofinterest>)QueryUtil.list(q,
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
	 * Removes all the profile areaofinterests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (profileAreaofinterest profileAreaofinterest : findAll()) {
			remove(profileAreaofinterest);
		}
	}

	/**
	 * Returns the number of profile areaofinterests.
	 *
	 * @return the number of profile areaofinterests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROFILEAREAOFINTEREST);

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
		return profileAreaofinterestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the profile areaofinterest persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(profileAreaofinterestImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROFILEAREAOFINTEREST = "SELECT profileAreaofinterest FROM profileAreaofinterest profileAreaofinterest";
	private static final String _SQL_SELECT_PROFILEAREAOFINTEREST_WHERE_PKS_IN = "SELECT profileAreaofinterest FROM profileAreaofinterest profileAreaofinterest WHERE PK_areaofinterest IN (";
	private static final String _SQL_COUNT_PROFILEAREAOFINTEREST = "SELECT COUNT(profileAreaofinterest) FROM profileAreaofinterest profileAreaofinterest";
	private static final String _ORDER_BY_ENTITY_ALIAS = "profileAreaofinterest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No profileAreaofinterest exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(profileAreaofinterestPersistenceImpl.class);
}