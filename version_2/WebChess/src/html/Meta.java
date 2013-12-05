package html;

public class Meta extends MetaData{
	
	private String startMetaTag = null;
	
	
	public Meta() {
		super("meta");
		init();
	}
	
	private void init(){
		CreateTag t = new CreateTag(this.getElementFromMetaData());
		setStartMetaTag(t.getProperOpeningTag());
	}
	
	public String getStartMetaTag() {
		return startMetaTag;
	}

	public void setStartMetaTag(String startMetaTag) {
		this.startMetaTag = startMetaTag;
	}

	
	void addBetweenMetaDataElement(String c) {
		
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


	String getMetaDataElement() {
		
		return this.getStartMetaTag();
	}

	
	void addAttributeToMetaDataElement(String attr) {
		setAttribute(attr);
		setStartMetaTag(this.getStartMetaTag().replaceFirst("/>", " "+ this.getAttribute() + "/>"));
	}



	
}
