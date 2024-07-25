package group;

import java.util.Iterator;

public class StudentGroup implements Iterable<Student>{
	
	private Student[] students;
	private int last;
	@Override
	public Iterator<Student> iterator() {
		return new StudentGroupIterator(this);
	}
	public StudentGroup(int maxindex) {
		this.students = new Student[maxindex];
		this.last = 0;
	}
	public Student getStudent(int num) {
		Student st = students[num];
		return st;
	}
	
	public void getInfo(Student stu) {
		students[last] = stu;
		last++;
	}
	public int studentNum() {
		return last;
	}

}
