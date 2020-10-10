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

import com.collaborated.entity.exception.NoSuchlabScreenProjectPartnersException;
import com.collaborated.entity.model.impl.labScreenProjectPartnersImpl;
import com.collaborated.entity.model.impl.labScreenProjectPartnersModelImpl;
import com.collaborated.entity.model.labScreenProjectPartners;
import com.collaborated.entity.service.persistence.labScreenProjectPartnersPersistence;

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
 * The persistence implementation for the lab screen project partners service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see labScreenProjectPartnersPersistence
 * @see com.collaborated.entity.service.persistence.labScreenProjectPartnersUtil
 * @generated
 */
@ProviderType
public class labScreenProjectPartnersPersistenceImpl extends BasePersistenceImpl<labScreenProjectPartners>
	implements labScreenProjectPartnersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link labScreenProjectPartnersUtil} to access the lab screen project partners persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = labScreenProjectPartnersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectPartnersModelImpl.FINDER_CACHE_ENABLED,
			labScreenProjectPartnersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectPartnersModelImpl.FINDER_CACHE_ENABLED,
			labScreenProjectPartnersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectPartnersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public labScreenProjectPartnersPersistenceImpl() {
		setModelClass(labScreenProjectPartners.class);
	}

	/**
	 * Caches the lab screen project partners in the entity cache if it is enabled.
	 *
	 * @param labScreenProjectPartners the lab screen project partners
	 */
	@Override
	public void cacheResult(labScreenProjectPartners labScreenProjectPartners) {
		entityCache.putResult(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectPartnersImpl.class,
			labScreenProjectPartners.getPrimaryKey(), labScreenProjectPartners);

		labScreenProjectPartners.resetOriginalValues();
	}

	/**
	 * Caches the lab screen project partnerses in the entity cache if it is enabled.
	 *
	 * @param labScreenProjectPartnerses the lab screen project partnerses
	 */
	@Override
	public void cacheResult(
		List<labScreenProjectPartners> labScreenProjectPartnerses) {
		for (labScreenProjectPartners labScreenProjectPartners : labScreenProjectPartnerses) {
			if (entityCache.getResult(
						labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
						labScreenProjectPartnersImpl.class,
						labScreenProjectPartners.getPrimaryKey()) == null) {
				cacheResult(labScreenProjectPartners);
			}
			else {
				labScreenProjectPartners.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab screen project partnerses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(labScreenProjectPartnersImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab screen project partners.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(labScreenProjectPartners labScreenProjectPartners) {
		entityCache.removeResult(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectPartnersImpl.class,
			labScreenProjectPartners.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<labScreenProjectPartners> labScreenProjectPartnerses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (labScreenProjectPartners labScreenProjectPartners : labScreenProjectPartnerses) {
			entityCache.removeResult(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
				labScreenProjectPartnersImpl.class,
				labScreenProjectPartners.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lab screen project partners with the primary key. Does not add the lab screen project partners to the database.
	 *
	 * @param PK_projectPartnerId the primary key for the new lab screen project partners
	 * @return the new lab screen project partners
	 */
	@Override
	public labScreenProjectPartners create(long PK_projectPartnerId) {
		labScreenProjectPartners labScreenProjectPartners = new labScreenProjectPartnersImpl();

		labScreenProjectPartners.setNew(true);
		labScreenProjectPartners.setPrimaryKey(PK_projectPartnerId);

		return labScreenProjectPartners;
	}

	/**
	 * Removes the lab screen project partners with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_projectPartnerId the primary key of the lab screen project partners
	 * @return the lab screen project partners that was removed
	 * @throws NoSuchlabScreenProjectPartnersException if a lab screen project partners with the primary key could not be found
	 */
	@Override
	public labScreenProjectPartners remove(long PK_projectPartnerId)
		throws NoSuchlabScreenProjectPartnersException {
		return remove((Serializable)PK_projectPartnerId);
	}

	/**
	 * Removes the lab screen project partners with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab screen project partners
	 * @return the lab screen project partners that was removed
	 * @throws NoSuchlabScreenProjectPartnersException if a lab screen project partners with the primary key could not be found
	 */
	@Override
	public labScreenProjectPartners remove(Serializable primaryKey)
		throws NoSuchlabScreenProjectPartnersException {
		Session session = null;

		try {
			session = openSession();

			labScreenProjectPartners labScreenProjectPartners = (labScreenProjectPartners)session.get(labScreenProjectPartnersImpl.class,
					primaryKey);

			if (labScreenProjectPartners == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlabScreenProjectPartnersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labScreenProjectPartners);
		}
		catch (NoSuchlabScreenProjectPartnersException nsee) {
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
	protected labScreenProjectPartners removeImpl(
		labScreenProjectPartners labScreenProjectPartners) {
		labScreenProjectPartners = toUnwrappedModel(labScreenProjectPartners);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labScreenProjectPartners)) {
				labScreenProjectPartners = (labScreenProjectPartners)session.get(labScreenProjectPartnersImpl.class,
						labScreenProjectPartners.getPrimaryKeyObj());
			}

			if (labScreenProjectPartners != null) {
				session.delete(labScreenProjectPartners);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labScreenProjectPartners != null) {
			clearCache(labScreenProjectPartners);
		}

		return labScreenProjectPartners;
	}

	@Override
	public labScreenProjectPartners updateImpl(
		labScreenProjectPartners labScreenProjectPartners) {
		labScreenProjectPartners = toUnwrappedModel(labScreenProjectPartners);

		boolean isNew = labScreenProjectPartners.isNew();

		labScreenProjectPartnersModelImpl labScreenProjectPartnersModelImpl = (labScreenProjectPartnersModelImpl)labScreenProjectPartners;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labScreenProjectPartners.getCreateDate() == null)) {
			if (serviceContext == null) {
				labScreenProjectPartners.setCreateDate(now);
			}
			else {
				labScreenProjectPartners.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!labScreenProjectPartnersModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labScreenProjectPartners.setModifiedDate(now);
			}
			else {
				labScreenProjectPartners.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labScreenProjectPartners.isNew()) {
				session.save(labScreenProjectPartners);

				labScreenProjectPartners.setNew(false);
			}
			else {
				labScreenProjectPartners = (labScreenProjectPartners)session.merge(labScreenProjectPartners);
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

		entityCache.putResult(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
			labScreenProjectPartnersImpl.class,
			labScreenProjectPartners.getPrimaryKey(), labScreenProjectPartners,
			false);

		labScreenProjectPartners.resetOriginalValues();

		return labScreenProjectPartners;
	}

	protected labScreenProjectPartners toUnwrappedModel(
		labScreenProjectPartners labScreenProjectPartners) {
		if (labScreenProjectPartners instanceof labScreenProjectPartnersImpl) {
			return labScreenProjectPartners;
		}

		labScreenProjectPartnersImpl labScreenProjectPartnersImpl = new labScreenProjectPartnersImpl();

		labScreenProjectPartnersImpl.setNew(labScreenProjectPartners.isNew());
		labScreenProjectPartnersImpl.setPrimaryKey(labScreenProjectPartners.getPrimaryKey());

		labScreenProjectPartnersImpl.setPK_projectPartnerId(labScreenProjectPartners.getPK_projectPartnerId());
		labScreenProjectPartnersImpl.setGroupId(labScreenProjectPartners.getGroupId());
		labScreenProjectPartnersImpl.setUserId(labScreenProjectPartners.getUserId());
		labScreenProjectPartnersImpl.setCreateDate(labScreenProjectPartners.getCreateDate());
		labScreenProjectPartnersImpl.setModifiedDate(labScreenProjectPartners.getModifiedDate());
		labScreenProjectPartnersImpl.setPK_projectId(labScreenProjectPartners.getPK_projectId());
		labScreenProjectPartnersImpl.setProjectPartnerId(labScreenProjectPartners.getProjectPartnerId());
		labScreenProjectPartnersImpl.setIsActive(labScreenProjectPartners.getIsActive());

		return labScreenProjectPartnersImpl;
	}

	/**
	 * Returns the lab screen project partners with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab screen project partners
	 * @return the lab screen project partners
	 * @throws NoSuchlabScreenProjectPartnersException if a lab screen project partners with the primary key could not be found
	 */
	@Override
	public labScreenProjectPartners findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlabScreenProjectPartnersException {
		labScreenProjectPartners labScreenProjectPartners = fetchByPrimaryKey(primaryKey);

		if (labScreenProjectPartners == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlabScreenProjectPartnersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labScreenProjectPartners;
	}

	/**
	 * Returns the lab screen project partners with the primary key or throws a {@link NoSuchlabScreenProjectPartnersException} if it could not be found.
	 *
	 * @param PK_projectPartnerId the primary key of the lab screen project partners
	 * @return the lab screen project partners
	 * @throws NoSuchlabScreenProjectPartnersException if a lab screen project partners with the primary key could not be found
	 */
	@Override
	public labScreenProjectPartners findByPrimaryKey(long PK_projectPartnerId)
		throws NoSuchlabScreenProjectPartnersException {
		return findByPrimaryKey((Serializable)PK_projectPartnerId);
	}

	/**
	 * Returns the lab screen project partners with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab screen project partners
	 * @return the lab screen project partners, or <code>null</code> if a lab screen project partners with the primary key could not be found
	 */
	@Override
	public labScreenProjectPartners fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
				labScreenProjectPartnersImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		labScreenProjectPartners labScreenProjectPartners = (labScreenProjectPartners)serializable;

		if (labScreenProjectPartners == null) {
			Session session = null;

			try {
				session = openSession();

				labScreenProjectPartners = (labScreenProjectPartners)session.get(labScreenProjectPartnersImpl.class,
						primaryKey);

				if (labScreenProjectPartners != null) {
					cacheResult(labScreenProjectPartners);
				}
				else {
					entityCache.putResult(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
						labScreenProjectPartnersImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
					labScreenProjectPartnersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labScreenProjectPartners;
	}

	/**
	 * Returns the lab screen project partners with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_projectPartnerId the primary key of the lab screen project partners
	 * @return the lab screen project partners, or <code>null</code> if a lab screen project partners with the primary key could not be found
	 */
	@Override
	public labScreenProjectPartners fetchByPrimaryKey(long PK_projectPartnerId) {
		return fetchByPrimaryKey((Serializable)PK_projectPartnerId);
	}

	@Override
	public Map<Serializable, labScreenProjectPartners> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, labScreenProjectPartners> map = new HashMap<Serializable, labScreenProjectPartners>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			labScreenProjectPartners labScreenProjectPartners = fetchByPrimaryKey(primaryKey);

			if (labScreenProjectPartners != null) {
				map.put(primaryKey, labScreenProjectPartners);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
					labScreenProjectPartnersImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (labScreenProjectPartners)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABSCREENPROJECTPARTNERS_WHERE_PKS_IN);

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

			for (labScreenProjectPartners labScreenProjectPartners : (List<labScreenProjectPartners>)q.list()) {
				map.put(labScreenProjectPartners.getPrimaryKeyObj(),
					labScreenProjectPartners);

				cacheResult(labScreenProjectPartners);

				uncachedPrimaryKeys.remove(labScreenProjectPartners.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(labScreenProjectPartnersModelImpl.ENTITY_CACHE_ENABLED,
					labScreenProjectPartnersImpl.class, primaryKey, nullModel);
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
	 * Returns all the lab screen project partnerses.
	 *
	 * @return the lab screen project partnerses
	 */
	@Override
	public List<labScreenProjectPartners> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lab screen project partnerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectPartnersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab screen project partnerses
	 * @param end the upper bound of the range of lab screen project partnerses (not inclusive)
	 * @return the range of lab screen project partnerses
	 */
	@Override
	public List<labScreenProjectPartners> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lab screen project partnerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectPartnersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab screen project partnerses
	 * @param end the upper bound of the range of lab screen project partnerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lab screen project partnerses
	 */
	@Override
	public List<labScreenProjectPartners> findAll(int start, int end,
		OrderByComparator<labScreenProjectPartners> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lab screen project partnerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link labScreenProjectPartnersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lab screen project partnerses
	 * @param end the upper bound of the range of lab screen project partnerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lab screen project partnerses
	 */
	@Override
	public List<labScreenProjectPartners> findAll(int start, int end,
		OrderByComparator<labScreenProjectPartners> orderByComparator,
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

		List<labScreenProjectPartners> list = null;

		if (retrieveFromCache) {
			list = (List<labScreenProjectPartners>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABSCREENPROJECTPARTNERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABSCREENPROJECTPARTNERS;

				if (pagination) {
					sql = sql.concat(labScreenProjectPartnersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<labScreenProjectPartners>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<labScreenProjectPartners>)QueryUtil.list(q,
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
	 * Removes all the lab screen project partnerses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (labScreenProjectPartners labScreenProjectPartners : findAll()) {
			remove(labScreenProjectPartners);
		}
	}

	/**
	 * Returns the number of lab screen project partnerses.
	 *
	 * @return the number of lab screen project partnerses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABSCREENPROJECTPARTNERS);

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
		return labScreenProjectPartnersModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab screen project partners persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(labScreenProjectPartnersImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABSCREENPROJECTPARTNERS = "SELECT labScreenProjectPartners FROM labScreenProjectPartners labScreenProjectPartners";
	private static final String _SQL_SELECT_LABSCREENPROJECTPARTNERS_WHERE_PKS_IN =
		"SELECT labScreenProjectPartners FROM labScreenProjectPartners labScreenProjectPartners WHERE PK_projectPartnerId IN (";
	private static final String _SQL_COUNT_LABSCREENPROJECTPARTNERS = "SELECT COUNT(labScreenProjectPartners) FROM labScreenProjectPartners labScreenProjectPartners";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labScreenProjectPartners.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No labScreenProjectPartners exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(labScreenProjectPartnersPersistenceImpl.class);
}