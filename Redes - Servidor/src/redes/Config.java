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
	private int port;
	
	public Config() {
		this.file = new File("server-config.properties");
		if(!file.exists()) {
			createFile();
		}
		
		loadFile();
	}
	
	private void createFile() {
		try (OutputStream output = new FileOutputStream(file)) {
            Properties prop = new Properties();
            prop.setProperty("port", "5678");
            prop.store(output, null);
        } catch (IOException io) { io.printStackTrace(); }
	}
	
	private void loadFile() {
		try (InputStream input = new FileInputStream(file)) {
            Properties prop = new Properties();
            prop.load(input);
            this.port = Integer.valueOf(prop.getProperty("port"));
        } catch (IOException ex) { ex.printStackTrace(); }
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
