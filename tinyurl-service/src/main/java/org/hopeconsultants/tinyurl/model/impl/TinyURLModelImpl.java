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

package org.hopeconsultants.tinyurl.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import org.hopeconsultants.tinyurl.model.TinyURL;
import org.hopeconsultants.tinyurl.model.TinyURLModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TinyURL service. Represents a row in the &quot;TinyUrl_TinyURL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TinyURLModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TinyURLImpl}.
 * </p>
 *
 * @author Hope Consultants International
 * @see TinyURLImpl
 * @see TinyURL
 * @see TinyURLModel
 * @generated
 */
@ProviderType
public class TinyURLModelImpl extends BaseModelImpl<TinyURL>
	implements TinyURLModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tiny url model instance should use the {@link TinyURL} interface instead.
	 */
	public static final String TABLE_NAME = "TinyUrl_TinyURL";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tinyURLId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "code_", Types.VARCHAR },
			{ "visible", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("tinyURLId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("visible", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table TinyUrl_TinyURL (tinyURLId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,code_ VARCHAR(75) null,visible BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table TinyUrl_TinyURL";
	public static final String ORDER_BY_JPQL = " ORDER BY tinyURL.tinyURLId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TinyUrl_TinyURL.tinyURLId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.hopeconsultants.tinyurl.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.hopeconsultants.tinyurl.model.TinyURL"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.hopeconsultants.tinyurl.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.hopeconsultants.tinyurl.model.TinyURL"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.hopeconsultants.tinyurl.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.hopeconsultants.tinyurl.model.TinyURL"),
			true);
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static final long CLASSPK_COLUMN_BITMASK = 2L;
	public static final long CODE_COLUMN_BITMASK = 4L;
	public static final long TINYURLID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.hopeconsultants.tinyurl.service.util.ServiceProps.get(
				"lock.expiration.time.org.hopeconsultants.tinyurl.model.TinyURL"));

	public TinyURLModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tinyURLId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTinyURLId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tinyURLId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("visible", isVisible());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public long getTinyURLId() {
		return _tinyURLId;
	}

	@Override
	public void setTinyURLId(long tinyURLId) {
		_columnBitmask = -1L;

		_tinyURLId = tinyURLId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@Override
	public String getCode() {
		if (_code == null) {
			return "";
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		_columnBitmask |= CODE_COLUMN_BITMASK;

		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
	}

	@Override
	public boolean getVisible() {
		return _visible;
	}

	@Override
	public boolean isVisible() {
		return _visible;
	}

	@Override
	public void setVisible(boolean visible) {
		_visible = visible;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TinyURL.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TinyURL toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TinyURL)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TinyURLImpl tinyURLImpl = new TinyURLImpl();

		tinyURLImpl.setTinyURLId(getTinyURLId());
		tinyURLImpl.setGroupId(getGroupId());
		tinyURLImpl.setCompanyId(getCompanyId());
		tinyURLImpl.setUserId(getUserId());
		tinyURLImpl.setUserName(getUserName());
		tinyURLImpl.setCreateDate(getCreateDate());
		tinyURLImpl.setModifiedDate(getModifiedDate());
		tinyURLImpl.setClassNameId(getClassNameId());
		tinyURLImpl.setClassPK(getClassPK());
		tinyURLImpl.setCode(getCode());
		tinyURLImpl.setVisible(isVisible());

		tinyURLImpl.resetOriginalValues();

		return tinyURLImpl;
	}

	@Override
	public int compareTo(TinyURL tinyURL) {
		int value = 0;

		if (getTinyURLId() < tinyURL.getTinyURLId()) {
			value = -1;
		}
		else if (getTinyURLId() > tinyURL.getTinyURLId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TinyURL)) {
			return false;
		}

		TinyURL tinyURL = (TinyURL)obj;

		long primaryKey = tinyURL.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TinyURLModelImpl tinyURLModelImpl = this;

		tinyURLModelImpl._setModifiedDate = false;

		tinyURLModelImpl._originalClassNameId = tinyURLModelImpl._classNameId;

		tinyURLModelImpl._setOriginalClassNameId = false;

		tinyURLModelImpl._originalClassPK = tinyURLModelImpl._classPK;

		tinyURLModelImpl._setOriginalClassPK = false;

		tinyURLModelImpl._originalCode = tinyURLModelImpl._code;

		tinyURLModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TinyURL> toCacheModel() {
		TinyURLCacheModel tinyURLCacheModel = new TinyURLCacheModel();

		tinyURLCacheModel.tinyURLId = getTinyURLId();

		tinyURLCacheModel.groupId = getGroupId();

		tinyURLCacheModel.companyId = getCompanyId();

		tinyURLCacheModel.userId = getUserId();

		tinyURLCacheModel.userName = getUserName();

		String userName = tinyURLCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tinyURLCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tinyURLCacheModel.createDate = createDate.getTime();
		}
		else {
			tinyURLCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tinyURLCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tinyURLCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		tinyURLCacheModel.classNameId = getClassNameId();

		tinyURLCacheModel.classPK = getClassPK();

		tinyURLCacheModel.code = getCode();

		String code = tinyURLCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			tinyURLCacheModel.code = null;
		}

		tinyURLCacheModel.visible = isVisible();

		return tinyURLCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{tinyURLId=");
		sb.append(getTinyURLId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", visible=");
		sb.append(isVisible());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.hopeconsultants.tinyurl.model.TinyURL");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tinyURLId</column-name><column-value><![CDATA[");
		sb.append(getTinyURLId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visible</column-name><column-value><![CDATA[");
		sb.append(isVisible());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TinyURL.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TinyURL.class, ModelWrapper.class
		};
	private long _tinyURLId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _code;
	private String _originalCode;
	private boolean _visible;
	private long _columnBitmask;
	private TinyURL _escapedModel;
}