package html;

public class CreateTag {
	private String element = null;
	
	public CreateTag(String e){
		super();
		this.element = e;
		
	}
	
	private String genericTag(){
		return "</"+getElement()+">";
	}
	
	private String createClosingTag(){
		return genericTag();
	}
	
	
	public String getClosingTag(){
		return createClosingTag();
	}
	
	private String[] splitSlash(){
		String [] tmp = genericTag().split("/");
		return tmp;
	}
	
	private String createOpeningTag(){
		return (splitSlash()[0] + splitSlash()[1]);
		
	}
	
	private String createProperOpeningTag(){
		return (splitSlash()[0] + splitSlash()[1].replaceFirst(">", " ") + "/>");
	}
	
	public String getProperOpeningTag(){
		return createProperOpeningTag();
	}
	
	public String getOpeningTag(){
		return createOpeningTag();
	}
	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}
	
}
