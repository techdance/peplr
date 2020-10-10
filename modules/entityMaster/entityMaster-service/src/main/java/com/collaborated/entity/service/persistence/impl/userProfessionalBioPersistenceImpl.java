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

import com.collaborated.entity.exception.NoSuchuserProfessionalBioException;
import com.collaborated.entity.model.impl.userProfessionalBioImpl;
import com.collaborated.entity.model.impl.userProfessionalBioModelImpl;
import com.collaborated.entity.model.userProfessionalBio;
import com.collaborated.entity.service.persistence.userProfessionalBioPersistence;

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
 * The persistence implementation for the user professional bio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userProfessionalBioPersistence
 * @see com.collaborated.entity.service.persistence.userProfessionalBioUtil
 * @generated
 */
@ProviderType
public class userProfessionalBioPersistenceImpl extends BasePersistenceImpl<userProfessionalBio>
	implements userProfessionalBioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link userProfessionalBioUtil} to access the user professional bio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = userProfessionalBioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
			userProfessionalBioModelImpl.FINDER_CACHE_ENABLED,
			userProfessionalBioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
			userProfessionalBioModelImpl.FINDER_CACHE_ENABLED,
			userProfessionalBioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
			userProfessionalBioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public userProfessionalBioPersistenceImpl() {
		setModelClass(userProfessionalBio.class);
	}

	/**
	 * Caches the user professional bio in the entity cache if it is enabled.
	 *
	 * @param userProfessionalBio the user professional bio
	 */
	@Override
	public void cacheResult(userProfessionalBio userProfessionalBio) {
		entityCache.putResult(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
			userProfessionalBioImpl.class, userProfessionalBio.getPrimaryKey(),
			userProfessionalBio);

		userProfessionalBio.resetOriginalValues();
	}

	/**
	 * Caches the user professional bios in the entity cache if it is enabled.
	 *
	 * @param userProfessionalBios the user professional bios
	 */
	@Override
	public void cacheResult(List<userProfessionalBio> userProfessionalBios) {
		for (userProfessionalBio userProfessionalBio : userProfessionalBios) {
			if (entityCache.getResult(
						userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
						userProfessionalBioImpl.class,
						userProfessionalBio.getPrimaryKey()) == null) {
				cacheResult(userProfessionalBio);
			}
			else {
				userProfessionalBio.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user professional bios.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(userProfessionalBioImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user professional bio.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(userProfessionalBio userProfessionalBio) {
		entityCache.removeResult(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
			userProfessionalBioImpl.class, userProfessionalBio.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<userProfessionalBio> userProfessionalBios) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (userProfessionalBio userProfessionalBio : userProfessionalBios) {
			entityCache.removeResult(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
				userProfessionalBioImpl.class,
				userProfessionalBio.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user professional bio with the primary key. Does not add the user professional bio to the database.
	 *
	 * @param PK_userProfessionalBio the primary key for the new user professional bio
	 * @return the new user professional bio
	 */
	@Override
	public userProfessionalBio create(long PK_userProfessionalBio) {
		userProfessionalBio userProfessionalBio = new userProfessionalBioImpl();

		userProfessionalBio.setNew(true);
		userProfessionalBio.setPrimaryKey(PK_userProfessionalBio);

		return userProfessionalBio;
	}

	/**
	 * Removes the user professional bio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_userProfessionalBio the primary key of the user professional bio
	 * @return the user professional bio that was removed
	 * @throws NoSuchuserProfessionalBioException if a user professional bio with the primary key could not be found
	 */
	@Override
	public userProfessionalBio remove(long PK_userProfessionalBio)
		throws NoSuchuserProfessionalBioException {
		return remove((Serializable)PK_userProfessionalBio);
	}

	/**
	 * Removes the user professional bio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user professional bio
	 * @return the user professional bio that was removed
	 * @throws NoSuchuserProfessionalBioException if a user professional bio with the primary key could not be found
	 */
	@Override
	public userProfessionalBio remove(Serializable primaryKey)
		throws NoSuchuserProfessionalBioException {
		Session session = null;

		try {
			session = openSession();

			userProfessionalBio userProfessionalBio = (userProfessionalBio)session.get(userProfessionalBioImpl.class,
					primaryKey);

			if (userProfessionalBio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchuserProfessionalBioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userProfessionalBio);
		}
		catch (NoSuchuserProfessionalBioException nsee) {
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
	protected userProfessionalBio removeImpl(
		userProfessionalBio userProfessionalBio) {
		userProfessionalBio = toUnwrappedModel(userProfessionalBio);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userProfessionalBio)) {
				userProfessionalBio = (userProfessionalBio)session.get(userProfessionalBioImpl.class,
						userProfessionalBio.getPrimaryKeyObj());
			}

			if (userProfessionalBio != null) {
				session.delete(userProfessionalBio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userProfessionalBio != null) {
			clearCache(userProfessionalBio);
		}

		return userProfessionalBio;
	}

	@Override
	public userProfessionalBio updateImpl(
		userProfessionalBio userProfessionalBio) {
		userProfessionalBio = toUnwrappedModel(userProfessionalBio);

		boolean isNew = userProfessionalBio.isNew();

		userProfessionalBioModelImpl userProfessionalBioModelImpl = (userProfessionalBioModelImpl)userProfessionalBio;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userProfessionalBio.getCreateDate() == null)) {
			if (serviceContext == null) {
				userProfessionalBio.setCreateDate(now);
			}
			else {
				userProfessionalBio.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!userProfessionalBioModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userProfessionalBio.setModifiedDate(now);
			}
			else {
				userProfessionalBio.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userProfessionalBio.isNew()) {
				session.save(userProfessionalBio);

				userProfessionalBio.setNew(false);
			}
			else {
				userProfessionalBio = (userProfessionalBio)session.merge(userProfessionalBio);
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

		entityCache.putResult(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
			userProfessionalBioImpl.class, userProfessionalBio.getPrimaryKey(),
			userProfessionalBio, false);

		userProfessionalBio.resetOriginalValues();

		return userProfessionalBio;
	}

	protected userProfessionalBio toUnwrappedModel(
		userProfessionalBio userProfessionalBio) {
		if (userProfessionalBio instanceof userProfessionalBioImpl) {
			return userProfessionalBio;
		}

		userProfessionalBioImpl userProfessionalBioImpl = new userProfessionalBioImpl();

		userProfessionalBioImpl.setNew(userProfessionalBio.isNew());
		userProfessionalBioImpl.setPrimaryKey(userProfessionalBio.getPrimaryKey());

		userProfessionalBioImpl.setPK_userProfessionalBio(userProfessionalBio.getPK_userProfessionalBio());
		userProfessionalBioImpl.setGroupId(userProfessionalBio.getGroupId());
		userProfessionalBioImpl.setUserId(userProfessionalBio.getUserId());
		userProfessionalBioImpl.setCreateDate(userProfessionalBio.getCreateDate());
		userProfessionalBioImpl.setModifiedDate(userProfessionalBio.getModifiedDate());
		userProfessionalBioImpl.setAreaofexpertise1(userProfessionalBio.getAreaofexpertise1());
		userProfessionalBioImpl.setAreaofexpertise2(userProfessionalBio.getAreaofexpertise2());
		userProfessionalBioImpl.setAreaofexpertise3(userProfessionalBio.getAreaofexpertise3());
		userProfessionalBioImpl.setExperienceyears(userProfessionalBio.getExperienceyears());
		userProfessionalBioImpl.setCvlink(userProfessionalBio.getCvlink());
		userProfessionalBioImpl.setBiodescription(userProfessionalBio.getBiodescription());
		userProfessionalBioImpl.setBioDiscipline(userProfessionalBio.getBioDiscipline());

		return userProfessionalBioImpl;
	}

	/**
	 * Returns the user professional bio with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user professional bio
	 * @return the user professional bio
	 * @throws NoSuchuserProfessionalBioException if a user professional bio with the primary key could not be found
	 */
	@Override
	public userProfessionalBio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchuserProfessionalBioException {
		userProfessionalBio userProfessionalBio = fetchByPrimaryKey(primaryKey);

		if (userProfessionalBio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchuserProfessionalBioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userProfessionalBio;
	}

	/**
	 * Returns the user professional bio with the primary key or throws a {@link NoSuchuserProfessionalBioException} if it could not be found.
	 *
	 * @param PK_userProfessionalBio the primary key of the user professional bio
	 * @return the user professional bio
	 * @throws NoSuchuserProfessionalBioException if a user professional bio with the primary key could not be found
	 */
	@Override
	public userProfessionalBio findByPrimaryKey(long PK_userProfessionalBio)
		throws NoSuchuserProfessionalBioException {
		return findByPrimaryKey((Serializable)PK_userProfessionalBio);
	}

	/**
	 * Returns the user professional bio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user professional bio
	 * @return the user professional bio, or <code>null</code> if a user professional bio with the primary key could not be found
	 */
	@Override
	public userProfessionalBio fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
				userProfessionalBioImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		userProfessionalBio userProfessionalBio = (userProfessionalBio)serializable;

		if (userProfessionalBio == null) {
			Session session = null;

			try {
				session = openSession();

				userProfessionalBio = (userProfessionalBio)session.get(userProfessionalBioImpl.class,
						primaryKey);

				if (userProfessionalBio != null) {
					cacheResult(userProfessionalBio);
				}
				else {
					entityCache.putResult(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
						userProfessionalBioImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
					userProfessionalBioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userProfessionalBio;
	}

	/**
	 * Returns the user professional bio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_userProfessionalBio the primary key of the user professional bio
	 * @return the user professional bio, or <code>null</code> if a user professional bio with the primary key could not be found
	 */
	@Override
	public userProfessionalBio fetchByPrimaryKey(long PK_userProfessionalBio) {
		return fetchByPrimaryKey((Serializable)PK_userProfessionalBio);
	}

	@Override
	public Map<Serializable, userProfessionalBio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, userProfessionalBio> map = new HashMap<Serializable, userProfessionalBio>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			userProfessionalBio userProfessionalBio = fetchByPrimaryKey(primaryKey);

			if (userProfessionalBio != null) {
				map.put(primaryKey, userProfessionalBio);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
					userProfessionalBioImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (userProfessionalBio)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERPROFESSIONALBIO_WHERE_PKS_IN);

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

			for (userProfessionalBio userProfessionalBio : (List<userProfessionalBio>)q.list()) {
				map.put(userProfessionalBio.getPrimaryKeyObj(),
					userProfessionalBio);

				cacheResult(userProfessionalBio);

				uncachedPrimaryKeys.remove(userProfessionalBio.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(userProfessionalBioModelImpl.ENTITY_CACHE_ENABLED,
					userProfessionalBioImpl.class, primaryKey, nullModel);
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
	 * Returns all the user professional bios.
	 *
	 * @return the user professional bios
	 */
	@Override
	public List<userProfessionalBio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user professional bios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user professional bios
	 * @param end the upper bound of the range of user professional bios (not inclusive)
	 * @return the range of user professional bios
	 */
	@Override
	public List<userProfessionalBio> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user professional bios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user professional bios
	 * @param end the upper bound of the range of user professional bios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user professional bios
	 */
	@Override
	public List<userProfessionalBio> findAll(int start, int end,
		OrderByComparator<userProfessionalBio> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user professional bios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfessionalBioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user professional bios
	 * @param end the upper bound of the range of user professional bios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user professional bios
	 */
	@Override
	public List<userProfessionalBio> findAll(int start, int end,
		OrderByComparator<userProfessionalBio> orderByComparator,
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

		List<userProfessionalBio> list = null;

		if (retrieveFromCache) {
			list = (List<userProfessionalBio>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERPROFESSIONALBIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERPROFESSIONALBIO;

				if (pagination) {
					sql = sql.concat(userProfessionalBioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<userProfessionalBio>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<userProfessionalBio>)QueryUtil.list(q,
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
	 * Removes all the user professional bios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (userProfessionalBio userProfessionalBio : findAll()) {
			remove(userProfessionalBio);
		}
	}

	/**
	 * Returns the number of user professional bios.
	 *
	 * @return the number of user professional bios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERPROFESSIONALBIO);

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
		return userProfessionalBioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user professional bio persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(userProfessionalBioImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERPROFESSIONALBIO = "SELECT userProfessionalBio FROM userProfessionalBio userProfessionalBio";
	private static final String _SQL_SELECT_USERPROFESSIONALBIO_WHERE_PKS_IN = "SELECT userProfessionalBio FROM userProfessionalBio userProfessionalBio WHERE PK_userProfessionalBio IN (";
	private static final String _SQL_COUNT_USERPROFESSIONALBIO = "SELECT COUNT(userProfessionalBio) FROM userProfessionalBio userProfessionalBio";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userProfessionalBio.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No userProfessionalBio exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(userProfessionalBioPersistenceImpl.class);
}