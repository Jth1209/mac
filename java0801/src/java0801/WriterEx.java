package java0801;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterEx {

	public static void main(String[] args) throws IOException {
		Writer write = new FileWriter("/Users/taehojang/file/text1.txt");
		
		String str = "abcABC";
		
		write.write(str);
		
		write.flush();
		write.close();
	}

}
