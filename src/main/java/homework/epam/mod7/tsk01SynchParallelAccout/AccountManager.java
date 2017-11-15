package homework.epam.mod7.tsk01SynchParallelAccout;

import java.nio.file.Path;
import java.util.ResourceBundle;

public interface AccountManager {
	
	boolean handleAccount(Integer integer);
	
	Integer lookForAccountNameBalance(ResourceBundle resourceBundle);
	
	boolean rollBackChanges();
}
