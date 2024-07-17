package singtone;

public class Singleton {
	private Singleton() {}// 해당 클래스의 생서자를 지역변수화 한다.(외부에서 생성자를 통해 객체생성하는것을 막기 위한 방법
	
	private static Singleton singleton = new Singleton();//클래스 내에서 스스로를 객체 선언 하는데, 이떄 접근 제한자는 private static형이다.
	
	public Singleton getinstance() {//외부에서 유일하게 객체를 생성할 수 있는 메소드는 puvlic형으로 선언한다
		return this.singleton;
	}
}
