package com.board.db;

public class cartDTO {
	private int id;
	private int product_id;
	private int quantity;
	
	public cartDTO(int id, int product_id, int quantity) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "cartDTO [id=" + id + ", product_id=" + product_id + ", quantity=" + quantity + "]";
	}
	
	
}
