package homework.epam.mod7.tsk01SynchParallelAccout;

import java.util.ResourceBundle;

public class AccountAdder implements AccountManager {
	static String accountName;
	static ResourceBundle resourceBundle                  = null;
	static Integer        startStateAccountBeforetransact = 0;
	
	
	public AccountAdder(String accountName) {
		this.accountName = accountName;
		ResourceBundle resourceBundle = ResourceBundle.getBundle("account.properties");
	}
	
	@Override public synchronized boolean handleAccount(Integer integer) {
		boolean result = false;
		
		return result;
	}
	
	@Override public Integer lookForAccountNameBalance(ResourceBundle resourceBundle) {
		return startStateAccountBeforetransact = Integer.parseInt(resourceBundle.getString(accountName));
	}
	
	
	@Override public synchronized boolean rollBackChanges() {
		boolean result = false;
		return result;
	}
}
