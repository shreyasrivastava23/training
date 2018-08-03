import lti.bank.AccountFactory;
import lti.bank.BalanceException;
import lti.bank.Bank;

public class TestAccount {

	public static void main(String[] args) {
		

//		Current ca=new Current("Polo");
//		ca.summary();
//		ca.withdraw(8000);
//		ca.summary();
		
	//	Account sav=new Savings("Polo");
		
	//	Bank sav=new Savings("Polo");
		
		Bank sav=AccountFactory.openAccount("savings","Polo");
		sav.summary();
		sav.deposit(2000);
		sav.deposit(4000);
		try {
			sav.withdraw(3000);
		} catch (BalanceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();//for developers to trouble shoot
			System.out.println(e1);//for logging
		}
		try {
			sav.withdraw(7000);
		} catch (BalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e);//for logging
			System.out.println(e.getMessage());
		}
		
//		sav.statement();
	Bank cur=AccountFactory.openAccount("current","Polo");
		cur.summary();
		cur.deposit(2000);
		cur.deposit(4000);
		try {
			cur.withdraw(3000);
		} catch (BalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cur.withdraw(7000);
		
			
		} catch (BalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		
		{
			System.out.println("bjb");
		}
	
		cur.statement();		
	}

}
