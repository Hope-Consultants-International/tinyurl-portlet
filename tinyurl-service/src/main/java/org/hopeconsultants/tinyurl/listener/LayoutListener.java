/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.tinyurl.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Layout;
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
public class LayoutListener extends BaseModelListener<Layout> {

	@Override
	public void onBeforeCreate(Layout layout) throws ModelListenerException {
		_addTinyURL(layout);
	}

	@Override
	public void onBeforeRemove(Layout layout) throws ModelListenerException {
		_deleteTinyURL(layout);
	}

	private void _addTinyURL(Layout layout) throws ModelListenerException {
		if (!layout.isTypePortlet()) {
			return;
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Adding tiny URL for layout " + layout.getFriendlyURL());
		}

		try {
			_tinyURLLocalService.addTinyURL(
				layout.getGroupId(), layout.getCompanyId(),
				layout.getUserId(), layout.getUserName(),
				TinyURLConstants.CLASSNAMEID_LAYOUT, layout.getPlid(), true);
		}
		catch (PortalException pe) {
			throw new ModelListenerException(pe);
		}
		catch (SystemException se) {
			throw new ModelListenerException(se);
		}
	}

	private void _deleteTinyURL(Layout layout) throws ModelListenerException {
		if (_log.isDebugEnabled()) {
			_log.debug(
				"Deleting tiny URL for layout " + layout.getFriendlyURL());
		}

		try {
			_tinyURLLocalService.deleteByC_P(
				TinyURLConstants.CLASSNAMEID_LAYOUT, layout.getPlid());
		}
		catch (NoSuchTinyURLException nstue) {
			// Don't worry if it's missing.
		}
		catch (SystemException se) {
			throw new ModelListenerException(se);
		}
	}

	@Reference(unbind = "-")
	private TinyURLLocalService _tinyURLLocalService;

	private final Log _log = LogFactoryUtil.getLog(getClass());

}