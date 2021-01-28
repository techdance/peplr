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

package com.collaborated.entity.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.Date;

import com.collaborated.entity.model.applicationLog;
import com.collaborated.entity.service.applicationLogLocalServiceUtil;
import com.collaborated.entity.service.base.commonWebsserviceAPILocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The implementation of the common websservice a p i local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.collaborated.entity.service.commonWebsserviceAPILocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPILocalServiceBaseImpl
 * @see com.collaborated.entity.service.commonWebsserviceAPILocalServiceUtil
 */
@ProviderType
public class commonWebsserviceAPILocalServiceImpl
	extends commonWebsserviceAPILocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.collaborated.entity.service.commonWebsserviceAPILocalServiceUtil} to access the common websservice a p i local service.
	 */
	public boolean logEntry(JSONObject jsonObject){
		applicationLog applicationLog = null;
		boolean status = false;
		if(jsonObject!=null){
			applicationLog = applicationLogLocalServiceUtil.createapplicationLog(CounterLocalServiceUtil.increment());
			applicationLog.setCreateDate(new Date());
			applicationLog.setUserId(jsonObject.getLong("userId"));
			applicationLog.setUserName(jsonObject.getString("userName"));
			applicationLog.setPageName(jsonObject.getString("pageName"));
			applicationLog.setModuleName(jsonObject.getString("moduleName"));
			applicationLog.setButtonName(jsonObject.getString("buttonName"));
			applicationLog.setProjectId(jsonObject.getLong("projectId"));
			applicationLog.setInterestId(jsonObject.getLong("interestId"));
			applicationLog.setComments(jsonObject.getString("comments"));
			applicationLogLocalServiceUtil.addapplicationLog(applicationLog);
			status = true;
		}
		return status;
	}
}