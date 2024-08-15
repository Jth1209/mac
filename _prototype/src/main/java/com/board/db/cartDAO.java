package com.board.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class cartDAO {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public cartDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public List<cartpDTO> showCart(){
		return session.selectList("Cart.showCart");
	}
	
	public void plusQuantity(int id) {
		session.update("Cart.plusQuantity",id);
	}
	
	public void minusQuantity(int id) {
		session.update("Cart.minusQuantity",id);
	}
	
	public int check(int id) {
		return session.selectOne("Cart.check",id);
	}
	
	public void insertCart(int id) {
		session.insert("Cart.insertCart",id);
	}
	
	public void deleteCart(int id) {
		session.delete("Cart.deleteCart",id);
	}
	
	public int selectStock(int id) {
		return session.selectOne("Cart.selectStock",id);
	}
	
	public int selectQuantity(int id) {
		return session.selectOne("Cart.selectQuantity",id);
	}
	
	public void deleteAll() {
		session.delete("Cart.deleteAll");
	}
}