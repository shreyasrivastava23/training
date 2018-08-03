import lti.org.Executive;

public class TestEmployee {

	public static void main(String[] args) {

		Manager mgr = new Manager("lilli", 7000, 2000);
		showSalary(mgr);

		Executive exe = new Executive("rose", 7000, 3000);

		//showSalary(exe);

	}

	private static void showSalary(Employee emp) {
     if(emp instanceof Manager)
    	 System.out.println("manager salary: " + emp.getSalary());
     else 
    	 System.out.println("executive salary" + emp.getSalary());
		 // TODO Auto-generated method stub

	}

	// private static void showSalary(Executive exe) {
	// // TODO Auto-generated method stub
	// System.out.println("executive salary" + exe.getSalary());
	// }
	//
	// private static void showSalary(Manager mgr) {
	// // TODO Auto-generated method stub
	// System.out.println("executive salary" + mgr.getSalary());
	// }

}
