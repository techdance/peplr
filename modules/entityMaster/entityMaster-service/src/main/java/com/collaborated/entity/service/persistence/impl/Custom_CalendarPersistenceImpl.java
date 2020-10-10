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

import com.collaborated.entity.exception.NoSuchCustom_CalendarException;
import com.collaborated.entity.model.Custom_Calendar;
import com.collaborated.entity.model.impl.Custom_CalendarImpl;
import com.collaborated.entity.model.impl.Custom_CalendarModelImpl;
import com.collaborated.entity.service.persistence.Custom_CalendarPersistence;

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
 * The persistence implementation for the custom_ calendar service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarPersistence
 * @see com.collaborated.entity.service.persistence.Custom_CalendarUtil
 * @generated
 */
@ProviderType
public class Custom_CalendarPersistenceImpl extends BasePersistenceImpl<Custom_Calendar>
	implements Custom_CalendarPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Custom_CalendarUtil} to access the custom_ calendar persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Custom_CalendarImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarModelImpl.FINDER_CACHE_ENABLED,
			Custom_CalendarImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarModelImpl.FINDER_CACHE_ENABLED,
			Custom_CalendarImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Custom_CalendarPersistenceImpl() {
		setModelClass(Custom_Calendar.class);
	}

	/**
	 * Caches the custom_ calendar in the entity cache if it is enabled.
	 *
	 * @param custom_Calendar the custom_ calendar
	 */
	@Override
	public void cacheResult(Custom_Calendar custom_Calendar) {
		entityCache.putResult(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarImpl.class, custom_Calendar.getPrimaryKey(),
			custom_Calendar);

		custom_Calendar.resetOriginalValues();
	}

	/**
	 * Caches the custom_ calendars in the entity cache if it is enabled.
	 *
	 * @param custom_Calendars the custom_ calendars
	 */
	@Override
	public void cacheResult(List<Custom_Calendar> custom_Calendars) {
		for (Custom_Calendar custom_Calendar : custom_Calendars) {
			if (entityCache.getResult(
						Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
						Custom_CalendarImpl.class,
						custom_Calendar.getPrimaryKey()) == null) {
				cacheResult(custom_Calendar);
			}
			else {
				custom_Calendar.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom_ calendars.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Custom_CalendarImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom_ calendar.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Custom_Calendar custom_Calendar) {
		entityCache.removeResult(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarImpl.class, custom_Calendar.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Custom_Calendar> custom_Calendars) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Custom_Calendar custom_Calendar : custom_Calendars) {
			entityCache.removeResult(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
				Custom_CalendarImpl.class, custom_Calendar.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom_ calendar with the primary key. Does not add the custom_ calendar to the database.
	 *
	 * @param PK_calendarEventId the primary key for the new custom_ calendar
	 * @return the new custom_ calendar
	 */
	@Override
	public Custom_Calendar create(long PK_calendarEventId) {
		Custom_Calendar custom_Calendar = new Custom_CalendarImpl();

		custom_Calendar.setNew(true);
		custom_Calendar.setPrimaryKey(PK_calendarEventId);

		return custom_Calendar;
	}

	/**
	 * Removes the custom_ calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_calendarEventId the primary key of the custom_ calendar
	 * @return the custom_ calendar that was removed
	 * @throws NoSuchCustom_CalendarException if a custom_ calendar with the primary key could not be found
	 */
	@Override
	public Custom_Calendar remove(long PK_calendarEventId)
		throws NoSuchCustom_CalendarException {
		return remove((Serializable)PK_calendarEventId);
	}

	/**
	 * Removes the custom_ calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom_ calendar
	 * @return the custom_ calendar that was removed
	 * @throws NoSuchCustom_CalendarException if a custom_ calendar with the primary key could not be found
	 */
	@Override
	public Custom_Calendar remove(Serializable primaryKey)
		throws NoSuchCustom_CalendarException {
		Session session = null;

		try {
			session = openSession();

			Custom_Calendar custom_Calendar = (Custom_Calendar)session.get(Custom_CalendarImpl.class,
					primaryKey);

			if (custom_Calendar == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustom_CalendarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(custom_Calendar);
		}
		catch (NoSuchCustom_CalendarException nsee) {
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
	protected Custom_Calendar removeImpl(Custom_Calendar custom_Calendar) {
		custom_Calendar = toUnwrappedModel(custom_Calendar);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(custom_Calendar)) {
				custom_Calendar = (Custom_Calendar)session.get(Custom_CalendarImpl.class,
						custom_Calendar.getPrimaryKeyObj());
			}

			if (custom_Calendar != null) {
				session.delete(custom_Calendar);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (custom_Calendar != null) {
			clearCache(custom_Calendar);
		}

		return custom_Calendar;
	}

	@Override
	public Custom_Calendar updateImpl(Custom_Calendar custom_Calendar) {
		custom_Calendar = toUnwrappedModel(custom_Calendar);

		boolean isNew = custom_Calendar.isNew();

		Custom_CalendarModelImpl custom_CalendarModelImpl = (Custom_CalendarModelImpl)custom_Calendar;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (custom_Calendar.getCreateDate() == null)) {
			if (serviceContext == null) {
				custom_Calendar.setCreateDate(now);
			}
			else {
				custom_Calendar.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!custom_CalendarModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				custom_Calendar.setModifiedDate(now);
			}
			else {
				custom_Calendar.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (custom_Calendar.isNew()) {
				session.save(custom_Calendar);

				custom_Calendar.setNew(false);
			}
			else {
				custom_Calendar = (Custom_Calendar)session.merge(custom_Calendar);
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

		entityCache.putResult(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
			Custom_CalendarImpl.class, custom_Calendar.getPrimaryKey(),
			custom_Calendar, false);

		custom_Calendar.resetOriginalValues();

		return custom_Calendar;
	}

	protected Custom_Calendar toUnwrappedModel(Custom_Calendar custom_Calendar) {
		if (custom_Calendar instanceof Custom_CalendarImpl) {
			return custom_Calendar;
		}

		Custom_CalendarImpl custom_CalendarImpl = new Custom_CalendarImpl();

		custom_CalendarImpl.setNew(custom_Calendar.isNew());
		custom_CalendarImpl.setPrimaryKey(custom_Calendar.getPrimaryKey());

		custom_CalendarImpl.setPK_calendarEventId(custom_Calendar.getPK_calendarEventId());
		custom_CalendarImpl.setGroupId(custom_Calendar.getGroupId());
		custom_CalendarImpl.setUserId(custom_Calendar.getUserId());
		custom_CalendarImpl.setCreateDate(custom_Calendar.getCreateDate());
		custom_CalendarImpl.setModifiedDate(custom_Calendar.getModifiedDate());
		custom_CalendarImpl.setCalendarResourceId(custom_Calendar.getCalendarResourceId());
		custom_CalendarImpl.setTimeZoneId(custom_Calendar.getTimeZoneId());
		custom_CalendarImpl.setStartDate(custom_Calendar.getStartDate());
		custom_CalendarImpl.setEndDate(custom_Calendar.getEndDate());
		custom_CalendarImpl.setStartTime(custom_Calendar.getStartTime());
		custom_CalendarImpl.setEndTime(custom_Calendar.getEndTime());
		custom_CalendarImpl.setEventTitle(custom_Calendar.getEventTitle());

		return custom_CalendarImpl;
	}

	/**
	 * Returns the custom_ calendar with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ calendar
	 * @return the custom_ calendar
	 * @throws NoSuchCustom_CalendarException if a custom_ calendar with the primary key could not be found
	 */
	@Override
	public Custom_Calendar findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustom_CalendarException {
		Custom_Calendar custom_Calendar = fetchByPrimaryKey(primaryKey);

		if (custom_Calendar == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustom_CalendarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return custom_Calendar;
	}

	/**
	 * Returns the custom_ calendar with the primary key or throws a {@link NoSuchCustom_CalendarException} if it could not be found.
	 *
	 * @param PK_calendarEventId the primary key of the custom_ calendar
	 * @return the custom_ calendar
	 * @throws NoSuchCustom_CalendarException if a custom_ calendar with the primary key could not be found
	 */
	@Override
	public Custom_Calendar findByPrimaryKey(long PK_calendarEventId)
		throws NoSuchCustom_CalendarException {
		return findByPrimaryKey((Serializable)PK_calendarEventId);
	}

	/**
	 * Returns the custom_ calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom_ calendar
	 * @return the custom_ calendar, or <code>null</code> if a custom_ calendar with the primary key could not be found
	 */
	@Override
	public Custom_Calendar fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
				Custom_CalendarImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Custom_Calendar custom_Calendar = (Custom_Calendar)serializable;

		if (custom_Calendar == null) {
			Session session = null;

			try {
				session = openSession();

				custom_Calendar = (Custom_Calendar)session.get(Custom_CalendarImpl.class,
						primaryKey);

				if (custom_Calendar != null) {
					cacheResult(custom_Calendar);
				}
				else {
					entityCache.putResult(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
						Custom_CalendarImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
					Custom_CalendarImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return custom_Calendar;
	}

	/**
	 * Returns the custom_ calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_calendarEventId the primary key of the custom_ calendar
	 * @return the custom_ calendar, or <code>null</code> if a custom_ calendar with the primary key could not be found
	 */
	@Override
	public Custom_Calendar fetchByPrimaryKey(long PK_calendarEventId) {
		return fetchByPrimaryKey((Serializable)PK_calendarEventId);
	}

	@Override
	public Map<Serializable, Custom_Calendar> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Custom_Calendar> map = new HashMap<Serializable, Custom_Calendar>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Custom_Calendar custom_Calendar = fetchByPrimaryKey(primaryKey);

			if (custom_Calendar != null) {
				map.put(primaryKey, custom_Calendar);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
					Custom_CalendarImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Custom_Calendar)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOM_CALENDAR_WHERE_PKS_IN);

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

			for (Custom_Calendar custom_Calendar : (List<Custom_Calendar>)q.list()) {
				map.put(custom_Calendar.getPrimaryKeyObj(), custom_Calendar);

				cacheResult(custom_Calendar);

				uncachedPrimaryKeys.remove(custom_Calendar.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Custom_CalendarModelImpl.ENTITY_CACHE_ENABLED,
					Custom_CalendarImpl.class, primaryKey, nullModel);
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
	 * Returns all the custom_ calendars.
	 *
	 * @return the custom_ calendars
	 */
	@Override
	public List<Custom_Calendar> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the custom_ calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_CalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ calendars
	 * @param end the upper bound of the range of custom_ calendars (not inclusive)
	 * @return the range of custom_ calendars
	 */
	@Override
	public List<Custom_Calendar> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the custom_ calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_CalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ calendars
	 * @param end the upper bound of the range of custom_ calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom_ calendars
	 */
	@Override
	public List<Custom_Calendar> findAll(int start, int end,
		OrderByComparator<Custom_Calendar> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the custom_ calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Custom_CalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom_ calendars
	 * @param end the upper bound of the range of custom_ calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of custom_ calendars
	 */
	@Override
	public List<Custom_Calendar> findAll(int start, int end,
		OrderByComparator<Custom_Calendar> orderByComparator,
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

		List<Custom_Calendar> list = null;

		if (retrieveFromCache) {
			list = (List<Custom_Calendar>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOM_CALENDAR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOM_CALENDAR;

				if (pagination) {
					sql = sql.concat(Custom_CalendarModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Custom_Calendar>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Custom_Calendar>)QueryUtil.list(q,
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
	 * Removes all the custom_ calendars from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Custom_Calendar custom_Calendar : findAll()) {
			remove(custom_Calendar);
		}
	}

	/**
	 * Returns the number of custom_ calendars.
	 *
	 * @return the number of custom_ calendars
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOM_CALENDAR);

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
		return Custom_CalendarModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom_ calendar persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Custom_CalendarImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOM_CALENDAR = "SELECT custom_Calendar FROM Custom_Calendar custom_Calendar";
	private static final String _SQL_SELECT_CUSTOM_CALENDAR_WHERE_PKS_IN = "SELECT custom_Calendar FROM Custom_Calendar custom_Calendar WHERE PK_calendarEventId IN (";
	private static final String _SQL_COUNT_CUSTOM_CALENDAR = "SELECT COUNT(custom_Calendar) FROM Custom_Calendar custom_Calendar";
	private static final String _ORDER_BY_ENTITY_ALIAS = "custom_Calendar.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Custom_Calendar exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(Custom_CalendarPersistenceImpl.class);
}