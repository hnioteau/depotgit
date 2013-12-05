package echec;

public class PageHtml {
	private String root;
	private String body;
	private String head;
	private final static String docType = "<!DOCTYPE html>" ;
	private static String docTitle = "Échecs en ligne";
	private ContentManagement cm;
	
	public PageHtml(String h,String b){
		this.setCm(new ContentManagement());
		this.setHead(h);
		this.setBody(b);
		this.setRoot(ContentManagement.NEW_LINE + this.getHead() + ContentManagement.NEW_LINE + this.getBody() + ContentManagement.NEW_LINE);
	}
	
	public String getRoot() {
		return root;
	}
	
	public String getPageHtml(){
		return this.getDoctype() + ContentManagement.NEW_LINE + this.getRoot();
	}
	
	public void setRoot(String root) {
		this.getCm().setContent(root);
		this.getCm().encapsulateElement("html");
		this.root = this.getCm().getContent();
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.getCm().setContent(body);
		this.getCm().encapsulateElement("body");
		this.body = this.getCm().getContent();
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.getCm().setContent(head);
		this.getCm().encapsulateElement("head");
		this.head = this.getCm().getContent();
	}
	public String getDoctype() {
		return docType;
	}

	public static String getDocTitle() {
		return docTitle;
	}

	public static void setDocTitle(String docTitle) {
		PageHtml.docTitle = docTitle;
	}

	public ContentManagement getCm() {
		return cm;
	}

	public void setCm(ContentManagement cm) {
		this.cm = cm;
	}
	
}
