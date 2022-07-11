package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteThread extends Thread {
	
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader br;
	
	public WriteThread(Socket socket) {
		this.socket = socket;
		this.br = new BufferedReader(new InputStreamReader(System.in));
		try {
			this.writer = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String request = br.readLine();
				writer.println(request);
				System.out.println("[Enviado]: " + request);
			} catch (IOException e) { e.printStackTrace(); }
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}
	
}
