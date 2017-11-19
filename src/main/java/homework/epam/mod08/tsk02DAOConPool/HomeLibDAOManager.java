package homework.epam.mod08.tsk02DAOConPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Don't forget close your library at the end of work with it !
 */
public class HomeLibDAOManager {
	private static          Properties                CONFIGS;
	private static          Connection                connection;
	private static volatile BlockingQueue<Connection> tenConnections;
	private static          Lock                      lock;
	
	// TODO: 17.11.2017 переписать prepared statement запросы под базу библиотеки ++ 17.10.2017 ::19:05
	private static String selectStar        = "SELECT * FROM bookShelf;";
	private static String updateYearRequest = "UPDATE  bookshelf SET yearproductionbook=? WHERE bookname=?;";
	private static String updateTypeRequest = "UPDATE  bookshelf SET type=? WHERE bookname=?;";
	private static String selectRequest     = "SELECT * FROM bookshelf WHERE bookname=?;";
	private static String insertRequest     =
			"INSERT INTO  bookshelf (bookname,author,publisher, type, yearproductionbook) VALUES (?,?,?,?,?);";
	private static String dropRequest       = "DROP TABLE IF EXISTS bookshelf;";
	private static String deleteBookRequest = "DELETE FROM bookShelf WHERE bookname=?;";
	private static String deleteBook        = "DELETE FROM bookshelf WHERE bookname=?;";
	
	
	private static PreparedStatement getInfoFromDB;
	private static PreparedStatement chageInfoInDB;
	private static PreparedStatement selectExactInfoFromDB;
	private static PreparedStatement insertInfoInDB;
	private static PreparedStatement dropTable;
	private static ResultSet         resultSet;
	
