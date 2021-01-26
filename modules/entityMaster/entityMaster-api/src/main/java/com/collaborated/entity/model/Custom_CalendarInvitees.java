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
 * The extended model interface for the Custom_CalendarInvitees service. Represents a row in the &quot;collaborated_Custom_CalendarInvitees&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Custom_CalendarInviteesModel
 * @see com.collaborated.entity.model.impl.Custom_CalendarInviteesImpl
 * @see com.collaborated.entity.model.impl.Custom_CalendarInviteesModelImpl
 * @generated
 */
@ImplementationClassName("com.collaborated.entity.model.impl.Custom_CalendarInviteesImpl")
@ProviderType
public interface Custom_CalendarInvitees extends Custom_CalendarInviteesModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.collaborated.entity.model.impl.Custom_CalendarInviteesImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Custom_CalendarInvitees, Long> P_K_CALENDAR_EVENT_SUB_ID_ACCESSOR =
		new Accessor<Custom_CalendarInvitees, Long>() {
			@Override
			public Long get(Custom_CalendarInvitees custom_CalendarInvitees) {
				return custom_CalendarInvitees.getPK_calendarEventSubId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Custom_CalendarInvitees> getTypeClass() {
				return Custom_CalendarInvitees.class;
			}
		};
}