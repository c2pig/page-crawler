package cpp.crawl.reports;

import java.util.Arrays;
import java.util.List;

import cpp.reporting.formatter.Formatter;
import cpp.reporting.outputter.Outputter;

public class Reporter {

	private List<Formatter>formatters;
	private Outputter output;

	public Reporter(Outputter output, Formatter...formatters) {
		this.output = output;
		this.formatters = Arrays.asList(formatters);
	}

	private String formatContent(String content) {
		StringBuilder formattedContent = new StringBuilder(content);
		this.formatters.forEach(f -> {
			
			formattedContent.replace(0, formattedContent.length(), f.format(formattedContent));
		});
		return formattedContent.toString();
	}
	
	public void print(String content) {
		output.output(formatContent(content));
	}

	public void print(Long content) {
		output.output(formatContent(content.toString()));
	}
	
	public void print(Double content) {
		output.output(formatContent(content.toString()));
	}
}
