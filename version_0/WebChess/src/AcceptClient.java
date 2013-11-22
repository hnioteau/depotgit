import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class AcceptClient implements Runnable{
	private ServerSocket webServer = null;
	private Socket clientThread = null;
	private String message = null;
	private int clientNumber;
	private BufferedReader inputClientStream = null;
	private PrintWriter outputClientStream = null; 

	
	public AcceptClient(ServerSocket ws){
		setWebServer(ws);
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String m) {
		this.message = m;
	}
	
	public void setWebServer(ServerSocket ws){
		this.webServer = ws;
	}
	
	public ServerSocket getWebServer(){
		return this.webServer;
	}
	private void setClientThread(Socket st){
		this.clientThread = st;
	}
	
	private int getNumberOfClientConnected(){
		return this.clientNumber;
	}
	private void setNumberOfClientConnected(int n){
		this.clientNumber = n;
	}
	
	private Socket getClientThread(){
		return this.clientThread;
	}
	
	private void initConnection(ServerSocket ws){
		System.out.println("I'm listening for one client connection");
		try {
			setClientThread(webServer.accept());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Listen for a client connection to be made to this server socket and accepts it.
		System.out.println("One client connected");
		System.out.println(Integer.toString(getNumberOfClientConnected()));
		setNumberOfClientConnected(this.clientNumber++); // increment number of client
	}
	
	private void initClientInputOutput(){
		try {
			System.out.println("Obtention des flux d'entrees et sorties");
			setInputClientStream(new BufferedReader (new InputStreamReader (getClientThread().getInputStream(),"utf-8")));
			setOutputClientStream(new PrintWriter (new OutputStreamWriter (getClientThread().getOutputStream(),"utf-8"),false));
			setNameOfCurrentThread("Client "+ getNumberOfClientConnected());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setNameOfCurrentThread(String n){
		Thread.currentThread().setName(n); // From request or response;
	}
	
	/*** initialize connection with an client and get output and input streams ***/
	
	private void init(){
		initConnection(getWebServer());
		initClientInputOutput();
	}
	
	private String [] createNewArray(String [] oldArray){
		String newArray[] = new String[oldArray.length * 2];
		// Copy elements from old Array to new Array
		for(int i = 0; i < oldArray.length; ++i){
			newArray[i] = oldArray[i]; 
		}
		return newArray; 
	}
	
	private void showMessage(String [] message){
		for(String line : message ){
			System.out.println(line);
		}
	}
	/*** Response ****/
	
	private void sendMessage(String m, boolean ok){
		
		if(ok){
			getOutputClientStream().println(m);
			System.out.println("Ok");
			getOutputClientStream().flush();
		}
	}
	
	public void run() {
		String r = null; // input line reading from navigator
		
		while(true){
			init();
			String [] m = new String[3]; // message sending 
			int lineCount = 0;
			try {
				while(!(r = getInputClientStream().readLine()).equals("")){
					// Handle message with a different thread 
					
					if(lineCount == m.length){
						m = createNewArray(m);
					}else{
						m[lineCount] = r;
						lineCount++;
						System.out.println(lineCount);
					}
					
				}
				showMessage(m);
				HttpMessage httpM = new HttpMessage(m);
				Thread handleMessage = new Thread(httpM); // Thread that handle message and sending to navigator
				System.out.println("Traitement des messages");
				handleMessage.start();
				System.out.println(Thread.currentThread().getName());
				System.out.println("Thread " + handleMessage.getName());
				System.out.println("***********************************");
				try {
					handleMessage.join();
					System.out.println("Je me prepare à envoyer des données à un client");
					synchronized (handleMessage){
						sendMessage(httpM.getGenericMessage().get(0),httpM.isMessageType());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Fermer");
				getClientThread().close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public BufferedReader getInputClientStream() {
		return inputClientStream;
	}

	public void setInputClientStream(BufferedReader inputClientStream) {
		this.inputClientStream = inputClientStream;
	}

	public PrintWriter getOutputClientStream() {
		return outputClientStream;
	}

	public void setOutputClientStream(PrintWriter outputClientStream) {
		this.outputClientStream = outputClientStream;
	}

}

