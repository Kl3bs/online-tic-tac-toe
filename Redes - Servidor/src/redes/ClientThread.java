package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {

	private String id;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;

	public ClientThread(Socket socket, String id) {
		this.id = id;
		this.socket = socket;
	}

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			write(id);
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public void write(String message) {
		writer.println(message);
		System.out.println("[Enviado -> " + id +"]: " + message);
	}
		
	public String read() {
		String read = "";
		try {
			read = reader.readLine();
			System.out.println("[Recebido -> " + id +"]: " + read);
			return read;
		} catch (IOException e) { e.printStackTrace(); }
		return read;
	}
	
	public PrintWriter getWriter() {
		return writer;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}
	
}