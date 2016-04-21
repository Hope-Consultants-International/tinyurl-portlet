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

package org.hopeconsultants.portlet.tinyurl.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TinyURL}.
 * </p>
 *
 * @author Hope Consultants International
 * @see TinyURL
 * @generated
 */
public class TinyURLWrapper implements TinyURL, ModelWrapper<TinyURL> {
	public TinyURLWrapper(TinyURL tinyURL) {
		_tinyURL = tinyURL;
	}

	@Override
	public Class<?> getModelClass() {
		return TinyURL.class;
	}

	@Override
	public String getModelClassName() {
		return TinyURL.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tinyURLId", getTinyURLId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("code", getCode());
		attributes.put("visible", getVisible());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tinyURLId = (Long)attributes.get("tinyURLId");

		if (tinyURLId != null) {
			setTinyURLId(tinyURLId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Boolean visible = (Boolean)attributes.get("visible");

		if (visible != null) {
			setVisible(visible);
		}
	}

	/**
	* Returns the primary key of this tiny u r l.
	*
	* @return the primary key of this tiny u r l
	*/
	@Override
	public long getPrimaryKey() {
		return _tinyURL.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tiny u r l.
	*
	* @param primaryKey the primary key of this tiny u r l
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tinyURL.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tiny u r l ID of this tiny u r l.
	*
	* @return the tiny u r l ID of this tiny u r l
	*/
	@Override
	public long getTinyURLId() {
		return _tinyURL.getTinyURLId();
	}

	/**
	* Sets the tiny u r l ID of this tiny u r l.
	*
	* @param tinyURLId the tiny u r l ID of this tiny u r l
	*/
	@Override
	public void setTinyURLId(long tinyURLId) {
		_tinyURL.setTinyURLId(tinyURLId);
	}

	/**
	* Returns the group ID of this tiny u r l.
	*
	* @return the group ID of this tiny u r l
	*/
	@Override
	public long getGroupId() {
		return _tinyURL.getGroupId();
	}

	/**
	* Sets the group ID of this tiny u r l.
	*
	* @param groupId the group ID of this tiny u r l
	*/
	@Override
	public void setGroupId(long groupId) {
		_tinyURL.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this tiny u r l.
	*
	* @return the company ID of this tiny u r l
	*/
	@Override
	public long getCompanyId() {
		return _tinyURL.getCompanyId();
	}

	/**
	* Sets the company ID of this tiny u r l.
	*
	* @param companyId the company ID of this tiny u r l
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tinyURL.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this tiny u r l.
	*
	* @return the user ID of this tiny u r l
	*/
	@Override
	public long getUserId() {
		return _tinyURL.getUserId();
	}

	/**
	* Sets the user ID of this tiny u r l.
	*
	* @param userId the user ID of this tiny u r l
	*/
	@Override
	public void setUserId(long userId) {
		_tinyURL.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tiny u r l.
	*
	* @return the user uuid of this tiny u r l
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tinyURL.getUserUuid();
	}

	/**
	* Sets the user uuid of this tiny u r l.
	*
	* @param userUuid the user uuid of this tiny u r l
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tinyURL.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tiny u r l.
	*
	* @return the user name of this tiny u r l
	*/
	@Override
	public java.lang.String getUserName() {
		return _tinyURL.getUserName();
	}

	/**
	* Sets the user name of this tiny u r l.
	*
	* @param userName the user name of this tiny u r l
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tinyURL.setUserName(userName);
	}

	/**
	* Returns the create date of this tiny u r l.
	*
	* @return the create date of this tiny u r l
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tinyURL.getCreateDate();
	}

	/**
	* Sets the create date of this tiny u r l.
	*
	* @param createDate the create date of this tiny u r l
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tinyURL.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this tiny u r l.
	*
	* @return the modified date of this tiny u r l
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tinyURL.getModifiedDate();
	}

	/**
	* Sets the modified date of this tiny u r l.
	*
	* @param modifiedDate the modified date of this tiny u r l
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tinyURL.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fully qualified class name of this tiny u r l.
	*
	* @return the fully qualified class name of this tiny u r l
	*/
	@Override
	public java.lang.String getClassName() {
		return _tinyURL.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_tinyURL.setClassName(className);
	}

	/**
	* Returns the class name ID of this tiny u r l.
	*
	* @return the class name ID of this tiny u r l
	*/
	@Override
	public long getClassNameId() {
		return _tinyURL.getClassNameId();
	}

	/**
	* Sets the class name ID of this tiny u r l.
	*
	* @param classNameId the class name ID of this tiny u r l
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_tinyURL.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this tiny u r l.
	*
	* @return the class p k of this tiny u r l
	*/
	@Override
	public long getClassPK() {
		return _tinyURL.getClassPK();
	}

	/**
	* Sets the class p k of this tiny u r l.
	*
	* @param classPK the class p k of this tiny u r l
	*/
	@Override
	public void setClassPK(long classPK) {
		_tinyURL.setClassPK(classPK);
	}

	/**
	* Returns the code of this tiny u r l.
	*
	* @return the code of this tiny u r l
	*/
	@Override
	public java.lang.String getCode() {
		return _tinyURL.getCode();
	}

	/**
	* Sets the code of this tiny u r l.
	*
	* @param code the code of this tiny u r l
	*/
	@Override
	public void setCode(java.lang.String code) {
		_tinyURL.setCode(code);
	}

	/**
	* Returns the visible of this tiny u r l.
	*
	* @return the visible of this tiny u r l
	*/
	@Override
	public boolean getVisible() {
		return _tinyURL.getVisible();
	}

	/**
	* Returns <code>true</code> if this tiny u r l is visible.
	*
	* @return <code>true</code> if this tiny u r l is visible; <code>false</code> otherwise
	*/
	@Override
	public boolean isVisible() {
		return _tinyURL.isVisible();
	}

	/**
	* Sets whether this tiny u r l is visible.
	*
	* @param visible the visible of this tiny u r l
	*/
	@Override
	public void setVisible(boolean visible) {
		_tinyURL.setVisible(visible);
	}

	@Override
	public boolean isNew() {
		return _tinyURL.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tinyURL.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tinyURL.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tinyURL.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tinyURL.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tinyURL.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tinyURL.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tinyURL.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tinyURL.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tinyURL.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tinyURL.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TinyURLWrapper((TinyURL)_tinyURL.clone());
	}

	@Override
	public int compareTo(
		org.hopeconsultants.portlet.tinyurl.model.TinyURL tinyURL) {
		return _tinyURL.compareTo(tinyURL);
	}

	@Override
	public int hashCode() {
		return _tinyURL.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.hopeconsultants.portlet.tinyurl.model.TinyURL> toCacheModel() {
		return _tinyURL.toCacheModel();
	}

	@Override
	public org.hopeconsultants.portlet.tinyurl.model.TinyURL toEscapedModel() {
		return new TinyURLWrapper(_tinyURL.toEscapedModel());
	}

	@Override
	public org.hopeconsultants.portlet.tinyurl.model.TinyURL toUnescapedModel() {
		return new TinyURLWrapper(_tinyURL.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tinyURL.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tinyURL.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tinyURL.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TinyURLWrapper)) {
			return false;
		}

		TinyURLWrapper tinyURLWrapper = (TinyURLWrapper)obj;

		if (Validator.equals(_tinyURL, tinyURLWrapper._tinyURL)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TinyURL getWrappedTinyURL() {
		return _tinyURL;
	}

	@Override
	public TinyURL getWrappedModel() {
		return _tinyURL;
	}

	@Override
	public void resetOriginalValues() {
		_tinyURL.resetOriginalValues();
	}

	private TinyURL _tinyURL;
}