package group;

public class Student {
	private String name;
	private String hakbun;
	private int java;
	
	public Student(String name, String hakbun, int java) {
		super();
		this.name = name;
		this.hakbun = hakbun;
		this.java = java;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", hakbun=" + hakbun + ", java=" + java + "]";
	}
	
	
}
