/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.portlet.tinyurl.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapperThreadLocal;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.wiki.model.WikiNode;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiNodeLocalServiceUtil;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hopeconsultants.portlet.tinyurl.model.TinyURL;
import org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalServiceUtil;

public class TinyURLToolsImpl implements TinyURLTools {

	public String getTinyURL(
			String friendlyURL, Map<String, Object> themeDisplay)
		throws SystemException {

		if (Validator.isNull(friendlyURL)) {
			return StringPool.BLANK;
		}

		long groupId = GetterUtil.getLong(themeDisplay.get("scope-group-id"));

		TinyURL tinyURL = null;

		int pos = friendlyURL.indexOf(Portal.FRIENDLY_URL_SEPARATOR);

		if (friendlyURL.startsWith("/documents/")) {
			// Document Library friendly URL

			long classPK = _getDocumentId(friendlyURL);

			if (classPK == 0) {
				return StringPool.BLANK;
			}

			tinyURL = TinyURLLocalServiceUtil.fetchByC_P(
				TinyURLConstants.CLASSNAMEID_DLFILEENTRY, classPK);

		}
		else if (pos == -1) {
			// Layout friendly URL

			long plid = GetterUtil.getLong(themeDisplay.get("plid"));

			if (plid == 0) {
				_log.warn("Layout friendly URL but plid is zero.");

				return StringPool.BLANK;
			}

			tinyURL = TinyURLLocalServiceUtil.fetchByC_P(
				TinyURLConstants.CLASSNAMEID_LAYOUT, plid);
		}
		else if (friendlyURL.lastIndexOf(StringPool.SLASH) == pos + 2) {
			// Journal article canonical URL

			if (friendlyURL.length() < pos + 3) {
				return StringPool.BLANK;
			}

			String urlTitle = friendlyURL.substring(pos + 3);

			JournalArticle article =
				JournalArticleLocalServiceUtil.fetchLatestArticleByUrlTitle(
					groupId, urlTitle, WorkflowConstants.STATUS_APPROVED);

			if (article == null) {
				_log.warn("No article found for friendly URL " + friendlyURL);
			}
			else {
				tinyURL = TinyURLLocalServiceUtil.fetchByC_P(
					TinyURLConstants.CLASSNAMEID_ARTICLE,
					article.getResourcePrimKey());
			}
		}
		else {
			// Portlet friendly URL route

			long[] idPair = _getIdFromFriendlyURL(friendlyURL, groupId);

			long classNameId = idPair[0];
			long classPK = idPair[1];

			if (classNameId == 0) {
				_log.warn(
					"Cannot find portlet for friendly URL " + friendlyURL);

				return StringPool.BLANK;
			}
			else if (idPair[1] == 0) {
				_log.warn("No classPK found for friendly URL " + friendlyURL);

				return StringPool.BLANK;
			}

			tinyURL = TinyURLLocalServiceUtil.fetchByC_P(classNameId, classPK);
		}

		if (tinyURL == null) {
			_log.warn("No tiny URL found for friendly URL " + friendlyURL);

			return StringPool.BLANK;
		}

		return _getPortalURL(themeDisplay) +
			TinyURLConstants.PATH_TINYURL + tinyURL.getCode();
	}

	// Code from PortalImpl.getPortletFriendlyURLMapperLayoutQueryStringComposite
	// but does not need to build up the query string; instead get the assetId
	// from the friendly URL route parameters.

