

public abstract class Account implements Bank {
	private int acntno;
	private String holder;
	protected double balance;

	private static int autogen = INIT_ACNT_NO;

	protected Transaction[]txns;
	protected int idx;
	public Account() {

	}

	public Account(String holder, double balance) {
		super();
		this.acntno = autogen++;
		this.holder = holder;
		this.balance = balance;
		
		txns= new Transaction[10];
		
		txns[idx++]=new Transaction("OB",balance,balance);
	}

	public void summary() {
		System.out.println("A/C No.:" + acntno);
		System.out.println("Holder:" + holder);
		System.out.println("Balance:" + balance);
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
		txns[idx++]=new Transaction("CR",amount,balance);
	}

	//public abstract void withdraw(double amount) ;
//		if (amount <= balance) 
//			balance -= amount;
//		 else 
//			System.out.println("insufficient funds");
	
public void statement()
{
	System.out.println("statement of A/C:"+ acntno);
	for(int i=0;i<idx;i++)
		System.out.println(txns[i]);
}
}
