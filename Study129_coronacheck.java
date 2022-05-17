package study0513;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Study129_coronacheck 
{
	public static void main(String[] args)  
	{
		Coronacheck coronacheck = new Coronacheck();
	}
}
class Coronacheck
{
	Scanner sc = new Scanner(System.in);
	
	int confirmed,critically,death;
	int inconfirmed,incritically,indeath;
	int cnt=0; //친구를 추가할때마다 등록된 인원수 체크.
	int select;
	
	int MAX=100;//총 저장가능한 인원수 변수
	
	String saveall[] = new String[MAX];
	
	Coronacheck() 
	{
		while(true)
		{
			main();
			
			if(select == 1)      {patientinput();}
			else if(select == 2) {patientoutput();}			
			else if(select == 3) {break;}
		}
		System.out.println("프로그램종료..");
	}
	
	void main()
	{
		System.out.println("1.환자수 입력");
		System.out.println("2.현황보기");
		System.out.println("3.종료");
		System.out.print("선택:"); select = sc.nextInt();
	}
	
	void patientinput()
	{
		System.out.println("<코로나 확진자 체크 프로그램>");
		System.out.print("확진자수:"); inconfirmed = sc.nextInt();
		System.out.print("중증환자:"); incritically = sc.nextInt();
		System.out.print("사망자:"); indeath = sc.nextInt();
		
		confirmed += inconfirmed;
		critically += incritically;
		death += indeath;
		
		Integer.toString(confirmed);
		Integer.toString(critically);
		Integer.toString(death);
		
		saveall[cnt] = "현재누적 통계 "+"\r\n"+ "확진자수:"+ confirmed+"명"+"\r\n"+"중증환자:" + critically+"명"+"\r\n"+"사망자:" + death+"명";
		
		patientSave(saveall[cnt]);//한줄씩 저장하기
		
		cnt++; //한명 입력끝났으므로 다음사람입력하기위한 증가.	
	}
	
	void patientoutput()
	{
        try{
            //파일 객체 생성
            File file = new File("C:\\aaa\\work\\cdata.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            
            String line = "";
            int i = 0;
            
            while((line = bufReader.readLine()) != null)
            {
                System.out.println(line);
    
                saveall[cnt] = line;//한줄씩읽어올때 결과값에 차례대로 저장하기
                
                i++;   
            }
            
            cnt=i;
            
            bufReader.close();
            
        }
        catch (FileNotFoundException e) 
        {}
        catch(IOException e)
        {}
	}
	
	//한줄씩저장하기.
		void patientSave(String cdata)
		{
			 try
			 {
				 //파일 객체 생성
				 File file = new File("C:\\aaa\\work\\cdata.txt");
		            
		         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		            
		          if(file.isFile() && file.canWrite())
		          {            
		        	  bufferedWriter.write(cdata);
		              bufferedWriter.newLine();
		              bufferedWriter.close();
		          }
		     }
			 catch (IOException e)
			 {
				 System.out.println(e);
		     }
		}		
}
