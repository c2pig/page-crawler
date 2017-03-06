package cpp.crawl.events;

public class Event<T>{
	
	private T value;
	
	public Event(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public String toString() {
		return String.format("[Event]: %s", this.value);
	}
}
