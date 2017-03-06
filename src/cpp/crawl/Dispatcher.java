package cpp.crawl;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Async;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.concurrent.FutureCallback;

import cpp.crawl.events.Event;

public class Dispatcher {
	
	private Worker<Event<String>> crawler;
	private ExecutorService tpool;
    private Async async;
    
	public Dispatcher(Worker<Event<String>> crawler, int size) {
		tpool = Executors.newFixedThreadPool(size);
		this.crawler = crawler;
		async = Async.newInstance().use(tpool);
	}
	
	public void dispatch(Event<String> e) {
//		tpool.submit(() -> {
//			System.out.println(String.format("https://www.google.com/#q=%d", e.getValue()));
//			
//		});
//		
		System.out.println(e);
		//Request req = Request.Get("http://www.google.com/#q=" + e.getValue()).connectTimeout(1000).socketTimeout(1000);
		Request req =  Request.Get("http://www.google.com/#");
		async.execute(req, new FutureCallback<Content>() {

            @Override
            public void failed(final Exception ex) {
                System.out.println(ex.getMessage() + ": " + req);
            }

            @Override
            public void completed(final Content content) {
                System.out.println("Request completed: " + req);
            }

            @Override
            public void cancelled() {
            }

        });
	}

}
