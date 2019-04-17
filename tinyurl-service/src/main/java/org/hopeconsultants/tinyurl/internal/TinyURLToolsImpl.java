/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.tinyurl.internal;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.asset.publisher.constants.AssetPublisherPortletKeys;
import com.liferay.blogs.kernel.model.BlogsEntry;
import com.liferay.blogs.kernel.service.BlogsEntryLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.message.boards.kernel.model.MBCategory;
import com.liferay.message.boards.kernel.service.MBCategoryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapperThreadLocal;
import com.liferay.portal.kernel.portlet.PortletIdCodec;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.PortletLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiNodeLocalService;
import com.liferay.wiki.service.WikiPageLocalService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hopeconsultants.tinyurl.configuration.TinyURLConfiguration;
import org.hopeconsultants.tinyurl.model.TinyURL;
import org.hopeconsultants.tinyurl.service.TinyURLLocalService;
import org.hopeconsultants.tinyurl.tools.TinyURLTools;
import org.hopeconsultants.tinyurl.util.PropsValues;
import org.hopeconsultants.tinyurl.util.TinyURLConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component(
	configurationPid = TinyURLConfiguration.CONFIGURATION_ID,
	immediate = true,
	property = {},
	service = TinyURLTools.class
)
public class TinyURLToolsImpl implements TinyURLTools {

	@Override
	public String getTinyURL(String friendlyURL, ThemeDisplay themeDisplay)
		throws SystemException, PortalException {

		if (Validator.isNull(friendlyURL)) {
			_log.warn("No friendly URL in request. (May be the root layout " +
				"on the server or a newly created layout.)");

			return StringPool.BLANK;
		}

		if (Validator.isNull(themeDisplay)) {
			_log.warn("themeDisplay parameter is null.");

			return StringPool.BLANK;
		}

		long groupId = themeDisplay.getScopeGroupId();
		long plid = themeDisplay.getPlid();

		TinyURL tinyURL = null;

		int pos = friendlyURL.indexOf(Portal.FRIENDLY_URL_SEPARATOR);

		if (pos == -1) {
			// Layout friendly URL

			if (plid == 0) {
				_log.warn(
					"Layout friendly URL but plid is zero:" +
						friendlyURL);

				return StringPool.BLANK;
			}

			tinyURL = _tinyURLLocalService.fetchByC_P(
				TinyURLConstants.CLASSNAMEID_LAYOUT, plid);
		}
		else if (friendlyURL.startsWith("/document_library/", pos + 2)) {
			// Document Library friendly URL

			long classPK = _getDocumentId(friendlyURL);

			if (classPK == 0) {
				_log.warn(
					"Document friendly URL but classPK is zero: " +
						friendlyURL);

				return StringPool.BLANK;
			}

			tinyURL = _tinyURLLocalService.fetchByC_P(
				TinyURLConstants.CLASSNAMEID_DLFILEENTRY, classPK);
		}
		else if (friendlyURL.lastIndexOf(StringPool.SLASH) == (pos + 2)) {
			// Journal article canonical URL

			if (friendlyURL.length() < (pos + 3)) {
				_log.warn(
					"Journal article friendly URL too short: " +
						friendlyURL);

				return StringPool.BLANK;
			}

			String urlTitle = friendlyURL.substring(pos + 3);

			JournalArticle article =
				_journalArticleLocalService.fetchLatestArticleByUrlTitle(
					groupId, urlTitle, WorkflowConstants.STATUS_APPROVED);

			if (article == null) {
				_log.warn("No article found for friendly URL " + friendlyURL);

				return StringPool.BLANK;
			}

			tinyURL = _tinyURLLocalService.fetchByC_P(
				TinyURLConstants.CLASSNAMEID_ARTICLE,
				article.getResourcePrimKey());
		}
		else {
			// Portlet friendly URL route

			long[] idPair = _getIdFromFriendlyURL(friendlyURL, groupId, plid);

			long classNameId = idPair[0];
			long classPK = idPair[1];

			if (classNameId == 0) {
				_log.warn(
					"Cannot find portlet for friendly URL " + friendlyURL);

				return StringPool.BLANK;
			}
			else if (classPK == 0) {
				_log.warn("No classPK found for friendly URL " + friendlyURL);

				return StringPool.BLANK;
			}

			tinyURL = _tinyURLLocalService.fetchByC_P(classNameId, classPK);
		}

		if (tinyURL == null) {
			_log.warn("No tiny URL found for friendly URL " + friendlyURL);

			return StringPool.BLANK;
		}

		return _getPortalURL(themeDisplay) +
			TinyURLConstants.PATH_TINYURL + tinyURL.getCode();
	}

