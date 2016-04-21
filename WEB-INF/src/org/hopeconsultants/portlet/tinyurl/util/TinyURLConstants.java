/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.portlet.tinyurl.util;

import com.liferay.portal.model.Layout;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.wiki.model.WikiPage;

import java.util.ArrayList;
import java.util.List;

public class TinyURLConstants {

	public static final long CLASSNAMEID_ARTICLE = PortalUtil.getClassNameId(JournalArticle.class);

	public static final long CLASSNAMEID_BLOGS = PortalUtil.getClassNameId(BlogsEntry.class);

	public static final long CLASSNAMEID_DLFILEENTRY = PortalUtil.getClassNameId(DLFileEntry.class);

	public static final long CLASSNAMEID_LAYOUT = PortalUtil.getClassNameId(Layout.class);

	public static final long CLASSNAMEID_MBCATEGORY = PortalUtil.getClassNameId(MBCategory.class);

	public static final long CLASSNAMEID_MBMESSAGE = PortalUtil.getClassNameId(MBMessage.class);

	public static final long CLASSNAMEID_WIKIPAGE = PortalUtil.getClassNameId(WikiPage.class);

	public static final String PATH_TINYURL = "/t/";

	public static final List<Long> USABLE_ASSETS = new ArrayList<Long>() {
		{
			add(PortalUtil.getClassNameId(JournalArticle.class));

			add(PortalUtil.getClassNameId(BlogsEntry.class));

			// NB: if this is enabled, need to exclude LR Sync temporary files sync.ffs_lock, Del.sync.ffs_lock

			add(PortalUtil.getClassNameId(DLFileEntry.class));

			// Note: assets are created when an MBCategory is subscribed to, but not when it is created.
			// So we create the tiny URL in MBCategoryListener, not AssetEntryListener.

			add(PortalUtil.getClassNameId(MBMessage.class));

			add(PortalUtil.getClassNameId(WikiPage.class));
		}
	};

}