package java0718;

public class HomeAppliancies {
	private int serialNo;
	private String manufacturer;
	private int year;
	
	class Washer {//HomeAppliancies 클래스의 멤버 클래스
		public void turnOn() {System.out.println("기본 워셔 작동");}
		public void turnOff() {System.out.println("기본 워셔 종료");}
	}
	class DishWasher{//HomeAppliancies class의 멤버 클래스
		public void turnOn() {System.out.println("접시 워셔 작동");}
		public void turnOff() {System.out.println("접시 워셔 종료");}
	}


}