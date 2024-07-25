package java0725;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

	public static void main(String[] args) {
		Map<Key,String> map = new HashMap<>();
		
		map.put(new Key(10), "luckybicky");
		map.put(new Key(10), "luckybicky");
		String str1 = map.get(new Key(10));
		String str2 = map.get(new Key(10));
		
		if(str1.equals(str2)) {
			System.out.println("correct");
		}else {
			System.out.println("incorrect");
		}
		
	}

}
