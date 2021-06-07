package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.servlet.dto.MemberVO;

public interface MemberDAO {

	MemberVO selectMemberByID(SqlSession session, String userId) throws SQLException;

	List<MemberVO> viewMembers(SqlSession session) throws SQLException;

	int createMember(SqlSession session, MemberVO memberVO) throws SQLException;

	List<MemberVO> detailMember(SqlSession session, String userId) throws SQLException;

	int updateMember(SqlSession session, MemberVO memberVO) throws SQLException;

	int deleteMember(SqlSession session, String userId) throws SQLException;

}
