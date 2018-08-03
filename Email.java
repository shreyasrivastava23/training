

public class Email {

	static String email = "imzubair@gmail.com";
	static int i, l1, l2, l3;
	static char ch;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = email.indexOf('@');
		int b = email.indexOf('.');
		System.out.println(a);
		System.out.println(b);
		for (i = 0; i <= a; i++)
		{
          ch=email.charAt(i);
        }
        l1=email.indexOf(ch)+1;
        if(l1<4)
        {
        	System.out.println("Invalid");
        }
        else
        {
        	ch=' ';
        	for(i=a+1;i<=b;i++)
        	{
        		ch=email.charAt(i);
        	}
        	 l2=email.indexOf(ch)+1;
             if(l2<3)
             {
             	System.out.println("Invalid");
             }
             else
             {
            		ch=' ';
            	 for(i=b+1;i<email.length();i++)
            	 {
            		 ch=email.charAt(i);
            	 }
            	 l3=email.indexOf(ch)+1;
            	 if(l3!=2)
                 {
                 	System.out.println("Invalid");
                 }
                 else
                 {
                	 System.out.println("VALID");
                 }
             }
        }
}
}
