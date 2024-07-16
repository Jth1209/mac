package Java0716;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorEx {

	public static void main(String[] args) {
		Set<String> ex = new HashSet<>();
		
		ex.add("김길동");	
		ex.add("김길동");	
		ex.add("김길동");	
		ex.add("김길동");	//HashSet은 중복된 입력값을 받지 않음
		
//		ex.add("김길동");
//		ex.add("안길동");	
//		ex.add("준길동");	
//		ex.add("비길동");	//HashSet은 중복된 입력값을 받지 않음
		
	    Iterator<String> iterator = ex.iterator();
	    while(iterator.hasNext()) {//while문은 조건문이 true일 경우 계속 반복
	    	String name = iterator.next();
	    	System.out.println(name);
	    }
	}
}