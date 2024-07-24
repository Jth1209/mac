package templateMethod;

public abstract class Struct {
	public abstract void Open();
	public abstract void Print();
	public abstract void Close();
	
	public final void display() {
		Open();
		for(int i = 0; i < 5; i++) {
			Print();
		}
		Close();
	}
}
