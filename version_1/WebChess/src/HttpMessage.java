import java.util.Arrays;
import java.util.List;


public class HttpMessage implements Runnable{
	private boolean messageType = false; // boolean to know message type (request by default)
	private HttpRequest request = null;
	private HttpResponse response = null;
	private List <String> genericMessage = null;
	private String startLine = null;
	protected static int code; // Request and Response must implement HttpMessage
	protected static String messageCode;
	
	public HttpMessage(String [] m){
		this.genericMessage = Arrays.asList(m);
	}
	
	private void messageHandler(){
		requestHandler();
		responseHandler();
		setGenericMessage(Arrays.asList(getResponse().getResult()));
		System.out.println(""+getGenericMessage().get(0));
		
	}
	
	private void responseHandler(){
		HttpResponse re = new HttpResponse(createStatusLine(code,"HTTP/1.1",messageCode),createHeaders(),createEntityBody());
		setResponse(re);
		messageType = true; // response create and ready
		
		
	}
	/*** A Modifier ***/
	
	private String createStatusLine(int accessStatus,String http_version,String m){
		Rules r = new Rules(http_version,70,4);
		return (r.HTTP_Version + Rules.SP + r.getStatusCode()[accessStatus]  + Rules.SP + m + Rules.CRLF);
	}
	
	private String createHeaders(){
		String h;
		if(code == 404){
			h = (getConnectionState("close") + Rules.CRLF + "Server : Alonzo");
		}else{
			System.out.println("Helooo");
			//System.out.println(getRequest().getExtension());
			h = (getContentType(getRequest().getExtension()) + Rules.CRLF  + getContentLength(10404) + Rules.CRLF +  getConnectionState("close") + Rules.CRLF + "Server: Alonzo");
		}
		return h;
	}
	
	private String getContentType(String v){
		return createContentType(v);
	}
	
	private String createContentType(String v){
		return "Content-Type: " + v + "; charset=utf-8 ";
	}
	
	private String getContentLength(int no){
		return createContentLength(no);
	}
	private String createContentLength(int no){
		return "Content-Length: " + no;
	}
	private String createEntityBody(){
		//System.out.println(getRequest().getResult());
		return getRequest().getResult();
		
	}
	
	private String getConnectionState(String s){
		return createConnectionState(s);
	}
	
	private String createConnectionState(String s){
		return "Connection:" + s;
	}
	/**** Handle Request ***/
	
	private void requestHandler(){
		HttpRequest r = new HttpRequest(getRequestLine());
		setRequest(r);
		System.out.println("Request Line: "+r.getRequestLine());	
	}
	
	
	
	private String getRequestLine(){
		return getGenericMessage().get(0);
	}
	public void run(){
		messageHandler();
	}

	public boolean isMessageType() {
		return messageType;
	}

	public void setMessageType(boolean messageType) {
		this.messageType = messageType;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public HttpResponse getResponse() {
		return response;
	}

	public void setResponse(HttpResponse response) {
		this.response = response;
	}

	public List<String> getGenericMessage() {
		return genericMessage;
	}

	public void setGenericMessage(List<String> genericMessage) {
		this.genericMessage = genericMessage;
	}

	public String getStartLine() {
		return startLine;
	}

	public void setStartLine(String startLine) {
		this.startLine = startLine;
	}
	
	
	
	

}
