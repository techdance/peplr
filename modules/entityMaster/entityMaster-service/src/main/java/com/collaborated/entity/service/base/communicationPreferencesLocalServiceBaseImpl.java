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

import com.collaborated.entity.model.communicationPreferences;
import com.collaborated.entity.service.communicationPreferencesLocalService;
import com.collaborated.entity.service.persistence.communicationPreferencesPersistence;
import com.collaborated.entity.service.persistence.languagePreferencesPersistence;
import com.collaborated.entity.service.persistence.profileAreaofinterestPersistence;
import com.collaborated.entity.service.persistence.userCredentialPersistence;
import com.collaborated.entity.service.persistence.userInstitutionProfileDetailsPersistence;
import com.collaborated.entity.service.persistence.userInstitutionProfileSubDetailsPersistence;
import com.collaborated.entity.service.persistence.userProfessionalBioPersistence;

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
 * Provides the base implementation for the communication preferences local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.collaborated.entity.service.impl.communicationPreferencesLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.impl.communicationPreferencesLocalServiceImpl
 * @see com.collaborated.entity.service.communicationPreferencesLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class communicationPreferencesLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements communicationPreferencesLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.collaborated.entity.service.communicationPreferencesLocalServiceUtil} to access the communication preferences local service.
	 */

	/**
	 * Adds the communication preferences to the database. Also notifies the appropriate model listeners.
	 *
	 * @param communicationPreferences the communication preferences
	 * @return the communication preferences that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public communicationPreferences addcommunicationPreferences(
		communicationPreferences communicationPreferences) {
		communicationPreferences.setNew(true);

		return communicationPreferencesPersistence.update(communicationPreferences);
	}

	/**
	 * Creates a new communication preferences with the primary key. Does not add the communication preferences to the database.
	 *
	 * @param PK_communicationPreferences the primary key for the new communication preferences
	 * @return the new communication preferences
	 */
	@Override
	public communicationPreferences createcommunicationPreferences(
		long PK_communicationPreferences) {
		return communicationPreferencesPersistence.create(PK_communicationPreferences);
	}

	/**
	 * Deletes the communication preferences with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_communicationPreferences the primary key of the communication preferences
	 * @return the communication preferences that was removed
	 * @throws PortalException if a communication preferences with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public communicationPreferences deletecommunicationPreferences(
		long PK_communicationPreferences) throws PortalException {
		return communicationPreferencesPersistence.remove(PK_communicationPreferences);
	}

	/**
	 * Deletes the communication preferences from the database. Also notifies the appropriate model listeners.
	 *
	 * @param communicationPreferences the communication preferences
	 * @return the communication preferences that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public communicationPreferences deletecommunicationPreferences(
		communicationPreferences communicationPreferences) {
		return communicationPreferencesPersistence.remove(communicationPreferences);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(communicationPreferences.class,
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
		return communicationPreferencesPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.communicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return communicationPreferencesPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.communicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return communicationPreferencesPersistence.findWithDynamicQuery(dynamicQuery,
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
		return communicationPreferencesPersistence.countWithDynamicQuery(dynamicQuery);
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
		return communicationPreferencesPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public communicationPreferences fetchcommunicationPreferences(
		long PK_communicationPreferences) {
		return communicationPreferencesPersistence.fetchByPrimaryKey(PK_communicationPreferences);
	}

	/**
	 * Returns the communication preferences with the primary key.
	 *
	 * @param PK_communicationPreferences the primary key of the communication preferences
	 * @return the communication preferences
	 * @throws PortalException if a communication preferences with the primary key could not be found
	 */
	@Override
	public communicationPreferences getcommunicationPreferences(
		long PK_communicationPreferences) throws PortalException {
		return communicationPreferencesPersistence.findByPrimaryKey(PK_communicationPreferences);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(communicationPreferencesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(communicationPreferences.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"PK_communicationPreferences");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(communicationPreferencesLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(communicationPreferences.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"PK_communicationPreferences");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(communicationPreferencesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(communicationPreferences.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"PK_communicationPreferences");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return communicationPreferencesLocalService.deletecommunicationPreferences((communicationPreferences)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return communicationPreferencesPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the communication preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.communicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of communication preferenceses
	 * @param end the upper bound of the range of communication preferenceses (not inclusive)
	 * @return the range of communication preferenceses
	 */
	@Override
	public List<communicationPreferences> getcommunicationPreferenceses(
		int start, int end) {
		return communicationPreferencesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of communication preferenceses.
	 *
	 * @return the number of communication preferenceses
	 */
	@Override
	public int getcommunicationPreferencesesCount() {
		return communicationPreferencesPersistence.countAll();
	}

	/**
	 * Updates the communication preferences in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param communicationPreferences the communication preferences
	 * @return the communication preferences that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public communicationPreferences updatecommunicationPreferences(
		communicationPreferences communicationPreferences) {
		return communicationPreferencesPersistence.update(communicationPreferences);
	}

	/**
	 * Returns the communication preferences local service.
	 *
	 * @return the communication preferences local service
	 */
	public communicationPreferencesLocalService getcommunicationPreferencesLocalService() {
		return communicationPreferencesLocalService;
	}

	/**
	 * Sets the communication preferences local service.
	 *
	 * @param communicationPreferencesLocalService the communication preferences local service
	 */
	public void setcommunicationPreferencesLocalService(
		communicationPreferencesLocalService communicationPreferencesLocalService) {
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
	public com.collaborated.entity.service.languagePreferencesLocalService getlanguagePreferencesLocalService() {
		return languagePreferencesLocalService;
	}

	/**
	 * Sets the language preferences local service.
	 *
	 * @param languagePreferencesLocalService the language preferences local service
	 */
	public void setlanguagePreferencesLocalService(
		com.collaborated.entity.service.languagePreferencesLocalService languagePreferencesLocalService) {
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
	 * Returns the user credential local service.
	 *
	 * @return the user credential local service
	 */
	public com.collaborated.entity.service.userCredentialLocalService getuserCredentialLocalService() {
		return userCredentialLocalService;
	}

	/**
	 * Sets the user credential local service.
	 *
	 * @param userCredentialLocalService the user credential local service
	 */
	public void setuserCredentialLocalService(
		com.collaborated.entity.service.userCredentialLocalService userCredentialLocalService) {
		this.userCredentialLocalService = userCredentialLocalService;
	}

	/**
	 * Returns the user credential persistence.
	 *
	 * @return the user credential persistence
	 */
	public userCredentialPersistence getuserCredentialPersistence() {
		return userCredentialPersistence;
	}

	/**
	 * Sets the user credential persistence.
	 *
	 * @param userCredentialPersistence the user credential persistence
	 */
	public void setuserCredentialPersistence(
		userCredentialPersistence userCredentialPersistence) {
		this.userCredentialPersistence = userCredentialPersistence;
	}

	/**
	 * Returns the user institution profile details local service.
	 *
	 * @return the user institution profile details local service
	 */
	public com.collaborated.entity.service.userInstitutionProfileDetailsLocalService getuserInstitutionProfileDetailsLocalService() {
		return userInstitutionProfileDetailsLocalService;
	}

	/**
	 * Sets the user institution profile details local service.
	 *
	 * @param userInstitutionProfileDetailsLocalService the user institution profile details local service
	 */
	public void setuserInstitutionProfileDetailsLocalService(
		com.collaborated.entity.service.userInstitutionProfileDetailsLocalService userInstitutionProfileDetailsLocalService) {
		this.userInstitutionProfileDetailsLocalService = userInstitutionProfileDetailsLocalService;
	}

	/**
	 * Returns the user institution profile details persistence.
	 *
	 * @return the user institution profile details persistence
	 */
	public userInstitutionProfileDetailsPersistence getuserInstitutionProfileDetailsPersistence() {
		return userInstitutionProfileDetailsPersistence;
	}

	/**
	 * Sets the user institution profile details persistence.
	 *
	 * @param userInstitutionProfileDetailsPersistence the user institution profile details persistence
	 */
	public void setuserInstitutionProfileDetailsPersistence(
		userInstitutionProfileDetailsPersistence userInstitutionProfileDetailsPersistence) {
		this.userInstitutionProfileDetailsPersistence = userInstitutionProfileDetailsPersistence;
	}

	/**
	 * Returns the user institution profile sub details local service.
	 *
	 * @return the user institution profile sub details local service
	 */
	public com.collaborated.entity.service.userInstitutionProfileSubDetailsLocalService getuserInstitutionProfileSubDetailsLocalService() {
		return userInstitutionProfileSubDetailsLocalService;
	}

	/**
	 * Sets the user institution profile sub details local service.
	 *
	 * @param userInstitutionProfileSubDetailsLocalService the user institution profile sub details local service
	 */
	public void setuserInstitutionProfileSubDetailsLocalService(
		com.collaborated.entity.service.userInstitutionProfileSubDetailsLocalService userInstitutionProfileSubDetailsLocalService) {
		this.userInstitutionProfileSubDetailsLocalService = userInstitutionProfileSubDetailsLocalService;
	}

	/**
	 * Returns the user institution profile sub details persistence.
	 *
	 * @return the user institution profile sub details persistence
	 */
	public userInstitutionProfileSubDetailsPersistence getuserInstitutionProfileSubDetailsPersistence() {
		return userInstitutionProfileSubDetailsPersistence;
	}

	/**
	 * Sets the user institution profile sub details persistence.
	 *
	 * @param userInstitutionProfileSubDetailsPersistence the user institution profile sub details persistence
	 */
	public void setuserInstitutionProfileSubDetailsPersistence(
		userInstitutionProfileSubDetailsPersistence userInstitutionProfileSubDetailsPersistence) {
		this.userInstitutionProfileSubDetailsPersistence = userInstitutionProfileSubDetailsPersistence;
	}

	/**
	 * Returns the user professional bio local service.
	 *
	 * @return the user professional bio local service
	 */
	public com.collaborated.entity.service.userProfessionalBioLocalService getuserProfessionalBioLocalService() {
		return userProfessionalBioLocalService;
	}

	/**
	 * Sets the user professional bio local service.
	 *
	 * @param userProfessionalBioLocalService the user professional bio local service
	 */
	public void setuserProfessionalBioLocalService(
		com.collaborated.entity.service.userProfessionalBioLocalService userProfessionalBioLocalService) {
		this.userProfessionalBioLocalService = userProfessionalBioLocalService;
	}

	/**
	 * Returns the user professional bio persistence.
	 *
	 * @return the user professional bio persistence
	 */
	public userProfessionalBioPersistence getuserProfessionalBioPersistence() {
		return userProfessionalBioPersistence;
	}

	/**
	 * Sets the user professional bio persistence.
	 *
	 * @param userProfessionalBioPersistence the user professional bio persistence
	 */
	public void setuserProfessionalBioPersistence(
		userProfessionalBioPersistence userProfessionalBioPersistence) {
		this.userProfessionalBioPersistence = userProfessionalBioPersistence;
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
		persistedModelLocalServiceRegistry.register("com.collaborated.entity.model.communicationPreferences",
			communicationPreferencesLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.collaborated.entity.model.communicationPreferences");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return communicationPreferencesLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return communicationPreferences.class;
	}

	protected String getModelClassName() {
		return communicationPreferences.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = communicationPreferencesPersistence.getDataSource();

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

	@BeanReference(type = communicationPreferencesLocalService.class)
	protected communicationPreferencesLocalService communicationPreferencesLocalService;
	@BeanReference(type = communicationPreferencesPersistence.class)
	protected communicationPreferencesPersistence communicationPreferencesPersistence;
	@BeanReference(type = com.collaborated.entity.service.languagePreferencesLocalService.class)
	protected com.collaborated.entity.service.languagePreferencesLocalService languagePreferencesLocalService;
	@BeanReference(type = languagePreferencesPersistence.class)
	protected languagePreferencesPersistence languagePreferencesPersistence;
	@BeanReference(type = com.collaborated.entity.service.profileAreaofinterestLocalService.class)
	protected com.collaborated.entity.service.profileAreaofinterestLocalService profileAreaofinterestLocalService;
	@BeanReference(type = profileAreaofinterestPersistence.class)
	protected profileAreaofinterestPersistence profileAreaofinterestPersistence;
	@BeanReference(type = com.collaborated.entity.service.userCredentialLocalService.class)
	protected com.collaborated.entity.service.userCredentialLocalService userCredentialLocalService;
	@BeanReference(type = userCredentialPersistence.class)
	protected userCredentialPersistence userCredentialPersistence;
	@BeanReference(type = com.collaborated.entity.service.userInstitutionProfileDetailsLocalService.class)
	protected com.collaborated.entity.service.userInstitutionProfileDetailsLocalService userInstitutionProfileDetailsLocalService;
	@BeanReference(type = userInstitutionProfileDetailsPersistence.class)
	protected userInstitutionProfileDetailsPersistence userInstitutionProfileDetailsPersistence;
	@BeanReference(type = com.collaborated.entity.service.userInstitutionProfileSubDetailsLocalService.class)
	protected com.collaborated.entity.service.userInstitutionProfileSubDetailsLocalService userInstitutionProfileSubDetailsLocalService;
	@BeanReference(type = userInstitutionProfileSubDetailsPersistence.class)
	protected userInstitutionProfileSubDetailsPersistence userInstitutionProfileSubDetailsPersistence;
	@BeanReference(type = com.collaborated.entity.service.userProfessionalBioLocalService.class)
	protected com.collaborated.entity.service.userProfessionalBioLocalService userProfessionalBioLocalService;
	@BeanReference(type = userProfessionalBioPersistence.class)
	protected userProfessionalBioPersistence userProfessionalBioPersistence;
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