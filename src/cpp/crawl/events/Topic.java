package cpp.crawl.events;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Topic<T> {

	private Stream<T> eventStream;
	
	public Topic(Supplier<T> supplier) {
		eventStream = Stream.generate(supplier);
	}
	
	public Stream<T> events() {
		return eventStream;
	}
	
	
}
