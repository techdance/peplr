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

import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.service.persistence.Custom_CalendarPersistence;
import com.collaborated.entity.service.persistence.Custom_WorkflowLogPersistence;
import com.collaborated.entity.service.persistence.Custom_WorkflowPersistence;
import com.collaborated.entity.service.persistence.Custom_Workflow_CompletedPersistence;
import com.collaborated.entity.service.persistence.Custom_Workflow_TaskPersistence;
import com.collaborated.entity.service.persistence.Custom_Workflow_TransitionPersistence;
import com.collaborated.entity.service.persistence.commonWebsserviceAPIPersistence;
import com.collaborated.entity.service.persistence.communicationPreferencesPersistence;
import com.collaborated.entity.service.persistence.labDetailedActivityTablePersistence;
import com.collaborated.entity.service.persistence.labDetailedCourseHoursPersistence;
import com.collaborated.entity.service.persistence.labDetailedCourseIdentificationPersistence;
import com.collaborated.entity.service.persistence.labDetailedCourseObjectivesPersistence;
import com.collaborated.entity.service.persistence.labDetailedCourseResourcesPersistence;
import com.collaborated.entity.service.persistence.labDetailedCourseTopicsPersistence;
import com.collaborated.entity.service.persistence.labDetailedInstructorQualificationPersistence;
import com.collaborated.entity.service.persistence.labDetailedLearningEnvironmentsPersistence;
import com.collaborated.entity.service.persistence.labScreenProjectOverviewPersistence;
import com.collaborated.entity.service.persistence.labScreenProjectPartnersPersistence;
import com.collaborated.entity.service.persistence.labScreenTaskPersistence;
import com.collaborated.entity.service.persistence.languagePreferencesPersistence;
import com.collaborated.entity.service.persistence.profileAreaofinterestPersistence;
import com.collaborated.entity.service.persistence.projectDiscussionPersistence;
import com.collaborated.entity.service.persistence.projectFilesUploadPersistence;
import com.collaborated.entity.service.persistence.projectFolderUploadPersistence;
import com.collaborated.entity.service.persistence.projectInviteTrackingPersistence;
import com.collaborated.entity.service.persistence.userCredentialPersistence;
import com.collaborated.entity.service.persistence.userInstitutionProfileDetailsPersistence;
import com.collaborated.entity.service.persistence.userInstitutionProfileSubDetailsPersistence;
import com.collaborated.entity.service.persistence.userProfessionalBioPersistence;
import com.collaborated.entity.service.persistence.userProfileImagePersistence;
import com.collaborated.entity.service.profileAreaofinterestLocalService;

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
 * Provides the base implementation for the profile areaofinterest local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.collaborated.entity.service.impl.profileAreaofinterestLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.impl.profileAreaofinterestLocalServiceImpl
 * @see com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class profileAreaofinterestLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements profileAreaofinterestLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil} to access the profile areaofinterest local service.
	 */

	/**
	 * Adds the profile areaofinterest to the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileAreaofinterest the profile areaofinterest
	 * @return the profile areaofinterest that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public profileAreaofinterest addprofileAreaofinterest(
		profileAreaofinterest profileAreaofinterest) {
		profileAreaofinterest.setNew(true);

		return profileAreaofinterestPersistence.update(profileAreaofinterest);
	}

	/**
	 * Creates a new profile areaofinterest with the primary key. Does not add the profile areaofinterest to the database.
	 *
	 * @param PK_areaofinterest the primary key for the new profile areaofinterest
	 * @return the new profile areaofinterest
	 */
	@Override
	public profileAreaofinterest createprofileAreaofinterest(
		long PK_areaofinterest) {
		return profileAreaofinterestPersistence.create(PK_areaofinterest);
	}

	/**
	 * Deletes the profile areaofinterest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PK_areaofinterest the primary key of the profile areaofinterest
	 * @return the profile areaofinterest that was removed
	 * @throws PortalException if a profile areaofinterest with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public profileAreaofinterest deleteprofileAreaofinterest(
		long PK_areaofinterest) throws PortalException {
		return profileAreaofinterestPersistence.remove(PK_areaofinterest);
	}

	/**
	 * Deletes the profile areaofinterest from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profileAreaofinterest the profile areaofinterest
	 * @return the profile areaofinterest that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public profileAreaofinterest deleteprofileAreaofinterest(
		profileAreaofinterest profileAreaofinterest) {
		return profileAreaofinterestPersistence.remove(profileAreaofinterest);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(profileAreaofinterest.class,
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
		return profileAreaofinterestPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return profileAreaofinterestPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return profileAreaofinterestPersistence.findWithDynamicQuery(dynamicQuery,
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
		return profileAreaofinterestPersistence.countWithDynamicQuery(dynamicQuery);
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
		return profileAreaofinterestPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public profileAreaofinterest fetchprofileAreaofinterest(
		long PK_areaofinterest) {
		return profileAreaofinterestPersistence.fetchByPrimaryKey(PK_areaofinterest);
	}

	/**
	 * Returns the profile areaofinterest with the primary key.
	 *
	 * @param PK_areaofinterest the primary key of the profile areaofinterest
	 * @return the profile areaofinterest
	 * @throws PortalException if a profile areaofinterest with the primary key could not be found
	 */
	@Override
	public profileAreaofinterest getprofileAreaofinterest(
		long PK_areaofinterest) throws PortalException {
		return profileAreaofinterestPersistence.findByPrimaryKey(PK_areaofinterest);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(profileAreaofinterestLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(profileAreaofinterest.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("PK_areaofinterest");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(profileAreaofinterestLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(profileAreaofinterest.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"PK_areaofinterest");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(profileAreaofinterestLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(profileAreaofinterest.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("PK_areaofinterest");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return profileAreaofinterestLocalService.deleteprofileAreaofinterest((profileAreaofinterest)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return profileAreaofinterestPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the profile areaofinterests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.collaborated.entity.model.impl.profileAreaofinterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile areaofinterests
	 * @param end the upper bound of the range of profile areaofinterests (not inclusive)
	 * @return the range of profile areaofinterests
	 */
	@Override
	public List<profileAreaofinterest> getprofileAreaofinterests(int start,
		int end) {
		return profileAreaofinterestPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of profile areaofinterests.
	 *
	 * @return the number of profile areaofinterests
	 */
	@Override
	public int getprofileAreaofinterestsCount() {
		return profileAreaofinterestPersistence.countAll();
	}

	/**
	 * Updates the profile areaofinterest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param profileAreaofinterest the profile areaofinterest
	 * @return the profile areaofinterest that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public profileAreaofinterest updateprofileAreaofinterest(
		profileAreaofinterest profileAreaofinterest) {
		return profileAreaofinterestPersistence.update(profileAreaofinterest);
	}

	/**
	 * Returns the common websservice a p i local service.
	 *
	 * @return the common websservice a p i local service
	 */
	public com.collaborated.entity.service.commonWebsserviceAPILocalService getcommonWebsserviceAPILocalService() {
		return commonWebsserviceAPILocalService;
	}

	/**
	 * Sets the common websservice a p i local service.
	 *
	 * @param commonWebsserviceAPILocalService the common websservice a p i local service
	 */
	public void setcommonWebsserviceAPILocalService(
		com.collaborated.entity.service.commonWebsserviceAPILocalService commonWebsserviceAPILocalService) {
		this.commonWebsserviceAPILocalService = commonWebsserviceAPILocalService;
	}

	/**
	 * Returns the common websservice a p i persistence.
	 *
	 * @return the common websservice a p i persistence
	 */
	public commonWebsserviceAPIPersistence getcommonWebsserviceAPIPersistence() {
		return commonWebsserviceAPIPersistence;
	}

	/**
	 * Sets the common websservice a p i persistence.
	 *
	 * @param commonWebsserviceAPIPersistence the common websservice a p i persistence
	 */
	public void setcommonWebsserviceAPIPersistence(
		commonWebsserviceAPIPersistence commonWebsserviceAPIPersistence) {
		this.commonWebsserviceAPIPersistence = commonWebsserviceAPIPersistence;
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
	 * Returns the custom_ calendar local service.
	 *
	 * @return the custom_ calendar local service
	 */
	public com.collaborated.entity.service.Custom_CalendarLocalService getCustom_CalendarLocalService() {
		return custom_CalendarLocalService;
	}

	/**
	 * Sets the custom_ calendar local service.
	 *
	 * @param custom_CalendarLocalService the custom_ calendar local service
	 */
	public void setCustom_CalendarLocalService(
		com.collaborated.entity.service.Custom_CalendarLocalService custom_CalendarLocalService) {
		this.custom_CalendarLocalService = custom_CalendarLocalService;
	}

	/**
	 * Returns the custom_ calendar persistence.
	 *
	 * @return the custom_ calendar persistence
	 */
	public Custom_CalendarPersistence getCustom_CalendarPersistence() {
		return custom_CalendarPersistence;
	}

	/**
	 * Sets the custom_ calendar persistence.
	 *
	 * @param custom_CalendarPersistence the custom_ calendar persistence
	 */
	public void setCustom_CalendarPersistence(
		Custom_CalendarPersistence custom_CalendarPersistence) {
		this.custom_CalendarPersistence = custom_CalendarPersistence;
	}

	/**
	 * Returns the custom_ workflow local service.
	 *
	 * @return the custom_ workflow local service
	 */
	public com.collaborated.entity.service.Custom_WorkflowLocalService getCustom_WorkflowLocalService() {
		return custom_WorkflowLocalService;
	}

	/**
	 * Sets the custom_ workflow local service.
	 *
	 * @param custom_WorkflowLocalService the custom_ workflow local service
	 */
	public void setCustom_WorkflowLocalService(
		com.collaborated.entity.service.Custom_WorkflowLocalService custom_WorkflowLocalService) {
		this.custom_WorkflowLocalService = custom_WorkflowLocalService;
	}

	/**
	 * Returns the custom_ workflow persistence.
	 *
	 * @return the custom_ workflow persistence
	 */
	public Custom_WorkflowPersistence getCustom_WorkflowPersistence() {
		return custom_WorkflowPersistence;
	}

	/**
	 * Sets the custom_ workflow persistence.
	 *
	 * @param custom_WorkflowPersistence the custom_ workflow persistence
	 */
	public void setCustom_WorkflowPersistence(
		Custom_WorkflowPersistence custom_WorkflowPersistence) {
		this.custom_WorkflowPersistence = custom_WorkflowPersistence;
	}

	/**
	 * Returns the custom_ workflow_ completed local service.
	 *
	 * @return the custom_ workflow_ completed local service
	 */
	public com.collaborated.entity.service.Custom_Workflow_CompletedLocalService getCustom_Workflow_CompletedLocalService() {
		return custom_Workflow_CompletedLocalService;
	}

	/**
	 * Sets the custom_ workflow_ completed local service.
	 *
	 * @param custom_Workflow_CompletedLocalService the custom_ workflow_ completed local service
	 */
	public void setCustom_Workflow_CompletedLocalService(
		com.collaborated.entity.service.Custom_Workflow_CompletedLocalService custom_Workflow_CompletedLocalService) {
		this.custom_Workflow_CompletedLocalService = custom_Workflow_CompletedLocalService;
	}

	/**
	 * Returns the custom_ workflow_ completed persistence.
	 *
	 * @return the custom_ workflow_ completed persistence
	 */
	public Custom_Workflow_CompletedPersistence getCustom_Workflow_CompletedPersistence() {
		return custom_Workflow_CompletedPersistence;
	}

	/**
	 * Sets the custom_ workflow_ completed persistence.
	 *
	 * @param custom_Workflow_CompletedPersistence the custom_ workflow_ completed persistence
	 */
	public void setCustom_Workflow_CompletedPersistence(
		Custom_Workflow_CompletedPersistence custom_Workflow_CompletedPersistence) {
		this.custom_Workflow_CompletedPersistence = custom_Workflow_CompletedPersistence;
	}

	/**
	 * Returns the custom_ workflow_ task local service.
	 *
	 * @return the custom_ workflow_ task local service
	 */
	public com.collaborated.entity.service.Custom_Workflow_TaskLocalService getCustom_Workflow_TaskLocalService() {
		return custom_Workflow_TaskLocalService;
	}

	/**
	 * Sets the custom_ workflow_ task local service.
	 *
	 * @param custom_Workflow_TaskLocalService the custom_ workflow_ task local service
	 */
	public void setCustom_Workflow_TaskLocalService(
		com.collaborated.entity.service.Custom_Workflow_TaskLocalService custom_Workflow_TaskLocalService) {
		this.custom_Workflow_TaskLocalService = custom_Workflow_TaskLocalService;
	}

	/**
	 * Returns the custom_ workflow_ task persistence.
	 *
	 * @return the custom_ workflow_ task persistence
	 */
	public Custom_Workflow_TaskPersistence getCustom_Workflow_TaskPersistence() {
		return custom_Workflow_TaskPersistence;
	}

	/**
	 * Sets the custom_ workflow_ task persistence.
	 *
	 * @param custom_Workflow_TaskPersistence the custom_ workflow_ task persistence
	 */
	public void setCustom_Workflow_TaskPersistence(
		Custom_Workflow_TaskPersistence custom_Workflow_TaskPersistence) {
		this.custom_Workflow_TaskPersistence = custom_Workflow_TaskPersistence;
	}

	/**
	 * Returns the custom_ workflow_ transition local service.
	 *
	 * @return the custom_ workflow_ transition local service
	 */
	public com.collaborated.entity.service.Custom_Workflow_TransitionLocalService getCustom_Workflow_TransitionLocalService() {
		return custom_Workflow_TransitionLocalService;
	}

	/**
	 * Sets the custom_ workflow_ transition local service.
	 *
	 * @param custom_Workflow_TransitionLocalService the custom_ workflow_ transition local service
	 */
	public void setCustom_Workflow_TransitionLocalService(
		com.collaborated.entity.service.Custom_Workflow_TransitionLocalService custom_Workflow_TransitionLocalService) {
		this.custom_Workflow_TransitionLocalService = custom_Workflow_TransitionLocalService;
	}

	/**
	 * Returns the custom_ workflow_ transition persistence.
	 *
	 * @return the custom_ workflow_ transition persistence
	 */
	public Custom_Workflow_TransitionPersistence getCustom_Workflow_TransitionPersistence() {
		return custom_Workflow_TransitionPersistence;
	}

	/**
	 * Sets the custom_ workflow_ transition persistence.
	 *
	 * @param custom_Workflow_TransitionPersistence the custom_ workflow_ transition persistence
	 */
	public void setCustom_Workflow_TransitionPersistence(
		Custom_Workflow_TransitionPersistence custom_Workflow_TransitionPersistence) {
		this.custom_Workflow_TransitionPersistence = custom_Workflow_TransitionPersistence;
	}

	/**
	 * Returns the custom_ workflow log local service.
	 *
	 * @return the custom_ workflow log local service
	 */
	public com.collaborated.entity.service.Custom_WorkflowLogLocalService getCustom_WorkflowLogLocalService() {
		return custom_WorkflowLogLocalService;
	}

	/**
	 * Sets the custom_ workflow log local service.
	 *
	 * @param custom_WorkflowLogLocalService the custom_ workflow log local service
	 */
	public void setCustom_WorkflowLogLocalService(
		com.collaborated.entity.service.Custom_WorkflowLogLocalService custom_WorkflowLogLocalService) {
		this.custom_WorkflowLogLocalService = custom_WorkflowLogLocalService;
	}

	/**
	 * Returns the custom_ workflow log persistence.
	 *
	 * @return the custom_ workflow log persistence
	 */
	public Custom_WorkflowLogPersistence getCustom_WorkflowLogPersistence() {
		return custom_WorkflowLogPersistence;
	}

	/**
	 * Sets the custom_ workflow log persistence.
	 *
	 * @param custom_WorkflowLogPersistence the custom_ workflow log persistence
	 */
	public void setCustom_WorkflowLogPersistence(
		Custom_WorkflowLogPersistence custom_WorkflowLogPersistence) {
		this.custom_WorkflowLogPersistence = custom_WorkflowLogPersistence;
	}

	/**
	 * Returns the lab detailed activity table local service.
	 *
	 * @return the lab detailed activity table local service
	 */
	public com.collaborated.entity.service.labDetailedActivityTableLocalService getlabDetailedActivityTableLocalService() {
		return labDetailedActivityTableLocalService;
	}

	/**
	 * Sets the lab detailed activity table local service.
	 *
	 * @param labDetailedActivityTableLocalService the lab detailed activity table local service
	 */
	public void setlabDetailedActivityTableLocalService(
		com.collaborated.entity.service.labDetailedActivityTableLocalService labDetailedActivityTableLocalService) {
		this.labDetailedActivityTableLocalService = labDetailedActivityTableLocalService;
	}

	/**
	 * Returns the lab detailed activity table persistence.
	 *
	 * @return the lab detailed activity table persistence
	 */
	public labDetailedActivityTablePersistence getlabDetailedActivityTablePersistence() {
		return labDetailedActivityTablePersistence;
	}

	/**
	 * Sets the lab detailed activity table persistence.
	 *
	 * @param labDetailedActivityTablePersistence the lab detailed activity table persistence
	 */
	public void setlabDetailedActivityTablePersistence(
		labDetailedActivityTablePersistence labDetailedActivityTablePersistence) {
		this.labDetailedActivityTablePersistence = labDetailedActivityTablePersistence;
	}

	/**
	 * Returns the lab detailed course hours local service.
	 *
	 * @return the lab detailed course hours local service
	 */
	public com.collaborated.entity.service.labDetailedCourseHoursLocalService getlabDetailedCourseHoursLocalService() {
		return labDetailedCourseHoursLocalService;
	}

	/**
	 * Sets the lab detailed course hours local service.
	 *
	 * @param labDetailedCourseHoursLocalService the lab detailed course hours local service
	 */
	public void setlabDetailedCourseHoursLocalService(
		com.collaborated.entity.service.labDetailedCourseHoursLocalService labDetailedCourseHoursLocalService) {
		this.labDetailedCourseHoursLocalService = labDetailedCourseHoursLocalService;
	}

	/**
	 * Returns the lab detailed course hours persistence.
	 *
	 * @return the lab detailed course hours persistence
	 */
	public labDetailedCourseHoursPersistence getlabDetailedCourseHoursPersistence() {
		return labDetailedCourseHoursPersistence;
	}

	/**
	 * Sets the lab detailed course hours persistence.
	 *
	 * @param labDetailedCourseHoursPersistence the lab detailed course hours persistence
	 */
	public void setlabDetailedCourseHoursPersistence(
		labDetailedCourseHoursPersistence labDetailedCourseHoursPersistence) {
		this.labDetailedCourseHoursPersistence = labDetailedCourseHoursPersistence;
	}

	/**
	 * Returns the lab detailed course identification local service.
	 *
	 * @return the lab detailed course identification local service
	 */
	public com.collaborated.entity.service.labDetailedCourseIdentificationLocalService getlabDetailedCourseIdentificationLocalService() {
		return labDetailedCourseIdentificationLocalService;
	}

	/**
	 * Sets the lab detailed course identification local service.
	 *
	 * @param labDetailedCourseIdentificationLocalService the lab detailed course identification local service
	 */
	public void setlabDetailedCourseIdentificationLocalService(
		com.collaborated.entity.service.labDetailedCourseIdentificationLocalService labDetailedCourseIdentificationLocalService) {
		this.labDetailedCourseIdentificationLocalService = labDetailedCourseIdentificationLocalService;
	}

	/**
	 * Returns the lab detailed course identification persistence.
	 *
	 * @return the lab detailed course identification persistence
	 */
	public labDetailedCourseIdentificationPersistence getlabDetailedCourseIdentificationPersistence() {
		return labDetailedCourseIdentificationPersistence;
	}

	/**
	 * Sets the lab detailed course identification persistence.
	 *
	 * @param labDetailedCourseIdentificationPersistence the lab detailed course identification persistence
	 */
	public void setlabDetailedCourseIdentificationPersistence(
		labDetailedCourseIdentificationPersistence labDetailedCourseIdentificationPersistence) {
		this.labDetailedCourseIdentificationPersistence = labDetailedCourseIdentificationPersistence;
	}

	/**
	 * Returns the lab detailed course objectives local service.
	 *
	 * @return the lab detailed course objectives local service
	 */
	public com.collaborated.entity.service.labDetailedCourseObjectivesLocalService getlabDetailedCourseObjectivesLocalService() {
		return labDetailedCourseObjectivesLocalService;
	}

	/**
	 * Sets the lab detailed course objectives local service.
	 *
	 * @param labDetailedCourseObjectivesLocalService the lab detailed course objectives local service
	 */
	public void setlabDetailedCourseObjectivesLocalService(
		com.collaborated.entity.service.labDetailedCourseObjectivesLocalService labDetailedCourseObjectivesLocalService) {
		this.labDetailedCourseObjectivesLocalService = labDetailedCourseObjectivesLocalService;
	}

	/**
	 * Returns the lab detailed course objectives persistence.
	 *
	 * @return the lab detailed course objectives persistence
	 */
	public labDetailedCourseObjectivesPersistence getlabDetailedCourseObjectivesPersistence() {
		return labDetailedCourseObjectivesPersistence;
	}

	/**
	 * Sets the lab detailed course objectives persistence.
	 *
	 * @param labDetailedCourseObjectivesPersistence the lab detailed course objectives persistence
	 */
	public void setlabDetailedCourseObjectivesPersistence(
		labDetailedCourseObjectivesPersistence labDetailedCourseObjectivesPersistence) {
		this.labDetailedCourseObjectivesPersistence = labDetailedCourseObjectivesPersistence;
	}

	/**
	 * Returns the lab detailed course resources local service.
	 *
	 * @return the lab detailed course resources local service
	 */
	public com.collaborated.entity.service.labDetailedCourseResourcesLocalService getlabDetailedCourseResourcesLocalService() {
		return labDetailedCourseResourcesLocalService;
	}

	/**
	 * Sets the lab detailed course resources local service.
	 *
	 * @param labDetailedCourseResourcesLocalService the lab detailed course resources local service
	 */
	public void setlabDetailedCourseResourcesLocalService(
		com.collaborated.entity.service.labDetailedCourseResourcesLocalService labDetailedCourseResourcesLocalService) {
		this.labDetailedCourseResourcesLocalService = labDetailedCourseResourcesLocalService;
	}

	/**
	 * Returns the lab detailed course resources persistence.
	 *
	 * @return the lab detailed course resources persistence
	 */
	public labDetailedCourseResourcesPersistence getlabDetailedCourseResourcesPersistence() {
		return labDetailedCourseResourcesPersistence;
	}

	/**
	 * Sets the lab detailed course resources persistence.
	 *
	 * @param labDetailedCourseResourcesPersistence the lab detailed course resources persistence
	 */
	public void setlabDetailedCourseResourcesPersistence(
		labDetailedCourseResourcesPersistence labDetailedCourseResourcesPersistence) {
		this.labDetailedCourseResourcesPersistence = labDetailedCourseResourcesPersistence;
	}

	/**
	 * Returns the lab detailed course topics local service.
	 *
	 * @return the lab detailed course topics local service
	 */
	public com.collaborated.entity.service.labDetailedCourseTopicsLocalService getlabDetailedCourseTopicsLocalService() {
		return labDetailedCourseTopicsLocalService;
	}

	/**
	 * Sets the lab detailed course topics local service.
	 *
	 * @param labDetailedCourseTopicsLocalService the lab detailed course topics local service
	 */
	public void setlabDetailedCourseTopicsLocalService(
		com.collaborated.entity.service.labDetailedCourseTopicsLocalService labDetailedCourseTopicsLocalService) {
		this.labDetailedCourseTopicsLocalService = labDetailedCourseTopicsLocalService;
	}

	/**
	 * Returns the lab detailed course topics persistence.
	 *
	 * @return the lab detailed course topics persistence
	 */
	public labDetailedCourseTopicsPersistence getlabDetailedCourseTopicsPersistence() {
		return labDetailedCourseTopicsPersistence;
	}

	/**
	 * Sets the lab detailed course topics persistence.
	 *
	 * @param labDetailedCourseTopicsPersistence the lab detailed course topics persistence
	 */
	public void setlabDetailedCourseTopicsPersistence(
		labDetailedCourseTopicsPersistence labDetailedCourseTopicsPersistence) {
		this.labDetailedCourseTopicsPersistence = labDetailedCourseTopicsPersistence;
	}

	/**
	 * Returns the lab detailed instructor qualification local service.
	 *
	 * @return the lab detailed instructor qualification local service
	 */
	public com.collaborated.entity.service.labDetailedInstructorQualificationLocalService getlabDetailedInstructorQualificationLocalService() {
		return labDetailedInstructorQualificationLocalService;
	}

	/**
	 * Sets the lab detailed instructor qualification local service.
	 *
	 * @param labDetailedInstructorQualificationLocalService the lab detailed instructor qualification local service
	 */
	public void setlabDetailedInstructorQualificationLocalService(
		com.collaborated.entity.service.labDetailedInstructorQualificationLocalService labDetailedInstructorQualificationLocalService) {
		this.labDetailedInstructorQualificationLocalService = labDetailedInstructorQualificationLocalService;
	}

	/**
	 * Returns the lab detailed instructor qualification persistence.
	 *
	 * @return the lab detailed instructor qualification persistence
	 */
	public labDetailedInstructorQualificationPersistence getlabDetailedInstructorQualificationPersistence() {
		return labDetailedInstructorQualificationPersistence;
	}

	/**
	 * Sets the lab detailed instructor qualification persistence.
	 *
	 * @param labDetailedInstructorQualificationPersistence the lab detailed instructor qualification persistence
	 */
	public void setlabDetailedInstructorQualificationPersistence(
		labDetailedInstructorQualificationPersistence labDetailedInstructorQualificationPersistence) {
		this.labDetailedInstructorQualificationPersistence = labDetailedInstructorQualificationPersistence;
	}

	/**
	 * Returns the lab detailed learning environments local service.
	 *
	 * @return the lab detailed learning environments local service
	 */
	public com.collaborated.entity.service.labDetailedLearningEnvironmentsLocalService getlabDetailedLearningEnvironmentsLocalService() {
		return labDetailedLearningEnvironmentsLocalService;
	}

	/**
	 * Sets the lab detailed learning environments local service.
	 *
	 * @param labDetailedLearningEnvironmentsLocalService the lab detailed learning environments local service
	 */
	public void setlabDetailedLearningEnvironmentsLocalService(
		com.collaborated.entity.service.labDetailedLearningEnvironmentsLocalService labDetailedLearningEnvironmentsLocalService) {
		this.labDetailedLearningEnvironmentsLocalService = labDetailedLearningEnvironmentsLocalService;
	}

	/**
	 * Returns the lab detailed learning environments persistence.
	 *
	 * @return the lab detailed learning environments persistence
	 */
	public labDetailedLearningEnvironmentsPersistence getlabDetailedLearningEnvironmentsPersistence() {
		return labDetailedLearningEnvironmentsPersistence;
	}

	/**
	 * Sets the lab detailed learning environments persistence.
	 *
	 * @param labDetailedLearningEnvironmentsPersistence the lab detailed learning environments persistence
	 */
	public void setlabDetailedLearningEnvironmentsPersistence(
		labDetailedLearningEnvironmentsPersistence labDetailedLearningEnvironmentsPersistence) {
		this.labDetailedLearningEnvironmentsPersistence = labDetailedLearningEnvironmentsPersistence;
	}

	/**
	 * Returns the lab screen project overview local service.
	 *
	 * @return the lab screen project overview local service
	 */
	public com.collaborated.entity.service.labScreenProjectOverviewLocalService getlabScreenProjectOverviewLocalService() {
		return labScreenProjectOverviewLocalService;
	}

	/**
	 * Sets the lab screen project overview local service.
	 *
	 * @param labScreenProjectOverviewLocalService the lab screen project overview local service
	 */
	public void setlabScreenProjectOverviewLocalService(
		com.collaborated.entity.service.labScreenProjectOverviewLocalService labScreenProjectOverviewLocalService) {
		this.labScreenProjectOverviewLocalService = labScreenProjectOverviewLocalService;
	}

	/**
	 * Returns the lab screen project overview persistence.
	 *
	 * @return the lab screen project overview persistence
	 */
	public labScreenProjectOverviewPersistence getlabScreenProjectOverviewPersistence() {
		return labScreenProjectOverviewPersistence;
	}

	/**
	 * Sets the lab screen project overview persistence.
	 *
	 * @param labScreenProjectOverviewPersistence the lab screen project overview persistence
	 */
	public void setlabScreenProjectOverviewPersistence(
		labScreenProjectOverviewPersistence labScreenProjectOverviewPersistence) {
		this.labScreenProjectOverviewPersistence = labScreenProjectOverviewPersistence;
	}

	/**
	 * Returns the lab screen project partners local service.
	 *
	 * @return the lab screen project partners local service
	 */
	public com.collaborated.entity.service.labScreenProjectPartnersLocalService getlabScreenProjectPartnersLocalService() {
		return labScreenProjectPartnersLocalService;
	}

	/**
	 * Sets the lab screen project partners local service.
	 *
	 * @param labScreenProjectPartnersLocalService the lab screen project partners local service
	 */
	public void setlabScreenProjectPartnersLocalService(
		com.collaborated.entity.service.labScreenProjectPartnersLocalService labScreenProjectPartnersLocalService) {
		this.labScreenProjectPartnersLocalService = labScreenProjectPartnersLocalService;
	}

	/**
	 * Returns the lab screen project partners persistence.
	 *
	 * @return the lab screen project partners persistence
	 */
	public labScreenProjectPartnersPersistence getlabScreenProjectPartnersPersistence() {
		return labScreenProjectPartnersPersistence;
	}

	/**
	 * Sets the lab screen project partners persistence.
	 *
	 * @param labScreenProjectPartnersPersistence the lab screen project partners persistence
	 */
	public void setlabScreenProjectPartnersPersistence(
		labScreenProjectPartnersPersistence labScreenProjectPartnersPersistence) {
		this.labScreenProjectPartnersPersistence = labScreenProjectPartnersPersistence;
	}

	/**
	 * Returns the lab screen task local service.
	 *
	 * @return the lab screen task local service
	 */
	public com.collaborated.entity.service.labScreenTaskLocalService getlabScreenTaskLocalService() {
		return labScreenTaskLocalService;
	}

	/**
	 * Sets the lab screen task local service.
	 *
	 * @param labScreenTaskLocalService the lab screen task local service
	 */
	public void setlabScreenTaskLocalService(
		com.collaborated.entity.service.labScreenTaskLocalService labScreenTaskLocalService) {
		this.labScreenTaskLocalService = labScreenTaskLocalService;
	}

	/**
	 * Returns the lab screen task persistence.
	 *
	 * @return the lab screen task persistence
	 */
	public labScreenTaskPersistence getlabScreenTaskPersistence() {
		return labScreenTaskPersistence;
	}

	/**
	 * Sets the lab screen task persistence.
	 *
	 * @param labScreenTaskPersistence the lab screen task persistence
	 */
	public void setlabScreenTaskPersistence(
		labScreenTaskPersistence labScreenTaskPersistence) {
		this.labScreenTaskPersistence = labScreenTaskPersistence;
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
	public profileAreaofinterestLocalService getprofileAreaofinterestLocalService() {
		return profileAreaofinterestLocalService;
	}

	/**
	 * Sets the profile areaofinterest local service.
	 *
	 * @param profileAreaofinterestLocalService the profile areaofinterest local service
	 */
	public void setprofileAreaofinterestLocalService(
		profileAreaofinterestLocalService profileAreaofinterestLocalService) {
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
	 * Returns the project discussion local service.
	 *
	 * @return the project discussion local service
	 */
	public com.collaborated.entity.service.projectDiscussionLocalService getprojectDiscussionLocalService() {
		return projectDiscussionLocalService;
	}

	/**
	 * Sets the project discussion local service.
	 *
	 * @param projectDiscussionLocalService the project discussion local service
	 */
	public void setprojectDiscussionLocalService(
		com.collaborated.entity.service.projectDiscussionLocalService projectDiscussionLocalService) {
		this.projectDiscussionLocalService = projectDiscussionLocalService;
	}

	/**
	 * Returns the project discussion persistence.
	 *
	 * @return the project discussion persistence
	 */
	public projectDiscussionPersistence getprojectDiscussionPersistence() {
		return projectDiscussionPersistence;
	}

	/**
	 * Sets the project discussion persistence.
	 *
	 * @param projectDiscussionPersistence the project discussion persistence
	 */
	public void setprojectDiscussionPersistence(
		projectDiscussionPersistence projectDiscussionPersistence) {
		this.projectDiscussionPersistence = projectDiscussionPersistence;
	}

	/**
	 * Returns the project files upload local service.
	 *
	 * @return the project files upload local service
	 */
	public com.collaborated.entity.service.projectFilesUploadLocalService getprojectFilesUploadLocalService() {
		return projectFilesUploadLocalService;
	}

	/**
	 * Sets the project files upload local service.
	 *
	 * @param projectFilesUploadLocalService the project files upload local service
	 */
	public void setprojectFilesUploadLocalService(
		com.collaborated.entity.service.projectFilesUploadLocalService projectFilesUploadLocalService) {
		this.projectFilesUploadLocalService = projectFilesUploadLocalService;
	}

	/**
	 * Returns the project files upload persistence.
	 *
	 * @return the project files upload persistence
	 */
	public projectFilesUploadPersistence getprojectFilesUploadPersistence() {
		return projectFilesUploadPersistence;
	}

	/**
	 * Sets the project files upload persistence.
	 *
	 * @param projectFilesUploadPersistence the project files upload persistence
	 */
	public void setprojectFilesUploadPersistence(
		projectFilesUploadPersistence projectFilesUploadPersistence) {
		this.projectFilesUploadPersistence = projectFilesUploadPersistence;
	}

	/**
	 * Returns the project folder upload local service.
	 *
	 * @return the project folder upload local service
	 */
	public com.collaborated.entity.service.projectFolderUploadLocalService getprojectFolderUploadLocalService() {
		return projectFolderUploadLocalService;
	}

	/**
	 * Sets the project folder upload local service.
	 *
	 * @param projectFolderUploadLocalService the project folder upload local service
	 */
	public void setprojectFolderUploadLocalService(
		com.collaborated.entity.service.projectFolderUploadLocalService projectFolderUploadLocalService) {
		this.projectFolderUploadLocalService = projectFolderUploadLocalService;
	}

	/**
	 * Returns the project folder upload persistence.
	 *
	 * @return the project folder upload persistence
	 */
	public projectFolderUploadPersistence getprojectFolderUploadPersistence() {
		return projectFolderUploadPersistence;
	}

	/**
	 * Sets the project folder upload persistence.
	 *
	 * @param projectFolderUploadPersistence the project folder upload persistence
	 */
	public void setprojectFolderUploadPersistence(
		projectFolderUploadPersistence projectFolderUploadPersistence) {
		this.projectFolderUploadPersistence = projectFolderUploadPersistence;
	}

	/**
	 * Returns the project invite tracking local service.
	 *
	 * @return the project invite tracking local service
	 */
	public com.collaborated.entity.service.projectInviteTrackingLocalService getprojectInviteTrackingLocalService() {
		return projectInviteTrackingLocalService;
	}

	/**
	 * Sets the project invite tracking local service.
	 *
	 * @param projectInviteTrackingLocalService the project invite tracking local service
	 */
	public void setprojectInviteTrackingLocalService(
		com.collaborated.entity.service.projectInviteTrackingLocalService projectInviteTrackingLocalService) {
		this.projectInviteTrackingLocalService = projectInviteTrackingLocalService;
	}

	/**
	 * Returns the project invite tracking persistence.
	 *
	 * @return the project invite tracking persistence
	 */
	public projectInviteTrackingPersistence getprojectInviteTrackingPersistence() {
		return projectInviteTrackingPersistence;
	}

	/**
	 * Sets the project invite tracking persistence.
	 *
	 * @param projectInviteTrackingPersistence the project invite tracking persistence
	 */
	public void setprojectInviteTrackingPersistence(
		projectInviteTrackingPersistence projectInviteTrackingPersistence) {
		this.projectInviteTrackingPersistence = projectInviteTrackingPersistence;
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
	 * Returns the user profile image local service.
	 *
	 * @return the user profile image local service
	 */
	public com.collaborated.entity.service.userProfileImageLocalService getuserProfileImageLocalService() {
		return userProfileImageLocalService;
	}

	/**
	 * Sets the user profile image local service.
	 *
	 * @param userProfileImageLocalService the user profile image local service
	 */
	public void setuserProfileImageLocalService(
		com.collaborated.entity.service.userProfileImageLocalService userProfileImageLocalService) {
		this.userProfileImageLocalService = userProfileImageLocalService;
	}

	/**
	 * Returns the user profile image persistence.
	 *
	 * @return the user profile image persistence
	 */
	public userProfileImagePersistence getuserProfileImagePersistence() {
		return userProfileImagePersistence;
	}

	/**
	 * Sets the user profile image persistence.
	 *
	 * @param userProfileImagePersistence the user profile image persistence
	 */
	public void setuserProfileImagePersistence(
		userProfileImagePersistence userProfileImagePersistence) {
		this.userProfileImagePersistence = userProfileImagePersistence;
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
		persistedModelLocalServiceRegistry.register("com.collaborated.entity.model.profileAreaofinterest",
			profileAreaofinterestLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.collaborated.entity.model.profileAreaofinterest");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return profileAreaofinterestLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return profileAreaofinterest.class;
	}

	protected String getModelClassName() {
		return profileAreaofinterest.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = profileAreaofinterestPersistence.getDataSource();

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

	@BeanReference(type = com.collaborated.entity.service.commonWebsserviceAPILocalService.class)
	protected com.collaborated.entity.service.commonWebsserviceAPILocalService commonWebsserviceAPILocalService;
	@BeanReference(type = commonWebsserviceAPIPersistence.class)
	protected commonWebsserviceAPIPersistence commonWebsserviceAPIPersistence;
	@BeanReference(type = com.collaborated.entity.service.communicationPreferencesLocalService.class)
	protected com.collaborated.entity.service.communicationPreferencesLocalService communicationPreferencesLocalService;
	@BeanReference(type = communicationPreferencesPersistence.class)
	protected communicationPreferencesPersistence communicationPreferencesPersistence;
	@BeanReference(type = com.collaborated.entity.service.Custom_CalendarLocalService.class)
	protected com.collaborated.entity.service.Custom_CalendarLocalService custom_CalendarLocalService;
	@BeanReference(type = Custom_CalendarPersistence.class)
	protected Custom_CalendarPersistence custom_CalendarPersistence;
	@BeanReference(type = com.collaborated.entity.service.Custom_WorkflowLocalService.class)
	protected com.collaborated.entity.service.Custom_WorkflowLocalService custom_WorkflowLocalService;
	@BeanReference(type = Custom_WorkflowPersistence.class)
	protected Custom_WorkflowPersistence custom_WorkflowPersistence;
	@BeanReference(type = com.collaborated.entity.service.Custom_Workflow_CompletedLocalService.class)
	protected com.collaborated.entity.service.Custom_Workflow_CompletedLocalService custom_Workflow_CompletedLocalService;
	@BeanReference(type = Custom_Workflow_CompletedPersistence.class)
	protected Custom_Workflow_CompletedPersistence custom_Workflow_CompletedPersistence;
	@BeanReference(type = com.collaborated.entity.service.Custom_Workflow_TaskLocalService.class)
	protected com.collaborated.entity.service.Custom_Workflow_TaskLocalService custom_Workflow_TaskLocalService;
	@BeanReference(type = Custom_Workflow_TaskPersistence.class)
	protected Custom_Workflow_TaskPersistence custom_Workflow_TaskPersistence;
	@BeanReference(type = com.collaborated.entity.service.Custom_Workflow_TransitionLocalService.class)
	protected com.collaborated.entity.service.Custom_Workflow_TransitionLocalService custom_Workflow_TransitionLocalService;
	@BeanReference(type = Custom_Workflow_TransitionPersistence.class)
	protected Custom_Workflow_TransitionPersistence custom_Workflow_TransitionPersistence;
	@BeanReference(type = com.collaborated.entity.service.Custom_WorkflowLogLocalService.class)
	protected com.collaborated.entity.service.Custom_WorkflowLogLocalService custom_WorkflowLogLocalService;
	@BeanReference(type = Custom_WorkflowLogPersistence.class)
	protected Custom_WorkflowLogPersistence custom_WorkflowLogPersistence;
	@BeanReference(type = com.collaborated.entity.service.labDetailedActivityTableLocalService.class)
	protected com.collaborated.entity.service.labDetailedActivityTableLocalService labDetailedActivityTableLocalService;
	@BeanReference(type = labDetailedActivityTablePersistence.class)
	protected labDetailedActivityTablePersistence labDetailedActivityTablePersistence;
	@BeanReference(type = com.collaborated.entity.service.labDetailedCourseHoursLocalService.class)
	protected com.collaborated.entity.service.labDetailedCourseHoursLocalService labDetailedCourseHoursLocalService;
	@BeanReference(type = labDetailedCourseHoursPersistence.class)
	protected labDetailedCourseHoursPersistence labDetailedCourseHoursPersistence;
	@BeanReference(type = com.collaborated.entity.service.labDetailedCourseIdentificationLocalService.class)
	protected com.collaborated.entity.service.labDetailedCourseIdentificationLocalService labDetailedCourseIdentificationLocalService;
	@BeanReference(type = labDetailedCourseIdentificationPersistence.class)
	protected labDetailedCourseIdentificationPersistence labDetailedCourseIdentificationPersistence;
	@BeanReference(type = com.collaborated.entity.service.labDetailedCourseObjectivesLocalService.class)
	protected com.collaborated.entity.service.labDetailedCourseObjectivesLocalService labDetailedCourseObjectivesLocalService;
	@BeanReference(type = labDetailedCourseObjectivesPersistence.class)
	protected labDetailedCourseObjectivesPersistence labDetailedCourseObjectivesPersistence;
	@BeanReference(type = com.collaborated.entity.service.labDetailedCourseResourcesLocalService.class)
	protected com.collaborated.entity.service.labDetailedCourseResourcesLocalService labDetailedCourseResourcesLocalService;
	@BeanReference(type = labDetailedCourseResourcesPersistence.class)
	protected labDetailedCourseResourcesPersistence labDetailedCourseResourcesPersistence;
	@BeanReference(type = com.collaborated.entity.service.labDetailedCourseTopicsLocalService.class)
	protected com.collaborated.entity.service.labDetailedCourseTopicsLocalService labDetailedCourseTopicsLocalService;
	@BeanReference(type = labDetailedCourseTopicsPersistence.class)
	protected labDetailedCourseTopicsPersistence labDetailedCourseTopicsPersistence;
	@BeanReference(type = com.collaborated.entity.service.labDetailedInstructorQualificationLocalService.class)
	protected com.collaborated.entity.service.labDetailedInstructorQualificationLocalService labDetailedInstructorQualificationLocalService;
	@BeanReference(type = labDetailedInstructorQualificationPersistence.class)
	protected labDetailedInstructorQualificationPersistence labDetailedInstructorQualificationPersistence;
	@BeanReference(type = com.collaborated.entity.service.labDetailedLearningEnvironmentsLocalService.class)
	protected com.collaborated.entity.service.labDetailedLearningEnvironmentsLocalService labDetailedLearningEnvironmentsLocalService;
	@BeanReference(type = labDetailedLearningEnvironmentsPersistence.class)
	protected labDetailedLearningEnvironmentsPersistence labDetailedLearningEnvironmentsPersistence;
	@BeanReference(type = com.collaborated.entity.service.labScreenProjectOverviewLocalService.class)
	protected com.collaborated.entity.service.labScreenProjectOverviewLocalService labScreenProjectOverviewLocalService;
	@BeanReference(type = labScreenProjectOverviewPersistence.class)
	protected labScreenProjectOverviewPersistence labScreenProjectOverviewPersistence;
	@BeanReference(type = com.collaborated.entity.service.labScreenProjectPartnersLocalService.class)
	protected com.collaborated.entity.service.labScreenProjectPartnersLocalService labScreenProjectPartnersLocalService;
	@BeanReference(type = labScreenProjectPartnersPersistence.class)
	protected labScreenProjectPartnersPersistence labScreenProjectPartnersPersistence;
	@BeanReference(type = com.collaborated.entity.service.labScreenTaskLocalService.class)
	protected com.collaborated.entity.service.labScreenTaskLocalService labScreenTaskLocalService;
	@BeanReference(type = labScreenTaskPersistence.class)
	protected labScreenTaskPersistence labScreenTaskPersistence;
	@BeanReference(type = com.collaborated.entity.service.languagePreferencesLocalService.class)
	protected com.collaborated.entity.service.languagePreferencesLocalService languagePreferencesLocalService;
	@BeanReference(type = languagePreferencesPersistence.class)
	protected languagePreferencesPersistence languagePreferencesPersistence;
	@BeanReference(type = profileAreaofinterestLocalService.class)
	protected profileAreaofinterestLocalService profileAreaofinterestLocalService;
	@BeanReference(type = profileAreaofinterestPersistence.class)
	protected profileAreaofinterestPersistence profileAreaofinterestPersistence;
	@BeanReference(type = com.collaborated.entity.service.projectDiscussionLocalService.class)
	protected com.collaborated.entity.service.projectDiscussionLocalService projectDiscussionLocalService;
	@BeanReference(type = projectDiscussionPersistence.class)
	protected projectDiscussionPersistence projectDiscussionPersistence;
	@BeanReference(type = com.collaborated.entity.service.projectFilesUploadLocalService.class)
	protected com.collaborated.entity.service.projectFilesUploadLocalService projectFilesUploadLocalService;
	@BeanReference(type = projectFilesUploadPersistence.class)
	protected projectFilesUploadPersistence projectFilesUploadPersistence;
	@BeanReference(type = com.collaborated.entity.service.projectFolderUploadLocalService.class)
	protected com.collaborated.entity.service.projectFolderUploadLocalService projectFolderUploadLocalService;
	@BeanReference(type = projectFolderUploadPersistence.class)
	protected projectFolderUploadPersistence projectFolderUploadPersistence;
	@BeanReference(type = com.collaborated.entity.service.projectInviteTrackingLocalService.class)
	protected com.collaborated.entity.service.projectInviteTrackingLocalService projectInviteTrackingLocalService;
	@BeanReference(type = projectInviteTrackingPersistence.class)
	protected projectInviteTrackingPersistence projectInviteTrackingPersistence;
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
	@BeanReference(type = com.collaborated.entity.service.userProfileImageLocalService.class)
	protected com.collaborated.entity.service.userProfileImageLocalService userProfileImageLocalService;
	@BeanReference(type = userProfileImagePersistence.class)
	protected userProfileImagePersistence userProfileImagePersistence;
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