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

import com.collaborated.entity.exception.NoSuchlabDetailedCourseIdentificationException;
import com.collaborated.entity.model.impl.labDetailedCourseIdentificationImpl;
import com.collaborated.entity.model.impl.labDetailedCourseIdentificationModelImpl;
import com.collaborated.entity.model.labDetailedCourseIdentification;
import com.collaborated.entity.service.persistence.labDetailedCourseIdentificationPersistence;

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
 * The persistence implementation for the lab detailed course identification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labDetailedCourseIdentificationPersistence
 * @see com.collaborated.entity.service.persistence.labDetailedCourseIdentificationUtil
 * @generated
 */
@ProviderType
public class labDetailedCourseIdentificationPersistenceImpl
	extends BasePersistenceImpl<labDetailedCourseIdentification>
	implements labDetailedCourseIdentificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labDetailedCourseIdentificationUtil} to access the lab detailed course identification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labDetailedCourseIdentificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseIdentificationModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseIdentificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseIdentificationModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseIdentificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseIdentificationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID =
		new FinderPath(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseIdentificationModelImpl.FINDER_CACHE_ENABLED,
			labDetailedCourseIdentificationImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByfetchCourseIdentificationbyProjectId",
			new String[] { Long.class.getName() },
			labDetailedCourseIdentificationModelImpl.PK_PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID =
		new FinderPath(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseIdentificationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfetchCourseIdentificationbyProjectId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the lab detailed course identification where PK_projectId = &#63; or throws a {@link NoSuchlabDetailedCourseIdentificationException} if it could not be found.
	 *
	 * @param PK_projectId the p k_project ID
	 * @return the matching lab detailed course identification
	 * @throws NoSuchlabDetailedCourseIdentificationException if a matching lab detailed course identification could not be found
	 */
	@Override
	public labDetailedCourseIdentification findByfetchCourseIdentificationbyProjectId(
		long PK_projectId)
		throws NoSuchlabDetailedCourseIdentificationException {
		labDetailedCourseIdentification labDetailedCourseIdentification = fetchByfetchCourseIdentificationbyProjectId(PK_projectId);

		if (labDetailedCourseIdentification == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PK_projectId=");
			msg.append(PK_projectId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchlabDetailedCourseIdentificationException(msg.toString());
		}

		return labDetailedCourseIdentification;
	}

	/**
	 * Returns the lab detailed course identification where PK_projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PK_projectId the p k_project ID
	 * @return the matching lab detailed course identification, or <code>null</code> if a matching lab detailed course identification could not be found
	 */
	@Override
	public labDetailedCourseIdentification fetchByfetchCourseIdentificationbyProjectId(
		long PK_projectId) {
		return fetchByfetchCourseIdentificationbyProjectId(PK_projectId, true);
	}

	/**
	 * Returns the lab detailed course identification where PK_projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PK_projectId the p k_project ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lab detailed course identification, or <code>null</code> if a matching lab detailed course identification could not be found
	 */
	@Override
	public labDetailedCourseIdentification fetchByfetchCourseIdentificationbyProjectId(
		long PK_projectId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PK_projectId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
					finderArgs, this);
		}

		if (result instanceof labDetailedCourseIdentification) {
			labDetailedCourseIdentification labDetailedCourseIdentification = (labDetailedCourseIdentification)result;

			if ((PK_projectId != labDetailedCourseIdentification.getPK_projectId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LABDETAILEDCOURSEIDENTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_FETCHCOURSEIDENTIFICATIONBYPROJECTID_PK_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PK_projectId);

				List<labDetailedCourseIdentification> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
						finderArgs, list);
				}
				else {
					labDetailedCourseIdentification labDetailedCourseIdentification =
						list.get(0);

					result = labDetailedCourseIdentification;

					cacheResult(labDetailedCourseIdentification);

					if ((labDetailedCourseIdentification.getPK_projectId() != PK_projectId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
							finderArgs, labDetailedCourseIdentification);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
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
			return (labDetailedCourseIdentification)result;
		}
	}

	/**
	 * Removes the lab detailed course identification where PK_projectId = &#63; from the database.
	 *
	 * @param PK_projectId the p k_project ID
	 * @return the lab detailed course identification that was removed
	 */
	@Override
	public labDetailedCourseIdentification removeByfetchCourseIdentificationbyProjectId(
		long PK_projectId)
		throws NoSuchlabDetailedCourseIdentificationException {
		labDetailedCourseIdentification labDetailedCourseIdentification = findByfetchCourseIdentificationbyProjectId(PK_projectId);

		return remove(labDetailedCourseIdentification);
	}

	/**
	 * Returns the number of lab detailed course identifications where PK_projectId = &#63;.
	 *
	 * @param PK_projectId the p k_project ID
	 * @return the number of matching lab detailed course identifications
	 */
	@Override
	public int countByfetchCourseIdentificationbyProjectId(long PK_projectId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID;

		Object[] finderArgs = new Object[] { PK_projectId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LABDETAILEDCOURSEIDENTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_FETCHCOURSEIDENTIFICATIONBYPROJECTID_PK_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PK_projectId);

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

	private static final String _FINDER_COLUMN_FETCHCOURSEIDENTIFICATIONBYPROJECTID_PK_PROJECTID_2 =
		"labDetailedCourseIdentification.PK_projectId = ?";

	public labDetailedCourseIdentificationPersistenceImpl() {
		setModelClass(labDetailedCourseIdentification.class);
	}

	/**
	 * Caches the lab detailed course identification in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseIdentification the lab detailed course identification
	 */
	@Override
	public void cacheResult(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		entityCache.putResult(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseIdentificationImpl.class,
			labDetailedCourseIdentification.getPrimaryKey(),
			labDetailedCourseIdentification);

		finderCache.putResult(FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
			new Object[] { labDetailedCourseIdentification.getPK_projectId() },
			labDetailedCourseIdentification);

		labDetailedCourseIdentification.resetOriginalValues();
	}

	/**
	 * Caches the lab detailed course identifications in the entity cache if it is enabled.
	 *
	 * @param labDetailedCourseIdentifications the lab detailed course identifications
	 */
	@Override
	public void cacheResult(
		List<labDetailedCourseIdentification> labDetailedCourseIdentifications) {
		for (labDetailedCourseIdentification labDetailedCourseIdentification : labDetailedCourseIdentifications) {
			if (entityCache.getResult(
						labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseIdentificationImpl.class,
						labDetailedCourseIdentification.getPrimaryKey()) == null) {
				cacheResult(labDetailedCourseIdentification);
			}
			else {
				labDetailedCourseIdentification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab detailed course identifications.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labDetailedCourseIdentificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab detailed course identification.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		entityCache.removeResult(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseIdentificationImpl.class,
			labDetailedCourseIdentification.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((labDetailedCourseIdentificationModelImpl)labDetailedCourseIdentification);
	}

	@Override
	public void clearCache(
		List<labDetailedCourseIdentification> labDetailedCourseIdentifications) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labDetailedCourseIdentification labDetailedCourseIdentification : labDetailedCourseIdentifications) {
			entityCache.removeResult(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseIdentificationImpl.class,
				labDetailedCourseIdentification.getPrimaryKey());

			clearUniqueFindersCache((labDetailedCourseIdentificationModelImpl)labDetailedCourseIdentification);
		}
	}

	protected void cacheUniqueFindersCache(
		labDetailedCourseIdentificationModelImpl labDetailedCourseIdentificationModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					labDetailedCourseIdentificationModelImpl.getPK_projectId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
				args, labDetailedCourseIdentificationModelImpl);
		}
		else {
			if ((labDetailedCourseIdentificationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						labDetailedCourseIdentificationModelImpl.getPK_projectId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
					args, labDetailedCourseIdentificationModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		labDetailedCourseIdentificationModelImpl labDetailedCourseIdentificationModelImpl) {
		Object[] args = new Object[] {
				labDetailedCourseIdentificationModelImpl.getPK_projectId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
			args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
			args);

		if ((labDetailedCourseIdentificationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					labDetailedCourseIdentificationModelImpl.getOriginalPK_projectId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_FETCHCOURSEIDENTIFICATIONBYPROJECTID,
				args);
		}
	}

	/**
	 * Creates a new lab detailed course identification with the primary key. Does not add the lab detailed course identification to the database.
	 *
	 * @param PK_courseId the primary key for the new lab detailed course identification
	 * @return the new lab detailed course identification
	 */
	@Override
	public labDetailedCourseIdentification create(long PK_courseId) {
		labDetailedCourseIdentification labDetailedCourseIdentification = new labDetailedCourseIdentificationImpl();

		labDetailedCourseIdentification.setNew(true);
		labDetailedCourseIdentification.setPrimaryKey(PK_courseId);

		return labDetailedCourseIdentification;
	}

	/**
	 * Removes the lab detailed course identification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_courseId the primary key of the lab detailed course identification
	 * @return the lab detailed course identification that was removed
	 * @throws NoSuchlabDetailedCourseIdentificationException if a lab detailed course identification with the primary key could not be found
	 */
	@Override
	public labDetailedCourseIdentification remove(long PK_courseId)
		throws NoSuchlabDetailedCourseIdentificationException {
		return remove((Serializable)PK_courseId);
	}

	/**
	 * Removes the lab detailed course identification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab detailed course identification
	 * @return the lab detailed course identification that was removed
	 * @throws NoSuchlabDetailedCourseIdentificationException if a lab detailed course identification with the primary key could not be found
	 */
	@Override
	public labDetailedCourseIdentification remove(Serializable primaryKey)
		throws NoSuchlabDetailedCourseIdentificationException {
		Session session = null;

		try {
			session = openSession();

			labDetailedCourseIdentification labDetailedCourseIdentification = (labDetailedCourseIdentification)session.get(labDetailedCourseIdentificationImpl.class,
					primaryKey);

			if (labDetailedCourseIdentification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabDetailedCourseIdentificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labDetailedCourseIdentification);
		}
		catch (NoSuchlabDetailedCourseIdentificationException nsee) {
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
	protected labDetailedCourseIdentification removeImpl(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		labDetailedCourseIdentification = toUnwrappedModel(labDetailedCourseIdentification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labDetailedCourseIdentification)) {
				labDetailedCourseIdentification = (labDetailedCourseIdentification)session.get(labDetailedCourseIdentificationImpl.class,
						labDetailedCourseIdentification.getPrimaryKeyObj());
			}

			if (labDetailedCourseIdentification != null) {
				session.delete(labDetailedCourseIdentification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labDetailedCourseIdentification != null) {
			clearCache(labDetailedCourseIdentification);
		}

		return labDetailedCourseIdentification;
	}

	@Override
	public labDetailedCourseIdentification updateImpl(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		labDetailedCourseIdentification = toUnwrappedModel(labDetailedCourseIdentification);

		boolean isNew = labDetailedCourseIdentification.isNew();

		labDetailedCourseIdentificationModelImpl labDetailedCourseIdentificationModelImpl =
			(labDetailedCourseIdentificationModelImpl)labDetailedCourseIdentification;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labDetailedCourseIdentification.getCreateDate() == null)) {
			if (serviceContext == null) {
				labDetailedCourseIdentification.setCreateDate(now);
			}
			else {
				labDetailedCourseIdentification.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labDetailedCourseIdentificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labDetailedCourseIdentification.setModifiedDate(now);
			}
			else {
				labDetailedCourseIdentification.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labDetailedCourseIdentification.isNew()) {
				session.save(labDetailedCourseIdentification);

				labDetailedCourseIdentification.setNew(false);
			}
			else {
				labDetailedCourseIdentification = (labDetailedCourseIdentification)session.merge(labDetailedCourseIdentification);
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
				!labDetailedCourseIdentificationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
			labDetailedCourseIdentificationImpl.class,
			labDetailedCourseIdentification.getPrimaryKey(),
			labDetailedCourseIdentification, false);

		clearUniqueFindersCache(labDetailedCourseIdentificationModelImpl);
		cacheUniqueFindersCache(labDetailedCourseIdentificationModelImpl, isNew);

		labDetailedCourseIdentification.resetOriginalValues();

		return labDetailedCourseIdentification;
	}

	protected labDetailedCourseIdentification toUnwrappedModel(
		labDetailedCourseIdentification labDetailedCourseIdentification) {
		if (labDetailedCourseIdentification instanceof labDetailedCourseIdentificationImpl) {
			return labDetailedCourseIdentification;
		}

		labDetailedCourseIdentificationImpl labDetailedCourseIdentificationImpl = new labDetailedCourseIdentificationImpl();

		labDetailedCourseIdentificationImpl.setNew(labDetailedCourseIdentification.isNew());
		labDetailedCourseIdentificationImpl.setPrimaryKey(labDetailedCourseIdentification.getPrimaryKey());

		labDetailedCourseIdentificationImpl.setPK_courseId(labDetailedCourseIdentification.getPK_courseId());
		labDetailedCourseIdentificationImpl.setGroupId(labDetailedCourseIdentification.getGroupId());
		labDetailedCourseIdentificationImpl.setUserId(labDetailedCourseIdentification.getUserId());
		labDetailedCourseIdentificationImpl.setCreateDate(labDetailedCourseIdentification.getCreateDate());
		labDetailedCourseIdentificationImpl.setModifiedDate(labDetailedCourseIdentification.getModifiedDate());
		labDetailedCourseIdentificationImpl.setPK_projectId(labDetailedCourseIdentification.getPK_projectId());
		labDetailedCourseIdentificationImpl.setCourseTitle(labDetailedCourseIdentification.getCourseTitle());
		labDetailedCourseIdentificationImpl.setCourseNumber(labDetailedCourseIdentification.getCourseNumber());
		labDetailedCourseIdentificationImpl.setPrerequisites(labDetailedCourseIdentification.getPrerequisites());
		labDetailedCourseIdentificationImpl.setCourseDescription(labDetailedCourseIdentification.getCourseDescription());

		return labDetailedCourseIdentificationImpl;
	}

	/**
	 * Returns the lab detailed course identification with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course identification
	 * @return the lab detailed course identification
	 * @throws NoSuchlabDetailedCourseIdentificationException if a lab detailed course identification with the primary key could not be found
	 */
	@Override
	public labDetailedCourseIdentification findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchlabDetailedCourseIdentificationException {
		labDetailedCourseIdentification labDetailedCourseIdentification = fetchByPrimaryKey(primaryKey);

		if (labDetailedCourseIdentification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabDetailedCourseIdentificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labDetailedCourseIdentification;
	}

	/**
	 * Returns the lab detailed course identification with the primary key or throws a {@link NoSuchlabDetailedCourseIdentificationException} if it could not be found.
	 *
	 * @param PK_courseId the primary key of the lab detailed course identification
	 * @return the lab detailed course identification
	 * @throws NoSuchlabDetailedCourseIdentificationException if a lab detailed course identification with the primary key could not be found
	 */
	@Override
	public labDetailedCourseIdentification findByPrimaryKey(long PK_courseId)
		throws NoSuchlabDetailedCourseIdentificationException {
		return findByPrimaryKey((Serializable)PK_courseId);
	}

	/**
	 * Returns the lab detailed course identification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab detailed course identification
	 * @return the lab detailed course identification, or <code>null</code> if a lab detailed course identification with the primary key could not be found
	 */
	@Override
	public labDetailedCourseIdentification fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
				labDetailedCourseIdentificationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labDetailedCourseIdentification labDetailedCourseIdentification = (labDetailedCourseIdentification)serializable;

		if (labDetailedCourseIdentification == null) {
			Session session = null;

			try {
				session = openSession();

				labDetailedCourseIdentification = (labDetailedCourseIdentification)session.get(labDetailedCourseIdentificationImpl.class,
						primaryKey);

				if (labDetailedCourseIdentification != null) {
					cacheResult(labDetailedCourseIdentification);
				}
				else {
					entityCache.putResult(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
						labDetailedCourseIdentificationImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseIdentificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labDetailedCourseIdentification;
	}

	/**
	 * Returns the lab detailed course identification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_courseId the primary key of the lab detailed course identification
	 * @return the lab detailed course identification, or <code>null</code> if a lab detailed course identification with the primary key could not be found
	 */
	@Override
	public labDetailedCourseIdentification fetchByPrimaryKey(long PK_courseId) {
		return fetchByPrimaryKey((Serializable)PK_courseId);
	}

	@Override
	public Map<Serializable, labDetailedCourseIdentification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labDetailedCourseIdentification> map = new HashMap<Serializable, labDetailedCourseIdentification>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labDetailedCourseIdentification labDetailedCourseIdentification = fetchByPrimaryKey(primaryKey);

			if (labDetailedCourseIdentification != null) {
				map.put(primaryKey, labDetailedCourseIdentification);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseIdentificationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(labDetailedCourseIdentification)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABDETAILEDCOURSEIDENTIFICATION_WHERE_PKS_IN);

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

			for (labDetailedCourseIdentification labDetailedCourseIdentification : (List<labDetailedCourseIdentification>)q.list()) {
				map.put(labDetailedCourseIdentification.getPrimaryKeyObj(),
					labDetailedCourseIdentification);

				cacheResult(labDetailedCourseIdentification);

				uncachedPrimaryKeys.remove(labDetailedCourseIdentification.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labDetailedCourseIdentificationModelImpl.ENTITY_CACHE_ENABLED,
					labDetailedCourseIdentificationImpl.class, primaryKey,
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
	 * Returns all the lab detailed course identifications.
	 *
	 * @return the lab detailed course identifications
	 */
	@Override
	public List<labDetailedCourseIdentification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab detailed course identifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseIdentificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course identifications
	 * @param end the upper bound of the range of lab detailed course identifications (not inclusive)
	 * @return the range of lab detailed course identifications
	 */
	@Override
	public List<labDetailedCourseIdentification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab detailed course identifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseIdentificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course identifications
	 * @param end the upper bound of the range of lab detailed course identifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab detailed course identifications
	 */
	@Override
	public List<labDetailedCourseIdentification> findAll(int start, int end,
		OrderByComparator<labDetailedCourseIdentification> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab detailed course identifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labDetailedCourseIdentificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab detailed course identifications
	 * @param end the upper bound of the range of lab detailed course identifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab detailed course identifications
	 */
	@Override
	public List<labDetailedCourseIdentification> findAll(int start, int end,
		OrderByComparator<labDetailedCourseIdentification> orderByComparator,
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

		List<labDetailedCourseIdentification> list = null;

		if (retrieveFromCache) {
			list = (List<labDetailedCourseIdentification>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABDETAILEDCOURSEIDENTIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABDETAILEDCOURSEIDENTIFICATION;

				if (pagination) {
					sql = sql.concat(labDetailedCourseIdentificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labDetailedCourseIdentification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labDetailedCourseIdentification>)QueryUtil.list(q,
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
	 * Removes all the lab detailed course identifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labDetailedCourseIdentification labDetailedCourseIdentification : findAll()) {
			remove(labDetailedCourseIdentification);
		}
	}

	/**
	 * Returns the number of lab detailed course identifications.
	 *
	 * @return the number of lab detailed course identifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABDETAILEDCOURSEIDENTIFICATION);

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
		return labDetailedCourseIdentificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab detailed course identification persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labDetailedCourseIdentificationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABDETAILEDCOURSEIDENTIFICATION = "SELECT labDetailedCourseIdentification FROM labDetailedCourseIdentification labDetailedCourseIdentification";
	private static final String _SQL_SELECT_LABDETAILEDCOURSEIDENTIFICATION_WHERE_PKS_IN =
		"SELECT labDetailedCourseIdentification FROM labDetailedCourseIdentification labDetailedCourseIdentification WHERE PK_courseId IN (";
	private static final String _SQL_SELECT_LABDETAILEDCOURSEIDENTIFICATION_WHERE =
		"SELECT labDetailedCourseIdentification FROM labDetailedCourseIdentification labDetailedCourseIdentification WHERE ";
	private static final String _SQL_COUNT_LABDETAILEDCOURSEIDENTIFICATION = "SELECT COUNT(labDetailedCourseIdentification) FROM labDetailedCourseIdentification labDetailedCourseIdentification";
	private static final String _SQL_COUNT_LABDETAILEDCOURSEIDENTIFICATION_WHERE =
		"SELECT COUNT(labDetailedCourseIdentification) FROM labDetailedCourseIdentification labDetailedCourseIdentification WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labDetailedCourseIdentification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labDetailedCourseIdentification exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No labDetailedCourseIdentification exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(labDetailedCourseIdentificationPersistenceImpl.class);
}