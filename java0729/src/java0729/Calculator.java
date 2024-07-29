package java0729;

public class Calculator {
	private int num;

	public int getNum() {
		return num;
	}

	public synchronized void setNum(int num) {
		this.num = num;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.num);
	}
	
	
}
