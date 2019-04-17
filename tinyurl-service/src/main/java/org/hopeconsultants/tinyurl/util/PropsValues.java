/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.tinyurl.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

public class PropsValues {

	public static final int INDEX_SEARCH_LIMIT = GetterUtil.getInteger(PropsUtil.get(PropsKeys.INDEX_SEARCH_LIMIT));

	public static final String LAYOUT_FRIENDLY_URL_PRIVATE_GROUP_SERVLET_MAPPING = PropsUtil.get(PropsKeys.LAYOUT_FRIENDLY_URL_PRIVATE_GROUP_SERVLET_MAPPING);

	public static final String LAYOUT_FRIENDLY_URL_PRIVATE_USER_SERVLET_MAPPING = PropsUtil.get(PropsKeys.LAYOUT_FRIENDLY_URL_PRIVATE_USER_SERVLET_MAPPING);

	public static final String LAYOUT_FRIENDLY_URL_PUBLIC_SERVLET_MAPPING = PropsUtil.get(PropsKeys.LAYOUT_FRIENDLY_URL_PUBLIC_SERVLET_MAPPING);

}