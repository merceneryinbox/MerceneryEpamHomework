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
			
// create array with java keywords from byte[]->String->String[] via split() for fulfilling Pattern array
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
		;
		InputStream javaFileRead = new ByteArrayInputStream(Files.readAllBytes(Paths.get(javaFileName)))){

// retrieve arrays of bytes from files - with java keywords and with .java program file
			bytesFromReservedWordFileArray = reservedJavaWordsFile.readAllBytes();
			bytesFromJavaFileArray = javaFileRead.readAllBytes();

// retrieve string with java key words and java program file
			reservedWordsInString = new String(bytesFromReservedWordFileArray, StandardCharsets.UTF_8);
			javaFileInString = new String(bytesFromJavaFileArray, StandardCharsets.UTF_8);

// retrieve array of java keywords from string witch retrieved from file, using new line splitter and initializingmPattern Array.
			javaReservedWordsInFileArray = reservedWordsInString.split("\\n");
			keyWordsPatternsArray = new Pattern[javaReservedWordsInFileArray.length];
			javaFileInStringArray = javaFileInString.split("\\s|\\n|^[a-zA-Z]|^[0-9]");

// store all keywords in the Map with count of inclusive equals 0 and fulfilling array of Patterns for Matcher
			for (int i = 0; i < javaReservedWordsInFileArray.length; i++) {
				resultMap.put(javaReservedWordsInFileArray[i], 0);
				keyWordsPatternsArray[i] = Pattern.compile(javaReservedWordsInFileArray[i]);
			}

// let's parse java keywords in javafile and count its inclusives
			for (int j = 0; j < keyWordsPatternsArray.length; j++) {
				String tmpStr  = javaReservedWordsInFileArray[j];
				int    counter = 0;
				for (int k = 0; k < javaFileInStringArray.length; k++) {
					if (tmpStr.equals(javaFileInStringArray[k])) {
						counter++;
					}
					resultMap.put(tmpStr, counter);
				}
			}
			
		} catch(IOException e){
			e.printStackTrace();
		}
		return resultMap;
	}
}