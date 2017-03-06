package cpp.crawl.generators;

import cpp.crawl.events.Topic;

public abstract class TraversedGenerator implements Generator {
	
	private String seedURL;
	
	public TraversedGenerator(String seedURL) {
		this.seedURL = seedURL;
	}

	public Topic create() {
		new Thread(new Runnable() {
			public void run() {
				while(isEnd()) {
					//something(travel());
				}
			}}).start();

		return null;
	}

	public abstract Boolean isEnd();
	public abstract String travel();
	
}
