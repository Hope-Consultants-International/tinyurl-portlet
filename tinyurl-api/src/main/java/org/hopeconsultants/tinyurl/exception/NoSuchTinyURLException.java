/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package org.hopeconsultants.tinyurl.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Hope Consultants International
 */
@ProviderType
public class NoSuchTinyURLException extends NoSuchModelException {

	public NoSuchTinyURLException() {
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