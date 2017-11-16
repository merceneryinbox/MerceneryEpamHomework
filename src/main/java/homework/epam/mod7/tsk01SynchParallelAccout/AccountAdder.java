package homework.epam.mod7.tsk01SynchParallelAccout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class AccountAdder implements AccountManager {
	private static String accountName;
	private static File   accountFileXML;
	private static Integer startStateAccountBeforetransact       = 0;
	private static Integer startStateAccountBeforetransactBackUp = 0;
	
	private static DocumentBuilderFactory documentBuilderFactory;
	private static DocumentBuilder        documentBuilder;
	private static Document               document;
	
	private static Node     coreNode;
	private static Node     balanceNode;
	private static Element  coreElement;
	private static Element  balanceElement;
	private static NodeList nodeList;
	
	public AccountAdder(String accountName) {
		this.accountName = accountName;
		accountFileXML = new File("./resource/account.xml");
		
		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(accountFileXML);
			document.getDocumentElement()
					.normalize();
			
			coreNode = document.getDocumentElement();
			coreElement = (Element) coreNode;
			
			NodeList nodeList = document.getElementsByTagName(document.getDocumentElement()
					                                                  .getChildNodes()
					                                                  .item(1)
					                                                  .getNodeName());
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override public void setAccount(Integer integer) {
		this.startStateAccountBeforetransact = integer;
	}
	
	@Override public synchronized boolean handleAccount(Integer integer) {
		boolean result = false;
		for (int tmp = 0; tmp < nodeList.getLength(); tmp++) {
			Node node = nodeList.item(tmp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				
				System.out.println("Author: " + element.getElementsByTagName("author")
						.item(0)
						.getChildNodes()
						.item(0)
						.getNodeValue());
				
				System.out.println("Language: " + element.getElementsByTagName("language")
						.item(0)
						.getChildNodes()
						.item(0)
						.getNodeValue());
			}
		}
		return result;
	}
	
	@Override public Integer lookForAccountNameBalance(ResourceBundle resourceBundle) {
		return startStateAccountBeforetransact =
		       startStateAccountBeforetransactBackUp = Integer.parseInt(resourceBundle.getString(accountName));
	}
	
	@Override public Integer showMeBalance() {
		
		return null;
	}
	
	@Override public synchronized boolean rollBackChanges() {
		boolean result = false;
		return result;
	}
	
	@Override public void writeAccount() {
	
	}
}
