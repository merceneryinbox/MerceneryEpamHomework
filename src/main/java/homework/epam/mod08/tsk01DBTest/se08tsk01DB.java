package homework.epam.mod08.tsk01DBTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
Задание 1. Работа с БД с помощью JDBC
Создайте таблицу в БД и с помощью JDBC выполните следующие действия
 извлеките информацию из таблицы с помощью подготовленного запроса;
 обновите несколько записей в таблице;
 выберите конкретную запись в таблице;
 вставьте новую запись в таблицу;
 удалите таблицу.
 */

public class se08tsk01DB {
	private static Properties CONFIGS;
	private static Connection connection;
	private static String selectStar   = "SELECT * FROM ? WHERE login=?";
	// UPDATE <имя_таблицы> SET <имя_поля_1>=<величина_поля_1>, <имя_поля_2>=<величина_поля_2> ...
	private static String updateReqest = "UPDATE ? SET ? =? WHERE user_id>?";
	private static PreparedStatement getInfoFromDB;
	private static PreparedStatement chageInfoFromDB;
	private static ResultSet         resultSet;
	
	public static void main(String[] args) {
		try (InputStream propertyStream = new FileInputStream("./src/resources/se08tsk01DBPGconfigs.xml")) {
			CONFIGS.loadFromXML(propertyStream);
			Class.forName(getDBDriver());
			connection = DriverManager.getConnection(getUrl(), "username", "password");

// Q:1
			// получаю данные из БД в прокручиваемый запрос, для возможности прокурчивать информацию назад (previous())
			// и вперёд next()
			// с возможностью просматривать изменения в базе данных в режиме реального времени
			// так же добавляю возможность изменять базу по ходу просмотра update....()
			getInfoFromDB = connection.prepareStatement(selectStar, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			getInfoFromDB.setString(1, "users");
			getInfoFromDB.setString(2, "'admin'");
			resultSet = getInfoFromDB.executeQuery();
// Q:2
			chageInfoFromDB = connection.prepareStatement(updateReqest, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                              ResultSet.CONCUR_UPDATABLE);
			chageInfoFromDB.setString(1,"users");
			chageInfoFromDB.setString(2,"role_id");
			chageInfoFromDB.setInt(3,1);
			chageInfoFromDB.setInt(3,3);
			
			chageInfoFromDB.executeUpdate();
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
