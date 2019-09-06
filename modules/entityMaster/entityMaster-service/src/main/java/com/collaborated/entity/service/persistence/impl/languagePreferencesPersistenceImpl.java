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

import com.collaborated.entity.exception.NoSuchlanguagePreferencesException;
import com.collaborated.entity.model.impl.languagePreferencesImpl;
import com.collaborated.entity.model.impl.languagePreferencesModelImpl;
import com.collaborated.entity.model.languagePreferences;
import com.collaborated.entity.service.persistence.languagePreferencesPersistence;

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
 * The persistence implementation for the language preferences service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see languagePreferencesPersistence
 * @see com.collaborated.entity.service.persistence.languagePreferencesUtil
 * @generated
 */
@ProviderType
public class languagePreferencesPersistenceImpl extends BasePersistenceImpl<languagePreferences>
	implements languagePreferencesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link languagePreferencesUtil} to access the language preferences persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = languagePreferencesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			languagePreferencesModelImpl.FINDER_CACHE_ENABLED,
			languagePreferencesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			languagePreferencesModelImpl.FINDER_CACHE_ENABLED,
			languagePreferencesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			languagePreferencesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public languagePreferencesPersistenceImpl() {
		setModelClass(languagePreferences.class);
	}

	/**
	 * Caches the language preferences in the entity cache if it is enabled.
	 *
	 * @param languagePreferences the language preferences
	 */
	@Override
	public void cacheResult(languagePreferences languagePreferences) {
		entityCache.putResult(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			languagePreferencesImpl.class, languagePreferences.getPrimaryKey(),
			languagePreferences);

		languagePreferences.resetOriginalValues();
	}

	/**
	 * Caches the language preferenceses in the entity cache if it is enabled.
	 *
	 * @param languagePreferenceses the language preferenceses
	 */
	@Override
	public void cacheResult(List<languagePreferences> languagePreferenceses) {
		for (languagePreferences languagePreferences : languagePreferenceses) {
			if (entityCache.getResult(
						languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
						languagePreferencesImpl.class,
						languagePreferences.getPrimaryKey()) == null) {
				cacheResult(languagePreferences);
			}
			else {
				languagePreferences.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all language preferenceses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(languagePreferencesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the language preferences.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(languagePreferences languagePreferences) {
		entityCache.removeResult(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			languagePreferencesImpl.class, languagePreferences.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<languagePreferences> languagePreferenceses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (languagePreferences languagePreferences : languagePreferenceses) {
			entityCache.removeResult(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
				languagePreferencesImpl.class,
				languagePreferences.getPrimaryKey());
		}
	}

	/**
	 * Creates a new language preferences with the primary key. Does not add the language preferences to the database.
	 *
	 * @param PK_languagePreferences the primary key for the new language preferences
	 * @return the new language preferences
	 */
	@Override
	public languagePreferences create(long PK_languagePreferences) {
		languagePreferences languagePreferences = new languagePreferencesImpl();

		languagePreferences.setNew(true);
		languagePreferences.setPrimaryKey(PK_languagePreferences);

		return languagePreferences;
	}

	/**
	 * Removes the language preferences with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_languagePreferences the primary key of the language preferences
	 * @return the language preferences that was removed
	 * @throws NoSuchlanguagePreferencesException if a language preferences with the primary key could not be found
	 */
	@Override
	public languagePreferences remove(long PK_languagePreferences)
		throws NoSuchlanguagePreferencesException {
		return remove((Serializable)PK_languagePreferences);
	}

	/**
	 * Removes the language preferences with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the language preferences
	 * @return the language preferences that was removed
	 * @throws NoSuchlanguagePreferencesException if a language preferences with the primary key could not be found
	 */
	@Override
	public languagePreferences remove(Serializable primaryKey)
		throws NoSuchlanguagePreferencesException {
		Session session = null;

		try {
			session = openSession();

			languagePreferences languagePreferences = (languagePreferences)session.get(languagePreferencesImpl.class,
					primaryKey);

			if (languagePreferences == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlanguagePreferencesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(languagePreferences);
		}
		catch (NoSuchlanguagePreferencesException nsee) {
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
	protected languagePreferences removeImpl(
		languagePreferences languagePreferences) {
		languagePreferences = toUnwrappedModel(languagePreferences);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(languagePreferences)) {
				languagePreferences = (languagePreferences)session.get(languagePreferencesImpl.class,
						languagePreferences.getPrimaryKeyObj());
			}

			if (languagePreferences != null) {
				session.delete(languagePreferences);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (languagePreferences != null) {
			clearCache(languagePreferences);
		}

		return languagePreferences;
	}

	@Override
	public languagePreferences updateImpl(
		languagePreferences languagePreferences) {
		languagePreferences = toUnwrappedModel(languagePreferences);

		boolean isNew = languagePreferences.isNew();

		languagePreferencesModelImpl languagePreferencesModelImpl = (languagePreferencesModelImpl)languagePreferences;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (languagePreferences.getCreateDate() == null)) {
			if (serviceContext == null) {
				languagePreferences.setCreateDate(now);
			}
			else {
				languagePreferences.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!languagePreferencesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				languagePreferences.setModifiedDate(now);
			}
			else {
				languagePreferences.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (languagePreferences.isNew()) {
				session.save(languagePreferences);

				languagePreferences.setNew(false);
			}
			else {
				languagePreferences = (languagePreferences)session.merge(languagePreferences);
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

		entityCache.putResult(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			languagePreferencesImpl.class, languagePreferences.getPrimaryKey(),
			languagePreferences, false);

		languagePreferences.resetOriginalValues();

		return languagePreferences;
	}

	protected languagePreferences toUnwrappedModel(
		languagePreferences languagePreferences) {
		if (languagePreferences instanceof languagePreferencesImpl) {
			return languagePreferences;
		}

		languagePreferencesImpl languagePreferencesImpl = new languagePreferencesImpl();

		languagePreferencesImpl.setNew(languagePreferences.isNew());
		languagePreferencesImpl.setPrimaryKey(languagePreferences.getPrimaryKey());

		languagePreferencesImpl.setPK_languagePreferences(languagePreferences.getPK_languagePreferences());
		languagePreferencesImpl.setUserId(languagePreferences.getUserId());
		languagePreferencesImpl.setCreateDate(languagePreferences.getCreateDate());
		languagePreferencesImpl.setModifiedDate(languagePreferences.getModifiedDate());
		languagePreferencesImpl.setLanguageName(languagePreferences.getLanguageName());

		return languagePreferencesImpl;
	}

	/**
	 * Returns the language preferences with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the language preferences
	 * @return the language preferences
	 * @throws NoSuchlanguagePreferencesException if a language preferences with the primary key could not be found
	 */
	@Override
	public languagePreferences findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlanguagePreferencesException {
		languagePreferences languagePreferences = fetchByPrimaryKey(primaryKey);

		if (languagePreferences == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlanguagePreferencesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return languagePreferences;
	}

	/**
	 * Returns the language preferences with the primary key or throws a {@link NoSuchlanguagePreferencesException} if it could not be found.
	 *
	 * @param PK_languagePreferences the primary key of the language preferences
	 * @return the language preferences
	 * @throws NoSuchlanguagePreferencesException if a language preferences with the primary key could not be found
	 */
	@Override
	public languagePreferences findByPrimaryKey(long PK_languagePreferences)
		throws NoSuchlanguagePreferencesException {
		return findByPrimaryKey((Serializable)PK_languagePreferences);
	}

	/**
	 * Returns the language preferences with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the language preferences
	 * @return the language preferences, or <code>null</code> if a language preferences with the primary key could not be found
	 */
	@Override
	public languagePreferences fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
				languagePreferencesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		languagePreferences languagePreferences = (languagePreferences)serializable;

		if (languagePreferences == null) {
			Session session = null;

			try {
				session = openSession();

				languagePreferences = (languagePreferences)session.get(languagePreferencesImpl.class,
						primaryKey);

				if (languagePreferences != null) {
					cacheResult(languagePreferences);
				}
				else {
					entityCache.putResult(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
						languagePreferencesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
					languagePreferencesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return languagePreferences;
	}

	/**
	 * Returns the language preferences with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_languagePreferences the primary key of the language preferences
	 * @return the language preferences, or <code>null</code> if a language preferences with the primary key could not be found
	 */
	@Override
	public languagePreferences fetchByPrimaryKey(long PK_languagePreferences) {
		return fetchByPrimaryKey((Serializable)PK_languagePreferences);
	}

	@Override
	public Map<Serializable, languagePreferences> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, languagePreferences> map = new HashMap<Serializable, languagePreferences>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			languagePreferences languagePreferences = fetchByPrimaryKey(primaryKey);

			if (languagePreferences != null) {
				map.put(primaryKey, languagePreferences);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
					languagePreferencesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (languagePreferences)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LANGUAGEPREFERENCES_WHERE_PKS_IN);

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

			for (languagePreferences languagePreferences : (List<languagePreferences>)q.list()) {
				map.put(languagePreferences.getPrimaryKeyObj(),
					languagePreferences);

				cacheResult(languagePreferences);

				uncachedPrimaryKeys.remove(languagePreferences.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(languagePreferencesModelImpl.ENTITY_CACHE_ENABLED,
					languagePreferencesImpl.class, primaryKey, nullModel);
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
	 * Returns all the language preferenceses.
	 *
	 * @return the language preferenceses
	 */
	@Override
	public List<languagePreferences> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the language preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of language preferenceses
	 * @param end the upper bound of the range of language preferenceses (not inclusive)
	 * @return the range of language preferenceses
	 */
	@Override
	public List<languagePreferences> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the language preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of language preferenceses
	 * @param end the upper bound of the range of language preferenceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of language preferenceses
	 */
	@Override
	public List<languagePreferences> findAll(int start, int end,
		OrderByComparator<languagePreferences> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the language preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of language preferenceses
	 * @param end the upper bound of the range of language preferenceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of language preferenceses
	 */
	@Override
	public List<languagePreferences> findAll(int start, int end,
		OrderByComparator<languagePreferences> orderByComparator,
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

		List<languagePreferences> list = null;

		if (retrieveFromCache) {
			list = (List<languagePreferences>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LANGUAGEPREFERENCES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LANGUAGEPREFERENCES;

				if (pagination) {
					sql = sql.concat(languagePreferencesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<languagePreferences>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<languagePreferences>)QueryUtil.list(q,
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
	 * Removes all the language preferenceses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (languagePreferences languagePreferences : findAll()) {
			remove(languagePreferences);
		}
	}

	/**
	 * Returns the number of language preferenceses.
	 *
	 * @return the number of language preferenceses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LANGUAGEPREFERENCES);

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
		return languagePreferencesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the language preferences persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(languagePreferencesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LANGUAGEPREFERENCES = "SELECT languagePreferences FROM languagePreferences languagePreferences";
	private static final String _SQL_SELECT_LANGUAGEPREFERENCES_WHERE_PKS_IN = "SELECT languagePreferences FROM languagePreferences languagePreferences WHERE PK_languagePreferences IN (";
	private static final String _SQL_COUNT_LANGUAGEPREFERENCES = "SELECT COUNT(languagePreferences) FROM languagePreferences languagePreferences";
	private static final String _ORDER_BY_ENTITY_ALIAS = "languagePreferences.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No languagePreferences exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(languagePreferencesPersistenceImpl.class);
}