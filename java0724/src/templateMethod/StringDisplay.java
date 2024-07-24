package templateMethod;

public class StringDisplay extends Struct{
	private String string;
	private int width;
	
	public StringDisplay(String str) {
		this.string = str;
		this.width = str.length();
	}
	public void printLine() {
		System.out.print("+");
		for(int i = 0; i<width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
	@Override
	public void Open() {
		printLine();
	}

	@Override
	public void Print() {
		System.out.println(string);
	}

	@Override
	public void Close() {
		printLine();
	}

}
