package html;


public class Tr extends TabularData{
	private String startTrTag = null;
	private String endTrTag = null;
	private String contentTrTag = null;
	
	public Tr() {
		super("tr");
		init();
	}
	
	private void init(){
		CreateTag t = new CreateTag(this.getElementFromTabularData());
		setStartTrTag(t.getOpeningTag());
		setEndTrTag(t.getClosingTag());
	}
	
	public String getEndTrTag() {
		return endTrTag;
	}

	public void setEndTrTag(String endTrTag) {
		this.endTrTag = endTrTag;
	}

	public String getStartTrTag() {
		return startTrTag;
	}

	public void setStartTrTag(String startTrTag) {
		this.startTrTag = startTrTag;
	}

	public String getContentTrTag() {
		return contentTrTag;
	}

	public void setContentTrTag(String contentTrTag) {
		this.contentTrTag = contentTrTag;
	}

	void addBetweenTabularDataElement(String c) {
		// c content there will be a text or another tag 
		this.setContentTrTag(c);
		
	}


	String getTabularDataElement() {
		return this.getStartTrTag()+this.getContentTrTag()+this.getEndTrTag();
	}

	
	public void addBetweenElement(String c) {
		addBetweenTabularDataElement(c);
		
	}

	
	public void addAttributeToElement(String attr) {
		this.addAttributeToTabularDataElement(attr);	
	}

	
	public String getElement() {
		return this.getTabularDataElement();
	}


	void addAttributeToTabularDataElement(String attr) {
		this.setAttribute(attr);
		setStartTrTag(this.getStartTrTag().replaceFirst(">", " "+ this.getAttribute() + ">"));
		
	}




}
