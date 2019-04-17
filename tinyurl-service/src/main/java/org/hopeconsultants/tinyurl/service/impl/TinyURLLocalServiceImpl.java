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

package org.hopeconsultants.tinyurl.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;

import org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException;
import org.hopeconsultants.tinyurl.model.TinyURL;
import org.hopeconsultants.tinyurl.service.base.TinyURLLocalServiceBaseImpl;
import org.hopeconsultants.tinyurl.util.TinyURLUtils;

/**
 * The implementation of the tiny url local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.hopeconsultants.tinyurl.service.TinyURLLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Hope Consultants International
 * @see TinyURLLocalServiceBaseImpl
 * @see org.hopeconsultants.tinyurl.service.TinyURLLocalServiceUtil
 */
public class TinyURLLocalServiceImpl extends TinyURLLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link org.hopeconsultants.tinyurl.service.TinyURLLocalServiceUtil} to access the tiny url local service.
	 */
	@Override
	public TinyURL addTinyURL(long groupId, long companyId, long userId,
			String userName, long classNameId, long classPK, boolean visible)
		throws SystemException, PortalException {

		Date now = new Date();

		long tinyURLId = counterLocalService.increment(TinyURL.class.getName());
		TinyURL tinyURL = tinyURLPersistence.create(tinyURLId);

		tinyURL.setGroupId(groupId);
		tinyURL.setCompanyId(companyId);
		tinyURL.setUserId(userId);
		// Note: if the user was deregistered after creating the asset
		// corresponding to this tinyURL, we will not be able to get his
		// name just from the userid.
		tinyURL.setUserName(userName);
		tinyURL.setCreateDate(now);
		tinyURL.setModifiedDate(now);

		tinyURL.setClassNameId(classNameId);
		tinyURL.setClassPK(classPK);
		tinyURL.setCode(TinyURLUtils.generateCode(tinyURLId));
		tinyURL.setVisible(visible);

		tinyURLPersistence.update(tinyURL);

		return tinyURL;
	}

	@Override
	public void deleteByC_P(long classNameId, long classPK)
		throws NoSuchTinyURLException, SystemException {

		tinyURLPersistence.removeByC_P(classNameId, classPK);
	}

	@Override
	public TinyURL fetchByC_P(long classNameId, long classPK)
		throws SystemException {

		return tinyURLPersistence.fetchByC_P(classNameId, classPK);
	}

	@Override
	public TinyURL fetchBycode(String code) throws SystemException {

		return tinyURLPersistence.fetchBycode(code);
	}

	@Override
	public TinyURL updateVisible(
			long classNameId, long classPK, boolean visible)
		throws SystemException {

		TinyURL tinyURL = tinyURLPersistence.fetchByC_P(classNameId, classPK);

		if (tinyURL != null) {
			tinyURL.setVisible(visible);

			tinyURL = tinyURLPersistence.update(tinyURL);
		}

		return tinyURL;
	}

}