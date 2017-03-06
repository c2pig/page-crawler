package cpp.crawl.reports;

import cpp.crawl.listeners.StatListener;

public class StatMetrics extends MetricsReceiver implements StatListener {

	public StatMetrics(Collector cmd) {
		super(cmd);
	}
}