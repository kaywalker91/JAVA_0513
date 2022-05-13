package study0513;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Study124_FileReader 
{

	public static void main(String[] args) 
	{
		try
		{
            //파일 객체 생성
            File file = new File("C:\\java\\work\\Sample.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            
            int singleCh = 0;
            
            while((singleCh = filereader.read()) != -1){
                System.out.print((char)singleCh);
                if((char)singleCh == '\r')
                    System.out.print("오");
                if((char)singleCh == '\n')
                    System.out.print("아");
            }
            
            filereader.close();
            
        }
		catch (FileNotFoundException e) 
		{
            // TODO: handle exception
        }catch(IOException e)
		{
            System.out.println(e);
        }
	  }
}




       



