package cpp.crawl;

import cpp.crawl.events.Event;

public class RefreshHeaderCrawler implements Worker<Event<String>> {

	public RefreshHeaderCrawler() {
		
	}
	
	public void crawl(Event<String> e) {
		System.out.println(e);
	}

}
