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
		String bookName           = "Fight Club";
		String author             = "Chack Pollanick";
		String publisher          = "W. W. Norton";
		String type               = "novel";
		int    yearProductionBook = 1996;
		
		HomeLibDAOManager homeLib;
		
		// создать DAO домашней библиотеки
		
		homeLib = HomeLibDAOManager.getInstance();
		
		homeLib.connectToLibrary();
		
		//найти книгу и сохранить её DAO для дальнейшей работы
		
		ExactBookDAO foundBookDAO = homeLib.getMeBook("War and Peace");
		
		
		// добавить новую книгу через DAO библиотеки
		
		homeLib.setNewBook(bookName, author);
		
		
		// создать DAO для книги через DAO библиотеки
		
		ExactBookDAO fightClubDAO = homeLib.getMeBook(bookName);
		
		
		// добавить данные про книгу в базе через DAO библиотеки
		
		homeLib.setYear(bookName, 1996);
		homeLib.setType(bookName, type);
		homeLib.setPublisher(bookName, "Walt Disney");
		
		
		//корректировать данные по книге в базе через DAO самой книги
		
		fightClubDAO.setPublisher(publisher);
		foundBookDAO.setYearProductionBook(yearProductionBook);
		
		
		//удалить книгу через DAO книги
		
		fightClubDAO.selfDestruct();
		
		
		//удалить книгу через DAO библиотеки
		
		
		homeLib.throwBookToTrash("War and Peace");
		
		//показать всю билиотеку
		
		homeLib.bookShelf();
		
		// закрываю библиотеку
		try {
			homeLib.libraryClose();
		} catch (Exception eignore) {
		
		}
	}
}