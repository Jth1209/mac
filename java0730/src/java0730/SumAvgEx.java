package java0730;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class SumAvgEx {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("kim",90));
		list.add(new Student("gim",98));
		list.add(new Student("lim",89));
		list.add(new Student("jun",68));
		
		int sum = list.stream().mapToInt(s->s.getNum()).sum();
		System.out.println(sum);
		OptionalDouble avg = list.stream().mapToDouble(s->s.getNum()).average();
		avg.ifPresent(ag->System.out.println(ag));//OptionalDouble 형의 변수에 값이 있으면 () 내부의 동작을 수행해준다.
	}
}
