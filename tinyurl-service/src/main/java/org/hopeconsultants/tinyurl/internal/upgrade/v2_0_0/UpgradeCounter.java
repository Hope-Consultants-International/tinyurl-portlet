package org.hopeconsultants.tinyurl.internal.upgrade.v2_0_0;

import com.liferay.counter.kernel.model.Counter;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;

import org.hopeconsultants.tinyurl.model.TinyURL;

public class UpgradeCounter extends UpgradeProcess {

    public UpgradeCounter(CounterLocalService counterLocalService) {
        _counterLocalService = counterLocalService;
    }

    @Override
    protected void doUpgrade() throws Exception {
        try (LoggingTimer loggingTimer = new LoggingTimer()) {

            // The name of the primary key counter in 7.x is different from
            // that of the 6.2 version. We want to transfer the value to
            // a new counter and then delete the legacy one.

            Counter oldCounter = _counterLocalService.fetchCounter(
                "org.hopeconsultants.portlet.tinyurl.model.TinyURL");
            Counter newCounter = _counterLocalService.fetchCounter(
                TinyURL.class.getName());

            if (newCounter != null) {
                _log.warn("Counter upgrade already performed.");

                return;
            }

            newCounter = _counterLocalService.createCounter(
                TinyURL.class.getName());

            if (oldCounter != null) {
                newCounter.setCurrentId(oldCounter.getCurrentId());
                _counterLocalService.deleteCounter(oldCounter);
            }

            _counterLocalService.addCounter(newCounter);
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
        UpgradeCounter.class);

    private CounterLocalService _counterLocalService;

}
