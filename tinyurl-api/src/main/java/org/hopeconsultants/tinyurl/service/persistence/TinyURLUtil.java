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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.hopeconsultants.tinyurl.model.TinyURL;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tiny url service. This utility wraps {@link org.hopeconsultants.tinyurl.service.persistence.impl.TinyURLPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hope Consultants International
 * @see TinyURLPersistence
 * @see org.hopeconsultants.tinyurl.service.persistence.impl.TinyURLPersistenceImpl
 * @generated
 */
@ProviderType
public class TinyURLUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TinyURL tinyURL) {
		getPersistence().clearCache(tinyURL);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TinyURL> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TinyURL> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TinyURL> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TinyURL> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TinyURL update(TinyURL tinyURL) {
		return getPersistence().update(tinyURL);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TinyURL update(TinyURL tinyURL, ServiceContext serviceContext) {
		return getPersistence().update(tinyURL, serviceContext);
	}

	/**
	* Returns the tiny url where classNameId = &#63; and classPK = &#63; or throws a {@link NoSuchTinyURLException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching tiny url
	* @throws NoSuchTinyURLException if a matching tiny url could not be found
	*/
	public static TinyURL findByC_P(long classNameId, long classPK)
		throws org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException {
		return getPersistence().findByC_P(classNameId, classPK);
	}

	/**
	* Returns the tiny url where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	*/
	public static TinyURL fetchByC_P(long classNameId, long classPK) {
		return getPersistence().fetchByC_P(classNameId, classPK);
	}

	/**
	* Returns the tiny url where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	*/
	public static TinyURL fetchByC_P(long classNameId, long classPK,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_P(classNameId, classPK, retrieveFromCache);
	}

	/**
	* Removes the tiny url where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the tiny url that was removed
	*/
	public static TinyURL removeByC_P(long classNameId, long classPK)
		throws org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException {
		return getPersistence().removeByC_P(classNameId, classPK);
	}

	/**
	* Returns the number of tiny urls where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the number of matching tiny urls
	*/
	public static int countByC_P(long classNameId, long classPK) {
		return getPersistence().countByC_P(classNameId, classPK);
	}

	/**
	* Returns the tiny url where code = &#63; or throws a {@link NoSuchTinyURLException} if it could not be found.
	*
	* @param code the code
	* @return the matching tiny url
	* @throws NoSuchTinyURLException if a matching tiny url could not be found
	*/
	public static TinyURL findBycode(String code)
		throws org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException {
		return getPersistence().findBycode(code);
	}

	/**
	* Returns the tiny url where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	*/
	public static TinyURL fetchBycode(String code) {
		return getPersistence().fetchBycode(code);
	}

	/**
	* Returns the tiny url where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tiny url, or <code>null</code> if a matching tiny url could not be found
	*/
	public static TinyURL fetchBycode(String code, boolean retrieveFromCache) {
		return getPersistence().fetchBycode(code, retrieveFromCache);
	}

	/**
	* Removes the tiny url where code = &#63; from the database.
	*
	* @param code the code
	* @return the tiny url that was removed
	*/
	public static TinyURL removeBycode(String code)
		throws org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException {
		return getPersistence().removeBycode(code);
	}

	/**
	* Returns the number of tiny urls where code = &#63;.
	*
	* @param code the code
	* @return the number of matching tiny urls
	*/
	public static int countBycode(String code) {
		return getPersistence().countBycode(code);
	}

	/**
	* Caches the tiny url in the entity cache if it is enabled.
	*
	* @param tinyURL the tiny url
	*/
	public static void cacheResult(TinyURL tinyURL) {
		getPersistence().cacheResult(tinyURL);
	}

	/**
	* Caches the tiny urls in the entity cache if it is enabled.
	*
	* @param tinyURLs the tiny urls
	*/
	public static void cacheResult(List<TinyURL> tinyURLs) {
		getPersistence().cacheResult(tinyURLs);
	}

	/**
	* Creates a new tiny url with the primary key. Does not add the tiny url to the database.
	*
	* @param tinyURLId the primary key for the new tiny url
	* @return the new tiny url
	*/
	public static TinyURL create(long tinyURLId) {
		return getPersistence().create(tinyURLId);
	}

	/**
	* Removes the tiny url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url that was removed
	* @throws NoSuchTinyURLException if a tiny url with the primary key could not be found
	*/
	public static TinyURL remove(long tinyURLId)
		throws org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException {
		return getPersistence().remove(tinyURLId);
	}

	public static TinyURL updateImpl(TinyURL tinyURL) {
		return getPersistence().updateImpl(tinyURL);
	}

	/**
	* Returns the tiny url with the primary key or throws a {@link NoSuchTinyURLException} if it could not be found.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url
	* @throws NoSuchTinyURLException if a tiny url with the primary key could not be found
	*/
	public static TinyURL findByPrimaryKey(long tinyURLId)
		throws org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException {
		return getPersistence().findByPrimaryKey(tinyURLId);
	}

	/**
	* Returns the tiny url with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url, or <code>null</code> if a tiny url with the primary key could not be found
	*/
	public static TinyURL fetchByPrimaryKey(long tinyURLId) {
		return getPersistence().fetchByPrimaryKey(tinyURLId);
	}

	public static java.util.Map<java.io.Serializable, TinyURL> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tiny urls.
	*
	* @return the tiny urls
	*/
	public static List<TinyURL> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TinyURL> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TinyURL> findAll(int start, int end,
		OrderByComparator<TinyURL> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TinyURL> findAll(int start, int end,
		OrderByComparator<TinyURL> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tiny urls from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tiny urls.
	*
	* @return the number of tiny urls
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TinyURLPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TinyURLPersistence, TinyURLPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TinyURLPersistence.class);

		ServiceTracker<TinyURLPersistence, TinyURLPersistence> serviceTracker = new ServiceTracker<TinyURLPersistence, TinyURLPersistence>(bundle.getBundleContext(),
				TinyURLPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}