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

import com.collaborated.entity.exception.NoSuchuserInstitutionProfileSubDetailsException;
import com.collaborated.entity.model.impl.userInstitutionProfileSubDetailsImpl;
import com.collaborated.entity.model.impl.userInstitutionProfileSubDetailsModelImpl;
import com.collaborated.entity.model.userInstitutionProfileSubDetails;
import com.collaborated.entity.service.persistence.userInstitutionProfileSubDetailsPersistence;

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
 * The persistence implementation for the user institution profile sub details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileSubDetailsPersistence
 * @see com.collaborated.entity.service.persistence.userInstitutionProfileSubDetailsUtil
 * @generated
 */
@ProviderType
public class userInstitutionProfileSubDetailsPersistenceImpl
	extends BasePersistenceImpl<userInstitutionProfileSubDetails>
	implements userInstitutionProfileSubDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link userInstitutionProfileSubDetailsUtil} to access the user institution profile sub details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = userInstitutionProfileSubDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileSubDetailsModelImpl.FINDER_CACHE_ENABLED,
			userInstitutionProfileSubDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileSubDetailsModelImpl.FINDER_CACHE_ENABLED,
			userInstitutionProfileSubDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileSubDetailsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public userInstitutionProfileSubDetailsPersistenceImpl() {
		setModelClass(userInstitutionProfileSubDetails.class);
	}

	/**
	 * Caches the user institution profile sub details in the entity cache if it is enabled.
	 *
	 * @param userInstitutionProfileSubDetails the user institution profile sub details
	 */
	@Override
	public void cacheResult(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		entityCache.putResult(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileSubDetailsImpl.class,
			userInstitutionProfileSubDetails.getPrimaryKey(),
			userInstitutionProfileSubDetails);

		userInstitutionProfileSubDetails.resetOriginalValues();
	}

	/**
	 * Caches the user institution profile sub detailses in the entity cache if it is enabled.
	 *
	 * @param userInstitutionProfileSubDetailses the user institution profile sub detailses
	 */
	@Override
	public void cacheResult(
		List<userInstitutionProfileSubDetails> userInstitutionProfileSubDetailses) {
		for (userInstitutionProfileSubDetails userInstitutionProfileSubDetails : userInstitutionProfileSubDetailses) {
			if (entityCache.getResult(
						userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
						userInstitutionProfileSubDetailsImpl.class,
						userInstitutionProfileSubDetails.getPrimaryKey()) == null) {
				cacheResult(userInstitutionProfileSubDetails);
			}
			else {
				userInstitutionProfileSubDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user institution profile sub detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(userInstitutionProfileSubDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user institution profile sub details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		entityCache.removeResult(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileSubDetailsImpl.class,
			userInstitutionProfileSubDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<userInstitutionProfileSubDetails> userInstitutionProfileSubDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (userInstitutionProfileSubDetails userInstitutionProfileSubDetails : userInstitutionProfileSubDetailses) {
			entityCache.removeResult(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
				userInstitutionProfileSubDetailsImpl.class,
				userInstitutionProfileSubDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user institution profile sub details with the primary key. Does not add the user institution profile sub details to the database.
	 *
	 * @param PK_userInstitionSub the primary key for the new user institution profile sub details
	 * @return the new user institution profile sub details
	 */
	@Override
	public userInstitutionProfileSubDetails create(long PK_userInstitionSub) {
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails = new userInstitutionProfileSubDetailsImpl();

		userInstitutionProfileSubDetails.setNew(true);
		userInstitutionProfileSubDetails.setPrimaryKey(PK_userInstitionSub);

		return userInstitutionProfileSubDetails;
	}

	/**
	 * Removes the user institution profile sub details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_userInstitionSub the primary key of the user institution profile sub details
	 * @return the user institution profile sub details that was removed
	 * @throws NoSuchuserInstitutionProfileSubDetailsException if a user institution profile sub details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileSubDetails remove(long PK_userInstitionSub)
		throws NoSuchuserInstitutionProfileSubDetailsException {
		return remove((Serializable)PK_userInstitionSub);
	}

	/**
	 * Removes the user institution profile sub details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user institution profile sub details
	 * @return the user institution profile sub details that was removed
	 * @throws NoSuchuserInstitutionProfileSubDetailsException if a user institution profile sub details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileSubDetails remove(Serializable primaryKey)
		throws NoSuchuserInstitutionProfileSubDetailsException {
		Session session = null;

		try {
			session = openSession();

			userInstitutionProfileSubDetails userInstitutionProfileSubDetails = (userInstitutionProfileSubDetails)session.get(userInstitutionProfileSubDetailsImpl.class,
					primaryKey);

			if (userInstitutionProfileSubDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchuserInstitutionProfileSubDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userInstitutionProfileSubDetails);
		}
		catch (NoSuchuserInstitutionProfileSubDetailsException nsee) {
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
	protected userInstitutionProfileSubDetails removeImpl(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		userInstitutionProfileSubDetails = toUnwrappedModel(userInstitutionProfileSubDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userInstitutionProfileSubDetails)) {
				userInstitutionProfileSubDetails = (userInstitutionProfileSubDetails)session.get(userInstitutionProfileSubDetailsImpl.class,
						userInstitutionProfileSubDetails.getPrimaryKeyObj());
			}

			if (userInstitutionProfileSubDetails != null) {
				session.delete(userInstitutionProfileSubDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userInstitutionProfileSubDetails != null) {
			clearCache(userInstitutionProfileSubDetails);
		}

		return userInstitutionProfileSubDetails;
	}

	@Override
	public userInstitutionProfileSubDetails updateImpl(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		userInstitutionProfileSubDetails = toUnwrappedModel(userInstitutionProfileSubDetails);

		boolean isNew = userInstitutionProfileSubDetails.isNew();

		userInstitutionProfileSubDetailsModelImpl userInstitutionProfileSubDetailsModelImpl =
			(userInstitutionProfileSubDetailsModelImpl)userInstitutionProfileSubDetails;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew &&
				(userInstitutionProfileSubDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				userInstitutionProfileSubDetails.setCreateDate(now);
			}
			else {
				userInstitutionProfileSubDetails.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!userInstitutionProfileSubDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userInstitutionProfileSubDetails.setModifiedDate(now);
			}
			else {
				userInstitutionProfileSubDetails.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userInstitutionProfileSubDetails.isNew()) {
				session.save(userInstitutionProfileSubDetails);

				userInstitutionProfileSubDetails.setNew(false);
			}
			else {
				userInstitutionProfileSubDetails = (userInstitutionProfileSubDetails)session.merge(userInstitutionProfileSubDetails);
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

		entityCache.putResult(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileSubDetailsImpl.class,
			userInstitutionProfileSubDetails.getPrimaryKey(),
			userInstitutionProfileSubDetails, false);

		userInstitutionProfileSubDetails.resetOriginalValues();

		return userInstitutionProfileSubDetails;
	}

	protected userInstitutionProfileSubDetails toUnwrappedModel(
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails) {
		if (userInstitutionProfileSubDetails instanceof userInstitutionProfileSubDetailsImpl) {
			return userInstitutionProfileSubDetails;
		}

		userInstitutionProfileSubDetailsImpl userInstitutionProfileSubDetailsImpl =
			new userInstitutionProfileSubDetailsImpl();

		userInstitutionProfileSubDetailsImpl.setNew(userInstitutionProfileSubDetails.isNew());
		userInstitutionProfileSubDetailsImpl.setPrimaryKey(userInstitutionProfileSubDetails.getPrimaryKey());

		userInstitutionProfileSubDetailsImpl.setPK_userInstitionSub(userInstitutionProfileSubDetails.getPK_userInstitionSub());
		userInstitutionProfileSubDetailsImpl.setGroupId(userInstitutionProfileSubDetails.getGroupId());
		userInstitutionProfileSubDetailsImpl.setUserId(userInstitutionProfileSubDetails.getUserId());
		userInstitutionProfileSubDetailsImpl.setCreateDate(userInstitutionProfileSubDetails.getCreateDate());
		userInstitutionProfileSubDetailsImpl.setModifiedDate(userInstitutionProfileSubDetails.getModifiedDate());
		userInstitutionProfileSubDetailsImpl.setFileId(userInstitutionProfileSubDetails.getFileId());
		userInstitutionProfileSubDetailsImpl.setPK_userInstition(userInstitutionProfileSubDetails.getPK_userInstition());

		return userInstitutionProfileSubDetailsImpl;
	}

	/**
	 * Returns the user institution profile sub details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user institution profile sub details
	 * @return the user institution profile sub details
	 * @throws NoSuchuserInstitutionProfileSubDetailsException if a user institution profile sub details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileSubDetails findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchuserInstitutionProfileSubDetailsException {
		userInstitutionProfileSubDetails userInstitutionProfileSubDetails = fetchByPrimaryKey(primaryKey);

		if (userInstitutionProfileSubDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchuserInstitutionProfileSubDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userInstitutionProfileSubDetails;
	}

	/**
	 * Returns the user institution profile sub details with the primary key or throws a {@link NoSuchuserInstitutionProfileSubDetailsException} if it could not be found.
	 *
	 * @param PK_userInstitionSub the primary key of the user institution profile sub details
	 * @return the user institution profile sub details
	 * @throws NoSuchuserInstitutionProfileSubDetailsException if a user institution profile sub details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileSubDetails findByPrimaryKey(
		long PK_userInstitionSub)
		throws NoSuchuserInstitutionProfileSubDetailsException {
		return findByPrimaryKey((Serializable)PK_userInstitionSub);
	}

	/**
	 * Returns the user institution profile sub details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user institution profile sub details
	 * @return the user institution profile sub details, or <code>null</code> if a user institution profile sub details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileSubDetails fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
				userInstitutionProfileSubDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		userInstitutionProfileSubDetails userInstitutionProfileSubDetails = (userInstitutionProfileSubDetails)serializable;

		if (userInstitutionProfileSubDetails == null) {
			Session session = null;

			try {
				session = openSession();

				userInstitutionProfileSubDetails = (userInstitutionProfileSubDetails)session.get(userInstitutionProfileSubDetailsImpl.class,
						primaryKey);

				if (userInstitutionProfileSubDetails != null) {
					cacheResult(userInstitutionProfileSubDetails);
				}
				else {
					entityCache.putResult(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
						userInstitutionProfileSubDetailsImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
					userInstitutionProfileSubDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userInstitutionProfileSubDetails;
	}

	/**
	 * Returns the user institution profile sub details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_userInstitionSub the primary key of the user institution profile sub details
	 * @return the user institution profile sub details, or <code>null</code> if a user institution profile sub details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileSubDetails fetchByPrimaryKey(
		long PK_userInstitionSub) {
		return fetchByPrimaryKey((Serializable)PK_userInstitionSub);
	}

	@Override
	public Map<Serializable, userInstitutionProfileSubDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, userInstitutionProfileSubDetails> map = new HashMap<Serializable, userInstitutionProfileSubDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			userInstitutionProfileSubDetails userInstitutionProfileSubDetails = fetchByPrimaryKey(primaryKey);

			if (userInstitutionProfileSubDetails != null) {
				map.put(primaryKey, userInstitutionProfileSubDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
					userInstitutionProfileSubDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(userInstitutionProfileSubDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERINSTITUTIONPROFILESUBDETAILS_WHERE_PKS_IN);

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

			for (userInstitutionProfileSubDetails userInstitutionProfileSubDetails : (List<userInstitutionProfileSubDetails>)q.list()) {
				map.put(userInstitutionProfileSubDetails.getPrimaryKeyObj(),
					userInstitutionProfileSubDetails);

				cacheResult(userInstitutionProfileSubDetails);

				uncachedPrimaryKeys.remove(userInstitutionProfileSubDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(userInstitutionProfileSubDetailsModelImpl.ENTITY_CACHE_ENABLED,
					userInstitutionProfileSubDetailsImpl.class, primaryKey,
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
	 * Returns all the user institution profile sub detailses.
	 *
	 * @return the user institution profile sub detailses
	 */
	@Override
	public List<userInstitutionProfileSubDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user institution profile sub detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileSubDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user institution profile sub detailses
	 * @param end the upper bound of the range of user institution profile sub detailses (not inclusive)
	 * @return the range of user institution profile sub detailses
	 */
	@Override
	public List<userInstitutionProfileSubDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user institution profile sub detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileSubDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user institution profile sub detailses
	 * @param end the upper bound of the range of user institution profile sub detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user institution profile sub detailses
	 */
	@Override
	public List<userInstitutionProfileSubDetails> findAll(int start, int end,
		OrderByComparator<userInstitutionProfileSubDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user institution profile sub detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileSubDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user institution profile sub detailses
	 * @param end the upper bound of the range of user institution profile sub detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user institution profile sub detailses
	 */
	@Override
	public List<userInstitutionProfileSubDetails> findAll(int start, int end,
		OrderByComparator<userInstitutionProfileSubDetails> orderByComparator,
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

		List<userInstitutionProfileSubDetails> list = null;

		if (retrieveFromCache) {
			list = (List<userInstitutionProfileSubDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERINSTITUTIONPROFILESUBDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERINSTITUTIONPROFILESUBDETAILS;

				if (pagination) {
					sql = sql.concat(userInstitutionProfileSubDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<userInstitutionProfileSubDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<userInstitutionProfileSubDetails>)QueryUtil.list(q,
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
	 * Removes all the user institution profile sub detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (userInstitutionProfileSubDetails userInstitutionProfileSubDetails : findAll()) {
			remove(userInstitutionProfileSubDetails);
		}
	}

	/**
	 * Returns the number of user institution profile sub detailses.
	 *
	 * @return the number of user institution profile sub detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERINSTITUTIONPROFILESUBDETAILS);

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
		return userInstitutionProfileSubDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user institution profile sub details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(userInstitutionProfileSubDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERINSTITUTIONPROFILESUBDETAILS = "SELECT userInstitutionProfileSubDetails FROM userInstitutionProfileSubDetails userInstitutionProfileSubDetails";
	private static final String _SQL_SELECT_USERINSTITUTIONPROFILESUBDETAILS_WHERE_PKS_IN =
		"SELECT userInstitutionProfileSubDetails FROM userInstitutionProfileSubDetails userInstitutionProfileSubDetails WHERE PK_userInstitionSub IN (";
	private static final String _SQL_COUNT_USERINSTITUTIONPROFILESUBDETAILS = "SELECT COUNT(userInstitutionProfileSubDetails) FROM userInstitutionProfileSubDetails userInstitutionProfileSubDetails";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userInstitutionProfileSubDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No userInstitutionProfileSubDetails exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(userInstitutionProfileSubDetailsPersistenceImpl.class);
}