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

package com.collaborated.entity.service.http;

import aQute.bnd.annotation.ProviderType;

import com.collaborated.entity.service.commonWebsserviceAPIServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link commonWebsserviceAPIServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see commonWebsserviceAPIServiceSoap
 * @see HttpPrincipal
 * @see commonWebsserviceAPIServiceUtil
 * @generated
 */
@ProviderType
public class commonWebsserviceAPIServiceHttp {
	public static com.liferay.portal.kernel.json.JSONArray createUser(
		HttpPrincipal httpPrincipal, java.lang.String prefix,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String institutionEmail, java.lang.String institutionName,
		java.lang.String password) {
		try {
			MethodKey methodKey = new MethodKey(commonWebsserviceAPIServiceUtil.class,
					"createUser", _createUserParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, prefix,
					firstName, lastName, institutionEmail, institutionName,
					password);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray customLogin(
		HttpPrincipal httpPrincipal, java.lang.String username,
		java.lang.String password) {
		try {
			MethodKey methodKey = new MethodKey(commonWebsserviceAPIServiceUtil.class,
					"customLogin", _customLoginParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					username, password);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(commonWebsserviceAPIServiceHttp.class);
	private static final Class<?>[] _createUserParameterTypes0 = new Class[] {
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class
		};
	private static final Class<?>[] _customLoginParameterTypes1 = new Class[] {
			java.lang.String.class, java.lang.String.class
		};
}