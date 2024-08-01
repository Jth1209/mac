package java0731;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileEx {

	public static void main(String[] args) throws IOException {
//		File dir = new File("/Users/taehojang/file");
//		if(dir.exists() == false) {dir.mkdir();}
//		
//		Writer writer = new FileWriter("/Users/taehojang/file/text.txt");
//		writer.write("테스트입니다");
//		writer.flush();
//		writer.close();
		Reader reader = new FileReader("/Users/taehojang/file/text.txt");
		char[] buf = new char[6];
		int readerNum = reader.read(buf);
		if(readerNum != -1) {
			for(char ch : buf) {
				System.out.print(ch);
			}
			System.out.println();
		}
		reader.close();
	}

}
