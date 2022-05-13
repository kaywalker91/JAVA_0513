package study0513;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Study125_FileReader {

	public static void main(String[] args) {
		try{
            //파일 객체 생성
            File file = new File("C:\\java\\work\\Sample.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String line = "";
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            br.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
 }
	
}
