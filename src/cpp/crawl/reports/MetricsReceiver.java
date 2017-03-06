package cpp.crawl.reports;

import java.util.Arrays;
import java.util.List;

public abstract class MetricsReceiver {
	
	private List<Collector> reports;
	
    public MetricsReceiver(Collector...reports) {
    	this.reports = Arrays.asList(reports);
    }
    
    protected List<Collector> getReports() {
    	return this.reports;
    }
}
