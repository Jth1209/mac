package java0725;

class MyClass{
	public void method() throws MyException{//예외 떠넘기기 메소드를 실행하면 무조건 오류가 발생함. 해당 메소드 사용시점에서 JVM에게 떠넘기거나 try-catch문을 작성해야 한다.
		throw new MyException("내가 설정한 오류~~");
	}
}

public class MyExceptionEx {

	public static void main(String[] args) {
		MyClass mc = new MyClass();
		try {
			mc.method();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
