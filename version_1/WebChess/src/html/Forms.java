package html;

public abstract class Forms extends Attribute implements Html{
	private String element = null;
	
	public Forms(String element){
		setElementFromForms(element);
	}

	public String getElementFromForms() {
		return element;
	}

	public void setElementFromForms(String element) {
		this.element = element;
	}
	
	abstract void addBetweenFormsElement(String c);
	abstract void addAttributeToFormsElement(String attr);
	abstract String getFormsElement();

}
