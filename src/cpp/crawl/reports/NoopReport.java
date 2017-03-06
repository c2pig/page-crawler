package cpp.crawl.reports;

public class NoopReport extends MetricsReceiver implements Collector {

	public NoopReport() {
		this(null);
	}
	
	public NoopReport(Collector cmd) {
		super(cmd);
	}

	@Override
	public void collect(Type type, String data) {
		System.out.println(String.format("[NoOp]:%s - %s", type, data));
	}

	@Override
	public void collect(Type type, Long data) {
		System.out.println(String.format("[NoOp]:%s - %d", type, data));
	}

	@Override
	public void collect(Type type, Double data) {
		System.out.println(String.format("[NoOp]:%s - %f.2", type, data));
	}

}
