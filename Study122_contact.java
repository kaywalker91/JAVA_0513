package study0513;

import java.io.*;
import java.util.*;

import study0512.Study118_file_class;

public class Study122_contact
{
	public static void main(String[] args) throws ClassNotFoundException,IOException
	{
		Scanner sc = new Scanner(System.in);
		
		File dir = new File("c:\\java\\work");
		File file = new File(dir, "cutomers.dat");
		
		Vector vc = new Vector();
		int select;
		int cusN=1;
		
		if (file.exists()) 
		{
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			vc = (Vector) 
			ois.readObject();
			ois.close();
		}
		while (true) 
		{
			System.out.println("1.고객등록");
			System.out.println("2.고객목록");
			System.out.println("3.종료");
			System.out.print("선택:"); 
			select = sc.nextInt();
			
			System.out.println();
			
			if (select == 1) 
			{
				Study123_contactdata newcus = new Study123_contactdata();
				vc.add(newcus);
				System.out.println(cusN+"번째 고객을 등록하였습니다.");
				cusN += 1;
				System.out.println();
			}
			else if (select == 2) 
			{
				for (int i = 0; i < vc.size(); i++) 
				{
					Study123_contactdata imsi = (Study123_contactdata) vc.elementAt(i);
					imsi.disp();
				}
			}
			else if (select == 3) 
			{
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				
				oos.writeObject(vc);
				oos.close();
				
				System.exit(0);
			} 
			else 
			{
				System.out.println("잘못 입력!!");
			}
		}
	}
}
		


