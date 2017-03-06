package cpp.crawl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import cpp.crawl.events.Event;
import cpp.crawl.events.Topic;
import cpp.crawl.listeners.StatListener;
import cpp.crawl.listeners.StatusListener;
import cpp.crawl.listeners.TaskListener;

public class BasedController<T> {

	private Topic<T> topic;
	
	private TaskListener taskListener;
	
	private StatListener statListener;
	
	private StatusListener statusListener;

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public BasedController(Topic<T> topic) {
		this.topic = topic;
	}

	private void taskState(Long completed) {
		this.taskListener.completedTasks(completed);
	}
	
	public void execute() {
		
		final AtomicLong taskCount = new AtomicLong(0); 
		
		Dispatcher dispatcher = new Dispatcher(new Worker<Event<String>>() {	
			public void exec(Event<String> t) {
				System.out.println(t);
			}
		}, 100);
		
		scheduler.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				taskState(taskCount.get());    
			}}, 0L, 500L, TimeUnit.MILLISECONDS);
		
		topic.events().forEach(e -> {
			if(e == null) {
				this.statusListener.stop();
				throw new RuntimeException("End Of Loop");
			}
			taskCount.getAndIncrement();
			dispatcher.dispatch((Event<String>) e);
			
		});
	}

	//Task statistic: [Total Task] [Completed Task] [Uncompleted Task]
	public void addTaskListener(TaskListener taskListener) {
		this.taskListener = taskListener;
	}
	
	//Elapsed Time, Average time on Task, ETA
	public void addStatListener(StatListener statListener) {
		this.statListener = statListener;
	}

	//Controller Status: [start] [stop] [terminate]
	public void addStatusListener(StatusListener statusListener) {
		this.statusListener = statusListener;
	}
}
