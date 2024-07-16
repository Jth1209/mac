package Java0712;

import java.util.Vector;

public class Student {
    private Vector<Transcript> transcript;
	private String name;
	
	@Override
	public String toString() {
		return "Student [transcript=" + transcript + ", name=" + name + "]";
	}

	public Student(String name) {
		this.name = name;
		this.transcript = new Vector<>();
	}
	
	public void addTranscript(Transcript trans) {
		transcript.add(trans);
	}

	public Vector<Transcript> getTranscript() {
		return transcript;
	}

	public void setTranscript(Vector<Transcript> transcript) {
		this.transcript = transcript;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
