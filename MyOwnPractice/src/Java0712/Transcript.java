package Java0712;

public class Transcript {

	private Course course;
	private Student student;
	private String data;
	private String grade;
	
	
//	@Override
//	public String toString() {
//		return "Transcript [course=" + course + ", student=" + student + ", data=" + data + ", grade=" + grade + "]";
//	}메인 코드에서 출력할 클래스가 아니라면 절대 toStirng() 쓰지 말길. 이것때문에 오류남

	public Transcript(Course course,Student student,String data, String grade) {
		this.course = course;
		this.student = student;
		this.data = data;
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	
}
