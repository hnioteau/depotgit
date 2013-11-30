package html;

public class Attribute {
	private String name = null;
	private String value = null;
	
	
	public Attribute(String n, String v){
		this.setName(n);
		this.setValue(v);
	}
	
	public Attribute(){
		this("", ""); // empty name and value
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private String createAttribut(){
		return getName() + "=" + "\"" + getValue() + "\"";
	}
	
	public String getAttribute(){
		return createAttribut();
	}
	
	public void setAttribute(String attribute){
		String[] tmp = attribute.split("=",2);
		setName(tmp[0]);
		setValue(tmp[1].replaceAll("\"", ""));
	}
	
	public void addAttributeToElement(String attr){
		
	}
}
