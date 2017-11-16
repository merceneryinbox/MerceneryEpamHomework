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

public class AccountAdder implements AccountManager {
	private static String accountName;
	private static File   accountFileXML;
	private static Integer startStateAccountBeforetransact       = 0;
	private static Integer startStateAccountBeforetransactBackUp = 0;
	
	private static DocumentBuilderFactory documentBuilderFactory;
	private static DocumentBuilder        documentBuilder;
	private static Document               document;
	
	private static Node coreNodeAccounts;
	private static Node userNode;
	private static Node balanceNode;
	
	private static Element coreElement;
	private static Element accountUserElement;
	private static Element userBalanceElement;
	
	private static String   accountElementName;
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
			
			coreNodeAccounts = document.getFirstChild();
			coreElement = (Element) coreNodeAccounts;
			userNode = document.getElementsByTagName("user")
					.item(0);
			balanceNode = document
			coreElement = (Element) coreNodeAccounts;
			
			NodeList nodeList = document.getElementsByTagName(document.getDocumentElement()
					                                                  .getChildNodes()
					                                                  .item(1)
					                                                  .getNodeName());
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node    node       = nodeList.item(i);
				Element tmpElement = (Element) node;
				accountElementName = accountUserElement.getElementsByTagName("user")
						.item(0)
						.getChildNodes()
						.item(0)
						.getNodeValue();
				
				if (accountElementName.equals(accountName)) {
					accountUserElement = tmpElement;
				}
			}
			
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
		
		return result;
	}
	
	@Override public Integer lookForAccountNameBalance(String accountBalanceName) {
		return startStateAccountBeforetransact =
		       startStateAccountBeforetransactBackUp = Integer.parseInt(
				       accountUserElement.getElementsByTagName("balance")
						       .item(0)
						       .getNodeValue());
	}
	
	@Override public Integer showMeBalance() {
		return startStateAccountBeforetransact;
	}
	
	@Override public synchronized boolean rollBackChanges() {
		boolean result = false;
		return result;
	}
	
	@Override public void saveTransaction() {
	
	}
}
