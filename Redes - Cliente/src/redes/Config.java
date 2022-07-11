package redes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {
	
	private File file;
	private String ip;
	private int port;
	
	public Config() {
		this.file = new File("client-config.properties");
		if(!file.exists()) {
			createFile();
		}
		
		loadFile();
	}
	
	private void createFile() {
		try (OutputStream output = new FileOutputStream(file)) {
            Properties prop = new Properties();
            prop.setProperty("ip", "localhost");
            prop.setProperty("port", "5678");
            prop.store(output, null);
        } catch (IOException io) { io.printStackTrace(); }
	}
	
	private void loadFile() {
		try (InputStream input = new FileInputStream(file)) {
            Properties prop = new Properties();
            prop.load(input);
            this.ip = prop.getProperty("ip");
            this.port = Integer.valueOf(prop.getProperty("port"));
        } catch (IOException ex) { ex.printStackTrace(); }
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
