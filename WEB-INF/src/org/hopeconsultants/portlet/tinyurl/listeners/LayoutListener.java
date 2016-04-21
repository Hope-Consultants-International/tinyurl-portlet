/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.portlet.tinyurl.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.Layout;

import org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException;
import org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalServiceUtil;
import org.hopeconsultants.portlet.tinyurl.util.TinyURLConstants;

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
			TinyURLLocalServiceUtil.addTinyURL(
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
			TinyURLLocalServiceUtil.deleteByC_P(
				TinyURLConstants.CLASSNAMEID_LAYOUT, layout.getPlid());
		}
		catch (NoSuchTinyURLException nstue) {
			// Don't worry if it's missing.
		}
		catch (SystemException se) {
			throw new ModelListenerException(se);
		}
	}

	private final Log _log = LogFactoryUtil.getLog(getClass());

}