package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;

public interface MemberDAO {

	MemberVO selectMemberByID(SqlMapClient smc, String userId) throws SQLException;

	List<MemberVO> viewMembers(SqlMapClient smc) throws SQLException;

	int createMember(SqlMapClient smc, MemberVO memberVO) throws SQLException;

	List<MemberVO> detailMember(SqlMapClient smc, String userId) throws SQLException;

	int updateMember(SqlMapClient smc, MemberVO memberVO) throws SQLException;

	int deleteMember(SqlMapClient smc, String userId) throws SQLException;

}
