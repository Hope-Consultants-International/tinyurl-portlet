package org.hopeconsultants.tinyurl.template;

import com.liferay.portal.kernel.template.TemplateContextContributor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hopeconsultants.tinyurl.tools.TinyURLTools;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
    	"type=" + TemplateContextContributor.TYPE_GLOBAL
	},
    service = TemplateContextContributor.class
)
public class TinyURLTemplateContextContributor
        implements TemplateContextContributor {

	@Override
	public void prepare(
		Map<String, Object> contextObjects, HttpServletRequest request) {

		contextObjects.put(
			"friendly_url",
			request.getAttribute(TinyURLTools.FRIENDLY_URL));

		contextObjects.put("tinyURLTools", _tinyURLTools);
	}

	@Reference(unbind = "-")
	private TinyURLTools _tinyURLTools;

}
