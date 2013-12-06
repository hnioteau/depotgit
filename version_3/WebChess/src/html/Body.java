package html;

public class Body extends Sections {
	
	private String startBodyTag = null;
	private String endBodyTag = null;
	private String contentBodyTag = null;
	private final static String tagName = "body";
	
	public Body() {
		super(tagName);
		init();
	}
	
	public void init(){
		CreateTag t = new CreateTag(this.getElementFromSections());
		setStartBodyTag(t.getOpeningTag());
		setEndBodyTag(t.getClosingTag());
	
	}
	
	public String getStartBodyTag() {
		return startBodyTag;
	}

	public void setStartBodyTag(String startBodyTag) {
		this.startBodyTag = startBodyTag;
	}

	public String getEndBodyTag() {
		return endBodyTag;
	}

	public void setEndBodyTag(String endBodyTag) {
		this.endBodyTag = endBodyTag;
	}

	public String getContentBodyTag() {
		return contentBodyTag;
	}

	public void setContentBodyTag(String contentBodyTag) {
		this.contentBodyTag = contentBodyTag;
	}
	
	
	void addBetweenSectionElement(String c){
		// c content there will be a text or another tag 
		this.setContentBodyTag(c);
		
	}
	
	public String getSectionsElement(){
		return this.getStartBodyTag()+this.getContentBodyTag()+this.getEndBodyTag();
	}

	
	public void addBetweenElement(String c) {
		addBetweenSectionElement(c);
		
	}


	public void addAttributeToElement(String attr) {
		addAttributeToSectionsElement(attr);
		
	}


	void addAttributeToSectionsElement(String attr) {
		this.setAttribute(attr); // initialize attribute
		// test if attribute is setting or not
		// get start tag
		setStartBodyTag(this.getStartBodyTag().replaceFirst(">", " "+ this.getAttribute() + ">"));
		
	}

	public String getElement() {	
		return this.getSectionsElement();
	}

	
	

	

	



}
