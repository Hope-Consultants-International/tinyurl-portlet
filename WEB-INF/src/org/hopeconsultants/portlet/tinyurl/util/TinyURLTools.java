/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.portlet.tinyurl.util;

import com.liferay.portal.kernel.exception.SystemException;

import java.util.Map;

public interface TinyURLTools {

	/*
	 * Return the tiny URL corresponding to the friendly URL of a page or asset currently being displayed.
	 * @param  friendlyURL   the friendly URL for which to find the tiny URL
	 * @param  themeDisplay  the flattened ThemeDisplay object in the template context
	 * @return               the absolute tiny URL
	 */
	public String getTinyURL(
			String friendlyURL, Map<String, Object> themeDisplay)
		throws SystemException;

}