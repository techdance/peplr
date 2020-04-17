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

import java.util.List;

import com.collaborated.entity.service.base.commonWebsserviceAPIServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.DuplicateUserEmailAddressException;
import com.liferay.portal.kernel.exception.DuplicateUserScreenNameException;
import com.liferay.portal.kernel.exception.NoSuchOrganizationException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.ReservedUserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * The implementation of the common websservice a p i remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.collaborated.entity.service.commonWebsserviceAPIService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPIServiceBaseImpl
 * @see com.collaborated.entity.service.commonWebsserviceAPIServiceUtil
 */
@ProviderType
public class commonWebsserviceAPIServiceImpl
	extends commonWebsserviceAPIServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.collaborated.entity.service.commonWebsserviceAPIServiceUtil} to access the common websservice a p i remote service.
	 */
	
	@JSONWebService
	@AccessControlled(guestAccessEnabled=true)
	public JSONArray createUser(String prefix, String firstName,
			String lastName, String institutionEmail, String institutionName, String password) {
		System.out.println(firstName + "--" + lastName + "--" + institutionEmail + "--"
						+ password + "--" + institutionName );
		String role = "User";
		boolean gender = false;
		long companyId = PortalUtil.getDefaultCompanyId();
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		boolean create = false;
		
		int date = 1;
		int month = 1;
		int year = 1970;

		User user = null;
		Long fbID = 0L;
		
		long prefixId = 0;
		
		/*try{
			System.out.println("companyId:=="+ PortalUtil.getDefaultCompanyId());
			alreadyCreated = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, institutionEmail);
			if(alreadyCreated!=null){
				create = true;
			}
		}catch(Exception e){}*/
		
		try {
			
			long defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
			Role rollobj = RoleLocalServiceUtil.getRole(companyId, role);
			User defaultUser = UserLocalServiceUtil.loadGetDefaultUser(companyId);
			
			System.out.println(rollobj);

			long[] longid = { rollobj.getRoleId() };
			if (create == false) {
				System.out.println(defaultUserId);
				System.out.println(PortalUtil.getDefaultCompanyId());
				System.out.println(password);
				System.out.println(institutionEmail);
				System.out.println(fbID);
				System.out.println(firstName);
				System.out.println(lastName);
				System.out.println(gender);
				System.out.println(month);
				System.out.println(date);
				System.out.println(year);
				System.out.println(longid);
				System.out.println(defaultUser.getLocale());
				
				
				user = UserLocalServiceUtil.addUser(defaultUserId, companyId,
						false, password, password, true ,"" , institutionEmail, 0l,
						"", defaultUser.getLocale(), firstName, "test", lastName, 0, 0, gender, month,
						date, year, null, null, null, longid, null, false,
						new ServiceContext());
				
				/*user = UserLocalServiceUtil.createUser(CounterLocalServiceUtil.increment(User.class.getName()));
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmailAddress(institutionEmail);				
				user.getExpandoBridge().setAttribute("instituteName", institutionName);
				user.setPassword(password);
				user.setPasswordEncrypted(true);
				UserLocalServiceUtil.updateUser(user);
				*/
				/*List<ListType> listType=ListTypeServiceUtil.getListTypes("com.liferay.portal.kernel.model.Contact.prefix");
				for(ListType l:listType){
					if(l.getName().toLowerCase().equals(prefix)){
						prefixId = l.getListTypeId();
					}
				}				
				if(prefixId!=0){
					Contact contact = ContactLocalServiceUtil.getContact(user.getContactId());
					contact.setPrefixId(prefixId);
					ContactLocalServiceUtil.updateContact(contact);
				}				
				else{
					ListType l = ListTypeLocalServiceUtil.addListType(prefix, "com.liferay.portal.kernel.model.Contact.prefix");
					Contact contact = ContactLocalServiceUtil.getContact(user.getContactId());
					contact.setPrefixId(l.getListTypeId());
					ContactLocalServiceUtil.updateContact(contact);
				}*/
				
				json = JSONFactoryUtil.createJSONObject();
				jsonArray = JSONFactoryUtil.createJSONArray();
				json.put("status", "Successfully Created");
				json.put("userId", user.getUserId());
				jsonArray.put(json);
			} else if (create == true) {
				jsonArray = JSONFactoryUtil.createJSONArray();
				json.put("status", "Already Registered");
				jsonArray.put(json);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			// TODO Auto-generated catch block
			if (e instanceof UserPasswordException
					|| e instanceof NoSuchOrganizationException) {
				json = JSONFactoryUtil.createJSONObject();
				jsonArray = JSONFactoryUtil.createJSONArray();
				json.put("staus", "Invalid");
				jsonArray.put(json);

			}

			e.printStackTrace();
			// e.printStackTrace();
		}
		return jsonArray;
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public JSONArray customLogin(String username, String password) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		long userId = 0;
		try{
			long companyId = PortalUtil.getDefaultCompanyId();
			System.out.println("companyId"+companyId);
			String authType = CompanyLocalServiceUtil.getCompany(companyId).getAuthType();
			userId = UserLocalServiceUtil.authenticateForBasic(companyId, authType, username, password);
			
		}catch(Exception e){}
		return jsonArray;
	}
}