package homework.epam.mod5.tsk02UniversalPropertiesReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
 * Задание 2. Обработка исключительных ситуаций
 Создать “универсальный” класс, позволяющий получить значение из любого properties-
 файла. Физическое чтение файла должно происходить только один раз. Обработайте
 следующие исключительные ситуации: нет файла *.properties, нет ключа в properties-файле.
 */
public class PropertiesReaderMercenery {
	private static String incomingPropertyFileName = null;
	private static Path   incomingPropertyFile     = null;
	
	private static FileReader          fileReader  = null;
	private static Map<String, String> propertyMap = new HashMap<>();
	
	public static Path getIncomingPropertyFile() {
		return incomingPropertyFile;
	}
	
	public static void setIncomingPropertyFile(Path incomingPropertyFile) {
		PropertiesReaderMercenery.incomingPropertyFile = incomingPropertyFile;
	}
	
	public static void main(String[] args) {
	
	
	}
	
	/**
	 * Special method correct handling MissingResourceException and NoSuchFileException
	 * @return Map fulfilled by keys and according values of properties
	 */
	public static Map<String, String> returnMapMethodHandler() {
		Map<String, String> handledMap = new HashMap<>();
		
		System.out.println("input correct resource file name please:\n");
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String correctresourceName = bufferedReader.readLine();
			setIncomingPropertyFileName(correctresourceName);
			handledMap = returnMePropertyMap(incomingPropertyFileName);
		
		} catch (MissingResourceException mre) {
			System.out.println("Your resourse have no such key.");
			mre.printStackTrace();
		} catch (NoSuchFileException nsfe) {
			System.out.println("Try to type correct file name.");
			returnMapMethodHandler();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return handledMap;
	}
	
	/**
	 * Main working method takes
	 * @param incomingPropertyFileName from returnMapMethodHandler's console input with help of BufferedReader
	 * @return fulfilled HashMap with keys & properties if were no exceptions
	 * @throws NoSuchFileException &
	 * @throws MissingResourceException witch are handled in special returnMapMethodHandler method
	 */
	private static Map<String, String> returnMePropertyMap(String incomingPropertyFileName) throws NoSuchFileException,
	                                                                                               MissingResourceException {
		setIncomingPropertyFileName(incomingPropertyFileName);
		setIncomingPropertyFile(Paths.get(getIncomingPropertyFileName()));
		ResourceBundle      resourceBundle = ResourceBundle.getBundle(getIncomingPropertyFileName());
		Enumeration<String> enumeration    = resourceBundle.getKeys();
		
		while (enumeration.hasMoreElements()) {
			String nextEl = enumeration.nextElement();
			propertyMap.put(nextEl, resourceBundle.getString(nextEl));
		}
		
		return propertyMap;
	}
	
	public static String getIncomingPropertyFileName() {
		return incomingPropertyFileName;
	}
	
	public static void setIncomingPropertyFileName(String incomingPropertyFileName) {
		PropertiesReaderMercenery.incomingPropertyFileName = incomingPropertyFileName;
	}
	
}
