package homework.epam.mod08.tsk02DAOConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExactBookDAO {
	
	private static String  bookName           = null;
	private static String  author             = null;
	private static String  publisher          = null;
	private static String  type               = null;
	private static Integer yearProductionBook = null;
	
	// TODO: 17.11.2017 переписать prepared statement запросы под базу библиотеки
	private static String selectStar             = "SELECT * FROM bookShelf;";
	private static String updateYearRequest      = "UPDATE  bookshelf SET yearproductionbook=? WHERE bookname=?;";
	private static String updateTypeRequest      = "UPDATE  bookshelf SET type=? WHERE bookname=?;";
	private static String updateAuthorRequest    = "UPDATE  bookshelf SET author=? WHERE bookname=?;";
	private static String updatePublisherRequest = "UPDATE  bookshelf SET publisher=? WHERE bookname=?;";
	private static String selectRequest          = "SELECT ? FROM bookshelf WHERE bookname=?;";
	
	private static Connection        connection;
	private static PreparedStatement getInfoFromDB;
	private static PreparedStatement chageInfoInDB;
	private static PreparedStatement selectExactInfoFromDB;
	private static ResultSet         resultSet;
	
	public ExactBookDAO(Connection connection, String bookName) {
		this.connection = connection;
		this.setBookName(bookName);
	}
	
	public String getPublisher() {
		try {
			selectExactInfoFromDB = connection.prepareStatement(selectRequest);
			selectExactInfoFromDB.setString(1, "publisher");
			selectExactInfoFromDB.setString(2, getBookName());
			
			resultSet = selectExactInfoFromDB.executeQuery();
			resultSet.next();
			setPublisher(resultSet.getString("publisher"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				selectExactInfoFromDB.close();
			} catch (SQLException eIgnore) {
			}
		}
		return publisher;
	}
	
	public ExactBookDAO setPublisher(String publisher) {
		setPublisher(publisher);
		try {
			chageInfoInDB = connection.prepareStatement(updatePublisherRequest);
			chageInfoInDB.setString(1, publisher);
			chageInfoInDB.setString(2, getBookName());
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				chageInfoInDB.close();
			} catch (SQLException eIgnore) {
			}
		}
		return this;
	}
	
	public String getType() {
		try {
			selectExactInfoFromDB = connection.prepareStatement(selectRequest);
			selectExactInfoFromDB.setString(1, "type");
			selectExactInfoFromDB.setString(1, getBookName());
			resultSet = selectExactInfoFromDB.executeQuery();
			
			resultSet.next();
			setType(resultSet.getString("type"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				selectExactInfoFromDB.close();
			} catch (SQLException eIgnore) {
			}
		}
		return type;
	}
	
	public static String getBookName() {
		return bookName;
	}
	
	public ExactBookDAO setBookName(String bookName) {
		setBookName(bookName);
		return this;
	}
	
	public ExactBookDAO setType(String type) {
		this.type = type;
		try {
			chageInfoInDB = connection.prepareStatement(updateTypeRequest);
			chageInfoInDB.setString(1, type);
			chageInfoInDB.setString(2, getBookName());
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				chageInfoInDB.close();
			} catch (SQLException eIgnore) {
			}
		}
		return this;
	}
	
	public Integer getYearProductionBook() {
		try {
			selectExactInfoFromDB = connection.prepareStatement(selectRequest);
			selectExactInfoFromDB.setString(1, "yearproductionbook");
			selectExactInfoFromDB.setString(2, getBookName());
			resultSet = selectExactInfoFromDB.executeQuery();
			
			resultSet.next();
			setYearProductionBook(resultSet.getInt("yearproductionbook"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				selectExactInfoFromDB.close();
			} catch (SQLException eIgnore) {
			}
		}
		return yearProductionBook;
	}
	
	public ExactBookDAO setYearProductionBook(Integer yearProductionBook) {
		this.yearProductionBook = yearProductionBook;
		try {
			chageInfoInDB = connection.prepareStatement(updateYearRequest);
			chageInfoInDB.setInt(1, yearProductionBook);
			chageInfoInDB.setString(2, getBookName());
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				chageInfoInDB.close();
			} catch (SQLException eIgnore) {
			}
		}
		return this;
	}
	
	public String getAuthor() {
		try {
			getInfoFromDB = connection.prepareStatement(selectRequest);
			getInfoFromDB.setString(1, "author");
			getInfoFromDB.setString(2, getBookName());
			
			resultSet = getInfoFromDB.executeQuery();
			resultSet.next();
			setAuthor(resultSet.getString("author"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				getInfoFromDB.close();
			} catch (SQLException eIgnore) {
			}
		}
		return author;
	}
	
	public ExactBookDAO setAuthor(String author) {
		this.author=author;
		try {
			chageInfoInDB = connection.prepareStatement(updateAuthorRequest);
			chageInfoInDB.setString(1, author);
			chageInfoInDB.setString(2, bookName);
			chageInfoInDB.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				chageInfoInDB.close();
			} catch (SQLException eIgnore) {
			}
		}
		return this;
	}
	
}