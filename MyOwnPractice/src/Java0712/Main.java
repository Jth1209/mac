package Java0712;

public class Main {
	public static void main(String[] args) {
		Student minsu = new Student("민수");
	    Student gildong = new Student("길동");
		Course java = new Course("JAVA");
		Course cplus = new Course("cplus");
		
		Transcript t1 = new Transcript(java,minsu,"202407","A");
		Transcript t2 = new Transcript(cplus,minsu,"202407","A+");
		Transcript t3 = new Transcript(java,gildong,"202407","B+");
		
		minsu.addTranscript(t1);
		minsu.addTranscript(t2);
		gildong.addTranscript(t3);
		
		java.addTranscript(t1);
		cplus.addTranscript(t2);
		java.addTranscript(t3);
		
		System.out.println(minsu);
		System.out.println(gildong);
		System.out.println(java);
		System.out.println(cplus);
	}
}
