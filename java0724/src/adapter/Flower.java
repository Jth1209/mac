package adapter;

public class Flower extends Seed implements Print{

	Flower(String str) {
		super(str);
	}

	@Override
	public void printWeak() {
		printAsta();
	}

	@Override
	public void printStrong() {
		printtitle();
	}

}
