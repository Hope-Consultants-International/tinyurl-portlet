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

package org.hopeconsultants.portlet.tinyurl.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for TinyURL. This utility wraps
 * {@link org.hopeconsultants.portlet.tinyurl.service.impl.TinyURLLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Hope Consultants International
 * @see TinyURLLocalService
 * @see org.hopeconsultants.portlet.tinyurl.service.base.TinyURLLocalServiceBaseImpl
 * @see org.hopeconsultants.portlet.tinyurl.service.impl.TinyURLLocalServiceImpl
 * @generated
 */
public class TinyURLLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.hopeconsultants.portlet.tinyurl.service.impl.TinyURLLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tiny u r l to the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny u r l
	* @return the tiny u r l that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL addTinyURL(
		org.hopeconsultants.portlet.tinyurl.model.TinyURL tinyURL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTinyURL(tinyURL);
	}

	/**
	* Creates a new tiny u r l with the primary key. Does not add the tiny u r l to the database.
	*
	* @param tinyURLId the primary key for the new tiny u r l
	* @return the new tiny u r l
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL createTinyURL(
		long tinyURLId) {
		return getService().createTinyURL(tinyURLId);
	}

	/**
	* Deletes the tiny u r l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l that was removed
	* @throws PortalException if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL deleteTinyURL(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTinyURL(tinyURLId);
	}

	/**
	* Deletes the tiny u r l from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny u r l
	* @return the tiny u r l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL deleteTinyURL(
		org.hopeconsultants.portlet.tinyurl.model.TinyURL tinyURL)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.hopeconsultants.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.hopeconsultants.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL fetchTinyURL(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTinyURL(tinyURLId);
	}

	/**
	* Returns the tiny u r l with the primary key.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l
	* @throws PortalException if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL getTinyURL(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTinyURL(tinyURLId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tiny u r ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.hopeconsultants.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tiny u r ls
	* @param end the upper bound of the range of tiny u r ls (not inclusive)
	* @return the range of tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.hopeconsultants.portlet.tinyurl.model.TinyURL> getTinyURLs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTinyURLs(start, end);
	}

	/**
	* Returns the number of tiny u r ls.
	*
	* @return the number of tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public static int getTinyURLsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTinyURLsCount();
	}

	/**
	* Updates the tiny u r l in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tinyURL the tiny u r l
	* @return the tiny u r l that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL updateTinyURL(
		org.hopeconsultants.portlet.tinyurl.model.TinyURL tinyURL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTinyURL(tinyURL);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL addTinyURL(
		long groupId, long companyId, long userId, java.lang.String userName,
		long classNameId, long classPK, boolean visible)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTinyURL(groupId, companyId, userId, userName,
			classNameId, classPK, visible);
	}

	public static void deleteByC_P(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException {
		getService().deleteByC_P(classNameId, classPK);
	}

	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL fetchByC_P(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByC_P(classNameId, classPK);
	}

	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL fetchBycode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBycode(code);
	}

	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL updateVisible(
		long classNameId, long classPK, boolean visible)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVisible(classNameId, classPK, visible);
	}

	public static void clearService() {
		_service = null;
	}

	public static TinyURLLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TinyURLLocalService.class.getName());

			if (invokableLocalService instanceof TinyURLLocalService) {
				_service = (TinyURLLocalService)invokableLocalService;
			}
			else {
				_service = new TinyURLLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TinyURLLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TinyURLLocalService service) {
	}

	private static TinyURLLocalService _service;
}