package html;

public class Link extends MetaData {
	
	private String startLinkTag = null;
	

	public Link() {
		super("link");
		init();

	}
	private void init(){
		CreateTag t = new CreateTag(this.getElementFromMetaData());
		setStartLinkTag(t.getProperOpeningTag());
	}
	
	public String getStartLinkTag() {
		return startLinkTag;
	}

	public void setStartLinkTag(String startLinkTag) {
		this.startLinkTag = startLinkTag;
	}

	void addBetweenMetaDataElement(String c) {
		//Do nothing because of it is an empty element
		
	}

	public void addBetweenElement(String c) {
		this.addBetweenMetaDataElement(c);
		
	}
	
	public void addAttributeToElement(String attr) {
		this.addAttributeToMetaDataElement(attr);
	}
	
	public String getElement() {
		return this.getMetaDataElement();
	}

	
	String getMetaDataElement() {
		return this.getStartLinkTag();
	}
	
	void addAttributeToMetaDataElement(String attr) {
		this.setAttribute(attr);
		setStartLinkTag(this.getStartLinkTag().replaceFirst("/>", " "+ this.getAttribute() + "/>"));	
	}
	


	
	
	

}
