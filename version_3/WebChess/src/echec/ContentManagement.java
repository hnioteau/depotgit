package echec;

import html.CreateTag;
import html.Html;

public class ContentManagement implements Cloneable{
	
	private String text = null;
	static final String NEW_LINE = System.getProperty("line.separator");
	static final String TAB = "\t";
	public ContentManagement(){
		this.text = "";
	}
	
	public ContentManagement(String c){
		this.text = c;
	}
	
	protected void encapsulateElement(String type){
		if(type.equals("body"))
			createElementAuxi(type);
		if(type.equals("form"))
			createElementAuxi(type);
		if(type.equals("head"))
			createElementAuxi(type);
		if(type.equals("html"))
			createElementAuxi(type);
		if(type.equals("img"))
			createElementAuxi(type);
		if(type.equals("input"))
			createElementAuxi(type);
		if(type.equals("link"))
			createElementAuxi(type);
		if(type.equals("meta"))
			createElementAuxi(type);
		if(type.equals("p"))
			createElementAuxi(type);
		if(type.equals("strong"))
			createElementAuxi(type);
		if(type.equals("table"))
			createElementAuxi(type);
		if(type.equals("title"))
			createElementAuxi(type);
		if(type.equals("td"))
			createElementAuxi(type);
		if(type.equals("tr"))
			createElementAuxi(type);
		
			
		
	}

	public Object clone(){
		ContentManagement c = null;
		try {
			c = (ContentManagement) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return c;
	}
	
	private void createElementAuxi(String type){
		CreateTag f = new CreateTag(type);
		setContent(f.getOpeningTag() + getContent() + f.getClosingTag());
			
	}
	
	protected void addAttribute(Object o,String attr){
		((Html) o).addAttributeToElement(attr);
		setContent(((Html) o).getElement());
	}
	
	protected void addBetween(Object o,String c){
		((Html) o).addBetweenElement(c);
		setContent(((Html) o).getElement());
	}
	
	protected String getElement(Object o){
		return ((Html) o).getElement();
	}
	
	public String getContent() {
		return text;
	}

	public void setContent(String content) {
		this.text =  content;
	}


	public String getNewLine() {
		return NEW_LINE;
	}
}
