package org.hopeconsultants.tinyurl.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
    category = "tinyurls",
    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
    id = TinyURLConfiguration.CONFIGURATION_ID,
    localization = "content/Language",
    name = "tinyurl-configuration-name"
)
public interface TinyURLConfiguration {

    public static final String CONFIGURATION_ID = "org.hopeconsultants.tinyurl.configuration.TinyURLConfiguration";

    @Meta.AD(
        deflt = "true",
        required = false
    )
    public boolean secureDecode();

    @Meta.AD(
        deflt = "false",
        required = false
    )
    public boolean verifyOnStartup();

}
