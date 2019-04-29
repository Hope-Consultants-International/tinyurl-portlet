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

package org.hopeconsultants.tinyurl.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TinyURL. This utility wraps
 * {@link org.hopeconsultants.tinyurl.service.impl.TinyURLLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Hope Consultants International
 * @see TinyURLLocalService
 * @see org.hopeconsultants.tinyurl.service.base.TinyURLLocalServiceBaseImpl
 * @see org.hopeconsultants.tinyurl.service.impl.TinyURLLocalServiceImpl
 * @generated
 */
@ProviderType
public class TinyURLLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.hopeconsultants.tinyurl.service.impl.TinyURLLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static org.hopeconsultants.tinyurl.model.TinyURL addTinyURL(
		long groupId, long companyId, long userId, String userName,
		long classNameId, long classPK, boolean visible)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTinyURL(groupId, companyId, userId, userName,
			classNameId, classPK, visible);
	}

	/**
	* Adds the tiny url to the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny url
	* @return the tiny url that was added
	*/
	public static org.hopeconsultants.tinyurl.model.TinyURL addTinyURL(
		org.hopeconsultants.tinyurl.model.TinyURL tinyURL) {
		return getService().addTinyURL(tinyURL);
	}

	/**
	* Creates a new tiny url with the primary key. Does not add the tiny url to the database.
	*
	* @param tinyURLId the primary key for the new tiny url
	* @return the new tiny url
	*/
	public static org.hopeconsultants.tinyurl.model.TinyURL createTinyURL(
		long tinyURLId) {
		return getService().createTinyURL(tinyURLId);
	}

	public static void deleteByC_P(long classNameId, long classPK)
		throws org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteByC_P(classNameId, classPK);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tiny url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url that was removed
	* @throws PortalException if a tiny url with the primary key could not be found
	*/
	public static org.hopeconsultants.tinyurl.model.TinyURL deleteTinyURL(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTinyURL(tinyURLId);
	}

	/**
	* Deletes the tiny url from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny url
	* @return the tiny url that was removed
	*/
	public static org.hopeconsultants.tinyurl.model.TinyURL deleteTinyURL(
		org.hopeconsultants.tinyurl.model.TinyURL tinyURL) {
		return getService().deleteTinyURL(tinyURL);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.hopeconsultants.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.hopeconsultants.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.hopeconsultants.tinyurl.model.TinyURL fetchByC_P(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByC_P(classNameId, classPK);
	}

	public static org.hopeconsultants.tinyurl.model.TinyURL fetchBycode(
		String code) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBycode(code);
	}

	public static org.hopeconsultants.tinyurl.model.TinyURL fetchTinyURL(
		long tinyURLId) {
		return getService().fetchTinyURL(tinyURLId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tiny url with the primary key.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url
	* @throws PortalException if a tiny url with the primary key could not be found
	*/
	public static org.hopeconsultants.tinyurl.model.TinyURL getTinyURL(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTinyURL(tinyURLId);
	}

	/**
	* Returns a range of all the tiny urls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.hopeconsultants.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tiny urls
	* @param end the upper bound of the range of tiny urls (not inclusive)
	* @return the range of tiny urls
	*/
	public static java.util.List<org.hopeconsultants.tinyurl.model.TinyURL> getTinyURLs(
		int start, int end) {
		return getService().getTinyURLs(start, end);
	}

	/**
	* Returns the number of tiny urls.
	*
	* @return the number of tiny urls
	*/
	public static int getTinyURLsCount() {
		return getService().getTinyURLsCount();
	}

	/**
	* Updates the tiny url in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny url
	* @return the tiny url that was updated
	*/
	public static org.hopeconsultants.tinyurl.model.TinyURL updateTinyURL(
		org.hopeconsultants.tinyurl.model.TinyURL tinyURL) {
		return getService().updateTinyURL(tinyURL);
	}

	public static org.hopeconsultants.tinyurl.model.TinyURL updateVisible(
		long classNameId, long classPK, boolean visible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVisible(classNameId, classPK, visible);
	}

	public static TinyURLLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TinyURLLocalService, TinyURLLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TinyURLLocalService.class);

		ServiceTracker<TinyURLLocalService, TinyURLLocalService> serviceTracker = new ServiceTracker<TinyURLLocalService, TinyURLLocalService>(bundle.getBundleContext(),
				TinyURLLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}