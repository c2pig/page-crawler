package cpp;

import cpp.crawl.BasedController;
import cpp.crawl.events.Event;
import cpp.crawl.generators.RandomGenerator;
import cpp.crawl.reports.OverviewReport;
import cpp.crawl.reports.Reporter;
import cpp.crawl.reports.SnapshotReport;
import cpp.crawl.reports.StatMetrics;
import cpp.crawl.reports.StatusMetrics;
import cpp.crawl.reports.TaskMetrics;
import cpp.reporting.formatter.Formatter;
import cpp.reporting.outputter.ConsoleOutput;
import cpp.reporting.outputter.EmailOutput;


public class Launcher {	
	
	public static void main(String[]args) {
		
		
		BasedController<Event<String>>controller = new BasedController(new RandomGenerator<Event<String>>().create());

		Reporter email = new Reporter(new EmailOutput("","",""), new Formatter());
		Reporter console = new Reporter(new ConsoleOutput(System.out), new Formatter());

		StatMetrics stat = new StatMetrics(new OverviewReport(email, console));
		StatusMetrics status = new StatusMetrics(new OverviewReport(console, email));
		TaskMetrics task = new TaskMetrics(new SnapshotReport(console));

		controller.addStatListener(stat);
		controller.addStatusListener(status);
		controller.addTaskListener(task);
		

		try {
			controller.execute();
		} catch(Exception e) {
			
		}
		
	}
}
