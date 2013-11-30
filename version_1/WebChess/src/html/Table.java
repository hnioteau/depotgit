package html;

public class Table extends TabularData{
	private String startTableTag = null;
	private String endTableTag = null;
	private String contentTableTag = null;
	private final static String nameTag = "table";
	
	public Table() {
		super(nameTag);
		init();
	}
	
	private void init(){
		CreateTag t = new CreateTag(this.getElementFromTabularData());
		setStartTableTag(t.getOpeningTag());
		setEndTableTag(t.getClosingTag());
	}
	public String getStartTableTag() {
		return startTableTag;
	}

	public void setStartTableTag(String startTableTag) {
		this.startTableTag = startTableTag;
	}

	public String getEndTableTag() {
		return endTableTag;
	}

	public void setEndTableTag(String endTableTag) {
		this.endTableTag = endTableTag;
	}

	public String getContentTableTag() {
		return contentTableTag;
	}

	public void setContentTableTag(String contentTableTag) {
		this.contentTableTag = contentTableTag;
	}

	
	void addBetweenTabularDataElement(String c) {
		// c content there will be a text or another tag 
		this.setContentTableTag(c);
		
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


	String getTabularDataElement() {
		return this.getStartTableTag()+this.getContentTableTag()+this.getEndTableTag();
	}

	void addAttributeToTabularDataElement(String attr) {
		setAttribute(attr);
		setStartTableTag(this.getStartTableTag().replaceFirst(">", " "+ this.getAttribute() + ">"));
		
	}




}
