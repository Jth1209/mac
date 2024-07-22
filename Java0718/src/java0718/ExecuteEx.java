package java0718;

public class ExecuteEx {

	public static void main(String[] args) {
		HomeAppliancies ha = new HomeAppliancies();
		HomeAppliancies.Washer washer = ha.new Washer();
		HomeAppliancies.DishWasher dwasher = ha.new DishWasher();//인스턴스 객체이기 떄문에 외부 객체를 이용해서만 내부 객체를 만들 수 있따.
		washer.turnOn();
		washer.turnOff();
		dwasher.turnOn();
		dwasher.turnOff();
	}

}
