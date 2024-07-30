package java0730;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapEx {

	public static void main(String[] args) {
		Map<String,Integer> mm = new HashMap<>();
		mm.put("1번", 90);
		mm.put("2번", 30);
		mm.put("3번", 80);
		
		Set<String> ss = mm.keySet();//set을 사용하면 중복된 값이 알아서 사라짐
		List<String> al = new ArrayList<>(ss);//set<>은 ArrayList에 바로 대입할 수 있지만, 기본 배열은 Arrays.asList()를 이용해서 대입해야 한다.
		Set<Map.Entry<String, Integer>> mess = mm.entrySet();//Map.Entry<> 선언 방식
		
		ss.stream().forEach(s->{
			int ret = mm.get(s);
			System.out.println(ret);
		});
		
		for(String str : ss) {
			int ret = mm.get(str);
			System.out.println(ret);
		}
	}

}
