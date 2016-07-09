/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.portlet.tinyurl.messaging;

import com.liferay.portal.kernel.messaging.HotDeployMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalServiceUtil;
import org.hopeconsultants.portlet.tinyurl.util.PropsValues;
import org.hopeconsultants.portlet.tinyurl.util.TinyURLUtils;

public class TinyURLHotDeployMessageListener extends HotDeployMessageListener {

	public TinyURLHotDeployMessageListener(String... servletContextNames) {
		super(servletContextNames);
	}

	@Override
	protected void onDeploy(Message message) throws Exception {

		int count = TinyURLLocalServiceUtil.getTinyURLsCount();

		if (count == 0 || PropsValues.TINYURL_VERIFY_ON_STARTUP) {
			TinyURLUtils.verifyDatabase();
		}
	}

}