/**
 * Copyright (C) 2016 Hope Consultants International. All rights reserved.
 */

package org.hopeconsultants.servlet.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hopeconsultants.portlet.tinyurl.util.WebKeys;

public class SaveFriendlyURLFilter extends BaseFilter {

    public static final String SKIP_FILTER =
        SaveFriendlyURLFilter.class + "SKIP_FILTER";

    @Override
    public void init(FilterConfig filterConfig) {
       _private = GetterUtil.getBoolean(
           filterConfig.getInitParameter("private"));

        String proxyPath = PortalUtil.getPathProxy();

        _user = GetterUtil.getBoolean(filterConfig.getInitParameter("user"));

        if (_private) {
            if (_user) {
                _friendlyURLPathPrefix =
                    PortalUtil.getPathFriendlyURLPrivateUser();
            }
            else {
                _friendlyURLPathPrefix =
                    PortalUtil.getPathFriendlyURLPrivateGroup();
            }
        }
        else {
            _friendlyURLPathPrefix = PortalUtil.getPathFriendlyURLPublic();
        }

        _pathInfoOffset = _friendlyURLPathPrefix.length() - proxyPath.length();
    }

    @Override
    public boolean isFilterEnabled(
        HttpServletRequest request, HttpServletResponse response) {

        return (!_isAlreadyFiltered(request));
    }

	@Override
	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

        request.setAttribute(SKIP_FILTER, Boolean.TRUE);

        if (request.getAttribute(WebKeys.FRIENDLY_URL) == null) {
    	    String pathInfo = _getPathInfo(request);

    	    request.setAttribute(
    	        WebKeys.FRIENDLY_URL, _getFriendlyURL(pathInfo));
        }

	    processFilter(
	        SaveFriendlyURLFilter.class, request, response, filterChain);
	}

    private String _getFriendlyURL(String pathInfo) {
        String friendlyURL = _friendlyURLPathPrefix;

        if (Validator.isNotNull(pathInfo)) {
            friendlyURL = friendlyURL.concat(pathInfo);
        }

        return friendlyURL;
    }

    private String _getPathInfo(HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        int pos = requestURI.indexOf(Portal.JSESSIONID);

        if (pos == -1) {
            return requestURI.substring(_pathInfoOffset);
        }

        return requestURI.substring(_pathInfoOffset, pos);
    }

    private boolean _isAlreadyFiltered(HttpServletRequest request) {
        if (request.getAttribute(SKIP_FILTER) != null) {
            return true;
        }
        else {
            return false;
        }
    }
	@Override
	protected Log getLog() {
		return _log;
	}

	private static Log _log =
        LogFactoryUtil.getLog(SaveFriendlyURLFilter.class);

    private String _friendlyURLPathPrefix;
    private int _pathInfoOffset;
    private boolean _private;
    private boolean _user;

}