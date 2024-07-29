package java0729;

public class Calculator {
	private int num;

	public int getNum() {
		return num;
	}

	public synchronized void setNum(int num) {//synchronized 사용 시 각각의 스레드의 동작이 마무리 된 후 다음 스레드의 작업을 실행 하도록 바뀜(비동기식 방법)
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
