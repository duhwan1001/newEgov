package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.servlet.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl memDao;

	private MemberDAOImpl() {

	}

	public static MemberDAOImpl getInstance() {
		if (memDao == null) {
			memDao = new MemberDAOImpl();
		}

		return memDao;
	}

	@Override
	public MemberVO selectMemberByID(SqlSession session, String userId) throws SQLException {

		return session.selectOne("user.viewMembers", userId);

	}

	@Override
	public List<MemberVO> viewMembers(SqlSession session) throws SQLException {

		return session.selectList("user.viewMembers");
	}

	@Override
	public int createMember(SqlSession session, MemberVO memberVO) throws SQLException {
		int obj = session.insert("user.createMember", memberVO);

		return obj;
	}

	@Override
	public List<MemberVO> detailMember(SqlSession session, String userId) throws SQLException {

		return session.selectList("user.detailMember", userId);
	}

	@Override
	public int updateMember(SqlSession session, MemberVO memberVO) throws SQLException {

		int obj = session.insert("user.updateMember", memberVO);

		return obj;
	}

	@Override
	public int deleteMember(SqlSession session, String userId) throws SQLException {

		int obj = session.delete("user.deleteMember", userId);

		return obj;
	}
}
