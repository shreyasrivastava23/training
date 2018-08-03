

public class Person implements Cloneable {
private String name;
private int age;
public Person() {
	this("Anonymous",-1);

}
	
public Person(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}
public void print()
{
	System.out.println("Name :" + name + "\t Age :" +age);
}



public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}



@Override
//public boolean equals(Object obj) {
//	
//	if(obj instanceof Person)
//	{
//		Person p=(Person)obj;
//		if(this.name.equals(p.name) && age==p.age)
//			return true;
//	}
//	return false;
//}
public void finalize()throws Throwable{
	System.out.println("Person is no more!");
}
public static void main(String[]args) throws CloneNotSupportedException {
	Person p1=new Person("Polo",21);

	Person pc=(Person)p1.clone();
	System.out.println(pc);
//	
//	System.out.println(p1.hashCode());
//	System.out.println(pc.hashCode());
//	System.out.println(p1);
//	System.out.println(p1.equals(pc));
//	
	Person p=null;
	for(int c=1;c<=5;c++)
		p=new Person();
	System.gc();
}
}