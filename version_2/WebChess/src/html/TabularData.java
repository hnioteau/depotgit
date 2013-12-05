package html;

public abstract class TabularData extends Attribute implements Html{
	private String element = null;
	
	public TabularData(String element){
		super();
		this.element = element;
	}
	public String getElementFromTabularData() {
		return element;
	}

	public void setElementFromTabularData(String element) {
		this.element = element;
	}
	
	abstract void addBetweenTabularDataElement(String c);
	abstract String getTabularDataElement();
	abstract void addAttributeToTabularDataElement(String attr);
}
