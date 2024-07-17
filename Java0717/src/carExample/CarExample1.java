package carExample;

public class CarExample1 {

	public static void main(String[] args) {
		Car car = new Car();
		for(int i =0; i<=5; i++) {
			CarEnum ce = car.run();
			
		switch(ce) {
		case fLtire: 
			System.out.println("change front-left");
			car.fLtire = new HankookTire(15,"front-left");
			break;
		case fRtire: 
			System.out.println("change front-right");
			car.fRtire = new KumhoTire(10,"front-right");
			break;
		case bLtire: 
			System.out.println("change back-left");
			car.bLtire = new HankookTire(14,"back-left");
			break;
		case bRtire: 
			System.out.println("change back-right");
			car.bRtire = new KumhoTire(12,"back-right");
			break;
		}
		System.out.println("--------------------------");
		}
	}
	
}
