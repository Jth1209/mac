package com.board.service;

import java.util.List;

import com.board.db.cartDAO;
import com.board.db.cartpDTO;

public class CartService {
	public List<cartpDTO> showCart() {
		cartDAO dao = new cartDAO();
		List<cartpDTO> dto = dao.showCart();
		return dto;
	}
	
	public void insertCart(int id) {
		cartDAO dao = new cartDAO();
		dao.insertCart(id);
	}
}
