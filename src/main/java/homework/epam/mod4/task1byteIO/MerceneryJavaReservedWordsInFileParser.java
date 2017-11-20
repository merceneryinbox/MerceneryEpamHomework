package homework.epam.mod4.task1byteIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MerceneryJavaReservedWordsInFileParser {
	private static Map<String, Integer> resultMap;
	
	private static String[] javaReservedWordsInFileArray;
	private static String[] javaFileInStringArray;
	
	private static byte[] bytesFromReservedWordFileArray;
	private static byte[] bytesFromJavaFileArray;
	
	private static String reservedWordsInString;
	private static String javaFileInString;
	private static String outputFileName;
	private static String result;
	
	/**
	 * Constructor
	 */
	MerceneryJavaReservedWordsInFileParser() {
		resultMap = new HashMap<>();
	}
	
	/**
	 * @param reservedJavaWordsFileName - main array for match words from it
	 * @param outputFileName            - filename in witch result is writing
	 * @param javaFileName              - start file from witch I try to retrieve matches
	 * @return Map for further using
	 */
	public Map transmitJavaWordsCount(String reservedJavaWordsFileName, String outputFileName, String javaFileName) {
		try (OutputStream infoStoreFileAboutJavaFile = new FileOutputStream(outputFileName);
		     InputStream reservedJavaWordsFile = new FileInputStream(reservedJavaWordsFileName);
		     InputStream javaFile = new FileInputStream(javaFileName)) {
			
			bytesFromReservedWordFileArray = new byte[reservedJavaWordsFile.available()];
			bytesFromJavaFileArray = new byte[javaFile.available()];
			
			reservedJavaWordsFile.read(bytesFromReservedWordFileArray, 0, bytesFromReservedWordFileArray.length);
			javaFile.read(bytesFromJavaFileArray, 0, bytesFromJavaFileArray.length);

// retrieve arrays of bytes from files - with java keywords and with .java program file byte[]->String->String[] via split()
			reservedWordsInString = new String(bytesFromReservedWordFileArray, StandardCharsets.UTF_8);
			javaReservedWordsInFileArray = reservedWordsInString.split("\\n");

// retrieve array of bytes byte[]->String->String[] via split() separating all words in file to alone String from *.java file
			javaFileInString = new String(bytesFromJavaFileArray, StandardCharsets.UTF_8);
			javaFileInStringArray = javaFileInString.split("\\s+|\\n+|\\t+|^[a-zA-Z]|^[0-9]");
			
			for (int javaReservedWordsArrayCounter = 0;
			     javaReservedWordsArrayCounter < javaReservedWordsInFileArray.length; javaReservedWordsArrayCounter++) {
				int    mapCounter = 0;
				String tmpStr     = javaReservedWordsInFileArray[javaReservedWordsArrayCounter];
				for (int javaFileCounter = 0; javaFileCounter < javaFileInStringArray.length; javaFileCounter++) {
					if (tmpStr.equals(javaFileInStringArray[javaFileCounter])) {
						resultMap.put(tmpStr, ++mapCounter);
					}
				}
			}
			String[] resultStringAr        = new String[resultMap.size()];
			int      resultStringArCounter = 0;
			for (Map.Entry entry :
					resultMap.entrySet()) {
				resultStringAr[resultStringArCounter] =
						"Ключевое слово Java - " + entry.getKey() + " повторяется в файле " + outputFileName + " " +
						entry.getValue() + " раз;" + "\\n";
			}
			
			StringBuilder resultStringBuilder = new StringBuilder();
			for (resultStringArCounter = 0; resultStringArCounter < resultStringAr.length;
			     resultStringArCounter++) {
				resultStringBuilder.append(resultStringAr[resultStringArCounter]);
			}

// create two temporary arrays for String->chars->bytes	transmogrify from retrieved string with resulting information
			char[] resultCharAr = (new String(resultStringBuilder.toString())).toCharArray();
			byte[] resultByteAr = new byte[resultCharAr.length];

// fulfilling bytes array by straight type casting from char into byte for writing byte[] into result file
			for (int resultByteCounter = 0; resultByteCounter < resultByteAr.length; resultByteCounter++) {
				resultByteAr[resultByteCounter] = (byte) resultCharAr[resultByteCounter];
			}
// writing whole byte[] into result file
			infoStoreFileAboutJavaFile.write(resultByteAr, 0, resultByteAr.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
}