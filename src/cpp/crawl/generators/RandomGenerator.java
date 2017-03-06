package cpp.crawl.generators;

import java.util.function.Supplier;

import cpp.crawl.events.Event;
import cpp.crawl.events.Topic;

public class RandomGenerator<T> implements Generator, Supplier<T> {

	private Topic<T> topic;
	
	private int count;
	
	
	public RandomGenerator() {
		topic = new Topic<T>(this);
	}
	
	@Override
	public T get() {
		T t = null;
		if(count < 10) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t = (T) new Event<Integer>(count++);
		}
		return t;
	}

	@Override
	public Topic<T> create() {
		return this.topic;
	}
}
