package com.board.db;

import java.sql.*;
import java.time.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDao {
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public BoardDao() {
		//SqlSessionFactory에서 session을 할당받는다.
		//이 때 openSession에 true를 주어야 자동 커밋이 된다.
		//default는 false이다.
		session = sqlsession_f.openSession(true);
	}

    // 게시글 갯수 얻기
    public int getNumRecords() {
        return session.selectOne("Board.count");
    }

    // 게시글 리스트 읽기
    public List<BoardpDto> selectList(int num) {
    	return session.selectList("Board.selectPage",num);
    }

    // 지정된 글 번호를 가진 레코드 읽기
    // hitsIncreased가 true이면 해당 글의 조회수를 1 증가시킴
    //                 false이면 조회수를 증가시키지 않음
    public BoardDto selectOne(int num) {
    	return session.selectOne("Board.selectOne",num);
    }
    
    public void updateHits(int num) {
    	session.update("Board.updateHits",num);
    }

    // DTO에 담긴 내용으로 새로운 레코드 저장
    public void insertOne(BoardDto dto) {
    	session.insert("Board.insertBoard",dto);
    }

    // DTO에 담긴 내용으로 게시글 데이터 업데이트
    public void updateOne(BoardDto dto) {
    	session.update("Board.updateBoard",dto);
    }

    // 지정된 글 번호의 레코드 삭제
    public void deleteOne(int num) {
    	session.delete("Board.deleteBoard",num);
    }
}