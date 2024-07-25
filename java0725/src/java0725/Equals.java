package java0725;

import java.util.Objects;

public class Equals {
	String id;

	public Equals(String id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Equals) {
			Equals eq = (Equals) obj;
			if(id.equals(eq.id)) {
				return true;
			}
		}
		return false;
	}
	
	
}
