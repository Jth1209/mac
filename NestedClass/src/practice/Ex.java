package practice;

public class Ex {

	public static void main(String[] args) {
		A a = new A();
		
		A.C c = new A.C();//C는 스태택 클래스
		
		A.B b = a.new B();//B는 인스턴스 클래스
		
		A.method2();//스태틱 
		
		A.C.field5 = 4;// static 이라 이렇게 사용할 수 있음
	}

}
