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

package com.hci.portlet.tinyurl.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TinyURLLocalService}.
 *
 * @author Hope Consultants International
 * @see TinyURLLocalService
 * @generated
 */
public class TinyURLLocalServiceWrapper implements TinyURLLocalService,
	ServiceWrapper<TinyURLLocalService> {
	public TinyURLLocalServiceWrapper(TinyURLLocalService tinyURLLocalService) {
		_tinyURLLocalService = tinyURLLocalService;
	}

	/**
	* Adds the tiny u r l to the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny u r l
	* @return the tiny u r l that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.hci.portlet.tinyurl.model.TinyURL addTinyURL(
		com.hci.portlet.tinyurl.model.TinyURL tinyURL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.addTinyURL(tinyURL);
	}

	/**
	* Creates a new tiny u r l with the primary key. Does not add the tiny u r l to the database.
	*
	* @param tinyURLId the primary key for the new tiny u r l
	* @return the new tiny u r l
	*/
	@Override
	public com.hci.portlet.tinyurl.model.TinyURL createTinyURL(long tinyURLId) {
		return _tinyURLLocalService.createTinyURL(tinyURLId);
	}

	/**
	* Deletes the tiny u r l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l that was removed
	* @throws PortalException if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.hci.portlet.tinyurl.model.TinyURL deleteTinyURL(long tinyURLId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.deleteTinyURL(tinyURLId);
	}

	/**
	* Deletes the tiny u r l from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny u r l
	* @return the tiny u r l that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.hci.portlet.tinyurl.model.TinyURL deleteTinyURL(
		com.hci.portlet.tinyurl.model.TinyURL tinyURL)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.hci.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.hci.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.hci.portlet.tinyurl.model.TinyURL fetchTinyURL(long tinyURLId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.fetchTinyURL(tinyURLId);
	}

	/**
	* Returns the tiny u r l with the primary key.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l
	* @throws PortalException if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.hci.portlet.tinyurl.model.TinyURL getTinyURL(long tinyURLId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.getTinyURL(tinyURLId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tiny u r ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.hci.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tiny u r ls
	* @param end the upper bound of the range of tiny u r ls (not inclusive)
	* @return the range of tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.hci.portlet.tinyurl.model.TinyURL> getTinyURLs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.getTinyURLs(start, end);
	}

	/**
	* Returns the number of tiny u r ls.
	*
	* @return the number of tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTinyURLsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.getTinyURLsCount();
	}

	/**
	* Updates the tiny u r l in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny u r l
	* @return the tiny u r l that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.hci.portlet.tinyurl.model.TinyURL updateTinyURL(
		com.hci.portlet.tinyurl.model.TinyURL tinyURL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.updateTinyURL(tinyURL);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tinyURLLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tinyURLLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tinyURLLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.hci.portlet.tinyurl.model.TinyURL addTinyURL(long groupId,
		long companyId, long userId, java.lang.String userName,
		long classNameId, long classPK, boolean visible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.addTinyURL(groupId, companyId, userId,
			userName, classNameId, classPK, visible);
	}

	@Override
	public void deleteByC_P(long classNameId, long classPK)
		throws com.hci.portlet.tinyurl.NoSuchTinyURLException,
			com.liferay.portal.kernel.exception.SystemException {
		_tinyURLLocalService.deleteByC_P(classNameId, classPK);
	}

	@Override
	public com.hci.portlet.tinyurl.model.TinyURL fetchByC_P(long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.fetchByC_P(classNameId, classPK);
	}

	@Override
	public com.hci.portlet.tinyurl.model.TinyURL fetchBycode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.fetchBycode(code);
	}

	@Override
	public com.hci.portlet.tinyurl.model.TinyURL updateVisible(
		long classNameId, long classPK, boolean visible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURLLocalService.updateVisible(classNameId, classPK, visible);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TinyURLLocalService getWrappedTinyURLLocalService() {
		return _tinyURLLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTinyURLLocalService(
		TinyURLLocalService tinyURLLocalService) {
		_tinyURLLocalService = tinyURLLocalService;
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