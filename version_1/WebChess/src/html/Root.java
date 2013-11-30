package html;

public class Root extends Attribute implements Html{
	private String startHtmlTag = null;
	private String endHtmlTag = null;
	private String contentHtmlTag = null;
	
	public Root(){
		createHtmlTag();
	}
	
	private void createHtmlTag(){
		CreateTag t = new CreateTag("html");
		setStartHtmlTag(t.getOpeningTag());
		setEndHtmlTag(t.getClosingTag());
	}
	
	public String getStartHtmlTag() {
		return startHtmlTag;
	}

	public void setStartHtmlTag(String startTag) {
		this.startHtmlTag = startTag;
	}

	public String getEndHtmlTag() {
		return endHtmlTag;
	}

	public void setEndHtmlTag(String endTag) {
		this.endHtmlTag = endTag;
	}

	public String getContentHtmlTag() {
		return contentHtmlTag;
	}

	public void setContentHtmlTag(String contentTag) {
		this.contentHtmlTag = contentTag;
	}
	
	protected void addBetweenHtmlElement(String c){
		setContentHtmlTag(c);
	}
	
	public String getHtmlElement(){
		return this.getStartHtmlTag()+this.getContentHtmlTag()+this.getEndHtmlTag();
	}
	
	protected void addAttributesToHtmlElement(String attr){
		this.setAttribute(attr);
		setStartHtmlTag(this.getStartHtmlTag().replaceFirst(">", " "+ this.getAttribute() + ">"));
	}

	public void addBetweenElement(String c) {
		addBetweenHtmlElement(c);
		
	}
	
	public void addAttributeToElement(String attr){
		addAttributesToHtmlElement(attr);
	};
	
	public String getElement() {
		return this.getHtmlElement();
	}
}
