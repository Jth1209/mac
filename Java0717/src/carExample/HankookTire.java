package carExample;

public class HankookTire extends Tire{
	
	
	public HankookTire(int maxRotate, String location) {
		super(maxRotate, location);
		// TODO Auto-generated constructor stub
	}

	public boolean roll() {
		++accumulatedRotated;
		if(accumulatedRotated < maxRotate) {
			System.out.println(location +" 남은 횟수: "+(maxRotate-accumulatedRotated));
			return true;
		}else {
			System.out.println(location+ " HanKooKTire punked!");
			return false;
		}
	}

}
