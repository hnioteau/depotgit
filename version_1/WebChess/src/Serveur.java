
import java.io.IOException;
import java.net.ServerSocket;



public class Serveur {
	
	
	protected static int client_numb;
	
	
	public static void main(String[] args){
		int port = Integer.parseInt(args[0]);
		ServerSocket server = null;
		Thread multipleConnection = null;
		try {
			server = new ServerSocket(port); // create server socket bound to port passed to first argument of main
			server.setReuseAddress(true); // reuse port already used
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(0);
		}
		multipleConnection = new Thread(new AcceptClient(server));
		multipleConnection.start();
		
		
	}
		
		
	
}
