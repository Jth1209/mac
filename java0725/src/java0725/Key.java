package java0725;

import java.util.Objects;

public class Key {
	int number;

	public Key(int number) {
		super();
		this.number = number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key key = (Key) obj;
			if(number == key.number ) {
				return true;
			}
		}
		return false;
	}
	
	
}
