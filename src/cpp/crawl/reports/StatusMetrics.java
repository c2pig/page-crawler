package cpp.crawl.reports;

import static cpp.crawl.reports.Type.*;

import cpp.crawl.listeners.StatusListener;

public class StatusMetrics extends MetricsReceiver implements StatusListener {
	
	public StatusMetrics(Collector cmd) {
		super(cmd);
	}

	public void start() {
		this.getReports().forEach(r -> r.collect(STATUS_START, "Crawler started"));
	}

	public void terminate() {
		this.getReports().forEach(r -> r.collect(STATUS_TERMINATED, "Crawler terminated"));
	}

	public void stop() {
		this.getReports().forEach(r -> r.collect(STATUS_STOPPED, "Crawler stopped"));
	}

	@Override
	public void startSince(Long ms) {
		this.getReports().forEach(r -> r.collect(STATUS_SINCE, ms));
	}

	@Override
	public void ETA(Long ms) {
		this.getReports().forEach(r -> r.collect(STATUS_ETA, ms));
	}
}