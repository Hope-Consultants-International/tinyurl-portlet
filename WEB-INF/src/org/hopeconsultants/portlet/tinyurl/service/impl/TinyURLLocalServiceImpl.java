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
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 *
 */

package org.hopeconsultants.portlet.tinyurl.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import java.util.Date;

import org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException;
import org.hopeconsultants.portlet.tinyurl.model.TinyURL;
import org.hopeconsultants.portlet.tinyurl.service.base.TinyURLLocalServiceBaseImpl;
import org.hopeconsultants.portlet.tinyurl.util.TinyURLUtils;

/**
 * The implementation of the tiny u r l local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Hope Consultants International
 * @see org.hopeconsultants.portlet.tinyurl.service.base.TinyURLLocalServiceBaseImpl
 * @see org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalServiceUtil
 */
public class TinyURLLocalServiceImpl extends TinyURLLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalServiceUtil} to access the tiny u r l local service.
	 */
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

	public void deleteByC_P(long classNameId, long classPK)
		throws NoSuchTinyURLException, SystemException {

		tinyURLPersistence.removeByC_P(classNameId, classPK);
	}

	public TinyURL fetchByC_P(long classNameId, long classPK)
		throws SystemException {

		return tinyURLPersistence.fetchByC_P(classNameId, classPK);
	}

	public TinyURL fetchBycode(String code) throws SystemException {

		return tinyURLPersistence.fetchBycode(code);
	}

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