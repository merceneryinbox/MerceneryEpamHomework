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

public class AmountAdder implements AccountManager {
	private static String accountName;
	private static File   accountFileXML;
	private static Integer startStateAccountBeforetransact       = 0;
	private static Integer startStateAccountBeforetransactBackUp = 0;
	
	private static DocumentBuilderFactory documentBuilderFactory;
	private static DocumentBuilder        documentBuilder;
	private static Document               document;
	
	private static Node coreNodeAccounts;
	private static Node userNode;
	private static Node balance1Node;
	private static Node balance2Node;
	
	private static Element coreElement;
	private static Element user1Element;
	private static Element user2Element;
	private static Element balance1Element;
	private static Element balance2Element;
	
	private static String   accountElementName;
	private static NodeList nodeList;
	
	public AmountAdder(String accountName) {
		this.accountName = accountName;
		accountFileXML = new File("./resource/account.xml");
		
		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(accountFileXML);
			document.getDocumentElement()
					.normalize();
			
			// получаю Главный (родительский) нод
			coreNodeAccounts = document.getFirstChild();
			
			// TODO: 16.11.2017 сделал элементы и ноды, добавить методы получения вэлью и изменения с проверкой правильности
			
			NodeList nodeList = document.getElementsByTagName(document.getDocumentElement()
					                                                  .getChildNodes()
					                                                  .item(1)
					                                                  .getNodeName());
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node    node       = nodeList.item(i);
				Element tmpElement = (Element) node;
				
				accountElementName = tmpElement.getElementsByTagName("name")
						.item(0)
						.getChildNodes()
						.item(0)
						.getNodeValue();
				
				if (accountElementName.equals(accountName)) {
					user1Element = tmpElement;
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
				       user1Element.getElementsByTagName("balance")
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
