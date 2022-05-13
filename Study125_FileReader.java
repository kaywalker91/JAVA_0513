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
            //���� ��ü ����
            File file = new File("C:\\java\\work\\Sample.txt");
            //�Է� ��Ʈ�� ����
            FileReader filereader = new FileReader(file);
            //�Է� ���� ����
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String line = "";
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            //.readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.            
            br.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
 }
	
}
