import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import echec.Echequier;


public class HttpRequest {
	private String requestLine = null;
	private FileInputStream fileToSend = null;
	private File file = null;
	private String result;
	private String extension = null;
	
	
	public HttpRequest(String r){
		setRequestLine(r);
		whatMethodItis(isolateElement());
	}

	private String[] isolateElement(){
		// Get Request
		// Isolate Elements
		String [] elemTab = null; 
		if(getRequestLine().isEmpty()){
			System.out.println("No client request line");
		}else{
			elemTab = getRequestLine().split("\\s");
			for(int i = 0; i < elemTab.length; ++i){
				System.out.println(elemTab[i]);
			}
		}
		return elemTab;
	}
	
	public void showRequestLine(){
		System.out.println(this.getRequestLine());
	}
	/*** When a web server receive a request first thing he does is to identified request line ***/
	
	private void whatMethodItis(String[] elem){
		verificationMethod(elem[0]);
		setExtension(this.handleFileExtension(elem[1]));
		if(elem[0].equals("GET")  && elem[1].equals("/base.html")){
			createFile(elem[1]);
			handleURI(isolateElement());
			
		}if(elem[0].equals("GET") && elem[1].equals("/stylesheet.css")){
			System.out.println("Create");
			createFile(elem[1]);
			setResult(processGETRequest());// retrieve whatever information is identified by Request-URI
		}
		else{
			createFile(elem[1]);
			setResult(processGETRequest());
		}
	}
	
	private void createFile(String URI){
		file = new File("/Users/ismo/Downloads/webchess/"+ URI); // create a new file instance (base.html,stylesheet.css,and so on ...)
		System.out.println("Path of File");
		System.out.println(this.file.getPath());
	}
	
	private String handleFileExtension(String path){
		String ext = null;
		if(path.endsWith(".html")){
			ext = "text/html";
		}
		if(path.endsWith(".css")){
			ext =  "text/css";
		}
		if(path.endsWith(".svg")){
			ext = "image/svg+xml";
		}
		
		return ext;
	}
	
	private String readingFile(){
		System.out.println("Je suis en train de lire...");
		String returnValue = ""; // empty string
		try {
			System.out.println(this.file.getAbsolutePath());
			fileToSend = new FileInputStream(this.file);
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
	
	private String processGETRequest(){
		return readingFile();
		
	}
	
	private void handleURI(String[] rl){
		URI requestURI = null;
		Echequier plateau = new Echequier();
		try {
			requestURI = new URI(rl[1]);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			System.exit(0);
		}
		if(requestURI.getAuthority() != null){
			System.out.println(requestURI.getAuthority());
		}
		if(requestURI.getQuery() != null){
			System.out.println("On vient de cliquer");
			System.out.println(requestURI.getQuery());
			//QueryString query = new QueryString(requestURI.getQuery()); // Get position
			// Send to chessboard to  
			//Convert letter to valid index
			// First is the letter to convert to index
			//String [] abs = query.getKey().split("\\.");
		
		}else{
			if(requestURI.getPath() != null && requestURI.getPath().endsWith("base.html")){
				
				System.out.println("Show Home Page");
				System.out.println(requestURI.getPath());
				
				plateau.start(); // initialize webchessBoard
				
				//Generate base.html
				this.setResult(plateau.showWebchessBoardInHtmlFormat());
			}
			
			HttpMessage.code = 2;
			HttpMessage.messageCode = "OK";
			
			
		}
		
		
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
		//handleFileExtension();
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
}
