package java0801;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadEx {

	public static void main(String[] args) throws IOException {
		Reader read = new FileReader("/Users/taehojang/file/text1.txt");
		String line = "";
		BufferedReader br = new BufferedReader(read);//****************
		while((line = br.readLine()) != null) {//***************
			System.out.println(line);
		}
		read.close();
	}

}
