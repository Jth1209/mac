package practice;

public class A {

	class B{}
	
	static class C{}//정적 클래스 C선언
	
	B field1= new B();
	C field2 = new C();
	
	void method1() {
		B val1 = new B();
		C val2 = new C();
	}
	
//	static B field3 = new B(); static 접근제한자를 사용한 클래스,매개변수등은 static을 사용한 클래스끼리, 필드끼리만 사용이 가능하다.
	static C field4 = new C();
	
	static void method2() {
//		B var1 = new B(); static으로 선언한 모든 클래스와 객체는 한 공간에 선언된다. 외부에서 접근할 수 없기 때문에 기본 접근제한자로 선언한 변수, 클래스가 static 메소드에 접근할 수 없다.
		C var2 = new C();
	}
}
