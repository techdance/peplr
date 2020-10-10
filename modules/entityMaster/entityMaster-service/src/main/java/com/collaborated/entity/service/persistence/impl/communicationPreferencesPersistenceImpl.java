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

import com.collaborated.entity.exception.NoSuchcommunicationPreferencesException;
import com.collaborated.entity.model.communicationPreferences;
import com.collaborated.entity.model.impl.communicationPreferencesImpl;
import com.collaborated.entity.model.impl.communicationPreferencesModelImpl;
import com.collaborated.entity.service.persistence.communicationPreferencesPersistence;

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
 * The persistence implementation for the communication preferences service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see communicationPreferencesPersistence
 * @see com.collaborated.entity.service.persistence.communicationPreferencesUtil
 * @generated
 */
@ProviderType
public class communicationPreferencesPersistenceImpl extends BasePersistenceImpl<communicationPreferences>
	implements communicationPreferencesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link communicationPreferencesUtil} to access the communication preferences persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = communicationPreferencesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
			communicationPreferencesModelImpl.FINDER_CACHE_ENABLED,
			communicationPreferencesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
			communicationPreferencesModelImpl.FINDER_CACHE_ENABLED,
			communicationPreferencesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
			communicationPreferencesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public communicationPreferencesPersistenceImpl() {
		setModelClass(communicationPreferences.class);
	}

	/**
	 * Caches the communication preferences in the entity cache if it is enabled.
	 *
	 * @param communicationPreferences the communication preferences
	 */
	@Override
	public void cacheResult(communicationPreferences communicationPreferences) {
		entityCache.putResult(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
			communicationPreferencesImpl.class,
			communicationPreferences.getPrimaryKey(), communicationPreferences);

		communicationPreferences.resetOriginalValues();
	}

	/**
	 * Caches the communication preferenceses in the entity cache if it is enabled.
	 *
	 * @param communicationPreferenceses the communication preferenceses
	 */
	@Override
	public void cacheResult(
		List<communicationPreferences> communicationPreferenceses) {
		for (communicationPreferences communicationPreferences : communicationPreferenceses) {
			if (entityCache.getResult(
						communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
						communicationPreferencesImpl.class,
						communicationPreferences.getPrimaryKey()) == null) {
				cacheResult(communicationPreferences);
			}
			else {
				communicationPreferences.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all communication preferenceses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(communicationPreferencesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the communication preferences.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(communicationPreferences communicationPreferences) {
		entityCache.removeResult(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
			communicationPreferencesImpl.class,
			communicationPreferences.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<communicationPreferences> communicationPreferenceses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (communicationPreferences communicationPreferences : communicationPreferenceses) {
			entityCache.removeResult(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
				communicationPreferencesImpl.class,
				communicationPreferences.getPrimaryKey());
		}
	}

	/**
	 * Creates a new communication preferences with the primary key. Does not add the communication preferences to the database.
	 *
	 * @param PK_communicationPreferences the primary key for the new communication preferences
	 * @return the new communication preferences
	 */
	@Override
	public communicationPreferences create(long PK_communicationPreferences) {
		communicationPreferences communicationPreferences = new communicationPreferencesImpl();

		communicationPreferences.setNew(true);
		communicationPreferences.setPrimaryKey(PK_communicationPreferences);

		return communicationPreferences;
	}

	/**
	 * Removes the communication preferences with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_communicationPreferences the primary key of the communication preferences
	 * @return the communication preferences that was removed
	 * @throws NoSuchcommunicationPreferencesException if a communication preferences with the primary key could not be found
	 */
	@Override
	public communicationPreferences remove(long PK_communicationPreferences)
		throws NoSuchcommunicationPreferencesException {
		return remove((Serializable)PK_communicationPreferences);
	}

	/**
	 * Removes the communication preferences with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the communication preferences
	 * @return the communication preferences that was removed
	 * @throws NoSuchcommunicationPreferencesException if a communication preferences with the primary key could not be found
	 */
	@Override
	public communicationPreferences remove(Serializable primaryKey)
		throws NoSuchcommunicationPreferencesException {
		Session session = null;

		try {
			session = openSession();

			communicationPreferences communicationPreferences = (communicationPreferences)session.get(communicationPreferencesImpl.class,
					primaryKey);

			if (communicationPreferences == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcommunicationPreferencesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(communicationPreferences);
		}
		catch (NoSuchcommunicationPreferencesException nsee) {
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
	protected communicationPreferences removeImpl(
		communicationPreferences communicationPreferences) {
		communicationPreferences = toUnwrappedModel(communicationPreferences);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(communicationPreferences)) {
				communicationPreferences = (communicationPreferences)session.get(communicationPreferencesImpl.class,
						communicationPreferences.getPrimaryKeyObj());
			}

			if (communicationPreferences != null) {
				session.delete(communicationPreferences);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (communicationPreferences != null) {
			clearCache(communicationPreferences);
		}

		return communicationPreferences;
	}

	@Override
	public communicationPreferences updateImpl(
		communicationPreferences communicationPreferences) {
		communicationPreferences = toUnwrappedModel(communicationPreferences);

		boolean isNew = communicationPreferences.isNew();

		communicationPreferencesModelImpl communicationPreferencesModelImpl = (communicationPreferencesModelImpl)communicationPreferences;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (communicationPreferences.getCreateDate() == null)) {
			if (serviceContext == null) {
				communicationPreferences.setCreateDate(now);
			}
			else {
				communicationPreferences.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!communicationPreferencesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				communicationPreferences.setModifiedDate(now);
			}
			else {
				communicationPreferences.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (communicationPreferences.isNew()) {
				session.save(communicationPreferences);

				communicationPreferences.setNew(false);
			}
			else {
				communicationPreferences = (communicationPreferences)session.merge(communicationPreferences);
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

		entityCache.putResult(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
			communicationPreferencesImpl.class,
			communicationPreferences.getPrimaryKey(), communicationPreferences,
			false);

		communicationPreferences.resetOriginalValues();

		return communicationPreferences;
	}

	protected communicationPreferences toUnwrappedModel(
		communicationPreferences communicationPreferences) {
		if (communicationPreferences instanceof communicationPreferencesImpl) {
			return communicationPreferences;
		}

		communicationPreferencesImpl communicationPreferencesImpl = new communicationPreferencesImpl();

		communicationPreferencesImpl.setNew(communicationPreferences.isNew());
		communicationPreferencesImpl.setPrimaryKey(communicationPreferences.getPrimaryKey());

		communicationPreferencesImpl.setPK_communicationPreferences(communicationPreferences.getPK_communicationPreferences());
		communicationPreferencesImpl.setGroupId(communicationPreferences.getGroupId());
		communicationPreferencesImpl.setUserId(communicationPreferences.getUserId());
		communicationPreferencesImpl.setCreateDate(communicationPreferences.getCreateDate());
		communicationPreferencesImpl.setModifiedDate(communicationPreferences.getModifiedDate());
		communicationPreferencesImpl.setPrimaryLanguageId(communicationPreferences.getPrimaryLanguageId());
		communicationPreferencesImpl.setPrimaryLanguageName(communicationPreferences.getPrimaryLanguageName());
		communicationPreferencesImpl.setSecondaryLanguageId(communicationPreferences.getSecondaryLanguageId());
		communicationPreferencesImpl.setSecondaryLanguageName(communicationPreferences.getSecondaryLanguageName());
		communicationPreferencesImpl.setTertiaryLanguageId(communicationPreferences.getTertiaryLanguageId());
		communicationPreferencesImpl.setTertiaryLanguageName(communicationPreferences.getTertiaryLanguageName());
		communicationPreferencesImpl.setEmailAddress(communicationPreferences.getEmailAddress());
		communicationPreferencesImpl.setPhoneNumber(communicationPreferences.getPhoneNumber());
		communicationPreferencesImpl.setMobileNumber(communicationPreferences.getMobileNumber());
		communicationPreferencesImpl.setWebsite(communicationPreferences.getWebsite());

		return communicationPreferencesImpl;
	}

	/**
	 * Returns the communication preferences with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the communication preferences
	 * @return the communication preferences
	 * @throws NoSuchcommunicationPreferencesException if a communication preferences with the primary key could not be found
	 */
	@Override
	public communicationPreferences findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcommunicationPreferencesException {
		communicationPreferences communicationPreferences = fetchByPrimaryKey(primaryKey);

		if (communicationPreferences == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcommunicationPreferencesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return communicationPreferences;
	}

	/**
	 * Returns the communication preferences with the primary key or throws a {@link NoSuchcommunicationPreferencesException} if it could not be found.
	 *
	 * @param PK_communicationPreferences the primary key of the communication preferences
	 * @return the communication preferences
	 * @throws NoSuchcommunicationPreferencesException if a communication preferences with the primary key could not be found
	 */
	@Override
	public communicationPreferences findByPrimaryKey(
		long PK_communicationPreferences)
		throws NoSuchcommunicationPreferencesException {
		return findByPrimaryKey((Serializable)PK_communicationPreferences);
	}

	/**
	 * Returns the communication preferences with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the communication preferences
	 * @return the communication preferences, or <code>null</code> if a communication preferences with the primary key could not be found
	 */
	@Override
	public communicationPreferences fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
				communicationPreferencesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		communicationPreferences communicationPreferences = (communicationPreferences)serializable;

		if (communicationPreferences == null) {
			Session session = null;

			try {
				session = openSession();

				communicationPreferences = (communicationPreferences)session.get(communicationPreferencesImpl.class,
						primaryKey);

				if (communicationPreferences != null) {
					cacheResult(communicationPreferences);
				}
				else {
					entityCache.putResult(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
						communicationPreferencesImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
					communicationPreferencesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return communicationPreferences;
	}

	/**
	 * Returns the communication preferences with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_communicationPreferences the primary key of the communication preferences
	 * @return the communication preferences, or <code>null</code> if a communication preferences with the primary key could not be found
	 */
	@Override
	public communicationPreferences fetchByPrimaryKey(
		long PK_communicationPreferences) {
		return fetchByPrimaryKey((Serializable)PK_communicationPreferences);
	}

	@Override
	public Map<Serializable, communicationPreferences> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, communicationPreferences> map = new HashMap<Serializable, communicationPreferences>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			communicationPreferences communicationPreferences = fetchByPrimaryKey(primaryKey);

			if (communicationPreferences != null) {
				map.put(primaryKey, communicationPreferences);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
					communicationPreferencesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (communicationPreferences)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COMMUNICATIONPREFERENCES_WHERE_PKS_IN);

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

			for (communicationPreferences communicationPreferences : (List<communicationPreferences>)q.list()) {
				map.put(communicationPreferences.getPrimaryKeyObj(),
					communicationPreferences);

				cacheResult(communicationPreferences);

				uncachedPrimaryKeys.remove(communicationPreferences.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(communicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
					communicationPreferencesImpl.class, primaryKey, nullModel);
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
	 * Returns all the communication preferenceses.
	 *
	 * @return the communication preferenceses
	 */
	@Override
	public List<communicationPreferences> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the communication preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link communicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of communication preferenceses
	 * @param end the upper bound of the range of communication preferenceses (not inclusive)
	 * @return the range of communication preferenceses
	 */
	@Override
	public List<communicationPreferences> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the communication preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link communicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of communication preferenceses
	 * @param end the upper bound of the range of communication preferenceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of communication preferenceses
	 */
	@Override
	public List<communicationPreferences> findAll(int start, int end,
		OrderByComparator<communicationPreferences> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the communication preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link communicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of communication preferenceses
	 * @param end the upper bound of the range of communication preferenceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of communication preferenceses
	 */
	@Override
	public List<communicationPreferences> findAll(int start, int end,
		OrderByComparator<communicationPreferences> orderByComparator,
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

		List<communicationPreferences> list = null;

		if (retrieveFromCache) {
			list = (List<communicationPreferences>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMUNICATIONPREFERENCES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMUNICATIONPREFERENCES;

				if (pagination) {
					sql = sql.concat(communicationPreferencesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<communicationPreferences>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<communicationPreferences>)QueryUtil.list(q,
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
	 * Removes all the communication preferenceses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (communicationPreferences communicationPreferences : findAll()) {
			remove(communicationPreferences);
		}
	}

	/**
	 * Returns the number of communication preferenceses.
	 *
	 * @return the number of communication preferenceses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMUNICATIONPREFERENCES);

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
		return communicationPreferencesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the communication preferences persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(communicationPreferencesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_COMMUNICATIONPREFERENCES = "SELECT communicationPreferences FROM communicationPreferences communicationPreferences";
	private static final String _SQL_SELECT_COMMUNICATIONPREFERENCES_WHERE_PKS_IN =
		"SELECT communicationPreferences FROM communicationPreferences communicationPreferences WHERE PK_communicationPreferences IN (";
	private static final String _SQL_COUNT_COMMUNICATIONPREFERENCES = "SELECT COUNT(communicationPreferences) FROM communicationPreferences communicationPreferences";
	private static final String _ORDER_BY_ENTITY_ALIAS = "communicationPreferences.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No communicationPreferences exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(communicationPreferencesPersistenceImpl.class);
}