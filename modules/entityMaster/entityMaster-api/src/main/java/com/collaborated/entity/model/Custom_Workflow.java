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
 * The extended model interface for the Custom_Workflow service. Represents a row in the &quot;collaborated_Custom_Workflow&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_WorkflowModel
 * @see com.collaborated.entity.model.impl.Custom_WorkflowImpl
 * @see com.collaborated.entity.model.impl.Custom_WorkflowModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.Custom_WorkflowImpl")
@ProviderType
public interface Custom_Workflow extends Custom_WorkflowModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.Custom_WorkflowImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Custom_Workflow, Long> WORK_FLOW_ID_ACCESSOR = new Accessor<Custom_Workflow, Long>() {
			@Override
			public Long get(Custom_Workflow custom_Workflow) {
				return custom_Workflow.getWorkFlowId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Custom_Workflow> getTypeClass() {
				return Custom_Workflow.class;
			}
		};
}