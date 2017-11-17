package homework.epam.mod08.tsk02DAOConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExactBookDAO {
	
	private static String  author             = null;
	private static String  publisher          = null;
	private static String  type               = null;
	private static Integer yearProductionBook = null;
	
	// TODO: 17.11.2017 переписать prepared statement запросы под базу библиотеки
	private static String selectStar        = "SELECT * FROM bookShelf;";
	private static String updateYearRequest = "UPDATE TABLE bookshelf SET yearproductionbook=? WHERE bookname=?;";
	private static String updateTypeRequest = "UPDATE TABLE bookshelf SET type=? WHERE bookname=?;";
	private static String selectRequest     = "SELECT * FROM bookshelf WHERE bookname=?;";
	private static String insertRequest     =
			"INSERT INTO  bookshelf (bookname,author,publisher, type, yearproductionbook) VALUES (?,?,?,?,?);";
	private static String dropRequest       = "DROP TABLE IF EXISTS bookshelf;";
	private static String deleteBookRequest = "DELETE FROM bookShelf WHERE bookname=?;";
	
	private static Connection        connection;
	private static PreparedStatement getInfoFromDB;
	private static PreparedStatement chageInfoInDB;
	private static PreparedStatement selectExactInfoFromDB;
	private static PreparedStatement insertInfoInDB;
	private static PreparedStatement dropTable;
	private static ResultSet         resultSet;
	
	public ExactBookDAO(Connection connection) {
		this.connection = connection;
	}
	
	public static String getAuthor() {
		return author;
	}
	
	public ExactBookDAO setAuthor(String author) {
		setAuthor(author);
		return this;
	}
	
	public static String getPublisher() {
		return publisher;
	}
	
	public ExactBookDAO setPublisher(String publisher) {
		setPublisher(publisher);
		return this;
	}
	
	public static String getType() {
		return type;
	}
	
	public ExactBookDAO setType(String type) {
		setType(type);
		return this;
	}
	
	public static Integer getYearProductionBook() {
		return yearProductionBook;
	}
	
	public ExactBookDAO setYearProductionBook(Integer yearProductionBook) {
		ExactBookDAO.yearProductionBook = yearProductionBook;
		return this;
	}
	
	public ExactBookDAO setBookName(String bookName) {
		setBookName(bookName);
		return this;
	}
	
	public void updatePublisher(String publisher) {
		setPublisher(publisher);
	}
	
	public void updateYear(int yearProductionBook) {
		setYearProductionBook(yearProductionBook);
	}
}
