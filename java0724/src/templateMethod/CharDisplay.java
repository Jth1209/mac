package templateMethod;

public class CharDisplay extends Struct{
	private char c;
	
	public CharDisplay(char c) {
		this.c = c;
	}
	@Override
	public void Open() {
		System.out.print("<< ");
	}

	@Override
	public void Print() {
		System.out.print(c);
	}

	@Override
	public void Close() {
		System.out.println(" >>");
	}

}
