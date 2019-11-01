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

package com.collaborated.entity.service.base;

import aQute.bnd.annotation.ProviderType;

import com.collaborated.entity.model.languagePreferences;
import com.collaborated.entity.service.languagePreferencesLocalService;
import com.collaborated.entity.service.persistence.communicationPreferencesPersistence;
import com.collaborated.entity.service.persistence.languagePreferencesPersistence;
import com.collaborated.entity.service.persistence.profileAreaofinterestPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the language preferences local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.collaborated.entity.service.impl.languagePreferencesLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.impl.languagePreferencesLocalServiceImpl
 * @see com.collaborated.entity.service.languagePreferencesLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class languagePreferencesLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements languagePreferencesLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.collaborated.entity.service.languagePreferencesLocalServiceUtil} to access the language preferences local service.
	 */

	/**
	 * Adds the language preferences to the database. Also notifies the appropriate model listeners.
	 *
	 * @param languagePreferences the language preferences
	 * @return the language preferences that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public languagePreferences addlanguagePreferences(
		languagePreferences languagePreferences) {
		languagePreferences.setNew(true);

		return languagePreferencesPersistence.update(languagePreferences);
	}

	/**
	 * Creates a new language preferences with the primary key. Does not add the language preferences to the database.
	 *
	 * @param PK_languagePreferences the primary key for the new language preferences
	 * @return the new language preferences
	 */
	@Override
	public languagePreferences createlanguagePreferences(
		long PK_languagePreferences) {
		return languagePreferencesPersistence.create(PK_languagePreferences);
	}

	/**
	 * Deletes the language preferences with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_languagePreferences the primary key of the language preferences
	 * @return the language preferences that was removed
	 * @throws PortalException if a language preferences with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public languagePreferences deletelanguagePreferences(
		long PK_languagePreferences) throws PortalException {
		return languagePreferencesPersistence.remove(PK_languagePreferences);
	}

	/**
	 * Deletes the language preferences from the database. Also notifies the appropriate model listeners.
	 *
	 * @param languagePreferences the language preferences
	 * @return the language preferences that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public languagePreferences deletelanguagePreferences(
		languagePreferences languagePreferences) {
		return languagePreferencesPersistence.remove(languagePreferences);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(languagePreferences.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return languagePreferencesPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return languagePreferencesPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return languagePreferencesPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return languagePreferencesPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return languagePreferencesPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public languagePreferences fetchlanguagePreferences(
		long PK_languagePreferences) {
		return languagePreferencesPersistence.fetchByPrimaryKey(PK_languagePreferences);
	}

	/**
	 * Returns the language preferences with the primary key.
	 *
	 * @param PK_languagePreferences the primary key of the language preferences
	 * @return the language preferences
	 * @throws PortalException if a language preferences with the primary key could not be found
	 */
	@Override
	public languagePreferences getlanguagePreferences(
		long PK_languagePreferences) throws PortalException {
		return languagePreferencesPersistence.findByPrimaryKey(PK_languagePreferences);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(languagePreferencesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(languagePreferences.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"PK_languagePreferences");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(languagePreferencesLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(languagePreferences.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"PK_languagePreferences");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(languagePreferencesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(languagePreferences.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"PK_languagePreferences");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return languagePreferencesLocalService.deletelanguagePreferences((languagePreferences)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return languagePreferencesPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the language preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.languagePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of language preferenceses
	 * @param end the upper bound of the range of language preferenceses (not inclusive)
	 * @return the range of language preferenceses
	 */
	@Override
	public List<languagePreferences> getlanguagePreferenceses(int start, int end) {
		return languagePreferencesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of language preferenceses.
	 *
	 * @return the number of language preferenceses
	 */
	@Override
	public int getlanguagePreferencesesCount() {
		return languagePreferencesPersistence.countAll();
	}

	/**
	 * Updates the language preferences in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param languagePreferences the language preferences
	 * @return the language preferences that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public languagePreferences updatelanguagePreferences(
		languagePreferences languagePreferences) {
		return languagePreferencesPersistence.update(languagePreferences);
	}

	/**
	 * Returns the communication preferences local service.
	 *
	 * @return the communication preferences local service
	 */
	public com.collaborated.entity.service.communicationPreferencesLocalService getcommunicationPreferencesLocalService() {
		return communicationPreferencesLocalService;
	}

	/**
	 * Sets the communication preferences local service.
	 *
	 * @param communicationPreferencesLocalService the communication preferences local service
	 */
	public void setcommunicationPreferencesLocalService(
		com.collaborated.entity.service.communicationPreferencesLocalService communicationPreferencesLocalService) {
		this.communicationPreferencesLocalService = communicationPreferencesLocalService;
	}

	/**
	 * Returns the communication preferences persistence.
	 *
	 * @return the communication preferences persistence
	 */
	public communicationPreferencesPersistence getcommunicationPreferencesPersistence() {
		return communicationPreferencesPersistence;
	}

	/**
	 * Sets the communication preferences persistence.
	 *
	 * @param communicationPreferencesPersistence the communication preferences persistence
	 */
	public void setcommunicationPreferencesPersistence(
		communicationPreferencesPersistence communicationPreferencesPersistence) {
		this.communicationPreferencesPersistence = communicationPreferencesPersistence;
	}

	/**
	 * Returns the language preferences local service.
	 *
	 * @return the language preferences local service
	 */
	public languagePreferencesLocalService getlanguagePreferencesLocalService() {
		return languagePreferencesLocalService;
	}

	/**
	 * Sets the language preferences local service.
	 *
	 * @param languagePreferencesLocalService the language preferences local service
	 */
	public void setlanguagePreferencesLocalService(
		languagePreferencesLocalService languagePreferencesLocalService) {
		this.languagePreferencesLocalService = languagePreferencesLocalService;
	}

	/**
	 * Returns the language preferences persistence.
	 *
	 * @return the language preferences persistence
	 */
	public languagePreferencesPersistence getlanguagePreferencesPersistence() {
		return languagePreferencesPersistence;
	}

	/**
	 * Sets the language preferences persistence.
	 *
	 * @param languagePreferencesPersistence the language preferences persistence
	 */
	public void setlanguagePreferencesPersistence(
		languagePreferencesPersistence languagePreferencesPersistence) {
		this.languagePreferencesPersistence = languagePreferencesPersistence;
	}

	/**
	 * Returns the profile areaofinterest local service.
	 *
	 * @return the profile areaofinterest local service
	 */
	public com.collaborated.entity.service.profileAreaofinterestLocalService getprofileAreaofinterestLocalService() {
		return profileAreaofinterestLocalService;
	}

	/**
	 * Sets the profile areaofinterest local service.
	 *
	 * @param profileAreaofinterestLocalService the profile areaofinterest local service
	 */
	public void setprofileAreaofinterestLocalService(
		com.collaborated.entity.service.profileAreaofinterestLocalService profileAreaofinterestLocalService) {
		this.profileAreaofinterestLocalService = profileAreaofinterestLocalService;
	}

	/**
	 * Returns the profile areaofinterest persistence.
	 *
	 * @return the profile areaofinterest persistence
	 */
	public profileAreaofinterestPersistence getprofileAreaofinterestPersistence() {
		return profileAreaofinterestPersistence;
	}

	/**
	 * Sets the profile areaofinterest persistence.
	 *
	 * @param profileAreaofinterestPersistence the profile areaofinterest persistence
	 */
	public void setprofileAreaofinterestPersistence(
		profileAreaofinterestPersistence profileAreaofinterestPersistence) {
		this.profileAreaofinterestPersistence = profileAreaofinterestPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.collaborated.entity.model.languagePreferences",
			languagePreferencesLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.collaborated.entity.model.languagePreferences");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return languagePreferencesLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return languagePreferences.class;
	}

	protected String getModelClassName() {
		return languagePreferences.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = languagePreferencesPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.collaborated.entity.service.communicationPreferencesLocalService.class)
	protected com.collaborated.entity.service.communicationPreferencesLocalService communicationPreferencesLocalService;
	@BeanReference(type = communicationPreferencesPersistence.class)
	protected communicationPreferencesPersistence communicationPreferencesPersistence;
	@BeanReference(type = languagePreferencesLocalService.class)
	protected languagePreferencesLocalService languagePreferencesLocalService;
	@BeanReference(type = languagePreferencesPersistence.class)
	protected languagePreferencesPersistence languagePreferencesPersistence;
	@BeanReference(type = com.collaborated.entity.service.profileAreaofinterestLocalService.class)
	protected com.collaborated.entity.service.profileAreaofinterestLocalService profileAreaofinterestLocalService;
	@BeanReference(type = profileAreaofinterestPersistence.class)
	protected profileAreaofinterestPersistence profileAreaofinterestPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}