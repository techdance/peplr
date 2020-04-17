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

import com.collaborated.entity.exception.NoSuchuserInstitutionProfileDetailsException;
import com.collaborated.entity.model.impl.userInstitutionProfileDetailsImpl;
import com.collaborated.entity.model.impl.userInstitutionProfileDetailsModelImpl;
import com.collaborated.entity.model.userInstitutionProfileDetails;
import com.collaborated.entity.service.persistence.userInstitutionProfileDetailsPersistence;

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
 * The persistence implementation for the user institution profile details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userInstitutionProfileDetailsPersistence
 * @see com.collaborated.entity.service.persistence.userInstitutionProfileDetailsUtil
 * @generated
 */
@ProviderType
public class userInstitutionProfileDetailsPersistenceImpl
	extends BasePersistenceImpl<userInstitutionProfileDetails>
	implements userInstitutionProfileDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link userInstitutionProfileDetailsUtil} to access the user institution profile details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = userInstitutionProfileDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileDetailsModelImpl.FINDER_CACHE_ENABLED,
			userInstitutionProfileDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileDetailsModelImpl.FINDER_CACHE_ENABLED,
			userInstitutionProfileDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileDetailsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public userInstitutionProfileDetailsPersistenceImpl() {
		setModelClass(userInstitutionProfileDetails.class);
	}

	/**
	 * Caches the user institution profile details in the entity cache if it is enabled.
	 *
	 * @param userInstitutionProfileDetails the user institution profile details
	 */
	@Override
	public void cacheResult(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		entityCache.putResult(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileDetailsImpl.class,
			userInstitutionProfileDetails.getPrimaryKey(),
			userInstitutionProfileDetails);

		userInstitutionProfileDetails.resetOriginalValues();
	}

	/**
	 * Caches the user institution profile detailses in the entity cache if it is enabled.
	 *
	 * @param userInstitutionProfileDetailses the user institution profile detailses
	 */
	@Override
	public void cacheResult(
		List<userInstitutionProfileDetails> userInstitutionProfileDetailses) {
		for (userInstitutionProfileDetails userInstitutionProfileDetails : userInstitutionProfileDetailses) {
			if (entityCache.getResult(
						userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
						userInstitutionProfileDetailsImpl.class,
						userInstitutionProfileDetails.getPrimaryKey()) == null) {
				cacheResult(userInstitutionProfileDetails);
			}
			else {
				userInstitutionProfileDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user institution profile detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(userInstitutionProfileDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user institution profile details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		entityCache.removeResult(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileDetailsImpl.class,
			userInstitutionProfileDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<userInstitutionProfileDetails> userInstitutionProfileDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (userInstitutionProfileDetails userInstitutionProfileDetails : userInstitutionProfileDetailses) {
			entityCache.removeResult(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
				userInstitutionProfileDetailsImpl.class,
				userInstitutionProfileDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user institution profile details with the primary key. Does not add the user institution profile details to the database.
	 *
	 * @param PK_userInstition the primary key for the new user institution profile details
	 * @return the new user institution profile details
	 */
	@Override
	public userInstitutionProfileDetails create(long PK_userInstition) {
		userInstitutionProfileDetails userInstitutionProfileDetails = new userInstitutionProfileDetailsImpl();

		userInstitutionProfileDetails.setNew(true);
		userInstitutionProfileDetails.setPrimaryKey(PK_userInstition);

		return userInstitutionProfileDetails;
	}

	/**
	 * Removes the user institution profile details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_userInstition the primary key of the user institution profile details
	 * @return the user institution profile details that was removed
	 * @throws NoSuchuserInstitutionProfileDetailsException if a user institution profile details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileDetails remove(long PK_userInstition)
		throws NoSuchuserInstitutionProfileDetailsException {
		return remove((Serializable)PK_userInstition);
	}

	/**
	 * Removes the user institution profile details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user institution profile details
	 * @return the user institution profile details that was removed
	 * @throws NoSuchuserInstitutionProfileDetailsException if a user institution profile details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileDetails remove(Serializable primaryKey)
		throws NoSuchuserInstitutionProfileDetailsException {
		Session session = null;

		try {
			session = openSession();

			userInstitutionProfileDetails userInstitutionProfileDetails = (userInstitutionProfileDetails)session.get(userInstitutionProfileDetailsImpl.class,
					primaryKey);

			if (userInstitutionProfileDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchuserInstitutionProfileDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userInstitutionProfileDetails);
		}
		catch (NoSuchuserInstitutionProfileDetailsException nsee) {
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
	protected userInstitutionProfileDetails removeImpl(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		userInstitutionProfileDetails = toUnwrappedModel(userInstitutionProfileDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userInstitutionProfileDetails)) {
				userInstitutionProfileDetails = (userInstitutionProfileDetails)session.get(userInstitutionProfileDetailsImpl.class,
						userInstitutionProfileDetails.getPrimaryKeyObj());
			}

			if (userInstitutionProfileDetails != null) {
				session.delete(userInstitutionProfileDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userInstitutionProfileDetails != null) {
			clearCache(userInstitutionProfileDetails);
		}

		return userInstitutionProfileDetails;
	}

	@Override
	public userInstitutionProfileDetails updateImpl(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		userInstitutionProfileDetails = toUnwrappedModel(userInstitutionProfileDetails);

		boolean isNew = userInstitutionProfileDetails.isNew();

		userInstitutionProfileDetailsModelImpl userInstitutionProfileDetailsModelImpl =
			(userInstitutionProfileDetailsModelImpl)userInstitutionProfileDetails;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userInstitutionProfileDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				userInstitutionProfileDetails.setCreateDate(now);
			}
			else {
				userInstitutionProfileDetails.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!userInstitutionProfileDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userInstitutionProfileDetails.setModifiedDate(now);
			}
			else {
				userInstitutionProfileDetails.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userInstitutionProfileDetails.isNew()) {
				session.save(userInstitutionProfileDetails);

				userInstitutionProfileDetails.setNew(false);
			}
			else {
				userInstitutionProfileDetails = (userInstitutionProfileDetails)session.merge(userInstitutionProfileDetails);
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

		entityCache.putResult(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
			userInstitutionProfileDetailsImpl.class,
			userInstitutionProfileDetails.getPrimaryKey(),
			userInstitutionProfileDetails, false);

		userInstitutionProfileDetails.resetOriginalValues();

		return userInstitutionProfileDetails;
	}

	protected userInstitutionProfileDetails toUnwrappedModel(
		userInstitutionProfileDetails userInstitutionProfileDetails) {
		if (userInstitutionProfileDetails instanceof userInstitutionProfileDetailsImpl) {
			return userInstitutionProfileDetails;
		}

		userInstitutionProfileDetailsImpl userInstitutionProfileDetailsImpl = new userInstitutionProfileDetailsImpl();

		userInstitutionProfileDetailsImpl.setNew(userInstitutionProfileDetails.isNew());
		userInstitutionProfileDetailsImpl.setPrimaryKey(userInstitutionProfileDetails.getPrimaryKey());

		userInstitutionProfileDetailsImpl.setPK_userInstition(userInstitutionProfileDetails.getPK_userInstition());
		userInstitutionProfileDetailsImpl.setGroupId(userInstitutionProfileDetails.getGroupId());
		userInstitutionProfileDetailsImpl.setUserId(userInstitutionProfileDetails.getUserId());
		userInstitutionProfileDetailsImpl.setCreateDate(userInstitutionProfileDetails.getCreateDate());
		userInstitutionProfileDetailsImpl.setModifiedDate(userInstitutionProfileDetails.getModifiedDate());
		userInstitutionProfileDetailsImpl.setInstitutionName(userInstitutionProfileDetails.getInstitutionName());
		userInstitutionProfileDetailsImpl.setAcadeCalendar(userInstitutionProfileDetails.getAcadeCalendar());
		userInstitutionProfileDetailsImpl.setDepartmentdescription(userInstitutionProfileDetails.getDepartmentdescription());

		return userInstitutionProfileDetailsImpl;
	}

	/**
	 * Returns the user institution profile details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user institution profile details
	 * @return the user institution profile details
	 * @throws NoSuchuserInstitutionProfileDetailsException if a user institution profile details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileDetails findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchuserInstitutionProfileDetailsException {
		userInstitutionProfileDetails userInstitutionProfileDetails = fetchByPrimaryKey(primaryKey);

		if (userInstitutionProfileDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchuserInstitutionProfileDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userInstitutionProfileDetails;
	}

	/**
	 * Returns the user institution profile details with the primary key or throws a {@link NoSuchuserInstitutionProfileDetailsException} if it could not be found.
	 *
	 * @param PK_userInstition the primary key of the user institution profile details
	 * @return the user institution profile details
	 * @throws NoSuchuserInstitutionProfileDetailsException if a user institution profile details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileDetails findByPrimaryKey(long PK_userInstition)
		throws NoSuchuserInstitutionProfileDetailsException {
		return findByPrimaryKey((Serializable)PK_userInstition);
	}

	/**
	 * Returns the user institution profile details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user institution profile details
	 * @return the user institution profile details, or <code>null</code> if a user institution profile details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileDetails fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
				userInstitutionProfileDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		userInstitutionProfileDetails userInstitutionProfileDetails = (userInstitutionProfileDetails)serializable;

		if (userInstitutionProfileDetails == null) {
			Session session = null;

			try {
				session = openSession();

				userInstitutionProfileDetails = (userInstitutionProfileDetails)session.get(userInstitutionProfileDetailsImpl.class,
						primaryKey);

				if (userInstitutionProfileDetails != null) {
					cacheResult(userInstitutionProfileDetails);
				}
				else {
					entityCache.putResult(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
						userInstitutionProfileDetailsImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
					userInstitutionProfileDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userInstitutionProfileDetails;
	}

	/**
	 * Returns the user institution profile details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_userInstition the primary key of the user institution profile details
	 * @return the user institution profile details, or <code>null</code> if a user institution profile details with the primary key could not be found
	 */
	@Override
	public userInstitutionProfileDetails fetchByPrimaryKey(
		long PK_userInstition) {
		return fetchByPrimaryKey((Serializable)PK_userInstition);
	}

	@Override
	public Map<Serializable, userInstitutionProfileDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, userInstitutionProfileDetails> map = new HashMap<Serializable, userInstitutionProfileDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			userInstitutionProfileDetails userInstitutionProfileDetails = fetchByPrimaryKey(primaryKey);

			if (userInstitutionProfileDetails != null) {
				map.put(primaryKey, userInstitutionProfileDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
					userInstitutionProfileDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(userInstitutionProfileDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERINSTITUTIONPROFILEDETAILS_WHERE_PKS_IN);

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

			for (userInstitutionProfileDetails userInstitutionProfileDetails : (List<userInstitutionProfileDetails>)q.list()) {
				map.put(userInstitutionProfileDetails.getPrimaryKeyObj(),
					userInstitutionProfileDetails);

				cacheResult(userInstitutionProfileDetails);

				uncachedPrimaryKeys.remove(userInstitutionProfileDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(userInstitutionProfileDetailsModelImpl.ENTITY_CACHE_ENABLED,
					userInstitutionProfileDetailsImpl.class, primaryKey,
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
	 * Returns all the user institution profile detailses.
	 *
	 * @return the user institution profile detailses
	 */
	@Override
	public List<userInstitutionProfileDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user institution profile detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user institution profile detailses
	 * @param end the upper bound of the range of user institution profile detailses (not inclusive)
	 * @return the range of user institution profile detailses
	 */
	@Override
	public List<userInstitutionProfileDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user institution profile detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user institution profile detailses
	 * @param end the upper bound of the range of user institution profile detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user institution profile detailses
	 */
	@Override
	public List<userInstitutionProfileDetails> findAll(int start, int end,
		OrderByComparator<userInstitutionProfileDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user institution profile detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userInstitutionProfileDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user institution profile detailses
	 * @param end the upper bound of the range of user institution profile detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user institution profile detailses
	 */
	@Override
	public List<userInstitutionProfileDetails> findAll(int start, int end,
		OrderByComparator<userInstitutionProfileDetails> orderByComparator,
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

		List<userInstitutionProfileDetails> list = null;

		if (retrieveFromCache) {
			list = (List<userInstitutionProfileDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERINSTITUTIONPROFILEDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERINSTITUTIONPROFILEDETAILS;

				if (pagination) {
					sql = sql.concat(userInstitutionProfileDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<userInstitutionProfileDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<userInstitutionProfileDetails>)QueryUtil.list(q,
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
	 * Removes all the user institution profile detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (userInstitutionProfileDetails userInstitutionProfileDetails : findAll()) {
			remove(userInstitutionProfileDetails);
		}
	}

	/**
	 * Returns the number of user institution profile detailses.
	 *
	 * @return the number of user institution profile detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERINSTITUTIONPROFILEDETAILS);

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
		return userInstitutionProfileDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user institution profile details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(userInstitutionProfileDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERINSTITUTIONPROFILEDETAILS = "SELECT userInstitutionProfileDetails FROM userInstitutionProfileDetails userInstitutionProfileDetails";
	private static final String _SQL_SELECT_USERINSTITUTIONPROFILEDETAILS_WHERE_PKS_IN =
		"SELECT userInstitutionProfileDetails FROM userInstitutionProfileDetails userInstitutionProfileDetails WHERE PK_userInstition IN (";
	private static final String _SQL_COUNT_USERINSTITUTIONPROFILEDETAILS = "SELECT COUNT(userInstitutionProfileDetails) FROM userInstitutionProfileDetails userInstitutionProfileDetails";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userInstitutionProfileDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No userInstitutionProfileDetails exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(userInstitutionProfileDetailsPersistenceImpl.class);
}