package html;

public abstract class EmbeddedContent extends Attribute implements Html{
	
	private String element = null;
	
	public EmbeddedContent(String element){
		this.element = element;
	}
	public String getElementFromEmbeddedContent() {
		return element;
	}

	public void setElementFromEmbeddedContent(String element) {
		this.element = element;
	}
	
	abstract void addAttributeToEmbeddedElement(String attr);
	abstract String getEmbeddedElement();
}
