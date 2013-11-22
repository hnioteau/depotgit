
public class HttpResponse {
	private String statusLine = null;
	private String responseHeader = null;
	private String entityBody = null;
	
	public HttpResponse(String st, String re,String en){
		setStatusLine(st);
		setResponseHeader(re);
		setEntityBody(en);
		
	}
	
	public String getResult(){
		return (getStatusLine() + getResponseHeader() + Rules.CRLF + Rules.CRLF + getEntityBody() + Rules.CRLF);
	}
	
	public String getStatusLine() {
		return statusLine;
	}
	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}
	public String getResponseHeader() {
		return responseHeader;
	}
	public void setResponseHeader(String responseHeader) {
		this.responseHeader = responseHeader;
	}
	public String getEntityBody() {
		return entityBody;
	}
	public void setEntityBody(String entityBody) {
		this.entityBody = entityBody;
	}
	/**** first treatment ****/
	
	
	
	
	/*private void prepareResponse(){
		if (fileExists) {
			statusLine = ;
        setResponseHeader( "Content-type: " + 
                contentType( fileName ) + CRLF); 
} else {
        statusLine = ?;
        contentTypeLine = ?;
        entityBody = "<HTML>" + 
                "<HEAD><TITLE>Not Found</TITLE></HEAD>" +
                "<BODY>Not Found</BODY></HTML>";
}*/
	
	// create an array of code status-code
	// use switch to recognize action to do from specific status code
	
	
}
