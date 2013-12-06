
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;



import echec.Echequier;
import echec.HtmlPageGenerator;
import echec.Pion;


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
				//System.out.println(elemTab[i]);
			}
		}
		return elemTab;
	}
	
	public void showRequestLine(){
		//System.out.println(this.getRequestLine());
	}
	/*** When a web server receive a request first thing he does is to identified request line ***/
	
	private void whatMethodItis(String[] elem){
		
		verificationMethod(elem[0]);
		setExtension(this.handleFileExtension(elem[1]));
		if(elem[0].equals("GET")){  
			createFile(elem[1]);
			handleURI(isolateElement());
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
	private void whatButtonItIs(String b){
		if(b.equals("New")){
			System.out.println("New");
			echec.Echequier clone =  (Echequier) (new Echequier()).clone();
			clone.start();
			AcceptClient.setPlateau(clone);
			this.setResult(AcceptClient.getPlateau().showWebchessBoardInHtmlFormat());
			
			
		}
		
		System.out.println(AcceptClient.getGame().getGame().getArrivee());
		if(b.equals("Undo")){
			
			AcceptClient.getGame().incIndex(1);
			if(AcceptClient.getGame().getPreviousGame() != null){
				//System.out.println(AcceptClient.getGame().getPreviousGame());
				AcceptClient.getGame().getPreviousGame();// Previous Game
				System.out.println(AcceptClient.getGame().getPreviousGame().getDepart());
				//AcceptClient.getGame().getPreviousGame().setDeplacement(em, p);;
				
			}
		}
		if(b.equals("Redo")){
			System.out.println(AcceptClient.getGame().getPreviousGame());
			AcceptClient.getGame().setIndex(2);
			if(AcceptClient.getGame().getPreviousGame() != null){
				AcceptClient.getGame().getPreviousGame(); // Previous Game
				AcceptClient.getGame().getPreviousGame(); // Following Game
		
			}
		}
	}
	
	private void handleURI(String[] rl){
		URI requestURI = null;
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
			// Do a refresh
			
			System.out.println(requestURI.getQuery());
			QueryString query = new QueryString(requestURI.getQuery()); // Get position
			if(requestURI.getQuery().contains("&"))
				query.access(0);
			System.out.println(query.getKey());
			System.out.println(query.getValue());
			// Piece Identity
			int ligne = -1;
			int colonne = -1;
			int c = -1;
			int l = -1;
			if(query.getKey().contains("Button")){
				System.out.println("Un Button vient d'etre presse");
				System.out.println(query.getValue());
				whatButtonItIs(query.getValue());
			}
			if(query.getKey().contains("TO")){
				System.out.println("Contient TO");
				char[] id1 = query.getKey().split("TO")[0].toCharArray();
				char[] id2 = query.getKey().split("TO")[1].toCharArray();
				c = Echequier.createIndices(id1)[1]; 
				l = Echequier.createIndices(id1)[0]; 
				colonne = Echequier.createIndices(id2)[1]; // end point
				ligne =  Echequier.createIndices(id2)[0]; // end point
				System.out.println(colonne);
				System.out.println(ligne);
				System.out.println(c);
				System.out.println(l);
			}else if(query.getKey().contains(".")){
				System.out.println("Normal Query");
				char[] id = query.getKey().split("\\.")[0].toCharArray();
				colonne = Echequier.createIndices(id)[1];
				ligne = Echequier.createIndices(id)[0];
				System.out.println(colonne);
				System.out.println(ligne);
			}
			if(query.getKey().contains("KILL")){
				System.out.println("Hello Kill Someone");
				char[] id1 = query.getKey().split("KILL")[0].toCharArray();
				char[] id2 = query.getKey().split("KILL")[1].toCharArray();
				c = Echequier.createIndices(id1)[1]; // killer
				l = Echequier.createIndices(id1)[0]; // killer
				colonne = Echequier.createIndices(id2)[1]; // victim
				ligne =  Echequier.createIndices(id2)[0]; // victim
				System.out.println(colonne);
				System.out.println(ligne);
				System.out.println(c);
				System.out.println(l);
				System.out.println(HtmlPageGenerator.getCasesToModify()[ligne][colonne]);
				System.out.println("kill Someone");	
			}
		
			if(ligne != -1 || colonne != -1 || c !=-1 || l != -1){
			
			if(AcceptClient.getPlateau().getCase(ligne, colonne).estOccupe() && !(HtmlPageGenerator.getCasesToModify()[ligne][colonne].contains("KILL"))){	
				HtmlPageGenerator.refreshCasesToModify();
				echec.Piece p = AcceptClient.getPlateau().getCase(ligne, colonne).getPiece();
			
				if(p.getType().equals("Pion")){
					if((Echequier.createName(ligne, colonne).contains("7") && p.getCouleur().equals("noir"))){
						System.out.println("Hello");
						((Pion) p).setClicks(1);
						;
					}
					if((Echequier.createName(ligne, colonne).contains("2") && p.getCouleur().equals("blanc"))){
						System.out.println("Hello");
						((Pion) p).setClicks(1);
					}
					if(((Pion) p).getClicks() == 1){
						// First time
						System.out.println(p.getType());
						System.out.println("First Time");
						echec.Position current = new echec.Position(colonne, ligne);
						HtmlPageGenerator.showTheCasesForTheFirstTime(current, p);
						//HtmlPageGenerator.showElements();
						this.setResult(AcceptClient.getPlateau().showWebchessBoardModifyInHtmlFormat());
						//AcceptClient.getGame().pushGame(AcceptClient.getPlateau().showWebchessBoardModifyInHtmlFormat());
						HttpMessage.code = 2;
						HttpMessage.messageCode = "OK";
						((Pion) p).setClicks(0);
					}
					else{
					System.out.println("Ohter time");
					System.out.println(p.getType());
					echec.Position current = new echec.Position(colonne, ligne);
					HtmlPageGenerator.showTheCases(current, p);
					this.setResult(AcceptClient.getPlateau().showWebchessBoardModifyInHtmlFormat());
					HttpMessage.code = 2;
					HttpMessage.messageCode = "OK";
					}
				}else{
					System.out.println("Ohter Piece");
					System.out.println(p.getType());
					echec.Position current = new echec.Position(colonne, ligne);
					HtmlPageGenerator.showTheCases(current, p);
					this.setResult(AcceptClient.getPlateau().showWebchessBoardModifyInHtmlFormat());
					
				}
			
				
			}else{
				
				System.out.println("Je dois faire un deplacement");
				echec.Deplacement de = new echec.Deplacement(new echec.Position(c,l), new echec.Position(colonne,ligne));
				AcceptClient.getGame().pushGame(de);
				de.setDeplacement(AcceptClient.getPlateau().getEmplacement(),AcceptClient.getPlateau().getCase(l,c).getPiece());
				this.setResult(AcceptClient.getPlateau().showWebchessBoardInHtmlFormat());
				
			}
			
			}
			
			
			// Send to chessboard to  
			//Convert letter to valid index
			// First is the letter to convert to index
			// create
		
		}else{
			if(requestURI.getPath() != null && requestURI.getPath().endsWith("base.html")){
				
				System.out.println("Show Html Page");
				//refresh webChessBoard
				echec.Echequier clone =  (Echequier) (new Echequier()).clone();
				
				AcceptClient.setPlateau(clone);
				clone.start();
				System.out.println("Ok");
				System.out.println(clone);
				System.out.println(clone.getCase(0, 0));
				
				//System.out.println(requestURI.getPath());
				//Generate base.html
				String baseHtml = AcceptClient.getPlateau().showWebchessBoardInHtmlFormat();
				this.setResult(baseHtml);
				AcceptClient.setGame(new GameOfChess(new echec.Deplacement(new echec.Position(0,0), new echec.Position(0, 0))));
				HttpMessage.code = 2;
				HttpMessage.messageCode = "OK";
			}
			if(requestURI.getPath() != null && requestURI.getPath().endsWith(".css")){
				System.out.println("Show Stylesheet Page");
				System.out.println(requestURI.getPath());
				System.out.println("Create");
				createFile(requestURI.getPath());
				setResult(processGETRequest());// retrieve whatever information is identified by Request-URI
			
			}if(requestURI.getPath() != null && requestURI.getPath().endsWith(".svg")){
				System.out.println("Show Xhtml+Svg Page");
				System.out.println(requestURI.getPath());
				createFile(requestURI.getPath());
				setResult(processGETRequest());
			}if(requestURI.getPath() != null && requestURI.getPath().endsWith(".ico")){
				System.out.println("Charger le logo");
				//createFile(requestURI.getPath());
				
			}
		
			
			
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
