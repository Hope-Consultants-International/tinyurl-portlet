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

package org.hopeconsultants.portlet.tinyurl.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.hopeconsultants.portlet.tinyurl.model.TinyURL;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TinyURL in entity cache.
 *
 * @author Hope Consultants International
 * @see TinyURL
 * @generated
 */
public class TinyURLCacheModel implements CacheModel<TinyURL>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{tinyURLId=");
		sb.append(tinyURLId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", code=");
		sb.append(code);
		sb.append(", visible=");
		sb.append(visible);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TinyURL toEntityModel() {
		TinyURLImpl tinyURLImpl = new TinyURLImpl();

		tinyURLImpl.setTinyURLId(tinyURLId);
		tinyURLImpl.setGroupId(groupId);
		tinyURLImpl.setCompanyId(companyId);
		tinyURLImpl.setUserId(userId);

		if (userName == null) {
			tinyURLImpl.setUserName(StringPool.BLANK);
		}
		else {
			tinyURLImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tinyURLImpl.setCreateDate(null);
		}
		else {
			tinyURLImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tinyURLImpl.setModifiedDate(null);
		}
		else {
			tinyURLImpl.setModifiedDate(new Date(modifiedDate));
		}

		tinyURLImpl.setClassNameId(classNameId);
		tinyURLImpl.setClassPK(classPK);

		if (code == null) {
			tinyURLImpl.setCode(StringPool.BLANK);
		}
		else {
			tinyURLImpl.setCode(code);
		}

		tinyURLImpl.setVisible(visible);

		tinyURLImpl.resetOriginalValues();

		return tinyURLImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tinyURLId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		code = objectInput.readUTF();
		visible = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tinyURLId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeBoolean(visible);
	}

	public long tinyURLId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public String code;
	public boolean visible;
}