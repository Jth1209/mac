package adapter;

public class Seed {
	private String string;
	
	Seed(String str){
		this.string = str;
	}
	public void printAsta() {
		System.out.println("*" + string + "*");
	}
	public void printtitle() {
		System.out.println("<" + string + ">");
	}
}
