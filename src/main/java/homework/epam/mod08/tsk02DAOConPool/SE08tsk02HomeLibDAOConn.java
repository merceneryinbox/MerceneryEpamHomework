package homework.epam.mod08.tsk02DAOConPool;

/*
Задание 2. DAO&ConnectionPool
Спроектируйте БД, хранящую информацию, например, о домашней библиотеке.
Реализуйте функциональность

добавления,
поиска и
удаления разнообразной информации

из этой БД. При реализации используйте (напишите) пул соединений и DAO.
 */
public class SE08tsk02HomeLibDAOConn {
	public static void main(String[] args) {
		String author             = "Chack Pollanick";
		String bookName           = "Fight Club";
		int    yearProductionBook = 1996;
		String type               = "novel";
		String publisher          = "W. W. Norton";
		
		
		// создаю DAO домашней библиотеки
		
		HomeLibDAOManager homeLib = new HomeLibDAOManager();
		
		
		// добавляю новую книгу
		
		homeLib.setNewBook(bookName, author);
		
		
		// создаю DAO для книги
		
		ExactBookDAO fightClubDAO = homeLib.bornSeparateBookDAO(bookName);
		
		
		// добавить данные про книгу в базе через DAO библиотеки
		
		homeLib.setYear(bookName, 1995);
		homeLib.setType(bookName, type);
		homeLib.setPublisher(bookName, "Walt Disney");
		
		
		//корректировать данные по книге в базе через DAO самой книги
		
		fightClubDAO.updatePublisher(publisher);
		fightClubDAO.updateYear(bookName, yearProductionBook);
		
	}
}