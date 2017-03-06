package cpp.crawl.generators;

import java.util.List;

import cpp.crawl.events.Topic;

public abstract class BatchedGenerator implements Generator {

	private String seedURL;
	
	public BatchedGenerator(String seedURL) {
		this.seedURL = seedURL;
	}

	public abstract List<String> produce();	
	
}
