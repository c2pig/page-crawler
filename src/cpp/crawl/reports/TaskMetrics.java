package cpp.crawl.reports;

import static cpp.crawl.reports.Type.*;

import cpp.crawl.listeners.TaskListener;

public class TaskMetrics extends MetricsReceiver implements TaskListener {

	public TaskMetrics(Collector cmd) {
		super(cmd);
	}

	@Override
	public void completedTasks(Long completedTask) {
		this.getReports().forEach(r -> r.collect(TASK_COMPLETED, completedTask));
	}
	
}
