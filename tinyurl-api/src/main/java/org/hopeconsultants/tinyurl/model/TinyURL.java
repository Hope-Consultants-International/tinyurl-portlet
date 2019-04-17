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

package org.hopeconsultants.tinyurl.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TinyURL service. Represents a row in the &quot;TinyUrl_TinyURL&quot; database table, with each column mapped to a property of this class.
 *
 * @author Hope Consultants International
 * @see TinyURLModel
 * @see org.hopeconsultants.tinyurl.model.impl.TinyURLImpl
 * @see org.hopeconsultants.tinyurl.model.impl.TinyURLModelImpl
 * @generated
 */
@ImplementationClassName("org.hopeconsultants.tinyurl.model.impl.TinyURLImpl")
@ProviderType
public interface TinyURL extends TinyURLModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.hopeconsultants.tinyurl.model.impl.TinyURLImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TinyURL, Long> TINY_URL_ID_ACCESSOR = new Accessor<TinyURL, Long>() {
			@Override
			public Long get(TinyURL tinyURL) {
				return tinyURL.getTinyURLId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TinyURL> getTypeClass() {
				return TinyURL.class;
			}
		};
}