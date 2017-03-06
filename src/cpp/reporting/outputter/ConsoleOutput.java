package cpp.reporting.outputter;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleOutput implements Outputter {

	private OutputStream os;
	
	public ConsoleOutput(OutputStream os) {
		this.os = os;
	}
	
	@Override
	public void output(String content) {
		try {
			content += "\n";
			this.os.write(content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
