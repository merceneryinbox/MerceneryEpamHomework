package homework.epam.mod3.tsk01CrazyLog;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 */
public class CrazyLogger {
	static private volatile StringBuilder accumExceptionSTraceBuild = null;
	static private volatile StringBuilder accumExceptionInfo        = null;
	static private volatile boolean       consoleLogOn              = false;
	static private volatile boolean       fileLogOn                 = false;
	static private volatile String[] poolOfTraceInStringsAr;
	static private volatile String crazyLogFileName = "craxyLogFile.log";
	static private Exception incomeException;
	static private LocalDate localDate;
	static private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-mm-YYYY : hh-mm - ");
	
	/**
	 *
	 */
	public CrazyLogger() {
		localDate = LocalDate.now();
		localDate.format(dateTimeFormatter);
	}
	
	/**
	 * @return
	 */
	public static boolean isConsoleLogOn() {
		return consoleLogOn;
	}
	
	/**
	 * @param consoleLogOn
	 */
	public static void setConsoleLogOn(boolean consoleLogOn) {
		CrazyLogger.consoleLogOn = consoleLogOn;
	}
	
	/**
	 * @return
	 */
	public boolean showMeLogBuilderInConsole() {
		boolean result = false;
		if (consoleLogOn) {
			System.out.println(localDate.toString() + accumExceptionSTraceBuild);
		}
		System.out.println("Console logging - OFF");
		return result;
	}
	
	/**
	 * @param incomeException
	 */
	public void takeException(Exception incomeException) {
		this.incomeException = incomeException;
		StackTraceElement[] poolOfST = incomeException.getStackTrace();
		poolOfTraceInStringsAr = new String[poolOfST.length];
		
		for (int i = 0; i < poolOfTraceInStringsAr.length; i++) {
			poolOfTraceInStringsAr[i] = localDate.toString() +
			                            poolOfST[i].getLineNumber() + " - " + poolOfST[i].getClassName()
			                            + " in method - "
			                            + poolOfST[i].getMethodName() + " " + poolOfST[i].getFileName();
		}
		
		for (int i = 0; i < poolOfTraceInStringsAr.length; i++) {
			accumExceptionSTraceBuild.append(poolOfTraceInStringsAr[i]);
		}
	}
	
	/**
	 * @param customLogFName
	 * @return
	 */
	public boolean saveToCustomLogToFile(String customLogFName) {
		boolean result = false;
		if (isFileLogOn()) {
			try (FileOutputStream fileOutputStream = new FileOutputStream(Paths.get(customLogFName)
					                                                              .toFile())) {
				char[] chars = poolOfTraceInStringsAr.toString()
						.toCharArray();
				byte[] bytes = new byte[chars.length];
				
				for (int i = 0; i < chars.length; i++) {
					bytes[i] = (byte) chars[i];
				}
				fileOutputStream.write(bytes);
				result = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * @return
	 */
	public static boolean isFileLogOn() {
		return fileLogOn;
	}
	
	/**
	 * @param fileLogOn
	 */
	public static void setFileLogOn(boolean fileLogOn) {
		CrazyLogger.fileLogOn = fileLogOn;
	}
	
	/**
	 * @return
	 */
	public boolean saveSilentLogToFile() {
		boolean result = false;
		
		if (isFileLogOn()) {
			try (FileOutputStream fileOutputStream = new FileOutputStream(Paths.get(crazyLogFileName)
					                                                              .toFile())) {
				char[] chars = poolOfTraceInStringsAr.toString()
						.toCharArray();
				byte[] bytes = new byte[chars.length];
				
				for (int i = 0; i < chars.length; i++) {
					bytes[i] = (byte) chars[i];
				}
				fileOutputStream.write(bytes);
				result = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * @param findInLog
	 * @return
	 */
	public String giveMeInfoAbout(String findInLog) {
		String resultString = "Nothing is found";
		for (int i = 0; i < poolOfTraceInStringsAr.length; i++) {
			if (poolOfTraceInStringsAr[i].contains(findInLog)) {
				accumExceptionInfo.append(poolOfTraceInStringsAr[i]);
			}
			resultString = accumExceptionInfo.toString();
		}
		return resultString;
	}
}
