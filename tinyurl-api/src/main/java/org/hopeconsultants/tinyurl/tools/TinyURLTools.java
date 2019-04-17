/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.tinyurl.tools;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.theme.ThemeDisplay;

public interface TinyURLTools {

	String FRIENDLY_URL = "FRIENDLY_URL";

    /**
	 * Return the tiny URL corresponding to the friendly URL of a page or asset currently being displayed.
	 * @param  friendlyURL   the friendly URL for which to find the tiny URL
	 * @param  themeDisplay  the ThemeDisplay object in the template context
	 * @return               the absolute tiny URL
	 * @throws PortalException
	 */
	public String getTinyURL(String friendlyURL, ThemeDisplay themeDisplay)
		throws SystemException, PortalException;

}