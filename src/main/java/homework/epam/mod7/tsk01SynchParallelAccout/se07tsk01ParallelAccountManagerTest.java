package homework.epam.mod7.tsk01SynchParallelAccout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class se07tsk01ParallelAccountManagerTest {
	public static void main(String[] args) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document1 =
					documentBuilder.parse("./src/account.xml");
			final Element documentElement = document1.getDocumentElement();
			final String  user1           = documentElement.getAttribute("user1");
			System.out.println("\n" + user1 + "\n");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
