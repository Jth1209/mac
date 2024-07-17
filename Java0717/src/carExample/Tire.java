package carExample;

public class Tire {
	public int maxRotate;
	public int accumulatedRotated;
	public String location;
	
	
	public Tire(int maxRotate, String location) {
//		super();
		this.maxRotate = maxRotate;
		this.location = location;
	}


	public boolean roll() {
		++accumulatedRotated;
		if(accumulatedRotated < maxRotate) {
			System.out.println(location +"남은 횟수: "+(maxRotate-accumulatedRotated));
			return true;
		}else {
			System.out.println(location+ "Tire punked!");
			return false;
		}
	}
}
