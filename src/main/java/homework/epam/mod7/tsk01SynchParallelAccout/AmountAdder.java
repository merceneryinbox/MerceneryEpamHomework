package homework.epam.mod7.tsk01SynchParallelAccout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class AmountAdder implements AccountManager {
	private static String user    = "user";
	private static String name    = "name";
	private static String balance = "balance";
	private static File accountFileXML;
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
	private static Element userElement;
	private static Element user2Element;
	private static Element balance1Element;
	private static Element balance2Element;
	
	private static String   accountElementName;
	private static NodeList nodeList;
	
	public AmountAdder(String name) {
		this.name = name;
		accountFileXML = new File("./src/resource/account.xml");
		
		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(accountFileXML);
			document.getDocumentElement()
					.normalize();
			
			// получаю Главный (родительский) нод
			coreNodeAccounts = document.getFirstChild();
			//получаю список пользователей
			NodeList usersnodeList = document.getElementsByTagName("user");
			// проверяем наличие такого пользователя
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	private boolean testUserExists(String name, NodeList usersnodeList) {
		boolean result = false;
		for (int usersListIndex = 0; usersListIndex < usersnodeList.getLength(); usersListIndex++) {
			Node    node    = usersnodeList.item(usersListIndex);
			Element element = (Element) node;
			String testUserName = element.getElementsByTagName("name")
					.item(0)
					.getChildNodes()
					.item(0)
					.getNodeValue();
			if (testUserName.equals(name)) {
				result = true;
				userElement = element;
			}
		}
		return result;
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
				       userElement.getElementsByTagName("balance")
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
