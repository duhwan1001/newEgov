package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.MenuDAO;
import kr.or.ddit.dao.MenuDAOImpl;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.dto.MenuVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;// = new MenuDAOImpl();

	public void setMenuDao(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	private SqlSessionFactory sqlSessionFactory; // = new OracleMyBatisSqlSessionFactory();

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<MenuVO> getMainMenuList() throws SQLException {
		
		List<MenuVO> menuList = null;
		SqlSession session = sqlSessionFactory.openSession(false);
		// autocommit 비활성화

		try {
			menuList = menuDAO.selectMainMenu(session);
			session.commit();
		} catch (SQLException e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return menuList;

		// transaction을 보여주기 위함. mybatis는 같은 세션에 한해서 자동으로 롤백 시켜준다.
	}

	@Override
	public List<MenuVO> getSubMenuList(String mCode) throws SQLException {
		
		List<MenuVO> subMenuList = null;
		SqlSession session = sqlSessionFactory.openSession(false);
		//false = Not autoCommit

		subMenuList = menuDAO.selectSubMenu(session, mCode);
		
		session.close();
		
		return subMenuList;
	}

	@Override
	public MenuVO getMenuByMcode(String mCode) throws SQLException {
		
		MenuVO menuVO = new MenuVO();
		SqlSession session = sqlSessionFactory.openSession(false);
		
		menuVO = menuDAO.selectSubMenuByMcode(session, mCode);
		
		session.close();
		
		return menuVO;
	}

	@Override
	public MenuVO getMenuByMname(String mName) throws SQLException {
		MenuVO menuVO = new MenuVO();
		SqlSession session = sqlSessionFactory.openSession();
		
		menuVO = menuDAO.selectMenuByMname(session, mName);
		
		session.close();
		
		return menuVO;
	}



}
