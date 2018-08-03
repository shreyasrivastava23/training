

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int c=0,c1=0,c2=0,c3=0;
String email="shr@gmail.com";
for(int i=0;i<email.length();i++)
{
	if(email.charAt(i)=='@')
	{
		c=i;
		c2++;
	}
 
	if(email.charAt(i)=='.')
	{
		c1=i;
		c3++;
	
	}
}
String s= email.substring(0,c);
String s1= email.substring(c+1,c1-1);
String s2= email.substring(c1+1);

if((s.length()<4)&&(s1.length()<3)&&(s2.length()<2)&&(c2==1)&&(c3==1))

{
	System.out.println("invalid");
}
else 
	{
	System.out.println("valid");
	}
}
}
	

