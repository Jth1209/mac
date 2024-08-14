package Login;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class LoginDAO {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public LoginDAO() {
		session = sqlsession_f.openSession(true);
	}
	
	public int searchUser(LoginDTO dto) {
		return session.selectOne("Member.searchUser",dto);
	}
	
	public LoginDTO searchUser2(String id) {
		return session.selectOne("Member.searchUser2",id);
	}
	
	public void insertMember(LoginDTO dto) {
		session.selectOne("Member.insertMember",dto);
	}
	
	public void updateInfo(LoginDTO dto) {
		session.selectOne("Member.updateInto",dto);
	}
	
}
