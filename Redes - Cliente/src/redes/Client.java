package redes;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	public static String id;
	
	public static void main(String[] args) {
		try {
			Config conf = new Config();
			Socket socket = new Socket(conf.getIp(), conf.getPort());
			System.out.println("Conectado ao servidor!");
	        new ReadThread(socket).start();
			new WriteThread(socket).start();
		} catch (IOException e) { e.printStackTrace(); }
	}

}
