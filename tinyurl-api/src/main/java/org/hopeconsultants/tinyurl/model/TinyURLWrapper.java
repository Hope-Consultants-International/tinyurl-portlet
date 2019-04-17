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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TinyURL}.
 * </p>
 *
 * @author Hope Consultants International
 * @see TinyURL
 * @generated
 */
@ProviderType
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

	@Override
	public TinyURL toEscapedModel() {
		return new TinyURLWrapper(_tinyURL.toEscapedModel());
	}

	@Override
	public TinyURL toUnescapedModel() {
		return new TinyURLWrapper(_tinyURL.toUnescapedModel());
	}

	/**
	* Returns the visible of this tiny url.
	*
	* @return the visible of this tiny url
	*/
	@Override
	public boolean getVisible() {
		return _tinyURL.getVisible();
	}

	@Override
	public boolean isCachedModel() {
		return _tinyURL.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tinyURL.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tinyURL.isNew();
	}

	/**
	* Returns <code>true</code> if this tiny url is visible.
	*
	* @return <code>true</code> if this tiny url is visible; <code>false</code> otherwise
	*/
	@Override
	public boolean isVisible() {
		return _tinyURL.isVisible();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tinyURL.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TinyURL> toCacheModel() {
		return _tinyURL.toCacheModel();
	}

	@Override
	public int compareTo(TinyURL tinyURL) {
		return _tinyURL.compareTo(tinyURL);
	}

	@Override
	public int hashCode() {
		return _tinyURL.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tinyURL.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TinyURLWrapper((TinyURL)_tinyURL.clone());
	}

	/**
	* Returns the fully qualified class name of this tiny url.
	*
	* @return the fully qualified class name of this tiny url
	*/
	@Override
	public java.lang.String getClassName() {
		return _tinyURL.getClassName();
	}

	/**
	* Returns the code of this tiny url.
	*
	* @return the code of this tiny url
	*/
	@Override
	public java.lang.String getCode() {
		return _tinyURL.getCode();
	}

	/**
	* Returns the user name of this tiny url.
	*
	* @return the user name of this tiny url
	*/
	@Override
	public java.lang.String getUserName() {
		return _tinyURL.getUserName();
	}

	/**
	* Returns the user uuid of this tiny url.
	*
	* @return the user uuid of this tiny url
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _tinyURL.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _tinyURL.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tinyURL.toXmlString();
	}

	/**
	* Returns the create date of this tiny url.
	*
	* @return the create date of this tiny url
	*/
	@Override
	public Date getCreateDate() {
		return _tinyURL.getCreateDate();
	}

	/**
	* Returns the modified date of this tiny url.
	*
	* @return the modified date of this tiny url
	*/
	@Override
	public Date getModifiedDate() {
		return _tinyURL.getModifiedDate();
	}

	/**
	* Returns the class name ID of this tiny url.
	*
	* @return the class name ID of this tiny url
	*/
	@Override
	public long getClassNameId() {
		return _tinyURL.getClassNameId();
	}

	/**
	* Returns the class pk of this tiny url.
	*
	* @return the class pk of this tiny url
	*/
	@Override
	public long getClassPK() {
		return _tinyURL.getClassPK();
	}

	/**
	* Returns the company ID of this tiny url.
	*
	* @return the company ID of this tiny url
	*/
	@Override
	public long getCompanyId() {
		return _tinyURL.getCompanyId();
	}

	/**
	* Returns the group ID of this tiny url.
	*
	* @return the group ID of this tiny url
	*/
	@Override
	public long getGroupId() {
		return _tinyURL.getGroupId();
	}

	/**
	* Returns the primary key of this tiny url.
	*
	* @return the primary key of this tiny url
	*/
	@Override
	public long getPrimaryKey() {
		return _tinyURL.getPrimaryKey();
	}

	/**
	* Returns the tiny url ID of this tiny url.
	*
	* @return the tiny url ID of this tiny url
	*/
	@Override
	public long getTinyURLId() {
		return _tinyURL.getTinyURLId();
	}

	/**
	* Returns the user ID of this tiny url.
	*
	* @return the user ID of this tiny url
	*/
	@Override
	public long getUserId() {
		return _tinyURL.getUserId();
	}

	@Override
	public void persist() {
		_tinyURL.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tinyURL.setCachedModel(cachedModel);
	}

	@Override
	public void setClassName(java.lang.String className) {
		_tinyURL.setClassName(className);
	}

	/**
	* Sets the class name ID of this tiny url.
	*
	* @param classNameId the class name ID of this tiny url
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_tinyURL.setClassNameId(classNameId);
	}

	/**
	* Sets the class pk of this tiny url.
	*
	* @param classPK the class pk of this tiny url
	*/
	@Override
	public void setClassPK(long classPK) {
		_tinyURL.setClassPK(classPK);
	}

	/**
	* Sets the code of this tiny url.
	*
	* @param code the code of this tiny url
	*/
	@Override
	public void setCode(java.lang.String code) {
		_tinyURL.setCode(code);
	}

	/**
	* Sets the company ID of this tiny url.
	*
	* @param companyId the company ID of this tiny url
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tinyURL.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this tiny url.
	*
	* @param createDate the create date of this tiny url
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_tinyURL.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tinyURL.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tinyURL.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tinyURL.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this tiny url.
	*
	* @param groupId the group ID of this tiny url
	*/
	@Override
	public void setGroupId(long groupId) {
		_tinyURL.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this tiny url.
	*
	* @param modifiedDate the modified date of this tiny url
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_tinyURL.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_tinyURL.setNew(n);
	}

	/**
	* Sets the primary key of this tiny url.
	*
	* @param primaryKey the primary key of this tiny url
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tinyURL.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tinyURL.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tiny url ID of this tiny url.
	*
	* @param tinyURLId the tiny url ID of this tiny url
	*/
	@Override
	public void setTinyURLId(long tinyURLId) {
		_tinyURL.setTinyURLId(tinyURLId);
	}

	/**
	* Sets the user ID of this tiny url.
	*
	* @param userId the user ID of this tiny url
	*/
	@Override
	public void setUserId(long userId) {
		_tinyURL.setUserId(userId);
	}

	/**
	* Sets the user name of this tiny url.
	*
	* @param userName the user name of this tiny url
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tinyURL.setUserName(userName);
	}

	/**
	* Sets the user uuid of this tiny url.
	*
	* @param userUuid the user uuid of this tiny url
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tinyURL.setUserUuid(userUuid);
	}

	/**
	* Sets whether this tiny url is visible.
	*
	* @param visible the visible of this tiny url
	*/
	@Override
	public void setVisible(boolean visible) {
		_tinyURL.setVisible(visible);
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

		if (Objects.equals(_tinyURL, tinyURLWrapper._tinyURL)) {
			return true;
		}

		return false;
	}

	@Override
	public TinyURL getWrappedModel() {
		return _tinyURL;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tinyURL.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tinyURL.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tinyURL.resetOriginalValues();
	}

	private final TinyURL _tinyURL;
}