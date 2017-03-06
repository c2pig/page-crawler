package cpp.crawl.listeners;

public interface StatusListener {
	public void start();
	public void terminate();
	public void stop();
	public void startSince(Long ms);
	public void ETA(Long ms);
	
}
