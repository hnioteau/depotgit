package html;

public class Td extends TabularData{
	
	private String startTdTag = null;
	private String endTdTag = null;
	private String contentTdTag = null;
	private final static String tagName = "td";
	
	public Td() {
		super(tagName);
		init();
	}
	private void init(){
		CreateTag t = new CreateTag(this.getElementFromTabularData());
		setStartTdTag(t.getOpeningTag());
		setEndTdTag(t.getClosingTag());
	}
	
	public String getStartTdTag() {
		return startTdTag;
	}

	public void setStartTdTag(String startTdTag) {
		this.startTdTag = startTdTag;
	}

	public String getEndTdTag() {
		return endTdTag;
	}

	public void setEndTdTag(String endTdTag) {
		this.endTdTag = endTdTag;
	}

	public String getContentTdTag() {
		return contentTdTag;
	}

	public void setContentTdTag(String contentTdTag) {
		this.contentTdTag = contentTdTag;
	}
	
	void addBetweenTabularDataElement(String c) {
		// c content there will be a text or another tag 
		this.setContentTdTag(c);
		
	}
	
	public void addBetweenElement(String c) {
		addBetweenTabularDataElement(c);
		
	}

	void addAttributeToTabularDataElement(String attr) {
		this.setAttribute(attr);
		setStartTdTag(this.getStartTdTag().replaceFirst(">", " "+ this.getAttribute() + ">"));
	}
	
	public String getElement() {
		return this.getTabularDataElement();
	}
	
	String getTabularDataElement() {	
		return this.getStartTdTag()+this.getContentTdTag()+this.getEndTdTag();
	}
	
	public static String getTagName() {
		return tagName;
	}
	
	public void addAttributeToElement(String attr) {
		this.addAttributeToTabularDataElement(attr);
	}


}
