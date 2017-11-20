package homework.epam.mod7.tsk01SynchParallelAccout;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 *
 */
public class MonyTransfering implements AccountManager {
	private static String user    = "user";
	private static String name    = "name";
	private static String balance = "balance";
	private static File accountFileXML;
	private static Integer startStateAccountBeforetransact       = 0;
	private static Integer startStateAccountBeforetransactBackUp = 0;
	private static DocumentBuilderFactory documentBuilderFactory;
	private static DocumentBuilder        documentBuilder;
	private static Document               document;
	private static Node                   coreNodeAccounts;
	private static Node                   userNode;
	private static Node                   balance1Node;
	private static Node                   balance2Node;
	private static Element                coreElement;
	private static Element                userElement;
	private static Element                user2Element;
	private static Element                balance1Element;
	private static Element                balance2Element;
	private static String                 accountElementName;
	private static NodeList               usersnodeList;
	
	/**
	 * @param name
	 */
	public MonyTransfering(String name) {
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
			usersnodeList = document.getElementsByTagName("user");
			// проверяем наличие такого пользователя , передаю указатель (userElement) в методе для взаимодействия со счётом
			// устанавливаем переменную для работы со счётом до завершения транзакции
			if (testUserExists(name, usersnodeList)) {
				startStateAccountBeforetransact = Integer.parseInt(userElement.getElementsByTagName("balance")
						                                                   .item(0)
						                                                   .getChildNodes()
						                                                   .item(0)
						                                                   .getNodeValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param name
	 * @param usersnodeList
	 * @return
	 */
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
	
	/**
	 * @return
	 */
	public String getname() {
		return name;
	}
	
	/**
	 * @param integer
	 */
	@Override public synchronized void setAmount(Integer integer) {
		this.startStateAccountBeforetransact = integer;
	}
	
	/**
	 * @param who
	 * @param howMuch
	 * @return
	 */
	@Override public synchronized boolean halfTransmitToAccount(String who, Integer howMuch) {
		boolean result = false;
		
		if (testUserExists(who, getUsersnodeList())) {
			for (int usersListIndex = 0; usersListIndex < usersnodeList.getLength(); usersListIndex++) {
				Node    node    = usersnodeList.item(usersListIndex);
				Element element = (Element) node;
				String testUserName = element.getElementsByTagName("name")
						.item(0)
						.getChildNodes()
						.item(0)
						.getNodeValue();
				if (testUserName.equals(name)) {
					
					Integer balanceNow = Integer.parseInt(element.getElementsByTagName("balance")
							                                      .item(0)
							                                      .getChildNodes()
							                                      .item(0)
							                                      .getNodeValue());
					if ((balanceNow + howMuch) > 0) {
						result = true;
						//Модифицируем атрибут(баланс) элемента
						NamedNodeMap namedNodeMap = node.getAttributes();
						Node         nodeAttr     = namedNodeMap.getNamedItem("balance");
						nodeAttr.setTextContent(balanceNow + howMuch + "");
					}
				}
			}
		}
		
		
		return result;
	}
	
	public static NodeList getUsersnodeList() {
		return usersnodeList;
	}
	
	/**
	 * @param accountBalanceName
	 * @return
	 */
	@Override public synchronized Integer lookForAccountNameBalance(String accountBalanceName) {
		return startStateAccountBeforetransact =
		       startStateAccountBeforetransactBackUp = Integer.parseInt(
				       userElement.getElementsByTagName("balance")
						       .item(0)
						       .getNodeValue());
	}
	
	/**
	 * @return
	 */
	@Override public synchronized Integer showMeBalance() {
		return startStateAccountBeforetransact;
	}
	
	/**
	 * @return
	 */
	@Override public synchronized boolean rollBackChanges() {
		boolean result = false;
		return result;
	}
	
	/**
	 *
	 */
	@Override public synchronized void saveTransaction() {
	
	}
}
