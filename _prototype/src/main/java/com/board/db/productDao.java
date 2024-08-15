package com.board.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class productDao {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public productDao() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public List<productpDto> getAllProducts(int num) {//물품 목록 출력
		// session을 통해 쿼리를 실행하고 값을 받아온다.
		return session.selectList("Products.selectAll",num);
	}
	
	public int Count() {
		return session.selectOne("Products.count");
	}
	
	public productDto selectOne(int id) {
		return session.selectOne("Products.selectOne",id);
	}

	public void addProduct(productDto product) {
		session.insert("Products.insertProducts", product);
	}

	public void updateProduct(productDto product) {
		session.update("Products.updateProducts", product);
	}

	public void deleteProduct(int id) {
		session.delete("Products.deleteProducts", id);
	}
}