package homework.epam.mod7.tsk01SynchParallelAccout;

import java.util.ResourceBundle;

public interface AccountManager {
	
	void setAccount(Integer integer);
	
	boolean handleAccount(Integer integer);
	
	Integer lookForAccountNameBalance(String accountNameBalance);
	
	Integer showMeBalance();
	
	boolean rollBackChanges();
	
	void saveTransaction();
}
