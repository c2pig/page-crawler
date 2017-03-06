package cpp.reporting.outputter;

public class EmailOutput implements Outputter {

	public EmailOutput(String server, String sender, String receipient) {
		
	}
	
	
	@Override
	public void output(String content) {
		System.out.println("[Email] - " + content);
	}
	
}
