package org.hopeconsultants.tinyurl.servlet.filter;

import javax.servlet.Filter;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"before-filter=Cache Filter - Friendly",
		"init.param.private=true",
		"init.param.user=false",
		"servlet-context-name=",
		"servlet-filter-name=Save Friendly URL Filter - Private Group",
		"url-pattern=/group/*",
	},
	service = Filter.class
)
public class SaveFriendlyURLFilterPrivateGroup extends SaveFriendlyURLFilter {

}
