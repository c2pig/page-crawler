package cpp.crawl;

import cpp.crawl.events.Event;

public class RefreshHeaderCrawler implements Worker<Event<String>> {

	public RefreshHeaderCrawler() {
		
	}
	
	public void exec(Event<String> e) {
		System.out.println(e);
	}

}
