package item;

public class itemDTO {
	private String iname;
	private int price;
	
	public itemDTO(String iname, int price) {
		super();
		this.iname = iname;
		this.price = price;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "itemDTO [iname=" + iname + ", price=" + price + "]";
	}
	
	
}
