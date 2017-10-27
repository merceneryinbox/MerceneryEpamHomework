package homework.epam.mod4.task1byteIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MerceneryJavaReservedWordsFileParsser {
	private static String reservedJavaWordsFileName;
	private static String outputFileName;
	private static String javaFileName;
	private static Map<String, Integer> resultMap = new HashMap<>();
	private static List<String>  javaKeyWordsInFile;
	private static List<Pattern> keyWordsPatterns;
	private static Matcher       matcher;
	byte[] bytesFromReservedWordFile;
	byte[] bytesFromJavaFile;
	private StringBuilder textFromJavaFile = null;
	private String result;
	
	
	public MerceneryJavaReservedWordsFileParsser() {
	}
	
	
	public Map transmitJavaWordCount(String reservedJavaWordsFileName, String outputFileName, String javaFileName) {
		try (OutputStream outStreamReservedWords = Files.newOutputStream(Paths.get(reservedJavaWordsFileName));
		     OutputStream outJavaFile = Files.newOutputStream(Paths.get(javaFileName));
		     InputStream fileToWriteTo = Files.newInputStream(Paths.get(outputFileName))) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
}