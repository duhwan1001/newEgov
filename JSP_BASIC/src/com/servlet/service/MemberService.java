package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

public interface MemberService {

	MemberVO login(String userId, String userPw) throws NotFoundIDException, InvalidPasswordException, SQLException;

	List<MemberVO> viewMembers() throws SQLException;

	int createMember(MemberVO memberVO) throws SQLException;

	List<MemberVO> detailMember(String userId) throws SQLException;

	int updateMember(MemberVO memberVO) throws SQLException;

	int deleteMember(String userId) throws SQLException;
}
