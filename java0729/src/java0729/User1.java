package java0729;

public class User1 extends Thread{
	private Calculator cal;
	
	public void setCalculator(Calculator cal) {
		this.cal = cal;
		this.setName("User1");
	}
	
	public void run() {
		cal.setNum(100);
	}
}
