/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package org.hopeconsultants.portlet.tinyurl;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Hope Consultants International
 */
public class NoSuchTinyURLException extends NoSuchModelException {

	public NoSuchTinyURLException() {
		super();
	}

	public NoSuchTinyURLException(String msg) {
		super(msg);
	}

	public NoSuchTinyURLException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTinyURLException(Throwable cause) {
		super(cause);
	}

}