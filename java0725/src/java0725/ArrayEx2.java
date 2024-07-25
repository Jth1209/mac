package java0725;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

public class ArrayEx2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("홍길동",90));
		list.add(new Student("김길동",96));
		list.add(new Student("정길동",99));
		list.add(new Student("천길동",95));
		list.add(new Student("백길동",91));
		
		Comparator<Student> c = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return Integer.compare(o2.getScore(), o1.getScore());
			}
		};
		
		Collections.sort(list,c);//ArrayList일 때 sort해주는 것을 Collections로 작성해야 한다.
		
		System.out.println(list);
	}

}
