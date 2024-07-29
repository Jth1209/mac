package threadControll;

public class ThreadEx1 extends Thread{
	int i = 0;
	public void run() {
		try {
			while(true) {
				i++;
				System.out.println(i);
				Thread.sleep(10);//	얼마에 한번 반복해서 실행할 것인지를 결정
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("종료");
	}
}
