import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpRequest {
	private String requestLine = null;
	private FileInputStream fileToSend = null;
	private File file = null;
	private String result;
	
	public HttpRequest(String r){
		setRequestLine(r);
		whatMethodItis(isolateElement());
	}

	private String[] isolateElement(){
		// Prendre la requete 
		// Puis isoler les elements
		String [] elemTab = null; 
		if(getRequestLine().isEmpty()){
			System.out.println("No client request");
		}else{
			elemTab = getRequestLine().split("\\s");
			//showRequestLine();
		}
		return elemTab;
	}
	
	public void showRequestLine(){
		System.out.println(this.getRequestLine());
	}
	/*** When a web server receive a request first thing he does is to identified request line ***/
	
	private void whatMethodItis(String[] elem){
		verificationMethod(elem[0]);
		if(elem[0].equals("GET")){
			 setResult(processGETRequest(elem)); // retrieve whatever information is identified by Request-URI
		}
		
	}
	
	private void createFile(String URI){
		file = new File("/Users/ismo/Downloads/webchess" + URI); // create a new file instance (base.html,stylesheet.css,and so on ...)
	}
	
	private String handleFileExtension(){
		String name = null;
		name = file.getName(); // get name file
		String ext = null;
		if(name.endsWith("html")){
			ext = "text/html";
		}
		if(name.endsWith("css")){
			ext =  "text/css";
		}
		if(name.endsWith("svg")){
			ext = "image/svg+xml";
		}
		
		return ext;
	}
	
	public String getFileExtension(){
		return handleFileExtension();
	}
	
	private String readingFile(String URI){
		System.out.println("Je suis en train de lire...");
		String returnValue = ""; // empty string
		try {
			createFile(URI);
			fileToSend = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileToSend,"utf-8"));
			String line = "";
			while ((line = reader.readLine()) != null) {
			      returnValue += line + "\n";
			}
			HttpMessage.code = 2;
			HttpMessage.messageCode = "OK";
		} catch (Exception e) {
			System.out.println("File Not Found");
			HttpMessage.code = 21;
			HttpMessage.messageCode = "Not Found";
			
			//System.exit(0);
		}finally {
		    if (fileToSend != null) {
		        try {
		          fileToSend.close();
		        } catch (IOException e) {
		          // Ignore issues during closing
		        }
		    }
		}
		return returnValue;
	}
	
	private String processGETRequest(String[] elem){
		return readingFile(elem[1]);
		
	}
	
	private void verificationMethod(String m){
		if(HttpRequest.isUpperCase(m)){
			System.out.println("Method Recognized");
		}
	}
	
	protected static boolean isUpperCase(String s){
		for(int i = 0; i < s.length(); ++i){
			if(Character.isLowerCase(s.charAt(i))){
				return false;
			}
		}
		return true;
	}
	public String getRequestLine() {
		return requestLine;
	}


	public void setRequestLine(String requestLine) {
		this.requestLine = requestLine;
	}

	public String getResult() {
		handleFileExtension();
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
