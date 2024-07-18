package java0718;

public class ExecuteEx {

	public static void main(String[] args) {
		HomeAppliancies ha = new HomeAppliancies();
		HomeAppliancies.Washer washer = ha.new Washer();
		HomeAppliancies.DishWasher dwasher = ha.new DishWasher();
		washer.turnOn();
		washer.turnOff();
		dwasher.turnOn();
		dwasher.turnOff();
	}

}
