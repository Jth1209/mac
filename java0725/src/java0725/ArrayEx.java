package java0725;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayEx {

	public static void main(String[] args) {
		Student[] students = {
				new Student("홍길동",90),
				new Student("임길동",70),
				new Student("주길동",60),
				new Student("양길동",100),
				new Student("천길동",80),
		};
		
		Comparator<Student> c = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return Integer.compare(o1.getScore(), o2.getScore());
			}
		};
		
		Arrays.sort(students,c);//배열은 Arrays
		for(Student st : students) {
			System.out.println(st);
		}
	}

}
