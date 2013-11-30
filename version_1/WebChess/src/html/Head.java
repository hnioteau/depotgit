package html;

public class Head extends MetaData{
	
	private String startHeadTag = null;
	private String endHeadTag = null;
	private String contentHeadTag = null;
	
	public Head() {
		super("head");
		init();
		
	}
	
	private void init(){
		CreateTag t = new CreateTag(this.getElementFromMetaData());
		setStartHeadTag(t.getOpeningTag());
		setEndHeadTag(t.getClosingTag());
	}

	public String getStartHeadTag() {
		return startHeadTag;
	}

	public void setStartHeadTag(String startHeadTag) {
		this.startHeadTag = startHeadTag;
	}

	public String getEndHeadTag() {
		return endHeadTag;
	}

	public void setEndHeadTag(String endHeadTag) {
		this.endHeadTag = endHeadTag;
	}

	public String getContentHeadTag() {
		return contentHeadTag;
	}

	public void setContentHeadTag(String contentHeadTag) {
		this.contentHeadTag = contentHeadTag;
	}

	void addBetweenMetaDataElement(String c) { 
		this.setContentHeadTag(c);
		
	}
	
	public String getMetaDataElement(){
		return this.getStartHeadTag()+this.getContentHeadTag()+this.getEndHeadTag();
	}


	public void addBetweenElement(String c) {
		addBetweenMetaDataElement(c);
		
	}
	
	public void addAttributeToElement(String attr) {
		this.addAttributeToMetaDataElement(attr);
	}


	public String getElement() {
		return this.getMetaDataElement();
	}

	
	void addAttributeToMetaDataElement(String attr) {
		this.setAttribute(attr);
		setStartHeadTag(this.getStartHeadTag().replaceFirst(">", " "+ this.getAttribute() + ">"));
		
	}

	

}