	@Activate
	protected void activate(Map<Object, Object> properties)
		throws SystemException, PortalException {

		_configuration = ConfigurableUtil.createConfigurable(
			TinyURLConfiguration.class, properties);

		int count = _tinyURLLocalService.getTinyURLsCount();

		if ((count == 0) || _configuration.verifyOnStartup()) {
			_verifyDatabase();
		}
	}

	@Modified
	protected void updateConfiguration(Map<Object, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
			TinyURLConfiguration.class, properties);
	}

	@SuppressWarnings("rawtypes")
	private long[] _getAssetPubIds(
			String namespace, long groupId, Map<String, String[]> params)
		throws SystemException {

		long classNameId = 0;
		long classPK = 0;

		// Extract the instanceId to which the friendly URL refers.
		// The FriendlyURLMapper does this internally but doesn't expose
		// the method to us.

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
			AssetEntry assetEntry = _assetEntryLocalService.fetchAssetEntry(
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
							assetGroupId, urlTitle);

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

	private long[] _getBlogsIds(
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
				BlogsEntry blogsEntry = _blogsEntryLocalService.getEntry(
					groupId, params.get(namespace + "urlTitle")[0]);

				classPK = blogsEntry.getEntryId();
			}
			catch (PortalException pe) {
				pe.printStackTrace();
			}
		}

		return new long[]{classNameId, classPK};
	}

	private long _getDocumentId(String url) throws SystemException {
		int pos = url.indexOf("/document_library/");

		String[] parts = StringUtil.split(
			url.substring(pos + "/document_library/".length()),
			StringPool.SLASH);

		if (parts.length < 3) {
			_log.warn("Malformed document friendly URL " + url);

			return 0;
		}

		if (!"view_file".equals(parts[1])) {
			_log.warn("Not a document friendly URL. " +
				"(Folders are not currently supported.)");

			return 0;
		}

		FileEntry fileEntry = null;

		try {
			fileEntry = _dlAppLocalService.getFileEntry(
				GetterUtil.getLong(parts[2]));
		}
		catch (PortalException pe) {
			_log.warn("No document found for friendly URL " + url);

			return 0;
		}

		return fileEntry.getFileEntryId();
	}

	// Code from PortalImpl.getPortletFriendlyURLMapperLayoutQueryStringComposite
	// but does not need to build up the query string; instead get the assetId
	// from the friendly URL route parameters.

	private long[] _getIdFromFriendlyURL(
			String url, long groupId, long plid)
		throws SystemException {

		long[] idPair = new long[]{0, 0};

		List<Portlet> portlets =
			_portletLocalService.getFriendlyURLMapperPortlets();

		for (Portlet portlet : portlets) {
			FriendlyURLMapper friendlyURLMapper =
				portlet.getFriendlyURLMapperInstance();

			if (url.endsWith(
				StringPool.SLASH + friendlyURLMapper.getMapping())) {

				url += StringPool.SLASH;
			}

			// We do not consider the case of TagsCompiler,
			// which has isCheckMappingWithPrefix()==false.

			int pos = url.indexOf(
				Portal.FRIENDLY_URL_SEPARATOR +
					friendlyURLMapper.getMapping() + StringPool.SLASH);

			if (pos != -1) {
				// The friendly URL belongs to this portlet. Extract the
				// parameters using a matching mapping template.

				Map<String, String[]> params =
					new HashMap<>();

				// We need the following to prevent exception in populateParams().

				FriendlyURLMapperThreadLocal.setPRPIdentifiers(
					new HashMap<String, String>());

				friendlyURLMapper.populateParams(
					url.substring(pos + 2), params, null);

				String portletId = friendlyURLMapper.getPortletId();
				String namespace = PortalUtil.getPortletNamespace(portletId);

				// The scopeGroupId from themeDisplay won't be correct because
				// our context is some web content display, not the target
				// portlet instance.

				try {
					groupId = _getScopeGroupId(plid, portletId);
				}
				catch (PortalException pe) {
					_log.warn("Could not find portlets in layout " + plid);
				}

				// Switch statement cannot use String, so use if...else.

				if (portletId.equals(AssetPublisherPortletKeys.ASSET_PUBLISHER)) {
					idPair = _getAssetPubIds(namespace, groupId, params);
				}
				else if (portletId.equals(PortletKeys.BLOGS)) {
					idPair = _getBlogsIds(namespace, groupId, params);
				}
				else if (portletId.equals(PortletKeys.MESSAGE_BOARDS)) {
					idPair = _getMessageIds(namespace, params);
				}
				else if (portletId.equals(WikiPortletKeys.WIKI)) {
					idPair = _getWikiPageIds(namespace, groupId, params);
				}

				break;
			}
		}

		return idPair;
	}

	private long[] _getMessageIds(
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

	private String _getPortalURL(ThemeDisplay themeDisplay)
		throws SystemException, PortalException {

		return PortalUtil.getPortalURL(themeDisplay) +
			PortalUtil.getPathContext();
	}

	private long _getScopeGroupId(long plid, String portletId)
		throws PortalException, SystemException {

		Layout layout = _layoutArticleLocalService.getLayout(plid);

		long scopeGroupId = layout.getGroupId();

		LayoutTypePortlet layoutTypePortlet =
			(LayoutTypePortlet)layout.getLayoutType();

		for (String id : layoutTypePortlet.getPortletIds()) {
			if (PortletIdCodec.decodePortletName(id).equals(portletId)) {
				// There's an instance of the specified portlet on the page.
				// If it's scopeable, get its configured scope group ID.

				scopeGroupId = PortalUtil.getScopeGroupId(layout, id);

				break;
			}
		}

		return scopeGroupId;
	}

	private long[] _getWikiPageIds(
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

			if ((nodeId == 0) &&
				params.containsKey(namespace + "nodeName")) {

				String nodeName = GetterUtil.getStringValues(
					params.get(namespace + "nodeName"))[0];

				WikiNode node = _wikiNodeLocalService.getNode(
					groupId, nodeName);

				nodeId = node.getNodeId();
			}

			WikiPage page = _wikiPageLocalService.getPage(
				nodeId, title);

			classPK = page.getResourcePrimKey();
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}

		return new long[]{classNameId, classPK};
	}

	private void _verifyDatabase()
		throws PortalException, SystemException {

		// Remove tiny URLs for non-existent entities

		_log.info("The tiny URL plugin database verifier has started." +
			" This may take a while to complete.");

		List<TinyURL> tinyURLs;
		int start = 0;
		int end = PropsValues.INDEX_SEARCH_LIMIT;
		int count = 0;

		do {
			tinyURLs = _tinyURLLocalService.getTinyURLs(start, end);

			for (TinyURL tinyURL : tinyURLs) {
				long classNameId = tinyURL.getClassNameId();
				long classPK = tinyURL.getClassPK();

				if (TinyURLConstants.USABLE_ASSETS.contains(classNameId)) {
					AssetEntry assetEntry =
						AssetEntryLocalServiceUtil.fetchEntry(
							PortalUtil.getClassName(classNameId), classPK);

					if (assetEntry == null) {
						if (_log.isDebugEnabled()) {
							_log.debug("Removing Asset tiny URL with ID " +
								String.valueOf(tinyURL.getTinyURLId()));
						}

						_tinyURLLocalService.deleteTinyURL(tinyURL);
						count++;
					}
				}
				else if (classNameId == TinyURLConstants.CLASSNAMEID_LAYOUT) {
					Layout layout = LayoutLocalServiceUtil.fetchLayout(classPK);

					if (layout == null) {
						if (_log.isDebugEnabled()) {
							_log.debug("Removing Layout tiny URL with ID " +
								String.valueOf(tinyURL.getTinyURLId()));
						}

						_tinyURLLocalService.deleteTinyURL(tinyURL);
						count++;
					}
				}
				else if (classNameId ==
						TinyURLConstants.CLASSNAMEID_MBCATEGORY) {

					MBCategory category =
						MBCategoryLocalServiceUtil.fetchMBCategory(classPK);

					if (category == null) {
						if (_log.isDebugEnabled()) {
							_log.debug("Removing MBCategory tiny URL with ID " +
								String.valueOf(tinyURL.getTinyURLId()));
						}

						_tinyURLLocalService.deleteTinyURL(tinyURL);
						count++;
					}
				}
				else {
					// Unsupported type; remove it.

					_tinyURLLocalService.deleteTinyURL(tinyURL);
					count++;
				}
			}

			start = end;
			end += PropsValues.INDEX_SEARCH_LIMIT;
		}
		while (tinyURLs.size() == PropsValues.INDEX_SEARCH_LIMIT);

		if (count > 0) {
			_log.info("The tiny URL database verifier deleted " +
				String.valueOf(count) + " invalid tiny URL entries.");
		}

		// Add non-existent tiny URLs for supported assets.

		List<AssetEntry> entries;
		start = 0;
		end = PropsValues.INDEX_SEARCH_LIMIT;
		count = 0;

		do {
			AssetEntryQuery query = new AssetEntryQuery();

			query.setExpirationDate(null);
			query.setPublishDate(null);
			query.setStart(start);
			query.setEnd(end);

			entries = AssetEntryLocalServiceUtil.getEntries(query);

			for (AssetEntry entry : entries) {
				long classNameId = entry.getClassNameId();

				if (TinyURLConstants.USABLE_ASSETS.contains(classNameId)) {
					long classPK = entry.getClassPK();

					TinyURL tinyURL = _tinyURLLocalService.fetchByC_P(
						classNameId, classPK);

					if (tinyURL == null) {
						tinyURL = _tinyURLLocalService.addTinyURL(
							entry.getGroupId(), entry.getCompanyId(),
							entry.getUserId(), entry.getUserName(),
							classNameId, classPK, entry.isVisible());

						if (_log.isDebugEnabled()) {
							_log.debug("Added Asset tiny URL with ID " +
								String.valueOf(tinyURL.getTinyURLId()));
						}

						count++;
					}
				}
			}

			start = end;
			end += PropsValues.INDEX_SEARCH_LIMIT;
		}
		while (entries.size() == PropsValues.INDEX_SEARCH_LIMIT);

		if (count > 0) {
			_log.info("The tiny URL database verifier added " +
				String.valueOf(count) + " missing tiny URLs for assets.");
		}

		// Add non-existent tiny URLs for portlet layouts.

		List<Layout> layouts;
		start = 0;
		end = PropsValues.INDEX_SEARCH_LIMIT;
		count = 0;

		do {
			layouts = LayoutLocalServiceUtil.getLayouts(start, end);

			for (Layout layout : layouts) {
				if (!layout.isTypePortlet()) {
					continue;
				}

				long plid = layout.getPlid();

				TinyURL tinyURL = _tinyURLLocalService.fetchByC_P(
					TinyURLConstants.CLASSNAMEID_LAYOUT, plid);

				if (tinyURL == null) {
					tinyURL = _tinyURLLocalService.addTinyURL(
						layout.getGroupId(), layout.getCompanyId(),
						layout.getUserId(), layout.getUserName(),
						TinyURLConstants.CLASSNAMEID_LAYOUT, plid, true);

					if (_log.isDebugEnabled()) {
						_log.debug("Added Layout tiny URL with ID " +
							String.valueOf(tinyURL.getTinyURLId()));
					}

					count++;
				}
			}

			start = end;
			end += PropsValues.INDEX_SEARCH_LIMIT;
		}
		while(layouts.size() == PropsValues.INDEX_SEARCH_LIMIT);

		if (count > 0) {
			_log.info("The tiny URL database verifier added " +
				String.valueOf(count) + " missing tiny URLs for layouts.");
		}

		// Add non-existent tiny URLs for Messageboard categories
		// (which don't have a corresponding AssetEntry).

		List<MBCategory> categories;
		start = 0;
		end = PropsValues.INDEX_SEARCH_LIMIT;
		count = 0;

		do {
			categories = MBCategoryLocalServiceUtil.getMBCategories(start, end);

			for (MBCategory category : categories) {
				TinyURL tinyURL = _tinyURLLocalService.fetchByC_P(
					TinyURLConstants.CLASSNAMEID_MBCATEGORY,
					category.getCategoryId());

				if (tinyURL == null) {
					tinyURL = _tinyURLLocalService.addTinyURL(
						category.getGroupId(), category.getCompanyId(),
						category.getUserId(), category.getUserName(),
						TinyURLConstants.CLASSNAMEID_MBCATEGORY,
						category.getCategoryId(), category.isApproved());

					if (_log.isDebugEnabled()) {
						_log.debug("Adding MBCategory tiny URL with ID " +
							String.valueOf(tinyURL.getTinyURLId()));
					}

					count++;
				}
			}

			start = end;
			end += PropsValues.INDEX_SEARCH_LIMIT;
		}
		while (categories.size() == PropsValues.INDEX_SEARCH_LIMIT);

		if (count > 0) {
			_log.info("The tiny URL database verifier added " +
				String.valueOf(count) +
				" missing tiny URLs for messageboard categories.");
		}

		_log.info("The tiny URL plugin database verifier has completed.");
	}

	@Reference(unbind = "-")
	private AssetEntryLocalService _assetEntryLocalService;

	@Reference(unbind = "-")
	private BlogsEntryLocalService _blogsEntryLocalService;

	@Reference(unbind = "-")
	private DLAppLocalService _dlAppLocalService;

	@Reference(unbind = "-")
	private JournalArticleLocalService _journalArticleLocalService;

	@Reference(unbind = "-")
	private LayoutLocalService _layoutArticleLocalService;

	@Reference(unbind = "-")
	private PortletLocalService _portletLocalService;

	@Reference(unbind = "-")
	private TinyURLLocalService _tinyURLLocalService;

	@Reference(unbind = "-")
	private WikiNodeLocalService _wikiNodeLocalService;

	@Reference(unbind = "-")
	private WikiPageLocalService _wikiPageLocalService;

	private volatile static TinyURLConfiguration _configuration;

	private static final Log _log = LogFactoryUtil.getLog(
		TinyURLToolsImpl.class);

}