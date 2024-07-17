package carExample;

public class KumhoTire extends Tire{
	
	
	public KumhoTire(int maxRotate, String location) {
		super(maxRotate, location);
		// TODO Auto-generated constructor stub
	}

	public boolean roll() {
		++accumulatedRotated;
		if(accumulatedRotated < maxRotate) {
			System.out.println(location +"남은 횟수: "+(maxRotate-accumulatedRotated));
			return true;
		}else {
			System.out.println(location+ "kumHoTire punked!");
			return false;
		}
	}

}
