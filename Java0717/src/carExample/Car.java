package carExample;

public class Car {
	Tire fLtire = new Tire(6,"front,left");
	Tire fRtire = new Tire(2,"front,right");
	Tire bLtire = new Tire(3,"back,left");
	Tire bRtire = new Tire(4,"back,right");
	
	public CarEnum run() {
		System.out.println("[car is started]");
		if(fLtire.roll() == false) {stop();return CarEnum.fLtire;}
		if(fRtire.roll() == false) {stop();return CarEnum.fRtire;}
		if(bLtire.roll() == false) {stop();return CarEnum.bLtire;}
		if(bRtire.roll() == false) {stop();return CarEnum.bRtire;}
		return CarEnum.Empty;
	}
	void stop() {
		System.out.println("[car is stopped]");
	}
}
