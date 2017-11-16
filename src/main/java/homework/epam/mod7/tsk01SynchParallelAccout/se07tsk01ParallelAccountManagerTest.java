package homework.epam.mod7.tsk01SynchParallelAccout;

public class se07tsk01ParallelAccountManagerTest {
	public static void main(String[] args) {
		MonyTransfering fromUser = new MonyTransfering("user1");
		MonyTransfering toUser   = new MonyTransfering("user2");
		Integer         money    = 50;
		if (transferFromToHowMuch(fromUser, toUser, money)) {
			System.out.println("Transfer from " + fromUser.getname() + " to " + toUser.getname() + " succes");
		} else {
			System.out.println("Error transfer from " + fromUser.getname() + " to " + toUser.getname());
			
		}
	}
	
	public static synchronized boolean transferFromToHowMuch(MonyTransfering monyTransfering1,
	                                                         MonyTransfering monyTransfering2,
	                                                         Integer sum) {
		boolean result = false;
		if (monyTransfering1.halfTransmitToAccount(monyTransfering1.getname(), ((-1) * sum))) {
			
			if (monyTransfering1.halfTransmitToAccount(monyTransfering1.getname(), sum)) {
				result = true;
			}
		}
		
		return result;
	}
}