	static {
		lock = new ReentrantLock();
		tenConnections = new LinkedBlockingDeque<Connection>(10);
		CONFIGS = new Properties();
		
		try (InputStream stream = new FileInputStream("./src/resource/se08tsk02HomeLibraryDBconfig.xml")) {
			CONFIGS.loadFromXML(stream);
			Class.forName(getDBDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Connection c :
				tenConnections) {
			lock.lock();
			try {
				c = DriverManager.getConnection(getUrl(), getUser(), getPassword());
				tenConnections.put(c);
				lock.unlock();
			} catch (SQLException sqle) {
				System.err.println("Error initialize pool of connections. Reinitialize HomeLib for solvation");
				// TODO: 17.11.2017 добавить логгер
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
	
	private static String getUser() {
		return CONFIGS.getProperty("database.user");
	}
	
	private static String getPassword() {
		return CONFIGS.getProperty("database.password");
	}
	
	public void connectToLibrary() {
		try (InputStream propertyStream = new FileInputStream("./src/resources/se08tsk02HomeLibraryDBconfig.xml")) {
			CONFIGS.loadFromXML(propertyStream);
			Class.forName(getDBDriver());
			connection = getConnection();
			
			// TODO: 17.11.2017 добавить логгер
			
		} catch (ClassNotFoundException e) {
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
				// TODO: 17.11.2017 добавить логгер
				
			}
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
// работа с подключением в базе
	private static String getDBDriver() {
		return CONFIGS.getProperty("database.driver");
	}
	
	public synchronized Connection getConnection() {
		Connection returnCon = null;
		while (tenConnections.isEmpty()) {
			try {
				wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			returnCon = tenConnections.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return returnCon;
	}
	
	public synchronized boolean shutDownPool() {
		boolean result = false;
		try {
			for (Connection c :
					tenConnections) {
				c.close();
			}
			result = true;
		} catch (SQLException e) {
			// TODO: 17.11.2017 add logger
			e.printStackTrace();
		}
		return result;
	}
////////////////////////////////////////////////////////////////////////////////////////////
// работа с запросами к базе
	
	public void setNewBook(String bookName, String author) {
		try {
			connection = getConnection();
			insertInfoInDB = connection.prepareStatement(insertRequest);
			insertInfoInDB.setString(1, bookName);
			insertInfoInDB.setString(2, author);
			
			insertInfoInDB.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error insert new book into your library");
			// TODO: 17.11.2017 Добавить логгер
		} finally {
			try {
				insertInfoInDB.close();
				putBackConnection(connection);
			} catch (SQLException eIgnore) {
			}
			
		}
	}
	
	public synchronized void putBackConnection(Connection usedConnection) {
		
		lock.lock();
		try {
			while (!tenConnections.isEmpty()) {
				wait();
			}
			tenConnections.put(usedConnection);
			notify();
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setYear(String bookName, int year) {
		try {
			connection = getConnection();
			chageInfoInDB = connection.prepareStatement(updateYearRequest, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			chageInfoInDB.setInt(1, year);
			chageInfoInDB.setString(2, bookName);
			
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: 17.11.2017 добавить логгер
			
		} finally {
			try {
				chageInfoInDB.close();
				putBackConnection(connection);
			} catch (SQLException eIgnore) {
			}
		}
		
	}
	
	public void setType(String bookName, String type) {
		try {
			connection = getConnection();
			chageInfoInDB = connection.prepareStatement(updateTypeRequest, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			chageInfoInDB.setString(1, type);
			chageInfoInDB.setString(2, bookName);
			
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: 17.11.2017 добавить логгер
			
		} finally {
			try {
				chageInfoInDB.close();
				putBackConnection(connection);
			} catch (SQLException eIgnore) {
			}
		}
	}
	
	public void setPublisher(String bookName, String publisher) {
		try {
			connection = getConnection();
			chageInfoInDB = connection.prepareStatement(updateTypeRequest, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			chageInfoInDB.setString(1, publisher);
			chageInfoInDB.setString(2, bookName);
			
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: 17.11.2017 добавить логгер
			
		} finally {
			try {
				chageInfoInDB.close();
				putBackConnection(connection);
			} catch (SQLException eIgnore) {
			}
		}
	}
	
	public void throwBookToTrash(String bookName) {
		try {
			connection = getConnection();
			chageInfoInDB = connection.prepareStatement(deleteBookRequest, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			chageInfoInDB.setString(1, bookName);
			
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: 17.11.2017 добавить логгер
		} finally {
			try {
				chageInfoInDB.close();
				putBackConnection(connection);
			} catch (SQLException eIgnore) {
			}
		}
	}
	
	public void bookShelf() {
		// получаю данные из БД в прокручиваемый запрос, для возможности прокурчивать информацию назад (previous())
		// и вперёд next()
		// с возможностью просматривать изменения в базе данных в режиме реального времени
		// так же добавляю возможность изменять базу по ходу просмотра update....()
		try {
			connection = getConnection();
			getInfoFromDB = connection.prepareStatement(selectStar, ResultSet.TYPE_SCROLL_SENSITIVE,
			                                            ResultSet.CONCUR_UPDATABLE);
			resultSet = getInfoFromDB.executeQuery();
			
			while (resultSet.next()) {
				String author             = resultSet.getString("author");
				String bookName           = resultSet.getString("bookName");
				String yearProductionBook = resultSet.getString("yearProductionBook");
				String type               = resultSet.getString("type");
				String publisher          = resultSet.getString("publisher");
				
				System.out.println("bookName | author | publisher| type | yearProductionBook");
				System.out.print(bookName + " |");
				System.out.print(author + " |");
				System.out.println(publisher + " |");
				System.out.print(type + " |");
				System.out.print(yearProductionBook + " |");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				getInfoFromDB.close();
				putBackConnection(connection);
			} catch (SQLException eIgnore) {
			}
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////
// генерация DAO объекта конкретной записи в базе
	
	public void libraryClose() {
		try {
			for (Connection c :
					tenConnections) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException eignore) {
				// TODO: 17.11.2017  Добавить логгер
			}
		}
	}
	
	public ExactBookDAO getMeBook(String bookName) {
		String  author             = null;
		String  publisher          = null;
		String  type               = null;
		Integer yearProductionBook = null;
		try {
			connection = getConnection();
			selectExactInfoFromDB = connection.prepareStatement(selectRequest);
			resultSet = selectExactInfoFromDB.executeQuery();
			
			resultSet.next();
			
			String dropBookName = resultSet.getString("bookName");
			author = resultSet.getString("author");
			publisher = resultSet.getString("publisher");
			type = resultSet.getString("type");
			yearProductionBook = resultSet.getInt("yearProductionBook");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: 17.11.2017 add logger
		} finally {
			putBackConnection(connection);
		}
		return new ExactBookDAO(getConnection(), bookName)
				.setAuthor(author)
				.setPublisher(publisher)
				.setType(type)
				.setYearProductionBook(yearProductionBook);
	}
	
	public void deleteBook(String bookName) {
		try {
			connection = getConnection();
			chageInfoInDB = connection.prepareStatement(deleteBook);
			chageInfoInDB.executeUpdate();
			putBackConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				chageInfoInDB.close();
				putBackConnection(connection);
			} catch (SQLException eIgnore) {
			}
		}
	}
}

