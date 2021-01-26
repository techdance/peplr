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

import com.collaborated.entity.exception.NoSuchdiscussionMessageNotificationException;
import com.collaborated.entity.model.discussionMessageNotification;
import com.collaborated.entity.model.impl.discussionMessageNotificationImpl;
import com.collaborated.entity.model.impl.discussionMessageNotificationModelImpl;
import com.collaborated.entity.service.persistence.discussionMessageNotificationPersistence;

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
 * The persistence implementation for the discussion message notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see discussionMessageNotificationPersistence
 * @see com.collaborated.entity.service.persistence.discussionMessageNotificationUtil
 * @generated
 */
@ProviderType
public class discussionMessageNotificationPersistenceImpl
	extends BasePersistenceImpl<discussionMessageNotification>
	implements discussionMessageNotificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link discussionMessageNotificationUtil} to access the discussion message notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = discussionMessageNotificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
			discussionMessageNotificationModelImpl.FINDER_CACHE_ENABLED,
			discussionMessageNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
			discussionMessageNotificationModelImpl.FINDER_CACHE_ENABLED,
			discussionMessageNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
			discussionMessageNotificationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public discussionMessageNotificationPersistenceImpl() {
		setModelClass(discussionMessageNotification.class);
	}

	/**
	 * Caches the discussion message notification in the entity cache if it is enabled.
	 *
	 * @param discussionMessageNotification the discussion message notification
	 */
	@Override
	public void cacheResult(
		discussionMessageNotification discussionMessageNotification) {
		entityCache.putResult(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
			discussionMessageNotificationImpl.class,
			discussionMessageNotification.getPrimaryKey(),
			discussionMessageNotification);

		discussionMessageNotification.resetOriginalValues();
	}

	/**
	 * Caches the discussion message notifications in the entity cache if it is enabled.
	 *
	 * @param discussionMessageNotifications the discussion message notifications
	 */
	@Override
	public void cacheResult(
		List<discussionMessageNotification> discussionMessageNotifications) {
		for (discussionMessageNotification discussionMessageNotification : discussionMessageNotifications) {
			if (entityCache.getResult(
						discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
						discussionMessageNotificationImpl.class,
						discussionMessageNotification.getPrimaryKey()) == null) {
				cacheResult(discussionMessageNotification);
			}
			else {
				discussionMessageNotification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all discussion message notifications.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(discussionMessageNotificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the discussion message notification.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		discussionMessageNotification discussionMessageNotification) {
		entityCache.removeResult(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
			discussionMessageNotificationImpl.class,
			discussionMessageNotification.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<discussionMessageNotification> discussionMessageNotifications) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (discussionMessageNotification discussionMessageNotification : discussionMessageNotifications) {
			entityCache.removeResult(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
				discussionMessageNotificationImpl.class,
				discussionMessageNotification.getPrimaryKey());
		}
	}

	/**
	 * Creates a new discussion message notification with the primary key. Does not add the discussion message notification to the database.
	 *
	 * @param PK_discussionNotificationId the primary key for the new discussion message notification
	 * @return the new discussion message notification
	 */
	@Override
	public discussionMessageNotification create(
		long PK_discussionNotificationId) {
		discussionMessageNotification discussionMessageNotification = new discussionMessageNotificationImpl();

		discussionMessageNotification.setNew(true);
		discussionMessageNotification.setPrimaryKey(PK_discussionNotificationId);

		return discussionMessageNotification;
	}

	/**
	 * Removes the discussion message notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_discussionNotificationId the primary key of the discussion message notification
	 * @return the discussion message notification that was removed
	 * @throws NoSuchdiscussionMessageNotificationException if a discussion message notification with the primary key could not be found
	 */
	@Override
	public discussionMessageNotification remove(
		long PK_discussionNotificationId)
		throws NoSuchdiscussionMessageNotificationException {
		return remove((Serializable)PK_discussionNotificationId);
	}

	/**
	 * Removes the discussion message notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the discussion message notification
	 * @return the discussion message notification that was removed
	 * @throws NoSuchdiscussionMessageNotificationException if a discussion message notification with the primary key could not be found
	 */
	@Override
	public discussionMessageNotification remove(Serializable primaryKey)
		throws NoSuchdiscussionMessageNotificationException {
		Session session = null;

		try {
			session = openSession();

			discussionMessageNotification discussionMessageNotification = (discussionMessageNotification)session.get(discussionMessageNotificationImpl.class,
					primaryKey);

			if (discussionMessageNotification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchdiscussionMessageNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(discussionMessageNotification);
		}
		catch (NoSuchdiscussionMessageNotificationException nsee) {
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
	protected discussionMessageNotification removeImpl(
		discussionMessageNotification discussionMessageNotification) {
		discussionMessageNotification = toUnwrappedModel(discussionMessageNotification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(discussionMessageNotification)) {
				discussionMessageNotification = (discussionMessageNotification)session.get(discussionMessageNotificationImpl.class,
						discussionMessageNotification.getPrimaryKeyObj());
			}

			if (discussionMessageNotification != null) {
				session.delete(discussionMessageNotification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (discussionMessageNotification != null) {
			clearCache(discussionMessageNotification);
		}

		return discussionMessageNotification;
	}

	@Override
	public discussionMessageNotification updateImpl(
		discussionMessageNotification discussionMessageNotification) {
		discussionMessageNotification = toUnwrappedModel(discussionMessageNotification);

		boolean isNew = discussionMessageNotification.isNew();

		discussionMessageNotificationModelImpl discussionMessageNotificationModelImpl =
			(discussionMessageNotificationModelImpl)discussionMessageNotification;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (discussionMessageNotification.getCreateDate() == null)) {
			if (serviceContext == null) {
				discussionMessageNotification.setCreateDate(now);
			}
			else {
				discussionMessageNotification.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!discussionMessageNotificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				discussionMessageNotification.setModifiedDate(now);
			}
			else {
				discussionMessageNotification.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (discussionMessageNotification.isNew()) {
				session.save(discussionMessageNotification);

				discussionMessageNotification.setNew(false);
			}
			else {
				discussionMessageNotification = (discussionMessageNotification)session.merge(discussionMessageNotification);
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

		entityCache.putResult(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
			discussionMessageNotificationImpl.class,
			discussionMessageNotification.getPrimaryKey(),
			discussionMessageNotification, false);

		discussionMessageNotification.resetOriginalValues();

		return discussionMessageNotification;
	}

	protected discussionMessageNotification toUnwrappedModel(
		discussionMessageNotification discussionMessageNotification) {
		if (discussionMessageNotification instanceof discussionMessageNotificationImpl) {
			return discussionMessageNotification;
		}

		discussionMessageNotificationImpl discussionMessageNotificationImpl = new discussionMessageNotificationImpl();

		discussionMessageNotificationImpl.setNew(discussionMessageNotification.isNew());
		discussionMessageNotificationImpl.setPrimaryKey(discussionMessageNotification.getPrimaryKey());

		discussionMessageNotificationImpl.setPK_discussionNotificationId(discussionMessageNotification.getPK_discussionNotificationId());
		discussionMessageNotificationImpl.setGroupId(discussionMessageNotification.getGroupId());
		discussionMessageNotificationImpl.setCreateDate(discussionMessageNotification.getCreateDate());
		discussionMessageNotificationImpl.setModifiedDate(discussionMessageNotification.getModifiedDate());
		discussionMessageNotificationImpl.setPK_projectDiscussionId(discussionMessageNotification.getPK_projectDiscussionId());
		discussionMessageNotificationImpl.setMessageFrom(discussionMessageNotification.getMessageFrom());
		discussionMessageNotificationImpl.setMessageTo(discussionMessageNotification.getMessageTo());
		discussionMessageNotificationImpl.setIsRead(discussionMessageNotification.getIsRead());
		discussionMessageNotificationImpl.setIsRemoved(discussionMessageNotification.getIsRemoved());
		discussionMessageNotificationImpl.setMessageTitle(discussionMessageNotification.getMessageTitle());
		discussionMessageNotificationImpl.setMessageContent(discussionMessageNotification.getMessageContent());
		discussionMessageNotificationImpl.setEmailContent(discussionMessageNotification.getEmailContent());

		return discussionMessageNotificationImpl;
	}

	/**
	 * Returns the discussion message notification with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the discussion message notification
	 * @return the discussion message notification
	 * @throws NoSuchdiscussionMessageNotificationException if a discussion message notification with the primary key could not be found
	 */
	@Override
	public discussionMessageNotification findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchdiscussionMessageNotificationException {
		discussionMessageNotification discussionMessageNotification = fetchByPrimaryKey(primaryKey);

		if (discussionMessageNotification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchdiscussionMessageNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return discussionMessageNotification;
	}

	/**
	 * Returns the discussion message notification with the primary key or throws a {@link NoSuchdiscussionMessageNotificationException} if it could not be found.
	 *
	 * @param PK_discussionNotificationId the primary key of the discussion message notification
	 * @return the discussion message notification
	 * @throws NoSuchdiscussionMessageNotificationException if a discussion message notification with the primary key could not be found
	 */
	@Override
	public discussionMessageNotification findByPrimaryKey(
		long PK_discussionNotificationId)
		throws NoSuchdiscussionMessageNotificationException {
		return findByPrimaryKey((Serializable)PK_discussionNotificationId);
	}

	/**
	 * Returns the discussion message notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the discussion message notification
	 * @return the discussion message notification, or <code>null</code> if a discussion message notification with the primary key could not be found
	 */
	@Override
	public discussionMessageNotification fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
				discussionMessageNotificationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		discussionMessageNotification discussionMessageNotification = (discussionMessageNotification)serializable;

		if (discussionMessageNotification == null) {
			Session session = null;

			try {
				session = openSession();

				discussionMessageNotification = (discussionMessageNotification)session.get(discussionMessageNotificationImpl.class,
						primaryKey);

				if (discussionMessageNotification != null) {
					cacheResult(discussionMessageNotification);
				}
				else {
					entityCache.putResult(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
						discussionMessageNotificationImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
					discussionMessageNotificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return discussionMessageNotification;
	}

	/**
	 * Returns the discussion message notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_discussionNotificationId the primary key of the discussion message notification
	 * @return the discussion message notification, or <code>null</code> if a discussion message notification with the primary key could not be found
	 */
	@Override
	public discussionMessageNotification fetchByPrimaryKey(
		long PK_discussionNotificationId) {
		return fetchByPrimaryKey((Serializable)PK_discussionNotificationId);
	}

	@Override
	public Map<Serializable, discussionMessageNotification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, discussionMessageNotification> map = new HashMap<Serializable, discussionMessageNotification>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			discussionMessageNotification discussionMessageNotification = fetchByPrimaryKey(primaryKey);

			if (discussionMessageNotification != null) {
				map.put(primaryKey, discussionMessageNotification);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
					discussionMessageNotificationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(discussionMessageNotification)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DISCUSSIONMESSAGENOTIFICATION_WHERE_PKS_IN);

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

			for (discussionMessageNotification discussionMessageNotification : (List<discussionMessageNotification>)q.list()) {
				map.put(discussionMessageNotification.getPrimaryKeyObj(),
					discussionMessageNotification);

				cacheResult(discussionMessageNotification);

				uncachedPrimaryKeys.remove(discussionMessageNotification.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(discussionMessageNotificationModelImpl.ENTITY_CACHE_ENABLED,
					discussionMessageNotificationImpl.class, primaryKey,
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
	 * Returns all the discussion message notifications.
	 *
	 * @return the discussion message notifications
	 */
	@Override
	public List<discussionMessageNotification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the discussion message notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link discussionMessageNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of discussion message notifications
	 * @param end the upper bound of the range of discussion message notifications (not inclusive)
	 * @return the range of discussion message notifications
	 */
	@Override
	public List<discussionMessageNotification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the discussion message notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link discussionMessageNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of discussion message notifications
	 * @param end the upper bound of the range of discussion message notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of discussion message notifications
	 */
	@Override
	public List<discussionMessageNotification> findAll(int start, int end,
		OrderByComparator<discussionMessageNotification> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the discussion message notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link discussionMessageNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of discussion message notifications
	 * @param end the upper bound of the range of discussion message notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of discussion message notifications
	 */
	@Override
	public List<discussionMessageNotification> findAll(int start, int end,
		OrderByComparator<discussionMessageNotification> orderByComparator,
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

		List<discussionMessageNotification> list = null;

		if (retrieveFromCache) {
			list = (List<discussionMessageNotification>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DISCUSSIONMESSAGENOTIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISCUSSIONMESSAGENOTIFICATION;

				if (pagination) {
					sql = sql.concat(discussionMessageNotificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<discussionMessageNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<discussionMessageNotification>)QueryUtil.list(q,
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
	 * Removes all the discussion message notifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (discussionMessageNotification discussionMessageNotification : findAll()) {
			remove(discussionMessageNotification);
		}
	}

	/**
	 * Returns the number of discussion message notifications.
	 *
	 * @return the number of discussion message notifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DISCUSSIONMESSAGENOTIFICATION);

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
		return discussionMessageNotificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the discussion message notification persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(discussionMessageNotificationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DISCUSSIONMESSAGENOTIFICATION = "SELECT discussionMessageNotification FROM discussionMessageNotification discussionMessageNotification";
	private static final String _SQL_SELECT_DISCUSSIONMESSAGENOTIFICATION_WHERE_PKS_IN =
		"SELECT discussionMessageNotification FROM discussionMessageNotification discussionMessageNotification WHERE PK_discussionNotificationId IN (";
	private static final String _SQL_COUNT_DISCUSSIONMESSAGENOTIFICATION = "SELECT COUNT(discussionMessageNotification) FROM discussionMessageNotification discussionMessageNotification";
	private static final String _ORDER_BY_ENTITY_ALIAS = "discussionMessageNotification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No discussionMessageNotification exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(discussionMessageNotificationPersistenceImpl.class);
}