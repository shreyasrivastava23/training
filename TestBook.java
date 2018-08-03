

import lti.lib.Book;
import lti.lib.Member;

public class TestBook {
	
	private String title="Alchemist";
	private String name="Polo";

	Book b = new Book(title);

	Member m = new Member(name);
	
	public void issueBook()
	{
		System.out.println("Book is issued to:"+name );
	}
	
	public void returnBook() {
		
		System.out.println("Book is returned by:"+name );
	}
	
	public void getMember()
	{
		System.out.println("Book is issued to:"+name );
	}
	
	public void getBook()
	{
		
	}

}
