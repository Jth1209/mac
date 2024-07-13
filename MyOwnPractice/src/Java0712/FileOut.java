package Java0712;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class FileOut {

	public static void main(String[] args) {
		LinkedList<Member> list = new LinkedList<>();
						
		
	    try (FileOutputStream fos = new FileOutputStream("/users/taehojang/temp/members.dat");
	    		ObjectOutputStream oos = new ObjectOutputStream(fos)){
	    	
	    	oos.writeObject(list);
	    	System.out.println("객체를 파일에 저장했습니다.");
	    	
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	}

}
