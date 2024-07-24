package group;

import java.util.Iterator;

public class StudentGroupIterator implements Iterator<Student>{
	
	private StudentGroup studentg;
	private int index;
	
	
	public StudentGroupIterator(StudentGroup studentg) {
		super();
		this.studentg = studentg;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if(index < studentg.studentNum()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Student next() {
		Student student = studentg.getStudent(index);
		index++;
		return student;
	}

}
