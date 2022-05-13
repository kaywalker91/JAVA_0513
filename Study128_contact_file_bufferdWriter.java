package study0513;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.Vector;

public class Study128_contact_file_bufferdWriter 
{
	public static void main(String[] args)  
	{
		Friendsss f = new Friendsss();
	}
}
class Friendsss
{
	Scanner sc = new Scanner(System.in);
	int MAX=100;//총 저장가능한 인원수 변수
	
	//이름 나이 사는곳 연락처 배열...
	String name[]= new String[MAX];
	String age[]= new String[MAX];
	String addr[]= new String[MAX];
	String hp[]= new String[MAX];
	String saveData[] = new String[MAX];
	int cnt=0; //친구를 추가할때마다 등록된 인원수 체크.
	int select;
	
	
	File dir = new File("c:\\aaa\\work");
	File file = new File(dir, "test.dat");		
	
	Friendsss() 
	{

		while(true)
		{
			menu1();
			if(select == 1)      {input1();}
			else if(select == 2) {output1();}			
			else if(select == 3) {fileSaveAll1();}
			else if(select == 4) {break;}
		}
		System.out.println("프로그램종료..");
		
	}
	
	void output1()
	{
        try{
            //파일 객체 생성
            File file = new File("C:\\aaa\\work\\data.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            int i = 0;
            while((line = bufReader.readLine()) != null){
                System.out.println(line);
                
                saveData[i] = line;//한줄씩읽어올때 결과값에 차례대로 저장하기
                i++;
                
            }   
            cnt=i;
            bufReader.close();
            
        }catch (FileNotFoundException e) {           
        }catch(IOException e){           
        }
		

	}
	void input1()
	{
		System.out.print("이름:"); name[cnt] = sc.next();
		System.out.print("나이:"); age[cnt] = sc.next();
		System.out.print("사는곳:"); addr[cnt] = sc.next();
		System.out.print("연락처:"); hp[cnt] = sc.next();
				
		System.out.println("친구 한명 등록 완료!");
		
		saveData[cnt] = name[cnt]+"/"+age[cnt]+"/"+addr[cnt]+"/"+hp[cnt];
		
		System.out.println("saveData["+cnt+"]:"+saveData[cnt]);
		
		fileSaveOne1(saveData[cnt]);//한줄씩 저장하기
		
		cnt++; //한명 입력끝났으므로 다음사람입력하기위한 증가.	
	}
	void menu1()
	{
		System.out.println("1.친구등록");
		System.out.println("2.친구보기");
		System.out.println("3.저장하기(일괄)");
		System.out.println("4.종료");
		System.out.print("선택:"); select = sc.nextInt();
	}
	//한줄씩저장하기.
		void fileSaveOne1(String data)
		{
			 try{
		            //파일 객체 생성
		            File file = new File("C:\\aaa\\work\\data.txt");
		            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
		            
		            if(file.isFile() && file.canWrite()){            

		                bufferedWriter.write(data);
		                bufferedWriter.newLine();
		                bufferedWriter.close();
		            }
		        }catch (IOException e) {
		            System.out.println(e);
		        }
		}
		
	//한번에저장하기
	void fileSaveAll1()
	{
		 try{
	            //파일 객체 생성
	            File file = new File("C:\\aaa\\work\\data.txt");
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
	            
	            if(file.isFile() && file.canWrite()){
                
	                for(int i=0; i<cnt; i++ )
	                {
	                	bufferedWriter.write(saveData[i]);
	                	bufferedWriter.newLine();
	                }                
	                
	                bufferedWriter.close();
	            }
	        }catch (IOException e) {
	            System.out.println(e);
	        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
