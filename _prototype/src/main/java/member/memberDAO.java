package member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class memberDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public memberDAO() {
		//SqlSessionFactory에서 session을 할당받는다.
		//이 때 openSession에 true를 주어야 자동 커밋이 된다.
		//default는 false이다.
		session = sqlsession_f.openSession(true);
	}
	public int checkUser(memberDTO dto) {
		return session.selectOne("Member.checkUser",dto);
	}
	
	public memberDTO selectOne(String id) {
		return session.selectOne("Member.selectOne",id);
	}
	
	public void insertUser(memberDTO dto) {
		session.insert("Member.insertUser",dto);
	}
	
	public void updateUser(memberDTO dto) {
		session.update("Member.updateUser",dto);
	}
	
	public void deleteUser(String id) {
		session.delete("Member.deleteUser",id);
	}
}
