package cpp.crawl.reports;

public enum Type {
	
	TASK_COMPLETED("COMPLETED"), TASK_UNCOMPLETED("UNCOMPLETED"), TASK_TOTAL("TOTAL"),
	STATUS_START("START"), STATUS_ETA("ETA"), STATUS_STOPPED("STOPPED"), STATUS_TERMINATED("TERMINATED"), STATUS_SINCE("SINCE");
	
	private String type;
	
	private Type(String type) {
		this.type = type;
	}
	
	
}
