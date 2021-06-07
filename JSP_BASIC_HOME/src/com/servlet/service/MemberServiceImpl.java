package com.servlet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.servlet.dao.MemberDAO;
import com.servlet.dao.MemberDAOImpl;
import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.mybatis.OracleMyBatisSqlSessionFactory;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	private SqlSessionFactory sqlSessionFactory = new OracleMyBatisSqlSessionFactory();
	
	public MemberServiceImpl() {
		memberDAO = MemberDAOImpl.getInstance();
	}

	@Override
	public MemberVO login(String userId, String userPw)
			throws NotFoundIDException, InvalidPasswordException, SQLException {

		SqlSession session = sqlSessionFactory.openSession();
		
		MemberVO member = null;
		try {
			member = memberDAO.selectMemberByID(session, userId);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if (member != null) {
			if (userPw.equals(member.getUserPw())) {
				return member;
			} else {
				throw new InvalidPasswordException();
			}
		} else {
			throw new NotFoundIDException();
		}
	}

	@Override
	public List<MemberVO> viewMembers() throws SQLException {
		List<MemberVO> member = new ArrayList<>();
		
		SqlSession session = sqlSessionFactory.openSession();

		member = memberDAO.viewMembers(session);

		session.close();
		return member;
	}

	@Override
	public int createMember(MemberVO memberVO) throws SQLException {

		SqlSession session = sqlSessionFactory.openSession();
		
		int cnt = 0;
		cnt = memberDAO.createMember(session, memberVO);
		
		session.close();
		return cnt;
	}

	@Override
	public List<MemberVO> detailMember(String userId) throws SQLException {
		List<MemberVO> member = new ArrayList<>();
		
		SqlSession session = sqlSessionFactory.openSession();

		member = memberDAO.detailMember(session, userId);
		session.close();
		return member;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws SQLException {

		SqlSession session = sqlSessionFactory.openSession();
		
		int cnt = 0;
		cnt = memberDAO.updateMember(session, memberVO);
		
		session.close();
		return cnt;
	}

	@Override
	public int deleteMember(String userId) throws SQLException {

		SqlSession session = sqlSessionFactory.openSession();
		
		int cnt = 0;
		cnt = memberDAO.deleteMember(session, userId);
		
		session.close();
		return cnt;
	}
}