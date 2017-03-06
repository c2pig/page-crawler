package cpp.crawl.reports;

import java.util.Arrays;
import java.util.List;

public class OverviewReport implements Collector {

	private List<Reporter>reports;
	
	public OverviewReport(Reporter...reports) {
		this.reports = Arrays.asList(reports);
	}

	@Override
	public void collect(Type type, String data) {
		this.reports.forEach(r -> r.print(data));
	}

	@Override
	public void collect(Type type, Long data) {
		this.reports.forEach(r -> r.print(data));
	}

	@Override
	public void collect(Type type, Double data) {
		this.reports.forEach(r -> r.print(data));
	}

}
