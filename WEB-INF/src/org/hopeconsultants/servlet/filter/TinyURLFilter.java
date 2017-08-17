/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.servlet.filter;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;

import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hopeconsultants.portlet.tinyurl.model.TinyURL;
import org.hopeconsultants.portlet.tinyurl.service.TinyURLLocalServiceUtil;
import org.hopeconsultants.portlet.tinyurl.util.PropsValues;
import org.hopeconsultants.portlet.tinyurl.util.TinyURLConstants;
import org.hopeconsultants.portlet.tinyurl.util.TinyURLUtils;
import org.hopeconsultants.portlet.tinyurl.util.WebKeys;

public class TinyURLFilter extends BaseFilter {

	@Override
	public boolean isFilterEnabled(
		HttpServletRequest request, HttpServletResponse response) {

		String requestURI = request.getRequestURI();

		return (_isValidRequestURI(requestURI));
	}

	@Override
	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		String requestURI = request.getRequestURI();

		String contextPath = PortalUtil.getPathContext();

		if (Validator.isNotNull(contextPath) &&
			requestURI.contains(contextPath)) {

			requestURI = requestURI.substring(contextPath.length());
		}

		// Insist the user is signed in before converting a tiny URL. This
		// prevents privilege escalation: friendly URLs may contain information
		// about portal content which could otherwise be disclosed to an
		// attacker who scans all possible tiny URLs.
		// TODO: implement auto-login.

		if (PropsValues.TINYURL_SECURE_DECODE) {
			boolean signedIn = false;

			try {
				User user = PortalUtil.initUser(request);
				signedIn = !user.isDefaultUser();
			}
			catch (NoSuchUserException nsue) {
			}

			if (!signedIn) {
				// The ServletContext from the FilterConfig is the Tiny URL
				// portlet's context. Use the root context from the request instead.

				String loginURI = "/c/portal/login?redirect=" +
					PortalUtil.escapeRedirect(contextPath + requestURI);

				RequestDispatcher requestDispatcher =
					request.getServletContext().getRequestDispatcher(loginURI);

				requestDispatcher.forward(request, response);
			}
		}

		String[] parts = StringUtil.split(requestURI, StringPool.SLASH);

		long tinyURLId;

		try {
			tinyURLId = TinyURLUtils.getTinyURLId(parts[2]);
		}
		catch (NumberFormatException nfe) {
			if (_log.isDebugEnabled()) {
				_log.debug("Tiny URL " + requestURI + " is not validly coded.");
			}

			processFilter(getClass(), request, response, filterChain);

			return;
		}

		TinyURL tinyURL = TinyURLLocalServiceUtil.fetchTinyURL(tinyURLId);

		if (tinyURL == null) {
			if (_log.isDebugEnabled()) {
				_log.debug("Tiny URL " + requestURI + " does not exist.");
			}

			processFilter(TinyURLFilter.class, request, response, filterChain);

			return;
		}

		if (!tinyURL.isVisible()) {
			if (_log.isDebugEnabled()) {
				_log.debug("Tiny URL " + requestURI + " is not visible.");
			}

			processFilter(TinyURLFilter.class, request, response, filterChain);

			return;
		}

		long classNameId = tinyURL.getClassNameId();
		long classPK = tinyURL.getClassPK();

