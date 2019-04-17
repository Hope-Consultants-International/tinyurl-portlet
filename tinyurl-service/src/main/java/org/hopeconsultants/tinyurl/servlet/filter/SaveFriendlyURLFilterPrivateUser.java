package org.hopeconsultants.tinyurl.servlet.filter;

import javax.servlet.Filter;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
        "before-filter=Cache Filter - Friendly",
		"init.param.private=true",
		"init.param.user=true",
		"servlet-context-name=",
		"servlet-filter-name=Save Friendly URL Filter - Private User",
		"url-pattern=/user/*",
	},
	service = Filter.class
)
public class SaveFriendlyURLFilterPrivateUser extends SaveFriendlyURLFilter {

}
