package homework.epam.mod3.tsk02LocaleAndResourceBundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

public class EngRusQuestionAnswerApp {
	static ResourceBundle myResourceBundle;
	static String myEnResourceFileName = "BundleResource_en.properties";
	static String myRuResourceFileName = "BundleResource_ru.properties";
	
	static String enQuestAnsFileName = "enQuestAns.txt";
	static String ruQuestAnsFileName = "ruQuestAns.txt";
	static Locale myLocale;
	
	public static void main(String[] args) {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Choose your locale: \nPress 1 for English;\n2 для Российской.");
			String  tmpBr    = bufferedReader.readLine();
			Integer localNum = Integer.parseInt(tmpBr);
			
			if (localNum == 1) {
				doEnChoice(bufferedReader, enQuestAnsFileName);
			} else if (localNum == 2) {
				doRuChoice(bufferedReader, ruQuestAnsFileName);
			} else {
				doEnChoice(bufferedReader, enQuestAnsFileName);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void doEnChoice(BufferedReader bufferedReader, String fileName) throws IOException {
		myResourceBundle = ResourceBundle.getBundle(myEnResourceFileName, myLocale);
		System.out.println("Please input number of question you want to answer for you from 1-3:");
		System.out.println("Question 1 ?");
		System.out.println("Question 2 ?");
		System.out.println("Question 3 ?");
		System.out.println("exit for exit.");
		
		readIntFromUser(bufferedReader, fileName);
		
	}
	
	private static void doRuChoice(BufferedReader bufferedReader, String fileName) throws IOException {
		myResourceBundle = ResourceBundle.getBundle(myRuResourceFileName, myLocale);
		System.out.println("Пожалуйста введите номер вопроса, чтобы узнать ответ от 1-3:");
		System.out.println("Вопрос 1 ?");
		System.out.println("Вопрос 2 ?");
		System.out.println("Вопрос 3 ?");
		
		readIntFromUser(bufferedReader, fileName);
	}
	
	private static void readIntFromUser(BufferedReader bufferedReader, String fileName) throws IOException {
		String   tmpBr   = null;
		String[] strings = getStringArrayFromTextFile(fileName);
		readAnswersFromCorrespondingFile(strings, bufferedReader);
	}
	
	private static String[] getStringArrayFromTextFile(String fileName) throws IOException {
		Object[] objects = Files.lines(Paths.get(fileName))
				.toArray();
		String[] strings = new String[objects.length];
		
		for (int i = 0; i < strings.length; i++) {
			strings[i] = (String) objects[i];
		}
		return strings;
	}
	
	private static void readAnswersFromCorrespondingFile(String[] strings, BufferedReader bufferedReader)
			throws IOException {
		String tmpBr = null;
		while (true) {
			tmpBr = bufferedReader.readLine();
			
			if (tmpBr.equalsIgnoreCase("exit")) {
				return;
			}
			
			Integer qnum = Integer.parseInt(tmpBr);
			switch (qnum) {
				case 1:
					System.out.println(strings[1]);
					break;
				case 2:
					System.out.println(strings[2]);
					break;
				case 3:
					System.out.println(strings[3]);
					break;
			}
		}
		
	}
}
