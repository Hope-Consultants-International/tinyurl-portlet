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
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

import org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException;
import org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalServiceUtil;
import org.hopeconsultants.portlet.tinyurl.util.TinyURLConstants;

public class AssetEntryListener extends BaseModelListener<AssetEntry> {

	@Override
	public void onBeforeCreate(AssetEntry entry) throws ModelListenerException {
		if (!TinyURLConstants.USABLE_ASSETS.contains(entry.getClassNameId())) {
			return;
		}

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Adding tiny URL for asset " + entry.getTitle());
		}

		try {
			TinyURLLocalServiceUtil.addTinyURL(
				entry.getGroupId(), entry.getCompanyId(),
				entry.getUserId(), entry.getUserName(),
				entry.getClassNameId(), entry.getClassPK(),
				entry.isVisible());
		}
		catch (PortalException pe) {
			throw new ModelListenerException(pe);
		}
		catch (SystemException se) {
			throw new ModelListenerException(se);
		}
	}

	@Override
	public void onBeforeRemove(AssetEntry entry) throws ModelListenerException {
		if (!TinyURLConstants.USABLE_ASSETS.contains(entry.getClassNameId())) {
			return;
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Deleting tiny URL for asset " + entry.getTitle());
		}

		try {
			TinyURLLocalServiceUtil.deleteByC_P(
				entry.getClassNameId(), entry.getClassPK());
		}
		catch (NoSuchTinyURLException nste) {
			// Don't worry if it's missing.
		}
		catch (SystemException se) {
			throw new ModelListenerException(se);
		}
	}

	@Override
	public void onBeforeUpdate(AssetEntry entry) throws ModelListenerException {
		if (!TinyURLConstants.USABLE_ASSETS.contains(entry.getClassNameId())) {
			return;
		}

		try {
			// The AssetEntryImpl class has a field originalStatus, but we
			// can't access it from the interface class. At least the
			// database entity is hopefully still in the entity cache.
			AssetEntry oldEntry = AssetEntryLocalServiceUtil.getAssetEntry(
				entry.getEntryId());

			boolean oldVisible = oldEntry.isVisible();
			boolean visible = entry.isVisible();

			if (visible != oldVisible) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Updating tiny URL for asset " + entry.getTitle());
				}

				TinyURLLocalServiceUtil.updateVisible(
					entry.getClassNameId(), entry.getClassPK(), visible);
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