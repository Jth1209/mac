package java0801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ChangeEx {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("/Users/taehojang/file/text1.txt");
		Reader read = new InputStreamReader(fin);
		
		String str = "";	
		BufferedReader br = new BufferedReader(read);//한 줄을 뭉텅이로 받아서 일렬로 정렬함.
		while((str = br.readLine()) != null) {
			String[] st = str.split(",");//split()에서 괄호 내부의 기호로 문자열을 나눔
			System.out.println(st.length);//잘라진 한 행의 문자의 개수를 출력
			for(String d : st) {
				System.out.println(d);//문자 하나하나를 출력
			}
			System.out.println("----");//분기점 표시
		}
		read.close();
		fin.close();
	}

}
