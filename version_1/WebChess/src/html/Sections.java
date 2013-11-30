package html;

public abstract class Sections extends Attribute implements Html{
	private String element = null;
	
	public Sections(String element){
		super(); // base class
		setElementFromSections(element);
	}

	public String getElementFromSections() {
		return element;
	}

	public void setElementFromSections(String element) {
		this.element = element;
	}
	
	abstract void addBetweenSectionElement(String c);
	abstract void addAttributeToSectionsElement(String attr);
	abstract String getSectionsElement();
}
