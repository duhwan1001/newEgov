package com.servlet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dao.MemberDAO;
import com.servlet.dao.MemberDAOImpl;
import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

import util.SqlMapClientUtil;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	private SqlMapClient smc;

	public MemberServiceImpl() {
		smc = SqlMapClientUtil.getInstance();
		memberDAO = MemberDAOImpl.getInstance();
	}

	@Override
	public MemberVO login(String userId, String userPw)
			throws NotFoundIDException, InvalidPasswordException, SQLException {

		MemberVO member = null;
		try {
			member = memberDAO.selectMemberByID(smc, userId);

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

		member = memberDAO.viewMembers(smc);

		return member;
	}

	@Override
	public int createMember(MemberVO memberVO) throws SQLException {

		int cnt = 0;
		cnt = memberDAO.createMember(smc, memberVO);
		return cnt;
	}

	@Override
	public List<MemberVO> detailMember(String userId) throws SQLException {
		List<MemberVO> member = new ArrayList<>();

		member = memberDAO.detailMember(smc, userId);

		return member;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws SQLException {

		int cnt = 0;
		cnt = memberDAO.updateMember(smc, memberVO);
		return cnt;
	}

	@Override
	public int deleteMember(String userId) throws SQLException {
		// TODO Auto-generated method stub
		int cnt = 0;
		cnt = memberDAO.deleteMember(smc, userId);
		return cnt;
	}
}