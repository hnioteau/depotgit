package html;

public abstract class MetaData extends Attribute implements Html{
	private String element = null;
	
	public MetaData(String element){
		super();
		setElementFromMetaData(element);
	}

	public String getElementFromMetaData() {
		return element;
	}

	public void setElementFromMetaData(String element) {
		this.element = element;
	}
	
	abstract void addBetweenMetaDataElement(String c);
	abstract String getMetaDataElement();
	abstract void addAttributeToMetaDataElement(String attr);
}
