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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TinyURLLocalService}.
 *
 * @author Hope Consultants International
 * @see TinyURLLocalService
 * @generated
 */
@ProviderType
public class TinyURLLocalServiceWrapper implements TinyURLLocalService,
	ServiceWrapper<TinyURLLocalService> {
	public TinyURLLocalServiceWrapper(TinyURLLocalService tinyURLLocalService) {
		_tinyURLLocalService = tinyURLLocalService;
	}

	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL addTinyURL(long groupId,
		long companyId, long userId, String userName, long classNameId,
		long classPK, boolean visible)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return _tinyURLLocalService.addTinyURL(groupId, companyId, userId,
			userName, classNameId, classPK, visible);
	}

	/**
	* Adds the tiny url to the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny url
	* @return the tiny url that was added
	*/
	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL addTinyURL(
		org.hopeconsultants.tinyurl.model.TinyURL tinyURL) {
		return _tinyURLLocalService.addTinyURL(tinyURL);
	}

	/**
	* Creates a new tiny url with the primary key. Does not add the tiny url to the database.
	*
	* @param tinyURLId the primary key for the new tiny url
	* @return the new tiny url
	*/
	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL createTinyURL(
		long tinyURLId) {
		return _tinyURLLocalService.createTinyURL(tinyURLId);
	}

	@Override
	public void deleteByC_P(long classNameId, long classPK)
		throws org.hopeconsultants.tinyurl.exception.NoSuchTinyURLException,
			com.liferay.portal.kernel.exception.SystemException {
		_tinyURLLocalService.deleteByC_P(classNameId, classPK);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tinyURLLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tiny url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url that was removed
	* @throws PortalException if a tiny url with the primary key could not be found
	*/
	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL deleteTinyURL(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tinyURLLocalService.deleteTinyURL(tinyURLId);
	}

	/**
	* Deletes the tiny url from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny url
	* @return the tiny url that was removed
	*/
	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL deleteTinyURL(
		org.hopeconsultants.tinyurl.model.TinyURL tinyURL) {
		return _tinyURLLocalService.deleteTinyURL(tinyURL);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tinyURLLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _tinyURLLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _tinyURLLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _tinyURLLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _tinyURLLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _tinyURLLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL fetchByC_P(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.fetchByC_P(classNameId, classPK);
	}

	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL fetchBycode(String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.fetchBycode(code);
	}

	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL fetchTinyURL(
		long tinyURLId) {
		return _tinyURLLocalService.fetchTinyURL(tinyURLId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tinyURLLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _tinyURLLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _tinyURLLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tinyURLLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tiny url with the primary key.
	*
	* @param tinyURLId the primary key of the tiny url
	* @return the tiny url
	* @throws PortalException if a tiny url with the primary key could not be found
	*/
	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL getTinyURL(long tinyURLId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tinyURLLocalService.getTinyURL(tinyURLId);
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
	@Override
	public java.util.List<org.hopeconsultants.tinyurl.model.TinyURL> getTinyURLs(
		int start, int end) {
		return _tinyURLLocalService.getTinyURLs(start, end);
	}

	/**
	* Returns the number of tiny urls.
	*
	* @return the number of tiny urls
	*/
	@Override
	public int getTinyURLsCount() {
		return _tinyURLLocalService.getTinyURLsCount();
	}

	/**
	* Updates the tiny url in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny url
	* @return the tiny url that was updated
	*/
	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL updateTinyURL(
		org.hopeconsultants.tinyurl.model.TinyURL tinyURL) {
		return _tinyURLLocalService.updateTinyURL(tinyURL);
	}

	@Override
	public org.hopeconsultants.tinyurl.model.TinyURL updateVisible(
		long classNameId, long classPK, boolean visible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.updateVisible(classNameId, classPK, visible);
	}

	@Override
	public TinyURLLocalService getWrappedService() {
		return _tinyURLLocalService;
	}

	@Override
	public void setWrappedService(TinyURLLocalService tinyURLLocalService) {
		_tinyURLLocalService = tinyURLLocalService;
	}

	private TinyURLLocalService _tinyURLLocalService;
}