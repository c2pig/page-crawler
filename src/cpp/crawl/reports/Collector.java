package cpp.crawl.reports;

public interface Collector {
	public void collect(Type type, String data);
	public void collect(Type type, Long data);
	public void collect(Type type, Double data);
}
