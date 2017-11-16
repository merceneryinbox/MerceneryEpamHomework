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
	private static String selectStar    = "SELECT * FROM ? WHERE login=?;";
	private static String updateRequest = "UPDATE ? SET ? =? WHERE user_id>?;";
	private static String selectRequest = "SELECT * FROM roles WHERE role_name=?;";
	private static String insertRequest = "INSERT INTO users (login,password,role_id) VALUE (?,?,?);";
	private static String dropRequest   = "DROP TABLE IF EXISTS ?;";
	
	private static PreparedStatement getInfoFromDB;
	private static PreparedStatement chageInfoInDB;
	private static PreparedStatement selectExactInfoFromDB;
	private static PreparedStatement insertInfoInDB;
	private static PreparedStatement dropTable;
	
	private static ResultSet resultSet;
	
	public static void main(String[] args) {
		try (InputStream propertyStream = new FileInputStream("./src/resources/se08tsk01DBPGconfigs.xml")) {
			CONFIGS.loadFromXML(propertyStream);
			Class.forName(getDBDriver());
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());

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
			chageInfoInDB = connection.prepareStatement(updateRequest, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			chageInfoInDB.setString(1, "users");
			chageInfoInDB.setString(2, "role_id");
			chageInfoInDB.setInt(3, 1);
			chageInfoInDB.setInt(3, 3);
			
			chageInfoInDB.executeUpdate();

// Q:3
			selectExactInfoFromDB = connection.prepareStatement(selectRequest);
			selectExactInfoFromDB.setString(1, "'updaters'");
			resultSet = selectExactInfoFromDB.executeQuery();
			
			// old plain output of DB data before JDBC 2.0
			System.out.println(
					"role_id     |    role_name    |    can_read    |    can_write    |    can_update      |  can_revoke    |    role_misc");
			
			while (resultSet.next()) {
				int     role_id    = resultSet.getInt("role_id");
				String  role_name  = resultSet.getString("role_name");
				boolean can_read   = resultSet.getBoolean("can_read");
				boolean can_write  = resultSet.getBoolean("can_write");
				boolean can_update = resultSet.getBoolean("can_update");
				boolean can_revoke = resultSet.getBoolean("can_revoke");
				String  role_misc  = resultSet.getString("role_misc");
				System.out.println(
						role_id + " | " + role_name + " | " + can_read + " | " + can_write + " | " + can_update +
						" | " + can_revoke + " | " + role_misc);
			}
//Q:4
			insertInfoInDB = connection.prepareStatement(insertRequest);
			insertInfoInDB.setString(1, "'friend'");
			insertInfoInDB.setString(2, "'passss'");
			insertInfoInDB.setInt(3, 1);
			
			insertInfoInDB.executeUpdate();

//Q:5
			dropTable = connection.prepareStatement(dropRequest);
			dropTable.setString(1, "users");
			dropTable.executeUpdate();
			
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
	
	private static String getUser() {
		return CONFIGS.getProperty("database.user");
	}
	
	private static String getPassword() {
		return CONFIGS.getProperty("database.password");
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
}
