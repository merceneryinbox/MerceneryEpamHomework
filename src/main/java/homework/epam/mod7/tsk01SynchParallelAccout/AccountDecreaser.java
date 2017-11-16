package homework.epam.mod7.tsk01SynchParallelAccout;

import java.nio.file.Path;
import java.util.ResourceBundle;

public class AccountDecreaser implements AccountManager {
	private volatile Path path;
	
	public AccountDecreaser(Path path) {
		this.path = path;
	}
	
	@Override public void setAccount(Integer integer) {
	
	}
	
	@Override public synchronized boolean handleAccount(Integer integer) {
		boolean result = false;
		return result ;
	}
	
	@Override public Integer lookForAccountNameBalance(ResourceBundle resourceBundle) {
		return null;
	}
	
	@Override public synchronized boolean rollBackChanges() {
		boolean result = false;
		return result ;
	}
	
	@Override public void writeAccount() {
	
	}
}
