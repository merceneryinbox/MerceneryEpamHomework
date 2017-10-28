package homework.epam.mod4.task1byteIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MerceneryJavaReservedWordsFileParser {
	private static Map<String, Integer> resultMap = new HashMap<>();
	
	private static String[]  javaReservedWordsInFileArray;
	private static String[]  javaFileInStringArray;
	private static Pattern[] keyWordsPatternsArray;
	
	private static Matcher matcher;
	
	private static byte[] bytesFromReservedWordFileArray;
	private static byte[] bytesFromJavaFileArray;
	
	private static String reservedWordsInString;
	private static String javaFileInString;
	private static String outputFileName;
	private static String result;
	
	
	MerceneryJavaReservedWordsFileParser() {
	}
	
	
	public Map transmitJavaWordsCount(String reservedJavaWordsFileName, String outputFileName, String javaFileName) {
		try (OutputStream infoStoreFileAboutJavaFile = new ByteArrayOutputStream();
		     InputStream reservedJavaWordsFile = new FileInputStream(reservedJavaWordsFileName);
		     InputStream javaFile = new FileInputStream(javaFileName)) {
			
			bytesFromReservedWordFileArray = new byte[reservedJavaWordsFile.available()];
			bytesFromJavaFileArray = new byte[javaFile.available()];
			
			reservedJavaWordsFile.read(bytesFromReservedWordFileArray, 0, bytesFromReservedWordFileArray.length);
			javaFile.read(bytesFromJavaFileArray, 0, bytesFromJavaFileArray.length);

// retrieve arrays of bytes from files - with java keywords and with .java program file byte[]->String->String[] via split()
			reservedWordsInString = new String(bytesFromReservedWordFileArray, StandardCharsets.UTF_8);
			javaReservedWordsInFileArray = reservedWordsInString.split("\\n");
			keyWordsPatternsArray = new Pattern[javaReservedWordsInFileArray.length];
			for (int i = 0; i < javaReservedWordsInFileArray.length; i++) {
				keyWordsPatternsArray[i] = Pattern.compile(javaReservedWordsInFileArray[i]);
			}

// create byte[]->String->String[] via split() separating all words in file to alone String from *.java file
			javaFileInString = new String(bytesFromJavaFileArray, StandardCharsets.UTF_8);
			javaFileInStringArray = javaFileInString.split("\\s,\\n,\\t,^[a-zA-Z]|^[0-9]");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
}