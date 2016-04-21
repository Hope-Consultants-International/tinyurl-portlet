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

package com.hci.portlet.tinyurl.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Hope Consultants International
 * @generated
 */
public class TinyURLSoap implements Serializable {
	public static TinyURLSoap toSoapModel(TinyURL model) {
		TinyURLSoap soapModel = new TinyURLSoap();

		soapModel.setTinyURLId(model.getTinyURLId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setCode(model.getCode());
		soapModel.setVisible(model.getVisible());

		return soapModel;
	}

	public static TinyURLSoap[] toSoapModels(TinyURL[] models) {
		TinyURLSoap[] soapModels = new TinyURLSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TinyURLSoap[][] toSoapModels(TinyURL[][] models) {
		TinyURLSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TinyURLSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TinyURLSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TinyURLSoap[] toSoapModels(List<TinyURL> models) {
		List<TinyURLSoap> soapModels = new ArrayList<TinyURLSoap>(models.size());

		for (TinyURL model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TinyURLSoap[soapModels.size()]);
	}

	public TinyURLSoap() {
	}

	public long getPrimaryKey() {
		return _tinyURLId;
	}

	public void setPrimaryKey(long pk) {
		setTinyURLId(pk);
	}

	public long getTinyURLId() {
		return _tinyURLId;
	}

	public void setTinyURLId(long tinyURLId) {
		_tinyURLId = tinyURLId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public boolean getVisible() {
		return _visible;
	}

	public boolean isVisible() {
		return _visible;
	}

	public void setVisible(boolean visible) {
		_visible = visible;
	}

	private long _tinyURLId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private String _code;
	private boolean _visible;
}