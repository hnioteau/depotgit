package html;


public class Title extends MetaData{
	
	private String startTitleTag = null;
	private String endTitleTag = null;
	private String contentTitleTag = null;
	
	public Title() {
		super("title");
		init();
	}
	
	private void init(){
		CreateTag t = new CreateTag(this.getElementFromMetaData());
		setStartTitleTag(t.getOpeningTag());
		setEndTitleTag(t.getClosingTag());
	}
	
	public String getStartTitleTag() {
		return startTitleTag;
	}
	public void setStartTitleTag(String startTitleTag) {
		this.startTitleTag = startTitleTag;
	}
	public String getContentTitleTag() {
		return contentTitleTag;
	}
	public void setContentTitleTag(String contentTitleTag) {
		this.contentTitleTag = contentTitleTag;
	}
	public String getEndTitleTag() {
		return endTitleTag;
	}
	public void setEndTitleTag(String endTitleTag) {
		this.endTitleTag = endTitleTag;
	}

	void addBetweenMetaDataElement(String c) {
		this.setContentTitleTag(c);
		
	}

	public void addBetweenElement(String c) {
		addBetweenMetaDataElement(c);
		
	}

	public void addAttributeToElement(String attr) {
		
	}
	
	public String getElement() {
		return getMetaDataElement();
	}

	
	String getMetaDataElement() {
		return this.getStartTitleTag()+this.getContentTitleTag()+this.getEndTitleTag();
	}


	void addAttributeToMetaDataElement(String attr) {
		this.setAttribute(attr);
		setStartTitleTag(this.getStartTitleTag().replaceFirst(">", " "+ this.getAttribute() + ">"));
		
		
	}

	

}