	private static long[] _getIdFromFriendlyURL(String url, long groupId)
		throws SystemException {

		long[] idPair = new long[]{0, 0};

		List<Portlet> portlets =
			PortletLocalServiceUtil.getFriendlyURLMapperPortlets();

		for (Portlet portlet : portlets) {
			FriendlyURLMapper friendlyURLMapper =
				portlet.getFriendlyURLMapperInstance();

			if (url.endsWith(
				StringPool.SLASH + friendlyURLMapper.getMapping())) {

				url += StringPool.SLASH;
			}

			// We do not consider the case of TagsCompiler, which has isCheckMappingWithPrefix()==false.

			int pos = url.indexOf(
				Portal.FRIENDLY_URL_SEPARATOR +
					friendlyURLMapper.getMapping() + StringPool.SLASH);

			if (pos != -1) {
				// The friendly URL belongs to this portlet. Extract the parameters using a matching mapping template.

				Map<String, String[]> params =
					new HashMap<String, String[]>();

				// We need the following to prevent exception in populateParams().

				FriendlyURLMapperThreadLocal.setPRPIdentifiers(
					new HashMap<String, String>());

				friendlyURLMapper.populateParams(
					url.substring(pos + 2), params, null);

				String portletId = friendlyURLMapper.getPortletId();
				String namespace = PortalUtil.getPortletNamespace(portletId);

				// Switch statement cannot use String, so use if...else.

				if (portletId.equals(PortletKeys.ASSET_PUBLISHER)) {
					idPair = _getAssetPubIds(namespace, groupId, params);
				}
				if (portletId.equals(PortletKeys.BLOGS)) {
					idPair = _getBlogsIds(namespace, groupId, params);
				}
				else if (portletId.equals(PortletKeys.MESSAGE_BOARDS)) {
					idPair = _getMessageIds(namespace, params);
				}
				else if (portletId.equals(PortletKeys.WIKI)) {
					idPair = _getWikiPageIds(namespace, groupId, params);
				}

				break;
			}
		}

		return idPair;
	}

	private static long[] _getAssetPubIds(
			String namespace, long groupId, Map<String, String[]> params)
		throws SystemException {

		long classNameId = 0;
		long classPK = 0;

		// Extract the instanceId to which the friendly URL refers.
		// The FriendlyURLMapper does this internally but doesn't expose the method to us.

		namespace += "INSTANCE_";

		for (String key : params.keySet()) {
			if (key.startsWith(namespace)) {
				int x = key.indexOf(StringPool.UNDERLINE, namespace.length());

				if (x != -1) {
					namespace = key.substring(0, x + 1);
				}

				break;
			}
		}

		if (params.containsKey(namespace + "assetEntryId")) {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchAssetEntry(
				GetterUtil.getLongValues(
					params.get(namespace + "assetEntryId"))[0]);

			if (assetEntry != null) {
				classNameId = assetEntry.getClassNameId();
				classPK = assetEntry.getClassPK();
			}
		}
		else if (params.containsKey(namespace + "type") &&
			params.containsKey(namespace + "urlTitle")) {

			String type = params.get(namespace + "type")[0];
			String urlTitle = params.get(namespace + "urlTitle")[0];

			long assetGroupId = groupId;

			if (params.containsKey(namespace + "groupId")) {
				assetGroupId = GetterUtil.getLongValues(
					params.get(namespace + "groupId"))[0];
			}

			AssetRendererFactory assetRendererFactory =
				AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByType(
					type);

			if (assetRendererFactory != null) {
				try {
					AssetRenderer assetRenderer =
						assetRendererFactory.getAssetRenderer(
							groupId, urlTitle);

				classNameId = assetRendererFactory.getClassNameId();
				classPK = assetRenderer.getClassPK();
				}
				catch (PortalException pe) {
					pe.printStackTrace();
				}
			}
		}

		return new long[]{classNameId, classPK};
	}

	private static long[] _getBlogsIds(
			String namespace, long groupId, Map<String, String[]> params)
		throws SystemException {

		long classNameId = TinyURLConstants.CLASSNAMEID_BLOGS;
		long classPK = 0;

		if (params.containsKey(namespace + "entryId")) {
			classPK = GetterUtil.getLongValues(
				params.get(namespace + "entryId"))[0];
		}
		else if (params.containsKey(namespace + "urlTitle")) {
			try {
				BlogsEntry blogsEntry =
					BlogsEntryLocalServiceUtil.getEntry(
						groupId, params.get(namespace + "urlTitle")[0]);

				classPK = blogsEntry.getEntryId();
			}
			catch (PortalException pe) {
				pe.printStackTrace();
			}
		}

		return new long[]{classNameId, classPK};
	}

