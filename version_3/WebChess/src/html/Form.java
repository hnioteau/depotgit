package html;

public class Form extends Forms{

	private String startFormTag = null;
	private String endFormTag = null;
	private String contentFormTag = null;
	
	public Form() {
		super("form");
		init();
		
	}
	private void init(){
		CreateTag t = new CreateTag(this.getElementFromForms());
		setStartFormTag(t.getOpeningTag());
		setEndFormTag(t.getClosingTag());
	}
	
	public String getStartFormTag() {
		return startFormTag;
	}
	public void setStartFormTag(String startFormTag) {
		this.startFormTag = startFormTag;
	}
	public String getEndFormTag() {
		return endFormTag;
	}
	public void setEndFormTag(String endFormTag) {
		this.endFormTag = endFormTag;
	}
	public String getContentFormTag() {
		return contentFormTag;
	}
	public void setContentFormTag(String contentFormTag) {
		this.contentFormTag = contentFormTag;
	}
	
	
	void addBetweenFormsElement(String c) {
		setContentFormTag(c);
		
	}
	
	public void addBetweenElement(String c) {
		addBetweenFormsElement(c);
		
	}
	
	
	void addAttributeToFormsElement(String attr) {
		this.setAttribute(attr);
		setStartFormTag(this.getStartFormTag().replaceFirst(">", " "+ this.getAttribute() + ">"));
		
	}
	
	public void addAttributeToElement(String attr){
		this.addAttributeToFormsElement(attr);
	}
	
	String getFormsElement() {
		return this.getStartFormTag()+this.getContentFormTag()+this.getEndFormTag();
	}
	
	public String getElement() {
		return this.getFormsElement();
	}
	


}
