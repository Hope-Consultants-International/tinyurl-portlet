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

package com.hci.portlet.tinyurl.service.persistence;

import com.hci.portlet.tinyurl.model.TinyURL;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the tiny u r l service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Hope Consultants International
 * @see TinyURLPersistenceImpl
 * @see TinyURLUtil
 * @generated
 */
public interface TinyURLPersistence extends BasePersistence<TinyURL> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TinyURLUtil} to access the tiny u r l persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the tiny u r l where classNameId = &#63; and classPK = &#63; or throws a {@link com.hci.portlet.tinyurl.NoSuchTinyURLException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching tiny u r l
	* @throws com.hci.portlet.tinyurl.NoSuchTinyURLException if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL findByC_P(long classNameId,
		long classPK)
		throws com.hci.portlet.tinyurl.NoSuchTinyURLException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tiny u r l where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL fetchByC_P(long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tiny u r l where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL fetchByC_P(long classNameId,
		long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tiny u r l where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the tiny u r l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL removeByC_P(long classNameId,
		long classPK)
		throws com.hci.portlet.tinyurl.NoSuchTinyURLException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tiny u r ls where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_P(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tiny u r l where code = &#63; or throws a {@link com.hci.portlet.tinyurl.NoSuchTinyURLException} if it could not be found.
	*
	* @param code the code
	* @return the matching tiny u r l
	* @throws com.hci.portlet.tinyurl.NoSuchTinyURLException if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL findBycode(
		java.lang.String code)
		throws com.hci.portlet.tinyurl.NoSuchTinyURLException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tiny u r l where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL fetchBycode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tiny u r l where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tiny u r l, or <code>null</code> if a matching tiny u r l could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL fetchBycode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tiny u r l where code = &#63; from the database.
	*
	* @param code the code
	* @return the tiny u r l that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL removeBycode(
		java.lang.String code)
		throws com.hci.portlet.tinyurl.NoSuchTinyURLException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tiny u r ls where code = &#63;.
	*
	* @param code the code
	* @return the number of matching tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public int countBycode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tiny u r l in the entity cache if it is enabled.
	*
	* @param tinyURL the tiny u r l
	*/
	public void cacheResult(com.hci.portlet.tinyurl.model.TinyURL tinyURL);

	/**
	* Caches the tiny u r ls in the entity cache if it is enabled.
	*
	* @param tinyURLs the tiny u r ls
	*/
	public void cacheResult(
		java.util.List<com.hci.portlet.tinyurl.model.TinyURL> tinyURLs);

	/**
	* Creates a new tiny u r l with the primary key. Does not add the tiny u r l to the database.
	*
	* @param tinyURLId the primary key for the new tiny u r l
	* @return the new tiny u r l
	*/
	public com.hci.portlet.tinyurl.model.TinyURL create(long tinyURLId);

	/**
	* Removes the tiny u r l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l that was removed
	* @throws com.hci.portlet.tinyurl.NoSuchTinyURLException if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL remove(long tinyURLId)
		throws com.hci.portlet.tinyurl.NoSuchTinyURLException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.hci.portlet.tinyurl.model.TinyURL updateImpl(
		com.hci.portlet.tinyurl.model.TinyURL tinyURL)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tiny u r l with the primary key or throws a {@link com.hci.portlet.tinyurl.NoSuchTinyURLException} if it could not be found.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l
	* @throws com.hci.portlet.tinyurl.NoSuchTinyURLException if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL findByPrimaryKey(
		long tinyURLId)
		throws com.hci.portlet.tinyurl.NoSuchTinyURLException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tiny u r l with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tinyURLId the primary key of the tiny u r l
	* @return the tiny u r l, or <code>null</code> if a tiny u r l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.hci.portlet.tinyurl.model.TinyURL fetchByPrimaryKey(
		long tinyURLId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tiny u r ls.
	*
	* @return the tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.hci.portlet.tinyurl.model.TinyURL> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.hci.portlet.tinyurl.model.TinyURL> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tiny u r ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.hci.portlet.tinyurl.model.impl.TinyURLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tiny u r ls
	* @param end the upper bound of the range of tiny u r ls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.hci.portlet.tinyurl.model.TinyURL> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tiny u r ls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tiny u r ls.
	*
	* @return the number of tiny u r ls
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}