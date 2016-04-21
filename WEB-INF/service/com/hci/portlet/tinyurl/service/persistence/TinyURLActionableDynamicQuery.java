/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.hci.portlet.tinyurl.service.persistence;

import com.hci.portlet.tinyurl.model.TinyURL;
import com.hci.portlet.tinyurl.service.TinyURLLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Hope Consultants International
 * @generated
 */
public abstract class TinyURLActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public TinyURLActionableDynamicQuery() throws SystemException {
		setBaseLocalService(TinyURLLocalServiceUtil.getService());
		setClass(TinyURL.class);

		setClassLoader(com.hci.portlet.tinyurl.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("tinyURLId");
	}
}