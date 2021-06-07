package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
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
	public MemberVO selectMemberByID(SqlMapClient smc, String userId) throws SQLException {

		return (MemberVO) smc.queryForObject("user.confirmId", userId);

	}

	@Override
	public List<MemberVO> viewMembers(SqlMapClient smc) throws SQLException {

		return (List<MemberVO>) smc.queryForList("user.viewMembers");
	}

	@Override
	public int createMember(SqlMapClient smc, MemberVO memberVO) throws SQLException {
		Object obj = smc.insert("user.createMember", memberVO);
		int cnt = 0;
		if (obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<MemberVO> detailMember(SqlMapClient smc, String userId) throws SQLException {

		return (List<MemberVO>) smc.queryForList("user.detailMember", userId);
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO memberVO) throws SQLException {
		
		Object obj = smc.insert("user.updateMember", memberVO);
		int cnt = 0;
		if (obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteMember(SqlMapClient smc, String userId) throws SQLException {
		
		Object obj = smc.insert("user.deleteMember", userId);
		int cnt = 0;
		if (obj == null) {
			cnt = 1;
		}
		return cnt;
	}
}
