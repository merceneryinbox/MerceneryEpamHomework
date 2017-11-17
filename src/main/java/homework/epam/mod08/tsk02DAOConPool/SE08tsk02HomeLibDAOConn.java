package homework.epam.mod08.tsk02DAOConPool;

import java.sql.SQLException;

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
		
		HomeLibDAOManager homeLib;
		
		// создать DAO домашней библиотеки
		
		homeLib = new HomeLibDAOManager();
		
		homeLib.connectToLibrary();
		
		//найти книгу и сохранить её DAO для дальнейшей работы
		
		ExactBookDAO foundBookDAO = homeLib.getMeBook("War and Peace");
		
		
		// добавить новую книгу через DAO библиотеки
		
		homeLib.setNewBook(bookName, author);
		
		
		// создать DAO для книги через DAO библиотеки
		
		ExactBookDAO fightClubDAO = homeLib.bornSeparateBookDAO(bookName);
		
		
		// добавить данные про книгу в базе через DAO библиотеки
		
		homeLib.setYear(bookName, 1996);
		homeLib.setType(bookName, type);
		homeLib.setPublisher(bookName, "Walt Disney");
		
		
		//корректировать данные по книге в базе через DAO самой книги
		
		fightClubDAO.updatePublisher(publisher);
		foundBookDAO.updateYear(yearProductionBook);
		
		
		//удалить книгу через DAO книги
		
		fightClubDAO.selfDestruct();
		
		
		//удалить книгу через DAO библиотеки
		
		
		homeLib.throwToTrashBook("War and Peace");
		
		//показать всю билиотеку
		
		homeLib.bookShelf();
		
		// закрываю библиотеку
		try {
			homeLib.libraryClose();
		} catch (Exception eignore) {
		
		}
	}
}