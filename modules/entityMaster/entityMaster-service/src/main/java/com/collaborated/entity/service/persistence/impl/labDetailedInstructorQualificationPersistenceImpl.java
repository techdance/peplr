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

import com.collaborated.entity.exception.NoSuchlabDetailedInstructorQualificationException;
import com.collaborated.entity.model.impl.labDetailedInstructorQualificationImpl;
import com.collaborated.entity.model.impl.labDetailedInstructorQualificationModelImpl;
import com.collaborated.entity.model.labDetailedInstructorQualification;
import com.collaborated.entity.service.persistence.labDetailedInstructorQualificationPersistence;

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
 * The persistence implementation for the lab detailed instructor qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedInstructorQualificationPersistence
 * @see com.collaborated.entity.service.persistence.labDetailedInstructorQualificationUtil
 * @generated
 */
@ProviderType
public class labDetailedInstructorQualificationPersistenceImpl
	extends BasePersistenceImpl<labDetailedInstructorQualification>
	implements labDetailedInstructorQualificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labDetailedInstructorQualificationUtil} to access the lab detailed instructor qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labDetailedInstructorQualificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedInstructorQualificationModelImpl.FINDER_CACHE_ENABLED,
			labDetailedInstructorQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedInstructorQualificationModelImpl.FINDER_CACHE_ENABLED,
			labDetailedInstructorQualificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedInstructorQualificationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID =
		new FinderPath(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedInstructorQualificationModelImpl.FINDER_CACHE_ENABLED,
			labDetailedInstructorQualificationImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchBygetCourseInstructorQualificationbyCourseId",
			new String[] { Long.class.getName() },
			labDetailedInstructorQualificationModelImpl.PK_COURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID =
		new FinderPath(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedInstructorQualificationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetCourseInstructorQualificationbyCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the lab detailed instructor qualification where PK_courseId = &#63; or throws a {@link NoSuchlabDetailedInstructorQualificationException} if it could not be found.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the matching lab detailed instructor qualification
	 * @throws NoSuchlabDetailedInstructorQualificationException if a matching lab detailed instructor qualification could not be found
	 */
	@Override
	public labDetailedInstructorQualification findBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId)
		throws NoSuchlabDetailedInstructorQualificationException {
		labDetailedInstructorQualification labDetailedInstructorQualification = fetchBygetCourseInstructorQualificationbyCourseId(PK_courseId);

		if (labDetailedInstructorQualification == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PK_courseId=");
			msg.append(PK_courseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchlabDetailedInstructorQualificationException(msg.toString());
		}

		return labDetailedInstructorQualification;
	}

	/**
	 * Returns the lab detailed instructor qualification where PK_courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the matching lab detailed instructor qualification, or <code>null</code> if a matching lab detailed instructor qualification could not be found
	 */
	@Override
	public labDetailedInstructorQualification fetchBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId) {
		return fetchBygetCourseInstructorQualificationbyCourseId(PK_courseId,
			true);
	}

	/**
	 * Returns the lab detailed instructor qualification where PK_courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PK_courseId the p k_course ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lab detailed instructor qualification, or <code>null</code> if a matching lab detailed instructor qualification could not be found
	 */
	@Override
	public labDetailedInstructorQualification fetchBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PK_courseId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
					finderArgs, this);
		}

		if (result instanceof labDetailedInstructorQualification) {
			labDetailedInstructorQualification labDetailedInstructorQualification =
				(labDetailedInstructorQualification)result;

			if ((PK_courseId != labDetailedInstructorQualification.getPK_courseId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LABDETAILEDINSTRUCTORQUALIFICATION_WHERE);

			query.append(_FINDER_COLUMN_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID_PK_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PK_courseId);

				List<labDetailedInstructorQualification> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
						finderArgs, list);
				}
				else {
					labDetailedInstructorQualification labDetailedInstructorQualification =
						list.get(0);

					result = labDetailedInstructorQualification;

					cacheResult(labDetailedInstructorQualification);

					if ((labDetailedInstructorQualification.getPK_courseId() != PK_courseId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
							finderArgs, labDetailedInstructorQualification);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
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
			return (labDetailedInstructorQualification)result;
		}
	}

	/**
	 * Removes the lab detailed instructor qualification where PK_courseId = &#63; from the database.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the lab detailed instructor qualification that was removed
	 */
	@Override
	public labDetailedInstructorQualification removeBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId)
		throws NoSuchlabDetailedInstructorQualificationException {
		labDetailedInstructorQualification labDetailedInstructorQualification = findBygetCourseInstructorQualificationbyCourseId(PK_courseId);

		return remove(labDetailedInstructorQualification);
	}

	/**
	 * Returns the number of lab detailed instructor qualifications where PK_courseId = &#63;.
	 *
	 * @param PK_courseId the p k_course ID
	 * @return the number of matching lab detailed instructor qualifications
	 */
	@Override
	public int countBygetCourseInstructorQualificationbyCourseId(
		long PK_courseId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID;

		Object[] finderArgs = new Object[] { PK_courseId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LABDETAILEDINSTRUCTORQUALIFICATION_WHERE);

			query.append(_FINDER_COLUMN_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID_PK_COURSEID_2);

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

	private static final String _FINDER_COLUMN_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID_PK_COURSEID_2 =
		"labDetailedInstructorQualification.PK_courseId = ?";

	public labDetailedInstructorQualificationPersistenceImpl() {
		setModelClass(labDetailedInstructorQualification.class);
	}

	/**
	 * Caches the lab detailed instructor qualification in the entity cache if it is enabled.
	 *
	 * @param labDetailedInstructorQualification the lab detailed instructor qualification
	 */
	@Override
	public void cacheResult(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		entityCache.putResult(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedInstructorQualificationImpl.class,
			labDetailedInstructorQualification.getPrimaryKey(),
			labDetailedInstructorQualification);

		finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
			new Object[] { labDetailedInstructorQualification.getPK_courseId() },
			labDetailedInstructorQualification);

		labDetailedInstructorQualification.resetOriginalValues();
	}

	/**
	 * Caches the lab detailed instructor qualifications in the entity cache if it is enabled.
	 *
	 * @param labDetailedInstructorQualifications the lab detailed instructor qualifications
	 */
	@Override
	public void cacheResult(
		List<labDetailedInstructorQualification> labDetailedInstructorQualifications) {
		for (labDetailedInstructorQualification labDetailedInstructorQualification : labDetailedInstructorQualifications) {
			if (entityCache.getResult(
						labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedInstructorQualificationImpl.class,
						labDetailedInstructorQualification.getPrimaryKey()) == null) {
				cacheResult(labDetailedInstructorQualification);
			}
			else {
				labDetailedInstructorQualification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab detailed instructor qualifications.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labDetailedInstructorQualificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab detailed instructor qualification.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		entityCache.removeResult(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedInstructorQualificationImpl.class,
			labDetailedInstructorQualification.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((labDetailedInstructorQualificationModelImpl)labDetailedInstructorQualification);
	}

	@Override
	public void clearCache(
		List<labDetailedInstructorQualification> labDetailedInstructorQualifications) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labDetailedInstructorQualification labDetailedInstructorQualification : labDetailedInstructorQualifications) {
			entityCache.removeResult(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedInstructorQualificationImpl.class,
				labDetailedInstructorQualification.getPrimaryKey());

			clearUniqueFindersCache((labDetailedInstructorQualificationModelImpl)labDetailedInstructorQualification);
		}
	}

	protected void cacheUniqueFindersCache(
		labDetailedInstructorQualificationModelImpl labDetailedInstructorQualificationModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					labDetailedInstructorQualificationModelImpl.getPK_courseId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
				args, labDetailedInstructorQualificationModelImpl);
		}
		else {
			if ((labDetailedInstructorQualificationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						labDetailedInstructorQualificationModelImpl.getPK_courseId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
					args, labDetailedInstructorQualificationModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		labDetailedInstructorQualificationModelImpl labDetailedInstructorQualificationModelImpl) {
		Object[] args = new Object[] {
				labDetailedInstructorQualificationModelImpl.getPK_courseId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
			args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
			args);

		if ((labDetailedInstructorQualificationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					labDetailedInstructorQualificationModelImpl.getOriginalPK_courseId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GETCOURSEINSTRUCTORQUALIFICATIONBYCOURSEID,
				args);
		}
	}

	/**
	 * Creates a new lab detailed instructor qualification with the primary key. Does not add the lab detailed instructor qualification to the database.
	 *
	 * @param PK_courseInstructorQualificationId the primary key for the new lab detailed instructor qualification
	 * @return the new lab detailed instructor qualification
	 */
	@Override
	public labDetailedInstructorQualification create(
		long PK_courseInstructorQualificationId) {
		labDetailedInstructorQualification labDetailedInstructorQualification = new labDetailedInstructorQualificationImpl();

		labDetailedInstructorQualification.setNew(true);
		labDetailedInstructorQualification.setPrimaryKey(PK_courseInstructorQualificationId);

		return labDetailedInstructorQualification;
	}

	/**
	 * Removes the lab detailed instructor qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	 * @return the lab detailed instructor qualification that was removed
	 * @throws NoSuchlabDetailedInstructorQualificationException if a lab detailed instructor qualification with the primary key could not be found
	 */
	@Override
	public labDetailedInstructorQualification remove(
		long PK_courseInstructorQualificationId)
		throws NoSuchlabDetailedInstructorQualificationException {
		return remove((Serializable)PK_courseInstructorQualificationId);
	}

	/**
	 * Removes the lab detailed instructor qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab detailed instructor qualification
	 * @return the lab detailed instructor qualification that was removed
	 * @throws NoSuchlabDetailedInstructorQualificationException if a lab detailed instructor qualification with the primary key could not be found
	 */
	@Override
	public labDetailedInstructorQualification remove(Serializable primaryKey)
		throws NoSuchlabDetailedInstructorQualificationException {
		Session session = null;

		try {
			session = openSession();

			labDetailedInstructorQualification labDetailedInstructorQualification =
				(labDetailedInstructorQualification)session.get(labDetailedInstructorQualificationImpl.class,
					primaryKey);

			if (labDetailedInstructorQualification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabDetailedInstructorQualificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labDetailedInstructorQualification);
		}
		catch (NoSuchlabDetailedInstructorQualificationException nsee) {
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
	protected labDetailedInstructorQualification removeImpl(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		labDetailedInstructorQualification = toUnwrappedModel(labDetailedInstructorQualification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labDetailedInstructorQualification)) {
				labDetailedInstructorQualification = (labDetailedInstructorQualification)session.get(labDetailedInstructorQualificationImpl.class,
						labDetailedInstructorQualification.getPrimaryKeyObj());
			}

			if (labDetailedInstructorQualification != null) {
				session.delete(labDetailedInstructorQualification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labDetailedInstructorQualification != null) {
			clearCache(labDetailedInstructorQualification);
		}

		return labDetailedInstructorQualification;
	}

	@Override
	public labDetailedInstructorQualification updateImpl(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		labDetailedInstructorQualification = toUnwrappedModel(labDetailedInstructorQualification);

		boolean isNew = labDetailedInstructorQualification.isNew();

		labDetailedInstructorQualificationModelImpl labDetailedInstructorQualificationModelImpl =
			(labDetailedInstructorQualificationModelImpl)labDetailedInstructorQualification;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew &&
				(labDetailedInstructorQualification.getCreateDate() == null)) {
			if (serviceContext == null) {
				labDetailedInstructorQualification.setCreateDate(now);
			}
			else {
				labDetailedInstructorQualification.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labDetailedInstructorQualificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labDetailedInstructorQualification.setModifiedDate(now);
			}
			else {
				labDetailedInstructorQualification.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labDetailedInstructorQualification.isNew()) {
				session.save(labDetailedInstructorQualification);

				labDetailedInstructorQualification.setNew(false);
			}
			else {
				labDetailedInstructorQualification = (labDetailedInstructorQualification)session.merge(labDetailedInstructorQualification);
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
				!labDetailedInstructorQualificationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedInstructorQualificationImpl.class,
			labDetailedInstructorQualification.getPrimaryKey(),
			labDetailedInstructorQualification, false);

		clearUniqueFindersCache(labDetailedInstructorQualificationModelImpl);
		cacheUniqueFindersCache(labDetailedInstructorQualificationModelImpl,
			isNew);

		labDetailedInstructorQualification.resetOriginalValues();

		return labDetailedInstructorQualification;
	}

	protected labDetailedInstructorQualification toUnwrappedModel(
		labDetailedInstructorQualification labDetailedInstructorQualification) {
		if (labDetailedInstructorQualification instanceof labDetailedInstructorQualificationImpl) {
			return labDetailedInstructorQualification;
		}

		labDetailedInstructorQualificationImpl labDetailedInstructorQualificationImpl =
			new labDetailedInstructorQualificationImpl();

		labDetailedInstructorQualificationImpl.setNew(labDetailedInstructorQualification.isNew());
		labDetailedInstructorQualificationImpl.setPrimaryKey(labDetailedInstructorQualification.getPrimaryKey());

		labDetailedInstructorQualificationImpl.setPK_courseInstructorQualificationId(labDetailedInstructorQualification.getPK_courseInstructorQualificationId());
		labDetailedInstructorQualificationImpl.setGroupId(labDetailedInstructorQualification.getGroupId());
		labDetailedInstructorQualificationImpl.setUserId(labDetailedInstructorQualification.getUserId());
		labDetailedInstructorQualificationImpl.setCreateDate(labDetailedInstructorQualification.getCreateDate());
		labDetailedInstructorQualificationImpl.setModifiedDate(labDetailedInstructorQualification.getModifiedDate());
		labDetailedInstructorQualificationImpl.setPK_projectId(labDetailedInstructorQualification.getPK_projectId());
		labDetailedInstructorQualificationImpl.setPK_courseId(labDetailedInstructorQualification.getPK_courseId());
		labDetailedInstructorQualificationImpl.setInstructor1Qualification(labDetailedInstructorQualification.getInstructor1Qualification());
		labDetailedInstructorQualificationImpl.setInstructor2Qualification(labDetailedInstructorQualification.getInstructor2Qualification());

		return labDetailedInstructorQualificationImpl;
	}

	/**
	 * Returns the lab detailed instructor qualification with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed instructor qualification
	 * @return the lab detailed instructor qualification
	 * @throws NoSuchlabDetailedInstructorQualificationException if a lab detailed instructor qualification with the primary key could not be found
	 */
	@Override
	public labDetailedInstructorQualification findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchlabDetailedInstructorQualificationException {
		labDetailedInstructorQualification labDetailedInstructorQualification = fetchByPrimaryKey(primaryKey);

		if (labDetailedInstructorQualification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabDetailedInstructorQualificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labDetailedInstructorQualification;
	}

	/**
	 * Returns the lab detailed instructor qualification with the primary key or throws a {@link NoSuchlabDetailedInstructorQualificationException} if it could not be found.
	 *
	 * @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	 * @return the lab detailed instructor qualification
	 * @throws NoSuchlabDetailedInstructorQualificationException if a lab detailed instructor qualification with the primary key could not be found
	 */
	@Override
	public labDetailedInstructorQualification findByPrimaryKey(
		long PK_courseInstructorQualificationId)
		throws NoSuchlabDetailedInstructorQualificationException {
		return findByPrimaryKey((Serializable)PK_courseInstructorQualificationId);
	}

	/**
	 * Returns the lab detailed instructor qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed instructor qualification
	 * @return the lab detailed instructor qualification, or <code>null</code> if a lab detailed instructor qualification with the primary key could not be found
	 */
	@Override
	public labDetailedInstructorQualification fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedInstructorQualificationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labDetailedInstructorQualification labDetailedInstructorQualification = (labDetailedInstructorQualification)serializable;

		if (labDetailedInstructorQualification == null) {
			Session session = null;

			try {
				session = openSession();

				labDetailedInstructorQualification = (labDetailedInstructorQualification)session.get(labDetailedInstructorQualificationImpl.class,
						primaryKey);

				if (labDetailedInstructorQualification != null) {
					cacheResult(labDetailedInstructorQualification);
				}
				else {
					entityCache.putResult(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedInstructorQualificationImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedInstructorQualificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labDetailedInstructorQualification;
	}

	/**
	 * Returns the lab detailed instructor qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_courseInstructorQualificationId the primary key of the lab detailed instructor qualification
	 * @return the lab detailed instructor qualification, or <code>null</code> if a lab detailed instructor qualification with the primary key could not be found
	 */
	@Override
	public labDetailedInstructorQualification fetchByPrimaryKey(
		long PK_courseInstructorQualificationId) {
		return fetchByPrimaryKey((Serializable)PK_courseInstructorQualificationId);
	}

	@Override
	public Map<Serializable, labDetailedInstructorQualification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labDetailedInstructorQualification> map = new HashMap<Serializable, labDetailedInstructorQualification>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labDetailedInstructorQualification labDetailedInstructorQualification =
				fetchByPrimaryKey(primaryKey);

			if (labDetailedInstructorQualification != null) {
				map.put(primaryKey, labDetailedInstructorQualification);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedInstructorQualificationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(labDetailedInstructorQualification)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABDETAILEDINSTRUCTORQUALIFICATION_WHERE_PKS_IN);

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

			for (labDetailedInstructorQualification labDetailedInstructorQualification : (List<labDetailedInstructorQualification>)q.list()) {
				map.put(labDetailedInstructorQualification.getPrimaryKeyObj(),
					labDetailedInstructorQualification);

				cacheResult(labDetailedInstructorQualification);

				uncachedPrimaryKeys.remove(labDetailedInstructorQualification.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labDetailedInstructorQualificationModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedInstructorQualificationImpl.class, primaryKey,
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
	 * Returns all the lab detailed instructor qualifications.
	 *
	 * @return the lab detailed instructor qualifications
	 */
	@Override
	public List<labDetailedInstructorQualification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab detailed instructor qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedInstructorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed instructor qualifications
	 * @param end the upper bound of the range of lab detailed instructor qualifications (not inclusive)
	 * @return the range of lab detailed instructor qualifications
	 */
	@Override
	public List<labDetailedInstructorQualification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab detailed instructor qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedInstructorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed instructor qualifications
	 * @param end the upper bound of the range of lab detailed instructor qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab detailed instructor qualifications
	 */
	@Override
	public List<labDetailedInstructorQualification> findAll(int start, int end,
		OrderByComparator<labDetailedInstructorQualification> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab detailed instructor qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedInstructorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed instructor qualifications
	 * @param end the upper bound of the range of lab detailed instructor qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab detailed instructor qualifications
	 */
	@Override
	public List<labDetailedInstructorQualification> findAll(int start, int end,
		OrderByComparator<labDetailedInstructorQualification> orderByComparator,
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

		List<labDetailedInstructorQualification> list = null;

		if (retrieveFromCache) {
			list = (List<labDetailedInstructorQualification>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABDETAILEDINSTRUCTORQUALIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABDETAILEDINSTRUCTORQUALIFICATION;

				if (pagination) {
					sql = sql.concat(labDetailedInstructorQualificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labDetailedInstructorQualification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labDetailedInstructorQualification>)QueryUtil.list(q,
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
	 * Removes all the lab detailed instructor qualifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labDetailedInstructorQualification labDetailedInstructorQualification : findAll()) {
			remove(labDetailedInstructorQualification);
		}
	}

	/**
	 * Returns the number of lab detailed instructor qualifications.
	 *
	 * @return the number of lab detailed instructor qualifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABDETAILEDINSTRUCTORQUALIFICATION);

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
		return labDetailedInstructorQualificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab detailed instructor qualification persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labDetailedInstructorQualificationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABDETAILEDINSTRUCTORQUALIFICATION = "SELECT labDetailedInstructorQualification FROM labDetailedInstructorQualification labDetailedInstructorQualification";
	private static final String _SQL_SELECT_LABDETAILEDINSTRUCTORQUALIFICATION_WHERE_PKS_IN =
		"SELECT labDetailedInstructorQualification FROM labDetailedInstructorQualification labDetailedInstructorQualification WHERE PK_courseInstructorQualificationId IN (";
	private static final String _SQL_SELECT_LABDETAILEDINSTRUCTORQUALIFICATION_WHERE =
		"SELECT labDetailedInstructorQualification FROM labDetailedInstructorQualification labDetailedInstructorQualification WHERE ";
	private static final String _SQL_COUNT_LABDETAILEDINSTRUCTORQUALIFICATION = "SELECT COUNT(labDetailedInstructorQualification) FROM labDetailedInstructorQualification labDetailedInstructorQualification";
	private static final String _SQL_COUNT_LABDETAILEDINSTRUCTORQUALIFICATION_WHERE =
		"SELECT COUNT(labDetailedInstructorQualification) FROM labDetailedInstructorQualification labDetailedInstructorQualification WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labDetailedInstructorQualification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labDetailedInstructorQualification exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No labDetailedInstructorQualification exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(labDetailedInstructorQualificationPersistenceImpl.class);
}