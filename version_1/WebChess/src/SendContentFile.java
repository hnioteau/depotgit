
public class SendContentFile{
	private String location;
	private String lastModification;
	protected static String encoding = "UTF-8";
	
	public SendContentFile(String pathname, String last){
		this.setLocation(pathname);
		this.setLastModification(last);
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getLastModification() {
		return lastModification;
	}

	public void setLastModification(String lastModification) {
		this.lastModification = lastModification;
	}
	
}
