package echec;


import java.util.ArrayList;
import java.util.List;

public class ChessBoardToHtml implements Cloneable{
	private ContentManagement cm = null;
	private List<String> streamHtml = null;
	private String line = null;
	
	public ChessBoardToHtml(){
		this.setCm(new ContentManagement());
		this.setStreamHtml(new ArrayList<String>());
	}

	public ContentManagement getCm() {
		return cm;
	}

	public void setCm(ContentManagement cm) {
		this.cm = cm;
	}
	
	
	protected void drawCaseWithoutPiece(String src, String alt,int width, String classe){
		this.drawHtmlImage(src,alt,width); // HTML Image
		this.drawHtmlCell(cm.getContent(),classe); // HTML Cell
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}
	
	protected void drawCaseWithPiece(String name, String type, String src, String alt,int width, String classe){
		this.drawHtmlInput(name,type,src,alt,width);
		this.drawHtmlCell(cm.getContent(),classe);
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
		
	}
	protected void drawBorderCase(String c){
		this.drawHtmlCell(c,"border");
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}
	
	protected void drawEmptyCase(){
		this.drawHtmlCell("", "corner");
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}
	
	protected void drawTable(String c){
		this.drawHtmlTable(c, "center");
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}
	
	protected void drawBody(String c){
		this.drawHtmlBody(c);
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}
	
	protected void drawForm(String c){
		this.drawHtmlForm(c);
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}
	
	protected void drawLine(String c){
		this.drawHtmlRow(c);
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}
	
	protected void drawTitle(String c){
		this.drawHtmlTitle(c);
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
		
	}// title of document
	
	protected void drawHead(String c){
		this.drawHtmlHead(c);
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}
	
	protected void drawLink(String rel, String href, String type){
		this.drawHtmlLink(rel, href, type);
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}// no content
	
	protected void drawMeta(String httpEquiv, String content){
		this.drawHtmlMeta(httpEquiv, content);
		this.getStreamHtml().add(cm.getContent()+ContentManagement.NEW_LINE);
	}//no content
	
	private void drawHtmlImage(String src, String alt, int width){
		html.Img im = new html.Img();	
		addCommonAttribute(im,src,alt,width);
	}// no content
	
	protected void drawHtmlRow(String c){
		html.Tr tr = new html.Tr();
		cm.addBetween(tr,c); // Add Content	
	}
	
	public Object clone(){
		ChessBoardToHtml ch = new ChessBoardToHtml();
		try {
			ch = (ChessBoardToHtml) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ch.cm = (ContentManagement) cm.clone();
		return ch;
	}
	protected void drawHtmlCell(String c, String classe){
		html.Td td = new html.Td();
		cm.addAttribute(td, "class="+classe); // Add Attribute
		cm.addBetween(td, c); // Add Content
		if(this.getCm().getContent().contains("input") || this.getCm().getContent().contains("img")){
			//System.out.println("Content ###############################");
			HtmlPageGenerator.initialiseArray(HtmlPageGenerator.getLigne(),HtmlPageGenerator.getColonne(), this.getCm().getContent());
			
		}
		
	}
	
	protected void drawHtmlTitle(String c){
		html.Title ti = new html.Title();
		cm.addBetween(ti, c); // Add Content
		
	}
	
	protected void drawHtmlBody(String c){
		html.Body bo = new html.Body();
		cm.addBetween(bo, c);
	}
	
	protected void drawHtmlLink(String rel, String href, String type){
		html.Link li = new html.Link();
		cm.addAttribute(li, "rel="+rel);
		cm.addAttribute(li, "href="+href);
		cm.addAttribute(li, "type="+type);
		
	}//no content
	
	protected void drawHtmlMeta(String httpEquiv, String content){
		html.Meta me = new html.Meta();
		cm.addAttribute(me, "http-equiv="+httpEquiv);
		cm.addAttribute(me, "content="+content);
	}// no content
	
	protected void drawHtmlHead(String c){
		html.Head he = new html.Head();
		cm.addBetween(he,c);
	}
	
	protected void drawHtmlForm(String c){
		html.Form fo = new html.Form();
		cm.addBetween(fo,c);
	}
	
	
	protected void drawHtmlTable(String c, String center){
		html.Table ta = new html.Table();
		cm.addAttribute(ta,"align="+center);
		cm.addBetween(ta,c);
	}
	
	private void addCommonAttribute(Object o,String src, String alt, int width){
		cm.addAttribute(o,"src="+src);
		cm.addAttribute(o,"alt="+alt);
		cm.addAttribute(o,"width="+width);
	}
	
	protected void drawHtmlInput(String src, String type, String name, String alt, int width){
		html.Input in  = new html.Input();
		addCommonAttribute(in,src,alt,width);
		cm.addAttribute(in, "name="+name);
		cm.addAttribute(in, "type="+type);
	}
	
	protected String ArrayListToString(List<?> l){
		String r = ContentManagement.NEW_LINE;
		for(int i = 0; i < l.size(); ++i){
			r +=  l.get(i);
		}
		return r;
	}
	
	
	public List<String> getStreamHtml() {
		return streamHtml;
	}
	

	
	public void setStreamHtml(List<String> streamHtml) {
		this.streamHtml = streamHtml;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
	
}
