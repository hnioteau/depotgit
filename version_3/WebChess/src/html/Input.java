package html;

public class Input extends Forms {
	
	private String startInputTag = null;
	
	
	public Input() {
		super("input");
		init();
	}
	
	private void init(){
		CreateTag t = new CreateTag(getElementFromForms());
		setStartInputTag(t.getProperOpeningTag());
		
	}
	
	public String getStartInputTag() {
		return startInputTag;
	}

	public void setStartInputTag(String startInputTag) {
		this.startInputTag = startInputTag;
	}

	public String getNameAttributeValue(){
		String v = null;
		if(this.getName().equals("name"))
			v = this.getValue();
		return v;
	}

	void addBetweenFormsElement(String c) {
		
		
	}

	
	public void addBetweenElement(String c) {
		// TODO Auto-generated method stub
		
	}

	
	void addAttributeToFormsElement(String attr) {
		this.setAttribute(attr);
		setStartInputTag(this.getStartInputTag().replaceFirst("/>", " "+ this.getAttribute() + "/>"));
		
	}


	String getFormsElement() {
		return this.getStartInputTag();
	}
	
	public String getElement(){
		return this.getFormsElement();
	};
	
	public void addAttributeToElement(String attr){
		this.addAttributeToFormsElement(attr);
	};

	

}
