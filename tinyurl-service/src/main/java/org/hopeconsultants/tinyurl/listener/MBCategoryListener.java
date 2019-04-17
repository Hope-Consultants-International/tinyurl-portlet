/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.tinyurl.listener;

import com.liferay.message.boards.kernel.model.MBCategory;
import com.liferay.message.boards.kernel.service.MBCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException;
import org.hopeconsultants.tinyurl.service.TinyURLLocalService;
import org.hopeconsultants.tinyurl.util.TinyURLConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    service = ModelListener.class
)
public class MBCategoryListener extends BaseModelListener<MBCategory> {

	// Note: MBCategory does not have an associated AssetEntry.

	@Override
	public void onBeforeCreate(MBCategory category)
		throws ModelListenerException {

		if (_log.isDebugEnabled()) {
			_log.debug("Adding tiny URL for MB category " + category.getName());
		}

		try {
			_tinyURLLocalService.addTinyURL(
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
			_tinyURLLocalService.deleteByC_P(
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

				_tinyURLLocalService.updateVisible(
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

	@Reference(unbind = "-")
	private TinyURLLocalService _tinyURLLocalService;

	private final Log _log = LogFactoryUtil.getLog(getClass());

}