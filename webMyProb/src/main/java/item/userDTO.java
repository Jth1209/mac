package item;

public class userDTO {
	private String iname;
	private int num;
	
	public userDTO(String iname, int num) {
		super();
		this.iname = iname;
		this.num = num;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "userDTO [iname=" + iname + ", num=" + num + "]";
	}
	
	
}


