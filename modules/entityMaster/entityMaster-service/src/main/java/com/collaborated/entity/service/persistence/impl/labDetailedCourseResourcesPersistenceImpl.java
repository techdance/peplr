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

import com.collaborated.entity.exception.NoSuchlabDetailedCourseResourcesException;
import com.collaborated.entity.model.impl.labDetailedCourseResourcesImpl;
import com.collaborated.entity.model.impl.labDetailedCourseResourcesModelImpl;
import com.collaborated.entity.model.labDetailedCourseResources;
import com.collaborated.entity.service.persistence.labDetailedCourseResourcesPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
 * The persistence implementation for the lab detailed course resources service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseResourcesPersistence
 * @see com.collaborated.entity.service.persistence.labDetailedCourseResourcesUtil
 * @generated
 */
@ProviderType
public class labDetailedCourseResourcesPersistenceImpl
	extends BasePersistenceImpl<labDetailedCourseResources>
	implements labDetailedCourseResourcesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labDetailedCourseResourcesUtil} to access the lab detailed course resources persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labDetailedCourseResourcesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseResourcesModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseResourcesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseResourcesModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseResourcesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseResourcesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID =
		new FinderPath(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseResourcesModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseResourcesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBygetCourseResourcesbyCourseId",
			new String[] { Long.class.getName() },
			labDetailedCourseResourcesModelImpl.PK_COURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETCOURSERESOURCESBYCOURSEID =
		new FinderPath(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseResourcesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetCourseResourcesbyCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the lab detailed course resources where PK_courseId = &#63; or throws a {@link NoSuchlabDetailedCourseResourcesException} if it could not be found.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the matching lab detailed course resources
	 * @throws NoSuchlabDetailedCourseResourcesException if a matching lab detailed course resources could not be found
	 */
	@Override
	public labDetailedCourseResources findBygetCourseResourcesbyCourseId(
		long PK_courseId) throws NoSuchlabDetailedCourseResourcesException {
		labDetailedCourseResources labDetailedCourseResources = fetchBygetCourseResourcesbyCourseId(PK_courseId);

		if (labDetailedCourseResources == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PK_courseId=");
			msg.append(PK_courseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchlabDetailedCourseResourcesException(msg.toString());
		}

		return labDetailedCourseResources;
	}

	/**
	 * Returns the lab detailed course resources where PK_courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the matching lab detailed course resources, or <code>null</code> if a matching lab detailed course resources could not be found
	 */
	@Override
	public labDetailedCourseResources fetchBygetCourseResourcesbyCourseId(
		long PK_courseId) {
		return fetchBygetCourseResourcesbyCourseId(PK_courseId, true);
	}

	/**
	 * Returns the lab detailed course resources where PK_courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PK_courseId the p k_course ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lab detailed course resources, or <code>null</code> if a matching lab detailed course resources could not be found
	 */
	@Override
	public labDetailedCourseResources fetchBygetCourseResourcesbyCourseId(
		long PK_courseId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PK_courseId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID,
					finderArgs, this);
		}

		if (result instanceof labDetailedCourseResources) {
			labDetailedCourseResources labDetailedCourseResources = (labDetailedCourseResources)result;

			if ((PK_courseId != labDetailedCourseResources.getPK_courseId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LABDETAILEDCOURSERESOURCES_WHERE);

			query.append(_FINDER_COLUMN_GETCOURSERESOURCESBYCOURSEID_PK_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PK_courseId);

				List<labDetailedCourseResources> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID,
						finderArgs, list);
				}
				else {
					labDetailedCourseResources labDetailedCourseResources = list.get(0);

					result = labDetailedCourseResources;

					cacheResult(labDetailedCourseResources);

					if ((labDetailedCourseResources.getPK_courseId() != PK_courseId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID,
							finderArgs, labDetailedCourseResources);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (labDetailedCourseResources)result;
		}
	}

	/**
	 * Removes the lab detailed course resources where PK_courseId = &#63; from the database.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the lab detailed course resources that was removed
	 */
	@Override
	public labDetailedCourseResources removeBygetCourseResourcesbyCourseId(
		long PK_courseId) throws NoSuchlabDetailedCourseResourcesException {
		labDetailedCourseResources labDetailedCourseResources = findBygetCourseResourcesbyCourseId(PK_courseId);

		return remove(labDetailedCourseResources);
	}

	/**
	 * Returns the number of lab detailed course resourceses where PK_courseId = &#63;.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the number of matching lab detailed course resourceses
	 */
	@Override
	public int countBygetCourseResourcesbyCourseId(long PK_courseId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETCOURSERESOURCESBYCOURSEID;

		Object[] finderArgs = new Object[] { PK_courseId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LABDETAILEDCOURSERESOURCES_WHERE);

			query.append(_FINDER_COLUMN_GETCOURSERESOURCESBYCOURSEID_PK_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PK_courseId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GETCOURSERESOURCESBYCOURSEID_PK_COURSEID_2 =
		"labDetailedCourseResources.PK_courseId = ?";

	public labDetailedCourseResourcesPersistenceImpl() {
		setModelClass(labDetailedCourseResources.class);
	}

	/**
	 * Caches the lab detailed course resources in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseResources the lab detailed course resources
	 */
	@Override
	public void cacheResult(
		labDetailedCourseResources labDetailedCourseResources) {
		entityCache.putResult(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseResourcesImpl.class,
			labDetailedCourseResources.getPrimaryKey(),
			labDetailedCourseResources);

		finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID,
			new Object[] { labDetailedCourseResources.getPK_courseId() },
			labDetailedCourseResources);

		labDetailedCourseResources.resetOriginalValues();
	}

	/**
	 * Caches the lab detailed course resourceses in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseResourceses the lab detailed course resourceses
	 */
	@Override
	public void cacheResult(
		List<labDetailedCourseResources> labDetailedCourseResourceses) {
		for (labDetailedCourseResources labDetailedCourseResources : labDetailedCourseResourceses) {
			if (entityCache.getResult(
						labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseResourcesImpl.class,
						labDetailedCourseResources.getPrimaryKey()) == null) {
				cacheResult(labDetailedCourseResources);
			}
			else {
				labDetailedCourseResources.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab detailed course resourceses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labDetailedCourseResourcesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab detailed course resources.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		labDetailedCourseResources labDetailedCourseResources) {
		entityCache.removeResult(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseResourcesImpl.class,
			labDetailedCourseResources.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((labDetailedCourseResourcesModelImpl)labDetailedCourseResources);
	}

	@Override
	public void clearCache(
		List<labDetailedCourseResources> labDetailedCourseResourceses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labDetailedCourseResources labDetailedCourseResources : labDetailedCourseResourceses) {
			entityCache.removeResult(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseResourcesImpl.class,
				labDetailedCourseResources.getPrimaryKey());

			clearUniqueFindersCache((labDetailedCourseResourcesModelImpl)labDetailedCourseResources);
		}
	}

	protected void cacheUniqueFindersCache(
		labDetailedCourseResourcesModelImpl labDetailedCourseResourcesModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					labDetailedCourseResourcesModelImpl.getPK_courseId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_GETCOURSERESOURCESBYCOURSEID,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID,
				args, labDetailedCourseResourcesModelImpl);
		}
		else {
			if ((labDetailedCourseResourcesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						labDetailedCourseResourcesModelImpl.getPK_courseId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_GETCOURSERESOURCESBYCOURSEID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID,
					args, labDetailedCourseResourcesModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		labDetailedCourseResourcesModelImpl labDetailedCourseResourcesModelImpl) {
		Object[] args = new Object[] {
				labDetailedCourseResourcesModelImpl.getPK_courseId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_GETCOURSERESOURCESBYCOURSEID,
			args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID,
			args);

		if ((labDetailedCourseResourcesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					labDetailedCourseResourcesModelImpl.getOriginalPK_courseId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETCOURSERESOURCESBYCOURSEID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GETCOURSERESOURCESBYCOURSEID,
				args);
		}
	}

	/**
	 * Creates a new lab detailed course resources with the primary key. Does not add the lab detailed course resources to the database.
	 *
	 * @param PK_courseResourceId the primary key for the new lab detailed course resources
	 * @return the new lab detailed course resources
	 */
	@Override
	public labDetailedCourseResources create(long PK_courseResourceId) {
		labDetailedCourseResources labDetailedCourseResources = new labDetailedCourseResourcesImpl();

		labDetailedCourseResources.setNew(true);
		labDetailedCourseResources.setPrimaryKey(PK_courseResourceId);

		return labDetailedCourseResources;
	}

	/**
	 * Removes the lab detailed course resources with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_courseResourceId the primary key of the lab detailed course resources
	 * @return the lab detailed course resources that was removed
	 * @throws NoSuchlabDetailedCourseResourcesException if a lab detailed course resources with the primary key could not be found
	 */
	@Override
	public labDetailedCourseResources remove(long PK_courseResourceId)
		throws NoSuchlabDetailedCourseResourcesException {
		return remove((Serializable)PK_courseResourceId);
	}

	/**
	 * Removes the lab detailed course resources with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab detailed course resources
	 * @return the lab detailed course resources that was removed
	 * @throws NoSuchlabDetailedCourseResourcesException if a lab detailed course resources with the primary key could not be found
	 */
	@Override
	public labDetailedCourseResources remove(Serializable primaryKey)
		throws NoSuchlabDetailedCourseResourcesException {
		Session session = null;

		try {
			session = openSession();

			labDetailedCourseResources labDetailedCourseResources = (labDetailedCourseResources)session.get(labDetailedCourseResourcesImpl.class,
					primaryKey);

			if (labDetailedCourseResources == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabDetailedCourseResourcesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labDetailedCourseResources);
		}
		catch (NoSuchlabDetailedCourseResourcesException nsee) {
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
	protected labDetailedCourseResources removeImpl(
		labDetailedCourseResources labDetailedCourseResources) {
		labDetailedCourseResources = toUnwrappedModel(labDetailedCourseResources);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labDetailedCourseResources)) {
				labDetailedCourseResources = (labDetailedCourseResources)session.get(labDetailedCourseResourcesImpl.class,
						labDetailedCourseResources.getPrimaryKeyObj());
			}

			if (labDetailedCourseResources != null) {
				session.delete(labDetailedCourseResources);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labDetailedCourseResources != null) {
			clearCache(labDetailedCourseResources);
		}

		return labDetailedCourseResources;
	}

	@Override
	public labDetailedCourseResources updateImpl(
		labDetailedCourseResources labDetailedCourseResources) {
		labDetailedCourseResources = toUnwrappedModel(labDetailedCourseResources);

		boolean isNew = labDetailedCourseResources.isNew();

		labDetailedCourseResourcesModelImpl labDetailedCourseResourcesModelImpl = (labDetailedCourseResourcesModelImpl)labDetailedCourseResources;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labDetailedCourseResources.getCreateDate() == null)) {
			if (serviceContext == null) {
				labDetailedCourseResources.setCreateDate(now);
			}
			else {
				labDetailedCourseResources.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labDetailedCourseResourcesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labDetailedCourseResources.setModifiedDate(now);
			}
			else {
				labDetailedCourseResources.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labDetailedCourseResources.isNew()) {
				session.save(labDetailedCourseResources);

				labDetailedCourseResources.setNew(false);
			}
			else {
				labDetailedCourseResources = (labDetailedCourseResources)session.merge(labDetailedCourseResources);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!labDetailedCourseResourcesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseResourcesImpl.class,
			labDetailedCourseResources.getPrimaryKey(),
			labDetailedCourseResources, false);

		clearUniqueFindersCache(labDetailedCourseResourcesModelImpl);
		cacheUniqueFindersCache(labDetailedCourseResourcesModelImpl, isNew);

		labDetailedCourseResources.resetOriginalValues();

		return labDetailedCourseResources;
	}

	protected labDetailedCourseResources toUnwrappedModel(
		labDetailedCourseResources labDetailedCourseResources) {
		if (labDetailedCourseResources instanceof labDetailedCourseResourcesImpl) {
			return labDetailedCourseResources;
		}

		labDetailedCourseResourcesImpl labDetailedCourseResourcesImpl = new labDetailedCourseResourcesImpl();

		labDetailedCourseResourcesImpl.setNew(labDetailedCourseResources.isNew());
		labDetailedCourseResourcesImpl.setPrimaryKey(labDetailedCourseResources.getPrimaryKey());

		labDetailedCourseResourcesImpl.setPK_courseResourceId(labDetailedCourseResources.getPK_courseResourceId());
		labDetailedCourseResourcesImpl.setGroupId(labDetailedCourseResources.getGroupId());
		labDetailedCourseResourcesImpl.setUserId(labDetailedCourseResources.getUserId());
		labDetailedCourseResourcesImpl.setCreateDate(labDetailedCourseResources.getCreateDate());
		labDetailedCourseResourcesImpl.setModifiedDate(labDetailedCourseResources.getModifiedDate());
		labDetailedCourseResourcesImpl.setPK_projectId(labDetailedCourseResources.getPK_projectId());
		labDetailedCourseResourcesImpl.setPK_courseId(labDetailedCourseResources.getPK_courseId());
		labDetailedCourseResourcesImpl.setTextbokTitle(labDetailedCourseResources.getTextbokTitle());
		labDetailedCourseResourcesImpl.setPublisherName(labDetailedCourseResources.getPublisherName());
		labDetailedCourseResourcesImpl.setAuthor(labDetailedCourseResources.getAuthor());
		labDetailedCourseResourcesImpl.setIsbn(labDetailedCourseResources.getIsbn());

		return labDetailedCourseResourcesImpl;
	}

	/**
	 * Returns the lab detailed course resources with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course resources
	 * @return the lab detailed course resources
	 * @throws NoSuchlabDetailedCourseResourcesException if a lab detailed course resources with the primary key could not be found
	 */
	@Override
	public labDetailedCourseResources findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlabDetailedCourseResourcesException {
		labDetailedCourseResources labDetailedCourseResources = fetchByPrimaryKey(primaryKey);

		if (labDetailedCourseResources == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabDetailedCourseResourcesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labDetailedCourseResources;
	}

	/**
	 * Returns the lab detailed course resources with the primary key or throws a {@link NoSuchlabDetailedCourseResourcesException} if it could not be found.
	 *
	 * @param PK_courseResourceId the primary key of the lab detailed course resources
	 * @return the lab detailed course resources
	 * @throws NoSuchlabDetailedCourseResourcesException if a lab detailed course resources with the primary key could not be found
	 */
	@Override
	public labDetailedCourseResources findByPrimaryKey(long PK_courseResourceId)
		throws NoSuchlabDetailedCourseResourcesException {
		return findByPrimaryKey((Serializable)PK_courseResourceId);
	}

	/**
	 * Returns the lab detailed course resources with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course resources
	 * @return the lab detailed course resources, or <code>null</code> if a lab detailed course resources with the primary key could not be found
	 */
	@Override
	public labDetailedCourseResources fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseResourcesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labDetailedCourseResources labDetailedCourseResources = (labDetailedCourseResources)serializable;

		if (labDetailedCourseResources == null) {
			Session session = null;

			try {
				session = openSession();

				labDetailedCourseResources = (labDetailedCourseResources)session.get(labDetailedCourseResourcesImpl.class,
						primaryKey);

				if (labDetailedCourseResources != null) {
					cacheResult(labDetailedCourseResources);
				}
				else {
					entityCache.putResult(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseResourcesImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseResourcesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labDetailedCourseResources;
	}

	/**
	 * Returns the lab detailed course resources with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_courseResourceId the primary key of the lab detailed course resources
	 * @return the lab detailed course resources, or <code>null</code> if a lab detailed course resources with the primary key could not be found
	 */
	@Override
	public labDetailedCourseResources fetchByPrimaryKey(
		long PK_courseResourceId) {
		return fetchByPrimaryKey((Serializable)PK_courseResourceId);
	}

	@Override
	public Map<Serializable, labDetailedCourseResources> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labDetailedCourseResources> map = new HashMap<Serializable, labDetailedCourseResources>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labDetailedCourseResources labDetailedCourseResources = fetchByPrimaryKey(primaryKey);

			if (labDetailedCourseResources != null) {
				map.put(primaryKey, labDetailedCourseResources);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseResourcesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (labDetailedCourseResources)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABDETAILEDCOURSERESOURCES_WHERE_PKS_IN);

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

			for (labDetailedCourseResources labDetailedCourseResources : (List<labDetailedCourseResources>)q.list()) {
				map.put(labDetailedCourseResources.getPrimaryKeyObj(),
					labDetailedCourseResources);

				cacheResult(labDetailedCourseResources);

				uncachedPrimaryKeys.remove(labDetailedCourseResources.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labDetailedCourseResourcesModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseResourcesImpl.class, primaryKey, nullModel);
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
	 * Returns all the lab detailed course resourceses.
	 *
	 * @return the lab detailed course resourceses
	 */
	@Override
	public List<labDetailedCourseResources> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab detailed course resourceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course resourceses
	 * @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	 * @return the range of lab detailed course resourceses
	 */
	@Override
	public List<labDetailedCourseResources> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab detailed course resourceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course resourceses
	 * @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab detailed course resourceses
	 */
	@Override
	public List<labDetailedCourseResources> findAll(int start, int end,
		OrderByComparator<labDetailedCourseResources> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab detailed course resourceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseResourcesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course resourceses
	 * @param end the upper bound of the range of lab detailed course resourceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab detailed course resourceses
	 */
	@Override
	public List<labDetailedCourseResources> findAll(int start, int end,
		OrderByComparator<labDetailedCourseResources> orderByComparator,
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

		List<labDetailedCourseResources> list = null;

		if (retrieveFromCache) {
			list = (List<labDetailedCourseResources>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABDETAILEDCOURSERESOURCES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABDETAILEDCOURSERESOURCES;

				if (pagination) {
					sql = sql.concat(labDetailedCourseResourcesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labDetailedCourseResources>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labDetailedCourseResources>)QueryUtil.list(q,
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
	 * Removes all the lab detailed course resourceses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labDetailedCourseResources labDetailedCourseResources : findAll()) {
			remove(labDetailedCourseResources);
		}
	}

	/**
	 * Returns the number of lab detailed course resourceses.
	 *
	 * @return the number of lab detailed course resourceses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABDETAILEDCOURSERESOURCES);

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
		return labDetailedCourseResourcesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab detailed course resources persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labDetailedCourseResourcesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABDETAILEDCOURSERESOURCES = "SELECT labDetailedCourseResources FROM labDetailedCourseResources labDetailedCourseResources";
	private static final String _SQL_SELECT_LABDETAILEDCOURSERESOURCES_WHERE_PKS_IN =
		"SELECT labDetailedCourseResources FROM labDetailedCourseResources labDetailedCourseResources WHERE PK_courseResourceId IN (";
	private static final String _SQL_SELECT_LABDETAILEDCOURSERESOURCES_WHERE = "SELECT labDetailedCourseResources FROM labDetailedCourseResources labDetailedCourseResources WHERE ";
	private static final String _SQL_COUNT_LABDETAILEDCOURSERESOURCES = "SELECT COUNT(labDetailedCourseResources) FROM labDetailedCourseResources labDetailedCourseResources";
	private static final String _SQL_COUNT_LABDETAILEDCOURSERESOURCES_WHERE = "SELECT COUNT(labDetailedCourseResources) FROM labDetailedCourseResources labDetailedCourseResources WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labDetailedCourseResources.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labDetailedCourseResources exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No labDetailedCourseResources exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(labDetailedCourseResourcesPersistenceImpl.class);
}