package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;

public interface MemberDAO {

	MemberVO selectMemberById(SqlSession session, String id) throws SQLException;

	// 회원리스트 조회
	List<MemberVO> selectMemberList(SqlSession session) throws SQLException;
	List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws SQLException;
	List<MemberVO> selectMemberList(SqlSession session, SearchCriteria cri) throws SQLException;
	
	// 검색 결과의 전체 리스트 개수
	int selectMemberListCount(SqlSession session, SearchCriteria cri) throws SQLException;
	
	// 회원 추가
	public void insertMember(SqlSession session, MemberVO member) throws SQLException;
	
	// 회원 수정
	public void modifyMember(SqlSession session, MemberVO member) throws SQLException;
	
	// 회원 삭제
	void deleteMember(SqlSession session, String id) throws SQLException;
	
	// 회원 정지
	void disabledMember(SqlSession session, String id) throws SQLException;
	
	// 회원 활성화
	void enabledMember(SqlSession session, String id) throws SQLException;
	
}
