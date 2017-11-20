package homework.epam.mod7.tsk02SynchronizedPropertyRaeder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class se07tsk02UniversalPropertyReader {
	private static          String incomingPropertyFileName = null;
	private static volatile Path   incomingPropertyFile     = null;
	
	private static FileReader          fileReader  = null;
	private static Map<String, String> propertyMap = new ConcurrentHashMap<>();
	
	/**
	 * @param incomingPropertyFile
	 */
	public synchronized static void setIncomingPropertyFile(Path incomingPropertyFile) {
		se07tsk02UniversalPropertyReader.incomingPropertyFile = incomingPropertyFile;
	}
	
	/**
	 * Special method correct handling MissingResourceException and NoSuchFileException
	 *
	 * @return Map fulfilled by keys and according values of properties
	 */
	public synchronized static Map<String, String> returnMapMethodHandler() {
		Map<String, String> handledMap          = new HashMap<>();
		String              correctresourceName = "Not inputed name of property file !";
		System.out.println("input correct resource file name please:\n");
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			correctresourceName = bufferedReader.readLine();
			setIncomingPropertyFileName(correctresourceName);
			handledMap = returnMePropertyMap(incomingPropertyFileName);
			
		} catch (MissingResourceException mre) {
			System.out.println("Your resourse have no such key.");
			mre.printStackTrace();
		} catch (NoSuchFileException nsfe) {
			System.out.println("Try to type correct file name. You typed: " + correctresourceName);
			returnMapMethodHandler();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return handledMap;
	}
	
	/**
	 * Main working method takes
	 *
	 * @param incomingPropertyFileName from returnMapMethodHandler's console input with help of BufferedReader
	 * @return fulfilled HashMap with keys & properties if were no exceptions
	 * @throws NoSuchFileException      &
	 * @throws MissingResourceException witch are handled in special returnMapMethodHandler method
	 */
	private synchronized static Map<String, String> returnMePropertyMap(String incomingPropertyFileName)
			throws NoSuchFileException,
			       MissingResourceException {
		setIncomingPropertyFileName(incomingPropertyFileName);
		setIncomingPropertyFile(Paths.get(getIncomingPropertyFileName()));
		ResourceBundle      resourceBundle = ResourceBundle.getBundle(getIncomingPropertyFileName());
		Enumeration<String> enumeration    = resourceBundle.getKeys();
		
		while (enumeration.hasMoreElements()) {
			String nextEl = enumeration.nextElement();
			propertyMap.put(nextEl, resourceBundle.getString(nextEl));
		}
		
		return propertyMap;
	}
	
	/**
	 * @return
	 */
	public static String getIncomingPropertyFileName() {
		return incomingPropertyFileName;
	}
	
	/**
	 * @param incomingPropertyFileName
	 */
	public static void setIncomingPropertyFileName(String incomingPropertyFileName) {
		se07tsk02UniversalPropertyReader.incomingPropertyFileName = incomingPropertyFileName;
	}
	
}


