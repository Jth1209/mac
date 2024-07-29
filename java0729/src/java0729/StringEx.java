package java0729;

public class StringEx {

	static class Aa{
		String set;
		
		public Aa(String set) {
			this.set = set;		}

		@Override
		public String toString() {
			return "Aa [set=" + set + "]";
		}
		
		
	}
	public static void main(String[] args) {
		Aa a = new Aa("테스트입니다");
		System.out.println(a);
	}

}
