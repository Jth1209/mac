package group;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		StudentGroup stg = new StudentGroup(3);
		stg.getInfo(new Student("김하나","1906001",90));
		stg.getInfo(new Student("최하나","1906002",96));
		stg.getInfo(new Student("이하나","1906003",98));
		
		Iterator<Student> it = stg.iterator();
		while(it.hasNext()) {
			Student st = it.next();
			System.out.println(st);
		}
		System.out.println();
		for(Student st : stg) {
			System.out.println(st);
		}
	}

}
