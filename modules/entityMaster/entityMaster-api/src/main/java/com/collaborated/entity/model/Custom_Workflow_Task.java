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
 * The extended model interface for the Custom_Workflow_Task service. Represents a row in the &quot;collaborated_Custom_Workflow_Task&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_Workflow_TaskModel
 * @see com.collaborated.entity.model.impl.Custom_Workflow_TaskImpl
 * @see com.collaborated.entity.model.impl.Custom_Workflow_TaskModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.Custom_Workflow_TaskImpl")
@ProviderType
public interface Custom_Workflow_Task extends Custom_Workflow_TaskModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.Custom_Workflow_TaskImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Custom_Workflow_Task, String> WORK_FLOW_TASK_ID_ACCESSOR =
		new Accessor<Custom_Workflow_Task, String>() {
			@Override
			public String get(Custom_Workflow_Task custom_Workflow_Task) {
				return custom_Workflow_Task.getWorkFlowTaskId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Custom_Workflow_Task> getTypeClass() {
				return Custom_Workflow_Task.class;
			}
		};
}