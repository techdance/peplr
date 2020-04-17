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

import com.collaborated.entity.exception.NoSuchuserCredentialException;
import com.collaborated.entity.model.impl.userCredentialImpl;
import com.collaborated.entity.model.impl.userCredentialModelImpl;
import com.collaborated.entity.model.userCredential;
import com.collaborated.entity.service.persistence.userCredentialPersistence;

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
 * The persistence implementation for the user credential service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userCredentialPersistence
 * @see com.collaborated.entity.service.persistence.userCredentialUtil
 * @generated
 */
@ProviderType
public class userCredentialPersistenceImpl extends BasePersistenceImpl<userCredential>
	implements userCredentialPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link userCredentialUtil} to access the user credential persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = userCredentialImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
			userCredentialModelImpl.FINDER_CACHE_ENABLED,
			userCredentialImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
			userCredentialModelImpl.FINDER_CACHE_ENABLED,
			userCredentialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
			userCredentialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public userCredentialPersistenceImpl() {
		setModelClass(userCredential.class);
	}

	/**
	 * Caches the user credential in the entity cache if it is enabled.
	 *
	 * @param userCredential the user credential
	 */
	@Override
	public void cacheResult(userCredential userCredential) {
		entityCache.putResult(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
			userCredentialImpl.class, userCredential.getPrimaryKey(),
			userCredential);

		userCredential.resetOriginalValues();
	}

	/**
	 * Caches the user credentials in the entity cache if it is enabled.
	 *
	 * @param userCredentials the user credentials
	 */
	@Override
	public void cacheResult(List<userCredential> userCredentials) {
		for (userCredential userCredential : userCredentials) {
			if (entityCache.getResult(
						userCredentialModelImpl.ENTITY_CACHE_ENABLED,
						userCredentialImpl.class, userCredential.getPrimaryKey()) == null) {
				cacheResult(userCredential);
			}
			else {
				userCredential.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user credentials.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(userCredentialImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user credential.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(userCredential userCredential) {
		entityCache.removeResult(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
			userCredentialImpl.class, userCredential.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<userCredential> userCredentials) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (userCredential userCredential : userCredentials) {
			entityCache.removeResult(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
				userCredentialImpl.class, userCredential.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user credential with the primary key. Does not add the user credential to the database.
	 *
	 * @param PK_userCredential the primary key for the new user credential
	 * @return the new user credential
	 */
	@Override
	public userCredential create(long PK_userCredential) {
		userCredential userCredential = new userCredentialImpl();

		userCredential.setNew(true);
		userCredential.setPrimaryKey(PK_userCredential);

		return userCredential;
	}

	/**
	 * Removes the user credential with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_userCredential the primary key of the user credential
	 * @return the user credential that was removed
	 * @throws NoSuchuserCredentialException if a user credential with the primary key could not be found
	 */
	@Override
	public userCredential remove(long PK_userCredential)
		throws NoSuchuserCredentialException {
		return remove((Serializable)PK_userCredential);
	}

	/**
	 * Removes the user credential with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user credential
	 * @return the user credential that was removed
	 * @throws NoSuchuserCredentialException if a user credential with the primary key could not be found
	 */
	@Override
	public userCredential remove(Serializable primaryKey)
		throws NoSuchuserCredentialException {
		Session session = null;

		try {
			session = openSession();

			userCredential userCredential = (userCredential)session.get(userCredentialImpl.class,
					primaryKey);

			if (userCredential == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchuserCredentialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userCredential);
		}
		catch (NoSuchuserCredentialException nsee) {
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
	protected userCredential removeImpl(userCredential userCredential) {
		userCredential = toUnwrappedModel(userCredential);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userCredential)) {
				userCredential = (userCredential)session.get(userCredentialImpl.class,
						userCredential.getPrimaryKeyObj());
			}

			if (userCredential != null) {
				session.delete(userCredential);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userCredential != null) {
			clearCache(userCredential);
		}

		return userCredential;
	}

	@Override
	public userCredential updateImpl(userCredential userCredential) {
		userCredential = toUnwrappedModel(userCredential);

		boolean isNew = userCredential.isNew();

		userCredentialModelImpl userCredentialModelImpl = (userCredentialModelImpl)userCredential;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userCredential.getCreateDate() == null)) {
			if (serviceContext == null) {
				userCredential.setCreateDate(now);
			}
			else {
				userCredential.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!userCredentialModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userCredential.setModifiedDate(now);
			}
			else {
				userCredential.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userCredential.isNew()) {
				session.save(userCredential);

				userCredential.setNew(false);
			}
			else {
				userCredential = (userCredential)session.merge(userCredential);
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

		entityCache.putResult(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
			userCredentialImpl.class, userCredential.getPrimaryKey(),
			userCredential, false);

		userCredential.resetOriginalValues();

		return userCredential;
	}

	protected userCredential toUnwrappedModel(userCredential userCredential) {
		if (userCredential instanceof userCredentialImpl) {
			return userCredential;
		}

		userCredentialImpl userCredentialImpl = new userCredentialImpl();

		userCredentialImpl.setNew(userCredential.isNew());
		userCredentialImpl.setPrimaryKey(userCredential.getPrimaryKey());

		userCredentialImpl.setPK_userCredential(userCredential.getPK_userCredential());
		userCredentialImpl.setGroupId(userCredential.getGroupId());
		userCredentialImpl.setUserId(userCredential.getUserId());
		userCredentialImpl.setCreateDate(userCredential.getCreateDate());
		userCredentialImpl.setModifiedDate(userCredential.getModifiedDate());
		userCredentialImpl.setMembership1(userCredential.getMembership1());
		userCredentialImpl.setMembership2(userCredential.getMembership2());
		userCredentialImpl.setMembership3(userCredential.getMembership3());
		userCredentialImpl.setMembership4(userCredential.getMembership4());
		userCredentialImpl.setCertificate1(userCredential.getCertificate1());
		userCredentialImpl.setCertificate2(userCredential.getCertificate2());
		userCredentialImpl.setCertificate3(userCredential.getCertificate3());

		return userCredentialImpl;
	}

	/**
	 * Returns the user credential with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user credential
	 * @return the user credential
	 * @throws NoSuchuserCredentialException if a user credential with the primary key could not be found
	 */
	@Override
	public userCredential findByPrimaryKey(Serializable primaryKey)
		throws NoSuchuserCredentialException {
		userCredential userCredential = fetchByPrimaryKey(primaryKey);

		if (userCredential == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchuserCredentialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userCredential;
	}

	/**
	 * Returns the user credential with the primary key or throws a {@link NoSuchuserCredentialException} if it could not be found.
	 *
	 * @param PK_userCredential the primary key of the user credential
	 * @return the user credential
	 * @throws NoSuchuserCredentialException if a user credential with the primary key could not be found
	 */
	@Override
	public userCredential findByPrimaryKey(long PK_userCredential)
		throws NoSuchuserCredentialException {
		return findByPrimaryKey((Serializable)PK_userCredential);
	}

	/**
	 * Returns the user credential with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user credential
	 * @return the user credential, or <code>null</code> if a user credential with the primary key could not be found
	 */
	@Override
	public userCredential fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
				userCredentialImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		userCredential userCredential = (userCredential)serializable;

		if (userCredential == null) {
			Session session = null;

			try {
				session = openSession();

				userCredential = (userCredential)session.get(userCredentialImpl.class,
						primaryKey);

				if (userCredential != null) {
					cacheResult(userCredential);
				}
				else {
					entityCache.putResult(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
						userCredentialImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
					userCredentialImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userCredential;
	}

	/**
	 * Returns the user credential with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_userCredential the primary key of the user credential
	 * @return the user credential, or <code>null</code> if a user credential with the primary key could not be found
	 */
	@Override
	public userCredential fetchByPrimaryKey(long PK_userCredential) {
		return fetchByPrimaryKey((Serializable)PK_userCredential);
	}

	@Override
	public Map<Serializable, userCredential> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, userCredential> map = new HashMap<Serializable, userCredential>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			userCredential userCredential = fetchByPrimaryKey(primaryKey);

			if (userCredential != null) {
				map.put(primaryKey, userCredential);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
					userCredentialImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (userCredential)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERCREDENTIAL_WHERE_PKS_IN);

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

			for (userCredential userCredential : (List<userCredential>)q.list()) {
				map.put(userCredential.getPrimaryKeyObj(), userCredential);

				cacheResult(userCredential);

				uncachedPrimaryKeys.remove(userCredential.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(userCredentialModelImpl.ENTITY_CACHE_ENABLED,
					userCredentialImpl.class, primaryKey, nullModel);
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
	 * Returns all the user credentials.
	 *
	 * @return the user credentials
	 */
	@Override
	public List<userCredential> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user credentials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user credentials
	 * @param end the upper bound of the range of user credentials (not inclusive)
	 * @return the range of user credentials
	 */
	@Override
	public List<userCredential> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user credentials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user credentials
	 * @param end the upper bound of the range of user credentials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user credentials
	 */
	@Override
	public List<userCredential> findAll(int start, int end,
		OrderByComparator<userCredential> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user credentials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userCredentialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user credentials
	 * @param end the upper bound of the range of user credentials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user credentials
	 */
	@Override
	public List<userCredential> findAll(int start, int end,
		OrderByComparator<userCredential> orderByComparator,
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

		List<userCredential> list = null;

		if (retrieveFromCache) {
			list = (List<userCredential>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERCREDENTIAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERCREDENTIAL;

				if (pagination) {
					sql = sql.concat(userCredentialModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<userCredential>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<userCredential>)QueryUtil.list(q,
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
	 * Removes all the user credentials from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (userCredential userCredential : findAll()) {
			remove(userCredential);
		}
	}

	/**
	 * Returns the number of user credentials.
	 *
	 * @return the number of user credentials
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERCREDENTIAL);

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
		return userCredentialModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user credential persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(userCredentialImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERCREDENTIAL = "SELECT userCredential FROM userCredential userCredential";
	private static final String _SQL_SELECT_USERCREDENTIAL_WHERE_PKS_IN = "SELECT userCredential FROM userCredential userCredential WHERE PK_userCredential IN (";
	private static final String _SQL_COUNT_USERCREDENTIAL = "SELECT COUNT(userCredential) FROM userCredential userCredential";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userCredential.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No userCredential exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(userCredentialPersistenceImpl.class);
}