package java0729;

public class ThreadEx1 {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		User1 u1 = new User1();
		u1.setCalculator(c);
		u1.start();
		
		User2 u2 = new User2();
		u2.setCalculator(c);
		u2.start();
	}
}
