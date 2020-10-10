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

import com.collaborated.entity.exception.NoSuchlabDetailedCourseHoursException;
import com.collaborated.entity.model.impl.labDetailedCourseHoursImpl;
import com.collaborated.entity.model.impl.labDetailedCourseHoursModelImpl;
import com.collaborated.entity.model.labDetailedCourseHours;
import com.collaborated.entity.service.persistence.labDetailedCourseHoursPersistence;

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
 * The persistence implementation for the lab detailed course hours service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseHoursPersistence
 * @see com.collaborated.entity.service.persistence.labDetailedCourseHoursUtil
 * @generated
 */
@ProviderType
public class labDetailedCourseHoursPersistenceImpl extends BasePersistenceImpl<labDetailedCourseHours>
	implements labDetailedCourseHoursPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labDetailedCourseHoursUtil} to access the lab detailed course hours persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labDetailedCourseHoursImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseHoursModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseHoursImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseHoursModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseHoursImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseHoursModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID =
		new FinderPath(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseHoursModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseHoursImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBygetCourseHoursbyCourseId",
			new String[] { Long.class.getName() },
			labDetailedCourseHoursModelImpl.PK_COURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETCOURSEHOURSBYCOURSEID =
		new FinderPath(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseHoursModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetCourseHoursbyCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the lab detailed course hours where PK_courseId = &#63; or throws a {@link NoSuchlabDetailedCourseHoursException} if it could not be found.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the matching lab detailed course hours
	 * @throws NoSuchlabDetailedCourseHoursException if a matching lab detailed course hours could not be found
	 */
	@Override
	public labDetailedCourseHours findBygetCourseHoursbyCourseId(
		long PK_courseId) throws NoSuchlabDetailedCourseHoursException {
		labDetailedCourseHours labDetailedCourseHours = fetchBygetCourseHoursbyCourseId(PK_courseId);

		if (labDetailedCourseHours == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PK_courseId=");
			msg.append(PK_courseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchlabDetailedCourseHoursException(msg.toString());
		}

		return labDetailedCourseHours;
	}

	/**
	 * Returns the lab detailed course hours where PK_courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the matching lab detailed course hours, or <code>null</code> if a matching lab detailed course hours could not be found
	 */
	@Override
	public labDetailedCourseHours fetchBygetCourseHoursbyCourseId(
		long PK_courseId) {
		return fetchBygetCourseHoursbyCourseId(PK_courseId, true);
	}

	/**
	 * Returns the lab detailed course hours where PK_courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PK_courseId the p k_course ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lab detailed course hours, or <code>null</code> if a matching lab detailed course hours could not be found
	 */
	@Override
	public labDetailedCourseHours fetchBygetCourseHoursbyCourseId(
		long PK_courseId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PK_courseId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID,
					finderArgs, this);
		}

		if (result instanceof labDetailedCourseHours) {
			labDetailedCourseHours labDetailedCourseHours = (labDetailedCourseHours)result;

			if ((PK_courseId != labDetailedCourseHours.getPK_courseId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LABDETAILEDCOURSEHOURS_WHERE);

			query.append(_FINDER_COLUMN_GETCOURSEHOURSBYCOURSEID_PK_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PK_courseId);

				List<labDetailedCourseHours> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID,
						finderArgs, list);
				}
				else {
					labDetailedCourseHours labDetailedCourseHours = list.get(0);

					result = labDetailedCourseHours;

					cacheResult(labDetailedCourseHours);

					if ((labDetailedCourseHours.getPK_courseId() != PK_courseId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID,
							finderArgs, labDetailedCourseHours);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID,
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
			return (labDetailedCourseHours)result;
		}
	}

	/**
	 * Removes the lab detailed course hours where PK_courseId = &#63; from the database.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the lab detailed course hours that was removed
	 */
	@Override
	public labDetailedCourseHours removeBygetCourseHoursbyCourseId(
		long PK_courseId) throws NoSuchlabDetailedCourseHoursException {
		labDetailedCourseHours labDetailedCourseHours = findBygetCourseHoursbyCourseId(PK_courseId);

		return remove(labDetailedCourseHours);
	}

	/**
	 * Returns the number of lab detailed course hourses where PK_courseId = &#63;.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the number of matching lab detailed course hourses
	 */
	@Override
	public int countBygetCourseHoursbyCourseId(long PK_courseId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETCOURSEHOURSBYCOURSEID;

		Object[] finderArgs = new Object[] { PK_courseId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LABDETAILEDCOURSEHOURS_WHERE);

			query.append(_FINDER_COLUMN_GETCOURSEHOURSBYCOURSEID_PK_COURSEID_2);

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

	private static final String _FINDER_COLUMN_GETCOURSEHOURSBYCOURSEID_PK_COURSEID_2 =
		"labDetailedCourseHours.PK_courseId = ?";

	public labDetailedCourseHoursPersistenceImpl() {
		setModelClass(labDetailedCourseHours.class);
	}

	/**
	 * Caches the lab detailed course hours in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseHours the lab detailed course hours
	 */
	@Override
	public void cacheResult(labDetailedCourseHours labDetailedCourseHours) {
		entityCache.putResult(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseHoursImpl.class,
			labDetailedCourseHours.getPrimaryKey(), labDetailedCourseHours);

		finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID,
			new Object[] { labDetailedCourseHours.getPK_courseId() },
			labDetailedCourseHours);

		labDetailedCourseHours.resetOriginalValues();
	}

	/**
	 * Caches the lab detailed course hourses in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseHourses the lab detailed course hourses
	 */
	@Override
	public void cacheResult(
		List<labDetailedCourseHours> labDetailedCourseHourses) {
		for (labDetailedCourseHours labDetailedCourseHours : labDetailedCourseHourses) {
			if (entityCache.getResult(
						labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseHoursImpl.class,
						labDetailedCourseHours.getPrimaryKey()) == null) {
				cacheResult(labDetailedCourseHours);
			}
			else {
				labDetailedCourseHours.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab detailed course hourses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labDetailedCourseHoursImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab detailed course hours.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(labDetailedCourseHours labDetailedCourseHours) {
		entityCache.removeResult(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseHoursImpl.class,
			labDetailedCourseHours.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((labDetailedCourseHoursModelImpl)labDetailedCourseHours);
	}

	@Override
	public void clearCache(
		List<labDetailedCourseHours> labDetailedCourseHourses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labDetailedCourseHours labDetailedCourseHours : labDetailedCourseHourses) {
			entityCache.removeResult(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseHoursImpl.class,
				labDetailedCourseHours.getPrimaryKey());

			clearUniqueFindersCache((labDetailedCourseHoursModelImpl)labDetailedCourseHours);
		}
	}

	protected void cacheUniqueFindersCache(
		labDetailedCourseHoursModelImpl labDetailedCourseHoursModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					labDetailedCourseHoursModelImpl.getPK_courseId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_GETCOURSEHOURSBYCOURSEID,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID,
				args, labDetailedCourseHoursModelImpl);
		}
		else {
			if ((labDetailedCourseHoursModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						labDetailedCourseHoursModelImpl.getPK_courseId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_GETCOURSEHOURSBYCOURSEID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID,
					args, labDetailedCourseHoursModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		labDetailedCourseHoursModelImpl labDetailedCourseHoursModelImpl) {
		Object[] args = new Object[] {
				labDetailedCourseHoursModelImpl.getPK_courseId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_GETCOURSEHOURSBYCOURSEID,
			args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID,
			args);

		if ((labDetailedCourseHoursModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					labDetailedCourseHoursModelImpl.getOriginalPK_courseId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETCOURSEHOURSBYCOURSEID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GETCOURSEHOURSBYCOURSEID,
				args);
		}
	}

	/**
	 * Creates a new lab detailed course hours with the primary key. Does not add the lab detailed course hours to the database.
	 *
	 * @param PK_courseHoursId the primary key for the new lab detailed course hours
	 * @return the new lab detailed course hours
	 */
	@Override
	public labDetailedCourseHours create(long PK_courseHoursId) {
		labDetailedCourseHours labDetailedCourseHours = new labDetailedCourseHoursImpl();

		labDetailedCourseHours.setNew(true);
		labDetailedCourseHours.setPrimaryKey(PK_courseHoursId);

		return labDetailedCourseHours;
	}

	/**
	 * Removes the lab detailed course hours with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_courseHoursId the primary key of the lab detailed course hours
	 * @return the lab detailed course hours that was removed
	 * @throws NoSuchlabDetailedCourseHoursException if a lab detailed course hours with the primary key could not be found
	 */
	@Override
	public labDetailedCourseHours remove(long PK_courseHoursId)
		throws NoSuchlabDetailedCourseHoursException {
		return remove((Serializable)PK_courseHoursId);
	}

	/**
	 * Removes the lab detailed course hours with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab detailed course hours
	 * @return the lab detailed course hours that was removed
	 * @throws NoSuchlabDetailedCourseHoursException if a lab detailed course hours with the primary key could not be found
	 */
	@Override
	public labDetailedCourseHours remove(Serializable primaryKey)
		throws NoSuchlabDetailedCourseHoursException {
		Session session = null;

		try {
			session = openSession();

			labDetailedCourseHours labDetailedCourseHours = (labDetailedCourseHours)session.get(labDetailedCourseHoursImpl.class,
					primaryKey);

			if (labDetailedCourseHours == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabDetailedCourseHoursException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labDetailedCourseHours);
		}
		catch (NoSuchlabDetailedCourseHoursException nsee) {
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
	protected labDetailedCourseHours removeImpl(
		labDetailedCourseHours labDetailedCourseHours) {
		labDetailedCourseHours = toUnwrappedModel(labDetailedCourseHours);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labDetailedCourseHours)) {
				labDetailedCourseHours = (labDetailedCourseHours)session.get(labDetailedCourseHoursImpl.class,
						labDetailedCourseHours.getPrimaryKeyObj());
			}

			if (labDetailedCourseHours != null) {
				session.delete(labDetailedCourseHours);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labDetailedCourseHours != null) {
			clearCache(labDetailedCourseHours);
		}

		return labDetailedCourseHours;
	}

	@Override
	public labDetailedCourseHours updateImpl(
		labDetailedCourseHours labDetailedCourseHours) {
		labDetailedCourseHours = toUnwrappedModel(labDetailedCourseHours);

		boolean isNew = labDetailedCourseHours.isNew();

		labDetailedCourseHoursModelImpl labDetailedCourseHoursModelImpl = (labDetailedCourseHoursModelImpl)labDetailedCourseHours;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labDetailedCourseHours.getCreateDate() == null)) {
			if (serviceContext == null) {
				labDetailedCourseHours.setCreateDate(now);
			}
			else {
				labDetailedCourseHours.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labDetailedCourseHoursModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labDetailedCourseHours.setModifiedDate(now);
			}
			else {
				labDetailedCourseHours.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labDetailedCourseHours.isNew()) {
				session.save(labDetailedCourseHours);

				labDetailedCourseHours.setNew(false);
			}
			else {
				labDetailedCourseHours = (labDetailedCourseHours)session.merge(labDetailedCourseHours);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !labDetailedCourseHoursModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseHoursImpl.class,
			labDetailedCourseHours.getPrimaryKey(), labDetailedCourseHours,
			false);

		clearUniqueFindersCache(labDetailedCourseHoursModelImpl);
		cacheUniqueFindersCache(labDetailedCourseHoursModelImpl, isNew);

		labDetailedCourseHours.resetOriginalValues();

		return labDetailedCourseHours;
	}

	protected labDetailedCourseHours toUnwrappedModel(
		labDetailedCourseHours labDetailedCourseHours) {
		if (labDetailedCourseHours instanceof labDetailedCourseHoursImpl) {
			return labDetailedCourseHours;
		}

		labDetailedCourseHoursImpl labDetailedCourseHoursImpl = new labDetailedCourseHoursImpl();

		labDetailedCourseHoursImpl.setNew(labDetailedCourseHours.isNew());
		labDetailedCourseHoursImpl.setPrimaryKey(labDetailedCourseHours.getPrimaryKey());

		labDetailedCourseHoursImpl.setPK_courseHoursId(labDetailedCourseHours.getPK_courseHoursId());
		labDetailedCourseHoursImpl.setGroupId(labDetailedCourseHours.getGroupId());
		labDetailedCourseHoursImpl.setUserId(labDetailedCourseHours.getUserId());
		labDetailedCourseHoursImpl.setCreateDate(labDetailedCourseHours.getCreateDate());
		labDetailedCourseHoursImpl.setModifiedDate(labDetailedCourseHours.getModifiedDate());
		labDetailedCourseHoursImpl.setPK_projectId(labDetailedCourseHours.getPK_projectId());
		labDetailedCourseHoursImpl.setPK_courseId(labDetailedCourseHours.getPK_courseId());
		labDetailedCourseHoursImpl.setNumberOfCredits(labDetailedCourseHours.getNumberOfCredits());
		labDetailedCourseHoursImpl.setNumberOfCourseWeeks(labDetailedCourseHours.getNumberOfCourseWeeks());
		labDetailedCourseHoursImpl.setCourseHoursPerWeek(labDetailedCourseHours.getCourseHoursPerWeek());
		labDetailedCourseHoursImpl.setLectureHoursPerWeek(labDetailedCourseHours.getLectureHoursPerWeek());
		labDetailedCourseHoursImpl.setLabHoursPerWeek(labDetailedCourseHours.getLabHoursPerWeek());
		labDetailedCourseHoursImpl.setIndependentStudyHoursPerWeek(labDetailedCourseHours.getIndependentStudyHoursPerWeek());

		return labDetailedCourseHoursImpl;
	}

	/**
	 * Returns the lab detailed course hours with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course hours
	 * @return the lab detailed course hours
	 * @throws NoSuchlabDetailedCourseHoursException if a lab detailed course hours with the primary key could not be found
	 */
	@Override
	public labDetailedCourseHours findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlabDetailedCourseHoursException {
		labDetailedCourseHours labDetailedCourseHours = fetchByPrimaryKey(primaryKey);

		if (labDetailedCourseHours == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabDetailedCourseHoursException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labDetailedCourseHours;
	}

	/**
	 * Returns the lab detailed course hours with the primary key or throws a {@link NoSuchlabDetailedCourseHoursException} if it could not be found.
	 *
	 * @param PK_courseHoursId the primary key of the lab detailed course hours
	 * @return the lab detailed course hours
	 * @throws NoSuchlabDetailedCourseHoursException if a lab detailed course hours with the primary key could not be found
	 */
	@Override
	public labDetailedCourseHours findByPrimaryKey(long PK_courseHoursId)
		throws NoSuchlabDetailedCourseHoursException {
		return findByPrimaryKey((Serializable)PK_courseHoursId);
	}

	/**
	 * Returns the lab detailed course hours with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course hours
	 * @return the lab detailed course hours, or <code>null</code> if a lab detailed course hours with the primary key could not be found
	 */
	@Override
	public labDetailedCourseHours fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseHoursImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labDetailedCourseHours labDetailedCourseHours = (labDetailedCourseHours)serializable;

		if (labDetailedCourseHours == null) {
			Session session = null;

			try {
				session = openSession();

				labDetailedCourseHours = (labDetailedCourseHours)session.get(labDetailedCourseHoursImpl.class,
						primaryKey);

				if (labDetailedCourseHours != null) {
					cacheResult(labDetailedCourseHours);
				}
				else {
					entityCache.putResult(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseHoursImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseHoursImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labDetailedCourseHours;
	}

	/**
	 * Returns the lab detailed course hours with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_courseHoursId the primary key of the lab detailed course hours
	 * @return the lab detailed course hours, or <code>null</code> if a lab detailed course hours with the primary key could not be found
	 */
	@Override
	public labDetailedCourseHours fetchByPrimaryKey(long PK_courseHoursId) {
		return fetchByPrimaryKey((Serializable)PK_courseHoursId);
	}

	@Override
	public Map<Serializable, labDetailedCourseHours> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labDetailedCourseHours> map = new HashMap<Serializable, labDetailedCourseHours>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labDetailedCourseHours labDetailedCourseHours = fetchByPrimaryKey(primaryKey);

			if (labDetailedCourseHours != null) {
				map.put(primaryKey, labDetailedCourseHours);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseHoursImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (labDetailedCourseHours)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABDETAILEDCOURSEHOURS_WHERE_PKS_IN);

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

			for (labDetailedCourseHours labDetailedCourseHours : (List<labDetailedCourseHours>)q.list()) {
				map.put(labDetailedCourseHours.getPrimaryKeyObj(),
					labDetailedCourseHours);

				cacheResult(labDetailedCourseHours);

				uncachedPrimaryKeys.remove(labDetailedCourseHours.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labDetailedCourseHoursModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseHoursImpl.class, primaryKey, nullModel);
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
	 * Returns all the lab detailed course hourses.
	 *
	 * @return the lab detailed course hourses
	 */
	@Override
	public List<labDetailedCourseHours> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab detailed course hourses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course hourses
	 * @param end the upper bound of the range of lab detailed course hourses (not inclusive)
	 * @return the range of lab detailed course hourses
	 */
	@Override
	public List<labDetailedCourseHours> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab detailed course hourses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course hourses
	 * @param end the upper bound of the range of lab detailed course hourses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab detailed course hourses
	 */
	@Override
	public List<labDetailedCourseHours> findAll(int start, int end,
		OrderByComparator<labDetailedCourseHours> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab detailed course hourses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseHoursModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course hourses
	 * @param end the upper bound of the range of lab detailed course hourses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab detailed course hourses
	 */
	@Override
	public List<labDetailedCourseHours> findAll(int start, int end,
		OrderByComparator<labDetailedCourseHours> orderByComparator,
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

		List<labDetailedCourseHours> list = null;

		if (retrieveFromCache) {
			list = (List<labDetailedCourseHours>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABDETAILEDCOURSEHOURS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABDETAILEDCOURSEHOURS;

				if (pagination) {
					sql = sql.concat(labDetailedCourseHoursModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labDetailedCourseHours>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labDetailedCourseHours>)QueryUtil.list(q,
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
	 * Removes all the lab detailed course hourses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labDetailedCourseHours labDetailedCourseHours : findAll()) {
			remove(labDetailedCourseHours);
		}
	}

	/**
	 * Returns the number of lab detailed course hourses.
	 *
	 * @return the number of lab detailed course hourses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABDETAILEDCOURSEHOURS);

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
		return labDetailedCourseHoursModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab detailed course hours persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labDetailedCourseHoursImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABDETAILEDCOURSEHOURS = "SELECT labDetailedCourseHours FROM labDetailedCourseHours labDetailedCourseHours";
	private static final String _SQL_SELECT_LABDETAILEDCOURSEHOURS_WHERE_PKS_IN = "SELECT labDetailedCourseHours FROM labDetailedCourseHours labDetailedCourseHours WHERE PK_courseHoursId IN (";
	private static final String _SQL_SELECT_LABDETAILEDCOURSEHOURS_WHERE = "SELECT labDetailedCourseHours FROM labDetailedCourseHours labDetailedCourseHours WHERE ";
	private static final String _SQL_COUNT_LABDETAILEDCOURSEHOURS = "SELECT COUNT(labDetailedCourseHours) FROM labDetailedCourseHours labDetailedCourseHours";
	private static final String _SQL_COUNT_LABDETAILEDCOURSEHOURS_WHERE = "SELECT COUNT(labDetailedCourseHours) FROM labDetailedCourseHours labDetailedCourseHours WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labDetailedCourseHours.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labDetailedCourseHours exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No labDetailedCourseHours exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(labDetailedCourseHoursPersistenceImpl.class);
}