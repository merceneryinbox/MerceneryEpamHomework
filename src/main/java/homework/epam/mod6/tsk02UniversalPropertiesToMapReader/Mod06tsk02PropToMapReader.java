/*
Задание 2. Использование Map
Создать “универсальный” класс, позволяющий получить значение из любого properties-
файла. Физическое чтение файла должно происходить только один раз. Результаты чтения
храните в коллекции типа Map.

1) Вопрос : Ответьте на вопрос: как ведет себя map-коллекция если в нее
добавить элемент с ключом, который уже присутствует?

1) Ответ : map-коллекция заменит старое значение с одинаковым ключом на новое с таким же ключом
 */
package homework.epam.mod6.tsk02UniversalPropertiesToMapReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Mod06tsk02PropToMapReader {
	private static String incomingPropertyFileName = null;
	private static Path   incomingPropertyFile     = null;
	
	private static Map<String, String> propertyMap = new HashMap<>();
	
	public static String getIncomingPropertyFileName() {
		return incomingPropertyFileName;
	}
	
	public static void setIncomingPropertyFileName(String incomingPropertyFileName) {
		Mod06tsk02PropToMapReader.incomingPropertyFileName = incomingPropertyFileName;
	}
	
	public static Map<String, String> retrievDataFromPropertyFile(String propertyFileName) {
		Path propertyFile = Paths.get(incomingPropertyFileName);
		try {
			ResourceBundle      resourceBundle = ResourceBundle.getBundle(propertyFileName, Locale.ENGLISH);
			Enumeration<String> enumeration    = resourceBundle.getKeys();
			
			if (enumeration != null) {
				while (enumeration.hasMoreElements()) {
					String tmpStr = enumeration.nextElement();
					propertyMap.put(tmpStr, resourceBundle.getString(tmpStr));
				}
			}
			
		} catch (Exception nsfe) {
			nsfe.printStackTrace();
		}
		return propertyMap;
	}
}
