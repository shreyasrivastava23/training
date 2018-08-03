public class Current extends Account {
	private double overdraft = 10000;

	public Current() {
		super();

	}

	public Current(String holder) {
		super(holder, INIT_CUR_BAL);
		this.overdraft = OVERDRAFT_AMT;
	}

	@Override
	public void summary() {

		super.summary();
		System.out.println("overdraft:" + overdraft);
	}

	public void withdraw(double amount) {

		if (amount <= (balance + overdraft)) {
			balance = balance - amount;
			if (balance < MIN_CUR_BAL) {
				overdraft += balance;
				balance = MIN_CUR_BAL;
			}
		} else
			System.out.println("insufficient balance");
	}

	public void deposit(double amount) {
		// if(overdraft!=10000 && amount<(1000-overdraft))
		// {
		// balance=0;
		// overdraft=overdraft+amount;
		// }
		// else {
		// balance=amount-(10000-overdraft);
		// }
		overdraft += amount;
		if (overdraft > OVERDRAFT_AMT) {
			balance += overdraft - OVERDRAFT_AMT;
			overdraft = OVERDRAFT_AMT;
		}
	}

}
