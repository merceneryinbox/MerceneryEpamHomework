package homework.epam.mod7.tsk01SynchParallelAccout;

/**
 *
 */
public interface AccountManager {
	/**
	 * @param integer
	 */
	void setAmount(Integer integer);
	
	/**
	 * @param who
	 * @param howMuch
	 * @return
	 */
	boolean halfTransmitToAccount(String who, Integer howMuch);
	
	/**
	 * @param accountNameBalance
	 * @return
	 */
	Integer lookForAccountNameBalance(String accountNameBalance);
	
	/**
	 * @return
	 */
	Integer showMeBalance();
	
	/**
	 * @return
	 */
	boolean rollBackChanges();
	
	/**
	 *
	 */
	void saveTransaction();
}
