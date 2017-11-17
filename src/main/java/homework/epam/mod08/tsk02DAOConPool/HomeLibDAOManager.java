package homework.epam.mod08.tsk02DAOConPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Don't forget close your library at the end of work with it !
 */
public class HomeLibDAOManager {
	private static String     bookName;
	private static Properties CONFIGS;
	private static Connection connection;
	
	// TODO: 17.11.2017 переписать prepared statement запросы под базу библиотеки
	private static String selectStar        = "SELECT * FROM ? WHERE login=?;";
	private static String updateYearRequest = "UPDATE ? SET ? =? WHERE user_id>?;";
	private static String updateTypeRequest = "UPDATE ? SET ? =? WHERE user_id>?;";
	private static String selectRequest     = "SELECT * FROM roles WHERE role_name=?;";
	private static String insertRequest     = "INSERT INTO users (login,password,role_id) VALUE (?,?,?);";
	private static String dropRequest       = "DROP TABLE IF EXISTS ?;";
	private static PreparedStatement getInfoFromDB;
	private static PreparedStatement chageInfoInDB;
	private static PreparedStatement selectExactInfoFromDB;
	private static PreparedStatement insertInfoInDB;
	private static PreparedStatement dropTable;
	private static ResultSet         resultSet;
	
	public void connectToLibrary() {
		try (InputStream propertyStream = new FileInputStream("./src/resources/se08tsk02HomeLibraryDBconfig.xml")) {
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
	
	public void setNewBook(String bookName, String author) {
		try {
			insertInfoInDB = connection.prepareStatement(insertRequest);
			insertInfoInDB.setString(1, bookName);
			insertInfoInDB.setString(2, author);
			
			insertInfoInDB.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error insert new book into your library");
			// TODO: 17.11.2017 Добавить логгер
		}
		
	}
	
	public void setYear(String bookName, int year) {
		try {
			chageInfoInDB = connection.prepareStatement(updateYearRequest, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			chageInfoInDB.setInt(1, year);
			chageInfoInDB.setString(2, bookName);
			
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setType(String bookName, String type) {
		try {
			chageInfoInDB = connection.prepareStatement(updateTypeRequest, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			chageInfoInDB.setString(1, type);
			chageInfoInDB.setString(2, bookName);
			
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setPublisher(String bookName, String publisher) {
		try {
			chageInfoInDB = connection.prepareStatement(updateTypeRequest, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			chageInfoInDB.setString(1, publisher);
			chageInfoInDB.setString(2, bookName);
			
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
