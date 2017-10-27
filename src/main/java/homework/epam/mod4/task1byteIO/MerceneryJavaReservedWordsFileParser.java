package homework.epam.mod4.task1byteIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MerceneryJavaReservedWordsFileParser {
	private static Map<String, Integer> resultMap = new HashMap<>();
	
	private static String[]  javaKeyWordsInFileArray;
	private static Pattern[] keyWordsPatternsArray;
	private static String[]  javaFileInStringArray;
	
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
		     InputStream reservedJavaWordsFile = new ByteArrayInputStream(
				     Files.readAllBytes(Paths.get(reservedJavaWordsFileName)));
		     InputStream javaFileRead = new ByteArrayInputStream(Files.readAllBytes(Paths.get(javaFileName)))) {

// retrieve arrays of bytes from files - with java keywords and with .java program file
			bytesFromReservedWordFileArray = reservedJavaWordsFile.readAllBytes();
			bytesFromJavaFileArray = javaFileRead.readAllBytes();

// retrieve string with java key words and java program file
			reservedWordsInString = new String(bytesFromReservedWordFileArray, StandardCharsets.UTF_8);
			javaFileInString = new String(bytesFromJavaFileArray, StandardCharsets.UTF_8);

// retrieve array of java keywords from string witch retrieved from file, using new line splitter and initializingmPattern Array.
			javaKeyWordsInFileArray = reservedWordsInString.split("\\n");
			keyWordsPatternsArray = new Pattern[javaKeyWordsInFileArray.length];
			javaFileInStringArray = javaFileInString.split("\\s|\\n|^[a-zA-Z]|^[0-9]");

// store all keywords in the Map with count of inclusive equals 0 and fulfilling array of Patterns for Matcher
			for (int i = 0; i < javaKeyWordsInFileArray.length; i++) {
				resultMap.put(javaKeyWordsInFileArray[i], 0);
				keyWordsPatternsArray[i] = Pattern.compile(javaKeyWordsInFileArray[i]);
			}

// let's parse java keywords in javafile and count its inclusives
			for (int j = 0; j < keyWordsPatternsArray.length; j++) {
				String tmpStr  = javaKeyWordsInFileArray[j];
				int    counter = 0;
				for (int k = 0; k < javaFileInStringArray.length; k++) {
					if (tmpStr.equals(javaFileInStringArray[k])) {
						counter++;
					}
					resultMap.put(tmpStr, counter);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
}