	private static long _getDocumentId(String url) throws SystemException {
		int pos = url.indexOf("/documents/");

		String[] parts = StringUtil.split(
			url.substring(pos + "/documents/".length()), StringPool.SLASH);

		if (parts.length < 3) {
			_log.warn("Malformed ocument friendly URL " + url);

			return 0;
		}

		long repositoryId = GetterUtil.getLong(parts[0]);

		if (repositoryId == 0) {
			_log.warn("Document friendly URL but repositoryId is zero: " + url);

			return 0;
		}

		FileEntry fileEntry = null;

		try {
			if (parts.length >= 4) {
				fileEntry = DLAppLocalServiceUtil.getFileEntryByUuidAndGroupId(
					parts[3], repositoryId);
			}
			else {
				fileEntry = DLAppLocalServiceUtil.getFileEntry(
					repositoryId, GetterUtil.getLong(parts[1]),
					HttpUtil.decodeURL(parts[2]));
			}
		}
		catch (PortalException pe) {
			_log.warn("No document found for friendly URL " + url);

			return 0;
		}

		return fileEntry.getFileEntryId();
	}

	private static long[] _getMessageIds(
			String namespace, Map<String, String[]> params) {

		long classNameId = 0;
		long classPK = 0;

		if (params.containsKey(namespace + "mbCategoryId")) {
			classNameId = TinyURLConstants.CLASSNAMEID_MBCATEGORY;

			classPK = GetterUtil.getLongValues(
				params.get(namespace + "mbCategoryId"))[0];
		}
		else if (params.containsKey(namespace + "messageId")) {
			classNameId = TinyURLConstants.CLASSNAMEID_MBMESSAGE;

			classPK = GetterUtil.getLongValues(
				params.get(namespace + "messageId"))[0];
		}

		return new long[]{classNameId, classPK};
	}

	// Code from PortalImpl.getPortalURL but using flattened ThemeDisplay object.

	private static String _getPortalURL(Map<String, Object> themeDisplay)
		throws SystemException {

		String serverName =
			GetterUtil.getString(themeDisplay.get("server-name"));

		long plid = GetterUtil.getLong(themeDisplay.get("plid"));

		try {
			Layout layout = LayoutLocalServiceUtil.getLayout(plid);

			if (layout != null) {
				LayoutSet layoutSet = layout.getLayoutSet();

				String virtualHostname = layoutSet.getVirtualHostname();

				String domain =
					HttpUtil.getDomain((String)themeDisplay.get("url-portal"));

				if (Validator.isNotNull(virtualHostname) &&
					domain.startsWith(virtualHostname)) {

					serverName = virtualHostname;
				}
			}
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}

		int port = GetterUtil.getInteger(themeDisplay.get("server-port"));

		boolean secure = GetterUtil.getBoolean(themeDisplay.get("secure"));

		return PortalUtil.getPortalURL(serverName, port, secure) +
			PortalUtil.getPathContext();
	}

	private static long[] _getWikiPageIds(
			String namespace, long groupId, Map<String, String[]> params)
		throws SystemException {

		long classNameId = TinyURLConstants.CLASSNAMEID_WIKIPAGE;
		long classPK = 0;
		long nodeId = 0;
		String title = StringPool.BLANK;

		if (params.containsKey(namespace + "title")) {
			title = GetterUtil.getStringValues(
				params.get(namespace + "title"))[0];
		}

		try {
			if (params.containsKey(namespace + "nodeId")) {
				nodeId = GetterUtil.getLongValues(
					params.get(namespace + "nodeId"))[0];
			}

			if (nodeId == 0 &&
				params.containsKey(namespace + "nodeName")) {

				String nodeName = GetterUtil.getStringValues(
					params.get(namespace + "nodeName"))[0];

				WikiNode node = WikiNodeLocalServiceUtil.getNode(
					groupId, nodeName);

				nodeId = node.getNodeId();
			}

			WikiPage page = WikiPageLocalServiceUtil.getPage(
				nodeId, title);

			classPK = page.getResourcePrimKey();
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}

		return new long[]{classNameId, classPK};
	}

	private static Log _log = LogFactoryUtil.getLog(TinyURLToolsImpl.class);

}