package homework.epam.mod3.tsk02LocaleAndResourceBundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * приложение, позволяющее по выбору пользователя использовать русский или английский язык, для отображения информации.
 * Приложение представляtт собой перечень вопросов под номерами (на английском или русском соответственно). Выбрав номер
 * вопроса пользователь может узнать ответ на него на языке запроса.
 */
public class EngRusQuestionAnswerApp {
	static ResourceBundle myResourceBundle;
	static String myEnResourceFileName = "BundleResource_en.properties";
	static String myRuResourceFileName = "BundleResource_ru.properties";
	
	public static void main(String[] args) {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			
			System.out.println(
					"Choose your locale\\Выберите локаль: \nPress 1 for English;\nНажмите 2 для Российской.");
			String  tmpBr    = bufferedReader.readLine();
			Integer localNum = Integer.parseInt(tmpBr);
			
			if (localNum == 1) {
				doEnChoice(bufferedReader, myEnResourceFileName);
			} else if (localNum == 2) {
				doRuChoice(bufferedReader, myRuResourceFileName);
			} else {
				doEnChoice(bufferedReader, myEnResourceFileName);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method for english users
	 *
	 * @param bufferedReader taken from main method's try block
	 * @param fileName       automaticaly choosen resource file with needed locale
	 * @throws IOException
	 */
	private static void doEnChoice(BufferedReader bufferedReader, String fileName) throws IOException {
		myResourceBundle = ResourceBundle.getBundle(myEnResourceFileName, Locale.ENGLISH);
		System.out.println("Please input number of question you want to answer for you from 1-3:");
		System.out.println("Question 1 ?");
		System.out.println("Question 2 ?");
		System.out.println("Question 3 ?");
		System.out.println("exit for exit.");
		
		readIntFromUser(bufferedReader, fileName);
		
	}
	
	/**
	 * method for russian users
	 *
	 * @param bufferedReader taken from main method's try block
	 * @param fileName       automaticaly choosen resource file with needed locale
	 * @throws IOException
	 */
	private static void doRuChoice(BufferedReader bufferedReader, String fileName) throws IOException {
		myResourceBundle = ResourceBundle.getBundle(myRuResourceFileName, Locale.forLanguageTag("RU"));
		System.out.println("Пожалуйста введите номер вопроса, чтобы узнать ответ от 1-3:");
		System.out.println("Вопрос 1 ?");
		System.out.println("Вопрос 2 ?");
		System.out.println("Вопрос 3 ?");
		
		readIntFromUser(bufferedReader, fileName);
	}
	
	/**
	 * tool method for printout the result of question taken from do..Choice methods
	 *
	 * @param bufferedReader taken from do..Choice method
	 * @param numQ           - question taken from do..Choice method
	 * @throws IOException
	 */
	private static void readIntFromUser(BufferedReader bufferedReader, String numQ) throws IOException {
		System.out.println(myResourceBundle.getString(numQ));
	}
}
