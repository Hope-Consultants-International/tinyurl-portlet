package org.hopeconsultants.tinyurl.internal.upgrade;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.hopeconsultants.tinyurl.internal.upgrade.v2_0_0.UpgradeCounter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {},
    service = UpgradeStepRegistrator.class
)
public class TinyURLUpgrade implements UpgradeStepRegistrator {

    @Override
    public void register(Registry registry) {
        registry.register(
            "0.0.0", "2.0.0",
            new UpgradeCounter(_counterLocalService));
    }

    @Reference(unbind = "-")
    private CounterLocalService _counterLocalService;

}
