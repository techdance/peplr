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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the projectFolderUpload service. Represents a row in the &quot;collaborated_projectFolderUpload&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see projectFolderUploadModel
 * @see com.collaborated.entity.model.impl.projectFolderUploadImpl
 * @see com.collaborated.entity.model.impl.projectFolderUploadModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.projectFolderUploadImpl")
@ProviderType
public interface projectFolderUpload extends projectFolderUploadModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.projectFolderUploadImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<projectFolderUpload, Long> P_K_PROJECT_FOLDER_ID_ACCESSOR =
		new Accessor<projectFolderUpload, Long>() {
			@Override
			public Long get(projectFolderUpload projectFolderUpload) {
				return projectFolderUpload.getPK_projectFolderId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<projectFolderUpload> getTypeClass() {
				return projectFolderUpload.class;
			}
		};
}