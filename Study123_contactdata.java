package study0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Study123_contactdata implements Serializable 
{
	private String name;
	private String jumin;
	private String tel;
	private String addr;
	
	private static transient BufferedReader in;
	
	static 
	{
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Study123_contactdata() throws IOException 
	{		
		System.out.print("name = ");
		name = in.readLine();
		System.out.print("jumin = ");
		jumin = in.readLine();
		System.out.print("tel = ");
		tel = in.readLine();
		System.out.print("addr = ");
		addr = in.readLine();
	}
	public void disp() 
	{
		System.out.print(name + "\t");
		System.out.print(jumin + "\t");
		System.out.print(tel + "\t");
		System.out.println(addr);
		System.out.println();
	}
}


