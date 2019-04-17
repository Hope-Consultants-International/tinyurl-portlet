package org.hopeconsultants.tinyurl.configuration;

import com.liferay.configuration.admin.category.ConfigurationCategory;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {},
    service = ConfigurationCategory.class
)
public class TinyURLConfigurationCategory implements ConfigurationCategory {

    @Override
    public String getCategoryIcon() {
        return _CATEGORY_ICON;
    }

    @Override
    public String getCategoryKey() {
        return _CATEGORY_KEY;
    }

    @Override
    public String getCategorySection() {
        return _CATEGORY_SECTION;
    }

    private static final String _CATEGORY_ICON = "link";

    private static final String _CATEGORY_KEY = "tinyurls";

    private static final String _CATEGORY_SECTION = "content";

}
