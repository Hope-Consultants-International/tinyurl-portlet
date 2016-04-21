/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.portlet.tinyurl.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;

import java.util.List;

import org.hopeconsultants.portlet.tinyurl.model.TinyURL;
import org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalServiceUtil;

public class TinyURLUtils {

	public static String generateCode(long tinyURLId) {
		return Base58Util.encode(tinyURLId);
	}

	public static long getTinyURLId(String code)
		throws NumberFormatException {

		return Base58Util.decodeAsLong(code);
	}

	public static void verifyDatabase()
		throws PortalException, SystemException {

		// Remove tiny URLs for non-existent entities

		_log.info("The tiny URL plugin database verifier has started." +
			" This may take a while to complete.");

		List<TinyURL> tinyURLs;
		int start = 0;
		int end = PropsValues.INDEX_SEARCH_LIMIT;
		int count = 0;

		do {
			tinyURLs = TinyURLLocalServiceUtil.getTinyURLs(start, end);

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

						TinyURLLocalServiceUtil.deleteTinyURL(tinyURL);
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

						TinyURLLocalServiceUtil.deleteTinyURL(tinyURL);
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

						TinyURLLocalServiceUtil.deleteTinyURL(tinyURL);
						count++;
					}
				}
				else {
					// Unsupported type; remove it.

					TinyURLLocalServiceUtil.deleteTinyURL(tinyURL);
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

					TinyURL tinyURL =
						TinyURLLocalServiceUtil.fetchByC_P(classNameId, classPK);

					if (tinyURL == null) {
						tinyURL = TinyURLLocalServiceUtil.addTinyURL(
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

				TinyURL tinyURL = TinyURLLocalServiceUtil.fetchByC_P(
					TinyURLConstants.CLASSNAMEID_LAYOUT, plid);

				if (tinyURL == null) {
					tinyURL = TinyURLLocalServiceUtil.addTinyURL(
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
				TinyURL tinyURL = TinyURLLocalServiceUtil.fetchByC_P(
					TinyURLConstants.CLASSNAMEID_MBCATEGORY,
					category.getCategoryId());

				if (tinyURL == null) {
					tinyURL = TinyURLLocalServiceUtil.addTinyURL(
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

	private static Log _log = LogFactoryUtil.getLog(TinyURLUtils.class);

}