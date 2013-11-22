
final public class Rules {
	final static String CRLF = "\r\n";
	final static String SP = " ";
	final String HTTP_Version;
 
	private final String[] statusCode;
	private final String[] responseHeaders;
	private final String[] generalHeaders;
	private final String[] entityHeaders;
	
	
	public Rules(String hv, int lenStatus, int lenFields){
		this.HTTP_Version = hv;
		this.statusCode = createTab(lenStatus,"statusCode"); // instantiate once an Array of STATUS CODE
		this.responseHeaders = createTab(9,"responseHeaders"); // instantiate once an Array of responses headers
		this.generalHeaders = createTab(9,"generalHeaders"); // instantiate once an Array of general headers
		this.entityHeaders = createTab(9,"entityHeaders"); // instantiate once an Array of entity general headers
	}
	
	
	public static int getIndexStatus(String[] tab, String code){  // access to status code
		int i;
		for(i = 0; i < tab.length; ++i){
			if(tab[i].equals(code)){
				break;
			}
		}
		return i;
	}
	public String getHttpVersion(){
		return this.HTTP_Version;
	}
	
	protected void affichageTab(String[] tab){
		for (int i= 0; i < tab.length; ++i){
			System.out.println(tab[i]);
		}
	}
	private void createGeneralHeaders(String[] temp){
		String genHeader= null;
		for(int i = 0; i< temp.length; ++i){
			switch(i){
			case 0:
				genHeader = "Cache-Control";
				break;
			case 1:
				genHeader = "Connection";
				break;
			case 2:
				genHeader = "Date";
				break;
			case 3:
				genHeader = "Pragma";
				break;
			case 4:
				genHeader = "Trailer";
				break;
			case 5:
				genHeader = "Transfer-encoding";
				break;
			case 6:
				genHeader = "Upgrade";
				break;
			case 7:
				genHeader = "Via";
				break;
			case 8:
				genHeader = "Warning";
				break;
			}
			temp[i] = genHeader;
		}
	}
	private void createEntityHeaders(String[] temp){
		String entHeader = null;
		for(int i = 0; i< temp.length; ++i){
			switch(i){
			case 0:
				entHeader = "Allow";
				break;
			case 1:
				entHeader = "Content-Encoding";
				break;
			case 2:
				entHeader = "Content-Language";
				break;
			case 3:
				entHeader = "Content-Length";
				break;
			case 4:
				entHeader = "Content-MD5";
				break;
			case 5:
				entHeader = "Content-Range";
				break;
			case 6:
				entHeader = "Content-Type";
				break;
			case 7:
				entHeader = "Expires";
				break;
			case 8:
				entHeader = "Last-Modified";
				break;
			case 9: 
				entHeader = "extension";
			}
			temp[i] = entHeader;
		}
		
	}
	private void createRespondeHeaders(String[] temp){
		String respHeader = null;
		for(int i = 0; i< temp.length; ++i){
			switch(i){
			case 0:
				respHeader = "Accept-Ranges";
				break;
			case 1:
				respHeader = "Age";
				break;
			case 2:
				respHeader = "Etag";
				break;
			case 3:
				respHeader = "Location";
				break;
			case 4:
				respHeader = "Proxy-Authenticate";
				break;
			case 5:
				respHeader = "Retry-After";
				break;
			case 6:
				respHeader = "Server";
				break;
			case 7:
				respHeader = "Vary";
				break;
			case 8:
				respHeader = "WWW-Autheticate";
				break;
			}
			temp[i] = respHeader;
		}
	}
	
	private void createStatusCode(String[] temp){
		int value = 100;
		for(int i = 0; i < temp.length; ++i){
			switch(value){
			case 102 :
				value = 200;
				break;
			case 207 :
				value = 300;
				break;
			case 308 :
				value = 400;
				break;
			case 418:
				value = 500;
				break;
			}
			temp[i] = "" + value;
			value++;
		}
	}
	

	private String[] createTab(int length, String type){
		String[] temp = new String[length]; 
		switch(type.charAt(0)){
		case 's':
			createStatusCode(temp);
			break;
		case 'r':
			createRespondeHeaders(temp);
			break;
		case 'e':
			createEntityHeaders(temp);
			break;
		case 'g':
			createGeneralHeaders(temp);
			break;
		}
		return temp;
	}

	public String[] getGeneralHeaders() {
		return generalHeaders;
	}

	public String[] getEntityHeaders() {
		return entityHeaders;
	}

	public String[] getResponseHeaders() {
		return responseHeaders;
	}

	public String[] getStatusCode() {
		return statusCode;
	}
		
}
