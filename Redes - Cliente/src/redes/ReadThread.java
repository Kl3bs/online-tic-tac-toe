package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {
	
	private Socket socket;
	private BufferedReader reader;
	
	public ReadThread(Socket socket) {
		this.socket = socket;
		try {
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	@Override
	public void run() {
		try {
			Client.id = reader.readLine();
			System.out.println("Recebido o ID: " + Client.id);
			String input = "";
			while(!input.contains("Empate") && !input.contains("vencedor")) {
				input = reader.readLine();
				System.out.println("[Recebido]: " + input);
			}
			
			System.out.println("Jogo encerrado!");
			socket.close();
			System.exit(0);
		} catch (IOException e) { e.printStackTrace(); }
		
	}
	
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public BufferedReader getreader() {
		return reader;
	}
	public void setreader(BufferedReader reader) {
		this.reader = reader;
	}

}
