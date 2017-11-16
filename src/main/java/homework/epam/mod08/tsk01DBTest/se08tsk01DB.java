package homework.epam.mod08.tsk01DBTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class se08tsk01DB {
	private static Properties CONFIGS;
	private static Connection connection;
	
	public static void main(String[] args) {
		try (InputStream propertyStream = new FileInputStream("./src/resources/se08tsk01DBPGconfigs.xml")) {
			CONFIGS.loadFromXML(propertyStream);
			Class.forName(getDBDriver());
			connection = DriverManager.getConnection(getUrl(), "username", "password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static String getDBDriver() {
		return CONFIGS.getProperty("database.driver");
	}
	
	private static String getUrl() {
		return getProtocol() + "://" + getHost() + ":" + getPort() + "/" +
		       getDatabaseName();
	}
	
	private static String getProtocol() {
		return CONFIGS.getProperty("database.driver");
	}
	
	private static String getHost() {
		return CONFIGS.getProperty("database.host");
	}
	
	private static String getPort() {
		return CONFIGS.getProperty("database.port");
	}
	
	private static String getDatabaseName() {
		return CONFIGS.getProperty("database.name");
	}
	
	private String getUser() {
		return CONFIGS.getProperty("database.user");
	}
	
	private String getPassword() {
		return CONFIGS.getProperty("database.password");
	}
}
