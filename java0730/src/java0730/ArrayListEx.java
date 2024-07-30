package java0730;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("kim",90));
		list.add(new Student("gim",80));
		list.add(new Student("lim",70));
		
		Collections.sort(list,(Student s1,Student s2) -> Integer.compare(s2.getNum(),s1.getNum()));
		
		list.stream().forEach(a->{
			System.out.println(a);
		});
	}

}
