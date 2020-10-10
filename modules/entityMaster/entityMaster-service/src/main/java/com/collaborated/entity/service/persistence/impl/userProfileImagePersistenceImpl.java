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

import com.collaborated.entity.exception.NoSuchuserProfileImageException;
import com.collaborated.entity.model.impl.userProfileImageImpl;
import com.collaborated.entity.model.impl.userProfileImageModelImpl;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.persistence.userProfileImagePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the user profile image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userProfileImagePersistence
 * @see com.collaborated.entity.service.persistence.userProfileImageUtil
 * @generated
 */
@ProviderType
public class userProfileImagePersistenceImpl extends BasePersistenceImpl<userProfileImage>
	implements userProfileImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link userProfileImageUtil} to access the user profile image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = userProfileImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
			userProfileImageModelImpl.FINDER_CACHE_ENABLED,
			userProfileImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
			userProfileImageModelImpl.FINDER_CACHE_ENABLED,
			userProfileImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
			userProfileImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public userProfileImagePersistenceImpl() {
		setModelClass(userProfileImage.class);
	}

	/**
	 * Caches the user profile image in the entity cache if it is enabled.
	 *
	 * @param userProfileImage the user profile image
	 */
	@Override
	public void cacheResult(userProfileImage userProfileImage) {
		entityCache.putResult(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
			userProfileImageImpl.class, userProfileImage.getPrimaryKey(),
			userProfileImage);

		userProfileImage.resetOriginalValues();
	}

	/**
	 * Caches the user profile images in the entity cache if it is enabled.
	 *
	 * @param userProfileImages the user profile images
	 */
	@Override
	public void cacheResult(List<userProfileImage> userProfileImages) {
		for (userProfileImage userProfileImage : userProfileImages) {
			if (entityCache.getResult(
						userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
						userProfileImageImpl.class,
						userProfileImage.getPrimaryKey()) == null) {
				cacheResult(userProfileImage);
			}
			else {
				userProfileImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user profile images.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(userProfileImageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user profile image.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(userProfileImage userProfileImage) {
		entityCache.removeResult(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
			userProfileImageImpl.class, userProfileImage.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<userProfileImage> userProfileImages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (userProfileImage userProfileImage : userProfileImages) {
			entityCache.removeResult(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
				userProfileImageImpl.class, userProfileImage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user profile image with the primary key. Does not add the user profile image to the database.
	 *
	 * @param PK_profileImageId the primary key for the new user profile image
	 * @return the new user profile image
	 */
	@Override
	public userProfileImage create(long PK_profileImageId) {
		userProfileImage userProfileImage = new userProfileImageImpl();

		userProfileImage.setNew(true);
		userProfileImage.setPrimaryKey(PK_profileImageId);

		return userProfileImage;
	}

	/**
	 * Removes the user profile image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_profileImageId the primary key of the user profile image
	 * @return the user profile image that was removed
	 * @throws NoSuchuserProfileImageException if a user profile image with the primary key could not be found
	 */
	@Override
	public userProfileImage remove(long PK_profileImageId)
		throws NoSuchuserProfileImageException {
		return remove((Serializable)PK_profileImageId);
	}

	/**
	 * Removes the user profile image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user profile image
	 * @return the user profile image that was removed
	 * @throws NoSuchuserProfileImageException if a user profile image with the primary key could not be found
	 */
	@Override
	public userProfileImage remove(Serializable primaryKey)
		throws NoSuchuserProfileImageException {
		Session session = null;

		try {
			session = openSession();

			userProfileImage userProfileImage = (userProfileImage)session.get(userProfileImageImpl.class,
					primaryKey);

			if (userProfileImage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchuserProfileImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userProfileImage);
		}
		catch (NoSuchuserProfileImageException nsee) {
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
	protected userProfileImage removeImpl(userProfileImage userProfileImage) {
		userProfileImage = toUnwrappedModel(userProfileImage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userProfileImage)) {
				userProfileImage = (userProfileImage)session.get(userProfileImageImpl.class,
						userProfileImage.getPrimaryKeyObj());
			}

			if (userProfileImage != null) {
				session.delete(userProfileImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userProfileImage != null) {
			clearCache(userProfileImage);
		}

		return userProfileImage;
	}

	@Override
	public userProfileImage updateImpl(userProfileImage userProfileImage) {
		userProfileImage = toUnwrappedModel(userProfileImage);

		boolean isNew = userProfileImage.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userProfileImage.isNew()) {
				session.save(userProfileImage);

				userProfileImage.setNew(false);
			}
			else {
				session.evict(userProfileImage);
				session.saveOrUpdate(userProfileImage);
			}

			session.flush();
			session.clear();
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

		entityCache.putResult(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
			userProfileImageImpl.class, userProfileImage.getPrimaryKey(),
			userProfileImage, false);

		userProfileImage.resetOriginalValues();

		return userProfileImage;
	}

	protected userProfileImage toUnwrappedModel(
		userProfileImage userProfileImage) {
		if (userProfileImage instanceof userProfileImageImpl) {
			return userProfileImage;
		}

		userProfileImageImpl userProfileImageImpl = new userProfileImageImpl();

		userProfileImageImpl.setNew(userProfileImage.isNew());
		userProfileImageImpl.setPrimaryKey(userProfileImage.getPrimaryKey());

		userProfileImageImpl.setPK_profileImageId(userProfileImage.getPK_profileImageId());
		userProfileImageImpl.setGroupId(userProfileImage.getGroupId());
		userProfileImageImpl.setCreatedOn(userProfileImage.getCreatedOn());
		userProfileImageImpl.setUserId(userProfileImage.getUserId());
		userProfileImageImpl.setFileEntryId(userProfileImage.getFileEntryId());
		userProfileImageImpl.setFileEntryUrl(userProfileImage.getFileEntryUrl());
		userProfileImageImpl.setBlobData(userProfileImage.getBlobData());

		return userProfileImageImpl;
	}

	/**
	 * Returns the user profile image with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user profile image
	 * @return the user profile image
	 * @throws NoSuchuserProfileImageException if a user profile image with the primary key could not be found
	 */
	@Override
	public userProfileImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchuserProfileImageException {
		userProfileImage userProfileImage = fetchByPrimaryKey(primaryKey);

		if (userProfileImage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchuserProfileImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userProfileImage;
	}

	/**
	 * Returns the user profile image with the primary key or throws a {@link NoSuchuserProfileImageException} if it could not be found.
	 *
	 * @param PK_profileImageId the primary key of the user profile image
	 * @return the user profile image
	 * @throws NoSuchuserProfileImageException if a user profile image with the primary key could not be found
	 */
	@Override
	public userProfileImage findByPrimaryKey(long PK_profileImageId)
		throws NoSuchuserProfileImageException {
		return findByPrimaryKey((Serializable)PK_profileImageId);
	}

	/**
	 * Returns the user profile image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user profile image
	 * @return the user profile image, or <code>null</code> if a user profile image with the primary key could not be found
	 */
	@Override
	public userProfileImage fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
				userProfileImageImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		userProfileImage userProfileImage = (userProfileImage)serializable;

		if (userProfileImage == null) {
			Session session = null;

			try {
				session = openSession();

				userProfileImage = (userProfileImage)session.get(userProfileImageImpl.class,
						primaryKey);

				if (userProfileImage != null) {
					cacheResult(userProfileImage);
				}
				else {
					entityCache.putResult(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
						userProfileImageImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
					userProfileImageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userProfileImage;
	}

	/**
	 * Returns the user profile image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PK_profileImageId the primary key of the user profile image
	 * @return the user profile image, or <code>null</code> if a user profile image with the primary key could not be found
	 */
	@Override
	public userProfileImage fetchByPrimaryKey(long PK_profileImageId) {
		return fetchByPrimaryKey((Serializable)PK_profileImageId);
	}

	@Override
	public Map<Serializable, userProfileImage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, userProfileImage> map = new HashMap<Serializable, userProfileImage>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			userProfileImage userProfileImage = fetchByPrimaryKey(primaryKey);

			if (userProfileImage != null) {
				map.put(primaryKey, userProfileImage);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
					userProfileImageImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (userProfileImage)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERPROFILEIMAGE_WHERE_PKS_IN);

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

			for (userProfileImage userProfileImage : (List<userProfileImage>)q.list()) {
				map.put(userProfileImage.getPrimaryKeyObj(), userProfileImage);

				cacheResult(userProfileImage);

				uncachedPrimaryKeys.remove(userProfileImage.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(userProfileImageModelImpl.ENTITY_CACHE_ENABLED,
					userProfileImageImpl.class, primaryKey, nullModel);
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
	 * Returns all the user profile images.
	 *
	 * @return the user profile images
	 */
	@Override
	public List<userProfileImage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user profile images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfileImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user profile images
	 * @param end the upper bound of the range of user profile images (not inclusive)
	 * @return the range of user profile images
	 */
	@Override
	public List<userProfileImage> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user profile images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfileImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user profile images
	 * @param end the upper bound of the range of user profile images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user profile images
	 */
	@Override
	public List<userProfileImage> findAll(int start, int end,
		OrderByComparator<userProfileImage> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user profile images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link userProfileImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user profile images
	 * @param end the upper bound of the range of user profile images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user profile images
	 */
	@Override
	public List<userProfileImage> findAll(int start, int end,
		OrderByComparator<userProfileImage> orderByComparator,
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

		List<userProfileImage> list = null;

		if (retrieveFromCache) {
			list = (List<userProfileImage>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERPROFILEIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERPROFILEIMAGE;

				if (pagination) {
					sql = sql.concat(userProfileImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<userProfileImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<userProfileImage>)QueryUtil.list(q,
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
	 * Removes all the user profile images from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (userProfileImage userProfileImage : findAll()) {
			remove(userProfileImage);
		}
	}

	/**
	 * Returns the number of user profile images.
	 *
	 * @return the number of user profile images
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERPROFILEIMAGE);

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
		return userProfileImageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user profile image persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(userProfileImageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERPROFILEIMAGE = "SELECT userProfileImage FROM userProfileImage userProfileImage";
	private static final String _SQL_SELECT_USERPROFILEIMAGE_WHERE_PKS_IN = "SELECT userProfileImage FROM userProfileImage userProfileImage WHERE PK_profileImageId IN (";
	private static final String _SQL_COUNT_USERPROFILEIMAGE = "SELECT COUNT(userProfileImage) FROM userProfileImage userProfileImage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userProfileImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No userProfileImage exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(userProfileImagePersistenceImpl.class);
}