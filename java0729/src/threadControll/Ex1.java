package threadControll;

public class Ex1 {

	public static void main(String[] args) {
		Thread th = new ThreadEx1();
		th.start();
		
		try {
			Thread.sleep(1000);//메인 스레드에서는 스레드의 실행을 얼마나 유지할지에 관한 try-catch문을 작성하면 된다.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th.interrupt();
	}

}
