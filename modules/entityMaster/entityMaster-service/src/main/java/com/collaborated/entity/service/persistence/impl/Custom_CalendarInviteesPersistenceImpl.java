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

import com.collaborated.entity.exception.NoSuchCustom_CalendarInviteesException;
import com.collaborated.entity.model.Custom_CalendarInvitees;
import com.collaborated.entity.model.impl.Custom_CalendarInviteesImpl;
import com.collaborated.entity.model.impl.Custom_CalendarInviteesModelImpl;
import com.collaborated.entity.service.persistence.Custom_CalendarInviteesPersistence;

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
 * The persistence implementation for the custom_ calendar invitees service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarInviteesPersistence
 * @see com.collaborated.entity.service.persistence.Custom_CalendarInviteesUtil
 * @generated
 */
@ProviderType
public class Custom_CalendarInviteesPersistenceImpl extends BasePersistenceImpl<Custom_CalendarInvitees>
	implements Custom_CalendarInviteesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Custom_CalendarInviteesUtil} to access the custom_ calendar invitees persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Custom_CalendarInviteesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarInviteesModelImpl.FINDER_CACHE_ENABLED,
			Custom_CalendarInviteesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarInviteesModelImpl.FINDER_CACHE_ENABLED,
			Custom_CalendarInviteesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarInviteesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Custom_CalendarInviteesPersistenceImpl() {
		setModelClass(Custom_CalendarInvitees.class);
	}

	/**
	 * Caches the custom_ calendar invitees in the entity cache if it is enabled.
	 *
	 * @param custom_CalendarInvitees the custom_ calendar invitees
	 */
	@Override
	public void cacheResult(Custom_CalendarInvitees custom_CalendarInvitees) {
		entityCache.putResult(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarInviteesImpl.class,
			custom_CalendarInvitees.getPrimaryKey(), custom_CalendarInvitees);

		custom_CalendarInvitees.resetOriginalValues();
	}

	/**
	 * Caches the custom_ calendar inviteeses in the entity cache if it is enabled.
	 *
	 * @param custom_CalendarInviteeses the custom_ calendar inviteeses
	 */
	@Override
	public void cacheResult(
		List<Custom_CalendarInvitees> custom_CalendarInviteeses) {
		for (Custom_CalendarInvitees custom_CalendarInvitees : custom_CalendarInviteeses) {
			if (entityCache.getResult(
						Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
						Custom_CalendarInviteesImpl.class,
						custom_CalendarInvitees.getPrimaryKey()) == null) {
				cacheResult(custom_CalendarInvitees);
			}
			else {
				custom_CalendarInvitees.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom_ calendar inviteeses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Custom_CalendarInviteesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom_ calendar invitees.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Custom_CalendarInvitees custom_CalendarInvitees) {
		entityCache.removeResult(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarInviteesImpl.class,
			custom_CalendarInvitees.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Custom_CalendarInvitees> custom_CalendarInviteeses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Custom_CalendarInvitees custom_CalendarInvitees : custom_CalendarInviteeses) {
			entityCache.removeResult(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
				Custom_CalendarInviteesImpl.class,
				custom_CalendarInvitees.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom_ calendar invitees with the primary key. Does not add the custom_ calendar invitees to the database.
	 *
	 * @param PK_calendarEventSubId the primary key for the new custom_ calendar invitees
	 * @return the new custom_ calendar invitees
	 */
	@Override
	public Custom_CalendarInvitees create(long PK_calendarEventSubId) {
		Custom_CalendarInvitees custom_CalendarInvitees = new Custom_CalendarInviteesImpl();

		custom_CalendarInvitees.setNew(true);
		custom_CalendarInvitees.setPrimaryKey(PK_calendarEventSubId);

		return custom_CalendarInvitees;
	}

	/**
	 * Removes the custom_ calendar invitees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_calendarEventSubId the primary key of the custom_ calendar invitees
	 * @return the custom_ calendar invitees that was removed
	 * @throws NoSuchCustom_CalendarInviteesException if a custom_ calendar invitees with the primary key could not be found
	 */
	@Override
	public Custom_CalendarInvitees remove(long PK_calendarEventSubId)
		throws NoSuchCustom_CalendarInviteesException {
		return remove((Serializable)PK_calendarEventSubId);
	}

	/**
	 * Removes the custom_ calendar invitees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom_ calendar invitees
	 * @return the custom_ calendar invitees that was removed
	 * @throws NoSuchCustom_CalendarInviteesException if a custom_ calendar invitees with the primary key could not be found
	 */
	@Override
	public Custom_CalendarInvitees remove(Serializable primaryKey)
		throws NoSuchCustom_CalendarInviteesException {
		Session session = null;

		try {
			session = openSession();

			Custom_CalendarInvitees custom_CalendarInvitees = (Custom_CalendarInvitees)session.get(Custom_CalendarInviteesImpl.class,
					primaryKey);

			if (custom_CalendarInvitees == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustom_CalendarInviteesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(custom_CalendarInvitees);
		}
		catch (NoSuchCustom_CalendarInviteesException nsee) {
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
	protected Custom_CalendarInvitees removeImpl(
		Custom_CalendarInvitees custom_CalendarInvitees) {
		custom_CalendarInvitees = toUnwrappedModel(custom_CalendarInvitees);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(custom_CalendarInvitees)) {
				custom_CalendarInvitees = (Custom_CalendarInvitees)session.get(Custom_CalendarInviteesImpl.class,
						custom_CalendarInvitees.getPrimaryKeyObj());
			}

			if (custom_CalendarInvitees != null) {
				session.delete(custom_CalendarInvitees);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (custom_CalendarInvitees != null) {
			clearCache(custom_CalendarInvitees);
		}

		return custom_CalendarInvitees;
	}

	@Override
	public Custom_CalendarInvitees updateImpl(
		Custom_CalendarInvitees custom_CalendarInvitees) {
		custom_CalendarInvitees = toUnwrappedModel(custom_CalendarInvitees);

		boolean isNew = custom_CalendarInvitees.isNew();

		Custom_CalendarInviteesModelImpl custom_CalendarInviteesModelImpl = (Custom_CalendarInviteesModelImpl)custom_CalendarInvitees;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (custom_CalendarInvitees.getCreateDate() == null)) {
			if (serviceContext == null) {
				custom_CalendarInvitees.setCreateDate(now);
			}
			else {
				custom_CalendarInvitees.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!custom_CalendarInviteesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				custom_CalendarInvitees.setModifiedDate(now);
			}
			else {
				custom_CalendarInvitees.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (custom_CalendarInvitees.isNew()) {
				session.save(custom_CalendarInvitees);

				custom_CalendarInvitees.setNew(false);
			}
			else {
				custom_CalendarInvitees = (Custom_CalendarInvitees)session.merge(custom_CalendarInvitees);
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

		entityCache.putResult(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarInviteesImpl.class,
			custom_CalendarInvitees.getPrimaryKey(), custom_CalendarInvitees,
			false);

		custom_CalendarInvitees.resetOriginalValues();

		return custom_CalendarInvitees;
	}

	protected Custom_CalendarInvitees toUnwrappedModel(
		Custom_CalendarInvitees custom_CalendarInvitees) {
		if (custom_CalendarInvitees instanceof Custom_CalendarInviteesImpl) {
			return custom_CalendarInvitees;
		}

		Custom_CalendarInviteesImpl custom_CalendarInviteesImpl = new Custom_CalendarInviteesImpl();

		custom_CalendarInviteesImpl.setNew(custom_CalendarInvitees.isNew());
		custom_CalendarInviteesImpl.setPrimaryKey(custom_CalendarInvitees.getPrimaryKey());

		custom_CalendarInviteesImpl.setPK_calendarEventSubId(custom_CalendarInvitees.getPK_calendarEventSubId());
		custom_CalendarInviteesImpl.setGroupId(custom_CalendarInvitees.getGroupId());
		custom_CalendarInviteesImpl.setUserId(custom_CalendarInvitees.getUserId());
		custom_CalendarInviteesImpl.setCreateDate(custom_CalendarInvitees.getCreateDate());
		custom_CalendarInviteesImpl.setModifiedDate(custom_CalendarInvitees.getModifiedDate());
		custom_CalendarInviteesImpl.setPK_calendarEventId(custom_CalendarInvitees.getPK_calendarEventId());
		custom_CalendarInviteesImpl.setInviteeEmailAddress(custom_CalendarInvitees.getInviteeEmailAddress());
		custom_CalendarInviteesImpl.setInvitee(custom_CalendarInvitees.getInvitee());
		custom_CalendarInviteesImpl.setStatus(custom_CalendarInvitees.getStatus());

		return custom_CalendarInviteesImpl;
	}

	/**
	 * Returns the custom_ calendar invitees with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ calendar invitees
	 * @return the custom_ calendar invitees
	 * @throws NoSuchCustom_CalendarInviteesException if a custom_ calendar invitees with the primary key could not be found
	 */
	@Override
	public Custom_CalendarInvitees findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustom_CalendarInviteesException {
		Custom_CalendarInvitees custom_CalendarInvitees = fetchByPrimaryKey(primaryKey);

		if (custom_CalendarInvitees == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustom_CalendarInviteesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return custom_CalendarInvitees;
	}

	/**
	 * Returns the custom_ calendar invitees with the primary key or throws a {@link NoSuchCustom_CalendarInviteesException} if it could not be found.
	 *
	 * @param PK_calendarEventSubId the primary key of the custom_ calendar invitees
	 * @return the custom_ calendar invitees
	 * @throws NoSuchCustom_CalendarInviteesException if a custom_ calendar invitees with the primary key could not be found
	 */
	@Override
	public Custom_CalendarInvitees findByPrimaryKey(long PK_calendarEventSubId)
		throws NoSuchCustom_CalendarInviteesException {
		return findByPrimaryKey((Serializable)PK_calendarEventSubId);
	}

	/**
	 * Returns the custom_ calendar invitees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ calendar invitees
	 * @return the custom_ calendar invitees, or <code>null</code> if a custom_ calendar invitees with the primary key could not be found
	 */
	@Override
	public Custom_CalendarInvitees fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
				Custom_CalendarInviteesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Custom_CalendarInvitees custom_CalendarInvitees = (Custom_CalendarInvitees)serializable;

		if (custom_CalendarInvitees == null) {
			Session session = null;

			try {
				session = openSession();

				custom_CalendarInvitees = (Custom_CalendarInvitees)session.get(Custom_CalendarInviteesImpl.class,
						primaryKey);

				if (custom_CalendarInvitees != null) {
					cacheResult(custom_CalendarInvitees);
				}
				else {
					entityCache.putResult(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
						Custom_CalendarInviteesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
					Custom_CalendarInviteesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return custom_CalendarInvitees;
	}

	/**
	 * Returns the custom_ calendar invitees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_calendarEventSubId the primary key of the custom_ calendar invitees
	 * @return the custom_ calendar invitees, or <code>null</code> if a custom_ calendar invitees with the primary key could not be found
	 */
	@Override
	public Custom_CalendarInvitees fetchByPrimaryKey(long PK_calendarEventSubId) {
		return fetchByPrimaryKey((Serializable)PK_calendarEventSubId);
	}

	@Override
	public Map<Serializable, Custom_CalendarInvitees> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Custom_CalendarInvitees> map = new HashMap<Serializable, Custom_CalendarInvitees>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Custom_CalendarInvitees custom_CalendarInvitees = fetchByPrimaryKey(primaryKey);

			if (custom_CalendarInvitees != null) {
				map.put(primaryKey, custom_CalendarInvitees);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
					Custom_CalendarInviteesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Custom_CalendarInvitees)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOM_CALENDARINVITEES_WHERE_PKS_IN);

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

			for (Custom_CalendarInvitees custom_CalendarInvitees : (List<Custom_CalendarInvitees>)q.list()) {
				map.put(custom_CalendarInvitees.getPrimaryKeyObj(),
					custom_CalendarInvitees);

				cacheResult(custom_CalendarInvitees);

				uncachedPrimaryKeys.remove(custom_CalendarInvitees.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Custom_CalendarInviteesModelImpl.ENTITY_CACHE_ENABLED,
					Custom_CalendarInviteesImpl.class, primaryKey, nullModel);
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
	 * Returns all the custom_ calendar inviteeses.
	 *
	 * @return the custom_ calendar inviteeses
	 */
	@Override
	public List<Custom_CalendarInvitees> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the custom_ calendar inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_CalendarInviteesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ calendar inviteeses
	 * @param end the upper bound of the range of custom_ calendar inviteeses (not inclusive)
	 * @return the range of custom_ calendar inviteeses
	 */
	@Override
	public List<Custom_CalendarInvitees> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the custom_ calendar inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_CalendarInviteesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ calendar inviteeses
	 * @param end the upper bound of the range of custom_ calendar inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom_ calendar inviteeses
	 */
	@Override
	public List<Custom_CalendarInvitees> findAll(int start, int end,
		OrderByComparator<Custom_CalendarInvitees> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the custom_ calendar inviteeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_CalendarInviteesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ calendar inviteeses
	 * @param end the upper bound of the range of custom_ calendar inviteeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of custom_ calendar inviteeses
	 */
	@Override
	public List<Custom_CalendarInvitees> findAll(int start, int end,
		OrderByComparator<Custom_CalendarInvitees> orderByComparator,
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

		List<Custom_CalendarInvitees> list = null;

		if (retrieveFromCache) {
			list = (List<Custom_CalendarInvitees>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOM_CALENDARINVITEES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOM_CALENDARINVITEES;

				if (pagination) {
					sql = sql.concat(Custom_CalendarInviteesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Custom_CalendarInvitees>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Custom_CalendarInvitees>)QueryUtil.list(q,
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
	 * Removes all the custom_ calendar inviteeses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Custom_CalendarInvitees custom_CalendarInvitees : findAll()) {
			remove(custom_CalendarInvitees);
		}
	}

	/**
	 * Returns the number of custom_ calendar inviteeses.
	 *
	 * @return the number of custom_ calendar inviteeses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOM_CALENDARINVITEES);

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
		return Custom_CalendarInviteesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom_ calendar invitees persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Custom_CalendarInviteesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOM_CALENDARINVITEES = "SELECT custom_CalendarInvitees FROM Custom_CalendarInvitees custom_CalendarInvitees";
	private static final String _SQL_SELECT_CUSTOM_CALENDARINVITEES_WHERE_PKS_IN =
		"SELECT custom_CalendarInvitees FROM Custom_CalendarInvitees custom_CalendarInvitees WHERE PK_calendarEventSubId IN (";
	private static final String _SQL_COUNT_CUSTOM_CALENDARINVITEES = "SELECT COUNT(custom_CalendarInvitees) FROM Custom_CalendarInvitees custom_CalendarInvitees";
	private static final String _ORDER_BY_ENTITY_ALIAS = "custom_CalendarInvitees.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Custom_CalendarInvitees exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(Custom_CalendarInviteesPersistenceImpl.class);
}