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

package org.hopeconsultants.tinyurl.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException;
import org.hopeconsultants.tinyurl.model.TinyURL;

/**
 * The persistence interface for the tiny url service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hope Consultants International
 * @see org.hopeconsultants.tinyurl.service.persistence.impl.TinyURLPersistenceImpl
 * @see TinyURLUtil
 * @generated
 */
@ProviderType
public interface TinyURLPersistence extends BasePersistence<TinyURL> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TinyURLUtil} to access the tiny url persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the tiny url where classNameId = &#63; and classPK = &#63; or throws a {@link NoSuchTinyURLException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching tiny url
	* @throws NoSuchTinyURLException if a matching tiny url could not be found
	*/
	public TinyURL findByC_P(long classNameId, long classPK)
		throws NoSuchTinyURLException;

	/**
	* Returns the tiny url where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	*/
	public TinyURL fetchByC_P(long classNameId, long classPK);

	/**
	* Returns the tiny url where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	*/
	public TinyURL fetchByC_P(long classNameId, long classPK,
		boolean retrieveFromCache);

	/**
	* Removes the tiny url where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the tiny url that was removed
	*/
	public TinyURL removeByC_P(long classNameId, long classPK)
		throws NoSuchTinyURLException;

	/**
	* Returns the number of tiny urls where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the number of matching tiny urls
	*/
	public int countByC_P(long classNameId, long classPK);

	/**
	* Returns the tiny url where code = &#63; or throws a {@link NoSuchTinyURLException} if it could not be found.
	*
	* @param code the code
	* @return the matching tiny url
	* @throws NoSuchTinyURLException if a matching tiny url could not be found
	*/
	public TinyURL findBycode(java.lang.String code)
		throws NoSuchTinyURLException;

	/**
	* Returns the tiny url where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	*/
	public TinyURL fetchBycode(java.lang.String code);

	/**
	* Returns the tiny url where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	*/
	public TinyURL fetchBycode(java.lang.String code, boolean retrieveFromCache);

	/**
	* Removes the tiny url where code = &#63; from the database.
	*
	* @param code the code
	* @return the tiny url that was removed
	*/
	public TinyURL removeBycode(java.lang.String code)
		throws NoSuchTinyURLException;

	/**
	* Returns the number of tiny urls where code = &#63;.
	*
	* @param code the code
	* @return the number of matching tiny urls
	*/
	public int countBycode(java.lang.String code);

	/**
	* Caches the tiny url in the entity cache if it is enabled.
	*
	* @param tinyURL the tiny url
	*/
	public void cacheResult(TinyURL tinyURL);

	/**
	* Caches the tiny urls in the entity cache if it is enabled.
	*
	* @param tinyURLs the tiny urls
	*/
	public void cacheResult(java.util.List<TinyURL> tinyURLs);

	/**
	* Creates a new tiny url with the primary key. Does not add the tiny url to the database.
	*
	* @param tinyURLId the primary key for the new tiny url
	* @return the new tiny url
	*/
	public TinyURL create(long tinyURLId);

	/**
	* Removes the tiny url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url that was removed
	* @throws NoSuchTinyURLException if a tiny url with the primary key could not be found
	*/
	public TinyURL remove(long tinyURLId) throws NoSuchTinyURLException;

	public TinyURL updateImpl(TinyURL tinyURL);

	/**
	* Returns the tiny url with the primary key or throws a {@link NoSuchTinyURLException} if it could not be found.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url
	* @throws NoSuchTinyURLException if a tiny url with the primary key could not be found
	*/
	public TinyURL findByPrimaryKey(long tinyURLId)
		throws NoSuchTinyURLException;

	/**
	* Returns the tiny url with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url, or <code>null</code> if a tiny url with the primary key could not be found
	*/
	public TinyURL fetchByPrimaryKey(long tinyURLId);

	@Override
	public java.util.Map<java.io.Serializable, TinyURL> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tiny urls.
	*
	* @return the tiny urls
	*/
	public java.util.List<TinyURL> findAll();

	/**
	* Returns a range of all the tiny urls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tiny urls
	* @param end the upper bound of the range of tiny urls (not inclusive)
	* @return the range of tiny urls
	*/
	public java.util.List<TinyURL> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tiny urls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tiny urls
	* @param end the upper bound of the range of tiny urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tiny urls
	*/
	public java.util.List<TinyURL> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TinyURL> orderByComparator);

	/**
	* Returns an ordered range of all the tiny urls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tiny urls
	* @param end the upper bound of the range of tiny urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tiny urls
	*/
	public java.util.List<TinyURL> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TinyURL> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tiny urls from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tiny urls.
	*
	* @return the number of tiny urls
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}