package Java0712;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileOut {

	public static void main(String[] args) {
		Member[] list = {
				new Member("김하나","911224","010-1234-5678"),
				new Member("강하나","891224","010-1234-5678"),
				new Member("김하나","901224","010-1234-5678")
		};
		
	    try (FileOutputStream fos = new FileOutputStream("/users/taehojang/temp/members.dat");
	    		ObjectOutputStream oos = new ObjectOutputStream(fos)){
	    	
	    	oos.writeObject(list);
	    	System.out.println("객체를 파일에 저장했습니다.");
	    	
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	}

}
