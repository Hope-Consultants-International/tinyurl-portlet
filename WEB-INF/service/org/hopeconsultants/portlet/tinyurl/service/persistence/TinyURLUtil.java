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

package org.hopeconsultants.portlet.tinyurl.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.hopeconsultants.portlet.tinyurl.model.TinyURL;

import java.util.List;

/**
 * The persistence utility for the tiny u r l service. This utility wraps {@link TinyURLPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hope Consultants International
 * @see TinyURLPersistence
 * @see TinyURLPersistenceImpl
 * @generated
 */
public class TinyURLUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TinyURL tinyURL) {
		getPersistence().clearCache(tinyURL);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TinyURL> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TinyURL> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TinyURL> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TinyURL update(TinyURL tinyURL) throws SystemException {
		return getPersistence().update(tinyURL);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TinyURL update(TinyURL tinyURL, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tinyURL, serviceContext);
	}

	/**
	* Returns the tiny u r l where classNameId = &#63; and classPK = &#63; or throws a {@link org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching tiny u r l
	* @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL findByC_P(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException {
		return getPersistence().findByC_P(classNameId, classPK);
	}

	/**
	* Returns the tiny u r l where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL fetchByC_P(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_P(classNameId, classPK);
	}

	/**
	* Returns the tiny u r l where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL fetchByC_P(
		long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_P(classNameId, classPK, retrieveFromCache);
	}

	/**
	* Removes the tiny u r l where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the tiny u r l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL removeByC_P(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException {
		return getPersistence().removeByC_P(classNameId, classPK);
	}

	/**
	* Returns the number of tiny u r ls where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_P(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_P(classNameId, classPK);
	}

	/**
	* Returns the tiny u r l where code = &#63; or throws a {@link org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException} if it could not be found.
	*
	* @param code the code
	* @return the matching tiny u r l
	* @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL findBycode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException {
		return getPersistence().findBycode(code);
	}

	/**
	* Returns the tiny u r l where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL fetchBycode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBycode(code);
	}

	/**
	* Returns the tiny u r l where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL fetchBycode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBycode(code, retrieveFromCache);
	}

	/**
	* Removes the tiny u r l where code = &#63; from the database.
	*
	* @param code the code
	* @return the tiny u r l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL removeBycode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException {
		return getPersistence().removeBycode(code);
	}

	/**
	* Returns the number of tiny u r ls where code = &#63;.
	*
	* @param code the code
	* @return the number of matching tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycode(code);
	}

	/**
	* Caches the tiny u r l in the entity cache if it is enabled.
	*
	* @param tinyURL the tiny u r l
	*/
	public static void cacheResult(
		org.hopeconsultants.portlet.tinyurl.model.TinyURL tinyURL) {
		getPersistence().cacheResult(tinyURL);
	}

	/**
	* Caches the tiny u r ls in the entity cache if it is enabled.
	*
	* @param tinyURLs the tiny u r ls
	*/
	public static void cacheResult(
		java.util.List<org.hopeconsultants.portlet.tinyurl.model.TinyURL> tinyURLs) {
		getPersistence().cacheResult(tinyURLs);
	}

	/**
	* Creates a new tiny u r l with the primary key. Does not add the tiny u r l to the database.
	*
	* @param tinyURLId the primary key for the new tiny u r l
	* @return the new tiny u r l
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL create(
		long tinyURLId) {
		return getPersistence().create(tinyURLId);
	}

	/**
	* Removes the tiny u r l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l that was removed
	* @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL remove(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException {
		return getPersistence().remove(tinyURLId);
	}

	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL updateImpl(
		org.hopeconsultants.portlet.tinyurl.model.TinyURL tinyURL)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tinyURL);
	}

	/**
	* Returns the tiny u r l with the primary key or throws a {@link org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException} if it could not be found.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l
	* @throws org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL findByPrimaryKey(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.hopeconsultants.portlet.tinyurl.NoSuchTinyURLException {
		return getPersistence().findByPrimaryKey(tinyURLId);
	}

	/**
	* Returns the tiny u r l with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l, or <code>null</code> if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.hopeconsultants.portlet.tinyurl.model.TinyURL fetchByPrimaryKey(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tinyURLId);
	}

	/**
	* Returns all the tiny u r ls.
	*
	* @return the tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.hopeconsultants.portlet.tinyurl.model.TinyURL> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.hopeconsultants.portlet.tinyurl.model.TinyURL> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tiny u r ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.hopeconsultants.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tiny u r ls
	* @param end the upper bound of the range of tiny u r ls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.hopeconsultants.portlet.tinyurl.model.TinyURL> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tiny u r ls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tiny u r ls.
	*
	* @return the number of tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TinyURLPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TinyURLPersistence)PortletBeanLocatorUtil.locate(org.hopeconsultants.portlet.tinyurl.service.ClpSerializer.getServletContextName(),
					TinyURLPersistence.class.getName());

			ReferenceRegistry.registerReference(TinyURLUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TinyURLPersistence persistence) {
	}

	private static TinyURLPersistence _persistence;
}