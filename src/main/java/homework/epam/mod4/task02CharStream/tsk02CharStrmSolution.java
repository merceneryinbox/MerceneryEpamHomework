/*
Задание 2. Работа с символьными потоками ввода-вывода
Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова
языка Java это код содержит. Выведите эти слова и их количество в другой файл.
Используйте только символьные потоки ввода-вывода.
* */
package homework.epam.mod4.task02CharStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tsk02CharStrmSolution {
	public static void main(String[] args) {
		
		Path sourcepath =
				Paths.get(".\\src\\main\\java\\homework\\epam\\mod4\\task02CharStream\\tsk02CharStrmSolution.java");
		Path targetPath = Paths.get("targetPath.txt");
		Path javaWords =
				Paths.get(".\\src\\main\\java\\homework\\epam\\mod4\\task02CharStream\\javareserevedwords.txt");
		try (FileReader readFrom = new FileReader(sourcepath.toFile());
		     FileReader readReservedWords = new FileReader(javaWords.toFile());
		     FileWriter writeTo = new FileWriter(targetPath.toFile())) {
			
			int             intCharInSourceFile;
			Character       characterForSource;
			List<Character> charListInSource = new ArrayList<>();
			
			while ((intCharInSourceFile = readFrom.read()) > 0) {
				characterForSource = (char) intCharInSourceFile;
				charListInSource.add(characterForSource);
			}
// copy List of source file's chars to []
			char[] chars = new char[charListInSource.size()];
			int    i     = 0;
			for (Character c :
					charListInSource) {
				chars[i++] = c;
			}
			
			int             intCharInResereved;
			Character       characterForReserved;
			List<Character> characterListInReserved = new ArrayList<>();
			
			while ((intCharInResereved = readReservedWords.read()) > 0) {
				characterForReserved = (char) intCharInResereved;
				characterListInReserved.add(characterForReserved);
			}
// copy List of reservedJavaFile's chars List to []
			char[] chars1 = new char[characterListInReserved.size()];
			int    j      = 0;
			for (Character c :
					characterListInReserved) {
				chars1[j] = c;
			}
			
			Map<String, Integer> retreivedMap = giveMeMapWithCodeWords(chars, chars1);
			StringBuilder        s            = new StringBuilder();
			for (Map.Entry entry :
					retreivedMap.entrySet()) {
				s.append(entry.getKey() + " содержится в файле " + sourcepath.getFileName() + " " + entry.getValue() +
				         " раз.");
			}
			
			writeTo.write(s.toString()
					              .toCharArray(), 0, s.length());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Map<String, Integer> giveMeMapWithCodeWords(char[] chars, char[] chars1) {
		Map<String, Integer> resultMap             = new HashMap<>();
		byte[]               readFromSourceBytes   = new byte[chars.length];
		byte[]               readFromReservedBytes = new byte[chars1.length];
		
		for (int i = 0; i < chars.length; i++) {
			readFromSourceBytes[i] = (byte) chars[i];
		}
		String builder    = new String(readFromSourceBytes, StandardCharsets.UTF_8);
		String resStrings = new String(readFromReservedBytes, StandardCharsets.UTF_8);
		
		String[] sourceWordsAr   = builder.split("\\n,\\s,\\t,^[a-zA-Z],^[0-9]");
		String[] reservedWordsAr = resStrings.split("\\n,\\s,\\t,^[a-zA-Z],^[0-9]");
		
		for (int i = 0; i < reservedWordsAr.length; i++) {
			int    matchCounter = 0;
			String tmpStr       = reservedWordsAr[i];
			
			for (int j = 0; j < sourceWordsAr.length; j++) {
				if (tmpStr.equals(sourceWordsAr[j])) {
					matchCounter++;
					resultMap.put(tmpStr, matchCounter);
				}
			}
		}
		return resultMap;
	}
}
