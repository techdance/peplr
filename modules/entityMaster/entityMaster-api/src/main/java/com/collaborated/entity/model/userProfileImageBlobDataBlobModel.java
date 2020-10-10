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

package com.collaborated.entity.model;

import aQute.bnd.annotation.ProviderType;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the blobData column in userProfileImage.
 *
 * @author Brian Wing Shun Chan
 * @see userProfileImage
 * @generated
 */
@ProviderType
public class userProfileImageBlobDataBlobModel {
	public userProfileImageBlobDataBlobModel() {
	}

	public userProfileImageBlobDataBlobModel(long PK_profileImageId) {
		_PK_profileImageId = PK_profileImageId;
	}

	public userProfileImageBlobDataBlobModel(long PK_profileImageId,
		Blob blobDataBlob) {
		_PK_profileImageId = PK_profileImageId;
		_blobDataBlob = blobDataBlob;
	}

	public long getPK_profileImageId() {
		return _PK_profileImageId;
	}

	public void setPK_profileImageId(long PK_profileImageId) {
		_PK_profileImageId = PK_profileImageId;
	}

	public Blob getBlobDataBlob() {
		return _blobDataBlob;
	}

	public void setBlobDataBlob(Blob blobDataBlob) {
		_blobDataBlob = blobDataBlob;
	}

	private long _PK_profileImageId;
	private Blob _blobDataBlob;
}