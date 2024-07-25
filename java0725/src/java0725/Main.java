package java0725;

public class Main {

	public static void main(String[] args) {
		Equals eq1 = new Equals("kimmo");
		Equals eq2 = new Equals("kimmo");
		System.out.println(eq1.hashCode());
		System.out.println(eq2.hashCode());//두 객체는 hashCode가 같기 때문에 동일객체로 처리된다.
		if(eq1.equals(eq2)) {
			System.out.println("correct");
		}else {
			System.out.println("incorrect");
		}
	}

}
