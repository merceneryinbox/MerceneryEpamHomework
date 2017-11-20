/*
* Задание 3. Работа с байтовыми и символьными потоками ввода-вывода
Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8.
Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.
* */

package homework.epam.mod4.SE04tsk03Utf8ToUtf16;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 */
public class SE04tsk03 {
	public static void main(String[] args) {
		String fileToRead  = "./src/main/java/homework/epam/mod4/SE04tsk03Utf8ToUtf16/SE04tsk03.java";
		String fileToWrite = fileToRead.concat(".utg16copy");
		
		try {
			Files.write(Paths.get(fileToWrite), Files.readAllLines(Paths.get(fileToRead), StandardCharsets.UTF_8),
			            StandardCharsets.UTF_16);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(" we can't found file.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(" we can't IO acces file.");
		}
		
	}
}
