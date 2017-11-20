/*
*Задание 1. Работа с байтовыми потоками ввода-вывода
1) Прочитайте файл, содержащий код на языке Java.(https://habrahabr.ru/post/108076/ , https://ru.stackoverflow.com/questions/429706/%D0%92-%D0%BA%D0%B0%D0%BA%D0%B8%D1%85-%D1%81%D0%BB%D1%83%D1%87%D0%B0%D1%8F%D1%85-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-bytearrayinputstream)
2) Определите, какие ключевые слова языка Java это код содержит.
3) Выведите эти слова и их количество в другой файл.
-- !-- Используйте только байтовые потоки ввода-вывода.-- !--
* */
package homework.epam.mod4.task1byteIO;

import java.util.Map;

/**
 *
 */
public class SE04JavaByteSpecWordsParser {
	String[] reservedJavaWords;
	
	public static void main(String[] args) {
		// declare & initiate filenames
		String reservedJavaWordsFileName = "javareservedwords.txt";
		String javaFileName              = MerceneryJavaReservedWordsInFileParser.class.getName();
		String outputFileName            = "outputFile.txt";
		
		// initiate my parserPlus class object
		MerceneryJavaReservedWordsInFileParser parserPlus = new MerceneryJavaReservedWordsInFileParser();
		
		// store map with keywords & theirs count
		Map<String, Integer> resultInformation =
				parserPlus.transmitJavaWordsCount(reservedJavaWordsFileName, outputFileName, javaFileName);
		for (Map.Entry entry : resultInformation.entrySet()) {
			String tmpStr = "В файле " + javaFileName + " встречается " + entry.getValue() + " ключевое слово " +
			                entry.getKey();
			System.out.println(tmpStr);
		}
	}
}
