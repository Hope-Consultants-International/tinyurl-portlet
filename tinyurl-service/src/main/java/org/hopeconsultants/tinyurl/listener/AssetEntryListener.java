/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.tinyurl.listener;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
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
			_tinyURLLocalService.addTinyURL(
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
			_tinyURLLocalService.deleteByC_P(
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
			AssetEntry oldEntry = _assetEntryLocalService.getAssetEntry(
				entry.getEntryId());

			boolean oldVisible = oldEntry.isVisible();
			boolean visible = entry.isVisible();

			if (visible != oldVisible) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Updating tiny URL for asset " + entry.getTitle());
				}

				_tinyURLLocalService.updateVisible(
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

	@Reference(unbind = "-")
	private AssetEntryLocalService _assetEntryLocalService;

	@Reference(unbind = "-")
	private TinyURLLocalService _tinyURLLocalService;

	private final Log _log = LogFactoryUtil.getLog(getClass());

}