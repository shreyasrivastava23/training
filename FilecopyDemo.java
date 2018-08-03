import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FilecopyDemo {
public static void main(String[] args)throws Exception
{
	
	BufferedInputStream istream=new BufferedInputStream(new FileInputStream("D:/Demo/vsc.exe"));
	BufferedOutputStream ostream=new BufferedOutputStream(new FileOutputStream("D:/Demo/vsc2.exe"));
	long startTime=System.currentTimeMillis();
	int ch=0;
	while(true)
	{
		ch=istream.read();
		if (ch==-1)
			break;
		ostream.write(ch);
	}
	System.out.println("Time :"+ (System.currentTimeMillis()-startTime));
	ostream.close();
	istream.close();
}
}
