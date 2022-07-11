package redes;

import java.net.ServerSocket;

public class Server {
	
	public static Game game;
	public static ClientThread X, O;
	public static ServerSocket serverSocket;
		
	public static void main(String argv[]) throws Exception {
		Config conf = new Config();
		System.out.println("Servidor iniciado!");
		
		try {
			serverSocket = new ServerSocket(conf.getPort());
			while(true) {
				if(X == null) {
					X = new ClientThread(serverSocket.accept(), "X");
					X.run();
				} else if(O == null) {
					O = new ClientThread(serverSocket.accept(), "O");
					O.run();
					game = new Game();
				}
			}
		} catch (Exception e) {	e.printStackTrace(); }
	}
}
