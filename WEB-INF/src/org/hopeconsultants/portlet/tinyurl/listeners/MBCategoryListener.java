/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.portlet.tinyurl.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;

import org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException;
import org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalServiceUtil;
import org.hopeconsultants.portlet.tinyurl.util.TinyURLConstants;

public class MBCategoryListener extends BaseModelListener<MBCategory> {

	// Note: MBCategory does not have an associated AssetEntry.

	@Override
	public void onBeforeCreate(MBCategory category)
		throws ModelListenerException {

		if (_log.isDebugEnabled()) {
			_log.debug("Adding tiny URL for MB category " + category.getName());
		}

		try {
			TinyURLLocalServiceUtil.addTinyURL(
				category.getGroupId(), category.getCompanyId(),
				category.getUserId(), category.getUserName(),
				TinyURLConstants.CLASSNAMEID_MBCATEGORY,
				category.getCategoryId(), category.isApproved());
		}
		catch (PortalException pe) {
			throw new ModelListenerException(pe);
		}
		catch (SystemException se) {
			throw new ModelListenerException(se);
		}
	}

	@Override
	public void onBeforeRemove(MBCategory category)
		throws ModelListenerException {

		if (_log.isDebugEnabled()) {
		_log.debug(
			"Deleting tiny URL for MB category " + category.getName());
		}

		try {
			TinyURLLocalServiceUtil.deleteByC_P(
				TinyURLConstants.CLASSNAMEID_MBCATEGORY,
				category.getCategoryId());
		}
		catch (NoSuchTinyURLException nste) {
			// Don't worry if it's missing.
		}
		catch (SystemException se) {
			throw new ModelListenerException(se);
		}
	}

	@Override
	public void onBeforeUpdate(MBCategory category)
		throws ModelListenerException {

		try {
			// The MBCategoryImpl class has a field originalStatus, but we
			// can't access it from the interface class. At least the database
			// entity is hopefully still in the entity cache.
			MBCategory oldCategory = MBCategoryLocalServiceUtil.getMBCategory(
				category.getCategoryId());

			int oldStatus = oldCategory.getStatus();
			int status = category.getStatus();

			if (status != oldStatus) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Updating tiny URL for MB category " +
							category.getName());
				}

				TinyURLLocalServiceUtil.updateVisible(
					TinyURLConstants.CLASSNAMEID_MBCATEGORY,
					category.getCategoryId(), category.isApproved());
			}
		}
		catch (PortalException pe) {
			throw new ModelListenerException(pe);
		}
		catch (SystemException se) {
			throw new ModelListenerException(se);
		}
	}

	private final Log _log = LogFactoryUtil.getLog(getClass());

}