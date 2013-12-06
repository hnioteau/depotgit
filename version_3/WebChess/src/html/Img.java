package html;

public class Img extends EmbeddedContent{
	private String startImgTag = null;


	public Img() {
		super("img");
		init();
	}
	
	private void init(){
		CreateTag t = new CreateTag(this.getElementFromEmbeddedContent());
		setStartImgTag(t.getProperOpeningTag());	
	}
	

	public String getStartImgTag() {
		return startImgTag;
	}

	public void setStartImgTag(String startImgTag) {
		this.startImgTag = startImgTag;
	}
	
	public void addBetweenElement(String c) {
		
		
	}
	
	public void addAttributeToEmbeddedElement(String attr) {
		this.setAttribute(attr);
		setStartImgTag(this.getStartImgTag().replaceFirst("/>", " "+ this.getAttribute() + "/>"));
		
	}

	public String getElement() {	
		return getEmbeddedElement();
	}


	String getEmbeddedElement() {
		return this.getStartImgTag();
	}

	public void addAttributeToElement(String attr) {
		addAttributeToEmbeddedElement(attr);
	}

	
	
	

}
