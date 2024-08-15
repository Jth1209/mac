package com.board.db;

public class cartpDTO {
	private int id;
	private int product_id;
	private String name;
	private String description;
	private int price;
	private int stock;
	private int quantity;
	
	public cartpDTO(int id, int product_id, String name, String description, int price, int stock, int quantity) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "cartpDTO [id=" + id + ", product_id=" + product_id + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", stock=" + stock + ", quantity=" + quantity + "]";
	}

	
}
