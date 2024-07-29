package threadControll;

public class ThreadEx1 extends Thread{
	int i = 0;
	public void run() {
			while(true) {
				i++;
				System.out.println(i);
				if(Thread.interrupted()){//	얼마에 한번 반복해서 실행할 것인지를 결정
					break;
				}
			}
		System.out.println("종료");
	}
}
