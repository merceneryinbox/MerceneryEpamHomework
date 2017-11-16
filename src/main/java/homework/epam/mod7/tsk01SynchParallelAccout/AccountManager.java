package homework.epam.mod7.tsk01SynchParallelAccout;


public interface AccountManager {
	
	void setAmount(Integer integer);
	
	boolean halfTransmitToAccount(String who, Integer howMuch);
	
	Integer lookForAccountNameBalance(String accountNameBalance);
	
	Integer showMeBalance();
	
	boolean rollBackChanges();
	
	void saveTransaction();
}
