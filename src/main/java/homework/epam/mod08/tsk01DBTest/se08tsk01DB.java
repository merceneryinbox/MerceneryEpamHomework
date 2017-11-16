package homework.epam.mod08.tsk01DBTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class se08tsk01DB {
	private static final Properties CONFIGS;
	private static Connection connection;
	static {
		CONFIGS = new Properties();
		try (InputStream propertyStream = new FileInputStream("./src/resources/se08tsk01DBPGconfigs.xml")) {
			CONFIGS.loadFromXML(propertyStream);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		connection = ;
	}
	
	private String getUser() {
		return CONFIGS.getProperty("database.user");
	}
	
	private String getPassword() {
		return CONFIGS.getProperty("database.password");
	}
	
	private String getUrl() {
		return getProtocol() + "://" + getHost() + ":" + getPort() + "/" +
		       getDatabaseName();
	}
	
	private String getProtocol() {
		return CONFIGS.getProperty("database.driver");
	}
	
	private String getHost() {
		return CONFIGS.getProperty("database.host");
	}
	
	private String getPort() {
		return CONFIGS.getProperty("database.port");
	}
	
	private String getDatabaseName() {
		return CONFIGS.getProperty("database.name");
	}
}
