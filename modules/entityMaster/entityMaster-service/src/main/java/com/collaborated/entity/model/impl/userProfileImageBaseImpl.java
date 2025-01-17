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

package com.collaborated.entity.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;

/**
 * The extended model base implementation for the userProfileImage service. Represents a row in the &quot;collaborated_userProfileImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link userProfileImageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see userProfileImageImpl
 * @see userProfileImage
 * @generated
 */
@ProviderType
public abstract class userProfileImageBaseImpl extends userProfileImageModelImpl
	implements userProfileImage {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user profile image model instance should use the {@link userProfileImage} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			userProfileImageLocalServiceUtil.adduserProfileImage(this);
		}
		else {
			userProfileImageLocalServiceUtil.updateuserProfileImage(this);
		}
	}
}