		if (classNameId == TinyURLConstants.CLASSNAMEID_DLFILEENTRY) {
			FileEntry fileEntry = null;

			try {
				fileEntry = DLAppLocalServiceUtil.getFileEntry(classPK);
			}
			catch (PortalException pe) {
				_log.warn("No document for tiny URL " + requestURI);

				processFilter(
				    TinyURLFilter.class, request, response, filterChain);

				return;
			}

			String friendlyURL = DLUtil.getPreviewURL(
				fileEntry, null, null, StringPool.BLANK, false, false);

			if (_log.isDebugEnabled()) {
				_log.debug("Redirect " + requestURI + " to " + friendlyURL);
			}

			response.sendRedirect(friendlyURL);
		}
		else if (classNameId == TinyURLConstants.CLASSNAMEID_ARTICLE) {
			JournalArticle article =
				JournalArticleLocalServiceUtil.fetchLatestArticle(
					classPK, WorkflowConstants.STATUS_APPROVED);

			if (article == null) {
				_log.warn("No journal article for tiny URL " + requestURI);

				processFilter(getClass(), request, response, filterChain);

				return;
			}

			Layout layout = _getJournalArticleLayout(article);

			if (layout == null) {
				_log.warn(
					"Journal article for tiny URL " + requestURI +
						" has no display page.");

				processFilter(getClass(), request, response, filterChain);

				return;
			}

			StringBundler sb = new StringBundler(3);

			sb.append(PortalUtil.getPathContext());

			if (!_isVirtualHost(request)) {
				sb.append(_getGroupFriendlyURI(layout));
			}

			sb.append(JournalArticleConstants.CANONICAL_URL_SEPARATOR);
			sb.append(article.getUrlTitle());

			String friendlyURL = sb.toString();

			if (_log.isDebugEnabled()) {
				_log.debug("Redirect " + requestURI + " to " + friendlyURL);
			}

			response.sendRedirect(friendlyURL);
		}
		else if (classNameId == TinyURLConstants.CLASSNAMEID_LAYOUT) {
			StringBundler sb = new StringBundler(3);

			sb.append(PortalUtil.getPathContext());

			Layout layout =	LayoutLocalServiceUtil.getLayout(classPK);

			if (!_isVirtualHost(request)) {
				sb.append(_getGroupFriendlyURI(layout));
			}

			sb.append(layout.getFriendlyURL());

			String friendlyURL = sb.toString();

			if (_log.isDebugEnabled()) {
				_log.debug("Redirect " + requestURI + " to " + friendlyURL);
			}

			response.sendRedirect(friendlyURL);
		}
		else {
			String friendlyURL = _getAssetStrutsURL(classNameId, classPK);

			if (_log.isDebugEnabled()) {
				_log.debug("Forward " + requestURI + " to " + friendlyURL);
			}

			if (Validator.isNull(friendlyURL)) {
				_log.warn(
					"Context URL cannot be found for tiny URL " + requestURI);

				processFilter(getClass(), request, response, filterChain);

				return;
			}

			// The ServletContext from the FilterConfig is the Tiny URL
			// portlet's context. Use the root context from the request instead.

			RequestDispatcher requestDispatcher =
				request.getServletContext().getRequestDispatcher(friendlyURL);

			requestDispatcher.forward(request, response);
		}
	}

	private String _getAssetStrutsURL(long classNameId, long classPK)
		throws PortalException, SystemException {

		String strutsURL = StringPool.BLANK;

		// Switch statement cannot use Long, so must use if...else.

		if (classNameId == TinyURLConstants.CLASSNAMEID_BLOGS) {
			strutsURL = _getFinderURL(
				"/blogs/find_entry", "entryId", classPK);
		}
		else if (classNameId == TinyURLConstants.CLASSNAMEID_DLFILEENTRY) {
			strutsURL = _getFinderURL(
				"/document_library/find_file_entry", "fileEntryId", classPK);
		}
		else if (classNameId == TinyURLConstants.CLASSNAMEID_MBCATEGORY) {
			strutsURL = _getFinderURL(
				"/message_boards/find_category", "mbCategoryId", classPK);
		}
		else if (classNameId == TinyURLConstants.CLASSNAMEID_MBMESSAGE) {
			strutsURL = _getFinderURL(
				"/message_boards/find_message", "messageId", classPK);
		}
		else if (classNameId == TinyURLConstants.CLASSNAMEID_WIKIPAGE) {
			strutsURL = _getFinderURL(
				"/wiki/find_page", "pageResourcePrimKey", classPK);
		}

		return strutsURL;
	}

	// Like BaseAssetRenderer.getURLViewInContext but does not require a Request object.

	private String _getFinderURL(
			String strutsPath, String primaryKeyParameterName,
			long primaryKeyParameterValue) {

		StringBundler sb = new StringBundler(6);

		sb.append(PortalUtil.getPathMain());
		sb.append(strutsPath);
		sb.append(StringPool.QUESTION);
		sb.append(primaryKeyParameterName);
		sb.append(StringPool.EQUAL);
		sb.append(primaryKeyParameterValue);

		return sb.toString();
	}

	private String _getGroupFriendlyURI(Layout layout)
		throws PortalException, SystemException {

		String friendlyURL;

		Group group = layout.getGroup();

		if (layout.isPrivateLayout()) {
			if (group.isUser()) {
				friendlyURL = PropsValues.
					LAYOUT_FRIENDLY_URL_PRIVATE_USER_SERVLET_MAPPING;
			}
			else {
				friendlyURL = PropsValues.
					LAYOUT_FRIENDLY_URL_PRIVATE_GROUP_SERVLET_MAPPING;
			}
		}
		else {
			friendlyURL =
				PropsValues.LAYOUT_FRIENDLY_URL_PUBLIC_SERVLET_MAPPING;
		}

		return friendlyURL + group.getFriendlyURL();
	}

	private Layout _getJournalArticleLayout(JournalArticle article)
		throws PortalException, SystemException {

		String layoutUuid = article.getLayoutUuid();
		long groupId = article.getGroupId();

		if (Validator.isNotNull(layoutUuid)) {
		    Layout layout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(
		        layoutUuid, groupId, true);

		    if (layout != null) {
		        return layout;
		    }

			return LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(
			    layoutUuid, groupId, false);
		}

		List<Long> privateLayoutIds =
			JournalContentSearchLocalServiceUtil.getLayoutIds(
			    groupId, true, article.getArticleId());

		if (!privateLayoutIds.isEmpty()) {
			long layoutId = privateLayoutIds.get(0);

			return LayoutLocalServiceUtil.getLayout(groupId, true, layoutId);
		}

		List<Long> publicLayoutIds =
			JournalContentSearchLocalServiceUtil.getLayoutIds(
			    groupId, true, article.getArticleId());

		if (!publicLayoutIds.isEmpty()) {
			long layoutId = privateLayoutIds.get(0);

			return LayoutLocalServiceUtil.getLayout(groupId, false, layoutId);
		}

		return null;
	}

	private boolean _isVirtualHost(HttpServletRequest request) {

		LayoutSet layoutSet = (LayoutSet)request.getAttribute(
			WebKeys.VIRTUAL_HOST_LAYOUT_SET);

		return (!Validator.isNull(layoutSet.getVirtualHostname()));
	}

	private boolean _isValidRequestURI(String requestURI) {
		if (requestURI == null) {
			return false;
		}

		String path = requestURI;

		String contextPath = PortalUtil.getPathContext();

		if (Validator.isNotNull(contextPath) && path.contains(contextPath)) {
			path = path.substring(contextPath.length());
		}

		String[] parts = StringUtil.split(path, StringPool.SLASH);

		// Filter's url-pattern ensures parts[0] = "" and parts[1] = "t".
		// Just need to validate in some way that parts[2] is a tinyURL.

		if (parts.length != 3 || Validator.isNull(parts[2])) {
			return false;
		}

		return true;
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	private static Log _log = LogFactoryUtil.getLog(TinyURLFilter.class);

}